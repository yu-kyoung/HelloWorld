package com.yedam.ref;

//실행클래스
public class CalculatorExe {
	public static void main(String[] args) {
		int a=20,b =30;
		
		//sum의 기능활용
		Calculator c1 = new Calculator();//인스턴스 생성 
		c1.sum(a, b); 
		
		
		Calculator.sum(a, b); //정적메소드 호출
		printStar();
		
		
		CalculatorExe ce= new CalculatorExe();
		ce.printStar();
	}// main
	
	static void printStar() {
		System.out.println("*");
	}
	
	
	
}
