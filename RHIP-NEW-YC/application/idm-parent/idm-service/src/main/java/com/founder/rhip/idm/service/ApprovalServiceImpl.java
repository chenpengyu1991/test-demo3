/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmApprovalInfo;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmApprovalInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("approvalService")
public class ApprovalServiceImpl extends AbstractService implements IApprovalService {

	@Resource(name = "idmApprovalInfoDao")
	private IIdmApprovalInfoDao idmApprovalInfoDao;

	/**
	 * 添加
	 * @param       IdmApprovalInfo
	 * @return      int
	 */
	public int createApprovalInfo(IdmApprovalInfo approvalInfo) {
		return idmApprovalInfoDao.insert(approvalInfo);
	}

	/**
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<ApprovalInfo>
	 */
	public PageList<IdmApprovalInfo> findApprovalInfo(Criteria criteria, Page page) {
		return idmApprovalInfoDao.getPageList(page, criteria,new Order("APPROVAL_DATE"));
	}

	/**
	 * 列表
	 * @param       Criteria
	 * @return      List<ApprovalInfo>
	 */
	public List<IdmApprovalInfo> findApprovalInfo(Criteria criteria) {
		List<IdmApprovalInfo> result = idmApprovalInfoDao.getList(criteria);
		return result;
	}

	/**
	 * 查看
	 * @param       String
	 * @return      ApprovalInfo
	 */
	public IdmApprovalInfo getApprovalInfo(String idmId) {
		IdmApprovalInfo result = null;
		//TODO
		return result;
	}

}