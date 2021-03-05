package com.exception12;

/**
 * 
 * @author gs813
 *
 *try
 *{
 *	//1
 *}
 *catch(Exception e)
 *{	
 *	//2
 *}
 *finally
 *{
 *	//3
 *}
 *
 *finally는 선택적! 
 *1->2->3순 수행
 *finally는 예외 발생 여부와 관계없이 반드시 실행되어야 하는 코드를 포함시킴
 *-예외발생과 상관없이 수행되어야 하는 메서드 등이 있다면 finally블럭으로 빼내어
 *이용하는 것이 좋음!
 */
public class ExceptionEx20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		try
//		{
//			startInstall();
//			//System.out.println("현재 실행 중: "+new Object() {}.getClass().getEnclosingMethod().getName());
//			copyFiles();
//			
//			deleteTempFiles();
//		
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			deleteTempFiles();
//
//		}
		
		try
		{
			startInstall();
			copyFiles();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			deleteTempFiles();
			/**
			 * 예외 발생 여부에 상관없이
			 * deleteTempFiles();는 실행하는데
			 * 이럴때 finally를 이용하면 좋음!
			 */
		}
	}
	/**
	 * String name = new Object() {}.getClass().getEnclosingMethod().getName();


출처: https://stanleykou.tistory.com/entry/Java-현재-수행중인-메소드의-이름을-얻는-방법 [StanleyKou의 개인작업실]
	
	 */
	
	static void startInstall()
	{
		System.out.println("startInstall()");
	}
	static void copyFiles()
	{
		System.out.println("copyFiles()");
	}
	static void deleteTempFiles()
	{
		System.out.println("deleteTempFiles()");
	}

}
