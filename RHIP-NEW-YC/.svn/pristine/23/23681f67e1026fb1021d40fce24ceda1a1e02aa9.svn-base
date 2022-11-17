package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 同步家医履约表
 * @author guo.xm
 */
@Entity
@Table(name = "SERVICE_SYNC_LOG")
public class ServiceSyncLog implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER||主键|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
    
    @Column(name = "PERSON_IDCARD", columnDefinition = "VARCHAR2|身份证号码||", length = 18, nullable = false)
    private String personIdcard;

    @Column(name = "NAME", columnDefinition = "VARCHAR2||名字|", length = 64, nullable = false)
    private String name;
    
    @Column(name = "JSON_DATA", columnDefinition = "VARCHAR2|同步内容json||", length = 4000, nullable = false)
    private String jsonData;
    
    @Column(name = "IS_SYNC", columnDefinition = "NUMBER||是否同步  0 否  1是|", length = 1, nullable = true)
    private Long isSync;
    
    @Column(name = "JSON_TYPE", columnDefinition = "VARCHAR2||JSON类型 EXAM体检 HM_EXAM老年人体检  CDM_EXAM慢病体检 HBP高血压随访 DI糖尿病随访  HBP_INTERVENE高血压分类干预    DI_INTERVENE糖尿病分类干预|", length = 16, nullable = true)
    private String jsonType;
    
    @Column(name = "EXAM_CODE", columnDefinition = "VARCHAR2||体检编号、随访ID|", length = 20, nullable = true)
    private String examCode;
    
    @Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|||", length = 64, nullable = true)
    private String createUser;
    
    @Column(name = "CREATE_DATE", columnDefinition = "DATE|||", nullable = true)
    private Date createDate;
    
    @Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|||", length = 64, nullable = true)
    private String updateUser;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|||", nullable = true)
    private Date updateDate;

    @Column(name = "SERVICE_DATE", columnDefinition = "DATE||体检时间、随访时间|", nullable = true)
    private Date serviceDate;
    
    @Column(name = "OPERATE", columnDefinition = "VARCHAR2||操作：A 新增   U 修改  D 删除|", length = 10, nullable = true)
    private String operate;
    
    @Column(name = "RECORD_ID", columnDefinition = "NUMBER||FDS  SERVICE_RECORD表的id|", length = 11, nullable = true)
    private Long recordId;
    
	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonIdcard() {
		return personIdcard;
	}

	public void setPersonIdcard(String personIdcard) {
		this.personIdcard = personIdcard;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Long getIsSync() {
		return isSync;
	}

	public void setIsSync(Long isSync) {
		this.isSync = isSync;
	}

	public String getJsonType() {
		return jsonType;
	}

	public void setJsonType(String jsonType) {
		this.jsonType = jsonType;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
}
