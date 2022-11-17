package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Person;

import java.util.List;
import java.util.Map;

public interface IPersonApp {

	public Person registPerson(Person person, String... properties) throws CheckException, Exception;

	public List<Person> queryBestRecord(Criteria criteria) throws CheckException, Exception;

	public List<Person> crossQueryId(Criteria condition, String targetDomain) throws CheckException, Exception;

	public List<Map<String, Object>> importPersons(List<Person> personList);

	public List<Map<String, Object>> importPersonsWithMap(List<Map<String, Object>> personMaps);
}
