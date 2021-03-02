package com.exception05;

public class ExceptionEx08 {

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
			if(ae instanceof ArithmeticException)
			{
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		}
		catch(Exception e)
		{
			//ArithmeticException을 제외한 모든 예외가 처리됨
			if(e instanceof Exception)
			{
				System.out.println("true true");
			}
			if(e instanceof ArithmeticException)
			{
				System.out.println("true true");
			}
			System.out.println("Exception");
		}
	}

}
