/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;
import com.founder.rhip.ehr.repository.clinic.IReadHealthRecordDao;

/**
 * 调阅健康档案记录
 * 
 * @author ggf
 * 
 */
@Service("readHealthRecordService")
public class ReadHealthRecordServiceImpl extends AbstractService implements IReadHealthRecordService {
	
	@Autowired
	private IReadHealthRecordDao readHealthRecordDao;

	@Override
	public void addReadRecord(ReadHealthRecord readHealthRecord) {
		readHealthRecordDao.insert(readHealthRecord);
	}

	@Override
	public List<ReadHealthRecord> getReadRecordList(Criteria criteria,Page page, Order order) {
		PageList<ReadHealthRecord> readHealthRecords  = readHealthRecordDao.getPageList(page, criteria, order);
		if(ObjectUtil.isNotEmpty(readHealthRecords)){
			return readHealthRecords.getList();
		}
		return null;
	}
}