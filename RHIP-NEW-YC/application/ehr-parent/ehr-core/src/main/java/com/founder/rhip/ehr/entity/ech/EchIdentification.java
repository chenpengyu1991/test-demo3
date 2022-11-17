package com.founder.rhip.ehr.entity.ech;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ECH_IDENTIFICATION")
public class EchIdentification implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长|11|", length = 11, nullable = false)
	private Long id;

//	@Column(name = "EXAM_RECORD_ID", columnDefinition = "NUMBER|体检表ID|11|", length = 11, nullable = false)
//	private Long examRecordId;//字段作废，暂不删除

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = false)
	private Long personId;

	@Column(name = "ECH_NO", columnDefinition = "VARCHAR2|编号|18|", length = 18, nullable = true)
	private String echNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "TCM_QI_QUALITY", columnDefinition = "NUMBER|气虚质|2|", length = 2, nullable = true)
	private Integer tcmQiQuality = 0;

	@Column(name = "QI_QUALITY_GUIDANCE", columnDefinition = "VARCHAR2|气虚质指导|50|", length = 50, nullable = true)
	private String QiQualityGuidance;
	
	@Column(name = "QI_QUALITY_GUIDANCESTR", columnDefinition = "VARCHAR2|气虚质指导其他|100|", length = 100, nullable = true)
	private String QiQualityGuidancestr;
	
	@Column(name = "TCM_YANG_QUALITY", columnDefinition = "NUMBER|阳虚质|2|", length = 2, nullable = true)
	private Integer tcmYangQuality = 0;

	@Column(name = "YANG_QUALITY_GUIDANCE", columnDefinition = "VARCHAR2|阳虚质指导|50|", length = 50, nullable = true)
	private String yangQualityGuidance;
	
	@Column(name = "YANG_QUALITY_GUIDANCESTR", columnDefinition = "VARCHAR2|阳虚质指导其他|100|", length = 100, nullable = true)
	private String yangQualityGuidancestr;
	
	@Column(name = "TCM_YIN_DEFICIENCY", columnDefinition = "NUMBER|阴虚质|2|", length = 2, nullable = true)
	private Integer tcmYinDeficiency = 0;

	@Column(name = "YIN_DEFICIENCY_GUIDANCE", columnDefinition = "VARCHAR2|阴虚质指导|50|", length = 50, nullable = true)
	private String yinDeficiencyGuidance;
	
	@Column(name = "YIN_DEFICIENCY_GUIDANCESTR", columnDefinition = "VARCHAR2|阴虚质指导其他|100|", length = 100, nullable = true)
	private String yinDeficiencyGuidancestr;
	
	@Column(name = "TCM_PHLEGM_WETNESS", columnDefinition = "NUMBER|痰湿质|2|", length = 2, nullable = true)
	private Integer tcmPhlegmWetness = 0;

	@Column(name = "PHLEGM_WETNESS_GUIDANCE", columnDefinition = "VARCHAR2|痰湿质指导|50|", length = 50, nullable = true)
	private String phlegmWetnessGuidance;
	
	@Column(name = "PHLEGM_WETNESS_GUIDANCESTR", columnDefinition = "VARCHAR2|痰湿质指导其他|100|", length = 100, nullable = true)
	private String phlegmWetnessGuidancestr;
	
	@Column(name = "TCM_HEAT_MEDIUM", columnDefinition = "NUMBER|湿热质|2|", length = 2, nullable = true)
	private Integer tcmHeatMedium = 0;

	@Column(name = "HEAT_MEDIUM_GUIDANCE", columnDefinition = "VARCHAR2|湿热质指导|50|", length = 50, nullable = true)
	private String heatMediumGuidance;
	
	@Column(name = "HEAT_MEDIUM_GUIDANCESTR", columnDefinition = "VARCHAR2|湿热质指导其他|100|", length = 100, nullable = true)
	private String heatMediumGuidancestr;
	
	@Column(name = "TCM_BLOOD_QUALITY", columnDefinition = "NUMBER|血瘀质|2|", length = 2, nullable = true)
	private Integer tcmBloodQuality = 0;

	@Column(name = "BLOOD_QUALITY_GUIDANCE", columnDefinition = "VARCHAR2|血瘀质指导|50|", length = 50, nullable = true)
	private String bloodQualityGuidance;
	
	@Column(name = "BLOOD_QUALITY_GUIDANCESTR", columnDefinition = "VARCHAR2|血瘀质指导其他|100|", length = 100, nullable = true)
	private String bloodQualityGuidancestr;
	
	@Column(name = "TCM_QI_STAGNATION", columnDefinition = "NUMBER|气郁质|2|", length = 2, nullable = true)
	private Integer tcmQiStagnation = 0;

	@Column(name = "QI_STAGNATION_GUIDANCE", columnDefinition = "VARCHAR2|气郁质指导|50|", length = 50, nullable = true)
	private String qiStagnationGuidance;
	
	@Column(name = "QI_STAGNATION_GUIDANCESTR", columnDefinition = "VARCHAR2|气郁质指导其他|100|", length = 100, nullable = true)
	private String qiStagnationGuidancestr;
	
	@Column(name = "TCM_SPECIAL_QUALITY", columnDefinition = "NUMBER|特禀质|2|", length = 2, nullable = true)
	private Integer tcmSpecialQuality = 0;

	@Column(name = "SPECIAL_QUALITY_GUIDANCE", columnDefinition = "VARCHAR2|特禀质指导|50|", length = 50, nullable = true)
	private String specialQualityGuidance;
	
	@Column(name = "SPECIAL_QUALITY_GUIDANCESTR", columnDefinition = "VARCHAR2|特禀质指导其他|100|", length = 100, nullable = true)
	private String specialQualityGuidancestr;
	
	@Column(name = "TCM_PEACEFUL_QUALITY", columnDefinition = "NUMBER|平和质|2|", length = 2, nullable = true)
	private Integer tcmPeacefulQuality = 0;

	@Column(name = "PEACEFUL_QUALITY_GUIDANCE", columnDefinition = "VARCHAR2|平和质指导|50|", length = 50, nullable = true)
	private String peacefulQualityGuidance;
	
	@Column(name = "PEACEFUL_QUALITY_GUIDANCESTR", columnDefinition = "VARCHAR2|平和质指导其他|100|", length = 100, nullable = true)
	private String peacefulQualityGuidancestr;
	
	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrg;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|创建人|50|", length = 50, nullable = true)
	private String createUser;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	@Column(name = "UPDATE_ORG", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrg;

	@Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|更新人|50|", length = 50, nullable = true)
	private String updateUser;

//	@Column(name = "EXAMINATION_DATE", columnDefinition = "DATE|体检表日期||", nullable = true)
//	private Date examinationDate;//字段作废，暂不删除

	@Column(name = "DISTINGUISH_TYPE", columnDefinition = "VARCHAR2|辨识类型||", length = 5 , nullable = true)
	private String distinguishType;

	@Column(name = "HYIN_EMPTY_YANG_HYPER", columnDefinition = "VARCHAR2|高血压阴虚阳亢证||", length = 1, nullable = true)
	private String hyinEmptyYangHyper;

	@Column(name = "HQI_BLOOD_EMPTY", columnDefinition = "VARCHAR2|高血压气血两虚证||", length = 1, nullable = true)
	private String hqiBloodEmpty;

	@Column(name = "HPHLEGM_BLOOD_STASIS", columnDefinition = "VARCHAR2|高血压痰瘀互结证||", length = 1, nullable = true)
	private String hphlegmBloodStasis;

	@Column(name = "HSPERM_DEFICIENCY", columnDefinition = "VARCHAR2|高血压肾精不足证||", length = 1, nullable = true)
	private String hspermDeficiency;

	@Column(name = "HYANG_EMPTY", columnDefinition = "VARCHAR2|高血压肾阳亏虚证||", length = 1, nullable = true)
	private String hyangEmpty;

	@Column(name = "HAN_OFFSET", columnDefinition = "VARCHAR2|高血压充任失调证||", length = 1, nullable = true)
	private String hanOffset;

	@Column(name = "DYIN_EMPTY_HOT", columnDefinition = "VARCHAR2|糖尿病阴虚燥热证||", length = 1, nullable = true)
	private String dyinEmptyHot;

	@Column(name = "DQI_YIN_EMPTY", columnDefinition = "VARCHAR2|糖尿病气阴两虚证||", length = 1, nullable = true)
	private String dqiYinEmpty;

	@Column(name = "DYIN_YANG_EMPTY", columnDefinition = "VARCHAR2|糖尿病阴阳两虚证||", length = 1, nullable = true)
	private String dyinYangEmpty;
	
	@Column(name = "TCM_CONCLUSION", columnDefinition = "VARCHAR2|体质辨识结论||", length = 100, nullable = true)
	private String tcmConclusion;
	
	@Transient
	private List<ElderlyPhyExamination>  exams;
	@Transient
	private List<EchIdentificationOption>  identificationOptions;
	
	/**
	 * 气虚质
	 */
	@Column(name = "qi_flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String qiFlag;
	
	/**
	 * 阳虚质
	 */
	@Column(name = "yang_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String yangFlag;
	
	/**
	 * 阴虚质
	 */
	@Column(name = "yin_Deficiency_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String yinDeficiencyFlag;
	
	/**
	 * 痰湿质
	 */
	@Column(name = "phle_gmWetness_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String phlegmWetnessFlag;
	
	/**
	 * 湿热质
	 */
	@Column(name = "heat_Medium_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String heatMediumFlag;
	
	/**
	 * 血瘀质
	 */
	@Column(name = "blood_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String bloodFlag;
	
	/**
	 * 气郁质
	 */
	@Column(name = "qi_Stagnation_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String qiStagnationFlag;
	
	/**
	 * 特禀质
	 */
	@Column(name = "special_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true)
	private String specialFlag;
	
	/**
	 * 平和质
	 */
	@Column(name = "peaceful_Flag", columnDefinition = "VARCHAR2|气虚质标识||", length = 1, nullable = true) 
	private String peacefulFlag;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEchNo() {
		return this.echNo;
	}

	public void setEchNo(String echNo) {
		this.echNo = echNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getTcmQiQuality() {
		return this.tcmQiQuality;
	}

	public void setTcmQiQuality(Integer tcmQiQuality) {
		this.tcmQiQuality = tcmQiQuality;
	}

	public Integer getTcmYangQuality() {
		return this.tcmYangQuality;
	}

	public void setTcmYangQuality(Integer tcmYangQuality) {
		this.tcmYangQuality = tcmYangQuality;
	}

	public Integer getTcmYinDeficiency() {
		return this.tcmYinDeficiency;
	}

	public void setTcmYinDeficiency(Integer tcmYinDeficiency) {
		this.tcmYinDeficiency = tcmYinDeficiency;
	}

	public Integer getTcmPhlegmWetness() {
		return this.tcmPhlegmWetness;
	}

	public void setTcmPhlegmWetness(Integer tcmPhlegmWetness) {
		this.tcmPhlegmWetness = tcmPhlegmWetness;
	}

	public Integer getTcmHeatMedium() {
		return this.tcmHeatMedium;
	}

	public void setTcmHeatMedium(Integer tcmHeatMedium) {
		this.tcmHeatMedium = tcmHeatMedium;
	}

	public Integer getTcmBloodQuality() {
		return this.tcmBloodQuality;
	}

	public void setTcmBloodQuality(Integer tcmBloodQuality) {
		this.tcmBloodQuality = tcmBloodQuality;
	}

	public Integer getTcmQiStagnation() {
		return this.tcmQiStagnation;
	}

	public void setTcmQiStagnation(Integer tcmQiStagnation) {
		this.tcmQiStagnation = tcmQiStagnation;
	}

	public Integer getTcmSpecialQuality() {
		return this.tcmSpecialQuality;
	}

	public void setTcmSpecialQuality(Integer tcmSpecialQuality) {
		this.tcmSpecialQuality = tcmSpecialQuality;
	}

	public Integer getTcmPeacefulQuality() {
		return this.tcmPeacefulQuality;
	}

	public void setTcmPeacefulQuality(Integer tcmPeacefulQuality) {
		this.tcmPeacefulQuality = tcmPeacefulQuality;
	}

	public String getQiQualityGuidance() {
		return QiQualityGuidance;
	}

	public void setQiQualityGuidance(String qiQualityGuidance) {
		QiQualityGuidance = qiQualityGuidance;
	}

	public String getQiQualityGuidancestr() {
		return QiQualityGuidancestr;
	}

	public void setQiQualityGuidancestr(String qiQualityGuidancestr) {
		QiQualityGuidancestr = qiQualityGuidancestr;
	}

	public String getYangQualityGuidance() {
		return yangQualityGuidance;
	}

	public void setYangQualityGuidance(String yangQualityGuidance) {
		this.yangQualityGuidance = yangQualityGuidance;
	}

	public String getYangQualityGuidancestr() {
		return yangQualityGuidancestr;
	}

	public void setYangQualityGuidancestr(String yangQualityGuidancestr) {
		this.yangQualityGuidancestr = yangQualityGuidancestr;
	}

	public String getYinDeficiencyGuidance() {
		return yinDeficiencyGuidance;
	}

	public void setYinDeficiencyGuidance(String yinDeficiencyGuidance) {
		this.yinDeficiencyGuidance = yinDeficiencyGuidance;
	}

	public String getYinDeficiencyGuidancestr() {
		return yinDeficiencyGuidancestr;
	}

	public void setYinDeficiencyGuidancestr(String yinDeficiencyGuidancestr) {
		this.yinDeficiencyGuidancestr = yinDeficiencyGuidancestr;
	}

	public String getPhlegmWetnessGuidance() {
		return phlegmWetnessGuidance;
	}

	public void setPhlegmWetnessGuidance(String phlegmWetnessGuidance) {
		this.phlegmWetnessGuidance = phlegmWetnessGuidance;
	}

	public String getPhlegmWetnessGuidancestr() {
		return phlegmWetnessGuidancestr;
	}

	public void setPhlegmWetnessGuidancestr(String phlegmWetnessGuidancestr) {
		this.phlegmWetnessGuidancestr = phlegmWetnessGuidancestr;
	}

	public String getHeatMediumGuidance() {
		return heatMediumGuidance;
	}

	public void setHeatMediumGuidance(String heatMediumGuidance) {
		this.heatMediumGuidance = heatMediumGuidance;
	}

	public String getHeatMediumGuidancestr() {
		return heatMediumGuidancestr;
	}

	public void setHeatMediumGuidancestr(String heatMediumGuidancestr) {
		this.heatMediumGuidancestr = heatMediumGuidancestr;
	}

	public String getBloodQualityGuidance() {
		return bloodQualityGuidance;
	}

	public void setBloodQualityGuidance(String bloodQualityGuidance) {
		this.bloodQualityGuidance = bloodQualityGuidance;
	}

	public String getBloodQualityGuidancestr() {
		return bloodQualityGuidancestr;
	}

	public void setBloodQualityGuidancestr(String bloodQualityGuidancestr) {
		this.bloodQualityGuidancestr = bloodQualityGuidancestr;
	}

	public String getQiStagnationGuidance() {
		return qiStagnationGuidance;
	}

	public void setQiStagnationGuidance(String qiStagnationGuidance) {
		this.qiStagnationGuidance = qiStagnationGuidance;
	}

	public String getQiStagnationGuidancestr() {
		return qiStagnationGuidancestr;
	}

	public void setQiStagnationGuidancestr(String qiStagnationGuidancestr) {
		this.qiStagnationGuidancestr = qiStagnationGuidancestr;
	}

	public String getSpecialQualityGuidance() {
		return specialQualityGuidance;
	}

	public void setSpecialQualityGuidance(String specialQualityGuidance) {
		this.specialQualityGuidance = specialQualityGuidance;
	}

	public String getSpecialQualityGuidancestr() {
		return specialQualityGuidancestr;
	}

	public void setSpecialQualityGuidancestr(String specialQualityGuidancestr) {
		this.specialQualityGuidancestr = specialQualityGuidancestr;
	}

	public String getPeacefulQualityGuidance() {
		return peacefulQualityGuidance;
	}

	public void setPeacefulQualityGuidance(String peacefulQualityGuidance) {
		this.peacefulQualityGuidance = peacefulQualityGuidance;
	}

	public String getPeacefulQualityGuidancestr() {
		return peacefulQualityGuidancestr;
	}

	public void setPeacefulQualityGuidancestr(String peacefulQualityGuidancestr) {
		this.peacefulQualityGuidancestr = peacefulQualityGuidancestr;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getDistinguishType() {
		return distinguishType;
	}

	public void setDistinguishType(String distinguishType) {
		this.distinguishType = distinguishType;
	}

	public String getHyinEmptyYangHyper() {
		return hyinEmptyYangHyper;
	}

	public void setHyinEmptyYangHyper(String hyinEmptyYangHyper) {
		this.hyinEmptyYangHyper = hyinEmptyYangHyper;
	}

	public String getHqiBloodEmpty() {
		return hqiBloodEmpty;
	}

	public void setHqiBloodEmpty(String hqiBloodEmpty) {
		this.hqiBloodEmpty = hqiBloodEmpty;
	}

	public String getHphlegmBloodStasis() {
		return hphlegmBloodStasis;
	}

	public void setHphlegmBloodStasis(String hphlegmBloodStasis) {
		this.hphlegmBloodStasis = hphlegmBloodStasis;
	}

	public String getHspermDeficiency() {
		return hspermDeficiency;
	}

	public void setHspermDeficiency(String hspermDeficiency) {
		this.hspermDeficiency = hspermDeficiency;
	}

	public String getHyangEmpty() {
		return hyangEmpty;
	}

	public void setHyangEmpty(String hyangEmpty) {
		this.hyangEmpty = hyangEmpty;
	}

	public String getHanOffset() {
		return hanOffset;
	}

	public void setHanOffset(String hanOffset) {
		this.hanOffset = hanOffset;
	}

	public String getDyinEmptyHot() {
		return dyinEmptyHot;
	}

	public void setDyinEmptyHot(String dyinEmptyHot) {
		this.dyinEmptyHot = dyinEmptyHot;
	}

	public String getDqiYinEmpty() {
		return dqiYinEmpty;
	}

	public void setDqiYinEmpty(String dqiYinEmpty) {
		this.dqiYinEmpty = dqiYinEmpty;
	}

	public String getDyinYangEmpty() {
		return dyinYangEmpty;
	}

	public void setDyinYangEmpty(String dyinYangEmpty) {
		this.dyinYangEmpty = dyinYangEmpty;
	}

	public List<EchIdentificationOption> getIdentificationOptions() {
		return identificationOptions;
	}

	public void setIdentificationOptions(List<EchIdentificationOption> identificationOptions) {
		this.identificationOptions = identificationOptions;
	}
	/**
	 * 计算体质
	 *
	 * @author Ye jianfei
	 */
	public void calTcm(){
		if(ObjectUtil.isNotEmpty(this.identificationOptions)){
			for(EchIdentificationOption option:this.identificationOptions){
				Integer optionNo = option.getOptionNo();
				Integer score = option.getScore();
				switch(optionNo){
					case 1:
						tcmPeacefulQuality += score;//平和质
						break;
					case 2:
						tcmPeacefulQuality += (5-score)+1;//平和质,反向计分
						tcmQiQuality += score;//气虚质
						break;
					case 3:
					case 14:
						tcmQiQuality += score;//气虚质
						break;
					case 4:
						tcmPeacefulQuality += (5-score)+1;//平和质,反向计分
						tcmQiQuality += score;//气虚质
						break;
					case 5:
						tcmPeacefulQuality += (5-score)+1;//平和质,反向计分
						tcmQiStagnation +=score;//气郁质
						break;
					case 6:
					case 7:	
					case 8:					
						tcmQiStagnation +=score;//气郁质
						break;
					case 9:
					case 16:
					case 28:	
					case 32:					
						tcmPhlegmWetness +=score;//痰湿质
						break;
					case 10:
					case 21:
					case 26:
					case 31:					
						tcmYinDeficiency +=score;//阴虚质
						break;
					case 11:
					case 12:
					case 29:					
						tcmYangQuality +=score;//阳虚质
						break;
					case 13:
						tcmYangQuality +=score;//阳虚质
						tcmPeacefulQuality += (5-score)+1;//平和质,反向计分
						break;
					case 15:
					case 17:
					case 18:
					case 20:					
						tcmSpecialQuality += score;//特禀质
						break;
					case 19:
					case 22:
					case 24:	
					case 33:					
						tcmBloodQuality += score;//血瘀质
						break;
					case 23:
					case 25:
					case 27:					
					case 30:					
						tcmHeatMedium += score;//湿热质
						break;
				}
			}
			calTcmFlag();
		}
	}

	public String getQiFlag() {
		return this.qiFlag;
	}

	public void setQiFlag(String qiFlag) {
		this.qiFlag = qiFlag;
	}

	public String getYangFlag() {
		return this.yangFlag;
	}

	public void setYangFlag(String yangFlag) {
		this.yangFlag = yangFlag;
	}

	public String getYinDeficiencyFlag() {
		return this.yinDeficiencyFlag;
	}

	public void setYinDeficiencyFlag(String yinDeficiencyFlag) {
		this.yinDeficiencyFlag = yinDeficiencyFlag;
	}

	public String getPhlegmWetnessFlag() {
		return this.phlegmWetnessFlag;
	}

	public void setPhlegmWetnessFlag(String phlegmWetnessFlag) {
		this.phlegmWetnessFlag = phlegmWetnessFlag;
	}

	public String getHeatMediumFlag() {
		return this.heatMediumFlag;
	}

	public void setHeatMediumFlag(String heatMediumFlag) {
		this.heatMediumFlag = heatMediumFlag;
	}

	public String getBloodFlag() {
		return this.bloodFlag;
	}

	public void setBloodFlag(String bloodFlag) {
		this.bloodFlag = bloodFlag;
	}

	public String getQiStagnationFlag() {
		return this.qiStagnationFlag;
	}

	public void setQiStagnationFlag(String qiStagnationFlag) {
		this.qiStagnationFlag = qiStagnationFlag;
	}

	public String getSpecialFlag() {
		return this.specialFlag;
	}

	public void setSpecialFlag(String specialFlag) {
		this.specialFlag = specialFlag;
	}

	public String getPeacefulFlag() {
		return this.peacefulFlag;
	}
	public void setPeacefulFlag(String peacefulFlag) {
		this.peacefulFlag = peacefulFlag;
	}

	public String getTcmConclusion() {
		return tcmConclusion;
	}

	public void setTcmConclusion(String tcmConclusion) {
		this.tcmConclusion = tcmConclusion;
	}

	public List<ElderlyPhyExamination> getExams() {
		return exams;
	}

	public void setExams(List<ElderlyPhyExamination> exams) {
		this.exams = exams;
	}

	private String getPeacefulQualityFlag() {
    	String result = "0";//否
    	if(this.getTcmPeacefulQuality()>=17
    			&& this.getTcmQiQuality()<=8
    			&& this.getTcmYangQuality()<=8
    			&& this.getTcmYinDeficiency()<=8
    			&& this.getTcmPhlegmWetness()<=8
    			&& this.getTcmHeatMedium()<=8
    			&& this.getTcmBloodQuality()<=8
    			&& this.getTcmQiStagnation()<=8
    			&& this.getTcmSpecialQuality()<=8){
    		result = "1";//是
    	}else if(this.getTcmPeacefulQuality()>=17
    			&& this.getTcmQiQuality()<10
    			&& this.getTcmYangQuality()<10
    			&& this.getTcmYinDeficiency()<10
    			&& this.getTcmPhlegmWetness()<10
    			&& this.getTcmHeatMedium()<10
    			&& this.getTcmBloodQuality()<10
    			&& this.getTcmQiStagnation()<10
    			&& this.getTcmSpecialQuality()<10){
    		result = "2";//基本是
    	}

    	return result;		
	}
	
    /**
     * 计算 气虚质、阳虚质、阴虚质、痰湿质、湿热质、血瘀质、气郁质、特禀质 状态
     * 1：是 2：倾向是
     *
     * @param quality
     * @return
     * @author Ye jianfei
     */
    private String getQualityFlag(Integer quality){
    	String result = "0";
    	if(quality >=11){
    		result = "1";
    	}else if(quality == 9 || quality == 10){
    		result = "3";
    	}
    	return result;
    }	
    
    public void calTcmFlag(){
		this.qiFlag = getQualityFlag(this.getTcmQiQuality());
		this.yangFlag = getQualityFlag(this.getTcmYangQuality());
		this.yinDeficiencyFlag = getQualityFlag(this.getTcmYinDeficiency());
		this.phlegmWetnessFlag = getQualityFlag(this.getTcmPhlegmWetness());
		this.heatMediumFlag = getQualityFlag(this.getTcmHeatMedium());
		this.bloodFlag = getQualityFlag(this.getTcmBloodQuality());
		this.qiStagnationFlag = getQualityFlag(this.getTcmQiStagnation());
		this.specialFlag = getQualityFlag(this.getTcmSpecialQuality());	
		this.peacefulFlag = getPeacefulQualityFlag();    	
    }
}