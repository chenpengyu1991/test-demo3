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
import com.founder.rhip.ehr.entity.healtheducation.HeSupervisor;

import java.util.Map;

/**
 * 健康工作督查服务接口,包含了工作督查情况登记、修改、删除、查询等操作
 * 
 * @author GaoFei
 *
 */
public interface IHeSupervisorService {

	/**
	 * 添加工作督查情况记录
	 * 
	 * @param  healthSupervisor 工作督查情况对象
	 * @param map 附件上传记录
	 * @param createrName 操作者名字
	 */
	public void createHealthSupervisor(HeSupervisor healthSupervisor, Map<String, String> map, String createrName);

	/**
	 * 修改工作督查情况记录
	 * 
	 * @param  healthSupervisor 工作督查情况对象
	 * @param map 附件上传记录
	 * @param createrName 操作者名字
	 * @param properties
	 */
	public void updateHealthSupervisor(HeSupervisor healthSupervisor, Map<String, String> map, String createrName, String... properties);

	/**
	 * 删除工作督查情况记录
	 * 
	 * @param ids 工作督查情况主键集合
	 * @return  成功或者失败标志1->成功，0->失败
	 */
	public int deleteHealthSupervisor(Long... ids);

	/**
	 * 分页显示工作督查情况记录
	 * 
	 * @param   criteria 查询条件
	 * @param   page 页面对象
	 * @return   PageList<HealthSupervisor>
	 */
	public PageList<HeSupervisor> findHealthSupervisor(Criteria criteria, Page page);
	
	/**
	 * 获取工作督查详情
	 * 
	 * @param criteria
	 * @return
	 */
	public HeSupervisor getHealthSupervisor(Criteria criteria);

}