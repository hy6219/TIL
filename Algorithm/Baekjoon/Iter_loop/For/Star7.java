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
		//����ϱ�
		/**
		 * �Է� hL=half Line(scanner)=5
		 * �� ���=line=hL*2-1=9
		 * �� ����=col=line=9
		 * 0~line/2(=mid=4)��-->����� 5ó��
		 * 
		 * 
		 *-- mid+1~line-1�� ��Ģã��(a)--
		 * mid=line/2=4
		 * 
		 * 5��-0�� ��ĭ	8�� ��ĭ	1~7�� *
		 * 6��-0~1�� ��ĭ  7~8�� ��ĭ  2~6�� *
		 * 
		 * -->i��(a) 0~(i-1-mid) ��ĭ
		 *     		(i-mid)~(col-(i-mid)-1) *
		 *          (col-(i-mid))~(col-1) ��ĭ
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
//			} -->��� ������ �������� ä����
			System.out.println();
		}
		
		for(;i < line; i++)
		{
			/**
			 * i��(a) 0~(i-1-mid) ��ĭ
		 *     		(i-mid)~(col-(i-mid)-1) *
		 *          (col-(i-mid))~(col-1) ��ĭ->��� ��
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
