package com.util.string_tokenizer;

import java.util.StringTokenizer;


public class StringTokenizerEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "100*(200+300)/2";
		
		StringTokenizer st = new StringTokenizer
				(
						exp,
						"+-*/()",
						true
				);
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
		System.out.println("============================================");
		StringTokenizer st2=
				new StringTokenizer
				(
						exp,
						"+-*/()",
						false
				);
		
		
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}
		
	}

}
