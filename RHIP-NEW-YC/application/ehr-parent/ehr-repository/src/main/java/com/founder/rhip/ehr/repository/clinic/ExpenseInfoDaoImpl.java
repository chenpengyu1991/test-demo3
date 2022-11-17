package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ExpenseInfo;

/**
 * DAO implement of ExpenseInfo
 * 
 */
@Repository("expenseInfoDao")
public class ExpenseInfoDaoImpl extends AbstractDao<ExpenseInfo, Long> implements IExpenseInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String EXPENSE_STATISTICS_SQL = "select t.hospital_code organCode,"
        + " t.OP_EM_HP_MARK rpType,"
    	+ " to_char(t.SETTLEMENT_DATE, 'yyyy/MM/dd') rpDate,"
        + " sum(decode(t.COST_TYPE_CODE, '00', t.TOTAL_COST, 0)) consumablesFee,"
        + " sum(decode(t.COST_TYPE_CODE, '01', t.TOTAL_COST, 0)) westernMedicineFee,"
        + " sum(decode(t.COST_TYPE_CODE, '02', t.TOTAL_COST, 0)) medicineFee,"
        + " sum(decode(t.COST_TYPE_CODE, '03', t.TOTAL_COST, 0)) chineseMedicineFee,"
        + " sum(decode(t.COST_TYPE_CODE, '03', t.TOTAL_COST, 0)) chineseMedicineFee,"
        + " sum(decode(t.COST_TYPE_CODE, '04', t.TOTAL_COST, 0)) inspectingFee,"
        + " sum(decode(t.COST_TYPE_CODE, '05', t.TOTAL_COST, 0)) inspectionFee,"
        + " sum(decode(t.COST_TYPE_CODE, '06', t.TOTAL_COST, 0)) laboratoryFee,"
        + " sum(decode(t.COST_TYPE_CODE, '07', t.TOTAL_COST, 0)) radiationFee,"
        + " sum(decode(t.COST_TYPE_CODE, '08', t.TOTAL_COST, 0)) treatmentFee,"
        + " sum(decode(t.COST_TYPE_CODE, '09', t.TOTAL_COST, 0)) operationFee,"
        + " sum(decode(t.COST_TYPE_CODE, '10', t.TOTAL_COST, 0)) bloodFee,"
        + " sum(decode(t.COST_TYPE_CODE, '11', t.TOTAL_COST, 0)) bedFee,"
        + " sum(decode(t.COST_TYPE_CODE, '12', t.TOTAL_COST, 0)) nursingFee,"
        + " sum(decode(t.COST_TYPE_CODE, '13', t.TOTAL_COST, 0)) anesthesiaFee,"
        + " sum(decode(t.COST_TYPE_CODE, '99', t.TOTAL_COST, 0)) otherFee,"
        + " count(distinct t.ehr_id) countEhrId"
        + " from ms_expense_info t where 1=1 %1$s"
        + " group by t.hospital_code, t.OP_EM_HP_MARK, to_char(t.SETTLEMENT_DATE, 'yyyy/MM/dd')";
    
    @Override
    public void updateOpEmHpMark() {
    	this.execute("update ms_expense_info t set t.op_em_hp_mark = '1' where t.op_em_hp_mark is null and t.ehr_id like 'mz%'");
    	this.execute("update ms_expense_info t set t.op_em_hp_mark = '3' where t.op_em_hp_mark is null and t.ehr_id like 'zy%'");
    }

	@Override
	public List<Map<String, Object>> getExpenseMapList(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		StringBuilder dateConditionSql = new StringBuilder(" and to_char(t.GATHER_DATE, 'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(EXPENSE_STATISTICS_SQL, dateConditionSql);
		return getMapList(sql, (Criteria) null);
	}
}