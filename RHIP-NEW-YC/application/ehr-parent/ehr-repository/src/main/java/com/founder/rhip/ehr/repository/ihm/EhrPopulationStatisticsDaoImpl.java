package com.founder.rhip.ehr.repository.ihm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.statistics.ColumnMapRowMapper;

/**
 * 人口数统计
 *
 * @author liuk
 *
 */
@Repository("ehrPopulationStatisticsDao")
public class EhrPopulationStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements IEhrPopulationStatisticsDao {

	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;


    @Override
	public List<Map<String, Object>> getPopulationStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType, String gender) {
		String sql = buildRecordSql(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, householdType,gender);
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
		if (ObjectUtil.isNotEmpty(gender)) {
			mapSqlParameterSource.addValue("gender", gender);
		}
        if (ObjectUtil.isNotEmpty(householdType)) {
            mapSqlParameterSource.addValue("householdType", householdType);
        }
		List<Map<String, Object>> data = query(sql, mapSqlParameterSource);
		return data;
	}

    private String buildRecordSql(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType,String gender) {
        String sql = null;
        String recordWhere = buildRecordWhereCondition(inputBeginDate, inputEndDate, householdType,gender);
        switch (orgType) {
            case "0": {
                if (ObjectUtil.isNotEmpty(townCode)) {
                    sql = String.format(getQueryByTown(), "AND GB_CODE=:townCode", "AND GB_CODE=:townCode", recordWhere);
                } else {
                    sql = String.format(getQueryByTown(), "", "AND GB_CODE is not null",  recordWhere);
                }
                break;
            }
            case EHRConstants.SQFWZX_CODE: {
                if (ObjectUtil.isNotEmpty(centreCode)) {
                    sql = String.format(getCenterSql(), "AND ORGAN_CODE=:centreCode", "AND PARENT_CODE=:centreCode",  recordWhere);
                } else if (ObjectUtil.isNotEmpty(townCode)) {
                    sql = String.format(getCenterSql(), "AND GB_CODE=:townCode", "AND GB_CODE=:townCode",  recordWhere);
                } else {
                    sql = String.format(getCenterSql(), "", "", recordWhere);
                }
                break;
            }
            case EHRConstants.SQFWZ_CODE: {
                if (ObjectUtil.isNotEmpty(stationCode)) {
                    sql = String.format(getStataionSql(), "AND ORGAN_CODE=:stationCode", "AND ORGAN_CODE=:stationCode",recordWhere);
                } else if (ObjectUtil.isNotEmpty(centreCode)) {
                    sql = String.format(getStataionSql(), "AND PARENT_CODE=:centreCode", "AND PARENT_CODE=:centreCode",  recordWhere);
                } else if (ObjectUtil.isNotEmpty(townCode)) {
                    sql = String.format(getStataionSql(), "AND GB_CODE=:townCode", "AND GB_CODE=:townCode", recordWhere);
                } else {
                    sql = String.format(getStataionSql(), "", "", recordWhere );
                }
                break;
            }
        }
        return sql;
    }

	private String buildRecordWhereCondition(Date inputBeginDate, Date inputEndDate, String householdType,String gender) {
		StringBuilder where = new StringBuilder();
		if (null != inputBeginDate) {
			where.append(" and INPUT_DATE>=:inputBeginDate ");
		}
		if (null != inputEndDate) {
			where.append(" and INPUT_DATE<=:inputEndDate ");
		}
		if (ObjectUtil.isNotEmpty(householdType)) {
			where.append(" and HOUSEHOLD_TYPE=:householdType ");
		}
        if (ObjectUtil.isNotEmpty(gender)){
            where.append(" and GENDER=:gender ");
        }
		return where.toString();
	}

	//@foff
    private String getQueryByTown(){
        return "SELECT TOWN.TARGET_NAME  ,POP.* FROM \n" +
                "(SELECT GB_CODE TARGET_CODE ,GB_NAME TARGET_NAME  FROM V_MDM_TOWN WHERE 1=1 %1$s  UNION  ALL SELECT '-1' AS TARGET_CODE ,'' TARGET_NAME FROM DUAL)  TOWN\n" +
                "LEFT JOIN \n" +
                "(SELECT DECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "SUM(CASE WHEN L <1  THEN TOTAL ELSE 0 END ) AS ZERO,\n" +
                "		SUM(CASE  WHEN L<1 AND Gender=1  THEN TOTAL ELSE 0 END ) AS ZERO1,\n" +
                "		SUM(CASE  WHEN L<1 AND Gender=2   THEN TOTAL ELSE 0 END ) AS ZERO2,\n" +
                "		SUM(CASE L WHEN 1 THEN TOTAL ELSE 0 END ) AS ONE,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS ONE1,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS ONE2,\n" +
                "		SUM(CASE L WHEN 2 THEN TOTAL ELSE 0 END ) AS TWO,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS TWO1,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS TWO2,\n" +
                "		SUM(CASE L WHEN 3 THEN TOTAL ELSE 0 END ) AS THREE,\n" +
                "		SUM(CASE WHEN L=3 AND Gender=1 THEN TOTAL ELSE 0 END ) AS THREE1,\n" +
                "		SUM(CASE WHEN L=3 AND Gender=2 THEN TOTAL ELSE 0 END ) AS THREE2,\n" +
                "		SUM(CASE L WHEN 4 THEN TOTAL ELSE 0 END ) AS FOUR,\n" +
                "		SUM(CASE WHEN L=4 AND Gender=1 THEN TOTAL ELSE 0 END ) AS FOUR1,\n" +
                "		SUM(CASE WHEN L=4 AND Gender=2 THEN TOTAL ELSE 0 END ) AS FOUR2,\n" +
                "		SUM(CASE L WHEN 5 THEN TOTAL ELSE 0 END ) AS FIVE,\n" +
                "		SUM(CASE WHEN L=5 AND Gender=1 THEN TOTAL ELSE 0 END ) AS FIVE1,\n" +
                "		SUM(CASE WHEN L=5 AND Gender=2 THEN TOTAL ELSE 0 END ) AS FIVE2,\n" +
                "		SUM(CASE L WHEN 6 THEN TOTAL ELSE 0 END ) AS SIX,\n" +
                "		SUM(CASE WHEN L=6 AND Gender=1 THEN TOTAL ELSE 0 END ) AS SIX1,\n" +
                "		SUM(CASE WHEN L=6 AND Gender=2 THEN TOTAL ELSE 0 END ) AS SIX2,\n" +
                "		SUM(CASE L WHEN 7 THEN TOTAL ELSE 0 END ) AS SEVEN,\n" +
                "		SUM(CASE WHEN L=7 AND Gender=1 THEN TOTAL ELSE 0 END ) AS SEVEN1,\n" +
                "		SUM(CASE WHEN L=7 AND Gender=2 THEN TOTAL ELSE 0 END ) AS SEVEN2,\n" +
                "		SUM(CASE L WHEN 8 THEN TOTAL ELSE 0 END ) AS EIGHT,\n" +
                "		SUM(CASE  WHEN L=8 AND Gender=1 THEN TOTAL ELSE 0 END ) AS EIGHT1,\n" +
                "		SUM(CASE  WHEN L=8 AND Gender=2 THEN TOTAL ELSE 0 END ) AS EIGHT2,\n" +
                "		SUM(CASE L WHEN 9 THEN TOTAL ELSE 0 END ) AS NINE,\n" +
                "		SUM(CASE  WHEN L=9 AND Gender=1 THEN TOTAL ELSE 0 END ) AS NINE1,\n" +
                "		SUM(CASE  WHEN L=9 AND Gender=2 THEN TOTAL ELSE 0 END ) AS NINE2,\n" +
                "		SUM(CASE L WHEN 10 THEN TOTAL ELSE 0 END ) AS TEN,\n" +
                "		SUM(CASE  WHEN L=10 AND Gender=1 THEN TOTAL ELSE 0 END ) AS TEN1,\n" +
                "		SUM(CASE  WHEN L=10 AND Gender=2 THEN TOTAL ELSE 0 END ) AS TEN2,\n" +
                "		SUM(CASE L WHEN 11 THEN TOTAL ELSE 0 END ) AS ELEVEN,\n" +
                "		SUM(CASE  WHEN L=11 AND Gender=1 THEN TOTAL ELSE 0 END ) AS ELEVEN1,\n" +
                "		SUM(CASE  WHEN L=11 AND Gender=2 THEN TOTAL ELSE 0 END ) AS ELEVEN2,\n" +
                "		SUM(CASE L WHEN 12 THEN TOTAL ELSE 0 END ) AS TWELVE,\n" +
                "		SUM(CASE  WHEN L=12 AND Gender=1  THEN TOTAL ELSE 0 END ) AS TWELVE1,\n" +
                "		SUM(CASE  WHEN L=12 AND Gender=2  THEN TOTAL ELSE 0 END ) AS TWELVE2,\n" +
                "		SUM(CASE L WHEN 13 THEN TOTAL ELSE 0 END ) AS THIRTEEN,\n" +
                "		SUM(CASE  WHEN L=13 AND Gender=1  THEN TOTAL ELSE 0 END ) AS THIRTEEN1,\n" +
                "		SUM(CASE  WHEN L=13 AND Gender=2  THEN TOTAL ELSE 0 END ) AS THIRTEEN2,\n" +
                "		SUM(CASE L WHEN 14 THEN TOTAL ELSE 0 END ) AS FOURTEEN,\n" +
                "		SUM(CASE  WHEN L=14 AND Gender=1  THEN TOTAL ELSE 0 END ) AS FOURTEEN1,\n" +
                "		SUM(CASE  WHEN L=14 AND Gender=2  THEN TOTAL ELSE 0 END ) AS FOURTEEN2,\n" +
                "		SUM(CASE L WHEN 15 THEN TOTAL ELSE 0 END ) AS FIFTEEN,\n" +
                "		SUM(CASE  WHEN L=15 AND Gender=1  THEN TOTAL ELSE 0 END ) AS FIFTEEN1,\n" +
                "		SUM(CASE  WHEN L=15 AND Gender=2  THEN TOTAL ELSE 0 END ) AS FIFTEEN2,\n" +
                "		SUM(CASE L WHEN 16 THEN TOTAL ELSE 0 END ) AS SIXTEEN,\n" +
                "		SUM(CASE  WHEN L=16 AND Gender=1  THEN TOTAL ELSE 0 END ) AS SIXTEEN1,\n" +
                "		SUM(CASE  WHEN L=16 AND Gender=2  THEN TOTAL ELSE 0 END ) AS SIXTEEN2,\n" +
                "		SUM(CASE L WHEN 17 THEN TOTAL ELSE 0 END ) AS SEVENTEEN,\n" +
                "		SUM(CASE  WHEN L=17 AND Gender=1  THEN TOTAL ELSE 0 END ) AS SEVENTEEN1,\n" +
                "		SUM(CASE  WHEN L=17 AND Gender=2  THEN TOTAL ELSE 0 END ) AS SEVENTEEN2,\n" +
                "		SUM(CASE  WHEN L >=18 THEN TOTAL ELSE 0 END ) AS EIGHTEEN,\n" +
                "		SUM(CASE   WHEN L>=18 AND Gender=1  THEN TOTAL ELSE 0 END ) AS EIGHTEEN1,\n" +
                "		SUM(CASE   WHEN L>=18 AND Gender=2  THEN TOTAL ELSE 0 END ) AS EIGHTEEN2\n"+
                " FROM (\n" +
                "			SELECT\n" +
                "				TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ) L,\n" +
                "				COUNT (1) TOTAL,\n" +
                "				TARGET_CODE,GENDER\n" +
                "			FROM\n" +
                "				(\n" +
                "					SELECT\n" +
                "						ORG.TARGET_CODE ,\n" +
                "						PER.HOUSEHOLD_TYPE,\n" +
                "						ORG.ORGAN_CODE,\n" +
                "						BIRTHDAY,Gender\n" +
                "					FROM\n" +
                "						(\n" +
                "							SELECT\n" +
                "								GB_CODE TARGET_CODE,\n" +
                "								ORGAN_CODE\n" +
                "							FROM\n" +
                "								V_MDM_ORGANIZATION_NOSUB\n" +
                "							WHERE\n" +
                "								GENRE_CODE = '"+EHRConstants.SQFWZ_CODE+"' %2$s \n" +
                "							AND GB_CODE IS NOT NULL\n" +
                "						) ORG\n" +
                "					INNER JOIN (\n" +
                "						SELECT\n" +
                "							INPUT_ORGAN_CODE,\n" +
                "							HOUSEHOLD_TYPE,\n" +
                "							BIRTHDAY,Gender\n" +
                "						FROM\n" +
                "							BI_PERSON_INFO\n" +
                "						WHERE\n" +
                "							FILING_FLAG = '1' %3$s\n" +
                "					) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "				)\n" +
                "			GROUP BY\n" +
                "				TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ),\n" +
                "				TARGET_CODE,Gender\n" +
                ")\n" +
                "GROUP BY rollup(TARGET_CODE)) POP ON town.TARGET_CODE=pop.TARGET_CODE";
    }


    private String getCenterSql(){
        return "SELECT TOWN.TARGET_NAME  ,POP.* FROM \n" +
                "(SELECT ORGAN_CODE TARGET_CODE,ORGAN_NAME  TARGET_NAME FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = '"+EHRConstants.SQFWZX_CODE+"'  %1$s UNION ALL SELECT '-1' AS TARGET_CODE ,'合计' TARGET_NAME FROM DUAL)  TOWN\n" +
                "LEFT JOIN \n" +
                "(SELECT DECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "SUM(CASE WHEN L <1  THEN TOTAL ELSE 0 END ) AS ZERO,\n" +
                "		SUM(CASE  WHEN L<1 AND Gender=1  THEN TOTAL ELSE 0 END ) AS ZERO1,\n" +
                "		SUM(CASE  WHEN L<1 AND Gender=2   THEN TOTAL ELSE 0 END ) AS ZERO2,\n" +
                "		SUM(CASE L WHEN 1 THEN TOTAL ELSE 0 END ) AS ONE,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS ONE1,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS ONE2,\n" +
                "		SUM(CASE L WHEN 2 THEN TOTAL ELSE 0 END ) AS TWO,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS TWO1,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS TWO2,\n" +
                "		SUM(CASE L WHEN 3 THEN TOTAL ELSE 0 END ) AS THREE,\n" +
                "		SUM(CASE WHEN L=3 AND Gender=1 THEN TOTAL ELSE 0 END ) AS THREE1,\n" +
                "		SUM(CASE WHEN L=3 AND Gender=2 THEN TOTAL ELSE 0 END ) AS THREE2,\n" +
                "		SUM(CASE L WHEN 4 THEN TOTAL ELSE 0 END ) AS FOUR,\n" +
                "		SUM(CASE WHEN L=4 AND Gender=1 THEN TOTAL ELSE 0 END ) AS FOUR1,\n" +
                "		SUM(CASE WHEN L=4 AND Gender=2 THEN TOTAL ELSE 0 END ) AS FOUR2,\n" +
                "		SUM(CASE L WHEN 5 THEN TOTAL ELSE 0 END ) AS FIVE,\n" +
                "		SUM(CASE WHEN L=5 AND Gender=1 THEN TOTAL ELSE 0 END ) AS FIVE1,\n" +
                "		SUM(CASE WHEN L=5 AND Gender=2 THEN TOTAL ELSE 0 END ) AS FIVE2,\n" +
                "		SUM(CASE L WHEN 6 THEN TOTAL ELSE 0 END ) AS SIX,\n" +
                "		SUM(CASE WHEN L=6 AND Gender=1 THEN TOTAL ELSE 0 END ) AS SIX1,\n" +
                "		SUM(CASE WHEN L=6 AND Gender=2 THEN TOTAL ELSE 0 END ) AS SIX2,\n" +
                "		SUM(CASE L WHEN 7 THEN TOTAL ELSE 0 END ) AS SEVEN,\n" +
                "		SUM(CASE WHEN L=7 AND Gender=1 THEN TOTAL ELSE 0 END ) AS SEVEN1,\n" +
                "		SUM(CASE WHEN L=7 AND Gender=2 THEN TOTAL ELSE 0 END ) AS SEVEN2,\n" +
                "		SUM(CASE L WHEN 8 THEN TOTAL ELSE 0 END ) AS EIGHT,\n" +
                "		SUM(CASE  WHEN L=8 AND Gender=1 THEN TOTAL ELSE 0 END ) AS EIGHT1,\n" +
                "		SUM(CASE  WHEN L=8 AND Gender=2 THEN TOTAL ELSE 0 END ) AS EIGHT2,\n" +
                "		SUM(CASE L WHEN 9 THEN TOTAL ELSE 0 END ) AS NINE,\n" +
                "		SUM(CASE  WHEN L=9 AND Gender=1 THEN TOTAL ELSE 0 END ) AS NINE1,\n" +
                "		SUM(CASE  WHEN L=9 AND Gender=2 THEN TOTAL ELSE 0 END ) AS NINE2,\n" +
                "		SUM(CASE L WHEN 10 THEN TOTAL ELSE 0 END ) AS TEN,\n" +
                "		SUM(CASE  WHEN L=10 AND Gender=1 THEN TOTAL ELSE 0 END ) AS TEN1,\n" +
                "		SUM(CASE  WHEN L=10 AND Gender=2 THEN TOTAL ELSE 0 END ) AS TEN2,\n" +
                "		SUM(CASE L WHEN 11 THEN TOTAL ELSE 0 END ) AS ELEVEN,\n" +
                "		SUM(CASE  WHEN L=11 AND Gender=1 THEN TOTAL ELSE 0 END ) AS ELEVEN1,\n" +
                "		SUM(CASE  WHEN L=11 AND Gender=2 THEN TOTAL ELSE 0 END ) AS ELEVEN2,\n" +
                "		SUM(CASE L WHEN 12 THEN TOTAL ELSE 0 END ) AS TWELVE,\n" +
                "		SUM(CASE  WHEN L=12 AND Gender=1  THEN TOTAL ELSE 0 END ) AS TWELVE1,\n" +
                "		SUM(CASE  WHEN L=12 AND Gender=2  THEN TOTAL ELSE 0 END ) AS TWELVE2,\n" +
                "		SUM(CASE L WHEN 13 THEN TOTAL ELSE 0 END ) AS THIRTEEN,\n" +
                "		SUM(CASE  WHEN L=13 AND Gender=1  THEN TOTAL ELSE 0 END ) AS THIRTEEN1,\n" +
                "		SUM(CASE  WHEN L=13 AND Gender=2  THEN TOTAL ELSE 0 END ) AS THIRTEEN2,\n" +
                "		SUM(CASE L WHEN 14 THEN TOTAL ELSE 0 END ) AS FOURTEEN,\n" +
                "		SUM(CASE  WHEN L=14 AND Gender=1  THEN TOTAL ELSE 0 END ) AS FOURTEEN1,\n" +
                "		SUM(CASE  WHEN L=14 AND Gender=2  THEN TOTAL ELSE 0 END ) AS FOURTEEN2,\n" +
                "		SUM(CASE L WHEN 15 THEN TOTAL ELSE 0 END ) AS FIFTEEN,\n" +
                "		SUM(CASE  WHEN L=15 AND Gender=1  THEN TOTAL ELSE 0 END ) AS FIFTEEN1,\n" +
                "		SUM(CASE  WHEN L=15 AND Gender=2  THEN TOTAL ELSE 0 END ) AS FIFTEEN2,\n" +
                "		SUM(CASE L WHEN 16 THEN TOTAL ELSE 0 END ) AS SIXTEEN,\n" +
                "		SUM(CASE  WHEN L=16 AND Gender=1  THEN TOTAL ELSE 0 END ) AS SIXTEEN1,\n" +
                "		SUM(CASE  WHEN L=16 AND Gender=2  THEN TOTAL ELSE 0 END ) AS SIXTEEN2,\n" +
                "		SUM(CASE L WHEN 17 THEN TOTAL ELSE 0 END ) AS SEVENTEEN,\n" +
                "		SUM(CASE  WHEN L=17 AND Gender=1  THEN TOTAL ELSE 0 END ) AS SEVENTEEN1,\n" +
                "		SUM(CASE  WHEN L=17 AND Gender=2  THEN TOTAL ELSE 0 END ) AS SEVENTEEN2,\n" +
                "		SUM(CASE  WHEN L >=18 THEN TOTAL ELSE 0 END ) AS EIGHTEEN,\n" +
                "		SUM(CASE   WHEN L>=18 AND Gender=1  THEN TOTAL ELSE 0 END ) AS EIGHTEEN1,\n" +
                "		SUM(CASE   WHEN L>=18 AND Gender=2  THEN TOTAL ELSE 0 END ) AS EIGHTEEN2\n"+
                " FROM (\n" +
                "			SELECT\n" +
                "				TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ) L,\n" +
                "				COUNT (1) TOTAL,\n" +
                "				TARGET_CODE,GENDER\n" +
                "			FROM\n" +
                "				(\n" +
                "					SELECT\n" +
                "						ORG.TARGET_CODE ,\n" +
                "						PER.HOUSEHOLD_TYPE,\n" +
                "						ORG.ORGAN_CODE,\n" +
                "						BIRTHDAY,Gender\n" +
                "					FROM\n" +
                "						(\n" +
                "							SELECT PARENT_CODE TARGET_CODE,  ORGAN_CODE  FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B2'  %2$s \n" +
                "						) ORG\n" +
                "					INNER JOIN (\n" +
                "						SELECT\n" +
                "							INPUT_ORGAN_CODE,\n" +
                "							HOUSEHOLD_TYPE,\n" +
                "							BIRTHDAY,Gender\n" +
                "						FROM\n" +
                "							BI_PERSON_INFO\n" +
                "						WHERE\n" +
                "							FILING_FLAG = '1' %3$s\n" +
                "					) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "				)\n" +
                "			GROUP BY\n" +
                "				TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ),\n" +
                "				TARGET_CODE,Gender\n" +
                ")\n" +
                "GROUP BY rollup(TARGET_CODE)) POP ON town.TARGET_CODE=pop.TARGET_CODE";
    }


    public String getStataionSql(){
        return "SELECT TOWN.TARGET_NAME  ,POP.* FROM \n" +
                "(SELECT ORGAN_CODE TARGET_CODE,ORGAN_NAME  TARGET_NAME FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = '"+EHRConstants.SQFWZ_CODE+"' %1$s UNION ALL SELECT '-1' AS TARGET_CODE ,'合计' TARGET_NAME FROM DUAL)  TOWN\n" +
                "LEFT JOIN \n" +
                "(SELECT DECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "SUM(CASE WHEN L <1  THEN TOTAL ELSE 0 END ) AS ZERO,\n" +
                "		SUM(CASE  WHEN L<1 AND Gender=1  THEN TOTAL ELSE 0 END ) AS ZERO1,\n" +
                "		SUM(CASE  WHEN L<1 AND Gender=2   THEN TOTAL ELSE 0 END ) AS ZERO2,\n" +
                "		SUM(CASE L WHEN 1 THEN TOTAL ELSE 0 END ) AS ONE,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS ONE1,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS ONE2,\n" +
                "		SUM(CASE L WHEN 2 THEN TOTAL ELSE 0 END ) AS TWO,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS TWO1,\n" +
                "		SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS TWO2,\n" +
                "		SUM(CASE L WHEN 3 THEN TOTAL ELSE 0 END ) AS THREE,\n" +
                "		SUM(CASE WHEN L=3 AND Gender=1 THEN TOTAL ELSE 0 END ) AS THREE1,\n" +
                "		SUM(CASE WHEN L=3 AND Gender=2 THEN TOTAL ELSE 0 END ) AS THREE2,\n" +
                "		SUM(CASE L WHEN 4 THEN TOTAL ELSE 0 END ) AS FOUR,\n" +
                "		SUM(CASE WHEN L=4 AND Gender=1 THEN TOTAL ELSE 0 END ) AS FOUR1,\n" +
                "		SUM(CASE WHEN L=4 AND Gender=2 THEN TOTAL ELSE 0 END ) AS FOUR2,\n" +
                "		SUM(CASE L WHEN 5 THEN TOTAL ELSE 0 END ) AS FIVE,\n" +
                "		SUM(CASE WHEN L=5 AND Gender=1 THEN TOTAL ELSE 0 END ) AS FIVE1,\n" +
                "		SUM(CASE WHEN L=5 AND Gender=2 THEN TOTAL ELSE 0 END ) AS FIVE2,\n" +
                "		SUM(CASE L WHEN 6 THEN TOTAL ELSE 0 END ) AS SIX,\n" +
                "		SUM(CASE WHEN L=6 AND Gender=1 THEN TOTAL ELSE 0 END ) AS SIX1,\n" +
                "		SUM(CASE WHEN L=6 AND Gender=2 THEN TOTAL ELSE 0 END ) AS SIX2,\n" +
                "		SUM(CASE L WHEN 7 THEN TOTAL ELSE 0 END ) AS SEVEN,\n" +
                "		SUM(CASE WHEN L=7 AND Gender=1 THEN TOTAL ELSE 0 END ) AS SEVEN1,\n" +
                "		SUM(CASE WHEN L=7 AND Gender=2 THEN TOTAL ELSE 0 END ) AS SEVEN2,\n" +
                "		SUM(CASE L WHEN 8 THEN TOTAL ELSE 0 END ) AS EIGHT,\n" +
                "		SUM(CASE  WHEN L=8 AND Gender=1 THEN TOTAL ELSE 0 END ) AS EIGHT1,\n" +
                "		SUM(CASE  WHEN L=8 AND Gender=2 THEN TOTAL ELSE 0 END ) AS EIGHT2,\n" +
                "		SUM(CASE L WHEN 9 THEN TOTAL ELSE 0 END ) AS NINE,\n" +
                "		SUM(CASE  WHEN L=9 AND Gender=1 THEN TOTAL ELSE 0 END ) AS NINE1,\n" +
                "		SUM(CASE  WHEN L=9 AND Gender=2 THEN TOTAL ELSE 0 END ) AS NINE2,\n" +
                "		SUM(CASE L WHEN 10 THEN TOTAL ELSE 0 END ) AS TEN,\n" +
                "		SUM(CASE  WHEN L=10 AND Gender=1 THEN TOTAL ELSE 0 END ) AS TEN1,\n" +
                "		SUM(CASE  WHEN L=10 AND Gender=2 THEN TOTAL ELSE 0 END ) AS TEN2,\n" +
                "		SUM(CASE L WHEN 11 THEN TOTAL ELSE 0 END ) AS ELEVEN,\n" +
                "		SUM(CASE  WHEN L=11 AND Gender=1 THEN TOTAL ELSE 0 END ) AS ELEVEN1,\n" +
                "		SUM(CASE  WHEN L=11 AND Gender=2 THEN TOTAL ELSE 0 END ) AS ELEVEN2,\n" +
                "		SUM(CASE L WHEN 12 THEN TOTAL ELSE 0 END ) AS TWELVE,\n" +
                "		SUM(CASE  WHEN L=12 AND Gender=1  THEN TOTAL ELSE 0 END ) AS TWELVE1,\n" +
                "		SUM(CASE  WHEN L=12 AND Gender=2  THEN TOTAL ELSE 0 END ) AS TWELVE2,\n" +
                "		SUM(CASE L WHEN 13 THEN TOTAL ELSE 0 END ) AS THIRTEEN,\n" +
                "		SUM(CASE  WHEN L=13 AND Gender=1  THEN TOTAL ELSE 0 END ) AS THIRTEEN1,\n" +
                "		SUM(CASE  WHEN L=13 AND Gender=2  THEN TOTAL ELSE 0 END ) AS THIRTEEN2,\n" +
                "		SUM(CASE L WHEN 14 THEN TOTAL ELSE 0 END ) AS FOURTEEN,\n" +
                "		SUM(CASE  WHEN L=14 AND Gender=1  THEN TOTAL ELSE 0 END ) AS FOURTEEN1,\n" +
                "		SUM(CASE  WHEN L=14 AND Gender=2  THEN TOTAL ELSE 0 END ) AS FOURTEEN2,\n" +
                "		SUM(CASE L WHEN 15 THEN TOTAL ELSE 0 END ) AS FIFTEEN,\n" +
                "		SUM(CASE  WHEN L=15 AND Gender=1  THEN TOTAL ELSE 0 END ) AS FIFTEEN1,\n" +
                "		SUM(CASE  WHEN L=15 AND Gender=2  THEN TOTAL ELSE 0 END ) AS FIFTEEN2,\n" +
                "		SUM(CASE L WHEN 16 THEN TOTAL ELSE 0 END ) AS SIXTEEN,\n" +
                "		SUM(CASE  WHEN L=16 AND Gender=1  THEN TOTAL ELSE 0 END ) AS SIXTEEN1,\n" +
                "		SUM(CASE  WHEN L=16 AND Gender=2  THEN TOTAL ELSE 0 END ) AS SIXTEEN2,\n" +
                "		SUM(CASE L WHEN 17 THEN TOTAL ELSE 0 END ) AS SEVENTEEN,\n" +
                "		SUM(CASE  WHEN L=17 AND Gender=1  THEN TOTAL ELSE 0 END ) AS SEVENTEEN1,\n" +
                "		SUM(CASE  WHEN L=17 AND Gender=2  THEN TOTAL ELSE 0 END ) AS SEVENTEEN2,\n" +
                "		SUM(CASE  WHEN L >=18 THEN TOTAL ELSE 0 END ) AS EIGHTEEN,\n" +
                "		SUM(CASE   WHEN L>=18 AND Gender=1  THEN TOTAL ELSE 0 END ) AS EIGHTEEN1,\n" +
                "		SUM(CASE   WHEN L>=18 AND Gender=2  THEN TOTAL ELSE 0 END ) AS EIGHTEEN2\n"+
                " FROM (\n" +
                "			SELECT\n" +
                "				TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ) L,\n" +
                "				COUNT (1) TOTAL,\n" +
                "				TARGET_CODE,GENDER\n" +
                "			FROM\n" +
                "				(\n" +
                "					SELECT\n" +
                "						ORG.ORGAN_CODE TARGET_CODE ,\n" +
                "						PER.HOUSEHOLD_TYPE,\n" +
                "						BIRTHDAY,Gender\n" +
                "					FROM\n" +
                "						(\n" +
                "								SELECT  ORGAN_CODE  FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = '"+EHRConstants.SQFWZ_CODE+"' %2$s \n" +
                "						) ORG\n" +
                "					INNER JOIN (\n" +
                "						SELECT\n" +
                "							INPUT_ORGAN_CODE,\n" +
                "							HOUSEHOLD_TYPE,\n" +
                "							BIRTHDAY,Gender\n" +
                "						FROM\n" +
                "							BI_PERSON_INFO\n" +
                "						WHERE\n" +
                "							FILING_FLAG = '1' %3$s\n" +
                "					) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "				)\n" +
                "			GROUP BY\n" +
                "				TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ),\n" +
                "				TARGET_CODE,Gender\n" +
                ")\n" +
                "GROUP BY rollup(TARGET_CODE)) POP ON town.TARGET_CODE=pop.TARGET_CODE order by town.TARGET_CODE desc";

    }
    //@fon
	private List<Map<String, Object>> query(String sql, MapSqlParameterSource sqlParameterSource) {
		if (null == sqlParameterSource) {
			return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper());
		}
		return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper(), sqlParameterSource);
	}

    public Map<String, Object> getIndexChartData(){

        StringBuilder sb = new StringBuilder("SELECT\n" +
                "SUM(CASE WHEN L <1  THEN TOTAL ELSE 0 END ) AS T0,\n" +
                "    SUM(CASE  WHEN L<1 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M0,\n" +
                "    SUM(CASE  WHEN L<1 AND Gender=2   THEN TOTAL ELSE 0 END ) AS F0,\n" +
                "    SUM(CASE L WHEN 1 THEN TOTAL ELSE 0 END ) AS T1,\n" +
                "    SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M1,\n" +
                "    SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F1,\n" +
                "    SUM(CASE L WHEN 2 THEN TOTAL ELSE 0 END ) AS T2,\n" +
                "    SUM(CASE WHEN L=1 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M2,\n" +
                "    SUM(CASE WHEN L=1 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F2,\n" +
                "    SUM(CASE L WHEN 3 THEN TOTAL ELSE 0 END ) AS T3,\n" +
                "    SUM(CASE WHEN L=3 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M3,\n" +
                "    SUM(CASE WHEN L=3 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F3,\n" +
                "    SUM(CASE L WHEN 4 THEN TOTAL ELSE 0 END ) AS T4,\n" +
                "    SUM(CASE WHEN L=4 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M4,\n" +
                "    SUM(CASE WHEN L=4 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F4,\n" +
                "    SUM(CASE L WHEN 5 THEN TOTAL ELSE 0 END ) AS T5,\n" +
                "    SUM(CASE WHEN L=5 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M5,\n" +
                "    SUM(CASE WHEN L=5 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F5,\n" +
                "    SUM(CASE L WHEN 6 THEN TOTAL ELSE 0 END ) AS T6,\n" +
                "    SUM(CASE WHEN L=6 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M6,\n" +
                "    SUM(CASE WHEN L=6 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F6,\n" +
                "    SUM(CASE L WHEN 7 THEN TOTAL ELSE 0 END ) AS T7,\n" +
                "    SUM(CASE WHEN L=7 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M7,\n" +
                "    SUM(CASE WHEN L=7 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F7,\n" +
                "    SUM(CASE L WHEN 8 THEN TOTAL ELSE 0 END ) AS T8,\n" +
                "    SUM(CASE  WHEN L=8 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M8,\n" +
                "    SUM(CASE  WHEN L=8 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F8,\n" +
                "    SUM(CASE L WHEN 9 THEN TOTAL ELSE 0 END ) AS T9,\n" +
                "    SUM(CASE  WHEN L=9 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M9,\n" +
                "    SUM(CASE  WHEN L=9 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F9,\n" +
                "    SUM(CASE L WHEN 10 THEN TOTAL ELSE 0 END ) AS T10,\n" +
                "    SUM(CASE  WHEN L=10 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M10,\n" +
                "    SUM(CASE  WHEN L=10 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F10,\n" +
                "    SUM(CASE L WHEN 11 THEN TOTAL ELSE 0 END ) AS T11,\n" +
                "    SUM(CASE  WHEN L=11 AND Gender=1 THEN TOTAL ELSE 0 END ) AS M11,\n" +
                "    SUM(CASE  WHEN L=11 AND Gender=2 THEN TOTAL ELSE 0 END ) AS F11,\n" +
                "    SUM(CASE L WHEN 12 THEN TOTAL ELSE 0 END ) AS T12,\n" +
                "    SUM(CASE  WHEN L=12 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M12,\n" +
                "    SUM(CASE  WHEN L=12 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F12,\n" +
                "    SUM(CASE L WHEN 13 THEN TOTAL ELSE 0 END ) AS T13,\n" +
                "    SUM(CASE  WHEN L=13 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M13,\n" +
                "    SUM(CASE  WHEN L=13 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F13,\n" +
                "    SUM(CASE L WHEN 14 THEN TOTAL ELSE 0 END ) AS T14,\n" +
                "    SUM(CASE  WHEN L=14 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M14,\n" +
                "    SUM(CASE  WHEN L=14 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F14,\n" +
                "    SUM(CASE L WHEN 15 THEN TOTAL ELSE 0 END ) AS T15,\n" +
                "    SUM(CASE  WHEN L=15 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M15,\n" +
                "    SUM(CASE  WHEN L=15 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F15,\n" +
                "    SUM(CASE L WHEN 16 THEN TOTAL ELSE 0 END ) AS T16,\n" +
                "    SUM(CASE  WHEN L=16 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M16,\n" +
                "    SUM(CASE  WHEN L=16 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F16,\n" +
                "    SUM(CASE L WHEN 17 THEN TOTAL ELSE 0 END ) AS T17,\n" +
                "    SUM(CASE  WHEN L=17 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M17,\n" +
                "    SUM(CASE  WHEN L=17 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F17,\n" +
                "    SUM(CASE  WHEN L >=18 THEN TOTAL ELSE 0 END ) AS T18,\n" +
                "    SUM(CASE   WHEN L>=18 AND Gender=1  THEN TOTAL ELSE 0 END ) AS M18,\n" +
                "    SUM(CASE   WHEN L>=18 AND Gender=2  THEN TOTAL ELSE 0 END ) AS F18\n" +
                " FROM (\n" +
                "      SELECT\n" +
                "        TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ) L,\n" +
                "        COUNT (1) TOTAL,\n" +
                "        TARGET_CODE,GENDER\n" +
                "      FROM\n" +
                "        (\n" +
                "          SELECT\n" +
                "            ORG.TARGET_CODE ,\n" +
                "            PER.HOUSEHOLD_TYPE,\n" +
                "            ORG.ORGAN_CODE,\n" +
                "            BIRTHDAY,Gender\n" +
                "          FROM\n" +
                "            (\n" +
                "              SELECT PARENT_CODE TARGET_CODE,  ORGAN_CODE  FROM mdm_organization WHERE GENRE_CODE = '"+EHRConstants.SQFWZX_CODE+"'   \n" +
                "            ) ORG\n" +
                "          INNER JOIN (\n" +
                "            SELECT\n" +
                "              INPUT_ORGAN_CODE,\n" +
                "              HOUSEHOLD_TYPE,\n" +
                "              BIRTHDAY,Gender\n" +
                "            FROM\n" +
                "              BI_PERSON_INFO\n" +
                "            WHERE\n" +
                "              FILING_FLAG = '1' \n" +
                "          ) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "        )\n" +
                "      GROUP BY\n" +
                "        TRUNC (( TO_NUMBER (TO_CHAR(SYSDATE, 'yyyy')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'yyyy'))) / 5 ),\n" +
                "        TARGET_CODE,Gender\n" +
                ")");

        return simpleJdbcTemplate.queryForMap(sb.toString(), new HashMap());
    }

}
