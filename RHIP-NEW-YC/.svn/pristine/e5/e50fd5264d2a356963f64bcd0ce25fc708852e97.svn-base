package com.founder.rhip.ph.service.oh;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.OccupationDiseaseReport;
import com.founder.rhip.ehr.entity.control.oh.OhCompanyInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEmployeeInfo;
import com.founder.rhip.ehr.repository.control.IOccupationDiseaseReportDao;
import com.founder.rhip.ehr.repository.oh.IOhCompanyInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhEmployeeInfoDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service("ohOccPatientService")
public class OccPatientServiceImpl extends AbstractService implements
        IOccPatientService,IMergerTownListener {

	@Resource(name = "ohEmployeeInfoDao")
    IOhEmployeeInfoDao employeeInfoDao;

	@Resource(name = "ohCompanyInfoDao")
    IOhCompanyInfoDao companyInfoDao;

	@Resource(name = "occupationDiseaseReportDao")
    IOccupationDiseaseReportDao occupationDiseaseReportDao;
	
	@Resource(name = "platformService")
	private IPlatformService platformService;
	

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;


	private final String[] personUpdateProperties = new String[] { "name", "birthday", "gender", "education", "phoneNumber",
			"firstGuardian", "guardianPhoneOne", "householdType", "pacounty", "patownShip", "pahouseNumber", "pastreet",
			"paAddress"};
	
	@Override
	public PageList<OhEmployeeInfo> searchEmployeeInfoList(Criteria criteria,
                                                           Page page) {
		return employeeInfoDao.searchEmployeeInfoList(page, criteria);
	}

	@Override
	public Boolean saveEmployeeInfo(OhEmployeeInfo employeeInfo, String opType, User user, Organization organization) {
		int rs = 0;
		createOrUpdatePersonUseDmPersonInfo(employeeInfo, user, organization);
		// 保存
		if (OHConstants.add.equals(opType)) {
			Long id = employeeInfoDao.saveEmployeeInfo(employeeInfo);
			if (id != null) {
				employeeInfo.setId(id);
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(opType)) {
			rs = employeeInfoDao.update(employeeInfo);
		}
		// 删除
		else if (OHConstants.del.equals(opType)) {
			rs = employeeInfoDao.update(employeeInfo, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}
	
	private Long createOrUpdatePersonUseDmPersonInfo(OhEmployeeInfo employeeInfo, User user, Organization organization) {
		Assert.notNull(employeeInfo, "职业病人员信息不能为空");
		PersonInfo person = new PersonInfo();
		employeeInfoToEhrPersonInfo(employeeInfo, person);//
		// 如果已经持有personId,则更新信息,否则根据慢病人员信息在健康档案创建一个人员
		doCreateOrUpdatePerson(person, user, organization);
		Long personId = person.getId();// 取得最新的id
		return personId;
	}
	/**
	 * 职业病人员信息属性拷贝到健康档案人员信息
	 *
	 * @param employeeInfo
	 * @param personInfo
	 */
	private void employeeInfoToEhrPersonInfo(OhEmployeeInfo employeeInfo, PersonInfo personInfo) {
		try {
			personInfo.setIdcard(employeeInfo.getIdcard());
			personInfo.setName(employeeInfo.getName());
			personInfo.setBirthday(employeeInfo.getBirthdate());
			personInfo.setGender(employeeInfo.getGender());
			personInfo.setEducation(employeeInfo.getEducation());
			personInfo.setPhoneNumber(employeeInfo.getMobile());
			personInfo.setHomePhone(employeeInfo.getPhone());
			personInfo.setFirstGuardian(employeeInfo.getContactName());
			personInfo.setGuardianPhoneOne(employeeInfo.getContactPhone());
			personInfo.setHouseholdType(employeeInfo.getHouseholdType());
			personInfo.setPacity(employeeInfo.getPacity());
			personInfo.setPacounty(employeeInfo.getPacounty());
			personInfo.setPatownShip(employeeInfo.getPatownShip());
			personInfo.setPastreet(employeeInfo.getPastreet());
			personInfo.setPahouseNumber(employeeInfo.getPahouseNumber());
			personInfo.setInputOrganCode(employeeInfo.getCreateOrganCode());
			personInfo.setUpdateOrganCode(employeeInfo.getUpdateOrganCode());
			personInfo.setInputDate(employeeInfo.getCreateTime());
			personInfo.setUpdateDate(employeeInfo.getUpdateTime());
		} catch (Exception e) {
			log.error("人员信息获取出错", e);
			throw new RuntimeException("人员信息获取出错", e);
		}
	}

	private void doCreateOrUpdatePerson(PersonInfo person, User user, Organization organization) {
		PersonInfo oldPersonInfo = platformService.queryPersonalInfo(new Criteria("idcard", person.getIdcard()));
		Long personId = person.getId();
		if (ObjectUtil.isNullOrEmpty(oldPersonInfo)) {
			person.setId(null);
			buildPersonInfoAddress(true, true, person);// 计算详细地址
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
			person.setId(oldPersonInfo.getId());
			updatePersonWithCheck(person, user, organization);
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

		platformService.updatePersonInfo(personInfo, updatePros.toArray(new String[updatePros.size()]));
		if (log.isDebugEnabled()) {
			log.debug("===============人员修改耗时:" + (System.currentTimeMillis() - start));
		}
	}


	@Override
	public OhEmployeeInfo searchEmployeeInfo(Criteria criteria) {
		return employeeInfoDao.searchEmployeeInfo(criteria);
	}

	@Override
	public Boolean saveCompanyInfo(OhCompanyInfo companyInfo, String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			Number keyId= companyInfoDao.generatedKey(companyInfo,"id",null);
			if(keyId==null)
				rs=0;
			else{
				companyInfo.setId(keyId.longValue());
				rs=1;
			}
		}
		// 修改
		else if (OHConstants.edit.equals(opType)) {
			rs = companyInfoDao.update(companyInfo);
		}
		// 删除
		else if (OHConstants.del.equals(opType)) {
			rs = companyInfoDao.update(companyInfo, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public OhCompanyInfo searchCompanyInfo(Criteria criteria) {
		return companyInfoDao.searchCompanyInfo(criteria);
	}

	@Override
	public Boolean verifyEmployeeInfo(OhEmployeeInfo employeeInfo,
			Long[] idArr, String opType) {
		employeeInfo.setVerifyState(opType);
		int rs = 0;
		for (Long id : idArr) {
			employeeInfo.setId(id);
			rs = employeeInfoDao.update(employeeInfo, "updateTime", "updateBy",
					"verifyState", "verifier", "verifyDate");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public Boolean resetVerifyState(OhEmployeeInfo employeeInfo) {
//		OhEmployeeInfo employeeInfo = new OhEmployeeInfo();
		//重置未审核状态
		employeeInfo.setVerifyState(OHConstants.VERIFY_STATE_3);
		int rs =employeeInfoDao.update(employeeInfo, "updateTime", "updateBy",
				"verifyState");
		return rs > 0 ? true : false;
	}

	@Override
	@Transactional
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		if (ObjectUtil.isNullOrEmpty(oldTownCode)) {
			return;
		}
		Assert.notNull(newTownCode, "目标中心不能为空");
		Criteria criteria = new Criteria("patownShip", OP.IN, oldTownCode);
		Parameters parameters = new Parameters("patownShip", newTownCode);
		employeeInfoDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void sendTownVillageRelation(String townCode,
										String[] newAddVillageCodes) {
		if (ObjectUtil.isNullOrEmpty(townCode)) {
			return;
		}
		Assert.notNull(newAddVillageCodes, "目标中心不能为空");
		Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		Parameters parameters = new Parameters("patownShip", townCode);
		employeeInfoDao.update(parameters, criteria);
	}

	@Override
	public PageList<OccupationDiseaseReport> getOPReportList(Criteria criteria, Page page) {
		return occupationDiseaseReportDao.getPageList(page, criteria, new Order("ID", false));
	}

	/**
	 * 查询职业病报卡
	 * @param criteria
	 * @return
	 */
	public OccupationDiseaseReport getOPReport(Criteria criteria){
		return occupationDiseaseReportDao.get(criteria);
	}

	@Override
	@Transactional
	public void saveReport(OccupationDiseaseReport report, OhEmployeeInfo employeeInfo, Organization organization, User user, RoleType role) {
		occupationDiseaseReportDao.insert(report);
		employeeInfoDao.insert(employeeInfo);
	}

	@Override
	@Transactional
	public void saveReport(OccupationDiseaseReport report) {
		occupationDiseaseReportDao.insert(report);
	}


}
