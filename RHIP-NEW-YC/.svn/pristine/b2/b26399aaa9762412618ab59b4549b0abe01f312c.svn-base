package com.founder.rhip.ehr.repository.statistics;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.founder.fasf.util.DateUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.DmManageAndFollowup;

@Repository("cdmWorkStatisticsDao")
public class CdmWorkStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements ICdmWorkStatisticsDao {

	@SuppressWarnings("unused")
	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	
	
	private static final String TUMOR_PATHOLOGY_SQL=
			"SELECT\n" +
					"	NVL (ORGAN_CODE, '合计') AS ORGAN_CODE,\n" +
					"	REPORT_TOTAL,\n" +
					"	PATHOLOGY_TOTAL,\n" +
					"	ROUND ( ( PATHOLOGY_TOTAL / REPORT_TOTAL ) * 1, 4 ) AS PERCENTAGE_TOTAL\n" +
					"FROM\n" +
					"	(\n" +
					"		SELECT\n" +
					"			%1$s  ORGAN_CODE,\n" +
					"			COUNT (*) AS REPORT_TOTAL,\n" +
					"			SUM ( CASE WHEN TUMOR_DIAGNOSIS_DEPENDS LIKE '%10%' AND TUMOR_PATHOLOGY_TYPE IS NOT NULL THEN 1 ELSE 0 END ) AS PATHOLOGY_TOTAL\n" +
					"		FROM\n" +
					"			(\n" +
					"				SELECT\n" +
					"					*\n" +
					"				FROM\n" +
					"					V_DM_REPORT_INFO\n" +
					"				LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON V_DM_REPORT_INFO.CREATE_ORGAN_CODE = V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE\n" +
					"				WHERE\n" +
					"					DIS_TYPE = 5 AND REPORT_STATUS != '5' %2$s\n" +
					"			)\n" +
					"		GROUP BY\n " +
					"			 ROLLUP (%1$s )\n" ;
	private static final String TOWN_TUMOR_PATHOLOGY_SQL=
			"WITH TOWN AS (SELECT * FROM V_MDM_TOWN UNION SELECT '合计' AS ORGAN_CODE, '合计' AS ORGAN_NAME FROM dual )"+
			"SELECT GB_CODE ORGAN_CODE,GB_NAME ORGAN_NAME ,R.* FROM TOWN TOWN LEFT JOIN ("
			+TUMOR_PATHOLOGY_SQL
			+"	) ) R  ON TOWN.GB_CODE=R.ORGAN_CODE ORDER BY TOWN.GB_CODE";
	
	private static final String ORG_TUMOR_PATHOLOGY_SQL2=
			"WITH ORG AS(\n" +
					"	SELECT  ORG.ORGAN_CODE, ORG.ORGAN_NAME  FROM V_MDM_ORGANIZATION_NOSUB ORG \n" +
					"	WHERE  ORG.GB_CODE =:gbCode AND GENRE_CODE IN ('A1','B1','R2')\n" +
					"	UNION\n" +
					"			SELECT '合计' AS ORGAN_CODE, '合计' AS ORGAN_NAME FROM dual\n" +
					")"
			+"SELECT  ORG.ORGAN_CODE, ORG.ORGAN_NAME ,R.* FROM ORG ORG LEFT JOIN ("
			+TUMOR_PATHOLOGY_SQL
			+")) R  ON ORG.ORGAN_CODE=R.ORGAN_CODE ORDER BY ORG.ORGAN_CODE  ";
	
	private static final String SINGLE_ORG_TUMOR_PATHOLOGY_SQL=
			"WITH ORG AS(\n" +
					"	SELECT  ORG.ORGAN_CODE, ORG.ORGAN_NAME  FROM V_MDM_ORGANIZATION_NOSUB ORG \n" +
					"	WHERE   ORG.ORGAN_CODE =:orgCode" +
					"	UNION\n" +
					"			SELECT '合计' AS ORGAN_CODE, '合计' AS ORGAN_NAME FROM dual\n" +
					")"
			+"SELECT  ORG.ORGAN_CODE, ORG.ORGAN_NAME ,R.* FROM ORG ORG LEFT JOIN ("
			+TUMOR_PATHOLOGY_SQL
			+")) R  ON ORG.ORGAN_CODE=R.ORGAN_CODE  ORDER BY ORG.ORGAN_CODE  ";
	
