package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.child.EmployeesHealthChecklist;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;

public interface IEmpSearchService {
	public PageList<EmployeesHealthChecklist> getEmployeesHealthChecklist(Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Page page);

	public EmployeesHealthChecklist getHealthCheck(Criteria criteria);

	public Integer saveEmployees(EmployeesHealthChecklist employeesHealthChecklist);

	public List<EmployeesHealthChecklist> getHealthCheckList(Criteria criteria, Order order);
}
