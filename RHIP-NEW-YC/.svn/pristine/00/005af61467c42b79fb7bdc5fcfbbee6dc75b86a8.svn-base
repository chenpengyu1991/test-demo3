package com.founder.rhip.ehr.entity.summary;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_FAMILY_BED_HISTORY")
public class FamilyBedHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "HOSPITAL", columnDefinition = "VARCHAR2|建立家庭病床医疗机构名称||", length = 70, nullable = true)
    private String hospital;

    @RecordTrace
    @Column(name = "BUILT_BED_DATE", columnDefinition = "DATE|家庭病床建床日期||", nullable = true)
    private Date builtBedDate;

    @RecordTrace
    @Column(name = "REMOVE_BED_DATE", columnDefinition = "DATE|家庭病床撤床日期||", nullable = true)
    private Date removeBedDate;

    @Column(name = "SICKBED_DAY", columnDefinition = "NUMBER|家庭病床建立天数||", length = 5, nullable = true)
    private Integer sickbedDay;

    @RecordTrace
    @Column(name = "BUILT_BED_REASON", columnDefinition = "VARCHAR2|家庭病床建立原因||", length = 100, nullable = true)
    private String builtBedReason;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @RecordTrace
    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @RecordTrace
    @Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病案号 ||", length = 18, nullable = true)
    private String medicalRecordNo;

    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|建档日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

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

    public String getHospital() {
        return this.hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getBuiltBedDate() {
        return this.builtBedDate;
    }

    public void setBuiltBedDate(Date builtBedDate) {
        this.builtBedDate = builtBedDate;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public Date getRemoveBedDate() {
        return removeBedDate;
    }

    public void setRemoveBedDate(Date removeBedDate) {
        this.removeBedDate = removeBedDate;
    }

    public Integer getSickbedDay() {
        return this.sickbedDay;
    }

    public void setSickbedDay(Integer sickbedDay) {
        this.sickbedDay = sickbedDay;
    }

    public String getBuiltBedReason() {
        return this.builtBedReason;
    }

    public void setBuiltBedReason(String builtBedReason) {
        this.builtBedReason = builtBedReason;
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
    
    
}
