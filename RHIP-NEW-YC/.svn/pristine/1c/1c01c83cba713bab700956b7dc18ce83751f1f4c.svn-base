/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import javax.annotation.Resource;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.management.mhm.MhmApprovalInfo;
import com.founder.rhip.ehr.repository.management.mhm.IMhmApprovalInfoDao;

import org.springframework.stereotype.Service;

@Service("mhmApprovalInfoService")
public class MhmApprovalInfoServiceImpl extends AbstractService implements IMhmApprovalInfoService {

	@Resource(name = "mhmApprovalInfoDao")
	private IMhmApprovalInfoDao mhmApprovalInfoDao;

	/**
	 * 添加
	 * @param       approvalInfo
	 * @return      int
	 */
	public int createApprovalInfo(MhmApprovalInfo approvalInfo) {
		return mhmApprovalInfoDao.insert(approvalInfo);
	}

	/**
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<MhmApprovalInfo>
	 */
	public PageList<MhmApprovalInfo> findApprovalInfo(Criteria criteria, Page page) {
		return mhmApprovalInfoDao.getPageList(page, criteria,new Order("APPROVAL_DATE"));
	}
}