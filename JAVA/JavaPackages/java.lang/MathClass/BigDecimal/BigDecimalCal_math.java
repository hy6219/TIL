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
		BigDecimal val1 = new BigDecimal(123);//int or long 타입으로도 가능
		BigDecimal val2 = BigDecimal.valueOf(125);
		
		System.out.println(val1+"+"+val2+"="+(val1.add(val2)));
		System.out.println(val1+"-"+val2+"="+(val1.subtract(val2)));
		System.out.println(val1+"*"+val2+"="+(val1.multiply(val2)));
		System.out.println(val1+"/"+val2+"="+(val1.divide(val2)));
		System.out.println(val1+"%"+val2+"="+(val1.remainder(val2)));
		
		/*
		 * 반올림- 
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
//		System.out.println(val1.divide(val2,2,RoundingMode.UNNECESSARY));->딱 
		//떨어지지 않아서 ArithmeticException 발생
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
		System.out.println(bd1.divide(bd2,1,RoundingMode.HALF_EVEN));//홀수라 half_up
		System.out.println("========================================");
		System.out.println();
		bd1 = BigDecimal.valueOf(-5.145);
//		System.out.println(bd1.setScale(1));
		System.out.println(bd1.setScale(1,RoundingMode.HALF_UP));//-3.1
		System.out.println("========================================");
		System.out.println();
		System.out.println(bd1.divide(bd2));
		System.out.println(bd1.divide(bd2, new MathContext(3,RoundingMode.HALF_UP)));
		//정수를 포함한 소수점 이하를 모두 포함하여 정밀도로 봄
		//이 경우 128은 유효하고, 그 이후에 있는 6을 반올림
	}

}
