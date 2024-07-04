package com.board.vo.util;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.ToString;

@ToString
public class PageMaker {

	private int totalRow;

	private Criteria cri;

	private int display = 10;

	private int pageStart;

	private int pageEnd;

	private boolean prev;

	private boolean next;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;

		pageEnd = (int) (Math.ceil(cri.getPage() / (double) display) * display);
		pageStart = pageEnd - display + 1;

		int tempEnd = (int) Math.ceil(totalRow / (double) cri.getAmount());

		if (pageEnd > tempEnd) {
			pageEnd = tempEnd;
		}

		prev = pageStart == 1 ? false : true;
		next = pageEnd * cri.getAmount() >= totalRow ? false : true;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public Criteria getCri() {
		return cri;
	}
	
	public String makeSearch(int page) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("amount", cri.getAmount())
				.queryParam("keyword", ((SearchCriteria)cri).getKeyword())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.build();
		
		return uri.toString();
	}
	
	public String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		}catch(Exception e) {
			return "";
		}
	}

}
