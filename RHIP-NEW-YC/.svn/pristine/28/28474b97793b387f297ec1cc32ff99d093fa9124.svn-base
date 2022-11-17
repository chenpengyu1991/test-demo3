package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_zhou on 2015/6/19.
 */
@Entity
@Table(name = "RP_STATISTICS")
@XmlRootElement
public class RpStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）||", length = 100, nullable = true)
    private String rpName;

    @Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇code||", length = 50, nullable = true)
    private String gbCode;

    @Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心code||", length = 50, nullable = true)
    private String centerCode;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构code||", length = 50, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型||", length = 5, nullable = true)
    private String organType;

    @Column(name = "RP_DATE", columnDefinition = "DATE|统计日期||", nullable = true)
    private Date rpDate;

    @Column(name = "TREATMENT_NUM", columnDefinition = "VARCHAR2|门诊就诊人次||", length = 10, nullable = true)
    private Integer treatmentNum;

    @Column(name = "IN_NUM", columnDefinition = "VARCHAR2|住院人次||", length = 10, nullable = true)
    private Integer inNum;

    @Column(name = "STUDY_NUM", columnDefinition = "VARCHAR2|检查人次||", length = 10, nullable = true)
    private Integer studyNum;

    @Column(name = "EXAMINATION_NUM", columnDefinition = "VARCHAR2|检验人次||", length = 10, nullable = true)
    private Integer examinationNum;

    @Column(name = "INHOSPITAL_DAY", columnDefinition = "VARCHAR2|住院日||", length = 10, nullable = true)
    private Integer inhospitalDay;

    @Column(name = "NEONATAL_DEATH_NUM", columnDefinition = "VARCHAR2|婴儿死亡数||", length = 10, nullable = true)
    private Integer neonatalDeathNum;

    @Column(name = "FIVE_DEATH_NUM", columnDefinition = "VARCHAR2|5岁以下婴儿死亡数||", length = 10, nullable = true)
    private Integer fiveDeathNum;

    @Column(name = "NEWBORN_NUM", columnDefinition = "VARCHAR2|婴儿数||", length = 10, nullable = true)
    private Integer newBornNum;

    @Column(name = "DELIVERY_DEATH_NUM", columnDefinition = "VARCHAR2|孕产妇死亡数||", length = 10, nullable = true)
    private Integer deliveryDeathNum;

    @Column(name = "DELIVERY_INHOSPITAL_NUM", columnDefinition = "VARCHAR2|孕妇住院分娩数||", length = 10, nullable = true)
    private Integer deliveryInhospitalNum;

    @Column(name = "DELIVERY_SYSTEM_NUM", columnDefinition = "VARCHAR2|孕产妇系统管理数||", length = 10, nullable = true)
    private Integer deliverySystemNum;

    @Column(name = "MATERNAL_REGISTRATION_NUM", columnDefinition = "VARCHAR2|孕产妇数||", length = 10, nullable = true)
    private Integer maternalRegistrationNum;

    @Column(name = "THREE_SYSTEM_NUM", columnDefinition = "VARCHAR2|3岁以下儿童系统管理数||", length = 10, nullable = true)
    private Integer threeSystemNum;

    @Column(name = "THREE_CHILD_NUM", columnDefinition = "VARCHAR2|3岁以下儿童数||", length = 10, nullable = true)
    private Integer threeChildNum;

    @Column(name = "VACCINATION_NUM", columnDefinition = "VARCHAR2|免疫规划接种数||", length = 10, nullable = true)
    private Integer vaccinationNum;

    @Column(name = "SCHOOL_CHILD_NUM", columnDefinition = "VARCHAR2|适龄儿童数||", length = 10, nullable = true)
    private Integer schoolChildNum;

    @Column(name = "CHILD_NUM", columnDefinition = "VARCHAR2|儿童数||", length = 10, nullable = true)
    private Integer childNum;

    @Column(name = "HBSAG_NUM", columnDefinition = "VARCHAR2|乙型肝炎抗原检查人数||", length = 10, nullable = true)
    private Integer hbsagNum;

    @Column(name = "HBSAG_POSITIVE_NUM", columnDefinition = "VARCHAR2|乙型肝炎抗原阳性人数||", length = 10, nullable = true)
    private Integer hbsagPositiveNum;

    @Column(name = "VACCINATION_TYPE", columnDefinition = "VARCHAR2|疫苗种类||", length = 10, nullable = true)
    private String vaccinationType;

    @Column(name = "PLAN_VACCINATION_NUM", columnDefinition = "VARCHAR2|应接种人数||", length = 10, nullable = true)
    private Integer planVaccinationNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRpName() {
        return rpName;
    }

    public void setRpName(String rpName) {
        this.rpName = rpName;
    }

    public String getGbCode() {
        return gbCode;
    }

    public void setGbCode(String gbCode) {
        this.gbCode = gbCode;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public Date getRpDate() {
        return rpDate;
    }

    public void setRpDate(Date rpDate) {
        this.rpDate = rpDate;
    }

    public Integer getTreatmentNum() {
        return treatmentNum;
    }

    public void setTreatmentNum(Integer treatmentNum) {
        this.treatmentNum = treatmentNum;
    }

    public Integer getInNum() {
        return inNum;
    }

    public void setInNum(Integer inNum) {
        this.inNum = inNum;
    }

    public Integer getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(Integer studyNum) {
        this.studyNum = studyNum;
    }

    public Integer getExaminationNum() {
        return examinationNum;
    }

    public void setExaminationNum(Integer examinationNum) {
        this.examinationNum = examinationNum;
    }

    public Integer getInhospitalDay() {
        return inhospitalDay;
    }

    public void setInhospitalDay(Integer inhospitalDay) {
        this.inhospitalDay = inhospitalDay;
    }

    public Integer getNeonatalDeathNum() {
        return neonatalDeathNum;
    }

    public void setNeonatalDeathNum(Integer neonatalDeathNum) {
        this.neonatalDeathNum = neonatalDeathNum;
    }

    public Integer getFiveDeathNum() {
        return fiveDeathNum;
    }

    public void setFiveDeathNum(Integer fiveDeathNum) {
        this.fiveDeathNum = fiveDeathNum;
    }

    public Integer getNewBornNum() {
        return newBornNum;
    }

    public void setNewBornNum(Integer newBornNum) {
        this.newBornNum = newBornNum;
    }

    public Integer getDeliveryDeathNum() {
        return deliveryDeathNum;
    }

    public void setDeliveryDeathNum(Integer deliveryDeathNum) {
        this.deliveryDeathNum = deliveryDeathNum;
    }

    public Integer getDeliveryInhospitalNum() {
        return deliveryInhospitalNum;
    }

    public void setDeliveryInhospitalNum(Integer deliveryInhospitalNum) {
        this.deliveryInhospitalNum = deliveryInhospitalNum;
    }

    public Integer getDeliverySystemNum() {
        return deliverySystemNum;
    }

    public void setDeliverySystemNum(Integer deliverySystemNum) {
        this.deliverySystemNum = deliverySystemNum;
    }

    public Integer getMaternalRegistrationNum() {
        return maternalRegistrationNum;
    }

    public void setMaternalRegistrationNum(Integer maternalRegistrationNum) {
        this.maternalRegistrationNum = maternalRegistrationNum;
    }

    public Integer getThreeSystemNum() {
        return threeSystemNum;
    }

    public void setThreeSystemNum(Integer threeSystemNum) {
        this.threeSystemNum = threeSystemNum;
    }

    public Integer getThreeChildNum() {
        return threeChildNum;
    }

    public void setThreeChildNum(Integer threeChildNum) {
        this.threeChildNum = threeChildNum;
    }

    public Integer getVaccinationNum() {
        return vaccinationNum;
    }

    public void setVaccinationNum(Integer vaccinationNum) {
        this.vaccinationNum = vaccinationNum;
    }

    public Integer getSchoolChildNum() {
        return schoolChildNum;
    }

    public void setSchoolChildNum(Integer schoolChildNum) {
        this.schoolChildNum = schoolChildNum;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public Integer getHbsagNum() {
        return hbsagNum;
    }

    public void setHbsagNum(Integer hbsagNum) {
        this.hbsagNum = hbsagNum;
    }

    public Integer getHbsagPositiveNum() {
        return hbsagPositiveNum;
    }

    public void setHbsagPositiveNum(Integer hbsagPositiveNum) {
        this.hbsagPositiveNum = hbsagPositiveNum;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    public Integer getPlanVaccinationNum() {
        return planVaccinationNum;
    }

    public void setPlanVaccinationNum(Integer planVaccinationNum) {
        this.planVaccinationNum = planVaccinationNum;
    }
}