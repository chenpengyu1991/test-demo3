/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.idm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.idm.common.ReportStatus;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 直报查询表单
 * 
 * @version 1.0, 2013-3-7
 * @author Ye jianfei
 */
public class ReportQueryForm {
	private String personId;
	private String idcard;
	private String name;
	private String gender;
	private String birthBeginDate;
	private String birthEndDate;
	private String type;
	private String fillBeginDate;
	private String fillEndDate;
	private String fillOrganCode;
    private String surveyOrgCode;
	private String reportStatus;
	private String caseStatus;
	private String reportCardTypeCode;
    private String infectiousCode;
	private String dateFlag;
    private String tab;
    private String logoff;
    private String frStatus;
    private String tsStatus;
    private String columnName;
    private String repeatConditions;
    private String modifySurveyOrg;
    private String diseaseType;
    

	public String getModifySurveyOrg() {
		return modifySurveyOrg;
	}

	public void setModifySurveyOrg(String modifySurveyOrg) {
		this.modifySurveyOrg = modifySurveyOrg;
	}

	public String getRepeatConditions() {
		return repeatConditions;
	}

	public void setRepeatConditions(String repeatConditions) {
		this.repeatConditions = repeatConditions;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}
	
	/**
	 * @param idcard the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the birthBeginDate
	 */
	public String getBirthBeginDate() {
		return birthBeginDate;
	}
	
	/**
	 * @param birthBeginDate the birthBeginDate to set
	 */
	public void setBirthBeginDate(String birthBeginDate) {
		this.birthBeginDate = birthBeginDate;
	}
	
	/**
	 * @return the birthEndDate
	 */
	public String getBirthEndDate() {
		return birthEndDate;
	}
	
	/**
	 * @param birthEndDate the birthEndDate to set
	 */
	public void setBirthEndDate(String birthEndDate) {
		this.birthEndDate = birthEndDate;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the fillBeginDate
	 */
	public String getFillBeginDate() {
		return fillBeginDate;
	}
	
	/**
	 * @param fillBeginDate the fillBeginDate to set
	 */
	public void setFillBeginDate(String fillBeginDate) {
		this.fillBeginDate = fillBeginDate;
	}
	
	/**
	 * @return the fillEndDate
	 */
	public String getFillEndDate() {
		return fillEndDate;
	}
	
	/**
	 * @param fillEndDate the fillEndDate to set
	 */
	public void setFillEndDate(String fillEndDate) {
		this.fillEndDate = fillEndDate;
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

    public String getSurveyOrgCode() {
        return surveyOrgCode;
    }

    public void setSurveyOrgCode(String surveyOrgCode) {
        this.surveyOrgCode = surveyOrgCode;
    }

    /**
	 * @return the reportStatus
	 */
	public String getReportStatus() {
		return reportStatus;
	}
	
	/**
	 * @param reportStatus the reportStatus to set
	 */
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    /**
	 * @return the reportCardTypeCode
	 */
	public String getReportCardTypeCode() {
		return reportCardTypeCode;
	}
	
	/**
	 * @param reportCardTypeCode the reportCardTypeCode to set
	 */
	public void setReportCardTypeCode(String reportCardTypeCode) {
		this.reportCardTypeCode = reportCardTypeCode;
	}

    public String getInfectiousCode() {
        return infectiousCode;
    }

    public void setInfectiousCode(String infectiousCode) {
        this.infectiousCode = infectiousCode;
    }

    public String getDateFlag() {
        return dateFlag;
    }

    public void setDateFlag(String dateFlag) {
        this.dateFlag = dateFlag;
    }

    public String getTsStatus() {
        return tsStatus;
    }

    public void setTsStatus(String tsStatus) {
        this.tsStatus = tsStatus;
    }

    public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
		return criteria;
	}

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }

    public String getFrStatus() {
        return frStatus;
    }

    public void setFrStatus(String frStatus) {
        this.frStatus = frStatus;
    }

    public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public Criteria getDateCriteria(Criteria criteria){
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("idcard", OP.LIKE, idcard);
		}

		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("D.name", OP.LIKE, name);
		}

		/*性别*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gender", OP.LIKE, gender);
		}



		/*出生日期*/
		Date birthBeginDate = DateUtil.parseSimpleDate(this.birthBeginDate, null);
		Date birthEndDate = DateUtil.parseSimpleDate(this.birthEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "D.birthday", birthBeginDate,birthEndDate);
