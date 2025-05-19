package com.example.mbboard.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;
import com.example.mbboard.service.LoginService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
public class loginFormController {

    private final LoginService loginService_1;
	@Autowired ILoginService loginService;


    loginFormController(LoginService loginService_1) {
        this.loginService_1 = loginService_1;
    }
	
	
	@GetMapping("/checkId")
	public boolean checkId(@RequestParam("memberId")String memberId) {
	  return loginService.countCheckId(memberId); 
		  
	  }
		
	@PostMapping("/registerForm")
	public String insertId(Member memberParam) {
		loginService.insertId(memberParam);
		
		return "success";
	}
		
		
	}
	

