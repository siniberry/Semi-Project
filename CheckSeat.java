import java.util.Scanner;


class rsvRecord
{
	int rsvYear;       //����
	int rsvMon;        //��
	int rsvDay;        //��
	String rsvStart;   //���
	String rsvReturn;  //����
	String rsvTime;    //�ð�
	String rsvGrade;   //���

	String rsvSeatNum;    //�¼���ȣ 
}







class CheckSeat extends Record
{
		
	rsvRecord[] rsvRec = new rsvRecord[100];

	String[] seatArr = new String[100];
	



	int m=0;
	int k=0;


	void input(int rsvYearIp, int rsvMonIp, int rsvDayIp, String rsvStartIp, String rsvReturnIp, String rsvTimeIp, String rsvGradeIp)  //����� �� �� Ƽ�����? ���� �ܰ迡�� ����
	{ 

		
		rsvRec[m] = new rsvRecord();	

		rsvRec[m].rsvYear =	rsvYearIp;		//��������;
		rsvRec[m].rsvMon =	rsvMonIp;		//������;
		rsvRec[m].rsvDay =	rsvDayIp;		//�ϻ���;
		rsvRec[m].rsvStart = rsvStartIp;		//���������;
		rsvRec[m].rsvReturn = rsvReturnIp;	//����������;
		rsvRec[m].rsvTime =	rsvTimeIp;		//�ð�����;
		rsvRec[m].rsvGrade = rsvGradeIp;		//�¼���޻���;

		m +=1 ;
	}

	String[] MkSeatArr()
	{
		Scanner sc = new Scanner(System.in);

		//String[] seatArr = new String[100];


		System.out.print("������ �Է��ϼ��� : ");
		int yearCk = sc.nextInt();
		System.out.print("���� �Է��ϼ��� : ");
		int monthCk = sc.nextInt();
		System.out.print("���� �Է��ϼ��� : ");
		int dayCk = sc.nextInt();

		System.out.print("������� �Է��ϼ��� : ");
		String startCk = sc.next();
		System.out.print("�������� �Է��ϼ��� : ");
		String returnCk = sc.next();

		System.out.print("�ð��� �Է��ϼ��� : ");
		String timeCk = sc.next();
		System.out.print("�¼������ �Է��ϼ��� : ");
		String seatGradeCk = sc.next();

		//�༱�� ������� �־�� ��..


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

	void CheckSeatImpl()	//-- �¼� ��ȸ
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

	void  CheckBisprint() //-- �¼� ����
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			//System.out.print("[\t����Ϸ��� '���'�� �Է��ϼ���		]");
			
			//if(strColumn.equals("���")) 
			//	{
			//		 System.out.println("����Ǿ����ϴ�");break;
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