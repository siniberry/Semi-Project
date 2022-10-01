import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

abstract class Record 
{	
    int [][] seats = new int[10][4]; // �¼�
    
	 boolean flag = true; // �ݺ� flag
    
   	 int row; // �� �̸�

   	 int col; // �� ��ȣ

	 abstract void mainSeatImpl();
	
}

class mainSeat extends Record //throws IOException
{
	void mainSeatImpl() throws IOException	//-- ������ �Է� 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do{

					System.out.println();
					System.out.println("�����������������������������������������������������۽�Ʈ Ŭ������������������������������������������������������������");
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
				
					for (int i = 0; i < 2; i++) 
					{
						 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
						 System.out.print("  ");
					for (int j = 0; j < 2; j++) 
					{	
						if(seats[i][j] == 0) 
						   System.out.print(0);
						else 
							System.out.print(1);
						
					}
					System.out.println();
					
				}
			  
				System.out.println();
				System.out.println("��������������������������������������������������������Ͻ���������������������������������������������������������");
				System.out.println();
				
				for (int i = 2; i < 5; i++) 
				{
					System.out.print(" [   "+ (char)(i+67) +"   ] ");		
					System.out.print("  ");
					for (int j = 2; j < 5; j++) 
					{	
						if(seats[i][j] == 0) 
						   System.out.print(0);
						else 
							System.out.print(1);
						
					}
					System.out.println();
					
				}
					 
				System.out.println();
				System.out.println("�������������������������������������������������������ڳ�̦�������������������������������������������������������");
				System.out.println();
				
				for (int i = 5; i < 10; i++) 
				{
					System.out.print(" [   "+ (char)(i+70) +"   ] ");		
					System.out.print("  ");
					for (int j = 5; j < 10; j++) 
					{	
						if(seats[i][j] == 0) 
						   System.out.print(0);
						else 
						   System.out.print(1);
						
					}
					System.out.println();
					
				}
				System.out.print("��������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println();
				



				 System.out.print("�����Ͻ� �¼��� �� ��ȣ�� �Է����ּ��� : ");

				 row = Integer.parseInt(br.readLine());

				 System.out.print("\n�����Ͻ� �� ��ȣ�� �Է����ּ���  : ");

				 col = (char)System.in.read();

				 

				 if(!(seats[row][col]== 0))
					 {

						System.out.println("�����Ͻ� " + row+"��"+col+"�� �¼��� ����Ǿ����ϴ�.");
						System.out.print("���� �Ϸ� �Ͻðڽ��ϱ� ? (Y / N) : ");

						String s = br.readLine();
						if(s.equals('y') || s.equals('Y')) 
							{
								seats[col][row - 1] = 1;
								System.out.println("������ �Ϸ�Ǿ����ϴ�");
							 }
						
						else 
						   
							{
							System.out.println("��ҵǾ����ϴ�");
							
							}

						flag = false;

					}
				 else
				{

					System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �¼��� �������ּ���.");

				 }

			}while(flag);


	}
}


public class Seatbasic
{
	public static void main(String[]args) throws IOException
	{
		mainSeat ms = new mainSeat();

		ms.mainSeatImpl();
		
	}
}