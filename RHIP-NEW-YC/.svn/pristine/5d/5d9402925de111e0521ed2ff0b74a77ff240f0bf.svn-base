package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_EXPENSE_INFO")
public class ExpenseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "PAY_BAR_CODE", columnDefinition = "VARCHAR2|收费条形码||", length = 20, nullable = true)
    private String payBarCode;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "MEDICAL_PAY_WAY", columnDefinition = "VARCHAR2|医疗费用支付方式代码||", length = 1, nullable = true)
    private String medicalPayWay;

    @Column(name = "MEDICAL_PAY_WAY_NAME", columnDefinition = "VARCHAR2|医疗费用支付方式名称||", length = 50, nullable = true)
    private String medicalPayWayName;

    @Column(name = "MEDICAL_SETTLEMENT_WAY_CODE", columnDefinition = "VARCHAR2|医疗费用结算方式代码||", length = 2, nullable = true)
    private String medicalSettlementWayCode;

    @Column(name = "MEDICAL_SETTLEMENT_WAY_NAME", columnDefinition = "VARCHAR2|医疗费用结算方式名称||", length = 50, nullable = true)
    private String medicalSettlementWayName;

    @Column(name = "TOTAL_COST", columnDefinition = "NUMBER|总费用||", scale = 10, precision = 2, nullable = true)
    private BigDecimal totalCost;

    @Column(name = "PERSONAL_EXPENSES", columnDefinition = "NUMBER|个人承担费用(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal personalExpenses;

    @Column(name = "MEDICAL_INSURANCE_COST_SUM", columnDefinition = "NUMBER|医疗保险金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal medicalInsuranceCostSum;

    @Column(name = "OTHER_SUBSIDIES_COST_SUM", columnDefinition = "NUMBER|其他补助金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal otherSubsidiesCostSum;

    @Column(name = "SETTLEMENT_DATE", columnDefinition = "TIMESTAMP|结算日期时间||", nullable = true)
    private Date settlementDate;

    @Column(name = "OTHER_DESC", columnDefinition = "VARCHAR2|其他说明||", length = 100, nullable = true)
    private String otherDesc;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
    @Column(name = "COST_NUMBER", columnDefinition = "VARCHAR2|费用主索引||", length = 50, nullable = true)
    private String costNumber;
    
	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 50, nullable = true)
	private String othercardno;

	@Column(name = "OP_EM_HP_MARK", columnDefinition = "VARCHAR2|门诊/急诊/住院标志||", length = 2, nullable = true)
	private String opEmHpMark;

	@Column(name = "OP_EM_HP_NO", columnDefinition = "VARCHAR2|门诊/急诊/住院编号||", length = 50, nullable = true)
	private String opEmHpNo;

	@Column(name = "RCD_IDCARD", columnDefinition = "VARCHAR2|收费员身份证号||", length = 18, nullable = true)
	private String rcdIdcard;

	@Column(name = "INVOICE_NO", columnDefinition = "VARCHAR2|发票号码||", length = 50, nullable = true)
	private String invoiceNo;

	@Column(name = "ACCOUNT_NO", columnDefinition = "VARCHAR2|结算序号||", length = 50, nullable = true)
	private String accountNo;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus;
	
    @Column(name = "IS_LIMIT", columnDefinition = "VARCHAR2|是否限制||", length = 1, nullable = true)
    private String isLimit;

    @Column(name = "TRANSACTION_CATEGORY", columnDefinition = "VARCHAR2|FS99057 1：收费，2：退费，3：作废||", length = 1, nullable = true)
    private String transactionCategory;

    @Column(name = "TRANSACTION_NAME", columnDefinition = "VARCHAR2|交易名称||", length = 1, nullable = true)
    private String transactionName;

    @Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
    @Transient
    private String opEmHpMarkDesc;
    
    public String getOpEmHpMarkDesc() {
		return opEmHpMarkDesc;
	}

	public void setOpEmHpMarkDesc(String opEmHpMarkDesc) {
		this.opEmHpMarkDesc = opEmHpMarkDesc;
	}

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

	public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getPayBarCode() {
        return this.payBarCode;
    }

    public void setPayBarCode(String payBarCode) {
        this.payBarCode = payBarCode;
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

    public String getMedicalPayWay() {
        return this.medicalPayWay;
    }

    public void setMedicalPayWay(String medicalPayWay) {
        this.medicalPayWay = medicalPayWay;
    }

    public String getMedicalPayWayName() {
        return this.medicalPayWayName;
    }

    public void setMedicalPayWayName(String medicalPayWayName) {
        this.medicalPayWayName = medicalPayWayName;
    }

    public String getMedicalSettlementWayCode() {
        return this.medicalSettlementWayCode;
    }

    public void setMedicalSettlementWayCode(String medicalSettlementWayCode) {
        this.medicalSettlementWayCode = medicalSettlementWayCode;
    }

    public String getMedicalSettlementWayName() {
        return this.medicalSettlementWayName;
    }

    public void setMedicalSettlementWayName(String medicalSettlementWayName) {
        this.medicalSettlementWayName = medicalSettlementWayName;
    }

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getPersonalExpenses() {
        return this.personalExpenses;
    }

    public void setPersonalExpenses(BigDecimal personalExpenses) {
        this.personalExpenses = personalExpenses;
    }

    public BigDecimal getMedicalInsuranceCostSum() {
        return this.medicalInsuranceCostSum;
    }

    public void setMedicalInsuranceCostSum(BigDecimal medicalInsuranceCostSum) {
        this.medicalInsuranceCostSum = medicalInsuranceCostSum;
    }

    public BigDecimal getOtherSubsidiesCostSum() {
        return this.otherSubsidiesCostSum;
    }

    public void setOtherSubsidiesCostSum(BigDecimal otherSubsidiesCostSum) {
        this.otherSubsidiesCostSum = otherSubsidiesCostSum;
    }

    public Date getSettlementDate() {
        return this.settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
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

	public String getOthercardtype() {
		return othercardtype;
	}

	public void setOthercardtype(String othercardtype) {
		this.othercardtype = othercardtype;
	}

	public String getOthercardno() {
		return othercardno;
	}

	public void setOthercardno(String othercardno) {
		this.othercardno = othercardno;
	}

	public String getOpEmHpMark() {
		return opEmHpMark;
	}

	public void setOpEmHpMark(String opEmHpMark) {
		this.opEmHpMark = opEmHpMark;
	}

	public String getOpEmHpNo() {
		return opEmHpNo;
	}

	public void setOpEmHpNo(String opEmHpNo) {
		this.opEmHpNo = opEmHpNo;
	}

	public String getRcdIdcard() {
		return rcdIdcard;
	}

	public void setRcdIdcard(String rcdIdcard) {
		this.rcdIdcard = rcdIdcard;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(String isLimit) {
		this.isLimit = isLimit;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
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
