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
���!


0��-0~4�� *, -
1��-0~3�� *, 4�� ��ĭ
2��-0~2�� *, 3~4�� ��ĭ
3��-0~1��*, 2~4�� ��ĭ
4��-0�� *, 1~4�� ��ĭ
���=line=5��
-->i��- 0~(line-1-i)�� *
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
