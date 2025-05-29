package com.yedam;

import java.util.Scanner;

public class Calendar {

	static boolean isLeapYear(int year) {
		// 윤년이면 true 평년이면 false		
		boolean leapYear=true;
		
		
		if (year % 4 == 0) {
			if (year % 100 != 0) {
				return true;
			} else if (year % 400 == 0) {
				return true;
			}

		}
		return false;
	}
}//class
//	static void showMonth() {
//		Scanner scn = new Scanner(System.in);
//		//Sun Mon Tue Wed Thu Fri Sat
//		//===========================
//		//                 1   2   3
//		
//		
//		int month = 1;
//		int lastDayAry [] = {31,28,31,30,31,30,31,31,30,31,30,31};
//		int space[]= {3,6,6,2,4,0,2,5,1,3,6,1};
//		//		System.out.println("월을 입력>> ");
////		month = Integer.parseInt(scn.nextLine());
////		System.out.printf("d% 월", month);
//		System.out.println("===========================");
//		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
//		System.out.println("===========================");
//		
//		for(int i=0; i<lastDayAry.length;i++) {
//			System.out.println(lastDayAry[i]);
//			
//		}
//		
//		
////		
////		for (int day = 0; day <lastDayAry; day++) {
////			System.out.printf("%4d", day);
////			if ((day) % 7 == 0) {
////				System.out.println();
////			}
////		}
//		
//	}//showMonth

// class
