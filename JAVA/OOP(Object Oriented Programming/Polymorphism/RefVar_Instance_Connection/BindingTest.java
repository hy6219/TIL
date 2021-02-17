package class_polymorphism_connection;

class Parent
{
	int x=100;
	void method()
	{
		System.out.println("Parent Method");
	}
}
class Child extends Parent
{
	int x=200;//this.x!=super.x
	
	@Override
	void method()
	{
		System.out.println("Child Method");
	}
}

public class BindingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p=new Child();//casting
		Child c=new Child();
		/*
		Child c1=(Child)new Parent();
		인스턴스 타입만 체크하기 때문에 문제는 안됨
		하지만 ClassCastException이 발생(실행하면서
		참조타입확인하면서 체크됨)
		[
		  In this time, compiler check 'instance type(object! 
		  really existed type!
		  "for example,
		  		Parent p=new Child();
		  		this means, its Reference type: Parent,
		  		BUT IT IS BASED ON 'CHILD CONSTRUCTOR',
		  		SO ITS INSTANCE TYPE IS 'CHILD!'")'
		  (NOT REFERENCE(EX: Parent or Child) TYPE)!"
		  
		  <highlight>
		  BUT WHEN WE EXECUTE THIS CODES,
		    IT(child c1=(Child)new Parent();)
		     CAN MAKE 'java.lang.~~.classcastingexception'
		    because of reference type check!
		]
		
		//child멤버수>=Parent멤버수이므로 자체적으로 금지됨 
		Child c2=new Parent();
		 * */
		
		System.out.println("p.x= "+p.x);
		p.method();
		
		System.out.println("c.x= "+c.x);
		c.method();
		/*
		 * Parent p=new Child();로
		 * 조상타입의 참조변수(p)로 자손 인스턴스(new Child())를
		 * 참조하는 경우,
		 * 
		 * 1)메서드->생성된 인스턴스를 따라감
		 * 2)멤버변수->참조변수를 따라감!
		 * 
		 * =========================================
		 * IF REFER CHILD INSTANCE BY PARENT REFERENCE VARIABLE,
		 * 
		 * 1)METHOD: FOLLOW 'INSTANCE'
		 * 2)MEMBER VARIABLE: FOLLOW 'REFERENCE VARIABLE'
		 */
	}

}
