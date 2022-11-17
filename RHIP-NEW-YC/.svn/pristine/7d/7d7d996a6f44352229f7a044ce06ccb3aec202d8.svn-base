package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "DC_INOCULAT_APPOINTMENT_PARAM")
public class InoculationAppointmentParam implements Serializable {

	private static final long serialVersionUID = -5368817521747162533L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "COUNT_YEAR", columnDefinition = "NUMBER|预约数量统计年度||", length = 9, nullable = true)
    private Integer countYear;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR|机构代码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR|机构名称||", length = 100, nullable = true)
    private String organName;

    @Column(name = "COUNT_NUM", columnDefinition = "NUMBER|可预约总数||", length = 9, nullable = true)
    private Integer countNum;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete = 0;

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

	public Integer getCountNum() {
		return countNum;
	}

	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}