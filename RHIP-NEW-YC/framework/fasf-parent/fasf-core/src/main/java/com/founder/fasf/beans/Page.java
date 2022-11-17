package com.founder.fasf.beans;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private int totalRows;

	private int pageSize;

	private int currentPage;

	private int previousPage;

	private int nextPage;

	private int totalPages;

	private int startRow;
	
	private String url;

	private List<Integer> pageList;

	public Page() {
	}

	public Page(int _totalRows) {
		totalRows = _totalRows;
		totalPages = (totalRows + pageSize - 1) / pageSize;
		currentPage = 1;
		startRow = 0;
	}

	public Page(int pageSize, int pageIndex) {
		this.pageSize = pageSize;
		currentPage = pageIndex;
		startRow = pageSize * (pageIndex - 1);
	}
	
	public Page(int pageSize, int pageIndex,String url) {
		this.pageSize = pageSize;
		currentPage = pageIndex;
		startRow = pageSize * (pageIndex - 1);
		this.url = url;
	}
	

	public int getStartRow() {
		return startRow;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		totalPages = (totalRows + pageSize - 1) / pageSize;
		this.startRow = pageSize * (currentPage - 1);
		this.previousPage = currentPage > 1 ? (currentPage - 1) : 1;
		this.nextPage = currentPage < totalPages ? (currentPage + 1) : totalPages;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void first() {
		currentPage = 1;
		startRow = 0;
	}

	public void previous() {
		if (currentPage == 1) {
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}

	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}

	public void last() {
		currentPage = totalPages > 0 ? totalPages : 1;
		startRow = (currentPage - 1) * pageSize;
	}

	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		this.startRow = (currentPage - 1) * this.getPageSize();
		if (currentPage > totalPages) {
			last();
		}
	}

	public List<Integer> addPage(int showPages) {
		List<Integer> list = new ArrayList<Integer>();
		int begin = currentPage - 2;
		int end = currentPage + showPages - 3;
		if (begin <= 0) {
			begin = 1;
			end = showPages;
		}
		if (end >= totalPages) {
			begin = totalPages - showPages + 1;
			if (begin <= 0) {
				begin = 1;
			}
			end = totalPages;
		}
		for (int i = begin; i <= end; i++) {
			list.add(i);
		}
		return list;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
