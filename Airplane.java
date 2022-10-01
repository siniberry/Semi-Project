class PeopleInfo // 탑승객
{
  String pName; // 이름
  String pNum; // 앞의 두 숫자로 나이 연산(앞의 두 숫자 잘라서 쓰기)
  boolean pBooking; // 예약여부
  boolean pCouBooking; // 쿠폰 보유여부
  int pMil; // 마일리지
  String pId; //탑승객 id
  String pPw; //탑승객 pw
}

/*
class Dummy // 더미 탑승객
{
PeopleInfo ps1 = new PeopleInfo();
PeopleInfo ps2 = new PeopleInfo();
PeopleInfo ps3 = new PeopleInfo();

ps1.pName = "오이삭"
ps1.pNum = "670615-1442670"

ps1.pBooking =
ps1.pCouBooking =
ps1.pMil = 500
ps1.pId =
ps1.pPw =

ps2.pName = "우수정"
ps2.pNum = "791228-2175265"

ps2.pBooking =
ps2.pCouBooking =
ps2.pMil = 500
ps2.pId =
ps2.pPw =


ps3.pName = "김갑환"
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
   System.out.println("[ 항공권 예약(ctrl+z입력시 뒤로가기) ]");
   memberCheck
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("계정이 있으십니까?(Y/N) : ");
      mYN = sc.next();
      
      if (mYN == "Y")
      {
         memberLogin   // 로그인 클래스
         {
         }
      }
      else
      {
         System.out.println("신규 회원가입을 하시겠습니까?(Y/N)");
         System.out.println("(신규회원가입시 쿠폰+랜덤 마일리지 지급)");
         System.out.print(": ");
         mYN = sc.next();
         if (mYN == "Y")
         {
            //회원가입 클래스
         }
         else
         {
            //비회원로그인 클래스
         }

      }
   }
   
   static int WP()   //왕복/편도
   {
      Scanner sc = new Scanner(System.in);
      System.out.println(" \t 1. 편도 ");
      System.out.println(" \t 2. 왕복 ");
      System.out.println();
      System.out.println();

         System.out.print("항목 번호를 입력해주세요 :");
         int n = sc.nextInt();

         if (n == 1)
            return 1;
         else if(n == 2)
            return 2;
         else 
            return 0;
   }



   static char sPoint()         //테스트 완료
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("출발지를 입력해주세요 : ");
      String input = sc.next();
      char result = 'E';
   
      if (input.equals("서울"))
         result = 'S';
      else if(input.equals("부산"))
         result = 'B';
      else if(input.equals("제주"))
         result = 'J';
      
      System.out.println(input);
      return result;
      
      
   }

   static char aPoint()         // 테스트 완료
   {
      Scanner sc = new Scanner(System.in);

      System.out.print("출발지를 입력해주세요 : ");
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

class MemberLogin      //로그인 클래스
{
   //Test179참조해서 Hashtable로 id/pw 검사
}

class MemberSignUp      //회원가입 클래스
{
	Scanner sc = new Scanner(System.in);

	System.out.println("\t [ 회원가입 ] ");

	System.out.print("이름 : ");
	PeopleInfo.pName = sc.next();

	System.out.print("주민등록번호 : ");
	PeopleInfo.pNum = sc.next();

	System.out.print("ID");
	PeopleInfo.pId = sc.next();

	System.out.print("PW");
	PeopleInfo.pPw = sc.next();


}
class nMemberLogin      //비회원 로그인 클래스
{

	static String getPName()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t [ 비회원 예매 ]");


		System.out.println("이름 : ");
		PeopleInfo.pName = sc.next();
		return PeopleInfo.pName;
	}

	/*
	static String getPNum()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("주민등록번호 : ");
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

			System.out.println("주민등록번호 : ");
			String isPNum = sc.next();

			int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
			
			arr1 = new int[14];
			
			arrS = new int[13];
			
			
			
			//System.out.print("주민등록번호 : \n");

			for (int i=0;i<13 ;i++ )
			{
				//System.out.printf("%d 번째 숫자를 입력하세요", i);
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
				System.out.print( "\n감사합니다.\n ");

			}
			else
			{
				System.out.print( "\n 잘못된 주민번호입니다. 주민번호를 재입력해주세요.\n ");
			}


		}
		//while (!arr1[12].equals(resultPN));
		while (arr1[12]!=resultPN);



	}
	
}


/*

  String pName; // 이름
  String pNum; // 앞의 두 숫자로 나이 연산(앞의 두 숫자 잘라서 쓰기)
  boolean pBooking; // 예약여부
  boolean pCouBooking; // 쿠폰 보유여부
  int pMil; // 마일리지
  String pId; //탑승객 id
  String pPw; //탑승객 pw
  */


public class Airplane
{
   public static void main(String []args)
   {
     





   }
}

/* 왕복/편도 예약
*날짜 = a
*시간 = b

*인원수(p) = 2
*1번째 탑승객 자리 = c1
*2번째 ~ =c2
{
 n= 왕복(2),편도(1)
static int nP = 1; //클래스 최상단 

 rd  = new Record[p];
    for(int i=0;i<p*n;i++) // n= 왕복(2),편도(1)
   {
    rd[nP] = new Record(); 
     예약권[nP].예약날짜 = a
     예약권[nP].예약시간 = b
      System.out.print(“i번째 승객의 좌석을 입력해주세요”);
        예약권[nP].좌석번호 = sc.next()
      nP++;
    }

  }

}
*/