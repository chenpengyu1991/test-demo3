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
import com.founder.rhip.ehr.dto.ChronicFollowupInfo;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.mdm.entity.Organization;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 随访记录
 * 
 * @author liuk
 * 
 */
public interface IFollowupRecordService {

	/**
	 * 保存高血压随访
	 * 
	 * @param hbp
	 * @param organization
	 * @param user
	 */
	boolean saveHbp(DmHypertensionFollowup hbp, Organization organization, User user);

	/**
	 * 获取高血压随访
	 * 
	 * @param criteria
	 * @return
	 */
	DmHypertensionFollowup getHbp(Criteria criteria);

	/**
	 * 获取糖尿病随访
	 * 
	 * @param criteria
	 * @return
	 */
	DmDiabeticFollowup getDi(Criteria criteria);

	/**
	 * 保存糖尿病随访
	 * 
	 * @param di
	 * @param organization
	 * @param user
	 */
	boolean saveDi(DmDiabeticFollowup di, Organization organization, User user);

	/**
	 * 获取肿瘤随访
	 * 
	 * @param criteria
	 * @return
	 */
	DmTumorFollowup getTumor(Criteria criteria);

	/**
	 * 保存肿瘤随访
	 * 
	 * @param tumor
	 * @param organization
	 * @param user
	 */
	Set<String> saveTumor(DmTumorFollowup tumor, Organization organization, User user);

	/**
	 * 获取脑卒中或者冠心病随访
	 * 
	 * @param criteria
	 * @return
	 */
	DmStrtumFollowup getStrtum(Criteria criteria);

	/**
	 * 计算脑卒中或者冠心病随访类型,2类3种情况:常规,和规范化,规范化分2类
	 * 
	 * @param dis
	 * @param diseaseType
	 * @param bodyLimitFlag
	 * @return
	 */
	String getFollowupType(DmDiseaseInfo dis, String diseaseType, String flag);

	/**
	 * 保存脑卒中或者冠心病随访
	 * 
	 * @param followup
	 * @param organization
	 * @param user
	 */
	boolean saveStrtum(DmStrtumFollowup followup, Organization organization, User user);

	/**
	 * 获取脑卒中和冠心病随访计划
	 * 
	 * @param plan
	 * @return
	 */
	List<DMFollowupPlan> getStrokeFollowupPlans(Criteria plan);

	/**
	 * 获取待随访总人数
	 * 
	 * @return
	 */
	Map<String, Long> getToFollowupCount(Organization organization, RoleType roleType);

	/**
	 * 计算待随访条件
	 * 
	 * @param followupFlag
	 * @return
	 */
	Criteria createToFollowupDateRange(String followupFlag);

	/**
	 * 查看个人月内是否待访,返回待访日期
	 * 
	 * @param personInfo
	 * @return
	 */
	List<ChronicFollowupInfo> queryNextFollowupInfo(PersonInfo personInfo);

	/**
	 * 检查是否是否待访
	 * 
	 * @param diseaseInfo
	 * @param followupFlag
	 * @return
	 */
	List<ChronicFollowupInfo> checkNextFollowupDate(DmDiseaseInfo diseaseInfo, String followupFlag);

	/**
	 * 计算随访日期范围
	 * 
	 * @param date
	 * @param followupFlag
	 * @return
	 */
	Criteria createToFollowupDateRange(Date date, String followupFlag);

	/**
	 * 计算下次随访日期
	 * 
	 * @param followupFlag
	 * @return
	 */
	Date getFollowupNextDateRange(String followupFlag);

	/**
	 * 新增历史随访
	 * 
	 * @param personId
	 *            disType planYear
	 * @return
	 */
	String saveHistoryFollowupData(Long personId, String disType, String planYear);

	/**
	 * 验证新增随访日期不能大于已存在计划最小日期
	 * 
	 * @param planId
	 *            personId visitDate disType
	 * @return
	 */
	String validateAddFollowupDate(Long planId, Long personId, Date visitDate, String disType);

	/**
	 * 逻辑删除管理卡,通过人员id删除所有随访和计划
	 * 
	 * @param personId
	 */
	void delFollowupAfterDelHm(Long personId);

