package com.founder.rhip.ehr.repository.finance;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceDetails;


/**
 * DAO interface of SrScientificResearch
 * 
 */
public interface IFcPubFinanceDetailsDao extends IDao<FcPubFinanceDetails,Long> {

    public void save(FcPubFinanceDetails fcPubFinanceDetails);

    public PageList<FcPubFinanceDetails> getPageListBySql(Page page, String sql, Criteria criteria);

}