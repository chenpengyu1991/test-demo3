package com.founder.rhip.ehr.repository.clinic;

import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of EhrIndex
 */
public interface IEHRHealthEventQueryDao extends IDao<EHRHealthEvent, Long> {

	public PageList<EHRHealthEvent> getPageListNoInfectious(Page page, Criteria criteria, Order order, String... properties);
}