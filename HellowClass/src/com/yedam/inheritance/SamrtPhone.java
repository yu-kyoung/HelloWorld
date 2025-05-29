package com.yedam.inheritance;

//CellPhone 상속
public class SamrtPhone extends CellPhone {// 부모 클래스를 상속 extends
	int channel;
	public SamrtPhone() {}
	public SamrtPhone(String model, String color, int channel) {
		super(model,color);//
		this.channel=channel;
	}
	
	void watch() {
		System.out.println(channel + "을 시청합니다.");
	}

	// 부모클래스의 기능을 자식클래스에서 다시정의(overriding) 할 수 있음
	@Override
	public void powerOn() {
		System.out.println("전원을 켭니다🎀");
	}

	@Override
	public void powerOff() {//부모가 퍼블릭이면 자식도 퍼블릭, 퍼블릭 이상은 불가능
		System.out.println("전원을 끕니다🎀");
	}
//super=부모
	@Override
	public String toString() {
		return "SamrtPhone [channel=" + channel + "]";
	}
	
	

}