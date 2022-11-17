package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmEmergency;

/**
 * DAO interface of MhmEmergency
 * 
 */
public interface IMhmEmergencyDao extends IDao<MhmEmergency,Long> {
	/**
     * 查询应急处置列表
     * @param       criteria
     * @return      PageList<MhmEmergency>
     */
	public PageList<MhmEmergency> findList(Criteria criteria,Page page);
}