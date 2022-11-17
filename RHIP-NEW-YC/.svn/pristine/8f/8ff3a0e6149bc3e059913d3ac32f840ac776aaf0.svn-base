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
import com.founder.rhip.ehr.entity.control.oh.OhContactSituation;
import com.founder.rhip.ehr.repository.oh.IOhContactSituationDao;

@Repository("ohContactSituationDao")
public class OhContactSituationDaoImpl extends
		AbstractDao<OhContactSituation, Integer> implements IOhContactSituationDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<OhContactSituation> searchContactSituationList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, enterprise_info_id, workshop_name, position, hazard_factors_name, man_num,PROTECTIVE_MEASURES,DAY_CONTACT_TIME, ");
		sql.append("woman_num, safeguard_procedures, create_time, create_by, update_time, update_by, is_delete from OH_CONTACT_SITUATION t");
		SqlBuilder
				.buildWhereStatement(OhContactSituation.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public Boolean saveContactSituation(OhContactSituation contactSituation) {
		return null;
	}

}
