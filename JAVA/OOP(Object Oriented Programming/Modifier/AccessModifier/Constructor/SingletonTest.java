package class_oop_access_modifier_constructor;

/*final class*/
final class Singleton
{
	/*
	 * Why static?
	 * : must excute method without instance object
	 * (why no instance?: private)
	 * 
	 * 
	 * 인스턴스 생성이 private로 인하여 불가능하므로
	 * 클래스 변수 생성이 필요함!
	 * 마찬가지로, 클래스 메서드가 필요하므로
	 * static 선언!
	 * */
	private static Singleton s=new Singleton();
	
	private Singleton()
	{
		
	}
	public static Singleton getInstance()
	{
		if(s==null)
		{
			s=new Singleton();
		}
		System.out.println("Hard to access!");
		System.out.println("Can't be Parent class: ");
		System.out.println("Because private constructor make hard to"
				+ " access or call Parent constructor in "
				+ "Child class");
		return s;
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 다행히도, class는 final이라서,
		 * 상속 외에는 문제는 안됨
		 */
	/*	Singleton s=new Singleton();
	 * Warning: 'The constructor is not visible'
	 * */
		Singleton t=Singleton.getInstance();
	}

}
