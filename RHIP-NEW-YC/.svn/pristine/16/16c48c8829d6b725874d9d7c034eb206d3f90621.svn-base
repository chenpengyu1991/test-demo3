package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpPregantWomenHealthcareService {
	/**
	 * 保存妇女保健服务统计报表
	 * @param dateStr 日期
	 */
	void savePregantWomenHealthcareStatistics(String dateStr);
	
	/**
	 * 查询妇女保健服务统计报表
	 * @param paramMap 查询参数
	 * @return
	 */
	List<Map<String, Object>> getPregantWomenHealthcareMapList(Map<String, String> paramMap);
	
	/**
	 * 育龄妇女保健工作量考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getGestationalPerformanceOrg(Map<String, String> paramMap);
	
	/**
	 * 孕产妇保健工作量考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getPregantPerformanceOrg(Map<String, String> paramMap);
}
