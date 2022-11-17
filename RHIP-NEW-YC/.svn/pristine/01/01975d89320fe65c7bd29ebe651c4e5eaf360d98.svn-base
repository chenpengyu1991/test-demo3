package com.founder.rhip.report.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.ui.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WeightSetQueryForm {
	
	//机构类型
	private String organType;

	//镇
	private String gbCode;
    //市级医院或中心（上级）
    private String centerCode;
    //站（当前机构）
    private String organCode;

	//权重类型
	private String rpType;

    //权重指标类型
    private String weightIndex;

    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;

    /***
     * @return
     */
    public Criteria getCriteria(){
        Criteria ca = new Criteria();

        ca.add("ORGAN_TYPE",this.organType);
        ca.add("GB_CODE",this.gbCode);
        ca.add("CENTER_CODE",this.centerCode);
        ca.add("ORGAN_CODE",this.organCode);
        ca.add("RP_TYPE",this.rpType);
        ca.add("WEIGHT_INDEX",this.weightIndex);
		/* 时间范围 --出入库日期*/
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
//		DateUtil.getCriteriaByDateRange(ca, "RP_BEGIN_DATE", beginDate,endDate);
//        DateUtil.getCriteriaByDateRange(ca, "RP_END_DATE", beginDate,endDate);
        ca.add("RP_BEGIN_DATE", this.beginDate);
        ca.add("RP_END_DATE",this.endDate);

        return ca;
    }
    
    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public String getGbCode() {
        return gbCode;
    }

    public void setGbCode(String gbCode) {
        this.gbCode = gbCode;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType;
    }

    public String getWeightIndex() {
        return weightIndex;
    }

    public void setWeightIndex(String weightIndex) {
        this.weightIndex = weightIndex;
    }

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
}
