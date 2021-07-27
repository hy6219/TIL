package com.util.scanner;

import java.io.File;
import java.util.Scanner;

public class ScannerEx3 {
//cmd로 수행!
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("ScannerTest2.txt"));
		int cnt = 0 ;
		int totalSum = 0 ;
		
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line).useDelimiter(", ");//구분자로 읽어오기
			//각 문자 앞 공백 제거
			int sum = 0;
			
			while(sc2.hasNextInt())
			{
				//이제는 구분자가 없으니 숫자만 있을것
				sum += sc2.nextInt();
			}
			System.out.println(line+", sum= "+sum);
			totalSum+=sum;
			cnt++;
		}
		System.out.println("Total Line: "+cnt+", Total sum: "+totalSum);
		
		
		
	}

}
