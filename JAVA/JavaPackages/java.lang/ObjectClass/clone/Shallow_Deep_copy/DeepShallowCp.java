package com.objectClass.clone.deepnShallow;

public class DeepShallowCp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle(new Point(1,1),3);
		Circle c2 ;
		Circle c3 ;
		/*
		 * 얕은 복사 :(객체/참조형 변수) 
		 * 		객체 내의 참조변수의 주소가 같아지는 것! --> 따라서 엄밀히 말하면, 두 객체가 다르다고
		 * 	    볼 수 있음
		 * 		String은 같은 클래스에 대해서 같은 해시코드를 반환하도록 되어있음!(<-메서드 정의를
		 * 참고하면, 31*~ 해시코드 식이 들어가 있음
		 * 		  (기본형 변수)
		 * 		변수의 주소가 같아지는 것!
		 */
//		//Before
//		
		System.out.println("===Before===");
		 System.out.println("c1: hashcode-"+c1.hashCode()+""
					+ ", identityHashCode: "+System.identityHashCode(c1)+
					", c1.center.hashCode:"+c1.center.hashCode()+","
							+ "c1.center identityHashcode: "+
					System.identityHashCode(c1.center)+"toString:\t"+c1.toString());
//		System.out.println("c2: hashcode-"+c2.hashCode()+""
//				+ ", identityHashCode: "+System.identityHashCode(c2)+
//				", toString:\t"+c2.toString());
//		System.out.println("c3: hashcode-"+c3.hashCode()+""
//				+ ", identityHashCode: "+System.identityHashCode(c3)+
//				", toString:\t"+c3.toString());
		//Shallow copy of c1 to c2
		c2 = c1.ShallowCopy();
		//Deep copy of c1 to c3
		c3 = c1.DeepCopy();
		
		//After
		
	   System.out.println("===After===");
	   System.out.println("c1: hashcode-"+c1.hashCode()+""
						+ ", identityHashCode: "+System.identityHashCode(c1)+
						", c1.center.hashCode:"+c1.center.hashCode()+","
								+ "c1.center identityHashcode: "+
						System.identityHashCode(c1.center)+"toString:\t"+c1.toString());
	   System.out.println("얇은 복사");
	   System.out.println("c2: hashcode-"+c2.hashCode()+""
				+ ", identityHashCode: "+System.identityHashCode(c2)+
				", c2.center.hashCode:"+c2.center.hashCode()+","
						+ "c2.center identityHashcode: "+
				System.identityHashCode(c2.center)+"toString:\t"+c2.toString());
	   System.out.println("깊은 복사");
	   System.out.println("c3: hashcode-"+c3.hashCode()+""
				+ ", identityHashCode: "+System.identityHashCode(c3)+
				", c3.center.hashCode:"+c3.center.hashCode()+","
						+ "c3.center identityHashcode: "+
				System.identityHashCode(c3.center)+"toString:\t"+c3.toString());
	   System.out.println(c1.equals(c2)); /*
	   얕은 복사를 하기 때문에 c1과 c2의 point 객체 주소가 같을 뿐, 다른 객체!
	   따라서 false 반환
	   */
	   System.out.println(c1.equals(c3));
	   
	    String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = "abc";
		String str4 = "abc";
		
		System.out.println("str1 hashCode: "+str1.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str1));
		System.out.println("str2 hashCode: "+str2.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str2));
		System.out.println("str3 hashCode: "+str3.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str3));
		System.out.println("str4 hashCode: "+str4.hashCode()+", "
				+ "System.identityHashCode: "+System.identityHashCode(str4));
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.equals(str3));
		
		System.out.println(str3.equals(str4));
	}

}
