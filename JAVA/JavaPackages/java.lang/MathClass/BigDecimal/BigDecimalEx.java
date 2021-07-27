package com.lang.math.BigDecimal;

import java.math.BigDecimal;

public class BigDecimalEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * BigDecimal, BigInteger:
		 *  		immutable objects
		 *  
		 *  BigInteger를 이용해서 표현
		 *  
		 *  정수 * 10^(-scale)
		 *  =precision: 정수의 정밀도 .precision() 
		 *  -scale 지수  .scale()
		 *  -intval: 정수  .unscaledValue()
		 *  
		 *  scale: 0 ~ Integer.MAX_VALUE 사이 값
		 */
		//BigDecimal 생성
		BigDecimal val = new BigDecimal("123.45");
		BigDecimal val2 = BigDecimal.valueOf(1.23);
		//double type literal로 생성(오차발생가능)
		BigDecimal val3 = new BigDecimal(1.0e-22);
		//BigInteger와 차이 new 참조타입(값(string x))으로 사용가능
		
		
		BigDecimal val4 = new BigDecimal(123);//int or long 타입으로도 가능
		BigDecimal val5 = BigDecimal.valueOf(123);
		
		System.out.println("val-"+val+","
				+ " 정수부분: "+val.unscaledValue()+","+
				" 지수부분 : "+val.scale()+", 정밀도 : "+val.precision());
		/*
		 * val-123.45, 정수부분: 12345, 지수부분 : 2, 정밀도 : 5
		 * 왜? 
		 * 지금 소수부분이 두자리->지수=2
		 * -->그렇기 때문에 이와 같이 풀어질 수 있음
		 * 12345 * 10^(-2)
		 * 
		 * -->따라서 정수부분=12345,
		 * 정밀도(정수)=5
		 */
		
		/*
		 * 다른 타입으로 변환
		 * 
		 * [1]문자열로 변환
		 * toPlainString() 
		 * toString()
		 * 
		 * -->1e-22와 같은 과학지수형태를 사용했을 때,
		 * toPlainString은 풀어진 값을 나타내려하고
		 * toString은 e를 살린 값을 표현
		 */
		
		System.out.println("val2 to PlainString:"+
		val2.toPlainString()+", toString: "+val2.toString());
		//val2 to PlainString:1.23, toString: 1.23
		System.out.println();
		
		
		System.out.printf("val3 to PlainString: %.28s\n,"
				+ "toString: %.28s\n, equals? : %b\n", val3.toPlainString(),
				val3.toString(),((val3.toPlainString()).equals
				(val3.toString())));
		/*
		 * val3 to PlainString:0.00000000000000000000010000000000000000485967743265708723529783189783450120951502847720104849571498561999760568141937255859375,
toString: 1.0000000000000000485967743265708723529783189783450120951502847720104849571498561999760568141937255859375E-22
		 */
		
		
	}

}
