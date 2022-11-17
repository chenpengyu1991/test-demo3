package com.founder.rhip.ehr.repository.hsa;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.ehr.dto.HealthSuperviseForm;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.statisticsdto.HsaServiceReport;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卫生监督统计
 * @author liuk
 *
 */
@Repository("hsaServiceReportDao")
public class HsaServiceReportDaoImpl extends AbstractDao<ReportRecord, Long> implements IHsaServiceReportDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	//报告的事件或线索次数
	private static final String HR_CENSUS_SQL1 = "SELECT create_organ_code ORG_CODE, count(1) reportNum, 0 patrolNum, 0 unitNum, 0 findNum" +
			" FROM HSA_REPORT_RECORD WHERE 1=1 %s GROUP BY create_organ_code";
	//协助开展的食源性疾病、生活饮用水安全、学校卫生、非法行医和非法采供血、计划生育实地巡查次数
	private static final String HR_CENSUS_SQL2 = "SELECT create_organ_code ORG_CODE, 0 reportNum, count(1) patrolNum, 0 unitNum, 0 findNum" +
			" FROM HSA_INSPECTION_RECORD WHERE INSP_LOC_TYPE=1 and INSP_HEALTH_PROFESSIONAL in ('3','5','7','8','9') %s GROUP BY create_organ_code";
	//规范建立服务单位数
	private static final String HR_CENSUS_SQL3 = "SELECT create_organ_code ORG_CODE, 0 reportNum, 0 patrolNum, count(1) unitNum, 0 findNum" +
			" FROM HSA_LOCATION_INFO WHERE STATUS=2 AND DATA_TYPE IN ('1', '2') %s GROUP BY create_organ_code";
	//发现的事件或线索次数
	private static final String HR_CENSUS_SQL4 = "SELECT create_organ_code ORG_CODE, 0 reportNum, 0 patrolNum, 0 unitNum, count(1) findNum" +
			" FROM HSA_INSPECTION_RECORD WHERE INSP_LOC_TYPE=1 %s GROUP BY create_organ_code";
	
	@Override
	public List<HsaServiceReport> getReportData(int type, String gbcode, String centerCode, int year, int month) {
		//@foff
		String sql="SELECT\n" +
				"	INFO_TYPE_CODE TYPE ,\n" +
				"	ILLEGAL_FLAG SUB_TYPE ,\n" +
				"	\"COUNT\" (1) COUNT \n" +
				" FROM\n" +
				" (SELECT\n" +
				"	CASE WHEN INFO_TYPE_CODE = '5' OR INFO_TYPE_CODE = '7' THEN '2' ELSE ILLEGAL_FLAG END AS ILLEGAL_FLAG,\n" +
				" HSA_REPORT_RECORD.INFO_TYPE_CODE,\n" +
				" HSA_REPORT_RECORD.CREATE_DATE,\n" +
				" HSA_REPORT_RECORD.CREATE_GBCODE,\n" +
				" HSA_REPORT_RECORD.CREATE_ORGAN_CODE\n" +
				" FROM\n" +
				"	HSA_REPORT_RECORD) HSA_REPORT_RECORD"+
				" WHERE\n" +
				"	INFO_TYPE_CODE IS NOT NULL \n" +
				" AND ILLEGAL_FLAG IS NOT NULL \n" +
				" %1$s \n" +
				" GROUP BY\n" +
				"	INFO_TYPE_CODE,\n" +
				"	ILLEGAL_FLAG\n" ;
		//@fon
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildUpTotalCondition(type, "HSA_REPORT_RECORD.CREATE_DATE", year, month, where, sqlParameterSource);
		buildOrganCondition("HSA_REPORT_RECORD.CREATE_GBCODE", "HSA_REPORT_RECORD.CREATE_ORGAN_CODE", gbcode, centerCode, where, sqlParameterSource);
		String finalSql = String.format(sql, where.toString());
		List<HsaServiceReport> result = getList(HsaServiceReport.class, finalSql, sqlParameterSource);
		return result;
	}




	@Override
	public List<HsaServiceReport> getInspectionData(int type, String gbcode, String centerCode,String yearMonthStart,
			String yearMonthEndDate) {
		//@foff
		String sql=	"SELECT\n" +
				"	HSA_INSPECTION_RECORD.INSP_HEALTH_PROFESSIONAL TYPE ,\n" +
				"	\"COUNT\" (1) COUNT \n" +
				"FROM\n" +
				"	HSA_INSPECTION_RECORD HSA_INSPECTION_RECORD\n" +
				"WHERE\n" +
				"	1=1 \n" +
				"	%1$s " +
				"GROUP BY\n" +
				"	HSA_INSPECTION_RECORD.INSP_HEALTH_PROFESSIONAL";
		//@fon
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		//buildUpTotalCondition(type, "HSA_INSPECTION_RECORD.INSP_DATE", year, month, where, sqlParameterSource);
		buildOrganCondition("HSA_INSPECTION_RECORD.CREATE_GBCODE", "HSA_INSPECTION_RECORD.CREATE_ORGAN_CODE","HSA_INSPECTION_RECORD.INSP_DATE", gbcode, centerCode, where, sqlParameterSource,yearMonthStart,yearMonthEndDate);
		String finalSql = String.format(sql, where.toString());
		List<HsaServiceReport> result = getList(HsaServiceReport.class, finalSql, sqlParameterSource);
		return result;
	}

	@Override
	public List<HsaServiceReport> getEduData(int type, String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate) {
		//@foff
		String sql=	"SELECT\n" +
				"	HE_ACTIVE.INDUSTRY_TYPE TYPE,\n" +
				"	\"COUNT\" (1) COUNT\n" +
				"FROM\n" +
				"	HE_ACTIVE HE_ACTIVE\n" +
				"WHERE\n" +
				"	HE_ACTIVE.STATUS='1' AND HE_ACTIVE.SYSTEM_TYPE = '1'\n" +
				"	%1$s " +
				"GROUP BY\n" +
				"	HE_ACTIVE.INDUSTRY_TYPE";
		//@fon
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		//buildUpTotalCondition(type, "ACTIVE_TIME", year, month, where, sqlParameterSource);
		buildOrganCondition("GBCODE", "ORG_CODE","ACTIVE_TIME", gbcode, centerCode, where, sqlParameterSource,yearMonthStart,yearMonthEndDate);
		String finalSql = String.format(sql, where.toString());
		List<HsaServiceReport> result = getList(HsaServiceReport.class, finalSql, sqlParameterSource);
		return result;
	}

	@Override
	public List<HsaServiceReport> getSodpData(int type, String gbcode, String centerCode,String yearMonthStart,
			String yearMonthEndDate) {
		String sql = "SELECT '4' AS TYPE, COUNT (1) AS COUNT FROM HSA_SUS_OCC_DIS_INFO WHERE 1=1 %1$s";
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		//buildUpTotalCondition(type, "REPORT_DATE", year, month, where, sqlParameterSource);
		buildOrganCondition("CREATE_GBCODE", "CREATE_ORGAN_CODE","REPORT_DATE", gbcode, centerCode, where, sqlParameterSource,yearMonthStart,yearMonthEndDate);
		String finalSql = String.format(sql, where.toString());
		List<HsaServiceReport> result = getList(HsaServiceReport.class, finalSql, sqlParameterSource);
		return result;
	}

	private void buildOrganCondition(String gbcodeColumn, String organColumn, String gbcode, String centerCode, StringBuilder where, MapSqlParameterSource sqlParameterSource) {
		if (ObjectUtil.isNotEmpty(centerCode)) {
			where.append(" AND ").append(organColumn).append("=:createOrganCode");
			sqlParameterSource.addValue("createOrganCode", centerCode);
		} else if (ObjectUtil.isNotEmpty(gbcode)) {
			where.append(" AND ").append(gbcodeColumn).append(" =:createGbcode");
			sqlParameterSource.addValue("createGbcode", gbcode);
		}

	}
	private void buildOrganCondition(String gbcodeColumn, String organColumn,String createDate, String gbcode, String centerCode, StringBuilder where, MapSqlParameterSource sqlParameterSource,String yearMonthStart,
			String yearMonthEndDate) {
		if (ObjectUtil.isNotEmpty(centerCode)) {
			where.append(" AND ").append(organColumn).append("=:createOrganCode");
			sqlParameterSource.addValue("createOrganCode", centerCode);
		} else if (ObjectUtil.isNotEmpty(gbcode)) {
			where.append(" AND ").append(gbcodeColumn).append(" =:createGbcode");
			sqlParameterSource.addValue("createGbcode", gbcode);
		}
		if(ObjectUtil.isNotEmpty(yearMonthStart)==true&&ObjectUtil.isNotEmpty(yearMonthEndDate)==true){
			where.append(" AND ("+createDate).append(">=TO_DATE(:yearMonthStart,'yyyy-MM-dd HH24:mi:ss')");
			where.append(" AND "+createDate).append("<=TO_DATE(:yearMonthEndDate,'yyyy-MM-dd HH24:mi:ss'))");
			sqlParameterSource.addValue("yearMonthStart", yearMonthStart);
			sqlParameterSource.addValue("yearMonthEndDate", yearMonthEndDate);
		}
		if(ObjectUtil.isNotEmpty(yearMonthStart)==true&&ObjectUtil.isNotEmpty(yearMonthEndDate)==false){
			where.append(" AND  "+createDate).append(">=TO_DATE(:yearMonthStart,'yyyy-MM-dd HH24:mi:ss')");
			sqlParameterSource.addValue("yearMonthStart", yearMonthStart);
		}
		if(ObjectUtil.isNotEmpty(yearMonthStart)==false&&ObjectUtil.isNotEmpty(yearMonthEndDate)==true){
			where.append(" AND "+createDate).append("<=TO_DATE(:yearMonthEndDate,'yyyy-MM-dd HH24:mi:ss')");
			sqlParameterSource.addValue("yearMonthEndDate", yearMonthEndDate);
		}
	}

	private void buildUpTotalCondition(int type, String column, int year, int month, StringBuilder sql, MapSqlParameterSource sqlParameterSource) {
		if (0 == type) {
			sql.append(" AND EXTRACT ( YEAR FROM ").append(column).append(" ) = :year \n");
			sqlParameterSource.addValue("year", year);
			sql.append("	AND EXTRACT ( MONTH FROM  ").append(column).append("  )  = :month \n");
			sqlParameterSource.addValue("month", month);
		} else {
			sql.append(" AND EXTRACT ( YEAR FROM ").append(column).append(" ) <= :year \n");
			sqlParameterSource.addValue("year", year);
			sql.append("	AND EXTRACT ( MONTH FROM  ").append(column).append("  )  <= :month \n");
			sqlParameterSource.addValue("month", month);
		}
	}

	//------------------
	@Override
	public List<HsaServiceReport> getReportData(int type, String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate) {
		//@foff
				String sql="SELECT\n" +
						"	INFO_TYPE_CODE TYPE ,\n" +
						"	ILLEGAL_FLAG SUB_TYPE ,\n" +
						"	\"COUNT\" (1) COUNT \n" +
						" FROM\n" +
						" (SELECT\n" +
						"	CASE WHEN INFO_TYPE_CODE = '5' OR INFO_TYPE_CODE = '7' THEN '2' ELSE ILLEGAL_FLAG END AS ILLEGAL_FLAG,\n" +
						" HSA_REPORT_RECORD.INFO_TYPE_CODE,\n" +
						" HSA_REPORT_RECORD.CREATE_DATE,\n" +
						" HSA_REPORT_RECORD.CREATE_GBCODE,\n" +
						" HSA_REPORT_RECORD.CREATE_ORGAN_CODE\n" +
						" FROM\n" +
						"	HSA_REPORT_RECORD) HSA_REPORT_RECORD"+
						" WHERE\n" +
						"	INFO_TYPE_CODE IS NOT NULL \n" +
						" AND ILLEGAL_FLAG IS NOT NULL \n" ;
						sql=sql+" %1$s \n" +
								" GROUP BY\n" +
								"	INFO_TYPE_CODE,\n" +
								"	ILLEGAL_FLAG\n";
				//@fon
				StringBuilder where = new StringBuilder();
				MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
				/*buildUpTotalCondition(type, "HSA_REPORT_RECORD.CREATE_DATE", yearMonthStart, yearMonthEndDate, where, sqlParameterSource);*/
				buildOrganCondition("HSA_REPORT_RECORD.CREATE_GBCODE", "HSA_REPORT_RECORD.CREATE_ORGAN_CODE","HSA_REPORT_RECORD.CREATE_DATE", gbcode, centerCode, where, sqlParameterSource,yearMonthStart,yearMonthEndDate);
				String finalSql = String.format(sql, where.toString());
				List<HsaServiceReport> result = getList(HsaServiceReport.class, finalSql, sqlParameterSource);
				return result;
	}

	@Override
	public List<Map<String, Object>> getHealthSupervision(String roleType, HealthSuperviseForm initForm) {
		StringBuilder stringBuilder = new StringBuilder();
		    stringBuilder.append("select org.organ_name,NVL(report.reportnum,0) reportnum,NVL(patrol.patrolnum,0)patrolnum  from " +
                " (select organ_code,organ_name,gb_code from mdm_organization where status=1 and ");
            if(roleType.equals(RoleType.ADMIN.getValue())){
                if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
                    stringBuilder.append(" genre_code = 'R11'");
                }
            }else if(roleType.equals(RoleType.ZXZH.getValue())){
                if(ObjectUtil.isNullOrEmpty(initForm.getOrgCode())){
                    stringBuilder.append(" parent_code = '"+initForm.getCurrentOrgCode()+"' or organ_code = '"+initForm.getCurrentOrgCode()+"'");
                }
                if(ObjectUtil.isNotEmpty(initForm.getOrgCode())){
					stringBuilder.append(" organ_code = '"+initForm.getOrgCode()+"'");
				}
            }else if(roleType.equals(RoleType.ZZH.getValue())){
                    stringBuilder.append(" organ_code = '"+initForm.getCurrentOrgCode()+"'");
            }
            stringBuilder.append(" ) org" +
                " left join" +
                " (select count(*) reportNum,");
			if(roleType.equals(RoleType.ADMIN.getValue())){
				if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
					stringBuilder.append(" create_gbcode ");
				}else {stringBuilder.append(" CREATE_ORGAN_CODE ");}
			}else if(roleType.equals(RoleType.QWGZX.getValue()) || roleType.equals(RoleType.ZXZH.getValue()) || roleType.equals(RoleType.ZZH.getValue())){
				stringBuilder.append(" CREATE_ORGAN_CODE ");
			}

            stringBuilder.append(" from HSA_REPORT_RECORD ");
		    stringBuilder.append(getWhereDate(initForm));
		    stringBuilder.append(" group by");
			if(roleType.equals(RoleType.ADMIN.getValue())){
				if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
					stringBuilder.append(" create_gbcode ");
				}else {stringBuilder.append(" CREATE_ORGAN_CODE ");}
			}else if(roleType.equals(RoleType.QWGZX.getValue()) || roleType.equals(RoleType.ZXZH.getValue()) || roleType.equals(RoleType.ZZH.getValue())){
				stringBuilder.append(" CREATE_ORGAN_CODE ");
			}
            stringBuilder.append(") report ");
			if(roleType.equals(RoleType.ADMIN.getValue())){
				if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
					stringBuilder.append(" on org.gb_code =  report.create_gbcode");
				}else {
					stringBuilder.append(" on org.organ_code =  report.CREATE_ORGAN_CODE");
				}
			}else if(roleType.equals(RoleType.QWGZX.getValue()) || roleType.equals(RoleType.ZXZH.getValue()) || roleType.equals(RoleType.ZZH.getValue())){
				stringBuilder.append(" on org.organ_code =  report.CREATE_ORGAN_CODE");
			}
			stringBuilder.append(" left join" +
                " (select count(*) patrolNum,");
			if(roleType.equals(RoleType.ADMIN.getValue())){
				if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
					stringBuilder.append(" create_gbcode ");
				}else {stringBuilder.append(" CREATE_ORGAN_CODE ");}
			}else if(roleType.equals(RoleType.QWGZX.getValue()) || roleType.equals(RoleType.ZXZH.getValue()) || roleType.equals(RoleType.ZZH.getValue())){
				stringBuilder.append(" CREATE_ORGAN_CODE ");
			}
			stringBuilder.append(" from HSA_INSPECTION_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" group by");
			if(roleType.equals(RoleType.ADMIN.getValue())){
				if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
					stringBuilder.append(" create_gbcode ");
				}else {stringBuilder.append(" CREATE_ORGAN_CODE ");}
			}else if(roleType.equals(RoleType.QWGZX.getValue()) || roleType.equals(RoleType.ZXZH.getValue()) || roleType.equals(RoleType.ZZH.getValue())){
				stringBuilder.append(" CREATE_ORGAN_CODE ");
			}
			stringBuilder.append(") patrol");
			if(roleType.equals(RoleType.ADMIN.getValue())){
				if(ObjectUtil.isNullOrEmpty(initForm.getGbcode())){
					stringBuilder.append(" on org.gb_code =  patrol.create_gbcode");
				}else {
					stringBuilder.append(" on org.organ_code =  patrol.CREATE_ORGAN_CODE");
				}
			}else if(roleType.equals(RoleType.QWGZX.getValue()) || roleType.equals(RoleType.ZXZH.getValue()) || roleType.equals(RoleType.ZZH.getValue())){
				stringBuilder.append(" on org.organ_code =  patrol.CREATE_ORGAN_CODE");
			}
		return getMapList(stringBuilder.toString(),new Criteria());
	}

	public List<Map<String,Object>> getHealthSupervisionStation(String code,HealthSuperviseForm initForm){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select NVL(reportnum,0) reportnum,NVL(patrolnum,0) patrolnum from \n" +
				"         (select organ_code from mdm_organization ) o\n" +
				"         left join \n" +
				"         (select NVL(count(*),0) reportnum,CREATE_ORGAN_CODE  from HSA_REPORT_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" group by CREATE_ORGAN_CODE) a on o.organ_code =  a.CREATE_ORGAN_CODE\n" +
				"         left join\n" +
				"         (select NVL(count(*),0) patrolnum,CREATE_ORGAN_CODE  from HSA_INSPECTION_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" group by CREATE_ORGAN_CODE) b on o.organ_code =  b.CREATE_ORGAN_CODE  \n" +
				"         where o.organ_code = '"+code+"'");
		return getMapList(stringBuilder.toString(),new Criteria());
	}

	public List<Map<String,Object>> getHealthSupervisionGB(String gbcode,HealthSuperviseForm initForm){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select NVL(reportnum,0) reportnum,NVL(patrolnum,0) patrolnum from \n" +
				"         (select GB_CODE from mdm_organization ) o\n" +
				"         left join \n" +
				"         (select NVL(count(*),0) reportnum,CREATE_GBCODE  from HSA_REPORT_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" group by CREATE_GBCODE) a on o.GB_CODE =  a.CREATE_GBCODE\n" +
				"         left join\n" +
				"         (select NVL(count(*),0) patrolnum,CREATE_GBCODE  from HSA_INSPECTION_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" group by CREATE_GBCODE) b on o.GB_CODE =  b.CREATE_GBCODE  \n" +
				"         where o.GB_CODE = '"+gbcode+"'");
		return getMapList(stringBuilder.toString(),new Criteria());
	}

	@Override
	public List<Map<String, Object>> getHealthSupervisionAll(HealthSuperviseForm initForm) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select NVL(a.reportnum,0) reportnum,NVL(b.patrolnum,0) patrolnum from " +
				"         (select NVL(count(*),0) reportnum  from HSA_REPORT_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" and CREATE_GBCODE != 'null') a" +
				",(select NVL(count(*),0) patrolnum  from HSA_INSPECTION_RECORD ");
		stringBuilder.append(getWhereDate(initForm));
		stringBuilder.append(" and CREATE_GBCODE != 'null') b ");
		return getMapList(stringBuilder.toString(),new Criteria());
	}

	private String getWhereDate(HealthSuperviseForm initForm){
		String sqlWhereDate = "";
		if(initForm.getCountType().equals("1")){//按年
			if(ObjectUtil.isNotEmpty(initForm.getYear())){
				String year = initForm.getYear();
				String nextYear =String.valueOf(Integer.valueOf(year)+1);
				sqlWhereDate = " where create_date between '1-1月 -"+year+"' and '1-1月 -"+nextYear+"' ";
			}
		}else if(initForm.getCountType().equals("2")){//按季度
			if(ObjectUtil.isNotEmpty(initForm.getYear())){
				String year = initForm.getYear();
				String nextYear =String.valueOf(Integer.valueOf(year)+1);
				String quarter = initForm.getQuarter();
				if(quarter.equals("0")){
					sqlWhereDate = " where create_date between '1-1月 -"+year+"' and '1-1月 -"+nextYear+"' ";
				}else if(quarter.equals("1")){
					sqlWhereDate =" where create_date between '1-1月 -"+year+"' and '31-3月 -"+year+"' ";
				}else if(quarter.equals("2")){
					sqlWhereDate =" where create_date between '1-4月 -"+year+"' and '30-6月 -"+year+"' ";
				}else if(quarter.equals("3")){
					sqlWhereDate =" where create_date between '1-7月 -"+year+"' and '30-9月 -"+year+"' ";
				}else if(quarter.equals("4")){
					sqlWhereDate =" where create_date between '1-10月 -"+year+"' and '31-12月 -"+year+"' ";
				}
			}
		}
		if(ObjectUtil.isNullOrEmpty(sqlWhereDate)){
			sqlWhereDate = " where 1=1 ";
		}
		return sqlWhereDate;
	}

	private void buildUpTotalCondition(int type, String column, Date yearMonthStart, Date yearMonthEndDate,
			StringBuilder sql, MapSqlParameterSource sqlParameterSource) {
		/*if (0 == type) {
			sql.append(" AND EXTRACT ( YEAR FROM ").append(column).append(" ) = :year \n");
			sqlParameterSource.addValue("year", year);
			sql.append("	AND EXTRACT ( MONTH FROM  ").append(column).append("  )  = :month \n");
			sqlParameterSource.addValue("month", month);
		} else {
			sql.append(" AND EXTRACT ( YEAR FROM ").append(column).append(" ) <= :year \n");
			sqlParameterSource.addValue("year", year);
			sql.append("	AND EXTRACT ( MONTH FROM  ").append(column).append("  )  <= :month \n");
			sqlParameterSource.addValue("month", month);
		}*/
		//sql.append(column.append(" ) <= :year \n");
	}




	@Override
	public List<Map<String, Object>> getHealthSupervisionList(Criteria criteria, List<String> organCodeList) {

		String orgCode = (String)criteria.get("orgCode");
		String quarter = (String) criteria.get("quarter");
		String year = (String)criteria.get("year");
		
		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();
		Map<String, Object> map;
		
		map = SqlBuilder.buildOrganCondition("create_organ_code","create_date", null, null, orgCode, year, quarter, organCodeList, new MapSqlParameterSource(), 2);
		String sql = String.format(HR_CENSUS_SQL1, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("create_organ_code","INSP_DATE", null, null, orgCode, year, quarter, organCodeList, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 2);
		sql = String.format(HR_CENSUS_SQL2, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("create_organ_code","create_date", null, null, orgCode, year, quarter, organCodeList, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 5);
		sql = String.format(HR_CENSUS_SQL3, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("create_organ_code","INSP_DATE", null, null, orgCode, year, quarter, organCodeList, (MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 2);
		sql = String.format(HR_CENSUS_SQL4, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("V.ORGAN_CODE",null, null, null, orgCode, null, null, organCodeList,(MapSqlParameterSource)map.get(SqlBuilder.SOURCE), 0);
		
		builDSSql(criteria, finalSql, sqlList);
		return getMapList(String.format(finalSql.toString(), map.get(SqlBuilder.WHERE)), (MapSqlParameterSource)map.get(SqlBuilder.SOURCE));
	}

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
			
		finalSql.append("SELECT V.GB_CODE gbcode,V.ORGAN_CODE orgCode," +
				" NVL(reportNum, 0) reportNum,NVL(patrolNum, 0) patrolNum," +
				" NVL(unitNum, 0) unitNum,NVL(findNum, 0) findNum" +
				" FROM mdm_organization V LEFT JOIN (")
		.append("SELECT ORG_CODE,")
		.append(" NVL(SUM(reportNum), 0) reportNum, " +
				" NVL(SUM(patrolNum), 0) patrolNum, " +
				" NVL(SUM(unitNum), 0) unitNum, " +
				" NVL(SUM(findNum), 0) findNum " +
				" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE ) T ON V.ORGAN_CODE=T.ORG_CODE WHERE 1=1 %s ORDER BY V.GENRE_CODE,V.ORGAN_NAME");
	}
}
