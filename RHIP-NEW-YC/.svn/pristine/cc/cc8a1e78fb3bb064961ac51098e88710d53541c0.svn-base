package com.founder.rhip.ehr.repository.child;
import javax.annotation.Resource;

import com.founder.fasf.beans.OP;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.child.ChildHealthCard;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of NeonatalFamilyVisit
 * 
 */
@Repository("neonatalFamilyVisitDao")
public class NeonatalFamilyVisitDaoImpl extends AbstractDao<NeonatalFamilyVisit, String> implements INeonatalFamilyVisitDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public Long getNeonatalVisitCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT PERSON_ID) FROM CH_NEONATAL_FAMILY_VISIT");
		SqlBuilder.buildWhereStatement(NeonatalFamilyVisit.class, sql, criteria);
		Long count = this.getSingle(sql.toString(), criteria, Long.class);
		return count;
	}

    public Map countChildVisit(Map<String, String> paramMap, List orgCodes){
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
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }

        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS childVisitCount FROM CH_NEONATAL_FAMILY_VISIT ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS childVisitCount FROM CH_NEONATAL_FAMILY_VISIT ");
        SqlBuilder.buildWhereStatement(NeonatalFamilyVisit.class, sql, ca);
//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> birthDefects = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> birthCertificate : birthDefects){
            resultMap.put(birthCertificate.get("org"), birthCertificate.get("childVisitCount"));
        }
        return resultMap;
    }

    public Map countHearing(Map<String, String> paramMap, List orgCodes){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Criteria ca = new Criteria("HEARING_SCREENING_RESULTS", OP.UEMPTY, null);
        String orgField = "";
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField,OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }

        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "VISIT_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS hearingCount FROM CH_NEONATAL_FAMILY_VISIT ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS hearingCount FROM CH_NEONATAL_FAMILY_VISIT ");
        SqlBuilder.buildWhereStatement(NeonatalFamilyVisit.class, sql, ca);
//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> birthDefects = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> birthCertificate : birthDefects){
            resultMap.put(birthCertificate.get("org"), birthCertificate.get("hearingCount"));
        }
        return resultMap;
    }
    
    public List<Map<String, Object>> getNeonatalFamilyVisitMapList(String dateStr) {
    	Assert.notNull(dateStr);
    	StringBuilder sqlBuilder = new StringBuilder(" select t.create_organ_code organCode,to_char(t.VISIT_DATE,'yyyy/MM/dd') vt, sum(decode(t.HEARING_SCREENING_RESULTS,null,t.HEARING_SCREENING_RESULTS,1)) hs_num, count(1) visit_num from ch_neonatal_family_visit t where to_char(t.gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by t.create_organ_code,to_char(t.VISIT_DATE,'yyyy/MM/dd')");
    	return getMapList(sqlBuilder.toString(), new Criteria());
    }
    
}