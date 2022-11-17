/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

import java.util.List;
import java.util.Map;

/**
 * 综合查询
 * @version 1.0, 2014-10-31
 * @author ROSE
 */
public interface IldaService {

    /**
     * 大处方监管查询
     * @param page
     * @param criteria
     * @param order
     * @param monitorIndex
     * @param paramMap
     * @return
     * @note monitorIndex = 1:处方金额
     * @note monitorIndex = 2:用量
     * @note monitorIndex = 3:天数
     * @note monitorIndex = 4:处方品种
     * @author Ye jianfei
     */
    public PageList<Map<String, Object>> getUnusualPrescriptionList(Page page, Criteria criteria,Order order,String monitorIndex,Map<String,String> paramMap);

    /**
     * 抗菌药物使用情况查询
     * @param paramMap 参数
     * @param page
     * @return 统计结果
     * @author ROSE
     */
    public PageList<Map<String, Object>> getAntibacterialsList(Map<String, String> paramMap, Page page);

    /**
     * 抗菌药物使用情况查看医生
     * @param orgCode
     * @param medicalCode
     * @param beginDateA
     * @param endDateA
     * @return
     */
    public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA,String endDateA);
    
    /**
     * 获取特殊药物信息
     * @param paramMap 查询参数
     * @param page 分页
     * @return
     */
    public PageList<Map<String, Object>> getDrugStatisticsMapPageList(Map<String, String> paramMap, Page page);

}