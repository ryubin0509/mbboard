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
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@WebFilter("/admin/*")
public class AdminFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = null;
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpReq  = (HttpServletRequest) request;
			session = httpReq.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			// 로그인이 안되어 있을떄 (인증)
			if(loginMember == null) {
				if(response instanceof HttpServletResponse) {
					log.info("OnSessionFilter에 걸려서 login으로 이동");
					((HttpServletResponse)  response).sendRedirect("/login");
					return;
				}
			}
			
			// 로그인은 되어있지만 
			if(loginMember.getMemberRole().equals("admin") == false) {
				if(response instanceof HttpServletResponse) {
					log.info("OnSessionFilter에 걸려서 sendRedirect / member/info 됨");
				}
				((HttpServletResponse) response).sendRedirect("/member/info");
				return;
			}
		}
		
		
		chain.doFilter(request, response);
	}
	

}
