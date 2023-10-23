package com.docmall.service;

import java.util.List;

import com.docmall.domain.Criteria;
import com.docmall.domain.SBoardVO;

public interface BoardService {

	public void register(SBoardVO board);
	
	public List<SBoardVO> getList();
	
	public SBoardVO get(Long idx);
	
	public void modify(SBoardVO board);
	
	public void delete(Long idx);
	
	public List<SBoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
