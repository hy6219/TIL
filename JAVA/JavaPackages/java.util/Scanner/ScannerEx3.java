package com.util.scanner;

import java.io.File;
import java.util.Scanner;

public class ScannerEx3 {
//cmd�� ����!
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("C:\\Users\\gs813\\OneDrive\\���� ȭ��"
				+ "\\ScannerTest2.txt"));
		int cnt = 0 ;
		int totalSum = 0 ;
		
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line).useDelimiter(", ");//�����ڷ� �о����
			//�� ���� �� ���� ����
			int sum = 0;
			
			while(sc2.hasNextInt())
			{
				//������ �����ڰ� ������ ���ڸ� ������
				sum += sc2.nextInt();
			}
			System.out.println(line+", sum= "+sum);
			totalSum+=sum;
			cnt++;
		}
		System.out.println("Total Line: "+cnt+", Total sum: "+totalSum);
		
		
		
	}

}
