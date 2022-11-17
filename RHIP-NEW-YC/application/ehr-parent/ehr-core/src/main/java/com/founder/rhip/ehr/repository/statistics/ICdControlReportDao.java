package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.HbpManageMonthReport;

public interface ICdControlReportDao extends IDao<PersonInfo, Long> {

	List<HbpManageMonthReport> getHbpManageMonthReport(String town, String center,String station, String mouth);

	List<HbpManageMonthReport> followupCompletedWithinDate(String town, String center,String station, String mouth);

}
