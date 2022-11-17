/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.mdm.entity.Organization;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 高危人群
 * 
 * @author liuk
 * 
 */
public interface IHighRiskService {
	/**
	 * 获取高人群列表
	 * 
	 * @param criteria
	 *            page
	 * @param roleType
	 * @param organization
	 * @return
	 */
	PageList<DmHighriskPersonInfo> getPersonList(Page page, Criteria criteria, Organization organization, RoleType roleType);

	/**
	 * 获取高危人员
	 * 
	 * @param criteria
	 * @return
	 */
	DmHighriskPersonInfo getPerson(Criteria criteria);

	/**
	 * 获取随访记录列表
	 * 
	 * @param Criteria
	 * @return List
	 */
	List<DmHighriskFollowup> getFollowupPlanList(Criteria criteria);

	/**
	 * 随访计划详细信息查看
	 * 
	 * @param Criteria
	 * @return Entity
	 */
	DmHighriskFollowup getFollowup(Criteria criteria);

	/**
	 * 危险因素信息查看
	 * 
	 * @param Criteria
	 * @return Entity
	 */
	DmHighriskRiskFactors getRiskFactorsInfo(Criteria criteria);

	/**
	 * 随访计划保存
	 * 
	 * @return boolean
	 */
	String saveFollowupPlan(DmHighriskFollowup dmHighriskFollowup);

	/**
	 * 获取管理计划列表
	 * 
	 * @param criteria
	 * @return List<DmHighriskManagePlan>
	 */
	List<DmHighriskManagePlan> getManagePalnList(Criteria criteria);

	/**
	 * 获取管理计划
	 * 
	 * @param criteria
	 * @return
	 */
	DmHighriskManagePlan getManagePlan(Criteria criteria);

	/**
	 * 保存管理计划
	 * 
	 * @param managePaln
	 * @return
	 */
	String saveManagePlan(DmHighriskManagePlan dmHighriskManagePlan, Criteria criteria);

	/**
	 * 保存危险因素首页信息
	 * 
	 * @param personInfo
	 * @param organization
	 * @param properties
	 * @return boolean
	 */
	boolean saveRiskFactors(DmHighriskPersonInfo personInfo, Organization organization);

	/**
	 * 删除管理计划
	 * 
	 * @param criteria
	 * @return boolean
	 */
	boolean removeManagePlan(DmHighriskManagePlan dmHighriskManagePlan, Criteria criteria);

