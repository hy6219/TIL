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
		int j = Integer.parseInt(s);
		int k = Integer.valueOf(s);
		
		System.out.println(s);
		System.out.println(t);
		System.out.println(l);
		System.out.println(j);
		System.out.println(k);
	}

}
