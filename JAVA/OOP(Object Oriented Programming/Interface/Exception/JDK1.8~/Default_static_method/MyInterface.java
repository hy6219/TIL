package interface_default_method;

public interface MyInterface {
	default void method1()
	{
		System.out.println("default method1() in MyInterface");
	}
	default void method2()
	{
		System.out.println("default method2() in MyInterface");
	}
	
	static void staticMethod()
	{
		System.out.println("static method in MyInterface");
	}
}
