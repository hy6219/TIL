package com.test01.after;

import java.util.Date;

public class Television extends Product{
	private int inchType;			//ÀÎÄ¡
	public Television() {
		/* super(); */
		// TODO Auto-generated constructor stub
	}

	public Television(String brand, String productNumber, 
			String productCode, String productName, int price,
			Date date, int inchType) {
		
		super(brand, productNumber, productCode, productName, price, date);
		// TODO Auto-generated constructor stub
		this.inchType = inchType;
	}

	public int getInchType() {
		return inchType;
	}

	public void setInchType(int inchType) {
		this.inchType = inchType;
	}
	
	@Override
	public String prn()
	{
		String s = super.prn();
		StringBuffer sb = 
				new StringBuffer(", inchType: "+getInchType());
		s += new String(sb);
		return s;
	}
	
}
