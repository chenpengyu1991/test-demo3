package com.founder.rhip.ehr.service.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PcbDicItem;
import com.founder.rhip.ehr.repository.basic.IPcbDicItemDao;

@Service("pcbDicItemService")
public class PcbDicItemServiceImpl extends AbstractService implements IPcbDicItemService {

	@Autowired
	private IPcbDicItemDao pcbDicItemDao;

	@Override
	public List<PcbDicItem> queryDictionary(Criteria criteria) {
		return pcbDicItemDao.queryDictionary(criteria);
	}

	@Override
	public List<PcbDicItem> queryDicItem(String dicCode) {
		if(StringUtil.isEmpty(dicCode)) {
			return null;
		}

		return pcbDicItemDao.queryDicItem(dicCode);
	}
	
}