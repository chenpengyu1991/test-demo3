package com.founder.rhip.ehr.entity.control.idm.special;

import com.founder.fasf.util.StringUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "IDM_LIST_FR")
public class ListFr implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

    @Column(name = "VISIT_NO", columnDefinition = "VARCHAR2|随访编号|20|", length = 20, nullable = true)
    private String visitNo;
    
	@Column(name = "VISIT_INST", columnDefinition = "VARCHAR2|访视单位（DC字典表）|100|", length = 100, nullable = true)
	private String visitInst;

	@Column(name = "VISIT_BY_ID", columnDefinition = "VARCHAR2|访视人（DC字典表）|50|", length = 50, nullable = true)
	private String visitById;

	@Column(name = "VISIT_CONTENT", columnDefinition = "VARCHAR2|访视内容及改进意见|200|", length = 200, nullable = true)
	private String visitContent;

	@Column(name = "VISIT_DT", columnDefinition = "DATE|访视日期||", nullable = true)
	private Date visitDt;

	@Column(name = "FEVER_DAYS", columnDefinition = "VARCHAR2|发热天数|20|", length = 20, nullable = true)
	private String feverDays;

	@Column(name = "FEVER_TYPE", columnDefinition = "VARCHAR2|热型|20|", length = 20, nullable = true)
	private String feverType;

	@Column(name = "TEMPERATURE", columnDefinition = "VARCHAR2|体温|20|", length = 20, nullable = true)
	private String temperature;

	@Column(name = "CHECK_TYPE", columnDefinition = "VARCHAR2|检测方法|100|", length = 100, nullable = true)
	private String checkType;

	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|检测结果|100|", length = 100, nullable = true)
	private String checkResult;

	@Column(name = "IMPRESS_TYPE", columnDefinition = "VARCHAR2|印象|2|", length = 2, nullable = true)
	private String impressType;

	@Column(name = "IMPRESS_OTHER", columnDefinition = "VARCHAR2|印象其他|100|", length = 100, nullable = true)
	private String impressOther;

	@Column(name = "FOLLOWUP_TIMES", columnDefinition = "NUMBER|随访次数||", length = 4, nullable = true)
	private Integer followupTimes;

	@Column(name = "SKIN_LESION", columnDefinition = "VARCHAR2|皮肤损害|100|", length = 100, nullable = true)
	private String skinLesion;

	@Column(name = "NERVE_LESION", columnDefinition = "VARCHAR2|周围神经损害|100|", length = 100, nullable = true)
	private String nerveLesion;

	@Column(name = "LEPROSY", columnDefinition = "VARCHAR2|麻风反应|2|", length = 2, nullable = true)
	private String leprosy;

	@Column(name = "LEPROSY_TYPE", columnDefinition = "VARCHAR2|麻风反应类型|2|", length = 2, nullable = true)
	private String leprosyType;

	@Column(name = "ULCER", columnDefinition = "VARCHAR2|溃疡|2|", length = 2, nullable = true)
	private String ulcer;

	@Column(name = "ULCER_HAND", columnDefinition = "VARCHAR2|溃疡－手|2|", length = 2, nullable = true)
	private String ulcerHand;

	@Column(name = "ULCER_LEG", columnDefinition = "VARCHAR2|溃疡－小腿|2|", length = 2, nullable = true)
	private String ulcerLeg;

	@Column(name = "ULCER_ANKLE", columnDefinition = "VARCHAR2|溃疡－踝|2|", length = 2, nullable = true)
	private String ulcerAnkle;

	@Column(name = "ULCER_FOOT", columnDefinition = "VARCHAR2|溃疡－足底|2|", length = 2, nullable = true)
	private String ulcerFoot;

	@Column(name = "ULCER_TOE", columnDefinition = "VARCHAR2|溃疡－趾|2|", length = 2, nullable = true)
	private String ulcerToe;

	@Column(name = "ULCER_OTHER", columnDefinition = "VARCHAR2|溃疡－其他|100|", length = 100, nullable = true)
	private String ulcerOther;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断结论|2|", length = 2, nullable = true)
	private String diagnosis;

	@Column(name = "CHECK_USER", columnDefinition = "VARCHAR2|检查人||", length = 50, nullable = true)
	private String checkUser;

	@Column(name = "BLOOD_PRESSURE", columnDefinition = "VARCHAR2|血压|20|", length = 20, nullable = true)
	private String bloodPressure;

	@Column(name = "PULSE", columnDefinition = "VARCHAR2|脉搏|20|", length = 20, nullable = true)
	private String pulse;

	@Column(name = "PACHULOSIS", columnDefinition = "VARCHAR2|皮肤粗糙|2|", length = 2, nullable = true)
	private String pachulosis;

	@Column(name = "SKIN_LICHEN", columnDefinition = "VARCHAR2|皮肤苔藓样变|2|", length = 2, nullable = true)
	private String skinLichen;

	@Column(name = "PITTING_EDEMA", columnDefinition = "VARCHAR2|凹陷性水肿|2|", length = 2, nullable = true)
	private String pittingEdema;

	@Column(name = "DEFORMITY", columnDefinition = "VARCHAR2|患肢畸形|2|", length = 2, nullable = true)
	private String deformity;

	@Column(name = "LYMPHATIC", columnDefinition = "VARCHAR2|淋巴管/结炎发作|2|", length = 2, nullable = true)
	private String lymphatic;

	@Column(name = "LAST_BREAK_DT", columnDefinition = "DATE|最近发作时间||", nullable = true)
	private Date lastBreakDt;

	@Column(name = "BREAK_PART", columnDefinition = "VARCHAR2|发作部位|2|", length = 2, nullable = true)
	private String breakPart;

	@Column(name = "TRAIT", columnDefinition = "VARCHAR2|特点|2|", length = 2, nullable = true)
	private String trait;

	@Column(name = "HYPERPYREXIA_SHIVER", columnDefinition = "VARCHAR2|高热寒战|2|", length = 2, nullable = true)
	private String hyperpyrexiaShiver;

	@Column(name = "HEALTH", columnDefinition = "VARCHAR2|卫生清洗|2|", length = 2, nullable = true)
	private String health;

	@Column(name = "INFECTION", columnDefinition = "VARCHAR2|防治感染|2|", length = 2, nullable = true)
	private String infection;

	@Column(name = "RAISE", columnDefinition = "VARCHAR2|患肢抬高|2|", length = 2, nullable = true)
	private String raise;

	@Column(name = "EXERCISE", columnDefinition = "VARCHAR2|患肢锻炼|2|", length = 2, nullable = true)
	private String exercise;

	@Column(name = "IS_BREAK", columnDefinition = "VARCHAR2|有无发作|2|", length = 2, nullable = true)
	private String isBreak;

	@Column(name = "BREAK_DURATION", columnDefinition = "VARCHAR2|发作持续时间|2|", length = 2, nullable = true)
	private String breakDuration;

	@Column(name = "INCENTIVE", columnDefinition = "VARCHAR2|发作诱因|2|", length = 2, nullable = true)
	private String incentive;

	@Column(name = "URINE_FACADE", columnDefinition = "VARCHAR2|尿液外观|2|", length = 2, nullable = true)
	private String urineFacade;

	@Column(name = "URINE_HARD", columnDefinition = "VARCHAR2|排尿困难|2|", length = 2, nullable = true)
	private String urineHard;

	@Column(name = "CHYLE", columnDefinition = "VARCHAR2|乳糜试验|2|", length = 2, nullable = true)
	private String chyle;

	@Column(name = "TREAT_CONDITION", columnDefinition = "VARCHAR2|治疗情况|2|", length = 2, nullable = true)
	private String treatCondition;

	@Column(name = "DIET", columnDefinition = "VARCHAR2|饮食|2|", length = 2, nullable = true)
	private String diet;

	@Column(name = "WATER", columnDefinition = "VARCHAR2|水量|2|", length = 2, nullable = true)
	private String water;

	@Column(name = "WORK_CONDITION", columnDefinition = "VARCHAR2|劳作情况|2|", length = 2, nullable = true)
	private String workCondition;

	@Column(name = "SPORT", columnDefinition = "VARCHAR2|剧烈运动|2|", length = 2, nullable = true)
	private String sport;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String mofigyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
	private String flag;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 100, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
	private String age;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|电话|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|居住地－县|100|", length = 100, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|居住地－村|100|", length = 100, nullable = true)
	private String pastreet;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|居住地－地址|100|", length = 100, nullable = true)
	private String pahouseNumber;

	@Column(name = "CASE_TYPE", columnDefinition = "VARCHAR2|病例类型|2|", length = 2, nullable = true)
	private String caseType;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|400|", length = 400, nullable = true)
	private String comments;

	@Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长姓名|50|", length = 50, nullable = true)
	private String parentsName;

	@Column(name = "LYMPHATIC_LAST_BREAK_DT", columnDefinition = "DATE|淋巴管/结炎发作:最近发作时间||", nullable = true)
	private Date lymphaticLastBreakDt;

	@Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址详细|100|", length = 100, nullable = true)
	private String paAddress;

	@Column(name = "FOLLOWUP_STATUS", columnDefinition = "VARCHAR2|随访状态|2|", length = 2, nullable = true)
	private String followupStatus;

	@Column(name = "LAPSE", columnDefinition = "VARCHAR2|转归|2|", length = 2, nullable = true)
	private String lapse;

	@Column(name = "SKIN_LESION_STATUS", columnDefinition = "VARCHAR2|皮损状态|2|", length = 2, nullable = true)
	private String skinLesionStatus;

	@Column(name = "NERVOUS_LESION", columnDefinition = "VARCHAR2|神经损害|2|", length = 2, nullable = true)
	private String nervousLesion;

	@Column(name = "EAR_RIGHT_THICK", columnDefinition = "VARCHAR2|耳右粗大|2|", length = 2, nullable = true)
	private String earRightThick;

	@Column(name = "EAR_LEFT_THICK", columnDefinition = "VARCHAR2|耳左粗大|2|", length = 2, nullable = true)
	private String earLeftThick;

	@Column(name = "ORBIT_RIGHT_THICK", columnDefinition = "VARCHAR2|眶右粗大|2|", length = 2, nullable = true)
	private String orbitRightThick;

	@Column(name = "ORBIT_LEFT_THICK", columnDefinition = "VARCHAR2|眶左粗大|2|", length = 2, nullable = true)
	private String orbitLeftThick;

	@Column(name = "ULNAR_RIGHT_THICK", columnDefinition = "VARCHAR2|尺右粗大|2|", length = 2, nullable = true)
	private String ulnarRightThick;

	@Column(name = "ULNAR_LEFT_THICK", columnDefinition = "VARCHAR2|尺左粗大|2|", length = 2, nullable = true)
	private String ulnarLeftThick;

	@Column(name = "PERONEAL_RIGHT_THICK", columnDefinition = "VARCHAR2|腓右粗大|2|", length = 2, nullable = true)
	private String peronealRightThick;

	@Column(name = "PERONEAL_LEFT_THICK", columnDefinition = "VARCHAR2|腓左粗大|2|", length = 2, nullable = true)
	private String peronealLeftThick;

	@Column(name = "MEDIAN_RIGHT_THICK", columnDefinition = "VARCHAR2|正右粗大|2|", length = 2, nullable = true)
	private String medianRightThick;

	@Column(name = "MEDIAN_LEFT_THICK", columnDefinition = "VARCHAR2|正左粗大|2|", length = 2, nullable = true)
	private String medianLeftThick;

	@Column(name = "SHIN_RIGHT_THICK", columnDefinition = "VARCHAR2|胫右粗大|2|", length = 2, nullable = true)
	private String shinRightThick;

	@Column(name = "SHIN_LEFT_THICK", columnDefinition = "VARCHAR2|胫左粗大|2|", length = 2, nullable = true)
	private String shinLeftThick;

	@Column(name = "OAR_RIGHT_THICK", columnDefinition = "VARCHAR2|桡右粗大|2|", length = 2, nullable = true)
	private String oarRightThick;

	@Column(name = "OAR_LEFT_THICK", columnDefinition = "VARCHAR2|桡左粗大|2|", length = 2, nullable = true)
	private String oarLeftThick;

	@Column(name = "FACE_RIGHT_THICK", columnDefinition = "VARCHAR2|面右粗大|2|", length = 2, nullable = true)
	private String faceRightThick;

	@Column(name = "FACE_LEFT_THICK", columnDefinition = "VARCHAR2|面左粗大|2|", length = 2, nullable = true)
	private String faceLeftThick;

	@Column(name = "EAR_RIGHT_TENDER", columnDefinition = "VARCHAR2|耳右触痛|2|", length = 2, nullable = true)
	private String earRightTender;

	@Column(name = "EAR_LEFT_TENDER", columnDefinition = "VARCHAR2|耳左触痛|2|", length = 2, nullable = true)
	private String earLeftTender;

	@Column(name = "ORBIT_RIGHT_TENDER", columnDefinition = "VARCHAR2|眶右触痛|2|", length = 2, nullable = true)
	private String orbitRightTender;

	@Column(name = "ORBIT_LEFT_TENDER", columnDefinition = "VARCHAR2|眶左触痛|2|", length = 2, nullable = true)
	private String orbitLeftTender;

	@Column(name = "ULNAR_RIGHT_TENDER", columnDefinition = "VARCHAR2|尺右触痛|2|", length = 2, nullable = true)
	private String ulnarRightTender;

	@Column(name = "ULNAR_LEFT_TENDER", columnDefinition = "VARCHAR2|尺左触痛|2|", length = 2, nullable = true)
	private String ulnarLeftTender;

	@Column(name = "PERONEAL_RIGHT_TENDER", columnDefinition = "VARCHAR2|腓右触痛|2|", length = 2, nullable = true)
	private String peronealRightTender;

	@Column(name = "PERONEAL_LEFT_TENDER", columnDefinition = "VARCHAR2|腓左触痛|2|", length = 2, nullable = true)
	private String peronealLeftTender;

	@Column(name = "MEDIAN_RIGHT_TENDER", columnDefinition = "VARCHAR2|正右触痛|2|", length = 2, nullable = true)
	private String medianRightTender;

	@Column(name = "MEDIAN_LEFT_TENDER", columnDefinition = "VARCHAR2|正左触痛|2|", length = 2, nullable = true)
	private String medianLeftTender;

	@Column(name = "SHIN_RIGHT_TENDER", columnDefinition = "VARCHAR2|胫右触痛|2|", length = 2, nullable = true)
	private String shinRightTender;

	@Column(name = "SHIN_LEFT_TENDER", columnDefinition = "VARCHAR2|胫左触痛|2|", length = 2, nullable = true)
	private String shinLeftTender;

	@Column(name = "OAR_RIGHT_TENDER", columnDefinition = "VARCHAR2|桡右触痛|2|", length = 2, nullable = true)
	private String oarRightTender;

	@Column(name = "OAR_LEFT_TENDER", columnDefinition = "VARCHAR2|桡左触痛|2|", length = 2, nullable = true)
	private String oarLeftTender;

	@Column(name = "FACE_RIGHT_TENDER", columnDefinition = "VARCHAR2|面右触痛|2|", length = 2, nullable = true)
	private String faceRightTender;

	@Column(name = "FACE_LEFT_TENDER", columnDefinition = "VARCHAR2|面左触痛|2|", length = 2, nullable = true)
	private String faceLeftTender;

	@Column(name = "OTHER_NEURO", columnDefinition = "VARCHAR2|其他精神|2|", length = 2, nullable = true)
	private String otherNeuro;

	@Column(name = "VISION_RIGHT", columnDefinition = "VARCHAR2|右眼视力|2|", length = 2, nullable = true)
	private String visionRight;

	@Column(name = "VISION_LEFT", columnDefinition = "VARCHAR2|左眼视力|2|", length = 2, nullable = true)
	private String visionLeft;

	@Column(name = "PINKEYE_RIGHT", columnDefinition = "VARCHAR2|右眼红眼|2|", length = 2, nullable = true)
	private String pinkeyeRight;

	@Column(name = "PINKEYE_LEFT", columnDefinition = "VARCHAR2|左眼红眼|2|", length = 2, nullable = true)
	private String pinkeyeLeft;

	@Column(name = "OPHTHALMODYNIA_RIGHT", columnDefinition = "VARCHAR2|右眼眼痛|2|", length = 2, nullable = true)
	private String ophthalmodyniaRight;

	@Column(name = "OPHTHALMODYNIA_LEFT", columnDefinition = "VARCHAR2|左眼眼痛|2|", length = 2, nullable = true)
	private String ophthalmodyniaLeft;

	@Column(name = "BLINK_RIGHT", columnDefinition = "VARCHAR2|右眼眨眼|2|", length = 2, nullable = true)
	private String blinkRight;

	@Column(name = "BLINK_LEFT", columnDefinition = "VARCHAR2|左眼眨眼|2|", length = 2, nullable = true)
	private String blinkLeft;

	@Column(name = "HAND_RIGHT_1", columnDefinition = "VARCHAR2|右手1|2|", length = 2, nullable = true)
	private String handRight1;

	@Column(name = "HAND_RIGHT_2", columnDefinition = "VARCHAR2|右手2|2|", length = 2, nullable = true)
	private String handRight2;

	@Column(name = "HAND_RIGHT_3", columnDefinition = "VARCHAR2|右手3|2|", length = 2, nullable = true)
	private String handRight3;

	@Column(name = "HAND_RIGHT_4", columnDefinition = "VARCHAR2|右手4|2|", length = 2, nullable = true)
	private String handRight4;

	@Column(name = "HAND_RIGHT_5", columnDefinition = "VARCHAR2|右手5|2|", length = 2, nullable = true)
	private String handRight5;

	@Column(name = "HAND_RIGHT_6", columnDefinition = "VARCHAR2|右手6|2|", length = 2, nullable = true)
	private String handRight6;

	@Column(name = "HAND_RIGHT_7", columnDefinition = "VARCHAR2|右手7|2|", length = 2, nullable = true)
	private String handRight7;

	@Column(name = "HAND_RIGHT_8", columnDefinition = "VARCHAR2|右手8|2|", length = 2, nullable = true)
	private String handRight8;

	@Column(name = "HAND_RIGHT_9", columnDefinition = "VARCHAR2|右手9|2|", length = 2, nullable = true)
	private String handRight9;

	@Column(name = "HAND_RIGHT_1_0", columnDefinition = "VARCHAR2|右手10|2|", length = 2, nullable = true)
	private String handRight10;

	@Column(name = "HAND_LEFT_1", columnDefinition = "VARCHAR2|左手1|2|", length = 2, nullable = true)
	private String handLeft1;

	@Column(name = "HAND_LEFT_2", columnDefinition = "VARCHAR2|左手2|2|", length = 2, nullable = true)
	private String handLeft2;

	@Column(name = "HAND_LEFT_3", columnDefinition = "VARCHAR2|左手3|2|", length = 2, nullable = true)
	private String handLeft3;

	@Column(name = "HAND_LEFT_4", columnDefinition = "VARCHAR2|左手4|2|", length = 2, nullable = true)
	private String handLeft4;

	@Column(name = "HAND_LEFT_5", columnDefinition = "VARCHAR2|左手5|2|", length = 2, nullable = true)
	private String handLeft5;

	@Column(name = "HAND_LEFT_6", columnDefinition = "VARCHAR2|左手6|2|", length = 2, nullable = true)
	private String handLeft6;

	@Column(name = "HAND_LEFT_7", columnDefinition = "VARCHAR2|左手7|2|", length = 2, nullable = true)
	private String handLeft7;

	@Column(name = "HAND_LEFT_8", columnDefinition = "VARCHAR2|左手8|2|", length = 2, nullable = true)
	private String handLeft8;

	@Column(name = "HAND_LEFT_9", columnDefinition = "VARCHAR2|左手9|2|", length = 2, nullable = true)
	private String handLeft9;

	@Column(name = "HAND_LEFT_1_0", columnDefinition = "VARCHAR2|左手10|2|", length = 2, nullable = true)
	private String handLeft10;

	@Column(name = "FOOT_RIGHT_1", columnDefinition = "VARCHAR2|右足1|2|", length = 2, nullable = true)
	private String footRight1;

	@Column(name = "FOOT_RIGHT_2", columnDefinition = "VARCHAR2|右足2|2|", length = 2, nullable = true)
	private String footRight2;

	@Column(name = "FOOT_RIGHT_3", columnDefinition = "VARCHAR2|右足3|2|", length = 2, nullable = true)
	private String footRight3;

	@Column(name = "FOOT_RIGHT_4", columnDefinition = "VARCHAR2|右足4|2|", length = 2, nullable = true)
	private String footRight4;

	@Column(name = "FOOT_RIGHT_5", columnDefinition = "VARCHAR2|右足5|2|", length = 2, nullable = true)
	private String footRight5;

	@Column(name = "FOOT_RIGHT_6", columnDefinition = "VARCHAR2|右足6|2|", length = 2, nullable = true)
	private String footRight6;

	@Column(name = "FOOT_RIGHT_7", columnDefinition = "VARCHAR2|右足7|2|", length = 2, nullable = true)
	private String footRight7;

	@Column(name = "FOOT_RIGHT_8", columnDefinition = "VARCHAR2|右足8|2|", length = 2, nullable = true)
	private String footRight8;

	@Column(name = "FOOT_RIGHT_9", columnDefinition = "VARCHAR2|右足9|2|", length = 2, nullable = true)
	private String footRight9;

	@Column(name = "FOOT_RIGHT_1_0", columnDefinition = "VARCHAR2|右足10|2|", length = 2, nullable = true)
	private String footRight10;

	@Column(name = "FOOT_LEFT_1", columnDefinition = "VARCHAR2|左足1|2|", length = 2, nullable = true)
	private String footLeft1;

	@Column(name = "FOOT_LEFT_2", columnDefinition = "VARCHAR2|左足2|2|", length = 2, nullable = true)
	private String footLeft2;

	@Column(name = "FOOT_LEFT_3", columnDefinition = "VARCHAR2|左足3|2|", length = 2, nullable = true)
	private String footLeft3;

	@Column(name = "FOOT_LEFT_4", columnDefinition = "VARCHAR2|左足4|2|", length = 2, nullable = true)
	private String footLeft4;

	@Column(name = "FOOT_LEFT_5", columnDefinition = "VARCHAR2|左足5|2|", length = 2, nullable = true)
	private String footLeft5;

	@Column(name = "FOOT_LEFT_6", columnDefinition = "VARCHAR2|左足6|2|", length = 2, nullable = true)
	private String footLeft6;

	@Column(name = "FOOT_LEFT_7", columnDefinition = "VARCHAR2|左足7|2|", length = 2, nullable = true)
	private String footLeft7;

	@Column(name = "FOOT_LEFT_8", columnDefinition = "VARCHAR2|左足8|2|", length = 2, nullable = true)
	private String footLeft8;

	@Column(name = "FOOT_LEFT_9", columnDefinition = "VARCHAR2|左足9|2|", length = 2, nullable = true)
	private String footLeft9;

	@Column(name = "FOOT_LEFT_1_0", columnDefinition = "VARCHAR2|左足10|2|", length = 2, nullable = true)
	private String footLeft10;

	@Column(name = "ULNAR_RIGHT_STATUS", columnDefinition = "VARCHAR2|尺右状态|100|", length = 100, nullable = true)
	private String ulnarRightStatus;

	@Column(name = "ULNAR_LEFT_STATUS", columnDefinition = "VARCHAR2|尺左状态|100|", length = 100, nullable = true)
	private String ulnarLeftStatus;

	@Column(name = "MEDIAN_RIGHT_STATUS", columnDefinition = "VARCHAR2|正右状态|100|", length = 100, nullable = true)
	private String medianRightStatus;

	@Column(name = "MEDIAN_LEFT_STATUS", columnDefinition = "VARCHAR2|正左状态|100|", length = 100, nullable = true)
	private String medianLeftStatus;

	@Column(name = "PLANTA_RIGHT_STATUS", columnDefinition = "VARCHAR2|足右状态|100|", length = 100, nullable = true)
	private String plantaRightStatus;

	@Column(name = "PLANTA_LEFT_STATUS", columnDefinition = "VARCHAR2|足左状态|100|", length = 100, nullable = true)
	private String plantaLeftStatus;

	@Column(name = "EYELID_RIGHT_STATUS", columnDefinition = "VARCHAR2|睑右状态|100|", length = 100, nullable = true)
	private String eyelidRightStatus;

	@Column(name = "EYELID_LEFT_STATUS", columnDefinition = "VARCHAR2|睑左状态|100|", length = 100, nullable = true)
	private String eyelidLeftStatus;

	@Column(name = "LITTLE_FINGER_RIGHT_STATUS", columnDefinition = "VARCHAR2|小指右状态|100|", length = 100, nullable = true)
	private String littleFingerRightStatus;

	@Column(name = "LITTLE_FINGER_LEFT_STATUS", columnDefinition = "VARCHAR2|小指左状态|100|", length = 100, nullable = true)
	private String littleFingerLeftStatus;

	@Column(name = "THUMB_RIGHT_STATUS", columnDefinition = "VARCHAR2|拇指右状态|100|", length = 100, nullable = true)
	private String thumbRightStatus;

	@Column(name = "THUMB_LEFT_STATUS", columnDefinition = "VARCHAR2|拇指左状态|100|", length = 100, nullable = true)
	private String thumbLeftStatus;

	@Column(name = "WRIST_RIGHT_STATUS", columnDefinition = "VARCHAR2|腕右状态|100|", length = 100, nullable = true)
	private String wristRightStatus;

	@Column(name = "WRIST_LEFT_STATUS", columnDefinition = "VARCHAR2|腕左状态|100|", length = 100, nullable = true)
	private String wristLeftStatus;

	@Column(name = "FOOT_RIGHT_STATUS", columnDefinition = "VARCHAR2|足右状态|100|", length = 100, nullable = true)
	private String footRightStatus;

	@Column(name = "FOOT_LEFT_STATUS", columnDefinition = "VARCHAR2|足左状态|100|", length = 100, nullable = true)
	private String footLeftStatus;

	@Column(name = "ULNAR_RIGHT_MONTHS", columnDefinition = "VARCHAR2|尺右月数|20|", length = 20, nullable = true)
	private String ulnarRightMonths;

	@Column(name = "ULNAR_LEFT_MONTHS", columnDefinition = "VARCHAR2|尺左月数|20|", length = 20, nullable = true)
	private String ulnarLeftMonths;

	@Column(name = "MEDIAN_RIGHT_MONTHS", columnDefinition = "VARCHAR2|正右月数|20|", length = 20, nullable = true)
	private String medianRightMonths;

	@Column(name = "MEDIAN_LEFT_MONTHS", columnDefinition = "VARCHAR2|正左月数|20|", length = 20, nullable = true)
	private String medianLeftMonths;

	@Column(name = "PLANTA_RIGHT_MONTHS", columnDefinition = "VARCHAR2|足右月数|20|", length = 20, nullable = true)
	private String plantaRightMonths;

	@Column(name = "PLANTA_LEFT_MONTHS", columnDefinition = "VARCHAR2|足左月数|20|", length = 20, nullable = true)
	private String plantaLeftMonths;

	@Column(name = "EYELID_RIGHT_MONTHS", columnDefinition = "VARCHAR2|睑右月数|20|", length = 20, nullable = true)
	private String eyelidRightMonths;

	@Column(name = "EYELID_LEFT_MONTHS", columnDefinition = "VARCHAR2|睑左月数|20|", length = 20, nullable = true)
	private String eyelidLeftMonths;

	@Column(name = "LITTLE_FINGER_RIGHT_MONTHS", columnDefinition = "VARCHAR2|小指右月数|20|", length = 20, nullable = true)
	private String littleFingerRightMonths;

	@Column(name = "LITTLE_FINGER_LEFT_MONTHS", columnDefinition = "VARCHAR2|小指左月数|20|", length = 20, nullable = true)
	private String littleFingerLeftMonths;

	@Column(name = "THUMB_RIGHT_MONTHS", columnDefinition = "VARCHAR2|拇指右月数|20|", length = 20, nullable = true)
	private String thumbRightMonths;

	@Column(name = "THUMB_LEFT_MONTHS", columnDefinition = "VARCHAR2|拇指左月数|20|", length = 20, nullable = true)
	private String thumbLeftMonths;

	@Column(name = "WRIST_RIGHT_MONTHS", columnDefinition = "VARCHAR2|腕右月数|20|", length = 20, nullable = true)
	private String wristRightMonths;

	@Column(name = "WRIST_LEFT_MONTHS", columnDefinition = "VARCHAR2|腕左月数|20|", length = 20, nullable = true)
	private String wristLeftMonths;

	@Column(name = "FOOT_RIGHT_MONTHS", columnDefinition = "VARCHAR2|足右月数|20|", length = 20, nullable = true)
	private String footRightMonths;

	@Column(name = "FOOT_LEFT_MONTHS", columnDefinition = "VARCHAR2|足左月数|20|", length = 20, nullable = true)
	private String footLeftMonths;

	@Column(name = "NEURITIS_HAPPEN_DT", columnDefinition = "DATE|神经炎发生日期||", nullable = true)
	private Date neuritisHappenDt;

	@Column(name = "NEURITIS_DIAGNOSIS_DT", columnDefinition = "DATE|神经炎确诊日期||", nullable = true)
	private Date neuritisDiagnosisDt;

	@Column(name = "ASSESSMENT", columnDefinition = "VARCHAR2|检查评价|200|", length = 200, nullable = true)
	private String Assessment;

	@Column(name = "REACTION_HAPPEN_DT", columnDefinition = "DATE|反应发生日期||", nullable = true)
	private Date reactionHappenDt;

	@Column(name = "REACTION_DIAGNOSIS_DT", columnDefinition = "DATE|反应确诊日期||", nullable = true)
	private Date reactionDiagnosisDt;

	@Column(name = "SKIN_RUBEDO_INFILTRATION", columnDefinition = "VARCHAR2|皮损发红浸润|2|", length = 2, nullable = true)
	private String skinRubedoInfiltration;

	@Column(name = "NEURITIS_1", columnDefinition = "VARCHAR2|神经炎1|2|", length = 2, nullable = true)
	private String neuritis1;

	@Column(name = "ENL", columnDefinition = "VARCHAR2|ENL|2|", length = 2, nullable = true)
	private String enl;

	@Column(name = "ARTHRITIS", columnDefinition = "VARCHAR2|关节炎|2|", length = 2, nullable = true)
	private String arthritis;

	@Column(name = "NEURITIS_2", columnDefinition = "VARCHAR2|神经炎2|2|", length = 2, nullable = true)
	private String neuritis2;

	@Column(name = "DISCOMFORT", columnDefinition = "VARCHAR2|不适|2|", length = 2, nullable = true)
	private String discomfort;

	@Column(name = "FEVER", columnDefinition = "VARCHAR2|发热|2|", length = 2, nullable = true)
	private String fever;

	@Column(name = "EDEMA", columnDefinition = "VARCHAR2|浮肿|2|", length = 2, nullable = true)
	private String edema;

	@Column(name = "ORCHIEPIDIDYMITIS", columnDefinition = "VARCHAR2|睾丸附睾炎|2|", length = 2, nullable = true)
	private String orchiepididymitis;

	@Column(name = "IRIDOCYCLITIS", columnDefinition = "VARCHAR2|虹膜睫状体炎|2|", length = 2, nullable = true)
	private String iridocyclitis;

	@Column(name = "REACTION_DESCRIPTION", columnDefinition = "VARCHAR2|反正描述|400|", length = 400, nullable = true)
	private String reactionDescription;

	@Column(name = "EYE_RIGHT_0", columnDefinition = "VARCHAR2|0眼右|2|", length = 2, nullable = true)
	private String eyeRight0;

	@Column(name = "EYE_LEFT_0", columnDefinition = "VARCHAR2|0眼左|2|", length = 2, nullable = true)
	private String eyeLeft0;

	@Column(name = "HAND_RIGHT_0", columnDefinition = "VARCHAR2|0手右|2|", length = 2, nullable = true)
	private String handRight0;

	@Column(name = "HAND_LEFT_0", columnDefinition = "VARCHAR2|0手左|2|", length = 2, nullable = true)
	private String handLeft0;

	@Column(name = "FOOT_RIGHT_0", columnDefinition = "VARCHAR2|0足右|2|", length = 2, nullable = true)
	private String footRight0;

	@Column(name = "FOOT_LEFT_0", columnDefinition = "VARCHAR2|0足左|2|", length = 2, nullable = true)
	private String footLeft0;

	@Column(name = "CORNEA_RIGHT_1", columnDefinition = "VARCHAR2|1角膜感觉障碍眼右|2|", length = 2, nullable = true)
	private String corneaRight1;

	@Column(name = "CORNEA_LEFT_1", columnDefinition = "VARCHAR2|1角膜感觉障碍眼左|2|", length = 2, nullable = true)
	private String corneaLeft1;

	@Column(name = "FEEL_HAND_RIGHT_1", columnDefinition = "VARCHAR2|1保护性感觉障碍手右|2|", length = 2, nullable = true)
	private String feelHandRight1;

	@Column(name = "FEEL_HAND_LEFT_1", columnDefinition = "VARCHAR2|1保护性感觉障碍手左|2|", length = 2, nullable = true)
	private String feelHandLeft1;

	@Column(name = "FEEL_FOOT_RIGHT_1", columnDefinition = "VARCHAR2|1保护性感觉障碍足右|2|", length = 2, nullable = true)
	private String feelFootRight1;

	@Column(name = "FEEL_FOOT_LEFT_1", columnDefinition = "VARCHAR2|1保护性感觉障碍足左|2|", length = 2, nullable = true)
	private String feelFootLeft1;

	@Column(name = "LAGOPHTHALMOS_RIGHT_2", columnDefinition = "VARCHAR2|2兔眼右|2|", length = 2, nullable = true)
	private String lagophthalmosRight2;

	@Column(name = "LAGOPHTHALMOS_LEFT_2", columnDefinition = "VARCHAR2|2兔眼左|2|", length = 2, nullable = true)
	private String lagophthalmosLeft2;

	@Column(name = "CLAWHAND_RIGHT_2", columnDefinition = "VARCHAR2|2爪形手右|2|", length = 2, nullable = true)
	private String clawhandRight2;

	@Column(name = "CLAWHAND_LEFT_2", columnDefinition = "VARCHAR2|2爪形手左|2|", length = 2, nullable = true)
	private String clawhandLeft2;

	@Column(name = "PEDAL_RIGHT_2", columnDefinition = "VARCHAR2|2垂足右|2|", length = 2, nullable = true)
	private String pedalRight2;

	@Column(name = "PEDAL_LEFT_2", columnDefinition = "VARCHAR2|2垂足左|2|", length = 2, nullable = true)
	private String pedalLeft2;

	@Column(name = "ECTROPION_RIGHT_2", columnDefinition = "VARCHAR2|2睑外翻右|2|", length = 2, nullable = true)
	private String ectropionRight2;

	@Column(name = "ECTROPION_LEFT_2", columnDefinition = "VARCHAR2|2睑外翻左|2|", length = 2, nullable = true)
	private String ectropionLeft2;

	@Column(name = "APE_HAND_RIGHT_2", columnDefinition = "VARCHAR2|2猿手右|2|", length = 2, nullable = true)
	private String apeHandRight2;

	@Column(name = "APE_HAND_LEFT_2", columnDefinition = "VARCHAR2|2猿手左|2|", length = 2, nullable = true)
	private String apeHandLeft2;

	@Column(name = "SKIN_CHAPPED_RIGHT_2", columnDefinition = "VARCHAR2|2皮肤皲裂伤口右|2|", length = 2, nullable = true)
	private String skinChappedRight2;

	@Column(name = "SKIN_CHAPPED_LEFT_2", columnDefinition = "VARCHAR2|2皮肤皲裂伤口左|2|", length = 2, nullable = true)
	private String skinChappedLeft2;

	@Column(name = "TRICHIASIS_RIGHT_2", columnDefinition = "VARCHAR2|2倒睫右|2|", length = 2, nullable = true)
	private String trichiasisRight2;

	@Column(name = "TRICHIASIS_LEFT_2", columnDefinition = "VARCHAR2|2倒睫左|2|", length = 2, nullable = true)
	private String trichiasisLeft2;

	@Column(name = "WRIST_DROP_RIGHT_2", columnDefinition = "VARCHAR2|2垂腕右|2|", length = 2, nullable = true)
	private String wristDropRight2;

	@Column(name = "WRIST_DROP_LEFT_2", columnDefinition = "VARCHAR2|2垂腕左|2|", length = 2, nullable = true)
	private String wristDropLeft2;

	@Column(name = "VOLA_ULCER_RIGHT_2", columnDefinition = "VARCHAR2|2单纯性足底溃疡右|2|", length = 2, nullable = true)
	private String volaUlcerRight2;

	@Column(name = "VOLA_ULCER_LEFT_2", columnDefinition = "VARCHAR2|2单纯性足底溃疡左|2|", length = 2, nullable = true)
	private String volaUlcerLeft2;

	@Column(name = "KERATITIS_RIGHT_2", columnDefinition = "VARCHAR2|2暴露性角膜炎右|2|", length = 2, nullable = true)
	private String keratitisRight2;

	@Column(name = "KERATITIS_LEFT_2", columnDefinition = "VARCHAR2|2暴露性角膜炎左|2|", length = 2, nullable = true)
	private String keratitisLeft2;

	@Column(name = "COR_CHAPPED_RIGHT_2", columnDefinition = "VARCHAR2|2皮肤角化皲裂伤口右|2|", length = 2, nullable = true)
	private String corChappedRight2;

	@Column(name = "COR_CHAPPED_LEFT_2", columnDefinition = "VARCHAR2|2皮肤角化皲裂伤口左|2|", length = 2, nullable = true)
	private String corChappedLeft2;

	@Column(name = "COM_ULCER_RIGHT_2", columnDefinition = "VARCHAR2|2复杂性足底溃疡右|2|", length = 2, nullable = true)
	private String comUlcerRight2;

	@Column(name = "COM_ULCER_LEFT_2", columnDefinition = "VARCHAR2|2复杂性足底溃疡左|2|", length = 2, nullable = true)
	private String comUlcerLeft2;

	@Column(name = "IRIS_RIGHT_2", columnDefinition = "VARCHAR2|2虹膜睫状体炎右|2|", length = 2, nullable = true)
	private String irisRight2;

	@Column(name = "IRIS_LEFT_2", columnDefinition = "VARCHAR2|2虹膜睫状体炎左|2|", length = 2, nullable = true)
	private String irisLeft2;

	@Column(name = "HAND_ULCER_RIGHT_2", columnDefinition = "VARCHAR2|2手掌溃疡右|2|", length = 2, nullable = true)
	private String handUlcerRight2;

	@Column(name = "HAND_ULCER_LEFT_2", columnDefinition = "VARCHAR2|2手掌溃疡左|2|", length = 2, nullable = true)
	private String handUlcerLeft2;

	@Column(name = "TALIPES_RIGHT_2", columnDefinition = "VARCHAR2|2爪型趾马蹄足右|2|", length = 2, nullable = true)
	private String talipesRight2;

	@Column(name = "TALIPES_LEFT_2", columnDefinition = "VARCHAR2|2爪型趾马蹄足左|2|", length = 2, nullable = true)
	private String talipesLeft2;

	@Column(name = "HYPOPSIA_RIGHT_2", columnDefinition = "VARCHAR2|2视力减退右|2|", length = 2, nullable = true)
	private String hypopsiaRight2;

	@Column(name = "HYPOPSIA_LEFT_2", columnDefinition = "VARCHAR2|2视力减退左|2|", length = 2, nullable = true)
	private String hypopsiaLeft2;

	@Column(name = "JOINT_RIGHT_2", columnDefinition = "VARCHAR2|2关节僵直右|2|", length = 2, nullable = true)
	private String jointRight2;

	@Column(name = "JOINT_LEFT_2", columnDefinition = "VARCHAR2|2关节僵直左|2|", length = 2, nullable = true)
	private String jointLeft2;

	@Column(name = "FOOT_COACTU_RIGHT_2", columnDefinition = "VARCHAR2|2足（趾）短缩或缺失右|2|", length = 2, nullable = true)
	private String footCoactuRight2;

	@Column(name = "FOOT_COACTU_LEFT_2", columnDefinition = "VARCHAR2|2足（趾）短缩或缺失左|2|", length = 2, nullable = true)
	private String footCoactuLeft2;

	@Column(name = "BLIND_RIGHT_2", columnDefinition = "VARCHAR2|2失明右|2|", length = 2, nullable = true)
	private String BlindRight2;

	@Column(name = "BLIND_LEFT_2", columnDefinition = "VARCHAR2|2失明左|2|", length = 2, nullable = true)
	private String BlindLeft2;

	@Column(name = "HAND_COACTU_RIGHT_2", columnDefinition = "VARCHAR2|2手（指）短缩或缺失右|2|", length = 2, nullable = true)
	private String handCoactuRight2;

	@Column(name = "HAND_COACTU_LEFT_2", columnDefinition = "VARCHAR2|2手（指）短缩或缺失左|2|", length = 2, nullable = true)
	private String handCoactuLeft2;

	@Column(name = "AMPUTATION_RIGHT_2", columnDefinition = "VARCHAR2|2截肢右|2|", length = 2, nullable = true)
	private String amputationRight2;

	@Column(name = "AMPUTATION_LEFT_2", columnDefinition = "VARCHAR2|2截肢左|2|", length = 2, nullable = true)
	private String amputationLeft2;

	@Column(name = "BROW_ALL_DROP", columnDefinition = "VARCHAR2|脱眉全脱|2|", length = 2, nullable = true)
	private String browAllDrop;

	@Column(name = "BROW_HALF_DROP", columnDefinition = "VARCHAR2|脱眉半脱|2|", length = 2, nullable = true)
	private String browHalfDrop;

	@Column(name = "PARALYSIS_HEMI", columnDefinition = "VARCHAR2|面瘫单侧|2|", length = 2, nullable = true)
	private String paralysisHemi;

	@Column(name = "PARALYSIS_BILATERAL", columnDefinition = "VARCHAR2|面瘫双侧|2|", length = 2, nullable = true)
	private String paralysisBilateral;

	@Column(name = "SADDLE_NOSE", columnDefinition = "VARCHAR2|鞍鼻|2|", length = 2, nullable = true)
	private String saddleNose;

	@Column(name = "OTHER_ULCER", columnDefinition = "VARCHAR2|其他溃疡|2|", length = 2, nullable = true)
	private String otherUlcer;

	@Column(name = "CURE_SCHEME", columnDefinition = "VARCHAR2|治疗方案|2|", length = 2, nullable = true)
	private String cureScheme;

	@Column(name = "CURE_SCHEME_OTHER", columnDefinition = "VARCHAR2|治疗方案其他|100|", length = 100, nullable = true)
	private String cureSchemeOther;

	@Column(name = "LEPROSY_BEGIN_DT", columnDefinition = "DATE|抗麻风开始治疗日期||", nullable = true)
	private Date leprosyBeginDt;

	@Column(name = "LEPROSY_END_DT", columnDefinition = "DATE|抗麻风完成治疗日期||", nullable = true)
	private Date leprosyEndDt;

	@Column(name = "LEPROSY_EFFECT", columnDefinition = "VARCHAR2|抗麻风疗效评价|2|", length = 2, nullable = true)
	private String leprosyEffect;

	@Column(name = "CURE_ADDRESS", columnDefinition = "VARCHAR2|治疗地点|2|", length = 2, nullable = true)
	private String cureAddress;

	@Column(name = "LEPROSY_EXPLAIN", columnDefinition = "VARCHAR2|抗麻风治疗说明|200|", length = 200, nullable = true)
	private String leprosyExplain;

	@Column(name = "NEURITIS_BEGIN_DT", columnDefinition = "DATE|神经炎开始治疗日期||", nullable = true)
	private Date neuritisBeginDt;

	@Column(name = "NEURITIS_END_DT", columnDefinition = "DATE|神经炎完成治疗日期||", nullable = true)
	private Date neuritisEndDt;

	@Column(name = "NEURITIS_EFFECT", columnDefinition = "VARCHAR2|神经炎疗效评价|2|", length = 2, nullable = true)
	private String neuritisEffect;

	@Column(name = "NEURITIS_1_DRUG", columnDefinition = "VARCHAR2|神经炎第一治疗药物|2|", length = 2, nullable = true)
	private String neuritis1Drug;

	@Column(name = "NEURITIS_1_DRUG_OTH", columnDefinition = "VARCHAR2|神经炎第一治疗药物其他|2|", length = 2, nullable = true)
	private String neuritis1DrugOth;

	@Column(name = "NEURITIS_2_DRUG", columnDefinition = "VARCHAR2|神经炎第二治疗药物|2|", length = 2, nullable = true)
	private String neuritis2Drug;

	@Column(name = "NEURITIS_2_DRUG_OTH", columnDefinition = "VARCHAR2|神经炎第二治疗药物其他|2|", length = 2, nullable = true)
	private String neuritis2DrugOth;

	@Column(name = "NEURITIS_3_DRUG", columnDefinition = "VARCHAR2|神经炎第三治疗药物|2|", length = 2, nullable = true)
	private String neuritis3Drug;

	@Column(name = "NEURITIS_3_DRUG_OTH", columnDefinition = "VARCHAR2|神经炎第三治疗药物其他|2|", length = 2, nullable = true)
	private String neuritis3DrugOth;

	@Column(name = "NEURITIS_EXPLAIN", columnDefinition = "VARCHAR2|神经炎治疗说明|400|", length = 400, nullable = true)
	private String neuritisExplain;

	@Column(name = "FUNCTION_EVALUATION", columnDefinition = "VARCHAR2|功能评价|2|", length = 2, nullable = true)
	private String functionEvaluation;

	@Column(name = "REACTION_BEGIN_DT", columnDefinition = "DATE|反应治疗开始治疗日期||", nullable = true)
	private Date reactionBeginDt;

	@Column(name = "REACTION_END_DT", columnDefinition = "DATE|反应治疗完成治疗日期||", nullable = true)
	private Date reactionEndDt;

	@Column(name = "REACTION_EFFECT", columnDefinition = "VARCHAR2|反应治疗疗效评价|2|", length = 2, nullable = true)
	private String reactionEffect;

	@Column(name = "REACTION_1_DRUG", columnDefinition = "VARCHAR2|反应治疗第一治疗药物|2|", length = 2, nullable = true)
	private String reaction1Drug;

	@Column(name = "REACTION_1_DRUG_OTH", columnDefinition = "VARCHAR2|反应治疗第一治疗药物其他|2|", length = 2, nullable = true)
	private String reaction1DrugOth;

	@Column(name = "REACTION_2_DRUG", columnDefinition = "VARCHAR2|反应治疗第二治疗药物|2|", length = 2, nullable = true)
	private String reaction2Drug;

	@Column(name = "REACTION_2_DRUG_OTH", columnDefinition = "VARCHAR2|反应治疗第二治疗药物其他|2|", length = 2, nullable = true)
	private String reaction2DrugOth;

	@Column(name = "REACTION_3_DRUG", columnDefinition = "VARCHAR2|反应治疗第三治疗药物|2|", length = 2, nullable = true)
	private String reaction3Drug;

	@Column(name = "REACTION_3_DRUG_OTH", columnDefinition = "VARCHAR2|反应治疗第三治疗药物其他|2|", length = 2, nullable = true)
	private String reaction3DrugOth;

	@Column(name = "REACTION_EXPLAIN", columnDefinition = "VARCHAR2|反应治疗治疗说明|400|", length = 400, nullable = true)
	private String reactionExplain;

	@Column(name = "PROGRESS_NOTE", columnDefinition = "CLOB|病程记录||", nullable = true)
	private String progressNote;

	@Column(name = "MIN_DOCTOR_NAME", columnDefinition = "VARCHAR2|医生签名|100|", length = 100, nullable = true)
	private String minDoctorName;

	@Column(name = "CHECK_FUNGUS", columnDefinition = "VARCHAR2|随访时查菌|2|", length = 2, nullable = true)
	private String checkFungus;

	@Column(name = "FUNGUS_DT", columnDefinition = "DATE|查菌日期||", nullable = true)
	private Date fungusDt;

	@Column(name = "FUNGUS_UNIT_PROPERTY", columnDefinition = "VARCHAR2|查菌单位性质|2|", length = 2, nullable = true)
	private String fungusUnitProperty;

	@Column(name = "FUNGUS_UNIT_PROPERTY_DETAIL", columnDefinition = "VARCHAR2|查菌单位性质（括号内的）|2|", length = 2, nullable = true)
	private String fungusUnitPropertyDetail;

	@Column(name = "ORBIT_RIGHT", columnDefinition = "VARCHAR2|眶上右|20|", length = 20, nullable = true)
	private String orbitRight;

	@Column(name = "ORBIT_LEFT", columnDefinition = "VARCHAR2|眶上左|20|", length = 20, nullable = true)
	private String orbitLeft;

	@Column(name = "EAR_RIGHT", columnDefinition = "VARCHAR2|耳垂右|20|", length = 20, nullable = true)
	private String earRight;

	@Column(name = "EAR_LEFT", columnDefinition = "VARCHAR2|耳垂左|20|", length = 20, nullable = true)
	private String earLeft;

	@Column(name = "MANDIBLE", columnDefinition = "VARCHAR2|下颌|20|", length = 20, nullable = true)
	private String mandible;

	@Column(name = "SKIN_UP_1", columnDefinition = "VARCHAR2|皮损上1|20|", length = 20, nullable = true)
	private String skinUp1;

	@Column(name = "SKIN_UP_2", columnDefinition = "VARCHAR2|皮损上2|20|", length = 20, nullable = true)
	private String skinUp2;

	@Column(name = "SKIN_UP_3", columnDefinition = "VARCHAR2|皮损上3|20|", length = 20, nullable = true)
	private String skinUp3;

	@Column(name = "SKIN_DOWN_1", columnDefinition = "VARCHAR2|皮损下1|20|", length = 20, nullable = true)
	private String skinDown1;

	@Column(name = "SKIN_DOWN_2", columnDefinition = "VARCHAR2|皮损下2|20|", length = 20, nullable = true)
	private String skinDown2;

	@Column(name = "SKIN_DOWN_3", columnDefinition = "VARCHAR2|皮损下3|20|", length = 20, nullable = true)
	private String skinDown3;

	@Column(name = "BI", columnDefinition = "VARCHAR2|BI|20|", length = 20, nullable = true)
	private String BI;

	@Column(name = "MI", columnDefinition = "VARCHAR2|MI|20|", length = 20, nullable = true)
	private String MI;

	@Column(name = "PATHOLOGY", columnDefinition = "VARCHAR2|随访时病理|2|", length = 2, nullable = true)
	private String pathology;

	@Column(name = "MATERIALS_DT", columnDefinition = "DATE|取材日期||", nullable = true)
	private Date materialsDt;

	@Column(name = "MATERIALS_PART", columnDefinition = "VARCHAR2|取材部位|100|", length = 100, nullable = true)
	private String materialsPart;

	@Column(name = "BACILLI_CHECK", columnDefinition = "VARCHAR2|抗酸杆菌检查|100|", length = 100, nullable = true)
	private String bacilliCheck;

	@Column(name = "BACILLI_UNIT_PRO", columnDefinition = "VARCHAR2|检查单位性质|2|", length = 2, nullable = true)
	private String bacilliUnitPro;

	@Column(name = "BACILLI_UNIT_PRO_DETAIL", columnDefinition = "VARCHAR2|检查单位性质（括号内的）|2|", length = 2, nullable = true)
	private String bacilliUnitProDetail;

	@Column(name = "PATHOLOGY_EXPLAIN", columnDefinition = "VARCHAR2|病理描述|400|", length = 400, nullable = true)
	private String pathologyExplain;

	@Column(name = "BLOOD_ROUTINE", columnDefinition = "VARCHAR2|血常规|2|", length = 2, nullable = true)
	private String bloodRoutine;

	@Column(name = "PISS_ROUTINE", columnDefinition = "VARCHAR2|尿常规|2|", length = 2, nullable = true)
	private String pissRoutine;

	@Column(name = "FECES_ROUTINE", columnDefinition = "VARCHAR2|粪常规|2|", length = 2, nullable = true)
	private String fecesRoutine;

	@Column(name = "LIVER_FUNCTION", columnDefinition = "VARCHAR2|肝功能|2|", length = 2, nullable = true)
	private String liverFunction;

	@Column(name = "RENAL_FUNCTION", columnDefinition = "VARCHAR2|肾功能|2|", length = 2, nullable = true)
	private String renalFunction;

	@Column(name = "OTHER_CHECK", columnDefinition = "VARCHAR2|其他检查|2|", length = 2, nullable = true)
	private String otherCheck;

	@Column(name = "EXCEPTION_DESCRIP", columnDefinition = "VARCHAR2|异常描述|400|", length = 400, nullable = true)
	private String exceptionDescrip;

	@Column(name = "PRECAUTION", columnDefinition = "VARCHAR2|防护措施|100|", length = 100, nullable = true)
	private String precaution;

	@Column(name = "SHOE_DT", columnDefinition = "DATE|发防护鞋日期||", nullable = true)
	private Date shoeDt;

	@Column(name = "SHOE_COUNT", columnDefinition = "VARCHAR2|发防护鞋双数|20|", length = 20, nullable = true)
	private String shoeCount;

	@Column(name = "SHOE_FREQUENCY", columnDefinition = "VARCHAR2|穿鞋频率|20|", length = 20, nullable = true)
	private String shoeFrequency;

	@Column(name = "ARTIFICIAL_LIMB", columnDefinition = "VARCHAR2|安装假肢需求|100|", length = 100, nullable = true)
	private String artificialLimb;

	@Column(name = "MAINTAIN_LIMB", columnDefinition = "VARCHAR2|维修假肢需求|100|", length = 100, nullable = true)
	private String maintainLimb;

	@Column(name = "OPS_RABBIT_RIGHT", columnDefinition = "VARCHAR2|手术兔眼右|2|", length = 2, nullable = true)
	private String opsRabbitRight;

	@Column(name = "OPS_RABBIT_LEFT", columnDefinition = "VARCHAR2|手术兔眼左|2|", length = 2, nullable = true)
	private String opsRabbitLeft;

	@Column(name = "OPS_ECTROPION_RIGHT", columnDefinition = "VARCHAR2|手术眼睑外翻右|2|", length = 2, nullable = true)
	private String opsEctropionRight;

	@Column(name = "OPS_ECTROPION_LEFT", columnDefinition = "VARCHAR2|手术眼睑外翻左|2|", length = 2, nullable = true)
	private String opsEctropionLeft;

	@Column(name = "OPS_CATARACT_RIGHT", columnDefinition = "VARCHAR2|手术白内障右|2|", length = 2, nullable = true)
	private String opsCataractRight;

	@Column(name = "OPS_CATARACT_LEFT", columnDefinition = "VARCHAR2|手术白内障左|2|", length = 2, nullable = true)
	private String opsCataractLeft;

	@Column(name = "OPS_PARALYSIS_RIGHT", columnDefinition = "VARCHAR2|手术面瘫右|2|", length = 2, nullable = true)
	private String opsParalysisRight;

	@Column(name = "OPS_PARALYSIS_LEFT", columnDefinition = "VARCHAR2|手术面瘫左|2|", length = 2, nullable = true)
	private String opsParalysisLeft;

	@Column(name = "OPS_CLAWHAND_RIGHT", columnDefinition = "VARCHAR2|手术爪形手右|2|", length = 2, nullable = true)
	private String opsClawhandRight;

	@Column(name = "OPS_CLAWHAND_LEFT", columnDefinition = "VARCHAR2|手术爪形手左|2|", length = 2, nullable = true)
	private String opsClawhandLeft;

	@Column(name = "OPS_APEHAND_RIGHT", columnDefinition = "VARCHAR2|手术猿手右|2|", length = 2, nullable = true)
	private String opsApehandRight;

	@Column(name = "OPS_APEHAND_LEFT", columnDefinition = "VARCHAR2|手术猿手左|2|", length = 2, nullable = true)
	private String opsApehandLeft;

	@Column(name = "OPS_WRIST_DROP_RIGHT", columnDefinition = "VARCHAR2|手术垂腕右|2|", length = 2, nullable = true)
	private String opsWristDropRight;

	@Column(name = "OPS_WRIST_DROP_LEFT", columnDefinition = "VARCHAR2|手术垂腕左|2|", length = 2, nullable = true)
	private String opsWristDropLeft;

	@Column(name = "OPS_PEDAL_RIGHT", columnDefinition = "VARCHAR2|手术垂足右|2|", length = 2, nullable = true)
	private String opsPedalRight;

	@Column(name = "OPS_PEDAL_LEFT", columnDefinition = "VARCHAR2|手术垂足左|2|", length = 2, nullable = true)
	private String opsPedalLeft;

	@Column(name = "OPS_AMPUTATION_RIGHT", columnDefinition = "VARCHAR2|手术截肢右|2|", length = 2, nullable = true)
	private String opsAmputationRight;

	@Column(name = "OPS_AMPUTATION_LEFT", columnDefinition = "VARCHAR2|手术截肢左|2|", length = 2, nullable = true)
	private String opsAmputationLeft;

	@Column(name = "OPS_ULCER_RIGHT", columnDefinition = "VARCHAR2|手术溃疡清创右|2|", length = 2, nullable = true)
	private String opsUlcerRight;

	@Column(name = "OPS_ULCER_LEFT", columnDefinition = "VARCHAR2|手术溃疡清创左|2|", length = 2, nullable = true)
	private String opsUlcerLeft;

	@Column(name = "SCHEME_EXPLAIN", columnDefinition = "VARCHAR2|方案说明|400|", length = 400, nullable = true)
	private String schemeExplain;

	@Column(name = "UNEFFECT_HAPPEN_DT", columnDefinition = "DATE|药物不良反应发现日期||", nullable = true)
	private Date uneffectHappenDt;

	@Column(name = "UNEFFECT_DIAG_DT", columnDefinition = "DATE|药物不良反应确诊日期||", nullable = true)
	private Date uneffectDiagDt;

	@Column(name = "UNEFFECT_DRUG", columnDefinition = "VARCHAR2|发生反应的药物|2|", length = 2, nullable = true)
	private String uneffectDrug;

	@Column(name = "UNEFFECT_DRUG_OTHER", columnDefinition = "VARCHAR2|发生反应的药物其他|100|", length = 100, nullable = true)
	private String uneffectDrugOther;

	@Column(name = "UNEFFECT_DIAG", columnDefinition = "VARCHAR2|不良反应诊断|100|", length = 100, nullable = true)
	private String uneffectDiag;

	@Column(name = "CURE_STEP", columnDefinition = "VARCHAR2|治疗措施|2|", length = 2, nullable = true)
	private String cureStep;

	@Column(name = "CURE_STEP_OTHER", columnDefinition = "VARCHAR2|治疗措施其他|100|", length = 100, nullable = true)
	private String cureStepOther;

	@Column(name = "CURE_STEP_EXPLAIN", columnDefinition = "VARCHAR2|治疗措施说明|400|", length = 400, nullable = true)
	private String cureStepExplain;

	@Column(name = "CURE_UNIT_PROPERTY", columnDefinition = "VARCHAR2|治疗单位级别|2|", length = 2, nullable = true)
	private String cureUnitProperty;

	@Column(name = "UNEFFECT_RESULT", columnDefinition = "VARCHAR2|不良反应结果|2|", length = 2, nullable = true)
	private String uneffectResult;

	@Column(name = "LAPSE_DT", columnDefinition = "DATE|转归日期||", nullable = true)
	private Date lapseDt;

	@Column(name = "UNEFFECT_EXPLAIN", columnDefinition = "VARCHAR2|不良反应描述|400|", length = 400, nullable = true)
	private String uneffectExplain;

	@Column(name = "DIE_DT", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date dieDt;

	@Column(name = "DIE_REASON", columnDefinition = "VARCHAR2|死亡原因|2|", length = 2, nullable = true)
	private String dieReason;

	@Column(name = "DIE_REASON_OTHER", columnDefinition = "VARCHAR2|死亡原因其他|100|", length = 100, nullable = true)
	private String dieReasonOther;

	@Column(name = "DIE_EXPLAIN", columnDefinition = "VARCHAR2|死亡情况说明|400|", length = 400, nullable = true)
	private String dieExplain;

	@Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|总医生签名|100|", length = 100, nullable = true)
	private String doctorName;

    @Column(name = "ATTACK_DT", columnDefinition = "DATE|发病日期||", nullable = true)
    private Date attackDt;

    @Column(name = "TREATMENT_DT", columnDefinition = "Date|就诊日期||", nullable = true)
    private Date treatmentDt;

    @Column(name = "TREATMENT_UNIT", columnDefinition = "VARCHAR2|初次就诊医院|100|", length = 100, nullable = true)
    private String treatmentUnit;

    @Column(name = "IN_HOSPITAL", columnDefinition = "VARCHAR2|是否住院|2|", length = 2, nullable = true)
    private String inHospital;

    @Column(name = "RASH", columnDefinition = "VARCHAR2|皮疹|2|", length = 2, nullable = true)
    private String rash;

    @Column(name = "OTHER_SYMPTOM", columnDefinition = "VARCHAR2|其他症状|100|", length = 100, nullable = true)
    private String otherSymptom;

    @Column(name = "DISEASE_PROGRESS", columnDefinition = "VARCHAR2|病情进展|2|", length = 2, nullable = true)
    private String diseaseProgress;

    @Column(name = "TRANSFER_UNIT", columnDefinition = "VARCHAR2|转诊机构|100|", length = 100, nullable = true)
    private String transferUnit;

	@Column(name = "FOLLOW_UP", columnDefinition = "VARCHAR2|是否进行病例随访|2|", length = 2, nullable = true)
	private String followUp;

	@Column(name = "FOLLOW_UP_UNIT", columnDefinition = "VARCHAR2|随访单位|2|", length = 2, nullable = true)
	private String followUpUnit;

	@Column(name = "FOLLOWUP_CASE_DIE", columnDefinition = "VARCHAR2|病例死亡|2|", length = 2, nullable = true)
	private String followupCaseDie;

	@Column(name = "FOLLOWUP_CASE_LOST_FOLLOWUP", columnDefinition = "VARCHAR2|病例失访|2|", length = 2, nullable = true)
	private String followupCaseLostFollowup;

	@Column(name = "FOLLOWUP_RESIDUAL_PARALYSIS", columnDefinition = "VARCHAR2|是否残留麻痹|2|", length = 2, nullable = true)
	private String followupResidualParalysis;

	@Column(name = "LEFT_UPPER_LIMB", columnDefinition = "VARCHAR2|左上肢|2|", length = 2, nullable = true)
	private String leftUpperLimb;

	@Column(name = "RIGHT_UPPER_LIMB", columnDefinition = "VARCHAR2|右上肢|2|", length = 2, nullable = true)
	private String rightUpperLimb;

	@Column(name = "LEFT_LOWER_LIMB", columnDefinition = "VARCHAR2|左下肢|2|", length = 2, nullable = true)
	private String leftLowerLimb;

	@Column(name = "RIGHT_LOWER_LIMB", columnDefinition = "VARCHAR2|右下肢|2|", length = 2, nullable = true)
	private String rightLowerLimb;

	@Column(name = "LIMB_SENSORY_DISTURBANCE", columnDefinition = "VARCHAR2|肢体感觉障碍|2|", length = 2, nullable = true)
	private String limbSensoryDisturbance;

	@Column(name = "LIMB_PART", columnDefinition = "VARCHAR2|部位(请注明)|100|", length = 100, nullable = true)
	private String limbPart;

	@Column(name = "INCONTINENT_DURATION", columnDefinition = "VARCHAR2|如有大小便失禁,持续时间|20|", length = 20, nullable = true)
	private String incontinentDuration;

	@Column(name = "BABINSKI_REFLEX", columnDefinition = "VARCHAR2|巴彬斯基氏反射|2|", length = 2, nullable = true)
	private String babinskiReflex;

	@Column(name = "ANKLE_CLONUS", columnDefinition = "VARCHAR2|踝阵挛|2|", length = 2, nullable = true)
	private String ankleClonus;

	@Column(name = "MUSCLE_ATROPHY", columnDefinition = "VARCHAR2|肌肉萎缩|2|", length = 2, nullable = true)
	private String muscleAtrophy;

	@Column(name = "MUSCLE_PART", columnDefinition = "VARCHAR2|部位(请注明)|100|", length = 100, nullable = true)
	private String musclePart;

	@Column(name = "DTR_UNUSUAL", columnDefinition = "VARCHAR2|深部腱反射异常|2|", length = 2, nullable = true)
	private String dtrUnusual;

	@Column(name = "TENDO_CALCANEUS", columnDefinition = "VARCHAR2|跟腱|2|", length = 2, nullable = true)
	private String tendoCalcaneus;

	@Column(name = "KNEE", columnDefinition = "VARCHAR2|膝|2|", length = 2, nullable = true)
	private String knee;

	@Column(name = "BICEPS_BRACHII", columnDefinition = "VARCHAR2|肱二头肌|2|", length = 2, nullable = true)
	private String bicepsBrachii;

	@Column(name = "LOCOMOTOR_ACTIVITY", columnDefinition = "VARCHAR2|行走能力|2|", length = 2, nullable = true)
	private String locomotorActivity;

	@Column(name = "CHECK_DOCTOR", columnDefinition = "VARCHAR2|检查医师|2|", length = 2, nullable = true)
	private String checkDoctor;

	@Column(name = "OUT_HOSPITL_DIAGNOSIS", columnDefinition = "VARCHAR2|病例出院诊断|2|", length = 2, nullable = true)
	private String outHospitlDiagnosis;

	@Column(name = "DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|其它|100|", length = 100, nullable = true)
	private String diagnosisOther;

	@Column(name = "TO_CDC_DT", columnDefinition = "DATE|随访表送达省CDC时间||", nullable = true)
	private Date toCdcDt;
	
	@Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|传染病报告卡编号-病例编号|30|", length = 30, nullable = true)
	private String recordNumber;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;
	
	@Column(name = "CHECK_DOCTOR_OTHER", columnDefinition = "VARCHAR2|检查医师-其他|100|", length = 100, nullable = true)
	private String checkDoctorOther;
	
	@Transient
    private String listLcJson;

    @Transient
    private List<ListLc> listLcs;

	@Transient
    private String visitInstStr;
    
	@Transient
    private String visitByIdStr;
	
	@Transient
    private String impressTypeStr;
	
	@Transient
    private String listCcJson;

    @Transient
    private List<ListCc> listCcs;

    @Transient
    private List<ListFr> listFrs;

    @Transient
    private String listFrJson;
    
    @Transient
    private String infectiousCode;
    
    public String getImpressTypeStr() {
        String result = "";
        if(StringUtil.isNotEmpty(impressType)){
            if("1".equals(impressType)){
                result = "治愈";
            }else if("2".equals(impressType)){
                result = "复发";
            }else if("4".equals(impressType)){
                result = "再感染";
            }
        }
        return result;
    }
    
    public void setImpressTypeStr(String impressTypeStr) {
        this.impressTypeStr = impressTypeStr;
    }
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getIdmId() {
		return idmId;
	}

	
	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	
	public String getVisitNo() {
		return visitNo;
	}

	
	public void setVisitNo(String visitNo) {
		this.visitNo = visitNo;
	}

	
	public String getVisitInst() {
		return visitInst;
	}

	
	public void setVisitInst(String visitInst) {
		this.visitInst = visitInst;
	}

	
	public String getVisitById() {
		return visitById;
	}

	
	public void setVisitById(String visitById) {
		this.visitById = visitById;
	}

	
	public String getVisitContent() {
		return visitContent;
	}

	
	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}

	
	public Date getVisitDt() {
		return visitDt;
	}

	
	public void setVisitDt(Date visitDt) {
		this.visitDt = visitDt;
	}

	
	public String getFeverDays() {
		return feverDays;
	}

	
	public void setFeverDays(String feverDays) {
		this.feverDays = feverDays;
	}

	
	public String getFeverType() {
		return feverType;
	}

	
	public void setFeverType(String feverType) {
		this.feverType = feverType;
	}

	
	public String getTemperature() {
		return temperature;
	}

	
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	
	public String getCheckType() {
		return checkType;
	}

	
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	
	public String getCheckResult() {
		return checkResult;
	}

	
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	
	public String getImpressType() {
		return impressType;
	}

	
	public void setImpressType(String impressType) {
		this.impressType = impressType;
	}

	
	public String getImpressOther() {
		return impressOther;
	}

	
	public void setImpressOther(String impressOther) {
		this.impressOther = impressOther;
	}

	
	public Integer getFollowupTimes() {
		return followupTimes;
	}

	
	public void setFollowupTimes(Integer followupTimes) {
		this.followupTimes = followupTimes;
	}

	
	public String getSkinLesion() {
		return skinLesion;
	}

	
	public void setSkinLesion(String skinLesion) {
		this.skinLesion = skinLesion;
	}

	
	public String getNerveLesion() {
		return nerveLesion;
	}

	
	public void setNerveLesion(String nerveLesion) {
		this.nerveLesion = nerveLesion;
	}

	
	public String getLeprosy() {
		return leprosy;
	}

	
	public void setLeprosy(String leprosy) {
		this.leprosy = leprosy;
	}

	
	public String getLeprosyType() {
		return leprosyType;
	}

	
	public void setLeprosyType(String leprosyType) {
		this.leprosyType = leprosyType;
	}

	
	public String getUlcer() {
		return ulcer;
	}

	
	public void setUlcer(String ulcer) {
		this.ulcer = ulcer;
	}

	
	public String getUlcerHand() {
		return ulcerHand;
	}

	
	public void setUlcerHand(String ulcerHand) {
		this.ulcerHand = ulcerHand;
	}

	
	public String getUlcerLeg() {
		return ulcerLeg;
	}

	
	public void setUlcerLeg(String ulcerLeg) {
		this.ulcerLeg = ulcerLeg;
	}

	
	public String getUlcerAnkle() {
		return ulcerAnkle;
	}

	
	public void setUlcerAnkle(String ulcerAnkle) {
		this.ulcerAnkle = ulcerAnkle;
	}

	
	public String getUlcerFoot() {
		return ulcerFoot;
	}

	
	public void setUlcerFoot(String ulcerFoot) {
		this.ulcerFoot = ulcerFoot;
	}

	
	public String getUlcerToe() {
		return ulcerToe;
	}

	
	public void setUlcerToe(String ulcerToe) {
		this.ulcerToe = ulcerToe;
	}

	
	public String getUlcerOther() {
		return ulcerOther;
	}

	
	public void setUlcerOther(String ulcerOther) {
		this.ulcerOther = ulcerOther;
	}

	
	public String getDiagnosis() {
		return diagnosis;
	}

	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	public String getCheckUser() {
		return checkUser;
	}

	
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	
	public String getBloodPressure() {
		return bloodPressure;
	}

	
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	
	public String getPulse() {
		return pulse;
	}

	
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	
	public String getPachulosis() {
		return pachulosis;
	}

	
	public void setPachulosis(String pachulosis) {
		this.pachulosis = pachulosis;
	}

	
	public String getSkinLichen() {
		return skinLichen;
	}

	
	public void setSkinLichen(String skinLichen) {
		this.skinLichen = skinLichen;
	}

	
	public String getPittingEdema() {
		return pittingEdema;
	}

	
	public void setPittingEdema(String pittingEdema) {
		this.pittingEdema = pittingEdema;
	}

	
	public String getDeformity() {
		return deformity;
	}

	
	public void setDeformity(String deformity) {
		this.deformity = deformity;
	}

	
	public String getLymphatic() {
		return lymphatic;
	}

	
	public void setLymphatic(String lymphatic) {
		this.lymphatic = lymphatic;
	}

	
	public Date getLastBreakDt() {
		return lastBreakDt;
	}

	
	public void setLastBreakDt(Date lastBreakDt) {
		this.lastBreakDt = lastBreakDt;
	}

	
	public String getBreakPart() {
		return breakPart;
	}

	
	public void setBreakPart(String breakPart) {
		this.breakPart = breakPart;
	}

	
	public String getTrait() {
		return trait;
	}

	
	public void setTrait(String trait) {
		this.trait = trait;
	}

	
	public String getHyperpyrexiaShiver() {
		return hyperpyrexiaShiver;
	}

	
	public void setHyperpyrexiaShiver(String hyperpyrexiaShiver) {
		this.hyperpyrexiaShiver = hyperpyrexiaShiver;
	}

	
	public String getHealth() {
		return health;
	}

	
	public void setHealth(String health) {
		this.health = health;
	}

	
	public String getInfection() {
		return infection;
	}

	
	public void setInfection(String infection) {
		this.infection = infection;
	}

	
	public String getRaise() {
		return raise;
	}

	
	public void setRaise(String raise) {
		this.raise = raise;
	}

	
	public String getExercise() {
		return exercise;
	}

	
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	
	public String getIsBreak() {
		return isBreak;
	}

	
	public void setIsBreak(String isBreak) {
		this.isBreak = isBreak;
	}

	
	public String getBreakDuration() {
		return breakDuration;
	}

	
	public void setBreakDuration(String breakDuration) {
		this.breakDuration = breakDuration;
	}

	
	public String getIncentive() {
		return incentive;
	}

	
	public void setIncentive(String incentive) {
		this.incentive = incentive;
	}

	
	public String getUrineFacade() {
		return urineFacade;
	}

	
	public void setUrineFacade(String urineFacade) {
		this.urineFacade = urineFacade;
	}

	
	public String getUrineHard() {
		return urineHard;
	}

	
	public void setUrineHard(String urineHard) {
		this.urineHard = urineHard;
	}

	
	public String getChyle() {
		return chyle;
	}

	
	public void setChyle(String chyle) {
		this.chyle = chyle;
	}

	
	public String getTreatCondition() {
		return treatCondition;
	}

	
	public void setTreatCondition(String treatCondition) {
		this.treatCondition = treatCondition;
	}

	
	public String getDiet() {
		return diet;
	}

	
	public void setDiet(String diet) {
		this.diet = diet;
	}

	
	public String getWater() {
		return water;
	}

	
	public void setWater(String water) {
		this.water = water;
	}

	
	public String getWorkCondition() {
		return workCondition;
	}

	
	public void setWorkCondition(String workCondition) {
		this.workCondition = workCondition;
	}

	
	public String getSport() {
		return sport;
	}

	
	public void setSport(String sport) {
		this.sport = sport;
	}

	
	public String getCreateUnit() {
		return createUnit;
	}

	
	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	
	public Date getCreateDt() {
		return createDt;
	}

	
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	
	public String getCreateUser() {
		return createUser;
	}

	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	
	public String getModifyUnit() {
		return modifyUnit;
	}

	
	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	
	public Date getModifyDt() {
		return modifyDt;
	}

	
	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	
	public String getMofigyUser() {
		return mofigyUser;
	}

	
	public void setMofigyUser(String mofigyUser) {
		this.mofigyUser = mofigyUser;
	}

	
	public Integer getIsDelete() {
		return isDelete;
	}

	
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	
	public String getFlag() {
		return flag;
	}

	
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
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

	
	public String getAge() {
		return age;
	}

	
	public void setAge(String age) {
		this.age = age;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	
	public String getCaseType() {
		return caseType;
	}

	
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	
	public String getComments() {
		return comments;
	}

	
	public void setComments(String comments) {
		this.comments = comments;
	}

	
	public String getParentsName() {
		return parentsName;
	}

	
	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	
	public Date getLymphaticLastBreakDt() {
		return lymphaticLastBreakDt;
	}

	
	public void setLymphaticLastBreakDt(Date lymphaticLastBreakDt) {
		this.lymphaticLastBreakDt = lymphaticLastBreakDt;
	}

	
	public String getPaAddress() {
		return paAddress;
	}

	
	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	
	public String getFollowupStatus() {
		return followupStatus;
	}

	
	public void setFollowupStatus(String followupStatus) {
		this.followupStatus = followupStatus;
	}

	
	public String getLapse() {
		return lapse;
	}

	
	public void setLapse(String lapse) {
		this.lapse = lapse;
	}

	
	public String getSkinLesionStatus() {
		return skinLesionStatus;
	}

	
	public void setSkinLesionStatus(String skinLesionStatus) {
		this.skinLesionStatus = skinLesionStatus;
	}

	
	public String getNervousLesion() {
		return nervousLesion;
	}

	
	public void setNervousLesion(String nervousLesion) {
		this.nervousLesion = nervousLesion;
	}

	
	public String getEarRightThick() {
		return earRightThick;
	}

	
	public void setEarRightThick(String earRightThick) {
		this.earRightThick = earRightThick;
	}

	
	public String getEarLeftThick() {
		return earLeftThick;
	}

	
	public void setEarLeftThick(String earLeftThick) {
		this.earLeftThick = earLeftThick;
	}

	
	public String getOrbitRightThick() {
		return orbitRightThick;
	}

	
	public void setOrbitRightThick(String orbitRightThick) {
		this.orbitRightThick = orbitRightThick;
	}

	
	public String getOrbitLeftThick() {
		return orbitLeftThick;
	}

	
	public void setOrbitLeftThick(String orbitLeftThick) {
		this.orbitLeftThick = orbitLeftThick;
	}

	
	public String getUlnarRightThick() {
		return ulnarRightThick;
	}

	
	public void setUlnarRightThick(String ulnarRightThick) {
		this.ulnarRightThick = ulnarRightThick;
	}

	
	public String getUlnarLeftThick() {
		return ulnarLeftThick;
	}

	
	public void setUlnarLeftThick(String ulnarLeftThick) {
		this.ulnarLeftThick = ulnarLeftThick;
	}

	
	public String getPeronealRightThick() {
		return peronealRightThick;
	}

	
	public void setPeronealRightThick(String peronealRightThick) {
		this.peronealRightThick = peronealRightThick;
	}

	
	public String getPeronealLeftThick() {
		return peronealLeftThick;
	}

	
	public void setPeronealLeftThick(String peronealLeftThick) {
		this.peronealLeftThick = peronealLeftThick;
	}

	
	public String getMedianRightThick() {
		return medianRightThick;
	}

	
	public void setMedianRightThick(String medianRightThick) {
		this.medianRightThick = medianRightThick;
	}

	
	public String getMedianLeftThick() {
		return medianLeftThick;
	}

	
	public void setMedianLeftThick(String medianLeftThick) {
		this.medianLeftThick = medianLeftThick;
	}

	
	public String getShinRightThick() {
		return shinRightThick;
	}

	
	public void setShinRightThick(String shinRightThick) {
		this.shinRightThick = shinRightThick;
	}

	
	public String getShinLeftThick() {
		return shinLeftThick;
	}

	
	public void setShinLeftThick(String shinLeftThick) {
		this.shinLeftThick = shinLeftThick;
	}

	
	public String getOarRightThick() {
		return oarRightThick;
	}

	
	public void setOarRightThick(String oarRightThick) {
		this.oarRightThick = oarRightThick;
	}

	
	public String getOarLeftThick() {
		return oarLeftThick;
	}

	
	public void setOarLeftThick(String oarLeftThick) {
		this.oarLeftThick = oarLeftThick;
	}

	
	public String getFaceRightThick() {
		return faceRightThick;
	}

	
	public void setFaceRightThick(String faceRightThick) {
		this.faceRightThick = faceRightThick;
	}

	
	public String getFaceLeftThick() {
		return faceLeftThick;
	}

	
	public void setFaceLeftThick(String faceLeftThick) {
		this.faceLeftThick = faceLeftThick;
	}

	
	public String getEarRightTender() {
		return earRightTender;
	}

	
	public void setEarRightTender(String earRightTender) {
		this.earRightTender = earRightTender;
	}

	
	public String getEarLeftTender() {
		return earLeftTender;
	}

	
	public void setEarLeftTender(String earLeftTender) {
		this.earLeftTender = earLeftTender;
	}

	
	public String getOrbitRightTender() {
		return orbitRightTender;
	}

	
	public void setOrbitRightTender(String orbitRightTender) {
		this.orbitRightTender = orbitRightTender;
	}

	
	public String getOrbitLeftTender() {
		return orbitLeftTender;
	}

	
	public void setOrbitLeftTender(String orbitLeftTender) {
		this.orbitLeftTender = orbitLeftTender;
	}

	
	public String getUlnarRightTender() {
		return ulnarRightTender;
	}

	
	public void setUlnarRightTender(String ulnarRightTender) {
		this.ulnarRightTender = ulnarRightTender;
	}

	
	public String getUlnarLeftTender() {
		return ulnarLeftTender;
	}

	
	public void setUlnarLeftTender(String ulnarLeftTender) {
		this.ulnarLeftTender = ulnarLeftTender;
	}

	
	public String getPeronealRightTender() {
		return peronealRightTender;
	}

	
	public void setPeronealRightTender(String peronealRightTender) {
		this.peronealRightTender = peronealRightTender;
	}

	
	public String getPeronealLeftTender() {
		return peronealLeftTender;
	}

	
	public void setPeronealLeftTender(String peronealLeftTender) {
		this.peronealLeftTender = peronealLeftTender;
	}

	
	public String getMedianRightTender() {
		return medianRightTender;
	}

	
	public void setMedianRightTender(String medianRightTender) {
		this.medianRightTender = medianRightTender;
	}

	
	public String getMedianLeftTender() {
		return medianLeftTender;
	}

	
	public void setMedianLeftTender(String medianLeftTender) {
		this.medianLeftTender = medianLeftTender;
	}

	
	public String getShinRightTender() {
		return shinRightTender;
	}

	
	public void setShinRightTender(String shinRightTender) {
		this.shinRightTender = shinRightTender;
	}

	
	public String getShinLeftTender() {
		return shinLeftTender;
	}

	
	public void setShinLeftTender(String shinLeftTender) {
		this.shinLeftTender = shinLeftTender;
	}

	
	public String getOarRightTender() {
		return oarRightTender;
	}

	
	public void setOarRightTender(String oarRightTender) {
		this.oarRightTender = oarRightTender;
	}

	
	public String getOarLeftTender() {
		return oarLeftTender;
	}

	
	public void setOarLeftTender(String oarLeftTender) {
		this.oarLeftTender = oarLeftTender;
	}

	
	public String getFaceRightTender() {
		return faceRightTender;
	}

	
	public void setFaceRightTender(String faceRightTender) {
		this.faceRightTender = faceRightTender;
	}

	
	public String getFaceLeftTender() {
		return faceLeftTender;
	}

	
	public void setFaceLeftTender(String faceLeftTender) {
		this.faceLeftTender = faceLeftTender;
	}

	
	public String getOtherNeuro() {
		return otherNeuro;
	}

	
	public void setOtherNeuro(String otherNeuro) {
		this.otherNeuro = otherNeuro;
	}

	
	public String getVisionRight() {
		return visionRight;
	}

	
	public void setVisionRight(String visionRight) {
		this.visionRight = visionRight;
	}

	
	public String getVisionLeft() {
		return visionLeft;
	}

	
	public void setVisionLeft(String visionLeft) {
		this.visionLeft = visionLeft;
	}

	
	public String getPinkeyeRight() {
		return pinkeyeRight;
	}

	
	public void setPinkeyeRight(String pinkeyeRight) {
		this.pinkeyeRight = pinkeyeRight;
	}

	
	public String getPinkeyeLeft() {
		return pinkeyeLeft;
	}

	
	public void setPinkeyeLeft(String pinkeyeLeft) {
		this.pinkeyeLeft = pinkeyeLeft;
	}

	
	public String getOphthalmodyniaRight() {
		return ophthalmodyniaRight;
	}

	
	public void setOphthalmodyniaRight(String ophthalmodyniaRight) {
		this.ophthalmodyniaRight = ophthalmodyniaRight;
	}

	
	public String getOphthalmodyniaLeft() {
		return ophthalmodyniaLeft;
	}

	
	public void setOphthalmodyniaLeft(String ophthalmodyniaLeft) {
		this.ophthalmodyniaLeft = ophthalmodyniaLeft;
	}

	
	public String getBlinkRight() {
		return blinkRight;
	}

	
	public void setBlinkRight(String blinkRight) {
		this.blinkRight = blinkRight;
	}

	
	public String getBlinkLeft() {
		return blinkLeft;
	}

	
	public void setBlinkLeft(String blinkLeft) {
		this.blinkLeft = blinkLeft;
	}

	
	public String getHandRight1() {
		return handRight1;
	}

	
	public void setHandRight1(String handRight1) {
		this.handRight1 = handRight1;
	}

	
	public String getHandRight2() {
		return handRight2;
	}

	
	public void setHandRight2(String handRight2) {
		this.handRight2 = handRight2;
	}

	
	public String getHandRight3() {
		return handRight3;
	}

	
	public void setHandRight3(String handRight3) {
		this.handRight3 = handRight3;
	}

	
	public String getHandRight4() {
		return handRight4;
	}

	
	public void setHandRight4(String handRight4) {
		this.handRight4 = handRight4;
	}

	
	public String getHandRight5() {
		return handRight5;
	}

	
	public void setHandRight5(String handRight5) {
		this.handRight5 = handRight5;
	}

	
	public String getHandRight6() {
		return handRight6;
	}

	
	public void setHandRight6(String handRight6) {
		this.handRight6 = handRight6;
	}

	
	public String getHandRight7() {
		return handRight7;
	}

	
	public void setHandRight7(String handRight7) {
		this.handRight7 = handRight7;
	}

	
	public String getHandRight8() {
		return handRight8;
	}

	
	public void setHandRight8(String handRight8) {
		this.handRight8 = handRight8;
	}

	
	public String getHandRight9() {
		return handRight9;
	}

	
	public void setHandRight9(String handRight9) {
		this.handRight9 = handRight9;
	}

	
	public String getHandRight10() {
		return handRight10;
	}

	
	public void setHandRight10(String handRight10) {
		this.handRight10 = handRight10;
	}

	
	public String getHandLeft1() {
		return handLeft1;
	}

	
	public void setHandLeft1(String handLeft1) {
		this.handLeft1 = handLeft1;
	}

	
	public String getHandLeft2() {
		return handLeft2;
	}

	
	public void setHandLeft2(String handLeft2) {
		this.handLeft2 = handLeft2;
	}

	
	public String getHandLeft3() {
		return handLeft3;
	}

	
	public void setHandLeft3(String handLeft3) {
		this.handLeft3 = handLeft3;
	}

	
	public String getHandLeft4() {
		return handLeft4;
	}

	
	public void setHandLeft4(String handLeft4) {
		this.handLeft4 = handLeft4;
	}

	
	public String getHandLeft5() {
		return handLeft5;
	}

	
	public void setHandLeft5(String handLeft5) {
		this.handLeft5 = handLeft5;
	}

	
	public String getHandLeft6() {
		return handLeft6;
	}

	
	public void setHandLeft6(String handLeft6) {
		this.handLeft6 = handLeft6;
	}

	
	public String getHandLeft7() {
		return handLeft7;
	}

	
	public void setHandLeft7(String handLeft7) {
		this.handLeft7 = handLeft7;
	}

	
	public String getHandLeft8() {
		return handLeft8;
	}

	
	public void setHandLeft8(String handLeft8) {
		this.handLeft8 = handLeft8;
	}

	
	public String getHandLeft9() {
		return handLeft9;
	}

	
	public void setHandLeft9(String handLeft9) {
		this.handLeft9 = handLeft9;
	}

	
	public String getHandLeft10() {
		return handLeft10;
	}

	
	public void setHandLeft10(String handLeft10) {
		this.handLeft10 = handLeft10;
	}

	
	public String getFootRight1() {
		return footRight1;
	}

	
	public void setFootRight1(String footRight1) {
		this.footRight1 = footRight1;
	}

	
	public String getFootRight2() {
		return footRight2;
	}

	
	public void setFootRight2(String footRight2) {
		this.footRight2 = footRight2;
	}

	
	public String getFootRight3() {
		return footRight3;
	}

	
	public void setFootRight3(String footRight3) {
		this.footRight3 = footRight3;
	}

	
	public String getFootRight4() {
		return footRight4;
	}

	
	public void setFootRight4(String footRight4) {
		this.footRight4 = footRight4;
	}

	
	public String getFootRight5() {
		return footRight5;
	}

	
	public void setFootRight5(String footRight5) {
		this.footRight5 = footRight5;
	}

	
	public String getFootRight6() {
		return footRight6;
	}

	
	public void setFootRight6(String footRight6) {
		this.footRight6 = footRight6;
	}

	
	public String getFootRight7() {
		return footRight7;
	}

	
	public void setFootRight7(String footRight7) {
		this.footRight7 = footRight7;
	}

	
	public String getFootRight8() {
		return footRight8;
	}

	
	public void setFootRight8(String footRight8) {
		this.footRight8 = footRight8;
	}

	
	public String getFootRight9() {
		return footRight9;
	}

	
	public void setFootRight9(String footRight9) {
		this.footRight9 = footRight9;
	}

	
	public String getFootRight10() {
		return footRight10;
	}

	
	public void setFootRight10(String footRight10) {
		this.footRight10 = footRight10;
	}

	
	public String getFootLeft1() {
		return footLeft1;
	}

	
	public void setFootLeft1(String footLeft1) {
		this.footLeft1 = footLeft1;
	}

	
	public String getFootLeft2() {
		return footLeft2;
	}

	
	public void setFootLeft2(String footLeft2) {
		this.footLeft2 = footLeft2;
	}

	
	public String getFootLeft3() {
		return footLeft3;
	}

	
	public void setFootLeft3(String footLeft3) {
		this.footLeft3 = footLeft3;
	}

	
	public String getFootLeft4() {
		return footLeft4;
	}

	
	public void setFootLeft4(String footLeft4) {
		this.footLeft4 = footLeft4;
	}

	
	public String getFootLeft5() {
		return footLeft5;
	}

	
	public void setFootLeft5(String footLeft5) {
		this.footLeft5 = footLeft5;
	}

	
	public String getFootLeft6() {
		return footLeft6;
	}

	
	public void setFootLeft6(String footLeft6) {
		this.footLeft6 = footLeft6;
	}

	
	public String getFootLeft7() {
		return footLeft7;
	}

	
	public void setFootLeft7(String footLeft7) {
		this.footLeft7 = footLeft7;
	}

	
	public String getFootLeft8() {
		return footLeft8;
	}

	
	public void setFootLeft8(String footLeft8) {
		this.footLeft8 = footLeft8;
	}

	
	public String getFootLeft9() {
		return footLeft9;
	}

	
	public void setFootLeft9(String footLeft9) {
		this.footLeft9 = footLeft9;
	}

	
	public String getFootLeft10() {
		return footLeft10;
	}

	
	public void setFootLeft10(String footLeft10) {
		this.footLeft10 = footLeft10;
	}

	
	public String getUlnarRightStatus() {
		return ulnarRightStatus;
	}

	
	public void setUlnarRightStatus(String ulnarRightStatus) {
		this.ulnarRightStatus = ulnarRightStatus;
	}

	
	public String getUlnarLeftStatus() {
		return ulnarLeftStatus;
	}

	
	public void setUlnarLeftStatus(String ulnarLeftStatus) {
		this.ulnarLeftStatus = ulnarLeftStatus;
	}

	
	public String getMedianRightStatus() {
		return medianRightStatus;
	}

	
	public void setMedianRightStatus(String medianRightStatus) {
		this.medianRightStatus = medianRightStatus;
	}

	
	public String getMedianLeftStatus() {
		return medianLeftStatus;
	}

	
	public void setMedianLeftStatus(String medianLeftStatus) {
		this.medianLeftStatus = medianLeftStatus;
	}

	
	public String getPlantaRightStatus() {
		return plantaRightStatus;
	}

	
	public void setPlantaRightStatus(String plantaRightStatus) {
		this.plantaRightStatus = plantaRightStatus;
	}

	
	public String getPlantaLeftStatus() {
		return plantaLeftStatus;
	}

	
	public void setPlantaLeftStatus(String plantaLeftStatus) {
		this.plantaLeftStatus = plantaLeftStatus;
	}

	
	public String getEyelidRightStatus() {
		return eyelidRightStatus;
	}

	
	public void setEyelidRightStatus(String eyelidRightStatus) {
		this.eyelidRightStatus = eyelidRightStatus;
	}

	
	public String getEyelidLeftStatus() {
		return eyelidLeftStatus;
	}

	
	public void setEyelidLeftStatus(String eyelidLeftStatus) {
		this.eyelidLeftStatus = eyelidLeftStatus;
	}

	
	public String getLittleFingerRightStatus() {
		return littleFingerRightStatus;
	}

	
	public void setLittleFingerRightStatus(String littleFingerRightStatus) {
		this.littleFingerRightStatus = littleFingerRightStatus;
	}

	
	public String getLittleFingerLeftStatus() {
		return littleFingerLeftStatus;
	}

	
	public void setLittleFingerLeftStatus(String littleFingerLeftStatus) {
		this.littleFingerLeftStatus = littleFingerLeftStatus;
	}

	
	public String getThumbRightStatus() {
		return thumbRightStatus;
	}

	
	public void setThumbRightStatus(String thumbRightStatus) {
		this.thumbRightStatus = thumbRightStatus;
	}

	
	public String getThumbLeftStatus() {
		return thumbLeftStatus;
	}

	
	public void setThumbLeftStatus(String thumbLeftStatus) {
		this.thumbLeftStatus = thumbLeftStatus;
	}

	
	public String getWristRightStatus() {
		return wristRightStatus;
	}

	
	public void setWristRightStatus(String wristRightStatus) {
		this.wristRightStatus = wristRightStatus;
	}

	
	public String getWristLeftStatus() {
		return wristLeftStatus;
	}

	
	public void setWristLeftStatus(String wristLeftStatus) {
		this.wristLeftStatus = wristLeftStatus;
	}

	
	public String getFootRightStatus() {
		return footRightStatus;
	}

	
	public void setFootRightStatus(String footRightStatus) {
		this.footRightStatus = footRightStatus;
	}

	
	public String getFootLeftStatus() {
		return footLeftStatus;
	}

	
	public void setFootLeftStatus(String footLeftStatus) {
		this.footLeftStatus = footLeftStatus;
	}

	
	public String getUlnarRightMonths() {
		return ulnarRightMonths;
	}

	
	public void setUlnarRightMonths(String ulnarRightMonths) {
		this.ulnarRightMonths = ulnarRightMonths;
	}

	
	public String getUlnarLeftMonths() {
		return ulnarLeftMonths;
	}

	
	public void setUlnarLeftMonths(String ulnarLeftMonths) {
		this.ulnarLeftMonths = ulnarLeftMonths;
	}

	
	public String getMedianRightMonths() {
		return medianRightMonths;
	}

	
	public void setMedianRightMonths(String medianRightMonths) {
		this.medianRightMonths = medianRightMonths;
	}

	
	public String getMedianLeftMonths() {
		return medianLeftMonths;
	}

	
	public void setMedianLeftMonths(String medianLeftMonths) {
		this.medianLeftMonths = medianLeftMonths;
	}

	
	public String getPlantaRightMonths() {
		return plantaRightMonths;
	}

	
	public void setPlantaRightMonths(String plantaRightMonths) {
		this.plantaRightMonths = plantaRightMonths;
	}

	
	public String getPlantaLeftMonths() {
		return plantaLeftMonths;
	}

	
	public void setPlantaLeftMonths(String plantaLeftMonths) {
		this.plantaLeftMonths = plantaLeftMonths;
	}

	
	public String getEyelidRightMonths() {
		return eyelidRightMonths;
	}

	
	public void setEyelidRightMonths(String eyelidRightMonths) {
		this.eyelidRightMonths = eyelidRightMonths;
	}

	
	public String getEyelidLeftMonths() {
		return eyelidLeftMonths;
	}

	
	public void setEyelidLeftMonths(String eyelidLeftMonths) {
		this.eyelidLeftMonths = eyelidLeftMonths;
	}

	
	public String getLittleFingerRightMonths() {
		return littleFingerRightMonths;
	}

	
	public void setLittleFingerRightMonths(String littleFingerRightMonths) {
		this.littleFingerRightMonths = littleFingerRightMonths;
	}

	
	public String getLittleFingerLeftMonths() {
		return littleFingerLeftMonths;
	}

	
	public void setLittleFingerLeftMonths(String littleFingerLeftMonths) {
		this.littleFingerLeftMonths = littleFingerLeftMonths;
	}

	
	public String getThumbRightMonths() {
		return thumbRightMonths;
	}

	
	public void setThumbRightMonths(String thumbRightMonths) {
		this.thumbRightMonths = thumbRightMonths;
	}

	
	public String getThumbLeftMonths() {
		return thumbLeftMonths;
	}

	
	public void setThumbLeftMonths(String thumbLeftMonths) {
		this.thumbLeftMonths = thumbLeftMonths;
	}

	
	public String getWristRightMonths() {
		return wristRightMonths;
	}

	
	public void setWristRightMonths(String wristRightMonths) {
		this.wristRightMonths = wristRightMonths;
	}

	
	public String getWristLeftMonths() {
		return wristLeftMonths;
	}

	
	public void setWristLeftMonths(String wristLeftMonths) {
		this.wristLeftMonths = wristLeftMonths;
	}

	
	public String getFootRightMonths() {
		return footRightMonths;
	}

	
	public void setFootRightMonths(String footRightMonths) {
		this.footRightMonths = footRightMonths;
	}

	
	public String getFootLeftMonths() {
		return footLeftMonths;
	}

	
	public void setFootLeftMonths(String footLeftMonths) {
		this.footLeftMonths = footLeftMonths;
	}

	
	public Date getNeuritisHappenDt() {
		return neuritisHappenDt;
	}

	
	public void setNeuritisHappenDt(Date neuritisHappenDt) {
		this.neuritisHappenDt = neuritisHappenDt;
	}

	
	public Date getNeuritisDiagnosisDt() {
		return neuritisDiagnosisDt;
	}

	
	public void setNeuritisDiagnosisDt(Date neuritisDiagnosisDt) {
		this.neuritisDiagnosisDt = neuritisDiagnosisDt;
	}

	
	public String getAssessment() {
		return Assessment;
	}

	
	public void setAssessment(String assessment) {
		Assessment = assessment;
	}

	
	public Date getReactionHappenDt() {
		return reactionHappenDt;
	}

	
	public void setReactionHappenDt(Date reactionHappenDt) {
		this.reactionHappenDt = reactionHappenDt;
	}

	
	public Date getReactionDiagnosisDt() {
		return reactionDiagnosisDt;
	}

	
	public void setReactionDiagnosisDt(Date reactionDiagnosisDt) {
		this.reactionDiagnosisDt = reactionDiagnosisDt;
	}

	
	public String getSkinRubedoInfiltration() {
		return skinRubedoInfiltration;
	}

	
	public void setSkinRubedoInfiltration(String skinRubedoInfiltration) {
		this.skinRubedoInfiltration = skinRubedoInfiltration;
	}

	
	public String getNeuritis1() {
		return neuritis1;
	}

	
	public void setNeuritis1(String neuritis1) {
		this.neuritis1 = neuritis1;
	}

	
	public String getEnl() {
		return enl;
	}

	
	public void setEnl(String enl) {
		this.enl = enl;
	}

	
	public String getArthritis() {
		return arthritis;
	}

	
	public void setArthritis(String arthritis) {
		this.arthritis = arthritis;
	}

	
	public String getNeuritis2() {
		return neuritis2;
	}

	
	public void setNeuritis2(String neuritis2) {
		this.neuritis2 = neuritis2;
	}

	
	public String getDiscomfort() {
		return discomfort;
	}

	
	public void setDiscomfort(String discomfort) {
		this.discomfort = discomfort;
	}

	
	public String getFever() {
		return fever;
	}

	
	public void setFever(String fever) {
		this.fever = fever;
	}

	
	public String getEdema() {
		return edema;
	}

	
	public void setEdema(String edema) {
		this.edema = edema;
	}

	
	public String getOrchiepididymitis() {
		return orchiepididymitis;
	}

	
	public void setOrchiepididymitis(String orchiepididymitis) {
		this.orchiepididymitis = orchiepididymitis;
	}

	
	public String getIridocyclitis() {
		return iridocyclitis;
	}

	
	public void setIridocyclitis(String iridocyclitis) {
		this.iridocyclitis = iridocyclitis;
	}

	
	public String getReactionDescription() {
		return reactionDescription;
	}

	
	public void setReactionDescription(String reactionDescription) {
		this.reactionDescription = reactionDescription;
	}

	
	public String getEyeRight0() {
		return eyeRight0;
	}

	
	public void setEyeRight0(String eyeRight0) {
		this.eyeRight0 = eyeRight0;
	}

	
	public String getEyeLeft0() {
		return eyeLeft0;
	}

	
	public void setEyeLeft0(String eyeLeft0) {
		this.eyeLeft0 = eyeLeft0;
	}

	
	public String getHandRight0() {
		return handRight0;
	}

	
	public void setHandRight0(String handRight0) {
		this.handRight0 = handRight0;
	}

	
	public String getHandLeft0() {
		return handLeft0;
	}

	
	public void setHandLeft0(String handLeft0) {
		this.handLeft0 = handLeft0;
	}

	
	public String getFootRight0() {
		return footRight0;
	}

	
	public void setFootRight0(String footRight0) {
		this.footRight0 = footRight0;
	}

	
	public String getFootLeft0() {
		return footLeft0;
	}

	
	public void setFootLeft0(String footLeft0) {
		this.footLeft0 = footLeft0;
	}

	
	public String getCorneaRight1() {
		return corneaRight1;
	}

	
	public void setCorneaRight1(String corneaRight1) {
		this.corneaRight1 = corneaRight1;
	}

	
	public String getCorneaLeft1() {
		return corneaLeft1;
	}

	
	public void setCorneaLeft1(String corneaLeft1) {
		this.corneaLeft1 = corneaLeft1;
	}

	
	public String getFeelHandRight1() {
		return feelHandRight1;
	}

	
	public void setFeelHandRight1(String feelHandRight1) {
		this.feelHandRight1 = feelHandRight1;
	}

	
	public String getFeelHandLeft1() {
		return feelHandLeft1;
	}

	
	public void setFeelHandLeft1(String feelHandLeft1) {
		this.feelHandLeft1 = feelHandLeft1;
	}

	
	public String getFeelFootRight1() {
		return feelFootRight1;
	}

	
	public void setFeelFootRight1(String feelFootRight1) {
		this.feelFootRight1 = feelFootRight1;
	}

	
	public String getFeelFootLeft1() {
		return feelFootLeft1;
	}

	
	public void setFeelFootLeft1(String feelFootLeft1) {
		this.feelFootLeft1 = feelFootLeft1;
	}

	
	public String getLagophthalmosRight2() {
		return lagophthalmosRight2;
	}

	
	public void setLagophthalmosRight2(String lagophthalmosRight2) {
		this.lagophthalmosRight2 = lagophthalmosRight2;
	}

	
	public String getLagophthalmosLeft2() {
		return lagophthalmosLeft2;
	}

	
	public void setLagophthalmosLeft2(String lagophthalmosLeft2) {
		this.lagophthalmosLeft2 = lagophthalmosLeft2;
	}

	
	public String getClawhandRight2() {
		return clawhandRight2;
	}

	
	public void setClawhandRight2(String clawhandRight2) {
		this.clawhandRight2 = clawhandRight2;
	}

	
	public String getClawhandLeft2() {
		return clawhandLeft2;
	}

	
	public void setClawhandLeft2(String clawhandLeft2) {
		this.clawhandLeft2 = clawhandLeft2;
	}

	
	public String getPedalRight2() {
		return pedalRight2;
	}

	
	public void setPedalRight2(String pedalRight2) {
		this.pedalRight2 = pedalRight2;
	}

	
	public String getPedalLeft2() {
		return pedalLeft2;
	}

	
	public void setPedalLeft2(String pedalLeft2) {
		this.pedalLeft2 = pedalLeft2;
	}

	
	public String getEctropionRight2() {
		return ectropionRight2;
	}

	
	public void setEctropionRight2(String ectropionRight2) {
		this.ectropionRight2 = ectropionRight2;
	}

	
	public String getEctropionLeft2() {
		return ectropionLeft2;
	}

	
	public void setEctropionLeft2(String ectropionLeft2) {
		this.ectropionLeft2 = ectropionLeft2;
	}

	public String getApeHandRight2() {
		return apeHandRight2;
	}

	public void setApeHandRight2(String apeHandRight2) {
		this.apeHandRight2 = apeHandRight2;
	}

	public String getApeHandLeft2() {
		return apeHandLeft2;
	}

	public void setApeHandLeft2(String apeHandLeft2) {
		this.apeHandLeft2 = apeHandLeft2;
	}

	public String getSkinChappedRight2() {
		return skinChappedRight2;
	}

	
	public void setSkinChappedRight2(String skinChappedRight2) {
		this.skinChappedRight2 = skinChappedRight2;
	}

	
	public String getSkinChappedLeft2() {
		return skinChappedLeft2;
	}

	
	public void setSkinChappedLeft2(String skinChappedLeft2) {
		this.skinChappedLeft2 = skinChappedLeft2;
	}

	
	public String getTrichiasisRight2() {
		return trichiasisRight2;
	}

	
	public void setTrichiasisRight2(String trichiasisRight2) {
		this.trichiasisRight2 = trichiasisRight2;
	}

	
	public String getTrichiasisLeft2() {
		return trichiasisLeft2;
	}

	
	public void setTrichiasisLeft2(String trichiasisLeft2) {
		this.trichiasisLeft2 = trichiasisLeft2;
	}

	
	public String getWristDropRight2() {
		return wristDropRight2;
	}

	
	public void setWristDropRight2(String wristDropRight2) {
		this.wristDropRight2 = wristDropRight2;
	}

	
	public String getWristDropLeft2() {
		return wristDropLeft2;
	}

	
	public void setWristDropLeft2(String wristDropLeft2) {
		this.wristDropLeft2 = wristDropLeft2;
	}

	
	public String getVolaUlcerRight2() {
		return volaUlcerRight2;
	}

	
	public void setVolaUlcerRight2(String volaUlcerRight2) {
		this.volaUlcerRight2 = volaUlcerRight2;
	}

	
	public String getVolaUlcerLeft2() {
		return volaUlcerLeft2;
	}

	
	public void setVolaUlcerLeft2(String volaUlcerLeft2) {
		this.volaUlcerLeft2 = volaUlcerLeft2;
	}

	
	public String getKeratitisRight2() {
		return keratitisRight2;
	}

	
	public void setKeratitisRight2(String keratitisRight2) {
		this.keratitisRight2 = keratitisRight2;
	}

	
	public String getKeratitisLeft2() {
		return keratitisLeft2;
	}

	
	public void setKeratitisLeft2(String keratitisLeft2) {
		this.keratitisLeft2 = keratitisLeft2;
	}

	
	public String getCorChappedRight2() {
		return corChappedRight2;
	}

	
	public void setCorChappedRight2(String corChappedRight2) {
		this.corChappedRight2 = corChappedRight2;
	}

	
	public String getCorChappedLeft2() {
		return corChappedLeft2;
	}

	
	public void setCorChappedLeft2(String corChappedLeft2) {
		this.corChappedLeft2 = corChappedLeft2;
	}

	
	public String getComUlcerRight2() {
		return comUlcerRight2;
	}

	
	public void setComUlcerRight2(String comUlcerRight2) {
		this.comUlcerRight2 = comUlcerRight2;
	}
	
	public String getComUlcerLeft2() {
		return comUlcerLeft2;
	}

	public void setComUlcerLeft2(String comUlcerLeft2) {
		this.comUlcerLeft2 = comUlcerLeft2;
	}

	public String getIrisRight2() {
		return irisRight2;
	}

	
	public void setIrisRight2(String irisRight2) {
		this.irisRight2 = irisRight2;
	}

	
	public String getIrisLeft2() {
		return irisLeft2;
	}

	
	public void setIrisLeft2(String irisLeft2) {
		this.irisLeft2 = irisLeft2;
	}

	
	public String getHandUlcerRight2() {
		return handUlcerRight2;
	}

	
	public void setHandUlcerRight2(String handUlcerRight2) {
		this.handUlcerRight2 = handUlcerRight2;
	}

	
	public String getHandUlcerLeft2() {
		return handUlcerLeft2;
	}

	
	public void setHandUlcerLeft2(String handUlcerLeft2) {
		this.handUlcerLeft2 = handUlcerLeft2;
	}

	
	public String getTalipesRight2() {
		return talipesRight2;
	}

	
	public void setTalipesRight2(String talipesRight2) {
		this.talipesRight2 = talipesRight2;
	}

	
	public String getTalipesLeft2() {
		return talipesLeft2;
	}

	
	public void setTalipesLeft2(String talipesLeft2) {
		this.talipesLeft2 = talipesLeft2;
	}

	
	public String getHypopsiaRight2() {
		return hypopsiaRight2;
	}

	
	public void setHypopsiaRight2(String hypopsiaRight2) {
		this.hypopsiaRight2 = hypopsiaRight2;
	}

	
	public String getHypopsiaLeft2() {
		return hypopsiaLeft2;
	}

	
	public void setHypopsiaLeft2(String hypopsiaLeft2) {
		this.hypopsiaLeft2 = hypopsiaLeft2;
	}

	
	public String getJointRight2() {
		return jointRight2;
	}

	
	public void setJointRight2(String jointRight2) {
		this.jointRight2 = jointRight2;
	}

	
	public String getJointLeft2() {
		return jointLeft2;
	}

	
	public void setJointLeft2(String jointLeft2) {
		this.jointLeft2 = jointLeft2;
	}

	
	public String getFootCoactuRight2() {
		return footCoactuRight2;
	}

	
	public void setFootCoactuRight2(String footCoactuRight2) {
		this.footCoactuRight2 = footCoactuRight2;
	}

	
	public String getFootCoactuLeft2() {
		return footCoactuLeft2;
	}

	
	public void setFootCoactuLeft2(String footCoactuLeft2) {
		this.footCoactuLeft2 = footCoactuLeft2;
	}

	
	public String getBlindRight2() {
		return BlindRight2;
	}

	
	public void setBlindRight2(String blindRight2) {
		BlindRight2 = blindRight2;
	}

	
	public String getBlindLeft2() {
		return BlindLeft2;
	}

	
	public void setBlindLeft2(String blindLeft2) {
		BlindLeft2 = blindLeft2;
	}

	
	public String getHandCoactuRight2() {
		return handCoactuRight2;
	}

	
	public void setHandCoactuRight2(String handCoactuRight2) {
		this.handCoactuRight2 = handCoactuRight2;
	}

	
	public String getHandCoactuLeft2() {
		return handCoactuLeft2;
	}

	
	public void setHandCoactuLeft2(String handCoactuLeft2) {
		this.handCoactuLeft2 = handCoactuLeft2;
	}

	
	public String getAmputationRight2() {
		return amputationRight2;
	}

	
	public void setAmputationRight2(String amputationRight2) {
		this.amputationRight2 = amputationRight2;
	}

	
	public String getAmputationLeft2() {
		return amputationLeft2;
	}

	
	public void setAmputationLeft2(String amputationLeft2) {
		this.amputationLeft2 = amputationLeft2;
	}

	
	public String getBrowAllDrop() {
		return browAllDrop;
	}

	
	public void setBrowAllDrop(String browAllDrop) {
		this.browAllDrop = browAllDrop;
	}

	
	public String getBrowHalfDrop() {
		return browHalfDrop;
	}

	
	public void setBrowHalfDrop(String browHalfDrop) {
		this.browHalfDrop = browHalfDrop;
	}

	
	public String getParalysisHemi() {
		return paralysisHemi;
	}

	
	public void setParalysisHemi(String paralysisHemi) {
		this.paralysisHemi = paralysisHemi;
	}

	
	public String getParalysisBilateral() {
		return paralysisBilateral;
	}

	
	public void setParalysisBilateral(String paralysisBilateral) {
		this.paralysisBilateral = paralysisBilateral;
	}

	
	public String getSaddleNose() {
		return saddleNose;
	}

	
	public void setSaddleNose(String saddleNose) {
		this.saddleNose = saddleNose;
	}

	
	public String getOtherUlcer() {
		return otherUlcer;
	}

	
	public void setOtherUlcer(String otherUlcer) {
		this.otherUlcer = otherUlcer;
	}

	
	public String getCureScheme() {
		return cureScheme;
	}

	
	public void setCureScheme(String cureScheme) {
		this.cureScheme = cureScheme;
	}

	
	public String getCureSchemeOther() {
		return cureSchemeOther;
	}

	
	public void setCureSchemeOther(String cureSchemeOther) {
		this.cureSchemeOther = cureSchemeOther;
	}

	
	public Date getLeprosyBeginDt() {
		return leprosyBeginDt;
	}

	
	public void setLeprosyBeginDt(Date leprosyBeginDt) {
		this.leprosyBeginDt = leprosyBeginDt;
	}

	
	public Date getLeprosyEndDt() {
		return leprosyEndDt;
	}

	
	public void setLeprosyEndDt(Date leprosyEndDt) {
		this.leprosyEndDt = leprosyEndDt;
	}

	
	public String getLeprosyEffect() {
		return leprosyEffect;
	}

	
	public void setLeprosyEffect(String leprosyEffect) {
		this.leprosyEffect = leprosyEffect;
	}

	
	public String getCureAddress() {
		return cureAddress;
	}

	
	public void setCureAddress(String cureAddress) {
		this.cureAddress = cureAddress;
	}

	
	public String getLeprosyExplain() {
		return leprosyExplain;
	}

	
	public void setLeprosyExplain(String leprosyExplain) {
		this.leprosyExplain = leprosyExplain;
	}

	
	public Date getNeuritisBeginDt() {
		return neuritisBeginDt;
	}

	
	public void setNeuritisBeginDt(Date neuritisBeginDt) {
		this.neuritisBeginDt = neuritisBeginDt;
	}

	
	public Date getNeuritisEndDt() {
		return neuritisEndDt;
	}

	
	public void setNeuritisEndDt(Date neuritisEndDt) {
		this.neuritisEndDt = neuritisEndDt;
	}

	
	public String getNeuritisEffect() {
		return neuritisEffect;
	}

	
	public void setNeuritisEffect(String neuritisEffect) {
		this.neuritisEffect = neuritisEffect;
	}

	
	public String getNeuritis1Drug() {
		return neuritis1Drug;
	}

	
	public void setNeuritis1Drug(String neuritis1Drug) {
		this.neuritis1Drug = neuritis1Drug;
	}

	
	public String getNeuritis1DrugOth() {
		return neuritis1DrugOth;
	}

	
	public void setNeuritis1DrugOth(String neuritis1DrugOth) {
		this.neuritis1DrugOth = neuritis1DrugOth;
	}

	
	public String getNeuritis2Drug() {
		return neuritis2Drug;
	}

	
	public void setNeuritis2Drug(String neuritis2Drug) {
		this.neuritis2Drug = neuritis2Drug;
	}

	
	public String getNeuritis2DrugOth() {
		return neuritis2DrugOth;
	}

	
	public void setNeuritis2DrugOth(String neuritis2DrugOth) {
		this.neuritis2DrugOth = neuritis2DrugOth;
	}

	
	public String getNeuritis3Drug() {
		return neuritis3Drug;
	}

	
	public void setNeuritis3Drug(String neuritis3Drug) {
		this.neuritis3Drug = neuritis3Drug;
	}

	
	public String getNeuritis3DrugOth() {
		return neuritis3DrugOth;
	}

	
	public void setNeuritis3DrugOth(String neuritis3DrugOth) {
		this.neuritis3DrugOth = neuritis3DrugOth;
	}

	
	public String getNeuritisExplain() {
		return neuritisExplain;
	}

	
	public void setNeuritisExplain(String neuritisExplain) {
		this.neuritisExplain = neuritisExplain;
	}
	
	public Date getReactionBeginDt() {
		return reactionBeginDt;
	}

	
	public void setReactionBeginDt(Date reactionBeginDt) {
		this.reactionBeginDt = reactionBeginDt;
	}

	
	public Date getReactionEndDt() {
		return reactionEndDt;
	}

	
	public void setReactionEndDt(Date reactionEndDt) {
		this.reactionEndDt = reactionEndDt;
	}

	
	public String getReactionEffect() {
		return reactionEffect;
	}

	
	public void setReactionEffect(String reactionEffect) {
		this.reactionEffect = reactionEffect;
	}

	
	public String getReaction1Drug() {
		return reaction1Drug;
	}

	
	public void setReaction1Drug(String reaction1Drug) {
		this.reaction1Drug = reaction1Drug;
	}

	
	public String getReaction1DrugOth() {
		return reaction1DrugOth;
	}

	
	public void setReaction1DrugOth(String reaction1DrugOth) {
		this.reaction1DrugOth = reaction1DrugOth;
	}

	
	public String getReaction2Drug() {
		return reaction2Drug;
	}

	
	public void setReaction2Drug(String reaction2Drug) {
		this.reaction2Drug = reaction2Drug;
	}

	
	public String getReaction2DrugOth() {
		return reaction2DrugOth;
	}

	
	public void setReaction2DrugOth(String reaction2DrugOth) {
		this.reaction2DrugOth = reaction2DrugOth;
	}

	
	public String getReaction3Drug() {
		return reaction3Drug;
	}

	
	public void setReaction3Drug(String reaction3Drug) {
		this.reaction3Drug = reaction3Drug;
	}

	
	public String getReaction3DrugOth() {
		return reaction3DrugOth;
	}

	
	public void setReaction3DrugOth(String reaction3DrugOth) {
		this.reaction3DrugOth = reaction3DrugOth;
	}

	
	public String getReactionExplain() {
		return reactionExplain;
	}

	
	public void setReactionExplain(String reactionExplain) {
		this.reactionExplain = reactionExplain;
	}

	
	public String getProgressNote() {
		return progressNote;
	}

	
	public void setProgressNote(String progressNote) {
		this.progressNote = progressNote;
	}

	
	public String getMinDoctorName() {
		return minDoctorName;
	}

	
	public void setMinDoctorName(String minDoctorName) {
		this.minDoctorName = minDoctorName;
	}

	public Date getFungusDt() {
		return fungusDt;
	}

	public String getFunctionEvaluation() {
		return functionEvaluation;
	}

	public void setFunctionEvaluation(String functionEvaluation) {
		this.functionEvaluation = functionEvaluation;
	}

	public String getCheckFungus() {
		return checkFungus;
	}

	public void setCheckFungus(String checkFungus) {
		this.checkFungus = checkFungus;
	}

	public void setFungusDt(Date fungusDt) {
		this.fungusDt = fungusDt;
	}

	
	public String getFungusUnitProperty() {
		return fungusUnitProperty;
	}

	
	public void setFungusUnitProperty(String fungusUnitProperty) {
		this.fungusUnitProperty = fungusUnitProperty;
	}

	
	public String getFungusUnitPropertyDetail() {
		return fungusUnitPropertyDetail;
	}

	
	public void setFungusUnitPropertyDetail(String fungusUnitPropertyDetail) {
		this.fungusUnitPropertyDetail = fungusUnitPropertyDetail;
	}

	
	public String getOrbitRight() {
		return orbitRight;
	}

	
	public void setOrbitRight(String orbitRight) {
		this.orbitRight = orbitRight;
	}

	
	public String getOrbitLeft() {
		return orbitLeft;
	}

	
	public void setOrbitLeft(String orbitLeft) {
		this.orbitLeft = orbitLeft;
	}

	
	public String getEarRight() {
		return earRight;
	}

	
	public void setEarRight(String earRight) {
		this.earRight = earRight;
	}

	
	public String getEarLeft() {
		return earLeft;
	}

	
	public void setEarLeft(String earLeft) {
		this.earLeft = earLeft;
	}

	
	public String getMandible() {
		return mandible;
	}

	
	public void setMandible(String mandible) {
		this.mandible = mandible;
	}

	
	public String getSkinUp1() {
		return skinUp1;
	}

	
	public void setSkinUp1(String skinUp1) {
		this.skinUp1 = skinUp1;
	}

	
	public String getSkinUp2() {
		return skinUp2;
	}

	
	public void setSkinUp2(String skinUp2) {
		this.skinUp2 = skinUp2;
	}

	
	public String getSkinUp3() {
		return skinUp3;
	}

	
	public void setSkinUp3(String skinUp3) {
		this.skinUp3 = skinUp3;
	}

	
	public String getSkinDown1() {
		return skinDown1;
	}

	
	public void setSkinDown1(String skinDown1) {
		this.skinDown1 = skinDown1;
	}

	
	public String getSkinDown2() {
		return skinDown2;
	}

	
	public void setSkinDown2(String skinDown2) {
		this.skinDown2 = skinDown2;
	}

	
	public String getSkinDown3() {
		return skinDown3;
	}

	
	public void setSkinDown3(String skinDown3) {
		this.skinDown3 = skinDown3;
	}

	
	public String getBI() {
		return BI;
	}

	
	public void setBI(String bI) {
		BI = bI;
	}

	
	public String getMI() {
		return MI;
	}

	
	public void setMI(String mI) {
		MI = mI;
	}

	
	public String getPathology() {
		return pathology;
	}

	
	public void setPathology(String pathology) {
		this.pathology = pathology;
	}

	
	public Date getMaterialsDt() {
		return materialsDt;
	}

	
	public void setMaterialsDt(Date materialsDt) {
		this.materialsDt = materialsDt;
	}

	
	public String getMaterialsPart() {
		return materialsPart;
	}

	
	public void setMaterialsPart(String materialsPart) {
		this.materialsPart = materialsPart;
	}

	
	public String getBacilliCheck() {
		return bacilliCheck;
	}

	
	public void setBacilliCheck(String bacilliCheck) {
		this.bacilliCheck = bacilliCheck;
	}

	
	public String getBacilliUnitPro() {
		return bacilliUnitPro;
	}

	
	public void setBacilliUnitPro(String bacilliUnitPro) {
		this.bacilliUnitPro = bacilliUnitPro;
	}

	
	public String getBacilliUnitProDetail() {
		return bacilliUnitProDetail;
	}

	
	public void setBacilliUnitProDetail(String bacilliUnitProDetail) {
		this.bacilliUnitProDetail = bacilliUnitProDetail;
	}

	
	public String getPathologyExplain() {
		return pathologyExplain;
	}

	
	public void setPathologyExplain(String pathologyExplain) {
		this.pathologyExplain = pathologyExplain;
	}

	
	public String getBloodRoutine() {
		return bloodRoutine;
	}

	
	public void setBloodRoutine(String bloodRoutine) {
		this.bloodRoutine = bloodRoutine;
	}

	
	public String getPissRoutine() {
		return pissRoutine;
	}

	
	public void setPissRoutine(String pissRoutine) {
		this.pissRoutine = pissRoutine;
	}

	
	public String getFecesRoutine() {
		return fecesRoutine;
	}

	
	public void setFecesRoutine(String fecesRoutine) {
		this.fecesRoutine = fecesRoutine;
	}

	
	public String getLiverFunction() {
		return liverFunction;
	}

	
	public void setLiverFunction(String liverFunction) {
		this.liverFunction = liverFunction;
	}

	
	public String getRenalFunction() {
		return renalFunction;
	}

	
	public void setRenalFunction(String renalFunction) {
		this.renalFunction = renalFunction;
	}

	
	public String getOtherCheck() {
		return otherCheck;
	}

	
	public void setOtherCheck(String otherCheck) {
		this.otherCheck = otherCheck;
	}

	
	public String getExceptionDescrip() {
		return exceptionDescrip;
	}

	
	public void setExceptionDescrip(String exceptionDescrip) {
		this.exceptionDescrip = exceptionDescrip;
	}

	
	public String getPrecaution() {
		return precaution;
	}

	
	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	
	public Date getShoeDt() {
		return shoeDt;
	}

	
	public void setShoeDt(Date shoeDt) {
		this.shoeDt = shoeDt;
	}

	
	public String getShoeCount() {
		return shoeCount;
	}

	
	public void setShoeCount(String shoeCount) {
		this.shoeCount = shoeCount;
	}

	
	public String getShoeFrequency() {
		return shoeFrequency;
	}

	
	public void setShoeFrequency(String shoeFrequency) {
		this.shoeFrequency = shoeFrequency;
	}

	
	public String getArtificialLimb() {
		return artificialLimb;
	}

	
	public void setArtificialLimb(String artificialLimb) {
		this.artificialLimb = artificialLimb;
	}

	
	public String getMaintainLimb() {
		return maintainLimb;
	}

	
	public void setMaintainLimb(String maintainLimb) {
		this.maintainLimb = maintainLimb;
	}

	
	public String getOpsRabbitRight() {
		return opsRabbitRight;
	}

	
	public void setOpsRabbitRight(String opsRabbitRight) {
		this.opsRabbitRight = opsRabbitRight;
	}

	
	public String getOpsRabbitLeft() {
		return opsRabbitLeft;
	}

	
	public void setOpsRabbitLeft(String opsRabbitLeft) {
		this.opsRabbitLeft = opsRabbitLeft;
	}

	
	public String getOpsEctropionRight() {
		return opsEctropionRight;
	}

	
	public void setOpsEctropionRight(String opsEctropionRight) {
		this.opsEctropionRight = opsEctropionRight;
	}

	
	public String getOpsEctropionLeft() {
		return opsEctropionLeft;
	}

	
	public void setOpsEctropionLeft(String opsEctropionLeft) {
		this.opsEctropionLeft = opsEctropionLeft;
	}

	
	public String getOpsCataractRight() {
		return opsCataractRight;
	}

	
	public void setOpsCataractRight(String opsCataractRight) {
		this.opsCataractRight = opsCataractRight;
	}

	
	public String getOpsCataractLeft() {
		return opsCataractLeft;
	}

	
	public void setOpsCataractLeft(String opsCataractLeft) {
		this.opsCataractLeft = opsCataractLeft;
	}

	
	public String getOpsParalysisRight() {
		return opsParalysisRight;
	}

	
	public void setOpsParalysisRight(String opsParalysisRight) {
		this.opsParalysisRight = opsParalysisRight;
	}

	
	public String getOpsParalysisLeft() {
		return opsParalysisLeft;
	}

	
	public void setOpsParalysisLeft(String opsParalysisLeft) {
		this.opsParalysisLeft = opsParalysisLeft;
	}

	
	public String getOpsClawhandRight() {
		return opsClawhandRight;
	}

	
	public void setOpsClawhandRight(String opsClawhandRight) {
		this.opsClawhandRight = opsClawhandRight;
	}

	
	public String getOpsClawhandLeft() {
		return opsClawhandLeft;
	}

	
	public void setOpsClawhandLeft(String opsClawhandLeft) {
		this.opsClawhandLeft = opsClawhandLeft;
	}

	public String getOpsApehandRight() {
		return opsApehandRight;
	}

	public void setOpsApehandRight(String opsApehandRight) {
		this.opsApehandRight = opsApehandRight;
	}

	public String getOpsApehandLeft() {
		return opsApehandLeft;
	}

	public void setOpsApehandLeft(String opsApehandLeft) {
		this.opsApehandLeft = opsApehandLeft;
	}

	public String getOpsWristDropRight() {
		return opsWristDropRight;
	}

	
	public void setOpsWristDropRight(String opsWristDropRight) {
		this.opsWristDropRight = opsWristDropRight;
	}

	
	public String getOpsWristDropLeft() {
		return opsWristDropLeft;
	}

	
	public void setOpsWristDropLeft(String opsWristDropLeft) {
		this.opsWristDropLeft = opsWristDropLeft;
	}

	
	public String getOpsPedalRight() {
		return opsPedalRight;
	}

	
	public void setOpsPedalRight(String opsPedalRight) {
		this.opsPedalRight = opsPedalRight;
	}

	
	public String getOpsPedalLeft() {
		return opsPedalLeft;
	}

	
	public void setOpsPedalLeft(String opsPedalLeft) {
		this.opsPedalLeft = opsPedalLeft;
	}

	
	public String getOpsAmputationRight() {
		return opsAmputationRight;
	}

	
	public void setOpsAmputationRight(String opsAmputationRight) {
		this.opsAmputationRight = opsAmputationRight;
	}

	
	public String getOpsAmputationLeft() {
		return opsAmputationLeft;
	}

	
	public void setOpsAmputationLeft(String opsAmputationLeft) {
		this.opsAmputationLeft = opsAmputationLeft;
	}

	
	public String getOpsUlcerRight() {
		return opsUlcerRight;
	}

	
	public void setOpsUlcerRight(String opsUlcerRight) {
		this.opsUlcerRight = opsUlcerRight;
	}

	
	public String getOpsUlcerLeft() {
		return opsUlcerLeft;
	}

	
	public void setOpsUlcerLeft(String opsUlcerLeft) {
		this.opsUlcerLeft = opsUlcerLeft;
	}

	
	public String getSchemeExplain() {
		return schemeExplain;
	}

	
	public void setSchemeExplain(String schemeExplain) {
		this.schemeExplain = schemeExplain;
	}

	
	public Date getUneffectHappenDt() {
		return uneffectHappenDt;
	}

	
	public void setUneffectHappenDt(Date uneffectHappenDt) {
		this.uneffectHappenDt = uneffectHappenDt;
	}

	
	public Date getUneffectDiagDt() {
		return uneffectDiagDt;
	}

	
	public void setUneffectDiagDt(Date uneffectDiagDt) {
		this.uneffectDiagDt = uneffectDiagDt;
	}

	
	public String getUneffectDrug() {
		return uneffectDrug;
	}

	
	public void setUneffectDrug(String uneffectDrug) {
		this.uneffectDrug = uneffectDrug;
	}

	
	public String getUneffectDrugOther() {
		return uneffectDrugOther;
	}

	
	public void setUneffectDrugOther(String uneffectDrugOther) {
		this.uneffectDrugOther = uneffectDrugOther;
	}

	
	public String getUneffectDiag() {
		return uneffectDiag;
	}

	
	public void setUneffectDiag(String uneffectDiag) {
		this.uneffectDiag = uneffectDiag;
	}

	
	public String getCureStep() {
		return cureStep;
	}

	
	public void setCureStep(String cureStep) {
		this.cureStep = cureStep;
	}

	
	public String getCureStepOther() {
		return cureStepOther;
	}

	
	public void setCureStepOther(String cureStepOther) {
		this.cureStepOther = cureStepOther;
	}

	
	public String getCureStepExplain() {
		return cureStepExplain;
	}

	
	public void setCureStepExplain(String cureStepExplain) {
		this.cureStepExplain = cureStepExplain;
	}

	
	public String getCureUnitProperty() {
		return cureUnitProperty;
	}

	
	public void setCureUnitProperty(String cureUnitProperty) {
		this.cureUnitProperty = cureUnitProperty;
	}

	
	public String getUneffectResult() {
		return uneffectResult;
	}

	
	public void setUneffectResult(String uneffectResult) {
		this.uneffectResult = uneffectResult;
	}

	
	public Date getLapseDt() {
		return lapseDt;
	}

	
	public void setLapseDt(Date lapseDt) {
		this.lapseDt = lapseDt;
	}

	
	public String getUneffectExplain() {
		return uneffectExplain;
	}

	
	public void setUneffectExplain(String uneffectExplain) {
		this.uneffectExplain = uneffectExplain;
	}

	
	public Date getDieDt() {
		return dieDt;
	}

	
	public void setDieDt(Date dieDt) {
		this.dieDt = dieDt;
	}

	
	public String getDieReason() {
		return dieReason;
	}

	
	public void setDieReason(String dieReason) {
		this.dieReason = dieReason;
	}

	
	public String getDieReasonOther() {
		return dieReasonOther;
	}

	
	public void setDieReasonOther(String dieReasonOther) {
		this.dieReasonOther = dieReasonOther;
	}

	
	public String getDieExplain() {
		return dieExplain;
	}

	
	public void setDieExplain(String dieExplain) {
		this.dieExplain = dieExplain;
	}

	
	public String getDoctorName() {
		return doctorName;
	}

	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	
	public String getListLcJson() {
		return listLcJson;
	}

	
	public void setListLcJson(String listLcJson) {
		this.listLcJson = listLcJson;
	}

	
	public List<ListLc> getListLcs() {
		return listLcs;
	}

	
	public void setListLcs(List<ListLc> listLcs) {
		this.listLcs = listLcs;
	}

	
	public String getVisitInstStr() {
		return visitInstStr;
	}

	
	public void setVisitInstStr(String visitInstStr) {
		this.visitInstStr = visitInstStr;
	}

	
	public String getVisitByIdStr() {
		return visitByIdStr;
	}

	
	public void setVisitByIdStr(String visitByIdStr) {
		this.visitByIdStr = visitByIdStr;
	}

	public String getListCcJson() {
		return listCcJson;
	}

	public void setListCcJson(String listCcJson) {
		this.listCcJson = listCcJson;
	}

	public List<ListCc> getListCcs() {
		return listCcs;
	}

	public void setListCcs(List<ListCc> listCcs) {
		this.listCcs = listCcs;
	}

    public String getInHospital() {
        return inHospital;
    }

    public void setInHospital(String inHospital) {
        this.inHospital = inHospital;
    }

    public String getTreatmentUnit() {
        return treatmentUnit;
    }

    public void setTreatmentUnit(String treatmentUnit) {
        this.treatmentUnit = treatmentUnit;
    }

    public Date getTreatmentDt() {
        return treatmentDt;
    }

    public void setTreatmentDt(Date treatmentDt) {
        this.treatmentDt = treatmentDt;
    }

    public Date getAttackDt() {
        return attackDt;
    }

    public void setAttackDt(Date attackDt) {
        this.attackDt = attackDt;
    }

    public String getOtherSymptom() {
        return otherSymptom;
    }

    public void setOtherSymptom(String otherSymptom) {
        this.otherSymptom = otherSymptom;
    }

    public String getRash() {
        return rash;
    }

    public void setRash(String rash) {
        this.rash = rash;
    }

    public String getTransferUnit() {
        return transferUnit;
    }

    public void setTransferUnit(String transferUnit) {
        this.transferUnit = transferUnit;
    }

    public String getDiseaseProgress() {
        return diseaseProgress;
    }

    public void setDiseaseProgress(String diseaseProgress) {
        this.diseaseProgress = diseaseProgress;
    }

    public String getListFrJson() {
        return listFrJson;
    }

    public void setListFrJson(String listFrJson) {
        this.listFrJson = listFrJson;
    }

    public List<ListFr> getListFrs() {
        return listFrs;
    }

    public void setListFrs(List<ListFr> listFrs) {
        this.listFrs = listFrs;
    }

	public String getFollowUp() {
		return followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public String getFollowUpUnit() {
		return followUpUnit;
	}

	public void setFollowUpUnit(String followUpUnit) {
		this.followUpUnit = followUpUnit;
	}

	public String getFollowupCaseDie() {
		return followupCaseDie;
	}

	public void setFollowupCaseDie(String followupCaseDie) {
		this.followupCaseDie = followupCaseDie;
	}

	public String getFollowupCaseLostFollowup() {
		return followupCaseLostFollowup;
	}

	public void setFollowupCaseLostFollowup(String followupCaseLostFollowup) {
		this.followupCaseLostFollowup = followupCaseLostFollowup;
	}

	public String getFollowupResidualParalysis() {
		return followupResidualParalysis;
	}

	public void setFollowupResidualParalysis(String followupResidualParalysis) {
		this.followupResidualParalysis = followupResidualParalysis;
	}

	public String getLeftUpperLimb() {
		return leftUpperLimb;
	}

	public void setLeftUpperLimb(String leftUpperLimb) {
		this.leftUpperLimb = leftUpperLimb;
	}

	public String getRightUpperLimb() {
		return rightUpperLimb;
	}

	public void setRightUpperLimb(String rightUpperLimb) {
		this.rightUpperLimb = rightUpperLimb;
	}

	public String getLeftLowerLimb() {
		return leftLowerLimb;
	}

	public void setLeftLowerLimb(String leftLowerLimb) {
		this.leftLowerLimb = leftLowerLimb;
	}

	public String getRightLowerLimb() {
		return rightLowerLimb;
	}

	public void setRightLowerLimb(String rightLowerLimb) {
		this.rightLowerLimb = rightLowerLimb;
	}

	public String getLimbSensoryDisturbance() {
		return limbSensoryDisturbance;
	}

	public void setLimbSensoryDisturbance(String limbSensoryDisturbance) {
		this.limbSensoryDisturbance = limbSensoryDisturbance;
	}

	public String getLimbPart() {
		return limbPart;
	}

	public void setLimbPart(String limbPart) {
		this.limbPart = limbPart;
	}

	public String getIncontinentDuration() {
		return incontinentDuration;
	}

	public void setIncontinentDuration(String incontinentDuration) {
		this.incontinentDuration = incontinentDuration;
	}

	public String getBabinskiReflex() {
		return babinskiReflex;
	}

	public void setBabinskiReflex(String babinskiReflex) {
		this.babinskiReflex = babinskiReflex;
	}

	public String getAnkleClonus() {
		return ankleClonus;
	}

	public void setAnkleClonus(String ankleClonus) {
		this.ankleClonus = ankleClonus;
	}

	public String getMuscleAtrophy() {
		return muscleAtrophy;
	}

	public void setMuscleAtrophy(String muscleAtrophy) {
		this.muscleAtrophy = muscleAtrophy;
	}

	public String getMusclePart() {
		return musclePart;
	}

	public void setMusclePart(String musclePart) {
		this.musclePart = musclePart;
	}

	public String getDtrUnusual() {
		return dtrUnusual;
	}

	public void setDtrUnusual(String dtrUnusual) {
		this.dtrUnusual = dtrUnusual;
	}

	public String getTendoCalcaneus() {
		return tendoCalcaneus;
	}

	public void setTendoCalcaneus(String tendoCalcaneus) {
		this.tendoCalcaneus = tendoCalcaneus;
	}

	public String getKnee() {
		return knee;
	}

	public void setKnee(String knee) {
		this.knee = knee;
	}

	public String getBicepsBrachii() {
		return bicepsBrachii;
	}

	public void setBicepsBrachii(String bicepsBrachii) {
		this.bicepsBrachii = bicepsBrachii;
	}

	public String getLocomotorActivity() {
		return locomotorActivity;
	}

	public void setLocomotorActivity(String locomotorActivity) {
		this.locomotorActivity = locomotorActivity;
	}

	public String getCheckDoctor() {
		return checkDoctor;
	}

	public void setCheckDoctor(String checkDoctor) {
		this.checkDoctor = checkDoctor;
	}

	public String getOutHospitlDiagnosis() {
		return outHospitlDiagnosis;
	}

	public void setOutHospitlDiagnosis(String outHospitlDiagnosis) {
		this.outHospitlDiagnosis = outHospitlDiagnosis;
	}

	public String getDiagnosisOther() {
		return diagnosisOther;
	}

	public void setDiagnosisOther(String diagnosisOther) {
		this.diagnosisOther = diagnosisOther;
	}

	public Date getToCdcDt() {
		return toCdcDt;
	}

	public void setToCdcDt(Date toCdcDt) {
		this.toCdcDt = toCdcDt;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCheckDoctorOther() {
		return checkDoctorOther;
	}

	public void setCheckDoctorOther(String checkDoctorOther) {
		this.checkDoctorOther = checkDoctorOther;
	}

	public String getInfectiousCode() {
		return infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
	}
    
    
}