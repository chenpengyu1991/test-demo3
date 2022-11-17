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
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.TbStatus;
import org.apache.commons.lang.StringUtils;

import java.util.Date;


/**
 * 结核病查询表单
 * @author Jiang Haiying
 */
public class TbQueryForm {
	
	/*姓名*/
	private String name;
	
	/*性别*/
	private String gender;
	
	/*身份证号*/
	private String idcard;
	
	/*户籍类型*/
	private String floatPopulation;
	
	/*治疗分类*/
	private String thisType;
	
	/*管理状态*/
	private Integer specialStatus;

	/*登记号*/
	private String registerNum;
	
	/*登记开始日期*/
	private String registerDtBegin;
	
	/*登记结束日期*/
	private String registerDtEnd;
	
	/*到位状态*/
    private String placeStatus;

    private String diagnosisType;
    private String lastDiagnosis;
    private String diagnosisAccording;
    private String diagnosisReasonMulti;
    private String diagnosisOther;

    /*管理方式*/
    private String thisManageType;

    /*管理方式*/
    private String manageType;
    
    private Date dateFrom;

    private Date dateTo;

    private String orgCode;
    /*注销状态*/
	private String logoff;

	private String ndyFlag;

	private String dangerFlag;

	private  String firstVist;

	public String getDangerFlag() {
		return dangerFlag;
	}

	public void setDangerFlag(String dangerFlag) {
		this.dangerFlag = dangerFlag;
	}

	public String getNdyFlag() {
		return ndyFlag;
	}

	public void setNdyFlag(String ndyFlag) {
		this.ndyFlag = ndyFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getFloatPopulation() {
		return floatPopulation;
	}

	public void setFloatPopulation(String floatPopulation) {
		this.floatPopulation = floatPopulation;
	}

	public String getThisType() {
		return thisType;
	}

	public void setThisType(String thisType) {
		this.thisType = thisType;
	}
	
	public Integer getSpecialStatus() {
		return specialStatus;
	}

	public void setSpecialStatus(Integer specialStatus) {
		this.specialStatus = specialStatus;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
		return criteria;
	}
	
	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public String getRegisterDtBegin() {
		return registerDtBegin;
	}

	public void setRegisterDtBegin(String registerDtBegin) {
		this.registerDtBegin = registerDtBegin;
	}

	public String getRegisterDtEnd() {
		return registerDtEnd;
	}

	public void setRegisterDtEnd(String registerDtEnd) {
		this.registerDtEnd = registerDtEnd;
	}

	private Criteria getDateCriteria(Criteria criteria){

		if (StringUtils.isNotBlank(name)){
			criteria.add("gen.name", OP.LIKE, name);
		}

		if (StringUtils.isNotBlank(gender)){
			criteria.add("gen.gender", gender);
		}
		
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("gen.idcard", OP.LIKE, idcard);
		}
		
		if (StringUtils.isNotBlank(floatPopulation)){
			criteria.add("gen.float_Population", floatPopulation);
		}
		
		if (StringUtils.isNotBlank(thisType)){
			criteria.add("other.this_Type", thisType);
		}
		
		if (StringUtils.isNotBlank(registerNum)){
			criteria.add("gen.register_Num", registerNum);
		}
		if (StringUtils.isNotBlank(thisManageType)){
			criteria.add("other.THIS_MANAGE_TYPE", thisManageType);
		}
		
		if (StringUtils.isNotBlank(manageType)){
			criteria.add("other.MANAGE_TYPE", manageType);
		}

		if (StringUtils.isNotBlank(orgCode)){
			criteria.add("other.orgCode", orgCode);
		}

		/*发病日期*/
		Date registerDtBegin = DateUtil.parseSimpleDate(this.registerDtBegin, null);
		Date registerDtEnd = DateUtil.parseSimpleDate(this.registerDtEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "dia.REGISTER_DT", registerDtBegin,registerDtEnd);
		
		if (StringUtils.isNotBlank(placeStatus)){
			criteria.add("status.place_status", placeStatus);
		}

        if (ObjectUtil.isNotEmpty(specialStatus)){
        	if(specialStatus.equals(TbStatus.RECOMMENDATION.getValue())){
				criteria.add("status.special_status", TbStatus.RECOMMENDATION.getValue());
			}else{
				criteria.add("status.special_status", OP.NE, TbStatus.RECOMMENDATION.getValue());
			}
        }
        if (StringUtils.isNotBlank(this.logoff)){
			criteria.add("status.logoff", logoff);
		}
        
		//指定查的是结核病
		criteria.add("IDM_TYPE", IdmType.TB.getValue());

		if (StringUtils.isNotBlank(ndyFlag)){
			criteria.add("status.NDY_FLAG", ndyFlag);
		}
		if (StringUtils.isNotBlank(dangerFlag)){
			//标记值
			String flagVal = "1";
			String dangerFlagArr[] = dangerFlag.split(",");
			Criteria criteriaDanger = null;
			for(int i=0;i< dangerFlagArr.length;i++){
				String dangerVal = dangerFlagArr[i];
				String columName = null;
				if("01".equals(dangerVal))
					columName = "status.danger_flag1";
				else if("02".equals(dangerVal))
					columName = "status.danger_flag2";
				else if("03".equals(dangerVal))
					columName = "status.danger_flag3";
				else if("04".equals(dangerVal))
					columName = "status.danger_flag4";
				else if("05".equals(dangerVal))
					columName = "status.danger_flag5";
				if(i==0) {
					criteriaDanger = new Criteria(columName,flagVal);
				}else{
					criteriaDanger.add(LOP.OR,new Criteria(columName,flagVal));
				}

			}
			criteria.add(LOP.AND, criteriaDanger);
		}
		return criteria;
	}

	public String getPlaceStatus() {
		return placeStatus;
	}

	public void setPlaceStatus(String placeStatus) {
		this.placeStatus = placeStatus;
	}

	public String getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

    public String getLastDiagnosis() {
        return lastDiagnosis;
    }

    public void setLastDiagnosis(String lastDiagnosis) {
        this.lastDiagnosis = lastDiagnosis;
    }


    public String getThisManageType() {
		return thisManageType;
	}

    public String getDiagnosisAccording() {
        return diagnosisAccording;
    }

    public void setDiagnosisAccording(String diagnosisAccording) {
        this.diagnosisAccording = diagnosisAccording;
    }

    public String getDiagnosisReasonMulti() {
        return diagnosisReasonMulti;
    }

    public void setDiagnosisReasonMulti(String diagnosisReasonMulti) {
        this.diagnosisReasonMulti = diagnosisReasonMulti;
    }

    public String getDiagnosisOther() {
        return diagnosisOther;
    }

    public void setDiagnosisOther(String diagnosisOther) {
        this.diagnosisOther = diagnosisOther;
    }

    public void setThisManageType(String thisManageType) {
		this.thisManageType = thisManageType;
	}

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

	public String getManageType() {
		return manageType;
	}

	public void setManageType(String manageType) {
		this.manageType = manageType;
	}

	public String getLogoff() {
		return logoff;
	}

	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}

	public String getFirstVist() {
		return firstVist;
	}

	public void setFirstVist(String firstVist) {
		this.firstVist = firstVist;
	}
}
