package com.founder.rhip.ehr.repository.ihm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;

@Repository("vaccinationTargetDao")
public class VaccinationTargetDaoImpl extends AbstractDao<VaccinationMgmt, Long> implements IVaccinationTargetDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String SIDE_EFFECT_SQL = "SELECT dse.id, " +
			"  dvm.name, " +
			"  dvm.idcard, " +
			"  dvm.father_idcard, " +
			"  dvm.father_name, " +
			"  dvm.mother_idcard, " +
			"  dvm.mother_name, " +
			"  dvm.vaccination_code, " +
			"  dse.SIDE_REACTION_DATE  as create_card_date , " +
			"  dse.SEQU_NAME, " +
			"  dse.vaccination_organcode as unit_name, " +
			"  dse.VACCINE_NAME, " +
			"  dse.SIDE_REACTION_DATE, " +
			"  dse.vaccination_organname " +
			"FROM DC_CHILDREN_SIDE_EFFECT dse " +
			"LEFT JOIN DC_VACCINATION_MGMT dvm " +
			"ON dse.vaccination_code = dvm.vaccination_code";
	
	private static final String TABOO_SQL = "SELECT dct.id, " +
			"  dvm.name, " +
			"  dvm.idcard, " +
			"  dvm.father_idcard, " +
			"  dvm.father_name, " +
			"  dvm.mother_idcard, " +
			"  dvm.mother_name, " +
			"  dvm.vaccination_code, " +
			"  dct.vaccination_organcode as unit_name, " +
			"  dct.vaccination_organname, " +
			"  dct.INPUT_DATE  as create_card_date , " +
			"  dct.tabu_name " +
			"FROM DC_CHILDREN_TABOO dct " +
			"LEFT JOIN DC_VACCINATION_MGMT dvm " +
			"ON dct.vaccination_code = dvm.vaccination_code";
	
	public PageList<Map<String, Object>> getSideEffectlist(Page page, Criteria criteria)
	{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(VaccinationMgmt.class, sqlBuilder, criteria);
		
		String lastSql = "select * from (" + SIDE_EFFECT_SQL + ") " + sqlBuilder;
		return this.getPageMapList(page, lastSql, criteria);
	}
	
	public Object getSideEffect(String id)
	{
		Criteria criteria = new Criteria();
		String lastSql = "select * from (" + SIDE_EFFECT_SQL + ") where id = '" + id + "'";
		return this.getMap(lastSql, criteria);
	}
	
	public PageList<Map<String, Object>> getTaboolist(Page page, Criteria criteria)
	{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(VaccinationMgmt.class, sqlBuilder, criteria);
		
		String lastSql = "select * from (" + TABOO_SQL + ") " + sqlBuilder;
		return this.getPageMapList(page, lastSql, criteria);
	}
	
	public Object getTaboo(String id)
	{
		Criteria criteria = new Criteria();
		String lastSql = "select * from (" + TABOO_SQL + ") where id = '" + id + "'";
		return this.getMap(lastSql, criteria);
	}
	
}