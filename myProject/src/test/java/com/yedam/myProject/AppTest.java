package com.yedam.myProject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
//        assertTrue( true );
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession sqlSession = factory.openSession();
		BoardMapper mapper=sqlSession.getMapper(BoardMapper.class);
		
		
		BoardVO board = new BoardVO();
		board.setTitle("mybatis연습66");
		board.setContent("mybatis입력테스트66");
		board.setWriter("user66");
		board.setBoardNo(6);

		//바꿔주기
//		int r = sqlSession.delete("com.yedam.mapper.BoardMapper.deleteBoard", board);
		int r= mapper.deleteBoard(board.getBoardNo());
		
		
		if (r > 0) {
			sqlSession.commit();//커밋
			System.out.println("등록성공");
		}

		List<BoardVO> list = sqlSession.selectList("com.yedam.mapper.BoardMapper.selectBoard");
		for (BoardVO board2 : list) {
			System.out.println(board2.toString());
		}

	}
}
