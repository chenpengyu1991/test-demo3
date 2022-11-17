package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.RemindStatistics;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-9.
 */
@Repository("remindStatisticsCountDao")
public class RemindStatisticsCountDaoImpl extends AbstractDao<RemindStatistics, Integer> implements IRemindStatisticsCountDao {
    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    @Resource
    private IDictionaryApp dictionaryApp;

    @Override
    public List<DicItem> getRemindList() {
        List<DicItem> remindList = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990016"));
        return remindList;
    }

    @Override
    public List<Map<String, Object>> getRemindStatisticsMapList(Criteria criteria) {

        List<DicItem> remindList = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990016"));
        StringBuilder sql_all = new StringBuilder();
        if(!("0").equals(criteria.get("GENRE_CODE").toString())){
            sql_all.append("  select  " );
            if(remindList!=null && !("").equals(remindList)){
                for(int i=1;i<=remindList.size();i++){
                    sql_all.append(" nvl(sum(count"+i+"),0) as count"+i+",");
                }
            }
            sql_all.append("  decode(grouping_id(organName), 1, '合计', organName) organName" );
            sql_all.append("  from (SELECT VMO.ORGAN_CODE AS organCode ,VMO.ORGAN_NAME as organName," );
           // sql_all.append("  VMO.GENRE_CODE,VMO.PARENT_CODE,VMO.GB_CODE, " );

            if(remindList!=null && !("").equals(remindList)){
                for(int i=1;i<=remindList.size();i++){
                    sql_all.append(" nvl(sum(VPRS.count"+i+"),0) as count"+i+",");
                }
            }
            sql_all.append("  VMO.GENRE_CODE,VMO.PARENT_CODE,VMO.GB_CODE " );
           /* sql_all.append("  nvl(sum(VPRS.count1),0) as count1,nvl(sum(VPRS.count2),0) as count2,nvl(sum(VPRS.count3),0) as count3,nvl(sum(VPRS.count4),0) as count4,");
            sql_all.append("  nvl(sum(VPRS.count5),0) as count5,nvl(sum(VPRS.count6),0) as count6 ");
           */
            sql_all.append("  FROM (SELECT * FROM  mdm_organization");
            if(criteria!=null && criteria.get("GENRE_CODE")!=null){
                sql_all.append("  WHERE  ");
                if(criteria.get("GENRE_CODE")!=null && criteria.get("GENRE_CODE")!=""){
                    sql_all.append("  GENRE_CODE ='" +criteria.get("GENRE_CODE")+"'");
                }
                if(("B1").equals(criteria.get("GENRE_CODE")) || ("A100").equals(criteria.get("GENRE_CODE"))){
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
            sql_all.append("  )VMO ");
            sql_all.append("  LEFT JOIN (select  ");
            if(remindList!=null && !("").equals(remindList)){
                for(int i=0;i<remindList.size();i++){
                    sql_all.append(" (case rs.category_type when '" +remindList.get(i).getItemCode()+ "' then count(rs.category_type) else 0 end) as count"+remindList.get(i).getItemCode()+",");
                }
            }
            sql_all.append("  rs.category_type,RS.organ_code");
            sql_all.append("  from V_PCBM_REMIND_STATISTICS rs");
            sql_all.append("  where rs.category_type is not null");
            if(criteria!=null && criteria.get("beginDate")!=null &&  criteria.get("endDate")!=null){
                sql_all.append("   AND  TO_CHAR(RS.create_date,'YYYY/MM/dd') BETWEEN  '"+criteria.get("beginDate")+"' AND  '"+criteria.get("endDate")+"'");
            }
            sql_all.append("  group by rs.category_type ,RS.organ_code) VPRS ");

            sql_all.append("  ON  VMO.ORGAN_CODE IS NOT NULL " );

            sql_all.append("  AND VMO.ORGAN_CODE=VPRS.organ_code");

            sql_all.append("  group by VMO.ORGAN_CODE, VMO.ORGAN_NAME,  VMO.GENRE_CODE,VMO.PARENT_CODE,VMO.GB_CODE) ");
            sql_all.append("  group by ROLLUP(organName)" );
        }else{
            sql_all.append("  select  " );
            if(remindList!=null && !("").equals(remindList)){
                for(int i=1;i<=remindList.size();i++){
                    sql_all.append(" nvl(sum(count"+i+"),0) as count"+i+",");
                }
            }
            sql_all.append("  decode(grouping_id(organName), 1, '合计', organName) organName" );
            sql_all.append("  from (SELECT VMT.GB_CODE," );
          /*  sql_all.append("  VMT.GB_NAME AS organName, " );*/
            if(remindList!=null && !("").equals(remindList)){
                for(int i=1;i<=remindList.size();i++){
                    sql_all.append(" nvl(sum(VPRS.count"+i+"),0) as count"+i+",");
                }
            }
            sql_all.append("  VMT.GB_NAME AS organName" );
           /* sql_all.append("   nvl(sum(VPRS.count1), 0) as count1,nvl(sum(VPRS.count2), 0) as count2,nvl(sum(VPRS.count3), 0) as count3," );
            sql_all.append("   nvl(sum(VPRS.count4), 0) as count4,nvl(sum(VPRS.count5), 0) as count5, nvl(sum(VPRS.count6), 0) as count6" );*/
            sql_all.append("   FROM (SELECT * FROM  V_MDM_TOWN  " );
            if(criteria!=null && criteria.get("GB_CODE")!=null){
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!=""){
                    sql_all.append("  WHERE  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
            }
            sql_all.append("   )VMT " );
            sql_all.append("   LEFT JOIN (select  " );
            if(remindList!=null && !("").equals(remindList)){
                for(int i=0;i<remindList.size();i++){
                    sql_all.append(" (case rs.category_type when '" +remindList.get(i).getItemCode()+ "' then count(rs.category_type) else 0 end) as count"+remindList.get(i).getItemCode()+",");
                }
            }
            sql_all.append("  rs.category_type,RS.organ_code,VO.GB_CODE");
            sql_all.append("  from V_PCBM_REMIND_STATISTICS rs,mdm_organization VO");
            sql_all.append("  where rs.organ_code=VO.ORGAN_CODE and  rs.category_type is not null");
            if(criteria!=null && criteria.get("beginDate")!=null &&  criteria.get("endDate")!=null){
                sql_all.append("   AND  TO_CHAR(RS.create_date,'YYYY/MM/dd') BETWEEN  '"+criteria.get("beginDate")+"' AND  '"+criteria.get("endDate")+"'");
            }
            sql_all.append("  group by rs.category_type ,RS.organ_code,VO.GB_CODE) VPRS ");
            sql_all.append("   ON   VMT.GB_CODE = VPRS.GB_CODE" );
            sql_all.append("   group by VMT.GB_CODE,VMT.GB_NAME)" );
            sql_all.append("   group by ROLLUP(organName)" );
        }

       /* sql_all.append(" select count(*) as count,rs.category_type  as categoryType");
        sql_all.append(" from  REMIND_STATISTICS   rs " );
        SqlBuilder.buildWhereStatement(RemindStatistics.class, sql_all, criteria) ;
        if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {
            sql_all.append(" WHERE ");
        }else{
            sql_all.append(" AND ");
        }
        sql_all.append("    rs.category_type is not null " );
        sql_all.append("    group by rs.category_type " );*/
        Criteria c=new Criteria();
        List<Map<String, Object>> listMap=this.getMapList(sql_all.toString(),c);
        return listMap;
    }

    @Override
    public List<Map<String, Object>> getOutOrgReStatisticsMapList(Criteria criteria) {
        StringBuilder sql_all = new StringBuilder();
        sql_all.append("  select  nvl(vs.countNum, 0) as countNum,vps.category_type  as ctype from " );
        sql_all.append("  (select nvl(COUNT(VPRS.category_type), 0) as countNum, " );
        sql_all.append("  VPRS.category_type  " );
        sql_all.append("  from REMIND_STATISTICS VPRS" );
        sql_all.append("  WHERE 1=1 " );
        if(criteria!=null && criteria.get("beginDate")!=null &&  criteria.get("endDate")!=null){
            sql_all.append("   AND  TO_CHAR(VPRS.create_date,'YYYY/MM/dd') BETWEEN  '"+criteria.get("beginDate")+"' AND  '"+criteria.get("endDate")+"'");
        }
        sql_all.append("  GROUP BY category_type)vs " );
        sql_all.append("  right join " );
        sql_all.append("  (select distinct category_type  from  REMIND_STATISTICS ) vps" );
        sql_all.append("  on vps.category_type = vs.category_type " );
        Criteria c=new Criteria();
        List<Map<String, Object>> listMap=this.getMapList(sql_all.toString(),c);
        return listMap;
    }
}
