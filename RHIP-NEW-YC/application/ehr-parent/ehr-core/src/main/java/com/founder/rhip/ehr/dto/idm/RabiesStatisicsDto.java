package com.founder.rhip.ehr.dto.idm;

/*
 * 传染病管理月报表-狂犬病防治月报表Dto
 */

import java.io.Serializable;
import java.util.Date;

public class RabiesStatisicsDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
    
    /*被动物咬伤就诊人数*/
    private Integer rabiesVisit = 0;    
    
    /*一犬伤多人事件起数*/
    private Integer biteMany = 0;    

    /*伤口经正规处理人数*/
    private Integer disposeVulnus = 0; 
    
    /*使用人用狂犬病疫苗人数*/
    private Integer rabiesVaccine   = 0;  
    
    /*使用狂犬病人免疫球蛋白联合疫苗人数*/
    private Integer rabiesImmunoglobulin = 0;
 
    /*发病人数*/
    private Integer incidence = 0;
     
    /*死亡人数*/
    private Integer deathToll = 0;
    
    /*处理疫点数*/
    private Integer disposeEpidemic = 0;
    
    /*其他*/
    private String rabiesOther;

	public String getFillOrganCode() {
		return fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Integer getRabiesVisit() {
		return rabiesVisit;
	}

	public void setRabiesVisit(Integer rabiesVisit) {
		this.rabiesVisit = rabiesVisit;
	}

	public Integer getBiteMany() {
		return biteMany;
	}

	public void setBiteMany(Integer biteMany) {
		this.biteMany = biteMany;
	}

	public Integer getDisposeVulnus() {
		return disposeVulnus;
	}

	public void setDisposeVulnus(Integer disposeVulnus) {
		this.disposeVulnus = disposeVulnus;
	}

	public Integer getRabiesVaccine() {
		return rabiesVaccine;
	}

	public void setRabiesVaccine(Integer rabiesVaccine) {
		this.rabiesVaccine = rabiesVaccine;
	}

	public Integer getRabiesImmunoglobulin() {
		return rabiesImmunoglobulin;
	}

	public void setRabiesImmunoglobulin(Integer rabiesImmunoglobulin) {
		this.rabiesImmunoglobulin = rabiesImmunoglobulin;
	}

	public Integer getIncidence() {
		return incidence;
	}

	public void setIncidence(Integer incidence) {
		this.incidence = incidence;
	}

	public Integer getDeathToll() {
		return deathToll;
	}

	public void setDeathToll(Integer deathToll) {
		this.deathToll = deathToll;
	}

	public Integer getDisposeEpidemic() {
		return disposeEpidemic;
	}

	public void setDisposeEpidemic(Integer disposeEpidemic) {
		this.disposeEpidemic = disposeEpidemic;
	}

	public String getRabiesOther() {
		return rabiesOther;
	}

	public void setRabiesOther(String rabiesOther) {
		this.rabiesOther = rabiesOther;
	}

	public String getFillOrgCode() {
		return fillOrgCode;
	}

	public void setFillOrgCode(String fillOrgCode) {
		this.fillOrgCode = fillOrgCode;
	}

	public String getFillUserId() {
		return fillUserId;
	}

	public void setFillUserId(String fillUserId) {
		this.fillUserId = fillUserId;
	}

	public Date getFillDt() {
		return fillDt;
	}

	public void setFillDt(Date fillDt) {
		this.fillDt = fillDt;
	}
	
}