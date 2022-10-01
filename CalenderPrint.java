import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;



class CalenderPrint //��� �Է�, Ķ���� �׷��ֱ�
	
	{	

		Scanner sc = new Scanner(System.in);
		Calendar cal = new GregorianCalendar();
		
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
		while (y < 1 || y<nowy);

		return y;
		
		}

		int inputMonth(){
		do
		{
			System.out.print("��   �Է� : ");
			m = sc.nextInt();
		}
		while (1 > m || m > 12 || (y==nowy && m<nowm));

		return m;
		}

		void print(int year, int month){
		int w;		
		int i;

		
		cal.set(year, month-1, 1);
		w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println();
		System.out.println("\t[ " + year + "�� " + month + "�� ]\n");	
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("============================");
		for (i=1; i<w; i++)
		{
			System.out.print("    ");		// ���� 4ĭ �־���
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
