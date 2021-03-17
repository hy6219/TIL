package com.util.string_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "100, 200, 300, 400";
		StringTokenizer st = new StringTokenizer(source, ",");
		System.out.println(st.countTokens());//��ü ��ū �� : 4
		while(st.hasMoreTokens())
		{
			/*
			 * boolean hasMoreTokens() :
			 * ��ū�� �����ִ��� �˷���
			 * 
			 * String nextToken() :���� ��ū�� ��ȯ
			 * 
			 * int countTokens() : ��ü ��ū�� ���� ��ȯ
			 */
			
			System.out.println("next: "+st.nextToken()+
					", ��ü ��ū ��: "+st.countTokens());
			//�̻�Ȳ������ ���� ��ü ��ū���� ��ȯ�� ��
			/*
			 * next: 100, ��ü ��ū ��: 3
next:  200, ��ü ��ū ��: 2
next:  300, ��ü ��ū ��: 1
next:  400, ��ü ��ū ��: 0
			 */
		}
	}

}
