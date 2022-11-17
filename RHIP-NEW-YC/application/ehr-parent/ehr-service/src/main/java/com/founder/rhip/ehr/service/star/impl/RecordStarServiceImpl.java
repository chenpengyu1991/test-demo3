package com.founder.rhip.ehr.service.star.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IValidateDTO;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.service.star.IDisplayFieldValueGetter;
import com.founder.rhip.ehr.service.star.IOneStarValueGetter;
import com.founder.rhip.ehr.service.star.IRecordStarService;
import com.founder.rhip.ehr.service.star.IStarValueGetter;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;
import com.founder.rhip.ehr.service.star.ITwoStarDisplayFieldGetter;
import com.founder.rhip.ehr.service.star.ITwoStarValueGetter;

/**
 * 星级获取
 * 
 * @author liuk
 * 
 */
@Service
public class RecordStarServiceImpl implements IRecordStarService {

	private static Logger logger = Logger
			.getLogger(RecordStarServiceImpl.class);
	@Autowired(required = false)
	private List<IOneStarValueGetter<PersonalBasicInfoDTO>> oneGetters;
	@Autowired(required = false)
	private List<ITwoStarValueGetter<PersonalBasicInfoDTO>> twoGetters;
	@Autowired(required = false)
	private List<IThreeStarValueGetter<PersonalPhyExamDTO>> threeGetters;
	@Autowired(required = false)
	private List<ITwoStarDisplayFieldGetter<PersonalBasicInfoDTO>> twoDisGetter;
	@Autowired(required = false)
	private List<IThreeStarDisplayFieldGetter<PersonalPhyExamDTO>> threeGetter;
	@Autowired
	private IPersonInfoDao personInfoDao;
	
	//三星基础分数
//	private Integer threeTotalScore = EHRConstants.Three_STAR_DIS_BASIC_SCORE;

	/**
	 * 一星计算
	 */
	@Override
	public void calOneStarRecord(IValidateDTO personalBasicInfo) {
		Assert.notNull(personalBasicInfo, "封面信息不能为空");
		PersonInfo personInfo = ((PersonalBasicInfoDTO) personalBasicInfo).getPersonInfo();
		Assert.notNull(personInfo, "人员基本信息不能为空");
		personInfo.setOneStarScore(calOneStar((PersonalBasicInfoDTO) personalBasicInfo));
		doCalStar(personInfo);
	}

	/**
	 * 二星计算
	 */
	@Override
	public void calTwoStarRecord(IValidateDTO personalBasicInfo) {
		Assert.notNull(personalBasicInfo, "人员基本信息不能为空");
		PersonInfo personInfo = ((PersonalBasicInfoDTO) personalBasicInfo).getPersonInfo();
//		personInfo.setTwoStarScore(calTwoStar((PersonalBasicInfoDTO) personalBasicInfo));
		personInfo.setTwoStarDisplayScore(calTwoStarDisplay((PersonalBasicInfoDTO) personalBasicInfo));
		doCalStar(personInfo);
	}

	/**
	 * 三星计算
	 */
	@Override
	public void calThreeStarRecord(IValidateDTO personalPhyExam) {
		Assert.notNull(personalPhyExam, "人员体检信息不能为空");
		PersonInfo personInfo = ((PersonalPhyExamDTO) personalPhyExam).getPersonInfo();
		personInfo.setThreeStarScore(calThreeStar((PersonalPhyExamDTO) personalPhyExam));
//		personInfo.setThreeStarDisplayScore(calThreeStarDisplay((PersonalPhyExamDTO) personalPhyExam));
//		calThreeTotalScore((PersonalPhyExamDTO) personalPhyExam);
		doCalStar(personInfo);
	}

	// 二 三星计算
	@Override
	public void calTwoAndThreeStarRecord(IValidateDTO personalPhyExam) {
		Assert.notNull(personalPhyExam, "体检信息不能为空");
		PersonInfo personInfo = ((PersonalPhyExamDTO) personalPhyExam)
				.getPersonInfo();
		Assert.notNull(personInfo, "人员基本信息不能为空");
		personInfo.setTwoStarScore(calTwoStar((PersonalBasicInfoDTO) personalPhyExam));
		personInfo.setThreeStarScore(calThreeStar((PersonalPhyExamDTO) personalPhyExam));
		doCalStar(personInfo);
	}

