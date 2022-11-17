/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.management.DmHighriskPersonInfo;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonInfo;

import java.util.List;

/**
 * 潜在人群
 * 
 * @author liuk
 * 
 */
public interface ICdPreventService {

	/**
	 * 潜在患者人群查询
	 * 
	 * @param Criteria
	 * @return List
	 */
	List<DmPotentialPersonInfo> getCdPreventList(Criteria criteria);

	/**
	 * 获取潜在患者明细
	 * 
	 * @param criteria
	 * @return
	 */
	DmPotentialPersonInfo getPerson(Criteria criteria);

	/**
	 * 纳入管理
	 * 
	 * @param type
	 *            根据type类型分配纳入到对应的慢病中管理
	 * @param personInfo
	 * @return
	 */
	boolean cooptationManage(DmHighriskPersonInfo personInfo);

	/**
	 * 纳入管理
	 * 
	 * @param type
	 *            根据type类型分配纳入到对应的慢病中管理
	 * @param personInfo
	 * @return
	 */
	void insertPotentialPersonAndParam();

}