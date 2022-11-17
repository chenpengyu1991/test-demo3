package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.entity.management.DmStrtumFollowup;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 冠心病脑卒中随访
 * 
 * @author liuk
 */
@Repository("dmStrtumFollowupDao")
public class DmStrtumFollowupDaoImpl extends AbstractDao<DmStrtumFollowup, Long> implements IDmStrtumFollowupDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<DmStrtumFollowup> getUnDeList(Criteria criteria) {
		criteria.add(getHmCardDeleteStatus("DM_DISEASE_INFO.", EHRConstants.DM_MANAGED_FLAG));
		StringBuilder sql = new StringBuilder("SELECT DM_STRTUM_FOLLOWUP.* FROM DM_STRTUM_FOLLOWUP LEFT JOIN DM_DISEASE_INFO ON DM_STRTUM_FOLLOWUP.PERSON_ID=DM_DISEASE_INFO.PERSON_ID ");
		SqlBuilder.buildWhereStatement(DmStrtumFollowup.class, sql, criteria);
		return getList(sql.toString(), criteria);
	}

	@Override
	public DmStrtumFollowup getLastStrokeFollowup(Long personId) {
		String sql = "SELECT A .* FROM (SELECT * FROM DM_STRTUM_FOLLOWUP  WHERE  DISEASE_TYPE =:diseaseType AND PERSON_ID=:personId  ORDER BY CREATE_DATE DESC)A WHERE ROWNUM=1";
        MapSqlParameterSource parameterSource= new MapSqlParameterSource("diseaseType", EHRConstants.DM_STROKE_TYPE);
        parameterSource.addValue("personId",personId);
        return get(DmStrtumFollowup.class, sql, parameterSource);
	}

	@Override
	public DmStrtumFollowup getLastCoronaryFollowup(Long personId) {
		String sql = "SELECT A .* FROM (SELECT * FROM DM_STRTUM_FOLLOWUP  WHERE  DISEASE_TYPE =:diseaseType AND PERSON_ID=:personId  ORDER BY CREATE_DATE DESC)A WHERE ROWNUM=1 ";
        MapSqlParameterSource parameterSource= new MapSqlParameterSource("diseaseType", EHRConstants.DM_CORONARY_TYPE);
        parameterSource.addValue("personId",personId);
        return get(DmStrtumFollowup.class, sql,parameterSource);
	}

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	@Override
	public Map<String, Object> getNumGroupByVisitWayCode(Criteria criteria) {
		StringBuilder sql = new StringBuilder("select nvl(sum(case when VISIT_WAY_CODE = '1' then 1 else 0 end), 0) mz_num,\n" +
				"    nvl(sum(case when VISIT_WAY_CODE = '2' then 1 else 0 end), 0) sm_num,\n" +
				"    nvl(sum(case when VISIT_WAY_CODE = '3' then 1 else 0 end), 0) dh_num,\n" +
				"    nvl(sum(case when VISIT_WAY_CODE = '4' then 1 else 0 end), 0) jz_num,\n" +
				"    count(*) hj_num from DM_STRTUM_FOLLOWUP");
		SqlBuilder.buildWhereStatement(DmHypertensionFollowup.class, sql, criteria);
		return this.getMap(sql.toString(), criteria);
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add(alias + "hbp_flag", isDelete);
		criteria.add(LOP.OR, alias + "di_flag", isDelete);
		criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
		criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
		criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
		return criteria;
	}
}
