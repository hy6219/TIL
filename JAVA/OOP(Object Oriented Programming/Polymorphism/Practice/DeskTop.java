package com.test01.after;

import java.util.Date;

public class DeskTop extends Product{
	
	private String cpu;				//cpu
	private int hdd;				//하드디스크
	private int ram;				//램
	private String os;				//운영체제
	private boolean allInOne;		//일체형인지 아닌지 여부
	
	
	
	
	public DeskTop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeskTop(String brand, String productNumber, 
			String productCode, String productName, 
			int price, Date date, String cpu, int hdd, 
			int ram, String os, boolean allInOne) {
		super(brand, productNumber, productCode, productName, price, date);
		// TODO Auto-generated constructor stub
		
		this.cpu = cpu;
		this.hdd = hdd;
		this.allInOne = allInOne;
		this.os = os;
		this.ram = ram;
		
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public boolean isAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	@Override
	public String prn()
	{
		String s = super.prn();
		StringBuffer sb = 
				new StringBuffer(", cpu: "+getCpu()+
						", os : "+ getOs()+
						", hdd: "+ getHdd()+
						", ram: "+ getRam()+
						",allInOne: "+((isAllInOne())?"yes":"no"));
		s += new String(sb);
		return s;
	}
	
}
