package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.IDmHighriskPersonInfoDao;
import com.founder.rhip.ehr.repository.management.IDmPersonInfoDao;
import com.founder.rhip.ehr.repository.management.IDmTumorFollowupDao;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IModifyTraceService;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 慢病人员通用方法
 * 
 * @author liuk
 * 
 */
@Service("cdmPersonService")
public class CdmPersonServiceImpl extends AbstractService implements ICdmPersonService, IPersonRecordMoveService, IMergerTownListener {

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@Resource(name = "healthEventService")
	private IHealthEventService healthEventService;

	@Resource(name = "dmPersonInfoDao")
	private IDmPersonInfoDao dmPersonInfoDao;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao dmDiseaseInfoDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "dmTumorFollowupDao")
	private IDmTumorFollowupDao dmTumorFollowupDao;

	@Resource
	private IDmHighriskPersonInfoDao dmHighriskPersonInfoDao;

	@Autowired
	private IModifyTraceService modifyTraceService;

	// 更新慢病人员信息用
	private final String[] dmPersonUpdateProperties = new String[] { "name", "idcard", "birthday", "gender", "marriage", "education", "occupation", "nation", "householdType", "phoneNumber", "pastreet", "patownShip", "paGroup","pahouseNumber", "hrstreet",
			"hrtownShip", "hrGroup", "hrhouseNumber", "unitName", "paAddress", "hrAddress", "inputOrganName", "inputOrganCode","otherNationDesc" };
	private final String[] personUpdateProperties = new String[] { "name", "idcard", "birthday", "gender", "marriage", "education", "occupation", "nation", "householdType", "phoneNumber", "pastreet", "patownShip", "paGroup","pahouseNumber", "hrstreet",
			"hrtownShip", "hrGroup", "hrhouseNumber", "unitName", "paAddress", "hrAddress","otherNationDesc" };

	@Override
	public PersonalBasicInfoDTO getPersonBasicInfo(Long personId) {
		Criteria cri = new Criteria();
		cri.add("personId", personId);
		cri.add("ehrType", EventType.PERSON_RECORD_BASIC_INFO.getCode());
		EHRHealthEvent healthEvent = healthEventService.getEHRHealthEvent(cri);
		PersonalBasicInfoDTO result = null;
		if (ObjectUtil.isNotEmpty(healthEvent)) {
			result = new PersonalBasicInfoDTO();
			Criteria criSearch = new Criteria();
			String ehrId = healthEvent.getEhrId();
			criSearch.add("ehrId", ehrId);
			PersonInfo personInfo = personInfoDao.get(new Criteria("id", personId));
			result.setPersonInfo(personInfo);
			// 过敏史
			personalRecordManagmentService.getDrugAllergyHistoryList(result, criSearch);
			// 既往疾病史
			personalRecordManagmentService.getDiseaseHistoryList(result, criSearch);
			// 既往手术史
			personalRecordManagmentService.getSurgeryHistoryList(result, criSearch);
			// 外伤史
			personalRecordManagmentService.getTraumaHistoryList(result, criSearch);
			// 输血史
			personalRecordManagmentService.getTransBloodHistoryList(result, criSearch);

			// 家族史
			personalRecordManagmentService.getFamilyHistory(result, criSearch);
		}
		return result;
	}

	@Override
	public PhysiqueExamination getPersonPhyExamination(Long personId) {
		return getPhyExamWithSeletedProperties(personId, new String[] {});
	}

	@Override
	public PhysiqueExamination getPhyExamWithSeletedProperties(Long personId, String[] pros) {
		EHRHealthEvent ehrHealthEvent = healthEventService.getEHRHealthEvent(new Criteria("personId", personId).add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode()));
		PhysiqueExamination phyExam = null;
		if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
			String ehrId = ehrHealthEvent.getEhrId();
			Criteria ca = new Criteria("personId", personId).add("ehrId", ehrId);
			phyExam = physiqueExaminationDao.get(ca, pros);
		}
		return phyExam;
	}

	@Override
	public void saveOrUpdatePerson(PersonInfo personInfo, User user, Organization organization) {
		Assert.notNull(personInfo, "人员信息不能为空");
		Assert.notNull(user, "登录用户信息不能为空");
		Assert.notNull(organization, "登录用户所在机构信息不能为空");
		doCreateOrUpdatePerson(personInfo, user, organization);
	}

	@Override
	public void saveOrUpdatePersonAsyn(PersonInfo personInfo, User user, Organization organization) {
		Assert.notNull(personInfo, "人员信息不能为空");
		Assert.notNull(user, "登录用户信息不能为空");
		Assert.notNull(organization, "登录用户所在机构信息不能为空");
		doCreateOrUpdatePersonAsyn(personInfo, user, organization);
	}

	@Override
	public Long createOrUpdatePersonUseDmPersonInfo(DmPersonInfo dmPersonInfo, User user, Organization organization) {
		Assert.notNull(dmPersonInfo, "慢病人员信息不能为空");
		Long personId = dmPersonInfo.getPersonId();
		PersonInfo person = new PersonInfo();
		dmPersonInfoToEhrPersonInfo(dmPersonInfo, person);//
		person.setId(personId);// id赋值
		// 如果已经持有personId,则更新信息,否则根据慢病人员信息在健康档案创建一个人员
		doCreateOrUpdatePerson(person, user, organization);
		personId = person.getId();// 取得最新的id
		dmPersonInfo.setPersonId(personId);
		return personId;
	}

	private void doCreateOrUpdatePerson(PersonInfo person, User user, Organization organization) {
		Long personId = person.getId();
		buildPersonInfoAddress(true, true, person);// 计算详细地址
		if (ObjectUtil.isNullOrEmpty(personId)) {
			person.setId(null);
			setPersonInputInfo(person, user, organization);
			String personIdString = platformService.createPerson(person, EHRConstants.RETURN_PERSON_ID, false);
			try {
				personId = Long.parseLong(personIdString);
			} catch (Exception e) {
				log.error("健康档案人员创建失败,无法获取到id", e);
			}
			Assert.notNull(personId, "健康档案人员创建后id无法获取");
			person.setId(personId);
		} else {
			updatePersonWithCheck(person, user, organization);
		}
	}

	private void doCreateOrUpdatePersonAsyn(PersonInfo person, User user, Organization organization) {
		Long personId = person.getId();
		if (ObjectUtil.isNullOrEmpty(personId)) {
			person.setId(null);
			// buildPersonInfoAddress(true, true, person);// 计算详细地址
			setPersonInputInfo(person, user, organization);
			String personIdString = platformService.createPerson(person, EHRConstants.RETURN_PERSON_ID, false);
			try {
				personId = Long.parseLong(personIdString);
			} catch (Exception e) {
				log.error("健康档案人员创建失败,无法获取到id", e);
			}
			Assert.notNull(personId, "健康档案人员创建后id无法获取");
			person.setId(personId);
		} else {
			updatePersonWithCheckAsyn(person, user, organization);
		}
	}

	@Override
	public void updateDmPersonInfo(Parameters parameters, Criteria criteria) {
		dmPersonInfoDao.update(parameters, criteria);
	}

	/**
	 * 修改人的信息,并检查是否修改
	 * 
	 * @param personInfo
	 */
	private void updatePersonWithCheckAsyn(PersonInfo personInfo, User user, Organization organization) {
		Assert.notNull(personInfo, "待更新人员为空");
		Long start = System.currentTimeMillis();
		String orgcode = organization.getOrganCode();
		String orgName = organization.getOrganName();
		String idcard = user.getIdentityCard();
		String name = user.getName();
		Set<String> updatePros = new HashSet<>(Arrays.asList(personUpdateProperties));

		if (ObjectUtil.isNotEmpty(orgcode)) {
			personInfo.setUpdateOrganCode(orgcode);
			updatePros.add("updateOrganCode");
		}
		if (ObjectUtil.isNotEmpty(orgName)) {
			personInfo.setUpdateOrganName(orgName);
			updatePros.add("updateOrganName");
		}
		if (ObjectUtil.isNotEmpty(idcard)) {
			personInfo.setUpdateIdcard(idcard);
			updatePros.add("updateIdcard");
		}
		if (ObjectUtil.isNotEmpty(name)) {
			personInfo.setUpdateName(name);
			updatePros.add("updateName");
		}

		if (!ObjectUtil.isNullOrEmpty(personInfo.getFirstGuardian())) {
		    updatePros.add("firstGuardian");
        }

        if (!ObjectUtil.isNullOrEmpty(personInfo.getGuardianPhoneOne())) {
            updatePros.add("guardianPhoneOne");
        }

		if (!ObjectUtil.isNullOrEmpty(personInfo.getGuardianPhoneTwo())) {
            updatePros.add("guardianPhoneTwo");
        }

        if(ObjectUtil.isNotEmpty(personInfo.getPopulationCategory())) {
			updatePros.add("populationCategory");
		}

		personInfo.setUpdateDate(new Date());
		updatePros.add("updateDate");

		platformService.updatePersonInfoAsyn(personInfo, updatePros.toArray(new String[updatePros.size()]));
		if (log.isDebugEnabled()) {
			log.debug("===============人员修改耗时:" + (System.currentTimeMillis() - start));
		}
	}

	private void setPersonInputInfo(PersonInfo person, User user, Organization organization) {
		String orgcode = organization.getOrganCode();
		String orgName = organization.getOrganName();
		String idcard = user.getIdentityCard();
		String name = user.getName();
		if (ObjectUtil.isNotEmpty(orgcode)) {
			person.setUpdateOrganCode(orgcode);
			// person.setInputOrganCode(orgcode);
		}
		if (ObjectUtil.isNotEmpty(orgName)) {
			person.setUpdateOrganName(orgName);
			// person.setInputOrganName(orgName);
		}
		if (ObjectUtil.isNotEmpty(idcard)) {
			person.setUpdateIdcard(idcard);
			person.setInputIdcard(idcard);
		}
		if (ObjectUtil.isNotEmpty(name)) {
			person.setUpdateName(name);
			person.setInputName(name);
		}
		Date date = new Date();
		person.setUpdateDate(date);
		person.setInputDate(date);
	}

	/**
	 * 修改人的信息,并检查是否修改
	 * 
	 * @param personInfo
	 */
	private void updatePersonWithCheck(PersonInfo personInfo, User user, Organization organization) {
		Assert.notNull(personInfo, "待更新人员为空");
		Long start = System.currentTimeMillis();
		String orgcode = organization.getOrganCode();
		String orgName = organization.getOrganName();
		String idcard = user.getIdentityCard();
		String name = user.getName();
		Set<String> updatePros = new HashSet<>(Arrays.asList(personUpdateProperties));

		if (ObjectUtil.isNotEmpty(orgcode)) {
			personInfo.setUpdateOrganCode(orgcode);
			updatePros.add("updateOrganCode");
		}
		if (ObjectUtil.isNotEmpty(orgName)) {
			personInfo.setUpdateOrganName(orgName);
			updatePros.add("updateOrganName");
		}
		if (ObjectUtil.isNotEmpty(idcard)) {
			personInfo.setUpdateIdcard(idcard);
			updatePros.add("updateIdcard");
		}
		if (ObjectUtil.isNotEmpty(name)) {
			personInfo.setUpdateName(name);
			updatePros.add("updateName");
		}

		personInfo.setUpdateDate(new Date());
		updatePros.add("updateDate");

		//保存封面修改痕迹
		String[] properties = {"name", "birthday", "gender", "marriage", "occupation", "nation", "education", "phoneNumber", "householdType",
				"paAddress", "hrAddress", "unitName"};
		modifyTraceService.executeCover(personInfo, properties);

		platformService.updatePersonInfo(personInfo, updatePros.toArray(new String[updatePros.size()]));
		if (log.isDebugEnabled()) {
			log.debug("===============人员修改耗时:" + (System.currentTimeMillis() - start));
		}
	}

	@Override
	public void saveOrReUpdateDmPersonInfo(DmPersonInfo dmPersonInfo) {
		doSaveOrUpdateDmPersonInfo(dmPersonInfo, true);
	}

	@Override
	public void saveOrUpdateDmPersonInfo(DmPersonInfo dmPersonInfo) {
		doSaveOrUpdateDmPersonInfo(dmPersonInfo, false);
	}

	private void doSaveOrUpdateDmPersonInfo(DmPersonInfo dmPersonInfo, boolean reUpdate) {
		Assert.notNull(dmPersonInfo);
		buildDmPersonInfoAddress(dmPersonInfo);
		if (ObjectUtil.isNotEmpty(dmPersonInfo.getId())) {
			if (reUpdate) {
				dmPersonInfoDao.update(dmPersonInfo);
			} else {
				dmPersonInfoDao.update(dmPersonInfo, dmPersonUpdateProperties);
			}
		} else {
			Number id = dmPersonInfoDao.generatedKey(dmPersonInfo, "ID",null);
			Assert.notNull(id);
			dmPersonInfo.setId(id.longValue());
		}
	}

	private void buildPersonInfoAddress(boolean calPa, boolean calHr, PersonInfo personInfo) {
		if (calHr) {
			String address = doBuildAddress(personInfo.getHrtownShip(), personInfo.getHrstreet(), personInfo.getHrhouseNumber());
			personInfo.setHrAddress(address);
		}
		if (calPa) {
			String address = doBuildAddress(personInfo.getPatownShip(), personInfo.getPastreet(), personInfo.getPahouseNumber());
			personInfo.setPaAddress(address);
		}
	}

	private void buildPersonInfoAddress(boolean calPa, boolean calHr, DmPersonInfo personInfo) {
		if (calHr) {
			String address = doBuildAddress(personInfo.getHrtownShip(), personInfo.getHrstreet(), personInfo.getHrhouseNumber());
			personInfo.setHrAddress(address);
		}
		if (calPa) {
			String address = doBuildAddress(personInfo.getPatownShip(), personInfo.getPastreet(), personInfo.getPahouseNumber());
			personInfo.setPaAddress(address);
		}
	}

	private void buildDmPersonInfoAddress(DmPersonInfo dmPersonInfo) {
		String address = doBuildAddress(dmPersonInfo.getPatownShip(), dmPersonInfo.getPastreet(), dmPersonInfo.getPahouseNumber());
		dmPersonInfo.setPaAddress(address);
		address = doBuildAddress(dmPersonInfo.getHrtownShip(), dmPersonInfo.getHrstreet(), dmPersonInfo.getHrhouseNumber());
		dmPersonInfo.setHrAddress(address);
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
	 * 判断信息是否被修改
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean decToUpdate(Object left, Object right) {
		if (ObjectUtil.isNullOrEmpty(left) && ObjectUtil.isNotEmpty(right)) {
			return true;
		}
		if (ObjectUtil.isNotEmpty(left) && !left.equals(right)) {
			return true;
		}
		return false;
	}

	/**
	 * 慢病人员信息属性拷贝到健康档案人员信息
	 * 
	 * @param dmPersonInfo
	 * @param personInfo
	 */
	@Override
	public void dmPersonInfoToEhrPersonInfo(DmPersonInfo dmPersonInfo, PersonInfo personInfo) {
		try {
			personInfo.setIdcard(dmPersonInfo.getIdcard());
			personInfo.setName(dmPersonInfo.getName());
			personInfo.setBirthday(dmPersonInfo.getBirthday());
			personInfo.setNation(dmPersonInfo.getNation());
			personInfo.setOtherNationDesc(dmPersonInfo.getOtherNationDesc());
			personInfo.setGender(dmPersonInfo.getGender());
			personInfo.setOccupation(dmPersonInfo.getOccupation());
			personInfo.setMarriage(dmPersonInfo.getMarriage());
			personInfo.setEducation(dmPersonInfo.getEducation());
			personInfo.setPhoneNumber(dmPersonInfo.getPhoneNumber());
			personInfo.setHouseholdType(dmPersonInfo.getHouseholdType());
			personInfo.setHrprovince(dmPersonInfo.getHrprovince());
			personInfo.setHrcity(dmPersonInfo.getHrcity());
			personInfo.setHrcounty(dmPersonInfo.getHrcounty());
			personInfo.setHrtownShip(dmPersonInfo.getHrtownShip());
			personInfo.setHrstreet(dmPersonInfo.getHrstreet());
			personInfo.setHrGroup(dmPersonInfo.getHrGroup());
			personInfo.setHrhouseNumber(dmPersonInfo.getHrhouseNumber());
			personInfo.setHrpostCode(dmPersonInfo.getHrpostCode());
			personInfo.setPaprovince(dmPersonInfo.getPaprovince());
			personInfo.setPacity(dmPersonInfo.getPacity());
			personInfo.setPacounty(dmPersonInfo.getPacounty());
			personInfo.setPatownShip(dmPersonInfo.getPatownShip());
			personInfo.setPastreet(dmPersonInfo.getPastreet());
			personInfo.setPaGroup(dmPersonInfo.getPaGroup());
			personInfo.setPahouseNumber(dmPersonInfo.getPahouseNumber());
			personInfo.setPapostCode(dmPersonInfo.getPapostCode());
			personInfo.setUnitName(dmPersonInfo.getUnitName());
			personInfo.setInputOrganCode(dmPersonInfo.getCreateOrganCode());
			personInfo.setUpdateOrganCode(dmPersonInfo.getUpdateOrganCode());
			personInfo.setInputDate(dmPersonInfo.getCreateDate());
			personInfo.setUpdateDate(dmPersonInfo.getUpdateDate());
		} catch (Exception e) {
			log.error("人员信息获取出错", e);
			throw new RuntimeException("人员信息获取出错", e);
		}
	}

	/**
	 * 健康档案人员信息 拷贝到 慢病人员信息属性
	 * 
	 * @param dmPersonInfo
	 * @param personInfo
	 */
	@Override
	public void ehrPersonInfoToDmPersonInfo(DmPersonInfo dmPersonInfo, PersonInfo personInfo) {
		try {
			dmPersonInfo.setIdcard(personInfo.getIdcard());
			dmPersonInfo.setName(personInfo.getName());
			dmPersonInfo.setBirthday(personInfo.getBirthday());
			dmPersonInfo.setNation(personInfo.getNation());
			dmPersonInfo.setGender(personInfo.getGender());
			dmPersonInfo.setOccupation(personInfo.getOccupation());
			dmPersonInfo.setMarriage(personInfo.getMarriage());
			dmPersonInfo.setEducation(personInfo.getEducation());
			dmPersonInfo.setPhoneNumber(personInfo.getPhoneNumber());
			dmPersonInfo.setHouseholdType(personInfo.getHouseholdType());
			dmPersonInfo.setHrprovince(personInfo.getHrprovince());
			dmPersonInfo.setHrcity(personInfo.getHrcity());
			dmPersonInfo.setHrcounty(personInfo.getHrcounty());
			dmPersonInfo.setHrtownShip(personInfo.getHrtownShip());
			dmPersonInfo.setHrstreet(personInfo.getHrstreet());
			dmPersonInfo.setHrhouseNumber(personInfo.getHrhouseNumber());
			dmPersonInfo.setHrpostCode(personInfo.getHrpostCode());
			dmPersonInfo.setPaprovince(personInfo.getPaprovince());
			dmPersonInfo.setPacity(personInfo.getPacity());
			dmPersonInfo.setPacounty(personInfo.getPacounty());
			dmPersonInfo.setPatownShip(personInfo.getPatownShip());
			dmPersonInfo.setPastreet(personInfo.getPastreet());
			dmPersonInfo.setPahouseNumber(personInfo.getPahouseNumber());
			dmPersonInfo.setPapostCode(personInfo.getPapostCode());
			dmPersonInfo.setUnitName(personInfo.getUnitName());
			dmPersonInfo.setInputOrganCode(personInfo.getInputOrganCode());
			dmPersonInfo.setInputOrganName(personInfo.getInputOrganName());
		} catch (Exception e) {
			log.error("人员信息获取出错", e);
			throw new RuntimeException("人员信息获取出错", e);
		}
	}

	// ==========IMergerTownListener乡镇合并 接口实现start=============//

	@Override
	@Transactional
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		Assert.hasText(newTownCode, "合并后的镇编码为空");
		Assert.notEmpty(oldTownCode, "需要和并的镇编码为空");

		// 户籍
		Criteria criteria = new Criteria("hrtownShip", OP.IN, oldTownCode);
		criteria.add("householdType", EHRConstants.HOUSE_HOLDER);// 只有户籍类型需要更新
		Parameters parameters = new Parameters("hrtownShip", newTownCode);
		HistoryRecorder.record(DmPersonInfo.class, dmPersonInfoDao, criteria, new String[] { "id", "hrtownShip" });
		dmPersonInfoDao.update(parameters, criteria);

		// 现住址
		criteria = new Criteria("patownShip", OP.IN, oldTownCode);
		parameters = new Parameters("patownShip", newTownCode);
		HistoryRecorder.record(DmPersonInfo.class, dmPersonInfoDao, criteria, new String[] { "id", "patownShip" });
		dmPersonInfoDao.update(parameters, criteria);

		// 高危人群
		HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "patownShip" });
		dmHighriskPersonInfoDao.update(parameters, criteria);

		criteria = new Criteria("createGbcode", OP.IN, oldTownCode);
		parameters = new Parameters("createGbcode", newTownCode);
		HistoryRecorder.record(DmPersonInfo.class, dmPersonInfoDao, criteria, new String[] { "id", "createGbcode" });
		dmPersonInfoDao.update(parameters, criteria);

		HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "createGbcode" });
		dmHighriskPersonInfoDao.update(parameters, criteria);

		// 肿瘤随访
		criteria = new Criteria("fltownShip", OP.IN, oldTownCode);
		parameters = new Parameters("fltownShip", newTownCode);
		dmTumorFollowupDao.update(parameters, criteria);

	}

	@Override
	@Transactional
	public void sendTownVillageRelation(String newTownCode, String[] newAddVillageCodes) {

		Assert.hasText(newTownCode, "需要迁移到的镇编码为空");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的社区编码为空");

		Criteria criteria = new Criteria("hrstreet", OP.IN, newAddVillageCodes);
		Parameters parameters = new Parameters("hrtownShip", newTownCode);
		criteria.add("householdType", EHRConstants.HOUSE_HOLDER);// 只有户籍类型需要更新
		HistoryRecorder.record(DmPersonInfo.class, dmPersonInfoDao, criteria, new String[] { "id", "hrstreet", "hrtownShip" });
		dmPersonInfoDao.update(parameters, criteria);

		criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		parameters = new Parameters("patownShip", newTownCode);
		HistoryRecorder.record(DmPersonInfo.class, dmPersonInfoDao, criteria, new String[] { "id", "pastreet", "patownShip" });
		dmPersonInfoDao.update(parameters, criteria);

		// 高危人群
		HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "patownShip", "pastreet" });
		dmHighriskPersonInfoDao.update(parameters, criteria);

		// 肿瘤随访
		criteria = new Criteria("flstreet", OP.IN, newAddVillageCodes);
		parameters = new Parameters("fltownShip", newTownCode);
		dmTumorFollowupDao.update(parameters, criteria);
	}

	/**
	 * 乡镇合并
	 *
	 */
	@Transactional
	public void mergeTownWithUpdateAddress(String newTownCode, String[] oldTownCode) {
		Assert.hasText(newTownCode, "合并后的镇编码为空");
		Assert.notEmpty(oldTownCode, "需要和并的镇编码为空");
		Set<String> oldTownCodes = new HashSet<>(Arrays.asList(oldTownCode));

		// 建档所在镇 直接更新
		// Criteria criteria = new Criteria("createGbcode", OP.IN, oldTownCode);
		// Parameters parameters = new Parameters("createGbcode", newTownCode);
		// dmPersonInfoDao.update(parameters, criteria);

		// 现住址和户籍地址处理历史数据
		Criteria criteria = new Criteria();
		criteria.add(LOP.OR, "hrtownShip", OP.IN, oldTownCode);
		criteria.add(LOP.OR, "patownShip", OP.IN, oldTownCode);
		int current = 1;
		Page page = new Page(10000, current);
		String[] neededProperties = { "id", "hrtownShip", "patownShip", "Hrstreet", "pastreet", "pahouseNumber", "hrhouseNumber" };
		PageList<DmPersonInfo> ps = dmPersonInfoDao.getPageList(page, criteria, neededProperties);

		if (null != ps) {
			deaTownl(ps.getList(), newTownCode, oldTownCodes);
			while (page.getTotalPages() > current) {
				page.next();
				current = page.getCurrentPage();
				ps = dmPersonInfoDao.getPageList(page, criteria, neededProperties);
				if (null != ps) {
					deaTownl(ps.getList(), newTownCode, oldTownCodes);
				}
			}
		}
	}

	/**
	 * Dea townl.
	 *
	 * @param ps
	 *            the ps
	 * @param newTownCode
	 *            the new town code
	 * @param oldTownCodes
	 *            the old town codes
	 */
	private void deaTownl(List<DmPersonInfo> ps, String newTownCode, Set<String> oldTownCodes) {
		for (DmPersonInfo p : ps) {
			String hrtownShip = p.getHrtownShip();
			String patownShip = p.getPatownShip();
			boolean pa = oldTownCodes.contains(patownShip);
			boolean hr = oldTownCodes.contains(hrtownShip);
			if (pa) {
				p.setPatownShip(newTownCode);
			}
			if (hr) {
				p.setHrtownShip(newTownCode);
			}
			buildPersonInfoAddress(pa, hr, p);
		}
		dmPersonInfoDao.batchUpdate(ps, "hrtownShip", "patownShip", "hrAddress", "paAddress");
	}

	@Transactional
	public void sendTownVillageRelationWithUpdateAddress(String townCode, String[] newAddVillageCodes) {
		Criteria criteria = new Criteria();
		criteria.add(LOP.OR, "Hrstreet", OP.IN, newAddVillageCodes);
		criteria.add(LOP.OR, "pastreet", OP.IN, newAddVillageCodes);
		Set<String> villageCodes = new HashSet<>(Arrays.asList(newAddVillageCodes));
		int current = 1;
		Page page = new Page(10000, current);
		String[] neededProperties = { "id", "hrstreet", "pastreet", "pahouseNumber", "hrhouseNumber" };
		while (true) {
			PageList<DmPersonInfo> ps = dmPersonInfoDao.getPageList(page, criteria, neededProperties);
			if (null == ps) {
				break;
			}
			List<DmPersonInfo> list = ps.getList();
			if (null == list || list.isEmpty()) {
				break;
			}
			dealVillage(ps.getList(), townCode, villageCodes);
			if (page.getCurrentPage() >= page.getTotalPages()) {
				break;
			}
			page.next();

		}

	}

	/**
	 * Deal village.
	 *
	 * @param ps
	 *            the ps
	 * @param townCode
	 *            the town code
	 * @param villageCodes
	 *            the village codes
	 */
	private void dealVillage(List<DmPersonInfo> ps, String townCode, Set<String> villageCodes) {
		for (DmPersonInfo p : ps) {
			String hrstreet = p.getHrstreet();
			String pastreet = p.getPastreet();
			boolean pa = villageCodes.contains(pastreet);
			boolean hr = villageCodes.contains(hrstreet);
			if (pa) {
				p.setPatownShip(townCode);
			}
			if (hr) {
				p.setHrtownShip(townCode);
			}
			buildPersonInfoAddress(pa, hr, p);
		}
		dmPersonInfoDao.batchUpdate(ps, "hrtownShip", "patownShip", "hrAddress", "paAddress");
	}

	// ==========IMergerTownListener乡镇合并 接口实现end=============//

	// ==========IPersonRecordMoveService健康档案迁移 接口实现start=======//
	@Override
	@Transactional
	public void personRecordMove(Long personId, String smpiId, Organization oldOrg, Organization newOrganization) {
		// 慢病档案迁移支持
		// 仅同步慢病管理卡和对应基本信息
		// 慢病管理只需要同步创建机构
		// 基本信息需要同步创建机构和上级和镇的信息
		Assert.notNull(personId, "迁移人员id不能为空");
		Assert.notNull(newOrganization, "迁移目标机构不能为空");
		Assert.notNull(oldOrg, "当前机构不能为空");

		String newOrganCode = newOrganization.getOrganCode();
		Parameters parameters = new Parameters("createOrganCode", newOrganCode);
		parameters.add("createOrganName", newOrganization.getOrganName());
		Criteria criteria = new Criteria("personId", personId);

		// 迁移管理卡
		// HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[] {
		// "id", "createOrganCode" });
		dmDiseaseInfoDao.update(parameters, criteria);
		// 迁移人员基本信息,人员冗余了上级和镇信息,都需要更新
		if(ObjectUtil.equals(newOrganization.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
				ObjectUtil.equals(newOrganization.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())) {
			parameters.add("createCenterOrganCode", newOrganCode);// organCode
			parameters.add("createGbcode", newOrganization.getGbCode()); // 所在镇
		} else {
			parameters.add("createCenterOrganCode", newOrganization.getParentCode());// 站直接取parentCode因为迁移针只对站
			parameters.add("createGbcode", newOrganization.getGbCode()); // 所在镇
		}

		// 高危人群
		// HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new
		// String[] { "id", "createOrganCode", "createCenterOrganCode",
		// "createGbcode" });
		dmHighriskPersonInfoDao.update(parameters, criteria);

		// 只针对管理卡人员信息
		criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		// HistoryRecorder.record(dmPersonInfoDao, criteria, new String[] {
		// "id", "createOrganCode", "createCenterOrganCode", "createGbcode" });
		dmPersonInfoDao.update(parameters, criteria);
	}

	// ==========IPersonRecordMoveService健康档案迁移 接口实现end========//

	@SuppressWarnings("unused")
	@Deprecated
	private void updatePersonWithCheckDp(PersonInfo personInfo, User user, Organization organization) {
		Assert.notNull(personInfo, "待更新人员为空");
		Long start = System.currentTimeMillis();
		PersonInfo old = platformService.queryPersonalInfo(personInfo.getId());
		Assert.notNull(old, "根据指定的人员id无法获取到人员信息 ,id为" + personInfo.getId());

		Long end = System.currentTimeMillis();
		if (log.isDebugEnabled()) {
			log.debug("===============人员查询耗时:" + (end - start));
		}
		// 需要更新字段
		List<String> updatePros = new ArrayList<>();

		// 是否更新详细住址
		boolean isPaNeedUpdate = false;
		boolean isHrNeedUpdate = false;

		/* 身份证只能补充,不能修改 */
		if (ObjectUtil.isNotEmpty(personInfo.getIdcard()) && ObjectUtil.isNullOrEmpty(old.getIdcard())) {
			updatePros.add("idcard");
		}

		if (decToUpdate(personInfo.getName(), old.getName())) {
			updatePros.add("name");
		}

		if (decToUpdate(personInfo.getBirthday(), old.getBirthday())) {
			updatePros.add("birthday");
		}
		if (decToUpdate(personInfo.getGender(), old.getGender())) {
			updatePros.add("gender");
		}
		if (decToUpdate(personInfo.getMarriage(), old.getMarriage())) {
			updatePros.add("marriage");
		}
		if (decToUpdate(personInfo.getEducation(), old.getEducation())) {
			updatePros.add("education");
		}
		if (decToUpdate(personInfo.getOccupation(), old.getOccupation())) {
			updatePros.add("occupation");
		}
		if (decToUpdate(personInfo.getNation(), old.getNation())) {
			updatePros.add("nation");
		}
		if (decToUpdate(personInfo.getHouseholdType(), old.getHouseholdType())) {
			updatePros.add("householdType");
		}
		if (decToUpdate(personInfo.getPhoneNumber(), old.getPhoneNumber())) {
			updatePros.add("phoneNumber");
		}
		if (decToUpdate(personInfo.getPastreet(), old.getPastreet())) {
			updatePros.add("pastreet");
			isPaNeedUpdate = true;
		}
		if (decToUpdate(personInfo.getPatownShip(), old.getPatownShip())) {
			updatePros.add("patownShip");
			isPaNeedUpdate = true;
		}
		if (decToUpdate(personInfo.getPahouseNumber(), old.getPahouseNumber())) {
			updatePros.add("pahouseNumber");
			isPaNeedUpdate = true;
		}
		if (decToUpdate(personInfo.getHrstreet(), old.getHrstreet())) {
			updatePros.add("hrstreet");
			isHrNeedUpdate = true;
		}
		if (decToUpdate(personInfo.getHrtownShip(), old.getHrtownShip())) {
			updatePros.add("hrtownShip");
			isHrNeedUpdate = true;
		}
		if (decToUpdate(personInfo.getHrhouseNumber(), old.getHrhouseNumber())) {
			updatePros.add("hrhouseNumber");
			isHrNeedUpdate = true;
		}
		if (decToUpdate(personInfo.getUnitName(), old.getUnitName())) {
			updatePros.add("unitName");
		}

		if (isHrNeedUpdate) {
			updatePros.add("hrAddress");
		}

		if (isPaNeedUpdate) {
			updatePros.add("paAddress");
		}

		// 计算详细地址
		buildPersonInfoAddress(isPaNeedUpdate, isHrNeedUpdate, personInfo);

		if (updatePros.size() > 0) {
			// 增加更新信息
			String orgcode = organization.getOrganCode();
			String orgName = organization.getOrganName();
			String idcard = user.getIdentityCard();
			String name = user.getName();
			if (ObjectUtil.isNotEmpty(orgcode)) {
				personInfo.setUpdateOrganCode(orgcode);
				updatePros.add("updateOrganCode");
			}
			if (ObjectUtil.isNotEmpty(orgName)) {
				personInfo.setUpdateOrganName(orgName);
				updatePros.add("updateOrganName");
			}
			if (ObjectUtil.isNotEmpty(idcard)) {
				personInfo.setUpdateIdcard(idcard);
				updatePros.add("updateIdcard");
			}
			if (ObjectUtil.isNotEmpty(name)) {
				personInfo.setUpdateName(name);
				updatePros.add("updateName");
			}

			personInfo.setUpdateDate(new Date());
			updatePros.add("updateDate");

			platformService.updatePersonInfo(personInfo, updatePros.toArray(new String[updatePros.size()]));
			if (log.isDebugEnabled()) {
				log.debug("===============人员修改耗时:" + (System.currentTimeMillis() - end));
			}
		}
	}
}
