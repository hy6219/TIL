package com.test01;

import java.util.Scanner;

public class Star4 {
/**
 * 
 * @param args
 *****
 ****
  ***
   **
    *
 ���
 0��-0~4�� *
 1��-1~4�� *, 0�� ��ĭ
 2��-2~4�� *, 0~1�� ��ĭ
 3��-3~4�� *, 0~2�� ��ĭ
 4��-4�� *, 0~3�� ��ĭ
 ->i��-i~(line-1)�� * , 0~(i-1)�� ��ĭ
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int line=s.nextInt();
		
		for(int i = 0;i < line; i++)
		{
			int j = 0;
			
			for(; j < i; j++)
			{
				System.out.print(" ");
			}
			for(; j < line; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
