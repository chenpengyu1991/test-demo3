package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.management.mhm.MhmOutpatientRecord;
import com.founder.rhip.ehr.repository.management.mhm.IMhmOutpatientRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("outPatientService")
public class OutPatientRecordServiceImpl implements IOutPatientRecordService {

	@Resource
	private IMhmOutpatientRecordDao outpatientRecordDao;

	@Override
	public List<MhmOutpatientRecord> getOutPatientRecords(Criteria criteria) {
		return outpatientRecordDao.getOutPatientRecords(criteria);
	}

}
