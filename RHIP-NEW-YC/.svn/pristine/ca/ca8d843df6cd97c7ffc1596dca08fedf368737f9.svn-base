package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-11.
 */
@Repository("heRecReadStatisticsDao")
public class HeRecReadStatisticsDaoImpl extends AbstractDao<ReadHealthRecord, Long> implements IHeRecReadStatisticsDao{
    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<Map<String, Object>> getHeRecReadStatistics(Map<String, String> paramMap) {
        Criteria   criteria=new Criteria();
        criteria.add("GENRE_CODE",paramMap.get("genreCode"));
        criteria.add("ORGAN_CODE",paramMap.get("organCode"));
        criteria.add("PARENT_CODE",paramMap.get("superOrganCode"));
        criteria.add("GB_CODE",paramMap.get("gbCode"));
        criteria.add("beginDate",paramMap.get("beginDate"));
        criteria.add("endDate",paramMap.get("endDate"));

        StringBuilder sql_all = new StringBuilder();

        if(criteria!=null && criteria.get("GENRE_CODE")!=null && ("0").equals(criteria.get("GENRE_CODE"))){
            sql_all.append("   select decode(grouping_id(organName), 1, '合计', organName) organName,  sum(countN) as countNum ");
            sql_all.append("   FROM (SELECT VMO.*,nvl(sum(VRHR.countNum), 0) as countN ");
            sql_all.append("   FROM  (SELECT  GB_CODE as organCode,GB_NAME AS organName  FROM V_MDM_TOWN  ");

            if(criteria!=null && criteria.get("GB_CODE")!=null){
                sql_all.append("  WHERE  ");
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!=""){
                    sql_all.append("  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
            }
            sql_all.append("   )VMO");
            sql_all.append("   LEFT JOIN (select COUNT(VO.GB_CODE) AS countNum,   VO.GB_CODE");
            sql_all.append("   from sy_ms_read_health_record RHR,MDM_ORGANIZATION VO ");
            sql_all.append("   WHERE  VO.ORGAN_CODE=RHR.READER_ORGANCODE and VO.PARENT_CODE IS not NULL AND VO.GB_CODE IS not NULL AND VO.STATUS=1");
                   //  TO_CHAR(RHR.READ_DATE,'YYYY-MM-dd') BETWEEN '2014-06-22' AND '2015-03-31'
            if(criteria!=null && criteria.get("beginDate")!=null &&  criteria.get("endDate")!=null){
                    sql_all.append("  AND TO_CHAR(RHR.READ_DATE,'YYYY/MM/dd') BETWEEN  '"+criteria.get("beginDate")+"' AND  '"+criteria.get("endDate")+"'");
            }
            sql_all.append("   group by VO.GB_CODE  ) VRHR ");
            sql_all.append("   ON VMO.organCode = VRHR.GB_CODE   group by VMO.organCode,VMO.organName) ");
            sql_all.append("   group by ROLLUP(organName) ");
        } else{
            sql_all.append("  select decode(grouping_id(organCode), 1, 'grouping', organCode) organCode,sum(countN) as countNum  ");
            sql_all.append("  FROM (SELECT VMO.*,nvl(sum(VRHR.countNum), 0) as countN ");
            sql_all.append("  FROM  (SELECT ORGAN_CODE as organCode,ORGAN_NAME as organName, GENRE_CODE, PARENT_CODE, GB_CODE ");
            sql_all.append("  FROM MDM_ORGANIZATION  ");
            if(criteria!=null && criteria.get("GENRE_CODE")!=null){
                sql_all.append("  WHERE  ");
                if(criteria.get("GENRE_CODE")!=null && criteria.get("GENRE_CODE")!=""){
                    sql_all.append("  GENRE_CODE ='" +criteria.get("GENRE_CODE")+"'");
                }
            if(("B100").equals(criteria.get("GENRE_CODE")) || ("A100").equals(criteria.get("GENRE_CODE"))){
                if(criteria.get("PARENT_CODE")!=null && criteria.get("PARENT_CODE")!="" && criteria.get("GENRE_CODE")!=null){
                    sql_all.append(" AND  ORGAN_CODE ='" +criteria.get("PARENT_CODE")+"'");
                }
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!="" && criteria.get("GENRE_CODE")!=null && criteria.get("PARENT_CODE")!=null ){
                    sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
            }else{
                if(criteria.get("PARENT_CODE")!=null && criteria.get("PARENT_CODE")!="" && criteria.get("GENRE_CODE")!=null){
                    sql_all.append(" AND  PARENT_CODE ='" +criteria.get("PARENT_CODE")+"'");
                }
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!="" && criteria.get("GENRE_CODE")!=null && criteria.get("PARENT_CODE")!=null ){
                    sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
                if(criteria.get("ORGAN_CODE")!="" && criteria.get("ORGAN_CODE")!=null && criteria.get("GB_CODE")!=null && criteria.get("PARENT_CODE")!=null && criteria.get("GENRE_CODE")!=null ){
                    sql_all.append(" AND  ORGAN_CODE ='" +criteria.get("ORGAN_CODE")+"'");
                }
            }
        }
                    sql_all.append("   )VMO ");
                    sql_all.append("   LEFT JOIN (select COUNT(RHR.READER_ORGANCODE) AS countNum,  RHR.READER_ORGANCODE ");
                    sql_all.append("   from sy_ms_read_health_record RHR ");
                if(criteria!=null && criteria.get("beginDate")!=null &&  criteria.get("endDate")!=null){
                    sql_all.append("   WHERE  TO_CHAR(RHR.READ_DATE,'YYYY/MM/dd') BETWEEN  '"+criteria.get("beginDate")+"' AND  '"+criteria.get("endDate")+"'");
                }
                    sql_all.append("   group by RHR.READER_ORGANCODE) VRHR ");
                    sql_all.append("   ON VMO.organCode = VRHR.READER_ORGANCODE ");
                    sql_all.append("   group by VMO.organCode,VMO.organName,VMO.GENRE_CODE,VMO.PARENT_CODE,VMO.GB_CODE)");
                    sql_all.append("   group by ROLLUP(organCode) ");
                }
                Criteria   ca=new Criteria();
                List<Map<String, Object>> listMap=this.getMapList(sql_all.toString(),ca);
                return listMap;
    }
}
