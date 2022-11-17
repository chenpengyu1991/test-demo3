package com.founder.rhip.ehr.statisticsdto;

import java.io.Serializable;

public class HbpManageMonthReport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6695861167196217893L;
	
	//机构name
	private String organName;
	//机构code
	private String organCode; 
	//新增管理病人数
	private Long addPatient;
	//累计管理病人
	private Long patientCount;
	//发生事件数
	private Long eventTotal;
	//三个月内随访人数
	private Long threeMonthsTotal;
	//六个月内随访人数
	private Long sixMonthsTotal;
	//九个月内随访人数
	private Long nineMonthsTotal;
	//十二个月内随访人数
	private Long twelveMonthsTotal;
	
	public void copyFrom(HbpManageMonthReport hbpManageMonthReport) {
		this.addPatient = hbpManageMonthReport.getAddPatient();
		this.patientCount = hbpManageMonthReport.getPatientCount();
		this.eventTotal = hbpManageMonthReport.getEventTotal();
		
	}
	public void copyMonthTotal(HbpManageMonthReport hbpManageMonthReport){
		this.threeMonthsTotal = hbpManageMonthReport.getThreeMonthsTotal();
		this.sixMonthsTotal = hbpManageMonthReport.getSixMonthsTotal();
		this.nineMonthsTotal = hbpManageMonthReport.getNineMonthsTotal();
		this.twelveMonthsTotal = hbpManageMonthReport.getTwelveMonthsTotal();
	}
	public Long getThreeMonthsTotal() {
		return threeMonthsTotal;
	}
	public void setThreeMonthsTotal(Long threeMonthsTotal) {
		this.threeMonthsTotal = threeMonthsTotal;
	}
	public Long getSixMonthsTotal() {
		return sixMonthsTotal;
	}
	public void setSixMonthsTotal(Long sixMonthsTotal) {
		this.sixMonthsTotal = sixMonthsTotal;
	}
	public Long getNineMonthsTotal() {
		return nineMonthsTotal;
	}
	public void setNineMonthsTotal(Long nineMonthsTotal) {
		this.nineMonthsTotal = nineMonthsTotal;
	}
	public Long getTwelveMonthsTotal() {
		return twelveMonthsTotal;
	}
	public void setTwelveMonthsTotal(Long twelveMonthsTotal) {
		this.twelveMonthsTotal = twelveMonthsTotal;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public Long getAddPatient() {
		return addPatient;
	}
	public void setAddPatient(Long addPatient) {
		this.addPatient = addPatient;
	}
	public Long getPatientCount() {
		return patientCount;
	}
	public void setPatientCount(Long patientCount) {
		this.patientCount = patientCount;
	}
	public Long getEventTotal() {
		return eventTotal;
	}
	public void setEventTotal(Long eventTotal) {
		this.eventTotal = eventTotal;
	}
	

}
