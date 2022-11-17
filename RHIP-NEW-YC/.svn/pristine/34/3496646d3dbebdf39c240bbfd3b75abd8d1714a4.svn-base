package com.founder.rhip.ehr.repository.summary;

import java.util.List;

import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of HospitalizedHistory
 */
public interface IHospitalizedHistoryDao extends IDao<HospitalizedHistory, String> {

	List<HospitalizedHistory> getDistinctList(Criteria criteria, Order order);
}