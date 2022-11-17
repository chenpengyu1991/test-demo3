package com.founder.rhip.ncp.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ncp.entity.NcpPatient;

public interface INcpPatientService {

	PageList<NcpPatient> getNcpPatientList(Page buildPage, Criteria criteria);

	int saveNcpPatientInfo(NcpPatient ncpPatient, User user, Organization organization);

	NcpPatient getNcpPatient(Criteria criteria);

	int deleteNcpPatient(NcpPatient ncpPatient);

	List<Map<String, Object>> exportNcpPatientList(Page page, Criteria criteria);


}
