import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;


class ChangeMonth{
   Scanner sc = new Scanner(System.in);
      
   int input()
   {

      int selectNum0;

      System.out.println("1. ��¥ ����");
      System.out.println("2. ���� �� ����");
      System.out.println("3. ���� �� ����");         
      do
      {
         selectNum0 = sc.nextInt();      
      }
      while(selectNum0>3 || selectNum0<1);

      return selectNum0;

   }
}

class DaySetting extends CalenderPrint //�� �Է��ϴ� Ŭ����

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
		{//���� �� �ҷ����� �޼ҵ�
         nowYear = ny;

      }
      void getNowMonth(int nm){//���� �� �ҷ����� �޼ҵ�
         nowMonth = nm;   
      }
      void getNowDay(int nd){//���� �� �ҷ����� �޼ҵ�
         nowDay = nd;
      }

      void getYear(int gy){//������ �⵵ �ҷ����� �޼ҵ�
         year = gy;
      }

      void getMonth(int gm){//������ �� �ҷ����� �޼ҵ�
         month = gm;
      }


      int input(int selectNum)
      {
		breakAlp = true;

         //�ƹ����� �̰����� ���ѷ��� ������ ���� �� �����ϴ�..�Ф�
         while(breakAlp == true)
         //while(true)

         {
            switch(selectNum)
            {
               case 1 :
                  System.out.print("��¥ �Է� ! ");
                  day= sc.nextInt();
                  
                  if(year == nowYear && month == nowMonth && nowDay>=day)
                  {
                     do
                     {
                        CP.print(year,month);
                         System.out.printf("���� ���� ��¥ �Է� (���� ��¥ = %d�� %d�� %d�� ): ",nowYear,nowMonth,nowDay);         
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
                     System.out.println("����� �������� ������ �Ұ��մϴ�. �ٸ� �������� ȣ���ϼ���.");

                     selectNum = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
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


                     selectNum = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
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

                     selectNum = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
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
                  

                  selectNum = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
                  breakAlp = true;
                  //return day;
                  break;

               case 4 :          
                  year = CP.inputYear();
                  month =   CP.inputMonth();         
                  CP.print(year, month);
            
                  selectNum = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
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