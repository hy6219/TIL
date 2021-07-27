package com.under03;

public class InstanceManager {
	/**
	 * 
	 * 인스턴스를 직접생성하지 않고
	 * 
	 * 메서드를 인터페이스를 통해 구현함으로써
	 * 인스턴스 제공
	 * ->다른 클래스의 인스턴스로  변경될 경우,
	 * 메서드 내용만 변경하면 됨! 
	 * 굳이 이를 받은 참조변수 클래스를 변경하지 않아도 됨!
	 */
	public static I getInstance()
	{
		return new B();
	}
}
