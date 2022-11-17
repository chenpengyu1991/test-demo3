/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.management.mhm.MhmApprovalInfo;

public interface IMhmApprovalInfoService {

	/**
	 * 添加
	 * @param       approvalInfo
	 * @return      int
	 */
	public int createApprovalInfo(MhmApprovalInfo approvalInfo);

	/**
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<MhmApprovalInfo>
	 */
	public PageList<MhmApprovalInfo> findApprovalInfo(Criteria criteria, Page page);

}