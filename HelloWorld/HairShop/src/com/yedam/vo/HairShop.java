package com.yedam.vo;


public class HairShop {
	String product;// 상품
	int price;// 가격
	String des;// 설명


	int clientId;// 고객번호
	String clientName;// 이름
	String phone;// 연락처
	String birth;// 생일
	String rank;// 등급
	int pay;// 선불금

	String date;

	String designer;
	String reservation;
	
	int count;
	





	

	public HairShop() {
	}

	public HairShop(String clientName, String phone, int count) {
		super();
		this.clientName = clientName;
		this.phone = phone;
		this.count = count;
	}

	public HairShop(String reservation, String clientName, String phone, String product, String designer ) {
		super();
		this.product = product;
		this.clientName = clientName;
		this.phone = phone;
		this.designer = designer;
		this.reservation = reservation;
	}


	public HairShop(String clientName, String phone, String birth) {
		super();
		this.clientName = clientName;
		this.phone = phone;
		this.birth = birth;
	}

	public HairShop(String product, int price, String des) {
		this.product = product;
		this.price = price;
		this.des = des;
	}

	public HairShop(int clientId, String clientName, String phone, String birth, String rank, int pay) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.phone = phone;
		this.birth = birth;
		this.rank = rank;
		this.pay = pay;
	}

	public HairShop(int clientId, String clientName, String phone, String birth, int pay) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.phone = phone;
		this.birth = birth;
		this.pay = pay;
	}

	
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}	
	
	
	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}


}