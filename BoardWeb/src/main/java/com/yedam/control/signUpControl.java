package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class signUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//get 화면출력
		//post = 회원등록
		req.setCharacterEncoding("utf-8");
		
		if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);
		}else if (req.getMethod().equals("POST")) {
			//db insert
			//images 폴더에 업로드
			//요청정보 경로 최대크기 인코딩 리네임정책
			String savePath = req.getServletContext().getRealPath("images");
			MultipartRequest mr= new MultipartRequest(
		    		req, //요청정보
		    		savePath,//업로드경로
		    		1024*1024*5,//최대크기 바이트 기준(5메가)
		    		"UTF-8",//인코딩
		    		new DefaultFileRenamePolicy()
		    		);
			String id =mr.getParameter("userId");
			String pw =mr.getParameter("userPw");
			String nm =mr.getParameter("userName");
			String img =mr.getFilesystemName("userImg");
			
			MemberVO member= new MemberVO();
			member.setMemberId(id);
			member.setMemberName(nm);
			member.setPassword(pw);
			member.setImg(img);
			
			MemberService svc= new MemberServiceImpl();
			if(svc.addMember(member)) {
				resp.sendRedirect("boardList.do");
			}
			
		}
	}

}
