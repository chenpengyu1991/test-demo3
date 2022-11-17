package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 糖尿病随访
 * 
 * @author liuk
 */
@Repository("dmDiabeticFollowupDao")
public class DmDiabeticFollowupDaoImpl extends AbstractDao<DmDiabeticFollowup, Long> implements IDmDiabeticFollowupDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<DmDiabeticFollowup> getUnDeList(Criteria criteria) {
		criteria.add(getHmCardDeleteStatus("DM_DISEASE_INFO.", EHRConstants.DM_MANAGED_FLAG));
		StringBuilder sql = new StringBuilder("SELECT DM_DIABETIC_FOLLOWUP.* FROM DM_DIABETIC_FOLLOWUP LEFT JOIN DM_DISEASE_INFO ON DM_DIABETIC_FOLLOWUP.PERSON_ID=DM_DISEASE_INFO.PERSON_ID ");
		SqlBuilder.buildWhereStatement(DmDiabeticFollowup.class, sql, criteria);
		return getList(sql.toString(), criteria);
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

	@Override
	public DmDiabeticFollowup getLastFollowup(Long personId) {
		String sql = "SELECT A .* FROM (SELECT * FROM DM_DIABETIC_FOLLOWUP  WHERE PERSON_ID=:personId ORDER BY CREATE_DATE DESC)A WHERE ROWNUM=1 ";
        MapSqlParameterSource parameterSource= new MapSqlParameterSource("personId", personId);
        return get(DmDiabeticFollowup.class, sql, parameterSource);
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
				"    count(*) hj_num from DM_DIABETIC_FOLLOWUP");
		SqlBuilder.buildWhereStatement(DmHypertensionFollowup.class, sql, criteria);
		return this.getMap(sql.toString(), criteria);
	}
}
