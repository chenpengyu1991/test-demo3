package com.founder.rhip.ehr.dto.mhm;

/*
 * 精神卫生-迁入迁出查询Dto
 */

import java.io.Serializable;
import java.util.Date;

public class MhmMoveQueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;   //MHM_MOVE表的ID主键字段
    private String statusId;
    private String eventId;
    private String logoff;
    private String name;
    private String idcard;
    private String gender;
    private String paAddress;
    private String parentsName;
    private String guarderPhone;
    private Date moveInDt;
    private String moveInOrgan;
    private Date moveOutDt;
    private String moveOutOrgan;
    private String flag;
    private String personId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPaAddress() {
        return paAddress;
    }

    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public String getGuarderPhone() {
        return guarderPhone;
    }

    public void setGuarderPhone(String guarderPhone) {
        this.guarderPhone = guarderPhone;
    }

    public Date getMoveInDt() {
        return moveInDt;
    }

    public void setMoveInDt(Date moveInDt) {
        this.moveInDt = moveInDt;
    }

    public String getMoveInOrgan() {
        return moveInOrgan;
    }

    public void setMoveInOrgan(String moveInOrgan) {
        this.moveInOrgan = moveInOrgan;
    }

    public Date getMoveOutDt() {
        return moveOutDt;
    }

    public void setMoveOutDt(Date moveOutDt) {
        this.moveOutDt = moveOutDt;
    }

    public String getMoveOutOrgan() {
        return moveOutOrgan;
    }

    public void setMoveOutOrgan(String moveOutOrgan) {
        this.moveOutOrgan = moveOutOrgan;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}