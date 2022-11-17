package com.founder.rhip.ehr.entity.control.idm.special;

/**
 * Created by admin on 2017/3/1.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** IDM_LIST_SR
 ID	NUMBER
 VISIT_TIME	DATE
 MONTH_COUNT	LONG(2147483647)
 SUPERVISOR_TYPE	VARCHAR2(5)
 VISIT_TYPE	VARCHAR2(5)
 SYMPTOM	VARCHAR2(5)
 SYMPTOM_OTHER	VARCHAR2(50)
 SMOKE	VARCHAR2(5)
 DRINK	VARCHAR2(5)
 METHOD	VARCHAR2(50)
 USAGE	VARCHAR2(5)
 DRUG_FORM	VARCHAR2(5)
 FORGOT_TIMES	VARCHAR2(5)
 UNTOWARD_EFFECT	VARCHAR2(5)
 EFFECT	VARCHAR2(50)
 COMPLICATION	VARCHAR2(5)
 COMPLICATION_DES	VARCHAR2(50)
 CLIC	VARCHAR2(50)
 SEASON	VARCHAR2(50)
 VISIT_RESULT	VARCHAR2(50)
 ADV	VARCHAR2(50)
 NEXT_VISIT_TIME	DATE
 IDMID	NUMBER
 VISIT_DOCTOR	VARCHAR2(50)
 */
