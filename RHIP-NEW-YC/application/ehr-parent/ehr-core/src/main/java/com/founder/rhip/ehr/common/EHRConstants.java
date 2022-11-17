package com.founder.rhip.ehr.common;

/**
 * @author liuk
 *
 */
public class EHRConstants {

	public static final Integer REFERRAL_UP_TYPE = 1;
	public static final Integer REFERRAL_BACK_TYPE = 0;
	public static final String LBL_TYPE_CODE_TEXT = "TEXT";
	public static final String LBL_TYPE_CODE_RADIO = "RADIO";
	public static final String LBL_TYPE_CODE_CHECKBOX = "CHECKBOX";

	// 预约短信发送模式
	public static final Integer SEND_TIME_NOW = 0;
	public static final Integer SEND_TIME_BEFORE = 1;

	public static final String IS_OFF_DISABLE = "0";//禁用
	public static final String IS_OFF_ENABLE = "1";//正常

	// 0:表示存在
	public static final Integer DELETE_FLG_0 = 0;
	// 1:表示已删除
	public static final Integer DELETE_FLG_1 = 1;

	public static final String SUCCESS = "1";//成功
	public static final String FAIL = "0";//失败

	public static final int PAGE_SIZE = 10;
	public static final int PAGE_SIZE_MIDDLE = 5;
	public static final int PAGE_SIZE_NINE = 9;
	public static final int USER_TYPE_OFFICER = 0;// userRole的类型0表示职能人员
	public static final int USER_TYPE_PATIENT = 1;// userRole的类型1表示患者

	public static final int USER_DISABLED = 1;// 用户不可用
	public static final int USER_NOT_DISABLED = 0;// 用户可用

	/* 卫生人员类型 */
	public static final String HEALTH_OFFICE_DOCTOR = "01";

	/* 医疗机构类型 */
	public static final String ORGANIZTION_HOSPITAL = "01"; // 医院
	public static final String ORGANIZTION_COMMUNITY = "02"; // 社区

	/* 添加患者类型 */
	public static final String CREATE_PERSON = "createPerson";

	/* 更新患者 */
	public static final String UPDATE_PERSON = "updatePerson";

	/* 查询患者 */
	public static final String QUERY_PERSON = "queryPerson";

	public static final Integer IS_REFERRAL = 1;// 在reserve_register表中此条数据为上转添加的
	public static final Integer NOT_REFERRAL = 0;// 在reserve_register表中此条数据不是上转添加的

	/**
	 * 短信发送设置
	 */
	public static final int TYPE_SELF_DISABLED = 0;
	public static final int TYPE_SELF_AUTO = 1;
	public static final int TYPE_SELF_MANUAL = 2;

	public static final int SMS_DISABLED = 0;
	public static final int SMS_AUTO = 1;
	public static final int SMS_MANUAL = 2;
	public static final int SMS_BEFORE = 3;

	/**
	 * 短信类型 0：预约挂号 1：预约检查 2：转诊 3：停诊
	 */
	public static final int SMS_TYPE_REG = 0;
	public static final int SMS_TYPE_EXAM = 1;
	public static final int SMS_TYPE_REF = 2;
	public static final int SMS_TYPE_STOP = 3;

	/* 诊断类型 */
	public static final String DIAGNOSIS_TYPE_OUTHOS = "01"; // 出院诊断
	public static final String DIAGNOSIS_TYPE_OUTPATIENT = "02"; // 门诊诊断
	public static final String DIAGNOSIS_TYPE_INHOS = "03"; // 入院初步诊断
	public static final String DIAGNOSIS_TYPE_BEFORE_OPERATION = "04"; // 术前诊断
	public static final String DIAGNOSIS_TYPE_AFTER_OPERATION = "05"; // 术前诊断术后
	public static final String DIAGNOSIS_TYPE_BODY = "06"; // 尸检诊断
	public static final String DIAGNOSIS_TYPE_RADIOLOGY = "07"; // 放射诊断
	public static final String DIAGNOSIS_TYPE_ULTRASOUND = "08"; // 超声诊断
	public static final String DIAGNOSIS_TYPE_PATHOLOGY = "09"; // 病理诊断
	public static final String DIAGNOSIS_TYPE_COMPLICATION = "10"; // 并发症诊断

