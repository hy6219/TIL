package com.util.random;

import java.util.Random;

public class RandomEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		int[] number =new int[100];
		int[] counter = new int[10];
		int i = 0;
		for(i = 0 ; i < number.length; i++)
		{
//			System.out.print(number[i] = (int)(Math.random()*10));
			System.out.print(number[i] = r.nextInt(10));
		}
		
		System.out.println();
		
		for(i = 0 ; i < number.length; i++)
		{
			counter[number[i]]++;//������ ���� number[i] ������ ī��Ʈ
		}
		
		for(i = 0 ; i < counter.length; i++)
		{
			System.out.println(i+"�� ���� : "+printGraph('#',counter[i])+" "+counter[i]);
		}
	}
	public static String printGraph(char ch, int val)
	{
		char[] bar = new char[val];
		int i = 0;
		for(i = 0 ; i < val; i++)
		{
			bar[i] = ch;
		}
		return new String(bar);//private char[] value (string.class)
		//�������迭-->���ڿ�
	}
}
