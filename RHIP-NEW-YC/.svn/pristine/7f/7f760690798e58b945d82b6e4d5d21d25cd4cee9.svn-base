package com.founder.rhip.ehr.repository.pbusiness.dmbc;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseCaught;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMouseCaughtDao;

/**
 * DAO implement of DmbcMouseCaught
 * 
 */
@Repository("dmbcMouseCaughtDao")
public class DmbcMouseCaughtDaoImpl extends AbstractDao<DmbcMouseCaught, Long> implements IDmbcMouseCaughtDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<DmbcMouseCaught> searchMouseList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select rownum num, id, monitor_id, mouse_species, site, environment, gender, body_length, remarks, weight, create_time, create_by, update_time, update_by, is_delete  from DMBC_MOUSE_CAUGHT t ");
		SqlBuilder.buildWhereStatement(DmbcMouseCaught.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}