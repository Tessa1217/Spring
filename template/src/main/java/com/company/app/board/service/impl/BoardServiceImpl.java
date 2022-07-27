package com.company.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.board.mapper.BoardMapper;
import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper mapper;
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return mapper.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mapper.getBoardList(vo);
	}
	
	@Override
	public List<BoardVO> getBoardListWithPaging(Criteria cri) {
		return mapper.getBoardListWithPaging(cri);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return mapper.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		return mapper.deleteBoard(vo) == 1;
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public void updateReplyCnt(String bno, int amount) {
		mapper.updateReplyCnt(bno, amount);
	}
}
