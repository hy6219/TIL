package com.lang.math.BigInteger;

import java.math.BigInteger;
import java.util.Arrays;

public class BigInteger_bitCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ��Ʈ���� �޼���
		 * 
		 * int bitCount() : 2������ ǥ������ �� 1�� ����
		 * (����: 0�� ����)
		 * 
		 * 
		 */
		System.out.println("BigInteger ���� �� int bitCount(), int bitLength()");
		//1)���ڿ��� ����
		BigInteger bi = new BigInteger("100000000000000");//1e8 �� �ε��Ҽ����� Ÿ��
		System.out.println(bi+" �� 2������ ǥ������ �� 1�� ����: "+bi.bitCount());
		
		//2)n������ ���� ���� ���ڿ�, n����
		BigInteger bi2 = 
				new BigInteger("20",16);
		System.out.println(bi2+" �� 2������ ǥ������ �� 1�� ����: "+bi2.bitCount());
		
		//3)BigInteger.valueOf(����)�� ����
		BigInteger bi3=
				BigInteger.valueOf(22);
		System.out.println(bi3);
		/*
		 * int bitLength(): 2������ ǥ�������� ���� ǥ���ϴµ� �ʿ��� ��Ʈ��
		 */
		System.out.println(String.format("0x%X",bi3)+", int bitLength(): "+
		 bi3.bitLength()+", 2���� ���: "+(bi3.toString(2)));
		System.out.println("=========================================");
		/*
		 * boolean testBit(int n)
		 * :�������� n+1��° ��Ʈ�� 1�̸�  true, 0�̸� false
		 */
//		String binary_bi3 = bi3.toString(2);//����� ������ ���ڿ��� ��ȯ
		System.out.println("testBit(1): "+bi3.testBit(1));//true
		/*
		 * BigInteger setBit(int n)
		 * :�������� n+1��° ��Ʈ�� 1�� ����
		 */
		System.out.println("setBit(0): "+bi3.setBit(0));//23 (�������� 1�� �ٲپ��� ����)
		System.out.println("bi3: "+bi3);//22(�ּҷ� ��ȯ���� �ʱ⿡, ���� ��������
		//�ʴ���, �������� ����Ұ�
		//�̷��� �����ϱ�
		BigInteger cp = bi3.setBit(0);
		System.out.println("bi3.setBit(0): "+cp);//23
		
		
		/*
		 * BigInteger clearBit(int n)
		 * : �������� n+1��° ��Ʈ�� 0���� ����
		 */
		System.out.println("=========================================");
		BigInteger cp1 = bi3.clearBit(2);
		System.out.println("bi3.clearBit(2): "+cp1);//18
		
		/*
		 * BigInteger flipBit(int n)
		 * :�������� n+1��° ��Ʈ�� ���(0->1,1->0)
		 */
		System.out.println("=========================================");
		BigInteger cp2 = bi3;
		
		for(int i = 0 ; i < bi3.bitLength(); i++)
		{
			cp2 = cp2.flipBit(i);
		}
		System.out.println("now, flipped value: "+cp2);
		System.out.println("bi3: "+
		bi3.toString(2)+", cp2: "+
				cp2.toString(2));
		System.out.println("=========================================");
		
		/*
		 * byte[] toByteArray() -byte�迭�� ��ȯ
		 */
		System.out.println("toByteArray");
		System.out.println(cp2.toByteArray());
		byte[] arr = cp2.toByteArray();
		for(int i = 0 ; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");//9
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));//[9]
	}

}
