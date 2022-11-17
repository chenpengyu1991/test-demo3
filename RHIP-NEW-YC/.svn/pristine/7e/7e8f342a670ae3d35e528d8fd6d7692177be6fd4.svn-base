package com.founder.rhip.ehr.repository.pbusiness.dmbc;

import javax.annotation.Resource;

import com.founder.fasf.util.ObjectUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMouseMonitorDao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of DmbcMouseMonitor
 * 
 */
@Repository("dmbcMouseMonitorDao")
public class DmbcMouseMonitorDaoImpl extends
		AbstractDao<DmbcMouseMonitor, Long> implements IDmbcMouseMonitorDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<DmbcMouseMonitor> searchMouseMonitorList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_date, town_ship, environment, temp, total, recovery_count, invalid_count, indoor_count, outdoor_count, place, density, monitor, verifiry_date, verifier, create_time, create_by, update_time, update_by, is_delete   from DMBC_MOUSE_MONITOR t ");
		SqlBuilder.buildWhereStatement(DmbcMouseMonitor.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<Map<String, Object>> report(String beginDate, String endDate, String townShip) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String table1 = "SELECT ENVIRONMENT ENV, SUM(TOTAL - INVALID_COUNT) TRAPS, AVG(DENSITY) DENSITY " +
				"FROM DMBC_MOUSE_MONITOR WHERE IS_DELETE = 0 ";
		if (ObjectUtil.isNotEmpty(beginDate)) {
			parameters.addValue("beginDate", beginDate);
			table1 += "AND TO_CHAR(MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
		}
		if (ObjectUtil.isNotEmpty(endDate)) {
			parameters.addValue("endDate", endDate);
			table1 += "AND TO_CHAR(MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
		}
		if (ObjectUtil.isNotEmpty(townShip)) {
			parameters.addValue("townShip", townShip);
			table1 += "AND TOWN_SHIP = :townShip ";
		}
		table1 += "GROUP BY ENVIRONMENT ORDER BY ENVIRONMENT";
		String table2 = "SELECT M .ENVIRONMENT ENV, COUNT (c.ID) RATS, WMSYS.WM_CONCAT(DISTINCT c.MOUSE_SPECIES) SPECIES " +
				"FROM DMBC_MOUSE_MONITOR M " +
				"JOIN DMBC_MOUSE_CAUGHT c ON M . ID = c.MONITOR_ID " +
				"WHERE M .IS_DELETE = 0 AND c.IS_DELETE = 0 ";
		if (ObjectUtil.isNotEmpty(beginDate)) {
			table2 += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
		}
		if (ObjectUtil.isNotEmpty(endDate)) {
			table2 += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
		}
		if (ObjectUtil.isNotEmpty(townShip)) {
			table2 += "AND M .TOWN_SHIP = :townShip ";
		}
		table2 += "GROUP BY M .ENVIRONMENT ORDER BY M .ENVIRONMENT";
		String sql = "SELECT A1.ENV, A1.TRAPS, A1.DENSITY, A2.RATS, A2.SPECIES " +
				"FROM ( " + table1 + " ) A1 JOIN ( " + table2 + " ) A2 ON A1.ENV = A2.ENV";
		return simpleJdbcTemplate.queryForList(sql, parameters);
}
}