	private void doCalStar(PersonInfo personInfo) {
		Integer oldStar = personInfo.getStar();
		Integer oneScore = personInfo.getOneStarScore();
		if (null != oneScore && oneScore == EHRConstants.ONE_STAT_DENOMINATOR) {
			Integer twoDisScore = personInfo.getTwoStarDisplayScore();
			if (twoDisScore != null && twoDisScore >= EHRConstants.TWO_STAR_DIS_SCORE * EHRConstants.DOC_INTEGRITY) {
				Integer threeScore = personInfo.getThreeStarScore();
				if (null != threeScore && threeScore == EHRConstants.THREE_STAT_DENOMINATOR ) {
					personInfo.setStar(EHRConstants.THREE_STAT_VALUE);
					personInfo.setIntegrity(StarUtil.div(threeScore, EHRConstants.THREE_STAT_DENOMINATOR));
				} else {
					personInfo.setIntegrity(StarUtil.div(twoDisScore, EHRConstants.TWO_STAR_DIS_SCORE));
					personInfo.setStar(EHRConstants.TWO_STAT_VALUE);
				}
			} else {
				personInfo.setStar(EHRConstants.ONE_STAT_VALUE);
				personInfo.setIntegrity(StarUtil.div(oneScore, EHRConstants.ONE_STAT_DENOMINATOR));
			}
		} else {
			personInfo.setIntegrity(StarUtil.div(oneScore, EHRConstants.ONE_STAT_DENOMINATOR));
			personInfo.setStar(EHRConstants.ZERO_STAT_VALUE);
		}
		
		// 星级改变时记录修改时间
		if(personInfo.getStar() != oldStar){
			personInfo.setStarUpdateDate(new Date());
		}
	}

	@Override
	@Transactional
	public void updateStar(PersonInfo personInfo) {
		if (null != personInfo) {
			personInfoDao.update(personInfo, "star", "oneStarScore",
					"twoStarDisplayScore", "threeStarScore", "integrity", "starUpdateDate");
		}
	}

	@Override
	public void copyStar(PersonInfo to, PersonInfo from) {
		if (null != to && null != from) {
			to.setStar(from.getStar());
			to.setOneStarScore(from.getOneStarScore());
			to.setTwoStarScore(from.getTwoStarScore());
			to.setThreeStarScore(from.getThreeStarScore());
			to.setIntegrity(from.getIntegrity());
		}
	}

	public int calOneStar(PersonalBasicInfoDTO dto) {
		int value = cal(dto, oneGetters);
		return value;
	}

	public int calTwoStar(PersonalBasicInfoDTO dto) {
		int value = cal(dto, twoGetters);
		return value;
	}

	public int calThreeStar(PersonalPhyExamDTO dto) {
		int value = cal(dto, threeGetters);
		return value;
	}
	
	/**
	 * 二星显示字段得分
	 * @param dto
	 * @return
	 */
	public int calTwoStarDisplay(PersonalBasicInfoDTO dto){
		int value = calDisplayField(dto, twoDisGetter);
		return value;
	}
	
	/**
	 * 三星显示字段得分
	 * @param dto
	 * @return
	 */
	public int calThreeStarDisplay(PersonalPhyExamDTO dto){
		int value = calDisplayField(dto, threeGetter);
		return value;
	}
	
	private <T> int cal(T target, List<? extends IStarValueGetter<T>> getters) {
		int value = 0;
		if (null != target && null != getters) {
			AgeHelper.destroy();
			for (IStarValueGetter<T> getter : getters) {
				int tmp = getter.execute(target);
				if (logger.isDebugEnabled()) {
					logger.debug(getter.getClass().getSimpleName() + ":" + tmp);
				}
				value += tmp;
			}
		}
		return value;
	}
	
	private <T> int calDisplayField(T target, List<? extends IDisplayFieldValueGetter<T>> getters){
		int value = 0;
		if (null != target && null != getters) {
			for (IDisplayFieldValueGetter<T> getter : getters) {
				int tmp = getter.execute(target);
				if (logger.isDebugEnabled()) {
					logger.debug(getter.getClass().getSimpleName() + ":" + tmp);
				}
				value += tmp;
			}
		}
		return value;
	}
}