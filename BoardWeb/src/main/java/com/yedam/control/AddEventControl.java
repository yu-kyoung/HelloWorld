package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		String eno = req.getParameter("eno");
		String title = req.getParameter("title");
		String startDay = req.getParameter("startDay");
		String endDay = req.getParameter("endDay");
		
		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStartDay(startDay);
		event.setEndDay(endDay);
		
		BoardService svc = new BoardServiceImpl();
	}

}
