/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.dto.ToBringIntoDiseaseInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.ehr.entity.management.DmYiShare;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 管理卡和随访计划
 *
 * @author liuk
 */
public interface IStandardizationService {

    /**
     *  一体机检查记录查看
     * @param page
     * @param criteria
     * @return
     */
    PageList<DmYiShare> searchYshareList(Page page, Criteria criteria);

    /**
     * 健康管理卡查看
     *
     * @param page the page
     * @param criteria the criteria
     * @param organization the organization
     * @param roleType the role type
     * @return List hm card list
     */
	PageList<DmDiseaseInfo> getHmCardList(Page page, Criteria criteria, Organization organization, RoleType roleType);


    /**
     * Gets manage card with followup count list.
     * @param page
     * @param criteria
     * @param form
     * @return
     */
    PageList<DmDiseaseInfo> getManageCardWithFollowupCountList(Page page, Criteria criteria, QueryForm form);


    /**
     * 健康管理卡详细信息查看
     *
     * @param criteria the criteria
     * @return Entity hm card
     */
	public DmDiseaseInfo getHmCard(Criteria criteria);

    /**
     * 健康管理卡修改
     *
     * @param diseaseInfo the disease info
     * @return boolean boolean
     */
	boolean saveHmCard(DmDiseaseInfo diseaseInfo, Map<String, String> fileMapGxy, Map<String, String> fileMapTnb, String createrName);

    /**
     * 肿瘤基本信息修改
     *
     * @param diseaseInfo the disease info
     * @return boolean boolean
     */
    boolean saveTumorPersonInfo(DmDiseaseInfo diseaseInfo);

    /**
     * 查询个人基本信息
     *
     * @param criteria the criteria
     * @return dm person info list
     */
	public List<DmPersonInfo> getDmPersonInfoList(Criteria criteria);

    /**
     * 报卡纳入检查重复
     *
     * @param personId the person id
     * @param manageOrgCode the manage org code
     * @return set
     */
	Set<String> checkReport(Long personId, String manageOrgCode);

    /**
     * 报卡信息复制到管理卡
     *
     * @param personId the person id
     * @param organization the organization
     * @return dm disease info
     */
	DmDiseaseInfo convertReportToDiseaseInfo(Long personId, Organization organization);

    /**
     * 纳入到管理卡
     *
     * @param diseaseInfo the disease info
     * @return set
     */
	Set<String> bringIntoManage(DmDiseaseInfo diseaseInfo,String hbpReportId,String diReportId,Map<String,String> linkMapGxy,Map<String,String> linkMapTnb,Map<String,String> managedOrgMap);


    /**
     * 查询管理卡信息
     *
     * @param personId the person id
     * @return dm disease info
     */
	DmDiseaseInfo queryDmDiseaseInfo(Long personId);

    /**
     * 手动新增管理卡
     *
     * @param diseaseInfo the disease info
     * @return set
     */
	Set<String> addManage(DmDiseaseInfo diseaseInfo, Map<String, String> fileMapGxy, Map<String, String> fileMapTnb, String createrName,Map<String, String> managedOrgMap);

    /**
     * 获取带建档信息
     *
     * @param psersonId the pserson id
     * @param orgCode the org code
     * @return to bring into disease infos
     */
	List<ToBringIntoDiseaseInfo> getToBringIntoDiseaseInfos(Long psersonId, String orgCode);

    /**
     * 检查该人员是否可以被管理
     *
     * @param organCode
     *            the disease info
     * @param personByIdcard
     *            the person by idcard
     * @return set
     */
    public Set<String> checkToManagedPerson(String organCode, PersonInfo personByIdcard,Map<String, String> managedOrgMap) ;


    /**
     * 撤销管理
     *
     * @param personId the person id
     */
	void cancelManage(Long personId);

	/**
     * 修改创建机构
     *
     * @param personId the person id
     * @param oldOrganCode the old organ code
     * @param newOrganCode the new organ code
     */
	void modifyManageOrganization(Long personId, String oldOrganCode, String newOrganCode);

    /**
     * 恢复管理
     *
     * @param personId the person id
     */
	void recoveryManage(Long personId);

    /**
     * 查询默认患病情况
     * @param personInfo
     * @return boolean [ ]
     */
	boolean[] getPersonDmManagedFlag(PersonInfo personInfo);

    /**
     * 管理卡的导出功能
     * @param page
     * @param criteria
     * @param organization
     * @param roleType
     * @return
     */
    List<Map<String, Object>> exportManageCard(Page page, Criteria criteria, Organization organization, RoleType roleType);

    /**
     * 健康管理卡导出
     *
     * @param page the page
     * @param criteria the criteria
     * @param organization the organization
     * @param roleType the role type
     * @return List hm card list
     */
    List<Map<String, Object>> exportHmCardList(Page page, Criteria criteria, Organization organization, RoleType roleType);

    /**
     * 统计五种慢病已管理的数量
     * @param criteria
     * @param organization
     * @param roleType
     * @return
     */
    public Map<String, Object> getMangerNum(Criteria criteria, Organization organization, RoleType roleType);

    /**
     *  统计不同时间段每种慢病的纳入管理的情况
     * @param dateType
     * @return
     */
    public Map<String, Object> getBringNum(int dateType, Organization organization, RoleType roleType);

    /**
     * 慢病纳入统计
     * @param page
     * @param form
     * @return
     */
    public PageList<Map<String, Object>> getMangerIntoStatistics(Page page, ReportQueryForm form, Organization currentOrg);

    /**
	 * 导出纳入统计
	 * @param page
	 * @param form
	 * @return
     */
    public List<Map<String, Object>> exportMangerIntoStatistics(Page page, ReportQueryForm form, Organization currentOrg);

    /**
     * 获取高血压糖尿病规范化管理人数
     * @return
     */
    public List<Map<String, Object>> getHbpDiManagerMaps(String year);

    /**
     * 根据Id和疾病类型删除相应的管理卡
     * @param dmDiseaseInfo
     * @param organization
     * @param user
     */
    void deleteHmCardBySelectedType(DmDiseaseInfo dmDiseaseInfo, Organization organization, User user);

    /**
     * 根据Id和疾病类型恢复相应的管理卡
     * @param dmDiseaseInfo
     * @param organization
     * @param user
     */
    public void renewHmCardBySelectedType(DmDiseaseInfo dmDiseaseInfo, Organization organization, User user);

}