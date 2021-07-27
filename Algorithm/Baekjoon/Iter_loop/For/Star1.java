package com.test01;

import java.util.Scanner;

public class Star1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int line=s.nextInt();
		
		for(int i = 0; i < line; i++)
		{
			for(int j = 0; j < (i+1); j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
