package class_oop_referenceVar_casting;

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
public class CastingTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=null;//Parent class
		//child1(fireengine)
		FireEngine f1=new FireEngine();
		FireEngine f2=null;//for casting
		
		
		System.out.println("f1");
		f1.water();
		
	//	System.out.println("f2");
	//	f2.water(); java.lang.NullPointerException
		
		System.out.println("Parent<=Child: 형변환 생략 가능");
		car=f1;
		car.drive();
		//car.water(); car는 Parent class car의 메서드에만 접근 가능!
		System.out.println("Parent=>Child: 형변환 생략 불가");
		System.out.println("f2");
		f2=(FireEngine)car;
		f2.water();
		System.out.println("Child class가 멤버변수가 더 많기 때문에"
				+ "Parent class가 Child class가 되고 싶을 때에만"
				+ " casting해야할 필요!");
	}

}
