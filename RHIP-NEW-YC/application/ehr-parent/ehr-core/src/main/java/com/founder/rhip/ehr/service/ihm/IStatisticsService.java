package com.founder.rhip.ehr.service.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;

import java.util.List;
import java.util.Map;

public interface IStatisticsService {
	
	/**
	 * 综合管理首页门诊统计
	 * @param criteria
	 * @return
	 */
	public HmOutpatient statisticsOutpatient(Criteria criteria);
	
	/**
	 * 综合管理首页住院统计
	 * @param criteria
	 * @return
	 */
	public HmHospitalize statisticsHospitalize(Criteria criteria);
	
	/**
     * 医生使用档案数
     * @param criteria
     * @return
     */
    public int countRow(Criteria criteria);

    /**
     * 预防接种总人数
     * @param criteria
     * @return
     */
    public int vaccinationNum(Criteria criteria);

    /**
     * 本年接种人数
     * @param criteria
     * @return
     */
    public int vaccinationNumByYear(Criteria criteria);

	//检验检查分析
	public List<Map<String, Object>> getCheckExamList(Map<String, String> paramMap);


	//用药分析
	public List<Map<String, Object>> getDrugUseList(Map<String, String> paramMap);

    
}
