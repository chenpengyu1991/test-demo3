package com.founder.rhip.ehr.repository.ihm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.statistics.ColumnMapRowMapper;

/**
 * 档案统计
 * 
 * @author liuk
 * 
 */
@Repository("ehrRecordStatisticsDao")
public class EhrRecordStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements IEhrRecordStatisticsDao {

	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<Map<String, Object>> getRecordStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender) {
		String sql = buildRecordSql(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, ageDateBegin, ageDateEnd, gender);
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
		if (null != ageDateBegin) {
			mapSqlParameterSource.addValue("ageDateBegin", ageDateBegin);
		}
		if (null != ageDateEnd) {
			mapSqlParameterSource.addValue("ageDateEnd", ageDateEnd);
		}
		if (null != gender) {
			mapSqlParameterSource.addValue("gender", gender);
		}
		List<Map<String, Object>> data = query(sql, mapSqlParameterSource);
		return data;
	}

	private String buildRecordSql(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender) {
		String sql = null;
		String recordWhere = buildRecordWhereCondition(inputBeginDate, inputEndDate, ageDateBegin, ageDateEnd, gender);
		String countYear = buildCountYearWhereCondition(inputBeginDate, inputEndDate, ageDateBegin, ageDateEnd, gender);
		String select=buildGenderSelect(inputBeginDate, inputEndDate, ageDateBegin, ageDateEnd, gender);
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

	private String buildRecordWhereCondition(Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender) {
		StringBuilder where = new StringBuilder();
		if (null != inputBeginDate) {
			where.append(" and INPUT_DATE>=:inputBeginDate ");
		}
		if (null != inputEndDate) {
			where.append(" and INPUT_DATE<=:inputEndDate ");
		}
		if (null != ageDateBegin) {
			where.append(" and BIRTHDAY>=:ageDateBegin ");
		}
		if (null != ageDateEnd) {
			where.append(" and BIRTHDAY<=:ageDateEnd ");
		}
		if (ObjectUtil.isNotEmpty(gender)) {
			where.append(" and GENDER=:gender ");
		}
		return where.toString();
	}

	private String buildCountYearWhereCondition(Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender) {
		int year;
		if (null != inputEndDate) {
			year = DateUtil.getField(inputEndDate, Calendar.YEAR);
		} else {
			year = DateUtil.getCurrentYear();
		}
		String where = " and COUNT_YEAR= " + year + " ";
		return where;
	}

	private String buildGenderSelect(Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender) {
		if (ObjectUtil.isNotEmpty(gender)) {
			if ("1".equals(gender)) {
				return " NVL(SUM(POP.HOUSEHOLD_MAN_NUM),0)  + NVL(SUM(POP.UN_HOUSEHOLD_MAN_NUM),0)    PERSON_COUNT, NVL(SUM (POP.HOUSEHOLD_MAN_NUM),0) HOUSEHOLD_PERSON_COUNT, 	NVL(SUM(POP.UN_HOUSEHOLD_MAN_NUM),0) UNHOUSEHOLD_PERSON_COUNT ";
			} else {
				return " NVL(SUM(POP.HOUSEHOLD_WOMAN_NUM),0)  + NVL(SUM(POP.UN_HOUSEHOLD_WOMAN_NUM),0)    PERSON_COUNT, NVL(SUM (POP.HOUSEHOLD_WOMAN_NUM),0) HOUSEHOLD_PERSON_COUNT, NVL(SUM(POP.UN_HOUSEHOLD_WOMAN_NUM),0) UNHOUSEHOLD_PERSON_COUNT ";
			}
		}
		return " NVL(SUM(POP.HOUSEHOLD_NUM),0)  + NVL(SUM(POP.UN_HOUSE_HOLD_NUM),0)    PERSON_COUNT,NVL(SUM (POP.HOUSEHOLD_NUM),0) HOUSEHOLD_PERSON_COUNT, NVL(SUM(POP.UN_HOUSE_HOLD_NUM),0) UNHOUSEHOLD_PERSON_COUNT ";
	}

	//@foff
    private String getQueryByTown(){
          return  "SELECT\n" +
            "	TOWN.GB_CODE TARGET_CODE,\n" +
            "	TOWN.GB_NAME TARGET_NAME,\n" +
            "	POP.PERSON_COUNT,\n" +
            "	POP.HOUSEHOLD_PERSON_COUNT,\n" +
            "	POP.UNHOUSEHOLD_PERSON_COUNT,\n" +
            "	REC.RECORD_COUNT,\n" +
            "	REC.HOUSEHOLD_RECORD_COUNT,\n" +
            "	REC.UNHOUSEHOLD_RECORD_COUNT,\n" +
            "	REC.RECORD_COUNT /NULLIF(POP.PERSON_COUNT, 0) RECORD_OCCUPANCY,\n" +
            "	REC.HOUSEHOLD_RECORD_COUNT/ NULLIF ( POP.HOUSEHOLD_PERSON_COUNT, 0 ) HOUSEHOLD_RECORD_OCCUPANCY,\n" +
            "	REC.UNHOUSEHOLD_RECORD_COUNT /NULLIF( POP.UNHOUSEHOLD_PERSON_COUNT, 0 ) UNHOUSEHOLD_RECORD_OCCUPANCY\n" +
            "FROM\n" +
            "	(SELECT GB_CODE,GB_NAME FROM V_MDM_TOWN WHERE 1=1 %1$s UNION ALL SELECT '-1' AS GB_CODE ,'' GB_NAME FROM DUAL)  TOWN\n" +
            "LEFT JOIN\n" +
            "(\n" +
            "	SELECT\n" +
            "	\"COUNT\"(1) RECORD_COUNT,\n" +
            "	\"SUM\"(CASE HOUSEHOLD_TYPE WHEN '2' THEN 1 ELSE 0 END ) AS UNHOUSEHOLD_RECORD_COUNT ,  \n" +
            "  \"SUM\"(CASE HOUSEHOLD_TYPE WHEN '1' THEN 1 ELSE 0 END ) AS HOUSEHOLD_RECORD_COUNT  ,\n" +
            "	DECODE(GROUPING_ID(GB_CODE),1,'-1',GB_CODE) GB_CODE\n" +
            "	FROM (\n" +
            "		SELECT\n" +
            "				ORG.GB_CODE,PER.HOUSEHOLD_TYPE,ORG.ORGAN_CODE\n" +
            "		FROM\n" +
            "			(SELECT GB_CODE, ORGAN_CODE  FROM MDM_ORGANIZATION WHERE GENRE_CODE in('B100','B200') %2$s) ORG\n" +
            "			INNER JOIN  \n" +
            "			(SELECT INPUT_ORGAN_CODE ,HOUSEHOLD_TYPE FROM BI_PERSON_INFO WHERE FILING_FLAG='1' %4$s )  PER\n" +
            "		ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
            "	)GROUP BY ROLLUP(GB_CODE)\n" +
            ")REC\n" +
            "ON REC.GB_CODE =TOWN.GB_CODE\n" +
            "LEFT JOIN \n" +
            "(\n" +
            "	SELECT\n" +
            "		DECODE(GROUPING_ID(POP.GBCODE),1,'-1',POP.GBCODE) GB_CODE,\n" +
                  "		%5$s" +
            "		FROM\n" +
            "		BI_POPULACE POP WHERE 1=1 %3$s\n" +
            "		GROUP BY ROLLUP (POP.GBCODE)\n" +
            ")POP ON TOWN.GB_CODE =POP.GB_CODE\n"; }


    private String getCenterSql(){
         return "SELECT\n" +
                 "	TOWN.TARGET_CODE,\n" +
                 "	TOWN.TARGET_NAME ,\n" +
                 "	POP.PERSON_COUNT,\n" +
                 "	POP.HOUSEHOLD_PERSON_COUNT,\n" +
                 "	POP.UNHOUSEHOLD_PERSON_COUNT,\n" +
                 "	REC.RECORD_COUNT,\n" +
                 "	REC.HOUSEHOLD_RECORD_COUNT,\n" +
                 "	REC.UNHOUSEHOLD_RECORD_COUNT,\n" +
                 "	REC.RECORD_COUNT /NULLIF(POP.PERSON_COUNT, 0) RECORD_OCCUPANCY,\n" +
                 "	REC.HOUSEHOLD_RECORD_COUNT/ NULLIF ( POP.HOUSEHOLD_PERSON_COUNT, 0 ) HOUSEHOLD_RECORD_OCCUPANCY,\n" +
                 "	REC.UNHOUSEHOLD_RECORD_COUNT /NULLIF( POP.UNHOUSEHOLD_PERSON_COUNT, 0 ) UNHOUSEHOLD_RECORD_OCCUPANCY\n" +
                 "FROM\n" +
                 "	(SELECT ORGAN_CODE TARGET_CODE,ORGAN_NAME  TARGET_NAME FROM MDM_ORGANIZATION WHERE GENRE_CODE = 'B100' and status=1 %1$s UNION ALL SELECT '-1' AS TARGET_CODE ,'合计' TARGET_NAME FROM DUAL)  TOWN\n" +
                 "LEFT JOIN\n" +
                 "(\n" +
                 "	SELECT\n" +
                 "	\"COUNT\"(1) RECORD_COUNT,\n" +
                 "	\n" +
                 "	\"SUM\"(CASE HOUSEHOLD_TYPE WHEN '2' THEN 1 ELSE 0 END ) AS UNHOUSEHOLD_RECORD_COUNT ,  \n" +
                 "  \"SUM\"(CASE HOUSEHOLD_TYPE WHEN '1' THEN 1 ELSE 0 END ) AS HOUSEHOLD_RECORD_COUNT  ,\n" +
                 "	DECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE\n" +
                 "	FROM (\n" +
                 "		SELECT\n" +
                 "				ORG.PARENT_CODE TARGET_CODE,PER.HOUSEHOLD_TYPE,ORG.ORGAN_CODE\n" +
                 "		FROM\n" +
                 "			(SELECT PARENT_CODE,  ORGAN_CODE  FROM MDM_ORGANIZATION WHERE GENRE_CODE = 'B200' and status=1  %2$s  ) ORG\n" +
                 "			INNER JOIN  \n" +
                 "			(SELECT INPUT_ORGAN_CODE ,HOUSEHOLD_TYPE FROM BI_PERSON_INFO WHERE FILING_FLAG='1' %4$s )  PER\n" +
                 "		ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                 "	)GROUP BY ROLLUP(TARGET_CODE)\n" +
                 ")REC\n" +
                 "ON REC.TARGET_CODE =TOWN.TARGET_CODE\n" +
                 "LEFT JOIN \n" +
                 "(\n" +
                 "	SELECT\n" +
                 "		DECODE(GROUPING_ID(POP.ORGAN_PARENT_CODE),1,'-1',POP.ORGAN_PARENT_CODE) TARGET_CODE,\n" +
                 "		%5$s" +
                 "		FROM\n" +
                 "		BI_POPULACE POP WHERE   POP.ORGAN_PARENT_CODE IS NOT NULL  %3$s  \n" +
                 "		GROUP BY ROLLUP (POP.ORGAN_PARENT_CODE)\n" +
                 ")POP ON TOWN.TARGET_CODE =POP.TARGET_CODE\n" ;
    }


    public String getStataionSql(){
        return
        "SELECT\n" +
                "	TOWN.TARGET_CODE,\n" +
                "	TOWN.TARGET_NAME ,\n" +
                "	POP.PERSON_COUNT,\n" +
                "	POP.HOUSEHOLD_PERSON_COUNT,\n" +
                "	POP.UNHOUSEHOLD_PERSON_COUNT,\n" +
                "	REC.RECORD_COUNT,\n" +
                "	REC.HOUSEHOLD_RECORD_COUNT,\n" +
                "	REC.UNHOUSEHOLD_RECORD_COUNT,\n" +
                "	REC.RECORD_COUNT /NULLIF(POP.PERSON_COUNT, 0) RECORD_OCCUPANCY,\n" +
                "	REC.HOUSEHOLD_RECORD_COUNT/ NULLIF ( POP.HOUSEHOLD_PERSON_COUNT, 0 ) HOUSEHOLD_RECORD_OCCUPANCY,\n" +
                "	REC.UNHOUSEHOLD_RECORD_COUNT /NULLIF( POP.UNHOUSEHOLD_PERSON_COUNT, 0 ) UNHOUSEHOLD_RECORD_OCCUPANCY\n" +
                "FROM\n" +
                "	(SELECT ORGAN_CODE TARGET_CODE,ORGAN_NAME  TARGET_NAME FROM MDM_ORGANIZATION WHERE GENRE_CODE = 'B200' and status=1 %1$s  UNION ALL SELECT '-1' AS TARGET_CODE ,'合计' TARGET_NAME FROM DUAL)  TOWN\n" +
                "LEFT JOIN\n" +
                "(\n" +
                "	SELECT\n" +
                "	\"COUNT\"(1) RECORD_COUNT,\n" +
                "	\n" +
                "	\"SUM\"(CASE HOUSEHOLD_TYPE WHEN '2' THEN 1 ELSE 0 END ) AS UNHOUSEHOLD_RECORD_COUNT ,  \n" +
                "  \"SUM\"(CASE HOUSEHOLD_TYPE WHEN '1' THEN 1 ELSE 0 END ) AS HOUSEHOLD_RECORD_COUNT  ,\n" +
                "	DECODE(GROUPING_ID(TARGET_CODE),1,'-1',TARGET_CODE) TARGET_CODE\n" +
                "	FROM (\n" +
                "		SELECT\n" +
                "				ORG.ORGAN_CODE TARGET_CODE,PER.HOUSEHOLD_TYPE,ORG.ORGAN_CODE\n" +
                "		FROM\n" +
                "			(SELECT  ORGAN_CODE  FROM MDM_ORGANIZATION WHERE GENRE_CODE = 'B200' and status=1 %2$s  ) ORG\n" +
                "			INNER JOIN  \n" +
                "			(SELECT INPUT_ORGAN_CODE ,HOUSEHOLD_TYPE FROM BI_PERSON_INFO WHERE FILING_FLAG='1' %4$s )  PER\n" +
                "		ON PER.INPUT_ORGAN_CODE = ORG.ORGAN_CODE\n" +
                "	)GROUP BY ROLLUP(ORGAN_CODE)\n" +
                ")REC\n" +
                "ON REC.TARGET_CODE =TOWN.TARGET_CODE\n" +
                "LEFT JOIN \n" +
                "(\n" +
                "	SELECT\n" +
                "		DECODE(GROUPING_ID(POP.ORGAN_CODE),1,'-1',POP.ORGAN_CODE) TARGET_CODE,\n" +
                "		%5$s" +
                "		FROM\n" +
                "		BI_POPULACE POP WHERE  POP.ORGAN_CODE IS NOT NULL %3$s \n" +
                "		GROUP BY ROLLUP (POP.ORGAN_CODE)\n" +
                ")POP ON TOWN.TARGET_CODE =POP.TARGET_CODE\n" ;

    }
    //@fon
	private List<Map<String, Object>> query(String sql, MapSqlParameterSource sqlParameterSource) {
		if (null == sqlParameterSource) {
			return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper());
		}
		return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper(), sqlParameterSource);
	}

}
