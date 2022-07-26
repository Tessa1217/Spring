package com.company.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;
import com.company.app.common.PageDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService service;

	// 전체 조회
	@RequestMapping("/boardList")
	public String boardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", service.getBoardList(vo));
		return "board/boardList";
	}
	
	// 페이징
	@GetMapping("/boardList")
	public String boardList(Model model, Criteria cri) {
		// 전체건수
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("boardList", service.getBoardListWithPaging(cri));
		return "board/boardList";
	}

	// 상세 페이지 이동
	@RequestMapping("/boardDetail")
	public String boardDetail(BoardVO vo, Model model) {
		vo = service.getBoard(vo);
		model.addAttribute("board", vo);
		return "board/boardDetail";
	}

	// 삽입 페이지 이동
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		return "board/boardInsert";
	}

	// 삽입
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO vo) {
		service.insertBoard(vo);
		return "redirect:boardList";
	}

	// 수정 페이지 이동
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, Model model) {
		vo = service.getBoard(vo);
		model.addAttribute("board", vo);
		return "board/boardUpdate";
	}

	// 수정
	@PostMapping("/boardUpdate")
	public String boardUpdateProcess(BoardVO vo, RedirectAttributes rttr) {
		if (service.updateBoard(vo)) {
			rttr.addFlashAttribute("result", "update success");
		}
		;
		return "redirect:/board/boardList";
	}

	// 삭제
	@RequestMapping("/boardDelete")
	public String boardDelete(BoardVO vo, RedirectAttributes rttr) {
		if (service.deleteBoard(vo)) {
			rttr.addFlashAttribute("result", "delete success");
		}
		return "redirect:/board/boardList";
	}
}
