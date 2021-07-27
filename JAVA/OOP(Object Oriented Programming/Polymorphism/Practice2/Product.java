package com.test01.after;

import java.util.Date;

public class Product {
	private String brand; 			//제조사
	private String productNumber;	//상품번호
	private String productCode;		//상품코드
	private String productName;		//상품명
	private int price;				//가격
	private Date date;				//제조일자
	
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
		//A extends B상황에서 object (parent class)-> child class인 television
		//, desktop, smartphone으로 자동 형변환됨
		System.out.println("["+(Run.i++)+"]");
		System.out.println(obj.getClass().getSimpleName()+" 생성자 호출 완료");
		System.out.println(this.getClass().getSimpleName()+" 생성자 호출 완료");
		System.out.println(this.getClass().getSimpleName()+" 생성자 다음 단계로 이동");
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
