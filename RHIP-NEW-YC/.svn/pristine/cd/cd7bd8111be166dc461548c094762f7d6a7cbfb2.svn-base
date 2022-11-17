package com.founder.rhip.ehr.common;

import java.util.List;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public class PageableDateSource {
	
	public static <T> void exec(IDataSource<T> dataSourceCallback) {
		int current = 1;
		Page page = buildPage(current);
		PageList<T> pageList = dataSourceCallback.get(page);
		List<T> list = pageList.getList();
		dataSourceCallback.run(list);
		list.clear();
		while (page.getTotalPages() > current) {
			page.next();
			current = page.getCurrentPage();
			pageList = dataSourceCallback.get(page);
			list = pageList.getList();
			dataSourceCallback.run(list);
			list.clear();
		}

	}
	
	public static <T> void execFirst(IDataSource<T> dataSourceCallback) {
		Page page = buildPage(1);
		PageList<T> pageList = dataSourceCallback.get(page);
		List<T> list = pageList.getList();
		dataSourceCallback.run(list);
		list.clear();
		while (page.getTotalPages() > 0) {
			page.setCurrentPage(1);
			pageList = dataSourceCallback.get(page);
			list = pageList.getList();
			dataSourceCallback.run(list);
			list.clear();
		}

	}
	
	private static Page buildPage(int current) {
		//pagesize配置不同调用可以不同
		Page page = new Page(1000, current);
		return page;
	}

}
