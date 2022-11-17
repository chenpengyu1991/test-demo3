package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 3星级  -- 生活方式
 *@author liuk
 */
@Component
public class ThreeStarLifestyleValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		PhysiqueExamination phyExam = personalPhyExamDTO.getPhysiqueExamination();
		int value = 0;
		if(ObjectUtil.isNotEmpty(phyExam)) {
			if(train(phyExam) && smoke(phyExam) && drink(phyExam) && diet(phyExam) && occupation(phyExam)){
				value = 1;
			}
		}
		return value;
	}
	
	//锻炼
	private boolean train(PhysiqueExamination phyExam){
		if(ObjectUtil.isNotEmpty(phyExam.getTrainFrequencyTypeCode()) && phyExam.getTrainFrequencyTypeCode().equals("4")){
			return true;
		}else if(ObjectUtil.isNotEmpty(phyExam.getTrainFrequencyTypeCode()) && ObjectUtil.isNotEmpty(phyExam.getTrainingMin()) &&
				ObjectUtil.isNotEmpty(phyExam.getTrainingTotaltime()) && ObjectUtil.isNotEmpty(phyExam.getTrainingWay())){
			return true;
		}
		return false;
	}
	
	//吸烟
	private boolean smoke(PhysiqueExamination phyExam){
		if(ObjectUtil.isNotEmpty(phyExam.getSmodeStatusCode()) && phyExam.getSmodeStatusCode().equals("1")){
			return true;
		}else if(ObjectUtil.isNotEmpty(phyExam.getSmodeStatusCode()) && ObjectUtil.isNotEmpty(phyExam.getDailySmoke()) &&
				ObjectUtil.isNotEmpty(phyExam.getSmokeAge())){
			return true;
		}
		return false;
	}
	
	//饮酒
	private boolean drink(PhysiqueExamination phyExam){
		if(ObjectUtil.isNotEmpty(phyExam.getDrinkFrequency()) && phyExam.getDrinkFrequency().equals("1")){
			return true;
		}else if(ObjectUtil.isNotEmpty(phyExam.getDrinkFrequency()) && ObjectUtil.isNotEmpty(phyExam.getDailyDrink()) &&
				ObjectUtil.isNotEmpty(phyExam.getNodrink()) && ObjectUtil.isNotEmpty(phyExam.getDrinkAge()) &&
				ObjectUtil.isNotEmpty(phyExam.getDrunk()) && (ObjectUtil.isNotEmpty(phyExam.getDrinkSpirit()) ||
						ObjectUtil.isNotEmpty(phyExam.getDrinkBeer()) || ObjectUtil.isNotEmpty(phyExam.getDrinkRedWine()) ||
						ObjectUtil.isNotEmpty(phyExam.getDrinkYellowWine()) || ObjectUtil.isNotEmpty(phyExam.getDrinkOther()))){
			return true;
		}
		return false;
	}
	
	//饮食习惯
	private boolean diet(PhysiqueExamination phyExam){
		if(ObjectUtil.isNotEmpty(phyExam.getDietAddictedOil()) || 
				ObjectUtil.isNotEmpty(phyExam.getDietHalophilic()) || 
				ObjectUtil.isNotEmpty(phyExam.getDietHunsuEquilibrium()) ||
				ObjectUtil.isNotEmpty(phyExam.getDietMeatMain()) ||
				ObjectUtil.isNotEmpty(phyExam.getDietSugarCravings()) ||
				ObjectUtil.isNotEmpty(phyExam.getDietVegetarian())) {
			return true;
		}
		return false;
	}
	
	//职业病危害因素接触史
	private boolean occupation(PhysiqueExamination phyExam){
		if(ObjectUtil.isNotEmpty(phyExam.getOccupationExposureFlag())) {
			return true;
		}
		return false;
	}
}