	/**
	 * 根据状态查询已建/未建管理计划
	 * 
	 * @param dmHighriskPersonInfo
	 * @param page
	 * @param roleType
	 * @param organization
	 * @return PageList<DmHighriskPersonInfo>
	 */
	PageList<DmHighriskPersonInfo> getManagePlanPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] ageDateRange, Organization organization, RoleType roleType);

	/**
	 * 查询已建管理计划人员列表
	 * 
	 * @param dmHighriskPersonInfo
	 * @param page
	 * @param roleType
	 * @param organization
	 * @return PageList<DmHighriskPersonInfo>
	 */
	PageList<DmHighriskPersonInfo> getFollowPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] Ages, Organization organization, RoleType roleType);

	/**
	 * 删除随访计划
	 * 
	 * @param criteria
	 * @return boolean
	 */
	boolean removeFollowUpPlan(Criteria criteria);

	/**
	 * 保存随访记录
	 * 
	 * @param dmHighriskRiskFactors
	 * @param dmHighriskConclusion
	 * @return boolean
	 */
	String saveFollowupConclusion(DmHighriskRiskFactors dmHighriskRiskFactors, DmHighriskConclusion dmHighriskConclusion);

	/**
	 * 获得管理评价信息
	 * 
	 * @param Criteria
	 * @return List<DmHighriskConclusion>
	 */
	List<DmHighriskConclusion> getConclusionList(Criteria criteria);

	DmHighriskConclusion getConclusion(Criteria ca);

	/**
	 * 删除管理评论
	 * 
	 * @param criteria
	 * @return void
	 */
	void removeConclusionPlan(Criteria criteria);

	/**
	 * 删除危险因素评定
	 * 
	 * @param criteria
	 * @return void
	 */
	void removeRiskFactor(Criteria criteria);

	/**
	 * 潜在危险人群患者列表
	 * 
	 * @param criteria
	 * @param page
	 * @return PageList<DmPotentialPersonInfo>
	 */
	List<DmPotentialPersonInfo> searchPotentialPerson(Criteria criteria, Page page);

	/**
	 * 获得潜在危险人群患者信息
	 * 
	 * @param criteria
	 * @return DmPotentialPersonInfo
	 */
	DmPotentialPersonInfo getPotentialInfo(Criteria criteria);

	/**
	 * 纳入管理
	 * 
	 * @param criteria
	 * @return DmPotentialPersonInfo
	 */
	DmPotentialPersonInfo intoManage(Criteria criteria);

	/**
	 * 将潜在人群纳入到高危中
	 * 
	 * @param criteria
	 * @return DmPotentialPersonInfo personInfo
	 */
	DmHighriskPersonInfo intoHighRiskGroup(Criteria ca, PersonInfo personInfo);

	/**
	 * 保存纳入信息
	 * 
	 * @param organization
	 * @param request
	 * @param criteria
	 * @return DmPotentialPersonInfo
	 */
	String saveIntoManage(DmHighriskPersonInfo dmHighriskPersonInfo, Organization organization);

	/**
	 * 管理计划制定计划阶段下拉菜单
	 * 
	 * @param dmHighriskManagePlan
	 * @return List<String>
	 */
	List<String> selectMenuStage(DmHighriskManagePlan dmHighriskManagePlan);

	/**
	 * 随访记录制定下拉菜单
	 * 
	 * @param dmHighriskManagePlan
	 * @return List<String>
	 */
	List<String> chooseManageStage(DmHighriskFollowup dmHighriskFollowup);

	/**
	 * 管理计划制定提示信息
	 * 
	 * @param dmHighriskManagePlan
	 * @return Map<String, Integer>
	 */
	// Map<String, Integer> messageAlert(DmHighriskManagePlan
	// dmHighriskManagePlan);
	/**
	 * 加载管理计划默认值限制年份选择
	 * 
	 * @param dmHighriskManagePlan
	 * @return Map<String,Object>
	 */
	Map<String, Object> loadManageDefaultValues(DmHighriskManagePlan dmHighriskManagePlan, String currentUser);

	/**
	 * 慢病预防管理点击姓名查看个人危险因素详细信息
	 * 
	 * @param dmHighriskManagePlan
	 * @return Map<String,Object>
	 */
	DmPotentialPersonInfo searchPreventionPersonnelInfo(Long personId);

	/**
	 * 查询某患者随访记录
	 * 
	 * @param criteria
	 *            order
	 * @return DMFollList<DMFollowupPlan>
	 */
	List<DMFollowupPlan> searchDmFollowupPlan(Criteria ca, Order order);

	/**
	 * 查询某患者指定随访计划
	 * 
	 * @param criteria
	 * @return DMFollowupPlan
	 */
	DMFollowupPlan searchDmFollowupPlanInfo(Criteria criteria);

	/**
	 * 慢病预防管理纳入时检查是否已纳入、是否重新管理已结束管理患者
	 * 
	 * @param personId
	 * @return String
	 */
	String checkIntoManage(Long personId);

	Map<String, Integer> getFollowCount();

	Map<String, Object> defaultConclusionValue(DmHighriskConclusion dmHighriskConclusion, String currentUser);

	/**
	 * 结束管理
	 * 
	 * @param personId
	 * 
	 */
	void highRiskEndManage(Long personId);
	/**
	 * 恢复管理
	 * 
	 * @param personId
	 * 
	 */
	void highRiskRecoverManage(Long personId);

	/**
	 * 获取危险因素中根据筛查标准的危险因素
	 * @param criteria
	 * @return
	 */
	public List<DmPotentialPersonParam> getDmPotentialPersonParams(Criteria criteria);

}