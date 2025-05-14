package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;

public interface IBoardService {
	int countBoardList(String searchWord);
	List<Board> selectBoardListByPage(Page p);
	Board selectBoardOne(int boardNo);
	
	int updateBoard(Board board);
	int insertBoard(Board b);

	int deleteBoardByKey(int boardNo);
	

}
