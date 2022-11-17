/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.Department;

import java.util.List;

public interface IDepartmentService {
	
	/**
	 * 查询科室
	 * @param       String
	 * @return      List<Department>
	 */
	public List<Department> getDepartments(Criteria criteria);
	
	/**
	 * 查询科室
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Department> getDepartments(Page page, Criteria criteria);

	/**
	 * 用缓存查询科室
	 * @param criteria
	 * @return
	 */
	public List<Department> getDepartmentsUsingCache(Criteria criteria);
	
	/**
	 * 查询科室
	 * @param criteria
	 * @return
	 */
	public Department getDepartment(Criteria criteria);
	
	/**
	 * 查询科室
	 * @param criteria
	 * @return
	 */
	public Department getDepartment(String deptCode);
	
	/**
	 * 查询科室
	 * @param criteria
	 * @return
	 */
	public Department getDepartment(Long deptId);
	
	/**
	 * 查询科室更新历史
	 * @param       String
	 * @return      List<Department>
	 */
	public PageList<Department> getUpdateHistory(Page page, Long deptId);

	/**
	 * 创建科室
	 * @param       String
	 * @param       List<Department>
	 * @return      Boolean
	 */
	public void createDepartment(List<Department> departments);
	
	/**
	 * 创建科室
	 * @param department
	 */
	public void createDepartment(Department department);

	/**
	 * 更新科室
	 * @param       Department
	 * @return      Boolean
	 */
	public void updateDepartment(List<Department> departments);
	
	/**
	 * 更新科室
	 * @param department
	 */
	public void updateDepartment(Department department);
	
	/**
	 * 删除科室
	 * @param       Department
	 * @return      Boolean
	 */
	public void deleteDepartment(List<Long> departmentIds);
	
	/**
	 * 删除科室
	 * @param departmentId
	 */
	public void deleteDepartment(Long departmentId);

}