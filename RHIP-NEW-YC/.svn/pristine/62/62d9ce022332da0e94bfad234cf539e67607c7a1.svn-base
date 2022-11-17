package com.founder.rhip.ehr.repository.statistics;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.DmManageAndFollowup;

public interface ICdmWorkStatisticsDao extends IDao<PersonInfo, Long> {

	List<Map<String, Object>> getTumorPathologyResult(String beginAge,String endAge,String gbCode,String orgCode);

	List<DmManageAndFollowup>  getManageAndFollowup(String beginAge, String endAge, String town, String center,String station, String cdmType);

	List<DmManageAndFollowup> getFollowupStatus(String beginAge, String endAge, String town, String center,String station,String cdmType);

	List<DmManageAndFollowup>  getIntoStatus(String beginAge, String endAge, String town, String center,String station,String cdmType);

}
