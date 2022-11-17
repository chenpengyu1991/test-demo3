package com.founder.rhip.ehr.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RP_DISEASES")
public class RpDiseases implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）|100|", length = 100, nullable = true)
	private String rpName;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇code|50|", length = 50, nullable = true)
	private String gbCode;

	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心code|50|", length = 50, nullable = true)
	private String centerCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构code|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型|5|", length = 5, nullable = true)
	private String organType;

	@Column(name = "RP_DATE", columnDefinition = "DATE|统计日期||", nullable = true)
	private Date rpDate;

	@Column(name = "A_NUM", columnDefinition = "NUMBER|A类传染病数|10|", length = 10, nullable = true)
	private Long aNum = 0l;

	@Column(name = "B_NUM", columnDefinition = "NUMBER|B类传染病数|10|", length = 10, nullable = true)
	private Long bNum = 0l;

	@Column(name = "JIA_NUM", columnDefinition = "NUMBER|甲类传染病数|10|", length = 10, nullable = true)
	private Long jiaNum = 0l;

	@Column(name = "YI_NUM", columnDefinition = "NUMBER|乙类传染病数|10|", length = 10, nullable = true)
	private Long yiNum = 0l;

	@Column(name = "BING_NUM", columnDefinition = "NUMBER|丙类传染病数|10|", length = 10, nullable = true)
	private Long bingNum = 0l;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return this.rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return this.organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public Date getRpDate() {
		return this.rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public Long getaNum() {
		return aNum;
	}

	public void setaNum(Long aNum) {
		this.aNum = aNum;
	}

	public Long getbNum() {
		return bNum;
	}

	public void setbNum(Long bNum) {
		this.bNum = bNum;
	}

	public Long getJiaNum() {
		return jiaNum;
	}

	public void setJiaNum(Long jiaNum) {
		this.jiaNum = jiaNum;
	}

	public Long getYiNum() {
		return yiNum;
	}

	public void setYiNum(Long yiNum) {
		this.yiNum = yiNum;
	}

	public Long getBingNum() {
		return bingNum;
	}

	public void setBingNum(Long bingNum) {
		this.bingNum = bingNum;
	}
}