package com.founder.rhip.ehr.repository.ihm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;

@Repository("ihmHospitalizeIntegrateDao")
public class HmHospitalizeIntegrateDaoImpl extends AbstractDao<HmHospitalize, Long> implements
		IHmHospitalizeIntegrateDao {

	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<HmHospitalize> catchHospitalizeData(String date) {
		StringBuilder sql = new StringBuilder();
		sql.append("select '"+date.replaceAll("/", "-")+" 00:00:00.0' ");
		sql.append("CREATE_DATE,nvl(CRITICAL_ILL_NUM.referral_hospital_code,nvl(fee.referral_hospital_code,nvl(IN_HOSPITAL_NUM.referral_hospital_code,nvl(LEAVE.referral_hospital_code,opt.HOSPITAL_CODE)))) organ_code,");
		sql.append("fee.in_personal_fee,fee.in_insurance_fee,fee.IN_HOS_FEE,CRITICAL_ILL_NUM.CRITICAL_ILL_NUM,summ.LEAVE_HOSPITAL_NUM, imr.INPATIENT_MEDICAL_RECORD_NUM, exp.IN_HOS_OPERATION_FEE, anesthesia_num,");
		sql.append(" in_hospital_num.cnt in_hospital_num, opt.cnt INHOSP_OPERATE_NUM,sickbed.cnt sickbedCount,");
		//药品费,占床日
		sql.append(" LEAVE.fee IN_HOS_MEDICINAL_FEE,LEAVE.days OUT_HOSP_BED,ANTIBACTERIAL_NUM, rsn.RESCU_SUCCESS_NUM, CLINIC_DIAG_ACCORD_NUM, ADMIT_DIAG_ACCORD_NUM, OPERATE_ACCORD_NUM");
		sql.append(" from ( select SUM(in_personal_fee) in_personal_fee,\n" +
				"    SUM(in_insurance_fee) in_insurance_fee,\n" +
				"    SUM(IN_HOS_FEE) IN_HOS_FEE,sum(ANTIBACTERIAL_NUM)ANTIBACTERIAL_NUM, REFERRAL_HOSPITAL_CODE from (select ");
		//个人费用
		sql.append("sum(PERSONAL_EXPENSES) in_personal_fee,");
		//--医保费用
		sql.append("sum(MEDICAL_INSURANCE_COST_SUM) in_insurance_fee,");
		//总费用
		sql.append("sum(INHOS_COST_SUM) IN_HOS_FEE,");
		//抗菌药物使用人数
		sql.append("case when ANTIBACTERIALS_FLAG='1' then count(1) end as ANTIBACTERIAL_NUM,");
		sql.append(" REFERRAL_HOSPITAL_CODE from (select i.*,\n" +
				"case when u.ehr_id is not null then 1 WHEN u.ehr_id is null THEN 0 end as ANTIBACTERIALS_FLAG\n" +
				"from MS_INPATIENT_INFO i left join (\n" +
				"  select ehr_id from MS_DRUG_USAGE where ANTIBACTERIALS_FLAG = '1' group by(ehr_id)\n" +
				") u on i.ehr_id = u.ehr_id )a where (to_char(a.INHOS_DATE, 'yyyy/MM/dd') ='"+date+"' or to_char(a.DEATH_DATE, 'yyyy/MM/dd') ='" + date+ "') group by a.REFERRAL_HOSPITAL_CODE, ANTIBACTERIALS_FLAG) group by REFERRAL_HOSPITAL_CODE)fee ");
		//出院人次，药品费,占床日
		sql.append(" left join (select count(1) LEAVE_HOSPITAL_NUM,SUM(du.fee) fee,sum(info.inhos_days) days,info.REFERRAL_HOSPITAL_CODE " +
				" from MS_INPATIENT_INFO info " +
				" left join (select ehr_id,  SUM(UNIT_PRICE*QUANTITY) fee from ms_drug_usage group by ehr_id) du" +
				" on du.ehr_id(+)= info.ehr_id\n" +
				" where (to_char(info.OUT_HOSPITAL_DATE, 'yyyy/MM/dd') ='"+date+"' or to_char(DEATH_DATE, 'yyyy/MM/dd') ='"+date+"' ) group by info.REFERRAL_HOSPITAL_CODE) LEAVE ");
		sql.append(" on LEAVE.REFERRAL_HOSPITAL_CODE = fee.REFERRAL_HOSPITAL_CODE");
		//危重病人
		sql.append(" left join (select count(1) CRITICAL_ILL_NUM, t.referral_hospital_code from MS_INPATIENT_INFO t where t.INHOS_CONDITION = '1' ");
		sql.append(" and to_char(t.INHOS_DATE, 'yyyy/MM/dd') = '"+date+"' group by t.referral_hospital_code) CRITICAL_ILL_NUM ");
		sql.append(" on CRITICAL_ILL_NUM.referral_hospital_code = fee.referral_hospital_code");
		//住院病人数
		sql.append(" left join (select count(1) cnt, referral_hospital_code from MS_INPATIENT_INFO t where to_char(t.INHOS_DATE, 'yyyy/MM/dd') = '"+date+"' group by t.referral_hospital_code) IN_HOSPITAL_NUM ");
		sql.append(" on IN_HOSPITAL_NUM.referral_hospital_code = fee.referral_hospital_code");
		//抢救成功人次
		sql.append(" left join (select SUM(INHOS_RESCUE_SUCCESS_TIMES) RESCU_SUCCESS_NUM, referral_hospital_code from MS_INPATIENT_INFO t where to_char(t.INHOS_DATE, 'yyyy/MM/dd') = '"+date+"' group by t.referral_hospital_code) rsn on rsn.referral_hospital_code = fee.referral_hospital_code");
		sql.append(" left JOIN\n" +
				"  (SELECT COUNT(1) cnt,--在院院病人数\n" +
				"    referral_hospital_code\n" +
				"  FROM MS_INPATIENT_INFO t\n" +
				"  WHERE (TO_CHAR(t.INHOS_DATE, 'yyyy/MM/dd') <= '" +date+ "' \n" +
				"  and (TO_CHAR(t.OUT_HOSPITAL_DATE, 'yyyy/MM/dd') >= '" +date+ "' or TO_CHAR(t.OUT_HOSPITAL_DATE, 'yyyy/MM/dd') >= '2016/11/29'))\n" +
				"  GROUP BY t.referral_hospital_code\n" +
				"  ) sickbed\n" +
				"ON sickbed.referral_hospital_code = fee.referral_hospital_code");
		//手术人次
		sql.append(" left JOIN (select count(1) cnt, sum(DECODE(ANESTHESIA_METHOD_CODE,NULL,0,1)) anesthesia_num,--麻醉人次\n" +
				" HOSPITAL_CODE from MS_SURGERY_INFO t where to_char(t.OPERTATION_DATE, 'yyyy/MM/dd') = '"+date+"' and OP_EM_HP_MARK='3'");
		sql.append(" group by t.HOSPITAL_CODE) opt on opt.HOSPITAL_CODE = fee.referral_hospital_code\n");
		sql.append(" left join (select REFERRAL_HOSPITAL_CODE, count(*) LEAVE_HOSPITAL_NUM --出院人数\n" +
				" from MS_INPATIENT_INFO\n" +
				" where TO_CHAR(OUT_HOSPITAL_DATE, 'yyyy/MM/dd') = '" + date +
				"' or TO_CHAR(DEATH_DATE, 'yyyy/MM/dd') = '" + date +"' group by REFERRAL_HOSPITAL_CODE) summ\n" +
				" on summ.REFERRAL_HOSPITAL_CODE = fee.referral_hospital_code");
		//病案首页数
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE, count(id) INPATIENT_MEDICAL_RECORD_NUM FROM MS_INPATIENT_MEDICAL_RECORD ");
		sql.append(" where TO_CHAR(OUT_HOSPITAL_DATE, 'yyyy/MM/dd') = '" + date + "' group by HOSPITAL_CODE) imr on imr.HOSPITAL_CODE = fee.referral_hospital_code");
		//住院手术收入
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE,SUM(DETAIL_ITEM_AMOUNT) IN_HOS_OPERATION_FEE FROM MS_EXPENSE_DETAIL ");
		sql.append(" where TO_CHAR(CLINIC_DATE, 'yyyy/MM/dd') = '" + date + "' AND MS_EXPENSE_DETAIL.COST_TYPE_CODE = '99' AND MS_EXPENSE_DETAIL.CLINIC_MARK = 3 group by HOSPITAL_CODE) exp on exp.HOSPITAL_CODE = fee.referral_hospital_code");
		//门诊和出院符合数
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE, count(id) CLINIC_DIAG_ACCORD_NUM FROM MS_INPATIENT_MEDICAL_RECORD ");
		sql.append(" where TO_CHAR(OUT_HOSPITAL_DATE, 'yyyy/MM/dd') = '" + date + "' AND OPHPDIAG_CI = '1' group by HOSPITAL_CODE) ophci on ophci.HOSPITAL_CODE = fee.referral_hospital_code");
		//入院和出院符合数
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE, count(id) ADMIT_DIAG_ACCORD_NUM FROM MS_INPATIENT_MEDICAL_RECORD ");
		sql.append(" where TO_CHAR(OUT_HOSPITAL_DATE, 'yyyy/MM/dd') = '" + date + "' AND ADDIAG_CI = '1' group by HOSPITAL_CODE) addci on addci.HOSPITAL_CODE = fee.referral_hospital_code");
		//术前和术后符合数
		sql.append(" LEFT JOIN (SELECT HOSPITAL_CODE, count(id) OPERATE_ACCORD_NUM FROM MS_INPATIENT_MEDICAL_RECORD ");
		sql.append(" where TO_CHAR(OUT_HOSPITAL_DATE, 'yyyy/MM/dd') = '" + date + "' AND OPERDIAG_CI = '1' group by HOSPITAL_CODE) opeci on opeci.HOSPITAL_CODE = fee.referral_hospital_code");

		return this.getList(sql.toString());
	}
}
