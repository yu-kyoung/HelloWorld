package com.yedam.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.common.hairClientDAO;
import com.yedam.vo.HairShop;;

public class HairShopApp {

	static hairClientDAO dao = new hairClientDAO();
	static String product;
	static int price;
	static String des;
	static HairShop hs = new HairShop(product, price, des);

	static int clientId;
	static String clientName;
	static String phone;
	static int pay;
	static String birth;
	static String rank;
	static String date;
	
	
//	static HairShop hs1 = new HairShop(clientId, clientName, phone, birth, pay);

	public static void main(String[] args) {
		boolean run = true;
		List<HairShop> hair = new ArrayList<>();

		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("===========================================");
			System.out.println();
			System.out.println("      1.상품관리 2.고객관리 3.예약관리 4.종료");
			System.out.println();
			System.out.println("===========================================");

			System.out.println("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine();

			switch (menu) {
			case 1:
				boolean run1 = true;
				while (run1) {
					System.out.println("===========================================");
					System.out.println("                   상품관리");
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

//						HairShop hs = new HairShop(product, price, des);

						int a = dao.insert(hs);

						if (a > 0) {// 1
							System.out.println("등록완료 했습니다.");
						} else {
							System.out.println("등록실패 했습니다.");
						}

						break;
					case 2:// 조회
						List<HairShop> list = dao.select();
						System.out.println("  상품명    가격           설명");
						System.out.println("----------------------------------");
						for (HairShop hs : list) {
							System.out.printf("%5s  %-3s" + "원   " + "%-5s\n", //
									hs.getProduct(), hs.getPrice(), hs.getDes());
						}
						break;

					case 3:// 수정
						System.out.println("상품명을 입력하세요>> ");
						product = scn.nextLine();
						System.out.println("수정할 가격을 입력하세요>> ");
						price = Integer.parseInt(scn.nextLine());
						System.out.println("수정할 상세설명을 입력하세요>> ");
						des = scn.nextLine();

						int a1 = dao.update(hs);
						if (a1 > 0) {
							System.out.println("상품이 수정되었습니다.");
						} else {
							System.out.println("수정을 실패했습니다.");
						}

						break;
					case 4:// 삭제
						System.out.println("상품명을 입력하세요>> ");
						product = scn.nextLine();
						System.out.println("상품을 삭제하겠습니까?(y/n)");
						String yesNo = scn.nextLine();

						if (yesNo.toLowerCase().equals("y")) {
							int a2 = dao.delete(product);
							if (a2 > 0) {
								System.out.println("삭제되었습니다.");
							} else {
								System.out.println("삭제를 실패했습니다.");
							}
						} else if (yesNo.toLowerCase().equals("n")) {
							System.out.println("취소되었습니다.");
						}

						break;
					case 5:
						run1 = false;

					}// switch
				} // while
				continue;
			default:
				System.out.println("잘못된 입력입니다.");
			case 2:
				boolean run2 = true;
				while (run2) {
					System.out.println("==============================================");
					System.out.println("                    고객관리");
					System.out.println("==============================================");
					System.out.println("1.고객등록 2.고객목록 3.고객정보수정 4.생일이벤트 5.메인메뉴");
					System.out.println("선택>> ");
					int menu2 = scn.nextInt();
					scn.nextLine();

					switch (menu2) {
					case 1:// 등록
						System.out.println("고객번호를 입력하세요>> ");
						clientId = Integer.parseInt(scn.nextLine());
						System.out.println("이름을 입력하세요>> ");
						clientName = scn.nextLine();
						System.out.println("연락처를 입력하세요>> ");
						phone = scn.nextLine();
						System.out.println("생일을 입력하세요>> ");
						birth = scn.nextLine();
						System.out.println("선불금을 입력하세요>> ");
						pay = Integer.parseInt(scn.nextLine());

						HairShop hs1 = new HairShop(clientId, clientName, phone, birth, pay);
						int b = dao.insert1(hs1);

						if (b > 0) {// 1
							System.out.println("등록완료 했습니다.");
						} else {
							System.out.println("등록실패 했습니다.");
						}
						break;
					case 2:// 조회
						HairShop hs2 = new HairShop(clientId, clientName, phone, birth, rank, pay);
						List<HairShop> list = dao.select1();

						System.out.println("고객번호   이름     연락처        생일      등급     선불금");
						System.out.println("----------------------------------------------------");
						for (HairShop hs : list) {
							System.out.printf("%3d  %5s %-12s %-10s %-5s %10d\n"//
									, hs.getClientId(), hs.getClientName(), //
									hs.getPhone(), hs.getBirth(), hs.getRank(), hs.getPay());
						}
						break;
					case 3:// 수정
						System.out.println("고객번호를 입력하세요>> ");
						clientId = Integer.parseInt(scn.nextLine());
						System.out.println("수정할 이름을 입력하세요>> ");
						clientName = scn.nextLine();
						System.out.println("수정할 연락처를 입력하세요>> ");
						phone = scn.nextLine();
						System.out.println("수정할 생일을 입력하세요>> ");
						birth = scn.nextLine();
						System.out.println("선불금을 입력하세요>> ");
						pay = Integer.parseInt(scn.nextLine());

						HairShop hs3 = new HairShop(clientId, clientName, phone, birth, pay);
						int b1 = dao.update1(hs3);

						if (b1 > 0) {
							System.out.println("정보가 수정되었습니다.");
						} else {
							System.out.println("수정을 실패했습니다.");
						}
						break;
					// 엔터치면 그냥 넘어가도록

					case 4:// 생일조회
						List<HairShop> list1 = dao.birth();
						HairShop hs4 = new HairShop(clientName, phone, birth);
						System.out.println("이름      연락처        생일   ");
						System.out.println("--------------------------");

						for (HairShop hs : list1) {
							System.out.printf("%-3s %12s %-10s\n"//
									, hs.getClientName(), hs.getPhone(), hs.getBirth());
						}
						System.out.println("\n‼생일이벤트 문자를 발송해 주세요.\n");

						break;
					case 5:// 메인메뉴
						run2 = false;
					}// end of switch
				} // end of while
				continue;
			case 3:
				System.out.println("==================================");
				System.out.println("              예약관리");
				System.out.println("==================================");
				System.out.println("1.예약등록 2.예약조회 3.예약취소 4.메인메뉴");
				System.out.println("선택>> ");
				int menu3 = scn.nextInt();
				scn.nextLine();
				switch (menu3) {
				case 1://예약관리
					String reaservation;
					String designer;
					
					System.out.println("예약일자를 입력하세요(yy-MM-dd)>> ");
					reaservation = scn.nextLine();
					System.out.println("이름을 입력하세요>> ");
					clientName = scn.nextLine();
					System.out.println("연락처를 입력하세요>> ");
					phone = scn.nextLine();
					System.out.println("상품명을 입력하세요>> ");
					product = scn.nextLine();
					System.out.println("담당자를 입력하세요>> ");
					designer = scn.nextLine();

					HairShop hs5 = new HairShop(reaservation, clientName, phone, product, designer);
					int c = dao.insert2(hs5);
										
					if (c > 0) {// 1
						System.out.println("등록완료 했습니다.");
					} else {
						System.out.println("등록실패 했습니다.");
					}
					
					
					
					
				case 2://조회
				case 3://취소
				
				
				
				case 4://메인메뉴
					
					
					
				}//end of switch
			case 4:// 종료
				run=false;
				break;
			}// end of switch

		} // end of while
		System.out.println("종료되었습니다.");
	}
}
