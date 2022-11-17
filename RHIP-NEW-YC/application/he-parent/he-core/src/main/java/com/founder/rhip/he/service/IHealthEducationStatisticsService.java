package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.HealthEducationReport;

import java.util.List;


public interface IHealthEducationStatisticsService {
	/**
	 * 统计健康教育活动
	 * 
	 * @param criteria 统计查询条件
	 * @return List<HealthEducationReport> 健康教育报表显示列表
	 */
	public List<HealthEducationReport> statisticsHealthEducation(Criteria criteria);

	public List<HealthEducationReport> getEduCensusList(Criteria criteria);
}
