import java.util.Scanner;

class PeopleInfo // ž�°� ȸ��
{
   private boolean pBooking;         // ���࿩��
   private boolean pCouBooking = false; // ���� ��������
   private int pMil;               // ���ϸ���
   private String pPoint;            // �����/������
   private String pName;            // �̸�
   private String pNum;               // �ֹε�Ϲ�ȣ

   public PeopleInfo(String pName, String pNum, boolean pBooking, boolean pCouBooking, int pMil)
   {
      this.pName = pName;
      this.pNum = pNum;
      this.pBooking = pBooking;
      this.pCouBooking = pCouBooking;
      this.pMil = pMil;
    }
   
   public PeopleInfo(String pName, String pNum, boolean pCouBooking)
   {
      this.pName = pName;
      this.pNum = pNum;
     this.pCouBooking = pCouBooking;
   }
   public PeopleInfo()
   {
   }

   public String getpName(){ return pName; }
   public String getpNum(){ return pNum; }
   public int getpMil(){ return pMil; }
   public boolean getpBooking(){ return pBooking; }
   public boolean getpCouBooking(){ return pCouBooking; }
   public void setpName(String pName){ this.pName = pName; }
   public void setpNum(String pNum){ this.pNum = pNum; }
   public void setpMil(int pMil){ this.pMil = pMil; }
   public void setpBooking(boolean pBooking){ this.pBooking = pBooking; }
   public void setCouBooking(boolean pCouBooking){ this.pCouBooking = pCouBooking; }
}

class MemberIDPW
{
   private String pName;         // �̸�
   private String pNum;         // �ֹε�Ϲ�ȣ
   private String pid;            // ž�°� id
   private String ppw;            // ž�°� pw

   public MemberIDPW(String pName, String pNum, String pid, String ppw)
   {
      this.pid = pid;
      this.ppw = ppw;
     this.pNum = pNum;
     this.pName = pName;
   }

   public String getpid(){ return pid; }
   public String getppw(){ return ppw; }
   public String getpName(){ return pName; }
   public String getpNum(){ return pNum; }
   public void setpid(String pid){ this.pid = pid; }
   public void setpwd(String ppw){ this.ppw = ppw; }
   public void setpName(String pName){ this.pName = pName; }
   public void setpNum(String pNum){ this.pNum = pNum; }


}

class NonMemberInfo                  //��ȸ�� ��������
{
   private String pName;            // �̸�
   private String pNum;               // �ֹε�Ϲ�ȣ

   public String getpName(){ return pName; }
   public String getpNum(){ return pNum; }
   public void setpName(String pName){ this.pName = pName; }
   public void setpNum(String pNum){ this.pNum = pNum; }

   public NonMemberInfo(String pName, String pNum)
   {
      this.pName = pName;
      this.pNum = pNum;
   }

}

class Record
{   
     int [][] seats = new int[10][4]; 
    boolean isRun= true; // �ݺ� flag
       String strColumn; // �� �̸�
      char inputColumn;
       int rowNum; // �� ��ȣ
}

class TicketBooking
{
   pHandler handler = new pHandler(100);
   String mYN;
   void memberCheck()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("������ �����ʴϱ�?(Y/N) : ");
      mYN = sc.next();
     String aorb;
      
      if (mYN.equals("Y") || mYN.equals("y"))      
      {
            
         do
         {
            aorb = handler.memberLogin();
         }
         while (aorb.equals("b"));
      }
      else
      {
         System.out.println("�ű� ȸ�������� �Ͻðڽ��ϱ�?(Y/N)");
         System.out.println("(�ű�ȸ�����Խ� ����+���� ���ϸ��� ����)");
         System.out.print(": ");
         mYN = sc.next();
         if (mYN.equals("Y")|| mYN.equals("y"))
         {
            handler.MemberInsert();
         }
         else
         {
            handler.nMemberInsert();
         }

      }
   }
   
   String WP()   // �༱�� ����
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("1. �� ");
      System.out.println("2. �պ� ");
      System.out.println();

      System.out.print("�׸� ��ȣ�� �Է����ּ��� :");
      int n = sc.nextInt();
         
      if (n == 1)
         return ""+ sPoint() + aPoint();      // SB
      if (n == 2)
         return ""+ sPoint() + aPoint() + sPoint() + aPoint();      //SBBS
      else 
         return "Error";
   }



   static char sPoint()         //�׽�Ʈ �Ϸ�
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("������� �Է����ּ���(����, ����, �λ�) : ");
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

   static char aPoint()         // �׽�Ʈ �Ϸ�
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("�������� �Է����ּ���(����, ����, �λ�) : ");
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

