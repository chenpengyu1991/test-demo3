package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

/**
 * 传染源、传播途径
 */
@Entity
@Table(name = "IDM_INFECTION_SOURCE_ROUTE")
public class InfectionSourceRoute implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "OUT_CONTACT_LEVEL", columnDefinition = "VARCHAR2|外出接触程度|2|", length = 2, nullable = true)
	private String outContactLevel;

	@Column(name = "LIVESTOCK_CONTACT_HISTORY", columnDefinition = "VARCHAR2|病前七日内禽畜接触史|2|", length = 2, nullable = true)
	private String livestockContactHistory;

	@Column(name = "LIVESTOCK_CONTACT_ADDR", columnDefinition = "VARCHAR2|病前七日内禽畜接地点|100|", length = 100, nullable = true)
	private String livestockContactAddr;

	@Column(name = "LIVESTOCK_CONTACT_ANIMAL", columnDefinition = "VARCHAR2|病前七日内禽畜接动物名称|100|", length = 100, nullable = true)
	private String livestockContactAnimal;

	@Column(name = "LIVESTOCK_CONTACT_WAY", columnDefinition = "VARCHAR2|病前七日内禽畜接方式|100|", length = 100, nullable = true)
	private String livestockContactWay;

	@Column(name = "LIVESTOCK_CONTACT_RATE", columnDefinition = "VARCHAR2|病前七日内禽畜接频率|2|", length = 2, nullable = true)
	private String livestockContactRate;

	@Column(name = "LIVESTOCK_HEALTH_CONDITION", columnDefinition = "VARCHAR2|病前七日内禽畜接动物健康状况|2|", length = 2, nullable = true)
	private String livestockHealthCondition;

	@Column(name = "TRANSMISSION_ROUTE", columnDefinition = "VARCHAR2|是否有传播途径|2|", length = 2, nullable = true)
	private String transmissionRoute;

	@Column(name = "LIVE_TOGETHER", columnDefinition = "VARCHAR2|与病人共处一室|2|", length = 2, nullable = true)
	private String liveTogether;

	@Column(name = "CLOSER_CONTACT", columnDefinition = "VARCHAR2|与病人有较近接触|2|", length = 2, nullable = true)
	private String closerContact;

	@Column(name = "SHARE_UTENSILS", columnDefinition = "VARCHAR2|与病人共用食具茶具毛巾玩具等|2|", length = 2, nullable = true)
	private String shareUtensils;

	@Column(name = "DISCHARGE_EXCREMENT", columnDefinition = "VARCHAR2|接触动物分泌物排泄物羽毛等|2|", length = 2, nullable = true)
	private String dischargeExcrement;

	@Column(name = "PROPAGATING_SOURCE", columnDefinition = "VARCHAR2|可能传播源|100|", length = 100, nullable = true)
	private String propagatingSource;

	@Column(name = "TRANSMISSION_ROUTE_DETAIL", columnDefinition = "VARCHAR2|可能传播途径|100|", length = 100, nullable = true)
	private String transmissionRouteDetail;

	@Column(name = "SAME_DISEASE", columnDefinition = "VARCHAR2|本地是否有同样疾病的发生|2|", length = 2, nullable = true)
	private String sameDisease;

	@Column(name = "OUT_HISTORY", columnDefinition = "VARCHAR2|外出史|2|", length = 2, nullable = true)
	private String outHistory;

	@Column(name = "OUT_ADDR", columnDefinition = "VARCHAR2|外出何地|100|", length = 100, nullable = true)
	private String outAddr;

	@Column(name = "OUT_SAME_DISEASE_DT", columnDefinition = "DATE|本地同样疾病的发生时间||", nullable = true)
	private Date outSameDiseaseDt;

	@Column(name = "OUT_SAME_DISEASE", columnDefinition = "VARCHAR2|该地是否有同样疾病|2|", length = 2, nullable = true)
	private String outSameDisease;

	@Column(name = "OUT_BACK_FOOD", columnDefinition = "VARCHAR2|是否在该地住宿、用膳、带回水产品等食物|2|", length = 2, nullable = true)
	private String outBackFood;

	@Column(name = "OUT_BACK_FOOD_NAME", columnDefinition = "VARCHAR2|食物名称|100|", length = 100, nullable = true)
	private String outBackFoodName;

	@Column(name = "STRANGER", columnDefinition = "VARCHAR2|有无外人来家|2|", length = 2, nullable = true)
	private String stranger;

	@Column(name = "STRANGER_FROM_ADDR", columnDefinition = "VARCHAR2|来自何地|100|", length = 100, nullable = true)
	private String strangerFromAddr;

	@Column(name = "STRANGER_SAME_DISEASE", columnDefinition = "VARCHAR2|该人是否有同样疾病|2|", length = 2, nullable = true)
	private String strangerSameDisease;

	@Column(name = "STRANGER_SAME_DISEASE_DT", columnDefinition = "DATE|该人发病时间||", nullable = true)
	private Date strangerSameDiseaseDt;

	@Column(name = "CONTACT_SIMILER_PATIENT", columnDefinition = "VARCHAR2|接触过类似病人|2|", length = 2, nullable = true)
	private String contactSimilerPatient;

	@Column(name = "CONTACT_SIMILER_PATIENT_DT", columnDefinition = "DATE|接触过类似病人时间||", nullable = true)
	private Date contactSimilerPatientDt;

	@Column(name = "CONTACT_SIMILER_PATIENT_ADDR", columnDefinition = "VARCHAR2|接触过类似病人地点|100|", length = 100, nullable = true)
	private String contactSimilerPatientAddr;

	@Column(name = "CONTACT_SIMILER_PATIENT_WAY", columnDefinition = "VARCHAR2|接触过类似病人方式|100|", length = 100, nullable = true)
	private String contactSimilerPatientWay;

	@Column(name = "DINER", columnDefinition = "VARCHAR2|在该地有无下列活动-用餐|2|", length = 2, nullable = true)
	private String diner;

	@Column(name = "BACK_FOOD", columnDefinition = "VARCHAR2|在该地有无下列活动-带回食品|2|", length = 2, nullable = true)
	private String backFood;

	@Column(name = "FOOD_NAME", columnDefinition = "VARCHAR2|在该地有无下列活动-食品名称|2|", length = 2, nullable = true)
	private String foodName;

	@Column(name = "STRANGER_LIVE", columnDefinition = "VARCHAR2|外人来家-在家住宿|2|", length = 2, nullable = true)
	private String strangerLive;

	@Column(name = "STRANGER_DINER", columnDefinition = "VARCHAR2|外人来家-在家用餐|2|", length = 2, nullable = true)
	private String strangerDiner;

	@Column(name = "STRANGER_BACK_FOOD", columnDefinition = "VARCHAR2|外人来家-带来食品|2|", length = 2, nullable = true)
	private String strangerBackFood;

	@Column(name = "STRANGER_FOOD_NAME", columnDefinition = "VARCHAR2|外人来家-食品名称|100|", length = 100, nullable = true)
	private String strangerFoodName;

	@Column(name = "SHARE_DINER", columnDefinition = "VARCHAR2|接触过同样病人-同吃|2|", length = 2, nullable = true)
	private String shareDiner;

	@Column(name = "SHARE_LIVER", columnDefinition = "VARCHAR2|接触过同样病人-同住|2|", length = 2, nullable = true)
	private String shareLiver;

	@Column(name = "SHARE_NURSE", columnDefinition = "VARCHAR2|接触过同样病人-护理|2|", length = 2, nullable = true)
	private String shareNurse;

	@Column(name = "SHARE_OTHER", columnDefinition = "VARCHAR2|接触过同样病人-其他|2|", length = 2, nullable = true)
	private String shareOther;

	@Column(name = "ANIMAL_CATEGORY", columnDefinition = "VARCHAR2|动物种类|2|", length = 2, nullable = true)
	private String animalCategory;

	@Column(name = "ANIMAL_SOURCE", columnDefinition = "VARCHAR2|伤人动物来源|2|", length = 2, nullable = true)
	private String animalSource;

	@Column(name = "ANIMAL_OTHER", columnDefinition = "VARCHAR2|伤人动物其他|100|", length = 100, nullable = true)
	private String animalOther;

	@Column(name = "HYDROPHOBIA_VACCINE", columnDefinition = "VARCHAR2|若为家养动物，是否接种兽用狂犬病疫苗|2|", length = 2, nullable = true)
	private String hydrophobiaVaccine;

	@Column(name = "HYDROPHOBIA_VACCINE_DT", columnDefinition = "DATE|接种兽用狂犬病疫苗日期||", nullable = true)
	private Date hydrophobiaVaccineDt;

	@Column(name = "WOUND_CAUSE", columnDefinition = "VARCHAR2|动物伤人原因|2|", length = 2, nullable = true)
	private String woundCause;

	@Column(name = "WOUND_CAUSE_OTHER", columnDefinition = "VARCHAR2|动物伤人原因其他|100|", length = 100, nullable = true)
	private String woundCauseOther;

	@Column(name = "MEANWHILE_BITE_MANY", columnDefinition = "VARCHAR2|是否同时咬伤多人|2|", length = 2, nullable = true)
	private String meanwhileBiteMany;

	@Column(name = "AFTER_WOUNDING", columnDefinition = "VARCHAR2|伤人后|2|", length = 2, nullable = true)
	private String afterWounding;

	@Column(name = "AFTER_WOUNDING_OTHER", columnDefinition = "VARCHAR2|伤人后其他|100|", length = 100, nullable = true)
	private String afterWoundingOther;

	@Column(name = "AFTER_WOUNDING_DIE_DT", columnDefinition = "DATE|伤人后死亡时间||", nullable = true)
	private Date afterWoundingDieDt;

	@Column(name = "AFTER_DEATH_WAY", columnDefinition = "VARCHAR2|动物死后处理方式|2|", length = 2, nullable = true)
	private String afterDeathWay;

	@Column(name = "AFTER_DEATH_WAY_OTHER", columnDefinition = "VARCHAR2|动物死后处理方式其他|100|", length = 100, nullable = true)
	private String afterDeathWayOther;

	@Column(name = "BITE_TOTAL", columnDefinition = "VARCHAR2|一犬共伤人数|20|", length = 20, nullable = true)
	private String biteTotal;

	@Column(name = "WHAT_BITE", columnDefinition = "VARCHAR2|本例为第几例|20|", length = 20, nullable = true)
	private String whatBite;

	@Column(name = "DIE_TOTAL", columnDefinition = "VARCHAR2|共死亡人数|20|", length = 20, nullable = true)
	private String dieTotal;

	@Column(name = "HOME_ACTIVITY", columnDefinition = "VARCHAR2|有无在家住宿、用膳、带回水产品、其他食物|2|", length = 2, nullable = true)
	private String homeActivity;

	@Column(name = "STRANGER_ADDR_SAME_DISEASE", columnDefinition = "VARCHAR2|外来人员来访地有无本病|2|", length = 2, nullable = true)
	private String strangerAddrSameDisease;

	@Column(name = "ANIMAL_CATEGORY_OTHER", columnDefinition = "VARCHAR2|动物种类-其他|100|", length = 100, nullable = true)
	private String animalCategoryOther;

	@Column(name = "LIVE", columnDefinition = "VARCHAR2|在该地有无下列活动-用餐|2|", length = 2, nullable = true)
	private String live;

    @Column(name = "OUT_PROVINCE", columnDefinition = "VARCHAR2|外出何地－省|100|", length = 100, nullable = true)
    private String outProvince;

    @Column(name = "OUT_CITY", columnDefinition = "VARCHAR2|外出何地－市|100|", length = 100, nullable = true)
    private String outCity;

    @Column(name = "OUT_COUNTY", columnDefinition = "VARCHAR2|外出何地－县|100|", length = 100, nullable = true)
    private String outCounty;

    @Column(name = "OUT_TOWN_SHIP", columnDefinition = "VARCHAR2|外出何地－乡|100|", length = 100, nullable = true)
    private String outTownShip;

    @Column(name = "OUT_VILLAGE", columnDefinition = "VARCHAR2|外出何地－村|100|", length = 100, nullable = true)
    private String outVillage;

    @Column(name = "OUT_INFECTED_AREA", columnDefinition = "VARCHAR2|外出的是否是疫区|2|", length = 2, nullable = true)
    private String outInfectedArea;

    @Column(name = "OUT_DAYS", columnDefinition = "VARCHAR2|外出天数|20|", length = 20, nullable = true)
    private String outDays;

    @Column(name = "OUT_PREVENT_FACILITY", columnDefinition = "VARCHAR2|防蚊设施|2|", length = 2, nullable = true)
    private String outPreventFacility;

    @Column(name = "STRANGER_FROM_PROVINCE", columnDefinition = "VARCHAR2|来自何地－省|100|", length = 100, nullable = true)
    private String strangerFromProvince;

    @Column(name = "STRANGER_FROM_CITY", columnDefinition = "VARCHAR2|来自何地－市|100|", length = 100, nullable = true)
    private String strangerFromCity;

    @Column(name = "STRANGER_FROM_COUNTY", columnDefinition = "VARCHAR2|来自何地－县|100|", length = 100, nullable = true)
    private String strangerFromCunty;

    @Column(name = "STRANGER_FROM_TOWN_SHIP", columnDefinition = "VARCHAR2|来自何地－乡|100|", length = 100, nullable = true)
    private String strangerFromTownShip;

    @Column(name = "STRANGER_FROM_VILLAGE", columnDefinition = "VARCHAR2|来自何地－村|100|", length = 100, nullable = true)
    private String strangerFromVillage;

    @Column(name = "STRANGER_FROM_INFECTED_AREA", columnDefinition = "VARCHAR2|外人来自疫区|2|", length = 2, nullable = true)
    private String strangerFromInfectedArea;

    @Column(name = "STRANGER_FROM_DAYS", columnDefinition = "VARCHAR2|外人来天数|20|", length = 20, nullable = true)
    private String strangerFromDays;

    @Column(name = "STRANGER_FROM_FEVER", columnDefinition = "VARCHAR2|外来人是否发热|2|", length = 2, nullable = true)
    private String strangerFromFever;

    @Column(name = "STRANGER_FROM_PLASMODIUM", columnDefinition = "VARCHAR2|外来人虐原虫|2|", length = 2, nullable = true)
    private String strangerFromPlasmodium;

    @Column(name = "FAMILY_FEVER", columnDefinition = "VARCHAR2|患者家庭成员发热|2|", length = 2, nullable = true)
    private String familyFever;

    @Column(name = "FEVER_PLASMODIUM", columnDefinition = "VARCHAR2|发热是否虐原虫|2|", length = 2, nullable = true)
    private String feverPlasmodium;

    @Column(name = "TRANS_FUSION_HISTORY", columnDefinition = "VARCHAR2|患者输血史|2|", length = 2, nullable = true)
    private String transFusionHistory;

    @Column(name = "THIS_TYPE", columnDefinition = "VARCHAR2|本次发病感染分类|2|", length = 2, nullable = true)
    private String thisType;
