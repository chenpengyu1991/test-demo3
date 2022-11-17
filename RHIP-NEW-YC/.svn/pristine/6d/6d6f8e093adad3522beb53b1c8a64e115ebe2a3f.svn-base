package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Disease;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("mdmDiseaseDao")
public class DiseaseDao extends MDMRepository<Disease, Long> implements IDiseaseDao {

	protected static final String TABLE_DISEASE = "MDM_DISEASE";

	protected static final String TABLE_DISEASE_LOG = "MDM_DISEASE_LOG";

	@Override
	public PageList<Disease> getLogList(Page page, Long diseaseId, String... properties) {
		String fields = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(fields).append(" FROM ").append(TABLE_DISEASE).append(" WHERE DISEASE_ID = ").append(diseaseId).append(" UNION ").append("SELECT ").append(fields)
				.append(" FROM ").append(TABLE_DISEASE_LOG).append(" WHERE DISEASE_ID = ").append(diseaseId).append(" ORDER BY OPERATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}

	@Override
	public void insertLog(Criteria criteria) {
		insertLogRecord(TABLE_DISEASE_LOG, criteria);
	}

	@Override
	public void deleteLog(Criteria criteria) {
		setTableName(TABLE_DISEASE_LOG);
		delete(criteria);
		setTableName(TABLE_DISEASE);
	}

	@Override
	public Long getDiseaseVersion() {
		final String sql = "SELECT VERSION FROM MDM_VERSION WHERE CODE='DISEASE'";
		Long version = getSingle(sql, null, Long.class);
		return version;
	}

	@Override
	public void publishDiseaseVersion() {
		final String sql = "UPDATE MDM_VERSION SET VERSION=(VERSION+1) WHERE CODE='DISEASE'";
		execute(sql);
	}

	@Override
	public List<Disease> getDiseasesByCategoryRange(String startCategory, String endCategory) {
		String sql = "SELECT * FROM MDM_DISEASE  WHERE STATUS=:status AND  SUBSTR(ICD10MAIN, 0, 3) >=:startCategory and SUBSTR(ICD10MAIN, 0, 3) <=:endCategory ";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("startCategory", startCategory);
		parameterSource.addValue("endCategory", endCategory);
		parameterSource.addValue("status", StatusValue.normalValue.getValue());
		List<Disease> diseases = getList(Disease.class, sql, parameterSource);
		if (null == diseases) {
			diseases = Collections.emptyList();
		}
		return diseases;
	}

}
