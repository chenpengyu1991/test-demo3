package com.founder.rhip.ph.dto.vaccine;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.mdm.entity.Organization;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author xu_bin
 * Vaccine details page use
 * include(患者基本情况 / 咬伤情况 / 疫苗接种情况 / 乙肝二对半检测结果 / 备注)
 * 其中(备注)已纳入 SuffererBaseInfoDTO
 * 各类接种情况统一纳入 
 * 
 * 为添加功能 增加对VaccineRecordDTO的映射
 */
public class VaccinationDetailsDTO implements Serializable {
	private static final long serialVersionUID = 2736755534315658502L;
	
	private VaccinationMgmt vaccinationMgmt;
	
	private Organization currentOrg;
	
	private User currentUser;
	
	private PersonInfo personInfo;
	
	/**
	 * 本次事件的性质
	 * 0、1、5、8表示重新接种，其他表示加强接种。
	 */
	private Integer vacciantionFlag;
	
	/**
	 * 是否全程接种
	 * 0表示没有 1表示全程接种。
	 */
	private Integer completeFlag;
	
	/**
	 * 咬傷情況
	 * */
	private TraumaHistory traumaHistory;
	
	/**
	 * 乙肝二对半检测结果
	 * */
	private List<ExamineDetail> examineDetailList; 
	
	
	/** 
	* @Fields vaccineType : 用于区分是什么类型的疫苗
	*/ 
	private String vaccineType;
	
	private String otherNote;
	private String factory;
	private Integer count;
	private Date lastInjectedDate;
	private String isInjected;
	//一年内是否全程接种过狂犬病疫苗
	private String isOneYearInjected;
	//一年前三年内是否全程接种过狂犬病疫苗
	private String isThreeYearInjected;
	//三年内是否加强接种过狂犬病疫苗
	private String isPowerInjected;
	//全程接种最后一剂接种时间
	private Date lastFullInjectedDate;
	//加强接种最后一剂接种时间
	private Date lastPowerInjectedDate;
	
	// 狂犬疫苗接种类型 5：五针法 4：四针法  51：五针法（临时） 41：四针法（临时）9：健康人预防性接种
	private Integer rabiesType;

    private Integer flag;


    public List<ExamineDetail> getExamineDetailList() {
		return examineDetailList;
	}

	public void setExamineDetailList(List<ExamineDetail> examineDetailList) {
		this.examineDetailList = examineDetailList;
	}

	public VaccinationMgmt getVaccinationMgmt() {
		return vaccinationMgmt;
	}

	public void setVaccinationMgmt(VaccinationMgmt vaccinationMgmt) {
		this.vaccinationMgmt = vaccinationMgmt;
	}

	public TraumaHistory getTraumaHistory() {
		return traumaHistory;
	}

	public void setTraumaHistory(TraumaHistory traumaHistory) {
		this.traumaHistory = traumaHistory;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public Organization getCurrentOrg() {
		return currentOrg;
	}

	public void setCurrentOrg(Organization currentOrg) {
		this.currentOrg = currentOrg;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getOtherNote() {
		return otherNote;
	}

	public void setOtherNote(String otherNote) {
		this.otherNote = otherNote;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getLastInjectedDate() {
		return lastInjectedDate;
	}

	public void setLastInjectedDate(Date lastInjectedDate) {
		this.lastInjectedDate = lastInjectedDate;
	}

	public String getIsInjected() {
		return isInjected;
	}

	public void setIsInjected(String isInjected) {
		this.isInjected = isInjected;
	}

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	public Integer getVacciantionFlag() {
		return vacciantionFlag;
	}

	public void setVacciantionFlag(Integer vacciantionFlag) {
		this.vacciantionFlag = vacciantionFlag;
	}


	public Integer getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(Integer completeFlag) {
		this.completeFlag = completeFlag;
	}
	

	public Integer getRabiesType() {
		return rabiesType;
	}

	public void setRabiesType(Integer rabiesType) {
		this.rabiesType = rabiesType;
	}

	public String getIsOneYearInjected() {
		return isOneYearInjected;
	}

	public void setIsOneYearInjected(String isOneYearInjected) {
		this.isOneYearInjected = isOneYearInjected;
	}

	public String getIsThreeYearInjected() {
		return isThreeYearInjected;
	}

	public void setIsThreeYearInjected(String isThreeYearInjected) {
		this.isThreeYearInjected = isThreeYearInjected;
	}

	public String getIsPowerInjected() {
		return isPowerInjected;
	}

	public void setIsPowerInjected(String isPowerInjected) {
		this.isPowerInjected = isPowerInjected;
	}

	public Date getLastFullInjectedDate() {
		return lastFullInjectedDate;
	}

	public void setLastFullInjectedDate(Date lastFullInjectedDate) {
		this.lastFullInjectedDate = lastFullInjectedDate;
	}

	public Date getLastPowerInjectedDate() {
		return lastPowerInjectedDate;
	}

	public void setLastPowerInjectedDate(Date lastPowerInjectedDate) {
		this.lastPowerInjectedDate = lastPowerInjectedDate;
	}
}
