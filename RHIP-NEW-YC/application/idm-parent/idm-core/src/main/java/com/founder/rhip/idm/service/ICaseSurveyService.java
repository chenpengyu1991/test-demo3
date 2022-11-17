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
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.idm.dto.CaseDto;

import java.util.List;
import java.util.Map;

public interface ICaseSurveyService {

	/**
	 * 添加
	 * @param       CaseDto
	 * @param       StatusInfo
	 * @param       PersonInfo
	 * @return      int
	 */
	public boolean createCaseSurvey(CaseDto caseDto, IdmStatusInfo statusinfo, PersonInfo personInfo) throws Exception;

	/**
	 * 修改
	 * @param       CaseDto
	 * @param       StatusInfo
	 * @param       PersonInfo
	 * @return      int
	 */
	public boolean updateCaseSurvey(CaseDto caseDto, IdmStatusInfo statusinfo, PersonInfo personInfo) throws Exception;

	/**
	 * 删除
	 * @param       String
	 * @param       User
	 * @return      int
	 */
	public boolean deleteCaseSurvey(String idmId, User user);

	/**
	 * 批量删除
	 * @param       String…
	 * @param       User
	 * @return      int
	 */
	public int deleteCaseSurvey(User user, String... idmIds);

	/**
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<CaseDto>
	 */
	public PageList<CaseDto> findCaseSurvey(Criteria criteria, Page page);

	/**
	 * 查看
	 * @param       String
	 * @return      CaseDto
	 */
	public CaseDto getCaseSurvey(String idmIdStr);

    /**
     * 保存患者接触史信息
     *
     * @param caseDto
     * @return boolean
     */
    public boolean saveCaseEs(CaseDto caseDto) throws Exception;
    /**
     * 保存密切接触者信息
     *
     * @param caseDto
     * @return boolean
     */
    public boolean saveCaseEfc(CaseDto caseDto) throws Exception;
    
    /**
     * 导入数据-密接接触者-手足口病-患者接触史
     *
     * @param dataList
     * @return int
     */
	public int importEsContactDatas(List<ListEs> dataList);
    /**
     * 导入数据-密接接触者
     *
     * @param dataList
     * @return int
     */
	public int importContactedDatas(List<ListEfc> dataList);
	 /**
     * 导入数据-腹泻病人登记检索报表
     *
     * @param dataList
     * @return int
     */
	public int importAnorectaDatas(List<IdmAnorectaReportTable> dataList);
	
    /**
     * 获取密接接触者列表
     *
     * @param ca
     * @return CaseDto
     */
    public CaseDto findcontacted(Criteria ca);
    
    /**
     * 获取密接接触者列表--手足口病
     *
     * @param ca
     * @return CaseDto
     */
    public CaseDto findcontact(Criteria ca);
    
    /**
     * 分配个案
     * @param statusInfo
     * @param caseOperateLog
     * @return int
     */
    public int assignCase(CaseOperateLog caseOperateLog, IdmStatusInfo statusInfo);
    
    /**
     * 个案合格率统计
     * @return
     */
    public List<Map<String, Object>> getCaseStatisticsMapList(Map<String, String> paramMap);
    
    /**
	 * 作废个案
	 * @param idmId
	 * @return
	 */
	public int invalidCase(String idmId);
	/**
	 * 创建审核个案记录
	 * @param caseApprovalInfo	 
	 */
	public void createApprovalInfo(CaseApprovalInfo caseApprovalInfo);

	public List<Map<String, Object>> getAnorectaStatisticsList(Criteria ca);

}