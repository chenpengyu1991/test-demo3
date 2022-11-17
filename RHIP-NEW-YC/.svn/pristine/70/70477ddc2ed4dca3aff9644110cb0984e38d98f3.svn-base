package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_REFERRAL_RECORD")
public class MhmReferralRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "REFERRAL_DT", columnDefinition = "DATE|转诊时间||", nullable = true)
	private Date referralDt;

	@Column(name = "REFERRAL_OUT_ORGAN", columnDefinition = "VARCHAR2|转出机构|100|", length = 100, nullable = true)
	private String referralOutOrgan;

	@Column(name = "REFERRAL_OUT_USER", columnDefinition = "VARCHAR2|转出医生|50|", length = 50, nullable = true)
	private String referralOutUser;

	@Column(name = "REFERRAL_IN_OGRAN", columnDefinition = "VARCHAR2|转入机构|100|", length = 100, nullable = true)
	private String referralInOgran;

	@Column(name = "REFERRAL_IN_USER", columnDefinition = "VARCHAR2|转入医生|50|", length = 50, nullable = true)
	private String referralInUser;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Date getReferralDt() {
		return this.referralDt;
	}

	public void setReferralDt(Date referralDt) {
		this.referralDt = referralDt;
	}

	public String getReferralOutOrgan() {
		return this.referralOutOrgan;
	}

	public void setReferralOutOrgan(String referralOutOrgan) {
		this.referralOutOrgan = referralOutOrgan;
	}

	public String getReferralOutUser() {
		return this.referralOutUser;
	}

	public void setReferralOutUser(String referralOutUser) {
		this.referralOutUser = referralOutUser;
	}

	public String getReferralInOgran() {
		return this.referralInOgran;
	}

	public void setReferralInOgran(String referralInOgran) {
		this.referralInOgran = referralInOgran;
	}

	public String getReferralInUser() {
		return this.referralInUser;
	}

	public void setReferralInUser(String referralInUser) {
		this.referralInUser = referralInUser;
	}

}