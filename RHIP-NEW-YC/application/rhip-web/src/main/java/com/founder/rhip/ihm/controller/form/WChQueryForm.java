package com.founder.rhip.ihm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cary on 4/30/2014.
 */
public class WChQueryForm {

    private String name;

    private String gender;

    private String idCard;

    private String birthday;

    private String birthdayEnd;
    
    private String createDate;

    private String paTownShip;

    private String organCode;

    private Date estimatedDueDateStart;//预产期

    private Date estimatedDueDateEnd;//预产期

    private String birthCertificateNo; //出生证条形码

    private String bcStatus; //作废状态
    
    private String genreCode;

    private Date visitDateStart;

    private Date visitDateEnd;

    private String estimatedDueDate;

    private String checkDateStart;

    private String checkDateEnd;

    private String selectCodeType;

    private String createDateStart;

    private String createDateEnd;

    private String updateDate;
    
    private String updateDateEnd;

    private String healthGuideStatus;
    
    private String startAge;
    
    private String endAge;
    
    private String townCode;

	private String centerCode;

	private String stationCode;

	private String babyCardNo;

    private String checkDate;

    private String samplingOrganName;

    private String motherName;

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getSamplingOrganName() {
        return samplingOrganName;
    }

    public void setSamplingOrganName(String samplingOrganName) {
        this.samplingOrganName = samplingOrganName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getBabyCardNo() {
        return babyCardNo;
    }

    public void setBabyCardNo(String babyCardNo) {
        this.babyCardNo = babyCardNo;
    }

    public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateDateEnd() {
		return updateDateEnd;
	}

	public void setUpdateDateEnd(String updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	public String getBirthdayEnd() {
		return birthdayEnd;
	}

	public void setBirthdayEnd(String birthdayEnd) {
		this.birthdayEnd = birthdayEnd;
	}
    
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPaTownShip() {
        return paTownShip;
    }

    public void setPaTownShip(String paTownShip) {
        this.paTownShip = paTownShip;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getEstimatedDueDateStart() {
        return estimatedDueDateStart;
    }

    public void setEstimatedDueDateStart(Date estimatedDueDateStart) {
        this.estimatedDueDateStart = estimatedDueDateStart;
    }

    public Date getEstimatedDueDateEnd() {
        return estimatedDueDateEnd;
    }

    public void setEstimatedDueDateEnd(Date estimatedDueDateEnd) {
        this.estimatedDueDateEnd = estimatedDueDateEnd;
    }

    public Date getVisitDateStart() {
        return visitDateStart;
    }

    public void setVisitDateStart(Date visitDateStart) {
        this.visitDateStart = visitDateStart;
    }

    public Date getVisitDateEnd() {
        return visitDateEnd;
    }

    public void setVisitDateEnd(Date visitDateEnd) {
        this.visitDateEnd = visitDateEnd;
    }

    public String getBirthCertificateNo() {
        return birthCertificateNo;
    }

    public void setBirthCertificateNo(String birthCertificateNo) {
        this.birthCertificateNo = birthCertificateNo;
    }

    public String getBcStatus() {
        return bcStatus;
    }

    public void setBcStatus(String bcStatus) {
        this.bcStatus = bcStatus;
    }

    public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

    public String getEstimatedDueDate() {
        return estimatedDueDate;
    }

    public void setEstimatedDueDate(String estimatedDueDate) {
        this.estimatedDueDate = estimatedDueDate;
    }

    public String getCheckDateStart() {
        return checkDateStart;
    }

    public void setCheckDateStart(String checkDateStart) {
        this.checkDateStart = checkDateStart;
    }

    public String getCheckDateEnd() {
        return checkDateEnd;
    }

    public void setCheckDateEnd(String checkDateEnd) {
        this.checkDateEnd = checkDateEnd;
    }

    public String getSelectCodeType() {
        return selectCodeType;
    }

    public void setSelectCodeType(String selectCodeType) {
        this.selectCodeType = selectCodeType;
    }

    public String getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(String createDateStart) {
        this.createDateStart = createDateStart;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    
    public String getHealthGuideStatus() {
		return healthGuideStatus;
	}

	public void setHealthGuideStatus(String healthGuideStatus) {
		this.healthGuideStatus = healthGuideStatus;
	}

	public String getStartAge() {
		return startAge;
	}

	public void setStartAge(String startAge) {
		this.startAge = startAge;
	}

	public String getEndAge() {
		return endAge;
	}

	public void setEndAge(String endAge) {
		this.endAge = endAge;
	}

	
	public String getTownCode() {
		return townCode;
	}

	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public Map getParamMap(){
        Map<String, String> paramMap = new HashMap<>();
        if(StringUtil.isNotEmpty(name)){
            paramMap.put("name", name);
        }
        if(StringUtil.isNotEmpty(gender)){
            paramMap.put("gender", gender);
        }
        if(StringUtil.isNotEmpty(idCard)){
            paramMap.put("idCard", idCard);
        }
        if(StringUtil.isNotEmpty(birthday)){
            paramMap.put("birthday", birthday);
        }
        if(StringUtil.isNotEmpty(birthdayEnd)){
            paramMap.put("birthdayEnd", birthdayEnd);
        }
        if(StringUtil.isNotEmpty(paTownShip)){
            paramMap.put("paTownShip", paTownShip);
        }
        if(StringUtil.isNotEmpty(organCode)){
            paramMap.put("organCode", organCode);
        }
        if(StringUtil.isNotEmpty(createDate)){
            paramMap.put("createDate", createDate);
        }
        if(StringUtil.isNotEmpty(createDateEnd)){
            paramMap.put("createDateEnd", createDateEnd);
        }if(StringUtil.isNotEmpty(updateDate)){
            paramMap.put("updateDate", updateDate);
        }
        if(StringUtil.isNotEmpty(updateDateEnd)){
            paramMap.put("updateDateEnd", updateDateEnd);
        }
        if(StringUtil.isNotEmpty(estimatedDueDate)){
            paramMap.put("estimatedDueDate", estimatedDueDate);
        }
        if(StringUtil.isNotEmpty(birthCertificateNo)){
            paramMap.put("birthCertificateNo", birthCertificateNo);
        }
        if(StringUtil.isNotEmpty(bcStatus)){
            paramMap.put("bcStatus", bcStatus);
        }
        if(StringUtil.isNotEmpty(genreCode)){
            paramMap.put("genreCode", genreCode);
        }

        if(StringUtil.isNotEmpty(checkDateStart)){
            paramMap.put("checkDateStart", checkDateStart);
        }

        if(StringUtil.isNotEmpty(checkDateEnd)){
            paramMap.put("checkDateEnd", checkDateEnd);
        }

        if(StringUtil.isNotEmpty(createDateStart)){
            paramMap.put("createDateStart",createDateStart);
        }
        if(StringUtil.isNotEmpty(healthGuideStatus)){
            paramMap.put("healthGuideStatus",healthGuideStatus);
        }
        if(StringUtil.isNotEmpty(startAge)){
            paramMap.put("startAge",startAge);
        }
        if(StringUtil.isNotEmpty(endAge)){
            paramMap.put("endAge",endAge);
        }
        if(StringUtil.isNotEmpty(stationCode)){
            paramMap.put("stationCode",stationCode);
        }
        if(StringUtil.isNotEmpty(centerCode)){
            paramMap.put("centerCode",centerCode);
        }
        if(StringUtil.isNotEmpty(townCode)){
            paramMap.put("townCode",townCode);
        } 
        if(StringUtil.isNotEmpty(selectCodeType)){
            paramMap.put("selectCodeType",selectCodeType);
        }
        if(StringUtil.isNotEmpty(checkDate)){
            paramMap.put("checkDate", checkDate);
        }
        if(StringUtil.isNotEmpty(samplingOrganName)){
            paramMap.put("samplingOrganName", samplingOrganName);
        }
        if(StringUtil.isNotEmpty(motherName)){
            paramMap.put("motherName", motherName);
        }
        return paramMap;
    }

    public Criteria getCriteria(){
        Criteria cri = new Criteria();
        if(StringUtil.isNotEmpty(name)){
            cri.add("neonatusName", name);
        }
        if(StringUtil.isNotEmpty(gender)){
            cri.add("neonatalGender", gender);
        }
        if(StringUtil.isNotEmpty(birthday)){
            cri.add("neonatusBirthday",OP.BETWEEN, new Object[]{DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd")),DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd"))});
        }

        if(StringUtil.isNotEmpty(organCode)){
            cri.add("createOrganCode", organCode);
        }
        if(StringUtil.isNotEmpty(createDate)){
            cri.add("visitDate",OP.BETWEEN, new Object[]{DateUtil.makeTimeToZero(DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd")),DateUtil.makeTimeToMax(DateUtil.parseSimpleDate(createDate, "yyyy/MM/dd"))});
        }
        return cri;
    }
}
