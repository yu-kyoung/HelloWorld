package com.yedam;

import java.util.Scanner;

public class JSExe {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);

//		System.out.println(str1.equals(str2)); // 문자열을 비교할때는 .equals를 사용

		//test2();// 호출
//		test3();//스캐너 입력
		test4();
	}// end of main

	public static void test() {
		int sum = 0;
		// 1부터 10까지의 값을 누적하는 반복문.
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과: " + sum);

	}// end of test

	public static void test2() {

		// 임의의 수를 생성.30~100사이의 임의의 수 생성
		// 평균: 소수점까지
		int sum = 0;
		for (int i = 1; i <= 7; i++) {
			int result = (int) (Math.random() * 71) + 30;// 0<= x <1★ 30<=x<101 실수 캐스팅 중요
			sum += result;
		}
		double avg = sum / 7.0;// ★ 소수점 표현

		System.out.println("평균 " + avg + " 합계 " + sum);
		System.out.println(Math.round(avg * 100) / 100.0);

		// "30" vs 30 숫자와 문자 비교
		String str3 = "30";
		int num3 = 30;
		System.out.println(str3.equals("" + num3));
		int num4 = Integer.parseInt(str3);// ★문자열 ->숫자로 변경
		System.out.println(num3 == num4);// 모니터 출력
	}// end of test2

	public static void test3() {
		// 사용자의 입력값을 읽어들이기.컨트롤 쉬프트 o
		Scanner scn = new Scanner(System.in);// 키보드 입력
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine();// 입력값을 문자열 형태로 반환.
			int score = Integer.parseInt(value);// (정수)숫자로 변환
			sum += score;
		}
		double avg = sum / 3.0;// ★ 소수점 표현

		System.out.println("평균 " + avg + " 합계 " + sum);
		System.out.println(Math.round(avg * 100) / 100.0);

	}// end of test3

	public static void test4() {
		
		Scanner scn=new Scanner(System.in);
		
		String str= "친구목록은";
		while(true) {
			System.out.println("친구이름을 입력하세요.종료 quit>>");
			String msg=scn.nextLine();	
			//equals로 비교
			if(msg.equals("quit")) {
				str += "입니다";
				break;
			}			
			System.out.println("친구목록은 "+msg);
			str += msg + ", ";//+= 누적하겠다는 의미
		}
		//홍길동, 김민규, 최석영 
		//친구목록은 , , , , 입니다.
		System.out.println(str);
		System.out.println("end of prog.");
		
		
	}//end of test4
	
	
	
	
}// end of class
