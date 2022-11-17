package com.founder.rhip.ehr.entity.summary;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_TRAUMA_HISTORY")
public class TraumaHistory implements Serializable {

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
    
    @Column(name = "OPS_NAME", columnDefinition = "VARCHAR2|外伤部位||", length = 100, nullable = true)
    private String opsName;

    @RecordTrace
    @Column(name = "PRE_OPS_DATE", columnDefinition = "DATE|上次外伤发生日期||", nullable = true)
    private Date preOpsDate;

    @RecordTrace
    @Column(name = "OPS_DATE", columnDefinition = "TIMESTAMP|外伤发生日期||", nullable = true)
    private Date opsDate;

    @Column(name = "OPERATION_CODE", columnDefinition = "VARCHAR2|外伤发生地点||", length = 100, nullable = true)
    private String operationCode;

    @Column(name = "HOS_NAME", columnDefinition = "VARCHAR2|外伤发生原因||", length = 100, nullable = true)
    private String hosName;

    @Column(name = "TREATMENT_TIME", columnDefinition = "TIMESTAMP|就诊日期||", nullable = true)
    private Date treatmentTime;

    @Column(name = "HURT_TYPE", columnDefinition = "VARCHAR2|伤害物体||", length = 10, nullable = true)
    private String hurtType;

    @Column(name = "DOCTOR_ADVISE", columnDefinition = "VARCHAR2|医生建议||", length = 1, nullable = true)
    private String doctorAdvise;

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

    @Column(name = "BITE_LEVEL", columnDefinition = "NUMBER|咬伤等级||", length = 1, nullable = true)
    private Integer biteLevel;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

    @Column(name = "HURT_SOURCE", columnDefinition = "VARCHAR2|动物来源||", length = 25, nullable = true)
    private String  hurtSource;

    @Column(name = "EXPOSE_TYPE", columnDefinition = "VARCHAR2|暴露方式||", length = 25, nullable = true)
    private String  exposeType;

    @Column(name = "HURT_STATUS", columnDefinition = "VARCHAR2|动物状况||", length = 25, nullable = true)
    private String  hurtStatus;

    @Column(name = "HURT_NATURE", columnDefinition = "VARCHAR2|被伤性质||", length = 25, nullable = true)
    private String  hurtNature;

    @Column(name = "FLUSH_METHOD", columnDefinition = "VARCHAR2|冲洗方法||", length = 300, nullable = true)
    private String  flushMethod;

    @Column(name = "FLUSH_TIME", columnDefinition = "VARCHAR2|冲洗时长||", length = 20, nullable = true)
    private String  flushTime;

    @Column(name = "DIS_INFECTANT", columnDefinition = "VARCHAR2|消毒剂||", length = 100, nullable = true)
    private String  disInfectant;

    @Column(name = "OTHER_FLUSH_METHOD", columnDefinition = "VARCHAR2|其他冲洗方式||", length = 300, nullable = true)
    private String  otherFlushMethod;

    @Column(name = "OTHER_FLUSH_TIME", columnDefinition = "VARCHAR2|其他冲洗时长||", length = 300, nullable = true)
    private String  otherFlushTime;

    @Column(name = "OTHER_DIS_INFECTANT", columnDefinition = "VARCHAR2|其他消毒剂||", length = 100, nullable = true)
    private String  otherDisInfectant;

    @Column(name = "NO_TREAT", columnDefinition = "VARCHAR2|伤口愈合处理 0：不处理 1：处理||", length = 1, nullable = true)
    private String  noTreat;

    @Column(name = "OTHERHANDLE", columnDefinition = "VARCHAR2|其他处理方式||", length = 100, nullable = true)
    private String otherHandle;

    @Column(name = "OTHERHANDLES", columnDefinition = "VARCHAR2|其他处理方式2||", length = 100, nullable = true)
    private String otherHandles;

    @Transient
    private String hurtOther;

    @Transient
    private String sourceOther;

    @Transient
    private String exposeOther;

    /*咬伤日期-小时*/
    @Transient
    private String opsHour;

    /*就诊日期-小时*/
    @Transient
    private String treatmentHour;

