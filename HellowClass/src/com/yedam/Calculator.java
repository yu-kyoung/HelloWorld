package com.yedam;

import com.yedam.member.Member;

public class Calculator {
//메소드선언
//매개변수
//반환유형
	// 필드
	// 생성자
	// 메소드
	// void 리턴값 없음
	
	//리턴값(유형) 이름 매개변수 
	String printStar(int times, String shape) {// 매개변수(times)
		String str = "";

		for (int i = 1; i <= times; i++) {
//			System.out.println(shape);
			str += shape + "\n";
		}
		return str;
	}//printstarㄴ
	
	
	
	//메소드 오버로딩 
//	(중복정리 가증 변수 개수가 달라야함.타입 다름)
	int add(int num1, int num2){
		return num1 + num2;
	}

	double add(double num1,double num2) {
		return num2 + num2;
	}

	//배열
	 double add(int[] ary) {
		int sum=0;
		for(int i=0; i<ary.length;i++ )
		{
			sum += ary[i];
		}		
		return sum;
	 }



	 Member getMaxPoint(Member[] memberArray) {
			// 결과값
			Member max = null;

			int maxPoint = 0;// 포인트를 비교하기위한 변수
			for (int i = 0; i < memberArray.length; i++) {
				if (maxPoint < memberArray[i].getPoint()) {
					maxPoint = memberArray[i].getPoint();
					max = memberArray[i];

				}

			}

			return max;
		}
	
	
	 
	 
}
