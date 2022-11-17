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

public interface IDaTargetService {

	/**
	 * 统计基药数据-出入库
	 * @Description: 根据orgType进行分组统计
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getChangeTargetList(Page page,Criteria criteria,String orgType);
	
	/**
	 * 统计基药数据-库存
	 * @Description: 根据orgType进行分组统计
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageTargetList(Page page,Criteria criteria,String orgType);

	/**
	 * 统计基药数据-出入库合计
	 * @Description: 根据orgType进行分组统计
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author 
	 */
	public List<Map<String, Object>> getChangeTargetSum(Criteria criteria, String genreCode);
	/**
	 * 统计基药数据-库存合计
	 * @Description: 根据orgType进行分组统计
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author 
	 */
	public List<Map<String, Object>> getStorageTargetSum(Criteria criteria, String genreCode);

}