package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "DM_DIABETIC_CONCLUSION")
public class DiabeticConclusion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = false)
    private String healthFileNo;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = false)
    private String idcard;

    @Column(name = "FPG", columnDefinition = "NUMBER|空腹血糖值(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal fpg;

    @Column(name = "GLU_VALUE", columnDefinition = "NUMBER|餐后两小时血糖值(mmol/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal gluvalue;

    @Column(name = "SACCHARIFICATION", columnDefinition = "NUMBER|糖化血红蛋自值(%)||", length = 5, nullable = true)
    private Integer saccharification;

    @Column(name = "AUXILIARY_EXAMINE_ITEM", columnDefinition = "VARCHAR2|辅助检查项目||", length = 100, nullable = true)
    private String auxiliaryExamineItem;

    @Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断结论||", length = 1, nullable = true)
    private String diagnosis;

    @Column(name = "MANAGE_LEVEL", columnDefinition = "VARCHAR2|管理级别||", length = 1, nullable = true)
    private String manageLevel;

    @Column(name = "CONCLUSIONS_OF_YEAR", columnDefinition = "NUMBER|结论年度||", length = 5, nullable = true)
    private Integer conclusionsOfYear;

    @Column(name = "ANNUAL_VISIT_TIMES", columnDefinition = "NUMBER|每年随访次数||", length = 5, nullable = true)
    private Integer annualVisitTimes;

    @Column(name = "FILL_UNIT_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 70, nullable = true)
    private String fillUnitName;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date fillDate;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 15, nullable = true)
    private String updateOrgancode;

    @Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
    private String updateOrganname;

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

    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public BigDecimal getFpg() {
        return this.fpg;
    }

    public void setFpg(BigDecimal fpg) {
        this.fpg = fpg;
    }

    public BigDecimal getGluvalue() {
        return this.gluvalue;
    }

    public void setGluvalue(BigDecimal gluvalue) {
        this.gluvalue = gluvalue;
    }

    public Integer getSaccharification() {
        return this.saccharification;
    }

    public void setSaccharification(Integer saccharification) {
        this.saccharification = saccharification;
    }

    public String getAuxiliaryExamineItem() {
        return this.auxiliaryExamineItem;
    }

    public void setAuxiliaryExamineItem(String auxiliaryExamineItem) {
        this.auxiliaryExamineItem = auxiliaryExamineItem;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getManageLevel() {
        return this.manageLevel;
    }

    public void setManageLevel(String manageLevel) {
        this.manageLevel = manageLevel;
    }

    public Integer getConclusionsOfYear() {
        return this.conclusionsOfYear;
    }

    public void setConclusionsOfYear(Integer conclusionsOfYear) {
        this.conclusionsOfYear = conclusionsOfYear;
    }

    public Integer getAnnualVisitTimes() {
        return this.annualVisitTimes;
    }

    public void setAnnualVisitTimes(Integer annualVisitTimes) {
        this.annualVisitTimes = annualVisitTimes;
    }

    public String getFillUnitName() {
        return this.fillUnitName;
    }

    public void setFillUnitName(String fillUnitName) {
        this.fillUnitName = fillUnitName;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public String getUpdateOrgancode() {
        return this.updateOrgancode;
    }

    public void setUpdateOrgancode(String updateOrgancode) {
        this.updateOrgancode = updateOrgancode;
    }

    public String getUpdateOrganname() {
        return this.updateOrganname;
    }

    public void setUpdateOrganname(String updateOrganname) {
        this.updateOrganname = updateOrganname;
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


    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

}
