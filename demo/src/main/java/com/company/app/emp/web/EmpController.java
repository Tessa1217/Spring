package com.company.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.mapper.DepartmentVO;
import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.mapper.EmpVO;
import com.company.app.emp.mapper.JobVO;

@Controller
public class EmpController {
	
	@Autowired EmpMapper dao;
	
	@RequestMapping("/empList")
	public String empList(EmpVO vo, Model model) {
		System.out.println("dept: " + vo.getDepartmentId());
		model.addAttribute("empList", dao.getEmpList(vo));
		return "empList";
	}
	
	@RequestMapping("/empInsert")
	public String empInsert(Model model) {
		return "empInsert";
	}
	
	@ModelAttribute("jobs")
	public List<JobVO> getJobs() {
		return dao.getJobs(null);
	}
	
	@ModelAttribute("depts")
	public List<DepartmentVO> getDepartments() {
		return dao.getDepartments(null);
	}
	
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO vo) {
		dao.empInsert(vo);
		return "redirect:empList";
	}
	
	@GetMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		model.addAttribute("emp", dao.getEmp(vo));
		return "empUpdate";
	}
	
	@PostMapping("/empUpdate")
	public String empUpdate(EmpVO vo) {
		dao.empUpdate(vo);
		return "redirect:empList";
	}
}
