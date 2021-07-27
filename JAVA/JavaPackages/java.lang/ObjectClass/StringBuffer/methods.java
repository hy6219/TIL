package com.objectClass.string.stringBuffer;

public class methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer();//버퍼크기 : 16글자 정도 들어갈 수 있음
		StringBuffer sb2 = new StringBuffer(32); //32만큼 
		StringBuffer sb3 = new StringBuffer("abcdefg");//7+16=23만큼
		/*
		 * int length():  StringBuffer 인스턴스에 저장된 문자열의 길이를 반환
		 * 
		 * int capacity() : StringBuffer 인스턴스의 내부 버퍼 크기 반환
		 */
		System.out.println("sb1: "+sb1+", sb1.length(): "+sb1.length()+", "
				+"capacity : "+sb1.capacity());
		System.out.println("sb2: "+sb2+", sb2.length(): "+sb2.length()+", "
				+"capacity : "+sb2.capacity());
		System.out.println("sb3: "+sb3+", sb3.length(): "+sb3.length()+", "
				+"capacity : "+sb3.capacity());
		/*
		 * 
		 * 
		 * sb1: , sb1.length(): 0, capacity : 16
sb2: , sb2.length(): 0, capacity : 32
sb3: abcdefg, sb3.length(): 7, capacity : 23
		 */
		System.out.println("===");
		sb1.append("def");
		System.out.println("sb1: "+sb1+", sb1.length(): "+sb1.length()+", "
				+"capacity : "+sb1.capacity());
/*
 * sb1: , sb1.length(): 0, capacity : 16
sb2: , sb2.length(): 0, capacity : 32
sb3: abcdefg, sb3.length(): 7, capacity : 23
===
sb1: def, sb1.length(): 3, capacity : 16
 */
		StringBuffer sb4 = sb2.append("def");//length는 변해도 capacity는 변하지 않음!
		System.out.println("sb2: "+sb2+", sb2.length(): "+sb2.length()+", "
				+"capacity : "+sb2.capacity()+",hashCode: "+sb2.hashCode());
		//capacity는 값이 변경되어도 변경되지 않음!
		
		System.out.println("sb4: "+sb4+", sb4.length(): "+sb4.length()+", "
				+"capacity : "+sb4.capacity()+",hashCode: "+sb4.hashCode());
		sb4.append(1.25f);
		System.out.println("sb4: "+sb4+", sb4.length(): "+sb4.length()+", "
				+"capacity : "+sb4.capacity()+",hashCode: "+sb4.hashCode());//길이는 7
		//capacity: 7+16=23
		/*
		 * 버퍼 크기가 작을때는? 그때도 과연 capacity가 그대로일까?
		 */
		
		StringBuffer sb5 = new StringBuffer(3);
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());//capacity: 3
		sb5.append("abcdef");
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());//capacity: 8
		
		System.out.println("===");
		/*
		 * char charAt(int index) : 지정된 인덱스(index)에 있는 문자를 반환
		 */
		System.out.println("sb5.charAt(2): "+sb5.charAt(2));//c
		
		System.out.println("===");
		/**
		 * StringBuffer deleteCharAt(int index) : 지정된 인덱스(index)에 있는
		 * 문자를 제거
		 */
		sb5.deleteCharAt(2);
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());//abdef
		
		/**
		 * StringBuffer delete(int start, int end) :
		 * start 인덱스부터 end-1 인덱스까지 삭제
		 */
		System.out.println("===");
		sb5.delete(1,4);//af
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/**
		 * StringBuffer insert(int pos, type t)
		 * : pos 인덱스 앞에 삽입!(중간삽입!)
		 * append는 뒤에서 삽입!
		 */
		System.out.println("===");
		sb5.insert(0, 1.2f); //1.2af
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		sb5.insert(1, false); //1false.2af
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/**
		 * StringBuffer replace(int start, int end, String str)
		 * : start~end-1 인덱스 범위를 str로 바꾸기!
		 */
		System.out.println("===");
		sb5.replace(2, 5, "true");//세자리를 넘어서면?
		//1ftruee.2af -->상관없다! start~end-1 의 문자열 일부를 그냥 str로 바꾸는 것!
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/**
		 * StringBuffer reverse()
		 * : StringBuffer 인스턴스에 저장되어 있는 문자열 순서를 거꾸로 나열!
		 */
		System.out.println("===");//
		sb5.reverse();//fa2.eeurtf1
		System.out.println("sb5: "+sb5+", sb5.length(): "+sb5.length()+", "
				+"capacity : "+sb5.capacity()+",hashCode: "+sb5.hashCode());
		
		/*
		 * void setLength(int newLength)
		 * : 지정된 길이로 문자열 길이 변경
		 * -길이를 늘리는 경우, 나머지 빈공간을 널문자로 채움
		 */
		StringBuffer ext = new StringBuffer("123456");
		System.out.println("ext length: "+ext.length()+", ext : "+ext+"]");//6
		//ext length: 6, ext : 123456]
		
		
		ext.setLength(10);
		System.out.println("ext length: "+ext.length()+", ext : "+ext+"]");//10
		//ext length: 10, ext : 123456    ]
		
		/*
		 * String substring(int start) -start ~ 끝까지
		 * String substring(int start, int end) - start ~ end-1까지
		 * 
		 * 문자열을 잘라냄
		 * 
		 */
		System.out.println("===");
		String s = ext.substring(1);//23456
		String s2 = ext.substring(1,4);//234
		System.out.println("ext: "+ext);
		System.out.println("s: "+s);
		System.out.println("s2: "+s2);
		/*
		 * substring은 return super.substring()이고
		 * 
		 * 다른 StringBuffer 반환메서드는 return this;로 되기 때문에 굳이
		 * 변수에 저장하지 않아도 됨
		 */
		
	}

}
