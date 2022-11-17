/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

/**
 * 计划生育
 *
 */
public interface IFamilyPlanningService {

	/**
	 * 获取育龄妇女登记列表
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public PageList<Map<String, Object>> getChildBearingList(Page page,Criteria criteria);
	
	/**
	 * 获取妇女病筛查列表
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public PageList<Map<String, Object>> getWomenDiseaseList(Page page,Criteria criteria);	
	
	/**
	 * 获取婚检登记列表
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public PageList<Map<String, Object>> getPremaritalHealthList(Page page,Criteria criteria);	
	
	/**
	 * 获取育龄妇女登记
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public Object getChildBearing(String id);
	
	/**
	 * 获取妇女病筛查
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public Object getWomenDisease(String id);	
	
	/**
	 * 获取婚检登记
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public Object getPremaritalHealth(String id);	

}