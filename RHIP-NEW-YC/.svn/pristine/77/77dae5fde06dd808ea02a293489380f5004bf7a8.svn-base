package com.founder.rhip.ehr.repository.statistics;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

public interface ICdmsStatisticsDao extends IDao<PersonInfo, Long>{
    public List<Map<String, Object>> getCdmsStatisticList(Criteria criteria);
    
	public List<Map<String, Object>> getHBPCount(String houseHoldType); 

	public List<Map<String, Object>> getNewHBPCount(String houseHoldType);

	public List<Map<String, Object>> getCuredHBPCount(String houseHoldType);

	public List<Map<String, Object>> getDITypeTwoCount(String houseHoldType); 

	public List<Map<String, Object>> getNewDITypeTwoCount(String houseHoldType); 

	public List<Map<String, Object>> getCuredDITypeTwoCount(String houseHoldType); 
	
	public List<Map<String, Object>> getTownHBPCount(String houseHoldType); 

	public List<Map<String, Object>> getTownNewHBPCount(String houseHoldType);

	public List<Map<String, Object>> getTownCuredHBPCount(String houseHoldType);

	public List<Map<String, Object>> getTownDITypeTwoCount(String houseHoldType); 

	public List<Map<String, Object>> getTownNewDITypeTwoCount(String houseHoldType); 

	public List<Map<String, Object>> getTownCuredDITypeTwoCount(String houseHoldType); 
	
	public List<Map<String,Object>> getCdmStatictics(String code,String organType,Date startDate, Date endDate);

	Long getHbpCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getHbpFollowupCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getHbpFollowupOKCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getDiCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getDiFollowupCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getDiFollowupOKCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);
	
	Long getDiTypeTwoCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getDiTypeTwoFollowupOKCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);

	Long getDiTypeTwoFollowupCountByOrganCode(List<String> orgCode, Date startDate, Date endDate);
}
