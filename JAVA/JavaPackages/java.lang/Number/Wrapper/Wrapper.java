package com.lang.number.wrapper;

public class Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = new Integer(3);
		Integer i2 = new Integer("3");
		Character c =new Character('a');
		Byte b = new Byte("10");
		Byte b2 = new Byte((byte) 10);
		
		Short s = new Short((short) 3);
		Short s2 = new Short("3");
		
		Long l = new Long((long)(Integer.MAX_VALUE) + 1);
//		Long l2 = new Long("str");  java.lang.NumberFormatException
		Long l2 = new Long(String.valueOf((long)(Integer.MAX_VALUE) + 1));
		
		Float f = new Float(3.14f);
		Float f2 = new Float("3.14f");
		
		Double d = new Double(3.14);
		Double d2 = new Double("3.14");
		
		System.out.println("i: "+ i+", i2: "+i2+
				"\n ,c: "+ c+
				",\n b: "+b+", b2: "+ b2+",\n"+
				" l: "+l+", l2: "+ l2+
				"\n, f: "+ f+", f2: "+f2+
				", d: "+d+", d2: "+d2);
		System.out.println("s: "+s+", s2:; "+s2);
		System.out.println("i==i2?: "+i2.equals(i));//true
		System.out.println("i2 compareTo i: "+i2.compareTo(i));//0 같다~
		System.out.println("Integer.SIZE: "+Integer.SIZE);//bits//32
		System.out.println("Integer.BYTES: "+Integer.BYTES);//bytes//4
		System.out.println("Integer.TYPTE: "+Integer.TYPE);//int
	}

}
