package com.founder.rhip.ehr.entity.management;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.export.Item;
import com.founder.rhip.mdm.entity.Organization;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DM_DISEASE_INFO")
public class DmDiseaseInfo implements Serializable {

	private static final long serialVersionUID = -2969663235898012052L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "REPORT_INFO_ID", columnDefinition = "varchar2|dmReportInfo的主键的json字符串，分别对应5中慢病的报卡id||", length = 200, nullable = true)
	private String reportInfoId;


	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	@Item(index = 3, column = "身份证号")
	private String idcard;

	@Column(name = "HBP_FLAG", columnDefinition = "VARCHAR2|高血压标志||", length = 1, nullable = true)
	private String hbpFlag;//=2表示已管理

	@Column(name = "HBP_TYPE", columnDefinition = "VARCHAR2|高血压类型||", length = 1, nullable = true)
	private String hbpType;

	@Column(name = "HBP_ACCIDENT_DATE", columnDefinition = "DATE|高血压发病日期||", nullable = true)
	private Date hbpAccidentDate;

	@Column(name = "HBP_DIAGNOSIS_DATE", columnDefinition = "DATE|高血压诊断日期||", nullable = true)
	private Date hbpDiagnosisDate;

	@Column(name = "HBP_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|高血压诊断依据(多选)||", length = 100, nullable = true)
	private String hbpDiagnosisDepends;

	@Column(name = "HBP_MANAGE_LEVEL", columnDefinition = "SMALLINT|高血压管理等级||", nullable = true)
	private Integer hbpManageLevel;

	@Column(name = "HBP_SBP", columnDefinition = "SMALLINT|收缩压(mmHg)||", nullable = true)
	private Integer hbpSbp;

	@Column(name = "HBP_DBP", columnDefinition = "SMALLINT|舒张压(mmHg)||", nullable = true)
	private Integer hbpDbp;

	@Column(name = "HBP_DIAGNOSED_ORGAN_NAME", columnDefinition = "VARCHAR2|高血压确诊医院名称||", length = 70, nullable = true)
	private String hbpDiagnosedOrganName;

	@Column(name = "HBP_DIAGNOSED_ORGAN_CODE", columnDefinition = "VARCHAR2|高血压确诊医院编码||", length = 50, nullable = true)
	private String hbpDiagnosedOrganCode;

	@Column(name = "HBP_OTHER_DIAGNOSIS_ORGAN_NAME", columnDefinition = "VARCHAR2|高血压其它诊断机构名称||", length = 70, nullable = true)
	private String hbpOtherDiagnosisOrganName;

	@Column(name = "HBP_OTHER_DIAGNOSIS_ORGAN_FLAG", columnDefinition = "VARCHAR2|高血压其它诊断机构标志||", length = 2, nullable = true)
	private String hbpOtherDiagnosisOrganFlag;

	@Column(name = "HBP_DIAGNOSED_DATE", columnDefinition = "DATE|高血压确诊时间||", nullable = true)
	private Date hbpDiagnosedDate;

	@Column(name = "HBP_CEREBROVASCULAR_FLAG", columnDefinition = "VARCHAR2|脑血管疾病标志||", length = 1, nullable = true)
	private String hbpCerebrovascularFlag;

	@Column(name = "HBP_HEART_FLAG", columnDefinition = "VARCHAR2|心脏疾病标志||", length = 1, nullable = true)
	private String hbpHeartFlag;

	@Column(name = "HBP_KIDNEY_FLAG", columnDefinition = "VARCHAR2|肾脏疾病标志||", length = 1, nullable = true)
	private String hbpKidneyFlag;

	@Column(name = "HBP_VASCULAR_FLAG", columnDefinition = "VARCHAR2|血管疾病标志||", length = 1, nullable = true)
	private String hbpVascularFlag;

	@Column(name = "HBP_RETINOPATHY_FLAG", columnDefinition = "VARCHAR2|高度高血压性视网膜病变标志||", length = 1, nullable = true)
	private String hbpRetinopathyFlag;

	@Column(name = "HBP_SELFLIVE_FLAG", columnDefinition = "VARCHAR2|生活自理能力(高血压)标志||", length = 1, nullable = true)
	private String hbpSelfliveFlag;

	@Column(name = "HBP_MANAGED_DATE", columnDefinition = "DATE|高血压纳入日期||", nullable = true)
	private Date hbpManagedDate;

	@Column(name = "HBP_CREATE_DATE", columnDefinition = "TIMESTAMP|高血压填报时间||", nullable = true)
	private Date hbpCreateDate;

	@Column(name = "HBP_UPDATE_DATE", columnDefinition = "TIMESTAMP|高血压更新日期和时间||", nullable = true)
	private Date hbpUpdateDate;

	@Column(name = "HBP_CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|高血压填报机构||", nullable = true)
	private String hbpCreateOrganCode;

	@Column(name = "HBP_UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|高血压更新机构||", nullable = true)
	private String hbpUpdateOrganCode;

	@Column(name = "HBP_CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|高血压填报医务人员||", nullable = true)
	private String hbpCreateDoctorCode;

	@Column(name = "HBP_UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|高血压更新医务人员||", nullable = true)
	private String hbpUpdateDoctorCode;

	@Column(name = "DI_FLAG", columnDefinition = "VARCHAR2|糖尿病标志||", length = 1, nullable = true)
	private String diFlag;

	@Column(name = "DI_TYPE", columnDefinition = "VARCHAR2|糖尿病类型||", length = 1, nullable = true)
	private String diType;

	@Column(name = "DI_ACCIDENT_DATE", columnDefinition = "DATE|糖尿病发病日期||", nullable = true)
	private Date diAccidentDate;

	@Column(name = "DI_DIAGNOSIS_DATE", columnDefinition = "DATE|糖尿病诊断日期||", nullable = true)
	private Date diDiagnosisDate;

	@Column(name = "DI_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|糖尿病诊断依据(多选)||", length = 100, nullable = true)
	private String diDiagnosisDepends;

	@Column(name = "DI_DIAGNOSED_ORGAN_NAME", columnDefinition = "VARCHAR2|糖尿病确诊医院名称||", length = 70, nullable = true)
	private String diDiagnosedOrganName;

	@Column(name = "DI_OTHER_DIAGNOSIS_ORGAN_NAME", columnDefinition = "VARCHAR2|糖尿病其它诊断机构名称||", length = 70, nullable = true)
	private String diOtherDiagnosisOrganName;

	@Column(name = "DI_OTHER_DIAGNOSIS_ORGAN_FLAG", columnDefinition = "VARCHAR2|高血压其它诊断机构标志||", length = 2, nullable = true)
	private String diOtherDiagnosisOrganFlag;

	@Column(name = "DI_DIAGNOSED_ORGAN_CODE", columnDefinition = "VARCHAR2|糖尿病确诊医院编码||", length = 50, nullable = true)
	private String diDiagnosedOrganCode;

	@Column(name = "DI_DIAGNOSED_DATE", columnDefinition = "DATE|糖尿病确诊时间||", nullable = true)
	private Date diDiagnosedDate;

	@Column(name = "DI_DIAGNOSED_WAY", columnDefinition = "VARCHAR2|糖尿病确诊方式||", length = 300, nullable = true)
	private String diDiagnosedWay;

	@Column(name = "DI_COM_HBP_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症高血压标志||", length = 1, nullable = true)
	private String diComHbpFlag;

	@Column(name = "DI_COM_DI_FOOT_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症糖尿病足||", length = 1, nullable = true)
	private String diComDiFootFlag;

	@Column(name = "DI_COM_NEUROPATHY_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症神经病变||", length = 1, nullable = true)
	private String diComNeuropathyFlag;

	@Column(name = "DI_COM_STROKE_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症脑卒中||", length = 1, nullable = true)
	private String diComStrokeFlag;

	@Column(name = "DI_COM_FPG", columnDefinition = "DECIMAL|糖尿病确诊并发症既往空腹血糖||", length = 5, scale = 2, nullable = true)
	private BigDecimal diComFpg;

	@Column(name = "DI_COM_HGB", columnDefinition = "SMALLINT|糖尿病确诊并发症既往糖化血红蛋白||", length = 5, scale = 2, nullable = true)
	private BigDecimal diComHgb;

	@Column(name = "DI_COM_RETY_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症视网膜病变||", length = 1, nullable = true)
	private String diComRetyFlag;

	@Column(name = "DI_COM_KIDNEY_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症糖尿病肾病||", length = 1, nullable = true)
	private String diComKidneyFlag;

	@Column(name = "DI_COM_HBC_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症高血脂||", length = 1, nullable = true)
	private String diComHbcFlag;

	@Column(name = "DI_COM_SMOKING_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症吸烟||", length = 1, nullable = true)
	private String diComSmokingFlag;

	@Column(name = "DI_COM_SMOKING_DAILY_NUM", columnDefinition = "INT|糖尿病确诊并发症吸烟每日数量||", length = 3, nullable = true)
	private Integer diComSmokingDailyNum;

	@Column(name = "DI_COM_DRINKING_FLAG", columnDefinition = "VARCHAR2|糖尿病确诊并发症饮酒||", length = 1, nullable = true)
	private String diComDrinkingFlag;

	@Column(name = "DI_COM_DRINKINGDAILY_NUM", columnDefinition = "INT|糖尿病确诊并发症饮酒每日数量||", length = 3, nullable = true)
	private Integer diComDrinkingdailyNum;

	@Column(name = "DI_CCOM_CORONARY_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症冠心病||", length = 1, nullable = true)
	private String diCcomCoronaryFlag;

	@Column(name = "DI_CCOM_CORONARY_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症冠心病诊断时间||", nullable = true)
	private Date diCcomCoronaryDisDate;

	@Column(name = "DI_CCOM_CORONARY_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症冠心病治疗方式||", length = 1, nullable = true)
	private String diCcomCoronaryTreatment;

	@Column(name = "DI_CCOM_HBP_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症高血压||", length = 1, nullable = true)
	private String diCcomHbpFlag;

	@Column(name = "DI_CCOM_HBP_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症高血压诊断时间||", nullable = true)
	private Date diCcomHbpDisDate;

	@Column(name = "DI_CCOM_HBP_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症高血压治疗方式||", length = 200, nullable = true)
	private String diCcomHbpTreatment;

	@Column(name = "DI_CCOM_HBC_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症高血脂||", length = 1, nullable = true)
	private String diCcomHbcFlag;

	@Column(name = "DI_CCOM_HBC_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症高血脂诊断时间||", nullable = true)
	private Date diCcomHbcDisDate;

	@Column(name = "DI_CCOM_HBC_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症高血脂治疗方式||", length = 200, nullable = true)
	private String diCcomHbcTreatment;

	@Column(name = "DI_CCOM_RETY_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症视网膜病变||", length = 1, nullable = true)
	private String diCcomRetyFlag;

	@Column(name = "DI_CCOM_RETY_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症视网膜病变诊断时间||", nullable = true)
	private Date diCcomRetyDisDate;

	@Column(name = "DI_CCOM_RETYP_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症视网膜病变治疗方式||", length = 200, nullable = true)
	private String diCcomRetypTreatment;

	@Column(name = "DI_CCOM_NERVE_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症周围神经病变||", length = 1, nullable = true)
	private String diCcomNerveFlag;

	@Column(name = "DI_CCOM_NERVE_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症周围神经病变诊断时间||", nullable = true)
	private Date diCcomNerveDisDate;

	@Column(name = "DI_CCOM_NERVE_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症周围神经病变治疗方式||", length = 200, nullable = true)
	private String diCcomNerveTreatment;

	@Column(name = "DI_CCOM_KIDNEY_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症肾病||", length = 1, nullable = true)
	private String diCcomKidneyFlag;

	@Column(name = "DI_CCOM_KIDNEY_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症肾病诊断时间||", nullable = true)
	private Date diCcomKidneyDisDate;

	@Column(name = "DI_CCOM_KIDNEY_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症肾病治疗方式||", length = 200, nullable = true)
	private String diCcomKidneyTreatment;

	@Column(name = "DI_CCOM_FOOT_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症足部病变||", length = 1, nullable = true)
	private String diCcomFootFlag;

	@Column(name = "DI_CCOM_FOOT_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症足部病变诊断时间||", nullable = true)
	private Date diCcomFootDisDate;

	@Column(name = "DI_CCOM_FOOT_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症足部病变治疗方式||", length = 200, nullable = true)
	private String diCcomFootTreatment;

	@Column(name = "DI_CCOM_STROKE_FLAG", columnDefinition = "VARCHAR2|糖尿病目前并发症脑卒中||", length = 1, nullable = true)
	private String diCcomStrokeFlag;

	@Column(name = "DI_CCOM_STROKE_DIS_DATE", columnDefinition = "DATE|糖尿病目前并发症脑卒中诊断时间||", nullable = true)
	private Date diCcomStrokeDisDate;

	@Column(name = "DI_CCOM_STROKE_TREATMENT", columnDefinition = "VARCHAR2|糖尿病目前并发症脑卒中治疗方式||", length = 200, nullable = true)
	private String diCcomStrokeTreatment;

	@Column(name = "DI_RT_DIET_CONTROL_FLAG", columnDefinition = "VARCHAR2|糖尿病近期治疗情况饮食控制||", length = 1, nullable = true)
	private String diRtDietControlFlag;

	@Column(name = "DI_RT_PHY_ACTIVITY_FLAG", columnDefinition = "VARCHAR2|糖尿病近期治疗情况体力活动||", length = 1, nullable = true)
	private String diRtPhyActivityFlag;

	@Column(name = "DI_RT_PHY_ACTIVITY_WEEK_COUNT", columnDefinition = "INT|糖尿病近期治疗情况体力活动每周次数||", length = 4, nullable = true)
	private Integer diRtPhyActivityWeekCount;

	@Column(name = "DI_RT_PHY_ACTIVITY_TIME", columnDefinition = "INT|糖尿病近期治疗情况体力活动每次时长||", length = 5, nullable = true)
	private Integer diRtPhyActivityTime;

	@Column(name = "DI_RT_HYP_DRUGS_FLAG", columnDefinition = "VARCHAR2|糖尿病近期治疗情况口服降糖药||", length = 1, nullable = true)
	private String diRtHypDrugsFlag;

	@Column(name = "DI_RT_HYP_DRUGS_DAILY_COUNT", columnDefinition = "INT|糖尿病近期治疗情况口服降糖药每日次数||", length = 2, nullable = true)
	private Integer diRtHypDrugsDailyCount;

	@Column(name = "DI_RT_HYP_DRUGSPER_DOSE", columnDefinition = "INT|糖尿病近期治疗情况口服降糖药每次药量||", length = 4, scale = 1, nullable = true)
	private BigDecimal diRtHypDrugsperDose;

	@Column(name = "DI_RT_HYP_DRUGSPER_DOSE_UNIT", columnDefinition = "VARCHAR2|糖尿病近期治疗情况口服降糖药每次药量单位||", length = 3, nullable = true)
	private String diRtHypDrugsperDoseUnit;

	@Column(name = "DI_RT_INSULIN_FLAG", columnDefinition = "VARCHAR2|糖尿病近期治疗情况胰岛素||", length = 1, nullable = true)
	private String diRtInsulinFlag;

	@Column(name = "DI_RT_INSULIN_DAILY_COUNT", columnDefinition = "INT|糖尿病近期治疗情况胰岛素每日次数||", length = 2, nullable = true)
	private Integer diRtInsulinDailyCount;

	@Column(name = "DI_RT_INSULIN_PER_DOSE", columnDefinition = "INT|糖尿病近期治疗情况胰岛素每次用量||", length = 5, scale = 1, nullable = true)
	private BigDecimal diRtInsulinPerDose;

	@Column(name = "DI_RT_INSULIN_PER_DOSE_UNIT", columnDefinition = "VARCHAR2|糖尿病近期治疗情况胰岛素每次用量单位||", length = 2, nullable = true)
	private String diRtInsulinPerDoseUnit;

	@Column(name = "DI_RT_QUIT_SMOKING_FLAG", columnDefinition = "VARCHAR2|糖尿病近期治疗情况戒烟||", length = 1, nullable = true)
	private String diRtQuitSmokingFlag;

	@Column(name = "DI_RT_LIMIT_DRINKING_FLAG", columnDefinition = "VARCHAR2|糖尿病近期治疗情况限酒||", length = 1, nullable = true)
	private String diRtLimitDrinkingFlag;

	@Column(name = "DI_RT_DOCTOR_NAME", columnDefinition = "VARCHAR2|糖尿病近期治疗情况责任医生||", length = 50, nullable = true)
	private String diRtDoctorName;

	@Column(name = "DI_RT_DOCTOR_CODE", columnDefinition = "VARCHAR2|糖尿病近期治疗情况责任医生身份证||", length = 18, nullable = true)
	private String diRtDoctorCode;

	@Column(name = "DI_RT_INPUT_DATE", columnDefinition = "DATE|糖尿病近期治疗情况建档时间||", nullable = true)
	private Date diRtInputDate;

	@Column(name = "DI_MANAGED_DATE", columnDefinition = "DATE|糖尿病纳入日期||", nullable = true)
	private Date diManagedDate;

	@Column(name = "DI_CREATE_DATE", columnDefinition = "TIMESTAMP|糖尿病填报时间||", nullable = true)
	private Date diCreateDate;

	@Column(name = "DI_UPDATE_DATE", columnDefinition = "TIMESTAMP|糖尿病更新日期和时间||", nullable = true)
	private Date diUpdateDate;

	@Column(name = "DI_CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|糖尿病填报机构||", nullable = true)
	private String diCreateOrganCode;

	@Column(name = "DI_UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|糖尿病更新机构||", nullable = true)
	private String diUpdateOrganCode;

	@Column(name = "DI_CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|糖尿病填报医务人员||", nullable = true)
	private String diCreateDoctorCode;

	@Column(name = "DI_UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|糖尿病更新医务人员||", nullable = true)
	private String diUpdateDoctorCode;

	@Column(name = "STROKE_FLAG", columnDefinition = "VARCHAR2|脑卒中标志||", length = 1, nullable = true)
	private String strokeFlag;

	@Column(name = "STROKE_TYPE", columnDefinition = "VARCHAR2|脑卒中类型||", length = 1, nullable = true)
	private String strokeType;

	@Column(name = "STROKE_ACCIDENT_DATE", columnDefinition = "DATE|脑卒中类型发病日期||", nullable = true)
	private Date strokeAccidentDate;

	@Column(name = "STROKE_DIAGNOSIS_DATE", columnDefinition = "DARE|脑卒中类型诊断日期||", nullable = true)
	private Date strokeDiagnosisDate;

	@Column(name = "STROKE_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|脑卒中类型诊断依据(多选)||", length = 100, nullable = true)
	private String strokeDiagnosisDepends;

	@Column(name = "STROKE_FAMILY_HIS_FLAG", columnDefinition = "VARCHAR2|脑卒中家族史标志||", length = 1, nullable = true)
	private String strokeFamilyHisFlag;

	@Column(name = "STROKE_BODY_LIMIT_FLAG", columnDefinition = "VARCHAR2|脑卒中身体活动受限标志||", length = 1, nullable = true)
	private String strokeBodyLimitFlag;

	@Column(name = "STROKE_MANAGED_DATE", columnDefinition = "DATE|脑卒中纳入日期||", nullable = true)
	private Date strokeManagedDate;

	@Column(name = "STROKE_CREATE_DATE", columnDefinition = "TIMESTAMP|脑卒中填报时间||", nullable = true)
	private Date strokeCreateDate;

	@Column(name = "STROKE_UPDATE_DATE", columnDefinition = "TIMESTAMP|脑卒中更新日期和时间||", nullable = true)
	private Date strokeUpdateDate;

	@Column(name = "STROKE_CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|脑卒中填报机构||", nullable = true)
	private String strokeCreateOrganCode;

	@Column(name = "STROKE_UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|脑卒中更新机构||", nullable = true)
	private String strokeUpdateOrganCode;

	@Column(name = "STROKE_CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|脑卒中填报医务人员||", nullable = true)
	private String strokeCreateDoctorCode;

	@Column(name = "STROKE_UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|脑卒中更新医务人员||", nullable = true)
	private String strokeUpdateDoctorCode;

	@Column(name = "CORONARY_FLAG", columnDefinition = "VARCHAR2|冠心病标志||", length = 1, nullable = true)
	private String coronaryFlag;

	@Column(name = "CORONARY_TYPE", columnDefinition = "VARCHAR2|冠心病类型||", length = 1, nullable = true)
	private String coronaryType;

	@Column(name = "CORONARY_ACCIDENT_DATE", columnDefinition = "DATE|冠心病类型发病日期||", nullable = true)
	private Date coronaryAccidentDate;

	@Column(name = "CORONARY_DIAGNOSIS_DATE", columnDefinition = "DATE|冠心病中类型诊断日期||", nullable = true)
	private Date coronaryDiagnosisDate;

	@Column(name = "CORONARY_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|冠心病类型诊断依据(多选)||", length = 100, nullable = true)
	private String coronaryDiagnosisDepends;

	@Column(name = "CORONARY_FAMILY_HIS_FLAG", columnDefinition = "VARCHAR2|冠心病家族式标志||", length = 1, nullable = true)
	private String coronaryFamilyHisFlag;

	@Column(name = "CORONARY_BODY_LIMIT_FLAG", columnDefinition = "VARCHAR2|冠心病身体活动受限标志||", length = 1, nullable = true)
	private String coronaryBodyLimitFlag;

	@Column(name = "CORONARY_MANAGED_DATE", columnDefinition = "DATE|冠心病纳入日期||", nullable = true)
	private Date coronaryManagedDate;

	@Column(name = "CORONARY_CREATE_DATE", columnDefinition = "TIMESTAMP|冠心病填报时间||", nullable = true)
	private Date coronaryCreateDate;

	@Column(name = "CORONARY_UPDATE_DATE", columnDefinition = "TIMESTAMP|冠心病更新日期和时间||", nullable = true)
	private Date coronaryUpdateDate;

	@Column(name = "CORONARY_CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|冠心病填报机构||", nullable = true)
	private String coronaryCreateOrganCode;

	@Column(name = "CORONARY_UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|冠心病更新机构||", nullable = true)
	private String coronaryUpdateOrganCode;

	@Column(name = "CORONARY_CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|冠心病填报医务人员||", nullable = true)
	private String coronaryCreateDoctorCode;

	@Column(name = "CORONARY_UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|冠心病更新医务人员||", nullable = true)
	private String coronaryUpdateDoctorCode;

	@Column(name = "TUMOR_FLAG", columnDefinition = "VARCHAR2|肿瘤标志||", length = 1, nullable = true)
	private String tumorFlag;

	@Column(name = "TUMOR_TYPE", columnDefinition = "VARCHAR2|肿瘤病名||", length = 50, nullable = true)
	private String tumorType;

	@Column(name = "TUMOR_ICD_TEN_CODE", columnDefinition = "VARCHAR2|ICD-10编码||", length = 8, nullable = true)
	private String tumorIcdTenCode;

	@Column(name = "TUMOR_ICD_TEN_NAME", columnDefinition = "VARCHAR2|ICD-10名称||", length = 50, nullable = true)
	private String tumorIcdTenName;

	@Column(name = "TUMOR_PRIMARY_PART", columnDefinition = "VARCHAR2|原发部位||", length = 100, nullable = true)
	private String tumorPrimaryPart;

	@Column(name = "TUMOR_METASTASIS_PART", columnDefinition = "VARCHAR2|肿瘤患者转移部位||", length = 100, nullable = true)
	private String tumorMetastasisPart;

	@Column(name = "TUMOR_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|诊断依据||", length = 100, nullable = true)
	private String tumorDiagnosisDepends;

	@Column(name = "TUMOR_PATHOLOGY_TYPE", columnDefinition = "VARCHAR2|病理类型||", length = 50, nullable = true)
	private String tumorPathologyType;

	@Column(name = "TUMOR_ICD_THREE_CODE", columnDefinition = "VARCHAR2|ICD-0-3编码||", length = 8, nullable = true)
	private String tumorIcdThreeCode;

	@Column(name = "TUMOR_ACCIDENT_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date tumorAccidentDate;

	@Column(name = "TUMOR_DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date tumorDiagnosisDate;

	@Column(name = "TUMOR_INFORMED_FLAG", columnDefinition = "VARCHAR2|知情状态标志||", length = 1, nullable = true)
	private String tumorInformedFlag;

	@Column(name = "TUMOR_MANAGED_DATE", columnDefinition = "DATE|肿瘤纳入日期||", nullable = true)
	private Date tumorManagedDate;

	@Column(name = "TUMOR_CREATE_DATE", columnDefinition = "TIMESTAMP|肿瘤填报时间||", nullable = true)
	private Date tumorCreateDate;

	@Column(name = "TUMOR_CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|肿瘤填报机构||", nullable = true)
	private String tumorCreateOrganCode;

	@Column(name = "TUMOR_UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|肿瘤更新机构||", nullable = true)
	private String tumorUpdateOrganCode;

	@Column(name = "TUMOR_CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|肿瘤填报医务人员||", nullable = true)
	private String tumorCreateDoctorCode;

	@Column(name = "TUMOR_UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|肿瘤更新医务人员||", nullable = true)
	private String tumorUpdateDoctorCode;

	@Column(name = "TUMOR_UPDATE_DATE", columnDefinition = "TIMESTAMP|肿瘤更新日期和时间||", nullable = true)
	private Date tumorUpdateDate;

	@Column(name = "LAST_HBP_PLAN_YEAR", columnDefinition = "VARCHAR2|最后一次管理计划年数||", length = 4, nullable = true)
	private String lastHbpPlanYear;

	@Column(name = "LAST_DI_PLAN_YEAR", columnDefinition = "VARCHAR2|最后一次管理计划年数||", length = 4, nullable = true)
	private String lastDiPlanYear;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "STATUS", columnDefinition = "INT|管理状态 1:管理状态正常 2:管理状态为注销||", nullable = true)
	private String status;
	
	@Column(name = "NEXT_HBP_FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|下次随访日期||", nullable = true)
	private Date nextHbpFollowupDate;

	@Column(name = "NEXT_DI_FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|下次随访日期|", nullable = true)
	private Date nextDiFollowupDate;

	@Column(name = "NEXT_STROKE_FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|下次随访日期||", nullable = true)
	private Date nextStrokeFollowupDate;

	@Column(name = " NEXT_CORONARY_FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|下次随访日期||", nullable = true)
	private Date nextCoronaryFollowupDate;

	@Column(name = "NEXT_TUMOR_FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|下次随访日期||", nullable = true)
	private Date nextTumorFollowupDate;

	@Column(name = "LAST_PHY_EXAMINATION_YEAR", columnDefinition = "TIMESTAMP|最后一次体检日期||", nullable = true)
	private Integer lastPhyExaminationYear;

//	@Column(name = "HBP_MANAGED_FLAG", columnDefinition = "VARCHAR2|管理标志||", length = 2, nullable = true)
//	private String hbpManagedFlag;
//
//	@Column(name = "DI_MANAGED_FLAG", columnDefinition = "VARCHAR2|管理标志||", length = 2, nullable = true)
//	private String diManagedFlag;

	@Column(name = "STROKE_MANAGED_FLAG", columnDefinition = "VARCHAR2|管理标志||", length = 2, nullable = true)
	private String strokeManagedFlag;

	@Column(name = "CORONARY_MANAGED_FLAG", columnDefinition = "VARCHAR2|管理标志||", length = 2, nullable = true)
	private String coronaryManagedFlag;

	@Column(name = "TUMOR_MANAGED_FLAG", columnDefinition = "VARCHAR2|管理标志||", length = 2, nullable = true)
	private String tumorManagedFlag;

	@Column(name = "STROKE_MANAGED_FAY_FLAG", columnDefinition = "VARCHAR2|是否满一年标志||", length = 2, nullable = true)
	private String strokeManagedFayFlag;

	@Column(name = "CORONARY_MANAGED_FAY_FLAG", columnDefinition = "VARCHAR2|是否满一年标志||", length = 2, nullable = true)
	private String coronaryManagedFayFlag;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

	@Transient
	private List<DmReportInfo> tumorReports;// 显示肿瘤的报卡

	@Transient
	private List<DmReportInfo> toManagedReports;// 改管理卡纳入时被纳入的报卡的id

	@Transient
	private DmPersonInfo dmPersonInfo;// 慢病患者信息

	@Transient
	private PersonInfo personInfo;// ehr人员信息

	@Transient
	private Organization currentOrganization;

	@Transient
	private User currentUser;

	@Transient
	@Item(index = 1, isDic = false, column = "姓名")
	private String name;

	@Transient
	@Item(index = 2, column = "性别", isDic = true, dicType = "GBT226112003")
	private String gender;

	@Transient
	private String reportStatus;

	@Transient
	private String paprovince;

	@Transient
	private String pacity;

	@Transient
	private String pacounty;

	@Transient
	private String patownShip;

	@Transient
	private String pastreet;

	@Transient
	private String pahouseNumber;
	/*@Transient
	private String paGroup;*/
	@Transient
	@Item(index = 5, column = "联系电话")
	private String phoneNumber;

	@Transient
	@Item(index = 4, column = "生日日期", isDate = true, datePattern = "yyyy/MM/dd")
	private Date birthday;

	@Item(index = 6, column = "管理机构")
	@Transient
	private String organName;

	@Item(index = 7, column = "患病类型")
	@Transient
	private String dieaseName;
    @Transient
	private boolean checkHbpNextFollowupDateStatus;

    @Transient
	private boolean checkDiNextFollowupDateStatus;

    @Transient
	private boolean checkCoronaryNextFollowupDateStatus;

    @Transient
	private boolean checkTumorNextFollowupDateStatus;

    @Transient
	private boolean checkStrokeNextFollowupDateStatus;

    @Transient
    private Integer followupCountHbp;

    @Transient
    private Integer followupCountDi;

    @Transient
    private Integer followupCountStroke;

    @Transient
    private Integer followupCountCoronary;

    @Transient
    private Integer followupCountTumor;
    
    @Transient
    private String hbpAccidentDateDesc;
    
    @Transient
    private String hbpKind;
    
    @Transient
    private String hbpKindDesc;
    
    @Transient
    private String updateDateDesc;
    
    @Transient
    private String diDiagnosisDateDesc;
    
    @Transient
    private String diAccidentDateDesc;
    
    @Transient
    private String tumorAccidentDateDesc;
    
    @Transient
    private String diDiagnosisDependsDesc;

	public boolean isCheckHbpNextFollowupDateStatus() {
		return checkHbpNextFollowupDateStatus;
	}

	public void setCheckHbpNextFollowupDateStatus(boolean checkHbpNextFollowupDateStatus) {
		this.checkHbpNextFollowupDateStatus = checkHbpNextFollowupDateStatus;
	}

	public boolean isCheckDiNextFollowupDateStatus() {
		return checkDiNextFollowupDateStatus;
	}

	public void setCheckDiNextFollowupDateStatus(boolean checkDiNextFollowupDateStatus) {
		this.checkDiNextFollowupDateStatus = checkDiNextFollowupDateStatus;
	}

	public boolean isCheckCoronaryNextFollowupDateStatus() {
		return checkCoronaryNextFollowupDateStatus;
	}

	public void setCheckCoronaryNextFollowupDateStatus(boolean checkCoronaryNextFollowupDateStatus) {
		this.checkCoronaryNextFollowupDateStatus = checkCoronaryNextFollowupDateStatus;
	}

	public boolean isCheckTumorNextFollowupDateStatus() {
		return checkTumorNextFollowupDateStatus;
	}

	public void setCheckTumorNextFollowupDateStatus(boolean checkTumorNextFollowupDateStatus) {
		this.checkTumorNextFollowupDateStatus = checkTumorNextFollowupDateStatus;
	}

	public boolean isCheckStrokeNextFollowupDateStatus() {
		return checkStrokeNextFollowupDateStatus;
	}

	public void setCheckStrokeNextFollowupDateStatus(boolean checkStrokeNextFollowupDateStatus) {
		this.checkStrokeNextFollowupDateStatus = checkStrokeNextFollowupDateStatus;
	}

	public String getPaprovince() {
		return paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public DmPersonInfo getDmPersonInfo() {
		return dmPersonInfo;
	}

	public void setDmPersonInfo(DmPersonInfo dmPersonInfo) {
		this.dmPersonInfo = dmPersonInfo;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getHbpFlag() {
		return this.hbpFlag;
	}

	public void setHbpFlag(String hbpFlag) {
		this.hbpFlag = hbpFlag;
	}

	public String getHbpType() {
		return this.hbpType;
	}

	public void setHbpType(String hbpType) {
		this.hbpType = hbpType;
	}

	public Date getHbpAccidentDate() {
		return this.hbpAccidentDate;
	}

	public void setHbpAccidentDate(Date hbpAccidentDate) {
		this.hbpAccidentDate = hbpAccidentDate;
	}

	public Date getHbpDiagnosisDate() {
		return this.hbpDiagnosisDate;
	}

	public void setHbpDiagnosisDate(Date hbpDiagnosisDate) {
		this.hbpDiagnosisDate = hbpDiagnosisDate;
	}

	public String getHbpDiagnosisDepends() {
		return this.hbpDiagnosisDepends;
	}

	public void setHbpDiagnosisDepends(String hbpDiagnosisDepends) {
		this.hbpDiagnosisDepends = hbpDiagnosisDepends;
	}

	public Integer getHbpManageLevel() {
		return this.hbpManageLevel;
	}

	public void setHbpManageLevel(Integer hbpManageLevel) {
		this.hbpManageLevel = hbpManageLevel;
	}

	public Integer getHbpSbp() {
		return this.hbpSbp;
	}

	public void setHbpSbp(Integer hbpSbp) {
		this.hbpSbp = hbpSbp;
	}

	public Integer getHbpDbp() {
		return this.hbpDbp;
	}

	public void setHbpDbp(Integer hbpDbp) {
		this.hbpDbp = hbpDbp;
	}

	public String getHbpDiagnosedOrganName() {
		return this.hbpDiagnosedOrganName;
	}

	public void setHbpDiagnosedOrganName(String hbpDiagnosedOrganName) {
		this.hbpDiagnosedOrganName = hbpDiagnosedOrganName;
	}

	public String getHbpDiagnosedOrganCode() {
		return this.hbpDiagnosedOrganCode;
	}

	public void setHbpDiagnosedOrganCode(String hbpDiagnosedOrganCode) {
		this.hbpDiagnosedOrganCode = hbpDiagnosedOrganCode;
	}

	public Date getHbpDiagnosedDate() {
		return this.hbpDiagnosedDate;
	}

	public void setHbpDiagnosedDate(Date hbpDiagnosedDate) {
		this.hbpDiagnosedDate = hbpDiagnosedDate;
	}

	public String getHbpCerebrovascularFlag() {
		return this.hbpCerebrovascularFlag;
	}

	public void setHbpCerebrovascularFlag(String hbpCerebrovascularFlag) {
		this.hbpCerebrovascularFlag = hbpCerebrovascularFlag;
	}

	public String getHbpHeartFlag() {
		return this.hbpHeartFlag;
	}

	public void setHbpHeartFlag(String hbpHeartFlag) {
		this.hbpHeartFlag = hbpHeartFlag;
	}

	public String getHbpKidneyFlag() {
		return this.hbpKidneyFlag;
	}

	public void setHbpKidneyFlag(String hbpKidneyFlag) {
		this.hbpKidneyFlag = hbpKidneyFlag;
	}

	public String getHbpVascularFlag() {
		return this.hbpVascularFlag;
	}

	public void setHbpVascularFlag(String hbpVascularFlag) {
		this.hbpVascularFlag = hbpVascularFlag;
	}

	public String getHbpRetinopathyFlag() {
		return this.hbpRetinopathyFlag;
	}

	public void setHbpRetinopathyFlag(String hbpRetinopathyFlag) {
		this.hbpRetinopathyFlag = hbpRetinopathyFlag;
	}

	public String getHbpSelfliveFlag() {
		return this.hbpSelfliveFlag;
	}

	public void setHbpSelfliveFlag(String hbpSelfliveFlag) {
		this.hbpSelfliveFlag = hbpSelfliveFlag;
	}

	public String getDiFlag() {
		return this.diFlag;
	}

	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}

	public String getDiType() {
		return this.diType;
	}

	public void setDiType(String diType) {
		this.diType = diType;
	}

	public Date getDiAccidentDate() {
		return this.diAccidentDate;
	}

	public void setDiAccidentDate(Date diAccidentDate) {
		this.diAccidentDate = diAccidentDate;
	}

	public Date getDiDiagnosisDate() {
		return this.diDiagnosisDate;
	}

	public void setDiDiagnosisDate(Date diDiagnosisDate) {
		this.diDiagnosisDate = diDiagnosisDate;
	}

	public String getDiDiagnosisDepends() {
		return this.diDiagnosisDepends;
	}

	public void setDiDiagnosisDepends(String diDiagnosisDepends) {
		this.diDiagnosisDepends = diDiagnosisDepends;
	}

	public String getDiDiagnosedOrganName() {
		return this.diDiagnosedOrganName;
	}

	public void setDiDiagnosedOrganName(String diDiagnosedOrganName) {
		this.diDiagnosedOrganName = diDiagnosedOrganName;
	}

	public String getDiDiagnosedOrganCode() {
		return this.diDiagnosedOrganCode;
	}

	public void setDiDiagnosedOrganCode(String diDiagnosedOrganCode) {
		this.diDiagnosedOrganCode = diDiagnosedOrganCode;
	}

	public Date getDiDiagnosedDate() {
		return this.diDiagnosedDate;
	}

	public void setDiDiagnosedDate(Date diDiagnosedDate) {
		this.diDiagnosedDate = diDiagnosedDate;
	}

	public String getDiDiagnosedWay() {
		return this.diDiagnosedWay;
	}

	public void setDiDiagnosedWay(String diDiagnosedWay) {
		this.diDiagnosedWay = diDiagnosedWay;
	}

	public String getDiComHbpFlag() {
		return this.diComHbpFlag;
	}

	public void setDiComHbpFlag(String diComHbpFlag) {
		this.diComHbpFlag = diComHbpFlag;
	}

	public String getDiComDiFootFlag() {
		return this.diComDiFootFlag;
	}

	public void setDiComDiFootFlag(String diComDiFootFlag) {
		this.diComDiFootFlag = diComDiFootFlag;
	}

	public String getDiComNeuropathyFlag() {
		return this.diComNeuropathyFlag;
	}

	public void setDiComNeuropathyFlag(String diComNeuropathyFlag) {
		this.diComNeuropathyFlag = diComNeuropathyFlag;
	}

	public String getDiComStrokeFlag() {
		return this.diComStrokeFlag;
	}

	public void setDiComStrokeFlag(String diComStrokeFlag) {
		this.diComStrokeFlag = diComStrokeFlag;
	}

	public BigDecimal getDiComFpg() {
		return this.diComFpg;
	}

	public void setDiComFpg(BigDecimal diComFpg) {
		this.diComFpg = diComFpg;
	}

	public BigDecimal getDiComHgb() {
		return this.diComHgb;
	}

	public void setDiComHgb(BigDecimal diComHgb) {
		this.diComHgb = diComHgb;
	}

	public String getDiComRetyFlag() {
		return this.diComRetyFlag;
	}

	public void setDiComRetyFlag(String diComRetyFlag) {
		this.diComRetyFlag = diComRetyFlag;
	}

	public String getDiComKidneyFlag() {
		return this.diComKidneyFlag;
	}

	public void setDiComKidneyFlag(String diComKidneyFlag) {
		this.diComKidneyFlag = diComKidneyFlag;
	}

	public String getDiComHbcFlag() {
		return this.diComHbcFlag;
	}

	public void setDiComHbcFlag(String diComHbcFlag) {
		this.diComHbcFlag = diComHbcFlag;
	}

	public String getDiComSmokingFlag() {
		return this.diComSmokingFlag;
	}

	public void setDiComSmokingFlag(String diComSmokingFlag) {
		this.diComSmokingFlag = diComSmokingFlag;
	}

	public Integer getDiComSmokingDailyNum() {
		return this.diComSmokingDailyNum;
	}

	public void setDiComSmokingDailyNum(Integer diComSmokingDailyNum) {
		this.diComSmokingDailyNum = diComSmokingDailyNum;
	}

	public String getDiComDrinkingFlag() {
		return this.diComDrinkingFlag;
	}

	public void setDiComDrinkingFlag(String diComDrinkingFlag) {
		this.diComDrinkingFlag = diComDrinkingFlag;
	}

	public Integer getDiComDrinkingdailyNum() {
		return this.diComDrinkingdailyNum;
	}

	public void setDiComDrinkingdailyNum(Integer diComDrinkingdailyNum) {
		this.diComDrinkingdailyNum = diComDrinkingdailyNum;
	}

	public String getDiCcomCoronaryFlag() {
		return this.diCcomCoronaryFlag;
	}

	public void setDiCcomCoronaryFlag(String diCcomCoronaryFlag) {
		this.diCcomCoronaryFlag = diCcomCoronaryFlag;
	}

	public Date getDiCcomCoronaryDisDate() {
		return this.diCcomCoronaryDisDate;
	}

	public void setDiCcomCoronaryDisDate(Date diCcomCoronaryDisDate) {
		this.diCcomCoronaryDisDate = diCcomCoronaryDisDate;
	}

	public String getDiCcomCoronaryTreatment() {
		return this.diCcomCoronaryTreatment;
	}

	public void setDiCcomCoronaryTreatment(String diCcomCoronaryTreatment) {
		this.diCcomCoronaryTreatment = diCcomCoronaryTreatment;
	}

	public String getDiCcomHbpFlag() {
		return this.diCcomHbpFlag;
	}

	public void setDiCcomHbpFlag(String diCcomHbpFlag) {
		this.diCcomHbpFlag = diCcomHbpFlag;
	}

	public Date getDiCcomHbpDisDate() {
		return this.diCcomHbpDisDate;
	}

	public void setDiCcomHbpDisDate(Date diCcomHbpDisDate) {
		this.diCcomHbpDisDate = diCcomHbpDisDate;
	}

	public String getDiCcomHbpTreatment() {
		return this.diCcomHbpTreatment;
	}

	public void setDiCcomHbpTreatment(String diCcomHbpTreatment) {
		this.diCcomHbpTreatment = diCcomHbpTreatment;
	}

	public String getDiCcomHbcFlag() {
		return this.diCcomHbcFlag;
	}

	public void setDiCcomHbcFlag(String diCcomHbcFlag) {
		this.diCcomHbcFlag = diCcomHbcFlag;
	}

	public Date getDiCcomHbcDisDate() {
		return this.diCcomHbcDisDate;
	}

	public void setDiCcomHbcDisDate(Date diCcomHbcDisDate) {
		this.diCcomHbcDisDate = diCcomHbcDisDate;
	}

	public String getDiCcomHbcTreatment() {
		return this.diCcomHbcTreatment;
	}

	public void setDiCcomHbcTreatment(String diCcomHbcTreatment) {
		this.diCcomHbcTreatment = diCcomHbcTreatment;
	}

	public String getDiCcomRetyFlag() {
		return this.diCcomRetyFlag;
	}

	public void setDiCcomRetyFlag(String diCcomRetyFlag) {
		this.diCcomRetyFlag = diCcomRetyFlag;
	}

	public Date getDiCcomRetyDisDate() {
		return this.diCcomRetyDisDate;
	}

	public void setDiCcomRetyDisDate(Date diCcomRetyDisDate) {
		this.diCcomRetyDisDate = diCcomRetyDisDate;
	}

	public String getDiCcomRetypTreatment() {
		return this.diCcomRetypTreatment;
	}

	public void setDiCcomRetypTreatment(String diCcomRetypTreatment) {
		this.diCcomRetypTreatment = diCcomRetypTreatment;
	}

	public String getDiCcomNerveFlag() {
		return this.diCcomNerveFlag;
	}

	public void setDiCcomNerveFlag(String diCcomNerveFlag) {
		this.diCcomNerveFlag = diCcomNerveFlag;
	}

	public Date getDiCcomNerveDisDate() {
		return this.diCcomNerveDisDate;
	}

	public void setDiCcomNerveDisDate(Date diCcomNerveDisDate) {
		this.diCcomNerveDisDate = diCcomNerveDisDate;
	}

	public String getDiCcomNerveTreatment() {
		return this.diCcomNerveTreatment;
	}

	public void setDiCcomNerveTreatment(String diCcomNerveTreatment) {
		this.diCcomNerveTreatment = diCcomNerveTreatment;
	}

	public String getDiCcomKidneyFlag() {
		return this.diCcomKidneyFlag;
	}

	public void setDiCcomKidneyFlag(String diCcomKidneyFlag) {
		this.diCcomKidneyFlag = diCcomKidneyFlag;
	}

	public Date getDiCcomKidneyDisDate() {
		return this.diCcomKidneyDisDate;
	}

	public void setDiCcomKidneyDisDate(Date diCcomKidneyDisDate) {
		this.diCcomKidneyDisDate = diCcomKidneyDisDate;
	}

	public String getDiCcomKidneyTreatment() {
		return this.diCcomKidneyTreatment;
	}

	public void setDiCcomKidneyTreatment(String diCcomKidneyTreatment) {
		this.diCcomKidneyTreatment = diCcomKidneyTreatment;
	}

	public String getDiCcomFootFlag() {
		return this.diCcomFootFlag;
	}

	public void setDiCcomFootFlag(String diCcomFootFlag) {
		this.diCcomFootFlag = diCcomFootFlag;
	}

	public Date getDiCcomFootDisDate() {
		return this.diCcomFootDisDate;
	}

	public void setDiCcomFootDisDate(Date diCcomFootDisDate) {
		this.diCcomFootDisDate = diCcomFootDisDate;
	}

	public String getDiCcomFootTreatment() {
		return this.diCcomFootTreatment;
	}

	public void setDiCcomFootTreatment(String diCcomFootTreatment) {
		this.diCcomFootTreatment = diCcomFootTreatment;
	}

	public String getDiCcomStrokeFlag() {
		return this.diCcomStrokeFlag;
	}

	public void setDiCcomStrokeFlag(String diCcomStrokeFlag) {
		this.diCcomStrokeFlag = diCcomStrokeFlag;
	}

	public Date getDiCcomStrokeDisDate() {
		return this.diCcomStrokeDisDate;
	}

	public void setDiCcomStrokeDisDate(Date diCcomStrokeDisDate) {
		this.diCcomStrokeDisDate = diCcomStrokeDisDate;
	}

	public String getDiCcomStrokeTreatment() {
		return this.diCcomStrokeTreatment;
	}

	public void setDiCcomStrokeTreatment(String diCcomStrokeTreatment) {
		this.diCcomStrokeTreatment = diCcomStrokeTreatment;
	}

	public String getDiRtDietControlFlag() {
		return this.diRtDietControlFlag;
	}

	public void setDiRtDietControlFlag(String diRtDietControlFlag) {
		this.diRtDietControlFlag = diRtDietControlFlag;
	}

	public String getDiRtPhyActivityFlag() {
		return this.diRtPhyActivityFlag;
	}

	public void setDiRtPhyActivityFlag(String diRtPhyActivityFlag) {
		this.diRtPhyActivityFlag = diRtPhyActivityFlag;
	}

	public Integer getDiRtPhyActivityWeekCount() {
		return this.diRtPhyActivityWeekCount;
	}

	public void setDiRtPhyActivityWeekCount(Integer diRtPhyActivityWeekCount) {
		this.diRtPhyActivityWeekCount = diRtPhyActivityWeekCount;
	}

	public Integer getDiRtPhyActivityTime() {
		return this.diRtPhyActivityTime;
	}

	public void setDiRtPhyActivityTime(Integer diRtPhyActivityTime) {
		this.diRtPhyActivityTime = diRtPhyActivityTime;
	}

	public String getDiRtHypDrugsFlag() {
		return this.diRtHypDrugsFlag;
	}

	public void setDiRtHypDrugsFlag(String diRtHypDrugsFlag) {
		this.diRtHypDrugsFlag = diRtHypDrugsFlag;
	}

	public Integer getDiRtHypDrugsDailyCount() {
		return this.diRtHypDrugsDailyCount;
	}

	public void setDiRtHypDrugsDailyCount(Integer diRtHypDrugsDailyCount) {
		this.diRtHypDrugsDailyCount = diRtHypDrugsDailyCount;
	}

	public BigDecimal getDiRtHypDrugsperDose() {
		return this.diRtHypDrugsperDose;
	}

	public void setDiRtHypDrugsperDose(BigDecimal diRtHypDrugsperDose) {
		this.diRtHypDrugsperDose = diRtHypDrugsperDose;
	}

	public String getDiRtInsulinFlag() {
		return this.diRtInsulinFlag;
	}

	public void setDiRtInsulinFlag(String diRtInsulinFlag) {
		this.diRtInsulinFlag = diRtInsulinFlag;
	}

	public Integer getDiRtInsulinDailyCount() {
		return this.diRtInsulinDailyCount;
	}

	public void setDiRtInsulinDailyCount(Integer diRtInsulinDailyCount) {
		this.diRtInsulinDailyCount = diRtInsulinDailyCount;
	}

	public BigDecimal getDiRtInsulinPerDose() {
		return this.diRtInsulinPerDose;
	}

	public void setDiRtInsulinPerDose(BigDecimal diRtInsulinPerDose) {
		this.diRtInsulinPerDose = diRtInsulinPerDose;
	}

	public String getDiRtQuitSmokingFlag() {
		return this.diRtQuitSmokingFlag;
	}

	public void setDiRtQuitSmokingFlag(String diRtQuitSmokingFlag) {
		this.diRtQuitSmokingFlag = diRtQuitSmokingFlag;
	}

	public String getDiRtLimitDrinkingFlag() {
		return this.diRtLimitDrinkingFlag;
	}

	public void setDiRtLimitDrinkingFlag(String diRtLimitDrinkingFlag) {
		this.diRtLimitDrinkingFlag = diRtLimitDrinkingFlag;
	}

	public String getDiRtDoctorName() {
		return this.diRtDoctorName;
	}

	public void setDiRtDoctorName(String diRtDoctorName) {
		this.diRtDoctorName = diRtDoctorName;
	}

	public String getDiRtDoctorCode() {
		return this.diRtDoctorCode;
	}

	public void setDiRtDoctorCode(String diRtDoctorCode) {
		this.diRtDoctorCode = diRtDoctorCode;
	}

	public Date getDiRtInputDate() {
		return this.diRtInputDate;
	}

	public void setDiRtInputDate(Date diRtInputDate) {
		this.diRtInputDate = diRtInputDate;
	}

	public String getStrokeFlag() {
		return this.strokeFlag;
	}

	public void setStrokeFlag(String strokeFlag) {
		this.strokeFlag = strokeFlag;
	}

	public String getStrokeType() {
		return this.strokeType;
	}

	public void setStrokeType(String strokeType) {
		this.strokeType = strokeType;
	}

	public Date getStrokeAccidentDate() {
		return this.strokeAccidentDate;
	}

	public void setStrokeAccidentDate(Date strokeAccidentDate) {
		this.strokeAccidentDate = strokeAccidentDate;
	}

	public Date getStrokeDiagnosisDate() {
		return strokeDiagnosisDate;
	}

	public void setStrokeDiagnosisDate(Date strokeDiagnosisDate) {
		this.strokeDiagnosisDate = strokeDiagnosisDate;
	}

	public String getStrokeDiagnosisDepends() {
		return this.strokeDiagnosisDepends;
	}

	public void setStrokeDiagnosisDepends(String strokeDiagnosisDepends) {
		this.strokeDiagnosisDepends = strokeDiagnosisDepends;
	}

	public String getStrokeFamilyHisFlag() {
		return this.strokeFamilyHisFlag;
	}

	public void setStrokeFamilyHisFlag(String strokeFamilyHisFlag) {
		this.strokeFamilyHisFlag = strokeFamilyHisFlag;
	}

	public String getStrokeBodyLimitFlag() {
		return this.strokeBodyLimitFlag;
	}

	public void setStrokeBodyLimitFlag(String strokeBodyLimitFlag) {
		this.strokeBodyLimitFlag = strokeBodyLimitFlag;
	}

	public String getCoronaryFlag() {
		return this.coronaryFlag;
	}

	public void setCoronaryFlag(String coronaryFlag) {
		this.coronaryFlag = coronaryFlag;
	}

	public String getCoronaryType() {
		return this.coronaryType;
	}

	public void setCoronaryType(String coronaryType) {
		this.coronaryType = coronaryType;
	}

	public Date getCoronaryAccidentDate() {
		return this.coronaryAccidentDate;
	}

	public void setCoronaryAccidentDate(Date coronaryAccidentDate) {
		this.coronaryAccidentDate = coronaryAccidentDate;
	}

	public Date getCoronaryDiagnosisDate() {
		return this.coronaryDiagnosisDate;
	}

	public void setCoronaryDiagnosisDate(Date coronaryDiagnosisDate) {
		this.coronaryDiagnosisDate = coronaryDiagnosisDate;
	}

	public String getCoronaryDiagnosisDepends() {
		return this.coronaryDiagnosisDepends;
	}

	public void setCoronaryDiagnosisDepends(String coronaryDiagnosisDepends) {
		this.coronaryDiagnosisDepends = coronaryDiagnosisDepends;
	}

	public String getCoronaryFamilyHisFlag() {
		return this.coronaryFamilyHisFlag;
	}

	public void setCoronaryFamilyHisFlag(String coronaryFamilyHisFlag) {
		this.coronaryFamilyHisFlag = coronaryFamilyHisFlag;
	}

	public String getCoronaryBodyLimitFlag() {
		return this.coronaryBodyLimitFlag;
	}

	public void setCoronaryBodyLimitFlag(String coronaryBodyLimitFlag) {
		this.coronaryBodyLimitFlag = coronaryBodyLimitFlag;
	}

	public String getTumorFlag() {
		return this.tumorFlag;
	}

	public void setTumorFlag(String tumorFlag) {
		this.tumorFlag = tumorFlag;
	}

	public String getTumorType() {
		return this.tumorType;
	}

	public void setTumorType(String tumorType) {
		this.tumorType = tumorType;
	}

	public String getTumorPrimaryPart() {
		return this.tumorPrimaryPart;
	}

	public void setTumorPrimaryPart(String tumorPrimaryPart) {
		this.tumorPrimaryPart = tumorPrimaryPart;
	}

	public String getTumorMetastasisPart() {
		return this.tumorMetastasisPart;
	}

	public void setTumorMetastasisPart(String tumorMetastasisPart) {
		this.tumorMetastasisPart = tumorMetastasisPart;
	}

	public String getTumorDiagnosisDepends() {
		return this.tumorDiagnosisDepends;
	}

	public void setTumorDiagnosisDepends(String tumorDiagnosisDepends) {
		this.tumorDiagnosisDepends = tumorDiagnosisDepends;
	}

	public String getTumorPathologyType() {
		return this.tumorPathologyType;
	}

	public void setTumorPathologyType(String tumorPathologyType) {
		this.tumorPathologyType = tumorPathologyType;
	}

	public Date getTumorAccidentDate() {
		return this.tumorAccidentDate;
	}

	public void setTumorAccidentDate(Date tumorAccidentDate) {
		this.tumorAccidentDate = tumorAccidentDate;
	}

	public Date getTumorDiagnosisDate() {
		return this.tumorDiagnosisDate;
	}

	public void setTumorDiagnosisDate(Date tumorDiagnosisDate) {
		this.tumorDiagnosisDate = tumorDiagnosisDate;
	}

	public String getTumorInformedFlag() {
		return this.tumorInformedFlag;
	}

	public void setTumorInformedFlag(String tumorInformedFlag) {
		this.tumorInformedFlag = tumorInformedFlag;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return this.createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return this.createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return this.updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return this.updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTumorIcdTenCode() {
		return tumorIcdTenCode;
	}

	public void setTumorIcdTenCode(String tumorIcdTenCode) {
		this.tumorIcdTenCode = tumorIcdTenCode;
	}

	public String getTumorIcdTenName() {
		return tumorIcdTenName;
	}

	public void setTumorIcdTenName(String tumorIcdTenName) {
		this.tumorIcdTenName = tumorIcdTenName;
	}

	public String getTumorIcdThreeCode() {
		return tumorIcdThreeCode;
	}

	public void setTumorIcdThreeCode(String tumorIcdThreeCode) {
		this.tumorIcdThreeCode = tumorIcdThreeCode;
	}

	public List<DmReportInfo> getTumorReports() {
		return tumorReports;
	}

	public void setTumorReports(List<DmReportInfo> tumorReports) {
		this.tumorReports = tumorReports;
	}

	public List<DmReportInfo> getToManagedReports() {
		return toManagedReports;
	}

	public void setToManagedReports(List<DmReportInfo> toManagedReports) {
		this.toManagedReports = toManagedReports;
	}

	public Organization getCurrentOrganization() {
		return currentOrganization;
	}

	public void setCurrentOrganization(Organization currentOrganization) {
		this.currentOrganization = currentOrganization;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getLastHbpPlanYear() {
		return lastHbpPlanYear;
	}

	public void setLastHbpPlanYear(String lastHbpPlanYear) {
		this.lastHbpPlanYear = lastHbpPlanYear;
	}

	public String getLastDiPlanYear() {
		return lastDiPlanYear;
	}

	public void setLastDiPlanYear(String lastDiPlanYear) {
		this.lastDiPlanYear = lastDiPlanYear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getNextHbpFollowupDate() {
		return nextHbpFollowupDate;
	}

	public void setNextHbpFollowupDate(Date nextHbpFollowupDate) {
		this.nextHbpFollowupDate = nextHbpFollowupDate;
	}

	public Date getNextDiFollowupDate() {
		return nextDiFollowupDate;
	}

	public void setNextDiFollowupDate(Date nextDiFollowupDate) {
		this.nextDiFollowupDate = nextDiFollowupDate;
	}

	public Date getNextStrokeFollowupDate() {
		return nextStrokeFollowupDate;
	}

	public void setNextStrokeFollowupDate(Date nextStrokeFollowupDate) {
		this.nextStrokeFollowupDate = nextStrokeFollowupDate;
	}

	public Date getNextCoronaryFollowupDate() {
		return nextCoronaryFollowupDate;
	}

	public void setNextCoronaryFollowupDate(Date nextCoronaryFollowupDate) {
		this.nextCoronaryFollowupDate = nextCoronaryFollowupDate;
	}

	public Date getNextTumorFollowupDate() {
		return nextTumorFollowupDate;
	}

	public void setNextTumorFollowupDate(Date nextTumorFollowupDate) {
		this.nextTumorFollowupDate = nextTumorFollowupDate;
	}

	public Date getHbpManagedDate() {
		return hbpManagedDate;
	}

	public void setHbpManagedDate(Date hbpManagedDate) {
		this.hbpManagedDate = hbpManagedDate;
	}

	public Date getDiManagedDate() {
		return diManagedDate;
	}

	public void setDiManagedDate(Date diManagedDate) {
		this.diManagedDate = diManagedDate;
	}

	public Date getStrokeManagedDate() {
		return strokeManagedDate;
	}

	public void setStrokeManagedDate(Date strokeManagedDate) {
		this.strokeManagedDate = strokeManagedDate;
	}

	public Date getCoronaryManagedDate() {
		return coronaryManagedDate;
	}

	public void setCoronaryManagedDate(Date coronaryManagedDate) {
		this.coronaryManagedDate = coronaryManagedDate;
	}

	public Date getTumorManagedDate() {
		return tumorManagedDate;
	}

	public void setTumorManagedDate(Date tumorManagedDate) {
		this.tumorManagedDate = tumorManagedDate;
	}

	public Integer getLastPhyExaminationYear() {
		return lastPhyExaminationYear;
	}

	public void setLastPhyExaminationYear(Integer lastPhyExaminationYear) {
		this.lastPhyExaminationYear = lastPhyExaminationYear;
	}

	public String getDiRtHypDrugsperDoseUnit() {
		return diRtHypDrugsperDoseUnit;
	}

	public void setDiRtHypDrugsperDoseUnit(String diRtHypDrugsperDoseUnit) {
		this.diRtHypDrugsperDoseUnit = diRtHypDrugsperDoseUnit;
	}

	public String getDiRtInsulinPerDoseUnit() {
		return diRtInsulinPerDoseUnit;
	}

	public void setDiRtInsulinPerDoseUnit(String diRtInsulinPerDoseUnit) {
		this.diRtInsulinPerDoseUnit = diRtInsulinPerDoseUnit;
	}

	public String getStrokeManagedFlag() {
		return strokeManagedFlag;
	}

	public void setStrokeManagedFlag(String strokeManagedFlag) {
		this.strokeManagedFlag = strokeManagedFlag;
	}

	public String getCoronaryManagedFlag() {
		return coronaryManagedFlag;
	}

	public void setCoronaryManagedFlag(String coronaryManagedFlag) {
		this.coronaryManagedFlag = coronaryManagedFlag;
	}

	public String getTumorManagedFlag() {
		return tumorManagedFlag;
	}

	public void setTumorManagedFlag(String tumorManagedFlag) {
		this.tumorManagedFlag = tumorManagedFlag;
	}

	public String getStrokeManagedFayFlag() {
		return strokeManagedFayFlag;
	}

	public void setStrokeManagedFayFlag(String strokeManagedFayFlag) {
		this.strokeManagedFayFlag = strokeManagedFayFlag;
	}

	public String getCoronaryManagedFayFlag() {
		return coronaryManagedFayFlag;
	}

	public void setCoronaryManagedFayFlag(String coronaryManagedFayFlag) {
		this.coronaryManagedFayFlag = coronaryManagedFayFlag;
	}

    public Integer getFollowupCountHbp() {
        return followupCountHbp;
    }

    public void setFollowupCountHbp(Integer followupCountHbp) {
        this.followupCountHbp = followupCountHbp;
    }

    public Integer getFollowupCountDi() {
        return followupCountDi;
    }

    public void setFollowupCountDi(Integer followupCountDi) {
        this.followupCountDi = followupCountDi;
    }

    public Integer getFollowupCountStroke() {
        return followupCountStroke;
    }

    public void setFollowupCountStroke(Integer followupCountStroke) {
        this.followupCountStroke = followupCountStroke;
    }

    public Integer getFollowupCountCoronary() {
        return followupCountCoronary;
    }

    public void setFollowupCountCoronary(Integer followupCountCoronary) {
        this.followupCountCoronary = followupCountCoronary;
    }

    public Integer getFollowupCountTumor() {
        return followupCountTumor;
    }

    public void setFollowupCountTumor(Integer followupCountTumor) {
        this.followupCountTumor = followupCountTumor;
    }

	
	public String getHbpAccidentDateDesc() {
		return hbpAccidentDateDesc;
	}

	
	public void setHbpAccidentDateDesc(String hbpAccidentDateDesc) {
		this.hbpAccidentDateDesc = hbpAccidentDateDesc;
	}

	
	public String getHbpKind() {
		return hbpKind;
	}

	
	public void setHbpKind(String hbpKind) {
		this.hbpKind = hbpKind;
	}

	
	public String getHbpKindDesc() {
		return hbpKindDesc;
	}

	
	public void setHbpKindDesc(String hbpKindDesc) {
		this.hbpKindDesc = hbpKindDesc;
	}

	
	public String getUpdateDateDesc() {
		return updateDateDesc;
	}

	
	public void setUpdateDateDesc(String updateDateDesc) {
		this.updateDateDesc = updateDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getDiDiagnosisDateDesc() {
		return diDiagnosisDateDesc;
	}

	
	public void setDiDiagnosisDateDesc(String diDiagnosisDateDesc) {
		this.diDiagnosisDateDesc = diDiagnosisDateDesc;
	}

	
	public String getDiAccidentDateDesc() {
		return diAccidentDateDesc;
	}

	
	public void setDiAccidentDateDesc(String diAccidentDateDesc) {
		this.diAccidentDateDesc = diAccidentDateDesc;
	}

	
	public String getTumorAccidentDateDesc() {
		return tumorAccidentDateDesc;
	}

	
	public void setTumorAccidentDateDesc(String tumorAccidentDateDesc) {
		this.tumorAccidentDateDesc = tumorAccidentDateDesc;
	}

	public String getDiDiagnosisDependsDesc() {
		return diDiagnosisDependsDesc;
	}

	public void setDiDiagnosisDependsDesc(String diDiagnosisDependsDesc) {
		this.diDiagnosisDependsDesc = diDiagnosisDependsDesc;
	}

	public String getHbpOtherDiagnosisOrganName() {
		return hbpOtherDiagnosisOrganName;
	}

	public void setHbpOtherDiagnosisOrganName(String hbpOtherDiagnosisOrganName) {
		this.hbpOtherDiagnosisOrganName = hbpOtherDiagnosisOrganName;
	}

	public String getHbpOtherDiagnosisOrganFlag() {
		return hbpOtherDiagnosisOrganFlag;
	}

	public void setHbpOtherDiagnosisOrganFlag(String hbpOtherDiagnosisOrganFlag) {
		this.hbpOtherDiagnosisOrganFlag = hbpOtherDiagnosisOrganFlag;
	}

	public String getDiOtherDiagnosisOrganName() {
		return diOtherDiagnosisOrganName;
	}

	public void setDiOtherDiagnosisOrganName(String diOtherDiagnosisOrganName) {
		this.diOtherDiagnosisOrganName = diOtherDiagnosisOrganName;
	}

	public String getDiOtherDiagnosisOrganFlag() {
		return diOtherDiagnosisOrganFlag;
	}

	public void setDiOtherDiagnosisOrganFlag(String diOtherDiagnosisOrganFlag) {
		this.diOtherDiagnosisOrganFlag = diOtherDiagnosisOrganFlag;
	}

	public Date getHbpCreateDate() {
		return hbpCreateDate;
	}

	public void setHbpCreateDate(Date hbpCreateDate) {
		this.hbpCreateDate = hbpCreateDate;
	}

	public Date getHbpUpdateDate() {
		return hbpUpdateDate;
	}

	public void setHbpUpdateDate(Date hbpUpdateDate) {
		this.hbpUpdateDate = hbpUpdateDate;
	}

	public Date getDiCreateDate() {
		return diCreateDate;
	}

	public void setDiCreateDate(Date diCreateDate) {
		this.diCreateDate = diCreateDate;
	}

	public Date getDiUpdateDate() {
		return diUpdateDate;
	}

	public void setDiUpdateDate(Date diUpdateDate) {
		this.diUpdateDate = diUpdateDate;
	}

	public Date getStrokeCreateDate() {
		return strokeCreateDate;
	}

	public void setStrokeCreateDate(Date strokeCreateDate) {
		this.strokeCreateDate = strokeCreateDate;
	}

	public Date getStrokeUpdateDate() {
		return strokeUpdateDate;
	}

	public void setStrokeUpdateDate(Date strokeUpdateDate) {
		this.strokeUpdateDate = strokeUpdateDate;
	}

	public Date getCoronaryCreateDate() {
		return coronaryCreateDate;
	}

	public void setCoronaryCreateDate(Date coronaryCreateDate) {
		this.coronaryCreateDate = coronaryCreateDate;
	}

	public Date getCoronaryUpdateDate() {
		return coronaryUpdateDate;
	}

	public void setCoronaryUpdateDate(Date coronaryUpdateDate) {
		this.coronaryUpdateDate = coronaryUpdateDate;
	}

	public Date getTumorCreateDate() {
		return tumorCreateDate;
	}

	public void setTumorCreateDate(Date tumorCreateDate) {
		this.tumorCreateDate = tumorCreateDate;
	}

	public Date getTumorUpdateDate() {
		return tumorUpdateDate;
	}

	public void setTumorUpdateDate(Date tumorUpdateDate) {
		this.tumorUpdateDate = tumorUpdateDate;
	}

	public String getHbpCreateOrganCode() {
		return hbpCreateOrganCode;
	}

	public void setHbpCreateOrganCode(String hbpCreateOrganCode) {
		this.hbpCreateOrganCode = hbpCreateOrganCode;
	}

	public String getHbpUpdateOrganCode() {
		return hbpUpdateOrganCode;
	}

	public void setHbpUpdateOrganCode(String hbpUpdateOrganCode) {
		this.hbpUpdateOrganCode = hbpUpdateOrganCode;
	}

	public String getHbpCreateDoctorCode() {
		return hbpCreateDoctorCode;
	}

	public void setHbpCreateDoctorCode(String hbpCreateDoctorCode) {
		this.hbpCreateDoctorCode = hbpCreateDoctorCode;
	}

	public String getHbpUpdateDoctorCode() {
		return hbpUpdateDoctorCode;
	}

	public void setHbpUpdateDoctorCode(String hbpUpdateDoctorCode) {
		this.hbpUpdateDoctorCode = hbpUpdateDoctorCode;
	}

	public String getDiCreateOrganCode() {
		return diCreateOrganCode;
	}

	public void setDiCreateOrganCode(String diCreateOrganCode) {
		this.diCreateOrganCode = diCreateOrganCode;
	}

	public String getDiUpdateOrganCode() {
		return diUpdateOrganCode;
	}

	public void setDiUpdateOrganCode(String diUpdateOrganCode) {
		this.diUpdateOrganCode = diUpdateOrganCode;
	}

	public String getDiCreateDoctorCode() {
		return diCreateDoctorCode;
	}

	public void setDiCreateDoctorCode(String diCreateDoctorCode) {
		this.diCreateDoctorCode = diCreateDoctorCode;
	}

	public String getDiUpdateDoctorCode() {
		return diUpdateDoctorCode;
	}

	public void setDiUpdateDoctorCode(String diUpdateDoctorCode) {
		this.diUpdateDoctorCode = diUpdateDoctorCode;
	}

	public String getStrokeCreateOrganCode() {
		return strokeCreateOrganCode;
	}

	public void setStrokeCreateOrganCode(String strokeCreateOrganCode) {
		this.strokeCreateOrganCode = strokeCreateOrganCode;
	}

	public String getStrokeUpdateOrganCode() {
		return strokeUpdateOrganCode;
	}

	public void setStrokeUpdateOrganCode(String strokeUpdateOrganCode) {
		this.strokeUpdateOrganCode = strokeUpdateOrganCode;
	}

	public String getStrokeCreateDoctorCode() {
		return strokeCreateDoctorCode;
	}

	public void setStrokeCreateDoctorCode(String strokeCreateDoctorCode) {
		this.strokeCreateDoctorCode = strokeCreateDoctorCode;
	}

	public String getStrokeUpdateDoctorCode() {
		return strokeUpdateDoctorCode;
	}

	public void setStrokeUpdateDoctorCode(String strokeUpdateDoctorCode) {
		this.strokeUpdateDoctorCode = strokeUpdateDoctorCode;
	}

	public String getCoronaryCreateOrganCode() {
		return coronaryCreateOrganCode;
	}

	public void setCoronaryCreateOrganCode(String coronaryCreateOrganCode) {
		this.coronaryCreateOrganCode = coronaryCreateOrganCode;
	}

	public String getCoronaryUpdateOrganCode() {
		return coronaryUpdateOrganCode;
	}

	public void setCoronaryUpdateOrganCode(String coronaryUpdateOrganCode) {
		this.coronaryUpdateOrganCode = coronaryUpdateOrganCode;
	}

	public String getCoronaryCreateDoctorCode() {
		return coronaryCreateDoctorCode;
	}

	public void setCoronaryCreateDoctorCode(String coronaryCreateDoctorCode) {
		this.coronaryCreateDoctorCode = coronaryCreateDoctorCode;
	}

	public String getCoronaryUpdateDoctorCode() {
		return coronaryUpdateDoctorCode;
	}

	public void setCoronaryUpdateDoctorCode(String coronaryUpdateDoctorCode) {
		this.coronaryUpdateDoctorCode = coronaryUpdateDoctorCode;
	}

	public String getTumorCreateOrganCode() {
		return tumorCreateOrganCode;
	}

	public void setTumorCreateOrganCode(String tumorCreateOrganCode) {
		this.tumorCreateOrganCode = tumorCreateOrganCode;
	}

	public String getTumorUpdateOrganCode() {
		return tumorUpdateOrganCode;
	}

	public void setTumorUpdateOrganCode(String tumorUpdateOrganCode) {
		this.tumorUpdateOrganCode = tumorUpdateOrganCode;
	}

	public String getTumorCreateDoctorCode() {
		return tumorCreateDoctorCode;
	}

	public void setTumorCreateDoctorCode(String tumorCreateDoctorCode) {
		this.tumorCreateDoctorCode = tumorCreateDoctorCode;
	}

	public String getTumorUpdateDoctorCode() {
		return tumorUpdateDoctorCode;
	}

	public void setTumorUpdateDoctorCode(String tumorUpdateDoctorCode) {
		this.tumorUpdateDoctorCode = tumorUpdateDoctorCode;
	}

	public String getReportInfoId() {
		return reportInfoId;
	}

	public void setReportInfoId(String reportInfoId) {
		this.reportInfoId = reportInfoId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getDieaseName() {
		return dieaseName;
	}

	public void setDieaseName(String dieaseName) {
		this.dieaseName = dieaseName;
	}
}