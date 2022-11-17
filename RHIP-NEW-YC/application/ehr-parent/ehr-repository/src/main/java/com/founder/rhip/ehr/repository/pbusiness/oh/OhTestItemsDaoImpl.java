package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.oh.OhChemicalsUsed;
import com.founder.rhip.ehr.entity.control.oh.OhEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhTestItems;
import com.founder.rhip.ehr.repository.oh.IOhTestItemsDao;

@Repository("ohTestItemsDao")
public class OhTestItemsDaoImpl extends
		AbstractDao<OhTestItems, Integer> implements IOhTestItemsDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<OhTestItems> searchTestItemsList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, enterprise_info_id, title, mini_url, workshop_name, draw_date, code,");
		sql.append("position, test_item, explain, create_time, create_by, update_time, update_by, is_delete from OH_TEST_ITEMS t");
		SqlBuilder
				.buildWhereStatement(OhTestItems.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}



}
