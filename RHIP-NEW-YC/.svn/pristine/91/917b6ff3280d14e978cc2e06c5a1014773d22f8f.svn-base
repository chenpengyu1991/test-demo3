package com.founder.rhip.ech.controller.form;


import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class EchManageQueryForm {

	private String examYear;

	private String name;

	private String idcard;

	private String gender;
	
	private String inputOrganCode;//站
	
	private String inputSuperOrganCode;//中心
	
	private String gbcode;//镇

	private String tcmConclusion;//体质类型,文字

	private String tcmStatus;//是否管理
	
	private String selectCodeType;
	
	private String organCode;

	private String logoff;

	private String searchPastreet;
	
	private String searchPatownShip;
	
	public String getSearchPastreet() {
		return searchPastreet;
	}

	public void setSearchPastreet(String searchPastreet) {
		this.searchPastreet = searchPastreet;
	}

	public String getSearchPatownShip() {
		return searchPatownShip;
	}

	public void setSearchPatownShip(String searchPatownShip) {
		this.searchPatownShip = searchPatownShip;
	}

	public String getExamYear() {
		return examYear;
	}

	public void setExamYear(String examYear) {
		this.examYear = examYear;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	
	public String getTcmConclusion() {
		return tcmConclusion;
	}

	
	public void setTcmConclusion(String tcmConclusion) {
		this.tcmConclusion = tcmConclusion;
	}

	
	public String getTcmStatus() {
		return tcmStatus;
	}

	
	public void setTcmStatus(String tcmStatus) {
		this.tcmStatus = tcmStatus;
	}

	
	public String getInputSuperOrganCode() {
		return inputSuperOrganCode;
	}

	
	public void setInputSuperOrganCode(String inputSuperOrganCode) {
		this.inputSuperOrganCode = inputSuperOrganCode;
	}

	public Criteria manageCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(examYear)) {
			Calendar beginDate = Calendar.getInstance();
			beginDate.set(Calendar.YEAR, Integer.parseInt(examYear));
			beginDate.set(Calendar.MONTH, Calendar.JANUARY);
			beginDate.set(Calendar.DAY_OF_MONTH, 1);
			
			Calendar endDate = Calendar.getInstance();
			endDate.set(Calendar.YEAR, Integer.parseInt(examYear));
			endDate.set(Calendar.MONTH, Calendar.DECEMBER);
			endDate.set(Calendar.DAY_OF_MONTH, 31);
			
			criteria.add("record.EXAM_YEAR", OP.LT, endDate.getTime());
			criteria.add("examYearStr", examYear);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("record.name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("record.idcard", idcard.toUpperCase());
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("record.gender", gender);
		}
		if (ObjectUtil.isNotEmpty(logoff)) {
			criteria.add("logoff", logoff);
		}
		if (StringUtil.isNotEmpty(tcmStatus)) {
			if("0".equals(tcmStatus)){
				if (StringUtil.isNotEmpty(tcmConclusion)) {
					criteria.add("IS_TCM", tcmStatus);
				}else{
					criteria.add("IS_TCM", OP.IS, null);
				}
			}else{
				criteria.add("IS_TCM", OP.GE, tcmStatus);
			}
		}
		if (StringUtil.isNotEmpty(inputOrganCode)) {
			criteria.add("inputOrganCode", inputOrganCode);
		}
		if (StringUtil.isNotEmpty(tcmConclusion)) {
			criteria.add("tcmConclusion", tcmConclusion);
		}
		if (ObjectUtil.isNotEmpty(searchPastreet)) {
			criteria.add("pastreet", searchPastreet);
		}else if (ObjectUtil.isNotEmpty(searchPatownShip)) {
			criteria.add("patown_ship", searchPatownShip);
		}
    	if(StringUtil.isNotEmpty(organCode)){
        	switch(selectCodeType){
        		case "B100"://中心
         			criteria.add("inputSuperOrganCode",organCode);
        			break;
        		case "0"://镇
        			criteria.add("gbcode",organCode);
        			break;
        		default:
        			criteria.add("inputOrganCode",organCode);
        	}    		
    	}  
		return criteria;
	}

	public Criteria statisticsCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(examYear)) {
			criteria.add("examYear", examYear);
		}
		if (StringUtil.isNotEmpty(inputOrganCode)) {
			criteria.add("inputOrganCode", inputOrganCode);
		}
		if (StringUtil.isNotEmpty(inputSuperOrganCode)) {
			criteria.add("inputSuperOrganCode",inputSuperOrganCode);
		}
		if (StringUtil.isNotEmpty(gbcode)) {
			criteria.add("gbcode",gbcode);
		}
		return criteria;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getSelectCodeType() {
		return selectCodeType;
	}

	public void setSelectCodeType(String selectCodeType) {
		this.selectCodeType = selectCodeType;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getLogoff() {
		return logoff;
	}

	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}
}
