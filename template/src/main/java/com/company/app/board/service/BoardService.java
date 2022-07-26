package com.company.app.board.service;

import java.util.List;

import com.company.app.common.Criteria;

public interface BoardService {
	
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	int getTotalCount(Criteria cri);
	List<BoardVO> getBoardListWithPaging(Criteria cri);
	int insertBoard(BoardVO vo);
	boolean updateBoard(BoardVO vo);
	boolean deleteBoard(BoardVO vo);

}
