package com.yedam.inheritance;

//부모 클래스 cellphone
//-전원 켜기, 끄기, 볼륨up, down,통화
//-model. color
//자식 클래스 smartphone
//-tv보기
public class CellPhone extends Object {//최상위 =오브젝트
	String model;
	String color;
	public CellPhone(){}
	
	
	public CellPhone(String model, String color) {
		this.model=model;
		this.color=color;
	}
	
	
	
 public	void powerOn() {
		System.out.println("전원켜기");
	}

 public	void powerOff() {
		System.out.println("전원끄기");
	}

	void 통화하기() {
		System.out.println("통화하기");
	}
	
	//toString ()오버라이딩
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}//오른쪽 소스 tostring
	
	
	
	
	
}
