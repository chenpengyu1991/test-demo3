package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_OUTPATIENT_DRUG_USAGE")
public class OutpatientDrugUsage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号||", length = 18, nullable = true)
    private String outpatientNo;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|处方号／记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|患者姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "NUMBER|年龄||", length = 3, nullable = true)
    private Integer age;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 20, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "CM_TYPE", columnDefinition = "VARCHAR2|中药类别代码||", length = 2, nullable = true)
    private String cmType;

    @Column(name = "DRUG_TYPE", columnDefinition = "VARCHAR2|药物类型||", length = 20, nullable = true)
    private String drugType;

    @Column(name = "DRUG_DOSAGE", columnDefinition = "VARCHAR2|药物剂型代码||", length = 2, nullable = true)
    private String drugDosage;

    @Column(name = "DRUG_USE_DAYS", columnDefinition = "NUMBER|用药天数||", length = 5, nullable = true)
    private Integer drugUseDays;

    @Column(name = "DRUG_USE_FREQUENCY", columnDefinition = "VARCHAR2|药物使用频率||", length = 20, nullable = true)
    private String drugUseFrequency;

    @Column(name = "DRUG_USE_DOSE_UNIT", columnDefinition = "VARCHAR2|药物使用剂量单位||", length = 6, nullable = true)
    private String drugUseDoseUnit;

    @Column(name = "DRUG_USE_DOSE", columnDefinition = "NUMBER|药物使用次剂量||", scale = 5, precision = 2, nullable = true)
    private BigDecimal drugUseDose;

    @Column(name = "DRUG_USE_TOTAL_DOSE", columnDefinition = "NUMBER|药物使用总剂量||", scale = 12, precision = 2, nullable = true)
    private BigDecimal drugUseTotalDose;

    @Column(name = "DRUG_USE_ROUTE_CODE", columnDefinition = "VARCHAR2|药物使用途径代码||", length = 3, nullable = true)
    private String drugUseRouteCode;

    @Column(name = "START_DATE", columnDefinition = "TIMESTAMP|用药开始日期时间||", nullable = true)
    private Date startDate;

    @Column(name = "STOP_DATE", columnDefinition = "TIMESTAMP|用药停止日期时间||", nullable = true)
    private Date stopDate;

    @Column(name = "DRUG_GENERIC_NAME", columnDefinition = "VARCHAR2|药物通用名||", length = 50, nullable = true)
    private String drugGenericName;

    @Column(name = "DRUG_TRADE_NAME", columnDefinition = "VARCHAR2|药物商用名||", length = 50, nullable = true)
    private String drugTradeName;

    @Column(name = "DRUG_SPECIFICATIONS", columnDefinition = "VARCHAR2|药品规格||", length = 20, nullable = true)
    private String drugSpecifications;

    @Column(name = "PRESCRIBING_DETAI_DESC", columnDefinition = "VARCHAR2|处方明细说明||", length = 200, nullable = true)
    private String prescribingDetaiDesc;

    @Column(name = "MANUFACTURE_FACTORY_NAME", columnDefinition = "VARCHAR2|生产厂家名称||", length = 50, nullable = true)
    private String manufactureFactoryName;

    @Column(name = "EXECUTE_MARK", columnDefinition = "CHAR|执行标记||", length = 1, nullable = true)
    private String executeMark;

    @Column(name = "EXECUTE_FREQUENCY", columnDefinition = "VARCHAR2|执行频度文字描述||", length = 200, nullable = true)
    private String executeFrequency;

    @Column(name = "EXECUTE_RESULT", columnDefinition = "VARCHAR2|执行结果||", length = 200, nullable = true)
    private String executeResult;

    @Column(name = "UNIT_PRICE", columnDefinition = "NUMBER|单价||", scale = 5, precision = 2, nullable = true)
    private BigDecimal unitPrice;

    @Column(name = "SUBTOTAL", columnDefinition = "NUMBER|小计||", scale = 8, precision = 2, nullable = true)
    private BigDecimal subtotal;

    @Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 200, nullable = true)
    private String remarks;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_USER_IDCARD", columnDefinition = "VARCHAR2|填报身份证号||", length = 18, nullable = true)
    private String fillUserIdCard;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

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

    public String getoutpatientNo() {
        return this.outpatientNo;
    }

    public void setoutpatientNo(String outpatientNo) {
        this.outpatientNo = outpatientNo;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getCmType() {
        return this.cmType;
    }

    public void setCmType(String cmType) {
        this.cmType = cmType;
    }

    public String getDrugType() {
        return this.drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getDrugDosage() {
        return this.drugDosage;
    }

    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }

    public Integer getDrugUseDays() {
        return this.drugUseDays;
    }

    public void setDrugUseDays(Integer drugUseDays) {
        this.drugUseDays = drugUseDays;
    }

    public String getDrugUseFrequency() {
        return this.drugUseFrequency;
    }

    public void setDrugUseFrequency(String drugUseFrequency) {
        this.drugUseFrequency = drugUseFrequency;
    }

    public String getDrugUseDoseUnit() {
        return this.drugUseDoseUnit;
    }

    public void setDrugUseDoseUnit(String drugUseDoseUnit) {
        this.drugUseDoseUnit = drugUseDoseUnit;
    }

    public BigDecimal getDrugUseDose() {
        return this.drugUseDose;
    }

    public void setDrugUseDose(BigDecimal drugUseDose) {
        this.drugUseDose = drugUseDose;
    }

    public BigDecimal getDrugUseTotalDose() {
        return this.drugUseTotalDose;
    }

    public void setDrugUseTotalDose(BigDecimal drugUseTotalDose) {
        this.drugUseTotalDose = drugUseTotalDose;
    }

    public String getDrugUseRouteCode() {
        return this.drugUseRouteCode;
    }

    public void setDrugUseRouteCode(String drugUseRouteCode) {
        this.drugUseRouteCode = drugUseRouteCode;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return this.stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getDrugGenericName() {
        return this.drugGenericName;
    }

    public void setDrugGenericName(String drugGenericName) {
        this.drugGenericName = drugGenericName;
    }

    public String getDrugTradeName() {
        return this.drugTradeName;
    }

    public void setDrugTradeName(String drugTradeName) {
        this.drugTradeName = drugTradeName;
    }

    public String getDrugSpecifications() {
        return this.drugSpecifications;
    }

    public void setDrugSpecifications(String drugSpecifications) {
        this.drugSpecifications = drugSpecifications;
    }

    public String getPrescribingDetaiDesc() {
        return this.prescribingDetaiDesc;
    }

    public void setPrescribingDetaiDesc(String prescribingDetaiDesc) {
        this.prescribingDetaiDesc = prescribingDetaiDesc;
    }

    public String getManufactureFactoryName() {
        return this.manufactureFactoryName;
    }

    public void setManufactureFactoryName(String manufactureFactoryName) {
        this.manufactureFactoryName = manufactureFactoryName;
    }

    public String getExecuteMark() {
        return this.executeMark;
    }

    public void setExecuteMark(String executeMark) {
        this.executeMark = executeMark;
    }

    public String getExecuteFrequency() {
        return this.executeFrequency;
    }

    public void setExecuteFrequency(String executeFrequency) {
        this.executeFrequency = executeFrequency;
    }

    public String getExecuteResult() {
        return this.executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public String getFillUserIdCard() {
        return this.fillUserIdCard;
    }

    public void setFillUserIdCard(String fillUserIdCard) {
        this.fillUserIdCard = fillUserIdCard;
    }

    public Date getFillTime() {
        return this.fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }

    public String getUpdateName() {
        return this.updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateIdcard() {
        return this.updateIdcard;
    }

    public void setUpdateIdcard(String updateIdcard) {
        this.updateIdcard = updateIdcard;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

}
