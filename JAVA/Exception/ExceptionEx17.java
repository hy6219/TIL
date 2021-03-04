package com.exception10;

public class ExceptionEx17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			method1();
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getSimpleName());
		}
	}
	static void method1() throws Exception
	{
		//add throws declaration(try-catch블럭이 없음)
		/**
		 * 사용자 실수로 발생되는 Exception 예외 클래스는
		 * 예외처리해주어야 함
		 */
		throw new Exception("고의로 예외 발생");
	}
}
