package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-4.
 */
@Repository("cardMonitoringDao")
public class CardMonitoringDaoImpl  extends AbstractDao<ReportRecord, Long> implements ICardMonitoringDao{
    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<Map<String, Object>> getCountReportMapList(Criteria criteria) {
        StringBuilder sql_all = new StringBuilder();
        String startDate=null;
        String endDate=null;
        if(!("100").equals(criteria.get("statisticsDate")) && criteria.get("statisticsDate")!=null && criteria!=null && criteria.get("beginDate")==null){
            Date[] dateRange=(Date[])criteria.get("statisticsDate");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            startDate=formatter.format(dateRange[0]);
            endDate=formatter.format(dateRange[1]);
        }
        if(criteria.get("beginDate")!=null && criteria.get("endDate")!=null){

            startDate=criteria.get("beginDate").toString();
            endDate=criteria.get("endDate").toString();
        }
        if(criteria!=null && criteria.get("GENRE_CODE")!=null && !("0").equals(criteria.get("GENRE_CODE"))){
            sql_all.append("  select decode(grouping_id(organCode), 1, 'grouping', organCode) organCode,");
            sql_all.append("  sum(COUNTSa) as countNuma,  sum(COUNTSa1) as countNuma1,  sum(COUNTSa2) as countNuma2,");
            sql_all.append("  sum(COUNTSB) as countNumb,  sum(COUNTSb1) as countNumb1,  sum(COUNTSb2) as countNumb2,");
            sql_all.append("  sum(COUNTSb3) as countNumb3, sum(COUNTSb9) as countNumb9, ");
            sql_all.append("  sum(COUNTSC) as countNumc,  sum(COUNTSc1) as countNumc1,  sum(COUNTSc2) as countNumc2 ");
            sql_all.append("  FROM (");
        sql_all.append("  SELECT VMO.ORGAN_CODE  as organCode,");
        sql_all.append("  nvl(SUM(VPRR.countsa), 0) as COUNTSa, nvl(SUM(VPRR.countsa1), 0) as COUNTSa1,nvl(SUM(VPRR.countsa2), 0) as COUNTSa2,");
        sql_all.append("  nvl(SUM(VPRR.countsb), 0) as COUNTSB, nvl(SUM(VPRR.countsb1), 0) as COUNTSb1, nvl(SUM(VPRR.countsb2), 0) as COUNTSb2,");
        sql_all.append("  nvl(SUM(VPRR.countsb3), 0) as COUNTSb3, nvl(SUM(VPRR.countsb9), 0) as COUNTSb9,");
        sql_all.append("  nvl(SUM(VPRR.countSC), 0) as COUNTSC, nvl(SUM(VPRR.countsc1), 0) as COUNTSc1,nvl(SUM(VPRR.countsc2), 0) as COUNTSc2");
        sql_all.append("  FROM  (SELECT * from V_MDM_ORGANIZATION  ");
            if(criteria!=null && criteria.get("GENRE_CODE")!=null){
                sql_all.append("  WHERE  ");
                if(criteria.get("GENRE_CODE")!=null && criteria.get("GENRE_CODE")!=""){
                    sql_all.append("  GENRE_CODE ='" +criteria.get("GENRE_CODE")+"'");
                }
                
                if (("A100".equals(criteria.get("GENRE_CODE")) || "B100".equals(criteria.get("GENRE_CODE")) || "B200".equals(criteria.get("GENRE_CODE"))) 
                		&& ObjectUtil.isNotEmpty(criteria.get("ORGAN_CODE"))) {
                	sql_all.append(" AND  ORGAN_CODE ='" + criteria.get("ORGAN_CODE")+"'");
                }
                if ("B100".equals(criteria.get("GENRE_CODE")) && ObjectUtil.isNullOrEmpty(criteria.get("ORGAN_CODE")) && ObjectUtil.isNotEmpty(criteria.get("GB_CODE"))) {
                	sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
				}
                if ("B200".equals(criteria.get("GENRE_CODE")) && ObjectUtil.isNullOrEmpty(criteria.get("ORGAN_CODE")) && ObjectUtil.isNotEmpty(criteria.get("PARENT_CODE"))) {
                	sql_all.append(" AND  PARENT_CODE ='" +criteria.get("PARENT_CODE")+"'");
				}
                if ("B200".equals(criteria.get("GENRE_CODE")) && ObjectUtil.isNullOrEmpty(criteria.get("ORGAN_CODE")) && ObjectUtil.isNotEmpty(criteria.get("GB_CODE"))) {
                	sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
				} else {
                   
                    if(ObjectUtil.isNotEmpty(criteria.get("GB_CODE"))){
                        sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                    }
                    
                }
            }
        sql_all.append("   )VMO ");
        sql_all.append("  LEFT JOIN");
        sql_all.append("  (select");
        sql_all.append("  (case RR.TYPE  when 1 then  count(RR.TYPE) ELSE  0  end) as COUNTSA,");
        sql_all.append("  (case when  RR.TYPE=1 and  RR.STATUS=1 then  count(RR.TYPE) ELSE  0  end) as countsa1,");
        sql_all.append("  (case when  RR.TYPE=1 and  RR.STATUS=2 then  count(RR.TYPE) ELSE  0  end) as countsa2,");
        sql_all.append("  (case RR.TYPE  when 2 then  count(RR.TYPE) ELSE  0  end) as countsb,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=1 then  count(RR.TYPE) ELSE  0  end) as countsb1,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=2 then  count(RR.TYPE) ELSE  0  end) as countsb2,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=4 then  count(RR.TYPE) ELSE  0  end) as countsb3,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=9 then  count(RR.TYPE) ELSE  0  end) as countsb9,");
        sql_all.append("  (case RR.TYPE  when 3 then  count(RR.TYPE) ELSE  0  end) as countsc,");
        sql_all.append("  (case when  RR.TYPE=3 and  RR.STATUS=1 then  count(RR.TYPE) ELSE  0  end) as countsc1,");
        sql_all.append("  (case when  RR.TYPE=3 and  RR.STATUS=2 then  count(RR.TYPE) ELSE  0  end) as countsc2,");
        sql_all.append("  rr.type,rr.status,RR.FILL_ORGAN_CODE");
        sql_all.append("  from CDM_REPORT_RECORD RR");
        sql_all.append("  WHERE  ((type=1 and status=1) or (status <> 3  and status <> 9))");
       /*     if(startDate!=null && endDate!=null){
                sql_all.append("  AND TO_CHAR(CREATE_DATE,'yyyy/MM/dd') BETWEEN  TO_CHAR("+startDate+",'yyyy/MM/dd')  AND TO_CHAR("+endDate+",'yyyy/MM/dd')");
            }*/
            if(startDate!=null && endDate!=null){
                sql_all.append("  AND TO_CHAR(CREATE_DATE,'yyyy/MM/dd') BETWEEN '"+startDate +"'AND '"+endDate+"'");
            }
        sql_all.append("  group by rr.type, rr.status,RR.FILL_ORGAN_CODE) VPRR");
        sql_all.append("  ON VPRR.FILL_ORGAN_CODE=VMO.ORGAN_CODE");
        sql_all.append("  GROUP BY VMO.ORGAN_CODE)" );
        sql_all.append("  group by ROLLUP(organCode) " );

        }else{

        sql_all.append("  select decode(grouping_id(organName), 1, '合计', organName) organName,");
        sql_all.append("  sum(COUNTSa) as countNuma,  sum(COUNTSa1) as countNuma1,  sum(COUNTSa2) as countNuma2,");
        sql_all.append("  sum(COUNTSB) as countNumb,  sum(COUNTSb1) as countNumb1,  sum(COUNTSb2) as countNumb2,");
        sql_all.append("  sum(COUNTSb3) as countNumb3, sum(COUNTSb9) as countNumb9,");
        sql_all.append("   sum(COUNTSC) as countNumc,  sum(COUNTSc1) as countNumc1,  sum(COUNTSc2) as countNumc2");
        sql_all.append("   FROM (");
        sql_all.append("  SELECT VMT.GB_CODE as organCode, VMT.GB_NAME AS organName,");
        sql_all.append("  nvl(SUM(VPRR.countsa), 0) as COUNTSa, nvl(SUM(VPRR.countsa1), 0) as COUNTSa1,  nvl(SUM(VPRR.countsa2), 0) as COUNTSa2,");
        sql_all.append("  nvl(SUM(VPRR.countsb), 0) as COUNTSB,  nvl(SUM(VPRR.countsb1), 0) as COUNTSb1,  nvl(SUM(VPRR.countsb2), 0) as COUNTSb2,");
        sql_all.append("  nvl(SUM(VPRR.countsb3), 0) as COUNTSb3, nvl(SUM(VPRR.countsb9), 0) as COUNTSb9,");
        sql_all.append("  nvl(SUM(VPRR.countSC), 0) as COUNTSC,nvl(SUM(VPRR.countsc1), 0) as COUNTSc1,");
        sql_all.append("  nvl(SUM(VPRR.countsc2), 0) as COUNTSc2");
        sql_all.append("  FROM  (SELECT * FROM V_MDM_TOWN ");
            if(criteria!=null && criteria.get("GB_CODE")!=null){
                sql_all.append("  WHERE  ");
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!=""){
                    sql_all.append("  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
            }
        sql_all.append("  )VMT");
        sql_all.append("  LEFT JOIN");
        sql_all.append("  (select");
        sql_all.append("  (case RR.TYPE  when 1 then  count(RR.TYPE) ELSE  0  end) as COUNTSA,");
        sql_all.append("  (case when  RR.TYPE=1 and  RR.STATUS=1 then  count(RR.TYPE) ELSE  0  end) as countsa1,");
        sql_all.append("  (case when  RR.TYPE=1 and  RR.STATUS=2 then  count(RR.TYPE) ELSE  0  end) as countsa2,");
        sql_all.append("  (case RR.TYPE  when 2 then  count(RR.TYPE) ELSE  0  end) as countsb,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=1 then  count(RR.TYPE) ELSE  0  end) as countsb1,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=2 then  count(RR.TYPE) ELSE  0  end) as countsb2,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=4 then  count(RR.TYPE) ELSE  0  end) as countsb3,");
        sql_all.append("  (case when  RR.TYPE=2 and  RR.STATUS=9 then  count(RR.TYPE) ELSE  0  end) as countsb9,");
        sql_all.append("  (case RR.TYPE  when 3 then  count(RR.TYPE) ELSE  0  end) as countsc,");
        sql_all.append("  (case when  RR.TYPE=3 and  RR.STATUS=1 then  count(RR.TYPE) ELSE  0  end) as countsc1,");
        sql_all.append("  (case when  RR.TYPE=3 and  RR.STATUS=2 then  count(RR.TYPE) ELSE  0  end) as countsc2,");
        sql_all.append("  rr.type,rr.status,RR.FILL_ORGAN_CODE,VO.GB_CODE");
        sql_all.append("  from CDM_REPORT_RECORD RR, V_MDM_ORGANIZATION VO WHERE RR.FILL_ORGAN_CODE=VO.ORGAN_CODE");
        sql_all.append("  AND ((RR.type=1 and RR.status=1) or (RR.status <> 3  and RR.status <> 9))");
            if(startDate!=null && endDate!=null){
                sql_all.append("  AND TO_CHAR(CREATE_DATE,'yyyy/MM/dd') BETWEEN '"+startDate +"'AND '"+endDate+"'");
            }
        sql_all.append("  group by rr.type, rr.status,RR.FILL_ORGAN_CODE,VO.GB_CODE) VPRR");
        sql_all.append("  ON VPRR.GB_CODE=VMT.GB_CODE");
        sql_all.append("  GROUP BY VMT.GB_CODE,VMT.GB_NAME) ");
        sql_all.append("  group by ROLLUP(organName)");
        }
        Criteria   ca=new Criteria();
        List<Map<String, Object>> listMap=this.getMapList(sql_all.toString(),ca);
        return listMap;
    }
}
