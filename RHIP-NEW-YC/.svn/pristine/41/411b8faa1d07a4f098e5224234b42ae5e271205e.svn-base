package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.oh.OhCondition;
import com.founder.rhip.ehr.repository.oh.IOhConditionDao;

@Repository("ohConditionDao")
public class OhConditionDaoImpl extends AbstractDao<OhCondition, Integer>
		implements IOhConditionDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<OhCondition> searchConditionList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, enterprise_info_id, employee_num, workingwoman_num, worker_num,");
		sql.append("dust_num, poison_num, physical_factor_num, other_num, create_time, create_by, ");
		sql.append("update_time, update_by, is_delete from OH_CONDITION t");
		SqlBuilder.buildWhereStatement(OhCondition.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public Boolean saveCondition(OhCondition condition) {
		int rs = this.insert(condition);
		if (rs > 0)
			return true;
		else
			return false;
	}

}
