package com.util.scanner;

import java.util.Scanner;

public class ScannerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] arr= null;
		
		while(true)
		{
			String prompt = ">>";
			
			System.out.print(prompt);
			
			//화면으로부터 라인단위로 입력받기
			String input = sc.nextLine();
			
			//입력받은 내용에서 앞뒤 공백 제거 후 구분자로 잘라서 넣기
			
			arr = input.trim().split(" +");//" +": 하나 이상의 공백
			
			String cmd = arr[0].trim();
			
			if("".equals(cmd))
			{
				continue;
			}
			
			cmd = cmd.toLowerCase();
			
			if(cmd.equals("q") || cmd.equals("Q"))
			{
				System.exit(0);
			}
			else
			{
				for(int i = 0 ; i < arr.length; i++)
				{
					System.out.println(arr[i]);
				}
			}
		}
	}

}
