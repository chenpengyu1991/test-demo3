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
import com.founder.rhip.idm.common.IdmType;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 疟疾专项血检登记查询表单
 * 
 * @version 1.0, 2013-5-6
 * @author Ye jianfei
 */
public class RegisterQueryForm {
	private String name;
	private String gender;
	private String testResult;//血检结果
	private String specialStatus;//登记状态
	private String pathogenesisBeginDate;//发病开始日期
	private String pathogenesisEndDate;//发病结束日期
	private String testBeginDate;//血检开始日期
	private String testEndDate;//血检结束日期
	private String idcard;//身份证号
	private String malariaType;//疟疾类型
	private String patientName;//重点人群-患者姓名
	private String reportBeginDate;//重点人群-填表开始日期
	private String reportEndDate;//重点人群-填表结束日期
    private String visitResult;//走访结果
    private String acceptTown;//所属城镇
    private String acceptUnit;//所属机构
    private String logoff;//注销状态
    private String floatPopulation;//常住类型
    private String reportOrg;//报告单位



    public String getLogoff() {
		return logoff;
	}

	
	public void setLogoff(String logoff) {
		this.logoff = logoff;
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
	 * @return the testResult
	 */
	public String getTestResult() {
		return testResult;
	}

	/**
	 * @param testResult the testResult to set
	 */
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	/**
	 * @return the specialStatus
	 */
	public String getSpecialStatus() {
		return specialStatus;
	}

	/**
	 * @param specialStatus the specialStatus to set
	 */
	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}

	/**
	 * @return the pathogenesisBeginDate
	 */
	public String getPathogenesisBeginDate() {
		return pathogenesisBeginDate;
	}

	/**
	 * @param pathogenesisBeginDate the pathogenesisBeginDate to set
	 */
	public void setPathogenesisBeginDate(String pathogenesisBeginDate) {
		this.pathogenesisBeginDate = pathogenesisBeginDate;
	}

	/**
	 * @return the pathogenesisEndDate
	 */
	public String getPathogenesisEndDate() {
		return pathogenesisEndDate;
	}

	/**
	 * @param pathogenesisEndDate the pathogenesisEndDate to set
	 */
	public void setPathogenesisEndDate(String pathogenesisEndDate) {
		this.pathogenesisEndDate = pathogenesisEndDate;
	}

	/**
	 * @return the testBeginDate
	 */
	public String getTestBeginDate() {
		return testBeginDate;
	}

	/**
	 * @param testBeginDate the testBeginDate to set
	 */
	public void setTestBeginDate(String testBeginDate) {
		this.testBeginDate = testBeginDate;
	}

	/**
	 * @return the testEndDate
	 */
	public String getTestEndDate() {
		return testEndDate;
	}

	/**
	 * @param testEndDate the testEndDate to set
	 */
	public void setTestEndDate(String testEndDate) {
		this.testEndDate = testEndDate;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMalariaType() {
        return malariaType;
    }

    public void setMalariaType(String malariaType) {
        this.malariaType = malariaType;
    }

    public String getVisitResult() {
        return visitResult;
    }

    public void setVisitResult(String visitResult) {
        this.visitResult = visitResult;
    }

    public String getAcceptTown() {
        return acceptTown;
    }

    public void setAcceptTown(String acceptTown) {
        this.acceptTown = acceptTown;
    }

    public String getAcceptUnit() {
        return acceptUnit;
    }

    public void setAcceptUnit(String acceptUnit) {
        this.acceptUnit = acceptUnit;
    }

    public String getFloatPopulation() {
        return floatPopulation;
    }

    public void setFloatPopulation(String floatPopulation) {
        this.floatPopulation = floatPopulation;
    }

    public String getReportOrg() {
        return reportOrg;
    }

    public void setReportOrg(String reportOrg) {
        this.reportOrg = reportOrg;
    }

    public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
		return criteria;
	}
    public Criteria getFgCriteria() {
        return getFgDateCriteria();
	}