	@Override
	public List<Map<String, Object>> getTumorPathologyResult(String beginAge, String endAge, String gbCode,String orgCode) {
		StringBuilder where = new StringBuilder();
		String groupColumn = null;
		String baseSql=null;
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		if (ObjectUtil.isNotEmpty(orgCode)) {
			where.append(" AND ORGAN_CODE =:orgCode ");
			groupColumn = "ORGAN_CODE";
			sqlParameterSource.addValue("orgCode", orgCode);
			baseSql=SINGLE_ORG_TUMOR_PATHOLOGY_SQL;
		} else if (ObjectUtil.isNotEmpty(gbCode)) {
			where.append(" AND GB_CODE =:gbCode ");
			sqlParameterSource.addValue("gbCode", gbCode);
			groupColumn = "ORGAN_CODE";
			baseSql=ORG_TUMOR_PATHOLOGY_SQL2;
		} else {
			groupColumn = "GB_CODE";
			baseSql=TOWN_TUMOR_PATHOLOGY_SQL;
		}

		if (ObjectUtil.isNotEmpty(beginAge)) {
			where.append(" AND TO_CHAR(CREATE_DATE,'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			where.append(" AND TO_CHAR(CREATE_DATE,'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}

		String sql = String.format(baseSql, groupColumn, where.toString());
		return this.getMapList(sql, sqlParameterSource);
	}

	@Override
	public List<DmManageAndFollowup> getIntoStatus(String beginAge, String endAge, String town, String center,String station, String cdmType) {
		String orgStatus = null;
		String orgCondition="";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		
		if (ObjectUtil.isNotEmpty(station)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND ORGAN_CODE=:station";
			sqlParameterSource.addValue("station", station);
		}else if (ObjectUtil.isNotEmpty(center)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND PARENT_CODE=:center";
			sqlParameterSource.addValue("center", center);
		}else if (ObjectUtil.isNotEmpty(town)) {
			orgStatus = "PARENT_CODE";
			orgCondition=" AND GB_CODE=:town";
			sqlParameterSource.addValue("town", town);
		}  else {
			orgStatus = "GB_CODE";
		}
		
		StringBuilder sql = new StringBuilder("SELECT * FROM(");
		sql.append("SELECT NVL("
				+ orgStatus
				+ ",'合计') AS UPDATE_ORGAN_CODE,SUM(CASE "
				+ cdmType(cdmType)
				+ " WHEN '2' THEN 1 ELSE 0 END)AS INTO_MANAGE_TOTAL FROM(SELECT * FROM V_DM_DISEASE_INFO LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON V_DM_DISEASE_INFO.CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE)");
		sql.append("WHERE 1=1 " + getHmCardDeleteStatusSql("", EHRConstants.DM_MANAGED_FLAG) + " AND STATUS != '2' AND GENRE_CODE ='B2' ");
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + intoManageDate(cdmType) + ",'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(" + intoManageDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}
		sql.append(orgCondition);
		sql.append(" GROUP BY  ROLLUP(" + orgStatus + ")) A");
		sql.append(" RIGHT JOIN(");
		sql.append("SELECT NVL("
				+ orgStatus
				+ ",'合计') AS ORGAN_CODE,SUM(CASE "
				+ cdmType(cdmType)
				+ " WHEN '2' THEN 1 ELSE 0 END)AS INTO_MANAGE_COUNT FROM(SELECT * FROM V_DM_DISEASE_INFO LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON V_DM_DISEASE_INFO.CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE)");
		sql.append("WHERE 1=1 " + getHmCardDeleteStatusSql("", EHRConstants.DM_MANAGED_FLAG) + " AND STATUS != '2' AND GENRE_CODE ='B2' ");
		if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			sql.append(" AND TO_CHAR(" + intoManageDate(cdmType) + ",'yyyy/mm/dd')>=");
			sql.append(" TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		}
		if (ObjectUtil.isNotEmpty(endAge) && ObjectUtil.isNullOrEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + intoManageDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}
		if (ObjectUtil.isNotEmpty(endAge) && ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + intoManageDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}
		sql.append(orgCondition);
		sql.append(" GROUP BY  ROLLUP(" + orgStatus + ")) B ON A.UPDATE_ORGAN_CODE=B.ORGAN_CODE");
		return this.getList(DmManageAndFollowup.class, sql.toString(), sqlParameterSource);
	}

	@Override
	public List<DmManageAndFollowup> getFollowupStatus(String beginAge, String endAge, String town, String center,String station, String cdmType) {
		String orgStatus = null;
		String orgCondition="";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		if (ObjectUtil.isNotEmpty(station)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND ORGAN_CODE=:station";
			sqlParameterSource.addValue("station", station);
		}else if (ObjectUtil.isNotEmpty(center)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND PARENT_CODE=:center";
			sqlParameterSource.addValue("center", center);
		}else if (ObjectUtil.isNotEmpty(town)) {
			orgStatus = "PARENT_CODE";
			orgCondition=" AND GB_CODE=:town";
			sqlParameterSource.addValue("town", town);
		}  else {
			orgStatus = "GB_CODE";
		}
		StringBuilder sql = new StringBuilder("SELECT * FROM (");
		sql.append("SELECT WHOLE AS UPDATE_ORGAN_CODE,TOTAL AS WAIT_TOTAL,EXPIRED_TOTAL AS EXPIRED_TOTAL,CANCEL_TOTAL FROM");
		sql.append("(SELECT NVL(" + orgStatus + ",'合计') AS WHOLE,");
		sql.append("SUM(CASE WHEN TO_CHAR(" + followupDate(cdmType) + ",'yyyy-mm-dd')>=TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}
		sql.append(" AND STATUS !='2' THEN 1 ELSE 0 END)AS TOTAL,");
		sql.append("SUM(CASE WHEN TO_CHAR(" + followupDate(cdmType) + ",'yyyy-mm-dd')<TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);			
		}
		sql.append(" AND STATUS !='2' THEN 1 ELSE 0 END)AS EXPIRED_TOTAL,");
		sql.append("SUM(CASE WHEN STATUS='2'");
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(UPDATE_DATE,'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(UPDATE_DATE,'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);		
		}
		sql.append(" THEN 1 ELSE 0 END)AS CANCEL_TOTAL");
		sql.append(" FROM(SELECT * FROM V_DM_DISEASE_INFO LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON V_DM_DISEASE_INFO.CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE) " +
				"WHERE 1=1" + getHmCardDeleteStatusSql("", EHRConstants.DM_MANAGED_FLAG) + " AND GENRE_CODE ='B2' ");
		
		sql.append(orgCondition);
		
		if (ObjectUtil.isNotEmpty(cdmType)) {
			sql.append(" AND " + cdmType(cdmType) + "='2'");
		}
		sql.append(" GROUP BY  ROLLUP (" + orgStatus + ")))A");
		sql.append(" RIGHT JOIN(");
		sql.append("SELECT WHOLE AS ORGAN_CODE,TOTAL AS UPDATE_WAIT_TOTAL,EXPIRED_TOTAL AS UPDATE_EXPIRED_TOTAL,DELETE_COUNT FROM");
		sql.append("(SELECT NVL(" + orgStatus + ",'合计')AS WHOLE,");
		sql.append("SUM(CASE WHEN TO_CHAR(" + followupDate(cdmType) + ",'yyyy-mm-dd')>=TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);			
		}
		sql.append(" AND STATUS !='2' THEN 1 ELSE 0 END)AS TOTAL,");
		sql.append("SUM(CASE WHEN TO_CHAR(" + followupDate(cdmType) + ",'yyyy-mm-dd')<TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(" + followupDate(cdmType) + ",'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);			
		}
		sql.append(" AND STATUS !='2' THEN 1 ELSE 0 END)AS EXPIRED_TOTAL,");
		sql.append("SUM(CASE WHEN STATUS='2'");
		if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			sql.append(" AND TO_CHAR(UPDATE_DATE,'yyyy/mm/dd')>=");
			sql.append(" TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		}
		if (ObjectUtil.isNotEmpty(endAge) && ObjectUtil.isNullOrEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(UPDATE_DATE,'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);			
		}
		if (ObjectUtil.isNotEmpty(endAge) && ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(UPDATE_DATE,'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);			
		}
		sql.append(" THEN 1 ELSE 0 END)AS DELETE_COUNT");
		sql.append(" FROM(SELECT * FROM V_DM_DISEASE_INFO LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON V_DM_DISEASE_INFO.CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE) " +
				"WHERE 1=1" + getHmCardDeleteStatusSql("", EHRConstants.DM_MANAGED_FLAG) + " AND GENRE_CODE ='B2' ");
		
		sql.append(orgCondition);
		
		if (ObjectUtil.isNotEmpty(cdmType)) {
			sql.append(" AND " + cdmType(cdmType) + "='2'");
		}
		sql.append(" GROUP BY  ROLLUP (" + orgStatus + ")))B ON A.UPDATE_ORGAN_CODE=B.ORGAN_CODE");
		return this.getList(DmManageAndFollowup.class, sql.toString(), sqlParameterSource);
	}

	@Override
	public List<DmManageAndFollowup> getManageAndFollowup(String beginAge, String endAge, String town, String center,String station, String cdmType) {
		String orgStatus = null;
		String orgCondition="";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		if (ObjectUtil.isNotEmpty(station)) {
			orgCondition=" AND ORGAN_CODE=:station";
			orgStatus="ORGAN_CODE";
			sqlParameterSource.addValue("station", station);
		}else if (ObjectUtil.isNotEmpty(center)) {
			orgCondition=" AND PARENT_CODE=:center";
			orgStatus="ORGAN_CODE";
			sqlParameterSource.addValue("center", center);
		}else if (ObjectUtil.isNotEmpty(town)) {
			orgCondition=" AND GB_CODE=:town";
			orgStatus="PARENT_CODE";
			sqlParameterSource.addValue("town", town);
		}  else {
			orgStatus = "GB_CODE";
		}
		StringBuilder sql = new StringBuilder("SELECT * FROM(");
		sql.append("SELECT ORGAN_CODE AS UPDATE_ORGAN_CODE,SUM(OUTPATIENT_COUNT)AS OUT_TOTAL,SUM(VISIT_COUNT)AS VISIT_TOTAL,SUM(PHONE_COUNT)AS PHONE_TOTAL,SUM(CENTRAL_COUNT) CENTRAL_TOTAL,SUM(OUTPATIENT_COUNT+VISIT_COUNT+PHONE_COUNT+CENTRAL_COUNT)AS TOTAL FROM(");
		sql.append("SELECT NVL(" + orgStatus + ", '合计') AS ORGAN_CODE,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '1' THEN 1 ELSE 0 END ) AS OUTPATIENT_COUNT ,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '2' THEN 1 ELSE 0 END ) AS VISIT_COUNT ,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '3' THEN 1 ELSE 0 END ) AS PHONE_COUNT,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '4' THEN 1 ELSE 0 END ) AS CENTRAL_COUNT");
		sql.append(" FROM(SELECT * FROM " + databaseTable(cdmType) + " LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON " + databaseTable(cdmType) + ".CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE)WHERE "
				+ orgStatus + " IS NOT NULL AND GENRE_CODE ='B2'  ");
		if (cdmType.equals(EHRConstants.DM_STROKE_TYPE)) {
			sql.append(" AND DISEASE_TYPE = '3'");
		} else if (cdmType.equals(EHRConstants.DM_CORONARY_TYPE)) {
			sql.append(" AND DISEASE_TYPE = '4'");
		}
		if (ObjectUtil.isNotEmpty(beginAge)) {
			sql.append(" AND TO_CHAR(VISIT_DATE,'yyyy/mm/dd')>=:beginAge");
			sqlParameterSource.addValue("beginAge", beginAge);
		}
		if (ObjectUtil.isNotEmpty(endAge)) {
			sql.append(" AND TO_CHAR(VISIT_DATE,'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}
		sql.append(orgCondition);
		
		
		sql.append(" GROUP BY  ROLLUP (" + orgStatus + ")");
		sql.append(")GROUP BY ORGAN_CODE) A");
		sql.append(" RIGHT JOIN(");
		sql.append("SELECT ORGAN_CODE,SUM(OUTPATIENT_COUNT)AS UPDATE_OUT_TOTAL,SUM(VISIT_COUNT)AS UPDATE_VISIT_TOTAL,SUM(PHONE_COUNT)AS UPDATE_PHONE_TOTAL,SUM(OUTPATIENT_COUNT+VISIT_COUNT+PHONE_COUNT+CENTRAL_COUNT)AS FOLLOWUP_TOTAL FROM(");
		sql.append("SELECT NVL(" + orgStatus + ", '合计') AS ORGAN_CODE,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '1' THEN 1 ELSE 0 END ) AS OUTPATIENT_COUNT ,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '2' THEN 1 ELSE 0 END ) AS VISIT_COUNT ,");
		sql.append("SUM(CASE VISIT_WAY_CODE WHEN '3' THEN 1 ELSE 0 END ) AS PHONE_COUNT,");
        sql.append("SUM(CASE VISIT_WAY_CODE WHEN '4' THEN 1 ELSE 0 END ) AS CENTRAL_COUNT");
		sql.append(" FROM(SELECT * FROM " + databaseTable(cdmType) + " LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON " + databaseTable(cdmType) + ".CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE)WHERE "
				+ orgStatus + " IS NOT NULL AND GENRE_CODE ='B2' ");
		if (cdmType.equals(EHRConstants.DM_STROKE_TYPE)) {
			sql.append(" AND DISEASE_TYPE = '3'");
		} else if (cdmType.equals(EHRConstants.DM_CORONARY_TYPE)) {
			sql.append(" AND DISEASE_TYPE = '4'");
		}
		if (ObjectUtil.isNullOrEmpty(endAge)) {
			//sql.append(" AND TO_CHAR(VISIT_DATE,'yyyy/mm/dd')<=");
			//sql.append(" '").append(DateUtil.toFormatString("yyyy/MM/dd",new Date())).append("' ");
		}else  {
			sql.append(" AND TO_CHAR(VISIT_DATE,'yyyy/mm/dd')<=:endAge");
			sqlParameterSource.addValue("endAge", endAge);
		}

		sql.append(orgCondition);
		
		sql.append(" GROUP BY  ROLLUP (" + orgStatus + ")");
		sql.append(")GROUP BY ORGAN_CODE) B ON A.UPDATE_ORGAN_CODE = B.ORGAN_CODE");
		return this.getList(DmManageAndFollowup.class, sql.toString(), sqlParameterSource);
	}

	// 慢病下次随访日期
	private String followupDate(String cdmType) {
		String followupDate = null;
		if (cdmType.equals(EHRConstants.DM_HBP_TYPE)) {
			followupDate = "NEXT_HBP_FOLLOWUP_DATE";
		} else if (cdmType.equals(EHRConstants.DM_DI_TYPE)) {
			followupDate = "NEXT_DI_FOLLOWUP_DATE";
		} else if (cdmType.equals(EHRConstants.DM_STROKE_TYPE)) {
			followupDate = "NEXT_STROKE_FOLLOWUP_DATE";
		} else if (cdmType.equals(EHRConstants.DM_CORONARY_TYPE)) {
			followupDate = "NEXT_CORONARY_FOLLOWUP_DATE";
		} else if (cdmType.equals(EHRConstants.DM_TUMOR_TYPE)) {
			followupDate = "NEXT_TUMOR_FOLLOWUP_DATE";
		}
		return followupDate;
	}

	// 慢病对应的视图
	private String databaseTable(String cdmType) {
		String dbTable = null;
		if (EHRConstants.DM_DI_TYPE.equals(cdmType)) {
			dbTable = "DM_DIABETIC_FOLLOWUP";
		} else if (EHRConstants.DM_HBP_TYPE.equals(cdmType)) {
			dbTable = "DM_HYPERTENSION_FOLLOWUP";
		} else if (EHRConstants.DM_TUMOR_TYPE.equals(cdmType)) {
			dbTable = "DM_TUMOR_FOLLOWUP";
		} else if (EHRConstants.DM_STROKE_TYPE.equals(cdmType)) {
			dbTable = "DM_STRTUM_FOLLOWUP";
		} else if (EHRConstants.DM_CORONARY_TYPE.endsWith(cdmType)) {
			dbTable = "DM_STRTUM_FOLLOWUP";
		}
		return dbTable;
	}

	// 慢病纳入标识
	private String cdmType(String cdmType) {
		String type = null;
		if (cdmType.equals(EHRConstants.DM_HBP_TYPE)) {
			type = "HBP_FLAG";
		} else if (cdmType.equals(EHRConstants.DM_DI_TYPE)) {
			type = "DI_FLAG";
		} else if (cdmType.equals(EHRConstants.DM_STROKE_TYPE)) {
			type = "STROKE_FLAG";
		} else if (cdmType.equals(EHRConstants.DM_CORONARY_TYPE)) {
			type = "CORONARY_FLAG";
		} else if (cdmType.equals(EHRConstants.DM_TUMOR_TYPE)) {
			type = "TUMOR_FLAG";
		}
		return type;
	}

	// 慢病纳入日期
	private String intoManageDate(String cdmType) {
		String followupDate = null;
		if (cdmType.equals(EHRConstants.DM_HBP_TYPE)) {
			followupDate = "HBP_MANAGED_DATE";
		} else if (cdmType.equals(EHRConstants.DM_DI_TYPE)) {
			followupDate = "DI_MANAGED_DATE";
		} else if (cdmType.equals(EHRConstants.DM_STROKE_TYPE)) {
			followupDate = "STROKE_MANAGED_DATE";
		} else if (cdmType.equals(EHRConstants.DM_CORONARY_TYPE)) {
			followupDate = "CORONARY_MANAGED_DATE";
		} else if (cdmType.equals(EHRConstants.DM_TUMOR_TYPE)) {
			followupDate = "TUMOR_MANAGED_DATE";
		}
		return followupDate;
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private String getHmCardDeleteStatusSql(String alias, String isDelete) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" and ( " +alias + "hbp_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "di_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "stroke_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "coronary_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "tumor_flag=" + isDelete + " )");
		return sqlBuffer.toString();
	}
}
