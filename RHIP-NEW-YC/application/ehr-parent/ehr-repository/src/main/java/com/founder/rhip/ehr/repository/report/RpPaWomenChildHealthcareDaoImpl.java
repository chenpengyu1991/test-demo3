package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.report.RpPaWomenChildHealthcare;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository("rpPaWomenChildHealthcareDao")
public class RpPaWomenChildHealthcareDaoImpl extends
		AbstractDao<RpPaWomenChildHealthcare, Long> implements
		IRpPaWomenChildHealthcareDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String WOMEN_CHILD_HEALTHCARE_STATISTICS_SQL = "select organ_code, doctor_idcard,max(doctor_name)doctor_name,sum(child_num) child_num,"
			+ " sum(pregnant_women_num) pregnant_women_num,sum(gestational_women_num) gestational_women_num,sum(premarital_num) premarital_num"
			+ " from rp_pa_women_child_healthcare %1$s group by organ_code,doctor_idcard";

	@Override
	public PageList<Map<String, Object>> getPaWomenChildHealthcarePageList(
			Criteria criteria, Page page) {
		StringBuilder conditionSqlBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(RpPaWomenChildHealthcare.class, conditionSqlBuilder, criteria);
		String sql = String.format(WOMEN_CHILD_HEALTHCARE_STATISTICS_SQL, conditionSqlBuilder.toString());
		return getPageMapList(page, sql, criteria);
	}
}
