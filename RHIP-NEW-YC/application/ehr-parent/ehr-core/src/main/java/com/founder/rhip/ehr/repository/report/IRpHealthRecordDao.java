package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpHealthRecord;

public interface IRpHealthRecordDao extends IDao<RpHealthRecord, Long> {
	
	public List<Map<String, Object>> getRpHealthRecordStatistics(Map<String, String> paramMap);
	
	public List<Map<String, Object>> getModifyTraceStatistics(Map<String, String> paramMap);
}
