/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal.impl;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonMerge;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.ehr.repository.basic.IPersonMergeDao;
import com.founder.rhip.ehr.repository.basic.IPersonMoveInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonMergeService;
import com.founder.rhip.ehr.service.personal.IPersonMoveService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.service.IPersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("personMergeService")
public class PersonMergeServiceImpl extends AbstractService implements IPersonMergeService {

	@Resource(name="personMergeDao")
	private IPersonMergeDao personMergeDao;

	@Resource(name = "mdmPersonService")
	private IPersonService personService;

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;
	@Override
	@Transactional
	public int mergePerson(List<PersonMerge> personMerges,String pmpiId,List<Person> persons) {
		personService.mergePerson(persons, pmpiId);
		return personMergeDao.batchInsert(personMerges);
	}

	@Override
	public List<PersonInfo> getMergePersonList(Long personId) {
		List<PersonInfo> result = new ArrayList<>();
		List<Long> personIds = new ArrayList<>();
		if(ObjectUtil.isNotEmpty(personId)){
			List<PersonMerge> personMerges = personMergeDao.getList(new Criteria("personId",personId),new String[]{"RELATION_PERSON_ID"});
			for(PersonMerge personMerge:personMerges){
				personIds.add(personMerge.getRelationPersonId());
			}
			if(ObjectUtil.isNotEmpty(personIds)) {
				result = personalRecordService.getPersonRecordList(new Criteria("id", OP.IN, personIds.toArray()));
			}
		}
		return result;
	}

	@Override
	public PersonMerge getPersonMerge(Criteria ca) {
		return personMergeDao.get(ca);
	}
}