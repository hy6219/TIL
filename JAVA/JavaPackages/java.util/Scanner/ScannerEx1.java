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
			
			//ȭ�����κ��� ���δ����� �Է¹ޱ�
			String input = sc.nextLine();
			
			//�Է¹��� ���뿡�� �յ� ���� ���� �� �����ڷ� �߶� �ֱ�
			
			arr = input.trim().split(" +");//" +": �ϳ� �̻��� ����
			
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
