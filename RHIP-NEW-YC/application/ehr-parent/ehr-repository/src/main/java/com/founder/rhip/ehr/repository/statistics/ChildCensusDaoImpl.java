package com.founder.rhip.ehr.repository.statistics;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.ChildCensus;

@Repository("childCensusDao")
public class ChildCensusDaoImpl extends AbstractDao<ChildCensus, Long> implements IChildCensusDao{

	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";
	
	private static final String CHILD_CENSUS_SQL1 = "SELECT FILL_ORGAN_CODE ORGCODE," +
			" COUNT(1) DEATHCOUNT, 0 VISITCOUNT, 0 EXAMINECOUNT1,0 EXAMINECOUNT2," +
			" 0 EXAMINECOUNT6, 0 TCMCOUNT1, 0 TCMCOUNT2, 0 TCMCOUNT6 " +
			" FROM PHBDB.DC_DEATH_MEDICINE_CERTIFICATE WHERE IS_DELETE <> 1 %1$s " +
			" GROUP BY FILL_ORGAN_CODE";
	
	private static final String CHILD_CENSUS_SQL2 = "SELECT CREATE_ORGAN_CODE ORGCODE," +
			" 0 DEATHCOUNT, COUNT(1) VISITCOUNT, 0 EXAMINECOUNT1,0 EXAMINECOUNT2, " +
			" 0 EXAMINECOUNT6, 0 TCMCOUNT1, 0 TCMCOUNT2 , 0 TCMCOUNT6 FROM CH_NEONATAL_FAMILY_VISIT " +
			" WHERE IS_DELETE = 0 %1$s GROUP BY CREATE_ORGAN_CODE";
	
	private static final String CHILD_CENSUS_SQL3 = "SELECT ORGCODE, 0 DEATHCOUNT, " +
			" 0 VISITCOUNT, EXAMINECOUNT1, EXAMINECOUNT2,EXAMINECOUNT6,0 TCMCOUNT1, 0 TCMCOUNT2, 0 TCMCOUNT6" +
			" FROM (SELECT CREATE_ORGAN_CODE ORGCODE, EXAMINE_AGE_GROUP EXAMINEGROUP, " +
			" COUNT(1) AS EXAMINECOUNT FROM CH_CHILD_HEALTH_EXAMINATION " +
			" WHERE (IS_DELETE <> 1 OR IS_DELETE IS NULL) %1$s GROUP BY EXAMINE_AGE_GROUP, " +
			" CREATE_ORGAN_CODE ) PIVOT(SUM(EXAMINECOUNT) FOR EXAMINEGROUP " +
			" IN('1' EXAMINECOUNT1, '2' EXAMINECOUNT2, '6' EXAMINECOUNT6))";
	
	private static final String CHILD_CENSUS_SQL4 = "SELECT ORGCODE, 0 DEATHCOUNT, 0 VISITCOUNT," +
			" 0 EXAMINECOUNT1, 0 EXAMINECOUNT2, 0 EXAMINECOUNT6,  TCMCOUNT1, TCMCOUNT2, TCMCOUNT6" +
			" FROM ( SELECT CREATE_ORGAN_CODE ORGCODE, AGEGROUP, COUNT(DISTINCT PERSON_ID) TCMCOUNT " +
			" FROM ( SELECT CREATE_ORGAN_CODE, PERSON_ID, MIN(EXAMINE_AGE_GROUP) AGEGROUP" +
			" FROM CH_CHILD_HEALTH_EXAMINATION WHERE TCM_HEALTH_MANAGE_SERVICE IS NOT NULL" +
			" AND (IS_DELETE <> 1 OR IS_DELETE IS NULL)  %1$s GROUP BY CREATE_ORGAN_CODE, PERSON_ID) " +
			" GROUP BY CREATE_ORGAN_CODE, AGEGROUP ) " +
			" PIVOT(SUM(TCMCOUNT) FOR AGEGROUP IN('1' TCMCOUNT1, '2' TCMCOUNT2, '6' TCMCOUNT6))";
	
	
   
	@Override
	public List<ChildCensus> getChildCensusList(Criteria criteria, List<String> organCodeList) {
		StringBuilder finalSql = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		StringBuilder where = new StringBuilder();
		
		buildOrganCondition("FILL_ORGAN_CODE", criteria, where, "FILL_TIME", organCodeList, sqlParameterSource);
		String sql1 = String.format(CHILD_CENSUS_SQL1, where.toString());
		
		where = new StringBuilder();
		buildOrganCondition("CREATE_ORGAN_CODE", criteria, where, "CREATE_DATE", organCodeList, sqlParameterSource);
		String sql2 = String.format(CHILD_CENSUS_SQL2, where.toString());
		
		where = new StringBuilder();
		buildOrganCondition("CREATE_ORGAN_CODE", criteria, where, "VISIT_DATE", organCodeList, sqlParameterSource);
		String sql3 = String.format(CHILD_CENSUS_SQL3, where.toString());

		where = new StringBuilder();
		buildOrganCondition("CREATE_ORGAN_CODE", criteria, where, "VISIT_DATE", organCodeList, sqlParameterSource);
		String sql4 = String.format(CHILD_CENSUS_SQL4, where.toString());
		
		buildSql(criteria, finalSql, sql1, sql2, sql3, sql4);
		
		return getList(ChildCensus.class, finalSql.toString(), sqlParameterSource);
	}
	
