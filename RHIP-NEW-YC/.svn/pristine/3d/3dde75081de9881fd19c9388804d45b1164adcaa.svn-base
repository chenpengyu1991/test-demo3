package com.founder.rhip.ehr.entity.summary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_HEALTH_SUMMARY")
public class HealthSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "DISEASE_NOTE", columnDefinition = "VARCHAR2|患病情况描述||", length = 400, nullable = true)
    private String diseaseNote;

    @Column(name = "ALLERGIC_SOURCE", columnDefinition = "VARCHAR2|过敏源代码组合||", length = 200, nullable = true)
    private String allergicSource;

    @Column(name = "TRAIN_FREQUENCY_TYPE_CODE", columnDefinition = "VARCHAR2|运动频率代码||", length = 1, nullable = true)
    private String trainFrequencyTypeCode;

    @Column(name = "TRAINING_TIME", columnDefinition = "NUMBER|每次锻炼时间(分钟)||", length = 5, nullable = true)
    private Integer trainingTime;

    @Column(name = "TRAINING_TOTALTIME", columnDefinition = "NUMBER|坚持锻炼时间(年)||", length = 3, nullable = true)
    private Integer trainingTotaltime;

    @Column(name = "TRAINING_WAY", columnDefinition = "VARCHAR2|运动方式说明||", length = 100, nullable = true)
    private String trainingWay;

    @Column(name = "FOOD_HABITS", columnDefinition = "VARCHAR2|饮食习惯代码||", length = 1, nullable = true)
    private String foodHabits;

    @Column(name = "FOOD_HOBBY", columnDefinition = "VARCHAR2|饮食嗜好||", length = 1, nullable = true)
    private String foodHobby;

    @Column(name = "SMODE_STATUS_CODE", columnDefinition = "VARCHAR2|吸烟状况代码||", length = 1, nullable = true)
    private String smodeStatusCode;

    @Column(name = "DAILY_SMOKE", columnDefinition = "NUMBER|日吸烟量(支)||", length = 5, nullable = true)
    private Integer dailySmoke;

    @Column(name = "SMOKE_AGE", columnDefinition = "NUMBER|开始吸烟年龄(岁)||", length = 5, nullable = true)
    private Integer smokeAges;

    @Column(name = "SMOKE_AGEE", columnDefinition = "NUMBER|戒烟年龄(岁)||", length = 3, nullable = true)
    private Integer smokeAgee;

    @Column(name = "DRINK_AGE", columnDefinition = "NUMBER|开始饮酒年龄(岁)||", length = 3, nullable = true)
    private Integer drinkAge;

    @Column(name = "DRINK_FREQUENCY", columnDefinition = "VARCHAR2|饮酒频率代码||", length = 1, nullable = true)
    private String drinkFrequency;

    @Column(name = "DRINK_TYPE", columnDefinition = "VARCHAR2|饮酒种类代码组合||", length = 100, nullable = true)
    private String drinkType;

    @Column(name = "DRINK_NUM", columnDefinition = "NUMBER|折合白酒日饮量(两)||", length = 5, nullable = true)
    private Integer drinkNum;

    @Column(name = "NODRINK", columnDefinition = "VARCHAR2|是否戒酒||", length = 1, nullable = true)
    private String nodrink;

    @Column(name = "NODRINK_AGE", columnDefinition = "NUMBER|戒酒年龄(岁)||", length = 3, nullable = true)
    private Integer nodrinkAge;

    @Column(name = "DRUNK", columnDefinition = "VARCHAR2|醉酒标志||", length = 1, nullable = true)
    private String drunk;

    @Column(name = "EXPOSE_STATE", columnDefinition = "VARCHAR2|职业暴露情况||", length = 1, nullable = true)
    private String exposeState;

    @Column(name = "EXPOSE_YEAR", columnDefinition = "NUMBER|累计暴露年限(年)||", length = 3, nullable = true)
    private String exposeYear;

    @Column(name = "EXPOSE_RISK", columnDefinition = "VARCHAR2|职业暴露危险因素||", length = 100, nullable = true)
    private String exposeRisk;

    @Column(name = "MEASURE_BIO", columnDefinition = "VARCHAR2|有无防护措施||", length = 1, nullable = true)
    private String measureBio;

    @Column(name = "DISABILITY", columnDefinition = "VARCHAR2|纳入残疾管理代码组合||", length = 200, nullable = true)
    private String disability;

    @Column(name = "DISEASE", columnDefinition = "VARCHAR2|纳入慢病管理编码组合||", length = 200, nullable = true)
    private String disease;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人员身份证||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人员姓名||", length = 30, nullable = true)
    private String inputName;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档人员姓名||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 1, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 15, nullable = true)
    private String updateOrgancode;

    @Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
    private String updateOrganname;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Transient
    private String disabilityDesc;
	
	@Transient
	private String allergicSourceDesc;
	
	@Transient
	private String trainFrequencyTypeCodeDesc;
	
	@Transient
	private String foodHabitsDesc;
	
	@Transient
	private String foodHobbyDesc;
	
	@Transient
	private String smodeStatusCodeDesc;
	
	@Transient
	private String drinkFrequencyDesc;
	
	@Transient
	private String nodrinkDesc;
	
	@Transient
	private String drunkDesc;
	
	@Transient
	private String drinkTypeDesc;
	
	@Transient
	private String exposeStateDesc;
	
	@Transient
	private String measureBioDesc;
	
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getExposeState() {
        return exposeState;
    }

    public void setExposeState(String exposeState) {
        this.exposeState = exposeState;
    }

    public String getExposeYear() {
        return exposeYear;
    }

    public void setExposeYear(String exposeYear) {
        this.exposeYear = exposeYear;
    }

    public String getExposeRisk() {
        return exposeRisk;
    }

    public void setExposeRisk(String exposeRisk) {
        this.exposeRisk = exposeRisk;
    }

    public String getInputIdcard() {
        return inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputOrganCode() {
        return inputOrganCode;
    }

    public void setInputOrganCode(String inputOrganCode) {
        this.inputOrganCode = inputOrganCode;
    }

    public String getInputOrganName() {
        return inputOrganName;
    }

    public void setInputOrganName(String inputOrganName) {
        this.inputOrganName = inputOrganName;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getDiseaseNote() {
        return this.diseaseNote;
    }

    public void setDiseaseNote(String diseaseNote) {
        this.diseaseNote = diseaseNote;
    }

    public String getAllergicSource() {
        return this.allergicSource;
    }

    public void setAllergicSource(String allergicSource) {
        this.allergicSource = allergicSource;
    }

    public String getTrainFrequencyTypeCode() {
        return this.trainFrequencyTypeCode;
    }

    public void setTrainFrequencyTypeCode(String trainFrequencyTypeCode) {
        this.trainFrequencyTypeCode = trainFrequencyTypeCode;
    }

    public Integer getTrainingTime() {
        return this.trainingTime;
    }

    public void setTrainingTime(Integer trainingTime) {
        this.trainingTime = trainingTime;
    }

    public Integer getTrainingTotaltime() {
        return this.trainingTotaltime;
    }

    public void setTrainingTotaltime(Integer trainingTotaltime) {
        this.trainingTotaltime = trainingTotaltime;
    }

    public String getTrainingWay() {
        return this.trainingWay;
    }

    public void setTrainingWay(String trainingWay) {
        this.trainingWay = trainingWay;
    }

    public String getFoodHabits() {
        return this.foodHabits;
    }

    public void setFoodHabits(String foodHabits) {
        this.foodHabits = foodHabits;
    }

    public String getFoodHobby() {
        return this.foodHobby;
    }

    public void setFoodHobby(String foodHobby) {
        this.foodHobby = foodHobby;
    }

    public String getSmodeStatusCode() {
        return this.smodeStatusCode;
    }

    public void setSmodeStatusCode(String smodeStatusCode) {
        this.smodeStatusCode = smodeStatusCode;
    }

    public Integer getDailySmoke() {
        return this.dailySmoke;
    }

    public void setDailySmoke(Integer dailySmoke) {
        this.dailySmoke = dailySmoke;
    }

    public Integer getSmokeAges() {
        return this.smokeAges;
    }

    public void setSmokeAges(Integer smokeAges) {
        this.smokeAges = smokeAges;
    }

    public Integer getSmokeAgee() {
        return this.smokeAgee;
    }

    public void setSmokeAgee(Integer smokeAgee) {
        this.smokeAgee = smokeAgee;
    }

    public Integer getDrinkAge() {
        return this.drinkAge;
    }

    public void setDrinkAge(Integer drinkAge) {
        this.drinkAge = drinkAge;
    }

    public String getDrinkFrequency() {
        return this.drinkFrequency;
    }

    public void setDrinkFrequency(String drinkFrequency) {
        this.drinkFrequency = drinkFrequency;
    }

    public String getDrinkType() {
        return this.drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public Integer getDrinkNum() {
        return this.drinkNum;
    }

    public void setDrinkNum(Integer drinkNum) {
        this.drinkNum = drinkNum;
    }

    public String getNodrink() {
        return this.nodrink;
    }

    public void setNodrink(String nodrink) {
        this.nodrink = nodrink;
    }

    public Integer getNodrinkAge() {
        return this.nodrinkAge;
    }

    public void setNodrinkAge(Integer nodrinkAge) {
        this.nodrinkAge = nodrinkAge;
    }

    public String getDrunk() {
        return this.drunk;
    }

    public void setDrunk(String drunk) {
        this.drunk = drunk;
    }

    public String getMeasureBio() {
        return this.measureBio;
    }

    public void setMeasureBio(String measureBio) {
        this.measureBio = measureBio;
    }

    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getDisease() {
        return this.disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
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


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getDisabilityDesc() {
		return disabilityDesc;
	}

	public void setDisabilityDesc(String disabilityDesc) {
		this.disabilityDesc = disabilityDesc;
	}

	public String getAllergicSourceDesc() {
		return allergicSourceDesc;
	}

	public void setAllergicSourceDesc(String allergicSourceDesc) {
		this.allergicSourceDesc = allergicSourceDesc;
	}

	public String getTrainFrequencyTypeCodeDesc() {
		return trainFrequencyTypeCodeDesc;
	}

	public void setTrainFrequencyTypeCodeDesc(String trainFrequencyTypeCodeDesc) {
		this.trainFrequencyTypeCodeDesc = trainFrequencyTypeCodeDesc;
	}

	public String getFoodHabitsDesc() {
		return foodHabitsDesc;
	}

	public void setFoodHabitsDesc(String foodHabitsDesc) {
		this.foodHabitsDesc = foodHabitsDesc;
	}

	public String getFoodHobbyDesc() {
		return foodHobbyDesc;
	}

	public void setFoodHobbyDesc(String foodHobbyDesc) {
		this.foodHobbyDesc = foodHobbyDesc;
	}

	public String getSmodeStatusCodeDesc() {
		return smodeStatusCodeDesc;
	}

	public void setSmodeStatusCodeDesc(String smodeStatusCodeDesc) {
		this.smodeStatusCodeDesc = smodeStatusCodeDesc;
	}

	public String getDrinkFrequencyDesc() {
		return drinkFrequencyDesc;
	}

	public void setDrinkFrequencyDesc(String drinkFrequencyDesc) {
		this.drinkFrequencyDesc = drinkFrequencyDesc;
	}

	public String getDrinkTypeDesc() {
		return drinkTypeDesc;
	}

	public void setDrinkTypeDesc(String drinkTypeDesc) {
		this.drinkTypeDesc = drinkTypeDesc;
	}

	public String getExposeStateDesc() {
		return exposeStateDesc;
	}

	public void setExposeStateDesc(String exposeStateDesc) {
		this.exposeStateDesc = exposeStateDesc;
	}

	public String getMeasureBioDesc() {
		return measureBioDesc;
	}

	public void setMeasureBioDesc(String measureBioDesc) {
		this.measureBioDesc = measureBioDesc;
	}

	public String getNodrinkDesc() {
		return nodrinkDesc;
	}

	public void setNodrinkDesc(String nodrinkDesc) {
		this.nodrinkDesc = nodrinkDesc;
	}

	public String getDrunkDesc() {
		return drunkDesc;
	}

	public void setDrunkDesc(String drunkDesc) {
		this.drunkDesc = drunkDesc;
	}
	
}
