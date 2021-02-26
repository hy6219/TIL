package com.test01;

import java.util.Scanner;

public class Season {


	public void getSeason()
	{
		int month;
		System.out.println("몇월달인지 입력해주세요! 예: 1월->1");
		Scanner sc=new Scanner(System.in);
		month=sc.nextInt();
		/**
		 * 12, 1, 2 겨울 12로 나누면 0 1 2
		 * 3, 4,5 봄 3 4 5 
		 * 6,7,8 여름 6 7 8
		 * 9,10,11 가을 9 10 11
		 */
		int iseason;
		if(month%12<3)
		{
			iseason=0;//겨울
		}
		else if(month%12<6)
		{
			iseason=1;//봄
		}
		else if(month%12<9)
		{
			iseason=2;//여름
		}
		else
		{
			iseason=3;//가을
		}
		String[] season= {"겨울","봄","여름","가을"};
		switch(iseason)
		{
		case 0:
			System.out.println("지금은 "+season[iseason]+"입니다");
			break;
		case 1:
			System.out.println("지금은 "+season[iseason]+"입니다");
			break;
		case 2:
			System.out.println("지금은 "+season[iseason]+"입니다");
			break;
		case 3:
			System.out.println("지금은 "+season[iseason]+"입니다");
			break;
		default:
			System.out.println("1~12월 내의 값을 입력한것이 아닌듯 합니다!");
		}
	}
}
