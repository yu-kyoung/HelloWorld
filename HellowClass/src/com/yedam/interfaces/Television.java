package com.yedam.interfaces;
//클래스  remoteControl 인터페이스를 상속(x) 구현클래스
public class Television implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("텔레비전을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("텔레비전을 끕니다.");

	}
 //인터페이스의 변수에 구현 클래스의 인스턴스를 할당

}
