/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.entity.OrganizationAreaHistory;
import com.founder.rhip.mdm.entity.OrganizationHistory;

import java.util.List;
import java.util.Map;

public interface IOrganizationService {

	/**
	 * 查询所有机构
	 */
	public PageList<Map<String, Object>> getOrganizations(Page page, Criteria criteria, String... properties);

	/**
	 * 查询所有机构
	 * @return      PageList<Organization>
	 */
	PageList<Organization> getOrganizations(Page page, Criteria criteria, Order order);

	/**
	 * 查询所有机构
	 * @return      PageList<Organization>
	 */
	PageList<Organization> getOrganizations(Page page, Criteria criteria);
	
	/**
	 * 查询所有机构
	 * @return
	 */
	public List<Organization> getOrganizations(Criteria criteria);

    public List<OrganizationHistory> getOrganizationsHistory(Criteria criteria);
	
	/**
	 * 查询所有机构,使用缓存
	 * @return
	 */
	public List<Organization> getOrganizationsUseCache(Criteria criteria);
	
	/**
	 * 查询所有机构,使用缓存
	 *
	 * @param criteria
	 * @param order
	 * @return
	 * @author Ye jianfei
	 */
	public List<Organization> getOrganizationsUseCache(Criteria criteria,Order order);
	
	/**
	 * 查询所有机构,使用缓存
	 * @return
	 */
	public Map<String, String> getOrganizationsMapUseCache(Criteria criteria);

	/**
	 * 根据机构ID查询机构
	 * @param       String
	 * @return      Organization
	 */
	public Organization getOrganization(Long organizationId);
	
	/**
	 * 根据机构CODE查询机构
	 * @param       String
	 * @return      Organization
	 */
	public Organization getOrganization(String organCode);
	
	/**
	 * 根据条件查询机构
	 * @param criteria
	 * @return
	 */
	public Organization getOrganization(Criteria criteria);

	public OrganizationHistory getOrganizationHistory2(Criteria criteria);

	/**
	 * 注册机构
	 * @param       Organization
	 * @return      String
	 */
	public void createOrganization(Organization organization, List<OrganizationArea> orgAreas);

	/**
	 * 更新机构
	 * @param       Organization
	 * @return      String
	 */
	public void updateOrganization(Organization organization, List<OrganizationArea> orgAreas, String... properties);
	
	/**
	 * 查询机构更新历史
	 */
	public Organization getOrganizationHistory(Criteria criteria);

	/**
	 * 查询机构更新历史
	 * @param       String
	 * @return      List<Organization>
	 */
	public PageList<Organization> getUpdateHistory(Page page, Long organizationId);
	
	/**
	 * 删除机构
	 * @param       Long
	 * @return      
	 */
	public void deleteOrganization(Long organizationId);
	
	/**
	 * 修改机构状态
	 * @param       Long
	 * @return      
	 */
	public void changeStatus(Organization organization);

	/**
	 * 批量导入
	 * @param organizationList
	 * @return
	 */
	int importOrganizations(List<Record> organizationList, String... properties);

	/**
	 * 获取OrganizationArea对象集合
	 * @param criteria
	 * @return
	 */
	public List<OrganizationArea> getOrganizationAreas(Criteria criteria);

    public List<OrganizationAreaHistory> getOrganizationAreasHistory(Criteria criteria);
	
	/**
	 * 保存机构与行政村的关系
	 * @param organCode
	 * @param villageCodes
	 * @return
	 */
	public Boolean saveRelation(String organCode, List<OrganizationArea> orgAreas);
	
	/**
     * 保存合并 机构
     * @param townCodes
     * @param request
     * @param model
     * @return
     */
    public String mergeOrganization(String newCode, String oldCode,Organization organization) ;
   
    /**
	 * 查询所有机构不包含中心（站）
	 * @return      List<Organization>
	 */
	public PageList<Organization> getOrganizationsNoVirtual(Page page, Criteria criteria);

	/**
	 * 根据村code获取机构
	 * @param villageCode
	 * @return
	 */
	public Organization queryOrganByVillage(String villageCode);
	
	/**
	 * 根据镇一级机构代码汇总所有设备资源
	 * @param page
	 * @param gbCode
	 * @return
	 */
	public List<Organization> sumEquipmentByTown(String gbCode);
	
	/**
	 * 根据除镇一级机构代码汇总所有设备资源
	 * @param orgType
	 * @param gbCode
	 * @param organCode
	 * @param parentCode
	 * @return
	 */
	public List<Organization> sumEquipment(String orgType, String gbCode, String organCode, String parentCode);

	public List<Organization> getOrgansRecursion(String organCode);

	/**
	 * 获取机构表中最大的sort为了给新建机构的sort赋值
	 * @return
	 */
	public Integer getMaxSort(Criteria criteria);

	/**
	 * 汇总床位资源、设备资源
	 * @return
	 */
	public Map<String, Object> getEquipmentData();

	/**
	 * 汇总医院设备资源
	 * @return
	 */
	public List<Organization> sumEquipmentByHospital(Criteria ca);
}