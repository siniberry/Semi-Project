
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Enumeration;

class PeopleInfo // ž�°�
{
   private String pName; // �̸�
   private String pNum; // �ֹε�Ϲ�ȣ
   private boolean pBooking; // ���࿩��
   private boolean pCouBooking; // ���� ��������
   private int pMil; // ���ϸ���
   private String pid; //ž�°� id
   private String ppw; //ž�°� pw

   public PeopleInfo(String pid, String ppw, String pName, String pNum, boolean pBooking, boolean pCouBooking, int pMil)
   {
      this.pid = pid;
      this.ppw = ppw;
      this.pName = pName;
      this.pNum = pNum;
      this.pBooking = pBooking;
      this.pCouBooking = pCouBooking;
      this.pMil = pMil;
    }
   public PeopleInfo(String pid, String ppw)
   {
      this.pid = pid;
      this.ppw = ppw;
   }
   public PeopleInfo(String pid, String ppw, String pName, String pNum)
   {
      this.pid = pid;
      this.ppw = ppw;
      this.pName = pName;
      this.pNum = pNum;
   }

   public String getpName(){ return pName; }
   public String getpNum(){ return pNum; }
   public String getpid(){ return pid; }
   public String getppw(){ return ppw; }
   public int getpMil(){ return pMil; }
   public boolean getpBooking(){ return pBooking; }
   public boolean getpCouBooking(){ return pCouBooking; }
   public void setpName(String pName){ this.pName = pName; }
   public void setpNum(String pNum){ this.pNum = pNum; }
   public void setpid(String pid){ this.pid = pid; }
   public void setpwd(String ppw){ this.ppw = ppw; }
   public void setpMil(int pMil){ this.pMil = pMil; }
   public void setpBooking(boolean pBooking){ this.pBooking = pBooking; }
   public void setName(boolean pCouBooking){ this.pCouBooking = pCouBooking; }
 

}
class pHandler
{
   private PeopleInfo[] members;
   private int idx;

   public pHandler(int num)
   {
      members = new PeopleInfo[num];
      idx = 0;
   }

   public void memberInsert()  //ȸ������
   { 
      String uid, pwd, name, num;
      Scanner sc = new Scanner(System.in);
      System.out.print("���̵� : "); uid = sc.next();

      if (!isUniqueID(uid)) // �ߺ�ID
      {
         System.out.println("�̹� ������� ���̵� �Դϴ�. \n");
         return;
      }

      System.out.print("�� ȣ : "); 
      pwd = sc.next();

      System.out.print("�� �� : "); 
      name = sc.next();

      System.out.print("�ֹε�Ϲ�ȣ : ");
      num = sc.next();

      members[idx] = new PeopleInfo(uid, pwd, name, num);
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

   public void memberLoginEx(){ // ȸ���α��ο� �޼ҵ�
      Scanner sc = new Scanner(System.in);
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
            return;

         }else if (!members[i].getpid().equals(uid))
         {
            System.out.println("�������� �ʴ� ���̵��Դϴ�. \n");
            return;
         }
         else if (members[i].getpid().equals(uid) && !members[i].getppw().equals(pwd))
         {
            System.out.println("��ȣ�� �߸��Ǿ����ϴ�. \n");
            return;
         }
      }
      // System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");

      /*
      �α��� ������ : "�α��� �Ǿ����ϴ�." �޼��� ���
      �α��� ���н� : "�������� �ʴ� ���̵� �Դϴ�." or "��ȣ�� �߸��Ǿ����ϴ�." �� �ϳ��� ���
      */
   }

   public void memberLogin(){
      Scanner sc = new Scanner(System.in);
      System.out.print("���̵� : "); 
      String uid = sc.next();

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
            } else{
               msg = "��ȣ�� �߸��Ǿ����ϴ�.";
            }
         }
      }
      System.out.println(msg);
   }
}


   


public class projectTest
{   
   public static void main(String []args)
   {
      pHandler handler = new pHandler(100);

      while (true)
      {
         System.out.println("[�װ��� ����]");
         System.out.println("1. ȸ������");
         System.out.println("2. �� �� ��");
         System.out.println("9. ����");

         Scanner sc = new Scanner(System.in);
         int choice = sc.nextInt();

         switch (choice)
         {
         case 1:
            handler.memberInsert(); break;
         case 2:
            handler.memberLogin(); break;
         case 9:
            System.out.println("����");
            return;
         }

      }

      
      
   }
}