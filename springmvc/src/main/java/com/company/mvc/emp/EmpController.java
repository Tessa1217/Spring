package com.company.mvc.emp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	// Spring = s4j
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired EmpMapper mapper;
	@RequestMapping("/emp")	
	// Parameter는 자동으로 알아서 vo에 담김 (ex - /emp?employee_id=100)
	public String emp(EmpVO vo, Model model) {
		// Spring은 model을 이용하여 값 넘겨줌 (emp라는 이름으로 DB 조최 결과 넘겨줌)
		logger.info(vo.toString());
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp/emp";
	}

	@RequestMapping("/empList")
	public String empList(EmpSearchVO vo, Model model) {
		model.addAttribute("empList", mapper.getEmpList(vo));
		model.addAttribute("deptList", mapper.getDepartmentList());
		return "emp/empList";
	}
	
	// 등록 페이지 이동
	@RequestMapping("/empInsert")
	// @GetMapping 등 메서드 타입별로 구별하여 사용 가능
	public String empInsert() {
		return "emp/empInsert";
	}
	
	// 등록 처리
	// DispatcherServlet이 1차적으로 vo 생성 후 해당 jsp에서 vo에 값을 담고 최종적으로
	// 매개변수로 넘겨주기 때문에 바로 EmpVO vo(Command 객체) 사용 가능
	// JSP에서 GET으로 요청 보내고 mapping은 POST일 경우 405번 에러 발생
	// GET과 POST일 경우 동일한 URL도 관계 없음
	// @RequestMapping(value="/empInsert", method = RequestMethod.POST)
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) { // EmpVO vo = Command 객체
		logger.info(vo.toString());
		int insert = mapper.getEmpInsert(vo);
		logger.info(insert + "건 삽입 완료");
		return "redirect:empList";
	}
	
	// 수정 페이지로 이동
	@RequestMapping("/empUpdate/{id}")
	public String empUpdateForm(@PathVariable String id, EmpVO vo, Model model) {
		vo.setEmployeeId(id);
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp/empUpdate";
	}
	
	// 수정
	@PostMapping("/empUpdate")
	public String empUpdate(EmpVO vo) {
		int update = mapper.getEmpUpdate(vo);
		logger.info(update + "건 수정 완료");
		return "redirect:empList";
	}
	
	@RequestMapping("/empDelete")
	public String empDelete(EmpVO vo) {
		int delete = mapper.empDelete(vo);
		logger.info(delete + "건 삭제 완료");
		return "redirect:empList";
	}
	
}
