package com.example.mbboard.filter;

import java.io.IOException;

import com.example.mbboard.dto.Member;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/member/*")
class OnSessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// session을 loginMember 유/무 확인
		
		HttpSession session = null;
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpReq  = (HttpServletRequest) request;
			session = httpReq.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			if(loginMember == null) {
				if(response instanceof HttpServletResponse) {
					log.info("OnSessionFilter에 걸려서 login으로 이동");
					((HttpServletResponse)  response).sendRedirect("/login");
					
				}
			}
		}
		chain.doFilter(request, response);
	}
}
