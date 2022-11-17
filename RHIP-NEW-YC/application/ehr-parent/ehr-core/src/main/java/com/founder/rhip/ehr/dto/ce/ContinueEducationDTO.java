package com.founder.rhip.ehr.dto.ce;

import java.util.List;

import com.founder.rhip.ehr.entity.ce.ContinueEducation;

public class ContinueEducationDTO {
	String staffCode;
	String smpiId;

	List<ContinueEducation> ceList;


	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getSmpiId() {
		return smpiId;
	}

	public void setSmpiId(String smpiId) {
		this.smpiId = smpiId;
	}

	public List<ContinueEducation> getCeList() {
		return ceList;
	}

	public void setCeList(List<ContinueEducation> ceList) {
		this.ceList = ceList;
	}

}
