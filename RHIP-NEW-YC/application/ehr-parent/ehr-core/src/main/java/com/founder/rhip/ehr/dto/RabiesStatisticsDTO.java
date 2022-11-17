package com.founder.rhip.ehr.dto;

import java.io.Serializable;

/**
 * 随访信息
 * 
 * @author liuk
 * 
 */
public class RabiesStatisticsDTO implements Serializable {
	private static final long serialVersionUID = 8418853226662140639L;
	
	private String orgCode;
	
	/** 
	* @Fields outpatient :犬伤就诊数
	*/ 
	private Integer outpatient;
	
	/** 
	* @Fields woundTreatment : 伤口处理数
	*/ 
	private Integer woundTreatment;
	
	/** 
	* @Fields commentVaccine : 注射疫苗数
	*/ 
	private Integer commentVaccine;
	
	/** 
	* @Fields commentGray : 免疫蛋白
	*/ 
	private Integer commentGray;
	
	/** 
	* @Fields oneDogAnyMan : 一犬伤多人
	*/ 
	private Integer oneDogAnyMan;
	
	/** 
	* @Fields outbreak : 发病
	*/ 
	private Integer outbreak;
	
	
	/** 
	* @Fields dead : 死亡人数
	*/ 
	private Integer dead;
	
	/** 
	* @Fields vaccineSpot : 处理疫点数
	*/ 
	private Integer vaccineSpot;

	public Integer getOutpatient() {
		return outpatient;
	}

	public void setOutpatient(Integer outpatient) {
		this.outpatient = outpatient;
	}

	public Integer getWoundTreatment() {
		return woundTreatment;
	}

	public void setWoundTreatment(Integer woundTreatment) {
		this.woundTreatment = woundTreatment;
	}

	public Integer getCommentVaccine() {
		return commentVaccine;
	}

	public void setCommentVaccine(Integer commentVaccine) {
		this.commentVaccine = commentVaccine;
	}

	public Integer getCommentGray() {
		return commentGray;
	}

	public void setCommentGray(Integer commentGray) {
		this.commentGray = commentGray;
	}

	public Integer getOneDogAnyMan() {
		return oneDogAnyMan;
	}

	public void setOneDogAnyMan(Integer oneDogAnyMan) {
		this.oneDogAnyMan = oneDogAnyMan;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getOutbreak() {
		return outbreak;
	}

	public void setOutbreak(Integer outbreak) {
		this.outbreak = outbreak;
	}

	public Integer getDead() {
		return dead;
	}

	public void setDead(Integer dead) {
		this.dead = dead;
	}

	public Integer getVaccineSpot() {
		return vaccineSpot;
	}

	public void setVaccineSpot(Integer vaccineSpot) {
		this.vaccineSpot = vaccineSpot;
	}
	
}
