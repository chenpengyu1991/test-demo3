package com.founder.rhip.ehr.repository.women;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.MaternalHealthManage;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;

/**
 * DAO interface of PrenatalFollowup
 */
public interface IPrenatalFollowupDao extends IDao<PrenatalFollowup, String> {

	public Long prenatalFollowOver5Count(Criteria criteria);
	
	public Map<String, Object> getOrganMapCount(Criteria criteria);
	
	public List<Map<String, Object>> getPrenataFollowupMapList(String dateStr);

	public Integer getPrenataFollNum(Integer year,Integer quarter,String orgCode);

	public List<MaternalHealthManage> getMaternalHealthManage(Integer year, Integer quarter, List<String> organCodeList);

	public void updateOrganByVillage(String createOrganCode, String createOrganName, String[] newAddVillageCodes,String tableName);
}