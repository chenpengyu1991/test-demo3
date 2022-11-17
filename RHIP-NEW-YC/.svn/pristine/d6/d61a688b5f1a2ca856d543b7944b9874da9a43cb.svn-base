package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 3星级  -- 查体
 *@author ggf
 */
@Component
public class ThreeStarBodyValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		PhysiqueExamination phyExam = personalPhyExamDTO.getPhysiqueExamination();
		int value = 0;
		if(ObjectUtil.isNotEmpty(phyExam) && ObjectUtil.isNotEmpty(phyExam.getHeartRate())) {
			value = 1;
		}
		return value;
	}
	
//	//眼底、皮肤、虹膜、淋巴结
//	private boolean proj1(PhysiqueExamination phyExam){
//		if(ObjectUtil.isNotEmpty(phyExam.getFundusOculiAnomalyFlag()) && ObjectUtil.isNotEmpty(phyExam.getSkinCheckResult()) &&
//				ObjectUtil.isNotEmpty(phyExam.getScleraCheckResult()) && ObjectUtil.isNotEmpty(phyExam.getLymphNodeCheckResult())){
//			return true;
//		}
//		return false;
//	}
//	
//	//肺
//	private boolean lung(PhysiqueExamination phyExam){
//		if(ObjectUtil.isNotEmpty(phyExam.getBarrelChest()) && ObjectUtil.isNotEmpty(phyExam.getLungsAnomalySound()) &&
//				ObjectUtil.isNotEmpty(phyExam.getLungsRaleFlag())){
//			return true;
//		}
//		return false;
//	}
//	
//	//心脏
//	private boolean heart(PhysiqueExamination phyExam){
//		if(ObjectUtil.isNotEmpty(phyExam.getHeartRate()) && ObjectUtil.isNotEmpty(phyExam.getCardioverter()) &&
//				ObjectUtil.isNotEmpty(phyExam.getHeartMurmurFlag()) ){
//			return true;
//		}
//		return false;
//	}
//	
//	//腹部
//	private boolean abdominal(PhysiqueExamination phyExam){
//		if(ObjectUtil.isNotEmpty(phyExam.getAbdominalTendernessFlag()) &&
//				ObjectUtil.isNotEmpty(phyExam.getAbdominalMassFlag()) &&
//				ObjectUtil.isNotEmpty(phyExam.getLiverFlag()) &&
//				ObjectUtil.isNotEmpty(phyExam.getSplenomegalyFlag()) &&
//				ObjectUtil.isNotEmpty(phyExam.getAbdominalVoicedFlag())) {
//			return true;
//		}
//		return false;
//	}
//	
//	//下肢水肿、足背动脉搏动、肛门指诊、乳腺、其他
//	private boolean proj2(PhysiqueExamination phyExam){
//		if(ObjectUtil.isNotEmpty(phyExam.getLegsEdemaCheckResult()) && ObjectUtil.isNotEmpty(phyExam.getArteriopalmus()) &&
//				ObjectUtil.isNotEmpty(phyExam.getDreCheckResultType()) && ObjectUtil.isNotEmpty(phyExam.getBreastAnomalyFlag())	) {
//			return true;
//		}
//		return false;
//	}
//	
//	//妇女
//	private boolean woman(PhysiqueExamination phyExam){
//		if(ObjectUtil.isNotEmpty(phyExam.getVulvaAnomalyFlag()) && ObjectUtil.isNotEmpty(phyExam.getVaginaAnomalyFlag()) &&
//				ObjectUtil.isNotEmpty(phyExam.getCervicalAnomalyFlag()) && ObjectUtil.isNotEmpty(phyExam.getCorpusAnomalyFlag()) &&
//				ObjectUtil.isNotEmpty(phyExam.getAccessoriesAnomalyFlag()) ){
//			return true;
//		}
//		return false;
//	}
}
