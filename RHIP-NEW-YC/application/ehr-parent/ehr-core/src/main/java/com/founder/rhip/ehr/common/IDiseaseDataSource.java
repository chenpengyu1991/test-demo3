package com.founder.rhip.ehr.common;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IDiseaseDataSource<T> {
	
	public PageList<T> get(Page page);
	
	public void run(List<T> list, Map<String, Object[]> map);
	
	public void updateStatistics(Map<String, Object[]> map);

}
