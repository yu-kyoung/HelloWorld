package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

//인덱스를 활용해서 객체를 관리.
//순서를 가지고 중복된 값도 가능함



public class ListExe {
	public static void main(String[] args) {
		// 10~100 점수를 임의의 값으로 생성

		List<Student> numbers = new ArrayList<Student>();
		// 10개의 합을 구하고 평균 출력
		double avg = 0;
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			int score = ((int) (Math.random() * 91) + 10);
			numbers.add(new Student(1000 + i, score));
//			System.out.println(numbers.get(i));
		}
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).GetScore();
		}
		avg = 1.0 * sum / numbers.size();
		System.out.printf("%d %.2f", sum, avg);
	}

	public static void exe2() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("김홍동", 20);
		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("홍길도", 30));

//		member.remove(member);

		String search = "김홍동";
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}
	}

	public static void exe1() {
		// 인터페이스 - 구현클래스
//	int[] ary= {10,20,30.4?}

		List<String> list = new ArrayList<String>();// 오브젝트 타입
		list.add("10");
		list.add(new String("Hello"));// 같은 형식을 맞추기위해//널값을 생각안해도됨
		// 특정위치에 추가할 수 있음
		list.add(1, "20");

		// 삭제
		list.remove(0);// 첫번째 삭제

		// 변경
		list.set(1, "World");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (Object item : list) {
			System.out.println(item);

		}

	}

}
