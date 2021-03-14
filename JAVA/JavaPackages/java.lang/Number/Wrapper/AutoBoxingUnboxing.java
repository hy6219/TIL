package com.lang.number.wrapper;

public class AutoBoxingUnboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int g = 10;
		Integer intg = g;
		Object obj   = g;
		
		System.out.println("Integer intg:"+intg+", Object obj = g: "+obj);
		//Integer intg:10, Object obj = g: 10
		
		
		System.out.println(intg + 3);//13
		
		float f = 1.23f;
		Float f1 = f;
		Object obj2 = f;
		System.out.println("Float f1: "+f1+", Object obj2 = f: "+obj2);
		System.out.println(f1 + 3);//4.23
//		System.out.println(obj2 + 3);
	}

}
