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
import com.founder.rhip.ehr.entity.healtheducation.HeResource;

import java.util.Map;

/**
 * 健康教育资源服务接口包含了对教育资源的添加、修改、删除、查询等功能
 * 
 * @author GaoFei
 *
 */
public interface IHeResourceService {

	/**
	 * 获取健康教育资源
	 * 
	 * @param criteria 查询条件
	 * @return 健康教育资源
	 */
	public HeResource getHealthEducationResource(Criteria criteria);
	
	/**
	 * 添加健康教育资源
	 * 
	 * @param  healthEducationResource 健康教育资源对象
	 * @param fileMap 上传文件记录
	 * @param createName 操作者姓名
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int createHealthEducationResource(HeResource healthEducationResource, Map<String, String> fileMap, Map<String, String> fileNameMap, String createrName);

	/**
	 * 修改健康教育资源
	 * 
	 * @param healthEducationResource 健康教育资源对象
	 * @param fileMap 上传文件记录
	 * @param createrName 操作者姓名
	 * @param properties 要更新的属性
	 * @return  成功或者失败标志1->成功，0->失败
	 */
	public int updateHealthEducationResource(HeResource healthEducationResource, Map<String, String> fileMap, Map<String, String> fileNameMap, String createrName, String... properties);

	/**
	 * 删除健康教育资源
	 * 
	 * @param ids 健康教育资源主键集合
	 * @return 
	 */
	public int deleteHealthEducationResource(Long... ids);

	/**
	 * 分页显示健康教育资源
	 * 
	 * @param criteria 查询条件
	 * @param page 页面对象
	 * @return PageList<HealthEducationResource>
	 */
	public PageList<HeResource> findHealthEducationResource(Criteria criteria, Page page);

}