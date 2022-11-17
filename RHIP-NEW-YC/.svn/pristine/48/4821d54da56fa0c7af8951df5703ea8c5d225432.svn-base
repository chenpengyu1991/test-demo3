
package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_CC")
public class ListCc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|传染病唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "PATIENT_NAME", columnDefinition = "VARCHAR2|涂阳患者名称|100|", length = 100, nullable = true)
	private String patientName;

	@Column(name = "REGIST_NO", columnDefinition = "VARCHAR2|涂阳患者登记号|20|", length = 20, nullable = true)
	private String registNo;

	@Column(name = "PATIEN_COUNTIES", columnDefinition = "VARCHAR2|患者所在区县|20|", length = 20, nullable = true)
	private String patientCounties;

	@Column(name = "CLOSE_NAME", columnDefinition = "VARCHAR2|接触者名称|100|", length = 100, nullable = true)
	private String closeName;

	@Column(name = "SEX", columnDefinition = "VARCHAR2|性别|2|", length = 2, nullable = true)
	private String sex;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
	private String age;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|地址|100|", length = 100, nullable = true)
	private String address;

	@Column(name = "CLOSE_TYPE", columnDefinition = "VARCHAR2|接触者类型|2|", length = 2, nullable = true)
	private String closeType;

	@Column(name = "CLOSE_DETAIL", columnDefinition = "VARCHAR2|接触者类型具体|2|", length = 2, nullable = true)
	private String closeDetail;

	@Column(name = "CHECK_DT", columnDefinition = "DATE|筛查日期||", nullable = true)
	private Date checkDt;

	@Column(name = "CHECK_SYMPTON", columnDefinition = "VARCHAR2|筛查者症状|2|", length = 2, nullable = true)
	private String checkSympton;

	@Column(name = "PPD", columnDefinition = "VARCHAR2|PPD试验|2|", length = 2, nullable = true)
	private String ppd;

	@Column(name = "X", columnDefinition = "VARCHAR2|X光检查|2|", length = 2, nullable = true)
	private String x;

	@Column(name = "PIC", columnDefinition = "VARCHAR2|痰涂片检查|2|", length = 2, nullable = true)
	private String pic;

	@Column(name = "DIAGNOSIS_RESULT", columnDefinition = "VARCHAR2|诊断结果|2|", length = 2, nullable = true)
	private String diagnosisResult;

	@Column(name = "DIAGNOSIS_RESULT_DETAIL", columnDefinition = "VARCHAR2|诊断结果描述|50|", length = 50, nullable = true)
	private String diagnosisResultDetail;
	
	@Column(name = "POSITIVE_SIGNS", columnDefinition = "VARCHAR2|阳性体症|2|", length = 2, nullable = true)
	private String positiveSigns;

	@Column(name = "NEW_REGIST_NO", columnDefinition = "VARCHAR2|新确认患者登记号|20|", length = 20, nullable = true)
	private String newRegistNo;

	@Column(name = "REGIST_DT", columnDefinition = "DATE|登记日期||", nullable = true)
	private Date registDt;

	@Column(name = "DORCTOR_NAME", columnDefinition = "VARCHAR2|检查医生名称|50|", length = 59, nullable = true)
	private String dorctorName;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String mofigyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
	private String flag;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "CLOSE_MONTHS", columnDefinition = "VARCHAR2|接触月数||", length = 20, nullable = true)
    private String closeMonths;
    
    @Column(name = "CLOSE_FREQUENCY", columnDefinition = "VARCHAR2|接触频率||", length = 20, nullable = true)
    private String closeFrequency;
    
    @Column(name = "FOLLOWUP_ID", columnDefinition = "NUMBER|随访id ListCC表的id 若它有值则idmId赋值为0|11|", length = 11, nullable = true)
    private Long followupId;
    
	@Transient
	private String acceptTown;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRegistNo() {
		return this.registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getPatientCounties() {
		return this.patientCounties;
	}

	public void setPatientCounties(String patientCounties) {
		this.patientCounties = patientCounties;
	}

	public String getCloseName() {
		return this.closeName;
	}

	public void setCloseName(String closeName) {
		this.closeName = closeName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCloseType() {
		return this.closeType;
	}

	public void setCloseType(String closeType) {
		this.closeType = closeType;
	}

	public String getCloseDetail() {
		return this.closeDetail;
	}

	public void setCloseDetail(String closeDetail) {
		this.closeDetail = closeDetail;
	}

	public Date getCheckDt() {
		return this.checkDt;
	}

	public void setCheckDt(Date checkDt) {
		this.checkDt = checkDt;
	}

    public String getCheckSympton() {
        return checkSympton;
    }

    public void setCheckSympton(String checkSympton) {
        this.checkSympton = checkSympton;
    }

    public String getPpd() {
		return this.ppd;
	}

	public void setPpd(String ppd) {
		this.ppd = ppd;
	}

	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDiagnosisResult() {
		return this.diagnosisResult;
	}

	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getPositiveSigns() {
		return this.positiveSigns;
	}

	public void setPositiveSigns(String positiveSigns) {
		this.positiveSigns = positiveSigns;
	}

	public String getNewRegistNo() {
		return this.newRegistNo;
	}

	public void setNewRegistNo(String newRegistNo) {
		this.newRegistNo = newRegistNo;
	}

	public Date getRegistDt() {
		return this.registDt;
	}

	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}

	public String getDorctorName() {
		return this.dorctorName;
	}

	public void setDorctorName(String dorctorName) {
		this.dorctorName = dorctorName;
	}

	public String getCreateUnit() {
		return this.createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUnit() {
		return this.modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getMofigyUser() {
		return this.mofigyUser;
	}

	public void setMofigyUser(String mofigyUser) {
		this.mofigyUser = mofigyUser;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDiagnosisResultDetail() {
		return diagnosisResultDetail;
	}

	public void setDiagnosisResultDetail(String diagnosisResultDetail) {
		this.diagnosisResultDetail = diagnosisResultDetail;
	}

	public String getAcceptTown() {
		return acceptTown;
	}

	public void setAcceptTown(String acceptTown) {
		this.acceptTown = acceptTown;
	}

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCloseMonths() {
        return closeMonths;
    }

    public void setCloseMonths(String closeMonths) {
        this.closeMonths = closeMonths;
    }

    public String getCloseFrequency() {
        return closeFrequency;
    }

    public void setCloseFrequency(String closeFrequency) {
        this.closeFrequency = closeFrequency;
    }

	public Long getFollowupId() {
		return followupId;
	}

	public void setFollowupId(Long followupId) {
		this.followupId = followupId;
	}
    
}