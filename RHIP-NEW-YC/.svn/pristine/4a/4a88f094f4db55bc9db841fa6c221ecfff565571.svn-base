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
import com.founder.rhip.ehr.repository.oh.IOhEquipmentDao;

@Repository("ohEquipmentDao")
public class OhEquipmentDaoImpl extends
		AbstractDao<OhEquipment, Integer> implements IOhEquipmentDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<OhEquipment> searchEquipmentList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id,seq_no, enterprise_info_id, workshop_name, equipment_name, model,powerl, count, ");
		sql.append("create_time, create_by, update_time, update_by, is_delete from OH_EQUIPMENT t");
		SqlBuilder
				.buildWhereStatement(OhEquipment.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}



}
