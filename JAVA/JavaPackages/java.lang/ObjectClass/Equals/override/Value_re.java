package com.objectClass.equals;

public class Value_re{
	int value;
	Value_re()
	{
		this(0);
	}
	Value_re(int value)
	{
		this.value=value;
	}
	/**
	 * equals로 Value_re값을 비교하기 위해서
	 * equals를 오버라이딩!(기존의 equals는 주소값으로 비교)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Value_re)
		{
			if(((Value_re) obj).value ==value)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}

