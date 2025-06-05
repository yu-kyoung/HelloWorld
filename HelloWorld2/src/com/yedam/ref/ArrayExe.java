package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {

//		strAry();
//		deleteAry();
		friendApp();

	}// end of main

	// 문자열배열
	public static void strAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언
		String[] stringAry = new String[10];// 입력값을 저장

		while (true) {
			System.out.print("이름을 입력>> ");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break;
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간 널인지 확인하고 추가
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공");
					break;
				}
			} // end of for
		} // end of while

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {// 널이 아닌 값 출력
				System.out.printf("stringlAry[%d]번째의 값 : %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end");
	}

	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);

		String[] stringAry = new String[10];
		stringAry[0] = "홍";
		stringAry[1] = "친";
		stringAry[2] = "태완";
		stringAry[3] = "태희";

		System.out.print("삭제할 친구 이름>> ");
		String name = scn.nextLine();

		// 삭제할 친구이름을 검색
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null;// 삭제
			}

		} // 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {// 널이 아닌 값 출력
				System.out.printf("stringlAry[%d]번째의 값 : %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end");
	}

	public static void friendApp() {
		Scanner scn = new Scanner(System.in);

		// 배열선언
		String[] friendAry = new String[10];// 입력값을 저장

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("선택>> ");
			// 메뉴선택
			int menu = Integer.parseInt(scn.nextLine());

			
			
			switch (menu) {
			case 1: // 문자추가
				System.out.print("이름추가>> ");
				String name = scn.nextLine();

				// 배열추가
				for (int i = 0; i < friendAry.length; i++) {
//			    // 빈공간 널인지 확인하고 추가
				 if (friendAry[i] == null) {
						friendAry[i] = name;
						System.out.println("입력성공");
						break;
					}
				} // end of for
				break;

			case 2: // 목록
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {// 널이 아닌 값 출력
						System.out.printf("이름 : %s\n", friendAry[i]);
					}
				}
				break;

			case 3: // 삭제
				System.out.print("이름삭제>> ");
				String name1 = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					 if(friendAry[i] != null && friendAry[i].equals(name1)) {
						friendAry[i] = null;// 삭제
						break;
					}else if(friendAry[i] != name1){
						System.out.print("존재 안하는 이름 ");
						break;
					}

				} // end for for
				break;

			case 4: // 종료
				run = false;
				System.out.println("end");

			}

		} // end of while

		System.out.println("end of prog");

	}// end of friendapp

}
