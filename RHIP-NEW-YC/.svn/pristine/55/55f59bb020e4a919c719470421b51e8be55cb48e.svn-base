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
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.ehr.entity.management.DmReportInfo;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * 慢病报卡
 * 
 * @author liuk
 * 
 */
public interface IReportCardService {

	/**
	 * 获取报卡详细
	 * 
	 * @param personId
	 * @return
	 */
	List<DmReportInfo> getReportCard(Criteria criteria);

	/**
	 * 根据ID主键查询报卡信息
	 * @param id
	 * @return DmReportInfo
	 * @auther Kevin Ro 2018-10-12
	 */
	DmReportInfo getDmReportInfo(long id);

	/**
	 * 报卡审核
	 * 
	 * @param personInfo
	 * @param reportInfos
	 * @param roleType
	 * @param user
	 */
	void approveReport(PersonInfo personInfo, List<DmReportInfo> reportInfos, RoleType roleType, User user, Organization organization, Map<String, String> linkMapGxy,
					   Map<String, String> linkMapTnb);

	/**
	 * 新增报卡保存校验是否能够上报
	 * 高血压: 不区分二级分类，只要存在就不能上报。
	 * 糖尿病: 需要区分二级分类是否重复上报
	 * 冠心病: 冠心病中只有急性心梗，超过28天可以再次上报，不算重报
	 * 脑卒中: 只要是已经上报过就不能重复上报，不需校验二级疾病
	 * 脑瘤: 不相同ICD-10疾病类型可以重复报卡
	 */
	public Map<String, Boolean> checkDuplicateReport(DmReportInfo reportInfo);

	/**
	 * 查询报卡列表,并根据人员id分组
	 * 
	 * @param page
	 * @param criteria
	 * @return
	 */
	List<DmPersonInfo> getReportsGroupByPersonId(Page page, Criteria criteria);

    /**
     * Gets reports.
     *
     * @param criteria the criteria
     * @return the reports
     */
    public List<Map<String, Object>> getDetailReportCardMapList(Criteria criteria);

    /**
	 * 查询重复报卡
	 * 
	 * @param reportInfo
	 * @return
	 */
	public PageList<DmReportInfo> getRepeatCardList(Page page, Criteria criteria, String conditions);

	/**
	 * 获取非继发的肿瘤列表
	 * @param idcard
	 * @return
	 */
	public List<DmReportInfo> getTumorReportInfos(String idcard);

	/**
	 * 报卡去重复更新
	 * @param cdmId
	 * @return
	 */
	public String updateRepeatCard(String cdmId);

	/**
	 * 报卡上报
	 * 
	 * @return boolean
	 */
	boolean saveReportCard(DmReportInfo reportInfo, RoleType roleType, User user, Organization organization,Map<String, String> linkMapGxy,
						   Map<String, String> linkMapTnb,Map<String, String> linkMapGxb,Map<String, String> linkMapNcz,Map<String, String> linkMapZl);

	/**
	 * 获取默认的分配机构
	 * @param personId
	 * @return
	 */
	Organization getAllocOrganization(Long personId);

	int getReportsCount(Criteria criteria);
}