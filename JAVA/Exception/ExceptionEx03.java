package com.exception02;

public class ExceptionEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=100;
		int result=0;
		int temp=0;
		
		for(int i=0;i<10;i++)
		{
			try
			{
				temp=number/((int)(Math.random()*10));
				//Exception in thread "main" java.lang.ArithmeticException: / by zero
				//0~9 사이의 수로 나누기 때문에 0으로 난는 경우 에러 발생 가능!
				result+=temp;
				System.out.println(i+"th ADD: "+temp+", After(Cur):"+result);
			}
			catch(ArithmeticException e)
			{
				System.out.print("["+i+"] ");
				e.printStackTrace();
			}
		}
	}

}
