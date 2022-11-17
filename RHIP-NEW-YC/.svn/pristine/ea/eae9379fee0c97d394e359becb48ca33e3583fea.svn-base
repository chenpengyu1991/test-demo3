package com.founder.rhip.im.repository.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.im.entity.medical.RdRealnameClinic;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RdBedDistribution
 * 
 */
@Repository("rdRealnameClinicDao")
public class RdRealnameClinicDaoImpl extends AbstractDao<RdRealnameClinic, Long> implements IRdRealnameClinicDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;

    private String ORGAN_SUMMARY_SQL = "select CLINIC_ORGAN_CODE\n" +
            ",COUNT(1) CLINIC_NUM\n" +
            ",COUNT(DECODE(IDCARD,NULL,NULL,1)) REALNAME_NUM\n" +
            "from(\n" +
            "   SELECT outpatient.CLINIC_ORGAN_CODE,outpatient.CLINIC_DATE,person.IDCARD\n" +
            "   FROM(\n" +
            "	    SELECT CLINIC_ORGAN_CODE,CLINIC_DATE,PERSON_ID\n" +
            "	    FROM MS_OUTPATIENT_INFO@DL_MS INFO\n" +
            "       left join mdm_organization org on ORG.ORGAN_CODE = INFO.CLINIC_ORGAN_CODE\n" +
            "	    %1$s\n" +
            "   ) outpatient\n" +
            "   left join BI_PERSON_INFO person on PERSON.id = OUTPATIENT.PERSON_ID\n" +
            ")\n" +
            "group by CLINIC_ORGAN_CODE";



    /**
     * 实名制年度趋势（按就诊日期月份1~12月）
     */
    private String TREND_YEAR_SQL = "	SELECT \n" +
            "		SUM(DECODE(MONTH,'1',CLINIC_NUM,0)) month1\n" +
            "		,SUM(DECODE(MONTH,'2',CLINIC_NUM,0)) month2\n" +
            "		,SUM(DECODE(MONTH,'3',CLINIC_NUM,0)) month3\n" +
            "		,SUM(DECODE(MONTH,'4',CLINIC_NUM,0)) month4\n" +
            "		,SUM(DECODE(MONTH,'5',CLINIC_NUM,0)) month5\n" +
            "		,SUM(DECODE(MONTH,'6',CLINIC_NUM,0)) month6\n" +
            "		,SUM(DECODE(MONTH,'7',CLINIC_NUM,0)) month7\n" +
            "		,SUM(DECODE(MONTH,'8',CLINIC_NUM,0)) month8\n" +
            "		,SUM(DECODE(MONTH,'9',CLINIC_NUM,0)) month9\n" +
            "		,SUM(DECODE(MONTH,'10',CLINIC_NUM,0)) month10\n" +
            "		,SUM(DECODE(MONTH,'11',CLINIC_NUM,0)) month11\n" +
            "		,SUM(DECODE(MONTH,'12',CLINIC_NUM,0)) month12\n" +
            "		,SUM(DECODE(MONTH,'1',REALNAME_NUM,0)) month_real1\n" +
            "		,SUM(DECODE(MONTH,'2',REALNAME_NUM,0)) month_real2\n" +
            "		,SUM(DECODE(MONTH,'3',REALNAME_NUM,0)) month_real3\n" +
            "		,SUM(DECODE(MONTH,'4',REALNAME_NUM,0)) month_real4\n" +
            "		,SUM(DECODE(MONTH,'5',REALNAME_NUM,0)) month_real5\n" +
            "		,SUM(DECODE(MONTH,'6',REALNAME_NUM,0)) month_real6\n" +
            "		,SUM(DECODE(MONTH,'7',REALNAME_NUM,0)) month_real7\n" +
            "		,SUM(DECODE(MONTH,'8',REALNAME_NUM,0)) month_real8\n" +
            "		,SUM(DECODE(MONTH,'9',REALNAME_NUM,0)) month_real9\n" +
            "		,SUM(DECODE(MONTH,'10',REALNAME_NUM,0)) month_real10\n" +
            "		,SUM(DECODE(MONTH,'11',REALNAME_NUM,0)) month_real11\n" +
            "		,SUM(DECODE(MONTH,'12',REALNAME_NUM,0)) month_real12\n" +
            "	FROM RD_REALNAME_CLINIC\n" +
            "	%1$s\n";

    private String RANKING_SQL = "SELECT %1$s, \n" +
            "   DECODE(CLINIC_NUM,0,0,ROUND(REALNAME_NUM/CLINIC_NUM,4)*100) REALNAME_RATE \n" +
            "   FROM( \n" +
            "       SELECT \n" +
            "	        %1$s, SUM(CLINIC_NUM) CLINIC_NUM, SUM(REALNAME_NUM) REALNAME_NUM\n" +
            "       FROM RD_REALNAME_CLINIC\n" +
            "       %2$s\n" +
            "       GROUP BY %1$s\n" +
            "   )\n" +
            "   ORDER BY REALNAME_RATE ASC";

    private String REALNAME_COMPOSE_SQL = "SELECT\n" +
            "	SUM(CLINIC_NUM) CLINIC_NUM\n" +
            "	,SUM(REALNAME_NUM) REALNAME_NUM\n" +
            "FROM RD_REALNAME_CLINIC\n" +
            "%1$s\n" ;

    @Override
    public List<Map<String, Object>> getOrganSummary(Criteria ca) {
        StringBuilder whereSql = new StringBuilder();
        SqlBuilder.buildWhereStatement(OutpatientInfo.class, whereSql, ca) ;
        String sql = String.format(ORGAN_SUMMARY_SQL,whereSql.toString());
        return this.getMapList(sql,ca);
    }

    @Override
    public Map<String, Object> getMonthTrendMap(Criteria ca) {
        Map<String,Object> result = null;
        StringBuilder sql = new StringBuilder(TREND_YEAR_SQL);
        StringBuilder sqlWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(RdRealnameClinic.class, sqlWhere, ca);
        String lastsql = String.format(sql.toString(),sqlWhere.toString());
        List<Map<String,Object>> maplist = this.getMapList(lastsql,ca);
        if(ObjectUtil.isNotEmpty(maplist)){
            result = maplist.get(0);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getRankingMapList(Criteria ca) {
        StringBuilder reportWhere = new StringBuilder();
        String groupField = getGroupField(ca);
        SqlBuilder.buildWhereStatement(RdRealnameClinic.class, reportWhere, ca);
        String sql = String.format(RANKING_SQL,groupField,reportWhere.toString());
        return this.getMapList(sql,ca);
    }

    @Override
    public Map<String, Object> getRealnameComposeMap(Criteria ca) {
        Map<String,Object> result = new HashMap<String,Object>();
        StringBuilder sql = new StringBuilder(REALNAME_COMPOSE_SQL);
        StringBuilder sqlWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(BirthCertificate.class, sqlWhere, ca);
        String lastsql = String.format(sql.toString(),sqlWhere.toString());
        List<Map<String,Object>> maplist = this.getMapList(lastsql,ca);
        if(ObjectUtil.isNotEmpty(maplist)){
            result = maplist.get(0);
        }
        return result;
    }

    private String getGroupField(Criteria ca ){
        String result = "ORGAN_CODE";
        Object genreCode = ca.get("GENRE_CODE");
        //按镇
        if("0".equals(genreCode)){
            result = "GB_CODE";
            ca.remove("GENRE_CODE");
        }
        if(OrgGenreCode.CENTRE.getValue().equals(genreCode)){
            result = "ORGAN_CODE";
        }
        if(OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){
            result = "ORGAN_CODE";
        }
        return result;
    }
}