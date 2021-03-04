package com.exception10;

public class ExceptionEx16 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		method1();
	}
	static void method1()
	{
		try
		{
			/**
			 * 예외를 단순히 전달만 하지 않고,
			 * 처리를 해주기 위하여 try-catch 블럭으로 감싸기
			 */
			throw new Exception("고의로 예외 발생");
		}
		catch(Exception e)
		{
			System.out.println("method1 메서드에서 예외가 처리되었습니다");
			e.printStackTrace();
			System.out.println(e.getClass().getSimpleName());
		}
	}

}
