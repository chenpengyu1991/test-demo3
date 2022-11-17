package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpHealthRecordService {
	/**
	 * 统计指定日期的检验将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertHealthRecordStatistics(String dateStr);

	/**
	 * 查询检验
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getHealthRecordStatistics(Map<String, String> paramMap);
	
	/**
	 * 统计指定日期的档案更新将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	public void insertModifyTraceStatistics(String dateStr);
	
	/**
	 * 查询档案更新
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getModifyTraceStatistics(Map<String, String> paramMap);
	
	/**
	 * 统计指定日期的医生数量更新将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	public void insertStaffStatistics(String dateStr);
}
