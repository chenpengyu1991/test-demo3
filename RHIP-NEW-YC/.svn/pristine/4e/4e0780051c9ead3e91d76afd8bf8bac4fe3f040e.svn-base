package com.founder.rhip.hm.controller.form;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.service.export.Item;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author
 * @Description:
 * @Date Created in 14:47 2019/3/20.
 */

public class EchPersonInfoExcel implements Serializable {

    @Item(index=1,column = "姓名")
    private String name;

    @Item(index=2,column ="性别",isDic=true,dicType="GBT226112003")
    private String gender;

    @Item(index=3,column = "年龄(岁)")
    private Integer age;

    @Item(index=4,column ="身份证号")
    private String idcard;

    @Item(index=5,column ="体检机构",isOrganization=true)
    private String inputOrganCode;

    @Item(index=6,column ="体质类型")
    private String tcmConclusion;

    @Item(index=7,column ="是否辨识")
    private String sfbs;

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


    public String getSfbs() {
		return sfbs;
	}

	public void setSfbs(String sfbs) {
		this.sfbs = sfbs;
	}

	public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