	/* 家庭档案 */
	public static final String FAMILY_MEMBERS = "family_members";
	public static final String FAMILY_HOUSEHOLDER_CODE = "02";
	public static final String FAMILY_HOUSEHOLDER_FLAG = "1";

	public static final String FAMILY_MEMBERS_MATE = "10";
	public static final String FAMILY_MEMBERS_SON = "20";
	public static final String FAMILY_MEMBERS_DAUGHTER = "30";
	public static final String FAMILY_MEMBERS_GRANDCHILDREN = "40";
	public static final String FAMILY_MEMBERS_GRANDSON = "41";
	public static final String FAMILY_MEMBERS_GRANDDAUGHTER = "42";
	public static final String FAMILY_MEMBERS_DAUGHTERSSON = "43";
	public static final String FAMILY_MEMBERS_DAUGHTERSDAUGHTER = "44";

	// 档案星级
	public static final int ONE_STAR = 1;
	public static final int TWO_STAR = 2;
	public static final int THREE_STAR = 3;

	// 户籍类型
	public static final String HOUSE_HOLDER = "1";
	public static final String UN_HOUSE_HOLDER = "2";
	public static final String NO_HOUSE_HOLDER_TYPE = "3";

	// 药物类型
	public static final int WESTERN_MEDICINE = 1; // 西药
	public static final int CHINESE_MEDICINE = 2; // 中药
	public static final int CHINESE_HERBAL_MEDICINE = 3; // 中草药
	public static final int OTHER_CHINESE_MEDICINE = 4; // 其他中药

	// 字典
	// 支付方式
	public static final String EXPENSE_INFO = "CV0710003";

	// 检查类型
	public static final String X_RAY = "1"; // x光
	public static final String CT = "2"; // CT
	public static final String MRI = "3"; // MRI
	public static final String PATHOLOGY = "4"; // 病理检查
	// 过敏源
	public static final String DRUG_ALLERGY = "CV0501038";
	// 家族疾病史
	public static final String FAMILY_DISEASE = "FS10240";

	// 有无标识
	public static final String UN_HAVE = "1";
	public static final String HAVE = "2";

	// 默认显示记录数 - 个人基本信息表
	public static final int DEFAULT_RECORD_COUNT = 2;

	// 家庭成员类型
	public static final String FAMILY_MEMTYPE_HEAD = "02";// 户主
	public static final String FAMILY_MEMBER_STATUS_ABLE = "0"; // 默认为可用状态
	public static final String FAMILY_MEMBER_STATUS_DISABLE = "1"; // 不可用

	// 个人档案管理状态
	public static final String UN_CREATE = "0"; // 未建档
	public static final String HAD_CREATE = "1"; // 已建档
	public static final String CHECK_FLAG = "2"; // 待审核
	public static final String HAD_BACK = "3"; // 已退回
	public static final String NO_IDCARD = "4"; // 无身份证
	public static final String HAD_OFF = "9"; // 已注销
	public static final String MOVE_OUT = "5"; // 待迁入

	/**档案已经加密标志*/
	public static final String RECORD_ENCRYPTED_FLAG="1";

	//档案注销原因
	/**迁出*/
	public static final String CANCEL_REASON_OUT="1";
	/**其他*/
	public static final String CANCEL_REASON_OTHER="2";
	/**死亡*/
	public static final String CANCEL_REASON_DEATH="9";

	// 家庭档案管理状态
	public static final String F_HAD_CREATE = "0"; // 已建档
	public static final String F_CHECK_FLAG = "1"; // 待审核
	public static final String F_HAD_OFF = "2"; // 已注销
	public static final String F_HAD_BACK = "3"; // 已退回

