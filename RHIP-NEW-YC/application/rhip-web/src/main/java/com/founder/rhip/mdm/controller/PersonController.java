package com.founder.rhip.mdm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonMerge;
import com.founder.rhip.ehr.service.personal.IPersonMergeService;
import com.founder.rhip.mdm.common.CommonUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IDomainService;
import com.founder.rhip.mdm.service.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController extends BaseController{
	
	@Resource(name = "mdmPersonService")
	private IPersonService personService;

	@Resource(name = "mdmDictionaryService")
	private IDictionaryService dictionaryService;

	@Resource(name = "mdmDomainService")
	private IDomainService domainService;
	
	@Resource(name = "personMergeService")
	private IPersonMergeService personMergeService;
	
	
	@RequestMapping("/personManage")
	public String personManage(ModelMap model) {
		PersonSearchForm condition = new PersonSearchForm();
		model.addAttribute("condition", condition);
		return "com.founder.mdm.pmpi.personManage";
	}
	
	@RequestMapping("/personList")
	public String personList(HttpServletRequest request,int indexPage, ModelMap model, PersonSearchForm condition) {
		Page page = super.getPage(request,  indexPage);
		// convert condition to criteria
		Record record = new Record(condition);
		// check domainId and localId
		int queryType = 1;
		if (StringUtil.isNotEmpty(condition.getDomainId()) || StringUtil.isNotEmpty(condition.getLocalId())) {
			queryType = 2;
		}
		Set<Entry<String, Object>> entrySet = record.entrySet();
		Criteria criteria = new Criteria();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (ObjectUtil.isNotEmpty(value)) {
				if (key.equals("idCardType")) {
					if (StringUtil.isNullOrEmpty(condition.getIdCardNo())) {
						continue;
					}
					if (value.equals("01")) {
						criteria.add("idCard", condition.getIdCardNo().toUpperCase());
					} else {
						criteria.add("otherCardType", value);
						criteria.add("otherCardNo", condition.getIdCardNo());
					}
				} else if (key.equals("name")) {
					setNameCriteria(criteria, (String) value, condition.getUseLike(), condition.getUseCpy());
				} else if (!key.equals("idCardNo") && !key.equals("useCpy") && !key.equals("useLike")) {
					criteria.add(key, value);
				}
			}
		}
		
		PageList<Person> list = personService.queryPerson(queryType, page, criteria);
		convertCodeToName(list.getList());
		model.addAttribute("personList", list.getList());
		model.addAttribute("page", list.getPage());
		return "com.founder.mdm.pmpi.personList";
	}
	
	@RequestMapping("/bestRecordInfo")
	public String bestRecordInfo(String pmpiId, ModelMap model) {
		Person person = personService.getBestRecord(pmpiId);
		model.addAttribute("person", person);
		model.addAttribute("detailType", "bestRecord");
		return "com.founder.mdm.pmpi.bestRecordDetail";
	}
	
	@RequestMapping("/personInfo")
	public String personInfo(HttpServletRequest request,Long personId, ModelMap model) {
		Page page = super.getPage(request,  1);
		Person person = personService.getPerson(personId);
		convertCodeToName(person);
		model.addAttribute("person", person);
		model.addAttribute("detailType", "person");
		return "com.founder.mdm.pmpi.personDetail";
	}
	
	@RequestMapping("/linkPersonSearch")
	@ResponseBody
	public List<Person> linkPersonSearch(String pmpiId) {
		List<Person> list = personService.getLinkPersons(pmpiId);
		Map<String, String> genderMap = dictionaryService.getDicItemMapUseCache(new Criteria("dicCode", "GBT226112003"));
		Map<String, String> paMap = dictionaryService.getDicItemMapUseCache(new Criteria("dicCode", "FS990001"));

		for (Person person : list) {
			person.setGender(genderMap.get(person.getGender()));
			person.setPaTownshipStr(paMap.get(person.getPaTownship()));
			person.setPaStreetStr(paMap.get(person.getPaStreet()));
		}
		convertCodeToName(list);
		return list;
	}
	
	@RequestMapping("/personLogList")
	public String getPersonTracks(HttpServletRequest request,int indexPage, ModelMap model, Long personId) {
		Page page = super.getPage(request,  indexPage);
		PageList<Person> logList = personService.getPersonLogs(page, personId);
		List<Person> personList = logList.getList();
		if (ObjectUtil.isNullOrEmpty(personList)) {
			personList = new ArrayList<>();
		}
		convertCodeToName(personList);
		model.addAttribute("logList", personList);
		model.addAttribute("page", logList.getPage());
		return "com.founder.mdm.pmpi.personLogList";
	}
	
	@RequestMapping("/viewLogDetail")
	public String getPersonLog(Long personId, Long updateTime, ModelMap model) {
		Person person = personService.getPersonLog(personId, updateTime);
		if (person == null) {
			Criteria crt = new Criteria();
			crt.add("personId", personId);
			crt.add("updateTime", updateTime);
			List<Person> list = personService.getPersons(crt);
			if (ObjectUtil.isNotEmpty(list)) {
				person = list.get(0);
			}
		}
		convertCodeToName(person);
		model.addAttribute("person", person);
		return "com.founder.mdm.pmpi.personLogDetail";
	}

	@RequestMapping("/compareLogDetail")
	public String compareLogDetail(String params, ModelMap model) {
		String[] compareList = params.split(",");
		Person left;
		Person right;
		if (compareList.length == 1) {
			String[] s = compareList[0].split(":");
			Long personId = Long.parseLong(s[0]);
			Long updateTime = Long.parseLong(s[1]);
			left = personService.getPerson(personId);
			right = personService.getPersonLog(personId, updateTime);
			model.addAttribute("leftName", "最新记录");
			model.addAttribute("rightName", "历史记录(" + printUpdateTime(s[1]) + ")");
		} else {
			String[] s1 = compareList[0].split(":");
			String[] s2 = compareList[1].split(":");
			Long personId1 = Long.parseLong(s1[0]);
			Long updateTime1 = Long.parseLong(s1[1]);
			Long personId2 = Long.parseLong(s2[0]);
			Long updateTime2 = Long.parseLong(s2[1]);
			left = personService.getPersonLog(personId1, updateTime1);
			right = personService.getPersonLog(personId2, updateTime2);
			model.addAttribute("leftName", "记录(" + printUpdateTime(s1[1]) + ")");
			model.addAttribute("rightName", "记录(" + printUpdateTime(s2[1]) + ")");
		}
		convertCodeToName(left);
		convertCodeToName(right);
		model.addAttribute("leftPerson", left);
		model.addAttribute("rightPerson", right);
		return "com.founder.mdm.pmpi.compareDiff";
	}

	@RequestMapping("/mergeConfirm")
	public String mergeConfirm(String pmpiIds, ModelMap model) {
		String[] pids = pmpiIds.split(",");
		Person sbr = personService.getBestRecord(pids[0]);
		model.addAttribute("pids", pmpiIds);
		model.addAttribute("person", sbr);
		return "com.founder.mdm.pmpi.mergeConfirm";
	}

	@RequestMapping("/merge")
	@ResponseBody
	public int merge(String pmpiId, String personIds) {
		String[] ids = personIds.split(",");
		List<Person> persons = personService.getPersons(new Criteria("personId", OP.IN, ids));
		List<PersonMerge> result = new ArrayList<>();
		List<Person> personList = personService.getPersons(new Criteria("pmpiId",pmpiId));
		if (ObjectUtil.isNotEmpty(personList)) {
			String localId = personList.get(0).getLocalId();
			Long mainPersonId = NumberUtil.convert(localId,Long.class);
			String idcard = personList.get(0).getIdCard();
			String operator = getOperator();
			CurrentLoginInfo current = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
			String operatorName = current.getUser().getName(); 
			Date operatorTime = new Date();
			for (Person person : persons) {
				String relationLocalId = person.getLocalId();
				Long relationPersonId = NumberUtil.convert(relationLocalId,Long.class);
				if(mainPersonId.equals(relationPersonId)){
					continue;
				}
				PersonMerge personMerge = new PersonMerge();
				personMerge.setPersonId(mainPersonId);
				personMerge.setIdCard(idcard);
				personMerge.setRelationPersonId(relationPersonId);
				personMerge.setCreateTime(operatorTime);
				personMerge.setCreatorLoginName(operator);
				personMerge.setCreatorName(operatorName);
				result.add(personMerge);

				person.setOperateType(OperateType.merge.getName());
				person.setUpdateTime(getOperatorTime());
				person.setUpdatePerson(operator);
			}
		}
		return personMergeService.mergePerson(result,pmpiId,persons);
	}

	@RequestMapping("/split")
	@ResponseBody
	public int split(String personIds) {
		String[] s = personIds.split(",");
		Long[] ids = new Long[s.length];
		for (int i = 0; i < s.length; i++) {
			ids[i] = Long.parseLong(s[i]);
		}
		return personService.splitPerson(getOperator(), ids);
	}
	
	private Criteria setNameCriteria(Criteria criteria, String personName, String useLike, String useCpy){
		final String personNamekey = "name";
		if (useCpy != null ) {
			String cpy = CommonUtil.getPinYin(personName).toLowerCase();
			Criteria nameCrt = new Criteria();
			if (useLike != null) {
				nameCrt.add(personNamekey, OP.LIKE, personName).add(LOP.OR, "cpy", OP.LIKE, cpy);
			}else {
				nameCrt.add(personNamekey, personName).add(LOP.OR, "cpy", cpy);
			}
			criteria.add(nameCrt);
			return criteria;
		}else if (useLike != null) {
			criteria.add(personNamekey, OP.LIKE, personName);
			return criteria;
		}
		criteria.add(personNamekey, personName);
		return criteria;
	}

	private String printUpdateTime(String updateTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(updateTime.substring(0, 4)).append("-")
				.append(updateTime.substring(4, 6)).append("-")
				.append(updateTime.substring(6, 8)).append(" ")
				.append(updateTime.substring(8, 10)).append(":")
				.append(updateTime.substring(10, 12)).append(":")
				.append(updateTime.substring(12, 14));
		return sb.toString();
	}

	private void convertCodeToName(List<Person> list) {
		Map<String, String> domainMap = domainService.getDomainMapUseCache(null);
		Map<String, String> idCardMap = dictionaryService.getDicItemMapUseCache(new Criteria("dicCode", "CV0201101"));
		for (Person person : list) {
			String name = domainMap.get(person.getDomainId());
			if (name != null) {
				person.setDomainId(name);
			}
			String idCardType = idCardMap.get(person.getOtherCardType());
			if (idCardType != null) {
				person.setOtherCardType(idCardType);
			}
		}
	}

	private void convertCodeToName(Person person) {
		Map<String, String> domainMap = domainService.getDomainMapUseCache(null);
		String name = domainMap.get(person.getDomainId());
		if (name != null) {
			person.setDomainId(name);
		}
	}
	
	public static class PersonSearchForm {
		private String name;
		private String gender;
		private Date birthday;
		private String phoneNumber;
		private String idCardType;
		private String idCardNo;
		private String pmpiId;
		private String domainId;
		private String localId;
		private String useCpy;
		private String useLike;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getIdCardType() {
			return idCardType;
		}
		public void setIdCardType(String idCardType) {
			this.idCardType = idCardType;
		}
		public String getIdCardNo() {
			return idCardNo;
		}
		public void setIdCardNo(String idCardNo) {
			this.idCardNo = idCardNo;
		}
		public String getPmpiId() {
			return pmpiId;
		}
		public void setPmpiId(String pmpiId) {
			this.pmpiId = pmpiId;
		}
		public String getDomainId() {
			return domainId;
		}
		public void setDomainId(String domainId) {
			this.domainId = domainId;
		}
		public String getLocalId() {
			return localId;
		}
		public void setLocalId(String localId) {
			this.localId = localId;
		}
		public String getUseCpy() {
			return useCpy;
		}
		public void setUseCpy(String useCpy) {
			this.useCpy = useCpy;
		}
		public String getUseLike() {
			return useLike;
		}
		public void setUseLike(String useLike) {
			this.useLike = useLike;
		}
	}
}
