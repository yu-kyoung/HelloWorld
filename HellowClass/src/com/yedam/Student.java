package com.yedam;

public class Student {
//라이브러리 클래스 역할//필드(속성)
	private int studentNo;
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;

	// 생성자(인스턴스(객체) 초기화)
	public Student() {
		// 매개값이 없는 생성자:기본생성자.
		// 컴파일러가 생성
		// 반드시 생성됨
	}

	public Student(int studentNo, String studentName) {
		this.studentNo = studentNo;
		this.studentName = studentName;
	}

	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;

	}

	// 메소드 (기능)
	void study() {
		System.out.println("공부를 합니다.");
	}

	void introduce() {
		System.out.printf("학번은 %d 이고 이름은 %s \n", studentNo, studentName);
	}

	// 영어,수학점수
	void setEngScore(int engScore) {
		if (engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore = engScore;
	}

	void setMathScore(int mathScore) {
		if (mathScore < 0 || mathScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}

	void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	// get
	int getStudentNo() {
		return studentNo;

	}

	String getStudentName() {
		return studentName;

	}

	int getEngScore() {
		return engScore;

	}

	int getMathScore() {
		return mathScore;

	}

// 스태틱이 없는 메소드는 반드시 변수선언을 해야함
}
