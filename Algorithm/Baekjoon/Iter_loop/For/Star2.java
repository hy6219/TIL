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
���!
0��-0~3�� ��ĭ, 4�� *
1��-0~2�� ��ĭ, 3~4�� *
2��-0~1�� ��ĭ, 2~4�� *
3��-0�� ��ĭ, 1~4�� *
4��-		, 0~4�� *
line=���=5��
--> i��-0~(line-2-i)�� ��ĭ, (line-1-i)~(line-1)�� *
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
