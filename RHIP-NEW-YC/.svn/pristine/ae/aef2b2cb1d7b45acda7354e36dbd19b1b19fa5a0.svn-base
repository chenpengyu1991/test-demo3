package com.founder.rhip.ehr.repository.report;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpInhospital;

public interface IRpInhospitalDao extends IDao<RpInhospital, Long> {
	/**
	 * 并按数量统计
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<RpInhospital> getInhosMedicalRecordQualityStatistics(Map<String, String> paramMap);
	
	/**
	 * 查询出入院相关的数据
	 * @param paramMap
	 * @return
	 */
	public List<RpInhospital> getInOrOutHospitalStatistics(Map<String, String> paramMap);
	
	/**
     * 临床路径
     * @param paramMap
     * @return
     */
	public List<RpInhospital> getClinicalPathwayStatistics(Map<String, String> paramMap);
	
	/**
	 * 综合管理首页住院统计(住院)
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> statisticsFeeInhospital(String dateStr, String dateFormater);
	
	/**
	 * 住院服务绩效考核
	 * @param paramMap
	 * @return
	 */
	public List<RpInhospital> getRpInhospitalPerformanceOrg(Map<String, String> paramMap);
}
