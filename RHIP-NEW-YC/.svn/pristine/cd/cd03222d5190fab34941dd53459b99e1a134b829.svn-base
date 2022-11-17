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
@Table(name = "DHS_FAMILY_HEREDITY_HISTORY")
public class FamilyHeredityHistory implements Serializable {

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

    @Column(name = "PATIENT_NAME", columnDefinition = "VARCHAR2|遗传病人姓名||", length = 50, nullable = true)
    private String patientName;

    @Column(name = "PATIENT_SEX", columnDefinition = "VARCHAR2|遗传病人性别||", length = 1, nullable = true)
    private String patientSex;

    @Column(name = "ASK_DATE", columnDefinition = "NUMBER|遗传病人发病年份||", length = 5, nullable = true)
    private Integer askDate;

    @RecordTrace
    @Column(name = "HEREDITYHISTORY", columnDefinition = "VARCHAR2|遗传病人疾病描述||", length = 100, nullable = true)
    private String heredityhistory;

    @Column(name = "RELATION", columnDefinition = "VARCHAR2|遗传病人与本人关系代码||", length = 2, nullable = true)
    private String relation;

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
	private String patientSexDesc;
	
	@Transient
	private String relationDesc;

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

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return this.patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Integer getAskDate() {
        return this.askDate;
    }

    public void setAskDate(Integer askDate) {
        this.askDate = askDate;
    }

    public String getHeredityhistory() {
        return this.heredityhistory;
    }

    public void setHeredityhistory(String heredityhistory) {
        this.heredityhistory = heredityhistory;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

	
	public String getPatientSexDesc() {
		return patientSexDesc;
	}

	
	public void setPatientSexDesc(String patientSexDesc) {
		this.patientSexDesc = patientSexDesc;
	}

	
	public String getRelationDesc() {
		return relationDesc;
	}

	
	public void setRelationDesc(String relationDesc) {
		this.relationDesc = relationDesc;
	}

    

}
