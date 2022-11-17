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
import com.founder.rhip.ehr.entity.healtheducation.HePrescription;

/**
 * 健康教育处方服务接口,包含了对健康教育处方的创建、修改、删除、查询等操作
 * 
 * @author GaoFei
 * 
 */
public interface IHePrescriptionService {

	/**
	 * 添加健康教育处方
	 * 
	 * @param healthPrescription 健康教育处方对象
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int createHealthPrescription(HePrescription healthPrescription);

	/**
	 * 修改健康教育处方
	 * 
	 * @param healthPrescription 健康教育处方对象
	 * @param properties 需要更新的属性
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int updateHealthPrescription(HePrescription healthPrescription, String... properties);

	/**
	 * 删除健康教育处方
	 * 
	 * @param ids 健康教育处方主键集合
	 * @return 成功或者失败标志1->成功，0->失败
	 */
	public int deleteHealthPrescription(Long... ids);

	/**
	 * 分页显示健康教育处方
	 * 
	 * @param criteria 查询条件
	 * @param page 页面对象
	 * @return PageList<HealthPrescription>
	 */
	public PageList<HePrescription> findHealthPrescription(Criteria criteria, Page page);
	
	/**
	 * 获取健康教育处方详情
	 * 
	 * @param criteria
	 * @return
	 */
	public HePrescription getHealthPrescription(Criteria criteria);

	/**
	 * 更新是否发布的状态
	 *
	 * @param parameters
	 * @param criteria
	 * @return
	 */
	public int updateStatus(Parameters parameters, Criteria criteria);

}