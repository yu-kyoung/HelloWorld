package co.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class EmpApp {
	public static void main(String[] args) {
		// 앱을 실행하는 클래스.
		EmpDAO dao = new EmpDAO();
		
		// 사용자의 입력을 처리하도록 작성하세요.
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			// 이곳에 메뉴작성.
			// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine();
			switch (menu) {
			case 1:
				System.out.println("사번이름>> ");
				String mid = scn.nextLine();
				System.out.println("이름입력>> ");
				String name = scn.nextLine();
				System.out.println("전화번호입력>> ");
				String phone = scn.nextLine();
				System.out.println("입사일입력>> ");
				String hiredate = scn.nextLine();
				System.out.println("급여입력>> ");
				String sal = scn.nextLine();
				
				Employee employee = new Employee(mid, name, phone, hiredate,Integer.parseInt(sal));
			
			case 2:
				dao.memberList();
				break;

			case 3:
				System.out.println("사번 급여>>");
				String mid1 = scn.nextLine();
				if (dao.modify(mid1)) {
					System.out.println("수정완료");
				} else {
					System.out.println("수정실패");
				}
			case 4:
				System.out.println("사번>> ");
				String mid2 = scn.nextLine();
				if (dao.removeMember(mid2)) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
			case 5:
				System.out.println("입사일자>> ");
				String hireDate = scn.nextLine();
				if (dao.memberList(hireDate)) {
					System.out.println("조회완료");
				} else {
					System.out.println("조회실패");
				}
			case 6:
				run = false;
				break;

			}// end of switch

		} // end of while
		System.out.println("end of prog.");
	} // end of main.
}
