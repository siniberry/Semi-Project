import java.util.Scanner;




   



public class DayDay
{
   public static void main(String[] args) 
   {

      int year;
      int month;
      int day;
      int selectNum1;
      int nowYear;
      int nowMonth;
      int nowDay;

      Scanner sc = new Scanner(System.in);

      CalenderPrint CP = new CalenderPrint();
      ChangeMonth CM = new ChangeMonth();
      DaySetting DS = new DaySetting();

      year = CP.inputYear();		//사용자로부터 입력받은 년도
      month =   CP.inputMonth();	//사용자로부터 입력받은 월
      CP.print(year, month);		// 연 월 받아서 달력출력

      nowYear = CP.nowy;			//현재의 년도
      nowMonth = CP.nowm;			//현재의 월
      nowDay = CP.nowd;				//현재의 일
      DS.getNowYear(nowYear);		//현재 년 불러오는 메소드
      DS.getNowMonth(nowMonth);		//현재 월 불러오는 메소드
      DS.getNowDay(nowDay);			//현재 일 불러오는 메소드

      DS.getYear(year);				//예매할 년도 불러오는 메소드(사용자에게 입력받은 년도)
      DS.getMonth(month);			//예매할 달 불러오는 메소드(사용자에게 입력받은 달)

      selectNum1 = CM.input();		//메뉴 1234중 선택한값 넘겨줌
      day = DS.input(selectNum1);	// 1234중 선택한 메뉴 실행 후 입력받은 날짜 반환
      
      /*
      do
      {
         selectNum1 = CM.input(); //메뉴 1234중 선택한값 넘겨줌
         day = DS.input(selectNum1); // 1234중 선택한 메뉴 실행 후 입력받은 날짜 반환
      }
      while (day!=100);
      */

      System.out.printf("%d년 %d월 %d일",DS.nyear,DS.nmonth,day);
   }

 }
   
