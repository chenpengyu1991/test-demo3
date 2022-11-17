package com.founder.rhip.ehr.repository.women;
import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.women.BirthDefectMonitor;
import com.founder.fasf.repository.AbstractDao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of BirthDefectMonitor
 * 
 */
@Repository("birthDefectMonitorDao")
public class BirthDefectMonitorDaoImpl extends AbstractDao<BirthDefectMonitor, String> implements IBirthDefectMonitorDao {
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
            "		COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'01',1,NULL)) month1\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'02',1,NULL)) month2\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'03',1,NULL)) month3\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'04',1,NULL)) month4\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'05',1,NULL)) month5\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'06',1,NULL)) month6\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'07',1,NULL)) month7\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'08',1,NULL)) month8\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'09',1,NULL)) month9\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'10',1,NULL)) month10\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'11',1,NULL)) month11\n" +
            "		,COUNT(DECODE(TO_CHAR(DELIVERY_DATE,'mm'),'12',1,NULL)) month12\n" +
            "	FROM WH_BIRTH_DEFECT_MONITOR\n" +
            "	%1$s\n" +
            ")";

    private String DEFECT_TYPE_SQL =
            "	SELECT BIRTH_DEFECT_TYPE\n" +
                    "		,COUNT(1) DEFECT_TYPE_COUNT\n" +
                    "	FROM WH_BIRTH_DEFECT_MONITOR\n" +
                    "	%1$s\n" +
                    "   GROUP BY BIRTH_DEFECT_TYPE" ;

    public Map countChildDefect(Map<String, String> paramMap, List orgCodes){

        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria();
        String orgField = "";
        if("0".equals(genreCode)){
            orgField = "AREA_CODE";
            ca.add(orgField,OP.IN, orgCodes);
        }else {
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }

        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "BIRTHDAY", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS defectCount FROM WH_BIRTH_DEFECT_MONITOR ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS defectCount FROM WH_BIRTH_DEFECT_MONITOR ");
        SqlBuilder.buildWhereStatement(BirthDefectMonitor.class, sql, ca);
//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> birthDefects = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> birthCertificate : birthDefects){
            resultMap.put(birthCertificate.get("org"), birthCertificate.get("defectCount"));
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getTrendMap(Criteria ca) {
        Map<String,Object> result = new HashMap<String,Object>();
        StringBuilder sql = new StringBuilder(TREND_YEAR_SQL);
        StringBuilder sqlWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(BirthDefectMonitor.class, sqlWhere, ca);
        String lastsql = String.format(sql.toString(),sqlWhere.toString());
        List<Map<String,Object>> maplist = this.getMapList(lastsql,ca);
        if(ObjectUtil.isNotEmpty(maplist)){
            result = maplist.get(0);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getDefectTypeMap(Criteria ca) {
        StringBuilder sql = new StringBuilder(DEFECT_TYPE_SQL);
        StringBuilder sqlWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(BirthDefectMonitor.class, sqlWhere, ca);
        String lastsql = String.format(sql.toString(),sqlWhere.toString());
        return this.getMapList(lastsql,ca);
    }
}