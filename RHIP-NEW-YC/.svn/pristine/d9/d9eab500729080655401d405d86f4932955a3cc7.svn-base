package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ExpenseInfo;

/**
 * DAO interface of ExpenseInfo
 */
public interface IExpenseInfoDao extends IDao<ExpenseInfo, Long> {
	
	/**
     * 根据ehr_id区分是住院还是门诊来填充op_em_hp_mark
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
	public void updateOpEmHpMark();
	
	List<Map<String, Object>> getExpenseMapList(String dateStr);
}