package com.founder.rhip.ehr.service;

import javax.annotation.Resource;

import com.founder.fasf.beans.Order;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.rhip.ehr.repository.clinic.IInpatientMedicalRecordDao;

@Service("inpatientMedicalRecordService")
public class InpatientMedicalRecordServiceImpl implements IInpatientMedicalRecordService{
	
	@Resource
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	
	@Override
	public PageList<InpatientMedicalRecord> getInpatientMedicalRecords(Criteria criteria, Page page, Order order) {
		return inpatientMedicalRecordDao.getPageList(page, criteria, order);
	}
}
