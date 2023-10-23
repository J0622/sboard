package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.Criteria;
import com.docmall.domain.SBoardVO;
import com.docmall.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;

	@Override
	public void register(SBoardVO board) {
		boardMapper.register(board);
	}

	@Override
	public List<SBoardVO> getList() {
		// TODO Auto-generated method stub
		return boardMapper.getList();
	}

	@Override
	public SBoardVO get(Long idx) {
//		조회수 증가 작업
		boardMapper.readCount(idx);
		
		return boardMapper.get(idx);
	}

	@Override
	public void modify(SBoardVO board) {
		// TODO Auto-generated method stub
		 boardMapper.modify(board);
	}

	@Override
	public void delete(Long idx) {
		boardMapper.delete(idx);
		
	}

	@Override
	public List<SBoardVO> getListWithPaging(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}

	
}
