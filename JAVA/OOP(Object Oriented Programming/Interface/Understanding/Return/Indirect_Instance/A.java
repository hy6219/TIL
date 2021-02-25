package com.under03;

public class A {
	void methodA()
	{
		I i=InstanceManager.getInstance();//return type:I
		i.methodB();
		System.out.println(i.toString());
	}
}