class pHandler   // �α��� / ȸ������
{
   private MemberIDPW[] members;
   private NonMemberInfo[] nonmembers;
   private int idx;
   private int nidx;
   String uid, pwd, name, num;
   String PNAn;

   public pHandler(int num)
   {
      members = new MemberIDPW[num];
      nonmembers = new NonMemberInfo[num];
      idx = 0;
      nidx = 0;
   }

   public void MemberInsert()  //ȸ������
   { 
      
      Scanner sc = new Scanner(System.in);
      System.out.print("���̵� : "); 
      uid = sc.next();

      if (!isUniqueID(uid)) // �ߺ�ID
      {
         System.out.println("�̹� ������� ���̵� �Դϴ�. \n");
         return;
      }

      System.out.print("��й�ȣ : "); 
      pwd = sc.next();

      System.out.print("�̸� : "); 
      name = sc.next();
      
      do
      {
         System.out.print("�ֹε�Ϲ�ȣ(13�ڸ�('-'����)) : ");
         num = sc.next();
         PNAn = isPNA(num);
      }
      while (PNAn.equals("Error"));
      

      members[idx] = new MemberIDPW(uid, pwd, name, num);

      idx++;
      System.out.println("���� �Ϸ�!! \n");
   }
  
   private boolean isUniqueID(String uid) // ���̵��� �ߺ� ����
   { 
      if (idx == 0) 
         return true;

      for (int i = 0 ; i < idx ; i ++)
      {
         if (members[i].getpid().equals(uid))
            return false;
      }
      return true;
   }

   public void memberLoginEx()
   { // ȸ���α��ο� �޼ҵ�
      Scanner sc = new Scanner(System.in);
      String replay = "yes";

      while(replay.equals("no"))
      {
         System.out.print("���̵� : "); 
         String uid = sc.nextLine();

         System.out.print("�н����� : "); 
         String pwd = sc.nextLine();

         for (int i = 0 ; i < idx ; i++)
         {
            if (members[i].getpid().equals(uid) && members[i].getppw().equals(pwd))
            {
               System.out.println("ȯ���մϴ�.");
               System.out.println("�α��ο� �����Ͽ����ϴ�. \n");
               replay = "no";
            }
            else if (!members[i].getpid().equals(uid))
            {
               System.out.println("�������� �ʴ� ���̵��Դϴ�. \n");
               replay = "yes";
            }
            else if (members[i].getpid().equals(uid) && !members[i].getppw().equals(pwd))
            {
               System.out.println("��ȣ�� �߸��Ǿ����ϴ�. \n");
               replay = "yes";
            }
      
         }
      }
      // System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");

      /*
      �α��� ������ : "�α��� �Ǿ����ϴ�." �޼��� ���
      �α��� ���н� : "�������� �ʴ� ���̵� �Դϴ�." or "��ȣ�� �߸��Ǿ����ϴ�." �� �ϳ��� ���
      */
   }

   public String memberLogin()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("���̵� : "); 
      String uid = sc.next();
      String mblg = "a";

      System.out.print("�н����� : "); 
      String pwd = sc.next();

      String msg = "�������� �ʴ� ���̵� �Դϴ�.";
     


      for (int i = 0 ; i < idx ; i++ )
      {
         if (members[i].getpid().equals(uid))
         {// members�迭�� �Է��� ���̵� ������
            if (members[i].getppw().equals(pwd))
            {
            msg = "�α��� �Ǿ����ϴ�.";
            return mblg = "a";

            } 
         else
         {
            msg = "��ȣ�� �߸��Ǿ����ϴ�.";
            return mblg = "b";

            }
         }
      }
      System.out.println(msg);
      return mblg = "b";
   }

   
   public void nMemberInsert()   //��ȸ�� �̸� �Է�
   {
      String name, num, PNAn;
      Scanner sc = new Scanner(System.in);
      System.out.print("�̸� : "); 
      name = sc.next();
      do
      {
      System.out.print("�ֹε�Ϲ�ȣ(13�ڸ�('-'����)) : ");
      num = sc.next();
      PNAn = isPNA(num);
      }
      while (PNAn.equals("Error"));
      
      nonmembers[nidx] = new NonMemberInfo(name,num);
      System.out.println("��ȸ�� �����Դϴ�.");
      nidx++;
      /*
      Scanner sc = new Scanner(System.in);
      System.out.println("[��ȸ�� �α���]");
      System.out.print("�̸� : ");
      String nm = sc.next();
      nm = 
     System.out.print
     */

   }
   
   static String isPNA(String pnum)   //��ȸ�� �ֹε�Ϲ�ȣ ��ȿ���˻�
   {
      Scanner sc = new Scanner(System.in);
      int resultPN=0;
      int[] arr1;
      int[] arrS;
      int sum=0;
     String result = pnum;
      do
      {

          /*
         System.out.print("�ֹε�Ϲ�ȣ : ");
          String isPNum = sc.next();
         */
          int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
          arr1 = new int[14];
          arrS = new int[13];

          for (int i=0;i<13 ;i++ )
            arr1[i] = Integer.parseInt(result.substring(i,i+1));
          for (int i=0;i<12 ;i++ )
            arrS[i] = arr[i] * arr1[i];
          for (int i= 0;i<12 ;i++ )
            sum +=arrS[i];
          
          resultPN  = 11-(sum%11);

          System.out.println();
          
          if (resultPN==10)
            resultPN = 0;

          if (arr1[12]==resultPN)
         {
            System.out.println("��ȿ�� �ֹε�Ϲ�ȣ�Դϴ�.");
            return result;
         }
          else
         {
            System.out.println("�߸��� �ֹε�Ϲ�ȣ�Դϴ�.");
            return "Error";
         }
       }
       while (arr1[12]!=resultPN && result.length() !=13);
   }
}

