package com.test01;

import java.util.Scanner;

public class Star2 {
/**
 * 
 * @param args
 	*
   **
  ***
 ****
*****
嘛扁!
0青-0~3凯 后沫, 4凯 *
1青-0~2凯 后沫, 3~4凯 *
2青-0~1凯 后沫, 2~4凯 *
3青-0凯 后沫, 1~4凯 *
4青-		, 0~4凯 *
line=青荐=5俺
--> i青-0~(line-2-i)凯 后沫, (line-1-i)~(line-1)凯 *
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int line=s.nextInt();
		
		for(int i = 0; i < line; i++)
		{
			int j = 0;
			for(; j < line -1 - i;j++)
			{
				System.out.print(" ");
			}
			for(;j < line; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < line; i++)
		{
			
		}
	}

}
