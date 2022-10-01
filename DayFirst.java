import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;



class CalenderPrint
	
	{	

		
		Calendar cal = new GregorianCalendar();
		Scanner sc = new Scanner(System.in);
		int y;
		int m;
		int w;

		int nowy = cal.get(Calendar.YEAR);		
		int nowm = cal.get(Calendar.MONTH)+1;	
		int nowd = cal.get(Calendar.DATE);
	

		int inputYear(){
	

		do
		{
			System.out.print("연도 입력 : ");
			y = sc.nextInt();
		}
		while (y < 1 || y<nowy); //오늘 이후만 가능하게하려고 연도 설정

		return y;
		
		}

		int inputMonth(){
		do
		{
			System.out.print("월   입력 : ");
			m = sc.nextInt();
		}
		while (1 > m || m > 12 || (y==nowy && m<nowm));//오늘 이후만 가능하게 월 설정

		return m;
		}

		void print(int year, int month){
		int w;		
		int i;


		cal.set(year, month-1, 1);
		w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println();
		System.out.println("\t[ " + year + "년 " + month + "월 ]\n");			// ' \t ' : tab
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");
		for (i=1; i<w; i++)
		{
			System.out.print("    ");	
			}


		for (i=1; i<=cal.getActualMaximum(Calendar.DATE); i++)	
		{
			System.out.printf("%4d", i);
			w++;				

			if (w%7==1)
			{
				System.out.println();		
			}
		}
		
		if (w%7!=1)					
		{
					System.out.println();
		}
		System.out.println("============================");
		}


}

class ChangeMonth{
	Scanner sc = new Scanner(System.in);
		
	int input(){

	int selectNum;
		
	do{

		System.out.println("1. 날짜 선택");
		System.out.println("2. 이전 달 보기");
		System.out.println("3. 다음 달 보기");
		System.out.println("4. 연도 선택으로 돌아가기");
		selectNum = sc.nextInt();		
		}
		while(selectNum>4 || selectNum<1);
		return selectNum;

}
}

public class DayFirst //처음 만든 파일이라 이름을 이렇게 지었어요... 클래스에 안넣고 본문에 했을때 실행된 파일입니당.. 
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);

		CalenderPrint CP = new CalenderPrint();
		ChangeMonth CM = new ChangeMonth();
	
		int year;
		int month;
		int day;
		int selectNum;//changemonht에서 받아온 1-4사이 숫자 넣을 변수

		
		year = CP.inputYear();
		month =	CP.inputMonth();
			CP.print(year, month);

		

		do{

		selectNum = CM.input();
		switch(selectNum){
		case 1 : System.out.printf("날짜 입력 (오늘 날짜 = %d년 %d월 %d일 ): ",CP.nowy,CP.nowm,CP.nowd);
			day= sc.nextInt();
			
			if(year == CP.nowy && month == CP.nowm && CP.nowd>=day){//실행일 기준 같은 년 월 선택했을시, 이전날짜 선택 못하게 하기위함.
			do
			{
				CP.print(year,month);
				 System.out.printf("오늘 이후 날짜 입력 (오늘 날짜 = %d년 %d월 %d일 ): ",CP.nowy,CP.nowm,CP.nowd);			
				 day= sc.nextInt();
			
			}while(day<=CP.nowd);
			break;	
			}
			else
			
			break;
				
		case 2 : //
		if( year==CP.nowy && CP.nowm == month){ //현시점 달 선택했을때 이전달 선택 못하게 함.
			CP.print(year, month);	
			System.out.println("현재달 이전달은 선택이 불가합니다. 다른 선택지를 호출하세요.");
			
			break;}
		
		else
		month -= 1;
		if(month<1) //1월에 전달 가려할때 작년 12월로 바꿔줌
			{
			month =12;
			year = year-1;
			}
		CP.print(year, month);
		
			break;

		case 3 : month = month + 1;
		if(month>12) //12월에 다음달 선택할때 내년 1월로 바꿔줌
			{
				month = 1;
				year +=1;
				}
		CP.print(year, month);
		break;
		case 4 : 			//다시 처음으로..
			year = CP.inputYear();
			month =	CP.inputMonth();			
			CP.print(year, month);
	
			break;
		
		
		}
		
		}while(selectNum !=1);

		}

	}
	

