package com.founder.rhip.ehr.entity.control.idm.special;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_FG")
public class ListFg implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "CONTACT_PATIENT_ID", columnDefinition = "VARCHAR2|患者关联|100|", length = 100, nullable = false)
	private Long contactPatientId;
	
	@Column(name = "PATIENT_NAME", columnDefinition = "VARCHAR2|患者姓名|50|", length = 50, nullable = true)
	private String patientName;

	@Column(name = "PATIENT_IDCARD", columnDefinition = "VARCHAR2|患者身份证号码|18|", length = 18, nullable = true)
	private String patientIdcard;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长或监护人姓名|50|", length = 50, nullable = true)
	private String parentsName;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|2|", length = 2, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
	private String age;

	@Column(name = "WEIGHT", columnDefinition = "VARCHAR2|体重|20|", length = 20, nullable = true)
	private String weight;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现居住地省|20|", length = 20, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现居住地市|20|", length = 20, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现居住地县区|20|", length = 20, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现居住地乡街道|100|", length = 100, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现居住地村社区|100|", length = 100, nullable = true)
	private String pastreet;

	@Column(name = "PAHOME_NUMBER", columnDefinition = "VARCHAR2|现居住地详细|100|", length = 100, nullable = true)
	private String pahomeNumber;

    @Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现居住地详细|100|", length = 100, nullable = true)
    private String paAddress;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "REST_OBJECT", columnDefinition = "VARCHAR2|休治对象|2|", length = 2, nullable = true)
	private String restObject;

	@Column(name = "DUTY_DOCTOR", columnDefinition = "VARCHAR2|督导服药人|50|", length = 50, nullable = true)
	private String dutyDoctor;

	@Column(name = "DRUG_NORM", columnDefinition = "VARCHAR2|服药是否规范|2|", length = 2, nullable = true)
	private String drugNorm;

	@Column(name = "DRUG_OBJECT", columnDefinition = "VARCHAR2|是否为应服对象|2|", length = 2, nullable = true)
	private String drugObject;

	@Column(name = "NO_OBJECT_RESULT", columnDefinition = "VARCHAR2|非应服对象原因|2|", length = 2, nullable = true)
	private String noObjectResult;

	@Column(name = "NO_OBJECT_OTHER", columnDefinition = "VARCHAR2|非应服对象原因-其他|200|", length = 200, nullable = true)
	private String noObjectOther;

	@Column(name = "NO_WHOLE_RESULT", columnDefinition = "VARCHAR2|未全程规范服药原因|2|", length = 2, nullable = true)
	private String noWholeResult;

	@Column(name = "NO_WHOLE_OTHER", columnDefinition = "VARCHAR2|未全程规范服药原因-其他|200|", length = 200, nullable = true)
	private String noWholeOther;

	@Column(name = "REST_DUTY_DOCTOR", columnDefinition = "VARCHAR2|休止期督导服药人|50|", length = 50, nullable = true)
	private String restDutyDoctor;

	@Column(name = "REPORT_ORG", columnDefinition = "VARCHAR2|上报单位|100|", length = 100, nullable = true)
	private String reportOrg;

	@Column(name = "REPORT_DATE", columnDefinition = "DATE|上报日期||", nullable = true)
	private Date reportDate;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|人员类型|20|", length = 20, nullable = true)
	private String flag;
	
    @Column(name = "ACCEPT_UNIT", columnDefinition = "VARCHAR2|接收单位|100|", length = 100, nullable = true)
    private String acceptUnit;

    @Column(name = "ACCEPT_TOWN", columnDefinition = "VARCHAR2|接收单位所属位置|100|", length = 100, nullable = true)
    private String acceptTown;

    
    private PersonInfo personInfo;
    
    public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this);
			personInfo.setIdcard(this.getPatientIdcard());
            personInfo.setId(null);
        }
        return personInfo;
    }
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientIdcard() {
		return this.patientIdcard;
	}

	public void setPatientIdcard(String patientIdcard) {
		this.patientIdcard = patientIdcard;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentsName() {
		return this.parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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

	public String getPahomeNumber() {
		return this.pahomeNumber;
	}

	public void setPahomeNumber(String pahomeNumber) {
		this.pahomeNumber = pahomeNumber;
	}

    public String getPaAddress() {
        return paAddress;
    }

    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRestObject() {
		return this.restObject;
	}

	public void setRestObject(String restObject) {
		this.restObject = restObject;
	}

	public String getDutyDoctor() {
		return this.dutyDoctor;
	}

	public void setDutyDoctor(String dutyDoctor) {
		this.dutyDoctor = dutyDoctor;
	}

	public String getDrugNorm() {
		return this.drugNorm;
	}

	public void setDrugNorm(String drugNorm) {
		this.drugNorm = drugNorm;
	}

	public String getDrugObject() {
		return this.drugObject;
	}

	public void setDrugObject(String drugObject) {
		this.drugObject = drugObject;
	}

	public String getNoObjectResult() {
		return this.noObjectResult;
	}

	public void setNoObjectResult(String noObjectResult) {
		this.noObjectResult = noObjectResult;
	}

	public String getNoObjectOther() {
		return this.noObjectOther;
	}

	public void setNoObjectOther(String noObjectOther) {
		this.noObjectOther = noObjectOther;
	}

	public String getNoWholeResult() {
		return this.noWholeResult;
	}

	public void setNoWholeResult(String noWholeResult) {
		this.noWholeResult = noWholeResult;
	}

	public String getNoWholeOther() {
		return this.noWholeOther;
	}

	public void setNoWholeOther(String noWholeOther) {
		this.noWholeOther = noWholeOther;
	}

	public String getRestDutyDoctor() {
		return this.restDutyDoctor;
	}

	public void setRestDutyDoctor(String restDutyDoctor) {
		this.restDutyDoctor = restDutyDoctor;
	}

	public String getReportOrg() {
		return this.reportOrg;
	}

	public void setReportOrg(String reportOrg) {
		this.reportOrg = reportOrg;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the acceptUnit
	 */
	public String getAcceptUnit() {
		return acceptUnit;
	}

	/**
	 * @param acceptUnit the acceptUnit to set
	 */
	public void setAcceptUnit(String acceptUnit) {
		this.acceptUnit = acceptUnit;
	}

	/**
	 * @return the acceptTown
	 */
	public String getAcceptTown() {
		return acceptTown;
	}

	/**
	 * @param acceptTown the acceptTown to set
	 */
	public void setAcceptTown(String acceptTown) {
		this.acceptTown = acceptTown;
	}

	/**
	 * @return the contactPatientId
	 */
	public Long getContactPatientId() {
		return contactPatientId;
	}

	/**
	 * @param contactPatientId the contactPatientId to set
	 */
	public void setContactPatientId(Long contactPatientId) {
		this.contactPatientId = contactPatientId;
	}

}