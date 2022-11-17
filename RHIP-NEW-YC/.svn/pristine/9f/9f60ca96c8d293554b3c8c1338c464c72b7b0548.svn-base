package com.founder.rhip.ehr.service.personal.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.founder.fasf.beans.Parameters;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.DisHistoryDisCode;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoTempDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.summary.IDiseaseHistoryDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.util.EHRUtil;
import com.founder.rhip.mdm.app.CheckException;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IPersonApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Person;

/**
 * Created with IntelliJ IDEA. User: Andy Date: 13-1-28 Time: 下午2:51 To change
 * this template use File | Settings | File Templates.
 */
@Service("platformService")
public class PlatformServiceImpl implements IPlatformService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "personInfoTempDao")
	private IPersonInfoTempDao personInfoTempDao;

	@Resource(name = "personApp")
	private IPersonApp personApp;

	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;

	@Resource(name = "diseaseHistoryDao")
	private IDiseaseHistoryDao diseaseHistoryDao;

	@Autowired
	private IDictionaryApp dictionaryApp;

	/**
	 * 根据用户信息查询并返回个人信息
	 * 
	 * @param personName
	 * @param idCard
	 * @return
	 */
	public PersonInfo queryPersonalInfo(String personName, String idCard) {
		if (StringUtils.isBlank(idCard))
			return null;
		Criteria ca = new Criteria("idcard", idCard);
		if (StringUtils.isNotBlank(personName))
			ca.add("name", personName);
		List<PersonInfo> list = personInfoDao.getList(ca);
		if (null != list && list.size() > 0)
			return list.get(0);
		return null;
	}
	
	public PersonInfo queryPersonalInfoByOtherIdCard(String otherIdCardtype, String otherIdCard) {
		if (StringUtils.isBlank(otherIdCard))
			return null;
		Criteria ca = new Criteria("otherIdcardType", otherIdCardtype).add("otherIdcard", otherIdCard);
		List<PersonInfo> list = personInfoDao.getList(ca);
		if (null != list && list.size() > 0)
			return list.get(0);
		return null;
	}

	/**
	 * 创建个人信息 如果存在则返回已存在人员信息
	 * 
	 * @param personInfo
	 * @param reutnType
	 *            :smpiId || personId 根据前两个类型返回对应值，null时返回smpiId
	 * @return 返回 SmpiId
	 */
	@Transactional
	public synchronized String createPerson(PersonInfo personInfo, String reutnType, boolean integrateData) {
		String result = "";
		try {
			PersonInfo oldPerson = null;
			String idCard = personInfo.getIdcard();
			/* 如果姓名为空则为：无名氏 */
			if (StringUtils.isBlank(personInfo.getName())) {
				personInfo.setName(EHRConstants.NO_PERSON_NAME);
			}

			/* 根据身份证查询居民信息 */
			if (StringUtils.isNotBlank(idCard)) {
				oldPerson = this.queryPersonalInfo(null, idCard);
				if (null != oldPerson) {
					personInfo.setId(oldPerson.getId());
					personInfo.setSmpiId(oldPerson.getSmpiId());
					personInfo = oldPerson;
				}
			}

			setPersonAddress(personInfo, null);

			/* 根据身份证没有查询到用户信息，则注册 */
			if (null == personInfo.getId()) {
				/* 保存至平台PersonInfo表 状态为：未建档 如果没有身份证号状态为：无身份证 */
				personInfo.setFilingFlag(StringUtils.isBlank(idCard) ? EHRConstants.NO_IDCARD : EHRConstants.UN_CREATE);
				Long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台
																								// 并返回ID
				personInfo.setId(personId);

				/* 如果是集成数据过来或者身份证为空，则不注册到MDM库 */
				if (!integrateData && StringUtils.isNotBlank(idCard)) {
					Person p = personApp.registPerson(EHRUtil.getPersonFromPersonInfo(personInfo));
					personInfo.setSmpiId(p.getPmpiId());
					personInfoDao.update(personInfo, "smpiId");
				}
			}

			if (null != reutnType && reutnType.equalsIgnoreCase(EHRConstants.RETURN_PERSON_ID)) {
				result = null == personInfo.getId() ? "" : String.valueOf(personInfo.getId());
			} else {
				result = personInfo.getSmpiId();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		return result;
	}

	@Override
	public PersonInfo queryPersonalInfo(String pixId) {
		if (null == pixId)
			return null;
		List<PersonInfo> personInfos = personInfoDao.getList(new Criteria("smpiId", pixId));
		if (null != personInfos && personInfos.size() > 0)
			return personInfos.get(0);
		return null;
	}

	@Override
	public PersonInfo queryPersonalInfo(Long id) {
		if (null == id)
			return null;
		return personInfoDao.get(new Criteria("id", id));
	}

	/**
	 * 根person对象属性更新对象
	 * 
	 * @param personInfo
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public int updatePersonInfo(PersonInfo personInfo, String... param) {
		int ret = 0;
		ret = updatePerson(personInfo, param);
		// 没有身份证不注册人员
		if (StringUtil.isNotEmpty(personInfo.getIdcard())) {
			try {
				Person newPerson = personApp.registPerson(EHRUtil.getPersonFromPersonInfo(personInfo), EHRUtil.getMDMParameter(param));
				//注册时，返回SMPIID
				if(ObjectUtil.isNotEmpty(newPerson)){
					personInfo.setSmpiId(newPerson.getPmpiId());
				}
			} catch (Exception ex) {
				logger.error("人员修改注册失败,当前人员id为" + personInfo.getId(), ex);
				throw new RuntimeException("注册到mdm失败", ex);
			}
		}
		return ret;
	}
	private int updatePerson (PersonInfo personInfo, String... param){
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			throw new IllegalArgumentException("人员对象为空！");
		}
		PersonInfo p = personInfoDao.get(personInfo.getId());
		Assert.notNull(p, "无法获取待更新人员,指定的人员id为:" + personInfo.getId());

		Set<String> properties = new HashSet<>();

		if (null != param) {
			properties.addAll(Arrays.asList(param));
		}

		setPersonAddress(personInfo, properties);

		/* 根据属性值判断值是否有变化，无变华则执行更新操作 */
//		if (p.equals(personInfo, properties)) {
//			return 1;
//		}

		// 如果原来的filingFlag为4（无身份证），并且更新了身份证，将filingFlag改为0（未建档）
		if (ObjectUtil.equals(p.getFilingFlag(),EHRConstants.NO_IDCARD) && ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
			personInfo.setFilingFlag(EHRConstants.UN_CREATE);
			properties.add("filingFlag");
		}
		param = properties.toArray(new String[properties.size()]);
		return personInfoDao.update(personInfo, param);
	}
	public int updatePersonInfoNoRegist(PersonInfo personInfo, String... param){
		int ret = 0;
		ret = updatePerson(personInfo, param);
		return ret;
	}
	@Transactional
	@Override
	public int updatePersonInfoAsyn(PersonInfo personInfo, String... param) {
		int ret = 0;
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			throw new IllegalArgumentException("人员对象为空！");
		}
		PersonInfo p = personInfoDao.get(personInfo.getId());
		Assert.notNull(p, "无法获取待更新人员,指定的人员id为:" + personInfo.getId());

		Set<String> properties = new HashSet<>();

		if (null != param) {
			properties.addAll(Arrays.asList(param));
		}

		setPersonAddress(personInfo, properties);

		/* 根据属性值判断值是否有变化，无变华则执行更新操作 */
//		if (p.equals(personInfo, properties)) {
//			return 1;
//		}

		// 如果原来的filingFlag为4（无身份证），并且更新了身份证，将filingFlag改为0（未建档）
		if (p.getFilingFlag().equals(EHRConstants.NO_IDCARD) && ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
			personInfo.setFilingFlag(EHRConstants.UN_CREATE);
			properties.add("filingFlag");
		}
		param = properties.toArray(new String[properties.size()]);
		ret = personInfoDao.update(personInfo, param);
		// 没有身份证不注册人员
		if (StringUtil.isNotEmpty(personInfo.getIdcard())) {
			final  PersonInfo personInfoFinal=personInfo;
			final String[] paramFinal=param;
			Thread thread=new Thread(
			new Runnable() {
				public void run() {
					try {
						personApp.registPerson(EHRUtil.getPersonFromPersonInfo(personInfoFinal), EHRUtil.getMDMParameter(paramFinal));
					} catch (Exception ex) {
						logger.error("人员修改注册失败,当前人员id为" + personInfoFinal.getId(), ex);
						//throw new RuntimeException("注册到mdm失败", ex);
					}
				}
			});
			thread.start();
		}
		return ret;
	}

	@Override
	@Transactional
	public String createEhrHealthEvent(EventType type, Long smpiId, Date eventDate, String organCode, String organName) {
		if (type == null || eventDate == null || organCode == null || organName == null)
			return "error:参数信息不可以为空！";
		// TODO 无身份证情况处理
		PersonInfo personInfo = personInfoDao.get(new Criteria("smpiId", smpiId));
		if (null == personInfo)
			return "error:根据smpiId未找到居民信息！";
		String personId = String.valueOf(personInfo.getId());

		Criteria c = new Criteria();
		c.add("ehrType", type.getCode());
		c.add("personId", personId);
		c.add("clinicDate", eventDate);
		c.add("clinicOrganCode", organCode);
		EHRHealthEvent event = ehrHealthEventDao.get(c);
		if (event == null) {
			event = new EHRHealthEvent();
			event.setClinicDate(eventDate);
			event.setPersonId(personInfo.getId());
			event.setAge(DateUtil.getAgeByBirthday(personInfo.getBirthday()) + "岁");
			event.setClinicOrganCode(organCode);
			event.setClinicOrganName(organName);
			event.setEhrType(type.getCode());
			event.setEhrName(type.getName());
			event.setCreateDate(new Date());
			Long eventId = ehrHealthEventDao.generatedKey(event, "ID", null).longValue();
			event.setId(eventId);
		}
		return event.getEhrId();
	}

	/**
	 * 根据条件返回Person Map List
	 * 
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public List<Map<String, Object>> queryPersonalInfoMap(Criteria criteria, String... properties) {
		return queryPersonalInfoMap(criteria, null, properties);
	}

	/**
	 * 根据条件返回Person Map List
	 * 
	 * @param criteria
	 * @param order
	 * @param properties
	 * @return
	 */
	public List<Map<String, Object>> queryPersonalInfoMap(Criteria criteria, Order order, String... properties) {
		return personInfoDao.getMapList(criteria, order, properties);
	}
	
	/** 
	* @Title: queryPersonalInfo 
	* @Description: 查询
	* @param @param criteria
	* @param @return
	* @return PersonInfo
	* @throws 
	*/
	@Override
	public PersonInfo queryPersonalInfo(Criteria criteria) {
		return personInfoDao.get(criteria);
	}

	/**
	 * 
	 * @param personInfo
	 *            公卫平台人员信息
	 * @param returnType
	 *            返回类型，人的Id或者主索引号
	 * @param domainId
	 *            域Id 人所属机构或者域的Id
	 * @param localId
	 *            人员所在机构下面的唯一Id
	 * @return
	 * @throws Exception 
	 * @throws CheckException 
	 */

	@Override
	@Transactional
	public synchronized long createPerson(PersonInfo personInfo, String domainId) {

		Assert.notNull(personInfo);
		Assert.notNull(domainId);
		
		/* 如果姓名为空则为：无名氏 */
		if (StringUtils.isBlank(personInfo.getName())) {
			personInfo.setName(EHRConstants.NO_PERSON_NAME);
		}
		setPersonAddress(personInfo, null);
		
		String idCard = personInfo.getIdcard();
		String otherIdcard = personInfo.getOtherIdcard();
		if (StringUtils.isNotBlank(idCard) || StringUtils.isNotBlank(otherIdcard)) {
			//有证件号
			//Person person = ReflectionUtils.wrapBean(Person.class, personInfo);

			PersonInfo dbPerson = null;
			if (StringUtils.isNotBlank(idCard)) {
				dbPerson = queryPersonalInfo(null, idCard);
			} else {
				dbPerson = queryPersonalInfoByOtherIdCard(personInfo.getOtherIdcardType(), otherIdcard);
			}
			if (dbPerson != null) {
				long personId = dbPerson.getId();
				return personId;
			}

			//personInfo.setFilingFlag(EHRConstants.UN_CREATE);//状态为：未建档
			//long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台并返回ID
			//return personId;
			
			Person person  = EHRUtil.getPersonFromPersonInfoForIntegrateData(personInfo);
			person.setDomainId(domainId);
			if (StringUtils.isNotBlank(otherIdcard)) {
				person.setOtherCardNo(personInfo.getOtherIdcard());
				person.setOtherCardType(personInfo.getOtherIdcardType());
			}
			
			try {
				Person p = personApp.registPerson(person);
				String smpiId = p.getPmpiId();
				personInfo.setSmpiId(smpiId);
			} catch(CheckException e) {
				e.printStackTrace();
				logger.warn("MDM注册人员失败", e);
			} catch(Exception e) {
				logger.warn("MDM注册人员失败", e);
			}
			
			if (StringUtils.isNotBlank(idCard)) {
				personInfo.setFilingFlag(EHRConstants.UN_CREATE);//状态为：未建档
			} else {
				personInfo.setFilingFlag(EHRConstants.NO_IDCARD);//无身份证
			}
			long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台并返回ID
			return personId;
		}
		/* 保存至平台PersonInfo表 如果没有身份证号状态为：无身份证 */
		personInfo.setFilingFlag(EHRConstants.NO_IDCARD);
		long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台并返回ID
		return personId;
	
	}
	@Override
	@Transactional
	public synchronized long createPerson(PersonInfo personInfo, String domainId, String localId) {
		Assert.notNull(personInfo);
		Assert.notNull(domainId);
		Assert.notNull(localId);
		
		/* 如果姓名为空则为：无名氏 */
		if (StringUtils.isBlank(personInfo.getName())) {
			personInfo.setName(EHRConstants.NO_PERSON_NAME);
		}
		setPersonAddress(personInfo, null);
		
		String idCard = personInfo.getIdcard();
		String otherIdcard = personInfo.getOtherIdcard();
		if (StringUtils.isNotBlank(idCard) || StringUtils.isNotBlank(otherIdcard)) {
			//有证件号
			//Person person = ReflectionUtils.wrapBean(Person.class, personInfo);

			PersonInfo dbPerson = null;
			if (StringUtils.isNotBlank(idCard)) {
				dbPerson = queryPersonalInfo(null, idCard);
			} else {
				dbPerson = queryPersonalInfoByOtherIdCard(personInfo.getOtherIdcardType(), otherIdcard);
			}
			if (dbPerson != null) {
				long personId = dbPerson.getId();
				return personId;
			}

			//personInfo.setFilingFlag(EHRConstants.UN_CREATE);//状态为：未建档
			//long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台并返回ID
			//return personId;
			
			Person person  = EHRUtil.getPersonFromPersonInfoForIntegrateData(personInfo);
			person.setDomainId(domainId);
			person.setLocalId(localId);
			if (StringUtils.isNotBlank(otherIdcard)) {
				person.setOtherCardNo(personInfo.getOtherIdcard());
				person.setOtherCardType(personInfo.getOtherIdcardType());
			}
			
			try {
				Person p = personApp.registPerson(person);
				String smpiId = p.getPmpiId();
				personInfo.setSmpiId(smpiId);
			} catch(CheckException e) {
				logger.warn("MDM注册人员失败", e);
			} catch(Exception e) {
				logger.warn("MDM注册人员失败", e);
			}
			
			if (StringUtils.isNotBlank(idCard)) {
				personInfo.setFilingFlag(EHRConstants.UN_CREATE);//状态为：未建档
			} else {
				personInfo.setFilingFlag(EHRConstants.NO_IDCARD);//无身份证
			}
			long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台并返回ID
			return personId;
		}
		/* 保存至平台PersonInfo表 如果没有身份证号状态为：无身份证 */
		personInfo.setFilingFlag(EHRConstants.NO_IDCARD);
		long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue(); // 保存至平台并返回ID
		return personId;
	}

	@Override
	public void saveOrUpdatePersonInfoTemp(PersonInfoTemp personInfoTemp) {
		Long personInfoId = personInfoTemp.getPersonInfoId();
		Criteria criteria = new Criteria("personInfoId", personInfoId);
		PersonInfoTemp t = personInfoTempDao.get(criteria);
		if (ObjectUtil.isNotEmpty(t)) {
			personInfoTemp.setId(t.getId());
			personInfoTempDao.update(personInfoTemp);
		} else {
			personInfoTempDao.insert(personInfoTemp);
		}
	}

	@Override
	public PersonInfoTemp queryPersonalInfoTemp(Long id) {
		if (null == id)
			return null;
		List<PersonInfoTemp> personInfoTemps = personInfoTempDao.getList(new Criteria("personInfoId", id));
		if (null != personInfoTemps && personInfoTemps.size() > 0)
			return personInfoTemps.get(0);
		return null;
	}

	@Override
	public void updatePersonInfoTemp(PersonInfoTemp personInfoTemp) {
		personInfoTempDao.update(personInfoTemp);
	}

	@Override
	public void addDiseaseHistory(Long personId, DisHistoryDisCode disCode, Date confirmationDate) {
		Assert.notNull(personId, "人员Id不能为空");
		Assert.notNull(disCode, "疾病类型不能为空");
		Criteria criteria=new Criteria("personId", personId);
		criteria.add("diseaseCode",disCode.getCode());
		criteria.add("ehrId","0");
		DiseaseHistory diseaseHistory=diseaseHistoryDao.get(criteria,"id");
		if (null!=diseaseHistory) {
			if(null!=confirmationDate){
				diseaseHistory.setConfirmationDate(confirmationDate);
				diseaseHistoryDao.update(diseaseHistory, "confirmationDate");
			}
		}else {
			diseaseHistory = new DiseaseHistory();
			diseaseHistory.setPersonId(personId);
			diseaseHistory.setDiseaseCode(disCode.getCode());
			diseaseHistory.setInputDate(new Date());
			diseaseHistory.setEhrId("0");// TODO 是否需要,当前数据库为必须
			diseaseHistory.setConfirmationDate(null == confirmationDate ? new Date() : confirmationDate);
			diseaseHistory.setDiseaseName(disCode.getName());
			diseaseHistoryDao.insert(diseaseHistory);
		}
	}

	@Override
	public void deleteDiseaseHistory(Long personId, List<DisHistoryDisCode> disCodes) {
		Assert.notNull(personId, "人员Id不能为空");
		Assert.notNull(disCodes, "疾病类型不能为空");
		if(disCodes.size()>0){
			Set<String> codes=new HashSet<>(disCodes.size());
			for (DisHistoryDisCode disHistoryDisCode : disCodes) {
				codes.add(disHistoryDisCode.getCode());
			}
			Criteria criteria=new Criteria("personId", personId);
			criteria.add("diseaseCode",OP.IN,codes);
//			criteria.add("ehrId",'0');
//			diseaseHistoryDao.delete(criteria);
			diseaseHistoryDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1), criteria);
		}
	
	}

    @Override
    @Transactional
    public void deleteNoIdCardPerson(Long personId){
        Assert.notNull(personId, "人员Id不能为空");
        Criteria criteria=new Criteria("id",personId);
        criteria.add("filingFlag",EHRConstants.NO_IDCARD);
        personInfoDao.delete(criteria);
    }
	
	private void buildPersonInfoAddress(PersonInfo personInfo) {
		String hrAddress = doBuildAddress(personInfo.getHrtownShip(), personInfo.getHrstreet(), personInfo.getHrhouseNumber());
		personInfo.setHrAddress(hrAddress);

		String paAddress = "";
		if (ObjectUtil.isNotEmpty(personInfo.getHouseholdType()) && "1".equals(personInfo.getHouseholdType())) {
			paAddress = doBuildAddress(personInfo.getPatownShip(), personInfo.getPastreet(), personInfo.getPahouseNumber());
		} else {
			paAddress = doBuildAddress(null, null, personInfo.getPahouseNumber());
		}

		personInfo.setPaAddress(paAddress);
	}

	private String doBuildAddress(String town, String street, String houseNumber) {
		String townName = "";
		if (ObjectUtil.isNotEmpty(town)) {
			DicItem dicItem = dictionaryApp.queryDicItem(EHRConstants.CS_TOWN_DICT_TYPE, town);
			townName = null == dicItem ? "" : dicItem.getItemName();
		}
		String streetName = "";
		if (ObjectUtil.isNotEmpty(street)) {
			DicItem dicItem = dictionaryApp.queryDicItem(EHRConstants.CS_TOWN_DICT_TYPE, street);
			streetName = null == dicItem ? "" : dicItem.getItemName();
		}
		houseNumber = houseNumber == null ? "" : houseNumber;
		return townName + streetName + houseNumber;
	}

	/**
	 * 设置现住址和户籍地址
	 * 
	 * @param personInfo
	 */
	private void setPersonAddress(PersonInfo personInfo, Set<String> param) {
		buildPersonInfoAddress(personInfo);
		if (ObjectUtil.isNotEmpty(param)) {
			param.add("hrAddress");
			param.add("paAddress");
		}
	}

	@Override
	public void renewDiseaseHistory(Long personId, List<DisHistoryDisCode> disCodes) {
		Assert.notNull(personId, "人员Id不能为空");
		Assert.notNull(disCodes, "疾病类型不能为空");
		if(disCodes.size()>0){
			Set<String> codes=new HashSet<>(disCodes.size());
			for (DisHistoryDisCode disHistoryDisCode : disCodes) {
				codes.add(disHistoryDisCode.getCode());
			}
			Criteria criteria=new Criteria("personId", personId);
			criteria.add("diseaseCode",OP.IN,codes);
//			criteria.add("ehrId",'0');
			diseaseHistoryDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_0), criteria);
		}
	}
}
