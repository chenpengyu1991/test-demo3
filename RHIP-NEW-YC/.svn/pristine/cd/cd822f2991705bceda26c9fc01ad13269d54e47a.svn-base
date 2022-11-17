/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hsa.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.entity.hsa.SusOccDisInfo;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 可疑职业病
 * 
 * @author liuk
 * 
 */
public interface ISusOccDiservice {

	/**
	 * 删除
	 * 
	 * @param Criteria
	 * @param Organization
	 * @param User
	 * @return void
	 */
	void deleteSusOccDisInfo(Criteria criteria, Organization organization, User user);

	/**
	 * 查看
	 * 
	 * @param page
	 * @param roleType
	 * @param organization
	 * @param Criteria
	 * @return SusOccDisInfo
	 */
	PageList<SusOccDisInfo> getSusOccDisInfo(Criteria criteria, Page page, RoleType roleType, Organization organization);

	/**
	 * 查看可疑职业病患者信息
	 * 
	 * @param id
	 * @return SusOccDisInfo
	 */
	SusOccDisInfo searchSusOccDiDetialedInfo(Long id);

	/**
	 * 查看
	 * 
	 * @param criteria
	 * @return List<SusOccDisInfo>
	 */
	List<SusOccDisInfo> susOccDisInfoList(Criteria criteria);

	/**
	 * 更新
	 * 
	 * @param reportRecord
	 * @param susOccDisInfoList
	 * @param organization
	 * @param user
	 * @return
	 */
	void updateSusOccDisInfo(ReportRecord reportRecord, List<SusOccDisInfo> susOccDisInfoList, Organization organization, User user);

	/**
	 * 新增可疑职业病人
	 * 
	 * @param reportRecord
	 * @param susOccDisInfoList
	 * @param organization
	 * @param user
	 * @return
	 */

	void addSusOccDisInfo(ReportRecord reportRecord, List<SusOccDisInfo> susOccDisInfoList, Organization organization, User user);

	/**
	 * 保存
	 * 
	 * @param susOccDisInfo
	 * @param user
	 * @param organization
	 * @return boolean
	 */
	boolean saveSusOccDisInfo(SusOccDisInfo susOccDisInfo, Organization organization, User user);
}