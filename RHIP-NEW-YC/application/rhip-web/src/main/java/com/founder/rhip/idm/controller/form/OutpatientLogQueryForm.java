package com.founder.rhip.idm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 门诊日志查询表单
 */
public class OutpatientLogQueryForm {
	private String idcard;
	private String name;
	private String occupation;
	private Integer beginAge;
	private Integer endAge;
	private String processStatus;
	private String diseaseName;
	private String pathogenesisBeginDate;
	private String pathogenesisEndDate;
	private String clinicOrganCode;
	private String medicalRoomCode;
	private String outpatientType;
	private String inhosBeginDate;
	private String inhosEndDate;
	private String examResult;
	private String hospitalCode;
	private String applyRoomCode;
	private String checkBeginDate;
	private String checkEndDate;
	private String registrationType;
	private String visitStatus;
	private String inDiagnose;
	private String detectionRoomCode;
	private String hbvDnaPosi;
	private String syphilisPosi;
	private String alanineAspartate;
	private String sputumSmearPosi;
	private String hospitalCode1;
	private String orgCode;
	private String townOrgCode;
	private String centerOrgCode;
	private String centerAndStation;
	
  
	public String getCenterAndStation() {
		return centerAndStation;
	}

	public void setCenterAndStation(String centerAndStation) {
		this.centerAndStation = centerAndStation;
	}

	public String getTownOrgCode() {
		return townOrgCode;
	}

