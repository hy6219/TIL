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
���
�� ���=line=5��(scanner)
-->������ �� �� ����=2*line-1->�� ����->col=9
col/2=4
0��- �� 1��, 0~col/2-1 && col/2+1 ~col-1 ��ĭ, col/2 *
1��-�� 3��, 0~col/2-2 && col/2+2 ~col-1 ��ĭ, col/2 -1 ~ col/2+1 *

-->i��-0 ~ (col/2-(i+1)) ��ĭ
	  (col / 2 +(i+1))~(col-1) ��ĭ
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