//布病
	@Column(name = "ANIMALS_KIND", columnDefinition = "VARCHAR2|畜别|100|", length = 100, nullable = true)
	private String animalsKind;
	@Column(name = "IS_FEED", columnDefinition = "VARCHAR2|饲养放牧|2|", length = 2, nullable = true)
	private String isFeed;
	@Column(name = "ANIMALS_KILL", columnDefinition = "VARCHAR2|屠宰|2|", length = 2, nullable = true)
	private String animalsKill;
	@Column(name = "ANIMALS_PZ", columnDefinition = "VARCHAR2|配种员|2|", length = 2, nullable = true)
	private String animalsPz;
	@Column(name = "ANIMALS_DOC", columnDefinition = "VARCHAR2|兽医|2|", length = 2, nullable = true)
	private String animalsDoc;
	@Column(name = "BB_OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String bbOther;
	
	@Column(name = "HAVE_FOOD_ADDR", columnDefinition = "VARCHAR2|食物来源（或食用地点）|100|", length = 100, nullable = true)
	private String haveFoodAddr;
	
	@Column(name = "HAVE_FOOD_DT", columnDefinition = "DATE|食用日期||", nullable = true)
	private Date haveFoodDt;

	
    @Transient
    private String contactSimilerPatientHour;//接触时间-小时
    
	public String getHaveFoodAddr() {
		return haveFoodAddr;
	}

	public void setHaveFoodAddr(String haveFoodAddr) {
		this.haveFoodAddr = haveFoodAddr;
	}

	public Date getHaveFoodDt() {
		return haveFoodDt;
	}

	public void setHaveFoodDt(Date haveFoodDt) {
		this.haveFoodDt = haveFoodDt;
	}

	public String getAnimalsKind() {
		return animalsKind;
	}

	public void setAnimalsKind(String animalsKind) {
		this.animalsKind = animalsKind;
	}

	public String getIsFeed() {
		return isFeed;
	}

	public void setIsFeed(String isFeed) {
		this.isFeed = isFeed;
	}

	public String getAnimalsKill() {
		return animalsKill;
	}

	public void setAnimalsKill(String animalsKill) {
		this.animalsKill = animalsKill;
	}

	public String getAnimalsPz() {
		return animalsPz;
	}

	public void setAnimalsPz(String animalsPz) {
		this.animalsPz = animalsPz;
	}

	public String getAnimalsDoc() {
		return animalsDoc;
	}

	public void setAnimalsDoc(String animalsDoc) {
		this.animalsDoc = animalsDoc;
	}

	public String getBbOther() {
		return bbOther;
	}

	public void setBbOther(String bbOther) {
		this.bbOther = bbOther;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getOutContactLevel() {
		return this.outContactLevel;
	}

	public void setOutContactLevel(String outContactLevel) {
		this.outContactLevel = outContactLevel;
	}

	public String getLivestockContactHistory() {
		return this.livestockContactHistory;
	}

	public void setLivestockContactHistory(String livestockContactHistory) {
		this.livestockContactHistory = livestockContactHistory;
	}

	public String getLivestockContactAddr() {
		return this.livestockContactAddr;
	}

	public void setLivestockContactAddr(String livestockContactAddr) {
		this.livestockContactAddr = livestockContactAddr;
	}

	public String getLivestockContactAnimal() {
		return this.livestockContactAnimal;
	}

	public void setLivestockContactAnimal(String livestockContactAnimal) {
		this.livestockContactAnimal = livestockContactAnimal;
	}

	public String getLivestockContactWay() {
		return this.livestockContactWay;
	}

	public void setLivestockContactWay(String livestockContactWay) {
		this.livestockContactWay = livestockContactWay;
	}

	public String getLivestockContactRate() {
		return this.livestockContactRate;
	}

	public void setLivestockContactRate(String livestockContactRate) {
		this.livestockContactRate = livestockContactRate;
	}

	public String getLivestockHealthCondition() {
		return this.livestockHealthCondition;
	}

	public void setLivestockHealthCondition(String livestockHealthCondition) {
		this.livestockHealthCondition = livestockHealthCondition;
	}

	public String getTransmissionRoute() {
		return this.transmissionRoute;
	}

	public void setTransmissionRoute(String transmissionRoute) {
		this.transmissionRoute = transmissionRoute;
	}

	public String getLiveTogether() {
		return this.liveTogether;
	}

	public void setLiveTogether(String liveTogether) {
		this.liveTogether = liveTogether;
	}

	public String getCloserContact() {
		return this.closerContact;
	}

	public void setCloserContact(String closerContact) {
		this.closerContact = closerContact;
	}

	public String getShareUtensils() {
		return this.shareUtensils;
	}

	public void setShareUtensils(String shareUtensils) {
		this.shareUtensils = shareUtensils;
	}

	public String getDischargeExcrement() {
		return this.dischargeExcrement;
	}

	public void setDischargeExcrement(String dischargeExcrement) {
		this.dischargeExcrement = dischargeExcrement;
	}

	public String getPropagatingSource() {
		return this.propagatingSource;
	}

	public void setPropagatingSource(String propagatingSource) {
		this.propagatingSource = propagatingSource;
	}

	public String getTransmissionRouteDetail() {
		return this.transmissionRouteDetail;
	}

	public void setTransmissionRouteDetail(String transmissionRouteDetail) {
		this.transmissionRouteDetail = transmissionRouteDetail;
	}

	public String getSameDisease() {
		return this.sameDisease;
	}

	public void setSameDisease(String sameDisease) {
		this.sameDisease = sameDisease;
	}

	public String getOutHistory() {
		return this.outHistory;
	}

	public void setOutHistory(String outHistory) {
		this.outHistory = outHistory;
	}

	public String getOutAddr() {
		return this.outAddr;
	}

	public void setOutAddr(String outAddr) {
		this.outAddr = outAddr;
	}

	public Date getOutSameDiseaseDt() {
		return this.outSameDiseaseDt;
	}

	public void setOutSameDiseaseDt(Date outSameDiseaseDt) {
		this.outSameDiseaseDt = outSameDiseaseDt;
	}

	public String getOutSameDisease() {
		return this.outSameDisease;
	}

	public void setOutSameDisease(String outSameDisease) {
		this.outSameDisease = outSameDisease;
	}

	public String getOutBackFood() {
		return this.outBackFood;
	}

	public void setOutBackFood(String outBackFood) {
		this.outBackFood = outBackFood;
	}

	public String getOutBackFoodName() {
		return this.outBackFoodName;
	}

	public void setOutBackFoodName(String outBackFoodName) {
		this.outBackFoodName = outBackFoodName;
	}

	public String getStranger() {
		return this.stranger;
	}

	public void setStranger(String stranger) {
		this.stranger = stranger;
	}

	public String getStrangerFromAddr() {
		return this.strangerFromAddr;
	}

	public void setStrangerFromAddr(String strangerFromAddr) {
		this.strangerFromAddr = strangerFromAddr;
	}

	public String getStrangerSameDisease() {
		return this.strangerSameDisease;
	}

	public void setStrangerSameDisease(String strangerSameDisease) {
		this.strangerSameDisease = strangerSameDisease;
	}

	public Date getStrangerSameDiseaseDt() {
		return this.strangerSameDiseaseDt;
	}

	public void setStrangerSameDiseaseDt(Date strangerSameDiseaseDt) {
		this.strangerSameDiseaseDt = strangerSameDiseaseDt;
	}

	public String getContactSimilerPatient() {
		return this.contactSimilerPatient;
	}

	public void setContactSimilerPatient(String contactSimilerPatient) {
		this.contactSimilerPatient = contactSimilerPatient;
	}

	public Date getContactSimilerPatientDt() {
		return this.contactSimilerPatientDt;
	}

	public void setContactSimilerPatientDt(Date contactSimilerPatientDt) {
		this.contactSimilerPatientDt = contactSimilerPatientDt;
	}

	public String getContactSimilerPatientAddr() {
		return this.contactSimilerPatientAddr;
	}

	public void setContactSimilerPatientAddr(String contactSimilerPatientAddr) {
		this.contactSimilerPatientAddr = contactSimilerPatientAddr;
	}

	public String getContactSimilerPatientWay() {
		return this.contactSimilerPatientWay;
	}

	public void setContactSimilerPatientWay(String contactSimilerPatientWay) {
		this.contactSimilerPatientWay = contactSimilerPatientWay;
	}

	public String getDiner() {
		return this.diner;
	}

	public void setDiner(String diner) {
		this.diner = diner;
	}

	public String getBackFood() {
		return this.backFood;
	}

	public void setBackFood(String backFood) {
		this.backFood = backFood;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getStrangerLive() {
		return this.strangerLive;
	}

	public void setStrangerLive(String strangerLive) {
		this.strangerLive = strangerLive;
	}

	public String getStrangerDiner() {
		return this.strangerDiner;
	}

	public void setStrangerDiner(String strangerDiner) {
		this.strangerDiner = strangerDiner;
	}

	public String getStrangerBackFood() {
		return this.strangerBackFood;
	}

	public void setStrangerBackFood(String strangerBackFood) {
		this.strangerBackFood = strangerBackFood;
	}

	public String getStrangerFoodName() {
		return this.strangerFoodName;
	}

	public void setStrangerFoodName(String strangerFoodName) {
		this.strangerFoodName = strangerFoodName;
	}

	public String getShareDiner() {
		return this.shareDiner;
	}

	public void setShareDiner(String shareDiner) {
		this.shareDiner = shareDiner;
	}

	public String getShareLiver() {
		return this.shareLiver;
	}

	public void setShareLiver(String shareLiver) {
		this.shareLiver = shareLiver;
	}

	public String getShareNurse() {
		return this.shareNurse;
	}

	public void setShareNurse(String shareNurse) {
		this.shareNurse = shareNurse;
	}

	public String getShareOther() {
		return this.shareOther;
	}

	public void setShareOther(String shareOther) {
		this.shareOther = shareOther;
	}

	public String getAnimalCategory() {
		return this.animalCategory;
	}

	public void setAnimalCategory(String animalCategory) {
		this.animalCategory = animalCategory;
	}

	public String getAnimalSource() {
		return this.animalSource;
	}

	public void setAnimalSource(String animalSource) {
		this.animalSource = animalSource;
	}

	public String getAnimalOther() {
		return this.animalOther;
	}

	public void setAnimalOther(String animalOther) {
		this.animalOther = animalOther;
	}

	public String getHydrophobiaVaccine() {
		return this.hydrophobiaVaccine;
	}

	public void setHydrophobiaVaccine(String hydrophobiaVaccine) {
		this.hydrophobiaVaccine = hydrophobiaVaccine;
	}

	public Date getHydrophobiaVaccineDt() {
		return this.hydrophobiaVaccineDt;
	}

	public void setHydrophobiaVaccineDt(Date hydrophobiaVaccineDt) {
		this.hydrophobiaVaccineDt = hydrophobiaVaccineDt;
	}

	public String getWoundCause() {
		return this.woundCause;
	}

	public void setWoundCause(String woundCause) {
		this.woundCause = woundCause;
	}

	public String getWoundCauseOther() {
		return this.woundCauseOther;
	}

	public void setWoundCauseOther(String woundCauseOther) {
		this.woundCauseOther = woundCauseOther;
	}

	public String getMeanwhileBiteMany() {
		return this.meanwhileBiteMany;
	}

	public void setMeanwhileBiteMany(String meanwhileBiteMany) {
		this.meanwhileBiteMany = meanwhileBiteMany;
	}

	public String getAfterWounding() {
		return this.afterWounding;
	}

	public void setAfterWounding(String afterWounding) {
		this.afterWounding = afterWounding;
	}

	public String getAfterWoundingOther() {
		return this.afterWoundingOther;
	}

	public void setAfterWoundingOther(String afterWoundingOther) {
		this.afterWoundingOther = afterWoundingOther;
	}

	public Date getAfterWoundingDieDt() {
		return this.afterWoundingDieDt;
	}

	public void setAfterWoundingDieDt(Date afterWoundingDieDt) {
		this.afterWoundingDieDt = afterWoundingDieDt;
	}

	public String getAfterDeathWay() {
		return this.afterDeathWay;
	}

	public void setAfterDeathWay(String afterDeathWay) {
		this.afterDeathWay = afterDeathWay;
	}

	public String getAfterDeathWayOther() {
		return this.afterDeathWayOther;
	}

	public void setAfterDeathWayOther(String afterDeathWayOther) {
		this.afterDeathWayOther = afterDeathWayOther;
	}

	public String getBiteTotal() {
		return this.biteTotal;
	}

	public void setBiteTotal(String biteTotal) {
		this.biteTotal = biteTotal;
	}

	public String getWhatBite() {
		return this.whatBite;
	}

	public void setWhatBite(String whatBite) {
		this.whatBite = whatBite;
	}

	public String getDieTotal() {
		return this.dieTotal;
	}

	public void setDieTotal(String dieTotal) {
		this.dieTotal = dieTotal;
	}

	public String getHomeActivity() {
		return this.homeActivity;
	}

	public void setHomeActivity(String homeActivity) {
		this.homeActivity = homeActivity;
	}

	public String getStrangerAddrSameDisease() {
		return this.strangerAddrSameDisease;
	}

	public void setStrangerAddrSameDisease(String strangerAddrSameDisease) {
		this.strangerAddrSameDisease = strangerAddrSameDisease;
	}

	public String getAnimalCategoryOther() {
		return this.animalCategoryOther;
	}

	public void setAnimalCategoryOther(String animalCategoryOther) {
		this.animalCategoryOther = animalCategoryOther;
	}

	public String getLive() {
		return this.live;
	}

	public void setLive(String live) {
		this.live = live;
	}

    public String getOutProvince() {
        return this.outProvince;
    }

    public void setOutProvince(String outProvince) {
        this.outProvince = outProvince;
    }

    public String getOutCity() {
        return this.outCity;
    }

    public void setOutCity(String outCity) {
        this.outCity = outCity;
    }

    public String getOutCounty() {
        return this.outCounty;
    }

    public void setOutCounty(String outCounty) {
        this.outCounty = outCounty;
    }

    public String getOutTownShip() {
        return this.outTownShip;
    }

    public void setOutTownShip(String outTownShip) {
        this.outTownShip = outTownShip;
    }

    public String getOutVillage() {
        return this.outVillage;
    }

    public void setOutVillage(String outVillage) {
        this.outVillage = outVillage;
    }

    public String getOutInfectedArea() {
        return this.outInfectedArea;
    }

    public void setOutInfectedArea(String outInfectedArea) {
        this.outInfectedArea = outInfectedArea;
    }

    public String getOutDays() {
        return this.outDays;
    }

    public void setOutDays(String outDays) {
        this.outDays = outDays;
    }

    public String getOutPreventFacility() {
        return this.outPreventFacility;
    }

    public void setOutPreventFacility(String outPreventFacility) {
        this.outPreventFacility = outPreventFacility;
    }

    public String getStrangerFromProvince() {
        return this.strangerFromProvince;
    }

    public void setStrangerFromProvince(String strangerFromProvince) {
        this.strangerFromProvince = strangerFromProvince;
    }

    public String getStrangerFromCity() {
        return this.strangerFromCity;
    }

    public void setStrangerFromCity(String strangerFromCity) {
        this.strangerFromCity = strangerFromCity;
    }

    public String getStrangerFromCunty() {
        return this.strangerFromCunty;
    }

    public void setStrangerFromCunty(String strangerFromCunty) {
        this.strangerFromCunty = strangerFromCunty;
    }

    public String getStrangerFromTownShip() {
        return this.strangerFromTownShip;
    }

    public void setStrangerFromTownShip(String strangerFromTownShip) {
        this.strangerFromTownShip = strangerFromTownShip;
    }

    public String getStrangerFromVillage() {
        return this.strangerFromVillage;
    }

    public void setStrangerFromVillage(String strangerFromVillage) {
        this.strangerFromVillage = strangerFromVillage;
    }

    public String getStrangerFromInfectedArea() {
        return this.strangerFromInfectedArea;
    }

    public void setStrangerFromInfectedArea(String strangerFromInfectedArea) {
        this.strangerFromInfectedArea = strangerFromInfectedArea;
    }

    public String getStrangerFromDays() {
        return this.strangerFromDays;
    }

    public void setStrangerFromDays(String strangerFromDays) {
        this.strangerFromDays = strangerFromDays;
    }

    public String getStrangerFromFever() {
        return this.strangerFromFever;
    }

    public void setStrangerFromFever(String strangerFromFever) {
        this.strangerFromFever = strangerFromFever;
    }

    public String getStrangerFromPlasmodium() {
        return this.strangerFromPlasmodium;
    }

    public void setStrangerFromPlasmodium(String strangerFromPlasmodium) {
        this.strangerFromPlasmodium = strangerFromPlasmodium;
    }

    public String getFamilyFever() {
        return this.familyFever;
    }

    public void setFamilyFever(String familyFever) {
        this.familyFever = familyFever;
    }

    public String getFeverPlasmodium() {
        return this.feverPlasmodium;
    }

    public void setFeverPlasmodium(String feverPlasmodium) {
        this.feverPlasmodium = feverPlasmodium;
    }

    public String getTransFusionHistory() {
        return transFusionHistory;
    }

    public void setTransFusionHistory(String transFusionHistory) {
        this.transFusionHistory = transFusionHistory;
    }

    public String getThisType() {
        return this.thisType;
    }

    public void setThisType(String thisType) {
        this.thisType = thisType;
    }

	public String getContactSimilerPatientHour() {
		return contactSimilerPatientHour;
	}

	public void setContactSimilerPatientHour(String contactSimilerPatientHour) {
		this.contactSimilerPatientHour = contactSimilerPatientHour;
	}
    
}
