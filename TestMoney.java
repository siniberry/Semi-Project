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

	if(seatclass.equals("���ڳ��")){
		priceLevel = priceLevel;
	}
	else if(seatclass.equals("�����Ͻ�")){
		priceLevel = priceLevel * 2;
	}
	else if(seatclass.equals("�۽�Ʈ")){
		priceLevel = priceLevel * 3;
	}
	
	return priceLevel;
}

}

class Discount
{
  // ������ ������ ��� �����Ͽ� ���� ���� ������ return ���ִ� �޼ҵ�
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
		long calDateDays = (calDate / (24*60*60*1000))*-1; 				// ���� ��¥�κ��� ���� �����ϱ����� �� �� ���� = calDateDays
		calMonth = (int)calDateDays-180;								// calMonth >=0 : �󸮹��� �ñ� (6���� �̻�) 
	}
	catch (ParseException e)
	{
	}
	
	if (calMonth<0)		// �󸮹��� �̿��� �ñ� 
	{
		if (discount)	// �����ɾ߽ð�����
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
		System.out.print("�ݾ��� �����ϼ��� : ");
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
		{	//�Ž����� ��ȯ
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
			System.out.printf("�Ž������� �����ϴ�.%n");
			System.out.printf("�ܿ� ���ϸ��� : %d%n",mileage);
		}
		//
		else
		{

		System.out.printf("�Ž�����: 1. ���ݹ�ȯ 2. ���ϸ��� ���� : ");
		mileselect = sc.nextInt(); 
		
		if(mileselect == 1){
		int[] coin = {50000,10000,5000,1000};
		int leftcoin = 999;
		
		for(int i = 0; i< coin.length; i++)
			{
			if((submoney/coin[i])>0)
				{
			System.out.println(coin[i] + "��: " + submoney/coin[i]);
			submoney %= coin[i];}
			if(leftcoin >= submoney){
				leftcoin = submoney; 
				getmileage = submoney;
				mileage += getmileage;
			}
					
			}
		
			System.out.printf("���ϸ��� ���� : %d%n",getmileage);
		}
		else if(mileselect == 2){
	
			mileage += submoney;
			System.out.printf("���ϸ��� ���� : %d%n",submoney);

						}
			System.out.printf("�ܿ� ���ϸ��� : %d",mileage);
			System.out.println();
		
		}
	}


//���ϸ��� �����ϴ� �޼ҵ�
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
		int mileage;//���ǰ�
		int year = 2022;//���ǰ�
		int month = 2;//���ǰ�
		int day =17;//���ǰ�
		String time = "0630";//���ǰ�
		char food = 'O';//���ǰ�
		char lug ='O';//���ǰ�
		char cou = 'O';//���ǰ�
	

		String depart;
		String seatclass;
		System.out.print("�������� �༱���� �Է����ּ��� : ");
		depart = sc.next();
		System.out.print("�¼� ����� �Է����ּ���: ");
		seatclass = sc.next();
		price = sm.deMoney(depart);
		price = sm.levelMoney(seatclass, price);

		price = dis.discount(price , food, lug, cou, year, month, day, time);

		System.out.printf("�������� �༱�� : %s%n�¼� ��� : %s%n���� : %d%n",depart, seatclass, price);
		mileage = 100;
		money = mc.getMoney(price);
		mc.calMoney(price,money,mileage);	
		mileage = mc.mileageCal(price, money, mileage);


		

	}
}
