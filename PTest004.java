import java.util.Scanner;

class PeopleInfo // 탑승객 회원
{
   private boolean pBooking;         // 예약여부
   private boolean pCouBooking = false; // 쿠폰 보유여부
   private int pMil;               // 마일리지
   private String pPoint;            // 출발지/도착지
   private String pName;            // 이름
   private String pNum;               // 주민등록번호

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
   private String pName;         // 이름
   private String pNum;         // 주민등록번호
   private String pid;            // 탑승객 id
   private String ppw;            // 탑승객 pw

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

class NonMemberInfo                  //비회원 예약정보
{
   private String pName;            // 이름
   private String pNum;               // 주민등록번호

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
    boolean isRun= true; // 반복 flag
       String strColumn; // 행 이름
      char inputColumn;
       int rowNum; // 열 번호
}

class TicketBooking
{
   pHandler handler = new pHandler(100);
   String mYN;
   void memberCheck()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("계정이 있으십니까?(Y/N) : ");
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
         System.out.println("신규 회원가입을 하시겠습니까?(Y/N)");
         System.out.println("(신규회원가입시 쿠폰+랜덤 마일리지 지급)");
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
   
   String WP()   // 행선지 선택
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("1. 편도 ");
      System.out.println("2. 왕복 ");
      System.out.println();

      System.out.print("항목 번호를 입력해주세요 :");
      int n = sc.nextInt();
         
      if (n == 1)
         return ""+ sPoint() + aPoint();      // SB
      if (n == 2)
         return ""+ sPoint() + aPoint() + sPoint() + aPoint();      //SBBS
      else 
         return "Error";
   }



   static char sPoint()         //테스트 완료
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("출발지를 입력해주세요(서울, 제주, 부산) : ");
      String input = sc.next();
      char result = 'E';
   
      if (input.equals("서울"))
         result = 'S';
      else if(input.equals("부산"))
         result = 'B';
      else if(input.equals("제주"))
         result = 'J';
   
      return result;
      
      
   }

   static char aPoint()         // 테스트 완료
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("도착지를 입력해주세요(서울, 제주, 부산) : ");
      String input = sc.next();
      char result = 'E';
   
      if (input.equals("서울"))
         result = 'S';
      else if(input.equals("부산"))
         result = 'B';
      else if(input.equals("제주"))
         result = 'J';

      return result;
      
   }
}

class pHandler   // 로그인 / 회원가입
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

   public void MemberInsert()  //회원가입
   { 
      
      Scanner sc = new Scanner(System.in);
      System.out.print("아이디 : "); 
      uid = sc.next();

      if (!isUniqueID(uid)) // 중복ID
      {
         System.out.println("이미 사용중인 아이디 입니다. \n");
         return;
      }

      System.out.print("비밀번호 : "); 
      pwd = sc.next();

      System.out.print("이름 : "); 
      name = sc.next();
      
      do
      {
         System.out.print("주민등록번호(13자리('-'제외)) : ");
         num = sc.next();
         PNAn = isPNA(num);
      }
      while (PNAn.equals("Error"));
      

      members[idx] = new MemberIDPW(uid, pwd, name, num);

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

   public void memberLoginEx()
   { // 회원로그인용 메소드
      Scanner sc = new Scanner(System.in);
      String replay = "yes";

      while(replay.equals("no"))
      {
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
               replay = "no";
            }
            else if (!members[i].getpid().equals(uid))
            {
               System.out.println("존재하지 않는 아이디입니다. \n");
               replay = "yes";
            }
            else if (members[i].getpid().equals(uid) && !members[i].getppw().equals(pwd))
            {
               System.out.println("암호가 잘못되었습니다. \n");
               replay = "yes";
            }
      
         }
      }
      // System.out.println("아이디와 비밀번호를 확인해주세요.");

      /*
      로그인 성공시 : "로그인 되었습니다." 메세지 출력
      로그인 실패시 : "존재하지 않는 아이디 입니다." or "암호가 잘못되었습니다." 중 하나를 출력
      */
   }

   public String memberLogin()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("아이디 : "); 
      String uid = sc.next();
      String mblg = "a";

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
            return mblg = "a";

            } 
         else
         {
            msg = "암호가 잘못되었습니다.";
            return mblg = "b";

            }
         }
      }
      System.out.println(msg);
      return mblg = "b";
   }

   
   public void nMemberInsert()   //비회원 이름 입력
   {
      String name, num, PNAn;
      Scanner sc = new Scanner(System.in);
      System.out.print("이름 : "); 
      name = sc.next();
      do
      {
      System.out.print("주민등록번호(13자리('-'제외)) : ");
      num = sc.next();
      PNAn = isPNA(num);
      }
      while (PNAn.equals("Error"));
      
      nonmembers[nidx] = new NonMemberInfo(name,num);
      System.out.println("비회원 예약입니다.");
      nidx++;
      /*
      Scanner sc = new Scanner(System.in);
      System.out.println("[비회원 로그인]");
      System.out.print("이름 : ");
      String nm = sc.next();
      nm = 
     System.out.print
     */

   }
   
   static String isPNA(String pnum)   //비회원 주민등록번호 유효성검사
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
         System.out.print("주민등록번호 : ");
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
            System.out.println("유효한 주민등록번호입니다.");
            return result;
         }
          else
         {
            System.out.println("잘못된 주민등록번호입니다.");
            return "Error";
         }
       }
       while (arr1[12]!=resultPN && result.length() !=13);
   }
}

