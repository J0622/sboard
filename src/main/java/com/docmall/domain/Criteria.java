package com.docmall.domain;



import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	
	private int pageNum;
	private int amount;

	private String type;
//	검색어
	private String keyword;

	public Criteria() {
		this(1, 10);
		System.out.println("기본생성자 호출");
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public String[] getTypeArr() {
		
		return type == null? new String[] {} : type.split("") ;
	}
	
	public String getListLink() {
	    UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
	            .queryParam("pageNum", this.pageNum)
	            .queryParam("amount", this.amount)
	            .queryParam("type", this.type)
	            .queryParam("keyword", this.keyword);

	    return builder.toUriString();
	}
	
}