	// 个人基本信息
	public static final String NO_PERSON_NAME = "无名氏";

	// 各档案星级分母
	public static final int ONE_STAT_DENOMINATOR = 13;
	public static final int TWO_STAT_DENOMINATOR = 8;
	public static final int THREE_STAT_DENOMINATOR = 10;

	public static final int TWO_STAR_DIS_SCORE = 24;
	public static final int Three_STAR_DIS_BASIC_SCORE = 97;

	public static final int ZERO_STAT_VALUE = 0;
	public static final int ONE_STAT_VALUE = 1;
	public static final int TWO_STAT_VALUE = 2;
	public static final int THREE_STAT_VALUE = 3;

	// 档案完整度标准
	public static final double DOC_INTEGRITY = 0.9;

	//档案删除状态
	public static final int AUDIT = 0;
	public static final int CANCELED = 1;

	//预约时间开始的key值
	public static final String PORTAL_RESERVE_START_TIME= "portal_reserve_start_time";

	//预约时间结束的key值
	public static final String PORTAL_RESERVE_END_TIME= "portal_reserve_end_time";

	/**
	 * 义齿标志
	 */
	public static final int DENTURE_TOOTH_FLG = 1;
	/**
	 * 缺齿标志
	 */
	public static final int MISSING_TOOTH_FLG = 1;
	/**
	 * 龋齿标志
	 */
	public static final int DECAYED_TOOTH_FLG = 1;
	/**
	 * 牙齿正常
	 */
	public static final String TOOTH_NORMAL_FLG = "0";

	/**
	 * 锻炼方式-不锻炼
	 */
	public static final String TRAIN_FREQUENCT_TYPE_NO = "4";

	/**
	 * 吸烟 每天
	 */
	public static final String SMOKE_STATUS_EVERYDAY = "1";
	/**
	 * 吸烟 不经常
	 */
	public static final String SMOKE_STATUS_SOMETIME = "2";
	/**
	 * 吸烟 戒烟
	 */
	public static final String SMOKE_STATUS_QUITE = "3";
	/**
	 * 吸烟 不吸烟
	 */
	public static final String SMOKE_STATUS_NERVER = "4";

	/**
	 * 饮酒 每天
	 */
	public static final String DRINK_FREQUENCY_EVERY_DAY = "1";
	/**
	 * 饮酒 经常
	 */
	public static final String DRINK_FREQUENCY_ALLWAYS = "2";
	/**
	 * 饮酒 偶尔
	 */
	public static final String DRINK_FREQUENCY_SOMETIME = "3";
	/**
	 * 饮酒 从不
	 */
	public static final String DRINK_FREQUENCY_NERVER = "4";
	/**
	 * 已戒酒
	 */
	public static final String NO_DRINK_FLAG_YES = "1";
	/**
	 * 未戒酒
	 */
	public static final String NO_DRINK_FLAG_NO = "2";

	/**
	 * 职业暴露标志 有
	 */
	public static final String OCCUPATION_EXPOSURE_FLAG_YES = "1";
	/**
	 * 职业暴露标志 没有
	 */
	public static final String OCCUPATION_EXPOSURE_FLAG_NO = "0";

	/**
	 * 体检主要用药标志
	 */
	public static final String PHY_INP_DRUGUSAG_FLAG_YES = "1";

	/**
	 * 体检主要用药标志
	 */
	public static final String PHY_INP_DRUGUSAG_FLAG_NO = "0";

	/**
	 * 体检住院史标志
	 */
	public static final String PHY_INHOSHISTORY_FLAG_YES = "1";

	/**
	 * 体检住院史标志
	 */
	public static final String PHY_INHOSHISTORY_FLAG_NO = "0";

	/**
	 * 体检家庭病床史标志
	 */
	public static final String PHY_FAMBENHISTORY_FLAG_YES = "1";

	/**
	 * 体检家庭病床史标志
	 */
	public static final String PHY_FAMBENHISTORY_FLAG_NO = "0";

