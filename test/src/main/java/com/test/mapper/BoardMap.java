package com.test.mapper;

import org.springframework.stereotype.Repository;

import com.test.board.BoardVO;

@Repository(value="boardMap")
public interface BoardMap {
	public BoardVO list(BoardVO vo);
}
