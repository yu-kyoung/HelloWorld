package com.yedam.app;

import java.util.List;
import java.util.Scanner;
import com.yedam.common.hairClientDAO;
import com.yedam.vo.HairShop;

public class HairShopApp2test {

    static hairClientDAO dao = new hairClientDAO();
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("\n==================헤어샵=====================");

            System.out.println("\n===========================================");
            System.out.println("      1.상품관리  2.고객관리  3.예약관리  4.종료");
            System.out.println("===========================================");
            System.out.print("선택>> ");
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1: productMenu(); break;
                case 2: clientMenu(); break;
                case 3: reservationMenu(); break;
                case 4: run = false; break;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    // 1. 상품 관리 메뉴
    private static void productMenu() {
        boolean run = true;
        while (run) {
            System.out.println("\n============= 상품관리 =============");
            System.out.println("1.상품등록  2.상품목록  3.상품수정  4.상품삭제  5.메인메뉴");
            System.out.print("선택>> ");
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1: insertProduct(); break;
                case 2: listProducts(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 5: run = false; break;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void insertProduct() {
        System.out.print("상품명>> ");
        String product = scn.nextLine();
        System.out.print("가격>> ");
        int price = Integer.parseInt(scn.nextLine());
        System.out.print("설명>> ");
        String des = scn.nextLine();

        int result = dao.insert(new HairShop(product, price, des));
        System.out.println(result > 0 ? "등록 완료." : "등록 실패.");
    }

    private static void listProducts() {
        System.out.println("\n상품명      가격        설명");
        System.out.println("------------------------------");
        for (HairShop hs : dao.select()) {
            System.out.printf("%-6s %,6d원  %s\n", hs.getProduct(), hs.getPrice(), hs.getDes());
        }
    }

    private static void updateProduct() {
        System.out.print("상품명>> ");
        String product = scn.nextLine();
        System.out.print("새 가격>> ");
        int price = Integer.parseInt(scn.nextLine());
        System.out.print("새 설명>> ");
        String des = scn.nextLine();

        int result = dao.update(new HairShop(product, price, des));
        System.out.println(result > 0 ? "수정 완료." : "수정 실패.");
    }

    private static void deleteProduct() {
        System.out.print("상품명>> ");
        String product = scn.nextLine();
        System.out.print("정말 삭제하시겠습니까?(y/n)>> ");
        if (scn.nextLine().equalsIgnoreCase("y")) {
            int result = dao.delete(product);
            System.out.println(result > 0 ? "삭제 완료." : "삭제 실패.");
        } else {
            System.out.println("취소되었습니다.");
        }
    }

    // 2. 고객 관리 메뉴
    private static void clientMenu() {
        boolean run = true;
        while (run) {
            System.out.println("\n============= 고객관리 =============");
            System.out.println("1.고객등록  2.고객목록  3.정보수정  4.생일조회  5.방문횟수  6.고객삭제  7.메인메뉴");
            System.out.print("선택>> ");
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1: insertClient(); break;
                case 2: listClients(); break;
                case 3: updateClient(); break;
                case 4: birthdayList(); break;
                case 5: increaseVisit(); break;
                case 6: delete3(); break;
                case 7: run = false; break;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void insertClient() {
        System.out.print("고객번호>> ");
        int id = Integer.parseInt(scn.nextLine());
        System.out.print("이름>> ");
        String name = scn.nextLine();
        System.out.print("연락처>> ");
        String phone = scn.nextLine();
        System.out.print("생일(yy-MM-dd)>> ");
        String birth = scn.nextLine();
        System.out.print("선불금>> ");
        int pay = Integer.parseInt(scn.nextLine());

        String rank = getRank(pay);
        HairShop hs = new HairShop(id, name, phone, birth, rank, pay);

        int result = dao.insert1(hs);
        System.out.println(result > 0 ? "등록 완료." : "등록 실패.");
    }

    private static void listClients() {
        System.out.println("\n고객번호 이름        연락처      생일        등급     선불금   방문횟수");
        System.out.println("------------------------------------------------------------");
        for (HairShop hs : dao.select1()) {
            System.out.printf("%-5d %-5s %-12s %-10s %-4s %,7d원 %3d회\n",
                    hs.getClientId(), hs.getClientName(), hs.getPhone(),
                    hs.getBirth(), hs.getRank(), hs.getPay(), hs.getCount());
        }
    }

    private static void updateClient() {
        System.out.print("고객번호>> ");
        int id = Integer.parseInt(scn.nextLine());
        System.out.print("이름>> ");
        String name = scn.nextLine();
        System.out.print("연락처>> ");
        String phone = scn.nextLine();
        System.out.print("생일>> ");
        String birth = scn.nextLine();
        System.out.print("선불금>> ");
        int pay = Integer.parseInt(scn.nextLine());

        String rank = getRank(pay);
        HairShop hs = new HairShop(id, name, phone, birth, rank, pay);

        int result = dao.update1(hs);
        System.out.println(result > 0 ? "수정 완료." : "수정 실패.");
    }

    private static void birthdayList() {
        System.out.println("\n이름        연락처        생일");
        System.out.println("-------------------------------");
        for (HairShop hs : dao.birth()) {
            System.out.printf("%-5s %-12s %10s\n", hs.getClientName(), hs.getPhone(), hs.getBirth());
        }
        System.out.println("‼ 생일 3일 전입니다. 이벤트 문자를 보내주세요.");
    }

    private static void increaseVisit() {
        System.out.print("연락처>> ");
        String phone = scn.nextLine();
        int result = dao.count(phone);
        if (result > 0) {
            for (HairShop hs : dao.select1()) {
                if (hs.getPhone().equals(phone)) {
                    System.out.printf("이름: %s, 연락처: %s, 방문횟수: %d\n",
                            hs.getClientName(), hs.getPhone(), hs.getCount());
                }
            }
            System.out.println("방문횟수 증가 완료.");
        } else {
            System.out.println("고객을 찾을 수 없습니다.");
        }
    }

    // 3. 예약 관리 메뉴
    private static void reservationMenu() {
        boolean run = true;
        while (run) {
            System.out.println("\n============= 예약관리 =============");
            System.out.println("1.예약등록  2.예약목록  3.예약취소  4.메인메뉴");
            System.out.print("선택>> ");
            int menu = Integer.parseInt(scn.nextLine());

            switch (menu) {
                case 1: insertReservation(); break;
                case 2: listReservations(); break;
                case 3: deleteReservation(); break;
                case 4: run = false; break;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void insertReservation() {
        System.out.print("예약일자(yy-MM-dd)>> ");
        String reservation = scn.nextLine();
        System.out.print("이름>> ");
        String name = scn.nextLine();
        System.out.print("연락처>> ");
        String phone = scn.nextLine();
        System.out.print("상품명>> ");
        String product = scn.nextLine();
        System.out.print("디자이너>> ");
        String designer = scn.nextLine();

        int result = dao.insert2(new HairShop(reservation, name, phone, product, designer));
        System.out.println(result > 0 ? "예약 완료." : "예약 실패.");
    }

    private static void listReservations() {
        System.out.println("\n예약일자       이름    연락처       상품명  디자이너");
        System.out.println("-----------------------------------------------");
        for (HairShop hs : dao.select2()) {
            System.out.printf("%-10s %-5s %-12s %-6s %-6s\n",
                    hs.getReservation(), hs.getClientName(), hs.getPhone(),
                    hs.getProduct(), hs.getDesigner());
        }
    }

    private static void deleteReservation() {
        System.out.print("이름>> ");
        String name = scn.nextLine();
        System.out.print("예약일자>> ");
        String reservation = scn.nextLine();
        System.out.print("예약을 취소하시겠습니까?(y/n)>> ");
        if (scn.nextLine().equalsIgnoreCase("y")) {
            int result = dao.delete2(name, reservation);
            System.out.println(result > 0 ? "예약 취소 완료." : "취소 실패.");
        } else {
            System.out.println("취소되었습니다.");
        }
    }

    // 고객 등급 계산
    private static String getRank(int pay) {
        if (pay >= 800000) return "VIP";
        else if (pay >= 600000) return "골드";
        else if (pay >= 300000) return "실버";
        else return "일반";
    }
    
    
    private static void delete3() {
        System.out.print("이름>> ");
        String name = scn.nextLine();
        System.out.print("연락처>> ");
        String phone = scn.nextLine();
        System.out.print("삭제하시겠습니까?(y/n)>> ");
        if (scn.nextLine().equalsIgnoreCase("y")) {
            int result = dao.delete3(name, phone);
            System.out.println(result > 0 ? "고객 삭제 완료." : "고객 삭제 실패.");
        } else {
            System.out.println("취소되었습니다.");
        }
    }
}
