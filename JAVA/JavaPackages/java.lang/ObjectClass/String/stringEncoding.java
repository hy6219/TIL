package com.objectClass.string;

import java.util.StringJoiner;

public class stringEncoding {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str ="������";
		
		byte[] barr = str.getBytes("utf-8");//UTF-8�ε� �ص� ��
		byte[] barr2 = str.getBytes("CP949");
		
		System.out.println("UTF-8: "+joinByteArr(barr));
	}
	
	static String joinByteArr(byte[] barr)
	{
		StringJoiner sj = new StringJoiner(":","[","]");
		
		for(byte b: barr)
		{
			sj.add(String.format("%02X", b));
		}
		return sj.toString();
	}

}
