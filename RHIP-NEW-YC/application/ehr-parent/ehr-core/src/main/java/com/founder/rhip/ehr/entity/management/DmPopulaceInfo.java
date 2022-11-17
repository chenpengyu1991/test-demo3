package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "DM_POPULACE")
public class DmPopulaceInfo implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "COUNT_YEAR", columnDefinition = "NUMBER|人口统计年度||", length = 9, nullable = true)
    private Integer countYear;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR|机构代码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR|机构名称||", length = 100, nullable = true)
    private String organName;

    @Column(name = "MAN_NUM", columnDefinition = "NUMBER|男性人口数||", length = 9, nullable = true)
    private Integer manNum;
    
    @Column(name = "TOTAL_NUM", columnDefinition = "NUMBER|人口总数||", length = 9, nullable = true)
    private Integer totalNum;

    @Column(name = "WOMAN_NUM", columnDefinition = "NUMBER|女性人口数||", length = 9, nullable = true)
    private Integer womanNum;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 12, nullable = true)
    private String gBCode;
    
    @Column(name = "ORGAN_PARENT_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 12, nullable = true)
    private String organParentCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCountYear() {
		return countYear;
	}

	public void setCountYear(Integer countYear) {
		this.countYear = countYear;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public Integer getManNum() {
		return manNum;
	}

	public void setManNum(Integer manNum) {
		this.manNum = manNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getWomanNum() {
		return womanNum;
	}

	public void setWomanNum(Integer womanNum) {
		this.womanNum = womanNum;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getgBCode() {
		return gBCode;
	}

	public void setgBCode(String gBCode) {
		this.gBCode = gBCode;
	}

	public String getOrganParentCode() {
		return organParentCode;
	}

	public void setOrganParentCode(String organParentCode) {
		this.organParentCode = organParentCode;
	}

}