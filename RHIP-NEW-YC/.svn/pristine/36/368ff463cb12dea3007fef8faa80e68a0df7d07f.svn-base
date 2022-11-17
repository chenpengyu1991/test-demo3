package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.CommonUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.service.IDomainService;
import com.founder.rhip.mdm.service.IPersonService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("personApp")
public class PersonAppImpl extends MDMBaseApp implements IPersonApp {

	@Resource(name = "mdmPersonService")
	private IPersonService personService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "mdmDomainService")
	private IDomainService domainService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Override
	public Person registPerson(Person person, String... properties) throws Exception {
		preProcess(person);
		personValidation(person, properties);
		//find old person
		Person oldPerson = personService.findOldPerson(person.getDomainId(), person.getLocalId());
		// already have this person, update
		if (oldPerson != null) {
			person.setOperateType(OperateType.update.getName());
			Person bestRecord = null;
			if (ObjectUtil.isNotEmpty(properties)) {
				bestRecord = personService.updatePerson(person, properties);
			} else {
				Object obj = personService.compareOldPerson(oldPerson, person);
				if (obj instanceof List) {
					List<Map<String, Object>> changedValues = (List<Map<String, Object>>) obj;
					bestRecord = personService.updatePerson(changedValues);
				} else {
					bestRecord = personService.updatePerson((Person) obj, properties);
				}
			}
			return bestRecord;
		}
		//insert with PMPI_ID
		if (StringUtil.isNotEmpty(person.getPmpiId())) {
			person.setOperateType(OperateType.create.getName());
			Person bestRecord = personService.createPersonWithPid(person);
			if (bestRecord == null) {
				throw new Exception("不存在该PMPI_ID的患者");
			} else {
				return bestRecord;
			}
		}
		//pure insert
		person.setOperateType(OperateType.create.getName());
		Person bestRecord = personService.createPerson(person);
		if (bestRecord == null) {
			throw new Exception("创建患者失败");
		}
		return bestRecord;
	}

	@Override
	public List<Person> queryBestRecord(Criteria criteria) throws Exception {
		if (criteria == null) {
			throw new Exception("请提供查询条件");
		}
		// validation
		List<Criterion> ctrs = criteria.getCriteria();
		if (ctrs.size() < 1) {
			throw new Exception("请提供查询条件");
		}
		Record record = new Record();
		List<String> messageList = new ArrayList<String>();
		for (Criterion ctr : ctrs) {
			record.put(ctr.getName(), ctr.getValue());
		}
		checkCriteria(messageList, criteria, EntityType.PERSON);
		dictionaryCheck(messageList, record, EntityType.PERSON);
		regexCheck(messageList, record, EntityType.PERSON);
		maxLengthCheck(messageList, record, EntityType.PERSON);
		if (ObjectUtil.isNotEmpty(messageList)) {
			throw getCheckException(messageList);
		}
		//query
		List<Person> persons = personService.queryPerson(criteria);
		return persons;
	}

	@Override
	public List<Person> crossQueryId(Criteria condition, String targetDomain) throws CheckException, Exception {
		//validation
		List<Criterion> ctrs = condition.getCriteria();
		Record record = new Record();
		List<String> messageList = new ArrayList<String>();
		for (Criterion ctr : ctrs) {
			record.put(ctr.getName(), ctr.getValue());
		}
		checkCriteria(messageList, condition, EntityType.PERSON);
		dictionaryCheck(messageList, record, EntityType.PERSON);
		regexCheck(messageList, record, EntityType.PERSON);
		maxLengthCheck(messageList, record, EntityType.PERSON);
		if (ObjectUtil.isNotEmpty(messageList)) {
			throw getCheckException(messageList);
		}
		// query
		List<Person> list = personService.crossQueryId(condition, targetDomain);
		return list;
	}

	@Override
	public List<Map<String, Object>> importPersons(List<Person> personList) {
		//validation
		for (Person person : personList) {
			preProcess(person);
			//personValidation(person);
		}
		Long start = System.currentTimeMillis();
		log.debug("------ start importing persons ----------------");
		List<Map<String, Object>> returnList = personService.createPersons(personList);
		Long end = System.currentTimeMillis();
		log.debug("------ import finished ----------------");
		log.debug("The size of the list is : " + returnList.size());
		log.debug("Total time used : " + (end - start) / 1000);
		return returnList;
	}

	@Override
	public List<Map<String, Object>> importPersonsWithMap(List<Map<String, Object>> personMaps) {
		for (Map<String, Object> person : personMaps) {
			//personValidation(person);
			person.put("updateTime", getOperatorTime());
			if (ObjectUtil.isNullOrEmpty(person.get("cpy"))) {
				person.put("cpy", CommonUtil.getPinYin((String)person.get("name")));
			}
		}
		Long start = System.currentTimeMillis();
		log.debug("------ start importing persons ----------------");
		List<Map<String, Object>> returnList = personService.createPersonsInMap(personMaps);
		Long end = System.currentTimeMillis();
		log.debug("------ import finished ----------------");
		log.debug("The size of the list is : " + returnList.size());
		log.debug("Total time used : " + (end - start)/1000);
		return returnList;
	}

	public Map<String, String> getDictionary(String dictKey) {
		Map<String, String> dictMap = null;
		if (dictKey.equals("DOMAIN_CODE")) {
			dictMap = domainService.getDomainMapUseCache(new Criteria("domainCode", dictKey));
		} else if (dictKey.equals("ORGAN_CODE")) {
			dictMap = organizationApp.queryAllOrganizationMap();
		} else if (dictKey.equals("411481")) {//此字典有5千多条数据，团风县以421121开头过滤 永城以411481开头过滤
			dictMap = dictionaryApp.queryDicItemMap(new Criteria("DIC_CODE",dictKey).add("STATUS","1").add("item_code", OP.LIKE,"421121%"));
		}
		else{
			dictMap = dictionaryApp.queryDicItemMap(dictKey);
		}
		return dictMap;
	}

	private void preProcess(Person person) {
		person.setUpdateTime(getOperatorTime());
		if (ObjectUtil.isNullOrEmpty(person.getCpy())) {
			person.setCpy(CommonUtil.getPinYin(person.getName()));
		}
	}

	private void personValidation(Person person, String... properties) throws CheckException, Exception {
		 if (ObjectUtil.isNotEmpty(properties)) {
			 List<String> proList = new ArrayList<String>();
			 for (String prop : properties) { proList.add(prop); };
			 if (!proList.contains("updateOrganCode")) {
				 proList.add("updateOrganCode");
			 }
			 if (!proList.contains("updatePerson")) {
				 proList.add("updatePerson");
			 }
			 if (!proList.contains("updateTime")) {
				 proList.add("updateTime");
			 }
			 properties = proList.toArray(new String[proList.size()]);
		 }
		List<String> messageList = new ArrayList<>();
		Record record = new Record(person);
		checkAll(messageList, record, EntityType.PERSON, properties);
		if (StringUtil.isNullOrEmpty(person.getIdCard()) && StringUtil.isNullOrEmpty(person.getOtherCardNo())) {
			messageList.add("证件号为空");
		}
		if (ObjectUtil.isNotEmpty(messageList)) {
			throw getCheckException(messageList);
		}
	}

}