//		/*传染病类型*/
//		if (StringUtils.isNotBlank(type)){
//			criteria.add("infectiousType", OP.EQ, type);
//		}

		/*填写日期|发病日期*/
		Date fillBeginDate = DateUtil.parseSimpleDate(this.fillBeginDate, null);
		Date fillEndDate = DateUtil.parseSimpleDate(this.fillEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "fillDate", fillBeginDate,fillEndDate);
        if("2".equals(this.getDateFlag())){
            criteria.remove("fillDate");
            DateUtil.getCriteriaByDateRange(criteria, "pathogenesisDate", fillBeginDate,fillEndDate);
        }

		if (ObjectUtil.isNotEmpty(fillOrganCode)){
           /* Criteria ca = new Criteria("CURRENT_UNIT", OP.EQ, fillOrganCode);
            Criteria ca1 = new Criteria("fillOrganCode", OP.EQ, fillOrganCode);
            ca.add(LOP.OR, ca1);
			criteria.add(ca);*/
            Criteria ca1 = new Criteria("fillOrganCode", OP.EQ, fillOrganCode);
			criteria.add(ca1);
		}

        if (ObjectUtil.isNotEmpty(surveyOrgCode)){
            Criteria criteria1 = new Criteria("CURRENT_UNIT", OP.EQ, surveyOrgCode);
//            Criteria criteria2 = new Criteria("fillOrganCode", OP.EQ, surveyOrgCode);
//            criteria1.add(LOP.OR, criteria2);
            criteria.add(criteria1);
        }
        //个案填写单位
        if (ObjectUtil.isNotEmpty(modifySurveyOrg)){
            criteria.add("modifySurveyOrg",modifySurveyOrg);
        }

        if (StringUtils.isNotEmpty(reportStatus)){
			criteria.add("reportStatus", OP.EQ, reportStatus);
		}else{
			Integer[] status = new Integer[]{ReportStatus.NOT_VERIFY.getValue(), ReportStatus.HOSPITAL_VERIFY.getValue(), ReportStatus.CANCEL.getValue()};
			criteria.add("reportStatus", OP.IN,status);
		}

		/*报卡状态
		if (StringUtils.isNotEmpty(reportStatus)){
			criteria.add("reportStatus", OP.EQ, reportStatus);
		}else{
			Integer [] status = new Integer[]{ReportStatus.READY.getValue(),ReportStatus.REJECT.getValue(),ReportStatus.VERIFIED_FIRST.getValue(),ReportStatus.VERIFIED_SECOND.getValue(),ReportStatus.CANCEL.getValue()};
			criteria.add("reportStatus", OP.IN,status);
		}*/

        /*个案状态*/
        if (StringUtils.isNotEmpty(caseStatus)){
        	criteria.add("caseStatus", OP.EQ, caseStatus);
           /* if("case".equals(tab)){
                criteria.add("caseStatus", OP.EQ, caseStatus);
            }*/
//            if("fr".equals(tab)){
//                criteria.add("FR_STATUS", OP.EQ, caseStatus);
//            }
//            if("ts".equals(tab)){
//                criteria.add("TS_STATUS", OP.EQ, caseStatus);
//            }
        }

        if(ObjectUtil.isNotEmpty(frStatus)){
            criteria.add("FR_STATUS", OP.EQ, frStatus);
        }
        if(ObjectUtil.isNotEmpty(tsStatus)){
            criteria.add("TS_STATUS", OP.EQ, tsStatus);
        }

        /*档案状态*/
        if (ObjectUtil.isNotEmpty(logoff)){
            criteria.add("S.LOGOFF", OP.EQ, logoff);
        }
		
		/*报卡类型*/
		if (StringUtils.isNotEmpty(reportCardTypeCode)){
			criteria.add("reportCardTypeCode", OP.EQ, reportCardTypeCode);
		}
		/*专项与法定区分字段*/
		criteria.add("idmType", OP.EQ, "1");
        if(StringUtils.isNotEmpty(infectiousCode)){
            criteria.add("infectiousCode", OP.EQ, infectiousCode);
        }
		return criteria;
	}
	
	public Criteria getFillDateRange(){
		Criteria criteria = new Criteria();
		/*填写日期|发病日期*/
		Date fillBeginDate = DateUtil.parseSimpleDate(this.fillBeginDate, null);
		Date fillEndDate = DateUtil.parseSimpleDate(this.fillEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "fillDate", fillBeginDate,fillEndDate);
		return criteria;
	}
	public Criteria getDiseaseControlCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtils.isNotBlank(personId)) {
			criteria.add("D.person_Id", personId);
		}
		return criteria;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
