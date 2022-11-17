package com.founder.rhip.ncp.dao;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.entity.NcpPatient;

public interface INcpPatientDao extends IDao<NcpPatient, String> {

	PageList<NcpPatient> getNcpPatientList(Page buildPage, Criteria criteria);

	List<Map<String, Object>> exportNcpPatientList(Page page, Criteria criteria);

	List<NcpPatient> queryWithOutFollowUp();

	List<NcpPatient> queryTimesFollowUp();

	List<NcpPatient> queryFollowUp();
}
