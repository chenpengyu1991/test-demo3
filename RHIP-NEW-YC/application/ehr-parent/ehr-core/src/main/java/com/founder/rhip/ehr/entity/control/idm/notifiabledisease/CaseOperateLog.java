package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "IDM_CASE_OPERATE_LOG")
public class CaseOperateLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|本表唯一编码|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编号|11|", length = 11, nullable = false)
	private Long idmId;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号|11|", length = 11, nullable = true)
	private Long personId;

    @Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型(1: 分配， 2：纳入)|1|", length = 1, nullable = true)
	private String operateType;
    
    @Column(name = "ASSIGN_UNIT", columnDefinition = "VARCHAR2|分配单位|50|", length = 50, nullable = true)
   	private String assignUnit;
    
    @Column(name = "RECEIVING_UNIT", columnDefinition = "VARCHAR2|接受单位|50|", length = 50, nullable = true)
	private String receivingUnit;
    
    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
	private String createOrganCode;

    @Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建操作人|50|", length = 50, nullable = true)
    private String createUserCode;
    
    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
   	private Date createDate;
    
    @Transient
    private String infectiousCode;

	public String getInfectiousCode() {
		return infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getAssignUnit() {
		return assignUnit;
	}

	public void setAssignUnit(String assignUnit) {
		this.assignUnit = assignUnit;
	}

	public String getReceivingUnit() {
		return receivingUnit;
	}

	public void setReceivingUnit(String receivingUnit) {
		this.receivingUnit = receivingUnit;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}