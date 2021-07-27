package com.test01;

import java.util.Scanner;

public class Star6 {
/**
 * 
 * @param args
 *********
  *******
   *****  
    ***
     *
 Ãâ·Â
 line(scanner)-ÃÑ Çà¼ö-5°³
 -->¿­¼ö=col=2*line-1=9
 -->col/2(Ç×»ó * ÂïÇôÁ® ÀÖÀ¸´Ï±î)-->=4=mid
 0Çà-0~(col/2 + 4)¿­ *
 1Çà-1~(col/2 +3)¿­ *, [0¿­,(col/2+4 or col-1)¿­] ºóÄ­
 2Çà-2~(col/2 +2)¿­ *, [0~1(=col/2 - 3)¿­,(col/2 + 3)~(col/2 + 4 or col-1)¿­] ºóÄ­
 
 -->iÇà-i~(mid + (line - 1- i)¿­  *
 	   0~(i-1) ºóÄ­
 	  ( mid+ (line-i)) ~(col-1) ºóÄ­
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int line=s.nextInt();
		int col=2*line-1;
		int mid=col/2;
		
		for(int i = 0; i < line; i++)
		{
			int j = 0;
			
			for(; j < i; j++)
			{
				System.out.print(" ");
			}
			for(;j < (mid + (line-i));j++)
			{
				System.out.print("*");
				
			}
			for(;j < line; j++)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
