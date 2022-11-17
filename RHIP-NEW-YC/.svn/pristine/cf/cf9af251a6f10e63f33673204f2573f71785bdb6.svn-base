package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.annotation.DisplayField;
import com.founder.rhip.ehr.annotation.RecordTrace;
import com.founder.rhip.ehr.annotation.Star;
import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.service.export.Item;

@Entity
@Table(name = "BI_PERSON_INFO")
public class PersonInfo implements Serializable {

	private static final long serialVersionUID = -7313564364933619294L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|主索引标识||", length = 50, nullable = true)
	private String smpiId;

	@Column(name = "PERSONAL_INF_NO", columnDefinition = "VARCHAR2|个人信息表编号||", length = 20, nullable = true)
	private String personalInfNo;
	@Item(index=35,column ="档案编号")
	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;

	@Column(name = "OTHER_IDCARD_TYPE", columnDefinition = "VARCHAR2|身份证件类别代码||", length = 2, nullable = true)
	private String otherIdcardType;

	@Column(name = "OTHER_IDCARD", columnDefinition = "VARCHAR2|其他证件号||", length = 18, nullable = true)
	private String otherIdcard;

	@Item(index=3,column ="身份证件号码")
	@Star(star = StarType.ONE)
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "ICDCARD_ARCHIVES", columnDefinition = "VARCHAR2|一卡通号||", length = 30, nullable = true)
	private String icdcardArchives;

	@Column(name = "IDCARD_FARM", columnDefinition = "VARCHAR2|新农合号||", length = 30, nullable = true)
	private String idcardFarm;

	@Column(name = "IDCARD_HOS", columnDefinition = "VARCHAR2|医保卡号||", length = 30, nullable = true)
	private String idcardHos;

	@Column(name = "IDCARD_VAS", columnDefinition = "VARCHAR2|预防接种卡号||", length = 20, nullable = true)
	private String idcardVas;

	@RecordTrace
	@Item(index=1,column = "姓名")
	@Star(star = StarType.ONE)
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 100, nullable = true)
	private String name;

	@Star(star = StarType.TWO)
	@DisplayField(star = StarType.TWO)
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@DisplayField(star = StarType.TWO)
	@RecordTrace(isDic = true, dictCode = "GBT3304")
	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;

	@Column(name = "OTHER_NATION_DESC", columnDefinition = "VARCHAR2|少数名族名称||", length = 50, nullable = true)
	private String otherNationDesc;

	@RecordTrace(isDic = true, dictCode = "GBT226112003")
	@Item(index=2,column ="性别",isDic=true,dicType="GBT226112003")
	@Star(star = StarType.TWO)
	@DisplayField(star = StarType.TWO)
	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;

	@RecordTrace(isDic = true, dictCode = "GBT6565")
	@DisplayField(star = StarType.TWO)
	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别||", length = 3, nullable = true)
	private String occupation;

	@Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业其他||", length = 30, nullable = true)
	private String occupationOther;

	@RecordTrace(isDic = true, dictCode = "GBT226122003")
	@DisplayField(star = StarType.TWO)
	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 2, nullable = true)
	private String marriage;

	@Column(name = "MARRIAGE_DATE", columnDefinition = "DATE|结婚时间||", nullable = true)
	private Date marriageDate;

	@Column(name = "ANNUAL_INCOME", columnDefinition = "NUMBER|总费用||", scale = 19, precision = 2, nullable = true)
	private BigDecimal annualIncome;

	@RecordTrace(dictCode = "GBT46582006", isDic = true)
	@DisplayField(star = StarType.TWO)
	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历||", length = 2, nullable = true)
	private String education;

	@RecordTrace
	@Item(index=21,column ="联系电话")
	@Star(star = StarType.ONE)
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "HOME_PHONE", columnDefinition = "VARCHAR2|住宅电话||", length = 20, nullable = true)
	private String homePhone;

	@Column(name = "NATIONALITY", columnDefinition = "VARCHAR2|国籍||", length = 3, nullable = true)
	private String nationality;

	@Column(name = "HOUSEHOLDER_FLAG", columnDefinition = "VARCHAR2|户主标志||", length = 1, nullable = true)
	private String householderFlag;

	@Column(name = "HOUSEHOLDER_NAME", columnDefinition = "VARCHAR2|户主姓名||", length = 50, nullable = true)
	private String householderName;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|本人与户主关系||", length = 2, nullable = true)
	private String relation;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|现住地12位行政区划代码||", length = 12, nullable = true)
	private String gBCode;

	@Column(name = "ZONE_GBCODE", columnDefinition = "VARCHAR2|现住地10位行政区划代码||", length = 10, nullable = true)
	private String zoneGBCode;

	@Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
	private String areaCode;

	@RecordTrace(isDic = true, dictCode = "FS10005")
	@Item(index=8,column ="户籍类型",isDic=true,dicType="FS10005")
	@Star(star = StarType.ONE)
	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|户籍类型||", length = 20, nullable = true)
	private String householdType;

	//	dicType="FS10005"
	@Column(name = "LIVING_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 20, nullable = true)
	private String livingType;

	@Column(name = "DOMICILE_FLAG", columnDefinition = "CHAR|常住地址户籍标志||", length = 1, nullable = true)
	private String domicileFalg;

	@Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String hrprovince;

	@Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
	private String hrcity;

//	@Item(index=9,column ="户籍地址-县(区)",isDic=true,dicType="FS990001")
	@Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
	private String hrcounty;

	@Item(index=10,isDic=true,dicType="FS990001",column ="户籍地址-乡镇")
	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String hrtownShip;

	@Item(index=11,isDic=true,dicType="FS990001",column ="户籍地址-村")
	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
	private String hrstreet;

	@Item(index=13,column ="户籍地址补充信息")
	@Star(star = StarType.ONE)
	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 50, nullable = true)
	private String hrhouseNumber;

	@RecordTrace
	@Column(name = "HR_ADDRESS", columnDefinition = "VARCHAR2|户籍地址||", length = 100, nullable = true)
	private String hrAddress;

	@RecordTrace
	@Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址地址||", length = 100, nullable = true)
	private String paAddress;

	@Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
	private String hrpostCode;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 70, nullable = true)
	private String pacity;

