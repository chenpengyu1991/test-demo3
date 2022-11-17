/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.idm.SchistosomeQueryDto;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SchStatus;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.dto.SchistosomeDto;

import java.util.List;
import java.util.Map;

/*
 * 血吸虫专项SERVICE 
 */

public interface ISchistosomeService {

	/**
	 * 分页查询监测登记
	 * @param       criteria
	 * @param       page
	 * @return      PageList<MalariaDto>
	 */
	public PageList<IdmStatusInfo> findRegisterList(Criteria criteria, Page page);

	/**
	 * 血吸虫报表
	 * @param criteria
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> findJcReport(Criteria criteria);
	public List<Map<String, Object>> findJcReportCount(Criteria criteria);
    /**
     * @param       criteria
     * @return      List<SchistosomeQueryDto>
     */
    public List<SchistosomeQueryDto> findRegisterList(Criteria criteria);
    
    public boolean saveRegister(SchistosomeDto schDto, User user, Long eventId, String type);

    public SchistosomeDto getRegister(String singleId);

	/**
	 * 分页查询个案调查
	 * @param       criteria
	 * @param       page
	 * @return      PageList<MalariaDto>
	 */
	public PageList<IdmStatusInfo> findCaseList(Criteria criteria, Page page);

    /**
     * 查询个案调查
     * @param       criteria
     * @return      List<IdmStatusInfo>
     */
	public List<IdmStatusInfo> findCaseList(Criteria criteria);
    /**
     * 保存个案调查
     * @param       schDto
     * @param       user
     * @param       eventId
     * @param       type
     * @return      boolean
     */
	public boolean saveCase(SchistosomeDto schDto, User user, Long eventId, IdmType type);

	/**
     * 分页查询治疗记录
     * @param       idmId
     * @param		page
     * @return      PageList<ListRr>
     */
	public PageList<ListRr> findAcographyList(String idmId, Page page);

    /**
     * 删除治疗记录
     * @param       singleId
     * @return      boolean
     */
    public boolean deleteAcography(Long singleId);

	/**
     * 分页查询晚血病人列表
     * @param       idmId
     * @param		page
     * @return      PageList<IdmStatusInfo>
     */
	public PageList<IdmStatusInfo> findAdvancedList(Criteria criteria, Page page);

	/**
     * 查询晚血病人列表
     * @param       idmId
     * @return      List<IdmStatusInfo>
     */
	public List<IdmStatusInfo> findAdvancedList(Criteria criteria);
	/**
     * 分页查询调查记录列表
     * @param       idmId
     * @param		page
     * @return      PageList<CaseInformation>
     */
	public PageList<CaseInformation> findSurveyList(String idmId, Page page);

    /**
     * 删除治疗记录
     * @param       singleId
     * @return      boolean
     */
    public boolean deleteSurvey(Long singleId);

	/**
     * 分页查询复查登记列表
     * @param       idmId
     * @param		page
     * @return      PageList<CaseInformation>
     */
    public PageList<CaseInformation> findReexamineList(String idmId, Page page) ;

    /**
     * 删除复查登记
     * @param       singleId
     * @return      boolean
     */
    public boolean deleteReexamine(Long singleId);
    /**
     * 血吸虫病保存
     * @param       schDto
     * @param       user
     * @return      boolean
     */

	/**
     * 分页查询体检列表
     * @param       idmId
     * @param		page
     * @return      PageList<CaseInformation>
     */
	public PageList<CaseInformation> findMedicalList(String idmId, Page page);

	/**
     * 删除体检表
     * @param       singleId
     * @return      boolean
     */
    public boolean deleteMedical(Long singleId);

    public boolean save(SchistosomeDto schDto, User user, SpecialEvents event);

    /**
     * 导入血吸虫病历史记录
     * @param       schDto
     * @return      Integer
     */
    public Integer importHistory(List<SchistosomeDto> schDtos);
    /**
     * 血吸虫病业务数据获取
     * @param       schDto
     * @param       user
     * @param		multiterm
     * @return      boolean
     */
    public SchistosomeDto getBusiness(Long idmId, Long singleId, SpecialEvents event, boolean multiterm);

    /**
     * 批量审批
     * @param       singleIds
     * @param       status
     * @param       user
     * @return      boolean
     */
    public boolean batchApproval(String[] singleIds, SchStatus status, User user);
    
	/**
	 * 获取患者ID
	 * @param idmId
	 * @return 患者ID
	 */
	public Long getPersonId(Long idmId);
}