package com.objectClass.cloneClass;

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
	
	/**
	 * 기존 clone의 제한자는 protected였는데
	 * 이를 구현하는 데에서는 protected나 public을 사용하면 되는데
	 * public을 사용하는 이유:
	 * 
	 * 상속관계가 없는 다른 클래스에서 호출 가능
	 */
	public Object clone()
	{
		Object obj = null;
		
		try
		{
			obj = super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			
		}
		return obj;
	}
}
