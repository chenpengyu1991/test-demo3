package com.founder.rhip.ehr.repository.clinic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.ExpenseDetail;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of ExpenseDetail
 * 
 */
@Repository("expenseDetailDao")
public class ExpenseDetailDaoImpl extends AbstractDao<ExpenseDetail, Long> implements IExpenseDetailDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
     * 根据ehr_id区分是住院还是门诊来填充CLINIC_MARK
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
    @Override
	public void updateClinicMark() {
		this.execute("update ms_expense_detail t set t.CLINIC_MARK = '1' where t.CLINIC_MARK is null and t.ehr_id like 'mz%'");
    	this.execute("update ms_expense_detail t set t.CLINIC_MARK = '3' where t.CLINIC_MARK is null and t.ehr_id like 'zy%'");
	}
	
}