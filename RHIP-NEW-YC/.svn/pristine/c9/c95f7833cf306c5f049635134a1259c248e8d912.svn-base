package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import javax.annotation.Resource;

import com.founder.rhip.ehr.entity.management.DmReportInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.DmYearReport;

@Repository("dmYearReportStatisticsDao")
public class DmYearReportStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements  IDmYearReportStatisticsDao{
	@Resource(name="queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;


    //@foff
	private static final String CD_BY_GENGER_SQL=""+
			"SELECT\n" +
			"			DIS_TYPE,\n" +
			"			decode(grouping_id(SUB_DIS_TYPE),1,'-1',SUB_DIS_TYPE) AS SUB_DIS_TYPE,\n" +
			"			\"SUM\"(CASE GENDER WHEN '1' THEN 1 ELSE 0 END ) AS MAN_COUNT ,  \n" +
			"			\"SUM\"(CASE GENDER WHEN '2' THEN 1 ELSE 0 END ) AS WMMAN_COUNT  ,\n" +
			"			\"COUNT\"(0) AS TOTAL\n" +
			"		FROM\n" +
			"			V_DM_REPORT_INFO REPORT\n" +
			"		WHERE\n" +
			"			REPORT_STATUS!=5 AND DIS_TYPE IS NOT NULL AND DIS_TYPE!=5 AND SUB_DIS_TYPE IS NOT NULL AND REPORT_TYPE=1 AND %1$s \n" +
			"		GROUP BY\n" +
			"			rollup(\n" +
			"			REPORT.DIS_TYPE,\n" +
			"			REPORT.SUB_DIS_TYPE)";


	private static final String CD_BY_AGE_SQL=""+
			"SELECT\n" +
			"			DIS_TYPE,\n" +
			"			DECODE(GROUPING_ID(SUB_DIS_TYPE),1,'-1',SUB_DIS_TYPE) SUB_DIS_TYPE,\n" +
			"			\"SUM\"(CASE  WHEN BIRTHDAY IS  NULL THEN 1 ELSE 0 END ) AS ZERO ,  \n" +
			"			\"SUM\"(CASE TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) WHEN 0 THEN 1 ELSE 0 END ) AS ONE ,  \n" +
			"			\"SUM\"(CASE  WHEN  TO_NUMBER(TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) >0 AND TO_NUMBER(TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) <5 THEN 1 ELSE 0 END ) AS TWO  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 1 THEN 1 ELSE 0 END ) AS THREE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 2 THEN 1 ELSE 0 END ) AS FOUR  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 3 THEN 1 ELSE 0 END ) AS FIVE                  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 4 THEN 1 ELSE 0 END ) AS SIX  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 5 THEN 1 ELSE 0 END ) AS SERVEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 6 THEN 1 ELSE 0 END ) AS EIGHT  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 7 THEN 1 ELSE 0 END ) AS NINE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 8 THEN 1 ELSE 0 END ) AS TEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 9 THEN 1 ELSE 0 END ) AS ELEVEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 10 THEN 1 ELSE 0 END ) AS TWELVE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 11 THEN 1 ELSE 0 END ) AS THIRTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 12 THEN 1 ELSE 0 END ) AS FOURTEEN      ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 13 THEN 1 ELSE 0 END ) AS FIFTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 14 THEN 1 ELSE 0 END ) AS SIXTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 15 THEN 1 ELSE 0 END ) AS SEVENTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 16 THEN 1 ELSE 0 END ) AS EIGHTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 17 THEN 1 ELSE 0 END ) AS NINETEEN  ,\n" +
			"			\"COUNT\"(0) AS TOTAL\n" +
			"		FROM\n" +
			"			V_DM_REPORT_INFO REPORT\n" +
			"		WHERE\n" +
			"			REPORT_STATUS!=5 AND DIS_TYPE IS NOT NULL AND DIS_TYPE!=5 AND SUB_DIS_TYPE IS NOT NULL  AND REPORT_TYPE=1 AND %1$s \n" +
			"	\n" +
			"		GROUP BY\n" +
			"			ROLLUP(\n" +
			"			REPORT.DIS_TYPE,\n" +
			"			REPORT.SUB_DIS_TYPE)\n" ;


	private static final String TUMOR_BY_GENGER_SQL=""+
			"	SELECT\n" +
			"			TUMOR_ICD_TEN_TYPE DIS_TYPE,\n" +
			"			decode(grouping_id(TUMOR_ICD_TEN_SHORT_CODE),1,'-1',TUMOR_ICD_TEN_SHORT_CODE) SUB_DIS_TYPE,\n" +
			"			\"SUM\"(CASE GENDER WHEN '1' THEN 1 ELSE 0 END ) AS MAN_COUNT ,  \n" +
			"			\"SUM\"(CASE GENDER WHEN '2' THEN 1 ELSE 0 END ) AS WMMAN_COUNT  ,\n" +
			"			\"COUNT\"(0) AS TOTAL\n" +
			"		FROM\n" +
			"			V_DM_REPORT_INFO\n" +
			"		WHERE\n" +
			"			REPORT_STATUS!=5 AND DIS_TYPE =5 AND ((REPORT_TYPE=2 AND TUMOR_DEATH_FIRST_FLAG=1) OR REPORT_TYPE=1) AND %1$s  \n"  +
			"		GROUP BY\n" +
			"			rollup(\n" +
			"			TUMOR_ICD_TEN_TYPE,\n" +
			"			TUMOR_ICD_TEN_SHORT_CODE)";


	private static final String TUMOR_BY_AGE_SQL=""+
			"	SELECT\n" +
			"			TUMOR_ICD_TEN_TYPE DIS_TYPE,\n" +
			"			decode(grouping_id(TUMOR_ICD_TEN_SHORT_CODE),1,'-1',TUMOR_ICD_TEN_SHORT_CODE) SUB_DIS_TYPE,\n" +
			"			\"SUM\"(CASE   WHEN BIRTHDAY IS NULL THEN 1 ELSE 0 END ) AS ZERO ,  \n" +
			"			\"SUM\"(CASE TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) WHEN 0 THEN 1 ELSE 0 END ) AS ONE ,  \n" +
			"			\"SUM\"(CASE  WHEN  TO_NUMBER(TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) >0 AND TO_NUMBER(TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) <5 THEN 1 ELSE 0 END ) AS TWO  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 1 THEN 1 ELSE 0 END ) AS THREE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 2 THEN 1 ELSE 0 END ) AS FOUR  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 3 THEN 1 ELSE 0 END ) AS FIVE                  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 4 THEN 1 ELSE 0 END ) AS SIX  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 5 THEN 1 ELSE 0 END ) AS SERVEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 6 THEN 1 ELSE 0 END ) AS EIGHT  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 7 THEN 1 ELSE 0 END ) AS NINE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 8 THEN 1 ELSE 0 END ) AS TEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 9 THEN 1 ELSE 0 END ) AS ELEVEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 10 THEN 1 ELSE 0 END ) AS TWELVE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 11 THEN 1 ELSE 0 END ) AS THIRTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 12 THEN 1 ELSE 0 END ) AS FOURTEEN      ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 13 THEN 1 ELSE 0 END ) AS FIFTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 14 THEN 1 ELSE 0 END ) AS SIXTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 15 THEN 1 ELSE 0 END ) AS SEVENTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 16 THEN 1 ELSE 0 END ) AS EIGHTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 17 THEN 1 ELSE 0 END ) AS NINETEEN  ,\n" +
			"			\"COUNT\"(0) AS TOTAL\n" +
			"		FROM\n" +
			"			V_DM_REPORT_INFO\n" +
			"		WHERE\n" +
			"			REPORT_STATUS!=5 AND DIS_TYPE =5 AND ((REPORT_TYPE=2 AND TUMOR_DEATH_FIRST_FLAG=1) OR REPORT_TYPE=1)  AND %1$s \n"  +
			"		GROUP BY\n" +
			"			rollup(\n" +
			"			TUMOR_ICD_TEN_TYPE,\n" +
			"			TUMOR_ICD_TEN_SHORT_CODE)";

	private static final String TUMOR_DEATH_BY_GENGER_SQL=""+
	"	SELECT\n" +
	"			decode(grouping_id(TUMOR_ICD_TEN_SHORT_CODE),1,'-1',TUMOR_ICD_TEN_SHORT_CODE) SUB_DIS_TYPE,\n" +
	"			\"SUM\"(CASE GENDER WHEN '1' THEN 1 ELSE 0 END ) AS MAN_COUNT ,  \n" +
	"			\"SUM\"(CASE GENDER WHEN '2' THEN 1 ELSE 0 END ) AS WMMAN_COUNT  ,\n" +
	"			\"COUNT\"(0) AS TOTAL\n" +
	"		FROM\n" +
	"			V_DM_REPORT_INFO\n" +
	"		WHERE\n" +
	"			REPORT_STATUS!=5 AND DIS_TYPE =5 AND REPORT_TYPE=2 AND %1$s  \n" +
	"		GROUP BY\n" +
	"			rollup( TUMOR_ICD_TEN_SHORT_CODE)";


	private static final String TUMOR_DEATH_BY_AGE_SQL=""+
			"	SELECT\n" +
			"			decode(grouping_id(TUMOR_ICD_TEN_SHORT_CODE),1,'-1',TUMOR_ICD_TEN_SHORT_CODE) SUB_DIS_TYPE,\n" +
			"			\"SUM\"(CASE   WHEN BIRTHDAY IS NULL THEN 1 ELSE 0 END ) AS ZERO ,  \n" +
			"			\"SUM\"(CASE TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) WHEN 0 THEN 1 ELSE 0 END ) AS ONE ,  \n" +
			"			\"SUM\"(CASE  WHEN  TO_NUMBER(TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) >0 AND TO_NUMBER(TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) <5 THEN 1 ELSE 0 END ) AS TWO  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 1 THEN 1 ELSE 0 END ) AS THREE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 2 THEN 1 ELSE 0 END ) AS FOUR  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 3 THEN 1 ELSE 0 END ) AS FIVE                  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 4 THEN 1 ELSE 0 END ) AS SIX  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 5 THEN 1 ELSE 0 END ) AS SERVEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 6 THEN 1 ELSE 0 END ) AS EIGHT  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 7 THEN 1 ELSE 0 END ) AS NINE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 8 THEN 1 ELSE 0 END ) AS TEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 9 THEN 1 ELSE 0 END ) AS ELEVEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 10 THEN 1 ELSE 0 END ) AS TWELVE  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 11 THEN 1 ELSE 0 END ) AS THIRTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 12 THEN 1 ELSE 0 END ) AS FOURTEEN      ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 13 THEN 1 ELSE 0 END ) AS FIFTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 14 THEN 1 ELSE 0 END ) AS SIXTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 15 THEN 1 ELSE 0 END ) AS SEVENTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 16 THEN 1 ELSE 0 END ) AS EIGHTEEN  ,\n" +
			"			\"SUM\"(CASE TRUNC ( ( TO_NUMBER (TO_CHAR(%2$s, 'YYYY')) - TO_NUMBER (TO_CHAR(BIRTHDAY, 'YYYY')) ) / 5 ) WHEN 17 THEN 1 ELSE 0 END ) AS NINETEEN  ,\n" +
			"			\"COUNT\"(0) AS TOTAL\n" +
			"		FROM\n" +
			"			V_DM_REPORT_INFO\n" +
			"		WHERE\n" +
			"			REPORT_STATUS!=5 AND DIS_TYPE =5 AND REPORT_TYPE=2 AND %1$s  \n" +
			"		GROUP BY\n" +
			"			rollup( TUMOR_ICD_TEN_SHORT_CODE)";
    //@fon
	@Override
	public List<DmYearReport> getCdYearReportByGenger(Criteria criteria) {
		String where=criteria.toSql(ClassMetadata.getMetadata(DmReportInfo.class),":");
		String sql=String.format(CD_BY_GENGER_SQL, where);
		List<DmYearReport> reports= getList(DmYearReport.class, sql, criteria);
		return reports;
	}

	@Override
	public List<DmYearReport> getCdYearReportByAge(Criteria criteria) {
		String where=criteria.toSql(ClassMetadata.getMetadata(DmReportInfo.class),":");
		String sql=String.format(CD_BY_AGE_SQL, where,getAgeCalBaseDateSql(criteria));
		List<DmYearReport> reports= getList(DmYearReport.class, sql, criteria);
		return reports;
	}



	@Override
	public List<DmYearReport> getTumorYearReportByAge(Criteria criteria) {
		String where=criteria.toSql(ClassMetadata.getMetadata(DmReportInfo.class),":");
		String sql=String.format(TUMOR_BY_AGE_SQL, where,getAgeCalBaseDateSql(criteria));
		List<DmYearReport> reports= getList(DmYearReport.class, sql, criteria);
		return reports;
	}


	@Override
	public List<DmYearReport> getTumorYearReportByGenger(Criteria criteria) {
		String where=criteria.toSql(ClassMetadata.getMetadata(DmReportInfo.class),":");
		String sql=String.format(TUMOR_BY_GENGER_SQL, where);
		List<DmYearReport> reports= getList(DmYearReport.class, sql, criteria);
		return reports;
	}

	@Override
	public List<DmYearReport> getTumorDeathYearReportByAge(Criteria criteria) {
        criteria.add("TUMOR_ICD_TEN_TYPE","1");
		String where=criteria.toSql(ClassMetadata.getMetadata(DmReportInfo.class),":");
		String sql=String.format(TUMOR_DEATH_BY_AGE_SQL, where,getAgeCalBaseDateSql(criteria));
		List<DmYearReport> reports= getList(DmYearReport.class, sql, criteria);
		return reports;
	}


	@Override
	public List<DmYearReport> getTumorDeathYearReportByGenger(Criteria criteria) {
        criteria.add("TUMOR_ICD_TEN_TYPE","1");
		String where=criteria.toSql(ClassMetadata.getMetadata(DmReportInfo.class),":");
		String sql=String.format(TUMOR_DEATH_BY_GENGER_SQL, where);
		List<DmYearReport> reports= getList(DmYearReport.class, sql, criteria);
		return reports;
	}

    private String getAgeCalBaseDateSql(Criteria criteria){
        if (criteria.contains("CREATE_DATE")){
            return "CREATE_DATE";
        }else{
            return "CD_DIAGNOSIS_DATE";
        }
    }


    @Override
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

}
