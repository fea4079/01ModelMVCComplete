package com.model2.mvc.common;


public class SearchVO {
	
	private int page;
	String searchCondition;
	String searchKeyword;
	int pageUnit;
//	private int itemPerPage = 10;     //한 페이지에 들어있는 아이템의 수
//	private int nextPage = 10;         //뛰어 넘는 페이지의 수
//	private int totalItemCount;         //총 아이템 수 
	
	public SearchVO(){
	}
	
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}