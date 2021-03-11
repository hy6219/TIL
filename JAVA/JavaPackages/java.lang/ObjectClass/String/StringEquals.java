package com.objectClass.string;

public class StringEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		String d = new String("abc");
		
		System.out.println((a==b));//true
		System.out.println((c==d));//false
		System.out.println((a==c));//false
		
		System.out.println(a.equals(b)); //true
		System.out.println(d.equals(c)); //true
		System.out.println(a.equals(c)); //true
	}

}
