package com.objectClass.cloneClass;


public class CloneClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(3,5);
		Point cp = (Point)p.clone();
		System.out.println(p.toString());
		System.out.println(cp.toString());
	}

}
