package com.util.string_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "100,,,200,300";
		
		String[] res = data.split(",");
		StringTokenizer st = new StringTokenizer(data,",");
		
		for(int i = 0 ;i < res.length; i++)
		{
			System.out.print(res[i]+"+");
		}
		System.out.println("����: "+res.length);
		System.out.println("=======================");
		System.out.println();
		System.out.println("����: "+st.countTokens());
		for(int i = 0 ; st.hasMoreTokens(); i++)
		{
			System.out.print(st.nextToken()+"+");
		}
		System.out.println();
		System.out.println("���� ��ū ����: "+st.countTokens());
	}
/*
 * ����: String split- ���ڿ��� ��ū���� �ν�
 * StringTokenizer- ���ڿ��� ��ū���� �ν�x
 */
}
