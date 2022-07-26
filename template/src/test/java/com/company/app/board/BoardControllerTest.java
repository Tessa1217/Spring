package com.company.app.board;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:config/*-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	// 가상 서버 역할을 하는 MockMvc
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	@Ignore
	public void listTest() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/boardList"))
					.andReturn()
					.getModelAndView()
					.getModelMap());
	}
	
	//@Test
	@Ignore
	public void insertTest() throws Exception {
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/boardInsert")
					.param("bno", "2")
					.param("title", "Controller Testing")
					.param("content", "컨트롤러에서 삽입 테스트 중입니다.")
					.param("writer", "YuJin")
				).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	//@Test
	@Ignore
	public void boardTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/boardDetail")
					.param("bno", "1"))
					.andReturn()
					.getModelAndView()
					.getModelMap());
	}
	
	//@Test
	@Ignore
	public void updateTest() throws Exception {
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/boardUpdate")
					.param("bno", "2")
					.param("title", "Update Test")
					.param("content", "Update Controller test")
				).andReturn().getModelAndView().getViewName();
		log.info("결과 페이지" + resultPage);
	}
	
	//@Test
	@Ignore
	public void deleteTest() throws Exception {
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/boardDelete")
					.param("bno", "20")).andReturn().getModelAndView().getViewName();
		log.info("결과 페이지" + resultPage);
	}
	
}
