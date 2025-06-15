package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.RetCode;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO rno을 삭제.
		String rno = req.getParameter("rno");

		// DB 입력처리.
		ReplyService svc = new ReplyServiceImpl();

		if (svc.removeReply(Integer.parseInt(rno))) {
			resp.getWriter().print(RetCode.getRetCode(true));
		} else {
			resp.getWriter().print(RetCode.getRetCode(false));
		}
	}



}
