package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.management.mhm.MhmOutpatientRecord;

import java.util.List;

public interface IOutPatientRecordService {

	public List<MhmOutpatientRecord> getOutPatientRecords(Criteria criteria);

}
