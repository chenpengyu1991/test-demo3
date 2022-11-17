package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpOutpatientService {
	
	void saveOutpatientStatistics(String dateStr);
	
	List<Map<String, Object>> getRpoutpatientMapList(Map<String, String> paramMap);

	/**
	 * 综合管理首页住院统计(门急诊)
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> statisticsFeeOutpatient(String dateStr, String dateFormater);
	
	/**
	 * 门急诊服务绩效考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getOutpatientPerformanceOrg(Map<String, String> paramMap);
}
