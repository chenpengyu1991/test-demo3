package com.founder.rhip.portal.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.PortalSet;
import com.founder.rhip.ehr.repository.portal.IPortalSetDao;

@Service("portalSetService")
public class PortalSetServiceImpl extends AbstractService implements IPortalSetService {
	
	@Autowired
	private IPortalSetDao portalSetDao;

	@Override
	public HashMap<String,String> getSetByType(String type){
		Criteria criteria = new Criteria("TYPE",type);
		List<PortalSet> list = portalSetDao.getList(criteria);
		HashMap<String,String> map = new HashMap<>();
		if(ObjectUtil.isNullOrEmpty(list)){
			return map;
		}
		for(PortalSet set:list){
			map.put(set.getCode(), set.getDescription());
		}
		return map;
	}
	
	@Override
	public List<PortalSet> getSetList(Criteria criteria){
		List<PortalSet> list = portalSetDao.getList(criteria);
		return list;
	}
	
	@Override
	public PageList<PortalSet> getSetPageList(Criteria criteria,Page page){
		Order or = new Order("type");
		or.asc("code");
		PageList<PortalSet> list = portalSetDao.getPageList(page,criteria,or);
		return list;
	}
	
	@Override
	public String getByCode(String code){
		Criteria criteria = new Criteria("code",code);
		PortalSet p = getSet(criteria);
		if(ObjectUtil.isNotEmpty(p)){
			return p.getDescription();
		}
		return null;
	}
	
	@Override
	public PortalSet getSet(Criteria criteria){
		PortalSet set = portalSetDao.get(criteria);
		return set;
	}
	
	@Override
	public Integer save(PortalSet portalSet){
		if(ObjectUtil.isNullOrEmpty(portalSet.getId())){
			return portalSetDao.insert(portalSet);
		}else{
			return portalSetDao.update(portalSet);
		}
	}
	
	@Override
	public Integer delete(Long setId){
		return portalSetDao.delete(setId);
	}

	@Override
	public HashMap<String, String> getSetByType(Criteria criteria) {		
		List<PortalSet> list = portalSetDao.getList(criteria);
		HashMap<String,String> map = new HashMap<>();
		if(ObjectUtil.isNullOrEmpty(list)){
			return map;
		}
		for(PortalSet set:list){
			map.put(set.getCode(), set.getDescription());
		}
		return map;
	}

	@Override
	public String getNameByCode(String code) {
		Criteria criteria = new Criteria("code",code);
		PortalSet p = getSet(criteria);
		if(ObjectUtil.isNotEmpty(p)){
			return p.getName();
		}
		return null;
	}
}
