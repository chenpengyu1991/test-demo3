package com.founder.rhip.ehr.repository.ihm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;

@Repository("ihmOutpatientIntegrateDao")
public class HmOutpatientIntegrateDaoImpl extends
		AbstractDao<HmOutpatient, Long> implements IHmOutpatientIntegrateDao {

	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<HmOutpatient> catchOutpatientData(String date) {
		StringBuilder sql = new StringBuilder();
        sql.append("SELECT  '"+date.replaceAll("/", "-") + " 00:00:00.0' CREATE_DATE,\n" +
                "  m.CLINIC_ORGAN_CODE ORGAN_CODE," +
                "  PRESCRIPTION_COUNT,\n" +
                "  medical_insurance_cost_sum cooperative_medical_fee,\n" +
                "  TREATMENT_NUM, STAY_NUM," +
                "  EMERGENCY_NUM,\n" +
                "  EMERGENCY_FEE,\n" +
                "  emergency_personal_fee,\n" +
                "  emergency_insurance_fee,\n" +
                "  OUTPATIENT_NUM,\n" +
                "  OUTPATIENT_FEE,\n" +
                "  outpatient_personal_fee,\n" +
                "  outpatient_insurance_fee,\n" +
                "  OUTPATIENT_MEDICINAL_FEE,\n" +
                "  nvl(j_prescription_route_count,0) + nvl(m_prescription_route_count,0) INFUSION_NUM,\n" +
                "  ANTIBIOTIC_OP_NUM,\n" +
                "  ANTIBIOTIC_EOP_NUM, r.reg_Num, OUTPATIENT_OPERATION_FEE, EMERGENCY_OPERATION_FEE \n" +
                "FROM\n" +
                "  (select CLINIC_ORGAN_CODE,\n" +
                "sum(PRESCRIPTION_COUNT) PRESCRIPTION_COUNT,\n" +
                " sum(medical_insurance_cost_sum) medical_insurance_cost_sum," +
                "sum(TREATMENT_NUM) TREATMENT_NUM,\n" +
                "sum(STAY_NUM) STAY_NUM," +
                "sum(j_cnt) EMERGENCY_NUM,\n" +
                "sum(EMERGENCY_FEE) EMERGENCY_FEE,\n" +
                "sum(emergency_personal_fee) emergency_personal_fee, \n" +
                "SUM(emergency_insurance_fee) emergency_insurance_fee,\n" +
                "sum(j_prescription_route_count) j_prescription_route_count,\n" +
                "sum(m_cnt) OUTPATIENT_NUM,\n" +
                "SUM(OUTPATIENT_FEE) OUTPATIENT_FEE,\n" +
                "SUM(outpatient_personal_fee) outpatient_personal_fee,\n" +
                "sum(outpatient_insurance_fee) outpatient_insurance_fee,\n" +
                "sum(m_prescription_route_count) m_prescription_route_count\n" +
                "from (\n" +
                "select\n" +
                "CLINIC_ORGAN_CODE,\n" +
                "sum(PRESCRIPTION_COUNT) PRESCRIPTION_COUNT,\n" +
                "case  when (medical_cost_pay_way = '01' or medical_cost_pay_way = '02' or medical_cost_pay_way = '03') then sum (medical_insurance_cost_sum) end as medical_insurance_cost_sum,\n" +
                "case  when (VISIT_STATUS =  '2' OR VISIT_STATUS IS NULL) then COUNT(1) end as TREATMENT_NUM,\n" +
                "case  when (OBSERVED_PATIENT_FLAG = '1') then COUNT(1) end as STAY_NUM," +
                "case  when (OUTPATIENT_TYPE = 1) then COUNT(1) end as j_cnt,\n" +
                "case  when (OUTPATIENT_TYPE = 1) then sum (outpatient_Cost_Sum) end as EMERGENCY_FEE,\n" +
                "case  when (OUTPATIENT_TYPE = 1) then SUM(personal_Expenses) end as emergency_personal_fee,\n" +
                "case  when (OUTPATIENT_TYPE = 1) then SUM(medical_Insurance_Cost_Sum) end as emergency_insurance_fee,\n" +
                "case  when (OUTPATIENT_TYPE = 1) then sum(prescription_route_count) end as j_prescription_route_count,\n" +
                "case  when (OUTPATIENT_TYPE = 0 OR OUTPATIENT_TYPE IS NULL) then count (1) end as m_cnt,\n" +
                "case  when (OUTPATIENT_TYPE = 0 OR OUTPATIENT_TYPE IS NULL) then SUM(outpatient_Cost_Sum) end as OUTPATIENT_FEE,\n" +
                "case  when (OUTPATIENT_TYPE = 0 OR OUTPATIENT_TYPE IS NULL) then SUM(personal_Expenses) end as outpatient_personal_fee,\n" +
                "case  when (OUTPATIENT_TYPE = 0 OR OUTPATIENT_TYPE IS NULL) then SUM(medical_Insurance_Cost_Sum) end as outpatient_insurance_fee,\n" +
                "case  when (OUTPATIENT_TYPE = 0 OR OUTPATIENT_TYPE IS NULL) then sum(prescription_route_count) end as m_prescription_route_count\n" +
                "from MS_OUTPATIENT_INFO\n" +
                "WHERE TO_CHAR(clinic_date, 'yyyy/MM/dd') = '" + date + "'\n" +
                "group by CLINIC_ORGAN_CODE, OUTPATIENT_TYPE,VISIT_STATUS,OBSERVED_PATIENT_FLAG,medical_cost_pay_way)\n" +
                "group by CLINIC_ORGAN_CODE\n" +
                ") m\n" +
                "left JOIN\n" +
                "  (SELECT SUM(PRESCRIPTION_TOTAL_COST) OUTPATIENT_MEDICINAL_FEE,\n" +
                "    op.HOSPITAL_CODE\n" +
                "  FROM MS_OUTPATIENT_PRESCRIPTION op\n" +
                "  WHERE TO_CHAR(op.PRESCRIBE_DATE, 'yyyy/MM/dd') = '" + date + "'\n" +
                "  GROUP BY op.HOSPITAL_CODE\n" +
                "  ) op\n" +
                "ON op.hospital_code = m.CLINIC_ORGAN_CODE\n" +
                "left JOIN(select HOSPITAL_CODE,sum(m_num)ANTIBIOTIC_OP_NUM,\n" +
                "sum(j_num) ANTIBIOTIC_EOP_NUM from (\n" +
                "select\n" +
                "HOSPITAL_CODE,\n" +
                "case  when (OP_EM_HP_MARK = '1') then count (*) end as m_num,\n" +
                "case  when (OP_EM_HP_MARK = '2') then count (*) end as j_num\n" +
                "from MS_OUTPATIENT_PRESCRIPTION\n" +
                "WHERE ANTIBIOTIC_FLAG                     ='1'\n" +
                "AND TO_CHAR(PRESCRIBE_DATE, 'yyyy/MM/dd') = '" + date + "'\n" +
                "group by HOSPITAL_CODE, OP_EM_HP_MARK)\n" +
                "group by HOSPITAL_CODE) a\n" +
                "on a.hospital_code = m.CLINIC_ORGAN_CODE " +
                "left JOIN(\n" +
                "select\n" +
                "create_organ_code,\n" +
                "count(*) reg_Num \n" +
                "from MS_REGISTER_RECORD\n" +
                "WHERE TO_CHAR(REC_DT, 'yyyy/MM/dd') = '" + date + "'\n" +
                "group by create_organ_code) r\n" +
                "on r.create_organ_code = m.CLINIC_ORGAN_CODE");
		//门诊手术收入
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE,SUM(DETAIL_ITEM_AMOUNT) OUTPATIENT_OPERATION_FEE FROM MS_EXPENSE_DETAIL ");
		sql.append(" where TO_CHAR(CLINIC_DATE, 'yyyy/MM/dd') = '" + date + "' AND MS_EXPENSE_DETAIL.COST_TYPE_CODE = '99' AND MS_EXPENSE_DETAIL.CLINIC_MARK = 1 group by HOSPITAL_CODE) oof on oof.HOSPITAL_CODE = m.CLINIC_ORGAN_CODE");
		//急诊手术收入
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE,SUM(DETAIL_ITEM_AMOUNT) EMERGENCY_OPERATION_FEE FROM MS_EXPENSE_DETAIL ");
		sql.append(" where TO_CHAR(CLINIC_DATE, 'yyyy/MM/dd') = '" + date + "' AND MS_EXPENSE_DETAIL.COST_TYPE_CODE = '99' AND MS_EXPENSE_DETAIL.CLINIC_MARK = 2 group by HOSPITAL_CODE) eof on eof.HOSPITAL_CODE = m.CLINIC_ORGAN_CODE");

		/*sql.append("select '"+date.replaceAll("/", "-")+" 00:00:00.0' CREATE_DATE, nvl(j.CLINIC_ORGAN_CODE,m.CLINIC_ORGAN_CODE) ORGAN_CODE,j.cnt EMERGENCY_NUM, j.EMERGENCY_FEE, j.emergency_personal_fee, j.emergency_insurance_fee, m.cnt OUTPATIENT_NUM, m.OUTPATIENT_FEE, m.outpatient_personal_fee, m.outpatient_insurance_fee,op.OUTPATIENT_MEDICINAL_FEE");
		sql.append(" from (select count(1) cnt, sum(outpatient_Cost_Sum) EMERGENCY_FEE, sum(personal_Expenses) emergency_personal_fee, sum(medical_Insurance_Cost_Sum) emergency_insurance_fee, t.CLINIC_ORGAN_CODE ");
		sql.append(" from MS_OUTPATIENT_INFO t where (t.OUTPATIENT_TYPE = 1 OR OUTPATIENT_TYPE IS NULL) ");
		sql.append(" and to_char(t.clinic_date, 'yyyy/MM/dd') = '"+date+"' group by t.CLINIC_ORGAN_CODE) j FULL OUTER JOIN ");
		sql.append(" (select count(1) cnt, sum(outpatient_Cost_Sum) OUTPATIENT_FEE, sum(personal_Expenses) outpatient_personal_fee, sum(medical_Insurance_Cost_Sum) outpatient_insurance_fee, t.CLINIC_ORGAN_CODE ");
		sql.append(" from MS_OUTPATIENT_INFO t where t.OUTPATIENT_TYPE = 0 and to_char(t.clinic_date, 'yyyy/MM/dd') = '"+date+"' group by t.CLINIC_ORGAN_CODE) m on j.CLINIC_ORGAN_CODE = m.CLINIC_ORGAN_CODE");
		//门诊药品费
		sql.append(" FULL OUTER JOIN (select sum(PRESCRIPTION_TOTAL_COST) OUTPATIENT_MEDICINAL_FEE,op.HOSPITAL_CODE");
		sql.append(" from MS_OUTPATIENT_PRESCRIPTION op where to_char(op.FILL_TIME, 'yyyy/MM/dd') = '"+date+"' group by op.HOSPITAL_CODE ) op");
		sql.append("  on op.hospital_code = m.CLINIC_ORGAN_CODE");*/
		return this.getList(sql.toString());
	}

}
