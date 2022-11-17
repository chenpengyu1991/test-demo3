package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.Person;

import java.util.List;
import java.util.Map;

public interface IPersonService {

	public Person createPerson(Person person);
	
	public Person createPersonWithPid(Person person);
	
	public List<Map<String, Object>> createPersons(List<Person> persons);
	
	public List<Map<String, Object>> createPersonsInMap(List<Map<String, Object>> persons);
	
	public Person updatePerson(Person person, String... properties);

	public Person updatePerson(List<Map<String, Object>> changedValues);
	
	public int deletePerson(String domainId, String localId);

	public void mergePerson(String personIds, String pmpiId);

	public int mergePerson(List<Person> personList, String pmpiId);
	
	public int splitPerson(String operator, Long... personId);

	public Person getBestRecord(String pmpiId);

	public Person getPerson(Long personId);

	public List<Person> getPersons(Criteria criteria);

	public List<Person> queryPerson(Criteria criteria);
	
	public PageList<Person> queryPerson(int queryType, Page page, Criteria criteria, String... properties);
	
	public List<Person> crossQueryId(Criteria condition, String targetDomain);
	
	public Person findOldPerson(String domainId, String localId);

	public Object compareOldPerson(Person oldPerson, Person person);

	public List<Person> getLinkPersons(String pmpiId);

	public PageList<Person> getPersonLogs(Page page, Long personId);

	public Person getPersonLog(Long personId, Long updateTime);

	
}
