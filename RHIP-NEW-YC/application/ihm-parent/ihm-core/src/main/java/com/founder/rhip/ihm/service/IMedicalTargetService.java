/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;

/**
 * 医疗服务
 * 
 * 
 * @version 1.0, 2014-4-24
 * @author Ye jianfei
 */
public interface IMedicalTargetService {
	
	/**
	 * 门急诊信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getOutpatientList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);

	/**
	 * 住院信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getInpatientList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);
	
	/**
	 * 医院费用信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @param opEmHpMark
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getHospitalCostsList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode
			,String opEmHpMark);
	
	/**
	 * 查询临床路径列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<ClinicalPathway> getClinicalPathwayList(Page page,Criteria criteria);

    /**
     * 临床路径统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getClinicalPathwayStatistics(Map<String, String> paramMap);

    /**
     * 治疗质量统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getCureResultAnalys(Map<String, String> paramMap);
	
	/**
	 * 查询床位使用情况列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<SickbedUseState> getSickbedUseStateList(Page page,Criteria criteria);

    /**
     * 监测症状统计
     *
     * @param paramMap
     * @return
     * @author Ye jianfei
     */
    public List<Map<String, Object>> getSymptomList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);


    /**
     * 检查结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getStudyAnalys(Map<String, String> paramMap);
    /**
     * 检验结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getExamAnalys(Map<String, String> paramMap);

    /**
     * A、B类型传染病统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseType(Map<String, String> paramMap);

    /**
     * 1年内按月统计A、B类型传染病
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap);
    
    /**
	 * 检验人数统计
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getExamCount(Map<String, String> paramMap);
}