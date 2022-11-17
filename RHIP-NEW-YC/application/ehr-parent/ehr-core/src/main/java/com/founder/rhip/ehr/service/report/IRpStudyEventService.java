package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.report.RpStudyEvent;

public interface IRpStudyEventService {
	/**
	 * 统计指定日期的检查将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertStudyEventStatistics(String dateStr);

	/**
	 * 查询检查
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<RpStudyEvent> getStudyEventStatistics(Map<String, String> paramMap);
}
