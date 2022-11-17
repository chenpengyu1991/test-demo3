package com.founder.rhip.mdm.entity;

import com.founder.rhip.mdm.common.JsonDateSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MDM_PERSON")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息标识||", length = 38, nullable = false)
	private Long personId;

	@Column(name = "DOMAIN_ID", columnDefinition = "VARCHAR2|系统域标识||", length = 20, nullable = true)
	private String domainId;

	@Column(name = "LOCAL_ID", columnDefinition = "VARCHAR2|本地系统标识||", length = 100, nullable = true)
	private String localId;

	@Column(name = "PMPI_ID", columnDefinition = "VARCHAR2|主索引标识||", length = 100, nullable = true)
	private String pmpiId;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 30, nullable = true)
	private String healthFileNo;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 20, nullable = true)
	private String idCard;

	@Column(name = "OTHER_CARD_TYPE", columnDefinition = "CHAR|其他证件类型代码||", length = 2, nullable = true)
	private String otherCardType;

	@Column(name = "OTHER_CARD_NO", columnDefinition = "VARCHAR2|其他证件号||", length = 50, nullable = true)
	private String otherCardNo;

	@Column(name = "HEALTH_CARD_NO", columnDefinition = "VARCHAR2|健康卡号||", length = 20, nullable = true)
	private String healthCardNo;

	@Column(name = "ALL_PURPOSE_CARD_NO", columnDefinition = "VARCHAR2|一卡通号||", length = 30, nullable = true)
	private String allPurposeCardNo;

	@Column(name = "ID_CARD_FARM", columnDefinition = "VARCHAR2|新农合号||", length = 30, nullable = true)
	private String idCardFarm;

	@Column(name = "ID_CARD_HOS", columnDefinition = "VARCHAR2|医保卡号||", length = 30, nullable = true)
	private String idCardHos;

	@Column(name = "ID_CARD_VAS", columnDefinition = "VARCHAR2|预防接种卡号||", length = 30, nullable = true)
	private String idCardVas;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 100, nullable = true)
	private String name;
	
	@Column(name = "CPY", columnDefinition = "VARCHAR2|姓名拼音||", length = 200, nullable = true)
	private String cpy;


	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 30, nullable = true)
	private String occupation;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码||", length = 2, nullable = true)
	private String marriage;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 10, nullable = true)
	private String education;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "HOME_PHONE", columnDefinition = "VARCHAR2|住宅电话||", length = 20, nullable = true)
	private String homePhone;

	@Column(name = "NATIONALITY", columnDefinition = "VARCHAR2|国籍||", length = 3, nullable = true)
	private String nationality;

	@Column(name = "HOUSEHOLDER_MARK", columnDefinition = "VARCHAR2|户主标志||", length = 1, nullable = true)
	private String householderMark;

	@Column(name = "HOUSEHOLDER_NAME", columnDefinition = "VARCHAR2|户主姓名||", length = 100, nullable = true)
	private String householderName;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|本人与户主关系||", length = 2, nullable = true)
	private String relation;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|现住地行政区划代码||", length = 12, nullable = true)
	private String gbCode;

	@Column(name = "DOMICILE_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 50, nullable = true)
	private String domicileType;

	@Column(name = "DOMICILE_RES_MARK", columnDefinition = "VARCHAR2|常住地址户籍标志||", length = 1, nullable = true)
	private String domicileResMark;

	@Column(name = "HR_PROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 100, nullable = true)
	private String hrProvince;

	@Column(name = "HR_CITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 100, nullable = true)
	private String hrCity;

	@Column(name = "HR_COUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 100, nullable = true)
	private String hrCounty;

	@Column(name = "HR_TOWNSHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 100, nullable = true)
	private String hrTownship;

	@Column(name = "HR_STREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 100, nullable = true)
	private String hrStreet;

	@Column(name = "HR_HOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 50, nullable = true)
	private String hrHouseNumber;

	@Column(name = "HR_POSTCODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 100, nullable = true)
	private String hrPostcode;

	@Column(name = "PA_PROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 100, nullable = true)
	private String paProvince;

	@Column(name = "PA_CITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 100, nullable = true)
	private String paCity;

	@Column(name = "PA_COUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 100, nullable = true)
	private String paCounty;

	@Column(name = "PA_TOWNSHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 100, nullable = true)
	private String paTownship;

	@Column(name = "PA_STREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 100, nullable = true)
	private String paStreet;

	@Column(name = "PA_HOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 50, nullable = true)
	private String paHouseNumber;

	@Column(name = "PA_POSTCODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 100, nullable = true)
	private String paPostcode;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 100, nullable = true)
	private String unitName;

	@Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|单位/学校电话号码||", length = 20, nullable = true)
	private String unitPhone;

//	@Column(name = "FIRST_GUARDIAN", columnDefinition = "VARCHAR2|第一监护人姓名||", length = 100, nullable = true)
//	private String firstGuardian;
//
//	@Column(name = "FIRST_RELATION", columnDefinition = "VARCHAR2|第一监护人与本人关系||", length = 2, nullable = true)
//	private String firstRelation;
//
//	@Column(name = "GUARDIAN_PHONE1", columnDefinition = "VARCHAR2|第一监护人电话||", length = 20, nullable = true)
//	private String guardianPhone1;
//
//	@Column(name = "SECOND_GUARDIAN", columnDefinition = "VARCHAR2|第二监护人姓名||", length = 100, nullable = true)
//	private String secondGuarDian;
//
//	@Column(name = "SECOND_RELATION", columnDefinition = "VARCHAR2|第二监护人与本人关系||", length = 2, nullable = true)
//	private String secondRelation;
//
//	@Column(name = "GUARDIAN_PHONE2", columnDefinition = "VARCHAR2|第二监护人电话||", length = 20, nullable = true)
//	private String guardianPhone2;

	@Column(name = "BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型代码||", length = 1, nullable = true)
	private String bloodType;

	@Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|Rh血型代码||", length = 1, nullable = true)
	private String rhBloodType;

//	@Column(name = "START_WORK_DATE", columnDefinition = "DATE|参加工作日期||", length = 8, nullable = true)
//	private Date startWorkDate;
//
//	@Column(name = "DISABILITY", columnDefinition = "VARCHAR2|残疾情况代码||", length = 2, nullable = true)
//	private String disability;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮件地址||", length = 100, nullable = true)
	private String email;

//	@Column(name = "TOILET_TYPE", columnDefinition = "VARCHAR2|家庭厕所类别代码||", length = 1, nullable = true)
//	private String toiletType;
//
//	@Column(name = "KITCHEN_EXHAUST_MARK", columnDefinition = "VARCHAR2|家庭厨房排风设施标识||", length = 1, nullable = true)
//	private String kitchenExhaustMark;
//
//	@Column(name = "KITCHEN_EXHAUST_TYPE", columnDefinition = "VARCHAR2|家庭厨房排风设施类别代码||", length = 1, nullable = true)
//	private String kitchenExhaustType;
//
//	@Column(name = "LIVE_STOCK_TYPE", columnDefinition = "VARCHAR2|家庭禽畜栏类别||", length = 1, nullable = true)
//	private String liveStockType;
//
//	@Column(name = "FUEL_TYPE", columnDefinition = "VARCHAR2|家庭燃料类型类别代码||", length = 1, nullable = true)
//	private String fuelType;
//
//	@Column(name = "DRINKING_WATER_TYPE", columnDefinition = "VARCHAR2|家庭饮水类别代码||", length = 1, nullable = true)
//	private String drinkingWaterType;
//
//	@Column(name = "INPUT_PERSON", columnDefinition = "VARCHAR2|建档人员姓名||", length = 100, nullable = true)
//	private String inputPerson;
//
//	@Column(name = "PHYSICIAN", columnDefinition = "VARCHAR2|责任医师姓名||", length = 100, nullable = true)
//	private String physician;
//
//	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
//	private Date inputDate;
//
//	@Column(name = "HEALTH_ORGAN_NAME_CODE", columnDefinition = "VARCHAR2|健康档案管理机构的组织机构代码||", length = 10, nullable = true)
//	private String healthOrganNameCode;
//
//	@Column(name = "HEALTH_ORGAN_NAME", columnDefinition = "VARCHAR2|健康档案管理机构名称||", length = 100, nullable = true)
//	private String healthOrganName;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间(yyyyMMddHHmmss)||", length = 17, nullable = true)
	private Long updateTime;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 20, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 100, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 20, nullable = true)
	private String updateIdcard;

	@Column(name = "UPDATE_PERSON", columnDefinition = "VARCHAR2|更新人姓名||", length = 100, nullable = true)
	private String updatePerson;
	
	//1:批量导入，2:创建，3:更新，4:合并，5:拆分
	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型", length = 20, nullable = true)
	private String operateType;
	
	private String paTownshipStr;

	private String paStreetStr;
	
	public String getPaTownshipStr() {
		return paTownshipStr;
	}

	public void setPaTownshipStr(String paTownshipStr) {
		this.paTownshipStr = paTownshipStr;
	}

	public String getPaStreetStr() {
		return paStreetStr;
	}

	public void setPaStreetStr(String paStreetStr) {
		this.paStreetStr = paStreetStr;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getDomainId() {
		return this.domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getLocalId() {
		return this.localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getPmpiId() {
		return this.pmpiId;
	}

	public void setPmpiId(String pmpiId) {
		this.pmpiId = pmpiId;
	}

	public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getOtherCardType() {
		return this.otherCardType;
	}

	public void setOtherCardType(String otherCardType) {
		this.otherCardType = otherCardType;
	}

	public String getOtherCardNo() {
		return this.otherCardNo;
	}

	public void setOtherCardNo(String otherCardNo) {
		this.otherCardNo = otherCardNo;
	}

	public String getHealthCardNo() {
		return this.healthCardNo;
	}

	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}

	public String getAllPurposeCardNo() {
		return this.allPurposeCardNo;
	}

	public void setAllPurposeCardNo(String allPurposeCardNo) {
		this.allPurposeCardNo = allPurposeCardNo;
	}

	public String getIdCardFarm() {
		return this.idCardFarm;
	}

	public void setIdCardFarm(String idCardFarm) {
		this.idCardFarm = idCardFarm;
	}

	public String getIdCardHos() {
		return this.idCardHos;
	}

	public void setIdCardHos(String idCardHos) {
		this.idCardHos = idCardHos;
	}

	public String getIdCardVas() {
		return this.idCardVas;
	}

	public void setIdCardVas(String idCardVas) {
		this.idCardVas = idCardVas;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpy() {
		return cpy;
	}

	public void setCpy(String cpy) {
		this.cpy = cpy;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHouseholderMark() {
		return this.householderMark;
	}

	public void setHouseholderMark(String householderMark) {
		this.householderMark = householderMark;
	}

	public String getHouseholderName() {
		return this.householderName;
	}

	public void setHouseholderName(String householderName) {
		this.householderName = householderName;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getDomicileType() {
		return this.domicileType;
	}

	public void setDomicileType(String domicileType) {
		this.domicileType = domicileType;
	}

	public String getDomicileResMark() {
		return this.domicileResMark;
	}

	public void setDomicileResMark(String domicileResMark) {
		this.domicileResMark = domicileResMark;
	}

	public String getHrProvince() {
		return this.hrProvince;
	}

	public void setHrProvince(String hrProvince) {
		this.hrProvince = hrProvince;
	}

	public String getHrCity() {
		return this.hrCity;
	}

	public void setHrCity(String hrCity) {
		this.hrCity = hrCity;
	}

	public String getHrCounty() {
		return this.hrCounty;
	}

	public void setHrCounty(String hrCounty) {
		this.hrCounty = hrCounty;
	}

	public String getHrTownship() {
		return this.hrTownship;
	}

	public void setHrTownship(String hrTownship) {
		this.hrTownship = hrTownship;
	}

	public String getHrStreet() {
		return this.hrStreet;
	}

	public void setHrStreet(String hrStreet) {
		this.hrStreet = hrStreet;
	}

	public String getHrHouseNumber() {
		return this.hrHouseNumber;
	}

	public void setHrHouseNumber(String hrHouseNumber) {
		this.hrHouseNumber = hrHouseNumber;
	}

	public String getHrPostcode() {
		return this.hrPostcode;
	}

	public void setHrPostcode(String hrPostcode) {
		this.hrPostcode = hrPostcode;
	}

	public String getPaProvince() {
		return this.paProvince;
	}

	public void setPaProvince(String paProvince) {
		this.paProvince = paProvince;
	}

	public String getPaCity() {
		return this.paCity;
	}

	public void setPaCity(String paCity) {
		this.paCity = paCity;
	}

	public String getPaCounty() {
		return this.paCounty;
	}

	public void setPaCounty(String paCounty) {
		this.paCounty = paCounty;
	}

	public String getPaTownship() {
		return this.paTownship;
	}

	public void setPaTownship(String paTownship) {
		this.paTownship = paTownship;
	}

	public String getPaStreet() {
		return this.paStreet;
	}

	public void setPaStreet(String paStreet) {
		this.paStreet = paStreet;
	}

	public String getPaHouseNumber() {
		return this.paHouseNumber;
	}

	public void setPaHouseNumber(String paHouseNumber) {
		this.paHouseNumber = paHouseNumber;
	}

	public String getPaPostcode() {
		return this.paPostcode;
	}

	public void setPaPostcode(String paPostcode) {
		this.paPostcode = paPostcode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitPhone() {
		return this.unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

//	public String getFirstGuardian() {
//		return this.firstGuardian;
//	}
//
//	public void setFirstGuardian(String firstGuardian) {
//		this.firstGuardian = firstGuardian;
//	}
//
//	public String getFirstRelation() {
//		return this.firstRelation;
//	}
//
//	public void setFirstRelation(String firstRelation) {
//		this.firstRelation = firstRelation;
//	}
//
//	public String getGuardianPhone1() {
//		return this.guardianPhone1;
//	}
//
//	public void setGuardianPhone1(String guardianPhone1) {
//		this.guardianPhone1 = guardianPhone1;
//	}
//
//	public String getSecondGuarDian() {
//		return this.secondGuarDian;
//	}
//
//	public void setSecondGuarDian(String secondGuarDian) {
//		this.secondGuarDian = secondGuarDian;
//	}
//
//	public String getSecondRelation() {
//		return this.secondRelation;
//	}
//
//	public void setSecondRelation(String secondRelation) {
//		this.secondRelation = secondRelation;
//	}
//
//	public String getGuardianPhone2() {
//		return this.guardianPhone2;
//	}
//
//	public void setGuardianPhone2(String guardianPhone2) {
//		this.guardianPhone2 = guardianPhone2;
//	}

	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getRhBloodType() {
		return this.rhBloodType;
	}

	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

//	public Date getStartWorkDate() {
//		return this.startWorkDate;
//	}
//
//	public void setStartWorkDate(Date startWorkDate) {
//		this.startWorkDate = startWorkDate;
//	}
//
//	public String getDisability() {
//		return this.disability;
//	}
//
//	public void setDisability(String disability) {
//		this.disability = disability;
//	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getToiletType() {
//		return this.toiletType;
//	}
//
//	public void setToiletType(String toiletType) {
//		this.toiletType = toiletType;
//	}
//
//	public String getKitchenExhaustMark() {
//		return this.kitchenExhaustMark;
//	}
//
//	public void setKitchenExhaustMark(String kitchenExhaustMark) {
//		this.kitchenExhaustMark = kitchenExhaustMark;
//	}
//
//	public String getKitchenExhaustType() {
//		return this.kitchenExhaustType;
//	}
//
//	public void setKitchenExhaustType(String kitchenExhaustType) {
//		this.kitchenExhaustType = kitchenExhaustType;
//	}
//
//	public String getLiveStockType() {
//		return this.liveStockType;
//	}
//
//	public void setLiveStockType(String liveStockType) {
//		this.liveStockType = liveStockType;
//	}
//
//	public String getFuelType() {
//		return this.fuelType;
//	}
//
//	public void setFuelType(String fuelType) {
//		this.fuelType = fuelType;
//	}
//
//	public String getDrinkingWaterType() {
//		return this.drinkingWaterType;
//	}
//
//	public void setDrinkingWaterType(String drinkingWaterType) {
//		this.drinkingWaterType = drinkingWaterType;
//	}
//
//	public String getInputPerson() {
//		return this.inputPerson;
//	}
//
//	public void setInputPerson(String inputPerson) {
//		this.inputPerson = inputPerson;
//	}
//
//	public String getPhysician() {
//		return this.physician;
//	}
//
//	public void setPhysician(String physician) {
//		this.physician = physician;
//	}
//
//	public Date getInputDate() {
//		return this.inputDate;
//	}
//
//	public void setInputDate(Date inputDate) {
//		this.inputDate = inputDate;
//	}
//
//	public String getHealthOrganNameCode() {
//		return this.healthOrganNameCode;
//	}
//
//	public void setHealthOrganNameCode(String healthOrganNameCode) {
//		this.healthOrganNameCode = healthOrganNameCode;
//	}
//
//	public String getHealthOrganName() {
//		return this.healthOrganName;
//	}
//
//	public void setHealthOrganName(String healthOrganName) {
//		this.healthOrganName = healthOrganName;
//	}

	public Long getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateIdcard() {
		return this.updateIdcard;
	}

	public void setUpdateIdcard(String updateIdcard) {
		this.updateIdcard = updateIdcard;
	}

	public String getUpdatePerson() {
		return this.updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

}