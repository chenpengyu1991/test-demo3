package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.child.ChildHealthCard;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.women.BirthDefectMonitor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of 妇幼保健
 */
@Repository("wchTargetDao")
public class WchTargetDaoImpl extends AbstractDao<IdmReport, Long> implements IWchTargetDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


    @Override
    public List<Map<String, Object>> getChildCount(Map<String, String> paramMap) {
        String paTownShip = paramMap.get("paTownShip");
        String timePoint = paramMap.get("timePoint");
        String timePointStr = "";
        if ("3".equals(timePoint)) {
            timePointStr = String.valueOf(DateUtil.getCurrentYear()) + "0331";
        }
        if ("9".equals(timePoint)) {
            timePointStr = String.valueOf(DateUtil.getCurrentYear()) + "0930";
        }
        String genreCode = paramMap.get("genreCode");
        String orgField = "";
        if ("0".equals(genreCode)) {
            orgField = "LATOWN_SHIP";
        } else {
            orgField = "CREATE_ORGAN_CODE";
        }

        StringBuilder sql = new StringBuilder(
                "SELECT DECODE(" + orgField + ", NULL, '合计', " + orgField + " ) AS ORGAN_CODE,\n" +
                        "       SUM(DECODE(AGE, '1', TOTAL, 0)) AS \"G1\",\n" +
                        "       SUM(DECODE(AGE, '2', TOTAL, 0)) AS \"G2\",\n" +
                        "       SUM(DECODE(AGE, '3', TOTAL, 0)) AS \"G3\",\n" +
                        "       SUM(DECODE(AGE, '4', TOTAL, 0)) AS \"G4\",\n" +
                        "       SUM(DECODE(AGE, '5', TOTAL, 0)) AS \"G5\",\n" +
                        "       SUM(DECODE(AGE, '6', TOTAL, 0)) AS \"G6\",\n" +
                        "       SUM(DECODE(AGE, '7', TOTAL, 0)) AS \"G7\",\n" +
                        "       SUM(DECODE(AGE, '1', TOTAL, 0))+SUM(DECODE(AGE, '2', TOTAL, 0)) + SUM(DECODE(AGE, '3', TOTAL, 0)) + SUM(DECODE(AGE, '4', TOTAL, 0))+SUM(DECODE(AGE, '5', TOTAL, 0)) + SUM(DECODE(AGE, '6', TOTAL, 0)) + SUM(DECODE(AGE, '7', TOTAL, 0)) AS \"ORGSUM\"\n" +
                        "  FROM (SELECT " + orgField + ", AGE, COUNT(AGE) AS TOTAL\n" +
                        "          FROM (SELECT ID,\n" +
                        "                       " + orgField + ", LASTREET,\n" +
                        "                       CEIL(MONTHS_BETWEEN(TO_DATE('" + timePointStr + "', 'YYYYMMDD'), BIRTHDAY) / 12) AS AGE\n" +
                        "                  FROM CH_CHILD_HEALTH_CARD\n" +
                        "                  WHERE LACOUNTY = '市' "
        );
        sql.append(" )         GROUP BY AGE, " + orgField + ")\n" +
                " GROUP BY ROLLUP(" + orgField + ")\n");


        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    /**
     * 儿童保健基础统计
     *
     * @param paramMap
     * @return
     * @author Cary
     */
    @Override
    public List<Map<String, Object>> getChildBaseCount(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");

        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");

        String birthCountSql = getBirthCount(paramMap);
        String defectCountSql = getDefectCount(paramMap);
        String cardCountSql = getCardCount(paramMap);
        String childVisitCountSql = getChildVisitCount(paramMap);
        String hcCountSql = getHcCount(paramMap);

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        if(StringUtil.isNotEmpty(beginDateStr)){
            sqlParameterSource.addValue("minneonatalBirthday", DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(beginDateStr, null)));
            sqlParameterSource.addValue("minbirthday", DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(beginDateStr, null)));
            sqlParameterSource.addValue("mininputDate", DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(beginDateStr, null)));
            sqlParameterSource.addValue("minvisitDate", DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(beginDateStr, null)));
            sqlParameterSource.addValue("mincheckDate", DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(beginDateStr, null)));
            sqlParameterSource.addValue("mindeliveryDate", DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(beginDateStr, null)));
        }
        if(StringUtil.isNotEmpty(endDateStr)){
            sqlParameterSource.addValue("maxneonatalBirthday", DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(endDateStr, null)));
            sqlParameterSource.addValue("maxbirthday", DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(endDateStr, null)));
            sqlParameterSource.addValue("maxinputDate", DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(endDateStr, null)));
            sqlParameterSource.addValue("maxvisitDate", DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(endDateStr, null)));
            sqlParameterSource.addValue("maxcheckDate", DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(endDateStr, null)));
            sqlParameterSource.addValue("maxdeliveryDate", DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(endDateStr, null)));
        }

        StringBuilder sql = new StringBuilder("SELECT ORGAN_CODE, ORGAN_NAME, BIRTHCOUNT, DEFECTCOUNT, CARDCOUNT, CHILDVISITCOUNT, HEALTHEXAMCOUNT");
        sql.append(" FROM (");
        if (!"0".equals(genreCode)) {//关联机构视图
            sql.append(" (SELECT * FROM V_MDM_ORGANIZATION_NOSUB ");
            sql.append(" WHERE genre_code = '" + genreCode + "' ");
        } else {//关联TOWN视图
            sql.append(" (SELECT GB_CODE AS ORGAN_CODE, GB_NAME AS ORGAN_NAME FROM V_MDM_TOWN ");
            if(StringUtil.isNotEmpty(gbCode)){
                sql.append(" WHERE GB_CODE = '" + gbCode + "' ");
            }

        }
        sql.append(" ) O  ");
        sql.append(" LEFT JOIN (" + birthCountSql + ") BC ON BC.ORG = O.ORGAN_CODE ");
        sql.append(" LEFT JOIN (" + defectCountSql + ") BD ON BD.ORG = O.ORGAN_CODE ");
        sql.append(" LEFT JOIN (" + cardCountSql + ") HC ON HC.ORG = O.ORGAN_CODE ");
        sql.append(" LEFT JOIN (" + childVisitCountSql + ") CHV ON CHV.ORG = O.ORGAN_CODE ");
        sql.append(" LEFT JOIN (" + hcCountSql + ") CHE ON CHE.ORG = O.ORGAN_CODE ");
        sql.append(" ) ");
        sql.append(" WHERE 1 = 1 ");
        if ("A100".equals(genreCode)) {//市级医院
            if (StringUtil.isNotEmpty(superOrganCode)) {
                sql.append(" AND O.ORGAN_CODE = '" + superOrganCode + "'");
            }
        }
        if ("B100".equals(genreCode)) {//中心
            if (StringUtil.isNotEmpty(superOrganCode)) {
                sql.append(" AND O.ORGAN_CODE = '" + superOrganCode + "'");
            }
        }
        if ("B200".equals(genreCode)) {//站
            if (StringUtil.isNotEmpty(organCode)) {
                sql.append(" AND O.ORGAN_CODE = '" + organCode + "'");
            }
            if (StringUtil.isNotEmpty(superOrganCode)) {
                sql.append(" AND O.PARENT_CODE = '" + superOrganCode + "'");
            }
        }
        if (("B100".equals(genreCode) || "B200".equals(genreCode)) && StringUtil.isNotEmpty(gbCode)) {
            sql.append(" AND O.GB_CODE = '" + gbCode + "'");
        }
        sql.append(" ORDER BY ORGAN_CODE ");

        List<Map<String, Object>> baseCounts = getMapList(sql.toString(), sqlParameterSource);

        return baseCounts;
    }

    private String getBirthCount(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "NEONATAL_BIRTHDAY", beginDate, endDate);
        String orgField = "";
        if ("0".equals(genreCode)) {
            orgField = "PATOWN_SHIP";
        } else {
            orgField = "CREATE_ORGAN_CODE";
        }
        StringBuilder sql = new StringBuilder("SELECT DECODE(" + orgField + ", NULL, '合计', " + orgField + ") AS ORG, COUNT(1) AS BIRTHCOUNT\n" +
                "  FROM CH_BIRTH_CERTIFICATE ");
        SqlBuilder.buildWhereStatement(BirthCertificate.class, sql, ca);
        sql.append(" AND " + orgField + " IS NOT NULL");
        sql.append(" GROUP BY " + " rollup(" + orgField + ")");
        return sql.toString();
    }

    private String getDefectCount(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "DELIVERY_DATE", beginDate, endDate);
        String orgField = "";
        if ("0".equals(genreCode)) {
            orgField = "AREA_CODE";
        } else {
            orgField = "CREATE_ORGAN_CODE";
        }
        StringBuilder sql = new StringBuilder("SELECT DECODE(" + orgField + ",null,'合计'," + orgField + ") AS org, count(1) AS defectCount FROM WH_BIRTH_DEFECT_MONITOR ");
        SqlBuilder.buildWhereStatement(BirthDefectMonitor.class, sql, ca);
        sql.append(" AND " + orgField + " IS NOT NULL");
        sql.append(" GROUP BY " + " rollup(" + orgField + ")");
        return sql.toString();
    }

    private String getCardCount(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "INPUT_DATE", beginDate, endDate);
        String orgField = "";
        if ("0".equals(genreCode)) {
            orgField = "LATOWN_SHIP";
        } else {
            orgField = "CREATE_ORGAN_CODE";
        }
        StringBuilder sql = new StringBuilder("SELECT DECODE(" + orgField + ",null,'合计'," + orgField + ") AS org, count(1) AS cardCount FROM CH_CHILD_HEALTH_CARD ");
        SqlBuilder.buildWhereStatement(ChildHealthCard.class, sql, ca);
        sql.append(" AND " + orgField + " IS NOT NULL");
        sql.append(" GROUP BY " + " rollup(" + orgField + ")");
        return sql.toString();
    }

    private String getChildVisitCount(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", beginDate, endDate);
        String orgField = "";
        if ("0".equals(genreCode)) {
            orgField = "PATOWN_SHIP";
        } else {
            orgField = "CREATE_ORGAN_CODE";
        }
        StringBuilder sql = new StringBuilder("SELECT DECODE(" + orgField + ",null,'合计'," + orgField + ") AS org, count(1) AS childVisitCount FROM CH_NEONATAL_FAMILY_VISIT ");
        SqlBuilder.buildWhereStatement(NeonatalFamilyVisit.class, sql, ca);
        sql.append(" AND " + orgField + " IS NOT NULL");
        sql.append(" GROUP BY " + " rollup(" + orgField + ")");
        return sql.toString();
    }

    private String getHcCount(Map<String, String> paramMap) {
        String genreCode = paramMap.get("genreCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate, endDate);
        String orgField = "";
        if ("0".equals(genreCode)) {
            orgField = "PATOWN_SHIP";
        } else {
            orgField = "CREATE_ORGAN_CODE";
        }
        StringBuilder sql = new StringBuilder("SELECT DECODE(" + orgField + ",null,'合计'," + orgField + ") AS org, count(1) AS healthExamCount FROM CH_CHILD_HEALTH_EXAMINATION ");
        SqlBuilder.buildWhereStatement(ChildHealthExamination.class, sql, ca);
        sql.append(" AND " + orgField + " IS NOT NULL");
        sql.append(" GROUP BY " + " rollup(" + orgField + ")");
        return sql.toString();
    }

    /**
     * 住院分娩率
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getHospitalDelivery(Map<String, String> paramMap){
        String paTownShip = paramMap.get("gbCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");

        StringBuilder sql = new StringBuilder("\n" +
                "select gb_code,nvl(sum(cnm),0) cnm from v_mdm_organization o left join (\n" +
                "SELECT CREATE_ORGAN_CODE, count(*) cnm\n" +
                "FROM WH_DELIVERY_RECORD_INFO\n" +
                "WHERE DELIVERY_DATE >= TO_DATE('"+beginDateStr+"', 'YYYY/MM/DD') \n" +
                "AND DELIVERY_DATE <= TO_DATE('"+endDateStr+"', 'YYYY/MM/DD')\n" +
                "group by CREATE_ORGAN_CODE\n" +
                ") r on o.organ_code = r.CREATE_ORGAN_CODE\n");
        if(StringUtil.isNotEmpty(paTownShip)){
            sql.append("where gb_code = '"+paTownShip+"'");
        }
        sql.append("group by gb_code order by gb_code");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

}