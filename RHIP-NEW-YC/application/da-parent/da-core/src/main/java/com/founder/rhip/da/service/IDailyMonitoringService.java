/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.da.service;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;

public interface IDailyMonitoringService {

	/**
	 * 获取异常处方列表
	 *
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
	 * 获取处方详细
	 *
	 * @param ehrId
	 * @param recordNumber
	 * @return
	 * @author Ye jianfei
	 */
	public OutpatientPrescription getOutpatientPrescription(String ehrId,String recordNumber);
	
	/**
	 * 获取用药列表
	 *
	 * @param page
	 * @param criteria
	 * @param order
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<DrugUsage> getDrugUsageList(Page page,Criteria criteria,Order order);
	/**
	 * 获取医师用药监控列表
	 *
	 * @param page
	 * @param criteria
	 * @param patientType :门诊B05000001/住院B05000002
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPhysicianDrugList(String patientType,Page page,Criteria criteria);
	
	/**
	 * 获取用药排名列表
	 *
	 * @param page
	 * @param criteria
	 * @param patientType
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getMedicationRankingList(String patientType,Page page,Criteria criteria);
	
	/**
	 * 获取药品费用占比列表
	 *
	 * @param page
	 * @param criteria
	 * @param patientType
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getDrugCostList(String patientType,Page page,Criteria criteria);
	
	/**
	 * 获取药品明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getDrugDetailList(String patientType,Page page,Criteria criteria);
	
	/**
	 * 获取费用明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getItemDetailList(String patientType,Page page,Criteria criteria);	
	
	/**
	 * 获取药品价格监督列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getDrugPriceList(Page page, Criteria criteria);
	

}