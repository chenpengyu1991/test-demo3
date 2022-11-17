/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.BrwAnonymousSet;
import com.founder.rhip.ehr.repository.clinic.IBrwAnonymousSetDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *健康档案浏览器角色配置
 * @author role
 *
 */
@Service("brwAnonymousSetService")
public class BrwAnonymousSetServiceImpl extends AbstractService implements IBrwAnonymousSetService {

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IBrwAnonymousSetDao brwAnonymousSetDao;

	public List<BrwAnonymousSet> getBrwAnonymousSets(Criteria criteria){
		return brwAnonymousSetDao.getList(criteria);
	}

	@Override
	public void save(BrwAnonymousSet brwAnonymousSet){
		brwAnonymousSetDao.insert(brwAnonymousSet);
	}

	@Transactional
	public void saveBath(HttpServletRequest request, String roleNames){
		Criteria criteria = new Criteria();
		brwAnonymousSetDao.delete(criteria);
		if(null != roleNames && !roleNames.isEmpty()) {
			List<BrwAnonymousSet> brwAnonymousSets = new ArrayList<BrwAnonymousSet>();
			String[] roleNameList = roleNames.split(",");
			Organization organization = SecurityUtils.getCurrentOrganization(request);
			User user = SecurityUtils.getCurrentUser(request);
			for (int i = 0; i < roleNameList.length; i++) {
				BrwAnonymousSet brwAnonymousSet = new BrwAnonymousSet();
				brwAnonymousSet.setOrgType(organization.getGenreCode());
				brwAnonymousSet.setGbcode(organization.getGbCode());
				brwAnonymousSet.setSupOrganCode(organization.getParentCode());
				brwAnonymousSet.setOrganCode(organization.getOrganCode());
				brwAnonymousSet.setOrganName(organization.getOrganName());
				brwAnonymousSet.setRoleType(roleNameList[i]);
				brwAnonymousSet.setCreateUserCode(user.getUserName());
				brwAnonymousSet.setCreateUserName(user.getName());
				brwAnonymousSet.setCreateDate(new Date());
				brwAnonymousSets.add(brwAnonymousSet);
			}
			brwAnonymousSetDao.batchInsert(brwAnonymousSets);
		}
	}

	public void delete(BrwAnonymousSet brwAnonymousSet){
		brwAnonymousSetDao.delete(new Criteria("id", brwAnonymousSet.getId()));
	}
}
