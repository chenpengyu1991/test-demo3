/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hsa.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.InspectionRecord;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.mdm.entity.Organization;

/**
 * * 日常巡查和家庭巡查
 * 
 * @author liuk
 * 
 */
public interface IInspRecordService {

	/**
	 * 添加
	 * @param linkMap 
	 * 
	 * @param InspectionRecord
	 * @param Organization
	 * @param User
	 * @return void
	 */
	void addRecord(InspectionRecord inspectionRecord, Organization organization, User user, RoleType role, Map<String, Map<String, String>> linkMap);

	/**
	 * 修改
	 * 
	 * @param InspectionRecord
	 * @param Organization
	 * @param User
	 * @return void
	 */
	public void updateRecord(InspectionRecord inspectionRecord, Organization organization, User user);


	/**
	 * 获取记录,分页
	 * 
	 * @param page
	 * @param criteria
	 * @param roleType
	 * @param organization
	 * @return
	 */
	public PageList<InspectionRecord> getPageInspectionRecordList(Page page, Criteria criteria, RoleType roleType, Organization organization);

	/**
	 * 编辑记录,获取记录全部信息
	 * 
	 * @param criteria
	 * @return
	 */
	public InspectionRecord getRecordForUpdate(Criteria criteria);

	/**
	 * 获取记录列表
	 * 
	 * @param criteria
	 * @return
	 */
	public List<InspectionRecord> getRecordList(Criteria criteria);

	/**
	 * 家庭列表
	 * 
	 * @param page
	 * @param criteria
	 * @param organization
	 * @param roleType
	 * @return
	 */
	List<InspectionRecord> getFamilyRecordList(Page page, Criteria criteria, Organization organization, RoleType roleType);

	/**
	 * 获取家庭巡查记录
	 * 
	 * @param id
	 * @return
	 */
	InspectionRecord getFamilyRecord(Long id);

	/**
	 * 保存家庭巡查记录
	 * 
	 * @param inspectionRecord
	 * @param organization
	 * @param user
	 * @param roleType
	 */
	void saveFamilyRecord(InspectionRecord inspectionRecord, Organization organization, User user, RoleType roleType);

	/**
	 * 获取日常巡查分页列表
	 * 
	 * @param page
	 * @param criteria
	 * @param roleType
	 * @param organization
	 * @return
	 */
	PageList<InspectionRecord> getPagedLocationRecordList(Page page, Criteria criteria, RoleType roleType, Organization organization);

	/**
	 * 获取巡查地点信息
	 * @param inspId
	 * @return
	 */
	LocationInfo getInspLocationByInspId(Long inspId);

}