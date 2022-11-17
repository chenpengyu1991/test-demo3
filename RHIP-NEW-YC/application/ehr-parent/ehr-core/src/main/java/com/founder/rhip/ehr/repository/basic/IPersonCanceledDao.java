package com.founder.rhip.ehr.repository.basic;

import java.util.Map;

import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of PersonInfo
 */
public interface IPersonCanceledDao extends IDao<PersonCanceledInfo, Long> {

	PageList<Map<String, Object>> exportPersonRecordList(Page page,
			Criteria criteria, Order order);


	public void updatePersonCanceledInfo(String canceledOrganCode, String canceledOrganName, String[] newAddVillageCodes);

}