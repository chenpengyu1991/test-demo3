package com.founder.rhip.ehr.repository.pbusiness.dmbc;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcDisinfectionMonitorDao;

/**
 * DAO implement of DmbcDisinfectionMonitor
 * 
 */
@Repository("dmbcDisinfectionMonitorDao")
public class DmbcDisinfectionMonitorDaoImpl extends
		AbstractDao<DmbcDisinfectionMonitor, Long> implements
		IDmbcDisinfectionMonitorDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public PageList<DmbcDisinfectionMonitor> searchDisinfectionMonitor(
			Criteria criteria, Page page) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, org_name, monitor_date, create_time, create_by, update_time, update_by, is_delete,(select sum(dr.total) from dmbc_disinfection_result dr where dr.monitor_id = t.id and dr.is_delete = 0) total,(select sum(dr.acept_num) from dmbc_disinfection_result dr where dr.monitor_id = t.id and dr.is_delete = 0) acept_num from DMBC_DISINFECTION_MONITOR t ");
		SqlBuilder.buildWhereStatement(DmbcDisinfectionMonitor.class, sql,
				criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}