package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;

/**
 * DAO interface of HealthResourceRecord
 * 
 */
public interface IHeResourceRecordDao extends IDao<HeResourceRecord,Long> {
	
	public PageList<HeResourceRecord> getHealthPositionPageList(Criteria criteria, Page page);

}