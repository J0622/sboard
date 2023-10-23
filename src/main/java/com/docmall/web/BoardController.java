
package com.docmall.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docmall.domain.Criteria;
import com.docmall.domain.PageDTO;
import com.docmall.domain.SBoardVO;
import com.docmall.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/register")
	public void register() {
		log.info("called register...");
	}
	@PostMapping("/register")
	public String register(SBoardVO board) {
		log.info("게시판 입력데이터" + board);
		
		boardService.register(board);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		List<SBoardVO> list = boardService.getListWithPaging(cri);
		model.addAttribute("list", list);

		int total = boardService.getTotalCount(cri);
		log.info("데이터 총 개수: " + total); 

		PageDTO pageDTO = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageDTO);
		log.info("페이징 정보: " + pageDTO);

	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("idx") Long idx,@ModelAttribute("cri") Criteria cri, Model model ) {
		log.info("페이징 정보를 보여주세요: " + cri);
		
		SBoardVO board = boardService.get(idx);
		model.addAttribute("board", board);
	}
	@PostMapping("/modify")
	public String modify(SBoardVO board, Criteria cri,RedirectAttributes rttr) {
		log.info("수정 데이터: " + board);
		log.info("Criteria 정보: " + cri);
		
		boardService.modify(board);
		rttr.addAttribute("pageNum", cri.getPageNum());		
		rttr.addAttribute("amount", cri.getAmount());		
		rttr.addAttribute("type", cri.getType());		
		rttr.addAttribute("keyword", cri.getKeyword());		
		return "redirect:/board/list";
	}

//	삭제하기
	@GetMapping("/delete")
	public String delete(@RequestParam("idx") Long idx,Criteria cri,RedirectAttributes rttr) {
		log.info("삭제할 글번호: " + idx);
		boardService.delete(idx);
		
		return "redirect:/board/list" + cri.getListLink();
	}
}

