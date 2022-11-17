package com.founder.rhip.ehr.entity.summary;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_HOSPITALIZED_HISTORY")
public class HospitalizedHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 50, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 50, nullable = true)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "HOS_NAME", columnDefinition = "VARCHAR2|住院医疗机构名称||", length = 70, nullable = true)
    private String hosName;

    @RecordTrace
    @Column(name = "IN_DATE", columnDefinition = "DATE|人院日期||", nullable = true)
    private Date inDate;

    @RecordTrace
    @Column(name = "OUTHOS_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
    private Date outhosDate;

    @Column(name = "INHOS_DAYS", columnDefinition = "NUMBER|住院天数||", length = 5, nullable = true)
    private Integer inhosDays;

    @RecordTrace
    @Column(name = "INHOS_REASON", columnDefinition = "VARCHAR2|入院原因||", length = 100, nullable = true)
    private String inhosReason;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @RecordTrace
    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|建档日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @RecordTrace
    @Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病案号 ||", length = 18, nullable = true)
    private String medicalRecordNo;
    
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

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getHosName() {
        return this.hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName;
    }

    public Date getInDate() {
        return this.inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getInhosDays() {
        return this.inhosDays;
    }

    public void setInhosDays(Integer inhosDays) {
        this.inhosDays = inhosDays;
    }

    public String getInhosReason() {
        return this.inhosReason;
    }

    public void setInhosReason(String inhosReason) {
        this.inhosReason = inhosReason;
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

    public Date getOuthosDate() {
        return outhosDate;
    }

    public void setOuthosDate(Date outhosDate) {
        this.outhosDate = outhosDate;
    }

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
    
    
}
