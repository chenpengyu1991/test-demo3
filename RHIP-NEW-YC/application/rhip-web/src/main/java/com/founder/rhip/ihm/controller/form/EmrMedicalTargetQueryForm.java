package com.founder.rhip.ihm.controller.form;


/**
 * 人力资源
 * @author chen_tao
 *
 */
public class EmrMedicalTargetQueryForm {
	
	//查询类型
	private String orgType;
	//按市级医院
	private String hospitalCode;
	//按卫生院
	private String superOrganCode;
	//按社区卫生服务站
	private String organCode;
    //按镇
    private String gbCode;
    //机构类型
    private String genreCode;
    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;
    //姓名
    private String name;
    //身份证号
    private String idcard;
    //门诊号
    private String outpatientNo;
    //住院号
    private String admissionNo;
    //性别
    private String sex;
    
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getSuperOrganCode() {
		return superOrganCode;
	}
	public void setSuperOrganCode(String superOrganCode) {
		this.superOrganCode = superOrganCode;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getGbCode() {
		return gbCode;
	}
	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}
	public String getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getOutpatientNo() {
		return outpatientNo;
	}
	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
