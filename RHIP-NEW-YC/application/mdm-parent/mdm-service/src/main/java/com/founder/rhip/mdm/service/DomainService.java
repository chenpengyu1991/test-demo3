package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.Domain;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.repository.IDomainDao;
import com.founder.rhip.mdm.service.IDomainService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mdmDomainService")
public class DomainService extends MDMService implements IDomainService {

	@Resource(name="mdmDomainDao")
	private IDomainDao domainDao;
	
	@Override
	public PageList<Domain> queryDomains(Page page, Criteria criteria) {
		PageList<Domain> pageList = domainDao.getPageList(page, criteria);
		return pageList;
	}
	
	@Override
	public List<Domain> queryDomains(Criteria criteria) {
		return domainDao.getList(criteria);
	}

	@Override
	public String insertDomain(Domain domain) {
		domainDao.insert(domain);
		return domain.getDomainCode();
	}

	@Override
	public String updateDomain(Domain domain) {
		domainDao.update(domain);
		return domain.getDomainCode();
	}

	@Override
	public Boolean deleteDomain(String domainCode) {
		int result = domainDao.delete(domainCode);
		return (result == 1);
	}
	
	@Override
	public Domain getDomain(String domainCode) {
		return domainDao.get(domainCode);
	}

	@Override
	public Map<String, String> getDomainMapUseCache(Criteria criteria) {
		String key = MAP_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		Map<String, String> retMap = (Map<String, String>) getCache(EntityType.DOMAIN, key);
		if (retMap == null) {
			retMap = new HashMap<>();
			List<Domain> items = domainDao.getAll();
			for (Domain item : items) {
				retMap.put(item.getDomainCode(), item.getDomainName());
			}
			if (retMap.size() > 0) {
				setCache(EntityType.DOMAIN, key, retMap);
			}
		}
		return retMap;
	}

}
