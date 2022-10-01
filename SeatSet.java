import java.util.Scanner;

class Record
{	
     int [][] seats = new int[10][4]; 
    
	 boolean isRun= true; // �ݺ� flag
    
   	 String strColumn; // �� �̸�
  	 char inputColumn;

   	 int rowNum; // �� ��ȣ
}

class YearSet 
{
	int year;

	class MonthSet(int year)
	{
		this.year = year;
	}
		MonthSet [] MSA = new MonthSet[6];
		
		for (int i =0;i<9 ; i++)
		{
			MSA[i] = new MonthSet(year[i]); 
		}
}

class MonthSet 
{
	int month;

	class DaySet(int month)
	{
		this.month = month;
	}
		DaySet [] DSA = new DaySet[6];
		
		for (int i =0;i<9 ; i++)
		{
			DSA[i] = new DaySet(month[i]); 
		}
}

class DaySet 
{
	int day;

	class FlightSet(int day)
	{
		this.day = day;
	}
		FlightSet [] FSA = new FlightSet[6];
		
		for (int i =0;i<9 ; i++)
		{
			FSA[i] = new FlightSet(day[i]); 
		}
	
}


class FlightSet 
{
	int flight;

	class TimeSet(int flight)
	{
		this.flight = flight;
	}
		TimeSet [] TSA = new TimeSet[9];
		
		for (int i =0;i<9 ; i++)
		{
			TSA[i] = new TimeSet(flight[i]); 
		}
	
		

} 
 class TimeSet 
{
	int time;

	class SeatSet(int time)
	{
		this.time = time;
	}
		SeatSet [] SSA = new SeatSet[9];
		
		for (int i =0;i<9 ; i++)
		{
			SSA[i] = new SeatSet(time[i]); 
		}
	
}

class SeatSet extends Record
{
	

		void FirstSeatImpl()	//-- �¼� ��ȸ
		{
			System.out.println();
			System.out.println("���������������������������������������۽�Ʈ Ŭ����������������������������������������������������");
			System.out.println();
			System.out.print(" [ "+"��/��"+ " ] ");
			
			for (int i = 0; i < 1; i++) 
				{
					for (int j = 0; j < seats[i].length; j++) 
						{
							System.out.print(" ");
							System.out.print(" [ "+"0"+(j+1)+" ]   ");
						}
		
				} 
				System.out.println();
			
			for (int i = 0; i < seats.length; i++) 
				{
					 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
					 System.out.print("  ");

					 for (int j = 0; j < seats[i].length; j++) 
						{	
							 if(seats[i][j] == 0) 
								 System.out.print("[ �� ]     ");
							else 
								 System.out.print("[ �� ]     ");
					
						 }
					System.out.println();
				
				}
		  
			System.out.print("������������������������������������������������������������������������������������������������������������������");
			System.out.println();				

		}

		void  Firstprint()	//-- �¼� ����
		{
			Scanner sc = new Scanner(System.in);
			
			do
			{
				System.out.print("[\t����Ϸ��� '���'�� �Է��ϼ���		]");
				System.out.print("\n�����Ͻ� �� �̸��� �Է����ּ���  : ");

				strColumn = sc.next().toUpperCase();
				
				if(strColumn.equals("���")) 
					{
						 System.out.println("����Ǿ����ϴ�");break;
					}

				inputColumn = strColumn.trim().charAt(0);

				System.out.println("�Է��� �� : " +inputColumn);

				if(inputColumn < 65 || inputColumn > 74) 
					{
						 System.out.println("������ �� ���� �¼��Դϴ�");continue;
					} 

				int column = inputColumn - 65;

				System.out.print("�����Ͻ� �¼��� �� ��ȣ�� �Է����ּ��� : ");
				
				rowNum = sc.nextInt();

				if(rowNum < 1 || rowNum > 4) 
					{
						  System.out.println("������ �� ���� �� ��ȣ�Դϴ�");continue;
					}

				System.out.println("�����Ͻ� �¼��� : " +inputColumn+ " ���̰� " + rowNum + " ���Դϴ�");
				System.out.print("���� �Ϸ� �Ͻðڽ��ϱ� ? (Y / N) : ");
				String s = sc.next();

				if((seats[column][rowNum-1]== 0))
					{
						if(s.equals("y") || s.equals("Y")) 
							{
								seats[column][rowNum-1] = 1;
								System.out.println("������ �Ϸ�Ǿ����ϴ�");
								// -- �װ��� ��ȣ ��� ();
								FirstSeatImpl();
								System.out.println();
								isRun = false;
							}
							
						else 
							{
								System.out.println("��ҵǾ����ϴ�");
								FirstSeatImpl();
							}
					}
				else
					{
						System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �¼��� �������ּ���.");
						FirstSeatImpl();
					 }
					
			} while (isRun);

			return;

		}
	


	
		
		void BisSeatImpl()	//-- �¼� ��ȸ
		{
			System.out.println();
			System.out.println("������������������������������������������Ͻ� Ŭ����������������������������������������������������");
			System.out.println();
			System.out.print(" [ "+"��/��"+ " ] ");
			
			for (int i = 0; i < 1; i++) 
				{
					for (int j = 0; j < seats[i].length; j++) 
						{
							System.out.print(" ");
							System.out.print(" [ "+"0"+(j+1)+" ]   ");
						}
		
				} 
				System.out.println();
			
			for (int i = 0; i < seats.length; i++) 
				{
					 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
					 System.out.print("  ");

					 for (int j = 0; j < seats[i].length; j++) 
						{	
							 if(seats[i][j] == 0) 
								 System.out.print("[ �� ]     ");
							else 
								 System.out.print("[ �� ]     ");
					
						 }
					System.out.println();
				
				}
		  
			System.out.print("������������������������������������������������������������������������������������������������������������������");
			System.out.println();				

		}

