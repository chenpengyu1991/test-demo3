package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Department;

public interface IDepartmentDao extends IDao<Department, Long> {
	
	public void insertDepartmentLog(Criteria criteria);
	
	public PageList<Department> getUpdateHistory(Page page, Long deptId, String... properties);
	
}
