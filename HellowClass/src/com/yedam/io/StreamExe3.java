package com.yedam.io;
//학생(추가,수정,삭제,목록) -종료하면  studentList.txt 에 저장

//add(추가 : 이름 ,점수 입력)
//modify(삭제: 이름)
//list(목록)
//종료시 저장

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.yedam.collection.Student;

public class StreamExe3 {
	static Scanner scn = new Scanner(System.in);
	static List<Student> studentList = new ArrayList<>();// 컬렉션

	public static void main(String[] args) {

		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// 파일의 끝부분에서 더이상읽을 값이 없음.
		}

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			// 조건문
			switch (menu) {
			case 1:// 추가
				add();
				break;
			case 2://수정
				modify();
				break;
			case 3:
			case 4:
			case 5:// 종료
				run = false;
				save();

			}

		} // while end
		System.out.println("end of prog");
	}// main end

	static void add() {
		System.out.print("학생번호: ");
		String sno = scn.nextLine();
		System.out.print("점수: ");
		String score = scn.nextLine();
		Student student = new Student(Integer.parseInt(sno), Integer.parseInt(score));
		if (studentList.add(student)) {
			System.out.println("저장완료");
		}
	}// add end
		// 저장

	static void save() {
		// 문자기반의 출력 스트림
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			// 1001 70
			for (Student student : studentList) {// 리스트에 있는 갯수만큼 반복하겠음
				String txt = student.GetstudentNo() + " " + student.GetScore() + "\n";
				writer.write(txt);
			}
			writer.close();// 닫아줘야함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// save end

	// 초기화
	static void init() throws IOException, NoSuchElementException {
		Scanner scan = new Scanner(new File("c:/temp/studentList.txt"));
		while (true) {
			String txt = scan.nextLine();
			String[] strAry = txt.split(" ");
			// studentlist 컬렉션에 추가
			studentList.add(new Student(Integer.parseInt(strAry[0]), //
					(Integer.parseInt(strAry[1]))//
			));
		}

	}//init
	
	static void modify() {
		System.out.print("학생번호: ");
		int sno = scn.nextInt();
		System.out.print("점수: ");
		int score = scn.nextInt();
		scn.nextLine();
		//컬렉션에서 검색
		for(int i =0; i<studentList.size(); i++) {
			if(studentList.get(i).GetstudentNo()==sno) {
				studentList.get(i).setScore(score);
				System.out.println("수정완료");
			}
		}
	}//modify

	static void remove() {
		System.out.print("학생번호: ");
		int sno = scn.nextInt();
		for(int i =0; i<studentList.size(); i++) {
			if(studentList.get(i).GetstudentNo()==sno) {
				studentList.remove(i);
				System.out.println("삭제완료");
			}
		}
		
	}//remove
	
	
	
}
