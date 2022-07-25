package com.company.mvc.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
	
	@Autowired ReplyMapper mapper;
	
	// 전체 조회
	@GetMapping("/reply")
	@ResponseBody
	public List<ReplyVO> replyList(ReplyVO vo) {
		return mapper.getList(vo);
	}
	
	// 단건 조회
	@GetMapping("/reply/{rno}")
	@ResponseBody
	public ReplyVO replySelect(@PathVariable int rno) {
		return mapper.read(rno);
	}
	
	// 삽입
	@PostMapping("/reply")
	public ReplyVO replyInsert(ReplyVO vo) {
		mapper.insertReply(vo);
		return vo;
	}
	
	// 수정
	@PutMapping("/reply")
	public ReplyVO replyUpdate(@RequestBody ReplyVO vo) {
		mapper.update(vo);
		return vo;	
	}
	
	// 삭제
	@DeleteMapping("/reply/{rno}")
	public int replyDelete(@PathVariable int rno) {
		mapper.delete(rno);
		return rno;
	}
}
