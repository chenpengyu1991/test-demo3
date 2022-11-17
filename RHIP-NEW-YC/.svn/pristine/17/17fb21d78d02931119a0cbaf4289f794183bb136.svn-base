package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.CheckUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.repository.IBestRecordDao;
import com.founder.rhip.mdm.repository.IPersonDao;
import com.founder.rhip.mdm.service.IMDMConfigService;
import com.founder.rhip.mdm.service.IPersonService;

import net.sf.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.Map.Entry;

@Service("mdmPersonService")
public class PersonServiceImpl extends MDMService implements IPersonService {

	@Resource(name = "mdmConfigService")
	private IMDMConfigService mdmConfigService;
	
	@Resource(name = "mdmPersonDao")
	private IPersonDao personDao;
	
	@Resource(name = "mdmBestRecordDao")
	private IBestRecordDao bestRecordDao;
	
	private String[] BEST_RECORD_PROPERTIES;
	
	private String[] PERSON_PROPERTIES;
	
	private static final String PMPI_ID = "pmpiId";
	private static final String PERSON_ID = "personId";
	private static final String DOMAIN_ID = "domainId";
	private static final String LOCAL_ID = "localId";
	private static final String ID_CARD = "idCard";
	private static final String OTHER_CARD_TYPE = "otherCardType";
	private static final String OTHER_CARD_NO = "otherCardNo";
	private static final String SEQ_PERSON = "SEQ_MDM_PERSON";
	

	@Transactional
	@Override
	public Person createPerson(Person person) {
		// check best record
		String idCard = person.getIdCard();
		Criteria ctr = new Criteria();
		if (StringUtil.isNotEmpty(idCard)) {
			ctr.add(ID_CARD, idCard);
		} else {
			idCard = person.getOtherCardNo();
			if (StringUtil.isNotEmpty(idCard)) {
				ctr.add(OTHER_CARD_TYPE, person.getOtherCardType());
				ctr.add(OTHER_CARD_NO, idCard);
			}
		}
		Person bestRecord = bestRecordDao.get(ctr, getBestRecordProperties());
		if (bestRecord != null) { // update best record
			// update best record
			updateBestRecordInfo(bestRecord, person);
			person.setPmpiId(bestRecord.getPmpiId());
		} else { // insert best record
			bestRecord = person;
			//查person表中有没有
			Person dbPerson = personDao.get(ctr, getPersonProperties());
			if (dbPerson != null) {
				bestRecord.setPmpiId(dbPerson.getPmpiId());
			} else {
				String pmpiId = generatePmpiId();
				bestRecord.setPmpiId(pmpiId);
				bestRecordDao.insert(bestRecord, getBestRecordProperties());
			}
		}
		// insert into PERSON
		int pCreated = personDao.insertWithSeq(person, SEQ_PERSON, getPersonProperties());
		if (pCreated != 1) {
			return null;
		}
		return bestRecord;
	}
	
	@Transactional
	@Override
	public Person createPersonWithPid(Person person) {
		Criteria ctr = new Criteria(PMPI_ID, person.getPmpiId());
		Person bestRecord = bestRecordDao.get(ctr, getBestRecordProperties());
		if (bestRecord != null) {
			int inserted = personDao.insertWithSeq(person, SEQ_PERSON, getPersonProperties());
			if (inserted == 1) {
				updateBestRecordInfo(bestRecord, person);
				return bestRecord;
			}
		}
		return null; // no BestRecord
	}

	@Transactional
	@Override
	public List<Map<String, Object>> createPersons(List<Person> persons) {
		List<Map<String, Object>> personMaps = new ArrayList<>();
		for (Person person : persons) {
			Record record = new Record(person);
			personMaps.add(record.getMap());
		}
		return createPersonsInMap(personMaps);
	}
	
