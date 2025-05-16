package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
//Math.random 활용해서 10~100 사이의 점수를 생성.
//학생 10명의 점수를 생성한 학생점수의 평균을 구하고 최고점수 구하기
//scoreAry
		int cnt=0;
		int sum=0;
		int[]scoreAry=new int[10];
		for(int i=1; i<=scoreAry.length; i++) {
	         scoreAry[i]=(int)(Math.random() * 91) + 10;
		     cnt++;
		
		
		
		
		
			 
		 
	
//		System.out.printf("%d  cnt:%d\n", scoreAry,cnt);
	
		
		}//for
		
	}
		
//		
//		double avg = 1.0 *  / cnt;// 실수 타입연산
//		System.out.printf("%.1f\n", avg);// 평균값
		
		
		
		
//		test();
//		test1();
//		test2();
//		test1_1();
//		test3();
	
	// end of main

	
	public static void test4() {	// int 배열=>intAry : 10, 17, 22, 31, 55, 24,
		int[] intAry = { 10, 17, 22, 31, 55, 24 };
		int temp = 0;
		// 정렬★
		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				if (intAry[i] < intAry[i + 1]) {//부등호에 따라 오름차순 내림차순
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			} // for i
		} // for j
		//출력
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("i: %d, %d\n", i, intAry[i]);
		}

		// 배열 중 최고값
		int max = 0;
		for (int i = 0; i < intAry.length; i++) {
			// max와 배열요소를 비교 ,큰값을 max에 저장
			if (max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.printf("최대값 %d\n", max);

		// 배열의 합
		int sum = 0;
		int cnt = 0;// 횟수
		for (int i = 0; i < intAry.length; i++) {// i+=2 2씩증가 if([i]%2==0)
			if (intAry[i] % 2 == 0) {// 값이 짝수 일때 더하기
				sum += intAry[i];
				cnt++;
				System.out.printf("sum: %d, i: %d, 값: %d  \n", sum, i, intAry[i]);
			}
		} // for
		double avg = 1.0 * sum / cnt;// 실수 타입연산
		System.out.printf("%.1f\n", avg);// 평균값

//		test();
//		test1();
//		test2();
//		test1_1();
//		test3();
		}
	
	
	public static void test() {

		while (true) {
			int num = (int) (Math.random() * 6) + 1;
			int num1 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", num, num1);

			if (num + num1 == 5) {
				break;
			}
		}
		System.out.printf("end\n");
	}// test

	public static void test1() {

		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (outer >= inner) {
					System.out.print("*");
				}

			} // inner
			System.out.println();
		} // outer

	}// test1

	public static void test2() {

		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (outer + inner >= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			} // inner
			System.out.println();
		} // outer

	}// test2

	public static void test1_1() {

		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (outer <= inner) {
					System.out.print("*");
				}

			} // inner
			System.out.println();
		} // outer

	}// test1_1

	public static void test3() {
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}

			}
		}

	}// test3

}// class
