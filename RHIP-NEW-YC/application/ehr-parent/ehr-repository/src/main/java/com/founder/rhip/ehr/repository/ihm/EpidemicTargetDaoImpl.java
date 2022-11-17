package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;

import javax.annotation.Resource;

/**
 * DAO implement of 疫情分析
 * 
 */
@Repository("epidemicTargetDao")
public class EpidemicTargetDaoImpl extends	AbstractDao<IdmReport, Long> implements IEpidemicTargetDao {

    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


    /**
     * 按职业统计
     */
    private static final String OCCUPATION_SQL = " SELECT * FROM ("
    		+ "SELECT COUNT(IDM_ID) reportSum"
    		+ " ,decode(grouping_id(%3$s),1,'grouping',%3$s) AS  organCode"
    		+ " ,decode(grouping_id(occupation),1,'grouping',occupation) AS  occupation"
    		+ " FROM "
    		+ " (SELECT org.gb_code,org.parent_code,org.ORGAN_CODE,org.GENRE_CODE, IDM.*  FROM V_MDM_ORGANIZATION_NOSUB ORG"
    		+ " LEFT JOIN "
    		+ " (SELECT * FROM V_DCD_IDM_DATA %1$s"
    		+ " ) IDM ON IDM.FILL_ORGAN_CODE = ORG.ORGAN_CODE"
    		+ " WHERE 1=1 %2$s)"
    		+ " GROUP BY CUBE(%3$s,OCCUPATION)"
    		+ " ORDER BY %3$s,OCCUPATION"
    		+ " ) WHERE organcode is not null and occupation is not null";
    
    /**
     * 职业种类统计
     */
    private static final String OCCUPATION_TYPE_SQL = "SELECT OCCUPATION occupation"
    		+ " FROM V_DCD_IDM_OCCUPATION"
    		+ " %1$s"
    		+ " GROUP BY OCCUPATION"
    		+ " ORDER BY OCCUPATION";    
    
