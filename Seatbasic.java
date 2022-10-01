import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

abstract class Record 
{	
    int [][] seats = new int[10][4]; // 좌석
    
	 boolean flag = true; // 반복 flag
    
   	 int row; // 열 이름

   	 int col; // 행 번호

	 abstract void mainSeatImpl();
	
}

class mainSeat extends Record //throws IOException
{
	void mainSeatImpl() throws IOException	//-- 데이터 입력 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do{

					System.out.println();
					System.out.println("──────────────────────────퍼스트 클래스────────────────────────────");
					System.out.println();
					System.out.print(" [ "+"행/열"+ " ] ");
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
				System.out.println("──────────────────────────비즈니스────────────────────────────");
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
				System.out.println("──────────────────────────이코노미────────────────────────────");
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
				System.out.print("───────────────────────────────────────────────────────────────────");
				System.out.println();
				



				 System.out.print("예약하실 좌석의 열 번호를 입력해주세요 : ");

				 row = Integer.parseInt(br.readLine());

				 System.out.print("\n예약하실 행 번호를 입력해주세요  : ");

				 col = (char)System.in.read();

				 

				 if(!(seats[row][col]== 0))
					 {

						System.out.println("선택하신 " + row+"열"+col+"행 좌석이 예약되었습니다.");
						System.out.print("예약 완료 하시겠습니까 ? (Y / N) : ");

						String s = br.readLine();
						if(s.equals('y') || s.equals('Y')) 
							{
								seats[col][row - 1] = 1;
								System.out.println("예약이 완료되었습니다");
							 }
						
						else 
						   
							{
							System.out.println("취소되었습니다");
							
							}

						flag = false;

					}
				 else
				{

					System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");

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