	/**
	 * 体检接种史标志
	 */
	public static final String PHY_VACCINFO_FLAG_YES = "1";

	/**
	 * 体检接种史标志
	 */
	public static final String PHY_VACCINFO_FLAG_NO = "0";

	public static final String RETURN_SMPI_ID = "smpiId";
	public static final String RETURN_PERSON_ID = "personId";

	/**
	 * 统计的有效数字
	 */
	public static final int STATISTICS_PRECISION = 4;

	/**
	 * 统计合计
	 */
	public static final String STATISTICS_TOTAL_CHS = "合计";

	/**
	 * 常熟镇数据字典类别
	 */
	public static final String CS_TOWN_DICT_TYPE = "FS990001";

	/* RHIP统一日期类型 */
	public static final String COMMON_DATE_PATTERN = "yyyy/MM/dd";

	/* 带时分秒日期类型 */
	public static final String SPEC_DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 档案的inputOrganCode为空
	 */
	public static final String INPUTORGANCODE_NULL = "-1";

	/**
	 * 没查找到信息
	 */
	public static final String NO_RESULT = "-1";

	/**
	 * 月份范围类型
	 */
	public static final String MONTH_RANGE_LFAG = "2";

	/**
	 * 季节范围类型
	 */
	public static final String SEASON_RANGE_LFAG = "3";

	/**
	 * 年范围类型
	 */
	public static final String YEAR_RANGE_LFAG = "4";

	/**
	 * 日期范围类型
	 */
	public static final String DATE_RANGE_LFAG = "5";

	/**
	 * 临时类型
	 */
	public static final String UN_HOUSE_HOLDER_LFAG = "3";

	/**
	 * 常住类型
	 */
	public static final String HOUSE_HOLDER_LFAG = "2";

	/**
	 * 统计年范围类型
	 */
	public static final String STATIC_YEAR_FLAG = "0";

	/**
	 * 全部或者不选择类型
	 */
	public static final String NO_SELECTED_FLAG = "-1";

	/**
	 * 慢病已经报卡
	 */
	public static final String DM_REPORTED_FLAG = "1";

	/**
	 * 慢病已经管理
	 */
	public static final String DM_MANAGED_FLAG = "2";

	/**
	 * 慢病选中标志
	 */
	public static final String DM_SELECTED_FLAG = "1";

	/**
	 * 高血压
	 */
	public static final String DM_HBP_TYPE = "1";

	/**
	 * 糖尿病
	 */
	public static final String DM_DI_TYPE = "2";

	/**
	 * 2型糖尿病
	 */
	public static final String DM_DI_TYPE_TWO = "2";

	/**
	 * 脑卒中
	 */
	public static final String DM_STROKE_TYPE = "3";

	/**
	 * 冠心病
	 */
	public static final String DM_CORONARY_TYPE = "4";

	/**
	 * 肿瘤
	 */
	public static final String DM_TUMOR_TYPE = "5";

	/**
	 * 上报类型病
	 */
	public static final String DM_REPORT_DIS = "1";
	/**
	 * 上报类型 死亡
	 */
	public static final String DM_REPORT_DEATH = "2";

	/**
	 * 上报类型 死亡 第一次上报 且死亡和诊断日期相同标志
	 */
	public static final String DM_REPORT_DEATH_FIRST_FLAG = "1";

	/**
	 * 不审核
	 */
	public static final String DM_APPROVE_NO = "1";
	/**
	 *
	 * 退回
	 */
	public static final String DM_APPROVE_REJECT = "2";
	/**
	 * 通过
	 */
	public static final String DM_APPROVE_PASS = "3";

	/**
	 * 不管理
	 */
	public static final String DM_APPROVE_NO_MANAGE = "4";

	/**
	 * 作废
	 */
	public static final String DM_APPROVE_CANCEL = "5";

	/**
	 * 慢病报卡最大间隔时间
	 */
	public static final Long DM_MAX_REPORT_INTERVAL = 28 * 24 * 60 * 60 * 1000L;