    /**
     * 按年龄统计
     * 年龄按照报卡日期进行计算
     */
    private static final String AGE_SQL = "SELECT  %3$s organCode,SUM(DECODE(SIGN(NVL(AGE_NUMBER,-1)),-1,0,1)) TOTAL"
    		+ " ,SUM(CASE AGE_NUMBER WHEN 0 THEN 1 ELSE 0 END ) AS ONE"
    		+ " ,SUM(CASE  WHEN  AGE_NUMBER >0 AND AGE_NUMBER <5 THEN 1 ELSE 0 END ) AS TWO"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 1 THEN 1 ELSE 0 END ) AS THREE"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 2 THEN 1 ELSE 0 END ) AS FOUR"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 3 THEN 1 ELSE 0 END ) AS FIVE"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 4 THEN 1 ELSE 0 END ) AS SIX"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 5 THEN 1 ELSE 0 END ) AS SERVEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 6 THEN 1 ELSE 0 END ) AS EIGHT"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 7 THEN 1 ELSE 0 END ) AS NINE"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 8 THEN 1 ELSE 0 END ) AS TEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 9 THEN 1 ELSE 0 END ) AS ELEVEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 10 THEN 1 ELSE 0 END ) AS TWELVE"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 11 THEN 1 ELSE 0 END ) AS THIRTEEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 12 THEN 1 ELSE 0 END ) AS FOURTEEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 13 THEN 1 ELSE 0 END ) AS FIFTEEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 14 THEN 1 ELSE 0 END ) AS SIXTEEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 15 THEN 1 ELSE 0 END ) AS SEVENTEEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 16 THEN 1 ELSE 0 END ) AS EIGHTEEN"
    		+ " ,SUM(CASE TRUNC ( AGE_NUMBER / 5 ) WHEN 17 THEN 1 ELSE 0 END ) AS NINETEEN"
    		+ " FROM"

    		+ " (SELECT org.gb_code,org.parent_code,org.ORGAN_CODE,org.GENRE_CODE, IDM.*  FROM V_MDM_ORGANIZATION_NOSUB ORG"
    		+ " LEFT JOIN "
    		+ " (SELECT "
    		+ " FILL_ORGAN_CODE"
    		+ " ,DECODE(BIRTHDAY,NULL"
    		+ "         ,DECODE(AGE_UNIT "
    		+ "                 ,1,TO_NUMBER(AGE)"
    		+ "                 ,2,TRUNC(TO_NUMBER(AGE)/12)"
    		+ "                 ,3,TRUNC(TO_NUMBER(AGE)/365))"
    		+ "         ,TRUNC(TO_NUMBER(TO_CHAR(FILL_DATE,'yyyy'))-TO_NUMBER(TO_CHAR(BIRTHDAY,'yyyy')))) AGE_NUMBER" 
    		+ " FROM V_DCD_IDM_DATA %1$s"
    		+ " ) IDM ON IDM.FILL_ORGAN_CODE = ORG.ORGAN_CODE"
    		+ " WHERE 1=1  %2$s)"
    		+ " WHERE %3$s IS NOT NULL"
    		+ " GROUP BY ROLLUP(%3$s)"
    		+ " ORDER BY %3$s";  
 
    
	@Override
	public List<Map<String, Object>> getOccupationTargetList(Criteria criteria) {
		StringBuilder sql = new StringBuilder(OCCUPATION_SQL);
		StringBuilder  whereSQL1 = new StringBuilder();
		StringBuilder  whereSQL2 = new StringBuilder();
		String genreCode = criteria.get("genreCode").toString();
		if(!"0".equals(genreCode)){
			whereSQL2.append(" AND GENRE_CODE='" + genreCode + "'");//机构类型
		}
		String orgField = "0".equals(genreCode)?"GB_CODE":"ORGAN_CODE";
		Object gbCode = criteria.get("GB_CODE");
		Object organCode = criteria.get("ORGAN_CODE");
		if(ObjectUtil.isNotEmpty(gbCode)){
			whereSQL2.append(" AND GB_CODE='" + gbCode.toString() + "'");
			criteria.remove("GB_CODE");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			whereSQL2.append(" AND ORGAN_CODE='" + organCode.toString() + "'");
			criteria.remove("ORGAN_CODE");
		}		
		criteria.remove("genreCode");
		SqlBuilder.buildWhereStatement(IdmReport.class, whereSQL1, criteria);
		String lastSql = String.format(sql.toString(),whereSQL1.toString(),whereSQL2.toString(),orgField);
		return this.getMapList(lastSql, criteria);
	}

	@Override
	public List<Map<String, Object>> getOccupationTypeList(Criteria criteria) {
		StringBuilder sql = new StringBuilder(OCCUPATION_TYPE_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		SqlBuilder.buildWhereStatement(IdmReport.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),whereSQL.toString());
		return this.getMapList(lastSql, criteria);
	}
	@Override
	public List<Map<String, Object>> getAgeTargetList(Criteria criteria) {
		StringBuilder sql = new StringBuilder(AGE_SQL);
		StringBuilder  whereSQL1 = new StringBuilder();
		StringBuilder  whereSQL2 = new StringBuilder();
		String genreCode = criteria.get("genreCode").toString();
		if(!"0".equals(genreCode)){
			whereSQL2.append(" AND GENRE_CODE='" + genreCode + "'");//机构类型
		}
		String orgField = "0".equals(genreCode)?"GB_CODE":"ORGAN_CODE";
		Object gbCode = criteria.get("GB_CODE");
		Object organCode = criteria.get("ORGAN_CODE");
		if(ObjectUtil.isNotEmpty(gbCode)){
			whereSQL2.append(" AND GB_CODE='" + gbCode.toString() + "'");
			criteria.remove("GB_CODE");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			whereSQL2.append(" AND ORGAN_CODE='" + organCode.toString() + "'");
			criteria.remove("ORGAN_CODE");
		}		
		criteria.remove("genreCode");
		SqlBuilder.buildWhereStatement(IdmReport.class, whereSQL1, criteria);
		String lastSql = String.format(sql.toString(),whereSQL1.toString(),whereSQL2.toString(),orgField);
		return this.getMapList(lastSql, criteria);
	}
}