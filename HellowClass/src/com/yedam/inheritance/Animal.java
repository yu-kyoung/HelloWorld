package com.yedam.inheritance;
//추상클래스:인스턴스 생성 불가, 추상메소드 사용가능
//자식클래스 bird, fish
public abstract class Animal {
	String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	//추상메소드 : 자식 클래스 에서 반드시 재 정의를 해줘야함
	public abstract void sound();
	//규칙을 새워야 할 경우
	
}
