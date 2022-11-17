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
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SchDiagnosis;
import com.founder.rhip.idm.common.SchStatus;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 血吸虫专项血检登记查询表单
 * 
 * @version 1.0, 2013-5-27
 * @author Ye jianfei
 */
public class SchQueryForm {
	private String name;
	private String gender;
	private String bloodTest;//血检结果类型
	private String bloodOption;//血检结果值
	private String specialStatus;//确诊结果
	private String idcard;//身份证号
	private String floatPopulation;//是否本地户籍
	private String caseStatus;//个案调查，管理状态：已管理人群、待建个案调查、待建治疗记录、晚血病人
	private String advancedStatus;//晚血病人管理状态：已管理晚血病人、待建晚血调查、待建信息管理、待建复查登记项
    private String logoff;//注销状态
    private String reportUnitCode;//报告单位
    private String caseType;//病例分类（晚血：是否死亡）
    private String ddiaBeginDt;//DDIA检查开始日期
    private String ddiaEndDt;//DDIA检查结束日期
    private String currentUnit;//管理机构


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

    public String getDdiaBeginDt() {
        return ddiaBeginDt;
    }

    public void setDdiaBeginDt(String ddiaBeginDt) {
        this.ddiaBeginDt = ddiaBeginDt;
    }

    public String getDdiaEndDt() {
        return ddiaEndDt;
    }

    public void setDdiaEndDt(String ddiaEndDt) {
        this.ddiaEndDt = ddiaEndDt;
    }

    public String getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(String currentUnit) {
        this.currentUnit = currentUnit;
    }