//	@Item(index=3,column ="现住址-县(区)",isDic=true,dicType="FS990001")
	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 70, nullable = true)
	private String pacounty;

	@Item(index=4,isDic=true,dicType="FS990001",column ="现住址乡镇")
	@Star(star = StarType.ONE)
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;

	@Item(index=5,isDic=true,dicType="FS990001",column ="现住址-村(街、路、弄等)")
	@Star(star = StarType.ONE)
	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;

	@Item(index=7,column ="现住址补充信息")
	@Star(star = StarType.ONE)
	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 50, nullable = true)
	private String pahouseNumber;

	@Transient
	private String addressDetail;

	@Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
	private String papostCode;

	@RecordTrace
	@DisplayField(star = StarType.TWO)
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 140, nullable = true)
	private String unitName;

	@Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|单位/学校电话号码||", length = 20, nullable = true)
	private String unitPhone;

	@Column(name = "UNIT_POSTCODE", columnDefinition = "VARCHAR2|单位/学校邮政编码||", length = 6, nullable = true)
	private String unitPostcode;

	@Column(name = "IMAGE_URL", columnDefinition = "VARCHAR2|头像地址||", length = 70, nullable = true)
	private String imageUrl;

	@RecordTrace
	@DisplayField(star = StarType.TWO)
	@Column(name = "FIRST_GUARDIAN", columnDefinition = "VARCHAR2|第一监护人姓名||", length = 50, nullable = true)
	private String firstGuardian;

	@Column(name = "FIRST_RELATION", columnDefinition = "VARCHAR2|第一监护人与本人关系||", length = 2, nullable = true)
	private String firstRelation;

	@Item(index=22,column ="联系人电话")
	@RecordTrace
	@Star(star = StarType.ONE)
	@DisplayField(star = StarType.TWO)
	@Column(name = "GUARDIAN_PHONE_ONE", columnDefinition = "VARCHAR2|紧急联系人电话||", length = 20, nullable = true)
	private String guardianPhoneOne;

	@Column(name = "SECOND_GUARDIAN", columnDefinition = "VARCHAR2|第二监护人姓名||", length = 50, nullable = true)
	private String secondGuardian;

	@Column(name = "SECOND_RELATION", columnDefinition = "VARCHAR2|第二监护人与本人关系||", length = 2, nullable = true)
	private String secondRelation;

	@Column(name = "GUARDIAN_PHONE_TWO", columnDefinition = "VARCHAR2|第二监护人电话||", length = 20, nullable = true)
	private String guardianPhoneTwo;

	@RecordTrace(isDic = true, dictCode = "CV0450005")
	@Star(star = StarType.TWO)
	@DisplayField(star = StarType.TWO)
	@Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型||", length = 1, nullable = true)
	private String aboBloodType;

	@RecordTrace(isDic = true, dictCode = "FS10010")
	@DisplayField(star = StarType.TWO)
	@Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|Rh血型||", length = 1, nullable = true)
	private String rhBloodType;

	@Column(name = "START_WORK_DATE", columnDefinition = "DATE|参加工作日期||", nullable = true)
	private Date startWorkDate;

	@Column(name = "DISABILITY", columnDefinition = "VARCHAR2|残疾情况||", length = 2, nullable = true)
	private String disability;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮件地址||", length = 70, nullable = true)
	private String email;

	@RecordTrace(isDic = true, dictCode = "CV0300304")
	@Column(name = "HASTOILET", columnDefinition = "VARCHAR2|厕所||", length = 1, nullable = true)
	private String hastoilet;

	@Column(name = "OUT_WIND", columnDefinition = "CHAR|家庭厨房排风设施标识||", length = 1, nullable = true)
	private String outWind;

	@RecordTrace(isDic = true, dictCode = "CV0300302")
	@Column(name = "OUT_WIND_TYPE", columnDefinition = "VARCHAR2|厨房排风设施||", length = 1, nullable = true)
	private String outWindType;

	@RecordTrace(isDic = true, dictCode = "FS10015")
	@Column(name = "FOWL_TYPE", columnDefinition = "VARCHAR2|禽畜栏||", length = 1, nullable = true)
	private String fowlType;

	@RecordTrace(isDic = true, dictCode = "CV0300303")
	@Column(name = "FUEL", columnDefinition = "VARCHAR2|燃料类型||", length = 1, nullable = true)
	private String fuel;

	@RecordTrace(isDic = true, dictCode = "CV0300115")
	@Column(name = "WATER", columnDefinition = "VARCHAR2|饮水||", length = 1, nullable = true)
	private String water;

	@Column(name = "STAR", columnDefinition = "NUMBER|星级||", length = 3, nullable = true)
	private Integer star;

	@Column(name = "ONE_STAR_SCORE", columnDefinition = "NUMBER|1星级分数||", length = 3, nullable = true)
	private Integer oneStarScore;

	@Column(name = "TWO_STAR_SCORE", columnDefinition = "NUMBER|2星级分数||", length = 3, nullable = true)
	private Integer twoStarScore;

	@Column(name = "THREE_STAR_SCORE", columnDefinition = "NUMBER|3星级分数||", length = 3, nullable = true)
	private Integer threeStarScore;

	@Column(name = "INTEGRITY", columnDefinition = "NUMBER|完整度||", length = 5, scale = 2, nullable = true)
	private BigDecimal integrity;

	@Column(name = "TWO_STAR_DISPLAY_SCORE", columnDefinition = "NUMBER|2星级填写的分数||", length = 3, nullable = true)
	private Integer twoStarDisplayScore;

	@Column(name = "THREE_STAR_DISPLAY_SCORE", columnDefinition = "NUMBER|3星级填写的分数||", length = 3, nullable = true)
	private Integer threeStarDisplayScore;

	@Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|管理机构人员身份证||", length = 18, nullable = true)
	private String inputIdcard;

	/*@Item(index=32,column ="建档人员",isStaff=true)*/
	@Star(star = StarType.ONE)
	@Column(name = "INPUTER_ID", columnDefinition = "VARCHAR2|管理机构人员ID||", length = 50, nullable = true)
	private String inputerId;

	@RecordTrace
