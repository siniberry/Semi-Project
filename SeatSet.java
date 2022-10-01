import java.util.Scanner;

class Record
{	
     int [][] seats = new int[10][4]; 
    
	 boolean isRun= true; // 반복 flag
    
   	 String strColumn; // 행 이름
  	 char inputColumn;

   	 int rowNum; // 열 번호
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
	

		void FirstSeatImpl()	//-- 좌석 조회
		{
			System.out.println();
			System.out.println("───────────────────퍼스트 클래스────────────────────────");
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
			
			for (int i = 0; i < seats.length; i++) 
				{
					 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
					 System.out.print("  ");

					 for (int j = 0; j < seats[i].length; j++) 
						{	
							 if(seats[i][j] == 0) 
								 System.out.print("[ □ ]     ");
							else 
								 System.out.print("[ ■ ]     ");
					
						 }
					System.out.println();
				
				}
		  
			System.out.print("─────────────────────────────────────────────────────────");
			System.out.println();				

		}

		void  Firstprint()	//-- 좌석 예약
		{
			Scanner sc = new Scanner(System.in);
			
			do
			{
				System.out.print("[\t취소하려면 '취소'를 입력하세요		]");
				System.out.print("\n예약하실 행 이름을 입력해주세요  : ");

				strColumn = sc.next().toUpperCase();
				
				if(strColumn.equals("취소")) 
					{
						 System.out.println("종료되었습니다");break;
					}

				inputColumn = strColumn.trim().charAt(0);

				System.out.println("입력한 행 : " +inputColumn);

				if(inputColumn < 65 || inputColumn > 74) 
					{
						 System.out.println("선택할 수 없는 좌석입니다");continue;
					} 

				int column = inputColumn - 65;

				System.out.print("예약하실 좌석의 열 번호를 입력해주세요 : ");
				
				rowNum = sc.nextInt();

				if(rowNum < 1 || rowNum > 4) 
					{
						  System.out.println("선택할 수 없는 열 번호입니다");continue;
					}

				System.out.println("선택하신 좌석은 : " +inputColumn+ " 행이고 " + rowNum + " 열입니다");
				System.out.print("예약 완료 하시겠습니까 ? (Y / N) : ");
				String s = sc.next();

				if((seats[column][rowNum-1]== 0))
					{
						if(s.equals("y") || s.equals("Y")) 
							{
								seats[column][rowNum-1] = 1;
								System.out.println("예약이 완료되었습니다");
								// -- 항공권 번호 출력 ();
								FirstSeatImpl();
								System.out.println();
								isRun = false;
							}
							
						else 
							{
								System.out.println("취소되었습니다");
								FirstSeatImpl();
							}
					}
				else
					{
						System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
						FirstSeatImpl();
					 }
					
			} while (isRun);

			return;

		}
	


	
		
		void BisSeatImpl()	//-- 좌석 조회
		{
			System.out.println();
			System.out.println("───────────────────비즈니스 클래스────────────────────────");
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
			
			for (int i = 0; i < seats.length; i++) 
				{
					 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
					 System.out.print("  ");

					 for (int j = 0; j < seats[i].length; j++) 
						{	
							 if(seats[i][j] == 0) 
								 System.out.print("[ □ ]     ");
							else 
								 System.out.print("[ ■ ]     ");
					
						 }
					System.out.println();
				
				}
		  
			System.out.print("─────────────────────────────────────────────────────────");
			System.out.println();				

		}

