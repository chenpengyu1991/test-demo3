package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

/**
 *病前饮食
 */
@Entity
@Table(name = "IDM_BEFORE_DISEASE_DIET")
public class BeforeDiseaseDiet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "DRINKING_TYPE", columnDefinition = "VARCHAR2|饮水类型||", length = 2, nullable = true)
	private String drinkingType;

	@Column(name = "DRINKING_HISTORY", columnDefinition = "VARCHAR2|饮生水史||", length = 2, nullable = true)
	private String drinkingHistory;

	@Column(name = "DRINKING_NUM", columnDefinition = "VARCHAR2|饮生水次数||", length = 2, nullable = true)
	private String drinkingNum;

	@Column(name = "DRINKING_TIME", columnDefinition = "DATE|最近饮水时间||", nullable = true)
	private Date drinkingTime;

	@Column(name = "EAT_SEA_PRODUCTS", columnDefinition = "VARCHAR2|吃海水产品||", length = 2, nullable = true)
	private String eatSeaProducts;

	@Column(name = "SEA_FOOD_NAME", columnDefinition = "VARCHAR2|食品名称||", length = 200, nullable = true)
	private String seaFoodName;

	@Column(name = "SEA_SALES_PLACES", columnDefinition = "VARCHAR2|购买地点||", length = 200, nullable = true)
	private String seaSalesPlaces;

	@Column(name = "EDIBLE_METHOD", columnDefinition = "VARCHAR2|食用方法||", length = 2, nullable = true)
	private String edibleMethod;

	@Column(name = "SUSPICIOUS_FOOD", columnDefinition = "VARCHAR2|吃其它可疑食品||", length = 2, nullable = true)
	private String suspiciousFood;

	@Column(name = "SUS_SALES_PLACES", columnDefinition = "VARCHAR2|购买地点||", length = 200, nullable = true)
	private String susSalesPlaces;

	@Column(name = "OUTSIDE_DINING_HISTORY", columnDefinition = "VARCHAR2|在外就餐史||", length = 2, nullable = true)
	private String outsideDiningHistory;

	@Column(name = "EAT_PLACE", columnDefinition = "VARCHAR2|就餐地点||", length = 200, nullable = true)
	private String eatPlace;

	@Column(name = "EAT_TIME", columnDefinition = "DATE|最近就餐时间||", nullable = true)
	private Date eatTime;

	@Column(name = "MEAL_P_NUM", columnDefinition = "VARCHAR2|同餐人数||", length = 20, nullable = true)
	private String mealPNum;

	@Column(name = "DINNER_HISTORY", columnDefinition = "VARCHAR2|聚餐史||", length = 2, nullable = true)
	private String dinnerHistory;

	@Column(name = "DINNER_DATE", columnDefinition = "DATE|聚餐日期||", nullable = true)
	private Date dinnerDate;

	@Column(name = "DINNER_P_NUM", columnDefinition = "VARCHAR2|同餐人数||", length = 20, nullable = true)
	private String dinnerPNum;

	@Column(name = "INFECTED_NUM", columnDefinition = "VARCHAR2|发病人数||", length = 20, nullable = true)
	private String infectedNum;

	@Column(name = "RES_HEALTH", columnDefinition = "VARCHAR2|居所卫生||", length = 2, nullable = true)
	private String resHealth;

	@Column(name = "INDOOR_FLIES", columnDefinition = "VARCHAR2|室内苍蝇||", length = 2, nullable = true)
	private String indoorFlies;

	@Column(name = "GO_HFM_DISEASE", columnDefinition = "VARCHAR2|发病6天前是否到过手足口病流行地||", length = 2, nullable = true)
	private String goHfmDisease;

	@Column(name = "OUT_DRINKING_TYPE", columnDefinition = "VARCHAR2|外出就餐水源类型||", length = 50, nullable = true)
	private String outDrinkingType;

	@Column(name = "OUT_DRINKING_PLACE", columnDefinition = "VARCHAR2|外出就餐水源地点||", length = 200, nullable = true)
	private String outDrinkingPlace;

	@Column(name = "OUT_DRINKING_RATE", columnDefinition = "VARCHAR2|外出就餐水源频率||", length = 2, nullable = true)
	private String outDrinkingRate;

	@Column(name = "COLD_FOOD", columnDefinition = "VARCHAR2|饮食情况-吃生冷食品||", length = 2, nullable = true)
	private String coldFood;

	@Column(name = "COLD_FOOD_NAME", columnDefinition = "VARCHAR2|饮食情况-生冷食品名称||", length = 50, nullable = true)
	private String coldFoodName;

	@Column(name = "COLD_FOOD_BUY_PLACE", columnDefinition = "VARCHAR2|饮食情况-生冷食品购买地点||", length = 200, nullable = true)
	private String coldFoodBuyPlace;

	@Column(name = "COOKED_FOOD_COLD_EAT", columnDefinition = "VARCHAR2|饮食情况-熟食冷吃||", length = 2, nullable = true)
	private String cookedFoodColdEat;

	@Column(name = "COOKED_FOOD_NAME", columnDefinition = "VARCHAR2|饮食情况-熟食名称||", length = 50, nullable = true)
	private String cookedFoodName;

	@Column(name = "COOKED_FOOD_BUY_PLACE", columnDefinition = "VARCHAR2|饮食情况-熟食购买地点||", length = 200, nullable = true)
	private String cookedFoodBuyPlace;

	@Column(name = "COOKED_FOOD_EAT_PLACE", columnDefinition = "VARCHAR2|饮食情况-在外就餐地点名称||", length = 50, nullable = true)
	private String cookedFoodEatPlace;

	@Column(name = "MEALS", columnDefinition = "VARCHAR2|饮食情况-同餐者||", length = 2, nullable = true)
	private String meals;

	@Column(name = "MER_COOKED_FOOD", columnDefinition = "VARCHAR2|市售熟食||", length = 2, nullable = true)
	private String merCookedFood;

	@Column(name = "MILCHIGS", columnDefinition = "VARCHAR2|奶制品||", length = 2, nullable = true)
	private String milchigs;

	@Column(name = "COOLER", columnDefinition = "VARCHAR2|冷饮||", length = 2, nullable = true)
	private String cooler;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他||", length = 200, nullable = true)
	private String other;

	@Column(name = "DRINKING_PLACE", columnDefinition = "VARCHAR2|饮生水地点||", length = 200, nullable = true)
	private String drinkingPlace;

	@Column(name = "SEPARATE", columnDefinition = "VARCHAR2|生熟饮具是否分开||", length = 2, nullable = true)
	private String separate;

	@Column(name = "ACCIDENT_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date accidentDate;

	@Column(name = "TOUCH_POSI_WATER", columnDefinition = "VARCHAR2|病前五天内有无接触阳性水源||", length = 2, nullable = true)
	private String touchPosiWater;

	@Column(name = "POSI_WATER_METHOD", columnDefinition = "VARCHAR2|接触阳性水源方式||", length = 2, nullable = true)
	private String posiWaterMethod;

	@Column(name = "POSI_WATER_PLACE", columnDefinition = "VARCHAR2|接触阳性水源地点||", length = 200, nullable = true)
	private String posiWaterPlace;

	@Column(name = "POSI_WATER_TYPE", columnDefinition = "VARCHAR2|接触阳性水源类型||", length = 50, nullable = true)
	private String posiWaterType;

	@Column(name = "POSI_WATER_DATE", columnDefinition = "DATE|接触阳性水源日期（yy/mm/dd）||", nullable = true)
	private Date posiWaterDate;

	@Column(name = "WATER_TYPE", columnDefinition = "VARCHAR2|水源类型||", length = 100, nullable = true)
	private String waterType;

	@Column(name = "OTHER_SELECT", columnDefinition = "VARCHAR2|其他-单选||", length = 2, nullable = true)
	private String otherSelect;

	@Column(name = "GO_HFM_DISEASE_DT", columnDefinition = "Date|发病6天前是否到过手足口病流行地-时间||", nullable = true)
	private Date goHfmDiseaseDt;

	@Column(name = "GO_HFM_DISEASE_ADDR", columnDefinition = "VARCHAR2|发病6天前是否到过手足口病流行地-地点||", length = 200, nullable = true)
	private String goHfmDiseaseAddr;

	@Column(name = "EDIBLE_METHOD_OTHER", columnDefinition = "VARCHAR2|食用方法-其他||", length = 100, nullable = true)
	private String edibleMethodOther;

    @Column(name = "SUS_FOOD_NAME", columnDefinition = "VARCHAR2|其他可疑食物名称||", length = 200, nullable = true)
    private String susFoodName;
    
	@Column(name = "DINNER_INFECTED_FLAG", columnDefinition = "VARCHAR2|同餐者发病||", length = 20, nullable = true)
	private String dinnerInfectedFlag;
	
	@Column(name = "HAVE_VISCERAL", columnDefinition = "VARCHAR2|近两个月有无食用未煮熟的动物内脏  ||", length = 20, nullable = true)
	private String haveVisceral;
	
	@Column(name = "VISCERAL_NAME", columnDefinition = "VARCHAR2|内脏的名称||", length = 20, nullable = true)
	private String visceralName;
	
	@Column(name = "VISCERAL_ADDR", columnDefinition = "VARCHAR2|食用内脏地点||", length = 100, nullable = true)
	private String visceralAddr;
	
	@Column(name = "VISCERAL_DATE", columnDefinition = "VARCHAR2|食用内脏日期||",  nullable = true)
	private Date visceralDate;
	
	@Column(name = "KILLING_ANIMALS", columnDefinition = "VARCHAR2|近两个月有无宰杀生畜||", length = 20, nullable = true)
	private String killingAnimals;
	
	
	@Transient
	private String dinnerHour;//同餐日期-小时
	


    public String getDinnerHour() {
		return dinnerHour;
	}

	public void setDinnerHour(String dinnerHour) {
		this.dinnerHour = dinnerHour;
	}

    public String getHaveVisceral() {
		return haveVisceral;
	}

	public void setHaveVisceral(String haveVisceral) {
		this.haveVisceral = haveVisceral;
	}

	public String getVisceralName() {
		return visceralName;
	}

	public void setVisceralName(String visceralName) {
		this.visceralName = visceralName;
	}

	public String getVisceralAddr() {
		return visceralAddr;
	}

	public void setVisceralAddr(String visceralAddr) {
		this.visceralAddr = visceralAddr;
	}

	public Date getVisceralDate() {
		return visceralDate;
	}

	public void setVisceralDate(Date visceralDate) {
		this.visceralDate = visceralDate;
	}

	public String getKillingAnimals() {
		return killingAnimals;
	}

	public void setKillingAnimals(String killingAnimals) {
		this.killingAnimals = killingAnimals;
	}

	public String getDinnerInfectedFlag() {
		return dinnerInfectedFlag;
	}

	public void setDinnerInfectedFlag(String dinnerInfectedFlag) {
		this.dinnerInfectedFlag = dinnerInfectedFlag;
	}

	/*最近就餐时间--小时*/
    @Transient
    private String eatTimeHour;

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

	public String getDrinkingType() {
		return this.drinkingType;
	}

	public void setDrinkingType(String drinkingType) {
		this.drinkingType = drinkingType;
	}

	public String getDrinkingHistory() {
		return this.drinkingHistory;
	}

	public void setDrinkingHistory(String drinkingHistory) {
		this.drinkingHistory = drinkingHistory;
	}

	public String getDrinkingNum() {
		return this.drinkingNum;
	}

	public void setDrinkingNum(String drinkingNum) {
		this.drinkingNum = drinkingNum;
	}

	public Date getDrinkingTime() {
		return this.drinkingTime;
	}

	public void setDrinkingTime(Date drinkingTime) {
		this.drinkingTime = drinkingTime;
	}

	public String getEatSeaProducts() {
		return this.eatSeaProducts;
	}

	public void setEatSeaProducts(String eatSeaProducts) {
		this.eatSeaProducts = eatSeaProducts;
	}

	public String getSeaFoodName() {
		return this.seaFoodName;
	}

	public void setSeaFoodName(String seaFoodName) {
		this.seaFoodName = seaFoodName;
	}

	public String getSeaSalesPlaces() {
		return this.seaSalesPlaces;
	}

	public void setSeaSalesPlaces(String seaSalesPlaces) {
		this.seaSalesPlaces = seaSalesPlaces;
	}

	public String getEdibleMethod() {
		return this.edibleMethod;
	}

	public void setEdibleMethod(String edibleMethod) {
		this.edibleMethod = edibleMethod;
	}

	public String getSuspiciousFood() {
		return this.suspiciousFood;
	}

	public void setSuspiciousFood(String suspiciousFood) {
		this.suspiciousFood = suspiciousFood;
	}

	public String getSusSalesPlaces() {
		return this.susSalesPlaces;
	}

	public void setSusSalesPlaces(String susSalesPlaces) {
		this.susSalesPlaces = susSalesPlaces;
	}

	public String getOutsideDiningHistory() {
		return this.outsideDiningHistory;
	}

	public void setOutsideDiningHistory(String outsideDiningHistory) {
		this.outsideDiningHistory = outsideDiningHistory;
	}

	public String getEatPlace() {
		return this.eatPlace;
	}

	public void setEatPlace(String eatPlace) {
		this.eatPlace = eatPlace;
	}

	public Date getEatTime() {
		return this.eatTime;
	}

	public void setEatTime(Date eatTime) {
		this.eatTime = eatTime;
	}

	public String getMealPNum() {
		return this.mealPNum;
	}

	public void setMealPNum(String mealPNum) {
		this.mealPNum = mealPNum;
	}

	public String getDinnerHistory() {
		return this.dinnerHistory;
	}

	public void setDinnerHistory(String dinnerHistory) {
		this.dinnerHistory = dinnerHistory;
	}

	public Date getDinnerDate() {
		return this.dinnerDate;
	}

	public void setDinnerDate(Date dinnerDate) {
		this.dinnerDate = dinnerDate;
	}

    public String getDinnerPNum() {
        return dinnerPNum;
    }

    public void setDinnerPNum(String dinnerPNum) {
        this.dinnerPNum = dinnerPNum;
    }

    public String getInfectedNum() {
		return this.infectedNum;
	}

	public void setInfectedNum(String infectedNum) {
		this.infectedNum = infectedNum;
	}

	public String getResHealth() {
		return this.resHealth;
	}

	public void setResHealth(String resHealth) {
		this.resHealth = resHealth;
	}

	public String getIndoorFlies() {
		return this.indoorFlies;
	}

	public void setIndoorFlies(String indoorFlies) {
		this.indoorFlies = indoorFlies;
	}

	public String getGoHfmDisease() {
		return this.goHfmDisease;
	}

	public void setGoHfmDisease(String goHfmDisease) {
		this.goHfmDisease = goHfmDisease;
	}

	public String getOutDrinkingType() {
		return this.outDrinkingType;
	}

	public void setOutDrinkingType(String outDrinkingType) {
		this.outDrinkingType = outDrinkingType;
	}

	public String getOutDrinkingPlace() {
		return this.outDrinkingPlace;
	}

	public void setOutDrinkingPlace(String outDrinkingPlace) {
		this.outDrinkingPlace = outDrinkingPlace;
	}

	public String getOutDrinkingRate() {
		return this.outDrinkingRate;
	}

	public void setOutDrinkingRate(String outDrinkingRate) {
		this.outDrinkingRate = outDrinkingRate;
	}

	public String getColdFood() {
		return this.coldFood;
	}

	public void setColdFood(String coldFood) {
		this.coldFood = coldFood;
	}

	public String getColdFoodName() {
		return this.coldFoodName;
	}

	public void setColdFoodName(String coldFoodName) {
		this.coldFoodName = coldFoodName;
	}

	public String getColdFoodBuyPlace() {
		return this.coldFoodBuyPlace;
	}

	public void setColdFoodBuyPlace(String coldFoodBuyPlace) {
		this.coldFoodBuyPlace = coldFoodBuyPlace;
	}

	public String getCookedFoodColdEat() {
		return this.cookedFoodColdEat;
	}

	public void setCookedFoodColdEat(String cookedFoodColdEat) {
		this.cookedFoodColdEat = cookedFoodColdEat;
	}

	public String getCookedFoodName() {
		return this.cookedFoodName;
	}

	public void setCookedFoodName(String cookedFoodName) {
		this.cookedFoodName = cookedFoodName;
	}

	public String getCookedFoodBuyPlace() {
		return this.cookedFoodBuyPlace;
	}

	public void setCookedFoodBuyPlace(String cookedFoodBuyPlace) {
		this.cookedFoodBuyPlace = cookedFoodBuyPlace;
	}

	public String getCookedFoodEatPlace() {
		return this.cookedFoodEatPlace;
	}

	public void setCookedFoodEatPlace(String cookedFoodEatPlace) {
		this.cookedFoodEatPlace = cookedFoodEatPlace;
	}

	public String getMeals() {
		return this.meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	public String getMerCookedFood() {
		return this.merCookedFood;
	}

	public void setMerCookedFood(String merCookedFood) {
		this.merCookedFood = merCookedFood;
	}

	public String getMilchigs() {
		return this.milchigs;
	}

	public void setMilchigs(String milchigs) {
		this.milchigs = milchigs;
	}

	public String getCooler() {
		return this.cooler;
	}

	public void setCooler(String cooler) {
		this.cooler = cooler;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getDrinkingPlace() {
		return this.drinkingPlace;
	}

	public void setDrinkingPlace(String drinkingPlace) {
		this.drinkingPlace = drinkingPlace;
	}

	public String getSeparate() {
		return this.separate;
	}

	public void setSeparate(String separate) {
		this.separate = separate;
	}

	public Date getAccidentDate() {
		return this.accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getTouchPosiWater() {
		return this.touchPosiWater;
	}

	public void setTouchPosiWater(String touchPosiWater) {
		this.touchPosiWater = touchPosiWater;
	}

	public String getPosiWaterMethod() {
		return this.posiWaterMethod;
	}

	public void setPosiWaterMethod(String posiWaterMethod) {
		this.posiWaterMethod = posiWaterMethod;
	}

	public String getPosiWaterPlace() {
		return this.posiWaterPlace;
	}

	public void setPosiWaterPlace(String posiWaterPlace) {
		this.posiWaterPlace = posiWaterPlace;
	}

	public String getPosiWaterType() {
		return this.posiWaterType;
	}

	public void setPosiWaterType(String posiWaterType) {
		this.posiWaterType = posiWaterType;
	}

	public Date getPosiWaterDate() {
		return this.posiWaterDate;
	}

	public void setPosiWaterDate(Date posiWaterDate) {
		this.posiWaterDate = posiWaterDate;
	}

	public String getWaterType() {
		return this.waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	public String getOtherSelect() {
		return this.otherSelect;
	}

	public void setOtherSelect(String otherSelect) {
		this.otherSelect = otherSelect;
	}

	public Date getGoHfmDiseaseDt() {
		return this.goHfmDiseaseDt;
	}

	public void setGoHfmDiseaseDt(Date goHfmDiseaseDt) {
		this.goHfmDiseaseDt = goHfmDiseaseDt;
	}

	public String getGoHfmDiseaseAddr() {
		return this.goHfmDiseaseAddr;
	}

	public void setGoHfmDiseaseAddr(String goHfmDiseaseAddr) {
		this.goHfmDiseaseAddr = goHfmDiseaseAddr;
	}

	public String getEdibleMethodOther() {
		return this.edibleMethodOther;
	}

	public void setEdibleMethodOther(String edibleMethodOther) {
		this.edibleMethodOther = edibleMethodOther;
	}

    public String getSusFoodName() {
        return susFoodName;
    }

    public void setSusFoodName(String susFoodName) {
        this.susFoodName = susFoodName;
    }

    public String getEatTimeHour() {
        return eatTimeHour;
    }

    public void setEatTimeHour(String eatTimeHour) {
        this.eatTimeHour = eatTimeHour;
    }
}
