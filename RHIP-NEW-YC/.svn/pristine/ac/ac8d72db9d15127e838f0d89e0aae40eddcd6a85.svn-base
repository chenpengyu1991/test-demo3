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
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;

import java.util.Map;

/**
 * 健康教育活动服务接口，包含对健康活动的添加、修改、删除、查询等操作
 * @author GaoFei
 *
 */
public interface IHeActiveService {

	/**
	 * 添加健康教育活动
	 * 
	 * @param heActive 健康教育活动对象
	 * @param healthResourceRecord 资料放放、宣传阵地使用情况记录对象
	 * @param map 上传附件记录
	 * @param createrName 操作者名字
	 */
	public void createHealthEducationActive(HeActive heActive, HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> fileNameMap, String createrName);

	/**
	 * 修改健康教育活动
	 * 
	 * @param heActive 健康教育活动对象
	 * @param healthResourceRecord 资料放放、宣传阵地使用情况记录对象
	 * @param map 上传附件记录
	 * @param createrName TODO
	 * @param properties
	 */
	public void updateHealthEducationActive(HeActive heActive, HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> fileNameMap, String createrName, String... properties);

	/**
	 * 删除健康教育活动
	 * 
	 * @param ids 健康教育活动主键集合
	 */
	public void deleteHealthEducationActive(Long... ids);

	/**
	 * 分页显示健康教育活动
	 * @param  criteria 查询条件
	 * @param   page 页面对象
	 * @return   PageList<HeActive>
	 */
	public PageList<HeActive> findHealthEducationActive(Criteria criteria, Page page);
	
	/**
	 * 获取健康教育活动
	 * 
	 * @param criteria
	 * @return
	 */
	public HeActive getHealthEducationActive(Criteria criteria);

}