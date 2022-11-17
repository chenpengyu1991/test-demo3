package com.founder.rhip.ehr.dto.idm;

/*
 * 传染病管理月报表-传染病访视月报表Dto
 */

import java.io.Serializable;
import java.util.Date;

public class InterviewStatisicsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*状态表唯一标识*/
    private String idmId;
    
    /*报卡填报机构*/
    private String fillOrganCode;
    
    /*报卡填报日期*/
    private Date fillDate;
  
    /*填报人机构编码*/
    private String fillOrgCode;
    
    /*填报人ID*/
    private String fillUserId;
 
    /*填报日期*/
    private Date fillDt;
    
    /*疾病编码*/
    private String diseaseCode;
    
    /*报告发现病数*/
    private Integer reportNumber = 0;    
    
    /*访视数*/
    private Integer interviewNumber = 0;    

    /*访视情况-住院人数*/
    private Integer inHospitalNumber = 0; 
    
    /*访视情况-在家人数*/
    private Integer inHomeNumber = 0;  
    
    /*访视情况-查无此人*/
    private Integer unknownPerson = 0;
 
    /*访视情况-误诊*/
    private Integer misdiagnose = 0;
     
    /*访视情况-其他人数*/
    private Integer interviewOther = 0;
    
    /*密切接触人数*/
    private Integer contactNumber = 0;
    
    /*接种疫苗人数*/
    private Integer vaccinationNumber = 0;
    
    /*其他*/
    private String other;

	
	/**
	 * @return the diseaseCode
	 */
	public String getDiseaseCode() {
		return diseaseCode;
	}

	
	/**
	 * @param diseaseCode the diseaseCode to set
	 */
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	
	/**
	 * @return the reportNumber
	 */
	public Integer getReportNumber() {
		return reportNumber;
	}

	
	/**
	 * @param reportNumber the reportNumber to set
	 */
	public void setReportNumber(Integer reportNumber) {
		this.reportNumber = reportNumber;
	}

	
	/**
	 * @return the interviewNumber
	 */
	public Integer getInterviewNumber() {
		return interviewNumber;
	}

	
	/**
	 * @param interviewNumber the interviewNumber to set
	 */
	public void setInterviewNumber(Integer interviewNumber) {
		this.interviewNumber = interviewNumber;
	}

	
	/**
	 * @return the inHospitalNumber
	 */
	public Integer getInHospitalNumber() {
		return inHospitalNumber;
	}

	
	/**
	 * @param inHospitalNumber the inHospitalNumber to set
	 */
	public void setInHospitalNumber(Integer inHospitalNumber) {
		this.inHospitalNumber = inHospitalNumber;
	}

	
	/**
	 * @return the inHomeNumber
	 */
	public Integer getInHomeNumber() {
		return inHomeNumber;
	}

	
	/**
	 * @param inHomeNumber the inHomeNumber to set
	 */
	public void setInHomeNumber(Integer inHomeNumber) {
		this.inHomeNumber = inHomeNumber;
	}

	
	/**
	 * @return the unknownPerson
	 */
	public Integer getUnknownPerson() {
		return unknownPerson;
	}

	
	/**
	 * @param unknownPerson the unknownPerson to set
	 */
	public void setUnknownPerson(Integer unknownPerson) {
		this.unknownPerson = unknownPerson;
	}

	
	/**
	 * @return the misdiagnose
	 */
	public Integer getMisdiagnose() {
		return misdiagnose;
	}

	
	/**
	 * @param misdiagnose the misdiagnose to set
	 */
	public void setMisdiagnose(Integer misdiagnose) {
		this.misdiagnose = misdiagnose;
	}

	
	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	
	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	
	/**
	 * @return the contactNumber
	 */
	public Integer getContactNumber() {
		return contactNumber;
	}

	
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	/**
	 * @return the vaccinationNumber
	 */
	public Integer getVaccinationNumber() {
		return vaccinationNumber;
	}

	
	/**
	 * @param vaccinationNumber the vaccinationNumber to set
	 */
	public void setVaccinationNumber(Integer vaccinationNumber) {
		this.vaccinationNumber = vaccinationNumber;
	}


	/**
	 * @return the idmId
	 */
	public String getIdmId() {
		return idmId;
	}


	/**
	 * @param idmId the idmId to set
	 */
	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}


	/**
	 * @return the fillOrganCode
	 */
	public String getFillOrganCode() {
		return fillOrganCode;
	}


	/**
	 * @param fillOrganCode the fillOrganCode to set
	 */
	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}


	/**
	 * @return the fillDate
	 */
	public Date getFillDate() {
		return fillDate;
	}


	/**
	 * @param fillDate the fillDate to set
	 */
	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}


	/**
	 * @return the interviewOther
	 */
	public Integer getInterviewOther() {
		return interviewOther;
	}


	/**
	 * @param interviewOther the interviewOther to set
	 */
	public void setInterviewOther(Integer interviewOther) {
		this.interviewOther = interviewOther;
	}


	public String getFillUserId() {
		return fillUserId;
	}


	public void setFillUserId(String fillUserId) {
		this.fillUserId = fillUserId;
	}


	public String getFillOrgCode() {
		return fillOrgCode;
	}


	public void setFillOrgCode(String fillOrgCode) {
		this.fillOrgCode = fillOrgCode;
	}


	public Date getFillDt() {
		return fillDt;
	}


	public void setFillDt(Date fillDt) {
		this.fillDt = fillDt;
	}

}