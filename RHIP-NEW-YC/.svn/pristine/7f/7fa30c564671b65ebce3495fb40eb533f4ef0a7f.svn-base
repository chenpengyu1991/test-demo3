package com.founder.rhip.ehr.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public class PageableDiseaseDataSource {
	
	public static <T> void exec(IDiseaseDataSource<T> dataSourceCallback) {
		Map<String, Object[]> map = new HashMap<>();
		int current = 1;
		Page page = buildPage(current);
		PageList<T> pageList = dataSourceCallback.get(page);
		List<T> list = pageList.getList();
		dataSourceCallback.run(list, map);
		list.clear();
		while (page.getTotalPages() > current) {
			page.next();
			current = page.getCurrentPage();
			pageList = dataSourceCallback.get(page);
			list = pageList.getList();
			dataSourceCallback.run(list, map);
			list.clear();
		}
		
		dataSourceCallback.updateStatistics(map);
	}
	
	
	private static Page buildPage(int current) {
		//pagesize配置不同调用可以不同
		Page page = new Page(1000, current);
		return page;
	}

}
