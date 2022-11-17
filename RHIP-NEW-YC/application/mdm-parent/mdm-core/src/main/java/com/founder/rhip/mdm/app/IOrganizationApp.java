package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;

public interface IOrganizationApp {
	
	/**
	 * 注册机构
	 * @param organization
	 * @return
	 */
	public String registOrganization(Organization organization) throws CheckException;
	
	/**
	 * 查询所有的机构
	 * @param criteria
	 * @return
	 */
	public List<Organization> queryAllOrganization();
	
	/**
	 * 查询所有的机构
	 * @param criteria
	 * @return
	 */
	public Map<String, String> queryAllOrganizationMap();
	
	/**
	 * 查询机构
	 * @param criteria
	 * @return
	 */
	public List<Organization> queryOrganization(Criteria criteria);
	
	/**
	 * 注册科室
	 * @param department
	 * @return
	 */
	public String registDepartment(Department department) throws CheckException;
	
	/**
	 * 查询科室
	 * @param criteria
	 * @return
	 */
	public List<Department> queryDepartment(Criteria criteria);

	/**
	 * 根据机构id 获取
	 * @param organizationId
	 * @return
	 */
	public Organization queryOrganization(long organizationId);
	
	/**
	 * 根据机构Code获取
	 * @param orgCode
	 * @return
	 */
	public Organization queryOrgan(String orgCode);
	
	/**
	 * 根据机构Code获取机构名称
	 * @param orgCode
	 * @return
	 */
	public String queryOrganName(String orgCode);
	
	/**
	 * 根据村code获取机构
	 * @param villageCode
	 * @return
	 */
	public Organization queryOrganByVillage(String villageCode);

	/**
	 * 查询机构 排序
	 * @param criteria
	 * @return
	 */
	public List<Organization> queryOrganization(Criteria criteria, Order order);
}
