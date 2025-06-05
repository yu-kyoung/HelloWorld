package com.yedam.ref;

public class ArrayExe3 {

	static Student[] stdAry;// 배열 클래스 단위에서 선언됨, 어디에서든 사용 가능

	public static void main(String[] args) {

		init();
		int sum = 0;
		double max = 0;
//		String maxName="";
		Student maxStd = new Student();

		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;// 점수합계
		}

		double avg = 1.0 * sum / stdAry.length;
		System.out.printf("평균 : %.2f\n", avg);
		
		for (int i = 0; i < stdAry.length; i++) {
			if (max < stdAry[i].height) {//큰키,이름
				max = stdAry[i].height;

				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}
		String strFmt = "이름:%s 점수:%d 키최대값:%.1f 평균:%.2f\n";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);

	}// main

	public static void init() {
		Student s1 = new Student();// 인스턴트 생성

		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height=170.8;
		s1.gender=Gender.MALE;

		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height=165.7;
		s2.gender=Gender.FEMALE;

		Student s3 = new Student();
		s3.studentName = "김철민";
		s3.score = 90;
		s3.height=180.3;
		s3.gender=Gender.MALE;

		stdAry = new Student[] { s1, s2, s3 };// 배열에 값을 할당
	}// init

	public static void test() {

		// 배열+기본타입:정수, 실수
		// 배열 + 참조타입(클래스):학생이름, 점수
		// 홍길동 80
//		int num1 =90;
		// 새로운 클래스 파일 생성 후
		Student s1 = new Student();// 클래스 이름과 같음.인스턴스 생성 값을 담을수 있는 공간
		s1.studentName = "홍길동";
		s1.score = 80;
		// 김민규 85-> s2에 저장
		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;

		// 홍길동의 점수를 90으로 변경
		s1.score = 90;

		// 학생정보 배열에 저장
		Student[] students = { s1, s2 };
		students[0].studentName = "홍길도";
		System.out.printf("이름 %s, 점수 %d", s1.studentName, s1.score);

	}
}
