package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		
		CellPhone phone1 = new CellPhone();//기본생성자없음
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());

		// 자식클래스
		CellPhone phone2 = new SamrtPhone();//부모클래스를 자식클래스에 할당할수 잇음
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();//부모 클래스에 있는 것만 실행가능
		
		
		
		SamrtPhone phone3=null;
		if(phone2 instanceof SamrtPhone) {
	    phone3 =(SamrtPhone)phone2;//캐스팅
		phone3.channel = 2;
		phone3.watch();
		}
		
		//instanceof 메소드 변환 가능 한지 체크
		if(phone1 instanceof SamrtPhone) {
		phone3= (SamrtPhone) phone1;
		phone3.channel = 3;
		phone3.watch();//실행에러 남
		}
	}
	}
