package com.founder.rhip.ehr.repository.ihm;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * @author liuk
 * @since 2014/5/20 17:20
 */
public interface IDiStatisticsDao extends IDao<PersonInfo, Long> {
	public List<Map<String, Object>> getStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate);
}
