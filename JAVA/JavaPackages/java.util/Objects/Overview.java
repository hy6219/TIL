package com.util.objects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;


public class Overview {

	String name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * java.util.Objects 클래스의 유용한 메서드들
		 * 
		 * 1)isNull() - 해당 객체가 널인지 확인 후 null인 경우 ,true 반환
		 * 
		 * 2)nonNull() - 해당 객체가 널이 아닌지 확인, 널이 아닌 경우 true 반환
		 * 
		 * 3)requireNonNull() - 해당 객체가 널이 아니어야 할 필요성을 가함
		 * -->if(null){~}로 확인하였던 유효성검사를 보다 손쉽게 할 수 있게 됨
		 * 
		 * 4)compare(Object a, Object b, Comparator c)
		 *  : *Comparator- 두 객체를 비교하는 기준
		 *  -a와 b 두객체를 비교-> a== b : 0 반환
		 *  				  a > b : 양수 반환
		 *  				  a < b : 음수 반환
		 *  
		 * 
		 * 4)equals(Object a, Object b) -->
		 * *Object 클래스와 차이- 따로 Null 검사를 하지 않아도 됨
		 * 
		 * 5)deepEquals(Object a, Object b) --> 재귀적으로 객체 비교
		 * --> 다차원 배열 비교가 가능
		 * 
		 * 6)toString(Object o), toString(Object o , String nullDefault)
		 * : 장점- object가 null일때 대체할 수 있는 문자열 지정 가능(두번째 메서드)
		 * -내부적으로 null 체크 후 Object 클래스의 메서드를 호출
		 * 7)hashCode(Object o ), hashCode(Object...values)
		 * -내부적으로 null 체크 후 Object 클래스의 메서드를 호출
		 * -null일 경우 0 반환
		 * -가변인자를 이용한 두번째 메서드를 이용하면 기존
		 * 매개변수들의 조합으로 이루어졌던 hashCode 오버라이딩 된 부분의
		 * 수고를 조금이라도 줄일 수 있음!
		 * 
		 */
		
		String[][] str1 = new String[][] {
						{"aaa","bbb"},
						{"AAA","BBB"}
		};

		String[][] str2 = new String[][] {
			{"aaa","bbb"},
			{"AAA","BBB"}
		};
		
		
		boolean checker = false;
		int i = 0;
		
		System.out.println("str1");
		for(String[] k : str1)
		{
			for(String l : k)
			{
				System.out.println(l+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("str2");
		for(String[] k : str2)
		{
			for(String l : k)
			{
				System.out.println(l+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		checker = Objects.equals(str1, str2);
		System.out.println("Objects.equals");
		System.out.println(
				checker
				);//false
		System.out.println();
		System.out.println("Object.equals");
//		System.out.println(str1.equals(str2));
		//false -첫번째 행 주소에 대해서만 수행
		int cnt = 0 ;
		for(i = 0 ; i < str1.length; i++)
		{
			if(str1[i].equals(str2[i]))
			{
				//Object 클래스의 equals를 불러옴
				//따라서 주소를 비교하게 됨
				cnt ++;
			}
		}
//		System.out.println(cnt);
		if(cnt == str1.length && cnt == str2.length)
		{
			checker = true;
		}
		else
		{
			checker = false;
		}
		
		System.out.println(checker);//false
		
		System.out.println();
		
		/*
		 * 2차원배열에 대한 비교 deepEquals
		 */
		System.out.println(Objects.deepEquals(str1, str2));//true
		
		System.out.println();
		System.out.println("compare");
		
		//Comparator
		Comparator c = String.CASE_INSENSITIVE_ORDER;
		int j = 0 ;
		for(i = 0 ; i < str1.length; i ++)
		{
			for(j = 0 ; j  < str1[i].length; j++)
			{
				System.out.printf("str1[%d][%d]: %s, "
						+ "str2[%d][%d]: %s, compare: %d\n", i, j, str1[i][j],
						i, j, str2[i][j],
			Objects.compare(str1[i][j],str2[i][j],c));
			}
		}
		
		for(String[] k: str1)
		{
			System.out.print(Arrays.toString(k)+"\t");//[aaa, bbb]	[AAA, BBB]
		}
		
		int[][] arr = {
				
				{1, 2, 3},
				{4, 5, 6}
				
		};
		System.out.println();
		for(int[] k : arr)
		{
			System.out.print(Arrays.toString(k)+"\t");//[1, 2, 3]	[4, 5, 6]
		}
		System.out.println();
		
		String s = null;
		
		System.out.println(Objects.isNull(s));
		System.out.println(Objects.nonNull(s));
//		Card c1 = new Card();
//		c1.setName(s);
//		System.out.println(c1.name); 
		
		/*
		 * Exception in thread "main" java.lang.NullPointerException: null error
	at java.util.Objects.requireNonNull(Objects.java:228)
	at com.util.objects.Card.setName(Card.java:13)
	at com.util.objects.Overview.main(Overview.java:161)

		 */
		
		
		Card c2 = new Card();
		c2.setName("마라탕");
		System.out.println(c2.name);//마라탕
		
	}
	

}
