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
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcRoachMonitorDao;

import java.util.List;
import java.util.Map;

/**
 * DAO implement of DmbcRoachMonitor
 * 
 */
@Repository("dmbcRoachMonitorDao")
public class DmbcRoachMonitorDaoImpl extends AbstractDao<DmbcRoachMonitor, Long> implements IDmbcRoachMonitorDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<DmbcRoachMonitor> searchRoachMonitorList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_date, town_ship, temp, environment, org_name, recycle_cnt, monitor, verifiry_date, verifier, create_time, create_by, update_time, update_by, is_delete from DMBC_ROACH_MONITOR t ");
		SqlBuilder.buildWhereStatement(DmbcRoachMonitor.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<Map<String, Object>> report(String beginDate, String endDate, String townShip) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String table1 = "SELECT M .ENVIRONMENT ENV, SUM ( C.TOTAL_N + C.TOTAL_F + C.TOTAL_M ) TOTAL, WMSYS.WM_CONCAT (DISTINCT C.SPECIES_CODE) SPECIES " +
				"FROM DMBC_ROACH_MONITOR M, DMBC_ROACH_CAUGHT C " +
				"WHERE M .IS_DELETE = 0 AND C.IS_DELETE = 0 AND M . ID = C.MONITOR_ID ";
		String table2 = "SELECT M .ENVIRONMENT ENV, SUM (M .RECYCLE_CNT) PAPER, SUM (M .POSITIVE_CNT) POS " +
				"FROM DMBC_ROACH_MONITOR M " +
				"WHERE M .IS_DELETE = 0 ";
		if (ObjectUtil.isNotEmpty(beginDate)) {
			parameters.addValue("beginDate", beginDate);
			table1 += "AND TO_CHAR(MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
			table2 += "AND TO_CHAR(MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
		}
		if (ObjectUtil.isNotEmpty(endDate)) {
			parameters.addValue("endDate", endDate);
			table1 += "AND TO_CHAR(MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
			table2 += "AND TO_CHAR(MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
		}
		if (ObjectUtil.isNotEmpty(townShip)) {
			parameters.addValue("townShip", townShip);
			table1 += "AND TOWN_SHIP = :townShip ";
			table2 += "AND TOWN_SHIP = :townShip ";
		}
		table1 += "GROUP BY ENVIRONMENT ORDER BY ENVIRONMENT";
		table2 += "GROUP BY ENVIRONMENT ORDER BY ENVIRONMENT";

		String sql = "SELECT A1.ENV, A2.PAPER, A2.POS, TO_CHAR ( A2.POS / A2.PAPER * 100, '999D99' ) || '%' RATE, A1.TOTAL, ROUND (A1.TOTAL / A2.PAPER) DENSITY, A1.SPECIES " +
				"FROM (" + table1 + ") A1 JOIN (" + table2 + ") A2 ON A1.ENV = A2.ENV";
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
}