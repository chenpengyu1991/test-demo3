package com.founder.rhip.ph.service.vaccine;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.RabiesStatisticsDTO;
import com.founder.rhip.ehr.dto.VaccineStatisticsMonthDTO;


/**
 * 
 * @author liu_jingyin
 */
public interface IVaccineStatisticsService {
	Map<String, VaccineStatisticsMonthDTO> statisticsByMonth(Date startDate, Date endDate);
	
	Map<String,RabiesStatisticsDTO> statistics(Date searchDate,String orgCode);
	
	/**
     * 统计犬伤接种信息
     * @param criteria
     * @return
     */
    List<Map<String, Object>> statisticsRabiesMapList(Criteria criteria);
}
