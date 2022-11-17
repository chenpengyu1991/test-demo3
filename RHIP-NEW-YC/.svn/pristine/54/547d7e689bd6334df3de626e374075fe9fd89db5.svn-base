package com.founder.rhip.cdm.controller.standardization;

import com.founder.rhip.ehr.service.export.Item;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 脑卒中冠心病导出
 * @author liuk
 *
 */
@SuppressWarnings("unused")
public class StrtumFollowupExportDef {
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

	@Item(index = 15, column = "随访日期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date visitDate;

	@Item(index = 16, column = "随访方式", isDic = true, dicType = "DMD00026")
	private String visitWayCode;

	@Item(index = 17, column = "收缩压(mmHg)")
	private Integer sbp;

	@Item(index = 18, column = "舒张压(mmHg)")
	private Integer dbp;

	@Item(index = 19, column = "空腹血糖值(mmol/L)")
	private BigDecimal fpg;

	@Item(index =10001 ,code = "GLU_VALUE", column = "餐后2小时血糖值(mmol/L)" )
	private BigDecimal gluValue;

	@Item(index =10002 ,code = "HGB", column = "糖化血红蛋白值(%)")
	private BigDecimal hgb;

	@Item(index =10003 ,code = "POSITIVE_SIGNS", column = "体格检查阳性体征" )
	private String  positiveSigns;

	@Item(index =10004 ,code = "ASSAY", column = "化验" )
	private String  assay;

	@Item(index =10005 ,code = "ECG", column = "心电图" )
	private String ecg;

	@Item(index =10006 ,code = "SPECIAL_EXAM", column = "特殊检查" )
	private String specialExam;

	@Item(index =10007 ,code = "OTHER_STATUS", column = "其他状况" )
	private String otherStatus;
	
	@Item(index =10008 ,code = "SMOKING", column = "吸烟量与以前相比" ,isDic=true,dicType="DMD00028" )
	private String smoking;

	@Item(index =10009 ,code = "DRINKING", column = "饮酒量与以前相比" ,isDic=true,dicType="DMD00028")
	private String drinking;

	@Item(index =10010 ,code = "MEAT", column = "肉类较以前摄入" ,isDic=true,dicType="DMD00028")
	private String meat;

	@Item(index =10100 ,code = "PRODUCE", column = "蔬菜水果较以前摄入" ,isDic=true,dicType="DMD00028" )
	private String produce;

	@Item(index =10101 ,code = "PHYSICAL_ACTIVITY", column = "体力活动较以前" ,isDic=true,dicType="DMD00028" )
	private String physicalActivity;

	@Item(index =10102 ,code = "ECG_TIMES", column = "测心电图次数"  ,isDic=true,dicType="DMD00029")
	private String ecgTimes;

	@Item(index =10103 ,code = "BLOOD_TIMES", column = "测血生化指标次数"   ,isDic=true,dicType="DMD00030" )
	private String bloodTimes;

	@Item(index =10105 ,code = "DRUG_PAYMENTS", column = "月平均药费支出（元）"  ,isDic=true,dicType="DMD00031" )
	private String drugPayments;
	
	@Item(index =10106 ,code = "BP_DRUG_FLAG", column = "血压用药",isDic=true,dicType="DMD00032" )
	private String bpDrugFlag;

	@Item(index =10107 , column = "血压用药第一种药物名称" )
	private String bpDrugNameFirst;

	@Item(index =10108 ,code = "BP_DRUG_METHOD_FIRST", column = "血压用药第一种药物使用方法" )
	private String bpDrugMethodFirst;


	@Item(index =10109 , column = "血压用药第二种药物名称" )
	private String bpDrugNameSecond;

	@Item(index =10110 ,code = "BP_DRUG_METHOD_SECOND", column = "血压用药第二种药物使用方法" )
	private String bpDrugMethodSecond;


	@Item(index =11000 ,code = "BP_DRUG_NAME_THIRD", column = "血压用药第三种药物名称" )
	private String bpDrugNameThird;

	@Item(index =11001 ,code = "BP_DRUG_METHOD_THIRD", column = "血压用药第三种药物使用方法" )
	private String bpDrugMethodThird;
	
	@Item(index =11002 ,code = "BP_DRUG_NO_REGULAR_REASON", column = "血压未规律用药原因" ,isDic=true,dicType="DMD00033"  )
	private String bpDrugNoRegularReason ;

	@Item(index =11003 ,code = "BG_DRUG_FLAG", column = "血糖用药" ,isDic=true,dicType="DMD00032" )
	private String bgDrugFlag;


	@Item(index =11004 ,code = "BG_DRUG_NAME_FIRST", column = "血糖用药第一种药物名称" )
	private String bgDrugNameFirst;

	@Item(index =11005 ,code = "BG_DRUG_METHOD_FIRST", column = "血糖用药第一种药物使用方法" )
	private String bgDrugMethodFirst;


	@Item(index =11006 ,code = "BG_DRUG_NAME_SECOND", column = "血糖用药第二种药物名称" )
	private String bgDrugNameSecond;

	@Item(index =11007 ,code = "BG_DRUG_METHOD_SECOND", column = "血糖用药第二种药物使用方法" )
	private String bgDrugMethodSecond;


	@Item(index =11008 ,code = "BG_DRUG_NAME_THIRD", column = "血糖用药第三种药物名称" )
	private String bgDrugNameThird;

	@Item(index =11009 ,code = "BG_DRUG_METHOD_THIRD", column = "血糖用药第三种药物使用方法" )
	private String bgDrugMethodThird;
	
	@Item(index =11100 ,code = "BG_DRUG_NO_REGULAR_REASON", column = "血糖未规律用药原因" ,isDic=true,dicType="DMD00033"  )
	private String bgDrugNoRegularReason ;

	@Item(index =11101 ,code = "BF_DRUG_FLAG", column = "血脂用药",isDic=true,dicType="DMD00032"  )
	private String bfDrugFlag;


	@Item(index =11102 ,code = "BF_DRUG_NAME_FIRST", column = "血脂用药第一种药物名称" )
	private String bfDrugNameFirst;

	@Item(index =11103 ,code = "BF_DRUG_METHOD_FIRST", column = "血脂用药第一种药物使用方法" )
	private String bfDrugMethodFirst;


	@Item(index =11104 ,code = "BF_DRUG_NAME_SECOND", column = "血脂用药第二种药物名称" )
	private String bfDrugNameSecond;

	@Item(index =11105 ,code = "BF_DRUG_METHOD_SECOND", column = "血脂用药第二种药物使用方法" )
	private String bfDrugMethodSecond;


	@Item(index =11106 ,code = "BF_DRUG_NAME_THIRD", column = "血脂用药第三种药物名称" )
	private String bfDrugNameThird;

	@Item(index =11107 ,code = "BF_DRUG_METHOD_THIRD", column = "血脂用药第三种药物使用方法" )
	private String bfDrugMethodThird;
	
	@Item(index =11108 ,code = "BF_DRUG_NO_REGULAR_REASON", column = "血脂未规律用药原因",isDic=true,dicType="DMD00033"  )
	private String bfDrugNoRegularReason ;

	@Item(index =11109 ,code = "NON_DRUGS", column = "非药物治疗措施",isDic=true, isMultiple = true,dicType="DMD00054")
	private String nonDrugs;
	
	@Item(index =11110 ,code = "NON_DRUGS_OTHER", column = "非药物治疗措施其它" )
	private String nonDrugsOther;

	@Item(index =11111,code = "HEDUCATION", column = "针对性健康教育" )
	private String heducation;
	
	@Item(index =11112 ,code = "CONCLUSION", column = "结论",isDic=true,dicType="DMD00035")
	private String conclusion;

	@Item(index =11113 ,code = "AFFIRM_PERSON", column = "确认人" )
	private String affirmPerson;

	@Item(index = 111114, column = "填报机构", isOrganization = true)
	private String createOrganCode;

	@Item(index = 111115, column = "填报人", isUser = true)
	private String createDoctorCode;

}
