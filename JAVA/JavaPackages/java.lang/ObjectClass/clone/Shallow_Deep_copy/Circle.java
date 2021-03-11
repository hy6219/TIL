package com.objectClass.clone.deepnShallow;

import java.util.Objects;

public class Circle implements Cloneable{
	
	//원점
	Point center;
	//반지름
	double radius;
	
	Circle(Point center, double radius)
	{
		this.center = center;
		this.radius = radius;
	}
	
	//Shallow-copy
	public Circle ShallowCopy()
	{
		Object obj = null;
		
		try
		{
			obj = super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			
		}
		
		return (Circle)obj;
	}
	
	//Deep-copy
	public Circle DeepCopy()
	{
		Object obj = null;
		try
		{
			obj = super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			
		}
		//casting//아직 obj = new Object()로 생성하지 않았으므로 컴파일 후 에러는 없을것
		Circle c = (Circle)obj;
		
		//값만 복사
		c.center = new Point(this.center.x, this.center.y);
		
		return c;
	}
	
	@Override
	public String toString()
	{
		return "[center = "+ center+", radius: "+radius+"]";
	}

	/**
	 * +실질적으로 가리키는 주소는 같은데 다른 주소를 반환할 경우를 대비!
	 * 동등성 원칙에 따라 hashcode도 오버라이딩
	 * -https://mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
	 * -https://nesoy.github.io/articles/2018-06/Java-equals-hashcode
	 */

	
}
