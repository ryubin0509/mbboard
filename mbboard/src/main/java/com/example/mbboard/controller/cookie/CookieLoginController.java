package com.example.mbboard.controller.cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;
import com.example.mbboard.service.IRootService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class CookieLoginController {
	
	@Autowired ILoginService loginService;
	
	
	@GetMapping("/cookieLogin")
	public String cookieLogin() {
		return "/cookie/cookieLogin";
	}
	
	@GetMapping("/cookieLogout")
	public String logout (HttpServletResponse response) {
		Cookie loginMemberId = new Cookie("loginMemberId", null);
		response.addCookie(loginMemberId);
		return "cookie/cookieLogin";
	}
	
	
	@PostMapping("/cookieLogin")
	public String login(HttpSession session, Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		if(loginMember != null) {
			// 클라이언트 쿠키에도 로그인에 성공한 ID만 저장
			
			if(paramMember.getSaveIdCk() != null) {
			Cookie c = new Cookie("saveId", paramMember.getMemberId());
			c.setPath("/"); // 모든 경로에서 사용 가능하도록
			response.addCookie(c);
			
			Cookie loginMemberId = new Cookie("loginMemberId",paramMember.getMemberId());
			response.addCookie(loginMemberId);
			return "redirect:/cookieSuccess";
			}  else {
				Cookie loginMemberId = new Cookie("loginMemberId",paramMember.getMemberId());
				response.addCookie(loginMemberId);
				
				Cookie c = new Cookie("saveId","");
				c.setMaxAge(0); // 쿠키 삭제
				c.setPath("/");
				response.addCookie(c);
				return "redirect:/cookieSuccess";
			}
			
	}
		return "redirect:/cookieFail";
	}
	
	@GetMapping("/cookieSuccess")
	public String cookieSuccess(@CookieValue(value = "loginMemberId", required = false) String loginMemberId ) {
		if(loginMemberId == null || loginMemberId.equals("")) {
			return "redirect:/cookieLogin";
		}
		
		// 로그인이 되어있다면
		return "cookie/cookieSuccess";
	}
}
