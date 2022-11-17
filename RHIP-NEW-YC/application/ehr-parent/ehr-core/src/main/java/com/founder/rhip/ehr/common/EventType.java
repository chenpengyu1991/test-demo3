package com.founder.rhip.ehr.common;


/**
 * 医疗活动类型
 * 
 * @author GaoFei
 *
 */
public enum EventType {
	/**
	 * 居民健康档案封面
	 */
    PERSON_RECORD_COVER("A00000001", "居民健康档案封面"),
	/**
	 * 个人基本信息表
	 */
    PERSON_RECORD_BASIC_INFO("A00000002", "个人基本信息表"),
	/**
	 * 个人健康体检表
	 */
    PERSON_RECORD_PHYSICIAL_EXAM("A00000003", "个人健康体检表"),
	/**
	 * 门诊记录
	 */
	OUTPATIENT("1", "门诊记录"),
	/**
	 * 住院记录
	 */
	INPATIENT("2", "住院记录"),
	/**
	 * 体检记录
	 */
	PHYSICAL_EXAMINATION("3", "体检记录"),
	/**
	 * 老年人健康体检
	 */
	OLD_PEOPLE_PHYSICAL_EXAMINATION("31", "老年人健康体检"),
	/**
	 * 商业体检
	 */
	COMMERCIAL_PHYSICAL_EXAMINATION("32", "商业体检"),
	/**
	 * 学生体检
	 */
	STUDENT_PHYSICAL_EXAMINATION("33", "学生体检"),
	/**
	 * 妇女病体检
	 */
	WOMEN_PHYSICAL_EXAMINATION("34", "妇女病体检"),
	/**
	 * 职业健康体检
	 */
	OCCUPATION_PHYSICAL_EXAMINATION("35", "职业健康体检"),
	/**
	 * 职业健康体检
	 */
	HEALTH_CERTIFICATE_EXAMINATION("36", "健康证体检"),
	
	/**
	 * 托幼体检
	 */
	EMPLOYEE_PHYSICAL_EXAMINATION("37", "托幼体检"),
	
	/**
	 * 慢病体检
	 */
	CHRONIC_DISEASE_PHYSICAL_EXAMINATION("39", "慢病体检"),
	/**
	 * 其它体检
	 */
	OTHER_PHYSICAL_EXAMINATION("9", "其它体检"),
	/**
	/**
	 * 住院病案首页
	 */
	INPATIENT_MEDICAL_RECORD("4", "住院病案首页"),
	/**
	 * 出院小结
	 */
	DISCHARGE_SUMMARY("5", "出院小结"),
	/**
	 * 成人二次疫苗
	 */
	VACCINATION("6", "成人二次疫苗"),
	/**
	 * 出生医学证明
	 */
	BIRTH_CERTIFICATE("C01", "出生医学证明"),
	/**
	 * 新生儿疾病筛查
	 */
	NEWBORN_DISEASE_SCREEN("C02", "新生儿疾病筛查"),
	/**
	 * 新生儿家庭访视
	 */
	NEWBORN_HOME_VISIT("C03", "新生儿家庭访视"),
	/**
	 * 儿童保健卡
	 */
	CHILD_HEALTH_CARD("C04", "儿童保健卡"),
	/**
	 * 儿童健康体检
	 */
	CHILD_PYSICAL_EXAMINATION("C05", "儿童健康体检"),
	/**
	 * 体弱儿童管理随访
	 */
	DEBILITY_CHILDREN_FOLLOW("C06", "体弱儿童管理随访"),
	/**
	 * 婚前保健服务
	 */
	PREMARITAL_CARE("W01", "婚前保健服务"),
	/**
	 * 妇女病普查
	 */
	WOMEN_DISEASES_SURVEY("W02", "妇女病普查"),
	/**
	 * 计划生育技术服务
	 */
	BIRTH_CONTROL("W03", "计划生育技术服务"),
	/**
	 * 孕产期保健服务与高危管理随访
	 */
	PERINATAL_PERIOD_CARE("W04", "孕产期保健服务与高危管理随访"),
	/**
	 * 产前筛查与诊断
	 */
	PRENATAL_SCREENING_DIAGNOSIS("W05", "产前筛查与诊断"),
	/**
	 * 分娩记录
	 */
	DELIVERY_RECORD("W06", "分娩记录"),
	/**
	 * 出生缺陷监测
	 */
	BIRTH_DEFECTS_MONITOR("W07", "出生缺陷监测"),
	/**
	 * 产前随访服务
	 */
	PRENATAL_FOLLOW("W08", "产前随访服务"),
	/**
	 * 产后访视服务
	 */
	POSTNATAL_VISIT("W09", "产后访视服务"),
	/**
	 * 产后42天健康检查
	 */
	POSTNATAL_42DAY_EXAMINATION("W10", "产后42天健康检查"),
	/**
	 * 其他
	 */
	OTHER("9", "其他"),

  /**
   * 老年人健康指导与评价
   */
  OLDER_PHYSICAL_GUIDE("G1","老年人健康指导与评价");


  private String code;
	private String name;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private EventType (String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
