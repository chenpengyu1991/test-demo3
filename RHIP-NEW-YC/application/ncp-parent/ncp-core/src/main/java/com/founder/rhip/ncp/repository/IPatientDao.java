package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.entity.NcpPatient;

public interface IPatientDao extends IDao<NcpPatient, String> {
	PageList<NcpPatient> getNcpPatientList(Page buildPage, Criteria criteria);
}
