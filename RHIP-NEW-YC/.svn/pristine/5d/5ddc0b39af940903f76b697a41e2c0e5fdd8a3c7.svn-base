package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CH_CHILD_DEATH_RECORD")
public class ChildDeathRecord implements Serializable {
	
	@Column(name = "MONTH_RECORD", columnDefinition = "VARCHAR2|时间||", length = 20, nullable = true)
	private String monthRecord;
	
	@Column(name = "SEVEN_NUMBER", columnDefinition = "NUMBER|七岁以下儿童数量||", length = 11, nullable = false)
	private Long sevenAgeNumber;
	
	@Column(name = "FIVE_NUMBER", columnDefinition = "NUMBER|五岁以下儿童数量||", length = 11, nullable = false)
	private Long fiveAgeNumber;
	
	@Column(name = "THREE_NUMBER", columnDefinition = "NUMBER|三岁以下儿童数量||", length = 11, nullable = false)
	private Long threeAgeNumber;
	
	@Column(name = "FIVE_DEATH", columnDefinition = "NUMBER|五岁以下儿童死亡数量||", length = 11, nullable = false)
	private Long fiveAgeDeath;
	
	@Column(name = "BABY_DEATH", columnDefinition = "NUMBER|婴儿死亡数量||", length = 11, nullable = false)
	private Long babyDeathNumber;
	
	@Column(name = "NEWBORN_DEATH", columnDefinition = "NUMBER|新生儿死亡数量||", length = 11, nullable = false)
	private Long newbornDeathNumber;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|机构编码||", length = 20, nullable = false)
	private String gbCode;
	
	//五岁以下儿童死亡率
	private Double underFiveMortality;
	
	//婴儿死亡率
	private Double babyMortality;
	
	//新生儿死亡率
	private Double newbornMortality;

	

	public String getMonthRecord() {
		return monthRecord;
	}

	public void setMonthRecord(String monthRecord) {
		this.monthRecord = monthRecord;
	}

	public Long getSevenAgeNumber() {
		return sevenAgeNumber;
	}

	public void setSevenAgeNumber(Long sevenAgeNumber) {
		this.sevenAgeNumber = sevenAgeNumber;
	}

	public Long getFiveAgeNumber() {
		return fiveAgeNumber;
	}

	public void setFiveAgeNumber(Long fiveAgeNumber) {
		this.fiveAgeNumber = fiveAgeNumber;
	}

	public Long getThreeAgeNumber() {
		return threeAgeNumber;
	}

	public void setThreeAgeNumber(Long threeAgeNumber) {
		this.threeAgeNumber = threeAgeNumber;
	}

	public Long getFiveAgeDeath() {
		return fiveAgeDeath;
	}

	public void setFiveAgeDeath(Long fiveAgeDeath) {
		this.fiveAgeDeath = fiveAgeDeath;
	}

	public Long getBabyDeathNumber() {
		return babyDeathNumber;
	}

	public void setBabyDeathNumber(Long babyDeathNumber) {
		this.babyDeathNumber = babyDeathNumber;
	}

	public Long getNewbornDeathNumber() {
		return newbornDeathNumber;
	}

	public void setNewbornDeathNumber(Long newbornDeathNumber) {
		this.newbornDeathNumber = newbornDeathNumber;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Double getUnderFiveMortality() {
		return underFiveMortality;
	}

	public void setUnderFiveMortality(Double underFiveMortality) {
		this.underFiveMortality = underFiveMortality;
	}

	public Double getBabyMortality() {
		return babyMortality;
	}

	public void setBabyMortality(Double babyMortality) {
		this.babyMortality = babyMortality;
	}

	public Double getNewbornMortality() {
		return newbornMortality;
	}

	public void setNewbornMortality(Double newbornMortality) {
		this.newbornMortality = newbornMortality;
	}

	
}
