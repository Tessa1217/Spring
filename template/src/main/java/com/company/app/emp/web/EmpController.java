package com.company.app.emp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.service.EmpSearchVO;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;


@Controller
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	// 서비스
	@Autowired EmpService service;
	
	// 단 건 조회
	@RequestMapping("/emp")	
	public String emp(EmpVO vo, Model model) {
		// Spring은 model을 이용하여 값 넘겨줌 (emp라는 이름으로 DB 조최 결과 넘겨줌)
		logger.info(vo.toString()); 
		model.addAttribute("emp", service.getEmp(vo));
		return "emp/emp";
	}
	
	// 전체 조회
	@RequestMapping("/empList")
	public String empList(EmpSearchVO vo, Model model) {
		model.addAttribute("empList", service.getEmpList(vo));
		return "emp/empList";
	}
	
	// 등록 페이지 이동
	@RequestMapping("/empInsert")
	// @GetMapping 등 메서드 타입별로 구별하여 사용 가능
	public String empInsert() {
		return "emp/empInsert";
	}
	
	// 등록 
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) { // EmpVO vo = Command 객체
		logger.info(vo.toString());
		int insert = service.insertEmp(vo);
		logger.info(insert + "건 삽입 완료");
		return "redirect:empList";
	}
	
	// 수정 페이지로 이동
	@RequestMapping("/empUpdate/{id}")
	public String empUpdateForm(@PathVariable String id, EmpVO vo, Model model) {
		vo.setEmployeeId(id);
		model.addAttribute("emp", service.getEmp(vo));
		return "emp/empUpdate";
	}
	
	// 수정
	@PostMapping("/empUpdate")
	public String empUpdate(EmpVO vo) {
		int update = service.updateEmp(vo);
		logger.info(update + "건 수정 완료");
		return "redirect:empList";
	}
	
	// 삭제
	@RequestMapping("/empDelete")
	public String empDelete(EmpVO vo) {
		int delete = service.deleteEmp(vo);
		logger.info(delete + "건 삭제 완료");
		return "redirect:empList";
	}
	
}
