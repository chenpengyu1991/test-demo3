package com.founder.rhip.ehr.repository.clinic;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;

/**
 * DAO implement of EhrIndex
 * 
 */
@Repository("ehrHealthEventDao")
public class EHRHealthEventDaoImpl extends AbstractDao<EHRHealthEvent, Long> implements IEHRHealthEventDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Override
    public List<String> getRelationOrganCodes(Long personId){
    	MapSqlParameterSource parameterSource=new MapSqlParameterSource();
    	parameterSource.addValue("personId", personId);
    	String sql="SELECT CLINIC_ORGAN_CODE FROM EHR_HEALTH_EVENT WHERE PERSON_ID=:personId GROUP BY CLINIC_ORGAN_CODE";
    	List<String> result=simpleJdbcTemplate.getNamedParameterJdbcOperations().queryForList(sql, parameterSource, String.class);
    	if(ObjectUtil.isNullOrEmpty(result)) {
    		return Collections.emptyList();
    	}
    	
    	return result;
    }

	@Override
	public Long getHealthEventId(Long personId) {
		if (ObjectUtil.isNullOrEmpty(personId)) {
			return null;
		}
		StringBuilder sqlBuilder = new StringBuilder("SELECT ID  FROM EHR_HEALTH_EVENT WHERE TO_CHAR(CREATE_DATE,'YYYY')='");
		sqlBuilder.append(DateUtil.getCurrentYear());
		sqlBuilder.append("' AND PERSON_ID=");
		sqlBuilder.append(personId);
		sqlBuilder.append(" AND EHR_TYPE='");
		sqlBuilder.append(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
		sqlBuilder.append("'");
		List<Map<String, Object>> list = this.getMapList(sqlBuilder.toString(), (Criteria) null);
		if (ObjectUtil.isNullOrEmpty(list)) {
			return null;
		}
    	Long id = Long.valueOf(String.valueOf(list.get(0).get("ID")));
    	return id;
	}

	@Override
	public Integer getCountBy(Criteria criteria){
		StringBuilder sql = new StringBuilder("select count(*) count from DHS_TRAUMA_HISTORY DTH");
		sql.append(" INNER JOIN EHR_HEALTH_EVENT EHE ON DTH.EHR_ID = EHE.EHR_ID ");
		SqlBuilder.buildWhereStatement(EHRHealthEvent.class, sql, criteria);

		Map<String,Object> map = this.getMap(sql.toString(), criteria);

		Integer count = Integer.parseInt( map.get("count").toString() );
		return count;
	}

	@Override
	public List<Map<String,Object>> getCountByOrgCode(Criteria criteria){
		StringBuilder sql = new StringBuilder("select count(*) count,EHE.CREATE_ORGAN_CODE from DHS_TRAUMA_HISTORY DTH");
		sql.append(" INNER JOIN EHR_HEALTH_EVENT EHE ON DTH.EHR_ID = EHE.EHR_ID ");
		SqlBuilder.buildWhereStatement(EHRHealthEvent.class, sql, criteria);
		sql.append(" GROUP BY EHE.CREATE_ORGAN_CODE ");

		List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
		return mapList;
	}
}