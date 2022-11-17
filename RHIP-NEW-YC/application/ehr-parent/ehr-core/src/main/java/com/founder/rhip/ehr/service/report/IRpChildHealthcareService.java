package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpChildHealthcareService {
	/**
	 * 保存儿童保健服务统计数据
	 * @param dateStr 日期条件
	 */
	void saveChildHealthcareStatistics(String dateStr);
	
	/**
	 * 查询儿童保健服务统计数据
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getChildHealthcareStatisticsMapList(Map<String, String> paramMap);

	/**
	 * 儿童保健服务绩效考核
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getChildHealthcarePerformanceOrg(Map<String, String> paramMap);

}
