package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
	
	public static void main(String[] args) {
	//1~1000 사이의 임의의 값을 생성. 임의의 값 randomValue 567
	//500 입력하면 입력 값보다 큽니다
	//정답입니다/ 프로그램 종료
	//시도횟수
    Scanner scn = new Scanner(System.in);
    int randomValue = (int) (Math.random() * 1000) + 1;
    System.out.println(randomValue);
    int count=0;
	while(true) {
		count++;
		System.out.println("숫자를 입력하세요");
		int result= Integer.parseInt(scn.nextLine());

	   if(randomValue>result) {
		   System.out.println("입력 값보다 큽니다");

	   }else if(randomValue<result){
		   System.out.println("입력 값보다 작습니다");

	   }else if(randomValue==result){

		   System.out.printf("정답 입니다 %d번 만에", count);
		   break;
	   }
	}
		
		
		
	}//end of main;
	
	
	
	
	
	public static void test() {
		int score = 90;
		// if
//		if (score >= 90) {
//			System.out.println("A");
//		} else if (score >= 80) {
//			System.out.println("B");
//		} else if (score >= 70) {
//			System.out.println("C");
//		} else {
//			System.out.println("불합격");
//		}//end of if
		
		
		score=score/10;//소수점을 버림
		switch(score) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("불합격");
		}//end of switch
		
		
		
		
	}//end of main
}
