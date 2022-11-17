package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.RpStatistics;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wang_zhou on 2015/6/19.
 */
@Repository("rpStatisticsDao")
public class RpStatisticsDaoImpl extends AbstractDao<RpStatistics, Long> implements IRpStatisticsDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    @Override
    public List<Map<String, Object>> getRpMapList(Criteria criteria) {
        String dStr=criteria.get("dateStr").toString();
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append(" select * from rp_statistics  rs where to_char(rs.rp_date,'yyyy/MM/dd')='"+dStr+"'");
        Criteria ca=new Criteria();
        List<Map<String, Object>> listMap=this.getMapList(sqlStr.toString(),ca);
        return listMap;
    }

    @Override
    public List<Map<String, Object>> getRpStatisticsMapList(Criteria criteria){

        StringBuilder sql_all = new StringBuilder();
        sql_all.append("  select decode(grouping_id(organCode), 1, 'grouping', organCode)organCode,");
        sql_all.append("  SUM(treatmentNum) as treatmentNum,SUM(inNum) AS inNum,SUM(studyNum)  AS studyNum,");
        sql_all.append("  SUM(examinationNum) AS examinationNum,");
        sql_all.append("  SUM(inhospitalDay) AS inhospitalDay,SUM(neonatalDeathNum) AS neonatalDeathNum,");
        sql_all.append("  SUM(fiveDeathNum) AS fiveDeathNum,SUM(newBornNum) AS newBornNum,");
        sql_all.append("  SUM(deliveryDeathNum) AS deliveryDeathNum,SUM(deliveryInhospitalNum) AS deliveryInhospitalNum,");
        sql_all.append("  SUM(deliverySystemNum) AS deliverySystemNum,SUM(maternalRegistrationNum) AS maternalRegistrationNum,");
        sql_all.append("  SUM(threeSystemNum) AS threeSystemNum,SUM(threeChildNum) AS threeChildNum,");
        sql_all.append("  SUM(vaccinationNum) AS vaccinationNum,SUM(schoolChildNum) AS schoolChildNum,");
        sql_all.append("  SUM(childNum) AS childNum,");
        sql_all.append("  SUM(hbsagNum)  AS hbsagNum,SUM(hbsagPositiveNum) AS hbsagPositiveNum");
        sql_all.append("  FROM");
        sql_all.append("  (SELECT   SUM(RS.TREATMENT_NUM) as treatmentNum,SUM(RS.IN_NUM) AS inNum ,");
        sql_all.append("  SUM(RS.STUDY_NUM) AS studyNum,SUM(RS.EXAMINATION_NUM) AS examinationNum, ");
        sql_all.append("  SUM(RS.INHOSPITAL_DAY) AS inhospitalDay,SUM(RS.NEONATAL_DEATH_NUM) AS neonatalDeathNum,");
        sql_all.append("  SUM(RS.FIVE_DEATH_NUM) AS fiveDeathNum,SUM(RS.NEWBORN_NUM) newBornNum, ");
        sql_all.append("  SUM(RS.DELIVERY_DEATH_NUM) AS deliveryDeathNum, SUM(RS.DELIVERY_INHOSPITAL_NUM) AS deliveryInhospitalNum, ");
        sql_all.append("  SUM(RS.DELIVERY_SYSTEM_NUM) AS deliverySystemNum, SUM(RS.MATERNAL_REGISTRATION_NUM) AS maternalRegistrationNum,");
        sql_all.append("  SUM(RS.THREE_SYSTEM_NUM) AS threeSystemNum,SUM(RS.THREE_CHILD_NUM) AS threeChildNum, ");
        sql_all.append("  SUM(RS.VACCINATION_NUM) AS vaccinationNum,SUM(RS.SCHOOL_CHILD_NUM) AS schoolChildNum,");
        sql_all.append("  SUM(RS.CHILD_NUM) AS childNum,");

        sql_all.append("  SUM(RS.HBSAG_NUM) AS hbsagNum,SUM(RS.HBSAG_POSITIVE_NUM) AS hbsagPositiveNum, ");
        sql_all.append("  RS.ORGAN_CODE AS organCode  FROM   ");
        sql_all.append("  (SELECT * FROM  RP_STATISTICS  WHERE ORGAN_CODE IS NOT NULL  ");
        if(criteria!=null && criteria.get("GENRE_CODE")!=null){
            sql_all.append("  AND  ");
            if(criteria.get("GENRE_CODE")!=null && criteria.get("GENRE_CODE")!=""){
                sql_all.append("  ORGAN_TYPE ='" +criteria.get("GENRE_CODE")+"'");
            }
            if(("B1").equals(criteria.get("GENRE_CODE")) || ("A1").equals(criteria.get("GENRE_CODE"))){
                if(criteria.get("PARENT_CODE")!=null && criteria.get("PARENT_CODE")!="" && criteria.get("GENRE_CODE")!=null){
                    sql_all.append(" AND  CENTER_CODE ='" +criteria.get("PARENT_CODE")+"'");
                }
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!="" && criteria.get("GENRE_CODE")!=null && criteria.get("PARENT_CODE")!=null ){
                    sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
            }else{
                if(criteria.get("PARENT_CODE")!=null && criteria.get("PARENT_CODE")!="" && criteria.get("GENRE_CODE")!=null){
                    sql_all.append(" AND  CENTER_CODE ='" +criteria.get("PARENT_CODE")+"'");
                }
                if(criteria.get("GB_CODE")!=null && criteria.get("GB_CODE")!="" && criteria.get("GENRE_CODE")!=null && criteria.get("PARENT_CODE")!=null ){
                    sql_all.append(" AND  GB_CODE ='" +criteria.get("GB_CODE")+"'");
                }
                if(criteria.get("ORGAN_CODE")!="" && criteria.get("ORGAN_CODE")!=null && criteria.get("GB_CODE")!=null && criteria.get("PARENT_CODE")!=null && criteria.get("GENRE_CODE")!=null ){
                    sql_all.append(" AND  ORGAN_CODE ='" +criteria.get("ORGAN_CODE")+"'");
                }
            }
        }
        if(criteria!=null && criteria.get("beginDate")!=null &&  criteria.get("endDate")!=null){
            sql_all.append("   AND  TO_CHAR(RP_DATE,'YYYY/MM/dd') BETWEEN  '"+criteria.get("beginDate")+"' AND  '"+criteria.get("endDate")+"'");
        }
        sql_all.append("  ) RS ");
        sql_all.append("  group by  RS.ORGAN_CODE) RPS ");
        sql_all.append("  group by ROLLUP(organCode)");
        Criteria ca=new Criteria();
        List<Map<String, Object>> listMap=this.getMapList(sql_all.toString(),ca);
        return listMap;
    }

    @Override
    public List<Map<String, Object>> getChildMgnt3(Map<String, String> paramMap) {
        String gbCode = paramMap.get("gbCode");
        String beginDate = paramMap.get("beginDate").substring(0,7);
        StringBuilder sql = new StringBuilder("SELECT GB_CODE,\n" +
                "       THREE_SYSTEM_NUM,\n" +
                "       THREE_CHILD_NUM,\n" +
                "       ROUND(THREE_SYSTEM_NUM / DECODE(THREE_CHILD_NUM,0,1,THREE_CHILD_NUM), 4) AS AVG \n" +
                "  FROM RP_STATISTICS" +
                "  WHERE  TO_CHAR(RP_DATE, 'YYYY/MM') = '"+beginDate+"' AND THREE_CHILD_NUM IS NOT NULL ");
        if(StringUtil.isNotEmpty(gbCode)){
            sql.append(" AND GB_CODE = '"+gbCode+"'");
        }
        return getMapList(sql.toString(), new MapSqlParameterSource());
    }

    @Override
    public List<Map<String, Object>> getChildVacc(Map<String, String> paramMap){
        String gbCode = paramMap.get("gbCode");
        String beginDate = paramMap.get("beginDate").substring(0,7);
        StringBuilder sql = new StringBuilder("SELECT DECODE(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE, " +
                " SUM(DECODE(T.VACCINATION_TYPE, '乙肝', T.AVG, NULL)) AS HBV\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '脊灰', T.AVG, NULL)) AS JH\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '百白破', T.AVG, NULL)) AS BBP\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '流脑A', T.AVG, NULL)) AS LNA\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '麻风', T.AVG, NULL)) AS MF\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '乙脑（减毒）', T.AVG, NULL)) AS YNJD\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '麻腮风', T.AVG, NULL)) AS MSF\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '甲肝灭活', T.AVG, NULL)) AS JGMH\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '群流脑A+C', T.AVG, NULL)) AS QLNAC\n" +
                "       ,SUM(DECODE(T.VACCINATION_TYPE, '白破', T.AVG, NULL)) AS BP\n" +
                "FROM(\n" +
                "SELECT GB_CODE, VACCINATION_TYPE,\n" +
                "       PLAN_VACCINATION_NUM,\n" +
                "       VACCINATION_NUM,\n" +
                "       ROUND(DECODE(VACCINATION_NUM,0,0,DECODE(SIGN(PLAN_VACCINATION_NUM-VACCINATION_NUM),1,1,PLAN_VACCINATION_NUM/VACCINATION_NUM)),4) AS AVG\n" +
                 "  FROM RP_STATISTICS\n" +
                " WHERE TO_CHAR(RP_DATE, 'YYYY/MM') = '"+beginDate+"'\n" +
                "   AND VACCINATION_NUM IS NOT NULL and gb_code is not null and gb_code !='总计' \n");
        if(StringUtil.isNotEmpty(gbCode)){
            sql.append(" AND GB_CODE = '"+gbCode+"'");
        }
                sql.append(")T\n" +
                "GROUP BY rollup(T.GB_CODE) order by T.GB_CODE");
//        if(StringUtil.isNotEmpty(gbCode)){
//            sql.append(" AND GB_CODE = '"+gbCode+"'");
//        }
        return getMapList(sql.toString(), new MapSqlParameterSource());
    }



}
