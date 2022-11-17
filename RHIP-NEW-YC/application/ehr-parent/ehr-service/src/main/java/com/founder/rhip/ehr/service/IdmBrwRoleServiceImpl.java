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
import com.founder.rhip.ehr.entity.clinic.IdmBrwRole;
import com.founder.rhip.ehr.repository.clinic.IIdmBrwRoleDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("idmBrwRoleService")
public class IdmBrwRoleServiceImpl extends AbstractService implements IIdmBrwRoleService {

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IIdmBrwRoleDao idmBrwRoleDao;

	public List<IdmBrwRole> getIdmBrwRoles(Criteria criteria){
		return idmBrwRoleDao.getList(criteria);
	}

	@Override
	public void save(IdmBrwRole idmBrwRole){
		idmBrwRoleDao.insert(idmBrwRole);
	}

	public void saveBath(HttpServletRequest request, String roleNames){
		Criteria criteria = new Criteria();
		idmBrwRoleDao.delete(criteria);
		if(null != roleNames && !roleNames.isEmpty()) {
			List<IdmBrwRole> idmBrwRoles = new ArrayList<IdmBrwRole>();
			String[] roleNameList = roleNames.split(",");
			Organization organization = SecurityUtils.getCurrentOrganization(request);
			User user = SecurityUtils.getCurrentUser(request);
			for (int i = 0; i < roleNameList.length; i++) {
				IdmBrwRole idmBrwRole = new IdmBrwRole();
				idmBrwRole.setOrgType(organization.getGenreCode());
				idmBrwRole.setGbcode(organization.getGbCode());
				idmBrwRole.setSupOrganCode(organization.getParentCode());
				idmBrwRole.setOrganCode(organization.getOrganCode());
				idmBrwRole.setOrganName(organization.getOrganName());
				idmBrwRole.setRoleType(roleNameList[i]);
				idmBrwRole.setCreateUserCode(user.getUserName());
				idmBrwRole.setCreateUserName(user.getName());
				idmBrwRole.setCreateDate(new Date());
				idmBrwRoles.add(idmBrwRole);
			}
			idmBrwRoleDao.batchInsert(idmBrwRoles);
		}
	}

	public void delete(IdmBrwRole idmBrwRole){
		idmBrwRoleDao.delete(new Criteria("id", idmBrwRole.getId()));
	}
}