class AirPlanePay
{
   static final int airFood =10000;   //�⳻�� 
   static final int luggage =20000;   //��ȭ�� 20Kg�̻��̸� ����
   String destination;
   String YN;
   boolean airFoodcheck = false;
   boolean luggagecheck = false;

   void pay(String sa)
   {
      if (sa.equals("SB"))
         destination = "����-�λ���";
      else if (sa.equals("BS"))
         destination = "�λ�-������";
      else if (sa.equals("SJ"))
         destination = "����-������";
      else if (sa.equals("JS"))
         destination = "����-������";
      else if (sa.equals("BJ"))
         destination = "�λ�-������";
      else if (sa.equals("JB"))
         destination = "����-�λ���";
      else
         return;

      Scanner sc = new Scanner(System.in);

      System.out.printf("[%s �����]%n",destination);
      System.out.println("�⳻�� ���� : "+airFood+"��");
      System.out.println("��ȭ�� ���� : "+luggage+"��");
      
      //=============================(�¼� �ҷ�����(ex)a1, b1,)=====================================
      System.out.println();
      //System.out.printf("%s - �⳻���� �����Ͻðڽ��ϱ�? (Y/N) : ");
      System.out.print("�⳻���� �����Ͻðڽ��ϱ�?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         airFoodcheck = true;
      }
      
      //System.out.printf("%s - ��ȭ���� 20KG �̻��̽ʴϱ�? (Y/N) : ");
      System.out.print("��ȭ���� 20KG �̻��̽ʴϱ�?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         luggagecheck = true;
      }

   }

}

class SeatFirst extends Record   
{
   void FirstSeatImpl()      //-- �¼� ��ȸ
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

   void  Firstprint()   //-- �¼� ����
   {
      Scanner sc = new Scanner(System.in);
      
      do
      {
         System.out.print("[\t����Ϸ��� '���'�� �Է��ϼ���      ]");
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

   }

}

class PayCalculate
{
   
}

public class PTest005
{
   public static void main(String []args)
   {
      Scanner sc = new Scanner(System.in);
      TicketBooking TB = new TicketBooking();
     AirPlanePay APP = new AirPlanePay(); 
     SeatFirst SF = new SeatFirst();
      String test;

     System.out.println(APP.airFoodcheck);
      
      while(true)
      {
       System.out.println("[�װ��� �߱Ǳ�]");
         System.out.println("�ȳ��ϼ���.");
         System.out.println("�װ��� �߱Ǳ��Դϴ�.");
       System.out.println();
       TB.memberCheck();

         System.out.println("[�װ��� �߱Ǳ�]");
         System.out.println("�ȳ��ϼ���.");
         System.out.println("�װ��� �߱Ǳ��Դϴ�.");

         System.out.println();
         System.out.println("1. �װ��� ���� ");
         System.out.println("2. �װ��� ��ȸ ");
         System.out.println("3. �װ��� �ܿ��¼� Ȯ�� ");
         System.out.println("4. ���� ");
         System.out.println();
         System.out.print("�׸� ��ȣ�� �Է����ּ��� : ");
         int choice = sc.nextInt();
         
         switch(choice)
         {
            case 1 :
            test = TB.WP();
         //�޷�, ��¥ ����
         //�ð� ����
         //�ο� ����
         SF.FirstSeatImpl();
         SF.Firstprint();
         //�¼� ����, �¼� ����
         //�¼���ȣ �Է¹ޱ�
         APP.pay(test);
         
         
         

            break;
            case 2 : break;
            case 3 : break;
            case 4 : return;
         }
         
      }
         
   }
}