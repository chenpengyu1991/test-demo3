/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.da.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.repository.da.IDailyMonitoringDao;

@Service("dailyMonitoringService")
public class DailyMonitoringServiceImpl extends AbstractService implements IDailyMonitoringService {
    
	@Resource(name = "dailyMonitoringDao")
    private IDailyMonitoringDao dailyMonitoringDao; 

	@Resource(name = "outpatientPrescriptionDao")
    private IOutpatientPrescriptionDao outpatientPrescriptionDao; 
	
	@Resource(name = "drugUsageDao")
    private IDrugUsageDao drugUsageDao; 
	
	/**
	 * 获取异常处方列表
	 *
	 * @param page
	 * @param criteria
	 * @param order
	 * @param monitorIndex
	 * @return
	 * @note monitorIndex = 1:处方金额
	 * @note monitorIndex = 2:用量
	 * @note monitorIndex = 3:天数
	 * @note monitorIndex = 4:处方品种
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getUnusualPrescriptionList(Page page, Criteria criteria,Order order,String monitorIndex,Map<String,String> paramMap) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = dailyMonitoringDao.getUnusualPrescriptionList(page, criteria,order,monitorIndex,paramMap);
		}
		return result;
	}

	/**
	 * 获取处方详细
	 *
	 * @param ehrId
	 * @param recordNumber
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public OutpatientPrescription getOutpatientPrescription(String ehrId, String recordNumber) {
		OutpatientPrescription result = null;
		if(StringUtil.isNotEmpty(ehrId) && StringUtil.isNotEmpty(recordNumber)){
			result = outpatientPrescriptionDao.getOutpatientPrescription(ehrId, recordNumber);
		}
		return result;
	}

	/**
	 * 获取用药列表
	 *
	 * @param page
	 * @param criteria
	 * @param order
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<DrugUsage> getDrugUsageList(Page page,Criteria criteria,Order order){
		PageList<DrugUsage> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = drugUsageDao.getPageList(page, criteria, order);
		}
		return result;
	}

	/**
	 * 获取医师用药监控列表
	 *
	 * @param page
	 * @param criteria
	 * @param patientType :门诊 1/住院 2
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getPhysicianDrugList(String patientType,Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) 
				&& ObjectUtil.isNotEmpty(criteria)
				&& ObjectUtil.isNotEmpty(patientType)){
			result = dailyMonitoringDao.getPhysicianDrugList(patientType, page, criteria);
		}
		return result;
	}

	/**
	 * 获取用药排名列表
	 *
	 * @param page
	 * @param criteria
	 * @param patientType
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getMedicationRankingList(String patientType,Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) 
				&& ObjectUtil.isNotEmpty(criteria)
				&& ObjectUtil.isNotEmpty(patientType)){
			result = dailyMonitoringDao.getMedicationRankingList(patientType, page, criteria);
		}
		return result;
	}

	/**
	 * 获取药品费用占比列表
	 *
	 * @param page
	 * @param criteria
	 * @param patientType
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getDrugCostList(String patientType,Page page,Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) 
				&& ObjectUtil.isNotEmpty(criteria)
				&& ObjectUtil.isNotEmpty(patientType)){
			result = dailyMonitoringDao.getDrugCostList(patientType, page, criteria);
		}	
		return result;
	}
	
	/**
	 * 获取药品明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getDrugDetailList(String patientType,Page page,Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) 
				&& ObjectUtil.isNotEmpty(criteria)
				&& ObjectUtil.isNotEmpty(patientType)){
			result = dailyMonitoringDao.getDrugDetailList(patientType, page, criteria);
		}	
		return result;
	}
	
	/**
	 * 获取费用明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getItemDetailList(String patientType,Page page,Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) 
				&& ObjectUtil.isNotEmpty(criteria)
				&& ObjectUtil.isNotEmpty(patientType)){
			result = dailyMonitoringDao.getItemDetailList(patientType, page, criteria);
		}	
		return result;
	}	
	
	/**
	 * 获取药品价格监督列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getDrugPriceList(Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = dailyMonitoringDao.getDrugPriceList(page, criteria);
		}
		return result;
	}
	

}