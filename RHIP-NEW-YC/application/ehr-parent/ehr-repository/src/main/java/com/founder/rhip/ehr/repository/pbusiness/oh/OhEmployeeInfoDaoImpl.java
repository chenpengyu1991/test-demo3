package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.oh.OhEmployeeInfo;
import com.founder.rhip.ehr.repository.oh.IOhEmployeeInfoDao;

@Repository("ohEmployeeInfoDao")
public class OhEmployeeInfoDaoImpl extends AbstractDao<OhEmployeeInfo, Integer> implements
		IOhEmployeeInfoDao {
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<OhEmployeeInfo> searchEmployeeInfoList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, gender, idcard, birthdate, paprovince, pacity, pacounty,");
		sql.append("patown_ship, job_type, doc_type, start_date, total_year, total_month,");
		
		sql.append("pneumoconiosis_type, death_date, died_reason, other_info, xline_no, education, ");
		sql.append("phone, mobile, other_contacts, contact_name, contact_addr, contact_phone, ");
		sql.append("contact_mobilephone, first_diagnosis_dt, first_result, first_org, ");
		sql.append("sec_diagnosis_dt, sec_result, sec_org, th_diagnosis_dt, th_result, th_org,");
		
		sql.append("occu_disease_type, occu_diseas_name, diagnosis_dt, diagnosis_org, verify_state,");
		sql.append("verify_date, verifier, create_time, create_by, update_time, update_by, is_delete");
		sql.append(" from OH_EMPLOYEE_INFO t");
		SqlBuilder.buildWhereStatement(OhEmployeeInfo.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "verify_state DESC, update_time DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public OhEmployeeInfo searchEmployeeInfo(Criteria criteria) {
		return this.get(OhEmployeeInfo.class, criteria);
	}

	@Override
	public Long saveEmployeeInfo(OhEmployeeInfo employeeInfo) {
		Number keyId= this.generatedKey(employeeInfo,"id",null);
		return  keyId==null?null:keyId.longValue();
	}

}
