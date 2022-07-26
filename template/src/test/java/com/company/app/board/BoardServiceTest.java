package com.company.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	BoardService service;
	
	/* @Setter(onMethod_ = @Autowired)와 동일한 방식
	 * @Autowired public void setService(BoardService service) { this.service =
	 * service; }
	 */
	
	
	@Test
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setBno("4");
		vo.setTitle("테스트하는 글");
		vo.setContent("보드 서비스 테스트하는 글입니다. 게시글 4번에 테스트합니다.");
		vo.setWriter("유진");
		service.insertBoard(vo);
		log.info(vo.getBno());
	}

}
