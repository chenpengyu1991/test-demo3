package com.founder.rhip.ehr.entity.pbusiness.student;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.service.export.Item;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "STUDENT_EXAM")
public class StudentExam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STUDENT_EXAM_ID", columnDefinition = "NUMBER|学生体检业务ID||", length = 11, nullable = true)
	private Long studentExamId;

	@Column(name = "PERSON_INFO_ID", columnDefinition = "NUMBER|健康档案ID||", length = 11, nullable = true)
	private String personInfoId;
	
	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
	private String ehrId;

	@Column(name = "EXAM_ID", columnDefinition = "NUMBER|体检ID||", length = 11, nullable = true)
	private Long examId;

	@Item(index =8, code = "EXAM_DATE", column = "体检日期", isDate = true, datePattern = "yyyy-MM-dd")
	@Column(name = "EXAM_DATE", columnDefinition = "DATE|体检日期||", nullable = true)
	private Date examDate;
	
	@Column(name = "PRINT_DATE", columnDefinition = "DATE|打印日期||", nullable = true)
	private Date printDate;

	@Column(name = "ORGANIZATION", columnDefinition = "VARCHAR2|体检单位||", length = 50, nullable = true)
	private String organization;

	@Item(index =999, code = "IDCARD", column = "身份证")
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
	private String idcard;

	@Item(index =3, code = "NAME", column = "姓名")
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Item(index =4, code = "GENDER", column = "性别", isDic = true, dicType = "GBT226112003")
	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;

	//@Item(index =14, code = "IN_YEAR", column = "入学年份")
	@Column(name = "IN_YEAR", columnDefinition = "VARCHAR2|入学年份||", length = 8, nullable = true)
	private String inYear;

	//@Item(index =15, code = "STUDENT_NO", column = "学籍卡号")
	@Column(name = "STUDENT_NO", columnDefinition = "VARCHAR2|学籍卡号||", length = 18, nullable = true)
	private String studentNo;

	@Item(index =5, code = "BIRTHDAY", column = "出生日期", isDate = true, datePattern = "yyyy-MM-dd")
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;
	
	@Column(name = "AGE", columnDefinition = "NUMBER|年龄||", nullable = true)
	private Double age;

	//@Item(index =12, code = "NATION", column = "民族")
	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;

	//@Item(index =13, code = "ABO_BLOOD_TYPE", column = "血型")
	@Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型代码||", length = 1, nullable = true)
	private String aboBloodType;

	@Column(name = "SCHOOL_CODE", columnDefinition = "VARCHAR2|学校编码||", length = 20, nullable = true)
	private String schoolCode;

	@Item(index =2, code = "SCHOOL_NAME", column = "学校")
	@Column(name = "SCHOOL_NAME", columnDefinition = "VARCHAR2|学校名称||", length = 50, nullable = true)
	private String schoolName;

	@Item(index =7, code = "CLASS_CODE", column = "班级")
	@Column(name = "CLASS_CODE", columnDefinition = "VARCHAR2|班级编码||", length = 10, nullable = true)
	private String classCode;

	@Column(name = "CLASS_NAME", columnDefinition = "VARCHAR2|班级名称||", length = 50, nullable = true)
	private String className;

	@Item(index =6, code = "GRADE_CODE", column = "年级")
	@Column(name = "GRADE_CODE", columnDefinition = "VARCHAR2|年级编码||", length = 10, nullable = true)
	private String gradeCode;

	@Column(name = "GRADE_NAME", columnDefinition = "VARCHAR2|年级名称||", length = 10, nullable = true)
	private String gradeName;

	//@Item(index =101, code = "MEDICAL_HISTORY", column = "既往重要病史")
	@Column(name = "MEDICAL_HISTORY", columnDefinition = "VARCHAR2|既往重要病史||", length = 100, nullable = true)
	private String medicalHistory;

	//@Item(index =102, code = "OTHER_MEDICAL_HISTORY", column = "其他既往病史")
	@Column(name = "OTHER_MEDICAL_HISTORY", columnDefinition = "VARCHAR2|其他既往病史||", length = 100, nullable = true)
	private String otherMedicalHistory;

	@Item(index =103, code = "HEIGHT", column = "身高(cm)")
	@Column(name = "HEIGHT", columnDefinition = "NUMBER|形体-身高(cm)||", scale = 5, precision = 2, nullable = true)
	private Double height;

	@Item(index =104, code = "BODY_WEIGHT", column = "体重(kg)")
	@Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|形体-体重(kg)||", scale = 5, precision = 2, nullable = true)
	private Double bodyWeight;

	@Column(name = "INDEX_OF_BODY_CHARACTERISTICS", columnDefinition = "NUMBER|形体-体质指数(BMI)||", scale = 5, precision = 2, nullable = true)
	private Double indexOfBodyCharacteristics;

	@Column(name = "HEIGHT_CATAGORY", columnDefinition = "VARCHAR2|形体-身高筛查||", length = 50, nullable = true)
	private String heightCatagory;

	@Column(name = "WEIGHT_CATAGORY", columnDefinition = "VARCHAR2|形体-BMI筛查||", length = 50, nullable = true)
	private String weightCatagory;

	//@Item(index =105, code = "BODY_DOCTOR", column = "检查医生")
	@Column(name = "BODY_DOCTOR", columnDefinition = "VARCHAR2|形体-检查医生||", length = 50, nullable = true)
	private String bodyDoctor;

	@Item(index =201, code = "SBP", column = "收缩压(mmHg)")
	@Column(name = "SBP", columnDefinition = "NUMBER|生理-收缩压(mmHg)||", length = 4, nullable = true)
	private Integer sbp;

	@Item(index =202, code = "DBP", column = "舒张压(mmHg)")
	@Column(name = "DBP", columnDefinition = "NUMBER|生理-舒张压(mmHg)||", length = 4, nullable = true)
	private Integer dbp;

	@Item(index =203, code = "PULSE_RATE", column = "脉率(次/min)")
	@Column(name = "PULSE_RATE", columnDefinition = "NUMBER|生理-脉率(次/min)||", length = 4, nullable = true)
	private Integer pulseRate;

	@Item(index =200, code = "VITAL_CAPACITY", column = "肺活量（ml）")
	@Column(name = "VITAL_CAPACITY", columnDefinition = "NUMBER|生理-肺活量（ml）||", length = 4, nullable = true)
	private Integer vitalCapacity;

	//@Item(index =205, code = "PHYSICAL_DOCTOR", column = "检查医生")
	@Column(name = "PHYSICAL_DOCTOR", columnDefinition = "VARCHAR2|生理-检查医生||", length = 50, nullable = true)
	private String physicalDoctor;

	@Item(index =301, code = "L_NAKED_EYE", column = "左眼裸眼视力值")
	@Column(name = "L_NAKED_EYE", columnDefinition = "NUMBER|眼科-左眼裸眼视力值||", scale = 3, precision = 1, nullable = true)
	private Double lNakedEye;

	@Item(index =302, code = "R_NAKED_EYE", column = "右眼裸眼视力值")
	@Column(name = "R_NAKED_EYE", columnDefinition = "NUMBER|眼科-右眼裸眼枧力值||", scale = 3, precision = 1, nullable = true)
	private Double rNakedEye;

	@Item(index =307, code = "COLOR_VISION", column = "色觉", isDic = true, dicMap = "{0:异常,1:正常}")
	@Column(name = "COLOR_VISION", columnDefinition = "VARCHAR2|眼科-辨色力||", length = 1, nullable = true)
	private String colorVision = "1";

	@Item(index =304, code = "L_TRACHOMA_EYE", column = "沙眼左", isDic = true, dicMap = "{0:无,1:有,2:可疑}")
	@Column(name = "L_TRACHOMA_EYE", columnDefinition = "VARCHAR2|眼科-沙眼左||", length = 1, nullable = true)
	private String lTrachomaEye = "0";

	@Item(index =305, code = "R_TRACHOMA_EYE", column = "沙眼右", isDic = true, dicMap = "{0:无,1:有,2:可疑}")
	@Column(name = "R_TRACHOMA_EYE", columnDefinition = "VARCHAR2|眼科-沙眼右||", length = 1, nullable = true)
	private String rTrachomaEye = "0";

	@Item(index =306, code = "CONJUNCTIVITIS", column = "结膜炎", isDic = true, dicMap = "{0:无,1:有}")
	@Column(name = "CONJUNCTIVITIS", columnDefinition = "VARCHAR2|眼科-结膜炎||", length = 1, nullable = true)
	private String conjunctivitis = "0";

	//@Item(index =307, code = "EYE_OTHER", column = "其他")
	@Column(name = "EYE_OTHER", columnDefinition = "VARCHAR2|眼科-其他||", length = 50, nullable = true)
	private String eyeOther;

	//@Item(index =308, code = "EYE_DOCTOR", column = "检查医生")
	@Column(name = "EYE_DOCTOR", columnDefinition = "VARCHAR2|眼科-检查医生||", length = 50, nullable = true)
	private String eyeDoctor;

	@Column(name = "DECAYED_BABY_TOOTH_NO_UPL", columnDefinition = "NUMBER|口腔-乳牙龋齿数(颗)上左||", length = 3, nullable = true)
	private Integer decayedBabyToothNoUpl;

	@Column(name = "DECAYED_BABY_TOOTH_NO_UPR", columnDefinition = "NUMBER|口腔-乳牙龋齿数(颗)上右||", length = 3, nullable = true)
	private Integer decayedBabyToothNoUpr;

	@Column(name = "DECAYED_BABY_TOOTH_NO_DOWNL", columnDefinition = "NUMBER|口腔-乳牙龋齿数(颗)下左||", length = 3, nullable = true)
	private Integer decayedBabyToothNoDownl;

	@Column(name = "DECAYED_BABY_TOOTH_NO_DOWNR", columnDefinition = "NUMBER|口腔-乳牙龋齿数(颗)下右||", length = 3, nullable = true)
	private Integer decayedBabyToothNoDownr;

	@Column(name = "MISSING_BABY_TOOTH_NO_UPL", columnDefinition = "NUMBER|口腔-乳牙龋缺数(颗)上左||", length = 3, nullable = true)
	private Integer missingBabyToothNoUpl;

	@Column(name = "MISSING_BABY_TOOTH_NO_UPR", columnDefinition = "NUMBER|口腔-乳牙龋缺数(颗)上右||", length = 3, nullable = true)
	private Integer missingBabyToothNoUpr;

	@Column(name = "MISSING_BABY_TOOTH_NO_DOWNL", columnDefinition = "NUMBER|口腔-乳牙龋缺数(颗)下左||", length = 3, nullable = true)
	private Integer missingBabyToothNoDownl;

	@Column(name = "MISSING_BABY_TOOTH_NO_DOWNR", columnDefinition = "NUMBER|口腔-乳牙龋缺数(颗)下右||", length = 3, nullable = true)
	private Integer missingBabyToothNoDownr;

	@Column(name = "FILL_BABY_TOOTH_NO_UPL", columnDefinition = "NUMBER|口腔-乳牙龋补数(颗)上左||", length = 3, nullable = true)
	private Integer fillBabyToothNoUpl;

	@Column(name = "FILL_BABY_TOOTH_NO_UPR", columnDefinition = "NUMBER|口腔-乳牙龋补数(颗)上右||", length = 3, nullable = true)
	private Integer fillBabyToothNoUpr;

	@Column(name = "FILL_BABY_TOOTH_NO_DOWNL", columnDefinition = "NUMBER|口腔-乳牙龋补数(颗)下左||", length = 3, nullable = true)
	private Integer fillBabyToothNoDownl;

	@Column(name = "FILL_BABY_TOOTH_NO_DOWNR", columnDefinition = "NUMBER|口腔-乳牙龋补数(颗)下右||", length = 3, nullable = true)
	private Integer fillBabyToothNoDownr;

	@Item(index =401, code = "DECAYED_TOOTH_NO_UPL", column = "乳牙龋齿D")
	@Column(name = "DECAYED_TOOTH_NO_UPL", columnDefinition = "NUMBER|口腔-龋齿数(颗)上左||", length = 3, nullable = true)
	private String decayedToothNoUpl;

	@Item(index =404, code = "DECAYED_TOOTH_NO_UPR", column = "恒牙龋齿D", nullValue="0")
	@Column(name = "DECAYED_TOOTH_NO_UPR", columnDefinition = "NUMBER|口腔-龋齿数(颗)上右||", length = 3, nullable = true)
	private String decayedToothNoUpr;

	@Column(name = "DECAYED_TOOTH_NO_DOWNL", columnDefinition = "NUMBER|口腔-龋齿数(颗)下左||", length = 3, nullable = true)
	private String decayedToothNoDownl;

	@Column(name = "DECAYED_TOOTH_NO_DOWNR", columnDefinition = "NUMBER|口腔-龋齿数(颗)下右||", length = 3, nullable = true)
	private String decayedToothNoDownr;

	@Item(index =402, code = "MISSING_TOOTH_NO_UPL", column = "乳牙龋缺M")
	@Column(name = "MISSING_TOOTH_NO_UPL", columnDefinition = "NUMBER|口腔-龋缺数(颗)上左||", length = 3, nullable = true)
	private String missingToothNoUpl;

	@Item(index =405, code = "MISSING_TOOTH_NO_UPR", column = "恒牙龋缺M", nullValue="0")
	@Column(name = "MISSING_TOOTH_NO_UPR", columnDefinition = "NUMBER|口腔-龋缺数(颗)上右||", length = 3, nullable = true)
	private String missingToothNoUpr;

	@Column(name = "MISSING_TOOTH_NO_DOWNL", columnDefinition = "NUMBER|口腔-龋缺数(颗)下左||", length = 3, nullable = true)
	private String missingToothNoDownl;

	@Column(name = "MISSING_TOOTH_NO_DOWNR", columnDefinition = "NUMBER|口腔-龋缺数(颗)下右||", length = 3, nullable = true)
	private String missingToothNoDownr;

	@Item(index =403, code = "FILL_TOOTH_NO_UPL", column = "乳牙龋补F")
	@Column(name = "FILL_TOOTH_NO_UPL", columnDefinition = "NUMBER|口腔-龋补数(颗)上左||", length = 3, nullable = true)
	private String fillToothNoUpl;

	@Item(index =406, code = "FILL_TOOTH_NO_UPR", column = "恒牙龋补F", nullValue="0")
	@Column(name = "FILL_TOOTH_NO_UPR", columnDefinition = "NUMBER|口腔-龋补数(颗)上右||", length = 3, nullable = true)
	private String fillToothNoUpr;

	@Column(name = "FILL_TOOTH_NO_DOWNL", columnDefinition = "NUMBER|口腔-龋补数(颗)下左||", length = 3, nullable = true)
	private String fillToothNoDownl;

	@Column(name = "FILL_TOOTH_NO_DOWNR", columnDefinition = "NUMBER|口腔-龋补数(颗)下右||", length = 3, nullable = true)
	private String fillToothNoDownr;

	@Item(index =400, code = "PERIODONTAL_CEHCK_RESULT", column = "牙周病", isDic = true, dicMap = "{0:无,1:有}")
	@Column(name = "PERIODONTAL_CEHCK_RESULT", columnDefinition = "VARCHAR2|口腔-牙周||", length = 9, nullable = true)
	private String periodontalCehckResult = "0";

	//@Item(index =408, code = "TOOTH_OTHER", column = "其他")
	@Column(name = "TOOTH_OTHER", columnDefinition = "VARCHAR2|口腔-其他||", length = 50, nullable = true)
	private String toothOther;

	//@Item(index =409, code = "TOOTH_DOCTOR", column = "检查医生")
	@Column(name = "TOOTH_DOCTOR", columnDefinition = "VARCHAR2|口腔-检查医生||", length = 50, nullable = true)
	private String toothDoctor;

	@Item(index =501, code = "HEART_CHECK_RESULT", column = "心脏")
	@Column(name = "HEART_CHECK_RESULT", columnDefinition = "VARCHAR2|内科-心脏检查结果||", length = 50, nullable = true)
	private String heartCheckResult = "0";

	//@Item(index =502, code = "HEART_OTHER", column = "心脏其他异常")
	@Column(name = "HEART_OTHER", columnDefinition = "VARCHAR2|内科-心脏其他异常||", length = 50, nullable = true)
	private String heartOther;

	@Item(index =505, code = "LIVER_CHECK_RESULT", column = "肝脏")
	@Column(name = "LIVER_CHECK_RESULT", columnDefinition = "VARCHAR2|内科-肝脏检查结果||", length = 50, nullable = true)
	private String liverCheckResult = "0";

	//@Item(index =504, code = "LIVER_OTHER", column = "肝脏其他异常")
	@Column(name = "LIVER_OTHER", columnDefinition = "VARCHAR2|内科-肝脏其他异常||", length = 50, nullable = true)
	private String liverOther;

	@Item(index =503, code = "LUNGS_CHECK_RESULT", column = "肺")
	@Column(name = "LUNGS_CHECK_RESULT", columnDefinition = "VARCHAR2|内科-肺检查结果||", length = 50, nullable = true)
	private String lungsCheckResult = "0";

	//@Item(index =506, code = "LUNGS_OTHER", column = "肺其他异常")
	@Column(name = "LUNGS_OTHER", columnDefinition = "VARCHAR2|内科-肺其他异常||", length = 50, nullable = true)
	private String lungsOther;

	@Item(index =507, code = "SPLEEN_CHECK_RESULT", column = "脾脏")
	@Column(name = "SPLEEN_CHECK_RESULT", columnDefinition = "VARCHAR2|内科-脾脏检查结果||", length = 50, nullable = true)
	private String spleenCheckResult = "0";

	//@Item(index =508, code = "SPLEEN_OTHER", column = "脾脏其他异常")
	@Column(name = "SPLEEN_OTHER", columnDefinition = "VARCHAR2|内科-脾脏其他异常||", length = 50, nullable = true)
	private String spleenOther;

	//@Item(index =509, code = "INTERNAL_DOCTOR", column = "检查医生")
	@Column(name = "INTERNAL_DOCTOR", columnDefinition = "VARCHAR2|内科-检查医生||", length = 50, nullable = true)
	private String internalDoctor;

	@Item(index =601, code = "HEAD_CHECK_RESULT", column = "头部检查")
	@Column(name = "HEAD_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-头部检查结果||", length = 50, nullable = true)
	private String headCheckResult = "0";

	//@Item(index =602, code = "HEAD_OTHER", column = "头部异常描述")
	@Column(name = "HEAD_OTHER", columnDefinition = "VARCHAR2|外科-头部异常描述||", length = 50, nullable = true)
	private String headOther;

	@Item(index =603, code = "NECK_CHECK_RESULT", column = "颈部检查")
	@Column(name = "NECK_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-颈部检查结果||", length = 50, nullable = true)
	private String neckCheckResult = "0";

	//@Item(index =604, code = "NECK_OTHER", column = "颈部其他异常")
	@Column(name = "NECK_OTHER", columnDefinition = "VARCHAR2|外科-颈部其他异常||", length = 50, nullable = true)
	private String neckOther;

	@Item(index =605, code = "CHEST_CHECK_RESULT", column = "胸部检查")
	@Column(name = "CHEST_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-胸部检查结果||", length = 50, nullable = true)
	private String chestCheckResult = "0";

	//@Item(index =606, code = "CHEST_OTHER", column = "胸部异常描述")
	@Column(name = "CHEST_OTHER", columnDefinition = "VARCHAR2|外科-胸部异常描述||", length = 50, nullable = true)
	private String chestOther;

	@Item(index =607, code = "SPINE_CHECK_RESULT", column = "脊柱检查")
	@Column(name = "SPINE_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-脊柱检查结果||", length = 50, nullable = true)
	private String spineCheckResult = "0";

	//@Item(index =608, code = "SPINE_OTHER", column = "脊柱其他异常")
	@Column(name = "SPINE_OTHER", columnDefinition = "VARCHAR2|外科-脊柱其他异常||", length = 50, nullable = true)
	private String spineOther;

	@Item(index =609, code = "LIMBS_CHECK_RESULT", column = "四肢检查")
	@Column(name = "LIMBS_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-四肢检查结果||", length = 50, nullable = true)
	private String limbsCheckResult = "0";

	//@Item(index =610, code = "LIMBS_OTHER", column = "四肢异常描述")
	@Column(name = "LIMBS_OTHER", columnDefinition = "VARCHAR2|外科-四肢异常描述||", length = 50, nullable = true)
	private String limbsOther;

	@Item(index =611, code = "SKIN_CHECK_RESULT", column = "皮肤检查")
	@Column(name = "SKIN_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-皮肤检查结果||", length = 50, nullable = true)
	private String skinCheckResult = "0";

	//@Item(index =612, code = "SKIN_OTHER", column = "皮肤异常描述")
	@Column(name = "SKIN_OTHER", columnDefinition = "VARCHAR2|外科-皮肤异常描述||", length = 50, nullable = true)
	private String skinOther;

	@Item(index =613, code = "LYMPH_NODE_CHECK_RESULT", column = "淋巴结检查")
	@Column(name = "LYMPH_NODE_CHECK_RESULT", columnDefinition = "VARCHAR2|外科-淋巴结检查结果||", length = 50, nullable = true)
	private String lymphNodeCheckResult = "0";

	//@Item(index =614, code = "LYMPH_NODE_OTHER", column = "淋巴结其他异常")
	@Column(name = "LYMPH_NODE_OTHER", columnDefinition = "VARCHAR2|外科-淋巴结其他异常||", length = 50, nullable = true)
	private String lymphNodeOther;

	//@Item(index =615, code = "SURGERY_DOCTOR", column = "检查医生")
	@Column(name = "SURGERY_DOCTOR", columnDefinition = "VARCHAR2|外科-检查医生||", length = 50, nullable = true)
	private String surgeryDoctor;

	@Item(index =701, code = "TUBERCULIN_TEST", column = "结核菌素试验")
	@Column(name = "TUBERCULIN_TEST", columnDefinition = "VARCHAR2|化验-结核菌素试验||", length = 10, nullable = true)
	private String tuberculinTest = "0";

	@Item(index =702, code = "HEMOGLOBIN_VALUE", column = "血红蛋白（g/L）")
	@Column(name = "HEMOGLOBIN_VALUE", columnDefinition = "NUMBER|化验-血红蛋白（g/L）||", length = 4, nullable = true)
	private Double hemoglobinValue;

	@Item(index =703, code = "SERUM_GPT_VALUE", column = "谷丙转氨酶（U/L）")
	@Column(name = "SERUM_GPT_VALUE", columnDefinition = "NUMBER|化验-肝功能-谷丙转氨酶（U/L）||", length = 4, nullable = true)
	private Double serumGptValue;

	@Item(index =704, code = "TOTAL_BILIRUBIN", column = "胆红素（umol/L）")
	@Column(name = "TOTAL_BILIRUBIN", columnDefinition = "NUMBER|化验-肝功能-胆红素（umol/L）||", scale = 4, precision = 1, nullable = true)
	private Double totalBilirubin;

	//@Item(index =705, code = "LAB_TEST_DOCTOR", column = "检查医生")
	@Column(name = "LAB_TEST_DOCTOR", columnDefinition = "VARCHAR2|化验-检查医生||", length = 50, nullable = true)
	private String labTestDoctor;

	//@Item(index =801, code = "OTHER_CHECK_ITEM", column = "其他检查项目")
	@Column(name = "OTHER_CHECK_ITEM", columnDefinition = "VARCHAR2|其他-检查项目||", length = 200, nullable = true)
	private String otherCheckItem;

	@Item(index =802, code = "OTHER_CHECK_RESULT", column = "其他")
	@Column(name = "OTHER_CHECK_RESULT", columnDefinition = "VARCHAR2|其他-检查结果||", length = 200, nullable = true)
	private String otherCheckResult;

	//@Item(index =803, code = "OTHER_CHECK_DOCTOR", column = "检查医生")
	@Column(name = "OTHER_CHECK_DOCTOR", columnDefinition = "VARCHAR2|其他-检查医生||", length = 50, nullable = true)
	private String otherCheckDoctor;

	@Item(index =901, code = "EXAMINATION_RESULT", column = "体检结论")
	@Column(name = "EXAMINATION_RESULT", columnDefinition = "VARCHAR2|体检结论||", length = 400, nullable = true)
	private String examinationResult;

	@Item(index =905, code = "MANA_DOCTOR_NAME", column = "医生")
	@Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|主检医生||", length = 50, nullable = true)
	private String manaDoctorName;

	//@Item(index =903, code = "HEALTH_GUIDANCE", column = "健康指导意见")
	@Column(name = "HEALTH_GUIDANCE", columnDefinition = "VARCHAR2|健康指导意见||", length = 100, nullable = true)
	private String healthGuidance;

	//@Item(index =900, code = "TOTAL_RESULT", column = "体检结果", isDic = true, dicMap = "{0:异常,1:正常}")
	@Column(name = "TOTAL_RESULT", columnDefinition = "VARCHAR2|体检结果||", length = 10, nullable = true)
	private String totalResult = "1";

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 50, nullable = true)
	private String operator;

	@Item(index =904, code = "OPERATE_ORGAN", column = "体检机构", isOrganization = true)
	@Column(name = "OPERATE_ORGAN", columnDefinition = "VARCHAR2|操作类型||", length = 50, nullable = true)
	private String operateOrgan;

	//@Item(index =906, code = "OPERATE_TIME", column = "医生签字日期")
	@Column(name = "OPERATE_TIME", columnDefinition = "DATE|操作时间||", nullable = true)
	private Date operateTime;
	
	@Column(name = "FATHER_EDUCATION", columnDefinition = "VARCHAR2|父亲文化程度||", length = 5, nullable = true)
	private String fatherEducation;
	
	@Column(name = "MOTHER_EDUCATION", columnDefinition = "VARCHAR2|母亲文化程度||", length = 5, nullable = true)
	private String motherEducation;
	
	@Column(name = "VACCINATION", columnDefinition = "VARCHAR2|预防接种||", length = 400, nullable = true)
	private String vaccination;
	
	public Long getStudentExamId() {
		return this.studentExamId;
	}

	public void setStudentExamId(Long studentExamId) {
		this.studentExamId = studentExamId;
	}

	public String getPersonInfoId() {
		return personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public Long getExamId() {
		return this.examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInYear() {
		return this.inYear;
	}

	public void setInYear(String inYear) {
		this.inYear = inYear;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAboBloodType() {
		return this.aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGradeCode() {
		return this.gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getMedicalHistory() {
		return this.medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getOtherMedicalHistory() {
		return otherMedicalHistory;
	}

	public void setOtherMedicalHistory(String otherMedicalHistory) {
		this.otherMedicalHistory = otherMedicalHistory;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(Double bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public Double getIndexOfBodyCharacteristics() {
		return this.indexOfBodyCharacteristics;
	}

	public void setIndexOfBodyCharacteristics(Double indexOfBodyCharacteristics) {
		this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
	}

	public String getHeightCatagory() {
		return heightCatagory;
	}

	public void setHeightCatagory(String heightCatagory) {
		this.heightCatagory = heightCatagory;
	}

	public String getWeightCatagory() {
		return weightCatagory;
	}

	public void setWeightCatagory(String weightCatagory) {
		this.weightCatagory = weightCatagory;
	}

	public String getBodyDoctor() {
		return this.bodyDoctor;
	}

	public void setBodyDoctor(String bodyDoctor) {
		this.bodyDoctor = bodyDoctor;
	}

	public Integer getSbp() {
		return this.sbp;
	}

	public void setSbp(Integer sbp) {
		this.sbp = sbp;
	}

	public Integer getDbp() {
		return this.dbp;
	}

	public void setDbp(Integer dbp) {
		this.dbp = dbp;
	}

	public Integer getPulseRate() {
		return this.pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Integer getVitalCapacity() {
		return this.vitalCapacity;
	}

	public void setVitalCapacity(Integer vitalCapacity) {
		this.vitalCapacity = vitalCapacity;
	}

	public String getPhysicalDoctor() {
		return this.physicalDoctor;
	}

	public void setPhysicalDoctor(String physicalDoctor) {
		this.physicalDoctor = physicalDoctor;
	}

	public Double getlNakedEye() {
		return lNakedEye;
	}

	public void setlNakedEye(Double lNakedEye) {
		this.lNakedEye = lNakedEye;
	}

	public Double getrNakedEye() {
		return rNakedEye;
	}

	public void setrNakedEye(Double rNakedEye) {
		this.rNakedEye = rNakedEye;
	}

	public String getColorVision() {
		return this.colorVision;
	}

	public void setColorVision(String colorVision) {
		this.colorVision = colorVision;
	}

	public String getlTrachomaEye() {
		return lTrachomaEye;
	}

	public void setlTrachomaEye(String lTrachomaEye) {
		this.lTrachomaEye = lTrachomaEye;
	}

	public String getrTrachomaEye() {
		return rTrachomaEye;
	}

	public void setrTrachomaEye(String rTrachomaEye) {
		this.rTrachomaEye = rTrachomaEye;
	}

	public String getConjunctivitis() {
		return this.conjunctivitis;
	}

	public void setConjunctivitis(String conjunctivitis) {
		this.conjunctivitis = conjunctivitis;
	}

	public String getEyeOther() {
		return this.eyeOther;
	}

	public void setEyeOther(String eyeOther) {
		this.eyeOther = eyeOther;
	}

	public String getEyeDoctor() {
		return this.eyeDoctor;
	}

	public void setEyeDoctor(String eyeDoctor) {
		this.eyeDoctor = eyeDoctor;
	}

	public Integer getDecayedBabyToothNoUpl() {
		return this.decayedBabyToothNoUpl;
	}

	public void setDecayedBabyToothNoUpl(Integer decayedBabyToothNoUpl) {
		this.decayedBabyToothNoUpl = decayedBabyToothNoUpl;
	}

	public Integer getDecayedBabyToothNoUpr() {
		return this.decayedBabyToothNoUpr;
	}

	public void setDecayedBabyToothNoUpr(Integer decayedBabyToothNoUpr) {
		this.decayedBabyToothNoUpr = decayedBabyToothNoUpr;
	}

	public Integer getDecayedBabyToothNoDownl() {
		return this.decayedBabyToothNoDownl;
	}

	public void setDecayedBabyToothNoDownl(Integer decayedBabyToothNoDownl) {
		this.decayedBabyToothNoDownl = decayedBabyToothNoDownl;
	}

	public Integer getDecayedBabyToothNoDownr() {
		return this.decayedBabyToothNoDownr;
	}

	public void setDecayedBabyToothNoDownr(Integer decayedBabyToothNoDownr) {
		this.decayedBabyToothNoDownr = decayedBabyToothNoDownr;
	}

	public Integer getMissingBabyToothNoUpl() {
		return this.missingBabyToothNoUpl;
	}

	public void setMissingBabyToothNoUpl(Integer missingBabyToothNoUpl) {
		this.missingBabyToothNoUpl = missingBabyToothNoUpl;
	}

	public Integer getMissingBabyToothNoUpr() {
		return this.missingBabyToothNoUpr;
	}

	public void setMissingBabyToothNoUpr(Integer missingBabyToothNoUpr) {
		this.missingBabyToothNoUpr = missingBabyToothNoUpr;
	}

	public Integer getMissingBabyToothNoDownl() {
		return this.missingBabyToothNoDownl;
	}

	public void setMissingBabyToothNoDownl(Integer missingBabyToothNoDownl) {
		this.missingBabyToothNoDownl = missingBabyToothNoDownl;
	}

	public Integer getMissingBabyToothNoDownr() {
		return this.missingBabyToothNoDownr;
	}

	public void setMissingBabyToothNoDownr(Integer missingBabyToothNoDownr) {
		this.missingBabyToothNoDownr = missingBabyToothNoDownr;
	}

	public Integer getFillBabyToothNoUpl() {
		return this.fillBabyToothNoUpl;
	}

	public void setFillBabyToothNoUpl(Integer fillBabyToothNoUpl) {
		this.fillBabyToothNoUpl = fillBabyToothNoUpl;
	}

	public Integer getFillBabyToothNoUpr() {
		return this.fillBabyToothNoUpr;
	}

	public void setFillBabyToothNoUpr(Integer fillBabyToothNoUpr) {
		this.fillBabyToothNoUpr = fillBabyToothNoUpr;
	}

	public Integer getFillBabyToothNoDownl() {
		return this.fillBabyToothNoDownl;
	}

	public void setFillBabyToothNoDownl(Integer fillBabyToothNoDownl) {
		this.fillBabyToothNoDownl = fillBabyToothNoDownl;
	}

	public Integer getFillBabyToothNoDownr() {
		return this.fillBabyToothNoDownr;
	}

	public void setFillBabyToothNoDownr(Integer fillBabyToothNoDownr) {
		this.fillBabyToothNoDownr = fillBabyToothNoDownr;
	}

	public String getDecayedToothNoUpl() {
		return this.decayedToothNoUpl;
	}

	public void setDecayedToothNoUpl(String decayedToothNoUpl) {
		this.decayedToothNoUpl = decayedToothNoUpl;
	}

	public String getDecayedToothNoUpr() {
		return this.decayedToothNoUpr;
	}

	public void setDecayedToothNoUpr(String decayedToothNoUpr) {
		this.decayedToothNoUpr = decayedToothNoUpr;
	}

	public String getDecayedToothNoDownl() {
		return this.decayedToothNoDownl;
	}

	public void setDecayedToothNoDownl(String decayedToothNoDownl) {
		this.decayedToothNoDownl = decayedToothNoDownl;
	}

	public String getDecayedToothNoDownr() {
		return this.decayedToothNoDownr;
	}

	public void setDecayedToothNoDownr(String decayedToothNoDownr) {
		this.decayedToothNoDownr = decayedToothNoDownr;
	}

	public String getMissingToothNoUpl() {
		return this.missingToothNoUpl;
	}

	public void setMissingToothNoUpl(String missingToothNoUpl) {
		this.missingToothNoUpl = missingToothNoUpl;
	}

	public String getMissingToothNoUpr() {
		return this.missingToothNoUpr;
	}

	public void setMissingToothNoUpr(String missingToothNoUpr) {
		this.missingToothNoUpr = missingToothNoUpr;
	}

	public String getMissingToothNoDownl() {
		return this.missingToothNoDownl;
	}

	public void setMissingToothNoDownl(String missingToothNoDownl) {
		this.missingToothNoDownl = missingToothNoDownl;
	}

	public String getMissingToothNoDownr() {
		return this.missingToothNoDownr;
	}

	public void setMissingToothNoDownr(String missingToothNoDownr) {
		this.missingToothNoDownr = missingToothNoDownr;
	}

	public String getFillToothNoUpl() {
		return this.fillToothNoUpl;
	}

	public void setFillToothNoUpl(String fillToothNoUpl) {
		this.fillToothNoUpl = fillToothNoUpl;
	}

	public String getFillToothNoUpr() {
		return this.fillToothNoUpr;
	}

	public void setFillToothNoUpr(String fillToothNoUpr) {
		this.fillToothNoUpr = fillToothNoUpr;
	}

	public String getFillToothNoDownl() {
		return this.fillToothNoDownl;
	}

	public void setFillToothNoDownl(String fillToothNoDownl) {
		this.fillToothNoDownl = fillToothNoDownl;
	}

	public String getFillToothNoDownr() {
		return this.fillToothNoDownr;
	}

	public void setFillToothNoDownr(String fillToothNoDownr) {
		this.fillToothNoDownr = fillToothNoDownr;
	}

	public String getPeriodontalCehckResult() {
		return this.periodontalCehckResult;
	}

	public void setPeriodontalCehckResult(String periodontalCehckResult) {
		this.periodontalCehckResult = periodontalCehckResult;
	}

	public String getToothOther() {
		return this.toothOther;
	}

	public void setToothOther(String toothOther) {
		this.toothOther = toothOther;
	}

	public String getToothDoctor() {
		return this.toothDoctor;
	}

	public void setToothDoctor(String toothDoctor) {
		this.toothDoctor = toothDoctor;
	}

	public String getHeartCheckResult() {
		return this.heartCheckResult;
	}

	public void setHeartCheckResult(String heartCheckResult) {
		this.heartCheckResult = heartCheckResult;
	}

	public String getHeartOther() {
		return this.heartOther;
	}

	public void setHeartOther(String heartOther) {
		this.heartOther = heartOther;
	}

	public String getLiverCheckResult() {
		return this.liverCheckResult;
	}

	public void setLiverCheckResult(String liverCheckResult) {
		this.liverCheckResult = liverCheckResult;
	}

	public String getLiverOther() {
		return this.liverOther;
	}

	public void setLiverOther(String liverOther) {
		this.liverOther = liverOther;
	}

	public String getLungsCheckResult() {
		return this.lungsCheckResult;
	}

	public void setLungsCheckResult(String lungsCheckResult) {
		this.lungsCheckResult = lungsCheckResult;
	}

	public String getLungsOther() {
		return this.lungsOther;
	}

	public void setLungsOther(String lungsOther) {
		this.lungsOther = lungsOther;
	}

	public String getSpleenCheckResult() {
		return this.spleenCheckResult;
	}

	public void setSpleenCheckResult(String spleenCheckResult) {
		this.spleenCheckResult = spleenCheckResult;
	}

	public String getSpleenOther() {
		return this.spleenOther;
	}

	public void setSpleenOther(String spleenOther) {
		this.spleenOther = spleenOther;
	}

	public String getInternalDoctor() {
		return this.internalDoctor;
	}

	public void setInternalDoctor(String internalDoctor) {
		this.internalDoctor = internalDoctor;
	}

	public String getHeadCheckResult() {
		return this.headCheckResult;
	}

	public void setHeadCheckResult(String headCheckResult) {
		this.headCheckResult = headCheckResult;
	}

	public String getHeadOther() {
		return headOther;
	}

	public void setHeadOther(String headOther) {
		this.headOther = headOther;
	}

	public String getNeckCheckResult() {
		return this.neckCheckResult;
	}

	public void setNeckCheckResult(String neckCheckResult) {
		this.neckCheckResult = neckCheckResult;
	}

	public String getNeckOther() {
		return this.neckOther;
	}

	public void setNeckOther(String neckOther) {
		this.neckOther = neckOther;
	}

	public String getChestCheckResult() {
		return this.chestCheckResult;
	}

	public void setChestCheckResult(String chestCheckResult) {
		this.chestCheckResult = chestCheckResult;
	}

	public String getChestOther() {
		return chestOther;
	}

	public void setChestOther(String chestOther) {
		this.chestOther = chestOther;
	}

	public String getSpineCheckResult() {
		return this.spineCheckResult;
	}

	public void setSpineCheckResult(String spineCheckResult) {
		this.spineCheckResult = spineCheckResult;
	}

	public String getSpineOther() {
		return this.spineOther;
	}

	public void setSpineOther(String spineOther) {
		this.spineOther = spineOther;
	}

	public String getLimbsCheckResult() {
		return this.limbsCheckResult;
	}

	public void setLimbsCheckResult(String limbsCheckResult) {
		this.limbsCheckResult = limbsCheckResult;
	}

	public String getLimbsOther() {
		return limbsOther;
	}

	public void setLimbsOther(String limbsOther) {
		this.limbsOther = limbsOther;
	}

	public String getSkinCheckResult() {
		return this.skinCheckResult;
	}

	public void setSkinCheckResult(String skinCheckResult) {
		this.skinCheckResult = skinCheckResult;
	}

	public String getSkinOther() {
		return skinOther;
	}

	public void setSkinOther(String skinOther) {
		this.skinOther = skinOther;
	}

	public String getLymphNodeCheckResult() {
		return this.lymphNodeCheckResult;
	}

	public void setLymphNodeCheckResult(String lymphNodeCheckResult) {
		this.lymphNodeCheckResult = lymphNodeCheckResult;
	}

	public String getLymphNodeOther() {
		return this.lymphNodeOther;
	}

	public void setLymphNodeOther(String lymphNodeOther) {
		this.lymphNodeOther = lymphNodeOther;
	}

	public String getSurgeryDoctor() {
		return this.surgeryDoctor;
	}

	public void setSurgeryDoctor(String surgeryDoctor) {
		this.surgeryDoctor = surgeryDoctor;
	}

	public String getTuberculinTest() {
		return this.tuberculinTest;
	}

	public void setTuberculinTest(String tuberculinTest) {
		this.tuberculinTest = tuberculinTest;
	}

	public Double getHemoglobinValue() {
		return this.hemoglobinValue;
	}

	public void setHemoglobinValue(Double hemoglobinValue) {
		this.hemoglobinValue = hemoglobinValue;
	}

	public Double getSerumGptValue() {
		return this.serumGptValue;
	}

	public void setSerumGptValue(Double serumGptValue) {
		this.serumGptValue = serumGptValue;
	}

	public Double getTotalBilirubin() {
		return this.totalBilirubin;
	}

	public void setTotalBilirubin(Double totalBilirubin) {
		this.totalBilirubin = totalBilirubin;
	}

	public String getLabTestDoctor() {
		return this.labTestDoctor;
	}

	public void setLabTestDoctor(String labTestDoctor) {
		this.labTestDoctor = labTestDoctor;
	}

	public String getOtherCheckItem() {
		return this.otherCheckItem;
	}

	public void setOtherCheckItem(String otherCheckItem) {
		this.otherCheckItem = otherCheckItem;
	}

	public String getOtherCheckResult() {
		return this.otherCheckResult;
	}

	public void setOtherCheckResult(String otherCheckResult) {
		this.otherCheckResult = otherCheckResult;
	}

	public String getOtherCheckDoctor() {
		return this.otherCheckDoctor;
	}

	public void setOtherCheckDoctor(String otherCheckDoctor) {
		this.otherCheckDoctor = otherCheckDoctor;
	}

	public String getExaminationResult() {
		return this.examinationResult;
	}

	public void setExaminationResult(String examinationResult) {
		this.examinationResult = examinationResult;
	}

	public String getManaDoctorName() {
		return this.manaDoctorName;
	}

	public void setManaDoctorName(String manaDoctorName) {
		this.manaDoctorName = manaDoctorName;
	}

	public String getHealthGuidance() {
		return this.healthGuidance;
	}

	public void setHealthGuidance(String healthGuidance) {
		this.healthGuidance = healthGuidance;
	}

	public String getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(String totalResult) {
		this.totalResult = totalResult;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperateOrgan() {
		return operateOrgan;
	}

	public void setOperateOrgan(String operateOrgan) {
		this.operateOrgan = operateOrgan;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getGenderName() {
		if ("1".equals(gender)) {
			return "男";
		} else if ("2".equals(gender)) {
			return "女";
		}
		return null;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Double getAge() {
		if (age == null) {
			if (examDate == null) {
				return DateUtil.getAgeByBirthday(birthday, new Date());
			}
			return DateUtil.getAgeByBirthday(birthday, examDate);
		}
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public String getFatherEducation() {
		return fatherEducation;
	}

	public void setFatherEducation(String fatherEducation) {
		this.fatherEducation = fatherEducation;
	}

	public String getMotherEducation() {
		return motherEducation;
	}

	public void setMotherEducation(String motherEducation) {
		this.motherEducation = motherEducation;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}
	
}