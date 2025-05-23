package com.yedam.ref;

import java.util.Scanner;

public class TodoExe {
	public static void main(String[] args) {
		// 혼공자 223페이지 연습문제6번.
		// 1.학생수 2.점수 3.최고점수 4.평균점수 5.종료
//		Scanner scn = new Scanner(System.in);
//
//		int stuNum = 0;// 학생수
//		int sum = 0;
//		int max = 0;
//		double avg = 0;
//		boolean run = true; // 반복문 실행/종료
//		int[] score = null; // 학생점수저장
//		while (run) {
//			System.out.println("1.학생수 2.점수 3.최고점수 4.평균점수 5.종료");
//			int menu = Integer.parseInt(scn.nextLine());
//
//			if (menu == 1) {
//				System.out.println("학생수를 입력하세요");
//				stuNum = Integer.parseInt(scn.nextLine());
//				score = new int[stuNum];
//				System.out.printf("%d명 입니다.\n", stuNum);
//
//			} else if (menu == 2) {
//				if (score == null) {
//					System.out.println("학생수를 입력하세요.");
//					continue;
//				}
//
//				for (int i = 0; i < score.length; i++) {
//					System.out.println("점수를 입력하세요");
//					score[i] = Integer.parseInt(scn.nextLine());
//					System.out.printf("%d점 입니다.\n", score[i]);
//				}
//
//			} else if (menu == 3) {
//
//				for (int i = 0; i < score.length; i++) {
//					if (max < score[i]) {
//						max = score[i];// 최대값 ...
//					}
//				}
//				System.out.printf("최대 점수 %d\n", max);
//
//			} else if (menu == 4) {
//				for (int i = 0; i < score.length; i++) {
//					sum += score[i];// 합
//					avg = sum * 1.0 / score.length;
//				}
//				System.out.printf("평균 %.1f\n", avg);
//
//			} else if (menu == 5) {
//				run = false;
//			} else {
//				System.out.println("1~5중에 선택");
//			}
//
//		} // while
//		System.out.println("종료");
		init();// 초기데이터 생성
		test();
	}// main

	static Student[] scores = null;// 스코어 이름

	public static void test() {
//		int studentNum=0;
		boolean run = true;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("1.학생수, 2.키입력 3.점수리스트(성별). 4.분석. 5.종료");
			System.out.print("선택>>");
			int selectNo = Integer.parseInt(scanner.nextLine());

			if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
				if (scores == null) {
					System.out.print("학생수를 지정하세요");
					continue; // 반복문의 첫번째로 돌아가는 것
				}
			}

			if (selectNo == 1) {
				System.out.print("학생수>>");// 학새수 지정
				int studentNum = Integer.parseInt(scanner.nextLine());
				scores = new Student[studentNum];
				System.out.printf("%d명 입니다.\n", studentNum);

			} else if (selectNo == 2) {// 점수입력
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d] 이름>>", i);
					String name = scanner.nextLine();// 이름저장
					System.out.printf("scores[%d] 점수>>", i);
					int score = Integer.parseInt(scanner.nextLine());
					System.out.printf("scores[%d] 키>>", i);
					double height = Double.parseDouble(scanner.nextLine());
					// Double.parsedouble("");문자를 실수 타입으로 변환
					System.out.printf("scores[%d] 성별>>", i);
					String gender = scanner.nextLine();// 성별저장
					Gender gen = Gender.MALE;
					if (gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}

					// 인스턴스 생성
					Student student = new Student();
					student.studentName = name;
					student.height = height;
					student.gender = gen;
					student.score = score;
					scores[i] = student;// 배열에 저장
				}

			} else if (selectNo == 3) {
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].height; // 점수 누적.
				}
				// 점수입력하도록 메세지 보여주기.
				if (sum == 0) {
					System.out.println("점수를 입력하세요.");
					continue;
				}
				System.out.print("검색조건 ex) 남 , 여 >>");
				String keyword = scanner.nextLine();
				Gender gen = Gender.MALE;
				if (keyword.equals("남") || keyword.equals("남자")||//
						keyword.equals("m")|| keyword.equals("male")) {
					gen = Gender.MALE;
				} else if (keyword.equals("여") || keyword.equals("여자")||//
						keyword.equals("w")|| keyword.equals("female")) {
					gen = Gender.FEMALE;
				}

				for (int i = 0; i < scores.length; i++) {
					if (keyword.equals("") || gen==scores[i].gender) {
						System.out.printf("scores[%d]> %s %d \n", i, scores[i].studentName, scores[i].score);
					}
				}
			} else if (selectNo == 4) {
				double max = 0;
				int sum = 0;// 최고점수,함계 변수선언//키큰사람
				double avg = 0;// 평균 변수 선언
				Student maxStd = new Student();// 최고 점수 학생정보저장
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].height;// 점수누적
					if (max < scores[i].height) {// 최고점수
						max = scores[i].height;

						maxStd.height = scores[i].height;
						maxStd.studentName = scores[i].studentName;

					}
				}
				avg = sum * 1.0 / scores.length;
				System.out.printf("학생이름:%s 큰키: %.1f\n평균점수:%.2f \n", maxStd.studentName, maxStd.height, avg);

			} else if (selectNo == 5) {
				run = false;
			}

		}

	}

	public static void init() {
		Student s1 = new Student();// 인스턴트 생성

		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;

		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;

		Student s3 = new Student();
		s3.studentName = "김철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE;

		scores = new Student[] { s1, s2, s3 };
	}// init
}// class
