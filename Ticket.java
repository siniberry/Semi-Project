class Ticket                     //티켓 제작, 출력 클래스
{
   String ticketNum;            // 티켓번호
   String point;               // 행선지
   String name;               // 이름
   String seat;               // 좌석번호
   String sclass;               // 좌석등급

   int year;
   int month;
   int day;

   void TicketPrint(String po,String pe,String se,String sc, int yr, int mth, int dy, String tm)      //출력메소드
   {   
      point = po;
      name = pe;
      seat = se;
      sclass = sc;

	  year = yr;
	  month = mth;
	  day = dy;
	  

      char gate = gateMaking(point);
      String start = startMaking(point);
      String end = endMaking(point);
	  String ymd = ymdMaking(year, month, day);
	  String hm = hmMaking(tm);

      ticketNum = ymd + gate + point + tm + seat;

      System.out.println("===========================================");
      System.out.printf("\t     [%s 클래스]%n",sclass);
      System.out.printf(" 예약자 : %s   \t\t탑승구 : %c%n",name,gate);
      System.out.printf("   \t\t\t좌석 : %s\n",seat);
      System.out.println();
      System.out.printf("   \t\t%s → %s%n", start,end);
      System.out.printf("\t%d/%d/%d %s 출발 비행기\n", year, month, day, hm); // 날짜팀 받아서 출력
      System.out.println();
	  System.out.printf(" \t항공권번호 : %s%n",ticketNum);
      System.out.println("===========================================");
      //}
   }

   char gateMaking(String point)      //탑승구 제작 메소드
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

   String startMaking(String point)   //영어대문자를 출발지로 다시 바꿔주는 메소드
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
   String endMaking(String point)      //영어대문자를 출발지로 다시 바꿔주는 메소드
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
	
	String ymdMaking(int year, int month, int day)
	{
		String str0 = Integer.toString(year); 
		String str1 = str0.substring(str0.length()-2, str0.length());
		String str2 = String.format("%02d", month);
		String str3 = Integer.toString(day);
		
		return str1 + str2 + str3;
	}

	String hmMaking(String time)
	{
		String str = time;
		String colon = ":";
		String str1 = str.substring(0,2);
		String str2 = str.substring(2);

		return str1 + colon + str2;

	}





	public void main(String[] args)
	{
			String hh = "";

			hh = TT.timetable(DS.year, DS.month, day, PPO.sPoint());

			Tic.TicketPrint(member[i].point,member[i].rName,member[i].rSeat,member[i].rClass, year, month, day, hh);

			Tic.TicketPrint(member[mi].point,member[mi].rName,member[mi].rSeat,member[mi].rClass, year, month, day, hh);

	}
}



