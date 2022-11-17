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
import com.founder.rhip.ehr.repository.oh.IOhChemicalsUsedDao;

@Repository("ohChemicalsUsedDao")
public class OhChemicalsUsedDaoImpl extends
		AbstractDao<OhChemicalsUsed, Integer> implements IOhChemicalsUsedDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<OhChemicalsUsed> searchChemicalsUsedList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, enterprise_info_id, workshop_name, chemical_name, source, ");
		sql.append("harvest_usage_amount, create_time, create_by, update_time, update_by, is_delete from OH_CHEMICALS_USED t");
		SqlBuilder
				.buildWhereStatement(OhChemicalsUsed.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public Boolean saveChemicalsUsed(OhChemicalsUsed chemicalsUsed) {	
		return  this.insert(chemicalsUsed)>0?true:false;
	}


}
