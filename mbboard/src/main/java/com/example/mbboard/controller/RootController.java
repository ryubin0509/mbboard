package com.example.mbboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mbboard.service.IRootService;

@Controller
public class RootController {
	@Autowired IRootService rootService;
	
	@GetMapping("/")
	public String index(Model model) {
		// 전체 접속카운트(누적)
		// 멤버 접속카운트(누적) 
		// 관리자 접속카운트(누적)
		// 오늘 전체 접속카운트(누적)
		// 오늘 멤버 접속카운트(누적)
		// 오늘 관리자 접속카운트(누적)
		Map<String, Integer> connectCountMapAll = rootService.getConnectCountAll();
		Map<String, Integer> connectCountMapToday = rootService.getConnectCountToday();
		
		model.addAttribute("connectCountMapAll", connectCountMapAll);
		model.addAttribute("connectCountMapToday", connectCountMapToday);
		return "index";
	}
}
