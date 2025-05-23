package com.yedam;

import java.util.Scanner;

public class ObjectExe {
//객체(속성=필드, 기능=메소드)
	public static void main(String[] args) {

//		Calendar.showMonth();
		Scanner scn = new Scanner(System.in);
		
		int year = 2010;
		while(true) {
			System.out.println("년도를 입력하세요>> ");
		String msg=scn.nextLine();
		try {
			year = Integer.parseInt(msg);
		} catch (NumberFormatException e) {
			if(msg.equals("quit")) {
				break;
			}System.out.println("숫자를 입력하세요.");
			
			continue;	
		
		}
		
		
		
		if(Calendar.isLeapYear(year)==true) {
			System.out.print("윤년입니다.\n");
		}else {
			System.out.print("평년입니다.\n");
			}
	
//		break;
		}
	}
}
