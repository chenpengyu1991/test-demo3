package com.founder.rhip.mdm;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.service.IPersonService;

@Service("personWebService")
@WebService(serviceName="personWebService")
public class PersonWebService extends BaseWebService implements IPersonWebService {

	@Resource(name = "mdmPersonService")
	private IPersonService personService;
	
	@Override
	public List<Person> query(String idCard, String name) {
		if (StringUtil.isEmpty(idCard) && StringUtil.isEmpty(name)) {
			throw new RuntimeException("参数为空");
		}
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(idCard)) {
			criteria.add("idCard", idCard);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", name);
		}
		List<Person> persons = personService.queryPerson(criteria);
		return persons;
	}

}
