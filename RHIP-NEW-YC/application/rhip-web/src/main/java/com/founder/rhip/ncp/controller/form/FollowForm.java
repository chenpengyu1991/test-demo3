package com.founder.rhip.ncp.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpRequest;

import java.util.Date;
import java.util.List;

public class FollowForm {

    private String name;

    private String cardno;

    private String sex;

    private Date dischargeBegin;

    private Date dischargeEnd;

    private String cyts;

    private String groupClassification;//人群分类

    private String lcfx;

    private String jkpj;

    private String fczt;

    private String sflb;

    private Date sfBegin;

    private Date sfEnd;

    private String doctor;

    private String gbcode;

    private String centerOrgCode;

    private String stationOrganCode;

    public Criteria toCriteria() {
        Criteria criteria = new Criteria();
        criteria.add("ncp.is_delete","0");
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("name", name);
        }
        if (StringUtil.isNotEmpty(cardno)) {
            criteria.add("cardno", cardno);
        }
        if (StringUtil.isNotEmpty(sex)) {
            criteria.add("sex", sex);
        }

        if (null != dischargeBegin && null == dischargeEnd) {
            criteria.add("discharge_date", OP.GE, DateUtil.makeTimeToZero(dischargeBegin));
        } else if (null == dischargeBegin && null != dischargeEnd) {
            criteria.add("discharge_date", OP.LE, DateUtil.makeTimeToMax(dischargeEnd));
        }
        if (null != dischargeBegin && null != dischargeEnd) {
            criteria.add("discharge_date", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(dischargeBegin), DateUtil.makeTimeToMax(dischargeEnd) });
        }

        if (StringUtil.isNotEmpty(cyts)) {//出院天数
            criteria.add("cyts", cyts);
        }

        // 人群分类
        if (StringUtils.isNotEmpty(groupClassification)) {
            criteria.add("groupClassification", groupClassification);
        }

        if (StringUtil.isNotEmpty(lcfx)) {
            criteria.add("clinical_class", lcfx);
        }
        if (StringUtil.isNotEmpty(jkpj)) {
            criteria.add("health_status", jkpj);
        }

        if (StringUtil.isNotEmpty(fczt)) {
            criteria.add("REEXAMINE_STATUS", fczt);
        }

        if (StringUtil.isNotEmpty(sflb)) {
            criteria.add("sflb", sflb);
        }
        if (sfBegin!=null) {
            criteria.add("sfBegin", sfBegin);
        }
        if (sfEnd!=null) {
            criteria.add("sfEnd", sfEnd);
        }
        if (StringUtil.isNotEmpty(doctor)) {
            criteria.add("doctor", doctor);
        }



        if (StringUtil.isNotEmpty(stationOrganCode)) {
            criteria.add("stationOrganCode", stationOrganCode);
        }else if(StringUtil.isNotEmpty(centerOrgCode)){
            criteria.add("centerOrgCode", centerOrgCode);
        }else if (StringUtil.isNotEmpty(gbcode)) {
            criteria.add("gbcode", gbcode);
        }
        return criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDischargeBegin() {
        return dischargeBegin;
    }

    public void setDischargeBegin(Date dischargeBegin) {
        this.dischargeBegin = dischargeBegin;
    }

    public Date getDischargeEnd() {
        return dischargeEnd;
    }

    public void setDischargeEnd(Date dischargeEnd) {
        this.dischargeEnd = dischargeEnd;
    }

    public Date getSfBegin() {
        return sfBegin;
    }

    public void setSfBegin(Date sfBegin) {
        this.sfBegin = sfBegin;
    }

    public Date getSfEnd() {
        return sfEnd;
    }

    public void setSfEnd(Date sfEnd) {
        this.sfEnd = sfEnd;
    }

    public String getCyts() {
        return cyts;
    }

    public void setCyts(String cyts) {
        this.cyts = cyts;
    }

    public String getGroupClassification() {
        return groupClassification;
    }

    public void setGroupClassification(String groupClassification) {
        this.groupClassification = groupClassification;
    }

    public String getLcfx() {
        return lcfx;
    }

    public void setLcfx(String lcfx) {
        this.lcfx = lcfx;
    }

    public String getJkpj() {
        return jkpj;
    }

    public void setJkpj(String jkpj) {
        this.jkpj = jkpj;
    }

    public String getFczt() {
        return fczt;
    }

    public void setFczt(String fczt) {
        this.fczt = fczt;
    }

    public String getSflb() {
        return sflb;
    }

    public void setSflb(String sflb) {
        this.sflb = sflb;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode;
    }

    public String getCenterOrgCode() {
        return centerOrgCode;
    }

    public void setCenterOrgCode(String centerOrgCode) {
        this.centerOrgCode = centerOrgCode;
    }

    public String getStationOrganCode() {
        return stationOrganCode;
    }

    public void setStationOrganCode(String stationOrganCode) {
        this.stationOrganCode = stationOrganCode;
    }
}
