package com.yedam.board;

import java.util.Scanner;

//BoardExe:
//추가 addboard
//,수정//글번호 조회 바뀔내용, 바꿀제목
//,삭제,
//목록boardlist -상세화면
//순번부여 nextSequence() 현재글번호 +1
//조회 (글번호 입력->글반환)메소드 getBoard
public class BoardExe {
	// 필드
	private Board[] boards;// 데이터 저장★
	private Scanner scn = new Scanner(System.in);
	private int bno = 2;// 배열 인덱스 2 부터 시작

//	(page-1)*5 <(page*5)
//	(page*5)

	// 생성자
	public BoardExe() {
		boards = new Board[100];// 배열 개수
		boards[0] = new Board(10, "날씨", "기온이 30도", "홍길동");
		boards[1] = new Board(11, "자바11", "기온이 30도임", "김길동");
		boards[2] = new Board(12, "자바12", "기온이 30도임", "김길동");
		boards[3] = new Board(13, "자바13", "기온이 30도임", "김길동");
		boards[4] = new Board(14, "자바14", "기온이 30도임", "김길동");
		boards[5] = new Board(15, "자바15", "기온이 30도임", "김길동");
		boards[6] = new Board(16, "자바16", "기온이 30도임", "김길동");
		boards[7] = new Board(17, "자바17", "기온이 30도임", "김길동");
		boards[8] = new Board(18, "자바18", "기온이 30도임", "김길동");
		boards[9] = new Board(19, "자바19", "기온이 30도임", "김길동");
		boards[10] = new Board(20, "자바20", "기온이 30도임", "김길동");

	}

	// loginCheck
	boolean loginCheck() {
		for (int i = 1; i <= 3; i++) {
			String id = userMessage("아이디를 입력");
			String pw = userMessage("비밀번호를 입력");
			// 로그인 성공하면...
			if (!UserExe.login(id, pw)) {
				System.out.println("아이디와 비밀번호를 확인하세요.");
				if (i == 3) {
					System.out.println("3번 실패했습니다. 종료합니다.");
					return false;
				}
				continue;
			} else {
				return true;
			} // 실패
		} // 3번의 기회를 제공.
		return false;// 로그인을 성공하면 언제라도 반복문을 빠져 나와서 아래 코드를 실행.
	}// loginCheck

//메소드
	void execute() {
		if (!loginCheck()) {
			return;// execute 메소드 종료
		}
		System.out.println("환영합니다");

		boolean run = true;
//		int time = 0;//try안됨

//		반복

		// 3번기회제공, 5월21일 과제
		// 아이디 입력
//		while (time < 3) {
//
//		
//			String userId =userMessage("아이디 입력");
		// 아이디 입력
//			String passwd =userMessage("비밀번호 입력");
//			// 비밀번호 입력
//
//			if (!UserExe.login(userId, passwd)) {
//				System.out.println("확인하세요");
//				time++;
//			} else {
//				System.out.println("환영합니다");
//				break;
//				
//			}
//		} // while
//
//		if(time==3) {
//			System.out.println("운영자를 찾아주세요");
//			return;//끝 메소드
//		}

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.추가 2.수정 3.삭제. 4.목록 5.종료");
			System.out.println("-------------------------------------");
			System.out.println("선택>>");
			int selectNo = 0;
			// 문자를 숫자로 변경 하면서 예외발생

			try {
				selectNo = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("1-5번중에서 선택");
				continue;// 반복문의 처음으로
			}

			switch (selectNo) {
			case 1:// 추가
				addBoard();
				break;
			case 2:// 수정
				modifyBoard();
				break;
			case 3:// 삭제
				removeBoard();
				break;
			case 4:// 목록
				boardList();
				break;
			case 5:// 종료
				run = false;
				System.out.println("종료");
				break;
			default:
				System.out.println("메뉴를 다시선택하세요");
			}// switch

		} // while
	}// execute

	// 글번호를 입력하세요>>
	// 제목을 입력하세요
	// 내용을 입력하세요
	// 작성자를 입력하세요
	// 추가성공 //추가실패

	void addBoard() {
//		System.out.print("글번호를 입력하세요>> ");

		int no = nextSequence();// Integer.parseInt(userMessage("글번호를 입력하세요"));
		String title = userMessage("제목을 입력하세요");
		String content = userMessage("내용을 입력하세요");
		String writer = userMessage("작성자를 입력하세요");

		Board board = new Board(no, title, content, writer);
		// 배열에 저장
		boards[bno++] = board;
		System.out.println("추가성공");

	}// addBoard

	void boardList() {
		// 글번호 제목 작성자
		// ===================
		// 1 날씨 ㅇ
		// 2 클래스 ㅋ
		// 3 자바 ㅁ
		// ** 등록된 글이 없습니다. **
//		---------------------------
//		상세보기:글번호 입력 ,메뉴로 이동(q);
//		---------------------------

//		sort();
		int page = 1;
		// while 반복문
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5;

			System.out.println("글번호      제목       작성자");
			System.out.println("========================");

			for (int i = start; i < end; i++) {
				if (boards[i] != null) {// 널 값이 아닌 목록
					boards[i].showInfo();
				}
			}
			// 상세보기
			System.out.println("----------------------------------");
			System.out.println("상세보기:글번호 입력,이전(p) 다음(n), 메뉴로 이동(q)");
			System.out.println("----------------------------------");
			System.out.println("선택>> ");

			String str = scn.nextLine();// 문자입력
			// 메뉴이동.상세보기
			if (str.equals("q")) {
				break;// 돌아가기
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("p")) {
				page--;
			} else {
				int no = 0;
				try {//번호 외 다른 문자가 들어오지 못하게 함
					no = Integer.parseInt(str);// 글번호 문자를 숫자로
					// 배열에서 조회
				} catch (NumberFormatException e) {
					System.out.println("목록의 글번호 중에 선택");
					continue;//목록다시보여주기
				}

				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과가 없습니다.");
					return;
				}
				sboard.showAllInfo();// 상세보기
			}
		}
		System.out.println();
	}// boardList

	void modifyBoard() {
		int bno = userMenu("수정할 글 번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}

		String title = userMessage("수정할 제목을 입력하세요");
		String content = userMessage("수정할 내용을 입력하세요");
		//
		result.setTitle(title);
		result.setContent(content);
		System.out.println("수정완료");

	}// modify

	void removeBoard() {
		int bno = userMenu("삭제할 글 번호를 입력하세요");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
				System.out.println("삭제완료");
			}
		}
	}

	// 단건 조회
	// 글 번호를 활용해서 배열에 조회하고 보드 반환
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		} // for
		return null;// 조건에 맞는 글번호가 없으면 널 반환
	}// getBoard

	// 사용자 입력값을 반환
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}// userMessage

	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				// 낫 널이 있어야함
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;
	}// next

	// 역순을로 정렬 하는 기능
	void sort() {
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.

}
