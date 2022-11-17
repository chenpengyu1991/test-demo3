package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;

import java.util.List;

public interface IDMFollowupPlanDao extends IDao<DMFollowupPlan, Long> {
	/**
	 * 查询随访计划
	 * @param criteria
	 * @param order
	 * @return
	 */
	public List<DMFollowupPlan> queryFollowupPlan(Criteria criteria, Order order);

    /**
     * 查询脑卒中的随访计划
     * @param plan the plan
     * @return list
     */
	List<DMFollowupPlan> queryStrokePlans(Criteria plan);

	/**
	 *	查询下次随访日期
	 * @param plan
	 * @return
	 */
	DMFollowupPlan getNextFollowupPlanDate(Criteria plan);

	/**
	 * 查询上次随访日期
	 * @param plan
	 * @return
	 */
	DMFollowupPlan getLastFollowupPlanDate(Criteria plan);

    /**
     * 获取已经随访的随访计划,不包含已经删除的
     *
     * @param personId the person id
     * @return the followuped plan by person id
     */
    public List<DMFollowupPlan> getFollowupedPlanByPersonId(Long personId);

	/**
	 * 生命周期——获取随访
	 * @param personId
	 * @return
	 */
	public List<DMFollowupPlan> getLifeEventByFollowupPlans(Long personId, String dmType);

	List<String> searchRepeatDate (Criteria criteria);


}