package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 随访信息
 * 
 * @author liuk
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class VaccineStatisticsDTO implements Serializable {
	private static final long serialVersionUID = 8418853226662140639L;
	/**
	 * 病类型
	 */
	private String diseaseType;

	/**
	 * 随访次数
	 */
	private Integer followupTimes;

	/**
	 * 下次随访时间
	 */
	private Date nextFollowupDate;

	/**
	 * 随访时间
	 */
	private Date followupDate;

	/**
	 * 疾病代码 icd_code
	 */
	private String icdCode;

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public Integer getFollowupTimes() {
		return followupTimes;
	}

	public void setFollowupTimes(Integer followupTimes) {
		this.followupTimes = followupTimes;
	}

	public Date getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

}