	/**
	 * 慢病报卡查看所有
	 */
	public static final String DM_REPORT_VIEW_ALL = "1";

	/**
	 * 慢病历史人员类型
	 */
	public static final String DM_PERSON_REPORT_TYPE = "1";

	/**
	 * 慢病历史人员类型
	 */
	public static final String DM_PERSON_MANGE_TYPE = "2";

	/**
	 * 慢病报卡查看待审核
	 */
	public static final String DM_REPORT_VIEW_TO_APP = "2";

	/**
	 * 慢病报卡查看待分配
	 */
	public static final String DM_REPORT_VIEW_TO_ALLOCATE = "3";

	/**
	 * 慢病报卡查慢病科已退回
	 */
	public static final String DM_REPORT_VIEW_REJECT = "4";

	/**
	 * 慢病报卡 查看待纳入管理
	 */
	public static final String DM_REPORT_TO_MAMAGE = "5";

	/**
	 * 管理状态正常
	 */
	public static final String DM_MANAGE_STATUS_NORMAL = "1";

	/**
	 * 管理状态为注销
	 */
	public static final String DM_MANAGE_STATUS_CANCEL = "2";


	/**
	 *  脑卒中冠心病管理标志是
	 */
	public static final String DM_SC_MANAGED_FLAG_YES = "1";
	/**
	 *  脑卒中冠心病管理标志否
	 */
	public static final String DM_SC_MANAGED_FLAG_NO = "2";

	/**
	 * 管理满一年标志是
	 */
	public static final String DM_MANAGED_FULL_ONE_YEAR_FLAG_YES = "1";
	/**
	 * 管理满一年标志否
	 */
	public static final String DM_MANAGED_FULL_ONE_YEAR_FLAG_NO = "2";


	/**
	 * 常规管理
	 */
	public static final String DM_FOLLOWUP_TYPE_NORMAL = "2";
	/**
	 * 规范化管理
	 */
	public static final String DM_FOLLOWUP_TYPE_STANDARD = "1";

	/**
	 * 规范化管理一类
	 */
	public static final String DM_FOLLOWUP_TYPE_STANDARD_ONE = "3";

	/**
	 * 规范化管理二类
	 */
	public static final String DM_FOLLOWUP_TYPE_STANDARD_OTHER = "4";

	/**
	 * 慢病随访过期类型 本日
	 */
	public static final String DM_FOLLOWUP_EXPIRE_TODAY = "1";
	/**
	 * 慢病随访过期类型 7天内
	 */
	public static final String DM_FOLLOWUP_EXPIRE_WEEK = "2";
	/**
	 * 慢病随访过期类型 30天内
	 */
	public static final String DM_FOLLOWUP_EXPIRE_MONTH = "3";
	/**
	 * 慢病随访过期类型 已经过期
	 */
	public static final String DM_FOLLOWUP_EXPIRE_EXPIRED = "4";

	/**
	 * 慢病随访过期类型 下月之前	 */
	public static final String DM_FOLLOWUP_NEXT_MONTH_EXPIRED = "5";

	/**
	 * 慢病随访 肿瘤第一次
	 */
	public static final String DM_FOLLOWUP_TUMOR_FIRST = "1";
	/**
	 * 慢病随访
	 */
	public static final String DM_FOLLOWUP_TUMOR_NORMAL = "2";
	/**
	 * 慢病随访 死亡
	 */
	public static final String DM_FOLLOWUP_TUMOR_LAST = "3";

	/**
	 * 恶性肿瘤
	 */
	public static final String DM_TUMOR_MALIGNANT_TYPE = "1";

	/**
	 * 非恶性肿瘤
	 */
	public static final String DM_TUMOR_NON_MALIGNANT_TYPE = "2";

	/**
	 * 慢病统计合计字段的默认值
	 */
	public static final String DM_STATISTICS_TOTAL_COLUMN_VALUE = "-1";

	/** 六十岁 */
	public static final int SIXTY_ELDER = 60;

	/** 六岁 */
	public static final int SIX_OLDER = 6;

