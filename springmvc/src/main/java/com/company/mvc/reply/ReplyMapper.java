package com.company.mvc.reply;

import java.util.List;

public interface ReplyMapper {
	
	List<ReplyVO> getList(ReplyVO vo);
	ReplyVO read(int rno);
	int insertReply(ReplyVO vo);
	int delete(int rno);
	int update(ReplyVO vo);
	
	

}
