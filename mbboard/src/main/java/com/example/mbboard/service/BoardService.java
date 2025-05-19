package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper; // 인터페이스 의존형태  - 디커플링
	
	@Override
	public int countBoardList(String searchWord) {
		return boardMapper.countBoardList(searchWord);
	}
	
	@Override
	public List<Board> selectBoardListByPage(Page p){
		List<Board>list = boardMapper.selectBoardListByPage(p);
		
		return list;
	}
	
	@Override
	public Board selectBoardOne(int boardNO) {
		Board board = boardMapper.selectBoardOne(boardNO);
		
		return board;
	}
	
	
	@Override
	public int insertBoard(Board b) {
		return boardMapper.insertBoard(b);
	}
	
	@Override
    public int updateBoard(Board b){
        return boardMapper.updateBoard(b);
        
        
    }
	@Override
	public int deleteBoardByKey(int boardNo) {
	    return boardMapper.deleteBoardByKey(boardNo);
	}


}
