package com.yedam.vo;

public class HairShop {
	String product;// 상품
	int price;// 가격
	String des;// 설명
	
	
	public HairShop(String product, int price, String des) {
		super();
		this.product = product;
		this.price = price;
		this.des = des;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}

	
}