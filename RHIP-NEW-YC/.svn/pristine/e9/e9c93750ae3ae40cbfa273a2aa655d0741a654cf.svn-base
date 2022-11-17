/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmApprovalInfo;

import java.util.List;

public interface IApprovalService {

	/**
	 * 添加
	 * @param       ApprovalInfo
	 * @return      int
	 */
	public int createApprovalInfo(IdmApprovalInfo approvalInfo);

	/**
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<ApprovalInfo>
	 */
	public PageList<IdmApprovalInfo> findApprovalInfo(Criteria criteria, Page page);

	/**
	 * 列表
	 * @param       Criteria
	 * @return      List<ApprovalInfo>
	 */
	public List<IdmApprovalInfo> findApprovalInfo(Criteria criteria);

	/**
	 * 查看
	 * @param       String
	 * @return      ApprovalInfo
	 */
	public IdmApprovalInfo getApprovalInfo(String idmId);

}