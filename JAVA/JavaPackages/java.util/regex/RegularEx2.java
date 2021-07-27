package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "HP: 011-1234-5678	, HOME: 02-123-4567";
		//0.String���� pattern�� ���� ���� ������ ����
		String pattern1 ="(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		String pattern2 ="(\\d{2,3})-(\\d{3,4})-(\\d{4})";
		
		//1.���ϰ�ü �����
		Pattern p1 = Pattern.compile(pattern1);
		Pattern p2 = Pattern.compile(pattern2);
		
		//2.matcher ��ü �����
		Matcher m1 = p1.matcher(source);
		Matcher m2 = p2.matcher(source);
		
		//3.find()-�־��� �ҽ� ������ ���ϰ� ��ġ�ϴ� �κ��� ã�Ƴ��� true��ȯ
		int i = 0;
		while(m1.find())
		{
			System.out.println(
					(++i)+":"+m1.group()+" ->"+
					m1.group(1)+" "+m1.group(2)+
					" "+m1.group(3)
					
					);
			
		}
		
		System.out.println();
		System.out.println("===================================================");
		i = 0;
		while(m2.find())
		{
			System.out.println(
					(++i)+":"+m2.group()+" ->"+
					m2.group(1)+" "+m2.group(2)+
					" "+m2.group(3)
					
					);
			
		}
	}

}
