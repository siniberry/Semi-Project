class PeopleInfo // ž�°�
{
  String pName; // �̸�
  String pNum; // ���� �� ���ڷ� ���� ����(���� �� ���� �߶� ����)
  boolean pBooking; // ���࿩��
  boolean pCouBooking; // ���� ��������
  int pMil; // ���ϸ���
  String pId; //ž�°� id
  String pPw; //ž�°� pw
}

/*
class Dummy // ���� ž�°�
{
PeopleInfo ps1 = new PeopleInfo();
PeopleInfo ps2 = new PeopleInfo();
PeopleInfo ps3 = new PeopleInfo();

ps1.pName = "���̻�"
ps1.pNum = "670615-1442670"

ps1.pBooking =
ps1.pCouBooking =
ps1.pMil = 500
ps1.pId =
ps1.pPw =

ps2.pName = "�����"
ps2.pNum = "791228-2175265"

ps2.pBooking =
ps2.pCouBooking =
ps2.pMil = 500
ps2.pId =
ps2.pPw =


ps3.pName = "�谩ȯ"
ps3.pNum = "671217-1911338"

ps3.pBooking =
ps3.pCouBooking =
ps3.pMil = 500
ps3.pId =
ps3.pPw =
}
*/

class Ticket
{
 int bookDay; 
 int bookTime;
 String bookSeatNum;
}

class NMember
{
String nMName;
String nMNum;
}

class TicketBooking
{
   String mYN;
   System.out.println("[ �װ��� ����(ctrl+z�Է½� �ڷΰ���) ]");
   memberCheck
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("������ �����ʴϱ�?(Y/N) : ");
      mYN = sc.next();
      
      if (mYN == "Y")
      {
         memberLogin   // �α��� Ŭ����
         {
         }
      }
      else
      {
         System.out.println("�ű� ȸ�������� �Ͻðڽ��ϱ�?(Y/N)");
         System.out.println("(�ű�ȸ�����Խ� ����+���� ���ϸ��� ����)");
         System.out.print(": ");
         mYN = sc.next();
         if (mYN == "Y")
         {
            //ȸ������ Ŭ����
         }
         else
         {
            //��ȸ���α��� Ŭ����
         }

      }
   }
   
   static int WP()   //�պ�/��
   {
      Scanner sc = new Scanner(System.in);
      System.out.println(" \t 1. �� ");
      System.out.println(" \t 2. �պ� ");
      System.out.println();
      System.out.println();

         System.out.print("�׸� ��ȣ�� �Է����ּ��� :");
         int n = sc.nextInt();

         if (n == 1)
            return 1;
         else if(n == 2)
            return 2;
         else 
            return 0;
   }



   static char sPoint()         //�׽�Ʈ �Ϸ�
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("������� �Է����ּ��� : ");
      String input = sc.next();
      char result = 'E';
   
      if (input.equals("����"))
         result = 'S';
      else if(input.equals("�λ�"))
         result = 'B';
      else if(input.equals("����"))
         result = 'J';
      
      System.out.println(input);
      return result;
      
      
   }

   static char aPoint()         // �׽�Ʈ �Ϸ�
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("������� �Է����ּ��� : ");
      String input = sc.next();
      char result = 'E';
   
      if (input.equals("����"))
         result = 'S';
      else if(input.equals("�λ�"))
         result = 'B';
      else if(input.equals("����"))
         result = 'J';

      return result;
      
   }
      

   
}

class MemberLogin      //�α��� Ŭ����
{
   //Test179�����ؼ� Hashtable�� id/pw �˻�
}

class MemberSignUp      //ȸ������ Ŭ����
{
	Scanner sc = new Scanner(System.in);

	System.out.println("\t [ ȸ������ ] ");

	System.out.print("�̸� : ");
	PeopleInfo.pName = sc.next();

	System.out.print("�ֹε�Ϲ�ȣ : ");
	PeopleInfo.pNum = sc.next();

	System.out.print("ID");
	PeopleInfo.pId = sc.next();

	System.out.print("PW");
	PeopleInfo.pPw = sc.next();


}
class nMemberLogin      //��ȸ�� �α��� Ŭ����
{

	static String getPName()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t [ ��ȸ�� ���� ]");


		System.out.println("�̸� : ");
		PeopleInfo.pName = sc.next();
		return PeopleInfo.pName;
	}

	/*
	static String getPNum()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("�ֹε�Ϲ�ȣ : ");
		PeopleInfo.pNum = sc.next();
		return PeopleInfo.pNum;
	}
	*/




	static void isPNAvailable()
	{
		Scanner sc = new Scanner(System.in);
		int resultPN=0;
		int[] arr1;
		int[] arrS;
		int sum=0;

		do
		{

			System.out.println("�ֹε�Ϲ�ȣ : ");
			String isPNum = sc.next();

			int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
			
			arr1 = new int[14];
			
			arrS = new int[13];
			
			
			
			//System.out.print("�ֹε�Ϲ�ȣ : \n");

			for (int i=0;i<13 ;i++ )
			{
				//System.out.printf("%d ��° ���ڸ� �Է��ϼ���", i);
				arr1[i] = Integer.parseInt( isPNum.substring(i,i+1));
				
			}

			for (int i=0;i<12 ;i++ )
			{
				arrS[i] = arr[i] * arr1[i];
			
			}

			for (int i= 0;i<12 ;i++ )
			{
				sum +=arrS[i];
			}
			
			resultPN  = 11-(sum%11);



			System.out.println();
			
			if (resultPN==10)
			{
				resultPN = 0;
			}
			//System.out.println(resultPN);

			if (arr1[12]==resultPN)
			{
				System.out.print( "\n�����մϴ�.\n ");

			}
			else
			{
				System.out.print( "\n �߸��� �ֹι�ȣ�Դϴ�. �ֹι�ȣ�� ���Է����ּ���.\n ");
			}


		}
		//while (!arr1[12].equals(resultPN));
		while (arr1[12]!=resultPN);



	}
	
}


/*

  String pName; // �̸�
  String pNum; // ���� �� ���ڷ� ���� ����(���� �� ���� �߶� ����)
  boolean pBooking; // ���࿩��
  boolean pCouBooking; // ���� ��������
  int pMil; // ���ϸ���
  String pId; //ž�°� id
  String pPw; //ž�°� pw
  */


public class Airplane
{
   public static void main(String []args)
   {
     





   }
}

/* �պ�/�� ����
*��¥ = a
*�ð� = b

*�ο���(p) = 2
*1��° ž�°� �ڸ� = c1
*2��° ~ =c2
{
 n= �պ�(2),��(1)
static int nP = 1; //Ŭ���� �ֻ�� 

 rd  = new Record[p];
    for(int i=0;i<p*n;i++) // n= �պ�(2),��(1)
   {
    rd[nP] = new Record(); 
     �����[nP].���೯¥ = a
     �����[nP].����ð� = b
      System.out.print(��i��° �°��� �¼��� �Է����ּ��䡱);
        �����[nP].�¼���ȣ = sc.next()
      nP++;
    }

  }

}
*/