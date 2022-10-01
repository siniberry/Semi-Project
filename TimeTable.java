
import java.util.Scanner;

class TimeTable
{	
	// 이용자가 입력한 「연, 월, 일, 출발지, 도착지」 를 매개변수로 받아
	// 항공편을 출력하고
	// 이용자가 선택한 항공편의 출발 시간을 리턴해주는 메소드
	String timetable(int year, int month, int day, String depart)	
	{
		Scanner sc = new Scanner(System.in);

		String dep;
		String time;
		int num;
	
		String[] table = {"\t\t①    06 : 30 ~ 07 : 25", "\t\t②    08 : 30 ~ 10 : 25", "\t\t③    10 : 30 ~ 12 : 25", "\t\t④    12 : 30 ~ 14 : 25", 
							"\t\t⑤    14 : 30 ~ 17 : 25", "\t\t⑥    16 : 30 ~ 18 : 25", "\t\t⑦    18 : 30 ~ 20 : 25", "\t\t⑧    20 : 30 ~ 21 : 25", 
							"\t\t⑨    22 : 30 ~ 23 : 25"};
		
		int k = 0;

		if (depart  == "SP")	// 출발지 : 서울 → 도착지 : 부산
		{
			k = 0;
		}
		else if (depart== "SJ")	// 출발지 : 서울 → 도착지 : 제주
		{
			k = 1;
		}
		else if (depart == "PS")	// 출발지 : 서울 → 도착지 : 제주
		{
			k = 2;
		}
		else if (depart == "PJ")	// 출발지 : 서울 → 도착지 : 제주
		{
			k = 3;
		}
		else if (depart  == "JS")	// 출발지 : 서울 → 도착지 : 제주
		{
			k = 4;
		}
		else if (depart  == "JP")	// 출발지 : 서울 → 도착지 : 제주
		{
			k = 5;
		}

		switch (depart)
		{
			case "SJ" : dep = "서울 -> 제주"; break;
			case "PS" : dep = "부산 -> 서울"; break;
			case "PJ" : dep = "부산 -> 제주"; break;
			case "JS" : dep = "제주 -> 서울"; break;
			case "JP" : dep = "제주 -> 부산"; break;
			case "SP" : dep = "서울 -> 부산"; break;
			default : dep = ""; break;
		}

		System.out.printf("\n■■■■■ %d년 %d월 %d일 %2s 항공편입니다 . ■■■■■\n ", year, month, day, dep);
		System.out.println();
		System.out.println("\t※ 오전 및 심야 시간 10% 할인 적용 (얼리버드 제외) ※");
		System.out.println();

		for (int i=0; i<9; i++)
		{	
			System.out.println(table[i]);
			System.out.println();
		}
		System.out.println();

		do
		{		
			System.out.print(" ■ 원하는 항공편의 번호를 선택해 주세요 : ");	
			num = sc.nextInt();
		}
		while (num<1 || num>9);

		switch (num)
		{
		case 1 : time = "0630"; break;
		case 2 : time = "0830"; break;
		case 3 : time = "1030"; break;
		case 4 : time = "1230"; break;
		case 5 : time = "1430"; break;
		case 6 : time = "1630"; break;
		case 7 : time = "1830"; break;
		case 8 : time = "2030"; break;
		case 9 : time = "2230"; break;
		default : time = ""; break;
		}

		return time;
	}
}