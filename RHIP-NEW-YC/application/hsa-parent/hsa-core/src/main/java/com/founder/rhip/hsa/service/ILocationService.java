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
import java.util.Set;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.ehr.entity.hsa.PenaltyInfo;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 地点
 * @author liuk
 */
public interface ILocationService {

    /**
     * 查看
     * @param criteria the criteria
     * @return LocationInfo location info
     */
	public LocationInfo getLocationInfo(Criteria criteria);

    /**
     * 导入
     * @param list the list
     * @return void
     */
	public void importLocationInfos(List<LocationInfo> list);

    /**
     * 获取地点信息
     * @param criteria the criteria
     * @return location infos
     */
	List<LocationInfo> getLocationInfos(Criteria criteria);

    /**
     * 增加地点信息
     * @param locationInfo the location info
     * @param organization the organization
     * @param user the user
     * @return long
     */
	Long addLocationInfo(LocationInfo locationInfo, Organization organization, User user);

    /**
     * 获取地点信息 分页
     * @param page the page
     * @param criteria the criteria
     * @return paged location infos
     */
	PageList<LocationInfo> getPagedLocationInfos(Page page, Criteria criteria);


    /**
     *获取分页地点信息,包含巡查次数
     *
     * @param page the page
     * @param criteria the criteria
     * @param roleType the role type
     * @param organization the organization
     * @return the paged loc info maps add insp count
     */
    public List<Map<String, Object>> getPagedLocInfoMapsAddInspCount(Page page, Criteria criteria,RoleType roleType, Organization organization);

    /**
     * 获取分页地点信息,包含巡查次数
     * @param page the page
     * @param criteria the criteria
     * @param roleType the role type
     * @param organization the organization
     * @return paged loc infos add insp count
     */
	PageList<LocationInfo> getPagedLocInfosAddInspCount(Page page, Criteria criteria, RoleType roleType, Organization organization);

    /**
     * 更新
     * @param locationInfo the location info
     * @param organization the organization
     * @param user the user
     * @return long
     */
	Long updateLocationInfo(LocationInfo locationInfo, Organization organization, User user);

    /**
     * 检查重复
     * @param locationInfo the location info
     * @return boolean
     */
	boolean checDulLocationInfo(LocationInfo locationInfo);

    /**
     * 注销
     * @param id the id
     */
	void cancel(Long id);

    /**
     * 查看基础信息和业务信息
     * @param criteria the criteria
     * @return location with busi info
     */
	LocationInfo getLocationWithBusiInfo(Criteria criteria);

    /**
     * Gets managed area code.
     *
     * @param organCode the organ code
     * @return the managed area code
     */
    List<String> getManagedAreaCode(String organCode);

    /**
     * Gets not show bs codes.
     *
     * @return the not show bs codes
     */
    Set<String> getNotShowBsCodes();


    /**
     * Import penalty infos.
     *
     * @param list the list
     */
    void importPenaltyInfos(List<PenaltyInfo> list);

	

}