package com.docmall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SBoardVO {
	private Long idx;
	private String subject;
	private String content;
	private String author;
	
	private Date createdate;
	private Date editdate;
	
	private int readcount;
}
