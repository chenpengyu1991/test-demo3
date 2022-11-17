package com.founder.rhip.ihm.controller.form;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

/**
 * 人力资源
 * @author chen_tao
 *
 */
public class ConsultationQueryForm {
	
    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;
    //姓名
    private String name;
    //身份证号
    private String idcard;
    //会诊单号
    private String consultationRecordCode;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	

	public String getConsultationRecordCode() {
		return consultationRecordCode;
	}

	public void setConsultationRecordCode(String consultationRecordCode) {
		this.consultationRecordCode = consultationRecordCode;
	}

	public Criteria getCriteria(){
		Criteria ca = new Criteria();
		if(StringUtil.isNotEmpty(name)){
			ca.add("name", OP.LIKE, name);
		}

		if(StringUtil.isNotEmpty(idcard)){
			ca.add("idcard",idcard);
		}
		
		if (StringUtil.isNotEmpty(consultationRecordCode)) {
			ca.add("consultationRecordCode", consultationRecordCode);
		}
		/* 时间范围--会诊日期 */
		Date beginDate = DateUtil.parseDateString(this.beginDate);
		Date endDate = DateUtil.parseDateString(this.endDate);
		DateUtil.getCriteriaByDateRange(ca, "CONSULTATION_DAE", beginDate,endDate);
		return ca;
	}
}