		void  Bisprint() //-- 좌석 예약
		{
			Scanner sc = new Scanner(System.in);
			
			do
			{
				System.out.print("[\t취소하려면 '취소'를 입력하세요		]");
				System.out.print("\n예약하실 행 이름을 입력해주세요  : ");

				strColumn = sc.next().toUpperCase();
				
				if(strColumn.equals("취소")) 
					{
						 System.out.println("종료되었습니다");break;
					}

				inputColumn = strColumn.trim().charAt(0);

				System.out.println("입력한 행 : " +inputColumn);

				if(inputColumn < 65 || inputColumn > 74) 
					{
						 System.out.println("선택할 수 없는 좌석입니다");continue;
					} 

				int column = inputColumn - 65;

				System.out.print("예약하실 좌석의 열 번호를 입력해주세요 : ");
				
				rowNum = sc.nextInt();

				if(rowNum < 1 || rowNum > 4) 
					{
						  System.out.println("선택할 수 없는 열 번호입니다");continue;
					}

				System.out.println("선택하신 좌석은 : " +inputColumn+ " 행이고 " + rowNum + " 열입니다");
				System.out.print("예약 완료 하시겠습니까 ? (Y / N) : ");
				String s = sc.next();

				if((seats[column][rowNum-1]== 0))
					{
						if(s.equals("y") || s.equals("Y")) 
							{
								seats[column][rowNum-1] = 1;
								System.out.println("예약이 완료되었습니다");
								// -- 항공권 번호 출력 ();
								BisSeatImpl();
								System.out.println();
								isRun = false;
							}
							
						else 
							{
								System.out.println("취소되었습니다");
								BisSeatImpl();
								
							}
					}
				else
					{
						System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
						BisSeatImpl();
					 }
					
			} while (isRun);

			return;

		}

	

	
		void EcoSeatImpl()	//-- 좌석 조회
		{
				System.out.println();
				System.out.println("───────────────────이코노미 클래스────────────────────────");
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
			
				for (int i = 0; i < seats.length; i++) 
				{
					 System.out.print(" [   "+ (char)(i+65) +"   ] ");		
					 System.out.print("  ");

					for (int j = 0; j < seats[i].length; j++) 
					{	
						if(seats[i][j] == 0) 
						   System.out.print("[ □ ]     ");
						else 
							System.out.print("[ ■ ]     ");
						
					}
					System.out.println();
				
				}
		  
			System.out.print("─────────────────────────────────────────────────────────");
			System.out.println();				

		}

		void  Ecoprint()//-- 좌석 예약
		{
			Scanner sc = new Scanner(System.in);
			do
			{
				System.out.print("[\t취소하려면 '취소'를 입력하세요		]");
				System.out.print("\n예약하실 행 이름을 입력해주세요  : ");

				strColumn = sc.next().toUpperCase();
				
				if(strColumn.equals("취소")) 
					{
						 System.out.println("종료되었습니다");break;
					}

				inputColumn = strColumn.trim().charAt(0);

				System.out.println("입력한 행 : " +inputColumn);

				if(inputColumn < 65 || inputColumn > 74) 
					{
						 System.out.println("선택할 수 없는 좌석입니다");continue;
					} 

				int column = inputColumn - 65;

				System.out.print("예약하실 좌석의 열 번호를 입력해주세요 : ");
				
				rowNum = sc.nextInt();

				if(rowNum < 1 || rowNum > 4) 
					{
						  System.out.println("선택할 수 없는 열 번호입니다");continue;
					}

			System.out.println("선택하신 좌석은 : " +inputColumn+ " 행이고 " + rowNum + " 열입니다");
			System.out.print("예약 완료 하시겠습니까 ? (Y / N) : ");
			String s = sc.next();

			 if((seats[column][rowNum-1]== 0))
			{
				if(s.equals("y") || s.equals("Y")) 
				{
					seats[column][rowNum-1] = 1;
					System.out.println("예약이 완료되었습니다");
					// -- 항공권 번호 출력 ();
					EcoSeatImpl();
					System.out.println();
					isRun = false;
				}
							
				else 	   
				{
					System.out.println("취소되었습니다");
					EcoSeatImpl();
					
				}
			}
			else
			{
				System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
				EcoSeatImpl();
			}
		} 
		while (isRun);

		return;

		}

}

/*
날짜<k> 연월일
    <v> 최종자료구조

<k> 2022.02.14
<v> 좌석구조

<k> 2022.02.15
<v> 좌석구조

대가리가 비어있는 팀원이라
*/