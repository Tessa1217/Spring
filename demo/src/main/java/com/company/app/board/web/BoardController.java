package com.company.app.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;
import com.company.app.common.PageDTO;

@Controller
public class BoardController {
	
	@Autowired BoardService service;
	
	@RequestMapping("/boardList")
	public String boardList(Criteria cri, Model model) {
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("boardList", service.getBoardListWithPaging(cri));
		return "boardList";
	}
	
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo, Model model) {
		return "boardInsert";	
	}
	
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO vo, Model model) {
		service.insertBoard(vo);
		return "redirect:boardList";
	}
	
	
	
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, Model model) {
		model.addAttribute("board", service.getBoard(vo));
		return "boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo) {
		service.updateBoard(vo);
		return "redirect:boardList";
	}

}
