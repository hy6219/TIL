package com.objectClass.covariantReturnType;

public class CovariantReturnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(3,5);
		Point cp = p.clone();
		System.out.println("p: "+p.toString()+", p.hashcode: "+
				p.hashCode()+", identityHashCode: "+System.identityHashCode(p));
		System.out.println("cp: "+cp.toString()+", cp.hashcode: "+
				cp.hashCode()+", identityHashCode: "+System.identityHashCode(cp));
	}

}
