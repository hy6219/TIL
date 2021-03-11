package com.test01.after;

import java.util.Date;


public class Run {
	public static int i = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * public DeskTop(String brand, String productNumber, 
			String productCode, String productName, 
			int price, Date date, String cpu, int hdd, 
			int ram, String os, boolean allInOne)
		 */
		DeskTop d = new DeskTop("samsung","S-123" ,
				"01","Samsung monitor", 1000000, new Date(), 
				"Intel i5", 500, 16, "Window 10", false);
		/*
		 * public Television(String brand, String productNumber, 
			String productCode, String productName, int price,
			Date date, int inchType)
		 */
		System.out.println();
		System.out.println("========================================");
		Television t = new Television("LG","T-321","03", "LG TV",
				5000000, new Date(), 46);
		/**
		 * public SmartPhone(String brand, String productNumber,
		 *  String productCode, String productName, int price,
			Date date, String cpu, int hdd, int ram, String os, 
			String mobileAgency)
		 */
		System.out.println();
		System.out.println("========================================");
		SmartPhone s = new SmartPhone("samsung",  "G-1234",
				"02", "galaxy21", 800000, new Date(),
				"Qualcom snapdragon",500, 16, "android", "KT");
		System.out.println();
		System.out.println("========================================");
		System.out.println(d.prn());
		System.out.println(t.prn());
		System.out.println(s.prn());
	}

}
