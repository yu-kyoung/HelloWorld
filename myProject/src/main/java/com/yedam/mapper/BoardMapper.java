package com.yedam.mapper;

import com.yedam.vo.BoardVO;

//인터페이스- BoardMapper.xml 매칭  패키지가 같아야함  똑같은 이름의 메소드
public interface BoardMapper {
	public BoardVO selectBoard();
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	
}
