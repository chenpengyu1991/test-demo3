package com.founder.rhip.ehr.entity.management;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DM_POTENTIAL_PERSON_INFO")
public class DmPotentialPersonInfo implements Serializable{

	private static final long serialVersionUID = 485646072914672005L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 8, nullable = true)
	private String occupation;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 70, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 70, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 70, nullable = true)
	private String pahouseNumber;
	
	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;

	@Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
	private String papostCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|现住地12位行政区划代码||", length = 12, nullable = true)
	private String gbcode;

	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
	private String inputOrganCode;

	@Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
	private String inputOrganName;

	@Column(name = "FIRST_CONDITIONS_FLAG", columnDefinition = "VARCHAR2|第一类因素标记||", length = 10, nullable = true)
	private String firstConditionsFlag;

	@Column(name = "SECOND_CONDITIONS_FLAG", columnDefinition = "VARCHAR2|第二类因素标记||", length = 10, nullable = true)
	private String secondConditionsFlag;

	@Column(name ="DF",columnDefinition ="VARCHAR2|危险因素种类",length = 255, nullable = true)
	private String df;

	@Column(name ="ABNORMAL",columnDefinition ="VARCHAR2|数据分析时是否出现异常 1.正常，2.异常",length = 255, nullable = true)
	private String abnormal;

	@Column(name ="IS_FROM_ONE",columnDefinition ="VARCHAR2|数据数据是否来自一期 1.是，2.否",length = 255, nullable = true)
	private String isFromOne;

	@Transient
	private String dfCode;

	@Transient
	private String dfName;

	@Transient
	private DmHighriskRiskFactors dmhighriskRiskFactors;
	
	private List<DmPotentialPersonParam> firstClassStandard;
	
	private List<DmPotentialPersonParam> secondClassStandard;
	
	public List<DmPotentialPersonParam> getFirstClassStandard() {
		return firstClassStandard;
	}
	public void setFirstClassStandard(List<DmPotentialPersonParam> firstClassStandard) {
		this.firstClassStandard = firstClassStandard;
	}

	public List<DmPotentialPersonParam> getSecondClassStandard() {
		return secondClassStandard;
	}

	public void setSecondClassStandard(List<DmPotentialPersonParam> secondClassStandard) {
		this.secondClassStandard = secondClassStandard;
	}
	
	public DmHighriskRiskFactors getDmhighriskRiskFactors() {
		return dmhighriskRiskFactors;
	}
	
	public void setDmhighriskRiskFactors(DmHighriskRiskFactors dmhighriskRiskFactors) {
		this.dmhighriskRiskFactors = dmhighriskRiskFactors;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPapostCode() {
		return this.papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	public String getGbcode() {
		return this.gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getInputOrganCode() {
		return this.inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getInputOrganName() {
		return this.inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	public String getFirstConditionsFlag() {
		return this.firstConditionsFlag;
	}

	public void setFirstConditionsFlag(String firstConditionsFlag) {
		this.firstConditionsFlag = firstConditionsFlag;
	}
	public String getSecondConditionsFlag() {
		return secondConditionsFlag;
	}

	public void setSecondConditionsFlag(String secondConditionsFlag) {
		this.secondConditionsFlag = secondConditionsFlag;
	}

	public String getDf() {
		return df;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public String getAbnormal() {
		return abnormal;
	}

	public void setAbnormal(String abnormal) {
		this.abnormal = abnormal;
	}

	public void setDfName(String dfName) {
		this.dfName = dfName;
	}

	public String getDfCode() {
		if(ObjectUtil.isNotEmpty(df)) {
			JSONArray jsonArray = JSONArray.fromObject(df);
			String[] names = new String[jsonArray.size()];
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				names[i] = jsonObject.get("id").toString();
			}
			dfCode = StringUtil.join(names, ",");
		}
		return dfCode;
	}

	public void setDfCode(String dfCode) {
		this.dfCode = dfCode;
		String[] dfValues = dfCode.split(",");
		JSONArray jsonArray = new JSONArray();
		for (String dfValue : dfValues) {
			if(ObjectUtil.isNotEmpty(dfValue)) {
				String[] temp = dfValue.split(":");
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", temp[0]);
				jsonObject.put("name", temp[1]);
				jsonArray.add(jsonObject);
			}
		}
		this.df = jsonArray.toString();
	}

	public String getDfName() {
		if(ObjectUtil.isNotEmpty(df)) {
			JSONArray jsonArray = JSONArray.fromObject(df);
			String[] names = new String[jsonArray.size()];
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				names[i] = jsonObject.get("name").toString();
			}
			dfName = StringUtil.join(names, ",");
		}

		return dfName;
	}

	public String getIsFromOne() {
		return isFromOne;
	}

	public void setIsFromOne(String isFromOne) {
		this.isFromOne = isFromOne;
	}
}