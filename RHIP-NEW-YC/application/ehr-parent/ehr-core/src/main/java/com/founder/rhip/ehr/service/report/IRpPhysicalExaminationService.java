package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpPhysicalExaminationService {
	
	void savePhysicalExaminationPaStatistics(String dateStr);
	
	List<Map<String, Object>> getPhysicalExaminationMapList(Map<String, String> paramMap);

}
