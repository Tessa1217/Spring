package com.company.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/ajax")
	@ResponseBody
	public EmpVO ajax(EmpVO vo) {
		vo.setFirstName("Kwon");
		vo.setLastName("YuJin");
		return vo;
	}
	
	@Autowired EmpMapper mapper;
	@RequestMapping("/emp")	
	// Parameter는 자동으로 알아서 vo에 담김 (ex - /emp?employee_id=100)
	public String emp(EmpVO vo, Model model) {
		// Spring은 model을 이용하여 값 넘겨줌 (emp라는 이름으로 DB 조최 결과 넘겨줌)
		logger.info(vo.toString());
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp";
	}

	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.getEmpList(null));
		return "empList";
	}
	
}
