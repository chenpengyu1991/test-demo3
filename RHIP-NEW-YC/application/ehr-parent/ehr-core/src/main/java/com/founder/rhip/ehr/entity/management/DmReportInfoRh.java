package com.founder.rhip.ehr.entity.management;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DM_REPORT_INFO_RH")
public class DmReportInfoRh implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = -8768002049647714367L;

@Id
 @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
 private Long id;
 
	@Column(name = "DIS_TYPE", columnDefinition = "VARCHAR2|疾病名称||", length = 50, nullable = true)
	private String disType;
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|迁出机构||", length = 50, nullable = true)
	private String createOrganCode;
	@Column(name = "RECORD_CHANGE_TIME", columnDefinition = "DATE|迁移时间||",  nullable = true)
	private Date recordChangeTime;
	
	 private String name;
	   
	 private String idcard;
	 
	 //现机构编码
	 private String currentOrganCode;
	 
	 private String operator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	
	public Date getRecordChangeTime() {
		return recordChangeTime;
	}

	public void setRecordChangeTime(Date recordChangeTime) {
		this.recordChangeTime = recordChangeTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCurrentOrganCode() {
		return currentOrganCode;
	}

	public void setCurrentOrganCode(String currentOrganCode) {
		this.currentOrganCode = currentOrganCode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	} 
}
