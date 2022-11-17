package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ncp.dao.INcpPatientDao;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;
import com.founder.rhip.ncp.entity.NcpPatient;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Repository("ncpPatientDao")
public class PatientDaoImpl extends AbstractDao<NcpPatient, String>  implements INcpPatientDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<NcpPatient> getNcpPatientList(Page buildPage, Criteria criteria) {

		StringBuilder sql = new StringBuilder();
		StringBuilder sql1 = new StringBuilder();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(NcpPatient.class);
		if (StringUtils.isNotEmpty((String) criteria.get("groupClassification"))) {
			String dynamicRecord = (String) criteria.get("groupClassification");
			criteria.remove("groupClassification");
			sql1 = getDynamicRecord(dynamicRecord, sql1);
		}
		sql.append("SELECT  ncp.*,B.NAME name, B.IDCARD idcard,  B.INPUT_ORGAN_NAME inputOrganName, B.INPUT_ORGAN_CODE inputOrganCode, B.GENDER gender, " +
				" B.BIRTHDAY birthday,B.PHONE_NUMBER phoneNumber,B.SIGN_FLAG signFlag,B.filing_Flag  filingFlag FROM BI_PERSON_INFO B inner join ncp_patient ncp on ncp.person_id=B.id");
		if (ObjectUtil.isNotEmpty(criteria.getCriteria())) {
			sql.append(" WHERE ").append(criteria.toSql(cMetadata, ":", "B"));
		}
		sql.append(sql1);
		sql.append(" order by ncp.update_time desc");
		//sql.append(order.toString());
		return this.getPageList(buildPage, sql.toString(), criteria);

	}

	private StringBuilder getDynamicRecord(String dynamicRecord, StringBuilder sql) {
		String[] sourceStrArray = dynamicRecord.split(",");
		for (int i = 0; i < sourceStrArray.length; i++) {
			sql.append(" AND( ");
			if (sourceStrArray[i].equals("1")) {
				sql.append(" MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 7");
				sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')>TO_CHAR(SYSDATE,'YYYY')-65");
				sql.append(" AND (MATERNAL_FLAG='1' or MATERNAL_FLAG is null)");
				sql.append(" AND NOT EXISTS( select person_id from DM_DISEASE_INFO D where (D.HBP_FLAG=2  OR D.DI_FLAG=2) AND B.ID=D.PERSON_ID ) ");
			}
			if (sourceStrArray[i].equals("2")) {
				sql.append(" MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 7 AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 0");
			}
			if (sourceStrArray[i].equals("3")) {
				sql.append(" TO_CHAR(B.BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65");
			}
			if (sourceStrArray[i].equals("4")) {
				sql.append(" MATERNAL_FLAG='2'");
			}
			if (sourceStrArray[i].equals("5")) {
				sql.append(" EXISTS( select person_id from DM_DISEASE_INFO D where D.HBP_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			}
			if (sourceStrArray[i].equals("6")) {
				sql.append(" EXISTS( select person_id from DM_DISEASE_INFO D where D.DI_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			}
			if (sourceStrArray[i].equals("7")) {
				sql.append(" EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE in('208', '209', '212') and dh.person_id = B.ID)");
			}
			if (sourceStrArray[i].equals("8")) {
				sql.append(" EXISTS( select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '208' and dh.person_id = B.ID)");
			}
			if (sourceStrArray[i].equals("9")) {
				sql.append(" EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '207' and dh.person_id = B.ID )");
			}
			if (i == sourceStrArray.length - 1) {
				sql.append(" ) ");
			}
			if (i != 0) {
				sql.append(" ) ");
			}

		}

		return sql;
	}

	@Override
	public List<Map<String, Object>> exportNcpPatientList(Page page, Criteria criteria) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		StringBuilder sql1 = new StringBuilder();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(NcpPatient.class);
		if (StringUtils.isNotEmpty((String) criteria.get("groupClassification"))) {
			String dynamicRecord = (String) criteria.get("groupClassification");
			criteria.remove("groupClassification");
			sql1 = getDynamicRecord(dynamicRecord, sql1);
		}
		sql.append("SELECT ncp.CLINICAL_CLASS clinicalclass, B.NAME name,B.GENDER gender,  B.IDCARD idcard,B.BIRTHDAY birthday,B.PHONE_NUMBER phonenumber,ORG.ORGAN_NAME managementorg,ncp.DISCHARGE_DATE dischargedate,   " +
				" case when B.SIGN_FLAG='0' then '未签约'    when B.SIGN_FLAG is null then '未签约'  when B.SIGN_FLAG ='1' then '已签约'   when B.SIGN_FLAG ='2' then '待付款'  else '' end signflag,"
				+ " case when B.filing_Flag='9' then '已结案'     when B.filing_Flag ='1' then '正常管理'   when B.filing_Flag ='5' then '正常管理'  else '' end filingflag" +
				" FROM BI_PERSON_INFO B inner join ncp_patient ncp on ncp.person_id=B.id INNER JOIN MDM_ORGANIZATION ORG on ncp.MANAGEMENT_ORG=org.ORGAN_CODE");
		if (ObjectUtil.isNotEmpty(criteria.getCriteria())) {
			sql.append(" WHERE ").append(criteria.toSql(cMetadata, ":", "B"));
		}
		sql.append(sql1);
		sql.append(" order by ncp.update_time desc");
		PageList<Map<String, Object>> pageList = this.getPageMapList(page, sql.toString(), criteria);
		List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
		if (null == result) {
			result = Collections.emptyList();
		}
		return result;
	}

	public List<NcpPatient> queryWithOutFollowUp() {
		StringBuilder sql = new StringBuilder("SELECT  ncp.create_doctor_code,ncp.id,ncp.cardno,ncp.discharge_date,p.plan_date FROM NCP_PATIENT  ncp\n" +
				"LEFT JOIN (select* from ncp_monitor_plan where type ='3') p on ncp.id =p.pid where p.plan_date is null");
		return this.getList(sql.toString());
	}

	public List<NcpPatient> queryTimesFollowUp() {
		StringBuilder sql = new StringBuilder("SELECT  ncp.create_doctor_code,ncp.id,ncp.cardno,ncp.discharge_date,tmp.plan_date as monitor_plan_date,tmp.id as monitor_plan_id FROM NCP_PATIENT  ncp " +
				"LEFT JOIN (select p.pid, p.id,pl.plan_date from(SELECT max(plan.id) as id,plan.pid  from ncp_monitor_plan plan where plan.type ='3' group by plan.pid) p left join"  +
				" ncp_monitor_plan pl on p.id = pl.id) tmp on ncp.id =tmp.pid where tmp.plan_date is not null");
		return this.getList(sql.toString());
	}

	public List<NcpPatient> queryFollowUp() {
		StringBuilder sql = new StringBuilder("SELECT ncp.create_doctor_code, ncp.id,ncp.cardno,ncp.discharge_date,p.plan_date, p.id as monitor_plan_id FROM NCP_PATIENT  ncp " +
				"LEFT JOIN (select plan.id,plan.pid,plan.plan_date from ncp_monitor_plan plan where plan.type ='3') p on ncp.id =p.pid where p.plan_date is not null");
		return this.getList(sql.toString());

	}
}
