package com.exception09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx15 {

	public static void main(String[] args) throws ArithmeticException, InputMismatchException{
		// TODO Auto-generated method stub
		method1();
		method2();
	}
	static void method1()
	{
		System.out.println("숫자 하나를 입력:");
		Scanner s=new Scanner(System.in);
		int val=s.nextInt();
		System.out.println(val);
	}
	static void method2()
	{
		System.out.println(2/0);
	}
}
