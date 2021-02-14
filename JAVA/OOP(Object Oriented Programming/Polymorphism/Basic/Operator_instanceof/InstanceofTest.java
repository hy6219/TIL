package class_oop_instanceof;


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

public class InstanceofTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FireEngine fe=new FireEngine();
		Car c=new Car();
		if(fe instanceof FireEngine)
		{
			System.out.println("fe is reference variable "
					+ "whose type is 'FireEngine'");
		}
		else
		{
			System.out.println("Check again,plz");
			System.out.println("reference var fe isn't FireEngine instance");
		}
		
		if(fe instanceof Car)
		{
			System.out.println("fe is reference variable "
					+ "whose type is 'Car'");
		}
		else
		{
			System.out.println("Check again,plz");
			System.out.println("reference var fe isn't Car instance");
		}
		if(c instanceof FireEngine)
		{
			System.out.println("fe is reference variable "
					+ "whose type is 'FireEngine'");
		}
		else
		{
			System.out.println("Check again,plz");
			System.out.println("reference var c isn't FireEngine instance");
		}
		//클래스 이름을 출력
		System.out.println(fe.getClass());
		System.out.println(fe.getClass().getName());
		/*
		 * [1]Obj.getClass()
		 * --
		 * class class_oop_instanceof.FireEngine 을 return
		 * -->class package.obj의 클래스  형식으로 반환
		 * 
		 * 
		 * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
		 * 
		 * 
		 * [2]클래스명 출력 Obj.getClass().getName()
		 * ==package name.obj의 클래스 형식으로 반환
		 * 
		 * https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html
		 * 
		 * 
		 */
	}

}
