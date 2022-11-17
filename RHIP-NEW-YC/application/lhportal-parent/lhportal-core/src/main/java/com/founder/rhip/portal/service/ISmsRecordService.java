package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.portal.SmsRecord;

public interface ISmsRecordService {

	/**
	 * 获取短信列表
	 * @param criteria
	 * @param page
	 * @return
	 */
	public PageList<SmsRecord> getSMSList(Criteria criteria, Page page);
}
