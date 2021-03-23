package com.part01_dateNcal;

import java.util.Calendar;
import java.util.Date;

public class CalToDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.Calendar->Date
		Calendar cal = Calendar.getInstance();
		Date d1 = new Date(cal.getTimeInMillis());
		
		System.out.println("Calendar to Date: Calendar-"+
							cal+",\nDate - "+d1);
		/*
		 * Calendar to Date: Calendar-java.util.GregorianCalendar[time=1616461061509,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2021,MONTH=2,WEEK_OF_YEAR=13,WEEK_OF_MONTH=4,DAY_OF_MONTH=23,DAY_OF_YEAR=82,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=4,AM_PM=0,HOUR=9,HOUR_OF_DAY=9,MINUTE=57,SECOND=41,MILLISECOND=509,ZONE_OFFSET=32400000,DST_OFFSET=0],
Date - Tue Mar 23 09:57:41 KST 2021
		 */
	}

}
