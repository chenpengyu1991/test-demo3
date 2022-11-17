package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpChildHealthcare;

public interface IRpChildHealthcareDao extends IDao<RpChildHealthcare, Long> {
	
	List<Map<String, Object>> getChildHealthcareMapList(Map<String, String> paramMap);

	/**
	 * 儿童保健服务绩效考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getChildHealthcarePerformanceOrg(Map<String, String> paramMap);;
}
