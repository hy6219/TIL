package com.exception10;
/**

고의로 예외 발생
고의로 예외를 발생시켰을 때, 예외처리를 하지 않은 경우는 단순히 예외를 '전달'만 한 것이기 때문에
어느 한 곳에서는 반드시 예외처리를 해주어야 함!
1)main 메서드(자신을 호출한 메서드) 내에 try-catch 블럭 작성 && main 메서드 내에서 사용되는 메서드 예외 발생
[
  public static void main(String[] args)
 { 
      try
      {
          method1();
       }
     catch(Exception e)
     {
       ...
     }
 }
static void method1() "throws Exception"
{
    throw new Exception(msg);
 }
]
2)메서드에서 try-catch 블럭 사용 && main 메서드(자신이 호출되는 메서드 내)에서는 단순히 메서드를 호출
[
public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		method1();
	}
	static void method1()
	{
		try
		{
			
			throw new Exception("고의로 예외 발생");
		}
		catch(Exception e)
		{
			...
		}
	}

]
**/
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
