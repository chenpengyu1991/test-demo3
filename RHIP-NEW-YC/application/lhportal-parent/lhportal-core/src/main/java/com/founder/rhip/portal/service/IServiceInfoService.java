package com.founder.rhip.portal.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.ServiceInfo;

public interface IServiceInfoService {
	
	public PageList<ServiceInfo> getList(Page page, Criteria criteria);
	
	public List<ServiceInfo> getList(Criteria criteria);
	
	ServiceInfo get(Long id);
	
	boolean update (ServiceInfo serviceInfo, Map<String, String> map, String createUserCode);
	
	boolean insert (ServiceInfo serviceInfo, Map<String, String> map, String createUserCode);
	
	int delete(Criteria criteria);

	public int updateStatus(Parameters parameters, Criteria criteria);
	
	public int update(ServiceInfo serviceInfo);

}
