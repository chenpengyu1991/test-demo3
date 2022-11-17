package com.founder.rhip.ehr.repository.ep;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ep.IodineNutritionMonitor;

/**
 * DAO interface of IodineNutritionMonitor
 * 
 */
public interface IIodineNutritionMonitorDao extends IDao<IodineNutritionMonitor,Long> {

	public String getMax(Long samplingId);
	
	public IodineNutritionMonitor getCurrentYearDetailBySurveyNo(String surveyNo);

}