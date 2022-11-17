package com.founder.rhip.ehr.repository.pbusiness.dmbc;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionResult;
import com.founder.rhip.ehr.repository.dmbc.IDmbcDisinfectionResultDao;

/**
 * DAO implement of DmbcDisinfectionResult
 * 
 */
@Repository("dmbcDisinfectionResultDao")
public class DmbcDisinfectionResultDaoImpl extends
		AbstractDao<DmbcDisinfectionResult, Long> implements
		IDmbcDisinfectionResultDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public PageList<DmbcDisinfectionResult> searchDisinfectionMonitor(
			Criteria criteria, Page page) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_id, dept_name, pinpoint_total, pinpoint_acept_num, syringe_total, syringe_acept_num, gauze_total, gauze_acept_num, blade_total, blade_acept_num, eq_pre_solution_total, eq_pre_solution_acept_num, mouth_total, mouth_acept_num, cure_inst_total, cure_inst_acept_num, forceps_total, forceps_acept_num, engine_bit_total, engine_bit_acept_num, endoscope_total, endoscope_acept_num, hd_germ_total, hd_germ_acept_num, tl_germ_total, tl_germ_acept_num, hd_mrsa_total, hd_mrsa_acept_num, tl_mrsa_total, tl_mrsa_acept_num, hd_colicin_total, hd_colicin_acept_num, tl_colicin_total, tl_colicin_acept_num, or_bacteria_total, or_bacteria_acept_num, dr_bacteria_total, dr_bacteria_acept_num, icu_bacteria_total, icu_bacteria_acept_num, itpss_total, itpss_acept_num, cicpss_total, cicpss_acept_num, bibpss_total, bibpss_acept_num, total, acept_num, create_time, create_by, update_time, update_by, is_delete from DMBC_DISINFECTION_RESULT t ");
		SqlBuilder.buildWhereStatement(DmbcDisinfectionResult.class, sql,
				criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}