package com.yedam.ref.app;

import java.util.Scanner;

public class MemberExe2_1 {
//회원추가, 수정, 삭제, 조회, 종료
//	추가-아이디 이름 전화번호 포인트
//	수정-아이디(조회) 연락처 수정
//	삭제 아이디로 삭제
	// 조회 이름 (조회)
//
	static Member[] memAry = new Member[100];

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("1.회원추가 2.수정 3.삭제. 4.조회 5.종료");
			System.out.print("선택>>");
			int selNo = Integer.parseInt(scanner.nextLine());

			if (selNo == 1) {

				System.out.print("아이디>>");
				String id = scanner.nextLine();
				System.out.print("이름>>");
				String name = scanner.nextLine();
				System.out.print("연락처>>");
				String tel = scanner.nextLine();
				System.out.print("포인트>>");
				int point = Integer.parseInt(scanner.nextLine());

				Member member = new Member();
				member.id = id;
				member.name = name;
				member.tel = tel;
				member.point = point;

				// 배열
				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] == null) {
						memAry[i] = member;

						System.out.println("입력성공");
						break;

					} // end of for
				}
			} else if (selNo == 2) {
				System.out.println("아이디 입력>> ");
				String id = scanner.nextLine();
				System.out.println("연락처 입력>> ");
				String tel = scanner.nextLine();

				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] != null) {
						if (memAry[i].id.equals(id)) {
							memAry[i].tel = tel;
							System.out.println("수정완료.");
							break;
						}
					}

				}

			} else if (selNo == 3) {
				System.out.println("아이디 입력>> ");
				String id = scanner.nextLine();

				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] != null) {
						if( memAry[i].id.equals(id)) {

							memAry[i]=null;
							System.out.println("삭제완료.");
						}
						break;
					}
				}

			} else if (selNo == 4) {
				System.out.print("이름조회>>");
				String name = scanner.nextLine();
				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] != null && name.equals(name)) {

						System.out.printf("아이디 %s\n 이름 %s\n 연락처 %s\n 포인트 %d\n", //
								memAry[i].id, memAry[i].name, memAry[i].tel, memAry[i].point);
						break;
					}

				} // for

			} else if (selNo == 5) {
				run = false;
			}

		} // while

	}

}
