package com.under03;

public class B implements I{

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("methodB in B class");
	}
	
	public String toString()
	{
		return new B().getClass().getSimpleName();
	}
	
}
