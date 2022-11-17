package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmTumorFollowup;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 随访计划
 *
 * @author liuk
 */
public interface IFollowupPlanService {

    /**
     * 删除计划
     *
     * @param personId the person id
     * @param disType the dis type
     * @return
     */
	public void removePlans(Long personId, String disType);

    /**
     * 生成肿瘤随访计划,根据每次随访的下次日期计算
     *
     * @param personId the person id
     * @param year the year
     * @param next the next
     */
    public void buildTumorPlans(Long personId, String year, Date next) ;

    /**
     * Generate plans.
     *
     * @param count the count
     * @param add the add
     * @param year the year
     * @param disType the dis type
     * @param personId the person id
     * @return the boolean
     */
	public boolean generatePlans(int count, int add, String year, String disType, Long personId);


    /**
     * 生成随访计划
     *
     * @param start the start 开始日期
     * @param count the count 随访总数
     * @param add the add 间隔月份
     * @param year the year 计划年度
     * @param disType the dis type 疾病类型
     * @param personId the person id
     * @return the boolean
     */
	public boolean generatePlans(Date start, int count, int add, String year, String disType, Long personId);

    /**
     * Update plan and return plan.
     *
     * @param id the id
     * @param followupId the followup id
     * @param visitDate the visit date
     * @return the dM followup plan
     */
	public DMFollowupPlan updatePlanAndReturnPlan(Long id, Long followupId, Date visitDate);

    /**
     * 获取下一次随访日期
     *
     * @param personId the person id
     * @param disType the dis type
     * @return next plan date
     */
	public Date getNextPlanDate(Long personId, String disType);

    /**
     * Gets last plan date.
     *
     * @param personId the person id
     * @param disType the dis type
     * @return the last plan date
     */
	public DMFollowupPlan getLastPlanDate(Long personId, String disType);

    /**
     * 更新计划,保存随访日期
     *
     * @param id the id
     * @param followupId the followup id
     * @param visitDate the visit date
     */
	public void updatePlan(Long id, Long followupId, Date visitDate);

    /**
     * 更新下次随访日期
     *
     * @param personId the person id
     * @param disType the dis type
     * @param date the date
     * @return
     */
	public void doUpdateNextFollowupDate(Long personId, String disType, Date date);

    /**
     * Build strtum plan.
     *
     * @param start the start
     * @param followupFlag the followup flag
     * @param disType the dis type
     * @param personId the person id
     * @return the date
     */
    public Date buildStrtumPlan(Date start, String followupFlag, String disType, Long personId);

    /**
     * Build strtum plan and upd next followup date.
     *
     * @param start the start
     * @param followupFlag the followup flag
     * @param disType the dis type
     * @param personId the person id
     * @return the boolean
     */
    public boolean buildStrtumPlanAndUpdNextFollowupDate(Date start, String followupFlag, String disType, Long personId);


    /**
     * 生成高血压糖尿病的下一年的随访计划和更新下次随访日期
     * @param disType
     * @param date 
     * @param personId
     * @return
     */
    public boolean buildHbpDiPlanAndUpdNextFollowupDate(String disType, Date date, Long personId);

    /**
     * Update next followup date.
     *
     * @param dmfInfo the dmf info
     * @param personId the person id
     * @param disType the dis type
     */
    public void updateNextFollowupDate(DMFollowupPlan dmfInfo, Long personId, String disType);

    /**
     * 删除肿瘤随访计划
     *
     * @param tumor the tumor
     */
	public void removeTumorPlan(DmTumorFollowup tumor);

    /**
     * Cal tumor plan.
     *
     * @param dmfInfo the dmf info
     * @param tumor the tumor
     * @param start the start
     * @param remove the remove
     */
    public void calTumorPlan(DMFollowupPlan dmfInfo, DmTumorFollowup tumor, Date start, boolean remove);

    /**
     * Build tumor plan.
     *
     * @param start the start
     * @param followupFlag the followup flag
     * @param disType the dis type
     * @param personId the person id
     * @return the date
     */
    public Date buildTumorPlan(Date start, String followupFlag, String disType, Long personId);

    //高血压糖尿病随访计划
    public Date buildHbpAndDiPlan(String disType, Date StartDate,Long personId, boolean flag);

    /**
     * 通过查询条件获取随访计划
     * @param criteria 查询条件
     * @return
     */
    public List<DMFollowupPlan> getFollowPlanList(Criteria criteria);

	public Date getNextPlanDate(Long personId, Date planDate, String dmHbpType);

	public Date buildStrtumPlan(String strokeManagedFayFlag, String dmStrokeType, Long personId);

	boolean generatePlan(Date start, int count, int add, String year, String disType, Long personId, Boolean flag);

	//查询重复日期
    List<String> searchRepeatDate(Criteria criteria);

    //删除随访计划
    public int clearPlan(Long planId);
}
