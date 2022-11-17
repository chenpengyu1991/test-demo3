package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 卫生条件
 */
@Entity
@Table(name = "IDM_HYGIENIC_CONDITION")
public class HygienicCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "RES_STATUS", columnDefinition = "VARCHAR2|住宅情况||", length = 2, nullable = true)
	private String resStatus;

	@Column(name = "PER_LIVING_AREA", columnDefinition = "VARCHAR2|家庭人均居住面积|20|", scale = 20, nullable = true)
	private String perLivingArea;

	@Column(name = "VENTILATION", columnDefinition = "VARCHAR2|开窗通风|2|", length = 2, nullable = true)
	private String ventilation;

	@Column(name = "CONDITION_HOURS", columnDefinition = "VARCHAR2|使用空调每天小时数||", length = 20, nullable = true)
	private String conditionHours;

	@Column(name = "AROUND_RES_HEALTH", columnDefinition = "VARCHAR2|住宅周围卫生|2|", length = 2, nullable = true)
	private String aroundResHealth;

	@Column(name = "FARMER_MARKET", columnDefinition = "VARCHAR2|农贸市场|2|", length = 2, nullable = true)
	private String farmerMarket;

	@Column(name = "LIV_BRE_FARMS", columnDefinition = "VARCHAR2|禽畜养殖场|2|", length = 2, nullable = true)
	private String livBreFarms;

	@Column(name = "SPECIES", columnDefinition = "VARCHAR2|禽畜养殖场动物品种||", length = 200, nullable = true)
	private String species;

	@Column(name = "FAMILY_POSITION", columnDefinition = "VARCHAR2|描述病例家庭位置(位置/附近水源等情况)||", length = 200, nullable = true)
	private String familyPosition;

	@Column(name = "CASES_FAMILY", columnDefinition = "VARCHAR2|病例家庭||", length = 2, nullable = true)
	private String casesFamily;

	@Column(name = "PAT_HOUSING_TYPES", columnDefinition = "VARCHAR2|病人家居住房类型||", length = 2, nullable = true)
	private String patHousingTypes;

	@Column(name = "HOUSE_FLOOR_TYPE", columnDefinition = "VARCHAR2|房屋地板类型||", length = 2, nullable = true)
	private String houseFloorType;

	@Column(name = "CLEAN_ROOM_TIME", columnDefinition = "VARCHAR2|多长时间打扫一次房间||", length = 200, nullable = true)
	private String cleanRoomTime;

	@Column(name = "KITCHEN_CUTTING_BOARD", columnDefinition = "VARCHAR2|家中厨房菜板使用||", length = 2, nullable = true)
	private String kitchenCuttingBoard;

	@Column(name = "PROC_RAW_MEAT_AFTER", columnDefinition = "VARCHAR2|若混用菜板，则加工完生肉类后||", length = 2, nullable = true)
	private String procRawMeatAfter;

	@Column(name = "IS_KNOW", columnDefinition = "VARCHAR2|家庭成员的禽流感知识知晓情况||", length = 2, nullable = true)
	private String isKnow;

	@Column(name = "FROM_TYPE", columnDefinition = "VARCHAR2|若明白，则知识来于||", length = 2, nullable = true)
	private String fromType;

	@Column(name = "AN_PAT_REL", columnDefinition = "VARCHAR2|家禽圈位置，描述与病例居住房间关系||", length = 2, nullable = true)
	private String anPatRel;

	@Column(name = "IS_DIE_AN_HN", columnDefinition = "VARCHAR2|农业部门是否证实病死动物死于H5N1型禽流感||", length = 2, nullable = true)
	private String isDieAnHn;

	@Column(name = "IS_DISINFECT_FAMLY", columnDefinition = "VARCHAR2|家庭环境是否进行彻底消毒||", length = 2, nullable = true)
	private String isDisinfectFamly;

	@Column(name = "DISINFECT_FAMLY_DATE", columnDefinition = "DATE|若已经彻底消毒，则时间为||", nullable = true)
	private Date disinfectFamlyDate;

	@Column(name = "WASH", columnDefinition = "VARCHAR2|饭前洗手||", length = 2, nullable = true)
	private String wash;

	@Column(name = "IS_SMOKE", columnDefinition = "VARCHAR2|是否抽烟||", length = 2, nullable = true)
	private String isSmoke;

	@Column(name = "SPLIFF_NUM", columnDefinition = "VARCHAR2|若抽烟，每天几支||", length = 2, nullable = true)
	private String spliffNum;

	@Column(name = "CHRONIC_DISEASE", columnDefinition = "VARCHAR2|是否有慢性疾病|多选|", length = 200, nullable = true)
	private String chronicDisease;

	@Column(name = "TIV", columnDefinition = "VARCHAR2|一年内是否接种流感疫苗||", length = 2, nullable = true)
	private String tiv;

	@Column(name = "TIV_LAST_INOCULATE_DATE", columnDefinition = "DATE|最后一次接种日期||", nullable = true)
	private Date tivLastInoculateDate;

	@Column(name = "IMMUNOGLOBULIN", columnDefinition = "VARCHAR2|是否曾注射免疫球蛋白||", length = 2, nullable = true)
	private String immunoglobulin;

	@Column(name = "IMM_LAST_INOCULATE_DATE", columnDefinition = "DATE|最后一次接种日期||", nullable = true)
	private Date immLastInoculateDate;

	@Column(name = "DRINKING_TYPE", columnDefinition = "VARCHAR2|饮水类型||", length = 2, nullable = true)
	private String drinkingType;
	
	@Column(name = "DRINKING_ADDR", columnDefinition = "VARCHAR2|饮水地点||", length = 100, nullable = true)
	private String drinkingAddr;
	
	@Column(name = "DRINKING_DATE", columnDefinition = "VARCHAR2|饮水日期||",  nullable = true)
	private Date drinkingDate;

	@Column(name = "WATER_TYPE", columnDefinition = "VARCHAR2|用水类型||", length = 2, nullable = true)
	private String waterType;

	@Column(name = "DRINKING_DISINFECTION", columnDefinition = "VARCHAR2|饮水是否消毒||", length = 2, nullable = true)
	private String drinkingDisinfection;

	@Column(name = "WATER_DISINFECTION", columnDefinition = "VARCHAR2|用水是否消毒||", length = 2, nullable = true)
	private String waterDisinfection;

	@Column(name = "TOILET_TYPE", columnDefinition = "VARCHAR2|厕所类型||", length = 2, nullable = true)
	private String toiletType;

	@Column(name = "DROPSY_CONTAINER", columnDefinition = "VARCHAR2|积水容器数|20|", length = 20, nullable = true)
	private String dropsyContainer;

	@Column(name = "POSITIVE_CONTAINER", columnDefinition = "VARCHAR2|阳性容器数|20|", length = 20, nullable = true)
	private String positiveContainer;

	@Column(name = "CONTAINER_TYPE", columnDefinition = "VARCHAR2|积水容器类型||", length = 2, nullable = true)
	private String containerType;

	@Column(name = "CONTAINER_OTHER", columnDefinition = "VARCHAR2|积水容器类型其他||", length = 100, nullable = true)
	private String containerOther;

	@Column(name = "EQUIPMENT", columnDefinition = "VARCHAR2|防蚊设备||", length = 2, nullable = true)
	private String equipment;

	@Column(name = "EQUIPMENT_OTHER", columnDefinition = "VARCHAR2|防蚊设备其他||", length = 100, nullable = true)
	private String equipmentOther;

    @Column(name = "MOSQUITO_NET", columnDefinition = "VARCHAR2|是否有蚊帐|2|", length = 2, nullable = true)
    private String mosquitoNet;

    @Column(name = "SLEEP_OPEN", columnDefinition = "VARCHAR2|是否露宿|2|", length = 2, nullable = true)
    private String sleepOpen;
    
    @Column(name = "APPLIANCE_SEPARATION", columnDefinition = "VARCHAR2|病人的饮食用具|20|", length = 20, nullable = true)
    private String applianceSeparation;
    @Column(name = "APPLIANCE_DISINFECTION_METHOD", columnDefinition = "VARCHAR2|饮食用具消毒方法|20|", length = 20, nullable = true)
    private String applianceDisinfectionMethod;
    
	@Column(name = "DRINKING_TYPE_OTHER", columnDefinition = "VARCHAR2|饮水类型-其他||", length = 20, nullable = true)
	private String drinkingTypeOther;

 
	public String getDrinkingAddr() {
		return drinkingAddr;
	}

	public void setDrinkingAddr(String drinkingAddr) {
		this.drinkingAddr = drinkingAddr;
	}

	public Date getDrinkingDate() {
		return drinkingDate;
	}

	public void setDrinkingDate(Date drinkingDate) {
		this.drinkingDate = drinkingDate;
	}

	public String getApplianceDisinfectionMethod() {
		return applianceDisinfectionMethod;
	}

	public void setApplianceDisinfectionMethod(String applianceDisinfectionMethod) {
		this.applianceDisinfectionMethod = applianceDisinfectionMethod;
	}

	public String getDrinkingTypeOther() {
		return drinkingTypeOther;
	}

	public void setDrinkingTypeOther(String drinkingTypeOther) {
		this.drinkingTypeOther = drinkingTypeOther;
	}

	public String getApplianceSeparation() {
		return applianceSeparation;
	}

	public void setApplianceSeparation(String applianceSeparation) {
		this.applianceSeparation = applianceSeparation;
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

	public String getResStatus() {
		return this.resStatus;
	}

	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}

	public String getPerLivingArea() {
		return this.perLivingArea;
	}

	public void setPerLivingArea(String perLivingArea) {
		this.perLivingArea = perLivingArea;
	}

	public String getVentilation() {
		return this.ventilation;
	}

	public void setVentilation(String ventilation) {
		this.ventilation = ventilation;
	}

	public String getConditionHours() {
		return this.conditionHours;
	}

	public void setConditionHours(String conditionHours) {
		this.conditionHours = conditionHours;
	}

	public String getAroundResHealth() {
		return this.aroundResHealth;
	}

	public void setAroundResHealth(String aroundResHealth) {
		this.aroundResHealth = aroundResHealth;
	}

	public String getFarmerMarket() {
		return this.farmerMarket;
	}

	public void setFarmerMarket(String farmerMarket) {
		this.farmerMarket = farmerMarket;
	}

	public String getLivBreFarms() {
		return this.livBreFarms;
	}

	public void setLivBreFarms(String livBreFarms) {
		this.livBreFarms = livBreFarms;
	}

	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getFamilyPosition() {
		return this.familyPosition;
	}

	public void setFamilyPosition(String familyPosition) {
		this.familyPosition = familyPosition;
	}

	public String getCasesFamily() {
		return this.casesFamily;
	}

	public void setCasesFamily(String casesFamily) {
		this.casesFamily = casesFamily;
	}

	public String getPatHousingTypes() {
		return this.patHousingTypes;
	}

	public void setPatHousingTypes(String patHousingTypes) {
		this.patHousingTypes = patHousingTypes;
	}

	public String getHouseFloorType() {
		return this.houseFloorType;
	}

	public void setHouseFloorType(String houseFloorType) {
		this.houseFloorType = houseFloorType;
	}

	public String getCleanRoomTime() {
		return this.cleanRoomTime;
	}

	public void setCleanRoomTime(String cleanRoomTime) {
		this.cleanRoomTime = cleanRoomTime;
	}

	public String getKitchenCuttingBoard() {
		return this.kitchenCuttingBoard;
	}

	public void setKitchenCuttingBoard(String kitchenCuttingBoard) {
		this.kitchenCuttingBoard = kitchenCuttingBoard;
	}

	public String getProcRawMeatAfter() {
		return this.procRawMeatAfter;
	}

	public void setProcRawMeatAfter(String procRawMeatAfter) {
		this.procRawMeatAfter = procRawMeatAfter;
	}

	public String getIsKnow() {
		return this.isKnow;
	}

	public void setIsKnow(String isKnow) {
		this.isKnow = isKnow;
	}

	public String getFromType() {
		return this.fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getAnPatRel() {
		return this.anPatRel;
	}

	public void setAnPatRel(String anPatRel) {
		this.anPatRel = anPatRel;
	}

    public String getIsDieAnHn() {
        return this.isDieAnHn;
    }

    public void setIsDieAnHn(String isDieAnHn) {
        this.isDieAnHn = isDieAnHn;
    }

    public String getIsDisinfectFamly() {
		return this.isDisinfectFamly;
	}

	public void setIsDisinfectFamly(String isDisinfectFamly) {
		this.isDisinfectFamly = isDisinfectFamly;
	}

	public Date getDisinfectFamlyDate() {
		return this.disinfectFamlyDate;
	}

	public void setDisinfectFamlyDate(Date disinfectFamlyDate) {
		this.disinfectFamlyDate = disinfectFamlyDate;
	}

	public String getWash() {
		return this.wash;
	}

	public void setWash(String wash) {
		this.wash = wash;
	}

	public String getIsSmoke() {
		return this.isSmoke;
	}

	public void setIsSmoke(String isSmoke) {
		this.isSmoke = isSmoke;
	}

	public String getSpliffNum() {
		return this.spliffNum;
	}

	public void setSpliffNum(String spliffNum) {
		this.spliffNum = spliffNum;
	}

	public String getChronicDisease() {
		return this.chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

    public Date getTivLastInoculateDate() {
        return tivLastInoculateDate;
    }

    public void setTivLastInoculateDate(Date tivLastInoculateDate) {
        this.tivLastInoculateDate = tivLastInoculateDate;
    }

    public String getTiv() {
        return tiv;
    }

    public void setTiv(String tiv) {
        this.tiv = tiv;
    }

    public String getImmunoglobulin() {
		return this.immunoglobulin;
	}

	public void setImmunoglobulin(String immunoglobulin) {
		this.immunoglobulin = immunoglobulin;
	}

	public Date getImmLastInoculateDate() {
		return this.immLastInoculateDate;
	}

	public void setImmLastInoculateDate(Date immLastInoculateDate) {
		this.immLastInoculateDate = immLastInoculateDate;
	}

	public String getDrinkingType() {
		return this.drinkingType;
	}

	public void setDrinkingType(String drinkingType) {
		this.drinkingType = drinkingType;
	}

	public String getWaterType() {
		return this.waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	public String getDrinkingDisinfection() {
		return this.drinkingDisinfection;
	}

	public void setDrinkingDisinfection(String drinkingDisinfection) {
		this.drinkingDisinfection = drinkingDisinfection;
	}

	public String getWaterDisinfection() {
		return this.waterDisinfection;
	}

	public void setWaterDisinfection(String waterDisinfection) {
		this.waterDisinfection = waterDisinfection;
	}

	public String getToiletType() {
		return this.toiletType;
	}

	public void setToiletType(String toiletType) {
		this.toiletType = toiletType;
	}

	public String getDropsyContainer() {
		return this.dropsyContainer;
	}

	public void setDropsyContainer(String dropsyContainer) {
		this.dropsyContainer = dropsyContainer;
	}

	public String getPositiveContainer() {
		return this.positiveContainer;
	}

	public void setPositiveContainer(String positiveContainer) {
		this.positiveContainer = positiveContainer;
	}

	public String getContainerType() {
		return this.containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getContainerOther() {
		return this.containerOther;
	}

	public void setContainerOther(String containerOther) {
		this.containerOther = containerOther;
	}

	public String getEquipment() {
		return this.equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getEquipmentOther() {
		return this.equipmentOther;
	}

	public void setEquipmentOther(String equipmentOther) {
		this.equipmentOther = equipmentOther;
	}

    public String getMosquitoNet() {
        return this.mosquitoNet;
    }

    public void setMosquitoNet(String mosquitoNet) {
        this.mosquitoNet = mosquitoNet;
    }

    public String getSleepOpen() {
        return this.sleepOpen;
    }

    public void setSleepOpen(String sleepOpen) {
        this.sleepOpen = sleepOpen;
    }
}
