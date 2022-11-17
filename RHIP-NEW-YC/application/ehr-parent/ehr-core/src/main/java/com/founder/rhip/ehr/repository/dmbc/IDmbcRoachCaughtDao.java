package com.founder.rhip.ehr.repository.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachCaught;

/**
 * DAO interface of DmbcRoachCaught
 * 
 */
public interface IDmbcRoachCaughtDao extends IDao<DmbcRoachCaught,Long> {

	public PageList<DmbcRoachCaught> searchRoachList(Page page,
			Criteria criteria);
}