package interface_default_method;

public interface MyInterface2 {
	default void method1()
	{
		System.out.println("default method1() in MyInterface2");
	}
	static void staticMethod()
	{
		System.out.println("static method in MyInterface2");
	}
}
