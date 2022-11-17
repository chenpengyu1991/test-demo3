package com.founder.rhip.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.portal.InfoType;
import com.founder.rhip.ehr.repository.portal.IInfoTypeDao;
import com.founder.rhip.portal.service.IInfoTypeService;

@Service("lhinfoTypeService")
public class InfoTypeServiceImpl extends AbstractService implements IInfoTypeService{
	
	@Autowired
	private IInfoTypeDao infoTypeDao;

	@Override
	public PageList<InfoType> getList(Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return infoTypeDao.getPageList(page, criteria);
	}

	@Override
	public List<InfoType> getList(Criteria criteria){
		criteria.add("IS_DELETE", "0");
		return infoTypeDao.getList(criteria);
	}
	
	@Override
	public int delete(Criteria criteria) {
		return infoTypeDao.update(new Parameters("IS_DELETE", "1"), criteria);
	}

	@Override
	public int update(InfoType infoType, String... properties) {
		return infoTypeDao.update(infoType, properties);
	}

	@Override
	public int save(InfoType infoType, String... properties) {
		return infoTypeDao.insert(infoType, properties);
	}

	@Override
	public InfoType get(Long id) {
		return infoTypeDao.get(id);
	}

	@Override
	public InfoType get(Criteria criteria) {
		return infoTypeDao.get(criteria);
	}

}
