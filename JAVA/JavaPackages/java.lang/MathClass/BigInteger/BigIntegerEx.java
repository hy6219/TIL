package com.lang.math.BigInteger;

import java.math.BigInteger;

public class BigIntegerEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i = 1; i < 100; i++)
		{
			System.out.printf("%d!=%s\n", i, sFactorial(BigInteger.valueOf(i)));
			//0.3�� ����
			Thread.sleep(300);
		}
	}
	/*
	 * BigInteger ����
	 * BigInteger.add/subtract/multiply/divide/remainder(BigInteger val)
	 */
	static String sFactorial(BigInteger n)
	{
		return String.valueOf(Factorial(n));
	}
	static BigInteger Factorial(BigInteger n)
	{
		if(n.signum()==-1) 
	    {
			//signum(): ���� -1 ,0 �̸� 0, ��� 1��ȯ
			return n.negate();
	    }
		else if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))
		{
			return BigInteger.ONE;
		}
		else
		{
			return n.multiply(Factorial(n.subtract(BigInteger.ONE)));
		}
	}

}
