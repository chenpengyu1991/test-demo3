package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MS_TREATMENT_RECORD")
public class TreatmentRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|患者姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "NUMBER|年龄||", length = 3, nullable = true)
	private Long age;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码||", length = 3, nullable = true)
	private String marriage;

	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 24, nullable = true)
	private String othercardno;

	@Column(name = "OP_EM_MARK", columnDefinition = "VARCHAR2|门诊/急诊标识||", length = 1, nullable = true)
	private String opEmMark;

	@Column(name = "OP_EM_NO", columnDefinition = "VARCHAR2|门诊/急诊编号||", length = 24, nullable = true)
	private String opEmNo;

	@Column(name = "TREAT_CODE", columnDefinition = "VARCHAR2|治疗处置项目编码||", length = 24, nullable = true)
	private String treatCode;

	@Column(name = "TREAT_NAME", columnDefinition = "VARCHAR2|治疗处置项目名称||", length = 100, nullable = true)
	private String treatName;

	@Column(name = "TREAT_CONTENT", columnDefinition = "VARCHAR2|治疗处置内容描述||", length = 800, nullable = true)
	private String treatContent;

	@Column(name = "TREAT_NOTICE", columnDefinition = "VARCHAR2|治疗处置注意事项||", length = 800, nullable = true)
	private String treatNotice;

	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 20, nullable = true)
	private String hospitalCode;

	@Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
	private String hospitalName;

	@Column(name = "DEPT_CODE", columnDefinition = "VARCHAR2|机构科室代码||", length = 50, nullable = true)
	private String deptCode;

	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|机构科室名称||", length = 100, nullable = true)
	private String deptName;

	@Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateName;

	@Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
	private String updateIdcard;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态||", length = 1, nullable = true)
	private Long isDelete;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	private String OpEmMarkDesc;
	
	public String getOpEmMarkDesc() {
		return OpEmMarkDesc;
	}

	public void setOpEmMarkDesc(String opEmMarkDesc) {
		OpEmMarkDesc = opEmMarkDesc;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getOthercardtype() {
		return this.othercardtype;
	}

	public void setOthercardtype(String othercardtype) {
		this.othercardtype = othercardtype;
	}

	public String getOthercardno() {
		return this.othercardno;
	}

	public void setOthercardno(String othercardno) {
		this.othercardno = othercardno;
	}

	public String getOpEmMark() {
		return this.opEmMark;
	}

	public void setOpEmMark(String opEmMark) {
		this.opEmMark = opEmMark;
	}

	public String getOpEmNo() {
		return this.opEmNo;
	}

	public void setOpEmNo(String opEmNo) {
		this.opEmNo = opEmNo;
	}

	public String getTreatCode() {
		return this.treatCode;
	}

	public void setTreatCode(String treatCode) {
		this.treatCode = treatCode;
	}

	public String getTreatName() {
		return this.treatName;
	}

	public void setTreatName(String treatName) {
		this.treatName = treatName;
	}

	public String getTreatContent() {
		return this.treatContent;
	}

	public void setTreatContent(String treatContent) {
		this.treatContent = treatContent;
	}

	public String getTreatNotice() {
		return this.treatNotice;
	}

	public void setTreatNotice(String treatNotice) {
		this.treatNotice = treatNotice;
	}

	public String getHospitalCode() {
		return this.hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUpdateName() {
		return this.updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateIdcard() {
		return this.updateIdcard;
	}

	public void setUpdateIdcard(String updateIdcard) {
		this.updateIdcard = updateIdcard;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	
}