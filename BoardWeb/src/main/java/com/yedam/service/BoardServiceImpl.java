package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
	}

	@Override
	public BoardVO getBoard(int bno) {//단건조회
		BoardVO board = mapper.selectBoard(bno);//글번호 ->조회
		if(board!=null) {
			mapper.updateReadCnt(bno);//글번호 조회수 증가
			sqlSession.commit();
		}
		return board;
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		int r = mapper.insertBoard(board);//처리된 건수 반환
		if(r==1) {
			sqlSession.commit();//커밋처리
			return true;
		}
		return false;
	}

}
