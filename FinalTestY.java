import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;



class MemberIDPW               // --(ȸ������/�α��θ��� ���� Ŭ����)
{
   private String pName;         // �̸�
   private String pNum;         // �ֹε�Ϲ�ȣ
   private String pid;            // ž�°� id
   private String ppw;            // ž�°� pw

   public MemberIDPW(String pid, String ppw, String pName, String pNum)
   {
      this.pid = pid;
      this.ppw = ppw;
     this.pName = pName;
     this.pNum = pNum;
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


class NonMemberInfo                  // ��ȸ�� ��������
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

class Record               //�¼��� �Ӽ�Ŭ����
{   
     int [][] seats = new int[10][4]; 
    boolean isRun= true; // �ݺ� flag
       String strColumn; // �� �̸�
      char inputColumn;
       int rowNum; // �� ��ȣ
}

class TicketBooking            // �װ��� ���� Ŭ����
{
   pHandler handler = new pHandler(100);    //ȸ������/�α��� �Ҷ� ����ϴ� Ŭ���� ����
   RandomMil rm = new RandomMil();
   String mYN, mYN1;                        //Scanner ����Ҷ� ����ϴ� ����
   String id,pw,name,num;                   //ȸ�����Խ� id,pw,name,num�� �ޱ� ���� ����
   int mil;                                 //���ϸ��� ����(ȸ�����Խ� 1000���ϸ��� �߰�) 
   char newCu = 'X';                        //���� ����(ȸ�����Խ� 'O'�� ����)
   private int mi;                        //handler Ŭ���� �ȿ� idx������ ������ ���� ����
   private int idx;

   int getmi()                              // mi�� ���๮���� ������ ���� Ŭ����
   {
     mi = handler.getmemNum();
      return mi;
   }
   int getidx()
   {
      idx = handler.getidx();
      return idx;
   }

   void memberCheck()                        //ȸ������ Ŭ����
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("������ �����ʴϱ�?(Y/N) : ");
      mYN = sc.next();
      String aorb;
      boolean aorb1 = true;
      
      if (mYN.equals("Y") || mYN.equals("y"))      
      {
         aorb = handler.memberLogin();
         id = handler.uid;
         pw = handler.pwd;
         do
         {
          if (aorb.equals("b"))
          {
             System.out.print("������ �����ʴϱ�?(Y/N) : ");
             mYN1 = sc.next();

             if (mYN1.equals("Y") || mYN1.equals("y"))
             {
               aorb = handler.memberLogin();
            id = handler.uid;
            pw = handler.pwd;
               continue;
             }
             else if (mYN1.equals("N") || mYN1.equals("n") )
             {
               aorb= "b";
               aorb1= false;
               break;
             }
           }
          else
          {
            aorb= "a";
            aorb1= true;
            break;
          }
         }
         while (aorb.equals("b") );
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
          id = handler.uid;
          pw = handler.pwd;
          name = handler.name;
          mil = rm.ranMil();
          newCu = 'O';
         }
         else
         {
            handler.nMemberInsert();
          id = handler.uid;
          pw = handler.pwd;
          name = handler.name;
         }
      }

      if (aorb1== false)
      {
          System.out.println("�ű� ȸ�������� �Ͻðڽ��ϱ�?(Y/N)");
          System.out.println("(�ű�ȸ�����Խ� ����+���� ���ϸ��� ����)");
          System.out.print(": ");
          mYN = sc.next();
          if (mYN.equals("Y")|| mYN.equals("y"))
          {
            handler.MemberInsert();
          id = handler.uid;
          pw = handler.pwd;
          name = handler.name;
          mil = rm.ranMil();
          newCu = 'O';
          }
          else
          {
            handler.nMemberInsert();
          id = handler.uid;
          pw = handler.pwd;
          name = handler.name;
          }

      }
   }
}

class RandomMil
{
	int ranMil()
	{
		Random rand = new Random();
		int ranMil = rand.nextInt(20001)+10000;
		return ranMil;
	}
}



class pHandler   // �α��� / ȸ������
{
   private MemberIDPW[] members;
   private NonMemberInfo[] nonmembers;
   private int idx;
   private int nidx;
   private int memNum;
   String uid, pwd, name, num;
   String PNAn;

