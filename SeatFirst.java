import java.util.Scanner;

class Record
{	
     int [][] seats = new int[10][4]; 
    
	 boolean isRun= true;; // �ݺ� flag
    
   	 String strColumn; // �� �̸�
  	 char inputColumn;

   	 int rowNum; // �� ��ȣ
}

class SeatFirst extends Record	
{
	void FirstSeatImpl()	//-- �¼� ��ȸ
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
							isRun = false;
						}
				}
			else
				{
					System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �¼��� �������ּ���.");
					FirstSeatImpl();
				 }
				
		} while (isRun);

	}

}



