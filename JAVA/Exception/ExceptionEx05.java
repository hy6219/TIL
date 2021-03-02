package com.exception04;

public class ExceptionEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		/**
		 * try 블럭에서 예외가 발생할 경우
		 */
		try
		{
			System.out.println(3);
			System.out.println("a");
			System.out.println(0/0);//catch블럭으로 이동
			System.out.println(4);//실행되지 않고 빠져나감
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println();
		}
		System.out.println(5);
	}

}
