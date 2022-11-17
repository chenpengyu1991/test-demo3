package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.ListScDc;

import java.util.List;

/**
 * DAO interface of IdmScDc
 * 
 */
public interface IListScDcDao extends IDao<ListScDc,Long> {

	/**
	 * 查询科室传染病信息
	 * @param criteria
	 * @return List<ListScDc>
	 */    
    public List<ListScDc> findDepartmentInfection(Criteria criteria, List<ListScDc> existsInfection);
    
    /**
     * 获取本机构，本月共上报多少种传染病
     * @param       criteria
     * @return      List<ListScDc>
     */
    public List<ListScDc> findInfections(Criteria criteria);
    
	/**
	 * 合计传染病信息
	 * @param criteria
	 * @return List<ListScDc>
	 */    
    public List<ListScDc> summaryInfection(Criteria criteria);
}