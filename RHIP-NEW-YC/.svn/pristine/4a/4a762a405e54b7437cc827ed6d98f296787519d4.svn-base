package com.founder.rhip.cdm.controller.standardization;

import com.founder.rhip.ehr.service.export.Item;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 糖尿病导出
 * @author liuk
 *
 */
@SuppressWarnings("unused")
public class DiFollowupExportDef {
	@Item(index = 1, isDic = false, column = "姓名")
	private String name;

	@Item(index = 2, column = "性别", isDic = true, dicType = "GBT226112003")
	private String gender;

	@Item(index = 3, column = "生日", isDate = true, datePattern = "yyyy/MM/dd")
	private String birthday;

	@Item(index = 4, column = "身份证")
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

	@Item(index = 11, column = "随访日期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date visitDate;

	@Item(index = 12, column = "随访方式", isDic = true, dicType = "DMD00026")
	private String visitWayCode;

	@Item(index = 13, isDic = true, column = "症状", dicType = "DMD00043", isMultiple = true)
	private String curSymptom;

	@Item(index = 14, column = "其他症状")
	private String otherSymptom;

	@Item(index = 15, column = "身高(cm)")
	private BigDecimal height;

	@Item(index = 16, column = "体重(kg)")
	private BigDecimal bodyWeight;

	@Item(index = 17, column = "体质指数")
	private BigDecimal indexOfBodyCharacteristics;

	@Item(index = 18, column = "下次随访达到体重(kg)")
	private BigDecimal nextFollowupBodyWeight;

	@Item(index = 19, column = "下次随访达到的体质指数")
	private BigDecimal nextFollowupBmi;

	@Item(index = 20, column = "舒张压(mmHg)")
	private Integer dbp;

	@Item(index = 21, column = "收缩压")
	private String sbp;

	@Item(index = 22, column = "足背动脉搏动",isDic = true,dicType = "DMD00044")
	private String heartRate;

	@Item(index = 23, column = "体征其它")
	private String signOther;

	@Item(index = 118, column = "日吸烟量(支)")
	private Integer dailySmoke;

	@Item(index = 119, column = "下次随访日吸烟量")
	private Integer smokeberTarget;

	@Item(index = 121, column = "日饮酒量(两)")
	private Integer dailyDrink;

	@Item(index = 122, column = "下次随访日饮酒量(两)")
	private Integer nextFollowupDailyDrink;

	@Item(index = 123, column = "运动频率")
	private Integer trainFrequencyType;

	@Item(index = 124, column = "每次锻炼时间(min)")
	private Integer trainingMin;

	@Item(index = 125, column = "下次随访运动次数")
	private Integer nextExerciseFrequency;

	@Item(index = 125, column = "下次随访运动时间")
	private Integer nextExerciseTime;

	@Item(index = 126, column = "自我血糖监测",isDic = true,dicType = "DMD00053")
	private String selfBsMonitoring;

	@Item(index = 127, column = "日主食量(g)")
	private Integer dailyRice;

	@Item(index = 128,  column = "下次随访日主食量(g)")
	private Integer staple;

    @Item(index = 129 , column ="辅助检查空腹血糖值")
    private BigDecimal fpg;

    @Item(index = 139 , column ="辅助检查糖化血红蛋白值")
    private BigDecimal hgb;

    @Item(index = 140 , column ="其他辅助检查描述")
    private String otherCheck;

    @Item(index = 141 , column ="辅助检查检查日期")
    private Date checkDate;

	@Item(index = 1130, column = "总胆固醇")
	private BigDecimal tc;

	@Item(index =1131, column = "甘油三酯")
	private BigDecimal triglycerideValue;

	@Item(index = 1131, column = "血清低密度脂蛋白胆固醇")
	private BigDecimal ldlcDetectValue;

	@Item(index = 1132, column = "HDLC血清高密度脂蛋白胆固醇")
	private BigDecimal hdlcDetectValue;

	@Item(index = 1133, column = "心理调整评价", isDic = true, dicType = "DMD00039")
	private String mentality;

	@Item(index = 1134, column = "遵医行为评价", isDic = true, dicType = "DMD00040")
	private String compiance;

	@Item(index = 1136, column = "低血糖反应", isDic = true, dicType = "DMD00045")
	private Integer hypoglycemiaReaction;

	@Item(index = 1136, column = "糖尿病并发症", isDic = true, isMultiple = true, dicType = "DMD00046")
	private String diComplication;





	@Item(index = 1136, column = "服药依从性", isDic = true, dicType = "DMD00041")
	private String medicationCompliance;

	@Item(index = 1137, column = "药物不良反应描述")
	private String effectsState;

	@Item(index = 1138, column = "此次随访分类", isDic = true, dicType = "DMD00042")
	private String visitType;

	@Item(index = 1239, column = "第一种药物")
	private String drugNameFirst;

	@Item(index = 1239, column = "第一种药物使用频率")
	private Integer drugPerdayFirst;

	@Item(index = 1240, column = "第一种药物每次剂量")
	private BigDecimal drugPertimeFirst;

	@Item(index =1241, column = "第一种用药单位", isDic = true, dicType = "DMD00067")
	private String firstMedicateUnit;

	@Item(index = 1242, column = "第二种药物名称")
	private String drugNameSecond;

	@Item(index = 1243, column = "第二种药物使用频率")
	private Integer drugPerdaySecond;

	@Item(index =1244, column = "第二种药物每次剂量")
	private BigDecimal drugPertimeSecond;

	@Item(index = 1245, column = "第二种用药单位", isDic = true, dicType = "DMD00067")
	private String secondMedicateUnit;

	@Item(index = 1246, column = "第三种药物")
	private String drugNameThird;

	@Item(index = 1247, column = "第三种药物使用频率")
	private Integer drugPerdayThird;

	@Item(index = 1248, column = "第三种药物每次剂量")
	private BigDecimal drugPertimeThird;

	@Item(index =1249, column = "第三种用药单位", isDic = true, dicType = "DMD00067")
	private String thirdMedicateUnit;

	@Item(index = 1350, column = "胰岛素用药种类")
	private String insulinSort;

	@Item(index = 1351, column = "胰岛素用药使用频率(次/d)")
	private String insulinUsage;

	@Item(index = 1352, column = "胰岛素用药次剂量")
	private String dosage;

	@Item(index = 1553, column = "胰岛素单位", isDic = true, dicType = "DMD00067")
	private String insulinDosageUnit;

	@Item(index = 1554, column = "胰岛素备注")
	private String insulinUsageRemark;

	@Item(index = 1550, column = "转诊机构", isOrganization = true)
	private String referralOrganCode;

	@Item(index = 1551, column = "转诊原因")
	private String referralReasons;

	@Item(index = 11552, column = "转诊科别")
	private String referralDepartment;

	@Item(index = 11553, column = "填报机构", isOrganization = true)
	private String createOrganCode;

	@Item(index = 11554, column = "填报人", isUser = true)
	private String createDoctorCode;

}
