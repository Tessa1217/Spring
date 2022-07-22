package com.company.mvc.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired BoardMapper mapper;
	
	@RequestMapping("/boardList")
	public String boardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", mapper.getBoardList(vo));
		return "board/boardList";
	}
	
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		return "board/boardInsert";
	}
	
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO vo) {
		mapper.insertBoard(vo);
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, Model model) {
		vo = mapper.getBoard(vo);
		model.addAttribute("board", vo);
		return "board/boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdateProcess(BoardVO vo) {
		return "redirect:boardList";
	}

}