	@Transactional
	@Override
	public List<Map<String, Object>> createPersonsInMap(List<Map<String, Object>> persons) {
		List<Map<String, Object>> newBestRecordList = new ArrayList<>();
		List<Map<String, Object>> updatedBestRecordList = new ArrayList<>();
		List<Map<String, Object>> updatedPersonList = new ArrayList<>();
		List<Map<String, Object>> removeList = new ArrayList<>();
		for (Map<String, Object> person : persons) {
			person.put("operateType", OperateType.batchImport.getName());
			Criteria criteria = new Criteria();
			criteria.add(DOMAIN_ID, person.get(DOMAIN_ID));
			criteria.add(LOCAL_ID, person.get(LOCAL_ID));
			Person oldPerson = personDao.get(criteria, getPersonProperties());
			if (oldPerson != null) {
				Person bestRecord = bestRecordDao.get(new Criteria(PMPI_ID, oldPerson.getPmpiId()), getBestRecordProperties());
				Record personRecord = new Record(new Person());
				personRecord.putAll(person);
				Map<String, Object> changedValue = getChangedValue(
						new Record(bestRecord), personRecord,
						getBestRecordProperties());
				changedValue.remove(PMPI_ID);
				if (ObjectUtil.isNotEmpty(changedValue)) {
					changedValue.put(PMPI_ID, bestRecord.getPmpiId());
					updatedBestRecordList.add(changedValue);
				}
				Map<String, Object> changedPersonValue = getChangedValue(
						new Record(oldPerson), personRecord,
						getBestRecordProperties());
				changedValue.remove(PERSON_ID);
				if (ObjectUtil.isNotEmpty(changedPersonValue)) {
					changedPersonValue.put(PERSON_ID, oldPerson.getPersonId());
					updatedPersonList.add(changedPersonValue);
				}
				person.put(PMPI_ID, bestRecord.getPmpiId());
				removeList.add(person);
			} else {
				// check best record
				String idCard = (String) person.get(ID_CARD);
				Criteria ctr = new Criteria();
				if (StringUtil.isNotEmpty(idCard)) {
					ctr.add(ID_CARD, idCard);
				} else {
					idCard = (String) person.get(OTHER_CARD_NO);
					if (StringUtil.isNotEmpty(idCard)) {
						ctr.add(OTHER_CARD_TYPE, person.get(OTHER_CARD_TYPE));
						ctr.add(OTHER_CARD_NO, idCard);
					}
				}
				Person bestRecord = bestRecordDao.get(ctr, getBestRecordProperties());
				if (bestRecord != null) {
					Record personRecord = new Record(new Person());
					personRecord.putAll(person);
					Map<String, Object> changedValue = getChangedValue(
							new Record(bestRecord), personRecord,
							getBestRecordProperties());
					changedValue.remove(PMPI_ID);
					if (ObjectUtil.isNotEmpty(changedValue)) {
						changedValue.put(PMPI_ID, bestRecord.getPmpiId());
						updatedBestRecordList.add(changedValue);
					}
					person.put(PMPI_ID, bestRecord.getPmpiId());
				} else {
					Map<String, Object> record = new HashMap<>();
					String pmpiId = generatePmpiId();
					person.put(PMPI_ID, pmpiId);
					record.putAll(person);
					newBestRecordList.add(record);
				}
				person.put(PERSON_ID, personDao.getSequenceNextVal(SEQ_PERSON, Long.class));
			}
		}

		List<Map<String, Object>> returnList = new ArrayList<>();
		for (Map<String, Object> person : persons) {
			Map<String, Object> ps = new HashMap<>();
			ps.put(DOMAIN_ID, person.get(DOMAIN_ID));
			ps.put(LOCAL_ID, person.get(LOCAL_ID));
			ps.put(PMPI_ID, person.get(PMPI_ID));
			returnList.add(ps);
		}
		if (ObjectUtil.isNotEmpty(removeList)) {
			for (Map<String, Object> p : removeList) {
				persons.remove(p);
			}
		}
		personDao.batchMapInsert(persons, getPersonProperties());
		if (ObjectUtil.isNotEmpty(newBestRecordList)) {
			bestRecordDao.batchMapInsert(newBestRecordList, getBestRecordProperties());
		}
		if (ObjectUtil.isNotEmpty(updatedBestRecordList)) {
			for (Map<String, Object> changedValue : updatedBestRecordList) {
				bestRecordDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
				personDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
			}
		}
		if (ObjectUtil.isNotEmpty(updatedPersonList)) {
			for (Map<String, Object> changedValue : updatedPersonList) {
				personDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
			}
		}
		//clean memory
		newBestRecordList.clear();
		updatedBestRecordList.clear();
		updatedPersonList.clear();
		removeList.clear();
		newBestRecordList = null;
		updatedBestRecordList = null;
		updatedPersonList = null;
		removeList = null;
		return returnList;
	}

