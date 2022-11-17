package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmReportInfo;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of DmDiseaseInfo
 * 
 */
public interface IDmReportInfoDao extends IDao<DmReportInfo, Long> {

	/**
	 * 查询报卡详细列表 分页 根据人分组
	 * 
	 * @param page
	 * @param criteria
	 * @return
	 */
	List<DmReportInfo> getPagedDetailReportCardListGroupByPerson(Page page, Criteria criteria);

    /**
     * 查询报卡详细列表
     *
     * @param criteria the criteria
     * @return the report card list
     */
    public List<Map<String, Object>> getDetailReportCardMapList(Criteria criteria);

    /**
	 * 获取报卡信息 包含审核状态
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmReportInfo> getReports(Criteria criteria, Order order);

	/**
	 * 查询重复报卡
	 * 
	 * @param criteria
	 * @return
	 */
	public PageList<DmReportInfo> getRepeatCardList(Page page, Criteria criteria, String conditions);

    /**
     * Update organ by village.
     *
     * @param orgCode the org code
     * @param superOrgCode the super org code
     * @param newAddVillageCodes the new add village codes
     * @param status the status
     */
    public void updateOrganByVillage(String orgCode, String superOrgCode, String[] newAddVillageCodes, String status);

    Integer getPagedDetailReportCardListGroupByPersonCount(Criteria criteria);
}