package com.util.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx2 {
	//cmd·Î test

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("ScannerTest.txt"));
		int sum = 0 ;
		int cnt = 0 ;
		
		while(sc.hasNextInt())
		{
			/*
			 * boolean hasNextInt:
			 * 
boolean java.util.Scanner.hasNextInt()


Returns true if the next token in this scanner's 
input can beinterpreted as an int value in the default radix 
using the nextInt method. The scanner does not advance past any input.

			 */
			sum += sc.nextInt();
			cnt++;
		}
		
		System.out.println("sum= "+sum);
		System.out.println("average = "+(sum/(double)cnt));
	}

}
