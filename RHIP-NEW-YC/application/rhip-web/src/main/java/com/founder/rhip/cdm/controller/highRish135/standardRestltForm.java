package com.founder.rhip.cdm.controller.highRish135;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * Created by wanghui on 17-5-10.
 */
public class standardRestltForm {

    private String name;
    private String idNo;
    private Integer filterType;
    private Integer popuFlag;
    private String meNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getPopuFlag() {
        return popuFlag;
    }

    public void setPopuFlag(Integer popuFlag) {
        this.popuFlag = popuFlag;
    }

    public String getMeNumber() {
        return meNumber;
    }

    public void setMeNumber(String meNumber) {
        this.meNumber = meNumber;
    }

    public Criteria toCriteria() {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("name", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(idNo)) {
            criteria.add("idNo", OP.LIKE, idNo);
        }
        if (ObjectUtil.isNotEmpty(filterType)) {
            criteria.add("filter_Type", filterType);
        }
        if (ObjectUtil.isNotEmpty(popuFlag)) {
            criteria.add("popu_Flag", popuFlag);
        }
        if (ObjectUtil.isNotEmpty(meNumber)) {
            criteria.add("me_Number", meNumber);
        }
        return criteria;
    }


}
