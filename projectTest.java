
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Enumeration;

class PeopleInfo // 탑승객
{
   private String pName; // 이름
   private String pNum; // 주민등록번호
   private boolean pBooking; // 예약여부
   private boolean pCouBooking; // 쿠폰 보유여부
   private int pMil; // 마일리지
   private String pid; //탑승객 id
   private String ppw; //탑승객 pw

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

   public void memberInsert()  //회원가입
   { 
      String uid, pwd, name, num;
      Scanner sc = new Scanner(System.in);
      System.out.print("아이디 : "); uid = sc.next();

      if (!isUniqueID(uid)) // 중복ID
      {
         System.out.println("이미 사용중인 아이디 입니다. \n");
         return;
      }

      System.out.print("암 호 : "); 
      pwd = sc.next();

      System.out.print("이 름 : "); 
      name = sc.next();

      System.out.print("주민등록번호 : ");
      num = sc.next();

      members[idx] = new PeopleInfo(uid, pwd, name, num);
      idx++;
      System.out.println("가입 완료!! \n");
   }

   private boolean isUniqueID(String uid) // 아이디의 중복 여부
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

   public void memberLoginEx(){ // 회원로그인용 메소드
      Scanner sc = new Scanner(System.in);
      System.out.print("아이디 : "); 
      String uid = sc.nextLine();

      System.out.print("패스워드 : "); 
      String pwd = sc.nextLine();

      for (int i = 0 ; i < idx ; i++)
      {
         if (members[i].getpid().equals(uid) && members[i].getppw().equals(pwd))
         {
            System.out.println("환영합니다.");
            System.out.println("로그인에 성공하였습니다. \n");
            return;

         }else if (!members[i].getpid().equals(uid))
         {
            System.out.println("존재하지 않는 아이디입니다. \n");
            return;
         }
         else if (members[i].getpid().equals(uid) && !members[i].getppw().equals(pwd))
         {
            System.out.println("암호가 잘못되었습니다. \n");
            return;
         }
      }
      // System.out.println("아이디와 비밀번호를 확인해주세요.");

      /*
      로그인 성공시 : "로그인 되었습니다." 메세지 출력
      로그인 실패시 : "존재하지 않는 아이디 입니다." or "암호가 잘못되었습니다." 중 하나를 출력
      */
   }

   public void memberLogin(){
      Scanner sc = new Scanner(System.in);
      System.out.print("아이디 : "); 
      String uid = sc.next();

      System.out.print("패스워드 : "); 
      String pwd = sc.next();

      String msg = "존재하지 않는 아이디 입니다.";

      for (int i = 0 ; i < idx ; i++ )
      {
         if (members[i].getpid().equals(uid))
         {// members배열에 입력한 아이디가 있으면
            if (members[i].getppw().equals(pwd))
            {
               msg = "로그인 되었습니다.";
            } else{
               msg = "암호가 잘못되었습니다.";
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
         System.out.println("[항공권 예약]");
         System.out.println("1. 회원가입");
         System.out.println("2. 로 그 인");
         System.out.println("9. 종료");

         Scanner sc = new Scanner(System.in);
         int choice = sc.nextInt();

         switch (choice)
         {
         case 1:
            handler.memberInsert(); break;
         case 2:
            handler.memberLogin(); break;
         case 9:
            System.out.println("종료");
            return;
         }

      }

      
      
   }
}