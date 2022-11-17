package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.dto.HealthEducationReport;


public interface IHealthEducationStatisticsService {
	/**
	 * 统计健康教育活动
	 * 
	 * @param criteria 统计查询条件
	 * @return List<HealthEducationReport> 健康教育报表显示列表
	 */
	public List<HealthEducationReport> statisticsHealthEducation(Map<String, String> map);
}
