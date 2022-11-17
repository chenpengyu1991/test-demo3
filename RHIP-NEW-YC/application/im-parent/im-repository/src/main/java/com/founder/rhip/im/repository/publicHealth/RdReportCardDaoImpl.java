package com.founder.rhip.im.repository.publicHealth;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.im.entity.publicHealth.RdReportCard;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import java.util.List;
import java.util.Map;

/**
 * DAO implement of RdReportCard
 * 
 */
@Repository("rdReportCardDao")
public class RdReportCardDaoImpl extends AbstractDao<RdReportCard, Long> implements IRdReportCardDao {
    String TREND_SQL = "SELECT BUSINESS_TYPE\n" +
            "        ,SUM(DECODE(MONTH,'1',RECORD_NUMBER,0)) month1\n" +
            "        ,SUM(DECODE(month,'2',RECORD_NUMBER,0)) month2\n" +
            "        ,SUM(DECODE(month,'3',RECORD_NUMBER,0)) month3\n" +
            "        ,SUM(DECODE(month,'4',RECORD_NUMBER,0)) month4\n" +
            "        ,SUM(DECODE(month,'5',RECORD_NUMBER,0)) month5\n" +
            "        ,SUM(DECODE(month,'6',RECORD_NUMBER,0)) month6\n" +
            "        ,SUM(DECODE(month,'7',RECORD_NUMBER,0)) month7\n" +
            "        ,SUM(DECODE(month,'8',RECORD_NUMBER,0)) month8\n" +
            "        ,SUM(DECODE(month,'9',RECORD_NUMBER,0)) month9\n" +
            "        ,SUM(DECODE(month,'10',RECORD_NUMBER,0)) month10\n" +
            "        ,SUM(DECODE(month,'11',RECORD_NUMBER,0)) month11\n" +
            "        ,SUM(DECODE(month,'12',RECORD_NUMBER,0)) month12\n" +
            "        FROM RD_REPORT_CARD" +
            " 	%1$s\n" +//WHERE 条件
            " 	GROUP BY BUSINESS_TYPE\n";

    public List<Map<String, Object>> getReportCardTrendList(Criteria criteria){
        StringBuilder sql = new StringBuilder();
        SqlBuilder.buildWhereStatement(RdReportCard.class,sql,criteria);
        TREND_SQL = String.format(TREND_SQL,sql);
        return this.getMapList(TREND_SQL,criteria);
    }
}