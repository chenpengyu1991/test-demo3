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
import com.founder.rhip.ehr.entity.healtheducation.HePromoteUnit;

/**
 * 健康促进单位服务接口,包含了对健康促进单位的创建、修改、删除、查询等操作
 * 
 * @author GaoFei
 *
 */
public interface IHePromoteUnitService {

	/**
	 * 添加健康促进单位
	 * 
	 * @param healthPromoteUnit 健康促进单位对象
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int createHealthPromoteUnit(HePromoteUnit healthPromoteUnit);

	/**
	 * 修改健康促进单位
	 * 
	 * @param healthPromoteUnit 健康促进单位对象
	 * @param properties 更新的属性
	 * @return  成功或者失败标志1->成功，0->失败
	 */
	public int updateHealthPromoteUnit(HePromoteUnit healthPromoteUnit, String... properties);

	/**
	 * 删除健康促进单位
	 * 
	 * @param ids 健康促进单位主键集合
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int deleteHealthPromoteUnit(Long... ids);

	/**
	 * 分页显示健康促进单位
	 * 
	 * @param criteria 查询条件
	 * @param page 页面对象
	 * @return PageList<HealthPromoteUnit>
	 */
	public PageList<HePromoteUnit> findHealthPromoteUnit(Criteria criteria, Page page);
	
	/**
	 * 获取健康促进单位详情
	 * 
	 * @param criteria 查询条件
	 * @return 健康教育促进单位对象
	 */
	public HePromoteUnit getHealthPromoteUnit(Criteria criteria);

}