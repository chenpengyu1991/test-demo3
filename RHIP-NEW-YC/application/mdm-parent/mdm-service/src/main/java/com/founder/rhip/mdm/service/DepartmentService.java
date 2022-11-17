/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IDepartmentDao;
import com.founder.rhip.mdm.service.IDepartmentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mdmDepartmentService")
public class DepartmentService extends MDMService implements IDepartmentService, IMergerOrganizationListener {
	
	protected static final String SEQ_DEPARTMENT = "SEQ_DEPARTMENT";
	
	@Resource(name="mdmDepartmentDao")
	private IDepartmentDao departmentDao;

	/**
	 * 查询科室
	 * @param       criteria
	 * @return      List<Department>
	 */
	public List<Department> getDepartments(Criteria criteria) {
		List<Department> departments = departmentDao.getList(criteria);
		return departments;
	}
	
	/**
	 * 查询科室
	 * @param     page
	 * @param     criteria
	 * @return      PageList<Department>
	 */
	public PageList<Department> getDepartments(Page page, Criteria criteria) {
		PageList<Department> departments = departmentDao.getPageList(page, criteria);
		return departments;
	}

	public List<Department> getDepartmentsUsingCache(Criteria criteria) {
		String key = LSIT_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<Department> retList = (List<Department>) getCache(EntityType.DEPARTMENT, key);
		if (retList == null) {
			Order order = new Order("ORGAN_CODE");
			retList = departmentDao.getList(criteria, order);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.DEPARTMENT, key, retList);
			}
		}
		return retList;
	}
	
	/**
	 * 查询科室
	 * @param criteria
	 * @return
	 */
	public Department getDepartment(String deptCode) {
		Criteria criteria = new Criteria(Department.DEPT_CODE, deptCode);
		return departmentDao.get(criteria);
	}
	
	/**
	 * 查询科室
	 * @param criteria
	 * @return
	 */
	public Department getDepartment(Long deptId) {
		return departmentDao.get(deptId);
	}
	
	/**
	 * 查询科室
	 * @param       criteria
	 * @return      Department
	 */
	public Department getDepartment(Criteria criteria) {
		return departmentDao.get(criteria);
	}
	
	/**
	 * 查询科室更新历史
	 * @param       String
	 * @return      List<Department>
	 */
	public PageList<Department> getUpdateHistory(Page page, Long deptId) {
		return departmentDao.getUpdateHistory(page, deptId);
	}

	/**
	 * 创建科室
	 * @param       String
	 * @param       List<Department>
	 * @return      Boolean
	 */
	@Transactional
	public void createDepartment(List<Department> departments) {
		departmentDao.batchInsertWithSeq(departments, SEQ_DEPARTMENT);
	}

	/**
	 * 更新科室
	 * @param       Department
	 * @return      Boolean
	 */
	@Transactional
	public void updateDepartment(List<Department> departments) {
		if (departments != null && departments.size() > 0) {
			List<Long> idList = new ArrayList<Long>();
			for (Department d : departments) {
				idList.add(d.getDeptId());
			}
			Criteria criteria = new Criteria(Department.DEPT_ID, OP.IN, idList);
			departmentDao.insertDepartmentLog(criteria);
			departmentDao.batchUpdate(departments);
		}
	}
	
	/**
	 * 删除科室
	 * @param       Department
	 * @return      Boolean
	 */
	@Transactional
	public void deleteDepartment(List<Long> departmentIds) {
		Criteria criteria = new Criteria(Department.DEPT_ID, OP.IN, departmentIds);
		departmentDao.delete(criteria);
	}

	@Override
	@Transactional
	public void createDepartment(Department department) {
		departmentDao.insertWithSeq(department, SEQ_DEPARTMENT);
	}

	@Override
	@Transactional
	public void updateDepartment(Department department) {
		Criteria criteria = new Criteria(Department.DEPT_ID, department.getDeptId());
		departmentDao.insertDepartmentLog(criteria);
		departmentDao.update(department);
	}

	@Override
	@Transactional
	public void deleteDepartment(Long departmentId) {
		departmentDao.delete(departmentId);
	}

	@Override
	@Transactional
	public void mergeStation(Organization station, List<Organization> stationList) {
		Parameters parameters = new Parameters("organCode", station.getOrganCode());
		parameters.add("organName", station.getOrganName());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : stationList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("organCode", OP.IN, codes);
		departmentDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("organCode", center.getOrganCode());
		parameters.add("organName", center.getOrganName());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("organCode", OP.IN, codes);
		departmentDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void moveStation(Organization center, List<Organization> stationList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		// TODO Auto-generated method stub

	}
}