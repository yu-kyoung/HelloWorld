package com.yedam.app;

import java.util.*;
import com.yedam.common.hairClientDAO;
import com.yedam.vo.HairShop;

public class HairShopApp2 {
	static hairClientDAO dao = new hairClientDAO();
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("===========================================");
			System.out.println("      1.상품관리 2.고객관리 3.예약관리 4.종료");
			System.out.println("===========================================");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
				case 1: productMenu(); break;
				case 2: clientMenu(); break;
				case 3: reservationMenu(); break;
				case 4: 
					run = false;
					System.out.println("종료되었습니다.");
					break;
				default:
					System.out.println("잘못된 입력입니다.");
			}
		}
	}

	// 상품관리 메뉴
	private static void productMenu() {
		boolean run1 = true;
		while (run1) {
			System.out.println("\n========== 상품관리 ==========");
			System.out.println("1.상품등록 2.상품목록조회 3.상품수정 4.상품삭제 5.메인메뉴");
			System.out.print("선택>> ");

			int menu1 = Integer.parseInt(scn.nextLine());

			switch (menu1) {
				case 1:
					System.out.print("상품명>> ");
					String product = scn.nextLine();
					System.out.print("가격>> ");
					int price = Integer.parseInt(scn.nextLine());
					System.out.print("설명>> ");
					String des = scn.nextLine();

					int inserted = dao.insert(new HairShop(product, price, des));
					System.out.println(inserted > 0 ? "등록완료" : "등록실패");
					break;

				case 2:
					List<HairShop> products = dao.select();
					System.out.println("  상품명    가격        설명");
					System.out.println("----------------------------------");
					for (HairShop p : products) {
						System.out.printf("%-7s %,7d원   %s\n", p.getProduct(), p.getPrice(), p.getDes());
					}
					break;

				case 3:
					System.out.print("수정할 상품명>> ");
					product = scn.nextLine();
					System.out.print("새 가격>> ");
					price = Integer.parseInt(scn.nextLine());
					System.out.print("새 설명>> ");
					des = scn.nextLine();

					int updated = dao.update(new HairShop(product, price, des));
					System.out.println(updated > 0 ? "수정완료" : "수정실패");
					break;

				case 4:
					System.out.print("삭제할 상품명>> ");
					product = scn.nextLine();
					System.out.print("정말 삭제하시겠습니까?(y/n) ");
					if (scn.nextLine().equalsIgnoreCase("y")) {
						int deleted = dao.delete(product);
						System.out.println(deleted > 0 ? "삭제완료" : "삭제실패");
					} else {
						System.out.println("삭제 취소됨");
					}
					break;

				case 5:
					run1 = false;
					break;

				default:
					System.out.println("잘못된 입력입니다.");
			}
		}
	}

	// 고객관리 메뉴
	private static void clientMenu() {
		boolean run2 = true;
		while (run2) {
			System.out.println("\n========== 고객관리 ==========");
			System.out.println("1.고객등록 2.고객목록 3.정보수정 4.생일이벤트 5.방문횟수 6.메인메뉴");
			System.out.print("선택>> ");

			int menu2 = Integer.parseInt(scn.nextLine());

			switch (menu2) {
				case 1:
					System.out.print("고객번호>> ");
					int clientId = Integer.parseInt(scn.nextLine());
					System.out.print("이름>> ");
					String clientName = scn.nextLine();
					System.out.print("연락처>> ");
					String phone = scn.nextLine();
					System.out.print("생일(yyyy-MM-dd)>> ");
					String birth = scn.nextLine();
					System.out.print("선불금>> ");
					int pay = Integer.parseInt(scn.nextLine());

					String rank = getRank(pay);
					HairShop newClient = new HairShop(clientId, clientName, phone, birth, rank, pay);

					System.out.println(dao.insert1(newClient) > 0 ? "등록완료" : "등록실패");
					break;

				case 2:
					List<HairShop> clients = dao.select1();
					System.out.println("고객번호 이름    연락처        생일       등급  선불금 방문횟수");
					System.out.println("---------------------------------------------------------------");
					for (HairShop c : clients) {
						System.out.printf("%3d   %-6s %-13s %-10s %-5s %,6d %4d\n",
								c.getClientId(), c.getClientName(), c.getPhone(),
								c.getBirth(), c.getRank(), c.getPay(), c.getCount());
					}
					break;

				case 3:
					System.out.print("고객번호>> ");
					clientId = Integer.parseInt(scn.nextLine());
					System.out.print("이름>> ");
					clientName = scn.nextLine();
					System.out.print("연락처>> ");
					phone = scn.nextLine();
					System.out.print("생일>> ");
					birth = scn.nextLine();
					System.out.print("선불금>> ");
					pay = Integer.parseInt(scn.nextLine());

					rank = getRank(pay);
					HairShop updateClient = new HairShop(clientId, clientName, phone, birth, rank, pay);
					System.out.println(dao.update1(updateClient) > 0 ? "수정완료" : "수정실패");
					break;

				case 4:
					List<HairShop> birthdays = dao.birth();
					System.out.println("이름    연락처         생일");
					System.out.println("-------------------------------");
					for (HairShop b : birthdays) {
						System.out.printf("%-6s %-12s %s\n", b.getClientName(), b.getPhone(), b.getBirth());
					}
					System.out.println("‼ 생일이벤트 문자를 발송해 주세요.");
					break;

				case 5:
					System.out.print("연락처>> ");
					phone = scn.nextLine();

					int updatedCount = dao.updateCount(phone);
					if (updatedCount > 0) {
						System.out.println("방문횟수가 추가되었습니다.");
						List<HairShop> clientList = dao.select1();
						for (HairShop h : clientList) {
							if (h.getPhone().equals(phone)) {
								System.out.printf("이름: %s, 연락처: %s, 방문횟수: %d\n", h.getClientName(), h.getPhone(), h.getCount());
							}
						}
					} else {
						System.out.println("해당 연락처를 가진 고객이 없습니다.");
					}
					break;

				case 6:
					run2 = false;
					break;

				default:
					System.out.println("잘못된 입력입니다.");
			}
		}
	}

	// 예약관리 메뉴
	private static void reservationMenu() {
		boolean run3 = true;
		while (run3) {
			System.out.println("\n========== 예약관리 ==========");
			System.out.println("1.예약등록 2.예약조회 3.예약취소 4.메인메뉴");
			System.out.print("선택>> ");

			int menu3 = Integer.parseInt(scn.nextLine());

			switch (menu3) {
				case 1:
					System.out.print("예약일자(yyyy-MM-dd)>> ");
					String reservation = scn.nextLine();
					System.out.print("이름>> ");
					String name = scn.nextLine();
					System.out.print("연락처>> ");
					String phone = scn.nextLine();
					System.out.print("상품명>> ");
					String product = scn.nextLine();
					System.out.print("디자이너>> ");
					String designer = scn.nextLine();

					HairShop booking = new HairShop(reservation, name, phone, product, designer);
					System.out.println(dao.insert2(booking) > 0 ? "예약 완료" : "예약 실패");
					break;

				case 2:
					List<HairShop> bookings = dao.select2();
					System.out.println(" 예약일자    이름     연락처       상품명   디자이너");
					System.out.println("---------------------------------------------------");
					for (HairShop r : bookings) {
						System.out.printf("%-10s %-5s %-13s %-6s %-6s\n",
								r.getReservation(), r.getClientName(), r.getPhone(),
								r.getProduct(),
