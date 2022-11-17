package com.founder.rhip.ehr.repository.ihm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.statistics.ColumnMapRowMapper;

/**
 * 星级统计
 * 
 * @author liuk
 * 
 */
@Repository("ehrStarStatisticsDao")
public class EhrStarStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements IEhrStarStatisticsDao {

	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<Map<String, Object>> getStarStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType) {
		String sql = buildRecordSql(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, householdType);
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
		if (null != householdType) {
			mapSqlParameterSource.addValue("householdType", householdType);
		}
		List<Map<String, Object>> data = query(sql, mapSqlParameterSource);
		return data;
	}

    private String buildRecordSql(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType) {
        String sql = null;
        String recordWhere = buildRecordWhereCondition(inputBeginDate, inputEndDate, householdType);
        String countYear = buildCountYearWhereCondition(inputBeginDate, inputEndDate,householdType);
        String select=buildHousholdSelect(householdType);
        switch (orgType) {
            case "0": {
                if (ObjectUtil.isNotEmpty(townCode)) {
                    sql = String.format(getQueryByTown(), "AND GB_CODE=:townCode", "AND GB_CODE=:townCode", "AND GBCODE=:townCode" + countYear, recordWhere,select);
                } else {
                    sql = String.format(getQueryByTown(), "", "AND GB_CODE is not null", "AND GBCODE is not null" + countYear, recordWhere,select);
                }
                break;
            }
            case "B100": {
                if (ObjectUtil.isNotEmpty(centreCode)) {
                    sql = String.format(getCenterSql(), "AND ORGAN_CODE=:centreCode", "AND PARENT_CODE=:centreCode", "AND ORGAN_PARENT_CODE=:centreCode" + countYear, recordWhere,select);
                } else if (ObjectUtil.isNotEmpty(townCode)) {
                    sql = String.format(getCenterSql(), "AND GB_CODE=:townCode", "AND GB_CODE=:townCode", "AND GBCODE=:townCode" + countYear, recordWhere,select);
                } else {
                    sql = String.format(getCenterSql(), "", "", countYear, recordWhere,select);
                }
                break;
            }
            case "B200": {
                if (ObjectUtil.isNotEmpty(stationCode)) {
                    sql = String.format(getStataionSql(), "AND ORGAN_CODE=:stationCode", "AND ORGAN_CODE=:stationCode", "AND ORGAN_CODE=:stationCode" + countYear, recordWhere,select);
                } else if (ObjectUtil.isNotEmpty(centreCode)) {
                    sql = String.format(getStataionSql(), "AND PARENT_CODE=:centreCode", "AND PARENT_CODE=:centreCode", "AND ORGAN_PARENT_CODE=:centreCode" + countYear, recordWhere,select);
                } else if (ObjectUtil.isNotEmpty(townCode)) {
                    sql = String.format(getStataionSql(), "AND GB_CODE=:townCode", "AND GB_CODE=:townCode", "AND GBCODE=:townCode" + countYear, recordWhere,select);
                } else {
                    sql = String.format(getStataionSql(), "", "", countYear, recordWhere,select);
                }
                break;
            }
        }
        return sql;
    }

	private String buildRecordWhereCondition(Date inputBeginDate, Date inputEndDate, String householdType) {
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
		return where.toString();
	}

    private String buildCountYearWhereCondition(Date inputBeginDate, Date inputEndDate,String gender) {
        int year;
        if (null != inputEndDate) {
            year = DateUtil.getField(inputEndDate, Calendar.YEAR);
        } else {
            year = DateUtil.getCurrentYear();
        }
        String where = " and COUNT_YEAR = " + year + " ";
        return where;
    }

    private String buildHousholdSelect(String type) {
        if (ObjectUtil.isNotEmpty(type)) {
            if ("1".equals(type)) {
                return " NVL (SUM(HOUSEHOLD_NUM), 0) PERSON_COUNT ";
            } else {
                return " NVL (SUM(UN_HOUSE_HOLD_NUM), 0) PERSON_COUNT ";
            }
        }
        return " NVL (SUM(HOUSEHOLD_NUM), 0) + NVL (SUM(UN_HOUSE_HOLD_NUM), 0) PERSON_COUNT ";
    }

	//@foff
    private String getQueryByTown(){
        return "SELECT\n" +
                "	TEMP.*, " +
                " ROUND(DECODE(SIGN(NVL(PERSON_COUNT,0)),0,0,NVL(RECORD_COUNT,0)/NVL(PERSON_COUNT,0)),4) RECORD_OCCUPANCY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(PERSON_COUNT,0)),0,0,NVL(ONE_STAR_RECORD_COUNT,0)/NVL(PERSON_COUNT,0)),4) ONE_STAR_RECORD_OCCUPANCY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(PERSON_COUNT,0)),0,0,NVL(TWO_STAR_RECORD_COUNT,0)/NVL(PERSON_COUNT,0)),4) TWO_STAR_RECORD_OCCUPANCY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(PERSON_COUNT,0)),0,0,NVL(THREE_STAR_RECORD_COUNT,0)/NVL(PERSON_COUNT,0)),4) THREE_STAR_RECORD_OCCUPANCY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(PERSON_COUNT,0)),0,0,NVL(TWOA_STAR_RECORD_COUNT,0)/NVL(PERSON_COUNT,0)),4) TWOA_STAR_RECORD_OCCUPANCY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(ONE_STAR_RECORD_COUNT,0)),0,0,NVL(ONE_STAR_RECORD_COM_COUNT,0)/NVL(ONE_STAR_RECORD_COUNT,0)),4) ONE_STAR_RECORD_INTEGRITY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(TWO_STAR_RECORD_COUNT,0)),0,0,NVL(TWO_STAR_RECORD_COM_COUNT,0)/NVL(TWO_STAR_RECORD_COUNT,0)),4) TWO_STAR_RECORD_INTEGRITY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(THREE_STAR_RECORD_COUNT,0)),0,0,NVL(THREE_STAR_RECORD_COM_COUNT,0)/NVL(THREE_STAR_RECORD_COUNT,0)),4) THREE_STAR_RECORD_INTEGRITY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(TWOA_STAR_RECORD_COUNT,0)),0,0,NVL(TWOA_STAR_RECORD_COM_COUNT,0)/NVL(TWOA_STAR_RECORD_COUNT,0)),4) THREE_STAR_RECORD_INTEGRITY,\n"+ 
                " ROUND(DECODE(SIGN(NVL(RECORD_COUNT,0)),0,0,NVL(STAR_RECORD_COM_COUNT,0)/NVL(RECORD_COUNT,0)),4) RECORD_INTEGRITY\n"+ 
                "FROM\n" +
                "	(\n" +
                "		SELECT\n" +
                "			TOWN.GB_CODE TARGET_CODE ,\n" +
                "			TOWN.GB_NAME TARGET_NAME,\n" +
                "			T_PERS.PERSON_COUNT,\n" +
                "			T_STAR.ONE_STAR_RECORD_COUNT,\n" +
                "			T_STAR.RECORD_COUNT,\n" +
                "			T_STAR.THREE_STAR_RECORD_COUNT,\n" +
                "			T_STAR.TWOA_STAR_RECORD_COUNT,\n" +
                "			T_STAR.TWO_STAR_RECORD_COUNT,\n" +
                "			T_COM.ONE_STAR_RECORD_COM_COUNT,\n" +
                "			T_COM.TWO_STAR_RECORD_COM_COUNT,\n" +
                "			T_COM.THREE_STAR_RECORD_COM_COUNT,\n" +
                "			T_COM.TWOA_STAR_RECORD_COM_COUNT,\n" +
                "			T_COM.STAR_RECORD_COM_COUNT\n" +
                "		FROM\n" +
                "		(SELECT GB_CODE,GB_NAME FROM V_MDM_TOWN WHERE 1=1 %1$s UNION ALL SELECT '-1' AS GB_CODE ,'' GB_NAME FROM DUAL)  TOWN\n" +
                "		LEFT JOIN (\n" +
                "			SELECT\n" +
                "				DECODE(GROUPING_ID(INPUT_GBCODE),1,'-1',INPUT_GBCODE) INPUT_GBCODE,\n" +
                "				SUM (TOTAL) AS RECORD_COUNT,\n" +
                "				SUM (ONE) ONE_STAR_RECORD_COUNT,\n" +
                "				SUM (TWO) TWO_STAR_RECORD_COUNT,\n" +
                "				SUM (THREE) THREE_STAR_RECORD_COUNT,\n" +
                "				NVL (SUM(THREE), 0) + NVL (SUM(TWO), 0) TWOA_STAR_RECORD_COUNT\n" +
                "			FROM\n" +
                "				(\n" +
                "					SELECT\n" +
                "					INPUT_GBCODE,\n" +
                "						COUNT (1) TOTAL,\n" +
                "					CASE STAR WHEN 1 THEN COUNT (STAR) END AS ONE,  \n" +
                "					CASE STAR WHEN 2 THEN COUNT (STAR) END AS TWO,  \n" +
                "					CASE STAR WHEN 3 THEN COUNT (STAR) END AS THREE  \n" +
                "					FROM\n" +
                "						(\n" +
                "							SELECT\n" +
                "								ORG.GB_CODE INPUT_GBCODE,\n" +
                "								STAR\n" +
                "							FROM\n" +
                "								(\n" +
                "									SELECT\n" +
                "										GB_CODE,\n" +
                "										ORGAN_CODE\n" +
                "									FROM\n" +
                "										V_MDM_ORGANIZATION_NOSUB\n" +
                "									WHERE\n" +
                "										GENRE_CODE = 'B200'\n %2$s " +
                "									AND GB_CODE IS NOT NULL\n" +
                "								) ORG\n" +
                "							INNER JOIN (\n" +
                "								SELECT\n" +
                "									INPUT_ORGAN_CODE,\n" +
                "									STAR\n" +
                "								FROM\n" +
                "									BI_PERSON_INFO\n" +
                "								WHERE\n" +
                "									FILING_FLAG = '1' %4$s \n" +
                "							) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "						)\n" +
                "					GROUP BY\n" +
                "						INPUT_GBCODE,\n" +
                "						STAR\n" +
                "				)\n" +
                "			GROUP BY\n" +
                "				ROLLUP (INPUT_GBCODE)\n" +
                "		) T_STAR ON T_STAR.INPUT_GBCODE = TOWN.GB_CODE\n" +
                "		LEFT JOIN (\n" +
                "			SELECT\n" +
                "				DECODE(GROUPING_ID(INPUT_GBCODE),1,'-1',INPUT_GBCODE) INPUT_GBCODE,\n" +
                "				SUM (ONE_COM) ONE_STAR_RECORD_COM_COUNT,\n" +
                "				SUM (TWO_COM) TWO_STAR_RECORD_COM_COUNT,\n" +
                "				SUM (THREE_COM) THREE_STAR_RECORD_COM_COUNT,\n" +
                "				NVL (SUM(THREE_COM), 0) + NVL (SUM(TWO_COM), 0) TWOA_STAR_RECORD_COM_COUNT,\n" +
                "				NVL (SUM(THREE_COM), 0) + NVL (SUM(TWO_COM), 0) + NVL (SUM(ONE_COM), 0) STAR_RECORD_COM_COUNT\n" +
                "			FROM\n" +
                "				(\n" +
                "					SELECT\n" +
                "						INPUT_GBCODE,\n" +
                "						CASE STAR WHEN 1 THEN COUNT (STAR) END AS ONE_COM,  \n" +
                "						CASE STAR WHEN 2 THEN COUNT (STAR) END AS TWO_COM,  \n" +
                "						CASE STAR WHEN 3 THEN COUNT (STAR) END AS THREE_COM \n" +
                "					FROM\n" +
                "						(\n" +
                "							SELECT\n" +
                "								ORG.GB_CODE INPUT_GBCODE,\n" +
                "								STAR\n" +
                "							FROM\n" +
                "								(\n" +
                "									SELECT\n" +
                "										GB_CODE,\n" +
                "										ORGAN_CODE\n" +
                "									FROM\n" +
                "										V_MDM_ORGANIZATION_NOSUB\n" +
                "									WHERE\n" +
                "										GENRE_CODE = 'B200'\n %2$s " +
                "									AND GB_CODE IS NOT NULL\n" +
                "								) ORG\n" +
                "							INNER JOIN (\n" +
                "								SELECT\n" +
                "									INPUT_ORGAN_CODE,\n" +
                "									STAR\n" +
                "								FROM\n" +
                "									BI_PERSON_INFO\n" +
                "								WHERE\n" +
                "									FILING_FLAG = '1'\n" +
                "								AND INTEGRITY > 0.99 \n  %4$s " +
                "							) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "						)\n" +
                "				GROUP BY\n" +
                "				INPUT_GBCODE,\n" +
                "				STAR\n" +
                "				)\n" +
                "			GROUP BY\n" +
                "				ROLLUP (INPUT_GBCODE)\n" +
                "		) T_COM ON T_COM.INPUT_GBCODE = T_STAR.INPUT_GBCODE\n" +
                "		LEFT JOIN (\n" +
                "				SELECT\n" +
                "					DECODE(GROUPING_ID(POP.GBCODE),1,'-1',POP.GBCODE) GBCODE,\n" +
                "					%5$s\n" +
                "				FROM\n" +
                "					BI_POPULACE POP\n" +
                "				WHERE\n" +
                "					POP.GBCODE IS NOT NULL  %3$s \n" +
                "				GROUP BY\n" +
                "					ROLLUP (POP.GBCODE)\n" +
                "			) T_PERS ON T_COM.INPUT_GBCODE=T_PERS.GBCODE\n" +
                "	) TEMP\n" +
                "ORDER BY\n" +
                "	TARGET_CODE";
    }


    private String getCenterSql(){
        return "SELECT\n" +
                "\tTEMP.*, RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  RECORD_OCCUPANCY,\n" +
                "\tONE_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  ONE_STAR_RECORD_OCCUPANCY,\n" +
                "\tTWO_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  TWO_STAR_RECORD_OCCUPANCY,\n" +
                "\tTHREE_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  THREE_STAR_RECORD_OCCUPANCY,\n" +
                "\tTWOA_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  TWOA_STAR_RECORD_OCCUPANCY,\n" +
                "\tONE_STAR_RECORD_COM_COUNT / NULLIF (ONE_STAR_RECORD_COUNT, 0) ONE_STAR_RECORD_INTEGRITY,\n" +
                "\tTWO_STAR_RECORD_COM_COUNT / NULLIF (TWO_STAR_RECORD_COUNT, 0) TWO_STAR_RECORD_INTEGRITY,\n" +
                "\tTHREE_STAR_RECORD_COM_COUNT / NULLIF (THREE_STAR_RECORD_COUNT, 0) THREE_STAR_RECORD_INTEGRITY,\n" +
                "\tTWOA_STAR_RECORD_COM_COUNT / NULLIF (TWOA_STAR_RECORD_COUNT, 0) TWOA_STAR_RECORD_INTEGRITY,\n" +
                "\tSTAR_RECORD_COM_COUNT / NULLIF (RECORD_COUNT, 0) RECORD_INTEGRITY\n" +
                "FROM\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tTOWN.TARGET_CODE  ,\n" +
                "\t\t\tTOWN.TARGET_NAME ,\n" +
                "\t\t\tT_PERS.PERSON_COUNT,\n" +
                "\t\t\tT_STAR.ONE_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_STAR.RECORD_COUNT,\n" +
                "\t\t\tT_STAR.THREE_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_STAR.TWOA_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_STAR.TWO_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_COM.ONE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.TWO_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.THREE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.TWOA_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.STAR_RECORD_COM_COUNT\n" +
                "\t\tFROM\n" +
                "\t\t\t(SELECT ORGAN_CODE TARGET_CODE,ORGAN_NAME  TARGET_NAME FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B100'  %1$s UNION ALL SELECT '-1' AS TARGET_CODE ,'合计' TARGET_NAME FROM DUAL)  TOWN\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tDECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "\t\t\t\tSUM (TOTAL) AS RECORD_COUNT,\n" +
                "\t\t\t\tSUM (ONE) ONE_STAR_RECORD_COUNT,\n" +
                "\t\t\t\tSUM (TWO) TWO_STAR_RECORD_COUNT,\n" +
                "\t\t\t\tSUM (THREE) THREE_STAR_RECORD_COUNT,\n" +
                "\t\t\t\tNVL (SUM(THREE), 0) + NVL (SUM(TWO), 0) TWOA_STAR_RECORD_COUNT\n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\t\t\tCOUNT (1) TOTAL,\n" +
                "\t\t\t\t\tCASE STAR WHEN 1 THEN COUNT (STAR) END AS ONE,  \n" +
                "\t\t\t\t\tCASE STAR WHEN 2 THEN COUNT (STAR) END AS TWO,  \n" +
                "\t\t\t\t\tCASE STAR WHEN 3 THEN COUNT (STAR) END AS THREE  \n" +
                "\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\tORG.PARENT_CODE TARGET_CODE,\n" +
                "\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\t\t\tSELECT PARENT_CODE,  ORGAN_CODE  FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B200'  %2$s \n" +
                "\t\t\t\t\t\t\t\t) ORG\n" +
                "\t\t\t\t\t\t\tINNER JOIN (\n" +
                "\t\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\t\tINPUT_ORGAN_CODE,\n" +
                "\t\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t\tBI_PERSON_INFO\n" +
                "\t\t\t\t\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\t\t\tFILING_FLAG = '1' %4$s \n" +
                "\t\t\t\t\t\t\t) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "\t\t\t\t\t\t)\n" +
                "\t\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t)\n" +
                "\t\t\tGROUP BY\n" +
                "\t\t\t\tROLLUP (TARGET_CODE)\n" +
                "\t\t) T_STAR ON T_STAR.TARGET_CODE = TOWN.TARGET_CODE\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tDECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "\t\t\t\tSUM (ONE_COM) ONE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tSUM (TWO_COM) TWO_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tSUM (THREE_COM) THREE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tNVL (SUM(THREE_COM), 0) + NVL (SUM(TWO_COM), 0) TWOA_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tNVL (SUM(THREE_COM), 0) + NVL (SUM(TWO_COM), 0) + NVL (SUM(ONE_COM), 0) STAR_RECORD_COM_COUNT\n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\t\t\tCASE STAR WHEN 1 THEN COUNT (STAR) END AS ONE_COM,  \n" +
                "\t\t\t\t\t\tCASE STAR WHEN 2 THEN COUNT (STAR) END AS TWO_COM,  \n" +
                "\t\t\t\t\t\tCASE STAR WHEN 3 THEN COUNT (STAR) END AS THREE_COM \n" +
                "\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\tORG.PARENT_CODE TARGET_CODE,\n" +
                "\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\t\t\tSELECT PARENT_CODE,  ORGAN_CODE  FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B200' %2$s \n" +
                "\t\t\t\t\t\t\t\t) ORG\n" +
                "\t\t\t\t\t\t\tINNER JOIN (\n" +
                "\t\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\t\tINPUT_ORGAN_CODE,\n" +
                "\t\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t\tBI_PERSON_INFO\n" +
                "\t\t\t\t\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\t\t\tFILING_FLAG = '1'\n" +
                "\t\t\t\t\t\t\t\tAND INTEGRITY > 0.99 %4$s \n" +
                "\t\t\t\t\t\t\t) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "\t\t\t\t\t\t)\n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\tSTAR\n" +
                "\t\t\t\t)\n" +
                "\t\t\tGROUP BY\n" +
                "\t\t\t\tROLLUP (TARGET_CODE)\n" +
                "\t\t) T_COM ON T_COM.TARGET_CODE = T_STAR.TARGET_CODE\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tDECODE(GROUPING_ID(POP.ORGAN_PARENT_CODE),1,'-1',POP.ORGAN_PARENT_CODE) TARGET_CODE,\n" +
                "\t\t\t\t\t %5$s \n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\tBI_POPULACE POP\n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tPOP.ORGAN_PARENT_CODE IS NOT NULL %3$s \n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\tROLLUP (POP.ORGAN_PARENT_CODE)\n" +
                "\t\t\t) T_PERS ON T_COM.TARGET_CODE=T_PERS.TARGET_CODE\n" +
                "\t) TEMP\n" +
                "ORDER BY\n" +
                "\tTARGET_CODE";
    }


    public String getStataionSql(){
        return "SELECT\n" +
                "\tTEMP.*, RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  RECORD_OCCUPANCY,\n" +
                "\tONE_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  ONE_STAR_RECORD_OCCUPANCY,\n" +
                "\tTWO_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  TWO_STAR_RECORD_OCCUPANCY,\n" +
                "\tTHREE_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  THREE_STAR_RECORD_OCCUPANCY,\n" +
                "\tTWOA_STAR_RECORD_COUNT /  NULLIF (PERSON_COUNT, 0)  TWOA_STAR_RECORD_OCCUPANCY,\n" +
                "\tONE_STAR_RECORD_COM_COUNT / NULLIF (ONE_STAR_RECORD_COUNT, 0) ONE_STAR_RECORD_INTEGRITY,\n" +
                "\tTWO_STAR_RECORD_COM_COUNT / NULLIF (TWO_STAR_RECORD_COUNT, 0) TWO_STAR_RECORD_INTEGRITY,\n" +
                "\tTHREE_STAR_RECORD_COM_COUNT / NULLIF (THREE_STAR_RECORD_COUNT, 0) THREE_STAR_RECORD_INTEGRITY,\n" +
                "\tTWOA_STAR_RECORD_COM_COUNT / NULLIF (TWOA_STAR_RECORD_COUNT, 0) TWOA_STAR_RECORD_INTEGRITY,\n" +
                "\tSTAR_RECORD_COM_COUNT / NULLIF (RECORD_COUNT, 0) RECORD_INTEGRITY\n" +
                "FROM\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tTOWN.TARGET_CODE  ,\n" +
                "\t\t\tTOWN.TARGET_NAME ,\n" +
                "\t\t\tT_PERS.PERSON_COUNT,\n" +
                "\t\t\tT_STAR.ONE_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_STAR.RECORD_COUNT,\n" +
                "\t\t\tT_STAR.THREE_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_STAR.TWOA_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_STAR.TWO_STAR_RECORD_COUNT,\n" +
                "\t\t\tT_COM.ONE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.TWO_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.THREE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.TWOA_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\tT_COM.STAR_RECORD_COM_COUNT\n" +
                "\t\tFROM\n" +
                "\t\t\t(SELECT ORGAN_CODE TARGET_CODE,ORGAN_NAME  TARGET_NAME FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B200' %1$s UNION ALL SELECT '-1' AS TARGET_CODE ,'合计' TARGET_NAME FROM DUAL)  TOWN\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tDECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "\t\t\t\tSUM (TOTAL) AS RECORD_COUNT,\n" +
                "\t\t\t\tSUM (ONE) ONE_STAR_RECORD_COUNT,\n" +
                "\t\t\t\tSUM (TWO) TWO_STAR_RECORD_COUNT,\n" +
                "\t\t\t\tSUM (THREE) THREE_STAR_RECORD_COUNT,\n" +
                "\t\t\t\tNVL (SUM(THREE), 0) + NVL (SUM(TWO), 0) TWOA_STAR_RECORD_COUNT\n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\t\t\tCOUNT (1) TOTAL,\n" +
                "\t\t\t\t\tCASE STAR WHEN 1 THEN COUNT (STAR) END AS ONE,  \n" +
                "\t\t\t\t\tCASE STAR WHEN 2 THEN COUNT (STAR) END AS TWO,  \n" +
                "\t\t\t\t\tCASE STAR WHEN 3 THEN COUNT (STAR) END AS THREE  \n" +
                "\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\tORG.ORGAN_CODE TARGET_CODE,\n" +
                "\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\t\t\tSELECT  ORGAN_CODE  FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B200'  %2$s\n" +
                "\t\t\t\t\t\t\t\t) ORG\n" +
                "\t\t\t\t\t\t\tINNER JOIN (\n" +
                "\t\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\t\tINPUT_ORGAN_CODE,\n" +
                "\t\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t\tBI_PERSON_INFO\n" +
                "\t\t\t\t\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\t\t\tFILING_FLAG = '1' %4$s\n" +
                "\t\t\t\t\t\t\t) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "\t\t\t\t\t\t)\n" +
                "\t\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t)\n" +
                "\t\t\tGROUP BY\n" +
                "\t\t\t\tROLLUP (TARGET_CODE)\n" +
                "\t\t) T_STAR ON T_STAR.TARGET_CODE = TOWN.TARGET_CODE\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tDECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE,\n" +
                "\t\t\t\tSUM (ONE_COM) ONE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tSUM (TWO_COM) TWO_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tSUM (THREE_COM) THREE_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tNVL (SUM(THREE_COM), 0) + NVL (SUM(TWO_COM), 0) TWOA_STAR_RECORD_COM_COUNT,\n" +
                "\t\t\t\tNVL (SUM(THREE_COM), 0) + NVL (SUM(TWO_COM), 0) + NVL (SUM(ONE_COM), 0) STAR_RECORD_COM_COUNT\n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\t\t\tCASE STAR WHEN 1 THEN COUNT (STAR) END AS ONE_COM,  \n" +
                "\t\t\t\t\t\tCASE STAR WHEN 2 THEN COUNT (STAR) END AS TWO_COM,  \n" +
                "\t\t\t\t\t\tCASE STAR WHEN 3 THEN COUNT (STAR) END AS THREE_COM \n" +
                "\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\tORG.ORGAN_CODE TARGET_CODE,\n" +
                "\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t(\n" +
                "\t\t\t\t\t\t\t\t\tSELECT ORGAN_CODE  FROM V_MDM_ORGANIZATION_NOSUB WHERE GENRE_CODE = 'B200' %2$s \n" +
                "\t\t\t\t\t\t\t\t) ORG\n" +
                "\t\t\t\t\t\t\tINNER JOIN (\n" +
                "\t\t\t\t\t\t\t\tSELECT\n" +
                "\t\t\t\t\t\t\t\t\tINPUT_ORGAN_CODE,\n" +
                "\t\t\t\t\t\t\t\t\tSTAR\n" +
                "\t\t\t\t\t\t\t\tFROM\n" +
                "\t\t\t\t\t\t\t\t\tBI_PERSON_INFO\n" +
                "\t\t\t\t\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\t\t\tFILING_FLAG = '1'\n" +
                "\t\t\t\t\t\t\t\tAND INTEGRITY > 0.99 %4$s\n" +
                "\t\t\t\t\t\t\t) PER ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "\t\t\t\t\t\t)\n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\tTARGET_CODE,\n" +
                "\t\t\t\tSTAR\n" +
                "\t\t\t\t)\n" +
                "\t\t\tGROUP BY\n" +
                "\t\t\t\tROLLUP (TARGET_CODE)\n" +
                "\t\t) T_COM ON T_COM.TARGET_CODE = T_STAR.TARGET_CODE\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tDECODE(GROUPING_ID(POP.ORGAN_CODE),1,'-1',POP.ORGAN_CODE) TARGET_CODE,\n" +
                "\t\t\t\t %5$s \n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\tBI_POPULACE POP\n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tPOP.ORGAN_PARENT_CODE IS NOT NULL %3$s\n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\tROLLUP (POP.ORGAN_CODE)\n" +
                "\t\t\t) T_PERS ON T_COM.TARGET_CODE=T_PERS.TARGET_CODE\n" +
                "\t) TEMP\n" +
                "ORDER BY\n" +
                "\tTARGET_CODE";

    }
    //@fon
	private List<Map<String, Object>> query(String sql, MapSqlParameterSource sqlParameterSource) {
		if (null == sqlParameterSource) {
			return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper());
		}
		return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper(), sqlParameterSource);
	}

}
