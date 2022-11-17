
package com.founder.fasf.beans;

import java.util.ArrayList;
import java.util.List;

public class PageList<T> {

	private Page page;

	public PageList(List<T> list, Page page) {
		this.list = list;
		this.page = page;
	}
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageList() {
		this.list = new ArrayList<T>();
	}


	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
