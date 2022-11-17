package com.founder.rhip.ihm.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;


/**
 * 居民健康卡
 */
public class HealthCardTargetForm {
	
	private String name;
	private String paperNo;
	private String birthday;
	private String deathDate;
    private String citizenCardNo;
    private String cardStatus;

	private String personType;
	private String cancelStatus;

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPaperNo() {
		return paperNo;
	}
	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

    public String getCitizenCardNo() {
        return citizenCardNo;
    }

    public void setCitizenCardNo(String citizenCardNo) {
        this.citizenCardNo = citizenCardNo;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Criteria getCriteria(){
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(name)){
			criteria.add("name",OP.LIKE,name);
		}
		if(StringUtil.isNotEmpty(paperNo)){
			criteria.add("paperNo",paperNo);
		}
		if(StringUtil.isNotEmpty(birthday)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date = null;
			try {
				date = sdf.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			criteria.add("birthday",date);
		}
        if(StringUtil.isNotEmpty(citizenCardNo)){
            criteria.add("citizenCardNo",citizenCardNo);
        }
        if(StringUtil.isNotEmpty(cardStatus)){
            criteria.add("cardStatus",cardStatus);
        }
		return criteria;
	}
	
	public Criteria getLifeEventCriteria(){
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(personType)){
			criteria.add("personType",personType);
		}
		if(StringUtil.isNotEmpty(cancelStatus)){
			criteria.add("cancelStatus",cancelStatus);
		}
		if(StringUtil.isNotEmpty(name)){
			criteria.add("name",OP.LIKE,name);
		}
		if(StringUtil.isNotEmpty(paperNo)){
			criteria.add("idcard",paperNo);
		}
		if(StringUtil.isNotEmpty(deathDate)){
			try {
				Date beginDate = DateUtil.parseSimpleDate(deathDate+" 00:00:00","yyyy/MM/dd HH:mm:ss");
				Date endDate = DateUtil.parseSimpleDate(deathDate+" 23:59:59","yyyy/MM/dd HH:mm:ss");
				DateUtil.getCriteriaByDateRange(criteria, "deathDate", beginDate, endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return criteria;
	}
}
