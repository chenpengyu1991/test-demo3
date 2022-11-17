package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 家医履约同步公卫表
 * @author guo.xm
 */
@Entity
@Table(name = "SERVICE_SYNC_TEMP")
public class ServiceSyncTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "RECORD_ID", columnDefinition = "NUMBER||service_record表id|", length = 11, nullable = false)
    private Long recordId;

    @Column(name = "SIGN_ID", columnDefinition = "NUMBER||签约ID|", length = 11, nullable = false)
    private Long signId;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
    
    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号码||", length = 18, nullable = false)
    private String idcard;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|||", length = 64, nullable = false)
    private String name;
    
    @Column(name = "JSON_DATA", columnDefinition = "VARCHAR2|同步内容json||", length = 4000, nullable = false)
    private String jsonData;
    
    @Column(name = "JSON_TYPE", columnDefinition = "NUMBER||JSON类型  1首次签约包体格检查  2血压 3血糖|", length = 2, nullable = true)
    private Integer jsonType;
    
    @Column(name = "EXAM_CODE", columnDefinition = "VARCHAR2||体检编号|", length = 20, nullable = true)
    private String examCode;
    
    @Column(name = "IS_DATA_SYNC", columnDefinition = "NUMBER||数据是否同步到公卫  0 否  1是|", length = 1, nullable = true)
    private Long isDataSync;

    @Column(name = "IS_CODE_SYNC", columnDefinition = "NUMBER||体检编号是否同步到家医  0 否  1是|", length = 1, nullable = true)
    private Long isCodeSync;
    
    @Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|||", length = 64, nullable = true)
    private String createUser;
    
    @Column(name = "CREATE_DATE", columnDefinition = "DATE|||", nullable = true)
    private Date createDate;
    
    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2||机构编码|", length = 20, nullable = true)
    private String organCode;
    
    @Column(name = "SERVICE_TIME", columnDefinition = "DATE||服务时间|", nullable = true)
    private Date serviceTime;
    
	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Long getIsDataSync() {
		return isDataSync;
	}

	public void setIsDataSync(Long isDataSync) {
		this.isDataSync = isDataSync;
	}

	public Long getIsCodeSync() {
		return isCodeSync;
	}

	public void setIsCodeSync(Long isCodeSync) {
		this.isCodeSync = isCodeSync;
	}

	public Integer getJsonType() {
		return jsonType;
	}

	public void setJsonType(Integer jsonType) {
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

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getSignId() {
		return signId;
	}

	public void setSignId(Long signId) {
		this.signId = signId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	
}
