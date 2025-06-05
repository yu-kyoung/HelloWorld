package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

//M-V-Control 역할
//url 패턴과 실행서블릿을 관리
public class FrontController extends HttpServlet {
	Map<String, Control> map;
	
	public FrontController() {
		map=new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	//boardList.do - 글목록 출력 기능
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/addBoard.do", new AddBoardControl());
		//처리순서중요
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//url 이 호출( http://localhostL8080/boardWeb/boardList.do) -> 페이지 호출 -> Control.
		String uri=req.getRequestURI();///BoardWeb/boardList.do
		String page= uri.substring(9);//
		Control sub= map.get(page);
		sub.exec(req, resp);
	}
	
	
	
}
