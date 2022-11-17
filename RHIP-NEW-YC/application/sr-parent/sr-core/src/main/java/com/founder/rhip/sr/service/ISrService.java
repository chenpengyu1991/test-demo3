package com.founder.rhip.sr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;

public interface ISrService {

    public PageList<SrScientificResearch> getPageList(Page page, Criteria criteria);

    public PageList<SrScientificResearch> getPageListBySql(Page page, String sql, Criteria criteria);

    public SrScientificResearch getSrScientificResearch(Criteria criteria);

    public int save(SrScientificResearch SrScientificResearch);

    public int delete(Criteria criteria);

}
