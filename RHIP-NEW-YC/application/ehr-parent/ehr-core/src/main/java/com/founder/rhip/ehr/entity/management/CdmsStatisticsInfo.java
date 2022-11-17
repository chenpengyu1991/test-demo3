package com.founder.rhip.ehr.entity.management;

import java.io.Serializable;
import java.math.BigDecimal;

public class CdmsStatisticsInfo implements Serializable {
	private static final long serialVersionUID = 6239325019571623959L;
	/**
	 * 单位
	 */
	private String createUnitName;
	/**
	 * 单位
	 */
	private String createUnitCode;
	/**
	 * 辖区人口数
	 */
	private Long districtPopulation;
	/**
	 * 辖区估计病人数
	 */
	private Long appraisePopulation;
	/**
	 * 已管理慢病人数（高血压）
	 */
	private Long manageHbpPopulation;
	/**
	 * 已管理慢病人数(糖尿病）
	 */
	private Long manageDiPopulation;
	/**
	 * 已管理慢病人数（肿瘤）
	 */
	private Long manageCancerPopulation;
	/**
	 * 已管理慢病人数（脑卒中）
	 */
	private Long manageStrokePopulation;
	/**
	 * 已管理慢病人数（冠心病）
	 */
	private Long manageCoronaryPopulation;

	/**
	 * 规范化管理慢病人数（高血压）
	 */
	private Long standardizationHbpPopulation;
	/**
	 * 规范化管理慢病人数(糖尿病）
	 */
	private Long standardizationDiPopulation;
	/**
	 * 规范化管理慢病人数（肿瘤）
	 */
	private Long standardizationCancerPopulation;
	/**
	 * 规范化管理慢病人数（脑卒中）
	 */
	private Long standardizationStrokePopulation;
	/**
	 * 规范化管理慢病人数（冠心病）
	 */
	private Long standardizationCoronaryPopulation;
	/**
	 * 规范化管理率(高血压)
	 */
	private BigDecimal standardizationManagementHbpRate;
	/**
	 * 规范化管理率(糖尿病)
	 */
	private BigDecimal standardizationManagementDiRate;
	/**
	 * 年内以管理慢病人数
	 */
	private Long cdmManageTotal;
	/**
	 * 规范化管理率(肿瘤)
	 */
	private BigDecimal standardizationManagementCancerRate;
	/**
	 * 规范化管理率(冠心病)
	 */
	private BigDecimal standardizationManagementStrokeRate;
	/**
	 * 规范化管理率(脑卒中)
	 */
	private BigDecimal standardizationManagementCoronaryRate;
	/**
	 * 健康管理率
	 */
	private BigDecimal healthManagementRate;
	/**
	 * 最近一次随访空腹血压达标人数
	 */
	private Long bloodToStandard;
	/**
	 * 管理人群血压控制率
	 */
	private BigDecimal bloodToStandardRate;
	/**
	 * 最近一次随访空腹血糖达标人数
	 */
	private Long bloodSugerToStandard;
	/**
	 * 管理人群血糖控制率
	 */
	private BigDecimal bloodSugerToStandardRate;


    public void add(CdmsStatisticsInfo other){

        districtPopulation+=other.getDistrictPopulation();
        /**
         * 辖区估计病人数
         */
        appraisePopulation+=other.getAppraisePopulation();
        /**
         * 已管理慢病人数（高血压）
         */
        manageHbpPopulation+=other.getManageHbpPopulation();
        /**
         * 已管理慢病人数(糖尿病）
         */
        manageDiPopulation+=other.getManageDiPopulation();
        /**
         * 已管理慢病人数（肿瘤）
         */
        manageCancerPopulation+=other.getManageCancerPopulation();
        /**
         * 已管理慢病人数（脑卒中）
         */
        manageStrokePopulation+=other.getManageStrokePopulation();
        /**
         * 已管理慢病人数（冠心病）
         */
        manageCoronaryPopulation+=other.getManageCoronaryPopulation();

        /**
         * 规范化管理慢病人数（高血压）
         */
        standardizationHbpPopulation+=other.getStandardizationHbpPopulation();
        /**
         * 规范化管理慢病人数(糖尿病）
         */
        standardizationDiPopulation+=other.getStandardizationDiPopulation();
        /**
         * 规范化管理慢病人数（肿瘤）
         */
        standardizationCancerPopulation+=other.getStandardizationCancerPopulation();
        /**
         * 规范化管理慢病人数（脑卒中）
         */
        standardizationStrokePopulation+=other.getStandardizationStrokePopulation();
        /**
         * 规范化管理慢病人数（冠心病）
         */
        standardizationCoronaryPopulation+=other.getStandardizationCoronaryPopulation();

        /**
         * 年内以管理慢病人数
         */
        cdmManageTotal+=other.getCdmManageTotal();

        /**
         * 最近一次随访空腹血压达标人数
         */
        bloodToStandard+=other.getBloodToStandard();

        /**
         * 最近一次随访空腹血糖达标人数
         */
        bloodSugerToStandard+=other.getBloodSugerToStandard();
;
    }

	public String getCreateUnitCode() {
		return createUnitCode;
	}

	public void setCreateUnitCode(String createUnitCode) {
		this.createUnitCode = createUnitCode;
	}

	public String getCreateUnitName() {
		return createUnitName;
	}

	public void setCreateUnitName(String createUnitName) {
		this.createUnitName = createUnitName;
	}

	public Long getDistrictPopulation() {
		return districtPopulation;
	}

