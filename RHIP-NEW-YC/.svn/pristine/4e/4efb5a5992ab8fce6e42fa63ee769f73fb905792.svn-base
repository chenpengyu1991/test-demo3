/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.dto.ManagementDto;

import java.util.List;

/*
 * 精神卫生-规范管理SERVICE 
 */

public interface IMhmManagementService {
	/**
	 * 分页查询-规范管理
	 * @param       criteria
	 * @param       page
	 * @return      PageList<MhmManagementQueryDto>
	 */
	public PageList<MhmManagementQueryDto> findManagementList(Criteria criteria, Page page);
	
    /**
     * 查询-规范管理
     * @param       criteria
     * @return      List<MhmManagementQueryDto>
     */
    public List<MhmManagementQueryDto> findManagementList(Criteria criteria);	

    
    /**
     * 规范管理业务数据获取
     * @param       statusId
     * @param		event
     * @return      ManagementDto
     */
    public ManagementDto getMhmManagement(Long statusId,MhmEvents event);

    /**
     * 查询出院列表
     * @param		criteria
     * @return      PageList<MhmFollowup>
     */
    public PageList<MhmInhospital> getDisChargeList(Criteria criteria,Page page);
 
    /**
     * 查询随访列表
     * @param		statusId
     * @return      PageList<MhmFollowup>
     */
    public PageList<MhmFollowup> getFollowupList(Long statusId,Page page);

    /**
     * 查询最近一次随访
     */
    public MhmFollowup getLastFollowup(Long statusId);
    
    /**
     * 查询个案计划列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmCase>
     */
    public PageList<MhmCase> getCasePlanList(Criteria criteria,Page page);
    
    /**
     * 获取个案计划详情
     * @param criteria
     * @return
     */
    public MhmCase getCasePlan(Criteria criteria);
    
    /**
     * 查询效果评估列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmAssess>
     */
    public PageList<MhmAssess> getAssessList(Criteria criteria,Page page);  
    
    /**
     * 查询应急处置列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmEmergency>
     */
    public PageList<MhmEmergency> getMhmEmergencyList(Criteria criteria,Page page);

    /**
     * 查询健康体检列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmPhysicalExamination>
     */
    public PageList<MhmPhysicalExamination> getMhmHealthCheckList(Criteria criteria,Page page);

    /**
     * 规范管理业务数据获取:同一个事件存在多条数据
     * @param       statusId
     * @param       eventId
     * @param		event
     * @return      ManagementDto
     */
    public ManagementDto getMulManagement(Long statusId,Long eventId,MhmEvents event); 
    /**
     * 规范管理业务数据保存
     * @param       mngDto
     * @param       event
     * @return      boolean
     */
    public boolean saveMhmManagement(ManagementDto mngDto,MhmEvents event, Integer status);
    /**
     * 规范管理业务数据删除
     * @param       eventId
     * @return      boolean
     */
    public boolean deleteMul(Long eventId);

    /**
     * 逻辑删除规范化管理主表数据
     */
    public boolean delManageMentData(Long statusId,String pixId,String idcard);

    public boolean deleteHealthCheck(Long eventId);
    /**
     * 审批随访记录
     * @param       id
     * @return      status
     */
    public boolean approvalFollowup(Long id,String status);
    /**
     * 查询免费服药明细列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmDrugFree>
     */
    public PageList<MhmDrugFree> getDrugFreeList(Criteria criteria,Page page, Order order);

    /**
     * 查询管理变更明细列表
     *
     * @param       criteria
     * @param        page
     * @return      PageList<MhmManageType>
     */
    public PageList<MhmManageType> getManageTypeList(Criteria criteria, Page page, Order order);

    /**
     * 查询病人类型变更列表
     *
     * @param       criteria
     * @param        page
     * @return      PageList<MhmSeverity>
     */
    public PageList<MhmSeverity> getPatientTypeList(Criteria criteria, Page page, Order order);

    /**
     * 查询经济状况变更明细列表
     *
     * @param       criteria
     * @param        page
     * @return      PageList<MhmEconomy>
     */
    public PageList<MhmEconomy> getEconomyHistory(Criteria criteria, Page page, Order order);

    
    /**
     * 查询病人首次变更记录
     *
     * @param       statusId
     * @return      MhmSeverity
     */
    public MhmSeverity getFirstPatientType(Long statusId);

    
    /**
     * 获取应急处置详情
     * @param criteria
     * @return
     */
    public MhmEmergency getEmergency(Criteria criteria);

    /**
     * 获取健康体检详情
     * @param criteria
     * @return
     */
    public MhmPhysicalExamination getHealthCheck(Criteria criteria);
    
    /**
     * 获取效果评估详情
     * @param criteria
     * @return
     */
    public MhmAssess getEvaluation(Criteria criteria);

	/**
	 * 获取患者ID
	 * @param statusId
	 * @return 患者ID
	 */
	public Long getPersonId(Long statusId);

    /**
     * 根据idCard获取患者基本信息
     * @param idCard
     * @return
     */
    public MhmBasicsInfo findBasicInfoByIdCard(String idCard);
}