package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpOutpatient;

public interface IRpOutpatientDao extends IDao<RpOutpatient, Long> {
	
	Map<String, Object> getRpOutpatientMap(String orgCode, String dateStr);
	
	List<Map<String, Object>> getRpoutpatientMapList(Map<String, String> paramMap);

	/**
	 * 综合管理首页住院统计(门急诊)
	 * @param criteria
	 * @return
	 */
	Map<String, Object> statisticsFeeOutpatient(String dateStr, String dateFormater);
	
	/**
	 * 门急诊服务绩效考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getOutpatientPerformanceOrg(Map<String, String> paramMap);
}
