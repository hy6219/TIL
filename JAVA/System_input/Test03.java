package com.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test03 v=new Test03();
		v.input1();
		System.out.println();
		Variable03 v1=new Variable03();
		v1.input2();
	}
	public void input1()
	{
		System.out.println("입력값을 한개만 넣어주세요");
		/**
		 * java.util.Scanner sc=new java.util.Scanner(System.in);
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		int i=0, j=0;
		String tmp=null;
		char t;
		//숫자 인덱스 확인
		int[] idx=new int[str.length()];
		while(i<str.length())
		{
			t=str.charAt(i);
			if((t>='0' && t<='9'))
			{
				if(tmp==null)
				{
					tmp=Character.toString(t);
					idx[i]=1;
					
				}
				else
				{
					tmp+=Character.toString(t);
				}
				
			}
			else
			{
				t='a';
				if(tmp==null)
				{
					tmp=Character.toString(t);
				}
				else
				{
					tmp+=Character.toString(t);
				}
			}
			j++;
			i++;
		}//---while---//
		j=0;
		for(int k=0;k<tmp.length();k++)
		{
			t=tmp.charAt(k);
			if(t!='a')
			{
				System.out.print(t);
				//뒤에 숫자가 더 남았는가?
				j=k+1;
				boolean checker=false;
				while(j<tmp.length()-1)
				{
					if(tmp.charAt(j)!='a')
					{
						//숫자가 한개라도 남아있으면 true
						checker=true;
						break;
					}
					j++;
				}
				if(checker==true)
				{
					System.out.print(", ");
				}
				
			}
			j++;
		}
	}
	public void input2()
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("정수 한개만 입력");
		
		try {
			//IOException이 발생할 수 있기 때문에
			//사전에 미리 예방하기 위해서!
			//에러를 막아두는것!
			//https://docs.oracle.com/javase/8/docs/api/
			
			String value=br.readLine();
			int number=Integer.parseInt(value);
			System.out.println("value: "+value);
			System.out.println("value*3: "+number*3);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
