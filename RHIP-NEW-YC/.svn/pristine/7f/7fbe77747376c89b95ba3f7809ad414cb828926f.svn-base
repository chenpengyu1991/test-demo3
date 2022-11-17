package com.founder.rhip.ehr.entity.summary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_DISEASE_HISTORY")
public class DiseaseHistory implements Serializable {

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

    @Column(name = "FORMERLY_TYPE", columnDefinition = "VARCHAR2|既往患病种类代码||", length = 6, nullable = true)
    private String formerlyType;

    @Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|疾病代码||", length = 100, nullable = true)
    private String diseaseCode;

    @Column(name = "DISEASE_NAME", columnDefinition = "VARCHAR2|疾病名称||", length = 100, nullable = true)
    private String diseaseName;

    @Column(name = "CONFIRMATION_DATE", columnDefinition = "DATE|确诊日期||", nullable = true)
    private Date confirmationDate;

    @Column(name = "OUTCOME_CODE", columnDefinition = "VARCHAR2|转归代码||", length = 1, nullable = true)
    private String outcomeCode;

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

    @Column(name = "OTHER_DESC", columnDefinition = "VARCHAR2|其他说明||", length = 100, nullable = true)
    private String otherDesc;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

    @Transient
    private String formerlyTypeDesc;
    
	@Transient
	private String inputDateStr;
    
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

    public String getFormerlyType() {
        return this.formerlyType;
    }

    public void setFormerlyType(String formerlyType) {
        this.formerlyType = formerlyType;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Date getConfirmationDate() {
        return this.confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getOutcomeCode() {
        return this.outcomeCode;
    }

    public void setOutcomeCode(String outcomeCode) {
        this.outcomeCode = outcomeCode;
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

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
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

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

	
	public String getFormerlyTypeDesc() {
		return formerlyTypeDesc;
	}

	
	public void setFormerlyTypeDesc(String formerlyTypeDesc) {
		this.formerlyTypeDesc = formerlyTypeDesc;
	}

	
	public String getInputDateStr() {
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
    
    

}
