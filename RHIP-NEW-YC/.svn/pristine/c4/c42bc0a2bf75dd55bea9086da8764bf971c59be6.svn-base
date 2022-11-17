package com.founder.rhip.ehr.repository.clinic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;

import javax.annotation.Resource;

/**
 * DAO implement of 医疗活动（不包含传染病）
 * 
 */
@Repository("ehrHealthEventQueryDao")
public class EhrHealthEventQueryDaoImpl extends	AbstractDao<EHRHealthEvent, Long> implements IEHRHealthEventQueryDao {

    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	/**
	 * 查询检查检验，不包括传染病
	 */
	private static final String SQL_WITHOUT_INFECTIOUS = "  EVENT WHERE NOT EXISTS"
			+ " (SELECT 1 FROM SY_RMSDB_MS_DIS_DIA_INFO INFO WHERE EVENT.EHR_ID = INFO.EHR_ID AND EVENT.PERSON_ID = INFO.PERSON_ID "
			+ " AND (UPPER(INFO.DIAGNOSIS_CODE) LIKE 'A%' OR UPPER(INFO.DIAGNOSIS_CODE) LIKE 'B%')) ";
	
	
	private StringBuilder buildSql(Criteria criteria, Order order,String... properties) {
		StringBuilder sql = SqlBuilder.createSelectStringNoWhere(EHRHealthEvent.class, getTable(EHRHealthEvent.class), properties);
		sql.append(SQL_WITHOUT_INFECTIOUS);
		StringBuilder whereBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(EHRHealthEvent.class, whereBuilder, criteria);
		String where = whereBuilder.toString().replaceFirst("WHERE|where", "AND");
		sql.append(where);
		sql.append(" ");
		if (null!=order) {
			sql.append(order.toString());
		}
		return sql;
	}
	
	@Override
	public PageList<EHRHealthEvent> getPageListNoInfectious(Page page, Criteria criteria, Order order, String... properties) {
		StringBuilder sql = buildSql(criteria, order,properties);
		return getPageList(page, sql.toString(), criteria);	
	}

}