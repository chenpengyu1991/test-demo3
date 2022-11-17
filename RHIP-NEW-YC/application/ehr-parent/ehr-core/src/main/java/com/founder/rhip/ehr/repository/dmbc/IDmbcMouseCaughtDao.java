package com.founder.rhip.ehr.repository.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseCaught;

/**
 * DAO interface of DmbcMouseCaught
 * 
 */
public interface IDmbcMouseCaughtDao extends IDao<DmbcMouseCaught,Long> {

	public PageList<DmbcMouseCaught> searchMouseList(Page page,
			Criteria criteria);
}