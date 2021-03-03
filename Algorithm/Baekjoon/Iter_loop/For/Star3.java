package com.test01;

import java.util.Scanner;

public class Star3 {
/**
 * 
 * @param args
 * 
*****
****
***
**
*
¬Ô±‚!


0«‡-0~4ø≠ *, -
1«‡-0~3ø≠ *, 4ø≠ ∫Ûƒ≠
2«‡-0~2ø≠ *, 3~4ø≠ ∫Ûƒ≠
3«‡-0~1ø≠*, 2~4ø≠ ∫Ûƒ≠
4«‡-0ø≠ *, 1~4ø≠ ∫Ûƒ≠
«‡ºˆ=line=5∞≥
-->i«‡- 0~(line-1-i)ø≠ *
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int line=s.nextInt();
		
		for(int i = 0; i < line; i++)
		{
			int j = 0;
			for(; j < (line-i);j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
