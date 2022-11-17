package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.fasf.beans.PageList;

public class SelectDTO<T> {
	private int pageSize;
	private int pageCount;
	private int currentPage;
	private List<T> objList;
	
	public SelectDTO() {
		
	}

	public SelectDTO(PageList<T> pageList) {
		this.objList = pageList.getList();
		this.setCurrentPage(pageList.getPage().getCurrentPage());
		this.setPageCount(pageList.getPage().getTotalPages());
		this.setPageSize(pageList.getPage().getPageSize());
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getObjList() {
		return objList;
	}

	public void setObjList(List<T> objList) {
		this.objList = objList;
	}

}
