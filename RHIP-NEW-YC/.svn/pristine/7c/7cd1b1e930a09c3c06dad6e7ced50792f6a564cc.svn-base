package com.founder.rhip.sr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import com.founder.rhip.ehr.repository.sr.ISrScientificResearchDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chen_haibing on 3/31/2014.
 */
@Service("srService")
public class SrServiceImpl implements ISrService {

    @Resource(name = "srScientificResearchDao")
    private ISrScientificResearchDao srScientificResearchDao;

    @Override
     public PageList<SrScientificResearch> getPageList(Page page, Criteria criteria) {
        return srScientificResearchDao.getPageList(page, criteria, new Order("YEAR DESC, BELONG_ORGAN_CODE, ID", false));
    }

    @Override
    public PageList<SrScientificResearch> getPageListBySql(Page page, String sql, Criteria criteria) {
        return srScientificResearchDao.getPageListBySql(page, sql, criteria);
    }

    @Override
    public SrScientificResearch getSrScientificResearch(Criteria criteria) {
        return srScientificResearchDao.get(criteria);
    }

    @Override
    public int save(SrScientificResearch srScientificResearch) {
        int result = 0;
        Long id = srScientificResearch.getId();
        if (ObjectUtil.isNotEmpty(id)) {
            result = srScientificResearchDao.update(srScientificResearch);
        } else {
            result = srScientificResearchDao.insert(srScientificResearch);
        }
        return result;
    }

    @Override
    public int delete(Criteria criteria) {
        return srScientificResearchDao.delete(criteria);
    }
}
