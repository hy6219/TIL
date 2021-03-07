package com.objectClass.clone.classArray.copy2;

public class CloneClassArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p = new Point[3];
		
		for(int i = 0; i < p.length; i++)
		{
			p[i] = new Point((i+1),(i+2));
		}
		
		Point[] cp = new Point[3];
		cp = p.clone();
		
		for(int i = 0 ; i < cp.length; i++)
		{
			System.out.println("p["+i+"]: "+p[i]+","
					+ " p["+i+"].hashcode: "+p[i].hashCode()+
					", identityHashCode: "+System.identityHashCode(p));
			System.out.println("cp["+i+"]: "+cp[i]+","
					+ " cp["+i+"].hashcode: "+cp[i].hashCode()+
					", identityHashCode: "+System.identityHashCode(cp));
			System.out.println("=========================");
			System.out.println();
		}
	}

}
