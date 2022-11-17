package com.founder.rhip.ehr.repository.pbusiness.dmbc;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcSewageTreatment;
import com.founder.rhip.ehr.repository.dmbc.IDmbcSewageTreatmentDao;

/**
 * DAO implement of DmbcSewageTreatment
 * 
 */
@Repository("dmbcSewageTreatmentDao")
public class DmbcSewageTreatmentDaoImpl extends AbstractDao<DmbcSewageTreatment, Long> implements IDmbcSewageTreatmentDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public PageList<DmbcSewageTreatment> searchSewageTreatment(Criteria criteria,
			Page page){
		StringBuilder sql = new StringBuilder();
		sql.append("select id,  org_name,  original_pool_length,  original_pool_width,  original_pool_height,  reaction_tank_length,  reaction_tank_width,  reaction_tank_height,  avg_daily_output,  processing_period,  disinfection_treatment,  disinfectant_name,  effective_constituent,  dis_usage_amount,  production_unit,  dis_production_permit,  material_name,  mat_usage_amount,  source,  mat_production_permit,  assigner_dept,  gender,  age,  education,  years,  train_num,  colorimetric_eq,  colorimetric_reagent,  keep_dark,  change_time,  account_record,  suggest,  pic_url,  min_url,  create_time,  create_by,  update_time,  update_by,  is_delete from DMBC_SEWAGE_TREATMENT t ");
		SqlBuilder.buildWhereStatement(DmbcSewageTreatment.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}
}