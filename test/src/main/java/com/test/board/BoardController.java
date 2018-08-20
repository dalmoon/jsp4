package com.test.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list.do")
	public String boardlist(BoardVO vo, Model model) {
		model.addAttribute("boardlist", boardService.boardlist(vo));
		return "WEB-INF/board/list";
	}
}
