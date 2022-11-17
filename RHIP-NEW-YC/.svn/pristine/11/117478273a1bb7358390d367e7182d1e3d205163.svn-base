package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.statistics.ColumnMapRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 慢病统计相关
 * @author liuk
 * @since 2014年5月30日 17:05:21
 */
@Repository("hbpStatisticsDao")
public class HbpStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements IHbpStatisticsDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<Map<String, Object>> getStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate) {
		String sql = buildRecordSql(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, "", "");
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("townCode", townCode);
		mapSqlParameterSource.addValue("centreCode", centreCode);
		mapSqlParameterSource.addValue("stationCode", stationCode);
		if (null != inputBeginDate) {
			mapSqlParameterSource.addValue("inputBeginDate", inputBeginDate);
		}
		if (null != inputEndDate) {
			mapSqlParameterSource.addValue("inputEndDate", inputEndDate);
		}
		List<Map<String, Object>> data = query(sql, mapSqlParameterSource);
		return data;
	}

	private String buildRecordSql(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType, String gender) {
		String sql = null;

        // %2$s 登记人数 >管理卡创建时间==>//纳入管理时间
        // %3$s 随访数量 >随访时间
        // %4$s 管理人数 >管理卡纳入管理时间
        // %5$s 管理人数 >随访时间
        // %6$s 规范化管理人数 >管理卡纳入管理时间
        // %7$s 规范化管理人数 >随访时间
        // %8$s 规范化管理人数  >随访时间
        // %9$s 规范化管理人数 >管理卡纳入管理时间 >随访时间

        // %1$s 机构
        // %10$s 机构

        String dmCreateDate=buildRecordWhereCondition(inputBeginDate,inputEndDate);
        String followupDate=buildFollowupWhereCondition(inputBeginDate,inputEndDate);
        String dmManageDate=buildHbpManageWhereCondition(inputBeginDate, inputEndDate);

        String[] condition={"",dmManageDate,followupDate,dmManageDate,followupDate,dmManageDate,followupDate,followupDate,dmManageDate,""};
		switch (orgType) {
		case "0": {

            if (ObjectUtil.isNotEmpty(townCode)) {
                condition[0]= "AND GB_CODE=:townCode";
                condition[9]= "AND DM.CREATE_GBCODE=:townCode";
                sql = String.format(getQueryByTown(),condition);
            } else {
                condition[0]= "";
                condition[9]= "";
                sql = String.format(getQueryByTown(),condition);
            }
			break;
		}
		case "B100": {

            if (ObjectUtil.isNotEmpty(centreCode)) {
                condition[0]= "AND ORGAN_CODE=:centreCode";
                condition[9]= "AND DM.CREATE_CENTER_ORGAN_CODE=:centreCode";
                sql = String.format(getCenterSql(),condition);
            } else if (ObjectUtil.isNotEmpty(townCode)) {
                condition[0]= "AND GB_CODE=:townCode";
                condition[9]= "AND DM.CREATE_GBCODE=:townCode";
                sql = String.format(getCenterSql(),condition);
            } else {
                condition[0]= "";
                condition[9]= "";
                sql = String.format(getCenterSql(),condition);
            }

			break;
		}
		case "B200": {
			if (ObjectUtil.isNotEmpty(stationCode)) {
                condition[0]= "AND ORGAN_CODE=:stationCode";
                condition[9]= "AND DM.CREATE_ORGAN_CODE=:stationCode";
				sql = String.format(getStataionSql(),condition);
			} else if (ObjectUtil.isNotEmpty(centreCode)) {
                condition[0]= "AND PARENT_CODE=:centreCode";
                condition[9]= "AND DM.CREATE_CENTER_ORGAN_CODE=:centreCode";
                sql = String.format(getStataionSql(),condition);
			} else if (ObjectUtil.isNotEmpty(townCode)) {
                condition[0]= "AND GB_CODE=:townCode";
                condition[9]= "AND DM.CREATE_GBCODE=:townCode";
                sql = String.format(getStataionSql(),condition);
			} else {
                condition[0]= "";
                condition[9]= "";
                sql = String.format(getStataionSql(),condition);
			}
			break;
		}
		}
		return sql;
	}


    private String buildFollowupWhereCondition(Date inputBeginDate, Date inputEndDate) {
        StringBuilder where = new StringBuilder();
        if (null != inputBeginDate) {
            where.append(" and DF.CREATE_DATE>=:inputBeginDate ");
        }
        if (null != inputEndDate) {
            where.append(" and DF.CREATE_DATE<=:inputEndDate ");
        }
        return where.toString();
    }

	private String buildRecordWhereCondition(Date inputBeginDate, Date inputEndDate) {
		StringBuilder where = new StringBuilder();
		if (null != inputBeginDate) {
			where.append(" and DM.CREATE_DATE>=:inputBeginDate ");
		}
		if (null != inputEndDate) {
			where.append(" and DM.CREATE_DATE<=:inputEndDate ");
		}
		return where.toString();
	}


    private String buildHbpManageWhereCondition(Date inputBeginDate, Date inputEndDate) {
        StringBuilder where = new StringBuilder();
        if (null != inputBeginDate) {
            where.append(" and DM.HBP_MANAGED_DATE>=:inputBeginDate ");
        }
        if (null != inputEndDate) {
            where.append(" and DM.HBP_MANAGED_DATE<=:inputEndDate ");
        }
        return where.toString();
    }

    private String buildDiManageWhereCondition(Date inputBeginDate, Date inputEndDate, String householdType, String gender) {
        StringBuilder where = new StringBuilder();
        if (null != inputBeginDate) {
            where.append(" and DI_MANAGED_DATE>=:inputBeginDate ");
        }
        if (null != inputEndDate) {
            where.append(" and DI_MANAGED_DATE<=:inputEndDate ");
        }
        return where.toString();
    }

	//@foff
    public String getQueryByTown(){
        return "--高血压登记数\n" +
                "SELECT\n" +
                "	ORG.TARGET_CODE,\n" +
                "	ORG.TARGET_NAME,\n" +
                "	A .HBP_ONE,\n" +
                "	A .HBP_TWO,\n" +
                "	A .HBP_THREE,\n" +
                "	B.HBP_FOLLOWUP_COUNT,\n" +
                "	C.HBP_MANAGED_COUNT,\n" +
                "	D .HBP_MANAGED_LIMIT_COUNT,\n" +
                "	E .HBP_FOLLOWUP_WELL_COUNT\n" +
                "FROM\n" +
                "	(\n" +

                " SELECT GB_CODE TARGET_CODE ,GB_NAME TARGET_NAME  FROM V_MDM_TOWN WHERE 1=1 %1$s  UNION  ALL SELECT '-1' AS TARGET_CODE ,'' TARGET_NAME FROM DUAL\n" +

                "	) ORG\n" +
                "LEFT JOIN (\n" +
                "	--慢病登记人数\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (CREATE_GBCODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			CREATE_GBCODE\n" +
                "		) TARGET_CODE,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 1 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_ONE,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 2 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_TWO,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 3 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_THREE\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				DECODE (\n" +
                "					GROUPING_ID (DM.CREATE_GBCODE),\n" +
                "					1,\n" +
                "					'-1',\n" +
                "					DM.CREATE_GBCODE\n" +
                "				) CREATE_GBCODE,\n" +
                "				DM.HBP_MANAGE_LEVEL,\n" +
                "				COUNT (1) TOTAL\n" +
                "			FROM\n" +
                "				V_DM_DISEASE_INFO DM\n" +
                "			WHERE\n" +
                "				DM.HBP_FLAG = '2'   %2$s %10$s\n" +
                "			GROUP BY\n" +
                "				DM.CREATE_GBCODE,\n" +
                "				DM.HBP_MANAGE_LEVEL\n" +
                "		)\n" +
                "	GROUP BY\n" +
                "		ROLLUP (CREATE_GBCODE)\n" +
                ") A ON ORG.TARGET_CODE = A .TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--高血压随访数量\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_GBCODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_GBCODE\n" +
                "		) TARGET_CODE,\n" +
                "		\"COUNT\" (1) HBP_FOLLOWUP_COUNT\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	INNER JOIN DM_HYPERTENSION_FOLLOWUP DF ON DM.PERSON_ID = DF.PERSON_ID\n" +
                "	WHERE\n" +
                "		DM.HBP_FLAG = '2'  %3$s %10$s\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_GBCODE)\n" +
                ") B ON A .TARGET_CODE = B.TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算管理人数\n" +
                "	SELECT\n" +
                "		\"COUNT\" (1) HBP_MANAGED_COUNT,\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_GBCODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_GBCODE\n" +
                "		) TARGET_CODE\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	WHERE\n" +
                "		DM.HBP_FLAG = '2'  %4$s %10$s\n" +
                "	AND EXISTS (\n" +
                "		SELECT\n" +
                "			2\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF\n" +
                "		WHERE\n" +
                "			DM.PERSON_ID = DF.PERSON_ID  %5$s \n" +
                "	)\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_GBCODE)\n" +
                ") C ON B.TARGET_CODE = C.TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算规范话随访\n" +
                "	SELECT\n" +
                "		\"COUNT\" (1) HBP_MANAGED_LIMIT_COUNT,\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DMM.CREATE_GBCODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DMM.CREATE_GBCODE\n" +
                "		) TARGET_CODE\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				CREATE_GBCODE,\n" +
                "				PERSON_ID,\n" +
                "				TRUNC (\n" +
                "					MONTHS_BETWEEN (\n" +
                "						SYSDATE,\n" +
                "						DM.HBP_MANAGED_DATE\n" +
                "					) / 3\n" +
                "				) REQUIRED_COUNT\n" +
                "			FROM\n" +
                "				V_DM_DISEASE_INFO DM\n" +
                "			WHERE\n" +
                "				DM.HBP_FLAG = '2'  %6$s %10$s\n" +
                "		) DMM\n" +
                "	INNER JOIN (\n" +
                "		SELECT\n" +
                "			DF.PERSON_ID,\n" +
                "			COUNT (1) TOTAL\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF WHERE 1=1 %7$s\n" +
                "		GROUP BY\n" +
                "			DF.PERSON_ID\n" +
                "	) DF ON DMM.PERSON_ID = DF.PERSON_ID\n" +
                "	AND DMM.REQUIRED_COUNT <= DF.TOTAL\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DMM.CREATE_GBCODE)\n" +
                ") D ON C.TARGET_CODE = D .TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算血压达标人数\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_GBCODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_GBCODE\n" +
                "		) TARGET_CODE,\n" +
                "		\"COUNT\" (1) HBP_FOLLOWUP_WELL_COUNT\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	\n" +
                "	INNER JOIN DM_HYPERTENSION_FOLLOWUP DFL ON DM.PERSON_ID = DFL.PERSON_ID\n" +
                "	INNER JOIN (\n" +
                "		SELECT\n" +
                "			DF.PERSON_ID,\n" +
                "			\"MAX\" (DF.ID) ID\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF WHERE 1=1 %8$s\n" +
                "		GROUP BY\n" +
                "			DF.PERSON_ID\n" +
                "	) DF ON DF.PERSON_ID = DFL.PERSON_ID\n" +
                "	AND DFL.ID = DF.ID\n" +
                "	WHERE\n" +
                "		DFL.SBP < "+EHRConstants.SBP_OK_VALUE[1]+" AND  DFL.SBP > "+EHRConstants.SBP_OK_VALUE[0]+"\n" +
                "	AND DFL.DBP < "+EHRConstants.DBP_OK_VALUE[1]+" AND  DFL.DBP > "+EHRConstants.DBP_OK_VALUE[0]+" \n" +
                "	AND 	DM.HBP_FLAG = '2'  %9$s %10$s\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_GBCODE)\n" +
                ") E ON D .TARGET_CODE = E .TARGET_CODE";
    }

    public String getCenterSql(){
        return "--高血压登记数\n" +
                "SELECT\n" +
                "	ORG.TARGET_CODE,\n" +
                "	ORG.TARGET_NAME,\n" +
                "	A .HBP_ONE,\n" +
                "	A .HBP_TWO,\n" +
                "	A .HBP_THREE,\n" +
                "	B.HBP_FOLLOWUP_COUNT,\n" +
                "	C.HBP_MANAGED_COUNT,\n" +
                "	D .HBP_MANAGED_LIMIT_COUNT,\n" +
                "	E .HBP_FOLLOWUP_WELL_COUNT\n" +
                "FROM\n" +
                "	(\n" +
                "		SELECT\n" +
                "			ORGAN_CODE TARGET_CODE,\n" +
                "			ORGAN_NAME TARGET_NAME\n" +
                "		FROM\n" +
                "			V_MDM_ORGANIZATION_NOSUB\n" +
                "		WHERE\n" +
                "			GENRE_CODE = 'B100' %1$s \n" +
                "		UNION ALL\n" +
                "			SELECT\n" +
                "				'-1' AS TARGET_CODE,\n" +
                "				'合计' TARGET_NAME\n" +
                "			FROM\n" +
                "				DUAL\n" +
                "	) ORG\n" +
                "LEFT JOIN (\n" +
                "	--慢病登记人数\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (CREATE_CENTER_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			CREATE_CENTER_ORGAN_CODE\n" +
                "		) TARGET_CODE,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 1 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_ONE,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 2 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_TWO,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 3 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_THREE\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				DECODE (\n" +
                "					GROUPING_ID (DM.CREATE_CENTER_ORGAN_CODE),\n" +
                "					1,\n" +
                "					'-1',\n" +
                "					DM.CREATE_CENTER_ORGAN_CODE\n" +
                "				) CREATE_CENTER_ORGAN_CODE,\n" +
                "				DM.HBP_MANAGE_LEVEL,\n" +
                "				COUNT (1) TOTAL\n" +
                "			FROM\n" +
                "				V_DM_DISEASE_INFO DM\n" +
                "			WHERE\n" +
                "				DM.HBP_FLAG = '2'   %2$s %10$s\n" +
                "			GROUP BY\n" +
                "				DM.CREATE_CENTER_ORGAN_CODE,\n" +
                "				DM.HBP_MANAGE_LEVEL\n" +
                "		)\n" +
                "	GROUP BY\n" +
                "		ROLLUP (CREATE_CENTER_ORGAN_CODE)\n" +
                ") A ON ORG.TARGET_CODE = A .TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--高血压随访数量\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_CENTER_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_CENTER_ORGAN_CODE\n" +
                "		) TARGET_CODE,\n" +
                "		\"COUNT\" (1) HBP_FOLLOWUP_COUNT\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	INNER JOIN DM_HYPERTENSION_FOLLOWUP DF ON DM.PERSON_ID = DF.PERSON_ID\n" +
                "	WHERE\n" +
                "		DM.HBP_FLAG = '2'   %3$s %10$s\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_CENTER_ORGAN_CODE)\n" +
                ") B ON A .TARGET_CODE = B.TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算管理人数\n" +
                "	SELECT\n" +
                "		\"COUNT\" (1) HBP_MANAGED_COUNT,\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_CENTER_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_CENTER_ORGAN_CODE\n" +
                "		) TARGET_CODE\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	WHERE\n" +
                "		DM.HBP_FLAG = '2'   %4$s %10$s\n" +
                "	AND EXISTS (\n" +
                "		SELECT\n" +
                "			2\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF\n" +
                "		WHERE\n" +
                "			DM.PERSON_ID = DF.PERSON_ID  %5$s \n" +
                "	)\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_CENTER_ORGAN_CODE)\n" +
                ") C ON B.TARGET_CODE = C.TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算规范话随访\n" +
                "	SELECT\n" +
                "		\"COUNT\" (1) HBP_MANAGED_LIMIT_COUNT,\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DMM.CREATE_CENTER_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DMM.CREATE_CENTER_ORGAN_CODE\n" +
                "		) TARGET_CODE\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				CREATE_CENTER_ORGAN_CODE,\n" +
                "				PERSON_ID,\n" +
                "				TRUNC (\n" +
                "					MONTHS_BETWEEN (\n" +
                "						SYSDATE,\n" +
                "						DM.HBP_MANAGED_DATE\n" +
                "					) / 3\n" +
                "				) REQUIRED_COUNT\n" +
                "			FROM\n" +
                "				V_DM_DISEASE_INFO DM\n" +
                "			WHERE\n" +
                "				DM.HBP_FLAG = '2'  %6$s %10$s\n" +
                "		) DMM\n" +
                "	INNER JOIN (\n" +
                "		SELECT\n" +
                "			DF.PERSON_ID,\n" +
                "			COUNT (1) TOTAL\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF WHERE 1=1 %7$s\n" +
                "		GROUP BY\n" +
                "			DF.PERSON_ID\n" +
                "	) DF ON DMM.PERSON_ID = DF.PERSON_ID\n" +
                "	AND DMM.REQUIRED_COUNT <= DF.TOTAL\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DMM.CREATE_CENTER_ORGAN_CODE)\n" +
                ") D ON C.TARGET_CODE = D .TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算血压达标人数\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_CENTER_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_CENTER_ORGAN_CODE\n" +
                "		) TARGET_CODE,\n" +
                "		\"COUNT\" (1) HBP_FOLLOWUP_WELL_COUNT\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	\n" +
                "	INNER JOIN DM_HYPERTENSION_FOLLOWUP DFL ON DM.PERSON_ID = DFL.PERSON_ID\n" +
                "	INNER JOIN (\n" +
                "		SELECT\n" +
                "			DF.PERSON_ID,\n" +
                "			\"MAX\" (DF.ID) ID\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF WHERE 1=1 %8$s\n" +
                "		GROUP BY\n" +
                "			DF.PERSON_ID\n" +
                "	) DF ON DF.PERSON_ID = DFL.PERSON_ID\n" +
                "	AND DFL.ID = DF.ID\n" +
                "	WHERE\n" +
                "		DFL.SBP < "+EHRConstants.SBP_OK_VALUE[1]+" AND  DFL.SBP > "+EHRConstants.SBP_OK_VALUE[0]+"\n" +
                "	AND DFL.DBP < "+EHRConstants.DBP_OK_VALUE[1]+" AND  DFL.DBP > "+EHRConstants.DBP_OK_VALUE[0]+" \n" +
                "	AND 	DM.HBP_FLAG = '2'   %9$s %10$s\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_CENTER_ORGAN_CODE)\n" +
                ") E ON D .TARGET_CODE = E .TARGET_CODE";
    }


    public String getStataionSql(){
        return "--高血压登记数\n" +
                "SELECT\n" +
                "	ORG.TARGET_CODE,\n" +
                "	ORG.TARGET_NAME,\n" +
                "	A .HBP_ONE,\n" +
                "	A .HBP_TWO,\n" +
                "	A .HBP_THREE,\n" +
                "	B.HBP_FOLLOWUP_COUNT,\n" +
                "	C.HBP_MANAGED_COUNT,\n" +
                "	D .HBP_MANAGED_LIMIT_COUNT,\n" +
                "	E .HBP_FOLLOWUP_WELL_COUNT\n" +
                "FROM\n" +
                "	(\n" +
                "		SELECT\n" +
                "			ORGAN_CODE TARGET_CODE,\n" +
                "			ORGAN_NAME TARGET_NAME\n" +
                "		FROM\n" +
                "			V_MDM_ORGANIZATION_NOSUB\n" +
                "		WHERE\n" +
                "			GENRE_CODE = 'B200' %1$s \n" +
                "		UNION ALL\n" +
                "			SELECT\n" +
                "				'-1' AS TARGET_CODE,\n" +
                "				'合计' TARGET_NAME\n" +
                "			FROM\n" +
                "				DUAL\n" +
                "	) ORG\n" +
                "LEFT JOIN (\n" +
                "	--慢病登记人数\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (CREATE_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			CREATE_ORGAN_CODE\n" +
                "		) TARGET_CODE,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 1 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_ONE,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 2 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_TWO,\n" +
                "		SUM (\n" +
                "			CASE\n" +
                "			WHEN HBP_MANAGE_LEVEL = 3 THEN\n" +
                "				TOTAL\n" +
                "			ELSE\n" +
                "				0\n" +
                "			END\n" +
                "		) HBP_THREE\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				DECODE (\n" +
                "					GROUPING_ID (DM.CREATE_ORGAN_CODE),\n" +
                "					1,\n" +
                "					'-1',\n" +
                "					DM.CREATE_ORGAN_CODE\n" +
                "				) CREATE_ORGAN_CODE,\n" +
                "				DM.HBP_MANAGE_LEVEL,\n" +
                "				COUNT (1) TOTAL\n" +
                "			FROM\n" +
                "				V_DM_DISEASE_INFO DM\n" +
                "			WHERE\n" +
                "				DM.HBP_FLAG = '2'   %2$s %10$s\n" +
                "			GROUP BY\n" +
                "				DM.CREATE_ORGAN_CODE,\n" +
                "				DM.HBP_MANAGE_LEVEL\n" +
                "		)\n" +
                "	GROUP BY\n" +
                "		ROLLUP (CREATE_ORGAN_CODE)\n" +
                ") A ON ORG.TARGET_CODE = A .TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--高血压随访数量\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_ORGAN_CODE\n" +
                "		) TARGET_CODE,\n" +
                "		\"COUNT\" (1) HBP_FOLLOWUP_COUNT\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	INNER JOIN DM_HYPERTENSION_FOLLOWUP DF ON DM.PERSON_ID = DF.PERSON_ID\n" +
                "	WHERE\n" +
                "		DM.HBP_FLAG = '2'   %3$s %10$s\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_ORGAN_CODE)\n" +
                ") B ON A .TARGET_CODE = B.TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算管理人数\n" +
                "	SELECT\n" +
                "		\"COUNT\" (1) HBP_MANAGED_COUNT,\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_ORGAN_CODE\n" +
                "		) TARGET_CODE\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	WHERE\n" +
                "		DM.HBP_FLAG = '2'   %4$s %10$s\n" +
                "	AND EXISTS (\n" +
                "		SELECT\n" +
                "			2\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF\n" +
                "		WHERE\n" +
                "			DM.PERSON_ID = DF.PERSON_ID  %5$s \n" +
                "	)\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_ORGAN_CODE)\n" +
                ") C ON B.TARGET_CODE = C.TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算规范话随访\n" +
                "	SELECT\n" +
                "		\"COUNT\" (1) HBP_MANAGED_LIMIT_COUNT,\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DMM.CREATE_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DMM.CREATE_ORGAN_CODE\n" +
                "		) TARGET_CODE\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				CREATE_ORGAN_CODE,\n" +
                "				PERSON_ID,\n" +
                "				TRUNC (\n" +
                "					MONTHS_BETWEEN (\n" +
                "						SYSDATE,\n" +
                "						DM.HBP_MANAGED_DATE\n" +
                "					) / 3\n" +
                "				) REQUIRED_COUNT\n" +
                "			FROM\n" +
                "				V_DM_DISEASE_INFO DM\n" +
                "			WHERE\n" +
                "				DM.HBP_FLAG = '2'   %6$s %10$s\n" +
                "		) DMM\n" +
                "	INNER JOIN (\n" +
                "		SELECT\n" +
                "			DF.PERSON_ID,\n" +
                "			COUNT (1) TOTAL\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF WHERE 1=1 %7$s\n" +
                "		GROUP BY\n" +
                "			DF.PERSON_ID\n" +
                "	) DF ON DMM.PERSON_ID = DF.PERSON_ID\n" +
                "	AND DMM.REQUIRED_COUNT <= DF.TOTAL\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DMM.CREATE_ORGAN_CODE)\n" +
                ") D ON C.TARGET_CODE = D .TARGET_CODE\n" +
                "LEFT JOIN (\n" +
                "	--计算血压达标人数\n" +
                "	SELECT\n" +
                "		DECODE (\n" +
                "			GROUPING_ID (DM.CREATE_ORGAN_CODE),\n" +
                "			1,\n" +
                "			'-1',\n" +
                "			DM.CREATE_ORGAN_CODE\n" +
                "		) TARGET_CODE,\n" +
                "		\"COUNT\" (1) HBP_FOLLOWUP_WELL_COUNT\n" +
                "	FROM\n" +
                "		V_DM_DISEASE_INFO DM\n" +
                "	\n" +
                "	INNER JOIN DM_HYPERTENSION_FOLLOWUP DFL ON DM.PERSON_ID = DFL.PERSON_ID\n" +
                "	INNER JOIN (\n" +
                "		SELECT\n" +
                "			DF.PERSON_ID,\n" +
                "			\"MAX\" (DF.ID) ID\n" +
                "		FROM\n" +
                "			DM_HYPERTENSION_FOLLOWUP DF WHERE 1=1 %8$s\n" +
                "		GROUP BY\n" +
                "			DF.PERSON_ID\n" +
                "	) DF ON DF.PERSON_ID = DFL.PERSON_ID\n" +
                "	AND DFL.ID = DF.ID\n" +
                "	WHERE\n" +
                "		DFL.SBP < "+EHRConstants.SBP_OK_VALUE[1]+" AND  DFL.SBP > "+EHRConstants.SBP_OK_VALUE[0]+"\n" +
                "	AND DFL.DBP < "+EHRConstants.DBP_OK_VALUE[1]+" AND  DFL.DBP > "+EHRConstants.DBP_OK_VALUE[0]+" \n" +
                "	AND 	DM.HBP_FLAG = '2'   %9$s %10$s\n" +
                "	GROUP BY\n" +
                "		ROLLUP (DM.CREATE_ORGAN_CODE)\n" +
                ") E ON D .TARGET_CODE = E .TARGET_CODE";
    }
    //@fon
	private List<Map<String, Object>> query(String sql, MapSqlParameterSource sqlParameterSource) {
		if (null == sqlParameterSource) {
			return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper());
		}
		return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper(), sqlParameterSource);
	}

}
