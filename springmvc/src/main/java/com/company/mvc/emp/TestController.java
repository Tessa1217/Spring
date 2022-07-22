package com.company.mvc.emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/paramtest") 
	public ModelAndView parameter() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parameter");
		mv.addObject("param1", "test");
		return mv;
	}
	
	@RequestMapping("/paramtesting")
	public String parameter2(Model model) {
		model.addAttribute("", "");
		return "parameter";
	}
	
	private PrintWriter out;
	
	@RequestMapping("/req1")
	public void request1(@RequestParam(defaultValue="default", required=false) String id,
						HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter(); 
		out.print(id);
	}
	
	@RequestMapping("/req2")
	public void request2(@RequestParam List<String> ids,
						HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter();
		out.print(ids);
	}
	
	@RequestMapping("/req3")
	public void request3(@RequestParam Map<String, Object> map,
						HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter(); 
		out.print(map.get("id"));
		out.print(map.get("ids"));
	}
	
	@RequestMapping("/req4")
	public void request4(RequestVO vo, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter(); 
		out.print(vo);
	}
	
	@RequestMapping("/req5")
	public void request5(ListRequestVO vo, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter(); 
		out.print(vo);
	}
	
	@RequestMapping("/req6")
	public void request6(RequestVO vo, 
						@RequestPart MultipartFile[] pics,
						HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter(); 
		// 첨부파일 업로드
		if (pics != null) {
			for (MultipartFile pic : pics) {
				if (pic != null && pic.getSize() > 0) { // 업로드할 파일이 있으면
					pic.transferTo(new File("C:\\upload\\tmp", pic.getOriginalFilename()));
					out.print(pic.getOriginalFilename() + "<br>");
					out.print(pic.getSize());
				}
			}
		}
		// 정보 출력
		out.print(vo);
	}
	
	@RequestMapping("/req7/{id}/{age}")
	public void request7(@PathVariable String id, 
						@PathVariable int age,
						HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter(); 
		out.print(id);
		out.print(age);
	}
	
	// 스트링 배열 request.getParameterValues() 대신하여 쓰는 방법
	@GetMapping("/array")
	
	public void empArray(@RequestParam String id, 
						@RequestParam String[] deptAry, 
						HttpServletResponse response) throws IOException {
		System.out.println(id);
		System.out.println(deptAry[0]);
		out = response.getWriter(); 
		out.print(id);
		out.print(deptAry);
	}
	
	

}
