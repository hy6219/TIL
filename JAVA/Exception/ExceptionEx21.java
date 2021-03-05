package com.exception12;

public class ExceptionEx21 {

	/**
	 * 
	 * @param args
	 * 
	 * finally 블럭은 try 블럭에 return이 있어도 실행됨
	 * catch 블럭 수행 중 return을 만나도 finally블럭 내의 코드는 수행됨!
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		method2();
		System.out.println("method1()수행을 마치고 main메서드로 돌아왔습니다");
	}
	static void method1()
	{
		try
		{
			System.out.println("method1()이 호출됨");
			return;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("method1()의 finally 블럭이 실행되었습니다");
		}
	}
	
	static void method2()
	{
		try
		{
			throw new Exception("고의로 예외 발생");
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getSimpleName()+" 예외 발생");
			return;
		}
		finally
		{
			System.out.println("method2()의 finally 블럭이 실행되었습니다");
		}
	}
}
