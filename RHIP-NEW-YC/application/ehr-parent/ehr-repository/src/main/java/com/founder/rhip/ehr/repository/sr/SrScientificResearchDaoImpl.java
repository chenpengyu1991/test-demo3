package com.founder.rhip.ehr.repository.sr;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of SrScientificResearch
 * 
 */
@Repository("srScientificResearchDao")
public class SrScientificResearchDaoImpl extends AbstractDao<SrScientificResearch, Long> implements ISrScientificResearchDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void save(SrScientificResearch srScientificResearch){


    }

    public PageList<SrScientificResearch> getPageListBySql(Page page, String sql, Criteria criteria){
        return getPageList(page, sql, criteria);
    }
}