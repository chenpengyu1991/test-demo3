/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.mhm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmMoveStatus;
import com.founder.rhip.mhm.common.MhmStatus;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 精神病人查询表单
 * 
 * @version 1.0, 2013-9-03
 * @author Yang Liu
 */
public class MhmMoveQueryForm {

    private String name;
    private String idcard;
    private String gender;
    //迁移状态
    private String transferStatus;
    //迁出时间
    private String transferOutBeginDt;
    private String transferOutEndDt;
    //迁入时间
    private String transferInBeginDt;
    private String transferInEndDt;
    //迁出站
    private String moveOutOrgan;
    //迁入站
    private String moveInOrgan;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferOutBeginDt() {
        return transferOutBeginDt;
    }

    public void setTransferOutBeginDt(String transferOutBeginDt) {
        this.transferOutBeginDt = transferOutBeginDt;
    }

    public String getTransferOutEndDt() {
        return transferOutEndDt;
    }

    public void setTransferOutEndDt(String transferOutEndDt) {
        this.transferOutEndDt = transferOutEndDt;
    }

    public String getTransferInBeginDt() {
        return transferInBeginDt;
    }

    public void setTransferInBeginDt(String transferInBeginDt) {
        this.transferInBeginDt = transferInBeginDt;
    }

    public String getTransferInEndDt() {
        return transferInEndDt;
    }

    public void setTransferInEndDt(String transferInEndDt) {
        this.transferInEndDt = transferInEndDt;
    }

    public String getMoveOutOrgan() {
        return moveOutOrgan;
    }

    public void setMoveOutOrgan(String moveOutOrgan) {
        this.moveOutOrgan = moveOutOrgan;
    }

    public String getMoveInOrgan() {
        return moveInOrgan;
    }

    public void setMoveInOrgan(String moveInOrgan) {
        this.moveInOrgan = moveInOrgan;
    }

    public Criteria getMoveCriteria(){
        Criteria criteria = new Criteria();
		/*姓名*/
        if (StringUtils.isNotBlank(name)){
            criteria.add("NAME", OP.LIKE, name);
        }
		/*身份证号码*/
        if (StringUtils.isNotBlank(idcard)){
            criteria.add("IDCARD", OP.LIKE, idcard.toUpperCase());
        }
        /*性别*/
        if (StringUtils.isNotBlank(gender)){
            criteria.add("GENDER", OP.LIKE, gender);
        }
        /*迁出时间*/
        Date transferOutBeginDt = DateUtil.parseSimpleDate(this.transferOutBeginDt, null);
        Date transferOutEndDt = DateUtil.parseSimpleDate(this.transferOutEndDt, null);
        DateUtil.getCriteriaByDateRange(criteria, "MOVE_OUT_DT", transferOutBeginDt,transferOutEndDt);
        /*迁入时间*/
        Date transferInBeginDt = DateUtil.parseSimpleDate(this.transferInBeginDt, null);
        Date transferInEndDt = DateUtil.parseSimpleDate(this.transferInEndDt, null);
        DateUtil.getCriteriaByDateRange(criteria, "MOVE_IN_DT", transferInBeginDt,transferInEndDt);
        /*迁移状态*/
        if (StringUtils.isNotEmpty(transferStatus)){
            criteria.add("FLAG", OP.EQ, transferStatus);
        }
        /*迁出站*/
        if (StringUtils.isNotEmpty(moveOutOrgan)){
            criteria.add("MOVE_OUT_ORGAN", OP.EQ, moveOutOrgan);
        }
        /*迁入站*/
        if (StringUtils.isNotEmpty(moveInOrgan)){
            criteria.add("MOVE_IN_ORGAN", OP.EQ, moveInOrgan);
        }
        return criteria;
    }
}
