package com.lang.math.BigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalCal_math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * BigDecimal add/subtract/multiply/divide/remainer(BigDecimal val)
		 * 
		 * 
		 */
		BigDecimal val1 = new BigDecimal(123);//int or long Ÿ�����ε� ����
		BigDecimal val2 = BigDecimal.valueOf(125);
		
		System.out.println(val1+"+"+val2+"="+(val1.add(val2)));
		System.out.println(val1+"-"+val2+"="+(val1.subtract(val2)));
		System.out.println(val1+"*"+val2+"="+(val1.multiply(val2)));
		System.out.println(val1+"/"+val2+"="+(val1.divide(val2)));
		System.out.println(val1+"%"+val2+"="+(val1.remainder(val2)));
		
		/*
		 * �ݿø�- 
		 * [1]divide
		 * 
		 * BigDecimal divide(Bigdecimal divisor)
		 * BigDecimal divide(Bigdecimal divisor, int roundingMode)
		 * BigDecimal divide(Bigdecimal divisor, RoundingMode roundingMode)
		 * BigDecimal divide(Bigdecimal divisor, int scale, int roundingMode)
		 * BigDecimal divide(Bigdecimal divisor, int scale, RoundingMode roundingMode)
		 * BigDecimal divide(Bigdecimal divisor, MathContext mc)
		 * 
		 * [2]
		 * setScale(int newScale)
		 * setScale(int newScale, int roundingMode)
		 * setScale(int newScale, RoundingMode mode)
		 * 
		 */
		System.out.println("========================================");
		System.out.println(val1.divide(val2,2,RoundingMode.HALF_UP));
		System.out.println(val1.divide(val2,2,RoundingMode.HALF_DOWN));
		System.out.println(val1.divide(val2,2,RoundingMode.UP));
		System.out.println(val1.divide(val2,2,RoundingMode.DOWN));
		System.out.println(val1.divide(val2,2,RoundingMode.CEILING));
		System.out.println(val1.divide(val2,2,RoundingMode.FLOOR));
		System.out.println(val1.divide(val2,2,RoundingMode.HALF_EVEN));
//		System.out.println(val1.divide(val2,2,RoundingMode.UNNECESSARY));->�� 
		//�������� �ʾƼ� ArithmeticException �߻�
//		System.out.println(val1.divide(val2,2,RoundingMode.HALF_UP));
		
		BigDecimal bd1 = new BigDecimal(-3);
		BigDecimal bd2 = new BigDecimal(4);
		System.out.println(bd1.divide(bd2));
		System.out.println("========================================");
		System.out.println(bd1.divide(bd2,1,RoundingMode.HALF_UP));
		System.out.println(bd1.divide(bd2,1,RoundingMode.HALF_DOWN));
		System.out.println(bd1.divide(bd2,1,RoundingMode.UP));
		System.out.println(bd1.divide(bd2,1,RoundingMode.DOWN));
		System.out.println(bd1.divide(bd2,1,RoundingMode.CEILING));
		System.out.println(bd1.divide(bd2,1,RoundingMode.FLOOR));
		System.out.println(bd1.divide(bd2,1,RoundingMode.HALF_EVEN));//Ȧ���� half_up
		System.out.println("========================================");
		System.out.println();
		bd1 = BigDecimal.valueOf(-5.145);
//		System.out.println(bd1.setScale(1));
		System.out.println(bd1.setScale(1,RoundingMode.HALF_UP));//-3.1
		System.out.println("========================================");
		System.out.println();
		System.out.println(bd1.divide(bd2));
		System.out.println(bd1.divide(bd2, new MathContext(3,RoundingMode.HALF_UP)));
		//������ ������ �Ҽ��� ���ϸ� ��� �����Ͽ� ���е��� ��
		//�� ��� 128�� ��ȿ�ϰ�, �� ���Ŀ� �ִ� 6�� �ݿø�
	}

}
