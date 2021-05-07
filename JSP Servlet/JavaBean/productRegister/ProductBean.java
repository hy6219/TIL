package com.jisoo.javabeans;

public class ProductBean {
	private String pName;
	private int price;
	private String exp;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPrice() {
		return String.valueOf(price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice(String price) {
		this.price = Integer.valueOf(price);
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	
}
