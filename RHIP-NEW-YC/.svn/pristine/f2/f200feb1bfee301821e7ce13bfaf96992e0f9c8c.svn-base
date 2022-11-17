package com.founder.rhip.portal.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.portal.InfoType;

public interface IInfoTypeService {

	public PageList<InfoType> getList(Page page, Criteria criteria);
	
	public List<InfoType> getList(Criteria criteria);

	public int delete(Criteria criteria);

	public int update(InfoType infoType, String... properties);

	public int save(InfoType infoType, String... properties);

	public InfoType get(Long id);
	
	public InfoType get(Criteria criteria);

}
