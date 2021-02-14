package class_oop_refVar_casting2;

import class_oop_referenceVar_casting.Car;

class Car
{
	String color;
	int door;
	
	void drive()
	{
		//운전
		System.out.println("Let's Drive!");
	}
	void stop()
	{
		//정지
		System.out.println("STOP!!");
	}
}
class FireEngine extends Car
{
	void water()
	{
		System.out.println("WATER!!");
	}
}

public class CastingTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car();
		Car car2=null;
		FireEngine fe=null;
		
		car.drive();
		fe=(FireEngine)car;
		/**
		 * CastingTest1.java에서도 동일하게
		 * Parent타입 인스턴스를 Child타입의 인스턴스로 참조하려고
		 * 했었지만, 문제가 되지 않았던 이유
		 * 
		 * :
		 * 1)컴파일러가 '참조변수간의 타입'만을 확인
		 * ->생성될 인스턴스의 타입을 고려하지 않음
		 * 2)결론적으로 CastingTest1.java에서는 FireEngine의 메서드를
		 * 접근하였지만, CasttingTest2.java에서는 Parent class인
		 * Car class의 메서드에 접근
		 * 
		 * -->java.lang.ClassCastException 발생
		 */
		fe.drive();
		car2=fe;
		car2.drive();
	}

}
