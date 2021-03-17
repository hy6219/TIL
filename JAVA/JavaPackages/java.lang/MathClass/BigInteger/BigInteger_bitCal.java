package com.lang.math.BigInteger;

import java.math.BigInteger;
import java.util.Arrays;

public class BigInteger_bitCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 비트연산 메서드
		 * 
		 * int bitCount() : 2진수로 표현했을 때 1의 개수
		 * (음수: 0의 개수)
		 * 
		 * 
		 */
		System.out.println("BigInteger 생성 및 int bitCount(), int bitLength()");
		//1)문자열로 생성
		BigInteger bi = new BigInteger("100000000000000");//1e8 는 부동소수점수 타입
		System.out.println(bi+" 를 2진수로 표현했을 때 1의 개수: "+bi.bitCount());
		
		//2)n진수의 값에 대한 문자열, n진수
		BigInteger bi2 = 
				new BigInteger("20",16);
		System.out.println(bi2+" 를 2진수로 표현했을 때 1의 개수: "+bi2.bitCount());
		
		//3)BigInteger.valueOf(숫자)로 생성
		BigInteger bi3=
				BigInteger.valueOf(22);
		System.out.println(bi3);
		/*
		 * int bitLength(): 2진수로 표현했을때 값을 표현하는데 필요한 비트수
		 */
		System.out.println(String.format("0x%X",bi3)+", int bitLength(): "+
		 bi3.bitLength()+", 2진수 출력: "+(bi3.toString(2)));
		System.out.println("=========================================");
		/*
		 * boolean testBit(int n)
		 * :우측에서 n+1번째 비트가 1이면  true, 0이면 false
		 */
//		String binary_bi3 = bi3.toString(2);//저장된 진법의 문자열로 변환
		System.out.println("testBit(1): "+bi3.testBit(1));//true
		/*
		 * BigInteger setBit(int n)
		 * :우측에서 n+1번째 비트를 1로 변경
		 */
		System.out.println("setBit(0): "+bi3.setBit(0));//23 (마지막을 1로 바꾸었기 때문)
		System.out.println("bi3: "+bi3);//22(주소로 반환하지 않기에, 따로 저장하지
		//않는한, 원래값을 출력할것
		//이렇게 저장하기
		BigInteger cp = bi3.setBit(0);
		System.out.println("bi3.setBit(0): "+cp);//23
		
		
		/*
		 * BigInteger clearBit(int n)
		 * : 우측에서 n+1번째 비트를 0으로 변경
		 */
		System.out.println("=========================================");
		BigInteger cp1 = bi3.clearBit(2);
		System.out.println("bi3.clearBit(2): "+cp1);//18
		
		/*
		 * BigInteger flipBit(int n)
		 * :우측에서 n+1번째 비트를 토글(0->1,1->0)
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
		 * byte[] toByteArray() -byte배열로 변환
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
