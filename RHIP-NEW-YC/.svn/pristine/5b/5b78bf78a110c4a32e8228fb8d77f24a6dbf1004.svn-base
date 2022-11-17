package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MS_DOCTOR_ADVICE")
public class DoctorAdvice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;

	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 50, nullable = true)
	private String othercardno;

	@Column(name = "HP_NO", columnDefinition = "VARCHAR2|住院号||", length = 50, nullable = true)
	private String hpNo;

	@Column(name = "HP_S_NO", columnDefinition = "VARCHAR2|住院流水号||", length = 50, nullable = true)
	private String hpSNo;

	@Column(name = "ODR_NO", columnDefinition = "VARCHAR2|医嘱编号||", length = 50, nullable = true)
	private String odrNo;

	@Column(name = "OTHER_ODR", columnDefinition = "VARCHAR2|其他医嘱||", length = 800, nullable = true)
	private String otherOdr;

	@Column(name = "OUT_HP_ODR", columnDefinition = "VARCHAR2|出院医嘱||", length = 800, nullable = true)
	private String outHpOdr;

	@Column(name = "ODR_GN", columnDefinition = "VARCHAR2|医嘱组号||", length = 50, nullable = true)
	private String odrGn;

	@Column(name = "ODR_TYPE", columnDefinition = "VARCHAR2|医嘱类别||", length = 2, nullable = true)
	private String odrType;

	@Column(name = "IF_DRUG", columnDefinition = "VARCHAR2|是否药品||", length = 2, nullable = true)
	private String ifDrug;

	@Column(name = "ODR_CODE", columnDefinition = "VARCHAR2|医嘱明细编码||", length = 50, nullable = true)
	private String odrCode;

	@Column(name = "ODR_NAME", columnDefinition = "VARCHAR2|医嘱明细名称||", length = 50, nullable = true)
	private String odrName;

	@Column(name = "ODR_NOTE", columnDefinition = "VARCHAR2|医嘱备注说明||", length = 800, nullable = true)
	private String odrNote;

	@Column(name = "ODRISU_DT", columnDefinition = "DATE|医嘱下达时间||", nullable = true)
	private Date odrisuDt;

	@Column(name = "BEGIN_TIME", columnDefinition = "DATE|医嘱开始执行时间||", nullable = true)
	private Date beginTime;

	@Column(name = "NURSE_IDCARD", columnDefinition = "VARCHAR2|执行护士身份证号||", length = 18, nullable = true)
	private String nurseIdcard;

	@Column(name = "NUR_E_DT", columnDefinition = "DATE|护士执行时间||", nullable = true)
	private Date nurEDt;

	@Column(name = "STOP_DT", columnDefinition = "DATE|医嘱停止执行时间||", nullable = true)
	private Date stopDt;

	@Column(name = "STPDOC_IDCARD", columnDefinition = "VARCHAR2|停止执行医生身份证号||", length = 18, nullable = true)
	private String stpdocIdcard;

	@Column(name = "DOC_IDCARD", columnDefinition = "VARCHAR2|开嘱医生身份证号||", length = 18, nullable = true)
	private String docIdcard;

	@Column(name = "DPT_CODE", columnDefinition = "VARCHAR2|开嘱科室编码||", length = 18, nullable = true)
	private String dptCode;

	@Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String fillUserName;

	@Column(name = "FILL_USER_IDCARD", columnDefinition = "VARCHAR2|填报身份证号||", length = 18, nullable = true)
	private String fillUserIdcard;

	@Column(name = "FILL_TIME", columnDefinition = "DATE|填报日期时间||", nullable = true)
	private Date fillTime;

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
	
    @Column(name = "IS_LIMIT", columnDefinition = "VARCHAR2|是否限制||", length = 1, nullable = true)
    private String isLimit;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
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

	public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
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

	public String getHpNo() {
		return this.hpNo;
	}

	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}

	public String getHpSNo() {
		return this.hpSNo;
	}

	public void setHpSNo(String hpSNo) {
		this.hpSNo = hpSNo;
	}

	public String getOdrNo() {
		return this.odrNo;
	}

	public void setOdrNo(String odrNo) {
		this.odrNo = odrNo;
	}

	public String getOtherOdr() {
		return this.otherOdr;
	}

	public void setOtherOdr(String otherOdr) {
		this.otherOdr = otherOdr;
	}

	public String getOutHpOdr() {
		return this.outHpOdr;
	}

	public void setOutHpOdr(String outHpOdr) {
		this.outHpOdr = outHpOdr;
	}

	public String getOdrGn() {
		return this.odrGn;
	}

	public void setOdrGn(String odrGn) {
		this.odrGn = odrGn;
	}

	public String getOdrType() {
		return this.odrType;
	}

	public void setOdrType(String odrType) {
		this.odrType = odrType;
	}

	public String getIfDrug() {
		return this.ifDrug;
	}

	public void setIfDrug(String ifDrug) {
		this.ifDrug = ifDrug;
	}

	public String getOdrCode() {
		return this.odrCode;
	}

	public void setOdrCode(String odrCode) {
		this.odrCode = odrCode;
	}

	public String getOdrName() {
		return this.odrName;
	}

	public void setOdrName(String odrName) {
		this.odrName = odrName;
	}

	public String getOdrNote() {
		return this.odrNote;
	}

	public void setOdrNote(String odrNote) {
		this.odrNote = odrNote;
	}

	public Date getOdrisuDt() {
		return this.odrisuDt;
	}

	public void setOdrisuDt(Date odrisuDt) {
		this.odrisuDt = odrisuDt;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getNurseIdcard() {
		return this.nurseIdcard;
	}

	public void setNurseIdcard(String nurseIdcard) {
		this.nurseIdcard = nurseIdcard;
	}

	public Date getNurEDt() {
		return this.nurEDt;
	}

	public void setNurEDt(Date nurEDt) {
		this.nurEDt = nurEDt;
	}

	public Date getStopDt() {
		return this.stopDt;
	}

	public void setStopDt(Date stopDt) {
		this.stopDt = stopDt;
	}

	public String getStpdocIdcard() {
		return this.stpdocIdcard;
	}

	public void setStpdocIdcard(String stpdocIdcard) {
		this.stpdocIdcard = stpdocIdcard;
	}

	public String getDocIdcard() {
		return this.docIdcard;
	}

	public void setDocIdcard(String docIdcard) {
		this.docIdcard = docIdcard;
	}

	public String getDptCode() {
		return this.dptCode;
	}

	public void setDptCode(String dptCode) {
		this.dptCode = dptCode;
	}

	public String getFillUserName() {
		return this.fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	public String getFillUserIdcard() {
		return this.fillUserIdcard;
	}

	public void setFillUserIdcard(String fillUserIdcard) {
		this.fillUserIdcard = fillUserIdcard;
	}

	public Date getFillTime() {
		return this.fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
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

	
	public String getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(String isLimit) {
		this.isLimit = isLimit;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	
}