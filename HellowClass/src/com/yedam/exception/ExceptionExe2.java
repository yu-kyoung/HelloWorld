package com.yedam.exception;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.메뉴 2.종료");
			System.out.print("선택 >> ");
			int menu = 0;

			while (true) {//적절한 값을 선택할때 까지 무한 반복
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException  e) {
					System.out.println("1.메뉴 2.종료");
					System.out.println("메뉴를 다시선택");
					continue;//처음으로 돌아가 반복
				
				}
				break;//정상적인 실행 계속
			}

			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
				break;
			default:
				System.out.println("없는 메뉴를 선택해 종료함");
				run = false;
			}

		}
		System.out.println("end of prog");
		scn.close();//메인메소드에서만 사용
	}// main

	
	
	public static void 백업() {

		// NullPointerException
		// NumverFarmatException
		// ClassCastException
		// ArrayIndexOutOfBoundsException
		Scanner scanner = new Scanner(System.in);// 리소스

		String str = scanner.nextLine();
		try {
			System.out.print(str.toString());
			int num = Integer.parseInt("a");

		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("Null 값 비정상");
//		} catch (NumberFormatException e) {
//			System.out.println("포맷이 비정상");
		} finally {
			// 정상실행, 예외 발생 이건 반드시 실행해야할 코드
//			scanner.close();// 리소스를 환원. 스캐너 워닝 오류
		}
		System.out.println("end of prog");
	}
}
