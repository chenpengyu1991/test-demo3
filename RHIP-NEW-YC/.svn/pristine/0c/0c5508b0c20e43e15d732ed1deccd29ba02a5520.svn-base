package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.rhip.ehr.common.IntegrationNumberType;

@Entity
@Table(name = "FS_INTEGRATION_LOG")
public class IntegrationLog implements Serializable {

	private static final long serialVersionUID = 8617266736652008854L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
    
    @Column(name = "CLINIC_PEOPLE_NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String clinicPeopleName;
    
    @Column(name = "EVENT_NAME", columnDefinition = "VARCHAR2|活动名||", length = 50, nullable = true)
    private String eventName;
	
	@Column(name = "NUMBER_CODE", columnDefinition = "VARCHAR2|编号代码||", length = 10, nullable = true)
	private String numberCode;
	
	@Column(name = "NUMBER_NAME", columnDefinition = "VARCHAR2|编号名称||", length = 50, nullable = true)
	private String numberName;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 15, nullable = true)
	private String organCode;
	
	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|机构名称||", length = 100, nullable = true)
	private String organName;
	
    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 50, nullable = false)
    private String ehrId;
    
    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录编号||", length = 50, nullable = false)
    private String recordNumber;
    
	@Column(name = "FLOW_TYPE", columnDefinition = "VARCHAR2|流程类型||", length = 6, nullable = true)
	private String flowType;
	
	@Column(name = "FLOW_NAME", columnDefinition = "VARCHAR2|流程名称||", length = 50, nullable = true)
	private String flowName;
	
	@Column(name = "ERROR_REASON", columnDefinition = "VARCHAR2|出错原因||", length = 500, nullable = true)
	private String errorReason;
	
	@Column(name = "RECORD_DATE", columnDefinition = "DATE|记录时间||", nullable = true)
	private Date recordDate;
	
	@Column(name = "RECORD_NAME", columnDefinition = "VARCHAR2|记录人姓名||", length = 50, nullable = true)
	private String recordName;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态||", length = 1, nullable = true)
	private Integer status;
	
	@Column(name = "FILE_NAME", columnDefinition = "VARCHAR2|CDA文档名称||", length = 100, nullable = true)
	private String fileName;

    @Column(name = "FULL_FLAG", columnDefinition = "VARCHAR2|完整性：0完整，1不完整，默认0||", length = 100, nullable = true)
    private String fullFlag;

    @Column(name = "CODE_FLAG", columnDefinition = "VARCHAR2|值域标准性：0标准，1不标准，默认0||", length = 100, nullable = true)
    private String codeFlag;

    @Column(name = "LOGIC_FLAG", columnDefinition = "VARCHAR2|逻辑性：0符合，1不符合，默认0||", length = 100, nullable = true)
    private String logicFlag;

	@Transient
	private Date recordDateBegin;
	
	@Transient
	private Date recordDateEnd;

    @Transient
    private String abnormalType;
	
	public IntegrationLog() {
	}

	public IntegrationLog(Long personId, String clinicPeopleName, String organCode,
			String organName, IntegrationNumberType integrationNumberType, String ehrId, String recordNumber, String flowType, String flowName,
			String errorReason, Date recordDate, String recordName, Integer status,
			String fileName) {
		super();
		this.personId = personId;
		this.clinicPeopleName = clinicPeopleName;
		this.eventName = integrationNumberType.getName();
		this.numberCode = integrationNumberType.getCode();
		this.numberName = integrationNumberType.getName();
		this.organCode = organCode;
		this.organName = organName;
		this.ehrId = ehrId;
		this.recordNumber = recordNumber;
		this.flowType = flowType;
		this.flowName = flowName;
		this.errorReason = errorReason;
		this.recordDate = recordDate;
		this.recordName = recordName;
		this.status = status;
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumberCode() {
		return numberCode;
	}

	public void setNumberCode(String numberCode) {
		this.numberCode = numberCode;
	}
	
	public String getNumberName() {
		return numberName;
	}
	
	public void setNumberName(String numberName) {
		this.numberName = numberName;
	}
	
	public String getOrganCode() {
		return organCode;
	}
	
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return organName;
	}
	
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	
	public String getEhrId() {
		return ehrId;
	}
	
	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}
	
	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	public String getFlowType() {
		return flowType;
	}
	
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	
	public String getFlowName() {
		return flowName;
	}
	
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	
	public String getErrorReason() {
		return errorReason;
	}
	
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	
	public Date getRecordDate() {
		return recordDate;
	}
	
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	public String getRecordName() {
		return recordName;
	}
	
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}


	
	public String getClinicPeopleName() {
		return clinicPeopleName;
	}

	public void setClinicPeopleName(String clinicPeopleName) {
		this.clinicPeopleName = clinicPeopleName;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getRecordDateBegin() {
		return recordDateBegin;
	}

	public void setRecordDateBegin(Date recordDateBegin) {
		this.recordDateBegin = recordDateBegin;
	}

	public Date getRecordDateEnd() {
		return recordDateEnd;
	}

	public void setRecordDateEnd(Date recordDateEnd) {
		this.recordDateEnd = recordDateEnd;
	}


    public String getFullFlag() {
        return fullFlag;
    }

    public void setFullFlag(String fullFlag) {
        this.fullFlag = fullFlag;
    }

    public String getCodeFlag() {
        return codeFlag;
    }

    public void setCodeFlag(String codeFlag) {
        this.codeFlag = codeFlag;
    }

    public String getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(String logicFlag) {
        this.logicFlag = logicFlag;
    }

    public String getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(String abnormalType) {
        this.abnormalType = abnormalType;
    }
}
