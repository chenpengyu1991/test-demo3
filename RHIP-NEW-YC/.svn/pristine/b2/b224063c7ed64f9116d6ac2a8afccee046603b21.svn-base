package com.founder.rhip.ehr.repository.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMosquitoesCaught;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of DmbcMosquitoesCaught
 * 
 */
public interface IDmbcMosquitoesCaughtDao extends IDao<DmbcMosquitoesCaught,Long> {

	public PageList<DmbcMosquitoesCaught> searchMosquitoesList(Page page,
			Criteria criteria);

	public List<Map<String, Object>> report(String beginDate, String endDate, String townShip);
}