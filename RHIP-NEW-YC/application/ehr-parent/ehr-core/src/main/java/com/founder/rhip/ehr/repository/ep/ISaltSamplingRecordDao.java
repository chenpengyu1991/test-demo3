package com.founder.rhip.ehr.repository.ep;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ep.SaltSamplingRecord;

/**
 * DAO interface of SaltSamplingRecord
 * 
 */
public interface ISaltSamplingRecordDao extends IDao<SaltSamplingRecord,Long> {

	public PageList<SaltSamplingRecord> getPageList(Page page, String year);
}