package com.docmall.mapper;

import java.util.List;

import com.docmall.domain.Criteria;
import com.docmall.domain.SBoardVO;

public interface BoardMapper {

//	게시글 저장
	public void register(SBoardVO board);
	
//	게시물 읽기
	public SBoardVO get(Long idx);
	
//	글 수정하기
	public void modify(SBoardVO board);
	
//	조회수 증가
	public void readCount(Long idx);
	
//	목록
	public List<SBoardVO> getList();
	
//	페이징 목록			 
	public List<SBoardVO> getListWithPaging(Criteria cri);
	
//	전체 데이터 개수, 이때 검색이 포함되는 경우 검색에 대한 개수를 확인해야하므로 Criteria cri를 사용
	public int getTotalCount(Criteria cri); //type,keyword를 사용하게 됨, 개수만 셀거니까
	
//	글 삭제하기
	public void delete(Long idx);
	
}
