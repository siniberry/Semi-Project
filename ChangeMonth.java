import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;


class ChangeMonth{
   Scanner sc = new Scanner(System.in);
      
   int input()
   {

      int selectNum0;

      System.out.println("1. 날짜 선택");
      System.out.println("2. 이전 달 보기");
      System.out.println("3. 다음 달 보기");         
      do
      {
         selectNum0 = sc.nextInt();      
      }
      while(selectNum0>3 || selectNum0<1);

      return selectNum0;

   }
}

class DaySetting extends CalenderPrint //일 입력하는 클래스

{
      CalenderPrint CP = new CalenderPrint();
      ChangeMonth CM = new ChangeMonth();
	  int nyear;
	  int nmonth;


      Scanner sc = new Scanner(System.in);
      int year;
      int month;
      int day;
      int nowYear;
      int nowMonth;
      int nowDay;
	  
      
      boolean breakAlp = true;

      void getNowYear(int ny)
		{//현재 년 불러오는 메소드
         nowYear = ny;

      }
      void getNowMonth(int nm){//현재 월 불러오는 메소드
         nowMonth = nm;   
      }
      void getNowDay(int nd){//현재 일 불러오는 메소드
         nowDay = nd;
      }

      void getYear(int gy){//예매할 년도 불러오는 메소드
         year = gy;
      }

      void getMonth(int gm){//예매할 달 불러오는 메소드
         month = gm;
      }


      int input(int selectNum)
      {
		breakAlp = true;

         //아무래도 이곳에서 무한루프 오류가 나는 것 같습니다..ㅠㅠ
         while(breakAlp == true)
         //while(true)

         {
            switch(selectNum)
            {
               case 1 :
                  System.out.print("날짜 입력 ! ");
                  day= sc.nextInt();
                  
                  if(year == nowYear && month == nowMonth && nowDay>=day)
                  {
                     do
                     {
                        CP.print(year,month);
                         System.out.printf("오늘 이후 날짜 입력 (오늘 날짜 = %d년 %d월 %d일 ): ",nowYear,nowMonth,nowDay);         
                         day= sc.nextInt();
                     
                     }
                     while(day<=nowDay);
                     breakAlp = false;
                     break;   
                  }
                  else
                  {
                     breakAlp = false;
                     //return day;
                     break;                  
                  }

                     
                 case 2 : 
                  if( nowYear==year && nowMonth == month)
                  {
                     int selectNum1;
                     CP.print(year, month);   
                     System.out.println("현재달 이전달은 선택이 불가합니다. 다른 선택지를 호출하세요.");

                     selectNum = CM.input(); //메뉴 1234중 선택한값 넘겨줌
                     breakAlp = true;
                     //day = DS.input(selectNum1);
                     break;
                  }
                  else if( nowYear==year )
                  {
                     
                     month -= 1;
                     if (month <= 0)
                     {
                        month = 12;
                     }
                     
                     CP.print(year, month);
                     //monthfix = month-1;


                     selectNum = CM.input(); //메뉴 1234중 선택한값 넘겨줌
                     breakAlp = true;
                     
                     break;

                  }
                  else if (nowYear != year)
                  {
                     month -= 1;
                     if (month <= 0)
                     {
                        month = 12;
                        year = year-1;
                     }
 
                     CP.print(year, month);

                     selectNum = CM.input(); //메뉴 1234중 선택한값 넘겨줌
                     breakAlp = true;
               
                     break;

                  }


               case 3 : month = month + 1;
                  if(month>12)
                  {
                     month = 1;
                     year +=1;
                  }
                  CP.print(year, month);
                  selectNum = 1;

                  //monthfix = month-1;
                  //yearfix = year-1;
                  

                  selectNum = CM.input(); //메뉴 1234중 선택한값 넘겨줌
                  breakAlp = true;
                  //return day;
                  break;

               case 4 :          
                  year = CP.inputYear();
                  month =   CP.inputMonth();         
                  CP.print(year, month);
            
                  selectNum = CM.input(); //메뉴 1234중 선택한값 넘겨줌
                  breakAlp = true;
                  //return day;
                  break;
            

            
            
            }
            
            
         }

		nyear=year;
		nmonth=month;
        return day;
      }



}