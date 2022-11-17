package com.founder.rhip.ism.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ism.ApprovalInfo;
import com.founder.rhip.ehr.entity.ism.ReportInfo;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;

/**
 * 伤害监测报卡
 * @author liuk
 */
public interface IReportCardService {

    /**
     * Save report card.
     *
     * @param reportInfo the report info
     * @param roleType the role type
     * @param user the user
     * @param organization the organization
     * @return the boolean
     */
    boolean saveReportCard(ReportInfo reportInfo, RoleType roleType, User user, Organization organization);

    /**
     * App report card.
     *
     * @param reportInfo the report info
     * @param roleType the role type
     * @param user the user
     * @param organization the organization
     * @param flag the flag
     * @param approvalInfo the approval info
     * @return the string
     */
    String appReportCard(ReportInfo reportInfo, RoleType roleType, User user, Organization organization, int flag, ApprovalInfo approvalInfo);

    /**
     * 查询报卡列表
     *
     * @param page the page
     * @param criteria the criteria
     * @return reports info
     */
	PageList<ReportInfo> getReportsInfo(Page page, Criteria criteria);

    /**
     * 查询重复报卡
     *
     * @param page the page
     * @param criteria the criteria
     * @param conditions the conditions
     * @return repeat card list
     */
	public PageList<ReportInfo> getRepeatCardList(Page page, Criteria criteria, String conditions);

    /**
     * Gets app details list.
     *
     * @param criteria the criteria
     * @return the app details list
     */
    List<ApprovalInfo> getAppDetailsList(Criteria criteria);

    /**
     * Delete report.
     *
     * @param id the id
     */
    void deleteReport(Long id);
	
}
