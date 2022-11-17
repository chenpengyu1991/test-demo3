package com.founder.rhip.ehr.repository.finance;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceDetails;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of SrScientificResearch
 * 
 */
@Repository("pubFinanceDetailsDao")
public class FcPubFinanceDetailsDaoImpl extends AbstractDao<FcPubFinanceDetails, Long> implements IFcPubFinanceDetailsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void save(FcPubFinanceDetails fcPubFinanceDetails){

    }

    public PageList<FcPubFinanceDetails> getPageListBySql(Page page, String sql, Criteria criteria){
        return getPageList(page, sql, criteria);
    }
}