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
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

/**
 * 药品监控SERVICE
 * 
 * 
 * @version 1.0, 2014-1-16
 * @author Ye jianfei
 */
public interface IDrugMonitoringService {

	/**
	 * 获取药库入库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageInList(Page page, Criteria criteria);
	
	/**
	 * 获取药库入库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageInDetailList(Page page, Criteria criteria);	
	
	/**
	 * 获取药库出库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageOutList(Page page, Criteria criteria);
	
	/**
	 * 获取药库出库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageOutDetailList(Page page, Criteria criteria);	
	
	/**
	 * 获取药库库存列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageList(Page page, Criteria criteria);
	
	/**
	 * 获取药库退库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageReturnList(Page page, Criteria criteria);
	
	/**
	 * 获取药Pharmacy退库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageReturnDetailList(Page page, Criteria criteria);		
	
	/**
	 * 获取药房入库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyInList(Page page, Criteria criteria);
	
	/**
	 * 获取药房入库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyInDetailList(Page page, Criteria criteria);	
	
	/**
	 * 获取药房出库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyOutList(Page page, Criteria criteria);
	
	/**
	 * 获取药房出库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyOutDetailList(Page page, Criteria criteria);
	
	/**
	 * 获取药房库存列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyList(Page page, Criteria criteria);	
	
	/**
	 * 获取药房退库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyReturnList(Page page, Criteria criteria);
	
	/**
	 * 获取药房退库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyReturnDetailList(Page page, Criteria criteria);	
	
	/**
	 * 获取药房退药列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyCancelList(Page page, Criteria criteria);
	
	/**
	 * 获取药房退药详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPharmacyCancelDetailList(Page page, Criteria criteria);		
	
	/**
	 * 获取药品养护列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getUpkeepList(Page page, Criteria criteria);	
}