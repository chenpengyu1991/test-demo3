/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.rhip.ehr.entity.child.ChildDeathRecord;
import com.founder.rhip.ehr.entity.child.ChildUnderThreeManage;

import java.util.List;
import java.util.Map;

/**
 * 妇幼保健
 *
 * @version 1.0, 2014-4-22
 * @author Cary
 */
public interface IWchTargetService {

    /**
     * 儿童人数统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getChildCount(Map<String, String> paramMap);

	/**
	 * 儿童保健（基础数据）
	 * @param paramMap
	 * @return
	 * @author Cary
	 */
	public List<Map<String, Object>> getChildBaseInfo(Map<String, String> paramMap);
	
	/**
	 * 儿童保健（保健服务）
	 *
	 * @param paramMap
	 * @return
	 * @author Cary
	 */
	public List<Map<String, Object>> getChildService(Map<String, String> paramMap);

	/**
	 * 儿童保健（营养评价）
	 * @Description: 根据orgType进行分组统计
	 * @param paramMap
	 * @return
	 * @author Cary
	 */
	public List<Map<String, Object>> getChildNutrition(Map<String, String> paramMap);
	
	/**
	 * 孕产妇保健统计
	 * @param paramMap
	 * @return
	 */
    public List<Map<String,Object>> getMotherhoodPeriodFollowupStatistics(Map<String, String> paramMap);

	/**
	 * 儿童疫苗接种率
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getChildVacc(Map<String, String> paramMap);

	/**
	 * 住院分娩率
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getHospitalDelivery(Map<String, String> paramMap);

	/**
	 * 3岁以下儿童系统管理率 ,修改
	 * @param paramMap
	 * @return
	 */
	public List<ChildUnderThreeManage> getNewChildMgnt3(String criteria, String gbCode);

	/**
	 * 孕产妇死亡率统计(修改)
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getNewMaternalDeath(Map<String, String> paramMap);

	/**
	 * 儿童死亡率统计，修改
	 * @param criteria
	 * @return
	 */
    List<ChildDeathRecord> getChildDeathMortality(String monthList, String gbCode);
}