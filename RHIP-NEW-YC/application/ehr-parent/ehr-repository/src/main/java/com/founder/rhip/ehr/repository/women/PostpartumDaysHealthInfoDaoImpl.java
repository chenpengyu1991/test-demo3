package com.founder.rhip.ehr.repository.women;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;
import com.founder.rhip.ehr.entity.women.PostpartumDaysHealthInfo;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;

/**
 * DAO implement of PostpartumDaysHealthInfo
 * 
 */
@Repository("postpartumDaysHealthInfoDao")
public class PostpartumDaysHealthInfoDaoImpl extends AbstractDao<PostpartumDaysHealthInfo, String> implements IPostpartumDaysHealthInfoDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public Long postpartumDaysCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT COUNT(DISTINCT PERSON_ID) FROM WH_POSTPARTUM_DAYS_HEALTH_INFO ");
		SqlBuilder.buildWhereStatement(PrenatalFollowup.class, sql, criteria);
		Long count = this.getSingle(sql.toString(), criteria, Long.class);
		return count;
	}

	@Override
	public Map<String, Object> getOrganMapCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT " +
				" CREATE_ORGAN_CODE as organCode,COUNT(1) as count" +
				" FROM " +
				" WH_POSTPARTUM_DAYS_HEALTH_INFO ");
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
	public List<Map<String, Object>> getPostpartumDaysHealthInfoMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder(
				" select t.create_organ_code organCode,to_char(t.supervision_date,'yyyy/MM/dd') rpDate,"
				+ " count(1) health_examination_num from wh_postpartum_days_health_info t where to_char(t.gather_date,'yyyy/MM/dd')='")
				.append(dateStr)
				.append("' group by t.create_organ_code,to_char(t.supervision_date,'yyyy/MM/dd')");
		return getMapList(sqlBuilder.toString(), new Criteria());

	}
}