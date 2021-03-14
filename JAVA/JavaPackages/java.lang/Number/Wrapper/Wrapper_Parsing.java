package com.lang.number.wrapper;

public class Wrapper_Parsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Wrapper클래스.parse자료형(string 값) :string 값-> 기본형
		 * Wrapper클래스.valueOf(string 값) : string 값 -> 래퍼클래스(성능이 조금 더 느림)
		 */
		int  i = new Integer("100");
		int i2 = new Integer("100").intValue();
		
		Integer i3 = Integer.valueOf("100");
		int i4 = Integer.valueOf("100");
		Integer i5 = Integer.parseInt("100");
		
		System.out.println("i: "+i+", i2: "+i2
				+", i3: "+i3);
		System.out.println("i4: "+i4+", i5: "+i5);
		
		Integer i6 = Integer.valueOf("1111", 2);//1111을 2진법 수로 인식
		Float f1 = Float.parseFloat("3.14f");
		
		Float f2 = new Float("3.14").floatValue();
	
		System.out.println("i6: "+i6+", f1: "+f1+",f2: "+f2);
	}

}