    /*
     * 血检登记
     * */
    public Criteria getRegisterCriteria(){
    	Criteria criteria = new Criteria();
		/*姓名-一般情况*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("gen.name", OP.LIKE, name);
		}
		/*性别-一般情况*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gen.gender", gender);
		}
        /*常住类型-一般情况*/
        if (StringUtils.isNotBlank(floatPopulation)){
            criteria.add("gen.float_Population", floatPopulation);
        }
		/*登记状态*/
		if (StringUtils.isNotBlank(specialStatus)){
        	criteria.add("status.SPECIAL_STATUS", specialStatus);
		}
		/*发病日期*/
		Date pathogenesisBeginDate = DateUtil.parseSimpleDate(this.pathogenesisBeginDate, null);
		Date pathogenesisEndDate = DateUtil.parseSimpleDate(this.pathogenesisEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "attc.PATHOGENESIS_DATE", pathogenesisBeginDate,pathogenesisEndDate);
		/*血检日期*/
		Date testBeginDate = DateUtil.parseSimpleDate(this.testBeginDate, null);
		Date testEndDate = DateUtil.parseSimpleDate(this.testEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "lab.TEST_DT", testBeginDate,testEndDate);
		
		/*血检结果*/
		if (StringUtils.isNotBlank(testResult)){
			criteria.add("lab.TEST_RESULT", testResult);
		}
         /*报告单位*/
        if (StringUtils.isNotBlank(reportOrg)){
            criteria.add("cas.report_Org", reportOrg);
        }

		/*专项与法定区分字段*/
		criteria.add("IDM_TYPE", OP.EQ, IdmType.MALARIA.getValue());    
		return criteria;
    }
    public Criteria getAiCriteria() {
        Criteria criteria = new Criteria();
        /*姓名*/
        if (StringUtils.isNotBlank(name)){
            criteria.add("name", OP.LIKE, name);
        }
		/*性别*/
        if (StringUtils.isNotBlank(gender)){
            criteria.add("gender", OP.LIKE, gender);
        }
        /*走访结果*/
        if (StringUtils.isNotBlank(visitResult)){
            criteria.add("visitResult", visitResult);
        }
        //所属城镇
        if (StringUtils.isNotBlank(acceptTown)){
            criteria.add("acceptTown", acceptTown);
        }
        //所属机构
        if (StringUtils.isNotBlank(acceptUnit)){
            criteria.add("acceptUnit", acceptUnit);
        }
        return criteria;
    }

	public Criteria getFgDateCriteria(){
		Criteria criteria = new Criteria();
		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("NAME", OP.LIKE, name);
		}

		/*性别*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gender",  gender);
		}
		
		/*填表日期*/
		Date reportBeginDate = DateUtil.parseSimpleDate(this.reportBeginDate, null);
		Date reportEndDate = DateUtil.parseSimpleDate(this.reportEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "REPORT_DATE", reportBeginDate,reportEndDate);

		/*所属城镇*/
        if (StringUtils.isNotEmpty(acceptTown)){
            criteria.add("ACCEPT_TOWN", OP.EQ, acceptTown);
        }	
        
		/*所属机构*/
        if (StringUtils.isNotEmpty(acceptUnit)){
            criteria.add("ACCEPT_UNIT", OP.EQ, acceptUnit);
        }	
        return criteria;
	}
	private Criteria getDateCriteria(Criteria criteria){

		/*姓名-一般情况*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("gen.name", OP.LIKE, name);
		}

		/*性别-一般情况*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gen.gender", OP.LIKE, gender);
		}
		/*登记状态*/
		if (StringUtils.isNotBlank(specialStatus)){
            if("3".equals(specialStatus)){
                criteria.add("status.SPECIAL_STATUS", specialStatus);
            }else {
                criteria.add("status.SPECIAL_STATUS", OP.GE, specialStatus);
            }
		}
		/*发病日期*/
		Date pathogenesisBeginDate = DateUtil.parseSimpleDate(this.pathogenesisBeginDate, null);
		Date pathogenesisEndDate = DateUtil.parseSimpleDate(this.pathogenesisEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "attc.PATHOGENESIS_DATE", pathogenesisBeginDate,pathogenesisEndDate);
		/*血检日期*/
		Date testBeginDate = DateUtil.parseSimpleDate(this.testBeginDate, null);
		Date testEndDate = DateUtil.parseSimpleDate(this.testEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "lab.TEST_DT", testBeginDate,testEndDate);
		
		/*血检结果*/
		if (StringUtils.isNotBlank(testResult)){
			criteria.add("lab.TEST_RESULT", testResult);
		}

        /*身份证号*/
         if (StringUtils.isNotBlank(idcard)){
         criteria.add("gen.IDCARD", idcard);
         }

        /*疟疾类型*/
        if (StringUtils.isNotBlank(malariaType)){
            criteria.add("lab.RDT", malariaType);
        }

        /*身份证号*/
        if (StringUtils.isNotBlank(visitResult)){
            criteria.add("gen.IDCARD", visitResult);
        }
        /*注销状态*/
        if (StringUtils.isNotBlank(logoff)){
            criteria.add("status.LOGOFF", logoff);
        }        
        
		/*专项与法定区分字段*/
		criteria.add("IDM_TYPE", OP.EQ, IdmType.MALARIA.getValue());
	
		return criteria;
	}

	
	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	
	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	
	/**
	 * @return the reportBeginDate
	 */
	public String getReportBeginDate() {
		return reportBeginDate;
	}

	
	/**
	 * @param reportBeginDate the reportBeginDate to set
	 */
	public void setReportBeginDate(String reportBeginDate) {
		this.reportBeginDate = reportBeginDate;
	}

	
	/**
	 * @return the reportEndDate
	 */
	public String getReportEndDate() {
		return reportEndDate;
	}

	
	/**
	 * @param reportEndDate the reportEndDate to set
	 */
	public void setReportEndDate(String reportEndDate) {
		this.reportEndDate = reportEndDate;
	}
}
