package interface_polymorphism_common;

public class Tank extends GroundUnit implements Repairable{
	Tank()
	{
		super(100);
	}
	/*
	 * return class name(Unit 주석 참조)
	 */
	@Override
	public String toString()
	{
		Tank t=new Tank();
		//https://stackoverflow.com/questions/2690333/how-to-get-the-name-of-a-class-without-the-package
		return t.getClass().getSimpleName();
	}
}
