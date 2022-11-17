package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TuberculosisDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1331904153556480875L;
	private String gbCode;
	private String organCode;
	private List<Tuberculosis> TuberculosisDtoList;
	public String getGbCode() {
		return gbCode;
	}
	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public List<Tuberculosis> getTuberculosisDtoList() {
		return TuberculosisDtoList;
	}
	public void setTuberculosisDtoList(List<Tuberculosis> tuberculosisDtoList) {
		TuberculosisDtoList = tuberculosisDtoList;
	}
	
	
	
}
