package com.yedam.exception;

//일반예외
public class ExceptionExe {
	public static void main(String[] args) {

		String numStr = "a";
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
		//예외발생시 대체할 코드
			System.out.println("실행예외발생");
		}
		System.out.println(num);

		//
			try {
				Class.forName("java.util.Scanner");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		System.out.println("종료");

	}

}
