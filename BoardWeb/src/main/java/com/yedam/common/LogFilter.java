package com.yedam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogFilter implements Filter {

	public LogFilter() {
		System.out.println("필터객체 생성");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 실행 전");

		String host = req.getRemoteAddr();
		String port = "" + req.getRemotePort();
		System.out.println("접속호스트: " + host + "포트: " + port);

		HttpServletRequest request=(HttpServletRequest) req;
		String uri=request.getRequestURI();
		String context=request.getContextPath();
		String page= uri.substring(context.length());
		System.out.println("ip: " +host+",page: "+page);
		
//		(list.indexOf(host)!= -1)
		if(!host.equals("0:0:0:0:0:0:0:1")) {//접속 차단
			return;
		}
		HttpSession session=request.getSession();
		
		
		chain.doFilter(req, resp);// 서블릿 실행

		System.out.println("서블릿 실행 후");
	}

}
