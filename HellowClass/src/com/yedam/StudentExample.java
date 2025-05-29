package com.yedam;

//실행 클래스
public class StudentExample {
	public static void main(String[] args) {

		Student student = new Student();// 클래스 변수= new실체생성-인스턴트
		student.setStudentNo(1001);
		student.setStudentName("홍길동");
//		student.engScore=80;
		student.setEngScore(85);
		student.setMathScore(85);
		student.study();
		student.introduce();
		System.out.println("이름 : "+student.getStudentName()
				+ " 영어 : " + student.getEngScore() +"수학 : " + student.getMathScore());
		
		
		Student student2 = new Student(1002, "김민규");// 클래스 변수= new실체생성-인스턴트
//		student2.studentNo =1002;
//		student2.studentName ="김민규";
//		student2.engScore=-50;
		student2.setEngScore(-50);
//		student2.mathScore=-80;
		student2.setMathScore(-80);
		student2.study();
		student2.introduce();

		// 스태틱이 없는 메소드는 반드시 변수선언을 해야함
		student2.setStudentName("김민규");
		student2.introduce();
	}
}
