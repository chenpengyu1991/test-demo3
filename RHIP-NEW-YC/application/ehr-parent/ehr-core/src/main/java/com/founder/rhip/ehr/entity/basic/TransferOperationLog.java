package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

public class TransferOperationLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private String moduleName;

	private String moveOutOrgan;

	private String moveInOrgan;

	private String name;
	   
	private String idcard;
	
	private String diseasename;

    private String operatorname;
    
    private Date beginTime;
    
    private Date endTime;
    
    private String diseaseType;
    
    private String gbcode;
    
    private String moveOutVillage;
    
    private String itemCode;
    
    private String activityName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getMoveOutOrgan() {
		return moveOutOrgan;
	}

	public void setMoveOutOrgan(String moveOutOrgan) {
		this.moveOutOrgan = moveOutOrgan;
	}

	public String getMoveInOrgan() {
		return moveInOrgan;
	}

	public void setMoveInOrgan(String moveInOrgan) {
		this.moveInOrgan = moveInOrgan;
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

	public String getDiseasename() {
		return diseasename;
	}

	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getMoveOutVillage() {
		return moveOutVillage;
	}

	public void setMoveOutVillage(String moveOutVillage) {
		this.moveOutVillage = moveOutVillage;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
}