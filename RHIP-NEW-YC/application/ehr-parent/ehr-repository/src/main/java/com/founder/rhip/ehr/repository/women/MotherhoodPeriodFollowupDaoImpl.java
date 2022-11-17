package com.founder.rhip.ehr.repository.women;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;

/**
 * DAO implement of MotherhoodPeriodFollowup
 * 
 */
@Repository("motherhoodPeriodFollowupDao")
public class MotherhoodPeriodFollowupDaoImpl extends AbstractDao<MotherhoodPeriodFollowup, String> implements IMotherhoodPeriodFollowupDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String MOTHERHOOD_PERIOD_FOLLOWUP_STATISTICS_SQL = "select create_organ_code organCode,check_idcard doctorIdcard,max(check_name)doctorName,"
			+ " check_job_number doctorCode,to_char(check_date, 'yyyy/MM/dd')rpDate,count(1) pregnantWomenNum "
			+ " from wh_motherhood_period_followup %1$s group by create_organ_code,check_idcard,check_job_number,to_char(check_date, 'yyyy/MM/dd')";

	@Override
	public Long getEarlyResponse(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT " +
				" COUNT(DISTINCT PERSON_ID) " +
				" FROM " +
				" WH_MOTHERHOOD_PERIOD_FOLLOWUP ");
		SqlBuilder.buildWhereStatement(MotherhoodPeriodFollowup.class, sql, criteria);
		Long count = this.getSingle(sql.toString(), criteria, Long.class);
		return count;
	}

	@Override
	public Map<String, Object> getOrganMapCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT " +
				" CREATE_ORGAN_CODE as organCode,COUNT(1) as count" +
				" FROM " +
				" WH_MOTHERHOOD_PERIOD_FOLLOWUP ");
		SqlBuilder.buildWhereStatement(MotherhoodPeriodFollowup.class, sql, criteria);
		sql.append(" GROUP BY CREATE_ORGAN_CODE");
		List<Map<String, Object>> maplist = this.getMapList(sql.toString(), criteria);
	    Map<String, Object> resultMap = new HashMap<String, Object>();
	    for(Map<String, Object> map : maplist){
	    	resultMap.put((String)map.get("organCode"), ((BigDecimal)map.get("count")).intValue());
	    }
	    return resultMap;
	}

	@Override
	public List<Map<String, Object>> getMotherhoodPeriodFollowupMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder(" select t.create_organ_code organCode,to_char(t.CHECK_DATE,'yyyy/MM/dd') dt, count(1) maternal_registration_num from wh_motherhood_period_followup t where to_char(t.gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by t.create_organ_code,to_char(t.CHECK_DATE,'yyyy/MM/dd')");
		return getMapList(sqlBuilder.toString(), new Criteria());
	}

	@Override
	public List<Map<String, Object>> getMotherhoodPeriodFollowupWorkloadMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder conditionSQL = new StringBuilder(" where to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(MOTHERHOOD_PERIOD_FOLLOWUP_STATISTICS_SQL, conditionSQL.toString());
		return getMapList(sql, new Criteria());
	}
}