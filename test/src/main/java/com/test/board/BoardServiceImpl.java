package com.test.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mapper.BoardMap;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMap boardMap;
	
	public BoardVO boardlist(BoardVO vo) {
		return boardMap.list(vo);
	}
}
