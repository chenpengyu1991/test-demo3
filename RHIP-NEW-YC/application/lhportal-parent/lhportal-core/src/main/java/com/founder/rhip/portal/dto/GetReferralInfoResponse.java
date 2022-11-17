package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.founder.rhip.ehr.entity.clinic.ReferralInfo;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetReferralInfoResponse implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	private String rtnCode;
	private String rtnMessage;
	
	@XmlElement(name = "referralInfo")
	private List<ReferralInfo> referralInfos;

	public String getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getRtnMessage() {
		return rtnMessage;
	}

	public void setRtnMessage(String rtnMessage) {
		this.rtnMessage = rtnMessage;
	}

	public List<ReferralInfo> getReferralInfo() {
		return referralInfos;
	}

	public void setReferralInfo(List<ReferralInfo> referralInfo) {
		this.referralInfos = referralInfo;
	}


}