    public Criteria getRegisterCriteria(){
		Criteria criteria = new Criteria();
		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("NAME", OP.LIKE, name);
		}
		/*性别*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gender", OP.LIKE, gender);
		}
		/*血检结果*/
		if (StringUtils.isNotBlank(bloodTest)){
			if(StringUtil.isNotEmpty(bloodOption)){
				criteria.add(getBloodTest(bloodTest), bloodOption);
			}else{
				criteria.add(getBloodTest(bloodTest), OP.UEMPTY,"");
			}
		}
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("idcard", OP.LIKE, idcard);
		}
		/*确诊结果*/
		if (StringUtils.isNotBlank(specialStatus)){
			switch (specialStatus){
				case "1":
					criteria.add("specialStatus", OP.IN,new Integer[]{SchStatus.REGISTER_DOCTOR.getValue(), SchStatus.REGISTER_SQZX.getValue(), SchStatus.REGISTER_JKTJZX.getValue(), SchStatus.FBK_VERIFY.getValue()});
					break;
				case "2":
					criteria.add("specialStatus", OP.IN,new Integer[]{SchStatus.JK_VERIFY.getValue()});
					break;
				case "3":
					criteria.add("specialStatus", OP.IN,new Integer[]{SchStatus.WRITE.getValue()});
					break;
				case "4":
					criteria.add("specialStatus", OP.IN,new Integer[]{SchStatus.CURE.getValue()});
					break;
				case "5":
					criteria.add("specialStatus", OP.IN,new Integer[]{SchStatus.ELIMINATION.getValue()});
					break;					
			}
		}
		/*是否本地户籍*/
		if (StringUtils.isNotBlank(floatPopulation)){
			criteria.add("gen.FLOAT_POPULATION", floatPopulation);
		}
		/*报告单位*/
		if (StringUtils.isNotBlank(reportUnitCode)){
			criteria.add("cas.REPORT_ORG", reportUnitCode);
		}
        /*DDIA检查日期*/
        Date ddiaBeginDate = DateUtil.parseSimpleDate(this.ddiaBeginDt, null);
        Date ddiaEndDate = DateUtil.parseSimpleDate(this.ddiaEndDt, null);
        DateUtil.getCriteriaByDateRange(criteria, "lab.DDIA_DT", ddiaBeginDate,ddiaEndDate);
		/*专项与法定区分字段*/
		criteria.add("IDM_TYPE", OP.EQ, IdmType.SCHISTOSOME.getValue());
        return criteria;
	}

	/*
	 * 	根据选择的血检结果类型查询不同字段
	 * */
	private String getBloodTest(String id){
		String result = "";
		switch(id){
			case "1":
				result = "lab.IHA_CHECK";
				break;
			case "2":
				result = "lab.DDIA";
				break;
			case "3":
				result = "lab.COPT";
				break;
			case "4":
				result = "lab.STOOL";
				break;
		}
		return result;
	}
	public Criteria getCaseCriteria(){
		Criteria criteria = new Criteria();
		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("NAME", OP.LIKE, name);
		}
		/*性别*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gender", OP.LIKE, gender);
		}
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("idcard", OP.LIKE, idcard);
		}
		/*管理状态*/
		criteria.add("specialStatus", OP.IN,new Integer[]{SchStatus.JK_VERIFY.getValue(), SchStatus.WRITE.getValue(), SchStatus.CURE.getValue()});
		if (StringUtils.isNotBlank(caseStatus)){
			switch (caseStatus){
				case "1":
					criteria.add("specialStatus", OP.GE, SchStatus.WRITE.getValue());//已管理人群
					break;
				case "2":
					criteria.add("specialStatus", SchStatus.JK_VERIFY.getValue());//待建个案
					break;
				case "3":
					criteria.add("dia.TRANSFER_TREATMENT_ACCORDING", OP.IN,
							new String[]{SchDiagnosis.ACUTE.getValue()
							, SchDiagnosis.CHRONIC.getValue()
							, SchDiagnosis.EXPANDED_TREAT.getValue()});//待建治疗记录
					break;
				case "4":
					criteria.add("dia.TRANSFER_TREATMENT_ACCORDING", SchDiagnosis.LATER.getValue());//晚血病人管理
					break;
			}
		}
		/*是否本地户籍*/
		if (StringUtils.isNotBlank(floatPopulation)){
			criteria.add("gen.FLOAT_POPULATION", floatPopulation);
		}
        /*注销状态*/
        if (StringUtils.isNotBlank(logoff)){
            criteria.add("status.LOGOFF", logoff);
        } 		
		/*专项与法定区分字段*/
		criteria.add("IDM_TYPE", OP.IN,new String[]{IdmType.SCHISTOSOME_CASE.getValue(), IdmType.SCHISTOSOME.getValue()});
        return criteria;
	}

	public Criteria getAdvancedCriteria(){
		Criteria criteria = new Criteria();
		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("NAME", OP.LIKE, name);
		}
		/*性别*/
		if (StringUtils.isNotBlank(gender)){
			criteria.add("gender", OP.LIKE, gender);
		}
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("idcard", OP.LIKE, idcard);
		}
		/*管理状态*/
		criteria.add("specialStatus", OP.GE, SchStatus.WRITE.getValue());//已建立个案
		criteria.add("dia.TRANSFER_TREATMENT_ACCORDING", SchDiagnosis.LATER.getValue());//诊断为晚血病人
		if (StringUtils.isNotBlank(advancedStatus)){
			switch (advancedStatus){
				case "1":
					criteria.add("card.ID", OP.UEMPTY,"");//已管理晚血病人
					break;
				case "2":
					criteria.add("survey.ID", OP.IS,"NULL");//待建晚血调查
					break;
				case "3":
					criteria.add("card.ID", OP.IS,"NULL").add("survey.ID", OP.UEMPTY,"");//待建信息管理
					break;
				case "4":
					criteria.add("reexamine.ID", OP.IS,"NULL").add("card.ID", OP.UEMPTY,"NULL");;//待建复查登记
					break;
			}
		}
		/*是否本地户籍*/
		if (StringUtils.isNotBlank(floatPopulation)){
			criteria.add("gen.FLOAT_POPULATION", floatPopulation);
		}	
        /*注销状态*/
        if (StringUtils.isNotBlank(logoff)){
            criteria.add("status.LOGOFF", logoff);
        } 
        /*是否死亡*/
        if (StringUtils.isNotBlank(caseType)){
            Criteria criteria1 = new Criteria();
            if ("1".equals(caseType)){
                criteria1.add("other.CASE_TYPE", "4");
                criteria1.add(LOP.OR, "other.CASE_TYPE_LAST", "4");
                criteria1.add(LOP.OR, "otherSurvey.OUTCOME_CODE", "4");
                criteria.add(criteria1);
            } 	
            if ("2".equals(caseType)){
            	Criteria crType = new Criteria();
            	Criteria crTypeLast = new Criteria();
            	Criteria crOutcome = new Criteria();
            	crType.add("other.CASE_TYPE", OP.NE, "4");
            	crType.add(LOP.OR,"other.CASE_TYPE", OP.IS,"NULL");
            	
            	crTypeLast.add("other.CASE_TYPE_LAST", OP.NE, "4");
            	crTypeLast.add(LOP.OR,"other.CASE_TYPE_LAST", OP.IS,"NULL");
            	
            	crOutcome.add("otherSurvey.OUTCOME_CODE", OP.NE, "4");
            	crOutcome.add(LOP.OR,"otherSurvey.OUTCOME_CODE", OP.IS,"NULL");
            	
                criteria1.add(LOP.AND,crType);
                criteria1.add(LOP.AND,crTypeLast);
                criteria1.add(LOP.AND,crOutcome);

                criteria.add(criteria1);
            } 
        }

        /*管理机构*/
        if (StringUtils.isNotBlank(currentUnit)){
            criteria.add("status.CURRENT_UNIT", currentUnit);
        }
		/*专项与法定区分字段*/
		criteria.add("IDM_TYPE", OP.IN,new String[]{IdmType.SCHISTOSOME_CASE.getValue()
				, IdmType.SCHISTOSOME.getValue()
				, IdmType.SCHISTOSOME_ADVANCED_IMPORT.getValue()});
        return criteria;
	}
	
	/**
	 * @return the floatPopulation
	 */
	public String getFloatPopulation() {
		return floatPopulation;
	}

	/**
	 * @param floatPopulation the floatPopulation to set
	 */
	public void setFloatPopulation(String floatPopulation) {
		this.floatPopulation = floatPopulation;
	}

	/**
	 * @return the caseStatus
	 */
	public String getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @param caseStatus the caseStatus to set
	 */
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @return the bloodTest
	 */
	public String getBloodTest() {
		return bloodTest;
	}

	/**
	 * @param bloodTest the bloodTest to set
	 */
	public void setBloodTest(String bloodTest) {
		this.bloodTest = bloodTest;
	}

	/**
	 * @return the bloodOption
	 */
	public String getBloodOption() {
		return bloodOption;
	}

	/**
	 * @param bloodOption the bloodOption to set
	 */
	public void setBloodOption(String bloodOption) {
		this.bloodOption = bloodOption;
	}

	/**
	 * @return the advancedStatus
	 */
	public String getAdvancedStatus() {
		return advancedStatus;
	}

	/**
	 * @param advancedStatus the advancedStatus to set
	 */
	public void setAdvancedStatus(String advancedStatus) {
		this.advancedStatus = advancedStatus;
	}

	public String getLogoff() {
		return logoff;
	}

	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}

	public String getReportUnitCode() {
		return reportUnitCode;
	}

	public void setReportUnitCode(String reportUnitCode) {
		this.reportUnitCode = reportUnitCode;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

}
