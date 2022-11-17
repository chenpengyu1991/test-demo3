package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;

/**
 * DAO interface of OutpatientPrescription
 */
public interface IOutpatientPrescriptionDao extends IDao<OutpatientPrescription, Long> {
	
	/**
	 * 更新冗余字段：处方品种数
	 *
	 * @return
	 * @author Ye jianfei
	 */
	public int updateTotalCount();
	
	/**
	 * 更新冗余字段：处方中药物使用最大剂量
	 *
	 * @return
	 * @author Ye jianfei
	 */
	public int updateMaxDose();
	
	/**
	 * 更新冗余字段：处方中药物使用最大天数
	 *
	 * @return
	 * @author Ye jianfei
	 */
	public int updateMaxUseDays();
	
	/**
	 * 获取处方详细
	 *
	 * @param ehrId
	 * @param recordNumber
	 * @return
	 * @author Ye jianfei
	 */
	public OutpatientPrescription getOutpatientPrescription(String ehrId,String recordNumber);
	
	/**
     * 根据ehr_id区分是住院还是门诊来填充op_em_hp_mark
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
	public void updateOpEmHpMark();
	
	/**
	 * 处方统计查询
	 * @param dateStr 日期（格式：yyyy/MM/dd）
	 * @return Map<String, Object> 处方数、抗菌药物处方、是否收费、是否发药等
	 */
	List<Map<String,Object>> getPrescriptionStatistics(String dateStr);

    /**
     * 按机构统计处方金额汇总，最大处方金额，处方数量
     * @param ca
     * @return
     */
    public List<Map<String,Object>> getPrescriptionSummary(Criteria ca);

	/**
     * 处方查询
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     * @author Ye jianfei
     */
    public PageList<OutpatientPrescription> getOutpatientPrescriptionList(Page page, Criteria criteria, Order order);
    
}