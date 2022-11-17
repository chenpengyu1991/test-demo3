package com.founder.rhip.ihm.controller.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ihm.common.Constants;


public class StatisticsQueryForm {
    private String unitCode;
    private String beginDate;
    private String endDate;
    private String context;
    private String groupByObj;

    private String inputSuperOrganCode;

    private String inputOrganCode;

    private String gBCode;

    //查询类型
    private String genreCode;

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: getSelectOrgCode
     * @Description: 获取选中的代码
     */
    public String getSelectOrgCode() {
        if (ObjectUtil.isNotEmpty(inputOrganCode)) {
            return inputOrganCode;
        } else if (ObjectUtil.isNotEmpty(inputSuperOrganCode)) {
            return inputSuperOrganCode;
        }
        return gBCode;
    }

    /**
     * @param @return
     * @return OrgGenreCode
     * @throws
     * @Title: getSelectOrgCodeType
     * @Description: 获取选中的机构类型
     */
    public Integer getSelectOrgCodeType() {
        if (ObjectUtil.isNotEmpty(inputOrganCode)) {
            return TargetDTO.STATION;
        } else if (ObjectUtil.isNotEmpty(inputSuperOrganCode)) {
            return TargetDTO.CENTER;
        } else if (ObjectUtil.isNotEmpty(gBCode)) {
            return TargetDTO.GB;
        }
        return TargetDTO.NO_SELECT;
    }

    /**
     * @param @return
     * @return OrgGenreCode
     * @throws
     * @Title: getSelectOrgCodeNextCodeType
     * @Description: 获取选中机构的下级机构类型
     */
    public Integer getSelectOrgCodeNextCodeType() {
        if (ObjectUtil.isNotEmpty(inputOrganCode)) {
            return TargetDTO.STATION;
        } else if (ObjectUtil.isNotEmpty(inputSuperOrganCode)) {
            return TargetDTO.STATION;
        } else if (ObjectUtil.isNotEmpty(gBCode)) {
            return TargetDTO.CENTER;
        }
        return TargetDTO.GB;
    }

    public String getInputSuperOrganCode() {
        return inputSuperOrganCode;
    }

    public void setInputSuperOrganCode(String inputSuperOrganCode) {
        this.inputSuperOrganCode = inputSuperOrganCode;
    }

    public String getInputOrganCode() {
        return inputOrganCode;
    }

    public void setInputOrganCode(String inputOrganCode) {
        this.inputOrganCode = inputOrganCode;
    }

    public String getgBCode() {
        return gBCode;
    }

    public void setgBCode(String gBCode) {
        this.gBCode = gBCode;
    }

    public String getGroupByObj() {
        return groupByObj;
    }

    public void setGroupByObj(String groupByObj) {
        this.groupByObj = groupByObj;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Criteria getCriteria() {
        Criteria criteria = new Criteria();
		/* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
        Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
        DateUtil.getCriteriaByDateRange(criteria, "CREATE_DATE", beginDate, endDate);
        return criteria;
    }

    public Map<String, String> getParamMap(){

        Map<String, String> paramMap = new HashMap<String, String>();
        if(StringUtil.isNotEmpty(genreCode)){
            paramMap.put("genreCode",genreCode);
        }
        if(StringUtil.isNotEmpty(inputOrganCode)){
            paramMap.put("organCode",inputOrganCode);
        }
        if(StringUtil.isNotEmpty(inputSuperOrganCode)){
            paramMap.put("superOrganCode",inputSuperOrganCode);
        }
        if(StringUtil.isNotEmpty(gBCode)){
            paramMap.put("gbCode",gBCode);
        }
        if(StringUtil.isNotEmpty(beginDate)){
            paramMap.put("beginDate",beginDate);
        }
        if(StringUtil.isNotEmpty(endDate)){
            paramMap.put("endDate",endDate);
        }
        return paramMap;
    }

    public String getGenreCode() {
        return genreCode;
    }
}
