package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpStudyEvent;

public interface IRpStudyEventDao extends IDao<RpStudyEvent, Long> {
	
	public List<RpStudyEvent> getStudyEventStatistics(Map<String, String> paramMap);
}
