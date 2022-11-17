
package com.founder.rhip.ehr.entity.basic;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CDM_REPORT_RECORD")
public class ReportRecord implements Serializable {

	private static final long serialVersionUID = -4200554635289545933L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "REPORT_ID", columnDefinition = "NUMBER|上报表id（成功时才有数据）|11|", length = 11, nullable = true)
    private Long reportId;

    @Column(name = "TYPE", columnDefinition = "NUMBER|上报类型（1:传染病；2:慢病）|1|", length = 1, nullable = true)
    private Integer type;

    @Column(name = "ILLNESS_CODE", columnDefinition = "VARCHAR2|疾病编码|20|", length = 20, nullable = true)
    private String illnessCode;

    @Column(name = "CONTENT", columnDefinition = "VARCHAR2|上报内容|800|", length = 800, nullable = true)
    private String content;

    @Column(name = "STATUS", columnDefinition = "NUMBER|状态（慢病：1未上报；2已上报；9重卡）（传染病：1初诊未上报；2初诊上报；3复诊未上报；9重卡）|1|", length = 1, nullable = true)
    private Integer status;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|新增单位|100|", length = 100, nullable = true)
    private String createOrganCode;

    @Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|新增人|50|", length = 50, nullable = true)
    private String createUserCode;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|新增时间||", nullable = true)
    private Date createDate;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|修改时间||", nullable = true)
    private Date updateDate;

    @Column(name = "CHARSET_NAME", columnDefinition = "VARCHAR2|中文编码规则|20|", length = 20, nullable = true)
    private String charsetName;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|患者姓名|50|", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别编码|1|", length = 1, nullable = true)
    private String gender;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证|18|", length = 18, nullable = true)
    private String idcard;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
    private String age;

    @Column(name = "AGE_UNIT", columnDefinition = "VARCHAR2|年龄单位|2|", length = 2, nullable = true)
    private String ageUnit;

    @Column(name = "TEL", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
    private String tel;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|患者工作单位|100|", length = 100, nullable = true)
    private String unitName;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|手机号码|20|", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻|2|", length = 2, nullable = true)
    private String marriage;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族|2|", length = 2, nullable = true)
    private String nation;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|文化程度|2|", length = 2, nullable = true)
    private String education;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业编码|11|", length = 11, nullable = true)
    private String occupation;

    @Column(name = "EHR_NO", columnDefinition = "VARCHAR2|门诊号|20|", length = 20, nullable = true)
    private String ehrNo;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号|20|", length = 20, nullable = true)
    private String admissionNo;

    @Column(name = "DIAGNOSIS_CODE", columnDefinition = "VARCHAR2|诊断编码|20|", length = 20, nullable = true)
    private String diagnosisCode;

    @Column(name = "DIAGNOSIS_ORGAN_CODE", columnDefinition = "VARCHAR2|诊断机构|100|", length = 100, nullable = true)
    private String diagnosisOrganCode;

    @Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|报告单位编码|100|", length = 100, nullable = true)
    private String fillOrganCode;

    @Column(name = "REPORT_DOCTOR_ID", columnDefinition = "VARCHAR2|填卡医生编码|50|", length = 50, nullable = true)
    private String reportDoctorId;

    @Column(name = "REPORT_DOCTOR_NAME", columnDefinition = "VARCHAR2|填卡医生姓名|50|", length = 50, nullable = true)
    private String reportDoctorName;

    @Column(name = "PATHOGENESIS_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
    private Date pathogenesisDate;

    @Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
    private Date diagnosisDate;

    @Column(name = "ILLNESS_SECOND_CODE", columnDefinition = "VARCHAR2|疾病二级分类（传染病：39种；慢病：5种）|20|", length = 20, nullable = true)
    private String illnessSecondCode;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识（0正常，－1删除）|", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "DELETE_CONTENT", columnDefinition = "VARCHAR2|删除说明|2|", length = 2, nullable = true)
    private String deleteContent;

    @Column(name = "DELETE_CONTENT_OTHER", columnDefinition = "VARCHAR2|删除说明其他|200|", length = 200, nullable = true)
    private String deleteContentOther;

    @Transient
    private String illnessSecondName;

	/*报卡信息*/
	@Transient
	private IdmReport idmReport;
	/**
	 * 获取报卡信息
	 *
	 * @return
	 * @author Ye jianfei
	 */
    public IdmReport getReport(){
    	if(ObjectUtil.isNullOrEmpty(this.idmReport)){
			this.idmReport = new IdmReport();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            try{
                BeanUtils.copyProperties(this.idmReport, this);

            }catch(Exception e){
                throw new RuntimeException(e);
            }
		}
    	//如果出生日期为空，根据身份证号码去计算
    	if(ObjectUtil.isNullOrEmpty(this.birthday)
    			&& ObjectUtil.isNotEmpty(this.idcard)){
    		birthday = IDCardUtil.getBirthDateByIdCard(idcard);
    		idmReport.setBirthday(birthday);//出生日期    		
    	}
    	//如果出年龄为空，根据身份证号码去计算
    	if(ObjectUtil.isNullOrEmpty(this.age)
    			&& ObjectUtil.isNotEmpty(this.idcard)){
    		idmReport.setAge(IDCardUtil.getAgeByIdCard(idcard)+"");//年龄
    		idmReport.setAgeUnit("1");//年龄单位		
    	}    	
    	idmReport.setInfectiousCode(this.illnessSecondCode);//疾病编码
    	return this.idmReport;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIllnessCode() {
        return illnessCode;
    }

    public void setIllnessCode(String illnessCode) {
        this.illnessCode = illnessCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCharsetName() {
        return charsetName;
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeUnit() {
        return ageUnit;
    }

    public void setAgeUnit(String ageUnit) {
        this.ageUnit = ageUnit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEhrNo() {
        return ehrNo;
    }

    public void setEhrNo(String ehrNo) {
        this.ehrNo = ehrNo;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDiagnosisOrganCode() {
        return diagnosisOrganCode;
    }

    public void setDiagnosisOrganCode(String diagnosisOrganCode) {
        this.diagnosisOrganCode = diagnosisOrganCode;
    }

    public String getFillOrganCode() {
        return fillOrganCode;
    }

    public void setFillOrganCode(String fillOrganCode) {
        this.fillOrganCode = fillOrganCode;
    }

    public String getReportDoctorId() {
        return reportDoctorId;
    }

    public void setReportDoctorId(String reportDoctorId) {
        this.reportDoctorId = reportDoctorId;
    }

    public String getReportDoctorName() {
        return reportDoctorName;
    }

    public void setReportDoctorName(String reportDoctorName) {
        this.reportDoctorName = reportDoctorName;
    }

    public Date getPathogenesisDate() {
        return pathogenesisDate;
    }

    public void setPathogenesisDate(Date pathogenesisDate) {
        this.pathogenesisDate = pathogenesisDate;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getIllnessSecondCode() {
        return illnessSecondCode;
    }

    public void setIllnessSecondCode(String illnessSecondCode) {
        this.illnessSecondCode = illnessSecondCode;
    }

    public String getIllnessSecondName() {
        return illnessSecondName;
    }

    public void setIllnessSecondName(String illnessSecondName) {
        this.illnessSecondName = illnessSecondName;
    }

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

    public String getDeleteContent() {
        return deleteContent;
    }

    public void setDeleteContent(String deleteContent) {
        this.deleteContent = deleteContent;
    }

    public String getDeleteContentOther() {
        return deleteContentOther;
    }

    public void setDeleteContentOther(String deleteContentOther) {
        this.deleteContentOther = deleteContentOther;
    }
}