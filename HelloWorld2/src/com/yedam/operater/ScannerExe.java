package com.yedam.operater;

import java.util.Scanner;

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

//		while (true) {
//			System.out.println("1.메뉴 2.메뉴 3.메뉴 4.종료");
//			int menu = Integer.parseInt(scn.nextLine());//nextLine - 사용자의 입력을 기다림 Integer.parseInt("30");
//
//			if (menu == 1) {
//				System.out.println("1번 메뉴를 선택했습니다.");
//			} else if (menu == 2) {
//				System.out.println("2번 메뉴를 선택했습니다.");
//			} else if (menu == 3) {
//				System.out.println("3번 메뉴를 선택했습니다.");
//			} else if (menu == 4) {
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}else {
//				System.out.println("1~4번 중에 선택하세요.");
//			}
//			
//		}//end of while

		// 조건추가 10만원을 초과(x), 마이너스(x)
		int balance = 0;
		int m = 0;
		while (true) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine());// nextLine - 사용자의 입력을 기다림 Integer.parseInt("30");

			if (menu == 1) {
				System.out.println("입금액을 입력>");
				// 입금기능
				m = Integer.parseInt(scn.nextLine());
				
				if (balance + m > 100000) {
					System.out.println("10만 초과했습니다.");
				} else {
					balance += m;
				}
			} else if (menu == 2) {
				System.out.println("출금액을 입력>");
				m = Integer.parseInt(scn.nextLine());
				
				if (balance <m) {
					System.out.println("잔액이 부족합니다.");
				} else {
					balance -= m;
				}
			} else if (menu == 3) {
				System.out.println("잔액> " + balance);

			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1~4번 중에 선택하세요.");
			}

		} // end of while
		System.out.println("end of prog.");

	}// end of main

}
