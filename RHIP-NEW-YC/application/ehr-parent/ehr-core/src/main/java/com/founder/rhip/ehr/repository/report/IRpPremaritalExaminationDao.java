package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpPremaritalExamination;

public interface IRpPremaritalExaminationDao extends
		IDao<RpPremaritalExamination, Long> {
	
	List<Map<String, Object>> getPremaritalExaminationMapList(Map<String, String> paramMap);

	/**
	 * 男女婚检绩效考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getPremaritalPerformanceOrg(Map<String, String> paramMap);
}
