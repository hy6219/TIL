package BindingTest2;


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
	
}

public class BindingTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p=new Child();//casting
		Child c=new Child();
		/*
		 * 
		 * IN CHILD CLASS,
		 *  	"NO MEMBER VARIABLE 'x'"
		 *  
		 *  SO, IN THIS TIME, PARENT.X IS INHERITED TO
		 *  CHILD CLASS WITHOUT CHANGE(VALUE)
		 *  
		 *  SO!! THIS.X==SUPER.X
		 *  
		 *  PLUS!
		 *  WE DIDN'T DO @OVERRIDE
		 *  
		 *  SO!! THIS.METHOD()==SUPER.METHOD()
		 */
		System.out.println("p.x= "+p.x);
		p.method();
		
		System.out.println("c.x= "+c.x);
		c.method();
	}

}
