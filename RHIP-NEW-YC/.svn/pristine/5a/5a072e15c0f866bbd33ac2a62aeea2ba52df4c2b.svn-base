package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of BirthCertificate
 * 
 */
@Repository("birthCertificateDao")
public class BirthCertificateDaoImpl extends AbstractDao<BirthCertificate, String> implements IBirthCertificateDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 年度趋势（按出生日期月份1~12月）
     */
    private String TREND_YEAR_SQL = "SELECT\n" +
            "	SUM(month1) month1\n" +
            "	,SUM(month2) month2\n" +
            "	,SUM(month3) month3\n" +
            "	,SUM(month4) month4\n" +
            "	,SUM(month5) month5\n" +
            "	,SUM(month6) month6\n" +
            "	,SUM(month7) month7\n" +
            "	,SUM(month8) month8\n" +
            "	,SUM(month9) month9\n" +
            "	,SUM(month10) month10\n" +
            "	,SUM(month11) month11\n" +
            "	,SUM(month12) month12\n" +
            "FROM(\n" +
            "	SELECT \n" +
            "		COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'01',1,NULL)) month1\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'02',1,NULL)) month2\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'03',1,NULL)) month3\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'04',1,NULL)) month4\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'05',1,NULL)) month5\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'06',1,NULL)) month6\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'07',1,NULL)) month7\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'08',1,NULL)) month8\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'09',1,NULL)) month9\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'10',1,NULL)) month10\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'11',1,NULL)) month11\n" +
            "		,COUNT(DECODE(TO_CHAR(NEONATAL_BIRTHDAY,'mm'),'12',1,NULL)) month12\n" +
            "	FROM CH_BIRTH_CERTIFICATE\n" +
            "	%1$s\n" +
            ")";
    private String GENDER_COMPOSE_SQL = "SELECT\n" +
            "	SUM(GENDER1) GENDER1\n" +
            "	,SUM(GENDER2) GENDER2\n" +
            "FROM(\n" +
            "	SELECT \n" +
            "		COUNT(DECODE(NEONATAL_GENDER,1,1,NULL)) GENDER1\n" +
            "		,COUNT(DECODE(NEONATAL_GENDER,2,1,NULL)) GENDER2\n" +
            "	FROM CH_BIRTH_CERTIFICATE\n" +
            "	%1$s\n" +
            ")";

    public Map countChildBirth(Map<String, String> paramMap, List orgCodes){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        String orgField = "";
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField,OP.IN, orgCodes);
        }else {
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }


        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "NEONATAL_BIRTHDAY", beginDate,endDate);

        StringBuilder sql = new StringBuilder("SELECT decode("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS birthCount FROM CH_BIRTH_CERTIFICATE ");
        SqlBuilder.buildWhereStatement(BirthCertificate.class, sql, ca);
        sql.append(" GROUP BY "+ " rollup(" + orgField + ")" );
        List<Map<String, Object>> birthCertificates = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> birthCertificate : birthCertificates){
            resultMap.put(birthCertificate.get("org"), birthCertificate.get("birthCount"));
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getTrendMap(Criteria ca) {
        Map<String,Object> result = new HashMap<String,Object>();
        StringBuilder sql = new StringBuilder(TREND_YEAR_SQL);
        StringBuilder sqlWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(BirthCertificate.class, sqlWhere, ca);
        String lastsql = String.format(sql.toString(),sqlWhere.toString());
        List<Map<String,Object>> maplist = this.getMapList(lastsql,ca);
        if(ObjectUtil.isNotEmpty(maplist)){
            result = maplist.get(0);
        }
        return result;
    }

    @Override
    public Map<String, Object> getGenderComposeMap(Criteria ca) {
        Map<String,Object> result = new HashMap<String,Object>();
        StringBuilder sql = new StringBuilder(GENDER_COMPOSE_SQL);
        StringBuilder sqlWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(BirthCertificate.class, sqlWhere, ca);
        String lastsql = String.format(sql.toString(),sqlWhere.toString());
        List<Map<String,Object>> maplist = this.getMapList(lastsql,ca);
        if(ObjectUtil.isNotEmpty(maplist)){
            result = maplist.get(0);
        }
        return result;
    }

}