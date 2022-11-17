package com.founder.rhip.ehr.repository.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.HealthRecordCensus;

@Repository("healthRecordCensusDao")
public class HealthRecordCensusDaoImpl extends AbstractDao<HealthRecordCensus, Long> implements IHealthRecordCensusDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";
	
			
	private static final String HR_CENSUS_SQL1 = "SELECT ORGAN_CODE ORG_CODE, SUM(NVL(HOUSEHOLD_NUM, 0) + NVL(UN_HOUSE_HOLD_NUM, 0)) PERMANENT_NUM," +
			"0 BUILD_RECORD_NUM, 0 BUILD_E_RECORD_NUM, 0 DYNAMIC_RECORD_NUM " +
			" FROM BI_POPULACE WHERE 1=1 %s GROUP BY ORGAN_CODE";
	
	private static final String HR_CENSUS_SQL2 = "SELECT CREATE_ORGAN_CODE ORG_CODE, 0 PERMANENT_NUM, 0 BUILD_RECORD_NUM, COUNT(1) BUILD_E_RECORD_NUM, 0 DYNAMIC_RECORD_NUM " +
			" FROM BI_PERSON_INFO WHERE FILING_FLAG = 1 AND (STAR>=2 OR (STAR = 1 AND IDCARD IS NOT NULL AND ((LENGTH(IDCARD) = 18 AND(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) - TO_NUMBER(SUBSTR(IDCARD, 7, 4)))<=6) OR\n" +
			"(LENGTH(IDCARD) = 15 AND  (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) - TO_NUMBER('19' || SUBSTR(IDCARD, 7, 2)))<=6)))) %s GROUP BY CREATE_ORGAN_CODE ";
	
	private static final String HR_CENSUS_SQL3 = "SELECT INPUT_ORGAN_CODE ORG_CODE,0 PERMANENT_NUM,0 BUILD_RECORD_NUM,0 BUILD_E_RECORD_NUM,SUM(UPDATE_NUM) DYNAMIC_RECORD_NUM FROM (select input_organ_code, case when (hbp.person_id is not null or di.person_id is not null or tumor.person_id is not null or strum.person_id is not null or event.person_id is not null) then 1 else 0 end UPDATE_NUM " +
			"      FROM BI_PERSON_INFO b left join (select max(hbp.person_id) person_id, to_char(hbp.visit_date, 'YYYY') visit_date from dm_hypertension_followup hbp group by hbp.person_id, to_char(hbp.visit_date, 'YYYY')) hbp on hbp.person_id = b.id and :year = to_number(hbp.visit_date) " +
			"               left join (select max(di.person_id) person_id, to_char(di.visit_date, 'YYYY') visit_date from dm_diabetic_followup di group by di.person_id, to_char(di.visit_date, 'YYYY')) di on di.person_id = b.id and :year = to_number(di.visit_date)\n" +
			"               left join (select max(tumor.person_id) person_id, to_char(tumor.visit_date, 'YYYY') visit_date from dm_tumor_followup tumor group by tumor.person_id, to_char(tumor.visit_date, 'YYYY')) tumor on tumor.person_id = b.id and :year = to_number(tumor.visit_date) " +
			"               left join (select max(strum.person_id) person_id, to_char(strum.visit_date, 'YYYY') visit_date from dm_strtum_followup strum group by strum.person_id, to_char(strum.visit_date, 'YYYY')) strum on strum.person_id = b.id and :year = to_number(strum.visit_date) " +
			"               left join (select max(event.person_id) person_id, to_char(clinic_date, 'YYYY') clinic_date from sy_ehr_health_event event where ehr_type NOT IN ('A00000001', 'A00000002') group by event.person_id, to_char(clinic_date, 'YYYY')) event on event.person_id = b.id and :year = to_number(event.clinic_date) " +
			"      WHERE FILING_FLAG = 1 AND STAR >= 2 AND b.ID IN (SELECT PERSON_ID FROM bi_modify_trace) %s ) GROUP BY INPUT_ORGAN_CODE";

	private static final String HR_CENSUS_SQL4 = "SELECT ORG_CODE, 0 PERMANENT_NUM, BUILD_RECORD_NUM, 0 BUILD_E_RECORD_NUM, 0 DYNAMIC_RECORD_NUM FROM  ( SELECT ORG_CODE, BUILD_RECORD_NUM, ROW_NUMBER() OVER(PARTITION BY ORG_CODE ORDER BY QUARTER DESC) GROUPSEQ FROM BI_BUILDRECORD WHERE BUILD_RECORD_NUM > 0 %s ) T WHERE T.GROUPSEQ = '1'";
	
	private static final String SELECT_SQL ="SELECT ID,ORG_CODE,BUILD_RECORD_NUM, QUARTER FROM ( SELECT ID, ORG_CODE, BUILD_RECORD_NUM,QUARTER, ROW_NUMBER() OVER(PARTITION BY ORG_CODE ORDER BY QUARTER DESC) GROUPSEQ FROM BI_BUILDRECORD WHERE BUILD_RECORD_NUM > 0 %s ) T WHERE T.GROUPSEQ = '1'";
	
	private void builDSSql(Criteria criteria, StringBuilder finalSql, List<String> list) {
		StringBuilder sqlb = new StringBuilder();
		for(String sql :list){
			if(sqlb.length()==0){
				sqlb.append("(").append(sql);
			}else{
				sqlb.append(" UNION ALL ").append(sql);
			}
		}
		sqlb.append(")");
			
		finalSql.append("SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE ORG_CODE," +
				"NVL(PERMANENT_NUM, 0) PERMANENT_NUM,NVL(BUILD_RECORD_NUM, 0) BUILD_RECORD_NUM," +
				"NVL(BUILD_E_RECORD_NUM, 0) BUILD_E_RECORD_NUM,NVL(DYNAMIC_RECORD_NUM, 0) DYNAMIC_RECORD_NUM" +
				" FROM mdm_organization V LEFT JOIN (")
		.append("SELECT ORG_CODE,")
		.append(" NVL(SUM(PERMANENT_NUM), 0) PERMANENT_NUM, " +
				" NVL(SUM(BUILD_RECORD_NUM), 0) BUILD_RECORD_NUM, " +
				" NVL(SUM(BUILD_E_RECORD_NUM), 0) BUILD_E_RECORD_NUM, " +
				" NVL(SUM(DYNAMIC_RECORD_NUM),0) DYNAMIC_RECORD_NUM " +
				" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE ) T ON V.ORGAN_CODE=T.ORG_CODE WHERE 1=1 %s ORDER BY V.GENRE_CODE,V.ORGAN_NAME");
	}
	
	@Override
	public List<HealthRecordCensus> getHealthRecordCensusList(Criteria criteria,
			List<String> organCodeList) {
		
		String orgCode = (String)criteria.get("orgCode");
		String quarter = (String) criteria.get("quarter");
		String year = (String)criteria.get("year");
		
		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();
		Map<String, Object> map;
		
		map = SqlBuilder.buildOrganCondition("ORGAN_CODE","COUNT_YEAR", null, null, orgCode, year, null, organCodeList, new MapSqlParameterSource(), 3);
		String sql = String.format(HR_CENSUS_SQL1, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","CREATE_DATE", null, null, orgCode, year, quarter, organCodeList, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 5);
		sql = String.format(HR_CENSUS_SQL2, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("INPUT_ORGAN_CODE","b.UPDATE_DATE", null, null, orgCode, year, quarter, organCodeList, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 1);
		sql = String.format(HR_CENSUS_SQL3, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("ORG_CODE","YEAR", "QUARTER", null, orgCode, year, quarter, organCodeList, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 4);
		sql = String.format(HR_CENSUS_SQL4, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("V.ORGAN_CODE",null, null, null, orgCode, null, null, organCodeList,(MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 0);
		
		builDSSql(criteria, finalSql, sqlList);
		return getList(HealthRecordCensus.class, String.format(finalSql.toString(), map.get(SqlBuilder.WHERE)), (MapSqlParameterSource)map.get(SqlBuilder.SOURCE));
	}

	@Override
	public HealthRecordCensus getHealthRecordCensus(Criteria criteria) {
		String orgCode=(String)criteria.get("orgCode");
		String quarter= (String) criteria.get("quarter");
		Integer year=(Integer)criteria.get("year");
		
		Map<String, Object> map = SqlBuilder.buildOrganCondition("ORG_CODE","YEAR", "QUARTER", null, orgCode, year+"", quarter, null, new MapSqlParameterSource(), 4);
		String sql = String.format(SELECT_SQL, map.get(SqlBuilder.WHERE));
		
		List<HealthRecordCensus> list = getList(HealthRecordCensus.class, sql, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE));
		HealthRecordCensus census = null;
		if(ObjectUtil.isNotEmpty(list)){
			census = list.get(0);
			if(census.getQuarter()!=Integer.parseInt(quarter)){
				census.setId(null);
			}
		}
		return census;
	}

	@Override
	public int updateBuildRecord(HealthRecordCensus healthRecord) {
		String sql = "UPDATE BI_BUILDRECORD SET BUILD_RECORD_NUM=:buildRecordNum  WHERE ID=:id ";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("buildRecordNum", healthRecord.getBuildRecordNum());
		parameterSource.addValue("id", healthRecord.getId());
		return simpleJdbcTemplate.update(sql, parameterSource);
	}
	
	@Override
	public int addBuildRecord(HealthRecordCensus healthRecord) {
		String sql = "INSERT INTO BI_BUILDRECORD(ID, ORG_CODE,ORG_NAME,YEAR,QUARTER,CREATEDATE,GB_CODE,BUILD_RECORD_NUM) " +
				"VALUES(:id, :orgCode, :orgName, :year, :quarter, :createdate, :gbCode, :buildRecordNum)";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", UUID.randomUUID().toString());
		parameterSource.addValue("orgCode", healthRecord.getOrgCode());
		parameterSource.addValue("orgName", healthRecord.getOrgName());
		parameterSource.addValue("year", healthRecord.getYear());
		parameterSource.addValue("quarter", healthRecord.getQuarter());
		parameterSource.addValue("gbCode", healthRecord.getGbCode());
		parameterSource.addValue("buildRecordNum", healthRecord.getBuildRecordNum());
		parameterSource.addValue("createdate", new Date());
		return simpleJdbcTemplate.update(sql, parameterSource);
	}
}
