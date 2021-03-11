package com.objectClass.getClass;

public class ClassEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c = new Card("HEART",3);
		Card c2 = null;
		try {
			c2 = Card.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getSimpleName());
		}//InstantiationException,IllegalAccessException 발생 가능
		
		Class cObj = c.getClass();//생성된 객체로부터 얻기
		Class cObj2= Card.class;//클래스 리터럴로부터 클래스명 얻기
		Class cObj3 = null;
		try {
			cObj3 = Class.forName("Card");//로딩단계 메모리에 아직 올라오지는 않음
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getClass().getSimpleName());
		}//클래스이름으로 얻기/
			
			
		Card c1 = null;
		try {
			c1 = Card.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getSimpleName());
		}
		
		System.out.println("Card c :"+c);
		System.out.println("Card c1 :"+c1);
		//클래스명만 출력
		System.out.println("c.getClass().getSimpleName() :"+cObj.getSimpleName());
		//접근제어자 예약어 class.패키지명.getClass.클래스명 출력
		System.out.println("c.getClass().toGenericString() :"+cObj.toGenericString());
		//class 패키지명.getClass.클래스명 출력
		System.out.println("c.getClass().toString():"+cObj.toString());
		
		/*
		 * https://homoefficio.github.io/2016/11/30/%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A6%AC%ED%84%B0%EB%9F%B4-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0-%EC%88%98%ED%8D%BC-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0/
		 * 
		 * 클래스 리터럴(Class Literal)은 String.class, Integer.class 등을 말하며, 
		 * String.class의 타입은 Class<String>, 
		 * Integer.class의 타입은 Class<Integer>다.
		 */
		System.out.println("========================================");
        System.out.println("Card.class.getSimpleName() :"+cObj2.getSimpleName());
		
		System.out.println("Card.class.toGenericString() :"+cObj2.toGenericString());
		
		System.out.println("Card.class.toString():"+cObj2.toString());

				
		System.out.println("========================================");
		System.out.println("Class.forName(\"Card\").getSimpleName() :"+cObj3.getSimpleName());
		
		System.out.println("Class.forName(\"Card\").toGenericString() :"+cObj3.toGenericString());
		
		System.out.println("Class.forName(\"Card\").toString():"+cObj3.toString());
	}

}
