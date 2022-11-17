package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * 慢病管理卡
 *
 * @author liuk
 */
public interface IDmDiseaseInfoDao extends IDao<DmDiseaseInfo, Long> {
    /**
     * 查询健康管理卡信息列表
     *
     * @param page the page
     * @param criteria the criteria
     * @return manage card list
     */
	public PageList<DmDiseaseInfo> getManageCardList(Page page, Criteria criteria);

    /**
     * 导出慢病体检信息列表
     *
     * @param page the page
     * @param criteria the criteria
     * @return manage card list
     */
    public List<Map<String, Object>> exportManageCardList(Page page, Criteria criteria);
    /**
     * Gets manage card count.
     *
     * @param criteria the criteria
     * @return the manage card count
     */
    Long getManageCardCount(Criteria criteria, String orgCodeList);

    /**
     * Gets person id count.
     *
     * @param criteria the criteria
     * @return the person id count
     */
    Long getPersonIdCount(Criteria criteria);

    /**
     * Gets manage card with followup count list.
     * @param page
     * @param criteria
     * @param form
     * @return
     */
    PageList<DmDiseaseInfo> getManageCardWithFollowupCountList(Page page, Criteria criteria, QueryForm form);

    /**
     * 随访数据
     *
     * @param page the page
     * @param disType the dis type
     * @param criteria the criteria
     * @return list
     */
	List<Map<String, Object>> exportDisAndFollowup(Page page, String disType, Criteria criteria);

	/**
     * 随访人员
     *
     * @param page the page
     * @param disType the dis type
     * @param criteria the criteria
     * @return list
     */
	List<Map<String, Object>> exportPersonFollowup(Page page, String disType, QueryForm form, Criteria criteria);

	/**
     * 随访计划
     *
     * @param page the page
     * @param disType the dis type
     * @param criteria the criteria
     * @return list
     */
	List<Map<String, Object>> exportFollowupPlan(Page page, String disType, Criteria criteria);

    /**
     * Update organ by village
     *
     * @param orgCode             the org code
     * @param newAddVillageCodes             the new add village codes
     */
	void updateOrganByVillage(String orgCode, String[] newAddVillageCodes);

    /**
     * 管理卡的导出功能
     *
     * @param page
     * @param criteria
     * @return
     */
    List<Map<String, Object>> exportManageCard(Page page, Criteria criteria);

    /**
     * 统计五种慢病已管理的数量
     * @param criteria
     * @return
     */
    Map<String, Object> getMangerNum(Criteria criteria);

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
     * 获取高血压糖尿病规范化管理人数
     * @return
     */
    public List<Map<String, Object>> getHbpDiManagerMaps(String year);

    /**
     * 获取管理卡,无其它信息(包含已管理和已撤销)
     *
     * @param criteria
     *            the criteria
     * @return disease info only
     */
    public DmDiseaseInfo getDiseaseInfoOnly(Criteria criteria);
}