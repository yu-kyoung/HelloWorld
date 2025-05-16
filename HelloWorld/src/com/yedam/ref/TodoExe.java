package com.yedam.ref;

import java.util.Scanner;

public class TodoExe {
	public static void main(String[] args) {
		// 혼공자 223페이지 연습문제6번.
		// 1.학생수 2.점수 3.최고점수 4.평균점수 5.종료
		Scanner scn = new Scanner(System.in);

		int stuNum = 0;
		int sum = 0;
		int max = 0;
		double avg = 0;
		boolean run = true;
		int[] score = null;
		while (run) {
			System.out.println("1.학생수 2.점수 3.최고점수 4.평균점수 5.종료");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("학생수를 입력하세요");
				stuNum = Integer.parseInt(scn.nextLine());
				score = new int[stuNum];
				System.out.printf("%d명 입니다.\n", stuNum);

			} else if (menu == 2) {
				if (score == null) {
					System.out.println("학생수를 입력하세요.");
					continue;
				}

				for (int i = 0; i < score.length; i++) {
					System.out.println("점수를 입력하세요");
					score[i] = Integer.parseInt(scn.nextLine());
					System.out.printf("%d점 입니다.\n", score[i]);
				}

			} else if (menu == 3) {

				for (int i = 0; i < score.length; i++) {
					if (max < score[i]) {
						max = score[i];// 최대값 ...
					}
				}
				System.out.printf("최대 점수 %d\n", max);

			} else if (menu == 4) {
				for (int i = 0; i < score.length; i++) {
					sum += score[i];// 합
					avg = sum * 1.0 / score.length;
				}
				System.out.printf("평균 %.1f\n", avg);

			} else if (menu == 5) {
				run = false;
			} else {
				System.out.println("1~5중에 선택");
			}

		} // while
		System.out.println("종료");
	}// main
}// class
