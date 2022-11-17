package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpExaminationEventService {
	/**
	 * 统计指定日期的检验将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertExaminationEventStatistics(String dateStr);

	/**
	 * 查询检验
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getExaminationEventStatistics(Map<String, String> paramMap);
}