   int getmemNum()
   {
      return memNum;
   }

   int getidx()
   {
      return idx;
   }

   public pHandler(int num)
   {
      members = new MemberIDPW[num];                  //ȸ�� �迭 Ŭ���� ����            --��resmember�� �ٸ�!!
      nonmembers = new NonMemberInfo[num];            //��ȸ�� �迭 Ŭ���� ����         --(ȸ������/�α��θ��� ���� Ŭ����)
      idx = 0;
      nidx = 0;
   }

   public void MemberInsert()  //ȸ������
   { 
      Scanner sc = new Scanner(System.in);

     do
     {
        System.out.print("���̵� : "); 
        uid = sc.next();
        if (!isUniqueID(uid))
            System.out.println("�̹� ������� ���̵� �Դϴ�. \n");
     }
      while (!isUniqueID(uid)); // �ߺ�ID
     

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
      memNum=idx;
      System.out.println("���� �Ϸ�!! \n");
      idx++; // ��� ��
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

  public String memberLogin()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("���̵� : "); 
      String uid = sc.next();
      String mblg = "a";

      System.out.print("�н����� : "); 
      String pwd = sc.next();

      String msg = "�������� �ʴ� ���̵� �Դϴ�.";
     int i=0;

      for (i = 0; i < idx ; i++)
      {
       
         if (members[i].getpid().equals(uid))
         {// members�迭�� �Է��� ���̵� ������
            if (members[i].getppw().equals(pwd))
            {
            msg = "�α��� �Ǿ����ϴ�.";
            System.out.println(msg);
            memNum=i;
            return mblg = "a";
            }
         else
         {
            msg = "��ȣ�� �߸��Ǿ����ϴ�.";
            System.out.println(msg);
            return mblg = "b";
         }
         }
      }
     
      System.out.println(msg);
     
      return mblg = "b";
     //return mblg = "a";
   }

   
   public void nMemberInsert()   //��ȸ�� �̸� �Է�
   {
      String PNAn;
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
   
   static String isPNA(String pnum)   //�ֹε�Ϲ�ȣ ��ȿ���˻�
   {
      Scanner sc = new Scanner(System.in);
      int resultPN=0;
      int[] arr1;
      int[] arrS;
      int sum=0;
     String result = pnum;
      do
      {
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

class AirPlanePay                  //�⳻�� / ��ȭ���� ������ ������ ����� Ŭ����
{
   static final int airFood =10000;   //�⳻�� 
   static final int luggage =20000;   //��ȭ�� 20Kg�̻��̸� ����
   String destination;
   String YN;                                    //��ĳ�� ����
   boolean airFoodCheck = false;               //�⺻�� false, �Ʒ� ��ĳ�ʿ��� y�� �Է��ϸ� true
   boolean luggageCheck = false;               //�⺻�� false, �Ʒ� ��ĳ�ʿ��� y�� �Է��ϸ� true

   void pay(String sa)
   {
      Scanner sc = new Scanner(System.in);
      destination = sa;
      System.out.printf("[%s �����]%n",destination);         // �����ؾ� ��-- sPoint()�����ؼ� �޼ҵ带 ������ ��
      System.out.println("�⳻�� ���� : "+airFood+"��");
      System.out.println("��ȭ�� ���� : "+luggage+"��");
      
      //=============================(�¼� �ҷ�����(ex)a1, b1,)=====================================
      System.out.println();
      //System.out.printf("%s - �⳻���� �����Ͻðڽ��ϱ�? (Y/N) : ");
      System.out.print("�⳻���� �����Ͻðڽ��ϱ�?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
         airFoodCheck = true;
     else
        airFoodCheck = false;
      
      //System.out.printf("%s - ��ȭ���� 20KG �̻��̽ʴϱ�? (Y/N) : ");
      System.out.print("��ȭ���� 20KG �̻��̽ʴϱ�?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
         luggageCheck = true;
     else
       luggageCheck = false;

   }
   

   boolean getAFC()
   {
      return airFoodCheck;
   }
   boolean getLGC()
   {
      return luggageCheck;
   }

}

class SeatFirst extends Record               // �¼��� Ŭ����(�۽�Ʈ��)
{
   private String SeatName;               // �¼���ȣ�� return ��Ű�� ���ؼ�

   void setSeatName(String name) {this.SeatName = name;}
   String getSeatName(){return SeatName;}

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
         SeatName = "" + inputColumn + rowNum;
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

   }


}

class SeatBis extends Record      // �¼��� Ŭ����(����Ͻ���)
{
   private String SeatName;
   void setSeatName(String name) {this.SeatName = name;}
   String getSeatName() {return SeatName;}

   void BisSeatImpl()   //-- �¼� ��ȸ
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
         SeatName = "" + inputColumn + rowNum;
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
   }
}



class SeatEco extends Record      //�¼��� Ŭ����(���ڳ�̼�)
{
   private String SeatName;
   
   void setSeatName(String name) {this.SeatName = name;}
   String getSeatName() {return SeatName;}

   void EcoSeatImpl()   //-- �¼� ��ȸ
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
      SeatName = "" + inputColumn + rowNum;
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
         isRun=false;
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

   }

   

}

class PayCalCulate                              //��� �� ������ ���
{
   char food = 'X';
   char lug = 'X';
   String seatClass;
   String seatName;
   int seatPay;
   
   void calPrint(String sClass, String sName, boolean acheck, boolean lcheck, int year, int month, int day, String time)      //���� ����Ʈ
   {
      seatClass = sClass;
      seatName = sName;
      if (acheck == true)
         food = 'O';
      if (lcheck == true)
         lug = 'O';

      char coupon = 'X';
      
      System.out.println();
      System.out.println("==========���� ������==========");
      System.out.printf("%d/%d/%d %s��� %n",year,month,day,time);       //�� �����ؾ���.  ��¥�� Ŭ���� ����ؼ� ���
      System.out.printf("�з� : %s%n",seatClass);               //�з� :���ڳ��, �۽�Ʈ, ����Ͻ�
      System.out.printf("�¼� : %s%n",seatName);            //�¼� :A1, B1, C1
      System.out.printf("�⳻�� : %c%n",food);               // �⳻�� : O, X
      System.out.printf("��ȭ�� 20KG �̻� : %c%n",lug);         // ��ȭ�� : O, X
      System.out.printf(" ��������(10%%) : %c%n",coupon);         // �������� O      �ϴ� ����� ����
      System.out.println("");
   }

   void TotalCal (String seat)
   {
      if (seat.equals("�۽�Ʈ"))
      seatPay = 200000;
      else if (seat.equals("����Ͻ�"))
      seatPay = 100000;
      else
      seatPay = 50000;
      
   }
}

class SeatCheck                        //�¼� ���� Ŭ����
{
   int Check()
   {
      int n = 4;
      Scanner sc = new Scanner(System.in);
      System.out.println("�¼������ �������ּ���.");
      System.out.println("1. �۽�Ʈ Ŭ���� ");
      System.out.println("2. ����Ͻ� Ŭ���� ");
      System.out.println("3. ���ڳ�� Ŭ���� ");
      System.out.println("4. ���� ");

      System.out.print("�׸� ��ȣ�� �Է����ּ��� : ");
        n = sc.nextInt();

      return n;
   }
}

class Ticket                  //Ƽ�� ����, ��� Ŭ����
{
   String ticketNum;          // Ƽ�Ϲ�ȣ
   String point;              // �༱��
   String name;               // �̸�
   String seat;               // �¼���ȣ
   String sclass;             // �¼����
   int peoCount=1;            // �������
   int roTrip=1;              // �պ�
   int tyear,tmonth,tday;
   String ttime;

   void YMDSetting(int year, int month, int day,String time)
   {
      tyear = year;
      tmonth = month;
      tday = day;
      ttime = time;
   }


   void TicketPrint(String po,String pe,String se,String sc)      //��¸޼ҵ�
   {   
      point = po;
      name = pe;
      seat = se;
      sclass = sc;

      char gate = gateMaking(point);
      String start = startMaking(point);
      String end = endMaking(point);

      //for (int i=0; i<roTrip*peoCount; i++)            //�պ��̸� �ѹ���
      //{
      ticketNum = ""+tyear+tmonth+tday + gate + point + ttime + seat;

      System.out.println("===========================================");
      System.out.printf("\t     [%s Ŭ����]%n",sclass);
      System.out.printf(" ������ : %s   \t    ž�±� : %c%n",name,gate);
      System.out.printf("   \t\t\t    �¼� : %s",seat);
      System.out.println();
      System.out.printf("\t      %s �� %s%n", start,end);
      System.out.printf("\t%d/%d/%d %s ��� �����%n",tyear,tmonth,tday,ttime); // ��¥�� �޾Ƽ� ���
      System.out.printf(" \t�װ��ǹ�ȣ : %s%n",ticketNum);
      System.out.println("===========================================");
      //}
   }

   char gateMaking(String point)      //ž�±� ���� �޼ҵ�
   {
      if (point.equals("SP") || point.equals("PS"))
         return 'A';
      else if (point.equals("SB") || point.equals("BS"))
         return 'B';
      else if (point.equals("SJ") || point.equals("JS"))
         return 'C';
      else 
         return 'D';
   }

   String startMaking(String point)   //����빮�ڸ� ������� �ٽ� �ٲ��ִ� �޼ҵ�
   {
      char result = point.charAt(0);
      if (result == 'S')
         return "����";
      else if (result == 'P')
         return "�λ�";
      else if (result == 'J')
         return "����";
      else
         return "����";
   }
   String endMaking(String point)      //����빮�ڸ� ������� �ٽ� �ٲ��ִ� �޼ҵ�
   {
      char result = point.charAt(1);
      if (result == 'S')
         return "����";
      else if (result == 'P')
         return "�λ�";
      else if (result == 'J')
         return "����";
      else
         return "����";
   }

   String getTicketNum()
   {
      return ticketNum;
   }
}

class resMember            //��--���� ȸ�� �迭 Ȱ���ؼ� ��ȣ�� ���� Ƽ���̳� Ŭ���� �� ������ �޶����� ��������.
{
   String ID="";   
   String PW="";
   String point="";
   String rName="";   
   int mil=0;   //���ϸ���
   int count=0;
   private int hasT;            // �ο���, Ƽ�Ϻ�������
   String rSeat="";
   String rClass="";      //�¼��̸�, �¼����
   String time;
   int membernumber;    //�ο��� ��ȣ  �� �̰ɷ� ������ �߾����� Ȯ�� ����
   int year,month,day;
   
   
   
   void setYMDT(int y,int m,int d,String t)
   {
      year = y;
      month = m;
      day = d;
      time = t;
   }

   void setMember(String id, String pw, int mil, String point, String name, String seatName, int n, String c, int num)
   {
      this.ID = id;
      this.PW = pw;
      this.mil = mil;
      this.point = point;
      rName = name;
      rSeat = seatName;
      this.hasT = n;
      rClass = c;
      membernumber = num;
   }

   String getRClass()
   {
      return rClass;
   }
   int gethasT()
   {
      return hasT;
     }

}

class pPoint                     //����� ������ Ŭ����
{
   private String start;
   private String end;
   String result;

   void Pointinput()               //�Է� Ŭ����
   {
      Scanner sc = new Scanner(System.in);
      do
      {
      System.out.println("�����, �������� �������ּ���");
      System.out.print("����/�λ�/����(���� ����) : ");
      start = sc.next();
      end = sc.next();
      }
      while (start.equals(end) || (!start.equals("����") && !start.equals("�λ�") && !start.equals("����")) 
        || (!end.equals("����") && !end.equals("�λ�") && !end.equals("����")));

      result = sPoint();
   }
   
   String sPoint()        //����� ������ ��ȯ Ŭ����
   {

      Scanner sc = new Scanner(System.in);
      String result;
      String result1="";
      String result2="";

      if (start.equals("����"))
         result1= "S";
      else if(start.equals("�λ�"))
         result1= "P";
      else if(start.equals("����"))
         result1= "J";
      else
         result1= "E";
      
      if (end.equals("����"))
         result2= "S";
      else if(end.equals("�λ�"))
         result2= "P";
      else if(end.equals("����"))
         result2= "J";
      else 
         result2= "E";
      result = result1 + result2;
      return result;
   }
}


class setMoney
{
int deMoney (String depart)
{
   int priceDepart = 1000;
   
   
   if(depart.equals("SJ"))
   {
      priceDepart = 120000;
   }
   else if(depart.equals("JS"))
   {
      priceDepart = 120000;
   }
   else if(depart.equals("SP"))
   {
      priceDepart = 100000;
   }
   else if (depart.equals("PS"))
   {
      priceDepart = 100000;
   }
   else if (depart.equals("PJ"))
   {
      priceDepart = 60000;
   }
   else if (depart.equals("JP"))
   {
      priceDepart = 60000;
   }


      return priceDepart;
}

int levelMoney(String seatclass, int price)
{
   int priceLevel = price;

   if(seatclass.equals("���ڳ��")){
      priceLevel = priceLevel;
   }
   else if(seatclass.equals("�����Ͻ�")){
      priceLevel = priceLevel * 2;
   }
   else if(seatclass.equals("�۽�Ʈ")){
      priceLevel = priceLevel * 3;
   }
   
   return priceLevel;
}

}

class Discount
{

  // ������ ������ ��� �����Ͽ� ���� ���� ������ return ���ִ� �޼ҵ�
  int discount(int money, boolean food, boolean lug, char cou, int year, int month, int day, String time) 
  {
   int price;
   boolean discount = false;
   String dash = "-";

   double saleprice, calcprice;
   int fprice = 10000, lprice = 20000;         
   
   if (time.equals("0630") || time.equals("0830") || time.equals("1030") || time.equals("2230"))
   {
      discount = true;
   }
   else
      discount = false;
      
   int number1 = year;
   String str1 = Integer.toString(number1); 

   int number2 = month; 
   String str2 = Integer.toString(number2); 

   int number3 = day; 
   String str3 = Integer.toString(number3); 
      
   String date = str1 + dash + str2 + dash + str3;
      
   int calMonth = 0;
   int compare = 0;
   SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
   String today = df.format (System.currentTimeMillis());

   try
   {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      Date currentDate = format.parse(today);
      Date lastDate = format.parse(date);
      long calDate = currentDate.getTime() - lastDate.getTime();
      long calDateDays = (calDate / (24*60*60*1000))*-1;             // ���� ��¥�κ��� ���� �����ϱ����� �� �� ���� = calDateDays
      calMonth = (int)calDateDays-180;                        // calMonth >=0 : �󸮹��� �ñ� (6���� �̻�) 
   }
   catch (ParseException e)
   {
   }
   
   if (calMonth<0)      // �󸮹��� �̿��� �ñ� 
   {
      if (discount)   // �����ɾ߽ð�����
      {
         saleprice = money*0.1;
         calcprice = money-saleprice;            
         money = Integer.parseInt(String.valueOf(Math.round(calcprice)));
      }
      else
         money *= 1;
   }
   else
      money *= 1;

   if (food == true )
   {
      money += fprice;
   }
   else
      money *= 1;

   if (lug == true)
   {
      money += lprice;
   }
   else
      money *= 1;
   
   if (cou == 'O')                     
   {
      saleprice = money*0.1;
      calcprice = money-saleprice;            
      price = Integer.parseInt(String.valueOf(Math.round(calcprice)));
   }
   else
      price = money;
   
   return price;
  }
}
class moneyCal
{


int price;
int getmileage;
int mileage;
int useMileage(int priceM, int gmileage){
   Scanner sc = new Scanner(System.in);
      
      char choiseM;
      int usedMileage = 0;
      if(gmileage>0){
       System.out.print("���ϸ����� ����Ͻðڽ��ϱ�?(Y/N) : ");
      choiseM = sc.next().charAt(0);
       if (choiseM == 'Y'|| choiseM == 'y')
         {
         do{
         System.out.printf("����� ���ϸ����� �Է�(�ܿ� ���ϸ��� %d) : ",gmileage);
         usedMileage = sc.nextInt();
         }while(usedMileage > gmileage || usedMileage ==0);

         mileage = gmileage - usedMileage;
            
         price = priceM - usedMileage;
         return usedMileage;
      }
       else
         {
         return usedMileage;    
       }
      }

   
      return usedMileage;
}

int getMoney(int leftMileage)
{
      int money = 0;
      int inputm = 0;
      int submoney;
      int sum = 0;
      Scanner sc = new Scanner(System.in);

      
      do{
      System.out.printf("�ݾ��� �����ϼ��� (�ݾ� : %d): ",price);
      inputm = sc.nextInt();
      if(inputm<price)
         {
         sum += inputm;
         if(sum > price){
            return sum;
         }
         else if(sum>=price){
         sum = price;
         return sum;
         
         }
         }
      
      
      else if(inputm >= price)
      {   //�Ž����� ��ȯ
      sum = inputm;
      return inputm;
      }
      }while (sum<price);
   
      return sum;

}

   




void calMoney(int getMoney) 
   {   
      Scanner sc = new Scanner(System.in);
      int submoney;
      int mileselect;
      submoney = getMoney - price;
      if(getMoney == price)
      {
         System.out.printf("�Ž������� �����ϴ�.%n");
         System.out.printf("�ܿ� ���ϸ��� : %d%n",mileage);
      }
      //
      else
      {

      System.out.printf("�Ž�����: 1. ���ݹ�ȯ 2. ���ϸ��� ���� : ");
      mileselect = sc.nextInt(); 
      
      if(mileselect == 1){
      int[] coin = {50000,10000,5000,1000};
      int leftcoin = 999;
      
      for(int i = 0; i< coin.length; i++)
         {
         if((submoney/coin[i])>0)
            {
         System.out.println(coin[i] + "��: " + submoney/coin[i]);
         submoney %= coin[i];}
         if(leftcoin >= submoney){
            leftcoin = submoney; 
            getmileage = submoney;
            mileage += getmileage;
         }
               
         }
      
         System.out.printf("���ϸ��� ���� : %d%n",getmileage);
      }
      else if(mileselect == 2){
   
         mileage += submoney;
         System.out.printf("���ϸ��� ���� : %d%n",submoney);

                  }
         System.out.printf("�ܿ� ���ϸ��� : %d",mileage);
         System.out.println();
      
      }
   }


//���ϸ��� �����ϴ� �޼ҵ�
int mileageCal(int price, int getMoney, int mileage){
      
      int submoney;
      submoney = getMoney - price;
      
      int leftcoin = 999;
      

         if((submoney/1000)>0)
            {
         submoney %= 1000;}
         if(leftcoin >= submoney){
            leftcoin = submoney; 
            getmileage = submoney;
            mileage += getmileage;               
         }
      return mileage;
}

}

class airTicketCheck      //�װ��� ��ȸ Ŭ����
{   
   
}



public class FinalTestY
{
   public static void main(String []args)
   {
      //Ŭ����, ���� ����
    Scanner sc = new Scanner(System.in);
     Calendar cal = new GregorianCalendar();
    TicketBooking TB = new TicketBooking();
     AirPlanePay APP = new AirPlanePay(); 
     SeatFirst SF = new SeatFirst();
     SeatBis SB = new SeatBis();
     SeatEco SE = new SeatEco();
     SeatCheck SC = new SeatCheck();
     PayCalCulate PCC = new PayCalCulate();
     resMember[] member = new resMember[100];               //�ִ��ο� 100��
     pPoint PPO = new pPoint();            // ����
     Ticket Tic = new Ticket();
     CalenderPrint CP = new CalenderPrint();
     ChangeMonth CM = new ChangeMonth();
     DaySetting DS = new DaySetting();
     TimeTable TT = new TimeTable();
     Ticket Tc = new Ticket();
     CheckSeat Cks = new CheckSeat();
    setMoney sm = new setMoney();
    moneyCal mc = new moneyCal();
    Discount dis = new Discount();
   
   

   


      int i=0;          //�̿ϼ� ����, �迭 �� ���� ��         // 0��° ��� ���� - ���� - �ٸ����̵� �α��� - 0��° ��� �α��� - ���� ��ȸ
      int mi=0;         //�̿ϼ� ����, ���ã���
      //member[i] = new resMember(TB.id,TB.pw,TB.mil,PPO.result,TB.name,PCC.seatName);   //member�� i��° �迭Ŭ���� ����.
                                                                  //�����ڷ� �μ��� �޾� i��° Ŭ������ ���κ����� ��ġ
                                                                  //ù ������ ���� �����Ƿ� �ƹ��͵� �ȵ�

   int year = cal.get(Calendar.YEAR);      
     int month = cal.get(Calendar.MONTH)+1;   
     int day;
      int selectNum1;
      int nowYear;
      int nowMonth;
      int nowDay;
     String time;
     int price;
     int money;
     int mileage;//���ǰ�
     char coupon = 'O';
     int usedMileage;
         

      String pPlace;
      String tChoice;            //switch�� ���ú���

      while(true)               //���Ǳ� ���ѹݺ���
      {
        
        System.out.println("[�װ��� �߱Ǳ�]");
        System.out.println("�ȳ��ϼ���.");
        System.out.println("�װ��� �߱Ǳ��Դϴ�.");
        System.out.println();
        TB.memberCheck();         //ȸ������/�α��� Ŭ����
        mi = TB.getmi();          //handler �� memNum ���� ȣ��         --���° ������� ã���ִ� ���� (0��° ȸ������ - 0��° ��� id/pw ��ġ��Ű��                                                       // 1 - 1
        member[mi] = new resMember();

         System.out.println("[�����Ͻ� �׸��� ������ �ּ���]");

         System.out.println();
         System.out.println("1. �װ��� ���� ");
         System.out.println("2. �װ��� ��ȸ ");
         System.out.println("3. �װ��� �ܿ��¼� Ȯ�� ");
         System.out.println("4. ���� ");
         System.out.println();
         System.out.print("�׸� ��ȣ : ");
         int choice = sc.nextInt();
         
         switch(choice)            //�Է°��� ���� ����/��ȸ/�ܿ��¼� Ȯ������ �Ѿ�� ���� switch��
         {
            case 1 :
            //PPO.Pointinput();         //����
            //�޷�, ��¥ ����           //-- ��¥�� Ŭ����
          CP.print(year, month);      //���� �޾Ƽ� �޷����

            nowYear = cal.get(Calendar.YEAR);       //������ �⵵
            nowMonth = cal.get(Calendar.MONTH)+1;         //������ ��
            nowDay = CP.nowd;         //������ ��
            DS.getNowYear(nowYear);     //���� �� �ҷ����� �޼ҵ�
            DS.getNowMonth(nowMonth);   //���� �� �ҷ����� �޼ҵ�
            DS.getNowDay(nowDay);      //���� �� �ҷ����� �޼ҵ�

            DS.getYear(year);         //������ �⵵ �ҷ����� �޼ҵ�(����ڿ��� �Է¹��� �⵵)
            DS.getMonth(month);         //������ �� �ҷ����� �޼ҵ�(����ڿ��� �Է¹��� ��)

            selectNum1 = CM.input();   //�޴� 1234�� �����Ѱ� �Ѱ���
            day = DS.input(selectNum1); //1234�� ������ �޴� ���� �� �Է¹��� ��¥ ��ȯ
         

            System.out.printf("%d�� %d�� %d��",DS.year,DS.month,day);


            PPO.Pointinput();         //����  //��¥�� ������ �ƴ����� �� ��ġ�� �־�� �ؼ� ������.
         time = TT.timetable(year,DS.month,day,PPO.result);
            
            //TT.timetable(DS.nyear, DS.nmonth, day, pPoint.result.charAt(0), pPoint.result.charAt(0));
            //String hh = TT.timetable(DS.year, DS.month, day, PPO.sPoint());
         //System.out.print(hh);

            //��¥�� ���� Ŭ����         
            //�ð� ����                    //-- ��¥�� Ŭ����

         


           int c = SC.Check();            //�¼� ��� �����Ұ����� ���� Ŭ����
            
         //�����

         String seatclass="����";
            switch (c)                     //SC.Check���� ���� �۽�Ʈ, ����Ͻ�, ���ڳ�� ����
            {
            case 1: 
              SF.FirstSeatImpl();    //�¼��� Ŭ����
                  SF.Firstprint();         //�¼��� Ŭ����
                  APP.pay(PPO.result);     //����Ҷ� �����,�������� ����ϱ� ���� PPO.result��� �μ��� ����
                  seatclass="�۽�Ʈ";      //�ٸ� Ŭ������ ������ �ֱ� ���� ���⼭ �¼������ ������ ����
      
              PCC.calPrint("�۽�Ʈ",SF.getSeatName(),APP.getAFC(),APP.getLGC(),year,DS.month,day,time);    //������(�μ� ����:�¼����,�¼���ȣ,�⳻��O/X,��ȭ��O/X)
                  break;
            case 2:   SB.BisSeatImpl();
                  SB.Bisprint();
                  APP.pay(PPO.result);
                  seatclass="����Ͻ�";
                  PCC.calPrint("����Ͻ�",SB.getSeatName(),APP.getAFC(),APP.getLGC(),year,DS.month,day,time);    //������(�μ� ����:�¼����,�¼���ȣ,�⳻��O/X,��ȭ��O/X)
                  break;
            case 3: SE.EcoSeatImpl();
                  SE.Ecoprint();
                  APP.pay(PPO.result);
                  seatclass="���ڳ��";
                  PCC.calPrint("���ڳ��",SE.getSeatName(),APP.getAFC(),APP.getLGC(),year,DS.month,day,time);    //������(�μ� ����:�¼����,�¼���ȣ,�⳻��O/X,��ȭ��O/X)
                  break;
            case 4: break;
            }

         member[mi].setMember(TB.id,TB.pw,TB.mil,PPO.result,TB.name,PCC.seatName,1,seatclass,mi);   //������ �迭
         member[mi].setYMDT(year,DS.month,day,time);
         Tic.YMDSetting(member[mi].year,member[mi].month,member[mi].day,member[mi].time);

            
           //�����
            price = sm.deMoney(member[mi].point);
            mileage = 10000;
            price = sm.levelMoney(member[mi].rClass, price);
            price = dis.discount(price, APP.airFoodCheck, APP.luggageCheck, coupon, year, month, day, time);
            usedMileage = mc.useMileage(price, mileage);   
            member[mi].mil = mileage - usedMileage;
            
            money = mc.getMoney(mileage);
            mc.calMoney(money);
            member[mi].mil = mc.mileageCal(price,money,member[mi].mil);




            System.out.print("Ƽ���� ����Ͻðڽ��ϱ�?(Y/N) :");
            tChoice = sc.next();                     

            if (tChoice.equals("Y") || tChoice.equals("y"))
            {
               Tic.TicketPrint(member[mi].point,member[mi].rName,member[mi].rSeat,member[mi].rClass);      //Ƽ�� ���
            }
            break;


            case 2 :
            if (member[mi].gethasT() == 1)         //����ȸ���� Ƽ���� ������ ������ Ƽ���� ����� �� �ְԲ�.(�迭���� Ȱ���ؼ� �ϼ��ؾ���)
            {
               System.out.print("����� Ƽ���� �ֽ��ϴ�. ����մϱ�?(Y/N) :");
               tChoice = sc.next();
               if (tChoice.equals("Y") || tChoice.equals("y"))
               {
               Tic.TicketPrint(member[mi].point,member[mi].rName,member[mi].rSeat,member[mi].rClass); //��-��,�������̸�,�����¼���ȣ,�����¼����
               }
            }
            else
               System.out.println("����� Ƽ���� �����ϴ�.");
            break;                               //��ƾ ����) ���̵� ����� Ƽ���� �������- ����� Ƽ���� �ֽ��ϴ�. ����մϱ�?
                                       //1-Ƽ�� ���, 0-�ٽ� ó��ȭ������
            case 3 :
            Cks.MkSeatArr();
            Cks.CheckBisprint();
         break;

            case 4 : break;
         }//switch�� ����
       i++;
      }//while�� ����
         
   }
}

/*
1. Ŭ���� �迭 Ȱ���ؼ� �װ��� ��ȸŬ���� ����(ȸ���� ���� Ƽ���� ���������� ��µǰԲ�)
   -�ܿ��¼� Ȯ�� Ŭ���� ����(1�� �ذ��ϸ� �ٷ� �ذ��� �� ����)

2. Ŭ���� �迭 Ȱ���ؼ� ��¥-�ð��� ���� �¼��� �ٲ�� �迭 ����

*/