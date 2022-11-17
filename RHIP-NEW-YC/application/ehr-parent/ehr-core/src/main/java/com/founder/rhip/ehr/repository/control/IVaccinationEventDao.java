package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of VaccinationInfo
 */
public interface IVaccinationEventDao extends IDao<VaccinationEvent, String> {

	/** 
	* @Title: getVaccinationEventList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param criteria
	* @param @return
	* @return PageList<VaccinationEvent>
	* @throws 
	*/
	PageList<VaccinationEvent> getVaccinationEventList(Page page, Criteria criteria);
	
	/**
     * 统计犬伤接种信息
     * @param criteria
     * @return
     */
	List<Map<String, Object>> statisticsRabiesMapList(Criteria criteria);

}