    public Integer getBiteLevel() {
        return biteLevel;
    }

    public void setBiteLevel(Integer biteLevel) {
        this.biteLevel = biteLevel;
    }

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

    public String getOpsName() {
        return this.opsName;
    }

    public void setOpsName(String opsName) {
        this.opsName = opsName;
    }

    public Date getPreOpsDate() {
        return preOpsDate;
    }

    public void setPreOpsDate(Date preOpsDate) {
        this.preOpsDate = preOpsDate;
    }

    public Date getOpsDate() {
        return this.opsDate;
    }

    public void setOpsDate(Date opsDate) {
        this.opsDate = opsDate;
    }

    public String getOperationCode() {
        return this.operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getHosName() {
        return this.hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName;
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

    public Date getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(Date treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public String getHurtType() {
        return hurtType;
    }

    public void setHurtType(String hurtType) {
        this.hurtType = hurtType;
    }

    public String getDoctorAdvise() {
        return doctorAdvise;
    }

    public void setDoctorAdvise(String doctorAdvise) {
        this.doctorAdvise = doctorAdvise;
    }

	public String getHurtOther() {
		return hurtOther;
	}

	public void setHurtOther(String hurtOther) {
		this.hurtOther = hurtOther;
	}

    public String getOpsHour() {
        return opsHour;
    }

    public void setOpsHour(String opsHour) {
        this.opsHour = opsHour;
    }

    public String getTreatmentHour() {
        return treatmentHour;
    }

    public void setTreatmentHour(String treatmentHour) {
        this.treatmentHour = treatmentHour;
    }

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

    public String getHurtSource() {
        return hurtSource;
    }

    public void setHurtSource(String hurtSource) {
        this.hurtSource = hurtSource;
    }

    public String getSourceOther() {
        return sourceOther;
    }

    public void setSourceOther(String sourceOther) {
        this.sourceOther = sourceOther;
    }

    public String getExposeType() {
        return exposeType;
    }

    public void setExposeType(String exposeType) {
        this.exposeType = exposeType;
    }

    public String getExposeOther() {
        return exposeOther;
    }

    public void setExposeOther(String exposeOther) {
        this.exposeOther = exposeOther;
    }

    public String getHurtStatus() {
        return hurtStatus;
    }

    public void setHurtStatus(String hurtStatus) {
        this.hurtStatus = hurtStatus;
    }

    public String getHurtNature() {
        return hurtNature;
    }

    public void setHurtNature(String hurtNature) {
        this.hurtNature = hurtNature;
    }

    public String getFlushMethod() {
        return flushMethod;
    }

    public void setFlushMethod(String flushMethod) {
        this.flushMethod = flushMethod;
    }

    public String getFlushTime() {
        return flushTime;
    }

    public void setFlushTime(String flushTime) {
        this.flushTime = flushTime;
    }

    public String getDisInfectant() {
        return disInfectant;
    }

    public void setDisInfectant(String disInfectant) {
        this.disInfectant = disInfectant;
    }

    public String getOtherFlushMethod() {
        return otherFlushMethod;
    }

    public void setOtherFlushMethod(String otherFlushMethod) {
        this.otherFlushMethod = otherFlushMethod;
    }

    public String getOtherFlushTime() {
        return otherFlushTime;
    }

    public void setOtherFlushTime(String otherFlushTime) {
        this.otherFlushTime = otherFlushTime;
    }

    public String getOtherDisInfectant() {
        return otherDisInfectant;
    }

    public void setOtherDisInfectant(String otherDisInfectant) {
        this.otherDisInfectant = otherDisInfectant;
    }

    public String getNoTreat() {
        return noTreat;
    }

    public void setNoTreat(String noTreat) {
        this.noTreat = noTreat;
    }

    public String getOtherHandle() {
        return otherHandle;
    }

    public void setOtherHandle(String otherHandle) {
        this.otherHandle = otherHandle;
    }

    public String getOtherHandles() {
        return otherHandles;
    }

    public void setOtherHandles(String otherHandles) {
        this.otherHandles = otherHandles;
    }
}
