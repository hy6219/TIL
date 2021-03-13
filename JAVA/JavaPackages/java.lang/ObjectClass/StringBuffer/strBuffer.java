package com.objectClass.string.stringBuffer;

public class strBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * StringBuffer: String과 다르게 mutable함!
		 * :String과 비슷하게 값을 char형 배열로 참조함
		 * 
		 * 내부의 buffer의 크기를 StringBuffer 생성자를 이용해서 지정해줄 수 있음
		 * 
		 * [StringBuffer constructors]
		 * 
		 * (1)
		 * public StringBuffer(int capacity) {
        		super(capacity);
    			}+
    			AbstractStringBuilder(int capacity) {
        				value = new char[capacity];
    			}
    ==>
		 * public StringBuffer(int length)
		 * {
		 * 	  value = new char[length];
		 * 	  shared= false;
		 * }
		 * 
		 * (2)
		 * public StringBuffer()
		 * {
		 * 		super(16);//버퍼 크기를 지정하지 않으면 기본으로 16(16개 문자)만큼 잡음
		 * }
		 * 
		 * (3)
		 * public StringBuffer(String str)
		 * {
		 * 		this(str.length()+16);//지정한 문자열의 길이보다 16 더 크게 버퍼 생성
		 * 		append(str);
		 * }
		 * 
		 */
		
		StringBuffer sb = new StringBuffer("abc");
		System.out.println("sb: "+sb+", hashCode: "+sb.hashCode()+
				", identity: "+
				+System.identityHashCode(sb));
		StringBuffer sb1 = new StringBuffer("abc");
		System.out.println(sb.equals(sb1));//false
		System.out.println(new String(sb).equals(new String(sb1)));//true
		System.out.println("sb1: "+sb1+", hashCode: "+sb1.hashCode()+
				", identity: "+
				+System.identityHashCode(sb1));
		/*
		 * sb: abc, hashCode: 1829164700, identity: 1829164700
sb1: abc, hashCode: 2018699554, identity: 2018699554
		 */
		//해시코드를 적절하게 재정의하지 않았기 때문에
		//같은 값을 가져도 다른 해시코드를 반환
		sb.append("def");
		System.out.println("sb: "+sb+", hashCode: "+sb.hashCode()+
				", identity: "+
				+System.identityHashCode(sb));//주소는 변하지 않음
		StringBuffer sb2 = sb.append("ghi");
		System.out.println("sb2: "+sb2+", hashCode: "+sb2.hashCode()+
				", identity: "+
				+System.identityHashCode(sb2));//sb의 주소값이 저장됨
		//-->mutable함! 값이 변경될때 주소도 변경되는 것이 아닌, 같은 주소에서 값만 변경 가능!
		System.out.println(sb.equals(sb1));//false
		/*
		 * equals를 오버라이딩하지 않았기 때문!
		 */
		
//		String str = new String("abc");
//		String str2= "abc";
//		System.out.println(str.equals(str2));//동등
//		System.out.println(str.hashCode()+", "+str2.hashCode());//같은 해시코드값
//		System.out.println(System.identityHashCode(str));
//		System.out.println(System.identityHashCode(str2));
		
		
	}

}
