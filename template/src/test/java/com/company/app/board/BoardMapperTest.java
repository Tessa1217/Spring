package com.company.app.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.board.mapper.BoardMapper;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class BoardMapperTest {

	@Autowired BoardMapper mapper;
	
	//@Test
	@Ignore
	public void test() {
		BoardVO vo = new BoardVO();
		vo.setBno("1");
		System.out.println(mapper.getBoardList(vo));
	}
	
	@Test
	public void pagingTest() {
		Criteria cri = new Criteria();
		cri.setPageNum(7);
		cri.setAmount(10);
		List<BoardVO> list = mapper.getBoardListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
}
