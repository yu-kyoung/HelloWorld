package com.yedam.collection;

public class Student {
	
		private int studentNo;
		private int score;

		public Student(int studentNo, int score) {
			this.studentNo = studentNo;
			this.score = score;

		}
//getter
		public int GetScore() {
			return score;
		}
		public int GetstudentNo() {
			return studentNo;
		}
		public void setScore(int score) {
			this.score = score;
		}
		
		
		
	}

