package interface_default_method;

public class Child extends Parent implements MyInterface, MyInterface2{

	/**
	 * 이름이 같은 메서드가 두개 이상 인터페이스에
	 * 존재할 경우,
	 * 인터페이스 1과 인터페이스 2 중 한 곳에
	 * 있는 메서드를 오버라이딩해주기!
	 * 
	 * 1)overriding
	 * public void method1(){A}
	 * public void method1(){B}
	 * 
	 * ++오버라이딩: 리턴타입, 매개변수, 이름이
	 * 같은데!!
	 * 내용이 다른것!
	 * 
	 * 2)overloading
	 * public void method(){}
	 * public void method(int x){}
	 * public void method(int x, int y){}
	 * public int method(int x){return x;}
	 *++오버로딩: 매개변수 or 리턴타입이 달라야 함!-->
	 *근본적으로 같은 기능을 하지만 
	 *작명을 하는 과정 등이 번거로움이 존재하는데
	 *이를 막을 수 있음
	 *
	 *
	 */
	//MyInterface,MyInterface2에 method1이 겹침!
	//-->오버라이딩해야!
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("method1() in Child");
	}


}
