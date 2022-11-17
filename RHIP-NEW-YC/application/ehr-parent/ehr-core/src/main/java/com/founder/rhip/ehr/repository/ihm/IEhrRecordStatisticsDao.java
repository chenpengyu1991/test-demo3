package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuk
 * @since 2014/5/20 17:20
 */
public interface IEhrRecordStatisticsDao extends IDao<PersonInfo, Long> {
	public List<Map<String, Object>> getRecordStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender);;
}
