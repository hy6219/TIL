package com.test01.after;

import java.util.Date;

public class SmartPhone extends Product{

	private String cpu;				//cpu
	private int hdd;				//�ϵ��ũ
	private int ram;				//��
	private String os;				//�ü��
	private String mobileAgency; 	//��Ż�
	
	public SmartPhone() {
		/* super(); */
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String brand, String productNumber, String productCode, String productName, int price,
			Date date, String cpu, int hdd, int ram, String os, String mobileAgency) {
		super(brand, productNumber, productCode, productName, price, date);
		// TODO Auto-generated constructor stub
		
		this.cpu = cpu;
		this.hdd = hdd;
		this.mobileAgency = mobileAgency;
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
				new StringBuffer(", cpu: "+getCpu()+
						", os : "+ getOs()+
						", hdd: "+ getHdd()+
						", ram: "+ getRam()+
						",mobileAgency: "+getMobileAgency());
		s += new String(sb);
		return s;
	}

	
}
