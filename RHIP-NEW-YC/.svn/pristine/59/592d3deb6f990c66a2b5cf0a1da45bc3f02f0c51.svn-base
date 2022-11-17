package com.founder.rhip.ehr.repository.pbusiness.dmbc;
import javax.annotation.Resource;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMosquitoesCaught;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMosquitoesCaughtDao;

import java.util.List;
import java.util.Map;

/**
 * DAO implement of DmbcMosquitoesCaught
 * 
 */
@Repository("dmbcMosquitoesCaughtDao")
public class DmbcMosquitoesCaughtDaoImpl extends AbstractDao<DmbcMosquitoesCaught, Long> implements IDmbcMosquitoesCaughtDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<DmbcMosquitoesCaught> searchMosquitoesList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_id, place, culex_pi, culex_tr, aedes_al, aedes_ae, an_s, an_a, an_d, an_m, other, total, remarks, species_code, create_time, create_by, update_time, update_by, is_delete from DMBC_MOSQUITOES_CAUGHT t ");
		SqlBuilder.buildWhereStatement(DmbcMosquitoesCaught.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<Map<String, Object>> report(String beginDate, String endDate, String townShip) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String table1 = "SELECT M .ENVIRONMENT ENV, SUM (C.TOTAL) TOTAL, WMSYS.WM_CONCAT (DISTINCT C.SPECIES_CODE) SPECIES FROM DMBC_MOSQUITOES_CAUGHT C, DMBC_MOSQUITOES_MONITOR M " +
				"WHERE C.IS_DELETE = 0 AND M .IS_DELETE = 0 AND C.MONITOR_ID = M . ID ";
		String table2 = "SELECT M .ENVIRONMENT ENV, COUNT (M . ID) * 0.25 TIME " +
				"FROM DMBC_MOSQUITOES_MONITOR M " +
				"WHERE M .IS_DELETE = 0 ";
		if (StringUtil.isNotEmpty(beginDate)) {
			parameters.addValue("beginDate", beginDate);
			table1 += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
			table2 += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
		}
		if (StringUtil.isNotEmpty(endDate)) {
			parameters.addValue("endDate", endDate);
			table1 += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
			table2 += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
		}
		if (ObjectUtil.isNotEmpty(townShip)) {
			parameters.addValue("townShip", townShip);
			table1 += "AND M.TOWN_SHIP = :townShip ";
			table2 += "AND M.TOWN_SHIP = :townShip ";
		}
		table1 += "GROUP BY M.ENVIRONMENT ORDER BY M.ENVIRONMENT";
		table2 += "GROUP BY M.ENVIRONMENT ORDER BY M.ENVIRONMENT";

		String sql = "SELECT A1.ENV ENV, A1.TOTAL TOTAL, A2. TIME TIME, A1.TOTAL / A2. TIME DENSITY, A1.SPECIES SPECIES " +
				"FROM (" + table1 + ") A1 JOIN (" + table2 + ") A2 ON A1.ENV = A2.ENV";
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
}