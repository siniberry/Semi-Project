class Ticket                     //Ƽ�� ����, ��� Ŭ����
{
   String ticketNum;            // Ƽ�Ϲ�ȣ
   String point;               // �༱��
   String name;               // �̸�
   String seat;               // �¼���ȣ
   String sclass;               // �¼����

   int year;
   int month;
   int day;

   void TicketPrint(String po,String pe,String se,String sc, int yr, int mth, int dy, String tm)      //��¸޼ҵ�
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
      System.out.printf("\t     [%s Ŭ����]%n",sclass);
      System.out.printf(" ������ : %s   \t\tž�±� : %c%n",name,gate);
      System.out.printf("   \t\t\t�¼� : %s\n",seat);
      System.out.println();
      System.out.printf("   \t\t%s �� %s%n", start,end);
      System.out.printf("\t%d/%d/%d %s ��� �����\n", year, month, day, hm); // ��¥�� �޾Ƽ� ���
      System.out.println();
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



