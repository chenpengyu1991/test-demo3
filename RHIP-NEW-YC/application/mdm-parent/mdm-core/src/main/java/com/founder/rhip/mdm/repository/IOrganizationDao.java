/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.rhip.mdm.repository;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Organization;

public interface IOrganizationDao extends IDao<Organization, Long> {
	
	public void insertOrganizationLog(Criteria criteria);
	
	public Organization getLog(Criteria criteria);

	public PageList<Organization> getUpdateHistory(Page page, Long organId, String... properties);
	
	/**
	 * 根据GBCODE获取机构实体
	 * @param organCode
	 * @return
	 */
	public Organization getGbcodeByOrganization(String organCode);
	
	/**
	 * 根据ORGANCODE查询机构
	 * @param organCode
	 * @return
	 */
	public List<Organization> getOrganizationList(String organCode);
	
	/**
	 * 查询所有机构不包含中心（站）
	 * @return      List<Organization>
	 */
	public PageList<Organization> getOrganizationsNoVirtual(Page page, Criteria criteria);

	/**
	 * Organization
	 * @param villageCode
	 * @return
	 */
	public Organization queryOrganByVillage(String villageCode);
	
	/**
	 * 根据镇一级机构代码汇总所有设备资源
	 * @param gbCode
	 * @return
	 */
	public List<Map<String, Object>> sumEquipmentByTown(String gbCode);
	
	/**
	 * 根据除镇一级机构代码汇总所有设备资源
	 * @param gbCode
	 * @return
	 */
	public List<Map<String, Object>> sumEquipment(String orgType, String gbCode, String organCode, String parentCode);

	public List<Organization> getOrgansRecursion(String organCode);

	/**
	 * 获取机构表中最大的sort为了给新建机构的sort赋值
	 * @return
	 */
	public Integer getMaxSort(Criteria criteria);

	/**
	 * 汇总全市设备资源、床位资源
	 * @return
	 */
	public Map<String,Object>  getEquipmentData();

	/**
	 * 汇总全市设备资源、床位资源(按医院分组：中心、市级医院)
	 * @param ca
	 * @return
	 */
	public List<Map<String,Object>>  getHospitalEquipmentData(Criteria ca);
}
