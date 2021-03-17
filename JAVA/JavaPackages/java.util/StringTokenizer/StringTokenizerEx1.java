package com.util.string_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "100, 200, 300, 400";
		StringTokenizer st = new StringTokenizer(source, ",");
		System.out.println(st.countTokens());//전체 토큰 수 : 4
		while(st.hasMoreTokens())
		{
			/*
			 * boolean hasMoreTokens() :
			 * 토큰이 남아있는지 알려줌
			 * 
			 * String nextToken() :다음 토큰을 반환
			 * 
			 * int countTokens() : 전체 토큰의 수를 반환
			 */
			
			System.out.println("next: "+st.nextToken()+
					", 전체 토큰 수: "+st.countTokens());
			//이상황에서는 남은 전체 토큰수를 반환할 것
			/*
			 * next: 100, 전체 토큰 수: 3
next:  200, 전체 토큰 수: 2
next:  300, 전체 토큰 수: 1
next:  400, 전체 토큰 수: 0
			 */
		}
	}

}
