package com.yedam.ref;

public class exe0516 {
	public static void main(String[] args) {
		// Math.random 활용해서 10~100 사이의 점수를 생성.
		// 학생 10명의 점수를 생성한 학생점수의 평균을 구하고 최고점수 구하기
		// scoreAry

		int sum = 0;

		int[] scoreAry = new int[10];
		for (int i = 0; i < scoreAry.length; i++) {
			scoreAry[i] = (int) (Math.random() * 91) + 10;

//				System.out.printf("%s cnt:%d\n", scoreAry,cnt);				
		} // for

		// 평균 ex{2.4.5.7.9}
		double avg = 0;
		int max = 0;
		for (int i = 0; i < scoreAry.length; i++) {
			sum += scoreAry[i];// 합
			if (max < scoreAry[i]) {
				max = scoreAry[i];// 최대값 ...
			}

		}
		System.out.printf("최대값 %d\n", max);
		avg = sum * 1.0 / 10;//10 = scoreAry.length
		System.out.printf("평균 %.1f", avg);

	}// main
}// class
