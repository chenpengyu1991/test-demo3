package com.founder.rhip.ehr.entity.management;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DM_PERSON_INFO_RH")
public class DmPersonInfoRh implements Serializable{
	
	private static final long serialVersionUID = 4567287506688410248L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "SOURCE_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Long sourceId;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构 中心冗余||", length = 50, nullable = true)
	private String createCenterOrganCode;

	@Column(name = "CREATE_GBCODE", columnDefinition = "VARCHAR2|填报镇||", length = 50, nullable = true)
	private String createGbcode;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;
	
	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String hrtownShip;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
	private String hrstreet;

	@Column(name = "RECORD_CHANGE_TIME", columnDefinition = "DATE|迁移时间||", nullable = true)
	private Date recordChangeTime;
	
	private String name;
	   
    private String idcard;
    
	private String villageName;
    
    //现机构编码
    private String currentOrganCode;
    
    //高血压
    private String hbpFlag;
    //糖尿病
    private String diFlag;
    //肿瘤
    private String tumorFlag;
    //冠心病
    private String coronaryFlag;
    //脑卒中
    private String strokeFlag;
    
    private String operator;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public String getCreateOrganCode() {
		return createOrganCode;
	}
	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}
	public String getCreateCenterOrganCode() {
		return createCenterOrganCode;
	}
	public void setCreateCenterOrganCode(String createCenterOrganCode) {
		this.createCenterOrganCode = createCenterOrganCode;
	}
	public String getCreateGbcode() {
		return createGbcode;
	}
	public void setCreateGbcode(String createGbcode) {
		this.createGbcode = createGbcode;
	}
	public String getPatownShip() {
		return patownShip;
	}
	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}
	public String getPastreet() {
		return pastreet;
	}
	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}
	public String getHrtownShip() {
		return hrtownShip;
	}
	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}
	public String getHrstreet() {
		return hrstreet;
	}
	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
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
	public String getHbpFlag() {
		return hbpFlag;
	}
	public void setHbpFlag(String hbpFlag) {
		this.hbpFlag = hbpFlag;
	}
	public String getDiFlag() {
		return diFlag;
	}
	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}
	public String getTumorFlag() {
		return tumorFlag;
	}
	public void setTumorFlag(String tumorFlag) {
		this.tumorFlag = tumorFlag;
	}
	public String getCoronaryFlag() {
		return coronaryFlag;
	}
	public void setCoronaryFlag(String coronaryFlag) {
		this.coronaryFlag = coronaryFlag;
	}
	public String getStrokeFlag() {
		return strokeFlag;
	}
	public void setStrokeFlag(String strokeFlag) {
		this.strokeFlag = strokeFlag;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
}
