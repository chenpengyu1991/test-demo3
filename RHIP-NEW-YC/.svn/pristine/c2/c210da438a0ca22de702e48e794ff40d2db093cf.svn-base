package com.founder.rhip.ehr.entity.ep;

import com.founder.rhip.ehr.common.EHRConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EP_SALT_TEST_RECORD")
public class SaltTestRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "MONITOR_ID", columnDefinition = "NUMBER|监测记录ID||", length = 11, nullable = true)
	private Long monitorId;

	@Column(name = "SALT_SAMPLING_NUMBER", columnDefinition = "VAR2|盐样编号||", length = 50 , nullable = true)
	private String saltSamplingNumber;

	@Column(name = "SALT_TYPE", columnDefinition = "VAR2|食盐种类||", length = 50 , nullable = true)
	private String saltType;

	@Column(name = "SALT_PRICE", columnDefinition = "NUMBER|食盐价格||", scale = 5, precision = 2, nullable = true)
	private Double saltPrice;

	@Column(name = "SALT_BRAND", columnDefinition = "VAR2|食盐品牌||", length = 50 , nullable = true)
	private String saltBrand;

	@Column(name = "SALT_BRAND_NAME", columnDefinition = "VAR2|食盐品牌名称||", length = 50 , nullable = true)
	private String saltBrandName;

	@Column(name = "SALT_SOURCE", columnDefinition = "VAR2|食盐来源||", length = 20 , nullable = true)
	private String saltSource;

	@Column(name = "SALT_PACKING_TYPE", columnDefinition = "VAR2|食盐包装种类||", length = 20 , nullable = true)
	private String saltPackingType;

	@Column(name = "SALT_PACKING_SIZE", columnDefinition = "VAR2|食盐包装规格||", length = 20 , nullable = true)
	private String saltPackingSize;

	@Column(name = "SPECIAL_SALT_STATUS", columnDefinition = "VAR2|是否海藻碘盐或强化盐||", length = 1 , nullable = true)
	private String specialSaltStatus;

	@Column(name = "MANUFACTURE_DATE", columnDefinition = "DATE|生产日期||", nullable = true)
	private Date manufactureDate;

	@Column(name = "BEST_BEFORE_DATE", columnDefinition = "NUMBER|保质期||", length = 10, nullable = true)
	private Integer bestBeforeDate;

	@Column(name = "SALT_IODINE_CONTENT", columnDefinition = "NUMBER|盐碘含量||", scale = 4, precision = 10, nullable = true)
	private BigDecimal saltIodineContent;

	@Column(name = "TEST_RESULT", columnDefinition = "VAR2|监测结果||", length = 50 , nullable = true)
	private String testResult;

	@Column(name = "TEST_REMARK", columnDefinition = "VAR2|监测结果备注||", length = 100 , nullable = true)
	private String testRemark;

	@Column(name = "LABORATORY", columnDefinition = "VAR2|实验室||", length = 50 , nullable = true)
	private String laboratory;

	@Column(name = "MONITOR_METHOD", columnDefinition = "VAR2|监测方法||", length = 50 , nullable = true)
	private String monitorMethod;

	@Column(name = "PROVINCE_IODINE_STANDARD", columnDefinition = "VAR2|该省碘盐含量标准||", length = 100, nullable = true)
	private String provinceIodineStandard;

	@Column(name = "MONITOR_NUMBER", columnDefinition = "VAR2|实验室监测编号||", length = 50 , nullable = true)
	private String monitorNumber;

	@Column(name = "DETERMINED_RESULT", columnDefinition = "NUMBER|测定结果||", scale = 4, precision = 10, nullable = true)
	private BigDecimal determinedResult;

	@Column(name = "LAB_CHECK_REMARK", columnDefinition = "VAR2|实验室检测备注||", length = 200 , nullable = true)
	private String labCheckRemark;

	@Column(name = "DELETE_FLAG", columnDefinition = "VAR2|删除标识||", length = 1 , nullable = true)
	private Integer deleteFlag = EHRConstants.DELETE_FLG_0;

	public Long getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public String getSaltSamplingNumber() {
		return this.saltSamplingNumber;
	}

	public void setSaltSamplingNumber(String saltSamplingNumber) {
		this.saltSamplingNumber = saltSamplingNumber;
	}

	public String getSaltType() {
		return this.saltType;
	}

	public void setSaltType(String saltType) {
		this.saltType = saltType;
	}

	public Double getSaltPrice() {
		return this.saltPrice;
	}

	public void setSaltPrice(Double saltPrice) {
		this.saltPrice = saltPrice;
	}

	public String getSaltBrand() {
		return this.saltBrand;
	}

	public void setSaltBrand(String saltBrand) {
		this.saltBrand = saltBrand;
	}

	public String getSaltBrandName() {
		return this.saltBrandName;
	}

	public void setSaltBrandName(String saltBrandName) {
		this.saltBrandName = saltBrandName;
	}

	public String getSaltSource() {
		return this.saltSource;
	}

	public void setSaltSource(String saltSource) {
		this.saltSource = saltSource;
	}

	public String getSaltPackingType() {
		return this.saltPackingType;
	}

	public void setSaltPackingType(String saltPackingType) {
		this.saltPackingType = saltPackingType;
	}

	public String getSaltPackingSize() {
		return this.saltPackingSize;
	}

	public void setSaltPackingSize(String saltPackingSize) {
		this.saltPackingSize = saltPackingSize;
	}

	public String getSpecialSaltStatus() {
		return this.specialSaltStatus;
	}

	public void setSpecialSaltStatus(String specialSaltStatus) {
		this.specialSaltStatus = specialSaltStatus;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Integer getBestBeforeDate() {
		return bestBeforeDate;
	}

	public void setBestBeforeDate(Integer bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}

    public BigDecimal getSaltIodineContent() {
        return saltIodineContent;
    }

    public void setSaltIodineContent(BigDecimal saltIodineContent) {
        this.saltIodineContent = saltIodineContent;
    }

    public String getTestResult() {
		return this.testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getTestRemark() {
		return this.testRemark;
	}

	public void setTestRemark(String testRemark) {
		this.testRemark = testRemark;
	}

	public String getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(String laboratory) {
		this.laboratory = laboratory;
	}

	public String getMonitorMethod() {
		return this.monitorMethod;
	}

	public void setMonitorMethod(String monitorMethod) {
		this.monitorMethod = monitorMethod;
	}



	public String getMonitorNumber() {
		return this.monitorNumber;
	}

    public String getProvinceIodineStandard() {
        return provinceIodineStandard;
    }

    public void setProvinceIodineStandard(String provinceIodineStandard) {
        this.provinceIodineStandard = provinceIodineStandard;
    }

    public void setMonitorNumber(String monitorNumber) {
		this.monitorNumber = monitorNumber;
	}

    public BigDecimal getDeterminedResult() {
        return determinedResult;
    }

    public void setDeterminedResult(BigDecimal determinedResult) {
        this.determinedResult = determinedResult;
    }

    public String getLabCheckRemark() {
		return this.labCheckRemark;
	}

	public void setLabCheckRemark(String labCheckRemark) {
		this.labCheckRemark = labCheckRemark;
	}

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}