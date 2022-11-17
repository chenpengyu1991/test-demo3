package com.founder.rhip.ehr.repository.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachMonitor;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of DmbcRoachMonitor
 * 
 */
public interface IDmbcRoachMonitorDao extends IDao<DmbcRoachMonitor, Long> {

	PageList<DmbcRoachMonitor> searchRoachMonitorList(Page page,
			Criteria criteria);

	public List<Map<String, Object>> report(String beginDate, String endDate, String townShip);
}