package com.founder.rhip.ncp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NCP_MONITOR")
public class NcpMonitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 0, nullable =false")
    private BigDecimal id;
    @Column(name = "CARDNO", columnDefinition = "VARCHAR2|证件号|, length = 18, nullable = false")
    private String cardno;
    @Column(name = "CARD_TYPE", columnDefinition = "VARCHAR2|证件类型0:身份证|, length = 2, nullable = false")
    private String cardType;
    @Column(name = "PATIENT_ID", columnDefinition = "NUMBER|患者ID|, length = 0, nullable = false")
    private BigDecimal patientId;
    @Column(name = "MONITOR_DATE", columnDefinition = "DATE|监测日期|, length = 0, nullable = false")
    private Date monitorDate;
    @Column(name = "TEMP", columnDefinition = "NUMBER|体温|, length = 4, nullable = false")
    private BigDecimal temp;
    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压|, length = 0, nullable = true")
    private BigDecimal sbp;
    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压|, length = 0, nullable = true")
    private BigDecimal dbp;
    @Column(name = "SYMPTOM_FLAG", columnDefinition = "NUMBER|症状标记|, length = 1, nullable = true")
    private Integer symptomFlag;
    @Column(name = "OTHER_INSPECT", columnDefinition = "VARCHAR2|其他检查|, length = 18, nullable = true")
    private String otherInspect;
    @Column(name = "HEALTH_ASSESSMENT", columnDefinition = "NUMBER|健康评价(1:有异常 0:无异常)|, length = 1, nullable = false")
    private Integer healthAssessment;
    @Column(name = "HEALTH_ASSESSMENT_DESC", columnDefinition = "VARCHAR2|健康评价异常描述|, length = 20, nullable = true")
    private String healthAssessmentDesc;
    @Column(name = "HEALTH_GUIDANCE", columnDefinition = "VARCHAR2|健康指导|, length = 30, nullable = true")
    private String healthGuidance;
    @Column(name = "HEALTH_GUIDANCE_DESC", columnDefinition = "VARCHAR2|健康指导描述|20, length = 1, nullable = true")
    private String healthGuidanceDesc;
    @Column(name = "REFERRAL", columnDefinition = "NUMBER|是否转诊|, length = 1, nullable = false")
    private Integer referral;
    @Column(name = "REFERRAL_ORG", columnDefinition = "VARCHAR2|转诊机构|, length = 20, nullable = true")
    private String referralOrg;
    @Column(name = "REFERRAL_DEPT", columnDefinition = "VARCHAR2|转诊科室|, length = 20, nullable = true")
    private String referralDept;
    @Column(name = "REFERRAL_DOCTOR", columnDefinition = "VARCHAR2|转诊医生|, length = 20, nullable = true")
    private String referralDoctor;
    @Column(name = "REFERRAL_DATE", columnDefinition = "DATE|转诊日期|, length = 0, nullable = true")
    private Date referralDate;
    @Column(name = "REFERRAL_REASON", columnDefinition = "VARCHAR2|转诊原因|, length = 20, nullable = true")
    private String referralReason;
    @Column(name = "MONITOR_ORG", columnDefinition = "VARCHAR2|监测机构|, length = 10, nullable = true")
    private String monitorOrg;
    @Column(name = "MONITOR_DOCTOR", columnDefinition = "VARCHAR2|监测医生|, length = 10, nullable = true")
    private String monitorDoctor;
    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间|, length = 0, nullable = false")
    private Date createTime;
    @Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间|, length = 0, nullable = true")
    private Date updateTime;
    @Column(name = "CREATE_ID", columnDefinition = "VARCHAR2|创建ID|, length = 20, nullable = true")
    private String createId;
    @Column(name = "PLAN_ID", columnDefinition = "NUMBER|监测计划ID|, length = 0, nullable = false")
    private BigDecimal planId;
    @Column(name = "TYPE", columnDefinition = "NUMBER|1:监测 2:随访3:复查|, length = 0, nullable = false")
    private BigDecimal type;

    @Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|随访医生|, length = 20, nullable = true")
    private String doctorName;

    @Column(name = "NEXT_MONITOR_DATE", columnDefinition = "DATE|下次随访日期|, length = 0, nullable = false")
    private Date nextMonitorDate;

    @Transient
    private String editFlag;//随访修改标志 edit为修改

    @Transient
    private String planType;//1:计划内 2:计划外

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(String editFlag) {
        this.editFlag = editFlag;
    }

    public Date getNextMonitorDate() {
        return nextMonitorDate;
    }

    public void setNextMonitorDate(Date nextMonitorDate) {
        this.nextMonitorDate = nextMonitorDate;
    }

    @Transient
    NcpReexaminationItem reexmItem;

    public NcpReexaminationItem getReexmItem() {
        return reexmItem;
    }

    public void setReexmItem(NcpReexaminationItem reexmItem) {
        this.reexmItem = reexmItem;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    private List<String> curSymptom;//症状

    private String symptioms;//症状编码逗号分隔

    public String getSymptioms() {
        return symptioms;
    }

    public void setSymptioms(String symptioms) {
        this.symptioms = symptioms;
    }

    public List<String> getCurSymptom() {
        return curSymptom;
    }

    public void setCurSymptom(List<String> curSymptom) {
        this.curSymptom = curSymptom;
    }

    public void setId(BigDecimal id){
        this.id=id;
    }
    public BigDecimal getId(){
        return id;
    }
    public void setCardno(String cardno){
        this.cardno=cardno;
    }
    public String getCardno(){
        return cardno;
    }
    public void setCardType(String cardType){
        this.cardType=cardType;
    }
    public String getCardType(){
        return cardType;
    }
    public void setPatientId(BigDecimal patientId){
        this.patientId=patientId;
    }
    public BigDecimal getPatientId(){
        return patientId;
    }
    public void setMonitorDate(Date monitorDate){
        this.monitorDate=monitorDate;
    }
    public Date getMonitorDate(){
        return monitorDate;
    }
    public void setTemp(BigDecimal temp){
        this.temp=temp;
    }
    public BigDecimal getTemp(){
        return temp;
    }
    public void setSbp(BigDecimal sbp){
        this.sbp=sbp;
    }
    public BigDecimal getSbp(){
        return sbp;
    }
    public void setDbp(BigDecimal dbp){
        this.dbp=dbp;
    }
    public BigDecimal getDbp(){
        return dbp;
    }
    public void setSymptomFlag(Integer symptomFlag){
        this.symptomFlag=symptomFlag;
    }
    public Integer getSymptomFlag(){
        return symptomFlag;
    }
    public void setOtherInspect(String otherInspect){
        this.otherInspect=otherInspect;
    }
    public String getOtherInspect(){
        return otherInspect;
    }
    public void setHealthAssessment(Integer healthAssessment){
        this.healthAssessment=healthAssessment;
    }
    public Integer getHealthAssessment(){
        return healthAssessment;
    }
    public void setHealthAssessmentDesc(String healthAssessmentDesc){
        this.healthAssessmentDesc=healthAssessmentDesc;
    }
    public String getHealthAssessmentDesc(){
        return healthAssessmentDesc;
    }
    public void setHealthGuidance(String healthGuidance){
        this.healthGuidance=healthGuidance;
    }
    public String getHealthGuidance(){
        return healthGuidance;
    }

    public String getHealthGuidanceDesc() {
        return healthGuidanceDesc;
    }

    public void setHealthGuidanceDesc(String healthGuidanceDesc) {
        this.healthGuidanceDesc = healthGuidanceDesc;
    }

    public void setReferral(Integer referral){
        this.referral=referral;
    }
    public Integer getReferral(){
        return referral;
    }
    public void setReferralOrg(String referralOrg){
        this.referralOrg=referralOrg;
    }
    public String getReferralOrg(){
        return referralOrg;
    }
    public void setReferralDept(String referralDept){
        this.referralDept=referralDept;
    }
    public String getReferralDept(){
        return referralDept;
    }
    public void setReferralDoctor(String referralDoctor){
        this.referralDoctor=referralDoctor;
    }
    public String getReferralDoctor(){
        return referralDoctor;
    }
    public void setReferralDate(Date referralDate){
        this.referralDate=referralDate;
    }
    public Date getReferralDate(){
        return referralDate;
    }
    public void setReferralReason(String referralReason){
        this.referralReason=referralReason;
    }
    public String getReferralReason(){
        return referralReason;
    }

    public String getMonitorOrg() {
        return monitorOrg;
    }

    public void setMonitorOrg(String monitorOrg) {
        this.monitorOrg = monitorOrg;
    }

    public String getMonitorDoctor() {
        return monitorDoctor;
    }

    public void setMonitorDoctor(String monitorDoctor) {
        this.monitorDoctor = monitorDoctor;
    }

    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime=updateTime;
    }
    public Date getUpdateTime(){
        return updateTime;
    }
    public void setCreateId(String createId){
        this.createId=createId;
    }
    public String getCreateId(){
        return createId;
    }
    public void setPlanId(BigDecimal planId){
        this.planId=planId;
    }
    public BigDecimal getPlanId(){
        return planId;
    }
    public void setType(BigDecimal type){
        this.type=type;
    }
    public BigDecimal getType(){
        return type;
    }
}
