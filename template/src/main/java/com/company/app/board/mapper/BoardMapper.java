package com.company.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

public interface BoardMapper {
	
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	List<BoardVO> getBoardListWithPaging(Criteria cri);
	int getTotalCount(Criteria cri);
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(BoardVO vo);
	void updateReplyCnt(@Param("bno") String bno, @Param("amount") int amount);

}
