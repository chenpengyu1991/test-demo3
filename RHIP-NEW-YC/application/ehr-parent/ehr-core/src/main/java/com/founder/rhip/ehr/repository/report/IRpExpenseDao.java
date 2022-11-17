package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpExpense;

public interface IRpExpenseDao extends IDao<RpExpense, Long> {
	
	List<Map<String, Object>> getRpExpenseMapList(Map<String, String> paramMap);
	
	/**
	 * 疾病经济负担
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getBurdenRpExpenseMapList(Map<String, String> paramMap);
}
