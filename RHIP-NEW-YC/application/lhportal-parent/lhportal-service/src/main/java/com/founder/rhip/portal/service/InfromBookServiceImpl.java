package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.InfromBook;
import com.founder.rhip.ehr.repository.portal.IInfromBookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("lhinfromBookService")
public class InfromBookServiceImpl extends AbstractService implements IInfromBookService{
	@Resource(name = "lhinfromBookDao")
	private IInfromBookDao infromBookDao;
	@Override
	public InfromBook getInfromBook() {
		return infromBookDao.get(new Criteria());
	}

	@Override
	public int save(InfromBook infromBook) {
		if(ObjectUtil.isNotEmpty(infromBook.getId())) {
			return infromBookDao.update(infromBook);
		}
		return infromBookDao.insert(infromBook);
	}
}
