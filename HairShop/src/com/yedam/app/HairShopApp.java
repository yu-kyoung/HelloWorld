package com.yedam.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.common.hairClientDAO;
import com.yedam.vo.HairShop;

public class HairShopApp {

	static hairClientDAO dao = new hairClientDAO();
	static String product;
	static int price;
	static String des;

	public static void main(String[] args) {
		boolean run = true;
		List<HairShop> hair = new ArrayList<>();

		Scanner scn = new Scanner(System.in);
		while (run) {

			System.out.println("1.상품관리 2.고객관리 3.예약관리 4.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine();

			switch (menu) {
			case 1:
				boolean run1 = true;
				while (run1) {
					System.out.println("===========================================");
					System.out.println("상품관리");
					System.out.println("===========================================");
					System.out.println("1.상품등록 2.상품목록조회 3.상품수정 4.상품삭제 5.메인메뉴");
					System.out.println("선택>> ");
					int menu1 = scn.nextInt();
					scn.nextLine();
					switch (menu1) {
					case 1:// 등록
						System.out.println("상품명을 입력하세요>> ");
						product = scn.nextLine();
						System.out.println("가격을 입력하세요>> ");
						price = Integer.parseInt(scn.nextLine());
						System.out.println("상세설명을 입력하세요>> ");
						des = scn.nextLine();

						HairShop hs = new HairShop(product, price, des);

						int a = dao.insert(hs);

						if (a > 0) {// 1
							System.out.println("상품등록완료");
						} else {
							System.out.println("상품등록실패");
						}

						break;
					case 2:// 조회
						List<HairShop> list = dao.select();
						break;
						
						
						
					case 3:// 수정
						System.out.println("상품명을 입력하세요>> ");
						product = scn.nextLine();
						System.out.println("수정할 가격을 입력하세요>> ");
						price = Integer.parseInt(scn.nextLine());
						System.out.println("수정할 상세설명을 입력하세요>> ");
						des = scn.nextLine();
//						for (int i = 0; i < hair.size(); i++) {
//							if (hair.get(i).getProduct().equals(product)) {
//								hair.get(i).setPrice(price);
//								hair.get(i).setDes(des);
//								System.out.println("수정되었습니다.");
//							}else {
//								System.out.println("수정 실패.");
//							}
//						}
						HairShop hs1 = new HairShop(product, price, des);
						int a1 = dao.update(hs1);
						if (a1 > 0) {
							System.out.println("상품이 수정되었습니다.");
						} else {
							System.out.println("상품 수정을 실패했습니다.");
						}

						break;
					case 4:// 삭제
						System.out.println("상품명을 입력하세요>> ");
						product = scn.nextLine();

//						for (int i = 0; i < hair.size(); i++) {
//							if (hair.get(i).getProduct().equals(product)) {
//								System.out.println("삭제하시겠습니까?(y/n)");
////								String yesNo = scn.nextLine();
////								if (yesNo.toLowerCase().equals("y")) {
////									System.out.println("삭제되었습니다.");
////								} else if (yesNo.toLowerCase().equals("n")) {
////									System.out.println("취소되었습니다.");
////								}
////							}
////
////						}
						HairShop hs2 = new HairShop(product, price, des);
						int a2 = dao.delete(product);
						if (a2 > 0) {
							System.out.println("상품을 삭제하겠습니까?(y/n)");
							String yesNo = scn.nextLine();
							if (yesNo.toLowerCase().equals("y")) {
								System.out.println("삭제되었습니다.");
							} else if (yesNo.toLowerCase().equals("n")) {
								System.out.println("취소되었습니다.");
							}
						}

						break;
					case 5:
						run1 = false;

					default:
						System.out.println("잘못된 입력입니다.");

					}// switch
				} // while
			case 2:

			case 3:

			case 4:// 종료
				run = false;

			}// end of switch

		} // end of while
		System.out.println("종료");
	}
}
