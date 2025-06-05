package com.yedam.operater;

public class OperatorExe {
	public static void main(String[] args) {
//		test();
		test5();

	}

	// 연습1
	public static void test() {
		// 증가 감소 연산자(++, --)
		byte num1 = -128;
		num1 = 127;// -128에서 127까지 byte
		num1++;
		System.out.println(num1);// 다시 제일작은값을 불러옴

		char ch1 = 'A'; // 65
		ch1 = 66;
		ch1 = '가';
		ch1 = 'a';
		ch1 = '가';
		ch1 = 0x29d7;// 유니코드 값
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);// 정수를 문자로

		}
	}// end of test
//byte, short ,long, int, char 정수 타입

	public static void test1() {
		byte num1 = 10;
		byte num2 = 20; // 정수 연산의 기본은 int
		byte sum = (byte) (num1 + num2);// num을 'int' 타입으로 변형해서 계산
		System.out.println(sum);

		long num3 = 10000000000L;// 리트럴 L long형 타입으로 출력
		long num4 = 100L;
		System.out.println(Integer.MAX_VALUE);// 정수가 담을 수 있는 최대값

	}// end of test 1

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;

		System.out.printf("num1->%d,num2->%d,result->%d", num1, num2, result);

		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("참이다.");// if가 거짓 이므로 출력 안함
		}
		result = 30;
		if (!(result != 30)) {// 크다의 반대는 작거나 같다 크거나 같다의 반대는 작다 ==부정은 !=, >부정은<=, >= 부정은 <
			System.out.println("\n result 는 30보다 작거나 같다");
		}

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 => %d", num1);
		}

	}// end of test2

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("\ni의 값은 %d", i);
			}
			isTrue = !isTrue;// 토글(on=>off, off=>on)
		}
	}// end of test3

	// 월 정보를 입력하면 "공란이 몇개인지를 반환 해주는 메소드 getSpace()"
	public static int getSpace(int month) {
		int space = 0;
		if (month == 3) {
			space = 6;
		} else if (month == 4) {// 4월
			space = 2;
		} else if (month == 5) {// 5월
			space = 4;
		} else if (month == 7) {// 6월
			space = 2;
		}
		return space;
	}// end of getSpace

	// 월 정보를 입력하면 "마지막 말일을 반환 해주는 메소드 getLastDate(월)"
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
		}
		return lastDate;
	}// end of last date

	// 달력만들기
	public static void test4() {
		// 요일
		int mon = 7;
		System.out.println(" Sun Mon Tue Wen Thu Fri Sat");
		// 공란
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);

		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		// 날짜출력
		for (int day = 1; day <= lastDate; day++) {

			System.out.printf("%4d", day);// '___' 3개의 공간을 확보

			if ((day + space) % 7 == 0) {
				System.out.println();
			}
		}
	}// end of test4

	// 삼항 연산자
	public static void test5() {
		String pass="";
		int score=(int)(Math.random() *100);
		System.out.println(score);
//		if(score>60) {
//			pass="합격";
//		}else{
//		   if(score<20){
//			pass="불불합격";
//		}else{
//		pass="불합격";
//		}
//	}
//		System.out.println(pass);

		
		pass=(score>=60) ? (score>=80) ? (score>20) ? "우수":"합격":"불합격":"불불합격";
	
		System.out.printf("%d점은 %s\n", score, pass);
		
		
		
	}// end of test5

}
