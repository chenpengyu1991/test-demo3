
package com.founder.rhip.ehr.dto;

import com.founder.fasf.util.ObjectUtil;

import java.util.List;

/**
 * 健康教育报表合计
 * 
 * @author GaoFei
 * 
 */
public class HealthEducationReportSummary {

	private Integer bulletinBoardQuantity = 0; // 设置宣传栏个数

	private Integer bulletinBoardUseFrequency = 0; // 宣传栏使用频率

	private Integer speciesMaterialQuantity = 0; // 印刷资料种类数

	private Integer issueMaterialQuantity = 0; // 发放印刷资料数

	private Integer speciesVideoQuantity = 0; // 播放音像资料种类数

	private Integer playVideoQuantity = 0; // 播放音像资料时间（小时）

	private Integer playVideoPersonQuantity = 0; // 接受音像播放教育人数

	private Integer healthConsultQuantity = 0; // 公众健康咨询活动数

	private Integer healthConsultPersonQuantity = 0; // 公众健康咨询活动人数

	private Integer healthLectureQuantity = 0; // 健康知识讲座数

	private Integer healthLecturePersonQuantity = 0; // 接受健康知识讲座人数

	private Integer otherActiveQuantity = 0; // 其他健康活动数

	private Integer otherActivePersonQuantity = 0; // 其他健康活动人数

	private Integer traditionalChineseQuantity = 0; // 中医健康教育处方及资料数

	public HealthEducationReportSummary(List<HealthEducationReport> reports) {
		if (ObjectUtil.isNullOrEmpty(reports)) {
			return;
		}
		for (HealthEducationReport report : reports) {
			//印刷资料种类数合计取最大值
			/*Integer specType = report.getSpeciesMaterialQuantity();
			if(specType>speciesMaterialQuantity)
				speciesMaterialQuantity= specType;*/
 		    this.speciesMaterialQuantity += report.getSpeciesMaterialQuantity();
			this.bulletinBoardQuantity += report.getBulletinBoardQuantity();
			this.bulletinBoardUseFrequency += report.getBulletinBoardUseFrequency();
			this.issueMaterialQuantity += report.getIssueMaterialQuantity();
			this.speciesVideoQuantity += report.getSpeciesVideoQuantity();
			this.playVideoQuantity += report.getPlayVideoQuantity();
			this.playVideoPersonQuantity += report.getPlayVideoPersonQuantity();
			this.healthConsultQuantity += report.getHealthConsultQuantity();
			this.healthConsultPersonQuantity += report.getHealthConsultPersonQuantity();
			this.healthLectureQuantity += report.getHealthLectureQuantity();
			this.healthLecturePersonQuantity += report.getHealthLecturePersonQuantity();
			this.otherActiveQuantity += report.getOtherActiveQuantity();
			this.otherActivePersonQuantity += report.getOtherActivePersonQuantity();
            this.traditionalChineseQuantity += report.getTraditionalChineseQuantity();
		}
	}

	public Integer getBulletinBoardQuantity() {
		return bulletinBoardQuantity;
	}

	public void setBulletinBoardQuantity(Integer bulletinBoardQuantity) {
		this.bulletinBoardQuantity = bulletinBoardQuantity;
	}

	public Integer getBulletinBoardUseFrequency() {
		return bulletinBoardUseFrequency;
	}

	public void setBulletinBoardUseFrequency(Integer bulletinBoardUseFrequency) {
		this.bulletinBoardUseFrequency = bulletinBoardUseFrequency;
	}

	public Integer getIssueMaterialQuantity() {
		return issueMaterialQuantity;
	}

	public void setIssueMaterialQuantity(Integer issueMaterialQuantity) {
		this.issueMaterialQuantity = issueMaterialQuantity;
	}

	public Integer getPlayVideoQuantity() {
		return playVideoQuantity;
	}

	public void setPlayVideoQuantity(Integer playVideoQuantity) {
		this.playVideoQuantity = playVideoQuantity;
	}

	public Integer getPlayVideoPersonQuantity() {
		return playVideoPersonQuantity;
	}

	public void setPlayVideoPersonQuantity(Integer playVideoPersonQuantity) {
		this.playVideoPersonQuantity = playVideoPersonQuantity;
	}

	public Integer getHealthConsultQuantity() {
		return healthConsultQuantity;
	}

	public void setHealthConsultQuantity(Integer healthConsultQuantity) {
		this.healthConsultQuantity = healthConsultQuantity;
	}

	public Integer getHealthConsultPersonQuantity() {
		return healthConsultPersonQuantity;
	}

	public void setHealthConsultPersonQuantity(Integer healthConsultPersonQuantity) {
		this.healthConsultPersonQuantity = healthConsultPersonQuantity;
	}

	public Integer getHealthLectureQuantity() {
		return healthLectureQuantity;
	}

	public void setHealthLectureQuantity(Integer healthLectureQuantity) {
		this.healthLectureQuantity = healthLectureQuantity;
	}

	public Integer getHealthLecturePersonQuantity() {
		return healthLecturePersonQuantity;
	}

	public void setHealthLecturePersonQuantity(Integer healthLecturePersonQuantity) {
		this.healthLecturePersonQuantity = healthLecturePersonQuantity;
	}

	public Integer getOtherActiveQuantity() {
		return otherActiveQuantity;
	}

	public void setOtherActiveQuantity(Integer otherActiveQuantity) {
		this.otherActiveQuantity = otherActiveQuantity;
	}

	public Integer getOtherActivePersonQuantity() {
		return otherActivePersonQuantity;
	}

	public void setOtherActivePersonQuantity(Integer otherActivePersonQuantity) {
		this.otherActivePersonQuantity = otherActivePersonQuantity;
	}

	public Integer getSpeciesMaterialQuantity() {
		return speciesMaterialQuantity;
	}

	public void setSpeciesMaterialQuantity(Integer speciesMaterialQuantity) {
		this.speciesMaterialQuantity = speciesMaterialQuantity;
	}

	public Integer getSpeciesVideoQuantity() {
		return speciesVideoQuantity;
	}

	public void setSpeciesVideoQuantity(Integer speciesVideoQuantity) {
		this.speciesVideoQuantity = speciesVideoQuantity;
	}

	public Integer getTraditionalChineseQuantity() {
		return traditionalChineseQuantity;
	}

	public void setTraditionalChineseQuantity(Integer traditionalChineseQuantity) {
		this.traditionalChineseQuantity = traditionalChineseQuantity;
	}
}
