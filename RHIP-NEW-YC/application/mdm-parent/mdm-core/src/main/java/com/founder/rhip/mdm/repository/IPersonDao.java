package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Person;

import java.util.List;
import java.util.Map;

public interface IPersonDao extends IDao<Person, Long> {

	public void insertPersonLog(String[] properties, Long... personId);
	
	public List<Person> crossQuery(Criteria criteria, Map<String, Object> target);

	public PageList<Person> getPersonLogs(Page page, Long personId, String[] properties);

	public Person getPersonLog(Long personId, Long updateTime, String[] properties);
}
