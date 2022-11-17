package com.founder.rhip.ehr.repository.women;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.dto.MaternalHealthManage;
import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * DAO implement of PrenatalFollowup
 * 
 */
@Repository("prenatalFollowupDao")
public class PrenatalFollowupDaoImpl extends AbstractDao<PrenatalFollowup, String> implements IPrenatalFollowupDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String MATERNAL_HEALTH_MANAGE_SQL1 = "SELECT F.CREATE_ORGAN_CODE ORGAN_CODE, " +
			" COUNT(DISTINCT PERSON_ID) LEAVEHOSTWENTYEIGHTDAY, 0 LIVEBIRTHSNUM, 0 THIRTWEEKEXANUM " +
			" FROM WH_POSTNATAL_FOLLOWUP F " +
			" WHERE F.IS_DELETE = 0  %1$s AND F.VISIT_DATE > F.LEAVE_HOSPITAL_DATE " +
			" AND F.VISIT_DATE - F.LEAVE_HOSPITAL_DATE <= 28  GROUP BY F.CREATE_ORGAN_CODE";
			
	private static final String MATERNAL_HEALTH_MANAGE_SQL2 = "SELECT CREATE_ORGAN_CODE ORGAN_CODE, " +
			"0 LEAVEHOSTWENTYEIGHTDAY, SUM(GESTATIONAL_NUMBER) LIVEBIRTHSNUM, 0 THIRTWEEKEXANUM FROM WH_DELIVERY_RECORD_INFO " +
			"WHERE  IS_DELETE = 0  %1$s  GROUP BY CREATE_ORGAN_CODE";
			
	private static final String MATERNAL_HEALTH_MANAGE_SQL3 = "SELECT CREATE_ORGAN_CODE ORGAN_CODE, " +
			"0 LEAVEHOSTWENTYEIGHTDAY, 0 LIVEBIRTHSNUM, COUNT(DISTINCT PERSON_ID) THIRTWEEKEXANUM FROM WH_PRENATAL_FOLLOWUP " +
			" WHERE GESTATIONAL_WEEKS < 14  %1$s  GROUP BY CREATE_ORGAN_CODE";
			
	@Override
	public Long prenatalFollowOver5Count(Criteria criteria) {
		StringBuilder sql = new StringBuilder("SELECT SUM(CASE WHEN COUNT (ID) >=5 THEN 1 ELSE 0 END ) FROM WH_PRENATAL_FOLLOWUP ");
		SqlBuilder.buildWhereStatement(PrenatalFollowup.class, sql, criteria);
		sql.append(" GROUP BY PERSON_ID ");
		Long count = this.getSingle(sql.toString(), criteria, Long.class);
		return count;
	}
	
	@Override
	public Map<String, Object> getOrganMapCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT " +
				" CREATE_ORGAN_CODE as organCode,COUNT(1) as count" +
				" FROM " +
				" WH_PRENATAL_FOLLOWUP ");
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
	public List<Map<String, Object>> getPrenataFollowupMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder(" select t.create_organ_code organCode,to_char(t.input_date,'yyyy/MM/dd') rpDate, count(1) prenatalCheckNum from wh_prenatal_followup t where to_char(t.gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by t.create_organ_code,to_char(t.input_date,'yyyy/MM/dd')");
		return getMapList(sqlBuilder.toString(), new Criteria());
	}

	public Integer getPrenataFollNum(Integer year,Integer quarter,String orgCode){
		int month = 1;
		if(quarter != 0){
			if(quarter == 1){
				month = 1;
			}else if(quarter == 2){
				month = 4;
			}else if(quarter == 3){
				month = 7;
			}else if(quarter == 4){
				month = 10;
			}
		}
		int nextYear = year+1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(*) from WH_PRENATAL_FOLLOWUP where GESTATIONAL_WEEKS < 14");
		stringBuilder.append(" and CREATE_ORGAN_CODE ='"+orgCode+"'");
		if(quarter == 0){
			stringBuilder.append(" and VISIT_DATE >=to_date('"+year+"0101','yyyymmdd') and VISIT_DATE < to_date('"+nextYear+"0101','yyyymmdd')");
		}else {
			int nextMonth = month +3;
			if(quarter == 4){
				stringBuilder.append(" and VISIT_DATE >=to_date('" + year + "" + month + "01','yyyymmdd') and VISIT_DATE < to_date('" + nextYear + "0101','yyyymmdd')");
			}else if(quarter == 3){
				stringBuilder.append(" and VISIT_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and VISIT_DATE < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
			}else {
				stringBuilder.append(" and VISIT_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and VISIT_DATE < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
			}
		}
		SqlBuilder.buildWhereStatement(PrenatalFollowup.class, stringBuilder, new Criteria());
		Long count = this.getSingle(stringBuilder.toString(), new Criteria(), Long.class);
		return Integer.parseInt(count.toString());
	}

	@Override
	public List<MaternalHealthManage> getMaternalHealthManage(Integer year, Integer quarter, List<String> organCodeList) {
		StringBuilder finalSql = new StringBuilder();
		Map<String, Object> map;
		
		map = SqlBuilder.buildOrganCondition("f.CREATE_ORGAN_CODE", "f.VISIT_DATE", null, null, null, year+"", quarter+"", organCodeList,new MapSqlParameterSource(), 1);
		String sql1 = String.format(MATERNAL_HEALTH_MANAGE_SQL1, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE", "DELIVERY_DATE", null, null, null, year+"", quarter+"", organCodeList, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String sql2 = String.format(MATERNAL_HEALTH_MANAGE_SQL2, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE", "VISIT_DATE", null, null, null, year+"", quarter+"", organCodeList, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String sql3 = String.format(MATERNAL_HEALTH_MANAGE_SQL3, map.get(SqlBuilder.WHERE));

		map = SqlBuilder.buildOrganCondition("V.ORGAN_CODE",null, null, null, null, null, null, organCodeList, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 0);
		
		buildSql(finalSql, sql1, sql2, sql3);
		
		return getList(MaternalHealthManage.class, String.format(finalSql.toString(), map.get(SqlBuilder.WHERE)), (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

	private void buildSql(StringBuilder finalSql, String sql1, String sql2, String sql3) {
		finalSql.append("SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE," +
				" NVL(LIVE_BIRTHS_NUM, 0) LIVE_BIRTHS_NUM, NVL(THIRTWEEKEXANUM, 0) THIRTWEEKEXANUM," +
				" NVL(LEAVEHOS_TWENTYEIGHT_DAY, 0) LEAVEHOS_TWENTYEIGHT_DAY" +
				" FROM SY_PHBDB_MDM_ORGANIZATION V LEFT JOIN (")
				
		.append(" select ORGAN_CODE, NVL(SUM(LIVEBIRTHSNUM), 0) LIVE_BIRTHS_NUM, " +
						" NVL(SUM(THIRTWEEKEXANUM), 0) THIRTWEEKEXANUM , " +
						" NVL(SUM(LEAVEHOSTWENTYEIGHTDAY), 0) LEAVEHOS_TWENTYEIGHT_DAY" +
						" FROM ( ")
				.append(sql1)
				.append(" UNION ALL ")
				.append(sql2)
				.append(" UNION ALL ")
				.append(sql3)
				.append(") GROUP BY ORGAN_CODE) T ON V.ORGAN_CODE=T.ORGAN_CODE WHERE 1=1 %s ORDER BY V.ORGAN_CODE,V.ORGAN_NAME");
	}


	@Override
	public void updateOrganByVillage(String createOrganCode, String createOrganName, String[] newAddVillageCodes,String tableName) {
		String sql = "UPDATE "+tableName+" ech SET ech.CREATE_ORGAN_CODE = :createOrganCode,ech.CREATE_ORGAN_NAME=:createOrganName WHERE EXISTS ( SELECT 1 FROM WOMEN_CHILD_HEALTH w WHERE w.PERSON_ID = ech.PERSON_ID AND w.PASTREET IN (:villages))";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("villages", Arrays.asList(newAddVillageCodes));
		parameterSource.addValue("createOrganCode", createOrganCode);
		parameterSource.addValue("createOrganName", createOrganName);
		simpleJdbcTemplate.update(sql, parameterSource);
	}
}