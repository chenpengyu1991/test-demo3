/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

import java.util.List;
import java.util.Map;

/**
 * 绩效(机构、个人)
 * * @version 1.0, 2014-6-17
 * @author Cary
 */
public interface IPerformanceService {

    /**
     * 医疗考核个人绩效-门诊摘要(挂号人次)
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getOutpatientPersonPerformance(Map<String, String> paramMap, Page page);
  
    /**
     * 医疗考核个人绩效-处方
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getPrescriptionPersonPerformance(Map<String, String> paramMap, Page page);
    
    /**
     * 妇幼保健个人绩效
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getWchPersonPerformance(Map<String, String> paramMap, Page page);

    /**
     * 疫苗接种针次数
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getVaccinationPerformance(Map<String, String> paramMap);

    /**
     * 体检次数、各体检项目次数
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getHealthExamPerformance(Map<String, String> paramMap);

    /**
     * 绩效- 机构人员培训
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getTrainingPerformance(Map<String, String> paramMap);

    /**
     * 慢病个人绩效
     * @param paramMap
     * @param type  1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @return
     */
    public PageList<Map<String, Object>> getCdmPersonPerformance(String type, Map<String, String> paramMap, Page page);

    /**
     * 健康档案个人绩效
     * @param paramMap
     * @return
     */
    public PageList<Map<String, Object>> getHRPersonPerformance(Map<String, String> paramMap, Page page);


    /**
     * 基本医疗效率指标(机构)
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
	public List<Map<String, Object>> getServiceCapacityList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);


    /**
     * 基本医疗效率指标(机构):单个机构指标
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
    public Map<String, Object> getServiceCapacity(String beginDate
            ,String endDate
            ,String genreCode
            ,String gbCode
            ,String parentCode
            ,String organCode);
    
    /**
     * 机构绩效-健康档案
     *
     * @param paramMap
     * @return
     * @author Ye jianfei
     */
    public List<Map<String, Object>> getHRPerformanceList(Map<String, String> paramMap);

    /**
     *公共卫生服务项目指标
     * @param beginDate
     * @param endDate
     * @param genreCode
     * @param gbCode
     * @param parentCode
     * @param organCode
     * @return
     */
    public List<Map<String, Object>> getServiceProjectPerformance(String beginDate
            ,String endDate
            ,String genreCode
            ,String gbCode
            ,String parentCode
            ,String organCode);
    
    /**
     * 抗菌药物统计查询
     * @param paramMap 参数
     * @param page
     * @return 统计结果
     * @author GaoFei
     */
    public PageList<Map<String, Object>> getAntibacterialsList(Map<String, String> paramMap, Page page);
    
    /**
     * 统计使用抗菌药医生
     * @param orgCode
     * @param medicalCode
     * @return
     */
    public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA,String endDateA);
    
    /**
     * 统计住院病案首页质量
     * @param paramMap
     * @param page
     * @return
     */
    public  PageList<Map<String, Object>> getInpatientMedicalRecordQuality(Map<String, String> paramMap, Page page);
    
    /**
     * 统计抗生素处方
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getAntibacterialsPrescriptionList(Map<String, String> paramMap);
}