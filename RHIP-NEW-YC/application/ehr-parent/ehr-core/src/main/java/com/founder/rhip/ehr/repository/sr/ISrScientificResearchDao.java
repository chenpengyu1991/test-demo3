package com.founder.rhip.ehr.repository.sr;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;


/**
 * DAO interface of SrScientificResearch
 * 
 */
public interface ISrScientificResearchDao extends IDao<SrScientificResearch,Long> {

    public void save(SrScientificResearch srScientificResearch);

    public PageList<SrScientificResearch> getPageListBySql(Page page, String sql, Criteria criteria);

}