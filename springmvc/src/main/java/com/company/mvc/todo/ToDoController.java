package com.company.mvc.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ToDoController {
	
	@Autowired TodoMapper mapper;
	
	@GetMapping(value="/getText", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String getText() {
		return "안녕하세요";
	}
	
	// 조회
	@GetMapping(value="/todo", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<TodoVO>> todoList(TodoVO vo) {
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity<List<TodoVO>>(list, HttpStatus.OK);
	}
	
//	@GetMapping("/check")
//	public List<TodoVO> check() {
//		ResponseEntity<TodoVO> result = null;
//		int a = 5/0;
//		return mapper.findAll(null);
//	}
	
	
	
	// 단건 조회
	@GetMapping("/todo/{no}")
	@ResponseBody
	public TodoVO todoSelect(@PathVariable int no) {
		return mapper.findById(no);
	}
	
	// 삽입
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}
	
	// 변경
	@PutMapping("/todo")
	// PUT은 파라미터가 JSON으로 들어오기 때문에 파싱 위한 @RequestBody 넣어줘야 함
	public TodoVO todoUpdate(@RequestBody TodoVO vo) {
		System.out.println(vo.getNo());
		mapper.merge(vo);
		return vo;
	}
	
	// 삭제
	@DeleteMapping("/todo/{no}")
	public int todoDelete(@PathVariable int no) {
		mapper.remove(no);
		return no;
	}
	
}
