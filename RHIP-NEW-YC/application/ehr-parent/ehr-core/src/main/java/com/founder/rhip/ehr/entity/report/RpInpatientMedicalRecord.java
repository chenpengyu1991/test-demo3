package com.founder.rhip.ehr.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RP_INPATIENT_MEDICAL_RECORD")
public class RpInpatientMedicalRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码|20|", length = 20, nullable = true)
	private String organCode;

	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

	@Column(name = "FEE_ALL", columnDefinition = "NUMBER|病案首页住院总费用|9|", length = 9, nullable = true)
	private BigDecimal feeAll;

	@Column(name = "PATHOLOGY_FEE", columnDefinition = "NUMBER|病理诊断费|9|", length = 9, nullable = true)
	private BigDecimal pathologyFee;

	@Column(name = "LAB_FEE", columnDefinition = "NUMBER|实验诊断费|9|", length = 9, nullable = true)
	private BigDecimal labFee;

	@Column(name = "IMG_FEE", columnDefinition = "NUMBER|影像诊断费|9|", length = 9, nullable = true)
	private BigDecimal imgFee;

	@Column(name = "CLINICAL_FEE", columnDefinition = "NUMBER|临床诊断项目费|9|", length = 9, nullable = true)
	private BigDecimal clinicalFee;

	@Column(name = "ONE_A", columnDefinition = "NUMBER|切口等级Ⅰ/愈合类型甲人次数|8|", length = 8, nullable = true)
	private Long oneA;

	@Column(name = "ONE_B", columnDefinition = "NUMBER|切口等级Ⅰ/愈合类型乙人次数|8|", length = 8, nullable = true)
	private Long oneB;

	@Column(name = "ONE_C", columnDefinition = "NUMBER|切口等级Ⅰ/愈合类型丙人次数|8|", length = 8, nullable = true)
	private Long oneC;

	@Column(name = "TWO_A", columnDefinition = "NUMBER|切口等级Ⅱ/愈合类型甲人次数|8|", length = 8, nullable = true)
	private Long twoA;

	@Column(name = "TWO_B", columnDefinition = "NUMBER|切口等级Ⅱ/愈合类型乙人次数|8|", length = 8, nullable = true)
	private Long twoB;

	@Column(name = "TWO_C", columnDefinition = "NUMBER|切口等级Ⅱ/愈合类型丙人次数|8|", length = 8, nullable = true)
	private Long twoC;

	@Column(name = "THREE_A", columnDefinition = "NUMBER|切口等级Ⅲ/愈合类型甲人次数|8|", length = 8, nullable = true)
	private Long threeA;

	@Column(name = "THREE_B", columnDefinition = "NUMBER|切口等级Ⅲ/愈合类型乙人次数|8|", length = 8, nullable = true)
	private Long threeB;

	@Column(name = "THREE_C", columnDefinition = "NUMBER|切口等级Ⅲ/愈合类型丙人次数|8|", length = 8, nullable = true)
	private Long threeC;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public BigDecimal getFeeAll() {
		return feeAll;
	}

	public void setFeeAll(BigDecimal feeAll) {
		this.feeAll = feeAll;
	}

	public BigDecimal getPathologyFee() {
		return pathologyFee;
	}

	public void setPathologyFee(BigDecimal pathologyFee) {
		this.pathologyFee = pathologyFee;
	}

	public BigDecimal getLabFee() {
		return labFee;
	}

	public void setLabFee(BigDecimal labFee) {
		this.labFee = labFee;
	}

	public BigDecimal getImgFee() {
		return imgFee;
	}

	public void setImgFee(BigDecimal imgFee) {
		this.imgFee = imgFee;
	}

	public BigDecimal getClinicalFee() {
		return clinicalFee;
	}

	public void setClinicalFee(BigDecimal clinicalFee) {
		this.clinicalFee = clinicalFee;
	}

	public Long getOneA() {
		return oneA;
	}

	public void setOneA(Long oneA) {
		this.oneA = oneA;
	}

	public Long getOneB() {
		return oneB;
	}

	public void setOneB(Long oneB) {
		this.oneB = oneB;
	}

	public Long getOneC() {
		return oneC;
	}

	public void setOneC(Long oneC) {
		this.oneC = oneC;
	}

	public Long getTwoA() {
		return twoA;
	}

	public void setTwoA(Long twoA) {
		this.twoA = twoA;
	}

	public Long getTwoB() {
		return twoB;
	}

	public void setTwoB(Long twoB) {
		this.twoB = twoB;
	}

	public Long getTwoC() {
		return twoC;
	}

	public void setTwoC(Long twoC) {
		this.twoC = twoC;
	}

	public Long getThreeA() {
		return threeA;
	}

	public void setThreeA(Long threeA) {
		this.threeA = threeA;
	}

	public Long getThreeB() {
		return threeB;
	}

	public void setThreeB(Long threeB) {
		this.threeB = threeB;
	}

	public Long getThreeC() {
		return threeC;
	}

	public void setThreeC(Long threeC) {
		this.threeC = threeC;
	}
}