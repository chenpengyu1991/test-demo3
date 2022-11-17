package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ReportRecord
 * 
 */
@Repository("reportRecordDao")
public class ReportRecordDaoImpl extends AbstractDao<ReportRecord, Long> implements IReportRecordDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageList<ReportRecord> getPageReportRecord(Page page, Criteria criteria, String order){

        StringBuilder sql_all = new StringBuilder();
        sql_all.append(" SELECT * ");
        sql_all.append(" FROM CDM_REPORT_RECORD " );
        SqlBuilder.buildWhereStatement(ReportRecord.class, sql_all, criteria) ;
        if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {
            sql_all.append(" WHERE ");
        }else{
            sql_all.append(" AND ");
        }
        sql_all.append(" ((type=1 and status=1) or (status <> 3  and status <> 9)) ");
        SqlBuilder.buildOrderStatement(sql_all, order);
        return this.getPageList(page, sql_all.toString(), criteria);
    }
}