package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.DoctorSignCensus;

public interface IDoctorSignCensusDao extends IDao<DoctorSignCensus, Long>{

	List<DoctorSignCensus> getDoctorSignCensusList(Criteria criteria, List<String> organCodeList);


}
