/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.healtheducation.HeWorkPlan;

/**
 * 健康教育登记-年度工作计划的创建、修改、删除、查询等操作
 * 
 * @author jiang_haiying
 * 
 */
public interface IHeWorkPlanService {

	/**
	 * 添加年度工作计划
	 * 
	 * @param workPlan 年度工作计划对象
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int createHeWorkPlan(HeWorkPlan workPlan);

	/**
	 * 修改年度工作计划
	 * 
	 * @param workPlan 年度工作计划对象
	 * @param properties 需要更新的属性
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int updateHeWorkPlan(HeWorkPlan workPlan, String... properties);

	/**
	 * 删除年度工作计划
	 * 
	 * @param ids 年度工作计划主键集合
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int deleteHeWorkPlan(Long... ids);

	/**
	 * 分页显示年度工作计划
	 * 
	 * @param criteria 查询条件
	 * @param page 页面对象
	 * @return PageList<HeWorkPlan>
	 */
	public PageList<HeWorkPlan> findHeWorkPlan(Criteria criteria, Page page);
	
	/**
	 * 获取年度工作计划详情
	 * 
	 * @param criteria
	 * @return
	 */
	public HeWorkPlan getHeWorkPlan(Criteria criteria);

}