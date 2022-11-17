package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;

import java.util.List;

/**
 * 保健计划
 * 
 */
public interface IHealthPalnService {

	/**
	 * 保健计划年度列表查询年份
	 * 
	 * @param personId
	 * @return
	 */
	List<DMFollowupPlan> queryDmFollowupPlanList(Criteria criteria, Order order);

	/**
	 * 保健计划年度列表查询随访计划
	 * 
	 * @param personId
	 * @return
	 */
	List<DMFollowupPlan> searchDmFollowupPlanList(Criteria criteria, Order order);

	/**
	 * 保健计划查询列表
	 * 
	 * @param Criteria
	 * @return List
	 */
	public PageList<DmHypertensionConclusion> getHealthPlanList(Page page, Criteria criteria);

	/**
	 * 保健计划查询详情
	 * 
	 * @param Criteria
	 * @return List
	 */
	public List<DmHypertensionConclusion> getHealthPlanDetailList(Criteria criteria);

	/**
	 * 根据personid得到DmHypertensionConclusion列表
	 * 
	 * @param Criteria
	 * @return List
	 */
	public List<DmHypertensionConclusion> getDmHypertensionConclusions(Criteria criteria);

	/**
	 * 保健计划修改
	 * 
	 * @return String
	 */
	public String saveHealthPlan(DmHypertensionConclusion healthPlan);

	/**
	 * 保健计划删除
	 * 
	 * @return List
	 */
	public void deleteHealthPlan(DmHypertensionConclusion healthPlanId);

	/**
	 * 查询最后一条随访计划
	 *
	 * @param criteria
	 * @return
	 */
	DMFollowupPlan searchLastPlan(Criteria criteria);
}
