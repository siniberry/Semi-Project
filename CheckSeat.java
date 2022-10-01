import java.util.Scanner;


class rsvRecord
{
	int rsvYear;       //연도
	int rsvMon;        //월
	int rsvDay;        //일
	String rsvStart;   //출발
	String rsvReturn;  //복귀
	String rsvTime;    //시간
	String rsvGrade;   //등급

	String rsvSeatNum;    //좌석번호 
}







class CheckSeat extends Record
{
		
	rsvRecord[] rsvRec = new rsvRecord[100];

	String[] seatArr = new String[100];
	



	int m=0;
	int k=0;


	void input(int rsvYearIp, int rsvMonIp, int rsvDayIp, String rsvStartIp, String rsvReturnIp, String rsvTimeIp, String rsvGradeIp)  //만들어 둔 거 티켓출력? 같은 단계에서 쓰기
	{ 

		
		rsvRec[m] = new rsvRecord();	

		rsvRec[m].rsvYear =	rsvYearIp;		//연도삽입;
		rsvRec[m].rsvMon =	rsvMonIp;		//월삽입;
		rsvRec[m].rsvDay =	rsvDayIp;		//일삽입;
		rsvRec[m].rsvStart = rsvStartIp;		//출발지삽입;
		rsvRec[m].rsvReturn = rsvReturnIp;	//도착지삽입;
		rsvRec[m].rsvTime =	rsvTimeIp;		//시간삽입;
		rsvRec[m].rsvGrade = rsvGradeIp;		//좌석등급삽입;

		m +=1 ;
	}

	String[] MkSeatArr()
	{
		Scanner sc = new Scanner(System.in);

		//String[] seatArr = new String[100];


		System.out.print("연도를 입력하세요 : ");
		int yearCk = sc.nextInt();
		System.out.print("월을 입력하세요 : ");
		int monthCk = sc.nextInt();
		System.out.print("일을 입력하세요 : ");
		int dayCk = sc.nextInt();

		System.out.print("출발지를 입력하세요 : ");
		String startCk = sc.next();
		System.out.print("도착지를 입력하세요 : ");
		String returnCk = sc.next();

		System.out.print("시간을 입력하세요 : ");
		String timeCk = sc.next();
		System.out.print("좌석등급을 입력하세요 : ");
		String seatGradeCk = sc.next();

		//행선지 출발지도 있어야 함..


		for (int i=0;i<rsvRec.length ;i++ )
		{
			if (rsvRec[i].rsvYear == yearCk)
			{
				if (rsvRec[i].rsvMon == monthCk)
				{
					if (rsvRec[i].rsvDay == dayCk)
					{
						if (rsvRec[i].rsvStart == startCk)
						{
							if (rsvRec[i].rsvReturn == returnCk)
							{
								if (rsvRec[i].rsvTime == timeCk)
								{
									if (rsvRec[i].rsvGrade == seatGradeCk)
									{
										seatArr[k] = rsvRec[i].rsvSeatNum;
										k +=1 ;
									}
								}

							}
						}

					}
				}
			}
		}

		return seatArr;

	}

	void CheckSeatImpl()	//-- 좌석 조회
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

	void  CheckBisprint() //-- 좌석 예약
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			//System.out.print("[\t취소하려면 '취소'를 입력하세요		]");
			
			//if(strColumn.equals("취소")) 
			//	{
			//		 System.out.println("종료되었습니다");break;
			//	}
			
			/*
			
			for (int i=0;i<seatArr.length ;i++ )
			{
				char ts = seatArr[i].charAt[0]; //C1
				int s1 = ts - 65;
				int s2 = Integer.parseInt(seatArr[i].substring[1]);

				seats[s1][s2-1] =1;
				CheckSeatImpl();
			}
			isRun = false;

			*/
			//int z=0;
			
			//String z = "0";
			//seatArr[0] = "a1";
			
			if (seatArr.length == 0)
			{
				for ( String z : seatArr  )
				{
					char ts = z.charAt(0); //C1
					int s1 = ts - 65;
					int s2 = Integer.parseInt(z.substring(1));

					seats[s1][s2-1] =1;
					CheckSeatImpl();			
				}
			}
			isRun = false;



		} while (isRun);

	}








}