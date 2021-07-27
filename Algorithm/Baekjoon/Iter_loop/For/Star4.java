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
 嘛扁
 0青-0~4凯 *
 1青-1~4凯 *, 0凯 后沫
 2青-2~4凯 *, 0~1凯 后沫
 3青-3~4凯 *, 0~2凯 后沫
 4青-4凯 *, 0~3凯 后沫
 ->i青-i~(line-1)凯 * , 0~(i-1)凯 后沫
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
