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

      year = CP.inputYear();		//����ڷκ��� �Է¹��� �⵵
      month =   CP.inputMonth();	//����ڷκ��� �Է¹��� ��
      CP.print(year, month);		// �� �� �޾Ƽ� �޷����

      nowYear = CP.nowy;			//������ �⵵
      nowMonth = CP.nowm;			//������ ��
      nowDay = CP.nowd;				//������ ��
      DS.getNowYear(nowYear);		//���� �� �ҷ����� �޼ҵ�
      DS.getNowMonth(nowMonth);		//���� �� �ҷ����� �޼ҵ�
      DS.getNowDay(nowDay);			//���� �� �ҷ����� �޼ҵ�

      DS.getYear(year);				//������ �⵵ �ҷ����� �޼ҵ�(����ڿ��� �Է¹��� �⵵)
      DS.getMonth(month);			//������ �� �ҷ����� �޼ҵ�(����ڿ��� �Է¹��� ��)

      selectNum1 = CM.input();		//�޴� 1234�� �����Ѱ� �Ѱ���
      day = DS.input(selectNum1);	// 1234�� ������ �޴� ���� �� �Է¹��� ��¥ ��ȯ
      
      /*
      do
      {
         selectNum1 = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
         day = DS.input(selectNum1); // 1234�� ������ �޴� ���� �� �Է¹��� ��¥ ��ȯ
      }
      while (day!=100);
      */

      System.out.printf("%d�� %d�� %d��",DS.nyear,DS.nmonth,day);
   }

 }
   
