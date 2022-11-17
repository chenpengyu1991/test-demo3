package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.report.RpInhospital;

public interface IRpInhospitalService {
	
	/**
	 * 统计指定日期的病案数将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertInhosMedicalRecordQualityStatistics(String dateStr);

	/**
	 * 查询病案质量
	 * @param paramMap
	 * @param page
	 * @return
	 */
	public List<RpInhospital> getInpatientMedicalRecordQuality(Map<String, String> paramMap);
	
	/**
	 * 统计指定日期的住院出院数据将数据插入表RpInhospital
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	public void insertInpatientInfoStatistics(String dateStr);
	
	/**
	 * 查询出入院相关的数据
	 * @param paramMap
	 * @return
	 */
	public List<RpInhospital> getInOrOutHospitalStatistics(Map<String, String> paramMap);
	
	/**
     * 统计住院人数（按照现在的床位数）
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
	public void insertBedStatistics(String dateStr);
	
	/**
	 * 获取手术麻醉的数据
	 * @param dateStr
	 */
	public void insertAnesthesiaAndSurgeryStatistics(String dateStr);
	
	/**
     * 插入临床路径的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public void insertClinicalPathwayStatistics(String dateStr);
    
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
