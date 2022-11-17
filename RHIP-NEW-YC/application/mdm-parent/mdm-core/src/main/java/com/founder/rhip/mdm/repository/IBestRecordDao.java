package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Person;

import java.util.List;
import java.util.Set;

public interface IBestRecordDao extends IDao<Person, String>{


	public void removeUnusedPmpiId(Set<String> checkList);
	
	public PageList<Person> queryBestRecord(Page page, Criteria criteria, String... properties);
	
	public List<Person> queryBestRecord(Criteria criteria, String... properties);
}