	private void buildSql(Criteria criteria, StringBuilder finalSql, String sql1, String sql2, String sql3, String sql4 ) {
		finalSql.append("SELECT ORGCODE, ")
				.append(" NVL(SUM(DEATHCOUNT),0) DEATHCOUNT, NVL(SUM(VISITCOUNT),0) VISITCOUNT," +
				" NVL(SUM(EXAMINECOUNT1),0) EXAMINECOUNT1,NVL(SUM(EXAMINECOUNT2),0) EXAMINECOUNT2, NVL(SUM(EXAMINECOUNT6),0) EXAMINECOUNT6," +
				" NVL(SUM(TCMCOUNT1),0) TCMCOUNT1, NVL(SUM(TCMCOUNT2),0) TCMCOUNT2,  NVL(SUM(TCMCOUNT6),0) TCMCOUNT6 FROM ( ")
				.append(sql1)
				.append(" UNION ALL ")
				.append(sql2)
				.append(" UNION ALL ")
				.append(sql3)
				.append(" UNION ALL ")
				.append(sql4).append(")").append(" GROUP BY ORGCODE");
	}

	private void buildOrganCondition(String orgCodeColumn, Criteria criteria, StringBuilder where, String timeColumn,
			List<String> organCodeList, MapSqlParameterSource sqlParameterSource) {
		
		String orgCode=(String)criteria.get("orgCode");
		
		if(ObjectUtil.isNotEmpty(orgCode) && organCodeList==null){
			where.append(" AND ").append(orgCodeColumn).append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		}else{
			if(ObjectUtil.isNotEmpty(organCodeList)){
				where.append(" AND ").append(orgCodeColumn).append(" in(:createOrgCode)");
				sqlParameterSource.addValue("createOrgCode", organCodeList);
			}
		}
		
		if (criteria == null || ObjectUtil.isNullOrEmpty(timeColumn)) {
			return;
		}
		if (criteria.contains("year") && !criteria.contains("month") && (!criteria.contains("createBeginTime") && !criteria.contains("createEndTime"))) {
			where.append(" AND TO_CHAR(").append(timeColumn).append(", 'YYYY') =:year ");
			sqlParameterSource.addValue("year", criteria.get("year"));
		} else if (criteria.contains("year") && criteria.contains("month")) {
			where.append(" AND TO_CHAR(").append(timeColumn).append(", 'YYYY/MM') = :year ");
			sqlParameterSource.addValue("year", criteria.get("year") + "/" + criteria.get("month"));
		} else if (criteria.contains("createBeginTime") && criteria.contains("createEndTime")) {
			where.append(" AND ").append(timeColumn).append(" BETWEEN TO_DATE( :day1, 'YYYY/MM/dd') AND TO_DATE( :day2, 'YYYY/MM/dd')");
			sqlParameterSource.addValue("day1", criteria.get("createBeginTime"));
			sqlParameterSource.addValue("day2", criteria.get("createEndTime"));
		} else if (criteria.contains("createBeginTime") && !criteria.contains("createEndTime")) {
			//查询本年度数据
			Date createBeginTime = DateUtil.parseSimpleDate(criteria.get("createBeginTime").toString(), "yyyy/MM/dd");
			Date createEndTime = DateUtil.lastDateOfYear(createBeginTime);
			
			where.append(" AND ").append(timeColumn).append(" BETWEEN TO_DATE( :day1, 'YYYY/MM/DD') AND TO_DATE( :day2, 'YYYY/MM/dd')");
			sqlParameterSource.addValue("day1", DateUtil.getDateTime("yyyy/MM/dd", createBeginTime));
			sqlParameterSource.addValue("day2", DateUtil.getDateTime("yyyy/MM/dd", createEndTime));
		} else if (!criteria.contains("createBeginTime") && criteria.contains("createEndTime")) {
			//查询本年度数据
			Date createEndTime = DateUtil.parseSimpleDate(criteria.get("createEndTime").toString(), "YYYY/MM/dd");
			Date createBeginTime = DateUtil.firstDateOfYear(createEndTime);
			
			where.append(" AND ").append(timeColumn).append(" BETWEEN TO_DATE( :day1, 'YYYY/MM/dd') AND TO_DATE( :day2, 'YYYY/MM/dd')");
			sqlParameterSource.addValue("day1", DateUtil.getDateTime("yyyy/MM/dd", createBeginTime));
			sqlParameterSource.addValue("day2", DateUtil.getDateTime("yyyy/MM/dd", createEndTime));
		}
	}
}