//	@Item(index=32,column ="建档人员")
	@Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|管理医生||", length = 30, nullable = true)
	private String inputName;

	@Column(name = "INPUT_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级管理机构编码||", length = 15, nullable = true)
	private String inputCenterOrganCode;

	@Column(name = "INPUT_GBCODE", columnDefinition = "VARCHAR2|上上级管理机构编码||", length = 12, nullable = true)
	private String inputGbcode;

	@Item(index=31,column ="管理机构机构编码",isOrganization=true)
	@Star(star = StarType.ONE)
	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|管理机构机构编码||", length = 15, nullable = true)
	private String inputOrganCode;

	@Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|管理机构名称||", length = 70, nullable = true)
	private String inputOrganName;

	@RecordTrace
//	@Item(index=34,column ="建档日期",isDate=true,datePattern="yyyy/MM/dd")
	@Star(star = StarType.ONE)
	@Column(name = "INPUT_DATE", columnDefinition = "DATE|管理日期||", nullable = true)
	private Date inputDate;

	@Column(name = "HEALTH_ORGAN_CODE", columnDefinition = "VARCHAR2|健康档案管理机构的组织机构代码||", length = 10, nullable = true)
	private String healthOrganCode;

	@Column(name = "HEALTH_ORGAN_NAME", columnDefinition = "VARCHAR2|健康档案管理机构名称||", length = 70, nullable = true)
	private String healthOrganName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 15, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
	private String updateIdcard;

	@Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateName;

	//	CV0710003
	@Column(name = "PAYMENT_URBAN_WORKDERS", columnDefinition = "VARCHAR2|费用支付城镇职工基本医疗保险||", length = 1, nullable = true)
	private String paymentUrbanWorkders;

	//	CV0710003
	@Column(name = "PAYMENT_URBAN_RESIDENT", columnDefinition = "VARCHAR2|费用支付城镇居民基本医疗保险||", length = 1, nullable = true)
	private String paymentUrbanResident;

	//	CV0710003
	@Column(name = "PAYMENT_NEW_RURAL_COOPERATION", columnDefinition = "VARCHAR2|费用支付新型农村合作医疗||", length = 1, nullable = true)
	private String paymentNewRuralCooperation;

	//	CV0710003
	@Column(name = "PAYMENT_POVERTY_RELIEF", columnDefinition = "VARCHAR2|费用支付贫困救助||", length = 1, nullable = true)
	private String paymentPovertyRelief;

	//	CV0710003
	@Column(name = "PAYMENT_COMMERCIAL", columnDefinition = "VARCHAR2|费用支付商业医疗保险||", length = 1, nullable = true)
	private String paymentCommercial;

	//	CV0710003
	@Column(name = "PAYMENT_BURSARY", columnDefinition = "VARCHAR2|费用支付全公费||", length = 1, nullable = true)
	private String paymentBursary;

	//	CV0710003
	@Column(name = "PAYMENT_PERSONAL_EXPENSES", columnDefinition = "VARCHAR2|费用支付全自费||", length = 1, nullable = true)
	private String paymentPersonalExpenses;

	//	CV0710003
	@Column(name = "PAYMENT_OTHER", columnDefinition = "VARCHAR2|费用支付其他||", length = 1, nullable = true)
	private String paymentOther;

	//	CV0710003
	@Column(name = "PAYMENT_OTHER_DESC", columnDefinition = "VARCHAR2|费用支付其他描述||", length = 1, nullable = true)
	private String paymentOtherDesc;

	@Column(name = "MOVED_VACATE_FLAG", columnDefinition = "VARCHAR2|迁入迁出||", length = 1, nullable = true)
	private String movedVacateFlag;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|个人状态||", length = 2, nullable = true)
	private String status;

	@Column(name = "FILING_FLAG", columnDefinition = "VARCHAR2|建档状态||", length = 1, nullable = true)
	private String filingFlag; // 0：未建档 1：已建档，3 已退回 9已注销 4无身份证 5待审核

	@Column(name = "LOGOUT_DATE", columnDefinition = "TIMESTAMP|注销时间||", nullable = true)
	private Date logoutDate;

	@Column(name = "STAR_UPDATE_DATE", columnDefinition = "NUMBER|星级更新时间||", length = 3, nullable = true)
	private Date starUpdateDate;

	@Column(name = "CITIZEN_CARD_NO", columnDefinition = "VARCHAR2|市民卡号||", length = 50, nullable = true)
	private String citizenCardNo;

	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

	@Column(name = "RELEASE_DATE", columnDefinition = "Date|发卡日期||", nullable = true)
	private Date releaseDate;

	@Column(name = "CARD_STATUS", columnDefinition = "VARCHAR2|市民卡状态||", length = 2, nullable = true)
	private String cardStatus;

	@Column(name = "ENCRYPTION_FLAG", columnDefinition = "VARCHAR2|加密标志:1加密,2 和null 不加密||", length = 1, nullable = true)
	private String encryptionFlag;

	@Column(name = "DECRYPTION_PASSWORD", columnDefinition = "VARCHAR2|解密密码||", length = 50, nullable = true)
	private String decryptionPassword;

