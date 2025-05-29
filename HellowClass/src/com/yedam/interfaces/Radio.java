package com.yedam.interfaces;
//remotecontrol을 구현하는 클래스
public class Radio implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("라디오를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("라디오를 끕니다.");
	}
	

//	RemoteControl rc=new Television();
//	rc.turnOn();
//	rc.turnOff();
}
