package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.validator.constraints.DateCustom;
import com.founder.rhip.ehr.validator.constraints.Idcard;


import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@Table(name = "MS_CLINICAL_PATHWAY")
public class ClinicalPathway implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号(自增长)|11|", length = 11, nullable = false)
	private Long id;

	@NotEmpty(message="医院编码为空")
	@Pattern(regexp="46714063-X|46714062-1|46714117-3|46714077-9|46714078-7",message="医院编码值非法")
	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|50|", length = 50, nullable = true)
	private String hospitalCode;

	@NotEmpty(message="科室编码为空")
	@Length(max = 50,message="科室编码长度过长")
	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|科室编码|50|", length = 50, nullable = true)
	private String departmentCode;

	@NotEmpty(message="科室名称为空")
	@Length(max = 50,message="科室名称长度过长")
	@Column(name = "DEPARTMENT_NAME", columnDefinition = "VARCHAR2|科室名称|50|", length = 50, nullable = true)
	private String departmentName;

	@Idcard(message="身份证号码非法")
	@NotEmpty(message="身份证号码为空")
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|患者身份证|20|", length = 20, nullable = true)
	private String idCard;

	@NotEmpty(message="患者姓名为空")
	@Length(max = 50,message="患者姓名长度过长")
	@Column(name = "PATIENT_NAME", columnDefinition = "VARCHAR2|患者姓名|50|", length = 50, nullable = true)
	private String patientName;

	@Length(max = 50,message="住院号过长")
	@Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号|50|", length = 50, nullable = true)
	private String admissionNo;

	@Length(max = 50,message="门诊号过长")
	@Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号|50|", length = 50, nullable = true)
	private String outpatientNo;

	@NotEmpty(message="诊断编码为空")
	@Length(max = 50,message="诊断编码过长")
	@Column(name = "DIAGNOSIS_CODE", columnDefinition = "VARCHAR2|诊断编码|50|", length = 50, nullable = true)
	private String diagnosisCode;

	@NotEmpty(message="诊断名称为空")
	@Length(max = 100,message="诊断名称过长")
	@Column(name = "DIAGNOSIS_NAME", columnDefinition = "VARCHAR2|诊断名称|100|", length = 100, nullable = true)
	private String diagnosisName;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@NotNull(message="进入路径时间为空或格式非法")
	@Column(name = "INTO_TIME", columnDefinition = "TIMESTAMP|进入路径时间||", nullable = true)
	private Date intoTime;

	@Column(name = "QUIT_TIME", columnDefinition = "TIMESTAMP|退出路径时间||", nullable = true)
	private Date quitTime;
	
	@DateCustom(pattern="yyyy/MM/dd HH:mm:ss",message="退出路径时间格式错误")
	private String quitPathTime;

	@Length(max = 100,message="退出路径原因过长")
	@Column(name = "QUIT_REASON", columnDefinition = "VARCHAR2|退出路径原因|100|", length = 100, nullable = true)
	private String quitReason;

	@Column(name = "COMPLETE_TIME", columnDefinition = "TIMESTAMP|完成路径时间||", nullable = true)
	private Date completeTime;

	@DateCustom(pattern="yyyy/MM/dd HH:mm:ss",message="完成路径时间格式错误")
	private String completePathTime;
	
	@Column(name = "VARIATION_TIME", columnDefinition = "TIMESTAMP|变异时间||", nullable = true)
	private Date variationTime;
	
	@DateCustom(pattern="yyyy/MM/dd HH:mm:ss",message="变异时间格式错误")
	private String variationOfTime;

	@Length(max = 100,message="变异原因过长")
	@Column(name = "VARIATION_REASON", columnDefinition = "VARCHAR2|变异原因|100|", length = 100, nullable = true)
	private String variationReason;

	@Pattern(regexp="s{0}|0|1",message="是否治愈值非法")
	@Column(name = "CURE_MARK", columnDefinition = "VARCHAR2|是否治愈|2|", length = 2, nullable = true)
	private String cureMark;

	@Pattern(regexp="s{0}|0|1",message="是否好转值非法")
	@Column(name = "IMPROVE_MARK", columnDefinition = "VARCHAR2|是否好转|2|", length = 2, nullable = true)
	private String improveMark;

	@Pattern(regexp="s{0}|0|1",message="是否死亡值非法")
	@Column(name = "DEATH_MARK", columnDefinition = "VARCHAR2|是否死亡|2|", length = 2, nullable = true)
	private String deathMark;

	@Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡时间||", nullable = true)
	private Date deathDate;
	
	@DateCustom(pattern="yyyy/MM/dd HH:mm:ss",message="死亡时间格式错误")
	private String deathOfDate;

	@XmlTransient
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|创建时间||", nullable = true)
	private Date createDate;

	@XmlTransient
	@Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrg;

	@XmlTransient
	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|创建人|50|", length = 50, nullable = true)
	private String createUser;

	@XmlTransient
	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新时间||", nullable = true)
	private Date updateDate;
	
	@XmlTransient
	@Column(name = "UPDATE_ORG", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrg;

	@XmlTransient
	@Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|更新人|50|", length = 50, nullable = true)
	private String updateUser;
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

	public static class DateAdapter extends XmlAdapter<String, Date> {

		private String pattern = "yyyy/MM/dd HH:mm:ss";

		@Override
		public Date unmarshal(String dateStr) throws Exception {
			if (ObjectUtil.isNullOrEmpty(dateStr)) {
				return null;
			}else if(dateStr.trim().length() != pattern.length()){
				return null;
			}
			return DateUtil.parseSimpleDate(dateStr.trim(), pattern);
		}

		@Override
		public String marshal(Date date) throws Exception {
			if (ObjectUtil.isNullOrEmpty(date)) {
				return null;
			}
			return DateUtil.getDateTime(pattern, date);
        }

    }

    public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHospitalCode() {
		return this.hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAdmissionNo() {
		return this.admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getOutpatientNo() {
		return this.outpatientNo;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public String getDiagnosisCode() {
		return this.diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public Date getIntoTime() {
		return this.intoTime;
	}

	public void setIntoTime(Date intoTime) {
		this.intoTime = intoTime;
	}

	public Date getQuitTime() {
		if(ObjectUtil.isNullOrEmpty(this.quitTime)){
			if (ObjectUtil.isNullOrEmpty(this.quitPathTime)) {
				return null;
			}else if(quitPathTime.trim().length() != "yyyy/MM/dd HH:mm:ss".length()){
				return null;
			}
			this.quitTime = DateUtil.parseSimpleDate(quitPathTime.trim(), "yyyy/MM/dd HH:mm:ss");
		}
		return this.quitTime;
	}

	public void setQuitTime(Date quitTime) {
		this.quitTime = quitTime;
	}

	public String getQuitReason() {
		return this.quitReason;
	}

	public void setQuitReason(String quitReason) {
		this.quitReason = quitReason;
	}

	public Date getCompleteTime() {
		if(ObjectUtil.isNullOrEmpty(this.completeTime)){
			if (ObjectUtil.isNullOrEmpty(this.completePathTime)) {
				return null;
			}else if(completePathTime.trim().length() != "yyyy/MM/dd HH:mm:ss".length()){
				return null;
			}
			this.completeTime = DateUtil.parseSimpleDate(completePathTime.trim(), "yyyy/MM/dd HH:mm:ss");
		}
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Date getVariationTime() {
		if(ObjectUtil.isNullOrEmpty(this.variationTime)){
			if (ObjectUtil.isNullOrEmpty(this.variationOfTime)) {
				return null;
			}else if(variationOfTime.trim().length() != "yyyy/MM/dd HH:mm:ss".length()){
				return null;
			}
			this.variationTime = DateUtil.parseSimpleDate(variationOfTime.trim(), "yyyy/MM/dd HH:mm:ss");
		}
		return this.variationTime;
	}

	public void setVariationTime(Date variationTime) {
		this.variationTime = variationTime;
	}

	public String getVariationReason() {
		return this.variationReason;
	}

	public void setVariationReason(String variationReason) {
		this.variationReason = variationReason;
	}

	public String getCureMark() {
		return this.cureMark;
	}

	public void setCureMark(String cureMark) {
		this.cureMark = cureMark;
	}

	public String getImproveMark() {
		return this.improveMark;
	}

	public void setImproveMark(String improveMark) {
		this.improveMark = improveMark;
	}

	public String getDeathMark() {
		return this.deathMark;
	}

	public void setDeathMark(String deathMark) {
		this.deathMark = deathMark;
	}

	public Date getDeathDate() {
		if(ObjectUtil.isNullOrEmpty(this.deathDate)){
			if (ObjectUtil.isNullOrEmpty(this.deathOfDate)) {
				return null;
			}else if(deathOfDate.trim().length() != "yyyy/MM/dd HH:mm:ss".length()){
				return null;
			}
			this.deathDate = DateUtil.parseSimpleDate(deathOfDate.trim(), "yyyy/MM/dd HH:mm:ss");
		}
		return this.deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getQuitPathTime() {
		return quitPathTime;
	}

	public void setQuitPathTime(String quitPathTime) {
		this.quitPathTime = quitPathTime;
	}

	public String getCompletePathTime() {
		return completePathTime;
	}

	public void setCompletePathTime(String completePathTime) {
		this.completePathTime = completePathTime;
	}

	public String getVariationOfTime() {
		return variationOfTime;
	}

	public void setVariationOfTime(String variationOfTime) {
		this.variationOfTime = variationOfTime;
	}

	public String getDeathOfDate() {
		return deathOfDate;
	}

	public void setDeathOfDate(String deathOfDate) {
		this.deathOfDate = deathOfDate;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}
	
	
}