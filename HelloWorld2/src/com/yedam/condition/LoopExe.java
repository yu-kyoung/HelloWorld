package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {
	public static void main(String[] args) {
//"가위 1 바위 2 보 3"매스랜덤	
//입력값 1,2,3 가위(1) 바위 (2) 보(3) 종료 (4)
		// "You lost", "You win" "Same"
		Scanner scn = new Scanner(System.in);
		while (true) {
			int randomValue = (int) (Math.random() * 3) + 1;
			System.out.println(randomValue);
			System.out.println("숫자를 입력하세요");
			
			int result = Integer.parseInt(scn.nextLine());

//			if(randomValue==result) {
//				System.out.println("same");
//			}
//			
			
			if (result == 1) {
				if (randomValue == 1) {
					System.out.println("same");
				}else if(randomValue==2) {
					System.out.println("you lose");
				}else if(randomValue==3) {
					System.out.println("you win");
				}
			}
			else if(result ==2) {
				if(randomValue == 1) {
					System.out.println("you win");
				}else if(randomValue==2) {
					System.out.println("same");
				}else if(randomValue==3) {
					System.out.println("you lose");
				}
			}
			else if(result==3) {
				if(randomValue==1) {
					System.out.println("you lose");
				}else if(randomValue==2) {
					System.out.println("you win");
				}else if(randomValue==3) {
					System.out.println("same");
				}
				
			}
			else if(result==4) {
				System.out.println("종료합니다.");
				break;
			}
		}


}

	public static void test() {

		// while vs do ..while
		boolean run = false;

//		while (run=!run) {
//			System.out.println("while문");
//		}
		do {
			System.out.println("while문");
			run = !run;
		} while (run);// true면 반복하고 아니면 안함 . 한번은 무조건 실행(2번 실행)

		System.out.println("end of prog");
	}

}
