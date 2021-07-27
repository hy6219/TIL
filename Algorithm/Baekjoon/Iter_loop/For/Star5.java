package com.test01;

import java.util.Scanner;

public class Star5 {
/**
 * 
 * @param args
    *
   ***
  *****
 *******
*********
Ãâ·Â
ÃÑ Çà¼ö=line=5°³(scanner)
-->¸¶Áö¸· Çà º° °¹¼ö=2*line-1->ÃÑ ¿­¼ö->col=9
col/2=4
0Çà- º° 1°³, 0~col/2-1 && col/2+1 ~col-1 ºóÄ­, col/2 *
1Çà-º° 3°³, 0~col/2-2 && col/2+2 ~col-1 ºóÄ­, col/2 -1 ~ col/2+1 *

-->iÇà-0 ~ (col/2-(i+1)) ºóÄ­
	  (col / 2 +(i+1))~(col-1) ºóÄ­
	  col / 2 -i ~ col / 2 + i *
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int line=s.nextInt();
		int col=2*line-1;
		int mid=col/2;
		for(int i = 0; i  < line; i++)
		{
			int j = 0;
			for(;j<(mid-i);j++)
			{
				System.out.print(" ");
			}
			for(;j <= (mid + i);j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
