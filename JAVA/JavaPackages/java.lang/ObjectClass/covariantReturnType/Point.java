package com.objectClass.covariantReturnType;

import java.util.Objects;

class Point implements Cloneable
{
	int x, y;
	
	Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		return "("+x+", "+y+")";
	}
	public int hashCode()
	{
		return Objects.hash(x,y);
	}
	
	/**
	 * 기존 clone의 제한자는 protected였는데
	 * 이를 구현하는 데에서는 protected나 public을 사용하면 되는데
	 * public을 사용하는 이유:
	 * 
	 * 상속관계가 없는 다른 클래스에서 호출 가능
	 */
	
	/**
	 * 공변 반환 타입(JDK 1.5~)
	 * -오버라이딩할 경우,
	 * 반환타입을 자손클래스 참조변수타입으로 할 수 있도록 함
	 * 
	 * -->실제로 반환되는 자손 객체의 타입으로 반환할 수 있게되어
	 * 번거로운 형변환이 생략될 수 있음!
	 */
	public Point clone()
	{
		Object obj = null;
		
		try
		{
			obj = super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			
		}
		return (Point)obj;
	}
}

