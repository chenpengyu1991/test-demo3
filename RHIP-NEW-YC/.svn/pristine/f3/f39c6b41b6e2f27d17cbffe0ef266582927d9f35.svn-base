package com.founder.rhip.mhm.dto;


import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;

public class MhmMoveDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*状态表ID*/
    private Long statusId;
    /*事件表ID*/
    private Long eventId;
    /*当前操作者*/
    private User currentUser;
    /*当前操作者所在机构*/
    private  Organization currentOrg;
    /*患者PIXID*/
    private String pixId;
    /*迁入迁出状态：1迁出，2迁入，3退回*/
    private String moveStatus;
    /*基本信息*/
    private MhmBasicsInfo mhmBasicsInfo;
    /*其他表*/
    private MhmOtherInfo mhmOtherInfo;

    private MhmMove move;//当前迁移内容

    PageList<MhmMove> moveList;//迁移列表

    @Transient
    private PersonInfo personInfo;

    public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getMhmBasicsInfo());
            personInfo.setHouseholdType(this.getMhmBasicsInfo().getFloatPopulation());
        }
        return personInfo;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Organization getCurrentOrg() {
        return currentOrg;
    }

    public void setCurrentOrg(Organization currentOrg) {
        this.currentOrg = currentOrg;
    }

    public String getMoveStatus() {
        return moveStatus;
    }

    public void setMoveStatus(String moveStatus) {
        this.moveStatus = moveStatus;
    }

    public MhmBasicsInfo getMhmBasicsInfo() {
        return mhmBasicsInfo;
    }

    public void setMhmBasicsInfo(MhmBasicsInfo mhmBasicsInfo) {
        this.mhmBasicsInfo = mhmBasicsInfo;
    }

    public MhmOtherInfo getMhmOtherInfo() {
        return mhmOtherInfo;
    }

    public void setMhmOtherInfo(MhmOtherInfo mhmOtherInfo) {
        this.mhmOtherInfo = mhmOtherInfo;
    }

    public String getPixId() {
        return pixId;
    }

    public void setPixId(String pixId) {
        this.pixId = pixId;
    }

    public MhmMove getMove() {
        return move;
    }

    public void setMove(MhmMove move) {
        this.move = move;
    }

    public PageList<MhmMove> getMoveList() {
        return moveList;
    }

    public void setMoveList(PageList<MhmMove> moveList) {
        this.moveList = moveList;
    }

}