package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;

/**
 * DAO interface of IdmListRr
 * 
 */
public interface IListRrDao extends IDao<ListRr,Long> {
	/**
     * 查看治疗记录列表
     * @param       criteria
     * @return      PageList<ListRr>
     */
	public PageList<ListRr> findAcographyList(Page page, Criteria criteria);
}