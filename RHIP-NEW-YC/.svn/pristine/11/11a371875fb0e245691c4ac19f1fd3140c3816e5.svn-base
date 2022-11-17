package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.Interaction;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IInteractionDao;
import com.founder.rhip.portal.service.IInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("interactionService")
public class InteractionServiceImpl extends AbstractService implements IInteractionService{

	@Autowired
	private IInteractionDao interactionDao;
	
	@Autowired
	private IHospitalInfoDao hospitalInfoDao;
	
	@Override
	public PageList<Interaction> getList(Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		Order order = new Order("INSERT_DATE", false);
		PageList<Interaction> result = interactionDao.getPageList(page, criteria, order);
		return result;
	}

	@Override
	public Interaction get(Long idTemp) {
		return interactionDao.get(idTemp);
	}

	@Override
	public int update(Interaction i,String... properties) {
		return interactionDao.update(i,properties);
	}

	@Override
	public int update(Parameters params, Criteria criteria) {
		/*Parameters params = new Parameters();
		params.add(column, value);*/
		return interactionDao.update(params, criteria);
	}

	@Override
	public Interaction getInteraction(Criteria criteria) {
		return interactionDao.get(criteria);
	}

	@Transactional
	@Override
	public int delete(Interaction interaction) {
		Parameters parameters = new Parameters("isDelete", 1);
		int rt1 = interactionDao.update(parameters, new Criteria("id",interaction.getId()));
		if (rt1 != 0) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public HospitalInfo getHospitalInfos(Criteria criteria) {
		return hospitalInfoDao.get(criteria);
	}

	@Override
	public List<HospitalInfo> getList(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return hospitalInfoDao.getList(criteria);
	}

	@Override
	public void insert(Interaction interaction) {
		interactionDao.insert(interaction);
		
	}
	
	/*@Override
	public List<Map<String, Object>> getDetailReportCardMapList(Criteria criteria) {
		List<Map<String, Object>> reports = hospitalInfoDao.getDetailReportCardMapList(criteria);
		if (ObjectUtil.isNullOrEmpty(reports)) {
			return Collections.emptyList();
		}
		return reports;
	}*/

}
