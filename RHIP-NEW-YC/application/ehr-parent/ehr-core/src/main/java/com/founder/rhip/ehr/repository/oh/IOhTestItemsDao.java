package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhTestItems;

public interface IOhTestItemsDao extends IDao<OhTestItems, Integer>{

	/**
	 * 监测点示意图查询
	 * @param       criteria
	 * @return      PageList<OhTestItems>
	 */
	PageList<OhTestItems> searchTestItemsList(Page page, Criteria criteria);
	

}
