package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_EXPENSE_DETAIL")
public class ExpenseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "CHARGE_CODE", columnDefinition = "VARCHAR2|收费代码||", length = 20, nullable = true)
    private String chargeCode;

    @Column(name = "DETAIL_ITEM_CODE", columnDefinition = "VARCHAR2|明细项目编码||", length = 20, nullable = true)
    private String detailItemCode;

    @Column(name = "DETAIL_ITEM_NAME", columnDefinition = "VARCHAR2|明细项目名称||", length = 50, nullable = true)
    private String detailItemName;

    @Column(name = "DETAIL_ITEM_UNIT", columnDefinition = "VARCHAR2|明细项目单位||", length = 100, nullable = true)
    private String detailItemUnit;

    @Column(name = "DETAIL_ITEM_PRICE", columnDefinition = "NUMBER|明细项目单价||", scale = 8, precision = 2, nullable = true)
    private BigDecimal detailItemPrice;

    @Column(name = "DETAIL_ITEM_QUANTITY", columnDefinition = "NUMBER|明细项目数量||", length = 8, nullable = true)
    private BigDecimal detailItemQuantity;

    @Column(name = "DETAIL_ITEM_AMOUNT", columnDefinition = "NUMBER|明细项目金额||", scale = 10, precision = 2, nullable = true)
    private BigDecimal detailItemAmount;

    @Column(name = "MEDICAL_INSURANCE_COST_SUM", columnDefinition = "NUMBER|医疗保险金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal medicalInsuranceCostSum;

    @Column(name = "PERSONAL_EXPENSES", columnDefinition = "NUMBER|个人承担费用(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal personalExpenses;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
    @Column(name = "COST_NUMBER", columnDefinition = "VARCHAR2|费用主索引||", length = 50, nullable = true)
    private String costNumber;
    
	@Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院/门诊号||", length = 50, nullable = true)
	private String admissionNo;

	@Column(name = "MEDICARE_CODE", columnDefinition = "VARCHAR2|药品医保编码/耗材编码/处置编码||", length = 50, nullable = true)
	private String medicareCode;

	@Column(name = "CLINIC_DATE", columnDefinition = "TIMESTAMP|收费时间（统计一定要用）||", nullable = true)
	private Date clinicDate;

	@Column(name = "CLINIC_MARK", columnDefinition = "NUMBER|门诊/急诊/住院标志||", length = 1, nullable = true)
	private Long clinicMark;

	@Column(name = "EXPENSE_TYPE", columnDefinition = "NUMBER|药品/耗材/处置等标志||", length = 1, nullable = true)
	private Long expenseType;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|批次号||", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "IS_CLOSE", columnDefinition = "NUMBER|是否结算||", length = 1, nullable = true)
	private Long isClose;
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

    @Column(name = "COST_TYPE_CODE", columnDefinition = "VARCHAR2|费用类别代码||", length = 2, nullable = true)
    private String costTypeCode;

    @Column(name = "COST_TYPE_NAME", columnDefinition = "VARCHAR2|费用分类名称||", length = 20, nullable = true)
    private String costTypeName;

    @Column(name = "TRANSACTION_CATEGORY", columnDefinition = "VARCHAR2|交易类别FS99057 1：收费，2：退费，3：作废||", length = 1, nullable = true)
    private String transactionCategory;

    @Column(name = "TRANSACTION_NAME", columnDefinition = "VARCHAR2|交易名称||", length = 1, nullable = true)
    private String transactionName;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEhrId() {
        return this.ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getHospitalCode() {
        return this.hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getChargeCode() {
        return this.chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getDetailItemCode() {
        return this.detailItemCode;
    }

    public void setDetailItemCode(String detailItemCode) {
        this.detailItemCode = detailItemCode;
    }

    public String getDetailItemName() {
        return this.detailItemName;
    }

    public void setDetailItemName(String detailItemName) {
        this.detailItemName = detailItemName;
    }

    public String getDetailItemUnit() {
        return this.detailItemUnit;
    }

    public void setDetailItemUnit(String detailItemUnit) {
        this.detailItemUnit = detailItemUnit;
    }

    public BigDecimal getDetailItemPrice() {
        return this.detailItemPrice;
    }

    public void setDetailItemPrice(BigDecimal detailItemPrice) {
        this.detailItemPrice = detailItemPrice;
    }

	public BigDecimal getDetailItemQuantity() {
		return detailItemQuantity;
	}

	
	public void setDetailItemQuantity(BigDecimal detailItemQuantity) {
		this.detailItemQuantity = detailItemQuantity;
	}

	public BigDecimal getDetailItemAmount() {
        return this.detailItemAmount;
    }

    public void setDetailItemAmount(BigDecimal detailItemAmount) {
        this.detailItemAmount = detailItemAmount;
    }

    public BigDecimal getMedicalInsuranceCostSum() {
        return this.medicalInsuranceCostSum;
    }

    public void setMedicalInsuranceCostSum(BigDecimal medicalInsuranceCostSum) {
        this.medicalInsuranceCostSum = medicalInsuranceCostSum;
    }

    public BigDecimal getPersonalExpenses() {
        return this.personalExpenses;
    }

    public void setPersonalExpenses(BigDecimal personalExpenses) {
        this.personalExpenses = personalExpenses;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

	
	public String getCostNumber() {
		return costNumber;
	}

	
	public void setCostNumber(String costNumber) {
		this.costNumber = costNumber;
	}

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getMedicareCode() {
		return medicareCode;
	}

	public void setMedicareCode(String medicareCode) {
		this.medicareCode = medicareCode;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public Long getClinicMark() {
		return clinicMark;
	}

	public void setClinicMark(Long clinicMark) {
		this.clinicMark = clinicMark;
	}

	public Long getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(Long expenseType) {
		this.expenseType = expenseType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getIsClose() {
		return isClose;
	}

	public void setIsClose(Long isClose) {
		this.isClose = isClose;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

    public String getCostTypeCode() {
        return costTypeCode;
    }

    public void setCostTypeCode(String costTypeCode) {
        this.costTypeCode = costTypeCode;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }
}
