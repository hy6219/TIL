package com.exception08;

public class ExceptionEx11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//예외클래스 객체 만들기
			Exception e=new Exception("고의로 발생시켰음");
			/**
			 * java.lang.Exception.Exception(String message)
			 */
			//throw를 이용하여 예외를 발생시킴
			throw e;
		}
		catch(Exception e)
		{
			System.out.println("에러 메시지: "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었음.");
	}

}
