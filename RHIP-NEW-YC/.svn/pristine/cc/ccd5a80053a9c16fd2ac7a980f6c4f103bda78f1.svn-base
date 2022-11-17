package com.founder.rhip.ehr.repository.ihm;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ihm.InhosTargetReport;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of IhmInhosTargetReport
 * 
 */
@Repository("inhosTargetReportDao")
public class InhosTargetReportDaoImpl extends AbstractDao<InhosTargetReport, Long> implements IInhosTargetReportDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String MD_SQL = " SELECT target.*"
            + " ,ROUND(DECODE(target.CASE_NUM,0,0,NVL(target.SUM_DAY,0)/target.CASE_NUM),4) sumDayAvg"//日:平均住院日
            + " ,ROUND(DECODE(target.CASE_NUM_1,0,0,NVL(target.SUM_DAY_1,0)/target.CASE_NUM_1),4) sumDayAvg1"//日:平均住院日1
            + " ,ROUND(DECODE(target.CASE_NUM_2,0,0,NVL(target.SUM_DAY_2,0)/target.CASE_NUM_2),4) sumDayAvg2"//日:平均住院日2
            + " ,ROUND(DECODE(target.CASE_NUM_3,0,0,NVL(target.SUM_DAY_3,0)/target.CASE_NUM_3),4) sumDayAvg3"//日:平均住院日3
            + " ,ROUND(DECODE(target.CASE_NUM_4,0,0,NVL(target.SUM_DAY_4,0)/target.CASE_NUM_4),4) sumDayAvg4"//日:平均住院日4
            + " ,ROUND(DECODE(target.CASE_NUM,0,0,NVL(target.SUM_FEE,0)/target.CASE_NUM),4) sumFeeAvg"//均费:平均住院费
            + " ,ROUND(DECODE(target.CASE_NUM_1,0,0,NVL(target.SUM_FEE_1,0)/target.CASE_NUM_1),4) sumFeeAvg1"//均费:平均住院费1
            + " ,ROUND(DECODE(target.CASE_NUM_2,0,0,NVL(target.SUM_FEE_2,0)/target.CASE_NUM_2),4) sumFeeAvg2"//均费:平均住院费2
            + " ,ROUND(DECODE(target.CASE_NUM_3,0,0,NVL(target.SUM_FEE_3,0)/target.CASE_NUM_3),4) sumFeeAvg3"//均费:平均住院费3
            + " ,ROUND(DECODE(target.CASE_NUM_4,0,0,NVL(target.SUM_FEE_4,0)/target.CASE_NUM_4),4) sumFeeAvg4"//均费:平均住院费4
            + " FROM("
            + " SELECT DISEASE_TYPE"
            + "     ,SUM(CASE_NUM) CASE_NUM"//病例数
            + "     ,SUM(DECODE(QUARTER_NUM,1,CASE_NUM,0)) CASE_NUM_1"//病例数1
            + "     ,SUM(DECODE(QUARTER_NUM,2,CASE_NUM,0)) CASE_NUM_2"//病例数2
            + "     ,SUM(DECODE(QUARTER_NUM,3,CASE_NUM,0)) CASE_NUM_3"//病例数3
            + "     ,SUM(DECODE(QUARTER_NUM,4,CASE_NUM,0)) CASE_NUM_4"//病例数4
            + "     ,SUM(DIE_NUM) DIE_NUM"//死亡数
            + "     ,SUM(DECODE(QUARTER_NUM,1,DIE_NUM,0)) DIE_NUM_1"//死亡数1
            + "     ,SUM(DECODE(QUARTER_NUM,2,DIE_NUM,0)) DIE_NUM_2"//死亡数2
            + "     ,SUM(DECODE(QUARTER_NUM,3,DIE_NUM,0)) DIE_NUM_3"//死亡数3
            + "     ,SUM(DECODE(QUARTER_NUM,4,DIE_NUM,0)) DIE_NUM_4"//死亡数4
            + "     ,SUM(FIFTEEN_RATE) FIFTEEN_RATE"//15日内再住院率
            + "     ,SUM(DECODE(QUARTER_NUM,1,FIFTEEN_RATE,0)) FIFTEEN_RATE_1"//15日内再住院率1
            + "     ,SUM(DECODE(QUARTER_NUM,2,FIFTEEN_RATE,0)) FIFTEEN_RATE_2"//15日内再住院率2
            + "     ,SUM(DECODE(QUARTER_NUM,3,FIFTEEN_RATE,0)) FIFTEEN_RATE_3"//15日内再住院率3
            + "     ,SUM(DECODE(QUARTER_NUM,4,FIFTEEN_RATE,0)) FIFTEEN_RATE_4"//15日内再住院率4
            + "     ,SUM(THIRTYONE_RATE) THIRTYONE_RATE"//31日内再住院率
            + "     ,SUM(DECODE(QUARTER_NUM,1,THIRTYONE_RATE,0)) THIRTYONE_RATE_1"//31日内再住院率1
            + "     ,SUM(DECODE(QUARTER_NUM,2,THIRTYONE_RATE,0)) THIRTYONE_RATE_2"//31日内再住院率2
            + "     ,SUM(DECODE(QUARTER_NUM,3,THIRTYONE_RATE,0)) THIRTYONE_RATE_3"//31日内再住院率3
            + "     ,SUM(DECODE(QUARTER_NUM,4,THIRTYONE_RATE,0)) THIRTYONE_RATE_4"//31日内再住院率4
            + "     ,SUM(SUM_DAY) SUM_DAY"//住院日总数
            + "     ,SUM(DECODE(QUARTER_NUM,1,SUM_DAY,0)) SUM_DAY_1"//住院日总数1
            + "     ,SUM(DECODE(QUARTER_NUM,2,SUM_DAY,0)) SUM_DAY_2"//住院日总数2
            + "     ,SUM(DECODE(QUARTER_NUM,3,SUM_DAY,0)) SUM_DAY_3"//住院日总数3
            + "     ,SUM(DECODE(QUARTER_NUM,4,SUM_DAY,0)) SUM_DAY_4"//住院日总数4
            + "     ,SUM(SUM_FEE) SUM_FEE"//住院费用总额
            + "     ,SUM(DECODE(QUARTER_NUM,1,SUM_FEE,0)) SUM_FEE_1"//住院费用总额1
            + "     ,SUM(DECODE(QUARTER_NUM,2,SUM_FEE,0)) SUM_FEE_2"//住院费用总额2
            + "     ,SUM(DECODE(QUARTER_NUM,3,SUM_FEE,0)) SUM_FEE_3"//住院费用总额3
            + "     ,SUM(DECODE(QUARTER_NUM,4,SUM_FEE,0)) SUM_FEE_4"//住院费用总额4
            + " FROM IHM_INHOS_TARGET_REPORT"
            + " %1$s"
            + " GROUP BY DISEASE_TYPE"
            + " ORDER BY DISEASE_TYPE DESC) target";

    private String getMdSql(Integer year,String genreCode,String gbCode,String organCode){
        StringBuilder sql = new StringBuilder(MD_SQL);
        //机构条件
        StringBuilder whereSql =  new StringBuilder(" WHERE ");
        if(ObjectUtil.isNotEmpty(year)){
            whereSql.append(" YEAR_NUM = " + year);
        }
        if(ObjectUtil.isNotEmpty(organCode)){
            whereSql.append(" AND ORGAN_CODE = '" + organCode + "'");
        }
        if(ObjectUtil.isNotEmpty(genreCode) && !"0".equals(genreCode)){
            whereSql.append(" AND GENRE_CODE = '" + genreCode + "'");
        }
        if(ObjectUtil.isNotEmpty(gbCode)){
            whereSql.append(" AND GB_CODE = '" + gbCode + "'");
        }
        return String.format(sql.toString(),whereSql.toString());
    }

    public List<Map<String, Object>> getMdList(Integer year,String genreCode,String gbCode,String organCode){
        String sql = getMdSql(year, genreCode, gbCode, organCode);
        return this.getMapList(sql,new Criteria());
    }
}