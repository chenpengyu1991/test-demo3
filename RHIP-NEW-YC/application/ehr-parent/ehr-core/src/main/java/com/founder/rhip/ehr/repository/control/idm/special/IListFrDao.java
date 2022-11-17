package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;

import java.util.List;

/**
 * DAO interface of IdmListFr
 * 
 */
public interface IListFrDao extends IDao<ListFr,Long> {

	/**
     * 麻风随访统计
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListFr> getFrListForLeprosySt(Page page, Criteria criteria);
   
    /**
     * 麻风随访统计 不分页
     * @param page
     * @param criteria
     * @return
     */
    public List<ListFr> getFrListForLeprosySt(Criteria criteria);

    public void updatePaAddress2(String paStreet, String townName, String villageName);
}