package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BI_ARCHIVES_MOVE_RECORD")
public class PersonMoveInfo implements Serializable {
	
	private static final long serialVersionUID = -3035569298951021258L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人编号||", length = 32, nullable = true)
    private Long personId;
    
    @Column(name = "PERSON_NAME", columnDefinition = "NUMBER|个人姓名||", length = 50, nullable = true)
    private String personName;
    
    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "OLD_STATION_CODE", columnDefinition = "VARCHAR2|原管理机构代码||", length = 20, nullable = true)
    private String oldStationCode;

    @Column(name = "OLD_STATION_NAME", columnDefinition = "VARCHAR2|原管理机构名称||", length = 500, nullable = true)
    private String oldStationName;

    @Column(name = "NEW_STATION_CODE", columnDefinition = "VARCHAR2|新管理机构代码||", length = 20, nullable = true)
    private String newStationCode;

    @Column(name = "NEW_STATION_NAME", columnDefinition = "VARCHAR2|新管理机构名称||", length = 500, nullable = true)
    private String newStationName;

    @Column(name = "OPERATOR_ID", columnDefinition = "VARCHAR2|操作者ID||", length = 11, nullable = true)
    private String operatorId;

    @Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者名称||", length = 50, nullable = true)
    private String operator;

    @Column(name = "OPERATION_DATE", columnDefinition = "DATE|操作时间||", length = 15, nullable = true)
    private Date operationDate;
    
    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSmpiId() {
		return smpiId;
	}

	public void setSmpiId(String smpiId) {
		this.smpiId = smpiId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getOldStationCode() {
		return oldStationCode;
	}

	public void setOldStationCode(String oldStationCode) {
		this.oldStationCode = oldStationCode;
	}

	public String getOldStationName() {
		return oldStationName;
	}

	public void setOldStationName(String oldStationName) {
		this.oldStationName = oldStationName;
	}

	public String getNewStationCode() {
		return newStationCode;
	}

	public void setNewStationCode(String newStationCode) {
		this.newStationCode = newStationCode;
	}

	public String getNewStationName() {
		return newStationName;
	}

	public void setNewStationName(String newStationName) {
		this.newStationName = newStationName;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
