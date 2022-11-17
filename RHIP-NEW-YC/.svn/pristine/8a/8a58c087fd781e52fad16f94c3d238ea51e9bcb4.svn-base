package com.founder.rhip.ph.service.oh;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.oh.OhPoisonReport;
import com.founder.rhip.ehr.repository.oh.IOhPoisonReportDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.service.IMergerTownListener;

@Service
public class OhPoisonReportServiceImpl extends AbstractService implements
		IOhPoisonReportService,IMergerTownListener {

	@Autowired
	private IOhPoisonReportDao ohPoisonReportDao;
	
	@Autowired
    private IPlatformService personService;
	@Override
	public PageList<OhPoisonReport> searchOhPoisonReportList(Page page,
			Criteria criteria) {
		criteria.add("IS_DELETE","0");
		//return ohPoisonReportDao.getPageList(page, criteria);
		Order order = new Order("VERIFY_STATE",false);
		order.desc("UPDATE_TIME");
		return ohPoisonReportDao.getPageList( page, criteria, order);
	}
	@Override
	public OhPoisonReport searchOhPoisonReport(Criteria criteria) {
		criteria.add("IS_DELETE","0");
		return ohPoisonReportDao.getList(criteria).size()>0?ohPoisonReportDao.getList(criteria).get(0):null;
	}
	@Override
	public int addOhPoisonReport(OhPoisonReport ohPoisonReport) {
		return ohPoisonReportDao.insert(ohPoisonReport);
	}

	@Override
	public int deleteOhPoisonReport(String isDelete,Criteria criteria) {
		Parameters params = new Parameters();
		params.add("IS_DELETE", isDelete);
		return ohPoisonReportDao.update(params, criteria);
	}

	@Override
	public int updateOhPoisonReport(OhPoisonReport ohPoisonReport) {
		return ohPoisonReportDao.update(ohPoisonReport);
	}

	@Override
	public int checkOhPoisonReport(String verifier,String verifyState,Criteria criteria) {
		Parameters params = new Parameters();
		params.add("VERIFY_DATE", new Date());
		params.add("VERIFIER", verifier);
		params.add("VERIFY_STATE", verifyState);
		return ohPoisonReportDao.update(params, criteria);
	}
	@Override
	@Transactional
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		if (ObjectUtil.isNullOrEmpty(oldTownCode)) {
			return;
		}
		Assert.notNull(newTownCode, "目标中心不能为空");
		Criteria criteria = new Criteria("patownShip", OP.IN, oldTownCode);
		Parameters parameters = new Parameters("patownShip", newTownCode);
		ohPoisonReportDao.update(parameters, criteria);

	}
	@Override
	@Transactional
	public void sendTownVillageRelation(String townCode,
										String[] newAddVillageCodes) {
		if (ObjectUtil.isNullOrEmpty(townCode)) {
			return;
		}
		Assert.notNull(newAddVillageCodes, "目标中心不能为空");
		Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		Parameters parameters = new Parameters("patownShip", townCode);
		ohPoisonReportDao.update(parameters, criteria);
	}
	@Override
    @Transactional
    public int createPerson(OhPoisonReport ohPoisonReport) throws InvocationTargetException, IllegalAccessException {
        PersonInfo personInfo = new PersonInfo();
        BeanUtils.copyProperties(ohPoisonReport,personInfo);
        personInfo.setId(null);
        personInfo.setOtherIdcardType("0");//证件类型-身份证
        personInfo.setProcessStatus("");
        personInfo.setUpdateName(ohPoisonReport.getUpdateBy());
        String pId = personService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, false);
        return Integer.parseInt(pId);
    }

}
