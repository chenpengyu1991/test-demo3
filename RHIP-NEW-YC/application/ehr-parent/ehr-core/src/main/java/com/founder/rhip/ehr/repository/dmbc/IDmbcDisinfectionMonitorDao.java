package com.founder.rhip.ehr.repository.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionMonitor;

/**
 * DAO interface of DmbcDisinfectionMonitor
 * 
 */
public interface IDmbcDisinfectionMonitorDao extends IDao<DmbcDisinfectionMonitor,Long> {

	public PageList<DmbcDisinfectionMonitor> searchDisinfectionMonitor(Criteria criteria,
			Page page);
}