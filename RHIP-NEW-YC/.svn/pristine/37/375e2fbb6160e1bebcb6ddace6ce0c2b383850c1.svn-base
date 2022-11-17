package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.Supervisor;

import java.util.List;

/**
 * DAO interface of IdmSupervisor
 * 
 */
public interface ISupervisorDao extends IDao<Supervisor,Long> {
	/**
	 * 合计
	 * @param criteria
	 * @param summaryType
	 * @return Supervisor
	 */    
    public Supervisor getSummary(Criteria criteria, String summaryType);

	/**
	 * 汇总
	 * @param criteria
	 * @param summaryType
	 * @return List<Supervisor>
	 */
    public List<Supervisor> findSupervisorFill(Criteria criteria, String summaryType);
}