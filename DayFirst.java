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
			System.out.print("���� �Է� : ");
			y = sc.nextInt();
		}
		while (y < 1 || y<nowy); //���� ���ĸ� �����ϰ��Ϸ��� ���� ����

		return y;
		
		}

		int inputMonth(){
		do
		{
			System.out.print("��   �Է� : ");
			m = sc.nextInt();
		}
		while (1 > m || m > 12 || (y==nowy && m<nowm));//���� ���ĸ� �����ϰ� �� ����

		return m;
		}

		void print(int year, int month){
		int w;		
		int i;


		cal.set(year, month-1, 1);
		w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println();
		System.out.println("\t[ " + year + "�� " + month + "�� ]\n");			// ' \t ' : tab
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
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

		System.out.println("1. ��¥ ����");
		System.out.println("2. ���� �� ����");
		System.out.println("3. ���� �� ����");
		System.out.println("4. ���� �������� ���ư���");
		selectNum = sc.nextInt();		
		}
		while(selectNum>4 || selectNum<1);
		return selectNum;

}
}

public class DayFirst //ó�� ���� �����̶� �̸��� �̷��� �������... Ŭ������ �ȳְ� ������ ������ ����� �����Դϴ�.. 
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);

		CalenderPrint CP = new CalenderPrint();
		ChangeMonth CM = new ChangeMonth();
	
		int year;
		int month;
		int day;
		int selectNum;//changemonht���� �޾ƿ� 1-4���� ���� ���� ����

		
		year = CP.inputYear();
		month =	CP.inputMonth();
			CP.print(year, month);

		

		do{

		selectNum = CM.input();
		switch(selectNum){
		case 1 : System.out.printf("��¥ �Է� (���� ��¥ = %d�� %d�� %d�� ): ",CP.nowy,CP.nowm,CP.nowd);
			day= sc.nextInt();
			
			if(year == CP.nowy && month == CP.nowm && CP.nowd>=day){//������ ���� ���� �� �� ����������, ������¥ ���� ���ϰ� �ϱ�����.
			do
			{
				CP.print(year,month);
				 System.out.printf("���� ���� ��¥ �Է� (���� ��¥ = %d�� %d�� %d�� ): ",CP.nowy,CP.nowm,CP.nowd);			
				 day= sc.nextInt();
			
			}while(day<=CP.nowd);
			break;	
			}
			else
			
			break;
				
		case 2 : //
		if( year==CP.nowy && CP.nowm == month){ //������ �� ���������� ������ ���� ���ϰ� ��.
			CP.print(year, month);	
			System.out.println("����� �������� ������ �Ұ��մϴ�. �ٸ� �������� ȣ���ϼ���.");
			
			break;}
		
		else
		month -= 1;
		if(month<1) //1���� ���� �����Ҷ� �۳� 12���� �ٲ���
			{
			month =12;
			year = year-1;
			}
		CP.print(year, month);
		
			break;

		case 3 : month = month + 1;
		if(month>12) //12���� ������ �����Ҷ� ���� 1���� �ٲ���
			{
				month = 1;
				year +=1;
				}
		CP.print(year, month);
		break;
		case 4 : 			//�ٽ� ó������..
			year = CP.inputYear();
			month =	CP.inputMonth();			
			CP.print(year, month);
	
			break;
		
		
		}
		
		}while(selectNum !=1);

		}

	}
	

