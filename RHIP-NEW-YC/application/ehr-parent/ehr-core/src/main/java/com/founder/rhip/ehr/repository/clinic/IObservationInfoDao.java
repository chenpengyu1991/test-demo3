package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.ObservationInfo;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of ObservationInfo
 */
public interface IObservationInfoDao extends IDao<ObservationInfo, Long> {
	
	public List<ObservationInfo> getPersonAndEhrList(int type);
}