package com.yedam.board;

public class Board {
	// Board: 글번호, 제목, 내용, 작성자
	// getter, setter 작성 :메소드
	// 기본생성자, 전체매개값 생성자
	private int boardNo;// 글번호
	private String title;// 제목
	private String content;// 내용
	private String writer;// 작성자
	// 생성자

	public Board() {
	}

	public Board(int boardNo, String title, String content, String writer) {

		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	// 글번호 제목 작성자 조회
	public void showInfo() {
		System.out.printf("%3d %-12s %-4s\n", boardNo, title, writer);
	}

	// 상세보기
	public void showAllInfo() {
		String strFormat = "글번호: %d  작성자: %s \n";
		strFormat += "제목: %s\n";
		strFormat += "내용: %s\n";//이런식으로 사용가능
		System.out.printf(strFormat, boardNo, title, writer, content);
	}
//	글번호:1 작성자:ㅁ 
//	제목:ㅁㅇ
//	내용:ㅁㄴㅇㅁㄴ

}