	@Transactional
	@Override
	public Person updatePerson(Person person, String... properties) {
		// insert oldPerson into PERSON_LOG
		personDao.insertPersonLog(getPersonProperties(), person.getPersonId());
		// update person
		if (properties == null) {
			properties = getPersonProperties();
		}
		personDao.update(person, properties);
		// return best record
		Criteria criteria = new Criteria(DOMAIN_ID, person.getDomainId()).add(LOCAL_ID, person.getLocalId());
		List<Person> list = bestRecordDao.queryBestRecord(criteria, getBestRecordProperties());
		if (ObjectUtil.isNullOrEmpty(list)) {
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public Person updatePerson(List<Map<String, Object>> changedValues) {
		Map<String, Object> cv1 = changedValues.get(0);
		Map<String, Object> cv2 = changedValues.get(1);
		// insert oldPerson into PERSON_LOG
		Long personId = (Long) cv1.get(PERSON_ID);
		String pmpiId = (String) cv1.get(PMPI_ID);
		personDao.insertPersonLog(getPersonProperties(), personId);
		// update person
		personDao.update(cv1, cv1.keySet().toArray(new String[] { "" }));
		// update best record
		bestRecordDao.update(cv2, cv2.keySet().toArray(new String[] { "" }));
		return bestRecordDao.get(new Criteria(PMPI_ID, pmpiId), getBestRecordProperties());
	}

	@Transactional
	@Override
	public int deletePerson(String domainId, String localId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public void mergePerson(String personIds, String pmpiId) {
		Long updateTime = CheckUtil.getOperatorTime();
		String[] ids = personIds.split(",");
		List<Person> personList = new ArrayList<>();
		for (String id : ids) {
			Person person = personDao.get(new Criteria("personId", id));
			if (!person.getPmpiId().equals(pmpiId)) {
				person.setUpdateTime(updateTime);
				personList.add(person);
			}
		}
		mergePerson(personList, pmpiId);
	}

	@Transactional
	@Override
	public int mergePerson(List<Person> personList, String pmpiId) {
		Person bestRecord = bestRecordDao.get(new Criteria(PMPI_ID, pmpiId), getBestRecordProperties());
		Set<String> changedBestRecords = new HashSet<>();
		List<Long> personIds = new ArrayList<>();
		List<Map<String, Object>> updateMapList = new ArrayList<>();
		Map<String, Object> changedValues = new HashMap<>();
		// store original PMPI_ID, PERSON_ID
		for (Person person : personList) {
			changedBestRecords.add(person.getPmpiId());
			Long personId = person.getPersonId();
			personIds.add(personId);
			Map<String, Object> updateMap = new HashMap<>();
			updateMap.put(PMPI_ID, pmpiId);
			updateMap.put(PERSON_ID, personId);
			updateMap.put("updateTime", person.getUpdateTime());
			updateMap.put("operateType", person.getOperateType());
			updateMap.put("updatePerson", person.getUpdatePerson());
			updateMapList.add(updateMap);
			Map<String, Object> change = getChangedValue(new Record(bestRecord), new Record(person), getBestRecordProperties());
			change.remove(PMPI_ID);
			if (ObjectUtil.isNotEmpty(change)) {
				change.put(PMPI_ID, pmpiId);
				changedValues.putAll(change);
			}
		}
		// batch insert into PERSON_LOG
		personDao.insertPersonLog(getPersonProperties(), (Long[])personIds.toArray(new Long[personIds.size()]));
		// update PMPI_ID in PERSON
		String[] updateProp = {PMPI_ID, "updateTime", "operateType", "updatePerson"};
		personDao.batchMapUpdate(updateMapList, updateProp);
		// clean PMPI_ID
		bestRecordDao.removeUnusedPmpiId(changedBestRecords);
		//update best record info
		if (ObjectUtil.isNotEmpty(changedValues)) {
			bestRecordDao.update(changedValues, changedValues.keySet().toArray(new String[]{""}));
		}
		updateAfterSplit(changedBestRecords.toArray(new String[]{""}));
		return personList.size();
	}

	@Transactional
	@Override
	public int splitPerson(String operator, Long... personId) {
		Long updateTime = CheckUtil.getOperatorTime();
		if (personId == null || personId.length == 0) {
			return 0;
		}
		// insert person log
		personDao.insertPersonLog(getPersonProperties(), personId);
		// change pmpi_id
		String pmpiId = generatePmpiId();
		String oldPmpiId = null;
		List<Map<String, Object>> updateMapList = new ArrayList<>();
		Record bestRecord = new Record(new Person());
		Criteria criteria = new Criteria(PERSON_ID, OP.IN, personId);
		List<Person> splitPersons = personDao.getList(criteria, getPersonProperties());
		for (Person person : splitPersons) {
			Map<String, Object> map = new HashMap<>();
			map.put(PMPI_ID, pmpiId);
			map.put(PERSON_ID, person.getPersonId());
			map.put("updateTime", updateTime);
			map.put("operateType", OperateType.split.getName());
			map.put("updatePerson", operator);
			updateMapList.add(map);
			if (oldPmpiId == null) {
				oldPmpiId = person.getPmpiId();
			}
			Map<String, Object> changedValue = getChangedValue(bestRecord, new Record(person), getBestRecordProperties());
			bestRecord.putAll(changedValue);
		}
		bestRecord.put(PMPI_ID, pmpiId);

		//do database update
		String[] updateProp = {PMPI_ID, "updateTime", "operateType", "updatePerson"};
		personDao.batchMapUpdate(updateMapList, updateProp);
		bestRecordDao.insert(bestRecord.getMap(), getBestRecordProperties());
		// update old best record
		updateAfterSplit(oldPmpiId);
		return updateMapList.size();
	}
	
	@Override
	public Person getBestRecord(String pmpiId) {
		return bestRecordDao.get(new Criteria("pmpiId", pmpiId), getBestRecordProperties());
	}
	
	@Override
	public Person getPerson(Long personId) {
		return personDao.get(new Criteria("personId", personId), getPersonProperties());
	}

	@Override
	public List<Person> getPersons(Criteria criteria) {
		return personDao.getList(criteria, getPersonProperties());
	}
	
	@Override
	public List<Person> queryPerson(Criteria criteria) {
		List<Person> persons = bestRecordDao.getList(criteria, getBestRecordProperties());
		if (ObjectUtil.isNullOrEmpty(persons)) {
			persons = bestRecordDao.queryBestRecord(criteria, getBestRecordProperties());
		}
		return persons;
	}
	
	@Override
	public PageList<Person> queryPerson(int queryType, Page page, Criteria criteria, String... properties) {
		if (properties == null || properties.length == 0) {
			properties = getBestRecordProperties();
		}
		PageList<Person> list = null;
		if (criteria == null || queryType == 1 ) {
			list = bestRecordDao.getPageList(page, criteria, properties);
		}
		if (ObjectUtil.isNullOrEmpty(list) || ObjectUtil.isNullOrEmpty(list.getList()) || queryType == 2 ) {
			list = bestRecordDao.queryBestRecord(page, criteria, properties);
		}
		return list;
	}

	@Override
	public List<Person> crossQueryId(Criteria condition, String targetDomain) {
		Map<String, Object> target = new HashMap<>();
		target.put(DOMAIN_ID, targetDomain);
		target.put(LOCAL_ID, null);
		target.put(PMPI_ID, null);
		return personDao.crossQuery(condition, target);
	}
	
	@Override
	public Person findOldPerson(String domainId, String localId) {
		if (StringUtil.isNotEmpty(domainId) && StringUtil.isNotEmpty(localId)) {
			Criteria criteria = new Criteria();
			criteria.add(DOMAIN_ID, domainId);
			criteria.add(LOCAL_ID, localId);
			return personDao.get(criteria, getPersonProperties());
		}
		return null;
	}
	
	@Override
	public Object compareOldPerson(Person oldPerson, Person person) {
		Map<String, Object> changedValue = getChangedValue(new Record(oldPerson), new Record(person), getBestRecordProperties());
		if (changedValue.size() > 0) {
			changedValue.put(PMPI_ID, oldPerson.getPmpiId());
			//Map<String, Object> changedValue1 = getChangedValue(new Record(oldPerson), new Record(person), getPersonProperties());
			Map<String, Object> changedValue1 = new Record(person).getMap();
			changedValue1.put(PERSON_ID, oldPerson.getPersonId());
			changedValue1.put(PMPI_ID, oldPerson.getPmpiId());
			List<Map<String, Object>> changedValues = new ArrayList<>();
			changedValues.add(changedValue1);
			changedValues.add(changedValue);
			return changedValues;
		}
		person.setPersonId(oldPerson.getPersonId());
		person.setPmpiId(oldPerson.getPmpiId());
		return person;
	}
	
	@Override
	public List<Person> getLinkPersons(String pmpiId) {
		Criteria criteria = new Criteria("pmpiId", pmpiId);
		return personDao.getList(criteria, getPersonProperties());
	}
	
	@Override
	public PageList<Person> getPersonLogs(Page page, Long personId) {
		return personDao.getPersonLogs(page, personId, getPersonProperties());
	}
	
	@Override
	public Person getPersonLog(Long personId, Long updateTime) {
		Person person =  personDao.getPersonLog(personId, updateTime, getPersonProperties());
		if (person == null) {
			person = getPerson(personId);
		}
		return person;
	}
	
	private int  updateBestRecordInfo(Person bestRecord, Person person) {
		BeanMap beanMap = BeanMap.create(bestRecord);
		Map<String, Object> changedValue = getChangedValue(new Record(bestRecord), new Record(person), getBestRecordProperties());
		changedValue.remove(PMPI_ID);
		if (changedValue.size() > 0) {
			changedValue.put(PMPI_ID, bestRecord.getPmpiId());
			Set<Entry<String, Object>> entrySet = changedValue.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				beanMap.put(entry.getKey(), entry.getValue());
			}
			return bestRecordDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
		}
		return 0;
	}

	private String[] getBestRecordProperties() {
		if (BEST_RECORD_PROPERTIES == null) {
			BEST_RECORD_PROPERTIES = mdmConfigService.getEntityProperties(EntityType.BESTRECORD);
		}
		return BEST_RECORD_PROPERTIES;
	}
	
	private String[] getPersonProperties() {
		if (PERSON_PROPERTIES == null) {
			PERSON_PROPERTIES = mdmConfigService.getEntityProperties(EntityType.PERSON);
		}
		return PERSON_PROPERTIES;
	}
	
	private String[] mergeProperties(String[] prop, String... newProp) {
		int length = prop.length + newProp.length;
		String[] properties = new String[length];
		System.arraycopy(prop, 0, properties, 0, prop.length);
		System.arraycopy(newProp, 0, properties, prop.length, newProp.length);
		return properties;
	}
	
	private String generatePmpiId() {
		return String.format("%010d", bestRecordDao.getSequenceNextVal("SEQ_BI_BEST_RECORD", Long.class));
	}

	private void updateAfterSplit(String... pmpiId) {
		if (pmpiId == null || pmpiId.length == 0) {
			return;
		}
		Map<String, Map<String, Object>> updates = new HashMap<>();
		List<Person> list = personDao.getList(new Criteria(PMPI_ID, OP.IN, pmpiId), new Order("UPDATE_TIME"));
		for (Person person : list) {
			String pid = person.getPmpiId();
			Record newBestRecord = new Record();
			Map<String, Object> valueMap = updates.get(pid);
			if (valueMap != null) {
				newBestRecord.putAll(valueMap);
			}
			newBestRecord.putAll(getChangedValue(newBestRecord, new Record(person), getBestRecordProperties()));
			updates.put(pid, newBestRecord.getMap());
		}
		List<Map<String, Object>> updateList = new ArrayList<>(updates.values());
		bestRecordDao.batchMapUpdate(updateList, getBestRecordProperties());

//		List<Person> remainPersons = personDao.getList(new Criteria(PMPI_ID, pmpiId), new Order("UPDATE_TIME"));
//		Record newBestRecord = new Record();
//		for (Person person : remainPersons) {
//			newBestRecord.putAll(getChangedValue(newBestRecord, new Record(person), getBestRecordProperties()));
//		}
//		bestRecordDao.update(newBestRecord.getMap(), getBestRecordProperties());
	}
}
