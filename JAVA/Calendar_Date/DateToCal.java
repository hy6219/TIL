package com.part01_dateNcal;

import java.util.Calendar;
import java.util.Date;

public class DateToCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.Date �ν��Ͻ��� Calendar �ν��Ͻ��� ��ȯ�ϱ�
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(d);
		
		System.out.println("Date to Calendar: Calendar-"+
				cal+",\nDate - "+d);
	}

}