@Entity
@Table(name = "IDM_LIST_SR")
public class ListSr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 0, nullable =true")
    private BigDecimal id;
    @Column(name = "VISIT_TIME", columnDefinition = "DATE|随访时间|, length = 0, nullable = true")
    private Date visitTime;
    @Column(name = "MONTH_COUNT", columnDefinition = "LONG|治疗月次|, length = 2147483647, nullable = true")
    private Long monthCount;
    @Column(name = "SUPERVISOR_TYPE", columnDefinition = "VARCHAR2|督导人员类型|, length = 5, nullable = true")
    private String supervisorType;
    @Column(name = "VISIT_TYPE", columnDefinition = "VARCHAR2|随访方式|, length = 5, nullable = true")
    private String visitType;
    @Column(name = "SYMPTOM", columnDefinition = "VARCHAR2|症状体征|, length = 5, nullable = true")
    private String symptom;
    @Column(name = "SYMPTOM_OTHER", columnDefinition = "VARCHAR2|其他|, length = 50, nullable = true")
    private String symptomOther;
    @Column(name = "SMOKE", columnDefinition = "VARCHAR2|n支、天|, length = 5, nullable = true")
    private String smoke;
    @Column(name = "DRINK", columnDefinition = "VARCHAR2|n两.天|, length = 5, nullable = true")
    private String drink;
    @Column(name = "METHOD", columnDefinition = "VARCHAR2|化疗方案|, length = 50, nullable = true")
    private String method;
    @Column(name = "USAGE", columnDefinition = "VARCHAR2|每日/间歇|, length = 5, nullable = true")
    private String usage;
    @Column(name = "DRUG_FORM", columnDefinition = "VARCHAR2|剂型|, length = 5, nullable = true")
    private String drugForm;
    @Column(name = "FORGOT_TIMES", columnDefinition = "VARCHAR2|漏服药次数|, length = 5, nullable = true")
    private String forgotTimes;
    @Column(name = "UNTOWARD_EFFECT", columnDefinition = "VARCHAR2|有无不良反应|, length = 5, nullable = true")
    private String untowardEffect;
    @Column(name = "EFFECT", columnDefinition = "VARCHAR2|内容|, length = 50, nullable = true")
    private String effect;
    @Column(name = "COMPLICATION", columnDefinition = "VARCHAR2|有无并发症状|, length = 5, nullable = true")
    private String complication;
    @Column(name = "COMPLICATION_DES", columnDefinition = "VARCHAR2|null|, length = 50, nullable = true")
    private String complicationDes;
    @Column(name = "CLIC_NAME", columnDefinition = "VARCHAR2|科室|, length = 50, nullable = true")
    private String clicName;

    @Column(name = "CLIC", columnDefinition = "VARCHAR2|科别|, length = 50, nullable = true")
    private String clic;
    @Column(name = "SEASON", columnDefinition = "VARCHAR2|原因|, length = 50, nullable = true")
    private String season;
    @Column(name = "VISIT_RESULT", columnDefinition = "VARCHAR2|2周内随访，随访结果|, length = 50, nullable = true")
    private String visitResult;
    @Column(name = "ADV", columnDefinition = "VARCHAR2|处理意见|, length = 50, nullable = true")
    private String adv;
    @Column(name = "NEXT_VISIT_TIME", columnDefinition = "DATE|下次随访时间|, length = 0, nullable = true")
    private Date nextVisitTime;
    @Column(name = "IDM_ID", columnDefinition = "NUMBER|idm编号|, length = 0, nullable = true")
    private Long idmId;
    @Column(name = "VISIT_DOCTOR", columnDefinition = "VARCHAR2|随访医生|, length = 50, nullable = true")
    private String visitDoctor;

    @Column(name = "FIRST_VIST", columnDefinition = "VARCHAR2|1：首次随访 ：2非首次随访|, length = 1, nullable = true")
    private String firstVist;
    @Column(name = "TJ_RESULT", columnDefinition = "VARCHAR2|痰菌情况|, length = 2, nullable = true")
    private String tjResult;
    @Column(name = "NY_RESULT", columnDefinition = "VARCHAR2|耐药情况|, length = 2, nullable = true")
    private String nyResult;
    @Column(name = "ROOM", columnDefinition = "VARCHAR2|单独居室|, length = 2, nullable = true")
    private String room;
    @Column(name = "WIND", columnDefinition = "VARCHAR2|通风情况|, length = 2, nullable = true")
    private String wind;
    @Column(name = "DRUG_PLACE", columnDefinition = "VARCHAR2|取药地点|, length = 50, nullable = true")
    private String drugPlace;
    @Column(name = "DRUG_DATE", columnDefinition = "DATE|取药时间|, length = 0, nullable = true")
    private Date drugDate;
    @Column(name = "DRUG_RECORD", columnDefinition = "VARCHAR2|服药记录卡的填写|, length = 2, nullable = true")
    private String drugRecord;
    @Column(name = "DRUG_SAVE", columnDefinition = "VARCHAR2|服药方法及药品存放|, length = 2, nullable = true")
    private String drugSave;
    @Column(name = "DRUG_HARM", columnDefinition = "VARCHAR2|不规律服药危害|, length = 2, nullable = true")
    private String drugHarm;
    @Column(name = "DRUG_UNTOWARD_EFFECT", columnDefinition = "VARCHAR2|不良反应及处理|, length = 2, nullable = true")
    private String drugUntowardEffect;
    @Column(name = "RECHECK", columnDefinition = "VARCHAR2|治疗期间复诊查痰|, length = 2, nullable = true")
    private String recheck;
    @Column(name = "OUTSIDE_KEEP", columnDefinition = "VARCHAR2|外出期间如何坚持服药|, length = 2, nullable = true")
    private String outsideKeep;
    @Column(name = "NOTICE", columnDefinition = "VARCHAR2|生活习惯及注意事项|, length = 2, nullable = true")
    private String notice;
    @Column(name = "CONTACT_CHECK", columnDefinition = "VARCHAR2|密切接触者检查|, length = 2, nullable = true")
    private String contactCheck;
    @Column(name = "PAT_TYPE", columnDefinition = "VARCHAR2|患者类型|, length = 2, nullable = true")
    private String patType;
    @Column(name = "TRE_TUB", columnDefinition = "VARCHAR2|肺结核治疗疗程|, length = 2, nullable = true")
    private String treTub;

    public String getTreTub() {
        return treTub;
    }

    public void setTreTub(String treTub) {
        this.treTub = treTub;
    }

    public String getPatType() {
        return patType;
    }

    public void setPatType(String patType) {
        this.patType = patType;
    }

    public String getFirstVist() {
        return firstVist;
    }

    public void setFirstVist(String firstVist) {
        this.firstVist = firstVist;
    }

    public String getTjResult() {
        return tjResult;
    }

    public void setTjResult(String tjResult) {
        this.tjResult = tjResult;
    }

    public String getNyResult() {
        return nyResult;
    }

    public void setNyResult(String nyResult) {
        this.nyResult = nyResult;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDrugPlace() {
        return drugPlace;
    }

    public void setDrugPlace(String drugPlace) {
        this.drugPlace = drugPlace;
    }

    public Date getDrugDate() {
        return drugDate;
    }

    public void setDrugDate(Date drugDate) {
        this.drugDate = drugDate;
    }

    public String getDrugRecord() {
        return drugRecord;
    }

    public void setDrugRecord(String drugRecord) {
        this.drugRecord = drugRecord;
    }

    public String getDrugSave() {
        return drugSave;
    }

    public void setDrugSave(String drugSave) {
        this.drugSave = drugSave;
    }

    public String getDrugHarm() {
        return drugHarm;
    }

    public void setDrugHarm(String drugHarm) {
        this.drugHarm = drugHarm;
    }

    public String getDrugUntowardEffect() {
        return drugUntowardEffect;
    }

    public void setDrugUntowardEffect(String drugUntowardEffect) {
        this.drugUntowardEffect = drugUntowardEffect;
    }

    public String getRecheck() {
        return recheck;
    }

    public void setRecheck(String recheck) {
        this.recheck = recheck;
    }

    public String getOutsideKeep() {
        return outsideKeep;
    }

    public void setOutsideKeep(String outsideKeep) {
        this.outsideKeep = outsideKeep;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getContactCheck() {
        return contactCheck;
    }

    public void setContactCheck(String contactCheck) {
        this.contactCheck = contactCheck;
    }

    public String getClicName() {
        return clicName;
    }

    public void setClicName(String clicName) {
        this.clicName = clicName;
    }

    public void setId(BigDecimal id){
        this.id=id;
    }
    public BigDecimal getId(){
        return id;
    }
    public void setVisitTime(Date visitTime){
        this.visitTime=visitTime;
    }
    public Date getVisitTime(){
        return visitTime;
    }
    public void setMonthCount(Long monthCount){
        this.monthCount=monthCount;
    }
    public Long getMonthCount(){
        return monthCount;
    }
    public void setSupervisorType(String supervisorType){
        this.supervisorType=supervisorType;
    }
    public String getSupervisorType(){
        return supervisorType;
    }
    public void setVisitType(String visitType){
        this.visitType=visitType;
    }
    public String getVisitType(){
        return visitType;
    }
    public void setSymptom(String symptom){
        this.symptom=symptom;
    }
    public String getSymptom(){
        return symptom;
    }
    public void setSymptomOther(String symptomOther){
        this.symptomOther=symptomOther;
    }
    public String getSymptomOther(){
        return symptomOther;
    }
    public void setSmoke(String smoke){
        this.smoke=smoke;
    }
    public String getSmoke(){
        return smoke;
    }
    public void setDrink(String drink){
        this.drink=drink;
    }
    public String getDrink(){
        return drink;
    }
    public void setMethod(String method){
        this.method=method;
    }
    public String getMethod(){
        return method;
    }
    public void setUsage(String usage){
        this.usage=usage;
    }
    public String getUsage(){
        return usage;
    }
    public void setDrugForm(String drugForm){
        this.drugForm=drugForm;
    }
    public String getDrugForm(){
        return drugForm;
    }
    public void setForgotTimes(String forgotTimes){
        this.forgotTimes=forgotTimes;
    }
    public String getForgotTimes(){
        return forgotTimes;
    }
    public void setUntowardEffect(String untowardEffect){
        this.untowardEffect=untowardEffect;
    }
    public String getUntowardEffect(){
        return untowardEffect;
    }
    public void setEffect(String effect){
        this.effect=effect;
    }
    public String getEffect(){
        return effect;
    }
    public void setComplication(String complication){
        this.complication=complication;
    }
    public String getComplication(){
        return complication;
    }
    public void setComplicationDes(String complicationDes){
        this.complicationDes=complicationDes;
    }
    public String getComplicationDes(){
        return complicationDes;
    }
    public void setClic(String clic){
        this.clic=clic;
    }
    public String getClic(){
        return clic;
    }
    public void setSeason(String season){
        this.season=season;
    }
    public String getSeason(){
        return season;
    }
    public void setVisitResult(String visitResult){
        this.visitResult=visitResult;
    }
    public String getVisitResult(){
        return visitResult;
    }
    public void setAdv(String adv){
        this.adv=adv;
    }
    public String getAdv(){
        return adv;
    }
    public void setNextVisitTime(Date nextVisitTime){
        this.nextVisitTime=nextVisitTime;
    }
    public Date getNextVisitTime(){
        return nextVisitTime;
    }
    public void setIdmId(Long idmId){
        this.idmId=idmId;
    }
    public Long getIdmId(){
        return idmId;
    }
    public void setVisitDoctor(String visitDoctor){
        this.visitDoctor=visitDoctor;
    }
    public String getVisitDoctor(){
        return visitDoctor;
    }
}
