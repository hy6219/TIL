package com.test01.after;

import java.util.Date;

public class SmartPhone extends DeskTop{


	private String mobileAgency; 	//Ελ½Ε»η
	
	public SmartPhone() {
		/* super(); */
		// TODO Auto-generated constructor stub
	}


	public SmartPhone(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os, String mobileAgency) {
		super(brand, productNumber, productCode, productName, price, date, cpu, hdd, ram, os);
		// TODO Auto-generated constructor stub
		this.mobileAgency = mobileAgency;
	}


	public String getMobileAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	@Override
	public String prn()
	{
		String s = super.prn();
		StringBuffer sb = 
				new StringBuffer(
						",mobileAgency: "+getMobileAgency());
		s += new String(sb);
		return s;
	}

	
}
