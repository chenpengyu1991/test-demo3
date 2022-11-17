package com.founder.rhip.ehr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.ChildDeath;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.rhip.ehr.entity.women.MaternalDeath;
import com.founder.rhip.ehr.repository.child.IChildDeathDao;
import com.founder.rhip.ehr.repository.control.IDeathMedicineCertificateDao;
import com.founder.rhip.ehr.repository.women.IMaternalDeathDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.repository.basic.ILifeEventDao;
import com.founder.rhip.ehr.service.personal.IPersonCanceledService;

@Service("lifeEventService")
public class LifeEventServiceImpl extends AbstractService implements ILifeEventService {

	@Resource(name = "lifeEventDao")
	private ILifeEventDao lifeEventDao;
	
	@Resource(name = "personCanceledInfoService")
	private IPersonCanceledService personCanceledService;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@Resource(name = "deathMedicineCertificateDao")
	private IDeathMedicineCertificateDao deathMedicineCertificateDao;

	@Resource(name = "childDeathDao")
	private IChildDeathDao childDeathDao;

	@Resource(name = "maternalDeathDao")
	private IMaternalDeathDao maternalDeathDao;

	@Autowired
	private IPlatformService platformService;

	@Override
	public PersonDeathRecord query(Criteria criteria){
		return lifeEventDao.get(criteria);
	}
	
	@Override
	public PageList<PersonDeathRecord> queryList(Criteria criteria, Page page) {
		return lifeEventDao.getPageList(page, criteria);
	}

	@Override
	public int batchSave(List<PersonDeathRecord> records) {
		return lifeEventDao.batchInsert(records);
	}

	@Transactional
	@Override
	public String Cancel(CurrentLoginInfo loginInfo,String ip) {
		Criteria criteria = new Criteria();
		criteria.add("cancelStatus", "0");
		List<PersonDeathRecord> pdrs = lifeEventDao.getList(criteria);
		if(pdrs == null || pdrs.size() == 0) return null;
		List<String> idcards = new ArrayList<String>();
		for(PersonDeathRecord pdr : pdrs){
			pdr.setCancelStatus("1");
			if (null == pdr.getIdcard()) {
				log.error("生命事件-》注销身份证号不能为空!");
				continue;
			} else{
				idcards.add(pdr.getIdcard());
			}
		}
		lifeEventDao.batchUpdate(pdrs,"cancelStatus");
		String result = personCanceledService.cancelPersonByIdcard(loginInfo, ip);
		return result;
	}
	/**
     * 获取死亡最高的前十种病
     * @return
     */
    public List<PersonDeathRecord> getTopTenDeath(Criteria criteria) {
    	return lifeEventDao.getTopTenDeath(criteria);
    }
    
    /**
     * 统计死于最高的前十种病的人口数目
     * @param criteria
     * @return
     */
    public List<PersonDeathRecord> getDeathICD10TargetList(Criteria criteria){
    	//按市级医院（一个市级医院一条数据）、按卫生院（一个卫生院一条数据）、按镇（一个镇一条数据）
    	return lifeEventDao.getDeathICD10TargetList(criteria);
    }

	@Override
	@Transactional
	public String activePersonRecord(Long personRecordId,String filingFlag) {
		Integer result = 0;
		PersonDeathRecord personDeathRecord = lifeEventDao.get(personRecordId);
		if(ObjectUtil.isNotEmpty(personDeathRecord)){
			personDeathRecord.setCancelStatus(String.valueOf(EHRConstants.AUDIT));
			result = lifeEventDao.update(personDeathRecord,"cancelStatus");
			Long personId = personDeathRecord.getPersonId();
			personalRecordManagmentService.activePersonRecord(personId, filingFlag);
		}
		return result.toString();
	}

	@Transactional
	public int batchSave(List<PersonDeathRecord> personDeathRecords, List<DeathMedicineCertificate> deathMedicineCertificates, List<ChildDeath> childDeaths, List<MaternalDeath> maternalDeaths) {
		createPerson(personDeathRecords);
		int result  = lifeEventDao.batchInsert(personDeathRecords);
		deathMedicineCertificateDao.batchInsert(deathMedicineCertificates);
		childDeathDao.batchInsert(childDeaths);
		maternalDeathDao.batchInsert(maternalDeaths);
		return result;
	}
	/**
	 * 生命事件导入，导入区域档案不存在的记录,创建健康档案
	 * @param personDeathRecords
	 */
	private void createPerson(List<PersonDeathRecord> personDeathRecords){
		for(PersonDeathRecord personDeathRecord:personDeathRecords){
			String result = "";
			PersonInfo personInfo = platformService.queryPersonalInfo(null, personDeathRecord.getIdcard());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				personInfo = new PersonInfo();
				personInfo.setName(personDeathRecord.getName());
				personInfo.setIdcard(personDeathRecord.getIdcard());
				personInfo.setFilingFlag(EHRConstants.UN_CREATE);

				personInfo.setInputOrganCode(personDeathRecord.getInputOrgancode());
				personInfo.setInputDate(new Date());
				// end add
				result =platformService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, true);
				personDeathRecord.setPersonId(NumberUtil.convert(result,Long.class));
			}else{
				personDeathRecord.setCancelStatus(personInfo.getFilingFlag().equals(EHRConstants.HAD_OFF)?"1":"0");
				personDeathRecord.setPersonId(personInfo.getId());
			}
		}

	}

	@Override
	public List<Map<String, Object>> getDeathICD10MapList(Criteria ca) {
		return lifeEventDao.getDeathICD10MapList(ca);
	}

	@Override
	public List<Map<String, Object>> getPersonTypeMapList(Criteria ca) {
		return lifeEventDao.getPersonTypeMapList(ca);
	}
}
