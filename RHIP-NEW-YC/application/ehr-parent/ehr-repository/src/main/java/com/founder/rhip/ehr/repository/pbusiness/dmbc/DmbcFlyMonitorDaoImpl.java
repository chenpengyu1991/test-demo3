package com.founder.rhip.ehr.repository.pbusiness.dmbc;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcFlyMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcFlyMonitorDao;

/**
 * DAO implement of DmbcFlyMonitor
 * 
 */
@Repository("dmbcFlyMonitorDao")
public class DmbcFlyMonitorDaoImpl extends AbstractDao<DmbcFlyMonitor, Long> implements IDmbcFlyMonitorDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<DmbcFlyMonitor> searchFlyMonitorList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_date, town_ship, temp, wind_scale, weather, monitor, verifiry_date, verifier, create_time, create_by, update_time, update_by, is_delete from DMBC_FLY_MONITOR t ");
		SqlBuilder.buildWhereStatement(DmbcFlyMonitor.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}