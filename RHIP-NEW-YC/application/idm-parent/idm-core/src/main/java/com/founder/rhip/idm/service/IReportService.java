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
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.idm.dto.ReportDto;

import java.util.List;
import java.util.Map;

public interface IReportService {

	/**
	 * 添加
	 * @param       ReportDto
	 */
    public boolean createReport(ReportDto reportDto, RoleType roleType, User user, long reportRecordId);

	/**
	 * 删除
	 * @param       idmId
	 * @param       user
	 * @return      int
	 */
	public int deleteReport(String idmId, User user);

	public Object valueFindCode(Criteria criteria, String dicmeta);

	/**
	 * 批量删除
	 * @param       user
     * @param       idmIds
	 * @return      int
	 */
	public int deleteReport(User user, String... idmIds);

	/**
	 * 分页
	 * @param       criteria
	 * @param       page
	 * @return      PageList<DcInfectionDiseaseReport>
	 */
	public PageList<IdmReport> findReport(Criteria criteria, Page page);
	public List<IdmReport> findReport(Criteria criteria);
	/**
	 * 分页
	 * @param       criteria
	 * @param       page
	 * @return      PageList<DcInfectionDiseaseReport>
	 */

	public PageList<IdmReport> getReportLists(Page page, Criteria criteria);
	public List<IdmReport> getReportLists(Criteria criteria);

	public IdmReport getReport(Criteria criteria);
    /**
     * 分页
     * @param       criteria
     * @param       page
     * @return      PageList<IdmReport>
     */
    public PageList<IdmReport> getFrList(Criteria criteria, Page page);

	/**
	 * 查看
	 * @param       id
	 * @return      DcInfectionDiseaseReport
	 */
	public ReportDto getReport(Integer id);

	/**
	 * 审批
	 * @param       reportDto
	 * @param       user
	 * @return      boolean
	 */
	public boolean approveReport(ReportDto reportDto, User user) throws Exception;

	/**
	 * 分配
	 * @param       generalCondition
	 * @param       statusinfo
	 * @param       caseInformation
	 * @return      int
	 */
	public int assignReport(String idmId, GeneralCondition generalCondition, IdmStatusInfo statusinfo, CaseInformation caseInformation);

	public List<IdmReport> findReportTable(Criteria ca);
	
	/**
	 * 个案查重
	 * @param       criteria
	 * @param       page
	 * @param       conditions
	 * @return      PageList<IdmReport>
	 */
	public PageList<IdmReport> getRepeatCasesList(Criteria criteria, Page page, String conditions);
	public void createUplodReport(ReportDto reportDto);
	
	/**
	 * 上报传染病统计
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> getDiseaseStatisticList(Criteria criteria);

}