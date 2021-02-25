package interface_default_method;

public class DefaultMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c=new Child();
		System.out.println("다양한 인터페이스 내 "
				+ "메서드 명이 같으면 "
				+ "'인터페이스를 구현한 클래스'에서"
				+ " 디폴트 메서드를 오버라이딩!");
		c.method1();//override
		System.out.println("조상 클래스 내에 있는 메서드와"
				+ " 인터페이스 내에 있는 디폴드 메서드의 이름이"
				+ " 같으면 디폴트 메서드는 무시!");
		c.method2();//Parent
		//static 메서드는 인터페이스 안에 있음
		/*method2는 조상클래스인 Parent 내에 있는 것과
		 * MyInterface 내에 있는것이 이름이 같음!
		 * 따라서 인터페이스메서드가 아닌 Parent클래스에
		 * 있는 것이 호출될 것
		 * 
		 */
		//static 메서드가 제어자가 default이므로
		//클래스명으로 접근
		System.out.println("인터페이스-static method");
		System.out.println("MyInterface");
		MyInterface.staticMethod();
		System.out.println("MyInterface2");
		MyInterface2.staticMethod();
	}

}
