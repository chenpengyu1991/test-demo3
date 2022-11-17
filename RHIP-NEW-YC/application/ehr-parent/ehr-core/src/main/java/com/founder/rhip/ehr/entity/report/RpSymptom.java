package com.founder.rhip.ehr.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RP_SYMPTOM")
public class RpSymptom implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）|100|", length = 100, nullable = true)
	private String rpName;

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇code|50|", length = 50, nullable = true)
	private String gbCode;

	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心code|50|", length = 50, nullable = true)
	private String centerCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构code|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型|5|", length = 5, nullable = true)
	private String organType;

	@Column(name = "RP_DATE", columnDefinition = "DATE|统计日期||", nullable = true)
	private Date rpDate;

	@Column(name = "FEVER_NUM", columnDefinition = "NUMBER|发热|10|", length = 10, nullable = true)
	private Long feverNum = 0l;

	@Column(name = "SYSTEMIC_PAIN_NUM", columnDefinition = "NUMBER|全身性疼痛|10|", length = 10, nullable = true)
	private Long systemicPainNum = 0l;

	@Column(name = "DISCOMFORT_FATIGUE_NUM", columnDefinition = "NUMBER|不适和疲劳|10|", length = 10, nullable = true)
	private Long discomfortFatigueNum = 0l;

	@Column(name = "ENLARGED_LYMPH_NUM", columnDefinition = "NUMBER|淋巴结增大|10|", length = 10, nullable = true)
	private Long enlargedLymphNum = 0l;

	@Column(name = "MOUTH_BREATHING_NUM", columnDefinition = "NUMBER|口呼吸|10|", length = 10, nullable = true)
	private Long mouthBreathingNum = 0l;

	@Column(name = "SNEEZE_NUM", columnDefinition = "NUMBER|喷嚏|10|", length = 10, nullable = true)
	private Long sneezeNum = 0l;

	@Column(name = "SORE_THROAT_NUM", columnDefinition = "NUMBER|咽痛|10|", length = 10, nullable = true)
	private Long soreThroatNum = 0l;

	@Column(name = "COUGH_NUM", columnDefinition = "NUMBER|咳嗽|10|", length = 10, nullable = true)
	private Long coughNum = 0l;

	@Column(name = "ABNORMAL_SPUTUM_NUM", columnDefinition = "NUMBER|痰异常|10|", length = 10, nullable = true)
	private Long abnormalSputumNum = 0l;

	@Column(name = "BREATHING_CHEST_PAIN_NUM", columnDefinition = "NUMBER|呼吸时胸痛|10|", length = 10, nullable = true)
	private Long breathingChestPainNum = 0l;

	@Column(name = "DYSPNEA_NUM", columnDefinition = "NUMBER|呼吸困难|10|", length = 10, nullable = true)
	private Long dyspneaNum = 0l;

	@Column(name = "NAUSEA_VOMITING_NUM", columnDefinition = "NUMBER|恶心和呕吐|10|", length = 10, nullable = true)
	private Long nauseaVomitingNum = 0l;

	@Column(name = "ABDOMINAL_PAIN_NUM", columnDefinition = "NUMBER|腹痛|10|", length = 10, nullable = true)
	private Long abdominalPainNum = 0l;

	@Column(name = "DIARRHEA_NUM", columnDefinition = "NUMBER|腹泻|10|", length = 10, nullable = true)
	private Long diarrheaNum = 0l;

	@Column(name = "CONSTIPATION_NUM", columnDefinition = "NUMBER|便稀、便秘|10|", length = 10, nullable = true)
	private Long constipationNum = 0l;

	@Column(name = "FLATULENCE_NUM", columnDefinition = "NUMBER|胃气胀|10|", length = 10, nullable = true)
	private Long flatulenceNum = 0l;

	@Column(name = "APPETITE_LACK_NUM", columnDefinition = "NUMBER|食欲缺乏|10|", length = 10, nullable = true)
	private Long appetiteLackNum = 0l;

	@Column(name = "RASH_MACULA_NUM", columnDefinition = "NUMBER|皮疹、斑疹|10|", length = 10, nullable = true)
	private Long rashMaculaNum = 0l;

	@Column(name = "POPULAR_URTICARIA_NUM", columnDefinition = "NUMBER|丘疹性荨麻疹|10|", length = 10, nullable = true)
	private Long papularUrticariaNum = 0l;

	@Column(name = "URTICARIAL_NUM", columnDefinition = "NUMBER|荨麻疹|10|", length = 10, nullable = true)
	private Long urticariaNum = 0l;

	@Column(name = "ERYTHEMA_MULTIFORME_NUM", columnDefinition = "NUMBER|多形性红斑|10|", length = 10, nullable = true)
	private Long erythemaMultiformeNum = 0l;

	@Column(name = "SPONTANEOUS_STASIS_NUM", columnDefinition = "NUMBER|自发性瘀班|10|", length = 10, nullable = true)
	private Long spontaneousStasisNum = 0l;

	@Column(name = "PURPURA_NUM", columnDefinition = "NUMBER|紫癜|10|", length = 10, nullable = true)
	private Long purpuraNum = 0l;

	@Column(name = "WATER_HERPES_NUM", columnDefinition = "NUMBER|水疱疹|10|", length = 10, nullable = true)
	private Long waterHerpesNum = 0l;

	@Column(name = "HEMATEMESIS_NUM", columnDefinition = "NUMBER|呕血|10|", length = 10, nullable = true)
	private Long hematemesisNum = 0l;

	@Column(name = "NASAL_BLEEDING_NUM", columnDefinition = "NUMBER|鼻出血|10|", length = 10, nullable = true)
	private Long nasalBleedingNum = 0l;

	@Column(name = "HEMOPTYSIS_NUM", columnDefinition = "NUMBER|咯血|10|", length = 10, nullable = true)
	private Long hemoptysisNum = 0l;

	@Column(name = "HEMATURIA_NUM", columnDefinition = "NUMBER|血尿|10|", length = 10, nullable = true)
	private Long hematuriaNum = 0l;

	@Column(name = "STOMACH_BLOOD_NUM", columnDefinition = "NUMBER|胃肠出血|10|", length = 10, nullable = true)
	private Long stomachBloodNum = 0l;

	@Column(name = "FECAL_OCCULT_BLOOD_NUM", columnDefinition = "NUMBER|大便潜血|10|", length = 10, nullable = true)
	private Long fecalOccultBloodNum = 0l;

	@Column(name = "VAGINAL_BLEEDING_NUM", columnDefinition = "NUMBER|阴道出血|10|", length = 10, nullable = true)
	private Long vaginalBleedingNum = 0l;

	@Column(name = "HEADACHE_NUM", columnDefinition = "NUMBER|头痛|10|", length = 10, nullable = true)
	private Long headacheNum = 0l;

	@Column(name = "DIZZINESS_VERTIGO_NUM", columnDefinition = "NUMBER|头晕和眩晕|10|", length = 10, nullable = true)
	private Long dizzinessVertigoNum = 0l;

	@Column(name = "COMA_NUM", columnDefinition = "NUMBER|昏迷|10|", length = 10, nullable = true)
	private Long comaNum = 0l;

	@Column(name = "FEBRILE_CONVULSION_NUM", columnDefinition = "NUMBER|发热性惊厥|10|", length = 10, nullable = true)
	private Long febrileConvulsionNum = 0l;

	@Column(name = "TREMOR_NUM", columnDefinition = "NUMBER|震颤|10|", length = 10, nullable = true)
	private Long tremorNum = 0l;

	@Column(name = "TETANY_NUM", columnDefinition = "NUMBER|手足搐搦|10|", length = 10, nullable = true)
	private Long tetanyNum = 0l;

	@Column(name = "ATAXIA_NUM", columnDefinition = "NUMBER|共济失调|10|", length = 10, nullable = true)
	private Long ataxiaNum = 0l;

	@Column(name = "ANOMALOUS_REFLECTION_NUM", columnDefinition = "NUMBER|异常反射|10|", length = 10, nullable = true)
	private Long anomalousReflectionNum = 0l;

	@Column(name = "CRAMPS_SPASMS_NUM", columnDefinition = "NUMBER|痛性痉挛和痉挛|10|", length = 10, nullable = true)
	private Long crampsSpasmsNum = 0l;

	@Column(name = "BLURRED_VISION_NUM", columnDefinition = "NUMBER|视物模糊|10|", length = 10, nullable = true)
	private Long blurredVisionNum = 0l;

	@Column(name = "DIPLOPIA_NUM", columnDefinition = "NUMBER|复视|10|", length = 10, nullable = true)
	private Long diplopiaNum = 0l;

	@Column(name = "DYSPHONIA_NUM", columnDefinition = "NUMBER|发声困难|10|", length = 10, nullable = true)
	private Long dysphoniaNum = 0l;

	@Column(name = "SPEECH_DISORDERS_NUM", columnDefinition = "NUMBER|言语障碍|10|", length = 10, nullable = true)
	private Long speechDisordersNum = 0l;

	@Column(name = "DYSPHAGIA_NUM", columnDefinition = "NUMBER|吞咽困难|10|", length = 10, nullable = true)
	private Long dysphagiaNum = 0l;

	@Column(name = "DRY_MOUTH_NUM", columnDefinition = "NUMBER|口干|10|", length = 10, nullable = true)
	private Long dryMouthNum = 0l;

	@Column(name = "MYASTHENIA_GRAVIS_NUM", columnDefinition = "NUMBER|肌无力|10|", length = 10, nullable = true)
	private Long myastheniaGravisNum = 0l;

	@Column(name = "NO_URINE_OLIGURIA_NUM", columnDefinition = "NUMBER|无尿、少尿|10|", length = 10, nullable = true)
	private Long noUrineOliguriaNum = 0l;

	@Column(name = "HYPERHIDROSIS_NUM", columnDefinition = "NUMBER|多汗|10|", length = 10, nullable = true)
	private Long hyperhidrosisNum = 0l;

	@Column(name = "SKIN_REDNESS_NUM", columnDefinition = "NUMBER|皮肤发红|10|", length = 10, nullable = true)
	private Long skinRednessNum = 0l;

	@Column(name = "WAIST_PAIN_NUM", columnDefinition = "NUMBER|腰痛|10|", length = 10, nullable = true)
	private Long waistPainNum = 0l;

	@Column(name = "EYE_PAIN_NUM", columnDefinition = "NUMBER|眼痛|10|", length = 10, nullable = true)
	private Long eyePainNum = 0l;

	@Column(name = "CONJUNCTIVA_BLOOD_NUM", columnDefinition = "NUMBER|结膜出血|10|", length = 10, nullable = true)
	private Long conjunctivaBloodNum = 0l;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return this.rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return this.organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public Date getRpDate() {
		return this.rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public Long getFeverNum() {
		return feverNum;
	}

	public void setFeverNum(Long feverNum) {
		this.feverNum = feverNum;
	}

	public Long getSystemicPainNum() {
		return systemicPainNum;
	}

	public void setSystemicPainNum(Long systemicPainNum) {
		this.systemicPainNum = systemicPainNum;
	}

	public Long getDiscomfortFatigueNum() {
		return discomfortFatigueNum;
	}

	public void setDiscomfortFatigueNum(Long discomfortFatigueNum) {
		this.discomfortFatigueNum = discomfortFatigueNum;
	}

	public Long getEnlargedLymphNum() {
		return enlargedLymphNum;
	}

	public void setEnlargedLymphNum(Long enlargedLymphNum) {
		this.enlargedLymphNum = enlargedLymphNum;
	}

	public Long getMouthBreathingNum() {
		return mouthBreathingNum;
	}

	public void setMouthBreathingNum(Long mouthBreathingNum) {
		this.mouthBreathingNum = mouthBreathingNum;
	}

	public Long getSneezeNum() {
		return sneezeNum;
	}

	public void setSneezeNum(Long sneezeNum) {
		this.sneezeNum = sneezeNum;
	}

	public Long getSoreThroatNum() {
		return soreThroatNum;
	}

	public void setSoreThroatNum(Long soreThroatNum) {
		this.soreThroatNum = soreThroatNum;
	}

	public Long getCoughNum() {
		return coughNum;
	}

	public void setCoughNum(Long coughNum) {
		this.coughNum = coughNum;
	}

	public Long getAbnormalSputumNum() {
		return abnormalSputumNum;
	}

	public void setAbnormalSputumNum(Long abnormalSputumNum) {
		this.abnormalSputumNum = abnormalSputumNum;
	}

	public Long getBreathingChestPainNum() {
		return breathingChestPainNum;
	}

	public void setBreathingChestPainNum(Long breathingChestPainNum) {
		this.breathingChestPainNum = breathingChestPainNum;
	}

	public Long getDyspneaNum() {
		return dyspneaNum;
	}

	public void setDyspneaNum(Long dyspneaNum) {
		this.dyspneaNum = dyspneaNum;
	}

	public Long getNauseaVomitingNum() {
		return nauseaVomitingNum;
	}

	public void setNauseaVomitingNum(Long nauseaVomitingNum) {
		this.nauseaVomitingNum = nauseaVomitingNum;
	}

	public Long getAbdominalPainNum() {
		return abdominalPainNum;
	}

	public void setAbdominalPainNum(Long abdominalPainNum) {
		this.abdominalPainNum = abdominalPainNum;
	}

	public Long getDiarrheaNum() {
		return diarrheaNum;
	}

	public void setDiarrheaNum(Long diarrheaNum) {
		this.diarrheaNum = diarrheaNum;
	}

	public Long getConstipationNum() {
		return constipationNum;
	}

	public void setConstipationNum(Long constipationNum) {
		this.constipationNum = constipationNum;
	}

	public Long getFlatulenceNum() {
		return flatulenceNum;
	}

	public void setFlatulenceNum(Long flatulenceNum) {
		this.flatulenceNum = flatulenceNum;
	}

	public Long getAppetiteLackNum() {
		return appetiteLackNum;
	}

	public void setAppetiteLackNum(Long appetiteLackNum) {
		this.appetiteLackNum = appetiteLackNum;
	}

	public Long getRashMaculaNum() {
		return rashMaculaNum;
	}

	public void setRashMaculaNum(Long rashMaculaNum) {
		this.rashMaculaNum = rashMaculaNum;
	}

	public Long getPapularUrticariaNum() {
		return papularUrticariaNum;
	}

	public void setPapularUrticariaNum(Long papularUrticariaNum) {
		this.papularUrticariaNum = papularUrticariaNum;
	}

	public Long getUrticariaNum() {
		return urticariaNum;
	}

	public void setUrticariaNum(Long urticariaNum) {
		this.urticariaNum = urticariaNum;
	}

	public Long getErythemaMultiformeNum() {
		return erythemaMultiformeNum;
	}

	public void setErythemaMultiformeNum(Long erythemaMultiformeNum) {
		this.erythemaMultiformeNum = erythemaMultiformeNum;
	}

	public Long getSpontaneousStasisNum() {
		return spontaneousStasisNum;
	}

	public void setSpontaneousStasisNum(Long spontaneousStasisNum) {
		this.spontaneousStasisNum = spontaneousStasisNum;
	}

	public Long getPurpuraNum() {
		return purpuraNum;
	}

	public void setPurpuraNum(Long purpuraNum) {
		this.purpuraNum = purpuraNum;
	}

	public Long getWaterHerpesNum() {
		return waterHerpesNum;
	}

	public void setWaterHerpesNum(Long waterHerpesNum) {
		this.waterHerpesNum = waterHerpesNum;
	}

	public Long getHematemesisNum() {
		return hematemesisNum;
	}

	public void setHematemesisNum(Long hematemesisNum) {
		this.hematemesisNum = hematemesisNum;
	}

	public Long getNasalBleedingNum() {
		return nasalBleedingNum;
	}

	public void setNasalBleedingNum(Long nasalBleedingNum) {
		this.nasalBleedingNum = nasalBleedingNum;
	}

	public Long getHemoptysisNum() {
		return hemoptysisNum;
	}

	public void setHemoptysisNum(Long hemoptysisNum) {
		this.hemoptysisNum = hemoptysisNum;
	}

	public Long getHematuriaNum() {
		return hematuriaNum;
	}

	public void setHematuriaNum(Long hematuriaNum) {
		this.hematuriaNum = hematuriaNum;
	}

	public Long getStomachBloodNum() {
		return stomachBloodNum;
	}

	public void setStomachBloodNum(Long stomachBloodNum) {
		this.stomachBloodNum = stomachBloodNum;
	}

	public Long getFecalOccultBloodNum() {
		return fecalOccultBloodNum;
	}

	public void setFecalOccultBloodNum(Long fecalOccultBloodNum) {
		this.fecalOccultBloodNum = fecalOccultBloodNum;
	}

	public Long getVaginalBleedingNum() {
		return vaginalBleedingNum;
	}

	public void setVaginalBleedingNum(Long vaginalBleedingNum) {
		this.vaginalBleedingNum = vaginalBleedingNum;
	}

	public Long getHeadacheNum() {
		return headacheNum;
	}

	public void setHeadacheNum(Long headacheNum) {
		this.headacheNum = headacheNum;
	}

	public Long getDizzinessVertigoNum() {
		return dizzinessVertigoNum;
	}

	public void setDizzinessVertigoNum(Long dizzinessVertigoNum) {
		this.dizzinessVertigoNum = dizzinessVertigoNum;
	}

	public Long getComaNum() {
		return comaNum;
	}

	public void setComaNum(Long comaNum) {
		this.comaNum = comaNum;
	}

	public Long getFebrileConvulsionNum() {
		return febrileConvulsionNum;
	}

	public void setFebrileConvulsionNum(Long febrileConvulsionNum) {
		this.febrileConvulsionNum = febrileConvulsionNum;
	}

	public Long getTremorNum() {
		return tremorNum;
	}

	public void setTremorNum(Long tremorNum) {
		this.tremorNum = tremorNum;
	}

	public Long getTetanyNum() {
		return tetanyNum;
	}

	public void setTetanyNum(Long tetanyNum) {
		this.tetanyNum = tetanyNum;
	}

	public Long getAtaxiaNum() {
		return ataxiaNum;
	}

	public void setAtaxiaNum(Long ataxiaNum) {
		this.ataxiaNum = ataxiaNum;
	}

	public Long getAnomalousReflectionNum() {
		return anomalousReflectionNum;
	}

	public void setAnomalousReflectionNum(Long anomalousReflectionNum) {
		this.anomalousReflectionNum = anomalousReflectionNum;
	}

	public Long getCrampsSpasmsNum() {
		return crampsSpasmsNum;
	}

	public void setCrampsSpasmsNum(Long crampsSpasmsNum) {
		this.crampsSpasmsNum = crampsSpasmsNum;
	}

	public Long getBlurredVisionNum() {
		return blurredVisionNum;
	}

	public void setBlurredVisionNum(Long blurredVisionNum) {
		this.blurredVisionNum = blurredVisionNum;
	}

	public Long getDiplopiaNum() {
		return diplopiaNum;
	}

	public void setDiplopiaNum(Long diplopiaNum) {
		this.diplopiaNum = diplopiaNum;
	}

	public Long getDysphoniaNum() {
		return dysphoniaNum;
	}

	public void setDysphoniaNum(Long dysphoniaNum) {
		this.dysphoniaNum = dysphoniaNum;
	}

	public Long getSpeechDisordersNum() {
		return speechDisordersNum;
	}

	public void setSpeechDisordersNum(Long speechDisordersNum) {
		this.speechDisordersNum = speechDisordersNum;
	}

	public Long getDysphagiaNum() {
		return dysphagiaNum;
	}

	public void setDysphagiaNum(Long dysphagiaNum) {
		this.dysphagiaNum = dysphagiaNum;
	}

	public Long getDryMouthNum() {
		return dryMouthNum;
	}

	public void setDryMouthNum(Long dryMouthNum) {
		this.dryMouthNum = dryMouthNum;
	}

	public Long getMyastheniaGravisNum() {
		return myastheniaGravisNum;
	}

	public void setMyastheniaGravisNum(Long myastheniaGravisNum) {
		this.myastheniaGravisNum = myastheniaGravisNum;
	}

	public Long getNoUrineOliguriaNum() {
		return noUrineOliguriaNum;
	}

	public void setNoUrineOliguriaNum(Long noUrineOliguriaNum) {
		this.noUrineOliguriaNum = noUrineOliguriaNum;
	}

	public Long getHyperhidrosisNum() {
		return hyperhidrosisNum;
	}

	public void setHyperhidrosisNum(Long hyperhidrosisNum) {
		this.hyperhidrosisNum = hyperhidrosisNum;
	}

	public Long getSkinRednessNum() {
		return skinRednessNum;
	}

	public void setSkinRednessNum(Long skinRednessNum) {
		this.skinRednessNum = skinRednessNum;
	}

	public Long getWaistPainNum() {
		return waistPainNum;
	}

	public void setWaistPainNum(Long waistPainNum) {
		this.waistPainNum = waistPainNum;
	}

	public Long getEyePainNum() {
		return eyePainNum;
	}

	public void setEyePainNum(Long eyePainNum) {
		this.eyePainNum = eyePainNum;
	}

	public Long getConjunctivaBloodNum() {
		return conjunctivaBloodNum;
	}

	public void setConjunctivaBloodNum(Long conjunctivaBloodNum) {
		this.conjunctivaBloodNum = conjunctivaBloodNum;
	}
}