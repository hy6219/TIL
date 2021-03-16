package com.chap03_StringTokenizer;

import java.util.StringTokenizer;

public class Run_stringtk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "홍길동, 26, 서울 송파구 잠실동, 먹방좋아함";
		StringTokenizer st = new StringTokenizer(str,",");
		System.out.println(st.countTokens());
		while(st.hasMoreElements())
		{
			//hasMoreElements(): 커서 뒤에 토큰이 남아있는지 확인(true, false)
			System.out.println(st.nextToken().trim());
		}
	}

}
