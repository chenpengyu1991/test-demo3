package com.founder.rhip.im.service.publicHealth;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.im.common.ImConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("lifeWayService")
public class LifeWayServiceImpl implements ILifeWayService {

	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;



	@Override
	public List<Map<String, Object>> getLifeWayMapList(Criteria criteria, String type) {
		List<Map<String,Object>> result = new ArrayList<>();
		if(ImConstants.EATING_HABITS.equals(type)){
			result = physiqueExaminationDao.getEatingHabitsMapList(criteria);
		}else if(ImConstants.TRAIN_FREQUENCY.equals(type)){
			result = physiqueExaminationDao.getTrainFrequencyMapList(criteria);
		}else if(ImConstants.SMODE_STATUS.equals(type)){
			result = physiqueExaminationDao.getSmodeStatusMapList(criteria);
		}else if(ImConstants.DRINK_FREQUENCY.equals(type)){
			result = physiqueExaminationDao.getDrinkFrequencyMapList(criteria);
		}
		return result;
	}
}
