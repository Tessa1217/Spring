package com.company.mvc.reply;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class ReplyMapperTest {
	
	@Autowired ReplyMapper mapper;
	
	// List Test
	@Test
	public void getList() {
		ReplyVO vo = new ReplyVO();
		vo.setBno("1");
		List<ReplyVO> list = mapper.getList(vo);
		for (ReplyVO reply : list) {
			System.out.println(reply.getRno());
		}
	}
	
	// Insert Test
	@Test
	public void insertTest() {
		ReplyVO vo = new ReplyVO();
		vo.setBno("1");
		vo.setReply("Testing");
		vo.setReplyer("Tester1");
		int insert = mapper.insertReply(vo);
		System.out.println(insert + "건 등록 완료");
	}
}
