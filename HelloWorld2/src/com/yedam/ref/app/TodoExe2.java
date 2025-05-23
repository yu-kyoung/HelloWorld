package com.yedam.ref.app;

public class TodoExe2 {

	public static void main(String[] args) {
		int[][] numAry = new int[3][5];
		int sum = 0;
		double avg=0;
		// 임의의 숫자 생성
		for (int outer = 0; outer < numAry.length; outer++) {
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100); // 0~99
				System.out.printf("ary[%d][%d] => %d\n", outer, inner, numAry[outer][inner]);
			}
		}

		

		// 평균 계산 및 출력
		for (int o = 0; o < numAry.length; o++) {
			
			for (int i = 0; i < numAry[o].length; i++) {
				sum += numAry[o][i];
			}
			avg = sum * 1.0 / numAry[o].length;
			System.out.printf("numAry[%d]의 평균은 %.2f\n", o, avg);
		}
	}//main
}