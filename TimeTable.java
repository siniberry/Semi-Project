
import java.util.Scanner;

class TimeTable
{	
	// �̿��ڰ� �Է��� ����, ��, ��, �����, �������� �� �Ű������� �޾�
	// �װ����� ����ϰ�
	// �̿��ڰ� ������ �װ����� ��� �ð��� �������ִ� �޼ҵ�
	String timetable(int year, int month, int day, String depart)	
	{
		Scanner sc = new Scanner(System.in);

		String dep;
		String time;
		int num;
	
		String[] table = {"\t\t��    06 : 30 ~ 07 : 25", "\t\t��    08 : 30 ~ 10 : 25", "\t\t��    10 : 30 ~ 12 : 25", "\t\t��    12 : 30 ~ 14 : 25", 
							"\t\t��    14 : 30 ~ 17 : 25", "\t\t��    16 : 30 ~ 18 : 25", "\t\t��    18 : 30 ~ 20 : 25", "\t\t��    20 : 30 ~ 21 : 25", 
							"\t\t��    22 : 30 ~ 23 : 25"};
		
		int k = 0;

		if (depart  == "SP")	// ����� : ���� �� ������ : �λ�
		{
			k = 0;
		}
		else if (depart== "SJ")	// ����� : ���� �� ������ : ����
		{
			k = 1;
		}
		else if (depart == "PS")	// ����� : ���� �� ������ : ����
		{
			k = 2;
		}
		else if (depart == "PJ")	// ����� : ���� �� ������ : ����
		{
			k = 3;
		}
		else if (depart  == "JS")	// ����� : ���� �� ������ : ����
		{
			k = 4;
		}
		else if (depart  == "JP")	// ����� : ���� �� ������ : ����
		{
			k = 5;
		}

		switch (depart)
		{
			case "SJ" : dep = "���� -> ����"; break;
			case "PS" : dep = "�λ� -> ����"; break;
			case "PJ" : dep = "�λ� -> ����"; break;
			case "JS" : dep = "���� -> ����"; break;
			case "JP" : dep = "���� -> �λ�"; break;
			case "SP" : dep = "���� -> �λ�"; break;
			default : dep = ""; break;
		}

		System.out.printf("\n������ %d�� %d�� %d�� %2s �װ����Դϴ� . ������\n ", year, month, day, dep);
		System.out.println();
		System.out.println("\t�� ���� �� �ɾ� �ð� 10% ���� ���� (�󸮹��� ����) ��");
		System.out.println();

		for (int i=0; i<9; i++)
		{	
			System.out.println(table[i]);
			System.out.println();
		}
		System.out.println();

		do
		{		
			System.out.print(" �� ���ϴ� �װ����� ��ȣ�� ������ �ּ��� : ");	
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