		void  Bisprint() //-- �¼� ����
		{
			Scanner sc = new Scanner(System.in);
			
			do
			{
				System.out.print("[\t����Ϸ��� '���'�� �Է��ϼ���		]");
				System.out.print("\n�����Ͻ� �� �̸��� �Է����ּ���  : ");

				strColumn = sc.next().toUpperCase();
				
				if(strColumn.equals("���")) 
					{
						 System.out.println("����Ǿ����ϴ�");break;
					}

				inputColumn = strColumn.trim().charAt(0);

				System.out.println("�Է��� �� : " +inputColumn);

				if(inputColumn < 65 || inputColumn > 74) 
					{
						 System.out.println("������ �� ���� �¼��Դϴ�");continue;
					} 

				int column = inputColumn - 65;

				System.out.print("�����Ͻ� �¼��� �� ��ȣ�� �Է����ּ��� : ");
				
				rowNum = sc.nextInt();

				if(rowNum < 1 || rowNum > 4) 
					{
						  System.out.println("������ �� ���� �� ��ȣ�Դϴ�");continue;
					}

				System.out.println("�����Ͻ� �¼��� : " +inputColumn+ " ���̰� " + rowNum + " ���Դϴ�");
				System.out.print("���� �Ϸ� �Ͻðڽ��ϱ� ? (Y / N) : ");
				String s = sc.next();

				if((seats[column][rowNum-1]== 0))
					{
						if(s.equals("y") || s.equals("Y")) 
							{
								seats[column][rowNum-1] = 1;
								System.out.println("������ �Ϸ�Ǿ����ϴ�");
								// -- �װ��� ��ȣ ��� ();
								BisSeatImpl();
								System.out.println();
								isRun = false;
							}
							
						else 
							{
								System.out.println("��ҵǾ����ϴ�");
								BisSeatImpl();
								
							}
					}
				else
					{
						System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �¼��� �������ּ���.");
						BisSeatImpl();
					 }
					
			} while (isRun);

			return;

		}

	

	
		void EcoSeatImpl()	//-- �¼� ��ȸ
		{
				System.out.println();
				System.out.println("�����������������������������������������ڳ�� Ŭ����������������������������������������������������");
				System.out.println();
				System.out.print(" [ "+"��/��"+ " ] ");
				for (int i = 0; i < 1; i++) 
				{
					for (int j = 0; j < seats[i].length; j++) 
					{
						System.out.print(" ");
						System.out.print(" [ "+"0"+(j+1)+" ]   ");
					}
				} 
				System.out.println();
			
				for (int i = 0; i < seats.length; i++) 
				{
					 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
					 System.out.print("  ");

					for (int j = 0; j < seats[i].length; j++) 
					{	
						if(seats[i][j] == 0) 
						   System.out.print("[ �� ]     ");
						else 
							System.out.print("[ �� ]     ");
						
					}
					System.out.println();
				
				}
		  
			System.out.print("������������������������������������������������������������������������������������������������������������������");
			System.out.println();				

		}

		void  Ecoprint()//-- �¼� ����
		{
			Scanner sc = new Scanner(System.in);
			do
			{
				System.out.print("[\t����Ϸ��� '���'�� �Է��ϼ���		]");
				System.out.print("\n�����Ͻ� �� �̸��� �Է����ּ���  : ");

				strColumn = sc.next().toUpperCase();
				
				if(strColumn.equals("���")) 
					{
						 System.out.println("����Ǿ����ϴ�");break;
					}

				inputColumn = strColumn.trim().charAt(0);

				System.out.println("�Է��� �� : " +inputColumn);

				if(inputColumn < 65 || inputColumn > 74) 
					{
						 System.out.println("������ �� ���� �¼��Դϴ�");continue;
					} 

				int column = inputColumn - 65;

				System.out.print("�����Ͻ� �¼��� �� ��ȣ�� �Է����ּ��� : ");
				
				rowNum = sc.nextInt();

				if(rowNum < 1 || rowNum > 4) 
					{
						  System.out.println("������ �� ���� �� ��ȣ�Դϴ�");continue;
					}

			System.out.println("�����Ͻ� �¼��� : " +inputColumn+ " ���̰� " + rowNum + " ���Դϴ�");
			System.out.print("���� �Ϸ� �Ͻðڽ��ϱ� ? (Y / N) : ");
			String s = sc.next();

			 if((seats[column][rowNum-1]== 0))
			{
				if(s.equals("y") || s.equals("Y")) 
				{
					seats[column][rowNum-1] = 1;
					System.out.println("������ �Ϸ�Ǿ����ϴ�");
					// -- �װ��� ��ȣ ��� ();
					EcoSeatImpl();
					System.out.println();
					isRun = false;
				}
							
				else 	   
				{
					System.out.println("��ҵǾ����ϴ�");
					EcoSeatImpl();
					
				}
			}
			else
			{
				System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �¼��� �������ּ���.");
				EcoSeatImpl();
			}
		} 
		while (isRun);

		return;

		}

}

/*
��¥<k> ������
    <v> �����ڷᱸ��

<k> 2022.02.14
<v> �¼�����

<k> 2022.02.15
<v> �¼�����

�밡���� ����ִ� �����̶�
*/