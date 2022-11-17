package com.founder.rhip.ehr.dto;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class SysConfigQueryForm {
    private String name;//参数名称
    private String description;//描述
    private String value;//值
    private String valid;//状态

    public Criteria toCriteria() {
        Criteria criteria = new Criteria();

        if (StringUtil.isNotEmpty(name)) {
            criteria.add("NAME", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(description)) {
            criteria.add("DESCRIPTION", OP.LIKE, description);
        }
        if (StringUtil.isNotEmpty(value)) {
            criteria.add("VALUE", OP.LIKE, value);
        }
        if (StringUtil.isNotEmpty(valid)) {
            criteria.add("VALID", OP.EQ, valid);
        }

        return criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
