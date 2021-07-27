package com.lang.method;
import static java.lang.Math.*;
import static java.lang.System.*;

public class MathExactException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = Integer.MIN_VALUE;
		
		out.println("i= "+i);
		out.println("-i="+(-i));
		
		/*
		 * public static int negateExact(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }

        return -a;
    }
		 */
		out.printf("negateExact(%d) = %d\n", 3, negateExact(3)); //-3
		out.printf("negateExact(%d) = %d\n", -3, negateExact(-3));//3
		/*
		 * �ּҰ�+1�� �Ǿ�(~a+1�� negate �����̱� ����)
		 * integer overflow �߻�
		 * 
		 * ��Ʈ��ȯ������ ~==>i�� �ִ��� �Ǳ� ����
		 */
		try
		{
			out.printf("negateExact(%d) = %d\n", i, negateExact(i));
			out.printf("incrementExact(%d) = %d\n",i,incrementExact(negateExact(i)));
			out.printf("toIntExact(%d) = %d\n", negateExact((long)i), toIntExact(negateExact((long)i)));
		}
		catch(ArithmeticException e)
		{
			//long��ȯ�� �޼���ȣ��
			out.println(e.getMessage().toString());
			out.printf("negateExact(%d) = %d\n", (long)i, negateExact((long)i));
			out.printf("incrementExact(%d) = %d\n",(long)i,incrementExact(negateExact((long)i)));
			out.printf("toIntExact(%d) = %d\n", (long)i, toIntExact((long)i));
		}
//		long t = negateExact((long)i);
//		out.printf("toIntExact(%d) = %d\n", t, toIntExact(t));
		/*
		 * Exception in thread "main" java.lang.ArithmeticException: integer overflow
		 * -->t���� int ���ֺ��� ũ�� ����!
		 */
		
		
		
	}

}
