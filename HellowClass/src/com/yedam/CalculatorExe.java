package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal = new Calculator();// 인스턴스 생성
		int num=10;//선언 예시
		String str ="❄";
		String result = cal.printStar(num, str);//매개값을 넣어줌
		System.out.println(result);
		
		
		double sum = cal.add(num, 10.5);//정수
		
		int[]numAry= {10,20,30};
		sum=cal.add(numAry);
		//정수배열을 매개값으로 받는 add 반환 유형은 double
		System.out.println("10");
		System.out.println(10);
		System.out.println(true);
		
		
		//Member[] w중에서 point가 큰 회원을 반환
		Member[] members= {new Member("user01","홍길동","1111",1000)//
						   ,new Member("user02","김민규","2222",2200)//
						   ,new Member("user03","황선홍","3333",2700)//
						   ,new Member("user04","홍명보","4444",1900)//
		};
		//반환유형(Member)
		Member member = cal.getMaxPoint(members);
		member.showInfo();
		
		
		
	
	}
	
}
