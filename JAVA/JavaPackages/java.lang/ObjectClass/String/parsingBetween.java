package com.objectClass.string;

public class parsingBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1  ;
		double d = 1.2;
		//i to string
		String s = i + "";
		String t= String.valueOf(i);
		String l = d + "";
		//String to i
		/**
		 * 
		 * Wrapper class. parseInt/... 사용시 ->trim으로
		 * 공백을 제거해주어야 함 (NumberFormatException 발생 가능)
		 */
		int j = Integer.parseInt(s.trim());
		int k = Integer.valueOf(s);
		
		System.out.println(s);
		System.out.println(t);
		System.out.println(l);
		System.out.println(j);
		System.out.println(k);
		
		String f = "false";
		boolean b= Boolean.valueOf(f);
		System.out.println(b);
		
		/**
		 * Boolean, Integer, ... ->Wrapper class : 기본형 값을 감싸고 있는 클래스
		 */
		System.out.println(Boolean.parseBoolean(f));
	}

}