class AirPlanePay
{
   static final int airFood =10000;   //기내식 
   static final int luggage =20000;   //수화물 20Kg이상이면 결제
   String destination;
   String YN;
   boolean airFoodcheck = false;
   boolean luggagecheck = false;

   void pay(String sa)
   {
      if (sa.equals("SB"))
         destination = "서울-부산행";
      else if (sa.equals("BS"))
         destination = "부산-서울행";
      else if (sa.equals("SJ"))
         destination = "서울-제주행";
      else if (sa.equals("JS"))
         destination = "제주-서울행";
      else if (sa.equals("BJ"))
         destination = "부산-제주행";
      else if (sa.equals("JB"))
         destination = "제주-부산행";
      else
         return;

      Scanner sc = new Scanner(System.in);

      System.out.printf("[%s 비행기]%n",destination);
      System.out.println("기내식 가격 : "+airFood+"원");
      System.out.println("수화물 가격 : "+luggage+"원");
      
      //=============================(좌석 불러오기(ex)a1, b1,)=====================================
      System.out.println();
      //System.out.printf("%s - 기내식을 선택하시겠습니까? (Y/N) : ");
      System.out.print("기내식을 선택하시겠습니까?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         airFoodcheck = true;
      }
      
      //System.out.printf("%s - 수화물이 20KG 이상이십니까? (Y/N) : ");
      System.out.print("수화물이 20KG 이상이십니까?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         luggagecheck = true;
      }

   }

}

class SeatFirst extends Record   
{
   void FirstSeatImpl()      //-- 좌석 조회
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

   void  Firstprint()   //-- 좌석 예약
   {
      Scanner sc = new Scanner(System.in);
      
      do
      {
         System.out.print("[\t취소하려면 '취소'를 입력하세요      ]");
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
       System.out.println("[항공기 발권기]");
         System.out.println("안녕하세요.");
         System.out.println("항공기 발권기입니다.");
       System.out.println();
       TB.memberCheck();

         System.out.println("[항공기 발권기]");
         System.out.println("안녕하세요.");
         System.out.println("항공기 발권기입니다.");

         System.out.println();
         System.out.println("1. 항공권 예약 ");
         System.out.println("2. 항공권 조회 ");
         System.out.println("3. 항공권 잔여좌석 확인 ");
         System.out.println("4. 종료 ");
         System.out.println();
         System.out.print("항목 번호를 입력해주세요 : ");
         int choice = sc.nextInt();
         
         switch(choice)
         {
            case 1 :
            test = TB.WP();
         //달력, 날짜 선택
         //시간 선택
         //인원 선택
         SF.FirstSeatImpl();
         SF.Firstprint();
         //좌석 보기, 좌석 선택
         //좌석번호 입력받기
         APP.pay(test);
         
         
         

            break;
            case 2 : break;
            case 3 : break;
            case 4 : return;
         }
         
      }
         
   }
}