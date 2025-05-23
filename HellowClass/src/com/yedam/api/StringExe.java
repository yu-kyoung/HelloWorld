package com.yedam.api;

import com.yedam.member.Member;

public class StringExe {
	public static void main(String[] args) {
		
		
		int num1=10, num2=20;
		System.out.println(num1==num2);
		
		String str1=new String("Hello");
		String str2=new String("Hello");
		System.out.println(str1.equals(str2));
		
		Member mem1 =new Member();//인스턴스
		Member mem2 =new Member();//주소비교

		System.out.println(mem1==mem2);
		System.out.println(mem1.equals(mem2));

		
	}
}
