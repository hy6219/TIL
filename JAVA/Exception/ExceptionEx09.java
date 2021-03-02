package com.exception06;

public class ExceptionEx09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		
		try
		{
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("e.printStackTrace()");
			ae.printStackTrace();
			/**
			 * java.lang.ArithmeticException: / by zero

	at com.exception06.ExceptionEx08.main(ExceptionEx08.java:13)
			 */
			
			System.out.println();
			System.out.println();
			String msg=ae.getMessage();
			/*
			 * the detail message string of 
			 * this Throwable instance
			 * (which may be null).
			 * 
			 */
			System.out.println(msg);
			/**
			 * / by zero
			 */
		}
		
	}

}
