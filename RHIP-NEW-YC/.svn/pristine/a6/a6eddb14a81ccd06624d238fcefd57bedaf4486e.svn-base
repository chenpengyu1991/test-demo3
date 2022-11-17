package com.founder.rhip.ehr.repository.report;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.report.RpPaVaccination;

@Repository("rpPaVaccinationDao")
public class RpPaVaccinationDaoImpl extends AbstractDao<RpPaVaccination, Long> implements IRpPaVaccinationDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String VACCINATION_PA_STATISTICS_SQL = "select organ_code, doctor_idcard,max(doctor_name)doctor_name,sum(vaccination_num) vaccination_num"
			+ " from rp_pa_vaccination %1$s group by organ_code,doctor_idcard";


	@Override
	public PageList<Map<String, Object>> getPaVaccinationPageList(
			Criteria criteria, Page page) {
		StringBuilder conditionSqlBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(RpPaVaccination.class, conditionSqlBuilder, criteria);
		String sql = String.format(VACCINATION_PA_STATISTICS_SQL, conditionSqlBuilder.toString());
		return getPageMapList(page, sql, criteria);

	}
}
