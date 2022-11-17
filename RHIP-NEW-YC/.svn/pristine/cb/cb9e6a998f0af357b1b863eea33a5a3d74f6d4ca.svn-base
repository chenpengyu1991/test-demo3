package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_HEALTH_RECORD")
public class RpHealthRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）|100|", length = 100, nullable = true)
	private String rpName;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇code|50|", length = 50, nullable = true)
	private String gbCode;

	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心code|50|", length = 50, nullable = true)
	private String centerCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构code|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型|5|", length = 5, nullable = true)
	private String organType;

	@Column(name = "RP_DATE", columnDefinition = "DATE|统计日期（出院日期）||", nullable = true)
	private Date rpDate;

	@Column(name = "RESIDENT_NUM", columnDefinition = "NUMBER|常住人口数|10|", length = 10, nullable = true)
	private Long residentNum = 0l;

	@Column(name = "CREATE_NUM", columnDefinition = "NUMBER|建档数|10|", length = 10, nullable = true)
	private Long createNum = 0l;
	
	@Column(name = "MODIFY_NUM", columnDefinition = "NUMBER|档案更新数|10|", length = 10, nullable = true)
	private Long modifyNum = 0l;
	
	@Column(name = "SHOULD_CREATE_NUM", columnDefinition = "NUMBER|应建档数|10|", length = 10, nullable = true)
	private Long shouldCreateNum = 0l;
	
	@Column(name = "ONE_STAR_NUM", columnDefinition = "NUMBER|一星数|10|", length = 10, nullable = true)
	private Long oneStarNum = 0l;
	
	@Column(name = "ONE_STAR_COMPLETE_NUM", columnDefinition = "NUMBER|一星完整数|10|", length = 10, nullable = true)
	private Long oneStarCompleteNum = 0l;
	
	@Column(name = "TWO_STAR_NUM", columnDefinition = "NUMBER|二星数|10|", length = 10, nullable = true)
	private Long twoStarNum = 0l;
	
	@Column(name = "TWO_STAR_COMPLETE_NUM", columnDefinition = "NUMBER|二星完整数|10|", length = 10, nullable = true)
	private Long twoStarCompleteNum = 0l;
	
	@Column(name = "THREE_STAR_NUM", columnDefinition = "NUMBER|三星数|10|", length = 10, nullable = true)
	private Long threeStarNum = 0l;
	
	@Column(name = "THREE_STAR_COMPLETE_NUM", columnDefinition = "NUMBER|三星完整数|10|", length = 10, nullable = true)
	private Long threeStarCompleteNum = 0l;
	
	@Column(name = "RP_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 20, nullable = true)
	private String rpType;

	@Column(name = "DOCTOR_NUM", columnDefinition = "NUMBER|医技人员数|10|", length = 10, nullable = true)
	private Long doctorNum;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public Date getRpDate() {
		return rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public Long getCreateNum() {
		return createNum;
	}

	public void setCreateNum(Long createNum) {
		this.createNum = createNum;
	}

	public Long getModifyNum() {
		return modifyNum;
	}

	public void setModifyNum(Long modifyNum) {
		this.modifyNum = modifyNum;
	}

	public Long getShouldCreateNum() {
		return shouldCreateNum;
	}

	public void setShouldCreateNum(Long shouldCreateNum) {
		this.shouldCreateNum = shouldCreateNum;
	}

	

	public Long getOneStarCompleteNum() {
		return oneStarCompleteNum;
	}

	public void setOneStarCompleteNum(Long oneStarCompleteNum) {
		this.oneStarCompleteNum = oneStarCompleteNum;
	}

	public Long getTwoStarNum() {
		return twoStarNum;
	}

	public void setTwoStarNum(Long twoStarNum) {
		this.twoStarNum = twoStarNum;
	}

	public Long getTwoStarCompleteNum() {
		return twoStarCompleteNum;
	}

	public void setTwoStarCompleteNum(Long twoStarCompleteNum) {
		this.twoStarCompleteNum = twoStarCompleteNum;
	}

	public Long getThreeStarNum() {
		return threeStarNum;
	}

	public void setThreeStarNum(Long threeStarNum) {
		this.threeStarNum = threeStarNum;
	}

	public Long getThreeStarCompleteNum() {
		return threeStarCompleteNum;
	}

	public void setThreeStarCompleteNum(Long threeStarCompleteNum) {
		this.threeStarCompleteNum = threeStarCompleteNum;
	}

	public Long getOneStarNum() {
		return oneStarNum;
	}

	public void setOneStarNum(Long oneStarNum) {
		this.oneStarNum = oneStarNum;
	}

	public String getRpType() {
		return rpType;
	}

	public void setRpType(String rpType) {
		this.rpType = rpType;
	}

	public Long getResidentNum() {
		return residentNum;
	}

	public void setResidentNum(Long residentNum) {
		this.residentNum = residentNum;
	}

	public Long getDoctorNum() {
		return doctorNum;
	}

	public void setDoctorNum(Long doctorNum) {
		this.doctorNum = doctorNum;
	}
	
}