package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.report.RpTreatmentQuality;

public interface IRpTreatmentQualityService {
	
	/**
	 * 统计指定日期的病案数将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertTreatmentQualityStatistics(String dateStr);

	/**
	 * 查询治疗质量
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<RpTreatmentQuality> getTreatmentQuality(Map<String, String> paramMap);
}
