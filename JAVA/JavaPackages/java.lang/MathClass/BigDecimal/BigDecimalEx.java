package com.lang.math.BigDecimal;

import java.math.BigDecimal;

public class BigDecimalEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * BigDecimal, BigInteger:
		 *  		immutable objects
		 *  
		 *  BigInteger�� �̿��ؼ� ǥ��
		 *  
		 *  ���� * 10^(-scale)
		 *  =precision: ������ ���е� .precision() 
		 *  -scale ����  .scale()
		 *  -intval: ����  .unscaledValue()
		 *  
		 *  scale: 0 ~ Integer.MAX_VALUE ���� ��
		 */
		//BigDecimal ����
		BigDecimal val = new BigDecimal("123.45");
		BigDecimal val2 = BigDecimal.valueOf(1.23);
		//double type literal�� ����(�����߻�����)
		BigDecimal val3 = new BigDecimal(1.0e-22);
		//BigInteger�� ���� new ����Ÿ��(��(string x))���� ��밡��
		
		
		BigDecimal val4 = new BigDecimal(123);//int or long Ÿ�����ε� ����
		BigDecimal val5 = BigDecimal.valueOf(123);
		
		System.out.println("val-"+val+","
				+ " �����κ�: "+val.unscaledValue()+","+
				" �����κ� : "+val.scale()+", ���е� : "+val.precision());
		/*
		 * val-123.45, �����κ�: 12345, �����κ� : 2, ���е� : 5
		 * ��? 
		 * ���� �Ҽ��κ��� ���ڸ�->����=2
		 * -->�׷��� ������ �̿� ���� Ǯ���� �� ����
		 * 12345 * 10^(-2)
		 * 
		 * -->���� �����κ�=12345,
		 * ���е�(����)=5
		 */
		
		/*
		 * �ٸ� Ÿ������ ��ȯ
		 * 
		 * [1]���ڿ��� ��ȯ
		 * toPlainString() 
		 * toString()
		 * 
		 * -->1e-22�� ���� �����������¸� ������� ��,
		 * toPlainString�� Ǯ���� ���� ��Ÿ�����ϰ�
		 * toString�� e�� �츰 ���� ǥ��
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
