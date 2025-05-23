package com.yedam.api;

import java.util.HashSet;
import java.util.Set;



public class ObjectExe {
	public static void main(String[] args) {
	
		//배열 [여러건 저장] => 컬렉션(1.list 2.set 3.map
		int[] ary = new int [5];
		//확장된 for
		for(int num : ary) {
			System.out.println(num);
		}
		
		//Set 컬렉션은 저장순서x 중복된 값x
		Set<Integer> set = new HashSet<Integer>();//정수를 처리해주는 것
		set.add(10);//중복된 값을 받아들이지 않음
		set.add(20);
		set.add(30);
		set.add(10);
		
		Set<Member>members=new HashSet<Member>();
		members.add(new Member("홍길동",10));
		members.add(new Member("김미석",20));
		members.add(new Member("홍길동",10));
		
		for(Member num:members) {
			System.out.println(num.toString());

		}
	}
		
		public static void exe1(){	
		int num1=10, num2=20;
		System.out.println(num1==num2);
		
		String str1=new String("Hello");
		String str2=new String("Hello");
		System.out.println(str1.equals(str2));
		
		Member mem1 =new Member();//인스턴스
		mem1.memberName="홍길동";
		mem1.age =10;
		
		
		Member mem2 =new Member();//주소비교
		mem2.memberName="홍길동";
		mem2.age =10;
		
		
		System.out.println(mem1==mem2);
		System.out.println(mem1.equals(mem2));

		
	}
}
