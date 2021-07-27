package com.util.objects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;


public class Overview {

	String name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * java.util.Objects Ŭ������ ������ �޼����
		 * 
		 * 1)isNull() - �ش� ��ü�� ������ Ȯ�� �� null�� ��� ,true ��ȯ
		 * 
		 * 2)nonNull() - �ش� ��ü�� ���� �ƴ��� Ȯ��, ���� �ƴ� ��� true ��ȯ
		 * 
		 * 3)requireNonNull() - �ش� ��ü�� ���� �ƴϾ�� �� �ʿ伺�� ����
		 * -->if(null){~}�� Ȯ���Ͽ��� ��ȿ���˻縦 ���� �ս��� �� �� �ְ� ��
		 * 
		 * 4)compare(Object a, Object b, Comparator c)
		 *  : *Comparator- �� ��ü�� ���ϴ� ����
		 *  -a�� b �ΰ�ü�� ��-> a== b : 0 ��ȯ
		 *  				  a > b : ��� ��ȯ
		 *  				  a < b : ���� ��ȯ
		 *  
		 * 
		 * 4)equals(Object a, Object b) -->
		 * *Object Ŭ������ ����- ���� Null �˻縦 ���� �ʾƵ� ��
		 * 
		 * 5)deepEquals(Object a, Object b) --> ��������� ��ü ��
		 * --> ������ �迭 �񱳰� ����
		 * 
		 * 6)toString(Object o), toString(Object o , String nullDefault)
		 * : ����- object�� null�϶� ��ü�� �� �ִ� ���ڿ� ���� ����(�ι�° �޼���)
		 * -���������� null üũ �� Object Ŭ������ �޼��带 ȣ��
		 * 7)hashCode(Object o ), hashCode(Object...values)
		 * -���������� null üũ �� Object Ŭ������ �޼��带 ȣ��
		 * -null�� ��� 0 ��ȯ
		 * -�������ڸ� �̿��� �ι�° �޼��带 �̿��ϸ� ����
		 * �Ű��������� �������� �̷������ hashCode �������̵� �� �κ���
		 * ���� �����̶� ���� �� ����!
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
		//false -ù��° �� �ּҿ� ���ؼ��� ����
		int cnt = 0 ;
		for(i = 0 ; i < str1.length; i++)
		{
			if(str1[i].equals(str2[i]))
			{
				//Object Ŭ������ equals�� �ҷ���
				//���� �ּҸ� ���ϰ� ��
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
		 * 2�����迭�� ���� �� deepEquals
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
		c2.setName("������");
		System.out.println(c2.name);//������
		
	}
	

}