	/**
	 * 恢复管理卡,通过人员id恢复所有随访和计划
	 *
	 * @param personId
	 */
	void renewFollowupAfterRenewlHm(Long personId);

	/**
	 * 修改指定人员的创建机构
	 * 
	 * @param personId
	 * @param oldOrganCode
	 * @param newOrganCode
	 */
	void modifyManageOrganization(Long personId, String oldOrganCode, String newOrganCode);

	/**
	 * 删除未完成的随访计划
	 * 
	 * @param personId
	 */
	void delUnDoFollowupPalnByPersonId(Long personId);

	/**
	 * 新增
	 * 
	 * @param personId
	 * @return
	 */
	DmHypertensionFollowup addHbp(Long personId);

	/**
	 * 新增
	 * 
	 * @param personId
	 * @return
	 */
	DmDiabeticFollowup addDi(Long personId);

	/**
	 * 新增
	 * 
	 * @param personId
	 * @return
	 */
	DmTumorFollowup addTumor(Long personId);

	/**
	 * 新增
	 * 
	 * @param personId
	 * @return
	 */
	DmStrtumFollowup addCoronary(Long personId);

	/**
	 * 新增
	 * 
	 * @param personId
	 * @return
	 */
	DmStrtumFollowup addStroke(Long personId);

	/**
	 * 获取随访数据
	 * 
	 * @param disType
	 * @param criteria
	 * @param organization
	 * @param roleType
	 * @return
	 */
	List<Map<String, Object>> exportDisAndFollowup(Page page, String disType, Criteria criteria, Organization organization, RoleType roleType);

	/**
	 * 获取随访计划
	 * 
	 * @param disType
	 * @param criteria
	 * @param organization
	 * @param roleType
	 * @return
	 */
	List<Map<String, Object>> exportFollowupPlan(Page page, String disType, Criteria criteria, Organization organization, RoleType roleType);

	/**
	 * 仅删除未完成的保健计划,并不更新最后一次随访日期
	 * 
	 * @param personId
	 *            the person id
	 * @param disType
	 *            the dis type
	 */
	public void delUnDoFollowupPalnByPersonIdAndDisType(Long personId, String disType);

	/**
	 * 肿瘤是否已经第一次随访
	 * 
	 * @param personId
	 *            the person id
	 * @return the boolean
	 */
	public boolean isHasTumorFirstrFollowup(Long personId);

	/**
	 * 肿瘤是否已经随访
	 *
	 * @param personId
	 *            the person id
	 * @return the boolean
	 */
	public boolean isHasTumorFollowup(Long personId);

	/**
	 * 肿瘤是否已经最后一次随访
	 * 
	 * @param personId
	 *            the person id
	 * @return the boolean
	 */
	public boolean isHasEndTumorFollowup(Long personId);

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> getNumGroupByVisitWayCode(Criteria criteria);

	/**
	 * 随访统计
	 * @param page
	 * @param form
	 * @return
	 */
	public PageList<Map<String, Object>> getFollowupStatistics(Page page, ReportQueryForm form, Organization currentOrg);

	/**
	 * 导出随访统计
	 * @param page
	 * @param form
	 * @return
	 */
	public List<Map<String, Object>> exportFollowupStatistics(Page page, ReportQueryForm form, Organization currentOrg);


	/**
	 * 删除指定慢病类型的慢病随访计划（逻辑删除）
	 * @param personId
	 * @param disTypes
	 */
	public void delFollowupPlanByPersonIdAndDisType(Long personId, List<String> disTypes);

	/**
	 * 恢复已删除的指定慢病类型的慢病随访计划
	 * @param personId
	 * @param disTypes
	 */
	public void renewFollowupPlanByPersonIdAndDisType(Long personId, List<String> disTypes);


	public List<Map<String, Object>> exportPersonFollowup(Page page, Criteria criteria, QueryForm form);

	List<DmHypertensionFollowup> getHbpList(Criteria criteria, Order order);

	List<DmDiabeticFollowup> getDiList(Criteria criteria, Order order);


	}
