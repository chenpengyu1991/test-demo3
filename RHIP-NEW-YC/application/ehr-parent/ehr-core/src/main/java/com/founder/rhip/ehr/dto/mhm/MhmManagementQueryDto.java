package com.founder.rhip.ehr.dto.mhm;

/*
 * 精神卫生-规范管理查询Dto
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class MhmManagementQueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String statusId;
    private String eventId;
    private String name;
    private String idcard;
    private String gender;
    private String age;
    private String managementTown;
    private String diagnosisContent;
    private Date fillDate;//登记日期
    private String logoff;
    private String freeFlag;//是否免费服药
	private String pixId;//患者唯一编码
    private String bringIntoMode;//管理方式（1基础管理；2个案管理）
    private String followupStatus;//审核状态(0未审核；1通过；2未通过)
	
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getManagementTown() {
        return managementTown;
    }

    public void setManagementTown(String managementTown) {
        this.managementTown = managementTown;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }

	public String getFreeFlag() {
		return freeFlag;
	}

	public void setFreeFlag(String freeFlag) {
		this.freeFlag = freeFlag;
	}

	public String getDiagnosisContent() {
		return diagnosisContent;
	}

	public void setDiagnosisContent(String diagnosisContent) {
		this.diagnosisContent = diagnosisContent;
	}

	public String getPixId() {
		return pixId;
	}

	public void setPixId(String pixId) {
		this.pixId = pixId;
	}

    public String getBringIntoMode() {
        return bringIntoMode;
    }

    public void setBringIntoMode(String bringIntoMode) {
        this.bringIntoMode = bringIntoMode;
    }

	public String getFollowupStatus() {
		return followupStatus;
	}

	public void setFollowupStatus(String followupStatus) {
		this.followupStatus = followupStatus;
	}
}