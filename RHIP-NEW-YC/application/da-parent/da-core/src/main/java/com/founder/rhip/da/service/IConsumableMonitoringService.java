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
 * 卫生耗材SERVICE
 * 
 * 
 * @version 1.0, 2014-1-16
 * @author Ye jianfei
 */
public interface IConsumableMonitoringService {

	/**
	 * 获取入库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getInList(Page page, Criteria criteria);
	
	/**
	 * 获取入库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getInDetailList(Page page, Criteria criteria);	
	
	/**
	 * 获取出库列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getOutList(Page page, Criteria criteria);
	
	/**
	 * 获取出库详细列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getOutDetailList(Page page, Criteria criteria);	
	
	/**
	 * 获取库存列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStoreList(Page page, Criteria criteria);
	
	/**
	 * 获取报损列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getBreakageList(Page page, Criteria criteria);
}