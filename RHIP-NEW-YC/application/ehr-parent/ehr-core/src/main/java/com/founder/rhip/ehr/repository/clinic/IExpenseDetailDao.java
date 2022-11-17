package com.founder.rhip.ehr.repository.clinic;

import com.founder.rhip.ehr.entity.clinic.ExpenseDetail;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of ExpenseDetail
 */
public interface IExpenseDetailDao extends IDao<ExpenseDetail, Long> {

	/**
     * 根据ehr_id区分是住院还是门诊来填充CLINIC_MARK
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
	public void updateClinicMark();
    
}