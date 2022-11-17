package com.founder.rhip.ehr.repository.pbusiness.dmbc;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcRoachCaughtDao;

/**
 * DAO implement of DmbcRoachCaught
 * 
 */
@Repository("dmbcRoachCaughtDao")
public class DmbcRoachCaughtDaoImpl extends AbstractDao<DmbcRoachCaught, Long> implements IDmbcRoachCaughtDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public PageList<DmbcRoachCaught> searchRoachList(Page page,
			Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_id, place, bla_germanica_n, bla_germanica_f, bla_germanica_m, per_americana_n, per_americana_f, per_americana_m, per_australasiae_n, per_australasiae_f, per_australasiae_m, per_fuliginosa_n, per_fuliginosa_f, per_fuliginosa_m, per_brunnea_burmeister_n, per_brunnea_burmeister_f, per_brunnea_burmeister_m, per_japonica_n, per_japonica_f, per_japonica_m, other_n, other_f, other_m, total_n, total_f, total_m, total, remarks, species_code, create_time, create_by, update_time, update_by, is_delete, bla_ger_density_n, bla_ger_density_f, bla_ger_density_m, bla_ger_dg_rate_n, bla_ger_dg_rate_f, bla_ger_dg_rate_m, per_ame_density_n, per_ame_density_f, per_ame_density_m, per_ame_dg_rate_n, per_ame_dg_rate_f, per_ame_dg_rate_m, per_aus_density_n, per_aus_density_f, per_aus_density_m, per_aus_dg_rate_n, per_aus_dg_rate_f, per_aus_dg_rate_m, per_ful_density_n, per_ful_density_f, per_ful_density_m, per_ful_dg_rate_n, per_ful_dg_rate_f, per_ful_dg_rate_m, per_bru_density_n, per_bru_density_f, per_bru_density_m, per_bru_dg_rate_n, per_bru_dg_rate_f, per_bru_dg_rate_m, per_jap_density_n, per_jap_density_f, per_jap_density_m, per_jap_dg_rate_n, per_jap_dg_rate_f, per_jap_dg_rate_m, other_density_n, other_density_f, other_density_m, other_dg_rate_n, other_dg_rate_f, other_dg_rate_m from DMBC_ROACH_CAUGHT t ");
		SqlBuilder.buildWhereStatement(DmbcRoachMonitor.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}