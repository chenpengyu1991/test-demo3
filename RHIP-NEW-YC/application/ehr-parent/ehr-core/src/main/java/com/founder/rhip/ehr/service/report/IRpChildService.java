package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpChildService {
	void saveChildAgeStatistics(String dateStr);
	
	List<Map<String, Object>> getChildAgeMapList(Map<String, String> paramMap);
}
