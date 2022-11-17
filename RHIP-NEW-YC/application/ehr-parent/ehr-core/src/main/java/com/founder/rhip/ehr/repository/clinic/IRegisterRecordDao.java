package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.RegisterRecord;

public interface IRegisterRecordDao extends IDao<RegisterRecord, Long> {
	
	List<Map<String,Object>> getRegisterStatistics(String dateStr);

}
