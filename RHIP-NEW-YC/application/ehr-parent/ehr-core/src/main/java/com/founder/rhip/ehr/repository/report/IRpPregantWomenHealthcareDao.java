package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpPregantWomenHealthcare;

public interface IRpPregantWomenHealthcareDao extends
		IDao<RpPregantWomenHealthcare, Long> {
	
	List<Map<String, Object>> getPregantWomenHealthcareMapList(Map<String, String> paramMap);

	/**
	 * 育龄妇女保健工作量考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getGestationalPerformanceOrg(Map<String, String> paramMap);
	
	/**
	 * 孕产妇保健工作量考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getPregantPerformanceOrg(Map<String, String> paramMap);
	
}
