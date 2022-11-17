package com.founder.rhip.cdm.controller.standardization;

import com.founder.rhip.ehr.service.export.Item;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 高血压导出
 * @author liuk
 *
 */
@SuppressWarnings("unused")
public class HbpFollowupExport {

	@Item(index=1,isDic = false, column = "姓名")
	private String name;
	

	@Item(index=2,column = "性别",isDic=true,dicType="GBT226112003")
	private String gender;

	@Item(index=3,column = "生日",isDate = true,  datePattern = "yyyy/MM/dd")
	private String birthday;

	@Item(index=4,column = "身份证")
	private String idcard;

    @Item(index=5,isDic=true,dicType="FS990001",column ="户籍地址-乡镇")
    private String hrtownShip;

    @Item(index=6,isDic=true,dicType="FS990001",column ="户籍地址-村")
    private String hrstreet;

    @Item(index=7,column ="户籍地址详细")
    private String hrhouseNumber;

    @Item(index=8,isDic=true,dicType="FS990001",column ="现住址乡镇")
    private String patownShip;

    @Item(index=9,isDic=true,dicType="FS990001",column ="现住址-村(街、路、弄等)")
    private String pastreet;

    @Item(index=10,column ="现住址详细")
    private String pahouseNumber;
	
	@Item(index=15,column = "随访日期",isDate = true,  datePattern = "yyyy/MM/dd")
	private Date visitDate;

	@Item(index=16,column = "随访方式",isDic=true,dicType="DMD00026")
	private String visitWayCode;
	
	@Item(index=17,isDic = true, column = "症状", dicType = "DMD00038", isMultiple = true)
	private String curSymptom;
	
	@Item(index=18,column = "其他症状")
	private String otherSymptom;

	@Item(index=19,column = "身高(cm)")
	private BigDecimal height;

	@Item(index=20,column = "体重(kg)")
	private BigDecimal bodyWeight;

//	@Item(index=11,column = "臀围(cm)")
//	private BigDecimal hip;
//
//	@Item(index=12,column = "腰围(cm)")
//	private BigDecimal waostline;
	
	@Item(index=21,column = "体质指数")
	private BigDecimal indexOfBodyCharacteristics;
	
	@Item(index=22,column = "下次随访达到体重(kg)")
	private BigDecimal nextFollowupBodyWeight;
	
	@Item(index=23,column = "下次随访达到的体质指数")
	private BigDecimal nextFollowupBmi;
	
	@Item(index=24,column = "舒张压(mmHg)")
	private Integer dbp;
	
	@Item(index=25,column = "收缩压")
	private String sbp;

	@Item(index=26,column = "心率(次/min)")
	private Integer heartRate;
	
	@Item(index=27,column = "体征其它")
	private String signOther;
	
	@Item(index=28,column = "日吸烟量(支)")
	private Integer dailyDailySmokeber;
	
	@Item(index=29,column = "下次随访日吸烟量")
	private Integer smokeberTarget;
	
	@Item(index=31,column = "日饮酒量(两)")
	private Integer dailyDrink;
	
	@Item(index=32,column = "下次随访日饮酒量(两)")
	private Integer nextFollowupDailyDrink;

	@Item(index=33,column = "运动频率")
	private Integer trainFrequency;

	@Item(index=34,column = "每次锻炼时间(min)")
	private Integer trainingMin;

	@Item(index=35,column = "下次随访运动次数")
	private Integer nextExerciseFrequency;

	@Item(index=36,column = "下次随访运动时间")
	private Integer nextExerciseTime;

	@Item(index=37,isDic=true,dicType="DMD00063",column = "摄盐情况（咸 淡）")
	private String salinity;
	
	@Item(index=38,isDic=true,dicType="DMD00063",column = "下次随访摄盐情况（咸 淡）")
	private String nextSalinityTarget;

//	@Item(index=39,column = "总胆固醇")
	private BigDecimal tc;

//	@Item(index=40,column = "甘油三酯")
	private BigDecimal triglycerideValue;

//	@Item(index=41,column = "血清低密度脂蛋白胆固醇")
	private BigDecimal ldlcDetectValue;

//	@Item(index=42,column = "HDLC血清高密度脂蛋白胆固醇")
	private BigDecimal hdlcDetectValue;
	
	@Item(index=43,column = "心理调整评价",isDic=true,dicType="DMD00039")
	private String mentality;

	@Item(index=44,column = "遵医行为评价",isDic=true,dicType="DMD00040")
	private String compiance;

	@Item(index=45,column = "辅助检查结果")
	private String aeResultDesc;
	
	@Item(index=46,column = "服药依从性",isDic=true,dicType="DMD00041")
	private String medicationCompliance;

	@Item(index=47,column = "药物不良反应描述")
	private String effectsState;

	@Item(index=48,column = "此次随访分类",isDic=true,dicType="DMD00042")
	private String visitType;

	@Item(index=49,column = "第一种药物")
	private String drugNameFirst;

	@Item(index=139,column = "第一种药物使用频率")
	private Integer drugPerdayFirst;

	@Item(index=140,column = "第一种药物每次剂量")
	private BigDecimal drugPertimeFirst;
	
	@Item(index=141,column = "第一种用药单位",isDic=true,dicType="DMD00067")
	private String firstMedicateUnit;

	@Item(index=142,column = "第二种药物名称")
	private String drugNameSecond;

	@Item(index=143,column = "第二种药物使用频率")
	private Integer drugPerdaySecond;

	@Item(index=144,column = "第二种药物每次剂量")
	private BigDecimal drugPertimeSecond;
	
	@Item(index=145,column = "第二种用药单位",isDic=true,dicType="DMD00067")
	private String secondMedicateUnit;

	@Item(index=146,column = "第三种药物")
	private String drugNameThird;

	@Item(index=147,column = "第三种药物使用频率")
	private Integer drugPerdayThird;

	@Item(index=148,column = "第三种药物每次剂量")
	private BigDecimal drugPertimeThird;

	@Item(index=149,column = "第三种用药单位",isDic=true,dicType="DMD00067")
	private String thirdMedicateUnit;

	@Item(index=150,column = "转诊机构",isOrganization=true)
	private String referralOrganCode;

	@Item(index=151,column = "转诊原因")
	private String referralReasons;

	@Item(index=152,column = "转诊科别")
	private String referralDepartment;
	
	@Item(index=153,column = "填报机构",isOrganization=true)
	private String createOrganCode;

	@Item(index=154,column = "随访医生",isUser=true)
	private String createDoctorCode;

}
