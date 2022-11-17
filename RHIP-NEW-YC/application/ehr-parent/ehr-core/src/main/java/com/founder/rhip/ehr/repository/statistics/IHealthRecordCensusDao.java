package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.HealthRecordCensus;

public interface IHealthRecordCensusDao extends IDao<HealthRecordCensus, Long>{

	List<HealthRecordCensus> getHealthRecordCensusList(Criteria criteria, List<String> organCodeList);

	HealthRecordCensus getHealthRecordCensus(Criteria criteria);

	int updateBuildRecord(HealthRecordCensus healthRecord);

	int addBuildRecord(HealthRecordCensus healthRecord);
}
