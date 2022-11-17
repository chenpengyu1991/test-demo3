package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MHM_DRUG")
public class MhmDrug implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

    @Column(name = "IS_FREE", columnDefinition = "VARCHAR2|是否是免费药|2|", length = 2, nullable = true)
    private String isFree;
    
	@Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|药物名称|50|", length = 50, nullable = true)
	private String drugName;

    @Column(name = "DRUG_FORM", columnDefinition = "VARCHAR2|药品剂型|20|", length = 20, nullable = true)
    private String drugForm;

    @Column(name = "DRUG_UNIT", columnDefinition = "VARCHAR2|单位（mg、ml）||", length = 20, nullable = true)
    private String drugUnit;
    
    @Column(name = "UNIT_MEASURE", columnDefinition = "NUMBER|单位计量||", scale = 5, precision = 2, nullable = true)
    private BigDecimal unitMeasure;

    @Column(name = "AMOUNT", columnDefinition = "NUMBER|每盒数量||", scale = 8, precision = 0, nullable = true)
    private Integer amount;
    
	@Column(name = "DRUG_SPECIFICATIONS", columnDefinition = "VARCHAR2|药品规格（例如：【一盒：25mg(粒)×100】|200|", length = 200, nullable = true)
	private String drugSpecifications;

    @Column(name = "DRUG_PRICE", columnDefinition = "NUMBER|药品价格||", scale = 5, precision = 2, nullable = true)
    private BigDecimal drugPrice;

    @Column(name = "UNIT_PRICE", columnDefinition = "NUMBER|单位价格（四舍五入）||", scale = 5, precision = 2, nullable = true)
    private BigDecimal unitPrice;
    
    @Column(name = "VERSION", columnDefinition = "NUMBER|版本号|11|", length = 11, nullable = true)
    private Long version;

    @Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
    private String fillOrganCode;

    @Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
    private String fillDoctorId;

    @Column(name = "FILL_DATE", columnDefinition = "DATE|填写时间||", nullable = true)
    private Date fillDate;

    @Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
    private String modifyDoctorId;

    @Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
    private String modifyOrganCode;

    @Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
    private Date modifyDate;
    
    /*是否能够删除本药品*/
    @Transient
    private Integer deleteFlag;

    /*发药中心*/
    @Transient
    private String organCenter;

    /*发药站*/
    @Transient
    private String organStation;

    /*费用*/
    @Transient
    private String currentPrice;

    @Transient
    private String statusId;

    @Transient
    private String name;

    @Transient
    private String gender;

    @Transient
    private String age;

    @Transient
    private String idcard;

    @Transient
    private String diagnosisContent;

    private String organTown;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugForm() {
        return drugForm;
    }

    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDrugSpecifications() {
        return drugSpecifications;
    }

    public void setDrugSpecifications(String drugSpecifications) {
        this.drugSpecifications = drugSpecifications;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFillOrganCode() {
        return fillOrganCode;
    }

    public void setFillOrganCode(String fillOrganCode) {
        this.fillOrganCode = fillOrganCode;
    }

    public String getFillDoctorId() {
        return fillDoctorId;
    }

    public void setFillDoctorId(String fillDoctorId) {
        this.fillDoctorId = fillDoctorId;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public String getModifyDoctorId() {
        return modifyDoctorId;
    }

    public void setModifyDoctorId(String modifyDoctorId) {
        this.modifyDoctorId = modifyDoctorId;
    }

    public String getModifyOrganCode() {
        return modifyOrganCode;
    }

    public void setModifyOrganCode(String modifyOrganCode) {
        this.modifyOrganCode = modifyOrganCode;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

	public String getDrugUnit() {
		return drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}

	public BigDecimal getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(BigDecimal unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(BigDecimal drugPrice) {
		this.drugPrice = drugPrice;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getIsFree() {
		return isFree;
	}

	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}

    public String getOrganStation() {
        return organStation;
    }

    public void setOrganStation(String organStation) {
        this.organStation = organStation;
    }

    public String getOrganCenter() {
        return organCenter;
    }

    public void setOrganCenter(String organCenter) {
        this.organCenter = organCenter;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getDiagnosisContent() {
        return diagnosisContent;
    }

    public void setDiagnosisContent(String diagnosisContent) {
        this.diagnosisContent = diagnosisContent;
    }

    public String getOrganTown() {
        return organTown;
    }

    public void setOrganTown(String organTown) {
        this.organTown = organTown;
    }
}