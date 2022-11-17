package com.founder.rhip.ehr.service.report;

import com.founder.rhip.ehr.entity.report.RpSymptom;

import java.util.List;
import java.util.Map;

public interface IRpSymptomService {

	/**
	 * 目前该方法没有实现
	 * 统计指定日期的就诊记录统计监测症状--50症状数据插入表RpSymptom
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertSymptomStatistics(String dateStr);

	/**
	 * 从就诊记录统计监测症状--50症状(查询)
	 * @param paramMap
	 * @return
	 */
	public List<RpSymptom> getSymptom(Map<String, String> paramMap);

	/**
	 * 1年内按月统计
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getSymptomMonth(Map<String, String> paramMap);

}
