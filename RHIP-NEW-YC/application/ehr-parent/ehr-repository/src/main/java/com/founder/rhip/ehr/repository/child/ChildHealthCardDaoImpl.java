package com.founder.rhip.ehr.repository.child;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.women.BirthDefectMonitor;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.child.ChildHealthCard;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

import java.util.*;

/**
 * DAO implement of ChildHealthCard
 * 
 */
@Repository("childHealthCardDao")
public class ChildHealthCardDaoImpl extends AbstractDao<ChildHealthCard, String> implements IChildHealthCardDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String CHILD_AGE_STATISTICS_SQL = "select %4$s from(select latown_ship,lastreet,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 0 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<1 then 1 else 0 end)zeroNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 1 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<2 then 1 else 0 end)oneNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 2 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<3 then 1 else 0 end)twoNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 3 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<4 then 1 else 0 end)threeNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 4 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<5 then 1 else 0 end)fourNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 5 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<6 then 1 else 0 end)fiveNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 6 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%2$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<7 then 1 else 0 end)sixNum1,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 0 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<1 then 1 else 0 end)zeroNum2,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 1 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<2 then 1 else 0 end)oneNum2,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 2 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<3 then 1 else 0 end)twoNum2,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 3 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<4 then 1 else 0 end)threeNum2,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 4 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<5 then 1 else 0 end)fourNum2,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 5 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<6 then 1 else 0 end)fiveNum2,"
			+ " sum(case when %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)= 6 and %1$s - to_char(birthday, 'yyyy') + decode(sign(%3$s - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0)<7 then 1 else 0 end)sixNum2"
			+ " from ch_child_health_card  group by latown_ship,lastreet)";

    public Map countChildCard(Map<String, String> paramMap, List orgCodes){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        String orgField = "";
        if("0".equals(genreCode)){
            orgField = "LATOWN_SHIP";
            ca.add(orgField,OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }

        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "INPUT_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS cardCount FROM CH_CHILD_HEALTH_CARD ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS cardCount FROM CH_CHILD_HEALTH_CARD ");
        SqlBuilder.buildWhereStatement(ChildHealthCard.class, sql, ca);
//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> cards = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> card : cards){
            resultMap.put(card.get("org"), card.get("cardCount"));
        }
        return resultMap;
    }

    public Map countChildCardByAge(Map<String, String> paramMap, List orgCodes, int age){
        String countField = "cardCount" + String.valueOf(age);
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        String orgField = "";
        if("0".equals(genreCode)){
            orgField = "LATOWN_SHIP";
            ca.add(orgField,OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }

        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "INPUT_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS " +countField+ " FROM CH_CHILD_HEALTH_CARD ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS " +countField+ " FROM CH_CHILD_HEALTH_CARD ");
        SqlBuilder.buildWhereStatement(ChildHealthCard.class, sql, ca);
        if(ObjectUtil.isNotEmpty(age)){
            sql.append(" AND CEIL(MONTHS_BETWEEN(SYSDATE, BIRTHDAY) / 12) <= " + String.valueOf(age));
        }

//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> cards = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> card : cards){
            resultMap.put(card.get("org"), card.get(countField));
        }
        return resultMap;
    }

    public List<Map<String, Object>> getChildCount(Map<String, String> paramMap, List orgCodes){
        String paTownShip = paramMap.get("paTownShip");
        String timePoint = paramMap.get("timePoint");
        String timePointStr = "";
        if("3".equals(timePoint)){
            timePointStr = String.valueOf(DateUtil.getCurrentYear())+"0330";
        }
        if("9".equals(timePoint)){
            timePointStr = String.valueOf(DateUtil.getCurrentYear())+"0929";
        }
        String genreCode = paramMap.get("genreCode");
        String orgField = "LATOWN_SHIP";
        if("A100".equals(genreCode)){
            orgField = "CREATE_ORGAN_CODE";
        }else if("B100".equals(genreCode)){
            orgField = "CREATE_ORGAN_CODE";
        }else if("B200".equals(genreCode)){
            orgField = "CREATE_ORGAN_CODE";
        }else if("0".equals(genreCode)){
            orgField = "LATOWN_SHIP";
        }

        String orgCodesStr = "";
        if(null!= orgCodes && orgCodes.size()>0){
            for(Object orgCode : orgCodes){
                orgCodesStr = orgCodesStr + "'" + orgCode.toString() + "',";
            }
            orgCodesStr = orgCodesStr.substring(0, orgCodesStr.length() - 1);
        }

        StringBuilder sql = new StringBuilder("\n" +
                "SELECT DECODE("+orgField+", NULL, '合计', "+orgField+" ) AS ORGAN_CODE,\n" +
                "       SUM(DECODE(AGE, '0', TOTAL, 0)) + SUM(DECODE(AGE, '1', TOTAL, 0)) AS \"G1\",\n" +
                "       SUM(DECODE(AGE, '2', TOTAL, 0)) AS \"G2\",\n" +
                "       SUM(DECODE(AGE, '3', TOTAL, 0)) AS \"G3\",\n" +
                "       SUM(DECODE(AGE, '4', TOTAL, 0)) AS \"G4\",\n" +
                "       SUM(DECODE(AGE, '5', TOTAL, 0)) AS \"G5\",\n" +
                "       SUM(DECODE(AGE, '6', TOTAL, 0)) AS \"G6\",\n" +
                "       SUM(DECODE(AGE, '7', TOTAL, 0)) AS \"G7\",\n" +
                "       SUM(DECODE(AGE, '0', TOTAL, 0)) + SUM(DECODE(AGE, '1', TOTAL, 0))+SUM(DECODE(AGE, '2', TOTAL, 0)) + SUM(DECODE(AGE, '3', TOTAL, 0)) + SUM(DECODE(AGE, '4', TOTAL, 0))+SUM(DECODE(AGE, '5', TOTAL, 0)) + SUM(DECODE(AGE, '6', TOTAL, 0)) + SUM(DECODE(AGE, '7', TOTAL, 0)) AS \"ORGSUM\"\n" +
                "  FROM (SELECT "+orgField+", AGE, COUNT(AGE) AS TOTAL\n" +
                "          FROM (SELECT ID,\n" +
                "                       "+orgField+", LASTREET,\n" +
                "                       FLOOR(MONTHS_BETWEEN(TO_DATE('"+timePointStr+"', 'YYYYMMDD'), BIRTHDAY) / 12) + 1 AS AGE\n" +
                "                  FROM CH_CHILD_HEALTH_CARD\n" +
                "                  WHERE LACOUNTY = '永城市' ");
                if(StringUtil.isNotEmpty(orgCodesStr)){
                    sql.append("                 AND "+orgField+" IN (" +orgCodesStr+")\n"   );
                }

                sql.append(
                " )         GROUP BY AGE, "+orgField+")\n" +
                " GROUP BY ROLLUP("+orgField+")\n");


        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

	@Override
	public List<Map<String, Object>> getChildAgeStatisticsMapList(String dateStr) {
		Integer year = DateUtil.getCurrentYear();
		String selectAlises = "latown_ship,lastreet,zeroNum1,oneNum1,twoNum1,threeNum1,fourNum1,fiveNum1,sixNum1,"
				+ "zeroNum1+oneNum1+twoNum1+threeNum1+fourNum1+fiveNum1+sixNum1 totalNum1,"
				+ "zeroNum2,oneNum2,twoNum2,threeNum2,fourNum2,fiveNum2,sixNum2,"
				+ "zeroNum2+oneNum2+twoNum2+threeNum2+fourNum2+fiveNum2+sixNum2 totalNum2";
		String sql = String.format(CHILD_AGE_STATISTICS_SQL, String.valueOf(year),"0331","0930",selectAlises);
		return getMapList(sql, new Criteria());
	}
	
}