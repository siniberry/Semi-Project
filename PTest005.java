import java.util.Scanner;

class MemberIDPW
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
   String mYN, mYN1;
   String id,pw,name,num;
   int mil;
   char newCu = 'X';

   void memberCheck()
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
         mil = 1000;
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
         mil = 1000;
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
     System.out.println(idx);
      
      System.out.println("���� �Ϸ�!! \n");
     idx++;
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
     
   

      for (int i = 0; i < idx ; i++ )
      {

         if (members[i].getpid().equals(uid))
         {// members�迭�� �Է��� ���̵� ������
            if (members[i].getppw().equals(pwd))
            {
            msg = "�α��� �Ǿ����ϴ�.";
            System.out.println(msg);
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

class AirPlanePay
{
   static final int airFood =10000;   //�⳻�� 
   static final int luggage =20000;   //��ȭ�� 20Kg�̻��̸� ����
   String destination;
   String YN;
   private boolean airFoodCheck = false;
   private boolean luggageCheck = false;

   void pay(String sa)
   {
      Scanner sc = new Scanner(System.in);
      destination = sa;
      System.out.printf("[%s �����]%n",destination);         // ����
      System.out.println("�⳻�� ���� : "+airFood+"��");
      System.out.println("��ȭ�� ���� : "+luggage+"��");
      
      //=============================(�¼� �ҷ�����(ex)a1, b1,)=====================================
      System.out.println();
      //System.out.printf("%s - �⳻���� �����Ͻðڽ��ϱ�? (Y/N) : ");
      System.out.print("�⳻���� �����Ͻðڽ��ϱ�?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         airFoodCheck = true;
      }
      
      //System.out.printf("%s - ��ȭ���� 20KG �̻��̽ʴϱ�? (Y/N) : ");
      System.out.print("��ȭ���� 20KG �̻��̽ʴϱ�?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         luggageCheck = true;
      }

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

class SeatFirst extends Record   
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

class SeatBis extends Record
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

class SeatEco extends Record
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

class PayCalCulate
{
   char food = 'X';
   char lug = 'X';
   String seatClass;
   String seatName;
   
   void calPrint(String sClass, String sName, boolean acheck, boolean lcheck)
   {
      seatClass = sClass;
      seatName = sName;
      if (acheck == true)
         food = 'O';
      if (lcheck == true)
         lug = 'O';

      int pay=0;
      char coupon = 'X';
      
      System.out.println();
      System.out.println("==========���� ������==========");
      System.out.println("YYYY/MM/DD H:M");                  //��¥�� �޾Ƽ� ���
      System.out.printf("�з� : %s%n",seatClass);               //�з� :���ڳ��, �۽�Ʈ, ����Ͻ�
      System.out.printf("�¼� : %s%n",seatName);               //�¼� :A1, B1, C1
      System.out.printf("�⳻�� : %c%n",food);               // �⳻�� : O, X
      System.out.printf("��ȭ�� 20KG �̻� : %c%n",lug);         // ��ȭ�� : O, X
      System.out.printf(" + %d%n",pay);                     // + ??? ���
      System.out.printf(" ��������(10%%) : %c%n",coupon);         // �������� O      //�̿ϼ�. ��������
      System.out.println("");
   }
}

class SeatCheck
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

class Ticket
{
   String ticketNum;            // Ƽ�Ϲ�ȣ
   String point;               // �༱��
   String name;               // �̸�
   String seat;               // �¼���ȣ
   String sclass;               // �¼����
   int peoCount=1;               // �������
   int roTrip=1;               // �պ�

   
   public Ticket(String po,String pe,String se,String sc)
   {
      point = po;
      name = pe;
      seat = se;
      sclass = sc;
   }

   /*
   void oneRound(int n)         //�պ� �޼ҵ�
   {
      roTrip = n;
   }

   void countPeople(int n)         //�ο� �޼ҵ�
   {
      peoCount = n;
   }
   */

   void TicketPrint()
   {   
      char gate = gateMaking(point);
      String start = startMaking(point);
      String end = endMaking(point);

      //for (int i=0; i<roTrip*peoCount; i++)            //�պ��̸� �ѹ���
      //{
      ticketNum = ""+"YYMMDD"+ gate + point + "HHMM" + seat;

      System.out.println("===========================================");
      System.out.printf("\t     [%s Ŭ����]%n",sclass);
      System.out.printf(" ������ : %s   \tž�±� : %c%n",name,gate);
      System.out.printf("   \t\t\t�¼� : %s",seat);
      System.out.println();
      System.out.printf("   \t%s �� %s%n", start,end);
      System.out.println("\tYYYY/MM/DD H:M ��� �����"); // ��¥�� �޾Ƽ� ���
      System.out.printf(" \t�װ��ǹ�ȣ : %s%n",ticketNum);
      System.out.println("===========================================");
      //}
   }

   char gateMaking(String point)
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

   String startMaking(String point)
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
   String endMaking(String point)
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

class resMember            //������ ���
{
   String ID,PW,point;      //ID,PW,���/������
   int mil,count;         //���ϸ���, �ο���
   String rClass;         //�¼�Ŭ����
   

   resMember(String id, String pw, int mil, String point)
   {
      this.ID = id;
      this.PW = pw;
      this.mil = mil;
      this.point = point;
   }

   void setRClass(String c)
   {
      rClass = c;
   }

   String getRClass()
   {
      return rClass;
   }

}

class pPoint
{
   private String start;
   private String end;
   String result;

   pPoint()
   {
      Scanner sc = new Scanner(System.in);
      do
      {
      System.out.println("�����, �������� �������ּ���");
      System.out.print("����/�λ�/����(���� ����) : ");
      start = sc.next();
      end = sc.next();
      }
      while (start.equals(end));

      result = sPoint();
   }
   
   String sPoint()        //�׽�Ʈ �Ϸ�
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

class airTicketCheck      //�װ��� ��ȸ Ŭ����
{   
   
}


public class PTest006
{
   public static void main(String []args)
   {
      Scanner sc = new Scanner(System.in);
      TicketBooking TB = new TicketBooking();
     AirPlanePay APP = new AirPlanePay(); 
     SeatFirst SF = new SeatFirst();
     SeatBis SB = new SeatBis();
     SeatEco SE = new SeatEco();
     SeatCheck SC = new SeatCheck();
     PayCalCulate PCC = new PayCalCulate();
     resMember[] member = new resMember[100];         // ����
     pPoint [] point = new pPoint[100];            // ����

     int i=0;

      String pPlace;

      while(true)
      {
       System.out.println("[�װ��� �߱Ǳ�]");
         System.out.println("�ȳ��ϼ���.");
         System.out.println("�װ��� �߱Ǳ��Դϴ�.");
       System.out.println();
       TB.memberCheck();

         System.out.println("[�����Ͻ� �׸��� ������ �ּ���]");

         System.out.println();
         System.out.println("1. �װ��� ���� ");
         System.out.println("2. �װ��� ��ȸ ");
         System.out.println("3. �װ��� �ܿ��¼� Ȯ�� ");
         System.out.println("4. ���� ");
         System.out.println();
         System.out.print("�׸� ��ȣ : ");
         int choice = sc.nextInt();
         
         switch(choice)
         {
            case 1 :
            point[i] = new pPoint();               //����
         //�޷�, ��¥ ����
		
		int year;
		int month;
		int day;
		int selectNum1;
		int nowYear;
		int nowMonth;
		int nowDay;

		CalenderPrint CP = new CalenderPrint();
		ChangeMonth CM = new ChangeMonth();
		
		DaySetting DS = new DaySetting();

		year = CP.inputYear();  //����ڷκ��� �Է¹��� �⵵
		month =	CP.inputMonth(); //����ڷκ��� �Է¹��� ��
		CP.print(year, month);   // �� �� �޾Ƽ� �޷����

		nowYear = CP.nowy;      //������ �⵵
		nowMonth = CP.nowm;     //������ ��
		nowDay = CP.nowd;       //������ ��
		DS.getNowYear(nowYear);  //���� �� �ҷ����� �޼ҵ�
		DS.getNowMonth(nowMonth); //���� �� �ҷ����� �޼ҵ�
		DS.getNowDay(nowDay);    //���� �� �ҷ����� �޼ҵ�

		DS.getYear(year);        //������ �⵵ �ҷ����� �޼ҵ�(����ڿ��� �Է¹��� �⵵)
		DS.getMonth(month);     //������ �� �ҷ����� �޼ҵ�(����ڿ��� �Է¹��� ��)

		selectNum1 = CM.input(); //�޴� 1234�� �����Ѱ� �Ѱ���
		day = DS.input(selectNum1); // 1234�� ������ �޴� ���� �� �Է¹��� ��¥ ��ȯ
		



         //�ð� ����
         //�ο� ����
         int c = SC.Check();
         String seatclass="����";
         switch (c)
         {
         case 1:   SF.FirstSeatImpl();
               SF.Firstprint();
               APP.pay(point[i].result);
               seatclass="�۽�Ʈ";
               PCC.calPrint("�۽�Ʈ",SF.getSeatName(),APP.getAFC(),APP.getLGC());
               break;
         case 2:   SB.BisSeatImpl();
               SB.Bisprint();
               APP.pay(point[i].result);
               seatclass="����Ͻ�";
               PCC.calPrint("����Ͻ�",SB.getSeatName(),APP.getAFC(),APP.getLGC());
               break;
         case 3: SE.EcoSeatImpl();
               SE.Ecoprint();
               APP.pay(point[i].result);
               seatclass="���ڳ��";
               PCC.calPrint("���ڳ��",SE.getSeatName(),APP.getAFC(),APP.getLGC());
               break;
         case 4: return;
         }
         Ticket Tic = new Ticket(point[i].result,TB.name,PCC.seatName,seatclass);
         System.out.print("Ƽ���� ����Ͻðڽ��ϱ�?(Y/N) :");
         String tchoice = sc.next();
         if (tchoice.equals("Y") || tchoice.equals("y"))
         {
            Tic.TicketPrint();
         }

         member[i] = new resMember(TB.id,TB.pw,TB.mil,point[i].result);   //������ �迭

            break;
            case 2 : break;
            case 3 : break;
            case 4 : return;
         }
       i++;
         
      }
         
   }
}

/*
�߰�. �װ��� ���� - ���ο�����, �պ�

1. �װ��� ��ȸ Ŭ���� ����(���/����)

2. �װ��� ��¥�� �ð��� ���� �¼����

3. �װ��� �ܿ��¼� Ȯ�� Ŭ����



*/