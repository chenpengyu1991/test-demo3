package com.founder.rhip.ihm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;


/**
 * 居民健康卡
 */
public class DeathMedicineCertificateForm {
	
	private String name;
	private String idCard;
	private String deathDate;
	private String deathDateStart;
	private String deathDateEnd;
	private String organCode;
    private String citizenCardNo;
    private String cancelStatus;

	public String getCitizenCardNo() {
		return citizenCardNo;
	}
	public void setCitizenCardNo(String citizenCardNo) {
		this.citizenCardNo = citizenCardNo;
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathDateStart() {
		return deathDateStart;
	}
	public void setDeathDateStart(String deathDateStart) {
		this.deathDateStart = deathDateStart;
	}
	public String getDeathDateEnd() {
		return deathDateEnd;
	}
	public void setDeathDateEnd(String deathDateEnd) {
		this.deathDateEnd = deathDateEnd;
	}
	public Criteria getCriteria(){
		Criteria criteria = new Criteria("isDelete", OP.NE, "1");
		if(StringUtil.isNotEmpty(name)){
			criteria.add("name", OP.LIKE,name);
		}
		if(StringUtil.isNotEmpty(idCard)){
			criteria.add("idCard",idCard);
		}
		if(StringUtil.isNotEmpty(deathDateStart) || StringUtil.isNotEmpty(deathDateEnd)){
			try {
				Date beginDate = null;
				Date endDate = null;
				if(ObjectUtil.isNotEmpty(deathDateStart) && StringUtil.isEmpty(deathDateEnd)) { // 开始日期不为空，结束日期为空
					beginDate = DateUtil.parseSimpleDate(deathDateStart+" 00:00:00","yyyy/MM/dd HH:mm:ss");
					endDate = DateUtil.parseSimpleDate(deathDateStart+" 23:59:59","yyyy/MM/dd HH:mm:ss");
				}
				if(StringUtil.isEmpty(deathDateStart) && ObjectUtil.isNotEmpty(deathDateEnd)) { //开始为空,结束日期不为空
					beginDate = DateUtil.parseSimpleDate(deathDateEnd+" 00:00:00","yyyy/MM/dd HH:mm:ss");
					endDate = DateUtil.parseSimpleDate(deathDateEnd+" 23:59:59","yyyy/MM/dd HH:mm:ss");
				}
				if(ObjectUtil.isNotEmpty(deathDateStart) && ObjectUtil.isNotEmpty(deathDateEnd)) { // 两个都不为空
					beginDate = DateUtil.parseSimpleDate(deathDateStart+" 00:00:00","yyyy/MM/dd HH:mm:ss");
					endDate = DateUtil.parseSimpleDate(deathDateEnd+" 23:59:59","yyyy/MM/dd HH:mm:ss");
				}
				DateUtil.getCriteriaByDateRange(criteria, "deathDate", beginDate, endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(StringUtil.isNotEmpty(deathDate)){
			criteria.add("deathDate", DateUtil.parseDateString(deathDate));
			
		}
		if(StringUtil.isNotEmpty(cancelStatus)){
			criteria.add("cancelStatus",cancelStatus);
		}
		return criteria;
	}
	
	public String getOrganCode() {
		return organCode;
	}
	
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	
}