	public void setTownOrgCode(String townOrgCode) {
		this.townOrgCode = townOrgCode;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getHospitalCode1() {
		return hospitalCode1;
	}

	public void setHospitalCode1(String hospitalCode1) {
		this.hospitalCode1 = hospitalCode1;
	}

	public String getAlanineAspartate() {
		return alanineAspartate;
	}

	public void setAlanineAspartate(String alanineAspartate) {
		this.alanineAspartate = alanineAspartate;
	}

	public String getDetectionRoomCode() {
		return detectionRoomCode;
	}

	public void setDetectionRoomCode(String detectionRoomCode) {
		this.detectionRoomCode = detectionRoomCode;
	}

	public String getHbvDnaPosi() {
		return hbvDnaPosi;
	}

	public void setHbvDnaPosi(String hbvDnaPosi) {
		this.hbvDnaPosi = hbvDnaPosi;
	}

	public String getSyphilisPosi() {
		return syphilisPosi;
	}

	public void setSyphilisPosi(String syphilisPosi) {
		this.syphilisPosi = syphilisPosi;
	}

	public String getSputumSmearPosi() {
		return sputumSmearPosi;
	}

	public void setSputumSmearPosi(String sputumSmearPosi) {
		this.sputumSmearPosi = sputumSmearPosi;
	}

	public String getInDiagnose() {
		return inDiagnose;
	}

	public void setInDiagnose(String inDiagnose) {
		this.inDiagnose = inDiagnose;
	}

	public String getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getCheckBeginDate() {
		return checkBeginDate;
	}

	public void setCheckBeginDate(String checkBeginDate) {
		this.checkBeginDate = checkBeginDate;
	}

	public String getCheckEndDate() {
		return checkEndDate;
	}

	public void setCheckEndDate(String checkEndDate) {
		this.checkEndDate = checkEndDate;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getApplyRoomCode() {
		return applyRoomCode;
	}

	public void setApplyRoomCode(String applyRoomCode) {
		this.applyRoomCode = applyRoomCode;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getExamResult() {
		return examResult;
	}

	public void setExamResult(String examResult) {
		this.examResult = examResult;
	}

	public String getInhosBeginDate() {
		return inhosBeginDate;
	}

	public void setInhosBeginDate(String inhosBeginDate) {
		this.inhosBeginDate = inhosBeginDate;
	}

	public String getInhosEndDate() {
		return inhosEndDate;
	}

	public void setInhosEndDate(String inhosEndDate) {
		this.inhosEndDate = inhosEndDate;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Integer getBeginAge() {
		return beginAge;
	}

	public void setBeginAge(Integer beginAge) {
		this.beginAge = beginAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getPathogenesisBeginDate() {
		return pathogenesisBeginDate;
	}

	public void setPathogenesisBeginDate(String pathogenesisBeginDate) {
		this.pathogenesisBeginDate = pathogenesisBeginDate;
	}

	public String getPathogenesisEndDate() {
		return pathogenesisEndDate;
	}

	public void setPathogenesisEndDate(String pathogenesisEndDate) {
		this.pathogenesisEndDate = pathogenesisEndDate;
	}

	public String getClinicOrganCode() {
		return clinicOrganCode;
	}

	public void setClinicOrganCode(String clinicOrganCode) {
		this.clinicOrganCode = clinicOrganCode;
	}

	public String getMedicalRoomCode() {
		return medicalRoomCode;
	}

	public void setMedicalRoomCode(String medicalRoomCode) {
		this.medicalRoomCode = medicalRoomCode;
	}

	public String getOutpatientType() {
		return outpatientType;
	}

	public void setOutpatientType(String outpatientType) {
		this.outpatientType = outpatientType;
	}
	
    //疾控三级标签
	public void getSearchOrgan(){
		if(StringUtil.isNotEmpty(orgCode)){
			this.clinicOrganCode = orgCode;
		}else if(StringUtil.isNotEmpty(centerOrgCode)){
			//中心(医院)及下属站
			this.clinicOrganCode = centerOrgCode;
			this.centerAndStation ="1";//查询中心及下属站
		}else if(StringUtil.isNotEmpty(townOrgCode)){
			this.clinicOrganCode = townOrgCode;
		}
	}
	
	public Criteria getCriteria(){
		getSearchOrgan();
		Criteria criteria = new Criteria();
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("idcard", OP.LIKE, idcard);
		}

		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("name", OP.LIKE, name);
		}

       /* if(ObjectUtil.isNotEmpty(endAge)){
        	criteria.add("age", OP.LE, beginAge);
        }
        if(ObjectUtil.isNotEmpty(beginAge)){
        	criteria.add("age", OP.GE, endAge);
        }
        */
		
		
        if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNotEmpty(endAge)) {
        	criteria.add("AGE", OP.BETWEEN, new Integer[] { beginAge, endAge });
		} else if (ObjectUtil.isNullOrEmpty(beginAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("AGE", OP.LE, endAge);
		} else if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			criteria.add("AGE", OP.GE, beginAge);
		}
        /*if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNullOrEmpty(endAge)) {
        	criteria.add("AGE", OP.GE, beginAge);
		} else if (ObjectUtil.isNullOrEmpty(beginAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("AGE", OP.LE, endAge);
		} else if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("AGE", OP.BETWEEN, new Integer[] { beginAge, endAge });
		}*/
        
        if(ObjectUtil.isNotEmpty(occupation)){
        	criteria.add("occupation", occupation);
        }
        if(ObjectUtil.isNotEmpty(diseaseName)){
        	criteria.add("diseaseName", OP.LIKE, diseaseName);
        }
        if(ObjectUtil.isNotEmpty(inDiagnose)){
        	criteria.add("inDiagnose", OP.LIKE, inDiagnose);
        	criteria.add(LOP.OR,"outDiagnose", OP.LIKE, inDiagnose);
        	
        }

		Date pathogenesisBeginDate = DateUtil.parseSimpleDate(this.pathogenesisBeginDate, null);
		Date pathogenesisEndDate = DateUtil.parseSimpleDate(this.pathogenesisEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "pathogenesisDate", pathogenesisBeginDate,pathogenesisEndDate);
  
		Date inhosBeginDate = DateUtil.parseSimpleDate(this.inhosBeginDate, null);
		Date inhosEndDate = DateUtil.parseSimpleDate(this.inhosEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "inhosDate", inhosBeginDate, inhosEndDate);
		
		Date checkBeginDate = DateUtil.parseSimpleDate(this.checkBeginDate, null);
		Date checkEndDate = DateUtil.parseSimpleDate(this.checkEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "e.check_Date", checkBeginDate, checkEndDate);
		
		if (ObjectUtil.isNotEmpty(clinicOrganCode) ){
			criteria.add("clinicOrganCode", clinicOrganCode);			
		}
		if (ObjectUtil.isNotEmpty(medicalRoomCode)){
			criteria.add("medicalRoomCode", medicalRoomCode);
		}
		if (ObjectUtil.isNotEmpty(detectionRoomCode)){
			criteria.add("detectionRoomCode", detectionRoomCode);
		}

        if (StringUtils.isNotEmpty(processStatus)){
			criteria.add("processStatus", OP.EQ, processStatus);
		}
        if (StringUtils.isNotEmpty(outpatientType)){
			criteria.add("outpatientType", outpatientType);
		}
        if (StringUtils.isNotEmpty(registrationType)){
			criteria.add("registrationType", registrationType);
		}
        if (StringUtils.isNotEmpty(visitStatus)){
			criteria.add("visitStatus", visitStatus);
		}
        if (StringUtils.isNotEmpty(examResult)){
        	if("1".equals(examResult) || "2".equals(examResult) || "3".equals(examResult)|| "4".equals(examResult)){
        		criteria.add("outpatientType", examResult);
        	}
		}
        
        if (StringUtils.isNotEmpty(hospitalCode)){
			criteria.add("hospitalCode", hospitalCode);
		}
        
        if (StringUtils.isNotEmpty(hospitalCode1)){
			criteria.add("e.hospital_Code", hospitalCode1);
		}
        
        if (StringUtils.isNotEmpty(applyRoomCode)){
			criteria.add("applyRoomCode", applyRoomCode);
		}
       
    	 if (StringUtils.isNotEmpty(hbvDnaPosi)){
 			criteria.add("hbvDnaPosi", hbvDnaPosi);
 		}
         
         if (StringUtils.isNotEmpty(syphilisPosi)){
 			criteria.add("syphilisPosi", syphilisPosi);
 		}
         if (StringUtils.isNotEmpty(alanineAspartate)){
 			criteria.add("alanineAspartate", alanineAspartate);
 		}
         if (StringUtils.isNotEmpty(sputumSmearPosi)){
 			criteria.add("sputumSmearPosi", sputumSmearPosi);
 		}
		return criteria;
	}
	
}
