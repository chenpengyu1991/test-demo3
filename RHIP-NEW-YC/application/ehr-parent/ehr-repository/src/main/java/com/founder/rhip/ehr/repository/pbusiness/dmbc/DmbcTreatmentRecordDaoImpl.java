package com.founder.rhip.ehr.repository.pbusiness.dmbc;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcTreatmentRecord;
import com.founder.rhip.ehr.repository.dmbc.IDmbcTreatmentRecordDao;

/**
 * DAO implement of DmbcTreatmentRecord
 * 
 */
@Repository("dmbcTreatmentRecordDao")
public class DmbcTreatmentRecordDaoImpl extends
		AbstractDao<DmbcTreatmentRecord, Long> implements
		IDmbcTreatmentRecordDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public PageList<DmbcTreatmentRecord> searchTreatmentRecord(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id,  sewage_treatment_id,  treatment_date,  treatment_quantity,  dosing_quantity,  treatment_time,  residual_chlorine_val,  assigner,  create_time,  create_by,  update_time,  update_by,  is_delete from DMBC_TREATMENT_RECORD t ");
		SqlBuilder.buildWhereStatement(DmbcTreatmentRecord.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}