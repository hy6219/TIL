package com.test01;

import java.util.Scanner;

public class Star7 {
	public static void main(String[] args)
	{
//	     *
//	    ***
//	   *****
//	  *******
//	 *********
//	  *******
//	   *****
//	    ***
//	     *
		//Ãâ·ÂÇÏ±â
		/**
		 * ÀÔ·Â hL=half Line(scanner)=5
		 * ÃÑ Çà¼ö=line=hL*2-1=9
		 * ÃÑ ¿­¼ö=col=line=9
		 * 0~line/2(=mid=4)Çà-->º°Âï±â 5Ã³·³
		 * 
		 * 
		 *-- mid+1~line-1Çà ±ÔÄ¢Ã£±â(a)--
		 * mid=line/2=4
		 * 
		 * 5Çà-0¿­ ºóÄ­	8¿­ ºóÄ­	1~7¿­ *
		 * 6Çà-0~1¿­ ºóÄ­  7~8¿­ ºóÄ­  2~6¿­ *
		 * 
		 * -->iÇà(a) 0~(i-1-mid) ºóÄ­
		 *     		(i-mid)~(col-(i-mid)-1) *
		 *          (col-(i-mid))~(col-1) ºóÄ­
		 */
		Scanner s=new Scanner(System.in);
		int hL=s.nextInt();
		int line=2*hL-1;
		int col=line;
		int mid=col/2;
		int i = 0;
		
		for(; i  <= mid; i++)
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
//			for(;j < col; j++)
//			{
//				System.out.print(" ");
//			} -->¾ø¾îµµ ¾îÂ÷ÇÇ °ø¹éÀ¸·Î Ã¤¿öÁü
			System.out.println();
		}
		
		for(;i < line; i++)
		{
			/**
			 * iÇà(a) 0~(i-1-mid) ºóÄ­
		 *     		(i-mid)~(col-(i-mid)-1) *
		 *          (col-(i-mid))~(col-1) ºóÄ­->¾ø¾îµµ µÊ
			 */
			int j = 0;
			
			for(; j < (i-mid);j++)
			{
				System.out.print(" ");
			}
			for(; j < (col-(i-mid));j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
