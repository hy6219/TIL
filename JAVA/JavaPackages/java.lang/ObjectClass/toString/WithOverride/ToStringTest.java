package com.objectClass.toString.withOverride;

import java.util.Date;

public class ToStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 123;
		double d = 12.345;
		float f = 23.456F;
		
		Date date = new Date();
		
		/*
		 *  
		 *Integer 클래스 내에 있는 toString()  
		 public static String toString(int i, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            radix = 10;

        if (radix == 10) {
            return toString(i);
        }

        char buf[] = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }
		 */
		
		System.out.println("i.toString(): "+Integer.toString(i));
		System.out.println("i.toHexString(): "+Integer.toHexString(i));
		System.out.println("d.toString(): "+Double.toString(d));
		System.out.println("d.toHexString(): "+Double.toHexString(d));
		System.out.println("f.toString(): "+Float.toString(f));
		System.out.println("f.toHexString(): "+Float.toHexString(f));
		
		System.out.println("date.toString: "+date.toString());
//		System.out.println("date"+date.toLocaleString());//The method toLocaleString() from the type Date is deprecated
//		date.toGMTString(); //deprecated!
		
	
	}

}
