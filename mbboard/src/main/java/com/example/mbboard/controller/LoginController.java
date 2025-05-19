package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.dto.Page;
import com.example.mbboard.service.ILoginService;
import com.example.mbboard.service.IRootService;
import com.example.mbboard.service.RootService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired ILoginService loginService;
	@Autowired IRootService  rootService;

 
	@GetMapping("findMemberPw")
	public String findMemberPw() {
		return "findMemberPw";
	}
	
	@PostMapping("/findMemberPw")
	public String findMemberPw(Member member) {
		// 비밀번호 변경
		loginService.changeMemberPwByAdmin(member);
		// 메일전송
		// 로그인 페이지로 이동
		
		return "/rechangeMemberPw";
		
	}
	
	@PostMapping("/rechangeMemberPw")
	public String rechangeMemberPw(Member member) {
		
		loginService.updaterechangeMemberPw(member);
		return "login";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
	@PostMapping("/login")
	public String login(HttpSession session, Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		if(loginMember != null) {
			// 클라이언트 쿠키에도 로그인에 성공한 ID만 저장
			
			if(paramMember.getSaveIdCk() != null) {
			Cookie c = new Cookie("saveId", paramMember.getMemberId());
			c.setPath("/"); // 모든 경로에서 사용 가능하도록
			response.addCookie(c);
			} else {
			Cookie c = new Cookie("saveId", "");
			c.setMaxAge(0); // 즉시 삭제
			c.setPath("/");
			}
			
			
			
			session.setAttribute("loginMember", loginMember);
			ConnectCount cc = new ConnectCount();
			cc.setMemberRole(loginMember.getMemberRole());
			if(rootService.getConnectDateByKey(cc) == null) {
				rootService.addConnectCount(cc); // 오늘 날짜 loginMember.getMemberRole()로 1행을 추가 카운터 1
			} else {
				rootService.modifyConnectCount(cc); // 오늘 날짜 loginMember.getMemberRole 수정 카운터 + 1 
			}
		}
		String memberRole = loginMember.getMemberRole();
		if(memberRole == "member") {
			return "/member/memberHome";
		} else {
			return "redirect:/admin/adminHome";
		}
	}
	// 세션안의 상세정보를 보여주는 요청 -> 로그인 상태에서 요청가능 -> 필터1)
	@GetMapping("/member/info") 
	public String info() {
		return "/member/info";
	}
	// 관리자 페이지 요청 -> 로그인 상태이고 role이 'ADMIN'요청가능 -> 필터2)
	@GetMapping("/admin/adminHome") 
	public String adminHome(@RequestParam(value="currentPage",defaultValue = "1")int currentPage, Model model) {
		Page p = new Page(8, currentPage, loginService.countMemberList());
		List<Member>list = loginService.selectNotAdmnMembers(p);
		
		model.addAttribute("member", list);
		model.addAttribute("Page", p);
		return "/admin/adminHome";
	}
	
	@GetMapping("/admin/memberUpdate")
	public String memberUpdate(@RequestParam(defaultValue = "null" )String memberId ,
								Model model) {
		
		Member member = loginService.selectMemberOne(memberId);
		
		model.addAttribute("member", member);
		return "/admin/memberUpdate";
	}
	
	@PostMapping("/admin/memberUpdate")
	public String memberUpdate(@RequestParam String memberId,
							   @RequestParam String memberPw,
							   @RequestParam String memberRole,
							   Model model) {
		
		Member member = new Member();
		member.setMemberId(memberId); 
		member.setMemberPw(memberPw); 
		member.setMemberRole(memberRole);
		
		loginService.updateMemberListOne(member);
		return "redirect:/admin/adminHome";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
}