//    @Column(name = "IS_SMB", columnDefinition = "VARCHAR2|数据采集备用字段||", length = 2, nullable = true)
//    private String isSmb;

	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 20, nullable = true)
	private String babyCardNo;

	@Item(index=36,column ="备注",isDic=true,dicType="FS990026")
	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 100, nullable = true)
	private String remarks;


	@Item(index=38,column ="签约状态",isDic=true,dicType="FS10399",nullValue = "未签约")
	@Column(name = "SIGN_FLAG", columnDefinition = "NUMBER|签约状态||", length = 1, nullable = true)
	private Integer signFlag;

	@Column(name = "POPULATION_CATEGORY", columnDefinition = "VARCHAR2|人群分类||", length = 100, nullable = true)
	private String populationCategory;

	@Column(name = "source", columnDefinition = "VARCHAR2|档案来源,1：pc,2:app||", length = 2, nullable = true)
	private String source;

	@Column(name = "BEGIN_FILL_DATE", columnDefinition = "Date|开始填写日期||", nullable = true)
	private Date beginFillDate;

	@Column(name = "FINSH_FILL_DATE", columnDefinition = "Date|结束填写日期||", nullable = true)
	private Date finshFillDate;

	@Item(index=12,column ="户籍地址-组",isDic=true,dicType="FS990001")
	@Column(name = "HR_GROUP", columnDefinition = "VARCHAR2|户籍小组地址||", length = 2, nullable = true)
	private String hrGroup;

	@Item(index=6,column ="现住址-组",isDic=true,dicType="FS990001")
	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;

	@RecordTrace(dictCode = "FS10009", isDic = true)
	@Column(name = "POVERTY", columnDefinition = "VARCHAR2|贫困人口||", length = 2, nullable = true)
	private String poverty;

	@RecordTrace(dictCode = "FS10009", isDic = true)
	@Column(name = "VERY_POVERTY", columnDefinition = "VARCHAR2|计生特困||", length = 2, nullable = true)
	private String veryPoverty;

	@RecordTrace(dictCode = "FS10009", isDic = true)
	@Column(name = "DISABLED", columnDefinition = "VARCHAR2|残疾人口||", length = 2, nullable = true)
	private String disabled;

	@Column(name = "POVERTY_TYPE", columnDefinition = "VARCHAR2|贫困类型FS990024||", length = 2, nullable = true)
	private String povertyType;

	@Column(name = "VERY_POVERTY_TYPE", columnDefinition = "VARCHAR2|特困类型FS990025||", length = 2, nullable = true)
	private String veryPovertyType;

	@Column(name = "CREATE_IDCARD", columnDefinition = "VARCHAR2|建档人员身份证||", length = 18, nullable = true)
	private String createIdcard;

	@Star(star = StarType.ONE)
	@Column(name = "CREATE_ID", columnDefinition = "VARCHAR2|建档人员ID||", length = 50, nullable = true)
	private String createId;

	@RecordTrace
	@Item(index=32,column ="建档人员")
	@Column(name = "CREATE_NAME", columnDefinition = "VARCHAR2|建档医生||", length = 30, nullable = true)
	private String createName;

	@Column(name = "CREATE_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级建档机构编码||", length = 15, nullable = true)
	private String createCenterOrganCode;

	@Column(name = "CREATE_GBCODE", columnDefinition = "VARCHAR2|上上级建档机构编码||", length = 12, nullable = true)
	private String createGbcode;

	@Item(index=31,column ="建档机构",isOrganization=true)
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Item(index=34,column ="建档日期",isDate=true,datePattern="yyyy/MM/dd")
	@Column(name = "CREATE_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
	private Date createDate;

	@RecordTrace(dictCode = "FS10281", isDic = true)
	@Column(name = "MATERNAL_Flag", columnDefinition = "CHAR|孕产妇标志|1：否,2:是|", length = 1, nullable = true)
	private String maternalFlag="1";

	@RecordTrace
	@Column(name = "LAST_MENSTRUAL_DATE", columnDefinition = "DATE|末次月经日期||", nullable = true)
	private Date lastMenstrualDate;

	@RecordTrace
	@Column(name = "ESTIMATED_DUE_DATE", columnDefinition = "DATE|预产期||", nullable = true)
	private Date estimatedDueDate;
	
	@Column(name = "EHR_FLAG", columnDefinition = "NUMBER|是否有医疗记录|0:没有医疗记录,1：有医疗记录|", nullable = true)
	private int ehrFlag = 0;

	@Column(name = "CONTRACT_STATUS", columnDefinition = "NUMBER|是否有医疗记录|0:没有医疗记录,1：有医疗记录|", nullable = true)
	private String contractStatus;
	/**
	 * 更新人ID
	 */
	@Transient
	private String updateInputerId;

	@Transient
	private String familyMemTypeCode;

	@Transient
	private String familyMemStatus;

	@Transient
	private String paAddressDetail;

	@Transient
	private String hrAddressDetail;

	@Transient
	private String healthFileNoHtml;

	@Transient
	private Long selected;

	@Transient
	private String localId;

	@Transient
	private String domainId;

	@Transient
	private String authorOrganization;

	@Transient
	private String personName;

	@Transient
	private String personGender;

	@Transient
	private Date personBirthDay;

	@Transient
	private String personIdCard;

	@Transient
	private String personPhoneNumber;

	@Transient
	private String genderDesc;

	@Transient
	private String nationDesc;

	@Transient
	private String educationDesc;

	@Transient
	private String marriageDesc;

	@Transient
	private String firstRelationDesc;

	@Transient
	private String secondRelationDesc;

	@Transient
	private String relationDesc;

	@Transient
	private String effectiveTime;

	@Transient
	private String systemTime;

	@Transient
	private String versionNumber;

	@Transient
	private String householderFlagDesc;

	@Transient
	private String sourceId;

	@Transient
	private String inputDateStr;

	@Transient
	private String domicileFalgDesc;

	/**
	 * 老年人标志，大于等于65岁
	 */
	@Transient
	private boolean oldPeopleFlag;

	@Transient
	private String motherIdcard;

	@Transient
	private String cPhysicalExamAge;

	//签约ID
	@Transient
	private Long signId;

	@Transient
	@Item(index=37,column ="体检日期",isDate=true,datePattern="yyyy/MM/dd")
//	@Column(name = "CLINIC_DATE", columnDefinition = "DATE|参加工作日期||", nullable = true)
	private Date clinicDate;

	@Transient
	private int age;
	
	// 头像标记用来页面判断是否显示默认图片
	@Transient
	private boolean personInfoAdditionalFlag;

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return DateUtil.getAgeByBirthday(birthday);
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getCitizenCardNo() {
		return citizenCardNo;
	}

	public void setCitizenCardNo(String citizenCardNo) {
		this.citizenCardNo = citizenCardNo;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public Long getSelected() {
		return selected;
	}

	public void setSelected(Long selected) {
		this.selected = selected;
	}

	public String getInputOrganName() {
		return inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public Date getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}

	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getMovedVacateFlag() {
		return movedVacateFlag;
	}

	public void setMovedVacateFlag(String movedVacateFlag) {
		this.movedVacateFlag = movedVacateFlag;
	}

	public String getFamilyMemStatus() {
		return familyMemStatus;
	}

	public void setFamilyMemStatus(String familyMemStatus) {
		this.familyMemStatus = familyMemStatus;
	}

	public String getPersonalInfNo() {
		return this.personalInfNo;
	}

	public void setPersonalInfNo(String personalInfNo) {
		this.personalInfNo = personalInfNo;
	}

	public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getOtherIdcardType() {
		return otherIdcardType;
	}

	public void setOtherIdcardType(String otherIdcardType) {
		this.otherIdcardType = otherIdcardType;
	}

	public String getOtherIdcard() {
		return otherIdcard;
	}

	public void setOtherIdcard(String otherIdcard) {
		this.otherIdcard = otherIdcard;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		if (ObjectUtil.isNotEmpty(idcard)) {
			this.idcard = idcard.toUpperCase();
		} else {
			this.idcard = idcard;
		}
	}

	public String getIcdcardArchives() {
		return this.icdcardArchives;
	}

	public void setIcdcardArchives(String icdcardArchives) {
		this.icdcardArchives = icdcardArchives;
	}

	public String getIdcardFarm() {
		return this.idcardFarm;
	}

	public void setIdcardFarm(String idcardFarm) {
		this.idcardFarm = idcardFarm;
	}

	public String getIdcardHos() {
		return this.idcardHos;
	}

	public void setIdcardHos(String idcardHos) {
		this.idcardHos = idcardHos;
	}

	public String getIdcardVas() {
		return this.idcardVas;
	}

	public void setIdcardVas(String idcardVas) {
		this.idcardVas = idcardVas;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getHouseholderFlag() {
		return this.householderFlag;
	}

	public void setHouseholderFlag(String householderFlag) {
		this.householderFlag = householderFlag;
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

	public String getGBCode() {
		return this.gBCode;
	}

	public void setGBCode(String gBCode) {
		this.gBCode = gBCode;
	}

	public String getZoneGBCode() {
		return this.zoneGBCode;
	}

	public void setZoneGBCode(String zoneGBCode) {
		this.zoneGBCode = zoneGBCode;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getHouseholdType() {
		return this.householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getDomicileFalg() {
		return domicileFalg;
	}

	public void setDomicileFalg(String domicileFalg) {
		this.domicileFalg = domicileFalg;
	}

	public String getHrprovince() {
		return this.hrprovince;
	}

	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	public String getHrcity() {
		return this.hrcity;
	}

	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	public String getHrcounty() {
		return this.hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getHrpostCode() {
		return this.hrpostCode;
	}

	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
	}

	public String getPaprovince() {
		return this.paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return this.pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return this.pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getPapostCode() {
		return this.papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFirstGuardian() {
		return this.firstGuardian;
	}

	public void setFirstGuardian(String firstGuardian) {
		this.firstGuardian = firstGuardian;
	}

	public String getFirstRelation() {
		return this.firstRelation;
	}

	public void setFirstRelation(String firstRelation) {
		this.firstRelation = firstRelation;
	}

	public String getGuardianPhoneOne() {
		return guardianPhoneOne;
	}

	public void setGuardianPhoneOne(String guardianPhoneOne) {
		this.guardianPhoneOne = guardianPhoneOne;
	}

	public String getSecondGuardian() {
		return this.secondGuardian;
	}

	public void setSecondGuardian(String secondGuardian) {
		this.secondGuardian = secondGuardian;
	}

	public String getSecondRelation() {
		return this.secondRelation;
	}

	public void setSecondRelation(String secondRelation) {
		this.secondRelation = secondRelation;
	}

	public String getGuardianPhoneTwo() {
		return guardianPhoneTwo;
	}

	public void setGuardianPhoneTwo(String guardianPhoneTwo) {
		this.guardianPhoneTwo = guardianPhoneTwo;
	}

	public String getAboBloodType() {
		return aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public void setPaAddressDetail(String paAddressDetail) {
		this.paAddressDetail = paAddressDetail;
	}

	public void setHrAddressDetail(String hrAddressDetail) {
		this.hrAddressDetail = hrAddressDetail;
	}

	public String getRhBloodType() {
		return this.rhBloodType;
	}

	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

	public Date getStartWorkDate() {
		return this.startWorkDate;
	}

	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public String getDisability() {
		return this.disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHastoilet() {
		return this.hastoilet;
	}

	public void setHastoilet(String hastoilet) {
		this.hastoilet = hastoilet;
	}

	public String getOutWind() {
		return this.outWind;
	}

	public void setOutWind(String outWind) {
		this.outWind = outWind;
	}

	public String getOutWindType() {
		return this.outWindType;
	}

	public void setOutWindType(String outWindType) {
		this.outWindType = outWindType;
	}

	public String getFowlType() {
		return this.fowlType;
	}

	public void setFowlType(String fowlType) {
		this.fowlType = fowlType;
	}

	public String getFuel() {
		return this.fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getWater() {
		return this.water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getInputName() {
		return this.inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getHealthOrganCode() {
		return this.healthOrganCode;
	}

	public void setHealthOrganCode(String healthOrganCode) {
		this.healthOrganCode = healthOrganCode;
	}

	public String getHealthOrganName() {
		return this.healthOrganName;
	}

	public void setHealthOrganName(String healthOrganName) {
		this.healthOrganName = healthOrganName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public String getUpdateName() {
		return this.updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getgBCode() {
		return gBCode;
	}

	public void setgBCode(String gBCode) {
		this.gBCode = gBCode;
	}

	public String getPaymentUrbanWorkders() {
		return paymentUrbanWorkders;
	}

	public void setPaymentUrbanWorkders(String paymentUrbanWorkders) {
		this.paymentUrbanWorkders = paymentUrbanWorkders;
	}

	public String getPaymentUrbanResident() {
		return paymentUrbanResident;
	}

	public void setPaymentUrbanResident(String paymentUrbanResident) {
		this.paymentUrbanResident = paymentUrbanResident;
	}

	public String getPaymentNewRuralCooperation() {
		return paymentNewRuralCooperation;
	}

	public void setPaymentNewRuralCooperation(String paymentNewRuralCooperation) {
		this.paymentNewRuralCooperation = paymentNewRuralCooperation;
	}

	public String getPaymentPovertyRelief() {
		return paymentPovertyRelief;
	}

	public void setPaymentPovertyRelief(String paymentPovertyRelief) {
		this.paymentPovertyRelief = paymentPovertyRelief;
	}

	public String getPaymentCommercial() {
		return paymentCommercial;
	}

	public void setPaymentCommercial(String paymentCommercial) {
		this.paymentCommercial = paymentCommercial;
	}

	public String getPaymentBursary() {
		return paymentBursary;
	}

	public void setPaymentBursary(String paymentBursary) {
		this.paymentBursary = paymentBursary;
	}

	public String getPaymentPersonalExpenses() {
		return paymentPersonalExpenses;
	}

	public void setPaymentPersonalExpenses(String paymentPersonalExpenses) {
		this.paymentPersonalExpenses = paymentPersonalExpenses;
	}

	public String getPaymentOther() {
		return paymentOther;
	}

	public void setPaymentOther(String paymentOther) {
		this.paymentOther = paymentOther;
	}

	public String getPaymentOtherDesc() {
		return paymentOtherDesc;
	}

	public void setPaymentOtherDesc(String paymentOtherDesc) {
		this.paymentOtherDesc = paymentOtherDesc;
	}

	public String getSmpiId() {
		return smpiId;
	}

	public void setSmpiId(String smpiId) {
		this.smpiId = smpiId;
	}

	public String getFamilyMemTypeCode() {
		return familyMemTypeCode;
	}

	public void setFamilyMemTypeCode(String familyMemTypeCode) {
		this.familyMemTypeCode = familyMemTypeCode;
	}

	public String getInputIdcard() {
		return inputIdcard;
	}

	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFilingFlag() {
		return filingFlag;
	}

	public void setFilingFlag(String filingFlag) {
		this.filingFlag = filingFlag;
	}

	public String getOccupationOther() {
		return occupationOther;
	}

	public void setOccupationOther(String occupationOther) {
		this.occupationOther = occupationOther;
	}

	public String getUnitPostcode() {
		return unitPostcode;
	}

	public void setUnitPostcode(String unitPostcode) {
		this.unitPostcode = unitPostcode;
	}

	public String getPaAddressDetail() {
		// this.paAddressDetail = getStr(this.paprovince) + " " +
		// getStr(this.pacity) + " " + getStr(this.pacounty) + " " +
		// getStr(this.patownShip) + " " + getStr(this.pastreet) + " " +
		// getStr(this.pahouseNumber);
		return paAddressDetail;
	}

	public String getHrAddressDetail() {
		// this.hrAddressDetail = getStr(this.hrprovince) + " " +
		// getStr(this.hrcity) + " " + getStr(this.hrcounty) + " " +
		// getStr(this.hrtownShip) + " " + getStr(this.hrstreet) + " " +
		// getStr(this.hrhouseNumber);
		return hrAddressDetail;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public BigDecimal getIntegrity() {
		return integrity;
	}

	public void setIntegrity(BigDecimal integrity) {
		this.integrity = integrity;
	}

	public Integer getOneStarScore() {
		return oneStarScore;
	}

	public void setOneStarScore(Integer oneStarScore) {
		this.oneStarScore = oneStarScore;
	}

	public Integer getTwoStarScore() {
		return twoStarScore;
	}

	public void setTwoStarScore(Integer twoStarScore) {
		this.twoStarScore = twoStarScore;
	}

	public Integer getThreeStarScore() {
		return threeStarScore;
	}

	public void setThreeStarScore(Integer threeStarScore) {
		this.threeStarScore = threeStarScore;
	}

	public String getHealthFileNoHtml() {

		if (StringUtil.isNullOrEmpty(this.getHealthFileNo())) {
			return "";
		}

		String[] noArray = StringUtil.split(this.getHealthFileNo());
		String personalInfoHtmlStr = "<s class=\"pop_No\"><span class=\"text\" style=\"width:50px;\"><b>编号：</b></span>";
		int i = 0;
		for (String arrayOne : noArray) {
			if (i == 6 || i == 9 || i == 12) {
				personalInfoHtmlStr = personalInfoHtmlStr + "<span class=\"line\">-</span><span>" + arrayOne + "</span>";
			} else {
				personalInfoHtmlStr = personalInfoHtmlStr + "<span>" + arrayOne + "</span>";
			}

			i++;
		}

		healthFileNoHtml = personalInfoHtmlStr + "</s>";

		return healthFileNoHtml;
	}

	private String getStr(String str) {
		return null == str ? "" : str;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonInfo other = (PersonInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getInputCenterOrganCode() {
		return inputCenterOrganCode;
	}

	public void setInputCenterOrganCode(String inputCenterOrganCode) {
		this.inputCenterOrganCode = inputCenterOrganCode;
	}

	public String getInputGbcode() {
		return inputGbcode;
	}

	public void setInputGbcode(String inputGbcode) {
		this.inputGbcode = inputGbcode;
	}

	public String getInputerId() {
		return inputerId;
	}

	public void setInputerId(String inputerId) {
		this.inputerId = inputerId;
	}

	public String getHrAddress() {
		return hrAddress;
	}

	public void setHrAddress(String hrAddress) {
		this.hrAddress = hrAddress;
	}

	public String getPaAddress() {
		return paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public boolean equals(PersonInfo other, Set<String> properties) {
		ConvertingWrapDynaBean dynaBeanOther = new ConvertingWrapDynaBean(other);
		ConvertingWrapDynaBean dynaBeanThis = new ConvertingWrapDynaBean(this);
		if (properties.size() < 1) {
			properties.addAll(dynaBeanThis.getPropertyNames());
		}
		boolean result = true;
		try {
			// 更新值为空的属性不予更新
			Iterator<String> it = properties.iterator();
			while (it.hasNext()) {
				String property = it.next();
				if (property.equals("updateDate") || property.equals("updateName") || property.equals("updateIdcard") || property.equals("updateOrganName") || property.equals("updateOrganCode")) {
					continue;
				}
				//B131120-001 begin modify by:meixingjian
				if (property.equals("GBCode") || property.equals("healthFileNoHtml") ) {
					it.remove();
					continue;
				}
				//B131120-001 end
				Object value = dynaBeanOther.get(property);
				if (null == value|| (value instanceof String && ((String) value).trim().isEmpty())) {
					it.remove();
					continue;
				}
				if (result&&decToUpdate(dynaBeanThis.get(property), value)) {
					result = false;
				}
			}
		} catch (Exception e) {
			new RuntimeException("计算和比较属性值时发生错误", e);
			e.printStackTrace();
		}
		return result;
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
		if (ObjectUtil.isNotEmpty(left)) {
			if (ObjectUtil.isNullOrEmpty(right)) {
				return true;
			} else if (left instanceof Date) {
				return !(((Date) left).getTime() == ((Date) right).getTime());
			} else {
				return !left.equals(right);
			}
		}
		return false;
	}

	public static void main(String[] abc) {
		PersonInfo o1 = new PersonInfo();
		o1.setName("姚锋1");
		o1.setBirthday(new Date());
		o1.setOneStarScore(1);
		o1.setAddressDetail("abcdefg");

		PersonInfo o2 = new PersonInfo();
		o2.setName("姚锋");
		o2.setBirthday(new Date());
		o2.setOneStarScore(1);
		o2.setAddressDetail("abcdefg");
		Set<String> properties = new HashSet<>();
		properties.add("birthday");
		properties.add("oneStarScore");
		if (o1.equals(o2, properties)) {
			System.out.print("ok");
		} else {
			System.out.print("no");
		}
	}

	public Integer getTwoStarDisplayScore() {
		return twoStarDisplayScore;
	}

	public void setTwoStarDisplayScore(Integer twoStarDisplayScore) {
		this.twoStarDisplayScore = twoStarDisplayScore;
	}

	public Integer getThreeStarDisplayScore() {
		return threeStarDisplayScore;
	}

	public void setThreeStarDisplayScore(Integer threeStarDisplayScore) {
		this.threeStarDisplayScore = threeStarDisplayScore;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Date getStarUpdateDate() {
		return starUpdateDate;
	}

	public void setStarUpdateDate(Date starUpdateDate) {
		this.starUpdateDate = starUpdateDate;
	}


	public String getAuthorOrganization() {
		return authorOrganization;
	}


	public void setAuthorOrganization(String authorOrganization) {
		this.authorOrganization = authorOrganization;
	}


	public String getPersonName() {
		this.personName = name;
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getPersonGender() {
		this.personGender = gender;
		return personGender;
	}


	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}


	public Date getPersonBirthDay() {
		this.personBirthDay = this.birthday;
		return personBirthDay;
	}


	public void setPersonBirthDay(Date personBirthDay) {
		this.personBirthDay = personBirthDay;
	}


	public String getPersonIdCard() {
		this.personIdCard = this.idcard;
		return personIdCard;
	}


	public void setPersonIdCard(String personIdCard) {
		this.personIdCard = personIdCard;
	}


	public String getPersonPhoneNumber() {
		this.personPhoneNumber = this.phoneNumber;
		return personPhoneNumber;
	}


	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}


	public String getGenderDesc() {
		return genderDesc;
	}


	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}


	public String getNationDesc() {
		return nationDesc;
	}


	public void setNationDesc(String nationDesc) {
		this.nationDesc = nationDesc;
	}


	public String getEducationDesc() {
		return educationDesc;
	}


	public void setEducationDesc(String educationDesc) {
		this.educationDesc = educationDesc;
	}


	public String getMarriageDesc() {
		return marriageDesc;
	}


	public void setMarriageDesc(String marriageDesc) {
		this.marriageDesc = marriageDesc;
	}


	public String getFirstRelationDesc() {
		return firstRelationDesc;
	}


	public void setFirstRelationDesc(String firstRelationDesc) {
		this.firstRelationDesc = firstRelationDesc;
	}


	public String getSecondRelationDesc() {
		return secondRelationDesc;
	}


	public void setSecondRelationDesc(String secondRelationDesc) {
		this.secondRelationDesc = secondRelationDesc;
	}


	public String getRelationDesc() {
		return relationDesc;
	}


	public void setRelationDesc(String relationDesc) {
		this.relationDesc = relationDesc;
	}


	public String getEffectiveTime() {
		return effectiveTime;
	}


	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public String getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(String systemTime) {
		this.systemTime = systemTime;
	}

	public String getVersionNumber() {
		return versionNumber;
	}


	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}


	public String getHouseholderFlagDesc() {
		return householderFlagDesc;
	}


	public void setHouseholderFlagDesc(String householderFlagDesc) {
		this.householderFlagDesc = householderFlagDesc;
	}


	public String getSourceId() {
		return sourceId;
	}


	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}


	public String getInputDateStr() {
		if (ObjectUtil.isNotEmpty(inputDate)) {
			this.inputDateStr = DateUtil.getDateTime("yyyy-MM-dd'T'hh:mm:ss", inputDate);
		}
		return inputDateStr;
	}


	public void setInputDateStr(String inputDateStr) {
		this.inputDateStr = inputDateStr;
	}


	public String getProcessStatus() {
		return processStatus;
	}


	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}


	public boolean isOldPeopleFlag() {
		return DateUtil.getAgeByBirthday(this.birthday,new Date())>=65;
	}

	public void setOldPeopleFlag(boolean oldPeopleFlag) {
		this.oldPeopleFlag = oldPeopleFlag;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getEncryptionFlag() {
		return encryptionFlag;
	}

	public void setEncryptionFlag(String encryptionFlag) {
		this.encryptionFlag = encryptionFlag;
	}

	public String getDecryptionPassword() {
		return decryptionPassword;
	}

	public void setDecryptionPassword(String decryptionPassword) {
		this.decryptionPassword = decryptionPassword;
	}

	public String getUpdateInputerId() {
		return updateInputerId;
	}

	public void setUpdateInputerId(String updateInputerId) {
		this.updateInputerId = updateInputerId;
	}

	public String getDomicileFalgDesc() {
		return domicileFalgDesc;
	}

	public void setDomicileFalgDesc(String domicileFalgDesc) {
		this.domicileFalgDesc = domicileFalgDesc;
	}

	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	public String getcPhysicalExamAge() {
		return cPhysicalExamAge;
	}

	public void setcPhysicalExamAge(String cPhysicalExamAge) {
		this.cPhysicalExamAge = cPhysicalExamAge;
	}

	public String getLivingType() {
		return livingType;
	}

	public void setLivingType(String livingType) {
		this.livingType = livingType;
	}

	public String getOtherNationDesc() {
		return otherNationDesc;
	}

	public void setOtherNationDesc(String otherNationDesc) {
		this.otherNationDesc = otherNationDesc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(Integer signFlag) {
		this.signFlag = signFlag;
	}

	public String getPopulationCategory() {
		return populationCategory;
	}

	public void setPopulationCategory(String populationCategory) {
		this.populationCategory = populationCategory;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getBeginFillDate() {
		return beginFillDate;
	}

	public void setBeginFillDate(Date beginFillDate) {
		this.beginFillDate = beginFillDate;
	}

	public Date getFinshFillDate() {
		return finshFillDate;
	}

	public void setFinshFillDate(Date finshFillDate) {
		this.finshFillDate = finshFillDate;
	}

	public void setHealthFileNoHtml(String healthFileNoHtml) {
		this.healthFileNoHtml = healthFileNoHtml;
	}

	public String getHrGroup() {
		return hrGroup;
	}

	public void setHrGroup(String hrGroup) {
		this.hrGroup = hrGroup;
	}

	public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}

	public String getPoverty() {
		return poverty;
	}

	public void setPoverty(String poverty) {
		this.poverty = poverty;
	}


	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getPovertyType() {
		return povertyType;
	}

	public void setPovertyType(String povertyType) {
		this.povertyType = povertyType;
	}

	public String getVeryPoverty() {
		return veryPoverty;
	}

	public void setVeryPoverty(String veryPoverty) {
		this.veryPoverty = veryPoverty;
	}

	public String getVeryPovertyType() {
		return veryPovertyType;
	}

	public void setVeryPovertyType(String veryPovertyType) {
		this.veryPovertyType = veryPovertyType;
	}

	public Long getSignId() {
		return signId;
	}

	public void setSignId(Long signId) {
		this.signId = signId;
	}

	public String getCreateIdcard() {
		return createIdcard;
	}

	public void setCreateIdcard(String createIdcard) {
		this.createIdcard = createIdcard;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreateCenterOrganCode() {
		return createCenterOrganCode;
	}

	public void setCreateCenterOrganCode(String createCenterOrganCode) {
		this.createCenterOrganCode = createCenterOrganCode;
	}

	public String getCreateGbcode() {
		return createGbcode;
	}

	public void setCreateGbcode(String createGbcode) {
		this.createGbcode = createGbcode;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMaternalFlag() {
		return maternalFlag;
	}

	public void setMaternalFlag(String maternalFlag) {
		this.maternalFlag = maternalFlag;
	}

	public Date getEstimatedDueDate() {
		return estimatedDueDate;
	}

	public void setEstimatedDueDate(Date estimatedDueDate) {
		this.estimatedDueDate = estimatedDueDate;
	}

	public Date getLastMenstrualDate() {
		return lastMenstrualDate;
	}

	public void setLastMenstrualDate(Date lastMenstrualDate) {
		this.lastMenstrualDate = lastMenstrualDate;
	}

	public int getEhrFlag() {
		return ehrFlag;
	}

	public void setEhrFlag(int ehrFlag) {
		this.ehrFlag = ehrFlag;
	}

	public boolean isPersonInfoAdditionalFlag() {
		return personInfoAdditionalFlag;
	}

	public void setPersonInfoAdditionalFlag(boolean personInfoAdditionalFlag) {
		this.personInfoAdditionalFlag = personInfoAdditionalFlag;
	}
	
	
}