package com.founder.rhip.ehr.entity.summary;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_TRANS_BLOOD_HISTORY")
public class TransBloodHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 50, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 11, nullable = true)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "BLOOD_TYPE", columnDefinition = "VARCHAR2|输血品种代码||", length = 1, nullable = true)
    private String bloodType;
    
    @Column(name = "BLOOD_TYPE_NAME", columnDefinition = "VARCHAR2|输血品种名称||", length = 50, nullable = true)
    private String bloodTypeName;

    @Column(name = "BLOOD_UNIT", columnDefinition = "VARCHAR2|单位||", length = 8, nullable = true)
    private String bloodUnit;

    @Column(name = "BLOOD_NUM", columnDefinition = "NUMBER|输血数量||", length = 5, nullable = true)
    private Integer bloodNum;

    @RecordTrace
    @Column(name = "BLOOD_DATE", columnDefinition = "DATE|输血日期||", nullable = true)
    private Date bloodDate;

    @Column(name = "BLOOD_REASON", columnDefinition = "VARCHAR2|输血原因||", length = 100, nullable = true)
    private String bloodReason;

    @Column(name = "HOSPITAL", columnDefinition = "VARCHAR2|输血医院名称||", length = 70, nullable = true)
    private String hospital;

    @RecordTrace
    @Column(name = "BEWRITE", columnDefinition = "VARCHAR2|输血反应描述||", length = 100, nullable = true)
    private String bewrite;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|建档日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Transient
	private String bloodTypeDesc;
	
	@Transient
	private String bloodUnitDesc;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodUnit() {
        return this.bloodUnit;
    }

    public void setBloodUnit(String bloodUnit) {
        this.bloodUnit = bloodUnit;
    }

    public Integer getBloodNum() {
        return this.bloodNum;
    }

    public void setBloodNum(Integer bloodNum) {
        this.bloodNum = bloodNum;
    }

    public Date getBloodDate() {
        return this.bloodDate;
    }

    public void setBloodDate(Date bloodDate) {
        this.bloodDate = bloodDate;
    }

    public String getBloodReason() {
        return this.bloodReason;
    }

    public void setBloodReason(String bloodReason) {
        this.bloodReason = bloodReason;
    }

    public String getHospital() {
        return this.hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getBewrite() {
        return this.bewrite;
    }

    public void setBewrite(String bewrite) {
        this.bewrite = bewrite;
    }

    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputIdcard() {
        return this.inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
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

    public Date getInputDate() {
        return this.inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getBloodTypeName() {
		return bloodTypeName;
	}

	
	public void setBloodTypeName(String bloodTypeName) {
		this.bloodTypeName = bloodTypeName;
	}

	public String getBloodTypeDesc() {
		return bloodTypeDesc;
	}

	public void setBloodTypeDesc(String bloodTypeDesc) {
		this.bloodTypeDesc = bloodTypeDesc;
	}

	public String getBloodUnitDesc() {
		return bloodUnitDesc;
	}

	public void setBloodUnitDesc(String bloodUnitDesc) {
		this.bloodUnitDesc = bloodUnitDesc;
	}


}