	/** 六十五岁 */
	public static final int SIXTY_FIVE_ELDER = 65;

	/** 机构类型 */
	public static final String TOWN = "01";
	public static final String CENTER = "02";
	public static final String STATION = "03";

	public static final Double CDM_PATIENT_RATE = 0.4;

	/** 预约挂号 */
	public static final String RESULT_REPEAT = "repeat";
	public static final String RESULT_OVER = "over";
	public static final String RESULT_FULL = "full";
	public static final String RESULT_FAIL = "fail";
	public static final String RESULT_OK = "ok";

	/** 取消预约挂号 */
	public static final String CANCEL_STOP = "stop";
	public static final String CANCEL_REPEAT = "repeat";
	public static final String CANCEL_FAIL = "fail";
	public static final String CANCEL_OK = "ok";

	/** 停诊 */
	public static final String STOP_FAIL = "stop_fail";
	public static final String STOP_OK = "stop_ok";
	public static final String STOP_REPEAT = "stop_repeat";
	public static final String STOP_HAVE = "stop_have";

	/**
	 * 巡查记录地点类型
	 */
	public static final String INSP_LOC_TYPE_LOCATION = "1";
	public static final String INSP_LOC_TYPE_FAMILY = "2";

	/**
	 * 地点数据类型
	 */
	public static final String LOCATION_DATA_TYPE_ADD="1";
	public static final String LOCATION_DATA_TYPE_ADD_NOT_SHOW="10";
	public static final String LOCATION_DATA_TYPE_IMPORT="2";
	public static final String LOCATION_DATA_TYPE_IMPORT_NOT_SHOW="20";

	public static final String LOCATION_NEW_RECORD_FLAG_NO="1";
	public static final String LOCATION_NEW_RECORD_FLAG_YES="2";

	/**
	 * 地点数据状态
	 */
	public static final String LOCATION_DATA_STATUS_CANCEL="1";
	public static final String LOCATION_DATA_STATUS_NORMAL="2";

	/**巡查内容*/
	public static final String INSPECTION_HAVE_GUIDE="1";
	/**巡查报告登记*/
	public static final String INSPECTION_HAVE_REPORT_CARD="1";

	/**巡查专业*/

	// 1 餐饮服务 餐饮服务
	// 2 公共场所 公共场所
	// 3 饮用水 饮用水
	// 5 学校卫生 学校卫生
	// 6 传染病防治 传染病防治
	// 7 非法行医 非法行医

	public static final String INSPECTION_HP_FOOD="1";
	public static final String INSPECTION_HP_LP="2";
	public static final String INSPECTION_HP_WATER="3";
	public static final String INSPECTION_HP_SCH="5";
	public static final String INSPECTION_HP_ID="6";
	public static final String INSPECTION_HP_IM="7";



	/* 市级综合医院 */
	public static final String[] HOSPITAL_CODES = new String[] { "46714063-X", "46714062-1", "46714117-3", "46714077-9", "46714078-7" }; // 第一、二、三、五院、中医院


	/**
	 * 血压合格标准
	 */
	public static final Integer[] SBP_OK_VALUE= {90,140};

	public static final Integer[] DBP_OK_VALUE= {60,90};

	/**
	 * 血糖合格
	 */
	public static final Double[] BS_OK_VALUE= {3.9,6.1};


	/**
	 * 成人二次疫苗的类型
	 * */
//	public static final String VACCINNATION_RABIES = "1";
//	public static final String VACCINNATION_HEPATITIS = "2";
//	public static final String VACCINNATION_PNEUMONIA = "3";
//	public static final String VACCINNATION_INFLUENZA = "4";

	/**
	 * 教育资源
	 */
	public static final String HE_SB = "1"; //宣传设备
	public static final String HE_ZD = "2"; //宣传阵地
	public static final String HE_CL = "3"; //宣传材料

	/**
	 * 市民卡指标 标志
	 */
	public static final String CIC_TARGET_FLAG_TRUE="T";
	public static final String CIC_TARGET_FLAG_FALSE="F";

