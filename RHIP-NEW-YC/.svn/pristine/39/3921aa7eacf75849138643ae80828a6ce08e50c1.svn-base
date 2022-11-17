package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author liuk
 * @since 2014/5/5 10:52
 */
@Table(name = "PERSON_DEATH_RECORD")
public class PersonDeathRecord {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键", length = 11, nullable = true)
    private Long id;
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|居民id", length = 11, nullable = true)
    private Long personId;
    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证", length = 18, nullable = true)
    private String idcard;
    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名", length = 50, nullable = true)
    private String name;
    @Column(name = "REPORT_DATE", columnDefinition = "TIMESTAMP|报告日期", nullable = true)
    private Date reportDate;
    @Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期", nullable = true)
    private Date deathDate;
    @Column(name = "DURATION", columnDefinition = "VARCHAR2|（A）发病至死亡大概时间间隔", length = 10, nullable = true)
    private String duration;
    @Column(name = "D_CAUSE", columnDefinition = "VARCHAR2|（A）直接导致死亡的疾病名称", length = 100, nullable = true)
    private String dCause;
    @Column(name = "CAUSE_A_NAME", columnDefinition = "VARCHAR2|（B）引起（A）的疾病名称", length = 100, nullable = true)
    private String causeAName;
    @Column(name = "CAUSE_A_DUR", columnDefinition = "VARCHAR2|（B）引起（A）大概时间间隔", length = 20, nullable = true)
    private String causeADur;
    @Column(name = "CAUSE_B_NAME", columnDefinition = "VARCHAR2|（c）引起（B）的疾病名称", length = 100, nullable = true)
    private String causeBName;
    @Column(name = "CAUSE_B_DUR", columnDefinition = "VARCHAR2|（c）引起（B）大概时间间隔", length = 20, nullable = true)
    private String causeBDur;
    @Column(name = "OTHER_DIAGNOSE", columnDefinition = "VARCHAR2|其他疾病诊断", length = 100, nullable = true)
    private String otherDiagnose;
    @Column(name = "DEATH_ICD", columnDefinition = "VARCHAR2|根本死因代码", length = 5, nullable = true)
    private String deathIcd;
    @Column(name = "DEATH_REASON", columnDefinition = "VARCHAR2|根本死亡原因名称", length = 200, nullable = true)
    private String deathReason;
    @Column(name = "DEATH_CLASS", columnDefinition = "VARCHAR2|死因分类", length = 2, nullable = true)
    private String deathClass;
    @Column(name = "ORGAN_LEVEL", columnDefinition = "VARCHAR2|最高诊断机构级别代码", length = 2, nullable = true)
    private String organLevel;
    @Column(name = "PLACE_TYPE", columnDefinition = "VARCHAR2|死亡地点类别代码", length = 2, nullable = true)
    private String placeType;
    @Column(name = "HOSPITAL", columnDefinition = "VARCHAR2|死亡时所在医院名称", length = 70, nullable = true)
    private String hospital;
    @Column(name = "DEATH_BASIS", columnDefinition = "VARCHAR2|死亡诊断依据代码", length = 2, nullable = true)
    private String deathBasis;
    @Column(name = "INPUT_ORGANCODE", columnDefinition = "VARCHAR2|录入机构编码", length = 100, nullable = true)
    private String inputOrgancode;
    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|录入人身份证号", length = 18, nullable = true)
    private String inputIdcard;
    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|录入日期和时间", nullable = true)
    private Date inputDate;
    @Column(name = "INPUT_USER", columnDefinition = "VARCHAR2|创建记录用户", length = 20, nullable = true)
    private String inputUser;
    @Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|更新记录用户", length = 20, nullable = true)
    private String updateUser;
    @Column(name = "UPDATE_ORGANCODE", columnDefinition = "VARCHAR2|更新记录机构", length = 100, nullable = true)
    private String updateOrgancode;
    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新时间", nullable = true)
    private Date updateDate;
    @Column(name = "CANCEL_STATUS", columnDefinition = "VARCHAR2|注销状态", nullable = true)
    private String cancelStatus;

    @Column(name = "PERSON_TYPE", columnDefinition = "VARCHAR2|群人分类：【1：5岁以下，2孕产妇，3其他】", nullable = true)
    private String personType;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码", length = 1, nullable = true)
    private String gender;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族", length = 2, nullable = true)
    private String nation;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码", length = 11, nullable = true)
    private String occupation;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码", length = 2, nullable = true)
    private String marriage;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码", length = 5, nullable = true)
    private String education;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作单位名称", length = 70, nullable = true)
    private String unitName;

