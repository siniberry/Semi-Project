import java.util.Scanner;

class MemberIDPW
{
   private String pName;         // 이름
   private String pNum;         // 주민등록번호
   private String pid;            // 탑승객 id
   private String ppw;            // 탑승객 pw

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
   String mYN, mYN1;
   String id,pw,name,num;
   int mil;
   char newCu = 'X';

   void memberCheck()
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("계정이 있으십니까?(Y/N) : ");
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
             System.out.print("계정이 있으십니까?(Y/N) : ");
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
         System.out.println("신규 회원가입을 하시겠습니까?(Y/N)");
         System.out.println("(신규회원가입시 쿠폰+랜덤 마일리지 지급)");
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
          System.out.println("신규 회원가입을 하시겠습니까?(Y/N)");
          System.out.println("(신규회원가입시 쿠폰+랜덤 마일리지 지급)");
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
     System.out.println(idx);
      
      System.out.println("가입 완료!! \n");
     idx++;
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
     
   

      for (int i = 0; i < idx ; i++ )
      {

         if (members[i].getpid().equals(uid))
         {// members배열에 입력한 아이디가 있으면
            if (members[i].getppw().equals(pwd))
            {
            msg = "로그인 되었습니다.";
            System.out.println(msg);
            return mblg = "a";

            } 
         else
         {
            msg = "암호가 잘못되었습니다.";
            System.out.println(msg);
            return mblg = "b";
            

            }
         }
      }
      System.out.println(msg);
      return mblg = "b";
     //return mblg = "a";
   }

   
   public void nMemberInsert()   //비회원 이름 입력
   {
      String PNAn;
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
   
   static String isPNA(String pnum)   //주민등록번호 유효성검사
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
   private boolean airFoodCheck = false;
   private boolean luggageCheck = false;

   void pay(String sa)
   {
      Scanner sc = new Scanner(System.in);
      destination = sa;
      System.out.printf("[%s 비행기]%n",destination);         // 수정
      System.out.println("기내식 가격 : "+airFood+"원");
      System.out.println("수화물 가격 : "+luggage+"원");
      
      //=============================(좌석 불러오기(ex)a1, b1,)=====================================
      System.out.println();
      //System.out.printf("%s - 기내식을 선택하시겠습니까? (Y/N) : ");
      System.out.print("기내식을 선택하시겠습니까?(Y/N) : ");
      YN = sc.next();
      if (YN.equals("Y") || YN.equals("y"))
      {
         airFoodCheck = true;
      }
      
      //System.out.printf("%s - 수화물이 20KG 이상이십니까? (Y/N) : ");
      System.out.print("수화물이 20KG 이상이십니까?(Y/N) : ");
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
   private String SeatName;               // 좌석번호를 return 시키기 위해서

   void setSeatName(String name) {this.SeatName = name;}
   String getSeatName(){return SeatName;}

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
         SeatName = "" + inputColumn + rowNum;
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

class SeatBis extends Record
{
   private String SeatName;
   void setSeatName(String name) {this.SeatName = name;}
   String getSeatName() {return SeatName;}

   void BisSeatImpl()   //-- 좌석 조회
   {
      System.out.println();
      System.out.println("───────────────────비즈니스 클래스────────────────────────");
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

   void  Bisprint() //-- 좌석 예약
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
         SeatName = "" + inputColumn + rowNum;
         System.out.print("예약 완료 하시겠습니까 ? (Y / N) : ");
         String s = sc.next();

         if((seats[column][rowNum-1]== 0))
            {
               if(s.equals("y") || s.equals("Y")) 
               {
                  seats[column][rowNum-1] = 1;
                  System.out.println("예약이 완료되었습니다");
                  // -- 항공권 번호 출력 ();
                  BisSeatImpl();
                  System.out.println();
               }
                  
               else 
               {
                  System.out.println("취소되었습니다");
                  BisSeatImpl();
               }
            }
         else
            {
               System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
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

   void EcoSeatImpl()   //-- 좌석 조회
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

   void  Ecoprint()//-- 좌석 예약
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
      SeatName = "" + inputColumn + rowNum;
        System.out.print("예약 완료 하시겠습니까 ? (Y / N) : ");
        String s = sc.next();

         if((seats[column][rowNum-1]== 0))
      {
         if(s.equals("y") || s.equals("Y")) 
         {
            seats[column][rowNum-1] = 1;
            System.out.println("예약이 완료되었습니다");
            // -- 항공권 번호 출력 ();
            EcoSeatImpl();
            System.out.println();
         }
                  
         else       
         {
            System.out.println("취소되었습니다");
            EcoSeatImpl();
         }
      }
      else
      {
         System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
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
      System.out.println("==========결제 영수증==========");
      System.out.println("YYYY/MM/DD H:M");                  //날짜팀 받아서 출력
      System.out.printf("분류 : %s%n",seatClass);               //분류 :이코노미, 퍼스트, 비즈니스
      System.out.printf("좌석 : %s%n",seatName);               //좌석 :A1, B1, C1
      System.out.printf("기내식 : %c%n",food);               // 기내식 : O, X
      System.out.printf("수화물 20KG 이상 : %c%n",lug);         // 수화물 : O, X
      System.out.printf(" + %d%n",pay);                     // + ??? 요금
      System.out.printf(" 할인쿠폰(10%%) : %c%n",coupon);         // 할인쿠폰 O      //미완성. 만들어야함
      System.out.println("");
   }
}

class SeatCheck
{
   int Check()
   {
      int n = 4;
      Scanner sc = new Scanner(System.in);
      System.out.println("좌석등급을 선택해주세요.");
      System.out.println("1. 퍼스트 클래스 ");
        System.out.println("2. 비즈니스 클래스 ");
        System.out.println("3. 이코노미 클래스 ");
      System.out.println("4. 종료 ");

      System.out.print("항목 번호를 입력해주세요 : ");
        n = sc.nextInt();

      return n;
   }
}

class Ticket
{
   String ticketNum;            // 티켓번호
   String point;               // 행선지
   String name;               // 이름
   String seat;               // 좌석번호
   String sclass;               // 좌석등급
   int peoCount=1;               // 몇명인지
   int roTrip=1;               // 왕복

   
   public Ticket(String po,String pe,String se,String sc)
   {
      point = po;
      name = pe;
      seat = se;
      sclass = sc;
   }

   /*
   void oneRound(int n)         //왕복 메소드
   {
      roTrip = n;
   }

   void countPeople(int n)         //인원 메소드
   {
      peoCount = n;
   }
   */

   void TicketPrint()
   {   
      char gate = gateMaking(point);
      String start = startMaking(point);
      String end = endMaking(point);

      //for (int i=0; i<roTrip*peoCount; i++)            //왕복이면 한번더
      //{
      ticketNum = ""+"YYMMDD"+ gate + point + "HHMM" + seat;

      System.out.println("===========================================");
      System.out.printf("\t     [%s 클래스]%n",sclass);
      System.out.printf(" 예약자 : %s   \t탑승구 : %c%n",name,gate);
      System.out.printf("   \t\t\t좌석 : %s",seat);
      System.out.println();
      System.out.printf("   \t%s → %s%n", start,end);
      System.out.println("\tYYYY/MM/DD H:M 출발 비행기"); // 날짜팀 받아서 출력
      System.out.printf(" \t항공권번호 : %s%n",ticketNum);
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
         return "서울";
      else if (result == 'P')
         return "부산";
      else if (result == 'J')
         return "제주";
      else
         return "에러";
   }
   String endMaking(String point)
   {
      char result = point.charAt(1);
      if (result == 'S')
         return "서울";
      else if (result == 'P')
         return "부산";
      else if (result == 'J')
         return "제주";
      else
         return "에러";
   }

   String getTicketNum()
   {
      return ticketNum;
   }
}

class resMember            //예약한 경우
{
   String ID,PW,point;      //ID,PW,출발/도착지
   int mil,count;         //마일리지, 인원수
   String rClass;         //좌석클래스
   

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
      System.out.println("출발지, 도착지를 선택해주세요");
      System.out.print("서울/부산/제주(공백 구분) : ");
      start = sc.next();
      end = sc.next();
      }
      while (start.equals(end));

      result = sPoint();
   }
   
   String sPoint()        //테스트 완료
   {

      Scanner sc = new Scanner(System.in);
      String result;
      String result1="";
      String result2="";

      if (start.equals("서울"))
         result1= "S";
      else if(start.equals("부산"))
         result1= "P";
      else if(start.equals("제주"))
         result1= "J";
      else
         result1= "E";
      
      if (end.equals("서울"))
         result2= "S";
      else if(end.equals("부산"))
         result2= "P";
      else if(end.equals("제주"))
         result2= "J";
      else 
         result2= "E";
      result = result1 + result2;
      return result;
   }
}

class airTicketCheck      //항공권 조회 클래스
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
     resMember[] member = new resMember[100];         // 수정
     pPoint [] point = new pPoint[100];            // 수정

     int i=0;

      String pPlace;

      while(true)
      {
       System.out.println("[항공기 발권기]");
         System.out.println("안녕하세요.");
         System.out.println("항공기 발권기입니다.");
       System.out.println();
       TB.memberCheck();

         System.out.println("[진행하실 항목을 선택해 주세요]");

         System.out.println();
         System.out.println("1. 항공권 예약 ");
         System.out.println("2. 항공권 조회 ");
         System.out.println("3. 항공권 잔여좌석 확인 ");
         System.out.println("4. 종료 ");
         System.out.println();
         System.out.print("항목 번호 : ");
         int choice = sc.nextInt();
         
         switch(choice)
         {
            case 1 :
            point[i] = new pPoint();               //수정
         //달력, 날짜 선택
		
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

		year = CP.inputYear();  //사용자로부터 입력받은 년도
		month =	CP.inputMonth(); //사용자로부터 입력받은 월
		CP.print(year, month);   // 연 월 받아서 달력출력

		nowYear = CP.nowy;      //현재의 년도
		nowMonth = CP.nowm;     //현재의 월
		nowDay = CP.nowd;       //현재의 일
		DS.getNowYear(nowYear);  //현재 년 불러오는 메소드
		DS.getNowMonth(nowMonth); //현재 월 불러오는 메소드
		DS.getNowDay(nowDay);    //현재 일 불러오는 메소드

		DS.getYear(year);        //예매할 년도 불러오는 메소드(사용자에게 입력받은 년도)
		DS.getMonth(month);     //예매할 달 불러오는 메소드(사용자에게 입력받은 달)

		selectNum1 = CM.input(); //메뉴 1234중 선택한값 넘겨줌
		day = DS.input(selectNum1); // 1234중 선택한 메뉴 실행 후 입력받은 날짜 반환
		



         //시간 선택
         //인원 선택
         int c = SC.Check();
         String seatclass="에러";
         switch (c)
         {
         case 1:   SF.FirstSeatImpl();
               SF.Firstprint();
               APP.pay(point[i].result);
               seatclass="퍼스트";
               PCC.calPrint("퍼스트",SF.getSeatName(),APP.getAFC(),APP.getLGC());
               break;
         case 2:   SB.BisSeatImpl();
               SB.Bisprint();
               APP.pay(point[i].result);
               seatclass="비즈니스";
               PCC.calPrint("비즈니스",SB.getSeatName(),APP.getAFC(),APP.getLGC());
               break;
         case 3: SE.EcoSeatImpl();
               SE.Ecoprint();
               APP.pay(point[i].result);
               seatclass="이코노미";
               PCC.calPrint("이코노미",SE.getSeatName(),APP.getAFC(),APP.getLGC());
               break;
         case 4: return;
         }
         Ticket Tic = new Ticket(point[i].result,TB.name,PCC.seatName,seatclass);
         System.out.print("티켓을 출력하시겠습니까?(Y/N) :");
         String tchoice = sc.next();
         if (tchoice.equals("Y") || tchoice.equals("y"))
         {
            Tic.TicketPrint();
         }

         member[i] = new resMember(TB.id,TB.pw,TB.mil,point[i].result);   //예약멤버 배열

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
추가. 항공권 예약 - ★인원선택, 왕복

1. 항공권 조회 클래스 제작(취소/변경)

2. 항공권 날짜와 시간에 따른 좌석출력

3. 항공권 잔여좌석 확인 클래스



*/