	/**血型*/
	public static final String ABO_BLOOD_TYPE_A="1";
	public static final String ABO_BLOOD_TYPE_B="2";
	public static final String ABO_BLOOD_TYPE_AB="4";
	public static final String ABO_BLOOD_TYPE_O="3";

	public static final String RH_BLOOD_TYPE_YES="2";


	/**
	 * 新增，删除常用联系人成功失败标识
	 */
	public static final String FREQUENT_OK = "ok";
	public static final String FREQUENT_FAIL = "fail";
	public static final String FREQUENT_REPEAT = "repeat";
	public static final String FREQUENT_REPEAT_ACCOUNT = "repeatAccount";

	/** 儿童体检年龄段　*/
	public static final String CHILD_AGE_GROUP_UNDER_ONE = "1";
	public static final String CHILD_AGE_GROUP_ONE_TO_TWO = "2";
	public static final String CHILD_AGE_GROUP_THREE_TO_SIX = "6";

	// Web 服务接口响应状态
	public static final String AA = "AA"; // 成功
	public static final String AE = "AE"; // 异常

	public static final Integer MENU_STATUS_DELETE = 0;//menu的状态 标示删除状态

	public static final Integer MENU_STATUS_RHIP = 1;//menu的状态 平台菜单

	public static final Integer MENU_STATUS_COMMON = 9;//menu的状态 表示几个系统共用菜单

	//	常熟是320581000000,园区是320586 团风是421121000000 永城411481000000
	public static final String FS990001_ROOT="411481000000";	//本地区行政区划代码根节点
	
	//顶层机构的code
	//public static final String WSJ_CODE="PDY815921";		//县卫生局code
	public static final String WSJ_CODE="MB1900457";		//县卫生局code
	//public static final String JK_CODE="420805585";		//疾控code
	public static final String JK_CODE="418565332";		//疾控code
	public static final String _HOSPITAL="_hospital";	//医院类别
	public static final String _CENTRE="_centre";		//中心类别
	public static final String _INFIRMARY = "_infirmary";//医务室
	public static final String _HEALTHOVERSIGHT = "_healthoversight";//卫生监督检验(监测、检测)所(站)
	public static final String _SHOWJK = "_showJk";//疾病预防控制中心
	public static final String _QWJW = "_showWjw";//区卫计委
	public static final String _OTHER = "_other";//其他
	//健康档案花粉过敏选择字典其他过敏源的code
	public static final String DRUG_ALLERGY_HISTORY_OTHER = "9";

	/* 传染病大类：甲、乙、丙 、其他*/
	public static final String IDM_A = "1";
	public static final String IDM_B = "2";
	public static final String IDM_C = "3";
	public static final String IDM_O = "0";

	/* 外部报卡上报记录表分类：1慢病，2传染病 3食源性疾病*/
	public static final int REPORT_CDM = 1;
	public static final int REPORT_IDM = 2;
	public static final int REPORT_FD = 3;

	/*传染病报卡来源：0 外部上报，1平台上报*/
	public static final String REPORT_SOURCE_EXTERNAL = "0";
	public static final String REPORT_SOURCE_PLATFORM = "1";

	/* 外部报卡上报记录表传染病状态：1初诊未上报，2初诊已上报，3复诊未上报，4诊断错误，5补卡已上报；9重卡 */
	public static final int IDM_FIRST_NO = 1;
	public static final int IDM_FIRST_YES = 2;
	public static final int IDM_SECOND_NO = 3;
	public static final int IDM_SECOND_ERROR = 4;
	public static final int IDM_REPEAT_YES = 5;
	public static final int IDM_REPEAT = 9;

	/* 外部报卡上报传染病审核状态：*/
	public static final String IDM_APPROVED_NO = "1";//待审核
	public static final String IDM_APPROVED_YES = "2";//已审核
	/* 外部报卡上报传染病上报人角色分类：*/
	public static final String IDM_ROLE_YS = "1";//医生
	public static final String IDM_ROLE_CRB = "2";//防保科