    @Column(name = "BIRTHDAY", columnDefinition = "VARCHAR2|出生日期", nullable = true)
    private Date birthday;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|实足年龄", length = 5, nullable = true)
    private String age;

    @Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人姓名", length = 50, nullable = true)
    private String contactName;

    @Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家人电话号码", length = 20, nullable = true)
    private String familyPhone;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号", length = 32, nullable = true)
    private String admissionNo;

    @Column(name = "CAUSE_C_NAME", columnDefinition = "VARCHAR2|直接死亡原因c名称", length = 100, nullable = true)
    private String causeCName;

    @Column(name = "CAUSE_C_DUR", columnDefinition = "VARCHAR2|引起（C）大概时间间隔", length = 20, nullable = true)
    private String causeCDur;

    @Column(name = "CAUSE_D_NAME", columnDefinition = "VARCHAR2|直接死亡原因D名称", length = 100, nullable = true)
    private String causeDName;

    @Column(name = "CAUSE_D_DUR", columnDefinition = "VARCHAR2|引起（D）大概时间间隔", length = 20, nullable = true)
    private String causeDDur;

    @Transient
    private int total;
    @Transient
    private int one;
    @Transient
    private int two;
    @Transient
    private int three;
    @Transient
    private int four;
    @Transient
    private int five;
    @Transient
    private int six;
    @Transient
    private int seven;
    @Transient
    private int eight;
    @Transient
    private int nine;
    @Transient
    private int ten;

    @Transient
    private String filingFlag; // 0：未建档 1：已建档，3 已退回 9已注销 4无身份证 5待审核

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getdCause() {
        return dCause;
    }

    public void setdCause(String dCause) {
        this.dCause = dCause;
    }

    public String getCauseAName() {
        return causeAName;
    }

    public void setCauseAName(String causeAName) {
        this.causeAName = causeAName;
    }

    public String getCauseADur() {
        return causeADur;
    }

    public void setCauseADur(String causeADur) {
        this.causeADur = causeADur;
    }

    public String getCauseBName() {
        return causeBName;
    }

    public void setCauseBName(String causeBName) {
        this.causeBName = causeBName;
    }

    public String getCauseBDur() {
        return causeBDur;
    }

    public void setCauseBDur(String causeBDur) {
        this.causeBDur = causeBDur;
    }

    public String getOtherDiagnose() {
        return otherDiagnose;
    }

    public void setOtherDiagnose(String otherDiagnose) {
        this.otherDiagnose = otherDiagnose;
    }

	public String getDeathIcd() {
		return deathIcd;
	}

	public void setDeathIcd(String deathIcd) {
		this.deathIcd = deathIcd;
	}

	public String getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

    public String getDeathClass() {
        return deathClass;
    }

    public void setDeathClass(String deathClass) {
        this.deathClass = deathClass;
    }

    public String getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(String organLevel) {
        this.organLevel = organLevel;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDeathBasis() {
        return deathBasis;
    }

    public void setDeathBasis(String deathBasis) {
        this.deathBasis = deathBasis;
    }

    public String getInputOrgancode() {
        return inputOrgancode;
    }

    public void setInputOrgancode(String inputOrgancode) {
        this.inputOrgancode = inputOrgancode;
    }

    public String getInputIdcard() {
        return inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateOrgancode() {
        return updateOrgancode;
    }

    public void setUpdateOrgancode(String updateOrgancode) {
        this.updateOrgancode = updateOrgancode;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

	public int getSeven() {
		return seven;
	}

	public void setSeven(int seven) {
		this.seven = seven;
	}


	public int getEight() {
		return eight;
	}

	public void setEight(int eight) {
		this.eight = eight;
	}

	public int getNine() {
		return nine;
	}

	public void setNine(int nine) {
		this.nine = nine;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getCauseDDur() {
        return causeDDur;
    }

    public void setCauseDDur(String causeDDur) {
        this.causeDDur = causeDDur;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getCauseCName() {
        return causeCName;
    }

    public void setCauseCName(String causeCName) {
        this.causeCName = causeCName;
    }

    public String getCauseCDur() {
        return causeCDur;
    }

    public void setCauseCDur(String causeCDur) {
        this.causeCDur = causeCDur;
    }

    public String getCauseDName() {
        return causeDName;
    }

    public void setCauseDName(String causeDName) {
        this.causeDName = causeDName;
    }

    public String getFilingFlag() {
        return filingFlag;
    }

    public void setFilingFlag(String filingFlag) {
        this.filingFlag = filingFlag;
    }
}
