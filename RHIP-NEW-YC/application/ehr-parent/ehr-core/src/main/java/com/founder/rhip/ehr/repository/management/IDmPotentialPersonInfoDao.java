package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonInfo;

/**
 * DAO interface of DmPotentialPerinfo
 * 
 */
public interface IDmPotentialPersonInfoDao extends IDao<DmPotentialPersonInfo,Long> {
	  public boolean truncateTable();

	public PageList<DmPotentialPersonInfo> getNotIntoPatientInfo(Page page, Criteria criteria);
	public DmPotentialPersonInfo getPatientInfo(Criteria criteria);
}