package com.test01.after;

import java.util.Date;

public class Product {
	private String brand; 			//������
	private String productNumber;	//��ǰ��ȣ
	private String productCode;		//��ǰ�ڵ�
	private String productName;		//��ǰ��
	private int price;				//����
	private Date date;				//��������
	
	public Product() {
	
		// TODO Auto-generated constructor stub
	}

	public Product(String brand, String productNumber, String productCode, String productName, int price, Date date) {
		Object obj = (Object) new Product();
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
		/*
		 * Polymorphism
		 */
		//A extends B��Ȳ���� object (parent class)-> child class�� television
		//, desktop, smartphone���� �ڵ� ����ȯ��
		System.out.println("["+(Run.i++)+"]");
		System.out.println(obj.getClass().getSimpleName()+" ������ ȣ�� �Ϸ�");
		System.out.println(this.getClass().getSimpleName()+" ������ ȣ�� �Ϸ�");
		System.out.println(this.getClass().getSimpleName()+" ������ ���� �ܰ�� �̵�");
		System.out.println();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String prn()
	{
		StringBuffer sb = 
				new StringBuffer("brand: "+getBrand()+", "+
						"productNumber: "+getProductNumber()+
						", productCode: "+getProductCode()+
						", productName: "+getProductName()+
						", price: "+getPrice()+
						", date: "+getDate());
		String s = new String(sb);
		return s;
	}
	
}
