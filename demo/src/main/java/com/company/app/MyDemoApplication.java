package com.company.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.mapper.EmpMapper;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.company.app.**.mapper")
public class MyDemoApplication {
	
	@Autowired EmpMapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(MyDemoApplication.class, args);
	}
	
	@RequestMapping("/")
	public String test(Model model) {
		model.addAttribute("str1", "<h1>Testing Thymeleaf</h1>");
		model.addAttribute("str2", "<p><b>text vs. utext</b></p>");
		model.addAttribute("empList", mapper.getEmpList(null));
		return "leaftest";
	}

}
