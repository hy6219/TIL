package interface_polymorphism_common;

public class Dropship extends AirUnit implements Repairable{
	
	Dropship()
	{
		super(50);
	}
	/*
	 * return class name(Unit 주석 참조)
	 */
	@Override
	public String toString()
	{
		Dropship d=new Dropship();
		//https://stackoverflow.com/questions/2690333/how-to-get-the-name-of-a-class-without-the-package
		
		return d.getClass().getSimpleName();
	}
}