	/* 外部报卡上报记录表慢病状态：1未上报，2已上报，9重卡 */
	public static final int DM_REPORTE_NO = 1;
	public static final int DM_REPORTE_YES = 2;
	public static final int DM_REPEAT = 9;

	public static  final String HBP = "hbp"; // 高血压
	public static final String DI = "di"; // 糖尿病
	public static final String CORONARY = "coronary"; // 冠心病
	public static final String STROKE = "stroke"; // 脑卒中
	public static final String TUMOR = "tumor"; // 肿瘤

	public static final String CDM_FOLLOWUP_PLAN = "1"; // 计划内
	public static final String CDM_FOLLOWUP_DISCONTENT = "2"; // 随访不满意新增随访
	public static final String CDM_FOLLOWUP_NEW = "3"; // 随访页面点击新增

	//生成健康档案编码最后五位序列码时在表FS_RECORD_SERIAL_NUMBER存的NUMBER_TYPE值
	public static final String EHR_NUMBER_TYPE = "GRBH";
	//生成体检编号
	public static final String EXAM_NUMBER_TYPE = "EXBH";
	
	//地区
	public static final String COUNTY_NAME = "永城市";
		
	//公卫同步家医履约
	public static final String EXAM_JSON_TYPE = "EXAM";//体检
	public static final String HM_EXAM_JSON_TYPE = "HM_EXAM";//老年人体检
	public static final String CDM_EXAM_JSON_TYPE = "CDM_EXAM";//慢病体检
	public static final String HBP_JSON_TYPE = "HBP";//高血压随访
	public static final String DI_JSON_TYPE = "DI";//糖尿病随访
	public static final String HBP_INTERVENE = "HBP_INTERVENE";//高血压分类干预
	public static final String DI_INTERVENE = "DI_INTERVENE";//糖尿病分类干预
	public static final String ADD = "A";//新增标识
	public static final String UPDATE = "U";//修改标识
	public static final String DELETE = "D";//删除标识

	//0127597: *年 *月分娩孕产妇花名册是否标记值
	public static final String YCFHMC_SHI = "1";

	public static final String YCFHMC_FOU = "0";

	public static final String EHR_FLAG_0="0";//档案没有医疗记录标记
	public static final String EHR_FLAG_1="1";//档案有门急诊医疗记录标记
	public static final String EHR_FLAG_2="2";//档案有住院医疗记录标记

	public static final String FILE_TYPE_MBGLKGXY="mbglkgxy";//高血压管理卡附件
	public static final String FILE_TYPE_MBBKGXY="mbbkgxy";//高血压报卡附件
	public static final String FILE_TYPE_MBGLKTNB="mbglktnb";//糖尿病管理卡附件
	public static final String FILE_TYPE_MBBKTNB="mbbktnb";//糖尿病报卡附件

	//在线用户的人数 存入StandParameterCfg使用
	public static final String STANDARD_CODE_USER = "USER_TOTAL_COUNT";
	public static final String PARAMETER_CODE_USER = "00000001";

	/*健康档案查看权限 0:有权限 1:无权限*/
	public static final String CIC_PERMISSION="0";
	
	//角色是否呗选中
    public static final Integer ROLE_SELECT_0 = 0;//未选中
    public static final Integer ROLE_SELECT_1 = 1;//选中

	public static final String SQFWZX_CODE = "B100";//卫生院社区 服务中心类型编号
	public static final String SQFWZ_CODE = "B200";//社区服务站 类型编号
	
	/* 疫苗类型 */
    public static final String VACCINE_RABIES = "1";
    public static final String VACCINE_HEPATITIS = "2";
    public static final String VACCINE_INFLUENZA = "3";
    public static final String VACCINE_PNEUMONIA = "4";
    public static final String VACCINE_GRAY = "5";

	//死亡登记表人群分类
	public static final String PERSON_TYPE_ET = "1"; //儿童
}
