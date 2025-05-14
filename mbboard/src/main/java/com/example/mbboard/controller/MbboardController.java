package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.service.IBoardService;

@Controller
public class MbboardController {
	@Autowired IBoardService boardService;
	
	@GetMapping("/mbboardList")
	public String mbboardList(@RequestParam(value= "searchWord", defaultValue ="") String searchWord, 
							  @RequestParam(value= "currentPage", defaultValue = "1")int currentPage,  Model model) {
		
		Page p = new Page(10, currentPage, boardService.countBoardList(searchWord), searchWord);
		
		
		List<Board> list = boardService.selectBoardListByPage(p);
		model.addAttribute("list", list);
		model.addAttribute("page", p);
		return "mbboardList";
	}
	
	@GetMapping("/mbinsertList")
	public String insertmbboardList( ) {
		
		return "mbinsertList";
	}
	
	@PostMapping("/mbinsertList")
	public String insertmbboardList(@RequestParam String boardTitle,
									@RequestParam String boardContent,
									@RequestParam String boardUser ) {
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardUser(boardUser);
		
		boardService.insertBoard(board);
		
		return "redirect:mbboardList";
	}
	
	@GetMapping("/mbListOne")
	public String memberListOne(@RequestParam int boardNo,
								Model model) {
	Board board	 = boardService.selectBoardOne(boardNo); 
	model.addAttribute("board", board);
	
	return "mbboardOne";
	
		
	}
	
	@GetMapping("/updatembListOne")
	public String updateListOne(@RequestParam int boardNo,
								Model model) {
	
	Board board	 = boardService.selectBoardOne(boardNo); 
	model.addAttribute("board", board);
		return "mbUpdateOne";
	
	}
	
	@PostMapping("/updatembListOne")
	public String updateListOne(
			@RequestParam int boardNo,
			@RequestParam String boardTitle,
			@RequestParam String boardContent,
			@RequestParam String boardUser) {
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardUser(boardUser);
		
		boardService.updateBoard(board); 
		return "redirect:mbboardList";
	}
	
	@GetMapping("/deletembListOne")
	public String deleteListOne(@RequestParam int boardNo) {
		
		boardService.deleteBoardByKey(boardNo);
		
		return "redirect:mbboardList";
	}
}
