package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Staff;

import java.util.List;
import java.util.Set;

public interface IStaffMainDao extends IDao<Staff, String> {

	public PageList<Staff> queryStaffMain(Page page, Criteria criteria, String... properties);
	
	public void removeUnusedSmpiId(Set<String> checkList);

	public List<Staff> queryStaffMain(Criteria criteria, String[] properties);
}
