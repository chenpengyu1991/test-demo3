package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListAi;

import java.util.List;

/**
 * DAO interface of IdmListAi
 * 
 */
public interface IListAiDao extends IDao<ListAi,Long> {
    public PageList<ListAi> findAiList(Page page, Criteria criteria, Order od);

    public List<ListAi> findAiList(Criteria criteria, Order od);
}