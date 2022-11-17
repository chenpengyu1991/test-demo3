package com.founder.rhip.ihm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.HbpDiCensus;

public interface IDoctorSignCensusService {

	List<DoctorSignCensus> getDoctorSignCensusList(Criteria criteria);

}
