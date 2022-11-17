package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpExpenseService {
	/**
	 * 保存费用报表数据
	 * @param dateStr 数据采集日期
	 */
	void saveExpenseStatistics(String dateStr);
	
	/**
	 * 获取医疗费用报表
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getRpExpenseMapList(Map<String, String> paramMap);
	
	/**
	 * 疾病经济负担
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getBurdenRpExpenseMapList(Map<String, String> paramMap);
}
