package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;

import java.util.List;

/**
 * DAO interface of IdmListCc
 * 
 */
public interface IListCcDao extends IDao<ListCc,Long> {

    public PageList<ListCc> getCcListForSt(Page page, Criteria criteria);

    public List<ListCc> getCcListForSt1(Criteria criteria);

    /**
     * 麻风密切接触者统计
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListCc> getCcListForLeprosySt(Page page, Criteria criteria);
    
    /**
     * 麻风密切接触者统计 不分页
     * @param page
     * @param criteria
     * @return
     */
    public List<ListCc> getCcListForLeprosySt(Criteria criteria);
    
}