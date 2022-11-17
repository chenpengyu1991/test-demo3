package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_CHILD")
public class RpChild implements Serializable {


	private static final long serialVersionUID = 7051866139833660866L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）||", length = 100, nullable = true)
	private String rpName;
	
	@Column(name = "PA_CITY", columnDefinition = "VARCHAR2|现住址（市）||", length = 50, nullable = true)
	private String paCity;
	
	@Column(name = "PA_COUNTY", columnDefinition = "VARCHAR2|现住址（镇）||", length = 50, nullable = true)
	private String paCounty;
	
	@Column(name = "PA_TOWN_SHIP", columnDefinition = "VARCHAR2|现住址（居委会）||", length = 50, nullable = true)
	private String paTownShip;
		
	@Column(name = "RP_DATE", columnDefinition = "VARCHAR2|统计日期||", nullable = true)
	private Date rpDate;
	
	@Column(name = "RP_TYPE", columnDefinition = "VARCHAR2|统计方式||", nullable = true)
	private String rpType;

	@Column(name = "ZERO_NUM", columnDefinition = "NUMBER|0-1岁||", length = 10, nullable = true)
	private Long zeroNum;
	
	@Column(name = "ONE_NUM", columnDefinition = "NUMBER|1-2岁||", length = 10, nullable = true)
	private Long oneNum;
	
	@Column(name = "TWO_NUM", columnDefinition = "NUMBER|2-3岁||", length = 10, nullable = true)
	private Long twoNum;
	
	@Column(name = "THREE_NUM", columnDefinition = "NUMBER|3-4岁||", length = 10, nullable = true)
	private Long threeNum;
	
	@Column(name = "FOUR_NUM", columnDefinition = "NUMBER|4-5岁||", length = 10, nullable = true)
	private Long fourNum;
	
	@Column(name = "FIVE_NUM", columnDefinition = "NUMBER|5-6岁||", length = 10, nullable = true)
	private Long fiveNum;
	
	@Column(name = "SIX_NUM", columnDefinition = "NUMBER|6-7岁||", length = 10, nullable = true)
	private Long sixNum;
	
	@Column(name = "TOTAL_NUM", columnDefinition = "NUMBER|0-7岁儿童总数||", length = 10, nullable = true)
	private Long totalNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public Date getRpDate() {
		return rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public String getRpType() {
		return rpType;
	}

	public void setRpType(String rpType) {
		this.rpType = rpType;
	}

	public Long getZeroNum() {
		return zeroNum;
	}

	public void setZeroNum(Long zeroNum) {
		this.zeroNum = zeroNum;
	}

	public Long getOneNum() {
		return oneNum;
	}

	public void setOneNum(Long oneNum) {
		this.oneNum = oneNum;
	}

	public Long getTwoNum() {
		return twoNum;
	}

	public void setTwoNum(Long twoNum) {
		this.twoNum = twoNum;
	}

	public Long getThreeNum() {
		return threeNum;
	}

	public void setThreeNum(Long threeNum) {
		this.threeNum = threeNum;
	}

	public Long getFourNum() {
		return fourNum;
	}

	public void setFourNum(Long fourNum) {
		this.fourNum = fourNum;
	}

	public Long getFiveNum() {
		return fiveNum;
	}

	public void setFiveNum(Long fiveNum) {
		this.fiveNum = fiveNum;
	}

	public Long getSixNum() {
		return sixNum;
	}

	public void setSixNum(Long sixNum) {
		this.sixNum = sixNum;
	}

	public Long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	public String getPaCity() {
		return paCity;
	}

	public void setPaCity(String paCity) {
		this.paCity = paCity;
	}

	public String getPaCounty() {
		return paCounty;
	}

	public void setPaCounty(String paCounty) {
		this.paCounty = paCounty;
	}

	public String getPaTownShip() {
		return paTownShip;
	}

	public void setPaTownShip(String paTownShip) {
		this.paTownShip = paTownShip;
	}
	
	

}
