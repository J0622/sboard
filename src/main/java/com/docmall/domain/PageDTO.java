package com.docmall.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO { 
    private int startPage;
    private int endPage;
    private boolean prev,next;
    private int total;
    private Criteria cri;

    public PageDTO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;

        int pageSize = 10; 
        int endPageInfo = pageSize - 1;  // 

        this.endPage = (int) (Math.ceil(cri.getPageNum() / (double) pageSize)) * pageSize;
        this.startPage = this.endPage - endPageInfo;
        
        int readEnd = (int) Math.ceil((total * 1.0) / cri.getAmount());
        
        if (readEnd <= this.endPage) {
            this.endPage = readEnd;
        }
        this.prev = this.startPage > 1;
        this.next = this.endPage < readEnd;
		
	}

}
