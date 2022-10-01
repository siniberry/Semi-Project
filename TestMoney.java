import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class setMoney
{
int deMoney (String depart)
{
	int priceDepart = 1000;
	
	
	if(depart.equals("SJ"))
	{
		priceDepart = 120000;
	}
	else if(depart.equals("JS"))
	{
		priceDepart = 120000;
	}
	else if(depart.equals("SP"))
	{
		priceDepart = 100000;
	}
	else if (depart.equals("PS"))
	{
		priceDepart = 100000;
	}
	else if (depart.equals("PJ"))
	{
		priceDepart = 60000;
	}
	else if (depart.equals("JP"))
	{
		priceDepart = 60000;
	}


		return priceDepart;
}

int levelMoney(String seatclass, int price)
{
	int priceLevel = price;

	if(seatclass.equals("이코노미")){
		priceLevel = priceLevel;
	}
	else if(seatclass.equals("비지니스")){
		priceLevel = priceLevel * 2;
	}
	else if(seatclass.equals("퍼스트")){
		priceLevel = priceLevel * 3;
	}
	
	return priceLevel;
}

}

class Discount
{
  // 가용한 할인을 모두 적용하여 최종 결제 가격을 return 해주는 메소드
  int discount(int money, char food, char lug, char cou, int year, int month, int day, String time) 
  {
	int price;
	boolean discount = false;
	String dash = "-";

	double saleprice, calcprice;
	int fprice = 10000, lprice = 20000;			
	
	if (time.equals("0630") || time.equals("0830") || time.equals("1030") || time.equals("2230"))
	{
		discount = true;
	}
	else
		discount = false;
		
	int number1 = year;
	String str1 = Integer.toString(number1); 

	int number2 = month; 
	String str2 = Integer.toString(number2); 

	int number3 = day; 
	String str3 = Integer.toString(number3); 
		
	String date = str1 + dash + str2 + dash + str3;
		
	int calMonth = 0;
	int compare = 0;
	SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
	String today = df.format (System.currentTimeMillis());

	try
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = format.parse(today);
		Date lastDate = format.parse(date);
		long calDate = currentDate.getTime() - lastDate.getTime();
		long calDateDays = (calDate / (24*60*60*1000))*-1; 				// 현재 날짜로부터 선택 연월일까지의 일 수 차이 = calDateDays
		calMonth = (int)calDateDays-180;								// calMonth >=0 : 얼리버드 시기 (6개월 이상) 
	}
	catch (ParseException e)
	{
	}
	
	if (calMonth<0)		// 얼리버드 이외의 시기 
	{
		if (discount)	// 오전심야시간대라면
		{
			saleprice = money*0.1;
			calcprice = money-saleprice;				
			money = Integer.parseInt(String.valueOf(Math.round(calcprice)));
		}
		else
			money *= 1;
	}
	else
		money *= 1;

	if (food == 'O')
	{
		money += fprice;
	}
	else
		money *= 1;

	if (lug == 'O')
	{
		money += lprice;
	}
	else
		money *= 1;
	
	if (cou == 'O')							
	{
		saleprice = money*0.1;
		calcprice = money-saleprice;				
		price = Integer.parseInt(String.valueOf(Math.round(calcprice)));
	}
	else
		price = money;
	
	return price;
  }
}
class moneyCal
{

int getmileage;

int getMoney(int price)
{
		int money = 0;
		int inputm = 0;
		int submoney;
		int sum = 0;
		Scanner sc = new Scanner(System.in);

		
		do{
		System.out.print("금액을 투입하세요 : ");
		inputm = sc.nextInt();
		if(inputm<price)
			{
			sum += inputm;
			if(sum > price){
				return sum;
			}
			else if(sum>=price){
			sum = price;
			return sum;
			
			}
			}
		
		
		else if(inputm >= price)
		{	//거스름돈 반환
		sum = inputm;
		return inputm;
		}
		}while (sum<price);
	
		return sum;

}

	




void calMoney(int price, int getMoney, int mileage) 
	{	
		Scanner sc = new Scanner(System.in);
		int submoney;
		int mileselect;
		submoney = getMoney - price;
		if(getMoney == price)
		{
			System.out.printf("거스름돈이 없습니다.%n");
			System.out.printf("잔여 마일리지 : %d%n",mileage);
		}
		//
		else
		{

		System.out.printf("거스름돈: 1. 현금반환 2. 마일리지 적립 : ");
		mileselect = sc.nextInt(); 
		
		if(mileselect == 1){
		int[] coin = {50000,10000,5000,1000};
		int leftcoin = 999;
		
		for(int i = 0; i< coin.length; i++)
			{
			if((submoney/coin[i])>0)
				{
			System.out.println(coin[i] + "원: " + submoney/coin[i]);
			submoney %= coin[i];}
			if(leftcoin >= submoney){
				leftcoin = submoney; 
				getmileage = submoney;
				mileage += getmileage;
			}
					
			}
		
			System.out.printf("마일리지 적립 : %d%n",getmileage);
		}
		else if(mileselect == 2){
	
			mileage += submoney;
			System.out.printf("마일리지 적립 : %d%n",submoney);

						}
			System.out.printf("잔여 마일리지 : %d",mileage);
			System.out.println();
		
		}
	}


//마일리지 저장하는 메소드
int mileageCal(int price, int getMoney, int mileage){
		
		int submoney;
		submoney = getMoney - price;
		
		int leftcoin = 999;
		

			if((submoney/1000)>0)
				{
			submoney %= 1000;}
			if(leftcoin >= submoney){
				leftcoin = submoney; 
				getmileage = submoney;
				mileage += getmileage;					
			}
		return mileage;
}

}

public class TestMoney
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		setMoney sm = new setMoney();
		moneyCal mc = new moneyCal();
		Discount dis = new Discount();
	
		int price;
		int money;
		int mileage;//임의값
		int year = 2022;//임의값
		int month = 2;//임의값
		int day =17;//임의값
		String time = "0630";//임의값
		char food = 'O';//임의값
		char lug ='O';//임의값
		char cou = 'O';//임의값
	

		String depart;
		String seatclass;
		System.out.print("목적지와 행선지를 입력해주세요 : ");
		depart = sc.next();
		System.out.print("좌석 등급을 입력해주세요: ");
		seatclass = sc.next();
		price = sm.deMoney(depart);
		price = sm.levelMoney(seatclass, price);

		price = dis.discount(price , food, lug, cou, year, month, day, time);

		System.out.printf("목적지와 행선지 : %s%n좌석 등급 : %s%n가격 : %d%n",depart, seatclass, price);
		mileage = 100;
		money = mc.getMoney(price);
		mc.calMoney(price,money,mileage);	
		mileage = mc.mileageCal(price, money, mileage);


		

	}
}
