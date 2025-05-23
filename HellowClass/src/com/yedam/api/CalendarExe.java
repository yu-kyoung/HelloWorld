package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//calendar:날짜 시간관련 
//date: 날짜 시간 
//클래스
public class CalendarExe {
	public static void main(String[] args) {
		// Calendar 클래스

		makeCalendar(2025, 5);

	}

	// 달력 다날라감;;

	Scanner scn = new Scanner(System.in);

	public static void makeCalendar(int year, int month) {
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, 1);

		System.out.printf("%d년 %2d월\n", year, month);
		System.out.println("=============================");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");
		
		int space = now.get(Calendar.DAY_OF_WEEK);
		int lastDate = now.getActualMaximum(Calendar.DATE);

		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);

			if ((i+space) % 7 == 0) {
				System.out.println();
			}

		}

	}

	public static void date() {
		Date today = new Date();
		System.out.println(today.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 생성자의 매개값으로 포맷지정 원하는 날짜형식으로 변환
		String timeStr = sdf.format(today);// date => string
		System.out.println(timeStr);
		// 2025-05-12 13:22:38 가능

		try {
			today = sdf.parse("2025-08-01 09:00:00");// string=>date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);

	}

	public static void cal() {
		Calendar now = Calendar.getInstance();
		// 값을 지정 시간변경
		now.set(2025, 0, 1);// 2025.1.1
		now.set(Calendar.YEAR, 2024);

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		}

		System.out.printf("년도 %d \n 월 %d \n 날짜 %d \n 요일 %d\n 말일 %d\n", //
				now.get(Calendar.YEAR), //
				now.get(Calendar.MONTH), //
				now.get(Calendar.DATE), //
				now.get(Calendar.DAY_OF_WEEK), //
				now.getActualMaximum(Calendar.DATE)

		);// get(1)년도ㅁㅁㅁ

	}
}