	public void setDistrictPopulation(Long districtPopulation) {
		this.districtPopulation = districtPopulation;
	}

	public Long getAppraisePopulation() {
		return appraisePopulation;
	}

	public void setAppraisePopulation(Long appraisePopulation) {
		this.appraisePopulation = appraisePopulation;
	}

	public Long getManageHbpPopulation() {
		return manageHbpPopulation;
	}

	public void setManageHbpPopulation(Long manageHbpPopulation) {
		this.manageHbpPopulation = manageHbpPopulation;
	}

	public Long getManageDiPopulation() {
		return manageDiPopulation;
	}

	public void setManageDiPopulation(Long manageDiPopulation) {
		this.manageDiPopulation = manageDiPopulation;
	}

	public Long getManageCancerPopulation() {
		return manageCancerPopulation;
	}

	public void setManageCancerPopulation(Long manageCancerPopulation) {
		this.manageCancerPopulation = manageCancerPopulation;
	}

	public Long getManageStrokePopulation() {
		return manageStrokePopulation;
	}

	public void setManageStrokePopulation(Long manageStrokePopulation) {
		this.manageStrokePopulation = manageStrokePopulation;
	}

	public Long getManageCoronaryPopulation() {
		return manageCoronaryPopulation;
	}

	public void setManageCoronaryPopulation(Long manageCoronaryPopulation) {
		this.manageCoronaryPopulation = manageCoronaryPopulation;
	}

	public Long getStandardizationHbpPopulation() {
		return standardizationHbpPopulation;
	}

	public void setStandardizationHbpPopulation(Long standardizationHbpPopulation) {
		this.standardizationHbpPopulation = standardizationHbpPopulation;
	}

	public Long getStandardizationDiPopulation() {
		return standardizationDiPopulation;
	}

	public void setStandardizationDiPopulation(Long standardizationDiPopulation) {
		this.standardizationDiPopulation = standardizationDiPopulation;
	}

	public Long getStandardizationCancerPopulation() {
		return standardizationCancerPopulation;
	}

	public void setStandardizationCancerPopulation(Long standardizationCancerPopulation) {
		this.standardizationCancerPopulation = standardizationCancerPopulation;
	}

	public Long getStandardizationStrokePopulation() {
		return standardizationStrokePopulation;
	}

	public void setStandardizationStrokePopulation(Long standardizationStrokePopulation) {
		this.standardizationStrokePopulation = standardizationStrokePopulation;
	}

	public Long getStandardizationCoronaryPopulation() {
		return standardizationCoronaryPopulation;
	}

	public void setStandardizationCoronaryPopulation(Long standardizationCoronaryPopulation) {
		this.standardizationCoronaryPopulation = standardizationCoronaryPopulation;
	}

	public BigDecimal getHealthManagementRate() {
		return healthManagementRate;
	}

	public void setHealthManagementRate(BigDecimal healthManagementRate) {
		this.healthManagementRate = healthManagementRate;
	}

	public Long getBloodToStandard() {
		return bloodToStandard;
	}

	public void setBloodToStandard(Long bloodToStandard) {
		this.bloodToStandard = bloodToStandard;
	}

	public BigDecimal getBloodToStandardRate() {
		return bloodToStandardRate;
	}

	public void setBloodToStandardRate(BigDecimal bloodToStandardRate) {
		this.bloodToStandardRate = bloodToStandardRate;
	}

	public Long getBloodSugerToStandard() {
		return bloodSugerToStandard;
	}

	public void setBloodSugerToStandard(Long bloodSugerToStandard) {
		this.bloodSugerToStandard = bloodSugerToStandard;
	}

	public BigDecimal getBloodSugerToStandardRate() {
		return bloodSugerToStandardRate;
	}

	public void setBloodSugerToStandardRate(BigDecimal bloodSugerToStandardRate) {
		this.bloodSugerToStandardRate = bloodSugerToStandardRate;
	}

    public Long getCdmManageTotal() {
        return cdmManageTotal;
    }

    public void setCdmManageTotal(Long cdmManageTotal) {
        this.cdmManageTotal = cdmManageTotal;
    }

    public BigDecimal getStandardizationManagementHbpRate() {
        return standardizationManagementHbpRate;
    }

    public void setStandardizationManagementHbpRate(BigDecimal standardizationManagementHbpRate) {
        this.standardizationManagementHbpRate = standardizationManagementHbpRate;
    }

    public BigDecimal getStandardizationManagementDiRate() {
        return standardizationManagementDiRate;
    }

    public void setStandardizationManagementDiRate(BigDecimal standardizationManagementDiRate) {
        this.standardizationManagementDiRate = standardizationManagementDiRate;
    }

    public BigDecimal getStandardizationManagementCancerRate() {
        return standardizationManagementCancerRate;
    }

    public void setStandardizationManagementCancerRate(BigDecimal standardizationManagementCancerRate) {
        this.standardizationManagementCancerRate = standardizationManagementCancerRate;
    }

    public BigDecimal getStandardizationManagementStrokeRate() {
        return standardizationManagementStrokeRate;
    }

    public void setStandardizationManagementStrokeRate(BigDecimal standardizationManagementStrokeRate) {
        this.standardizationManagementStrokeRate = standardizationManagementStrokeRate;
    }

    public BigDecimal getStandardizationManagementCoronaryRate() {
        return standardizationManagementCoronaryRate;
    }

    public void setStandardizationManagementCoronaryRate(BigDecimal standardizationManagementCoronaryRate) {
        this.standardizationManagementCoronaryRate = standardizationManagementCoronaryRate;
    }

}
