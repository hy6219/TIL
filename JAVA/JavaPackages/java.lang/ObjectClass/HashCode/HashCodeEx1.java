package com.objectClass.hashCode;

public class HashCodeEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = "abc";
		String str4 = "abc";
		
		System.out.println("str1 hashCode: "+str1.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str1));
		System.out.println("str2 hashCode: "+str2.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str2));
		System.out.println("str3 hashCode: "+str3.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str3));
		System.out.println("str4 hashCode: "+str4.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str4));
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.equals(str3));
		
		System.out.println(str3.equals(str4));
	}

}
