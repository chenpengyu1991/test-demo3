package com.founder.rhip.ehr.service.personal.impl;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.rhip.ehr.repository.basic.ILifeEventDao;
import com.founder.rhip.ehr.repository.basic.IPersonCanceledDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.control.IDeathMedicineCertificateDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.IPersonCancelListener;
import com.founder.rhip.ehr.service.personal.IPersonCanceledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("personCanceledInfoService")
public class PersonCanceledInfoServiceImpl extends AbstractService implements IPersonCanceledService {

	@Resource(name = "personCanceledInfoDao")
	private IPersonCanceledDao personCanceledInfoDao;
	
	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;
	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Autowired(required = false)
	private List<IPersonCancelListener> personCancelListener;

	@Resource(name = "lifeEventDao")
	private ILifeEventDao lifeEventDao;
	
	@Resource(name = "deathMedicineCertificateDao")
	private IDeathMedicineCertificateDao deathMedicineCertificateDao;

	@Override
	public PageList<PersonCanceledInfo> getPersonCanceledList(Criteria criteria, Page page, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonCanceledInfo> getCancelPersonRecords(Criteria criteria, Order order) {
		return personCanceledInfoDao.getList(criteria, order);
	}

	/**
	 * 审核个人档案
	 * 
	 */

	@Transactional
	public Integer approveCancelPerson(String status, PersonCanceledInfo personCanceledInfo) {
		Integer result = 0;
		Long personId = Long.valueOf(personCanceledInfo.getPersonId());
		result = setPersonStatus(status, personId);
		if (result > 0 && EHRConstants.HAD_BACK.equals(status)) {
			personCanceledInfoDao.update(personCanceledInfo, "rejectedReason");
		} else {
			personCancel(personCancelListener, personId);
			personCanceledInfo.setCanceledStatus(EHRConstants.CANCELED);
			personCanceledInfoDao.update(personCanceledInfo, "canceledStatus");
			// 档案注销时间
			Parameters parameters = new Parameters();
			parameters.add("LOGOUT_DATE", new Date());
			personInfoDao.update(parameters, new Criteria("id", personId));
		}
		return result;
	}

	/**
	 * 注销个人档案
	 * 
	 */
	@Transactional
	public int offPersonCanceled(String status, PersonCanceledInfo personCanceledInfo) {
		Integer result = 0;
		// 档案注销
		result = personCanceledInfo.getId() != null ? personCanceledInfoDao.update(personCanceledInfo) : personCanceledInfoDao.insert(personCanceledInfo);
		if (result > 0) {
			Long personId = Long.valueOf(personCanceledInfo.getPersonId());
        	setPersonStatus(status, personId);
			setPhysicalExamRecordStatus(status, personId);
			personCancel(personCancelListener, personId);
			//插入死亡医学证明死亡登记记录 并审批通过
			if(personCanceledInfo.getCanceledReason().equals("1")){
				DeathMedicineCertificate dmc = deathMedicineCertificateDao.get(new Criteria("idcard",personCanceledInfo.getIdCard()));
				if(ObjectUtil.isNotEmpty(dmc)){
					dmc.setCancelStatus("1");
					dmc.setDeathReason(personCanceledInfo.getOtherReason());
					dmc.setDeathDate(personCanceledInfo.getCanceledReasonDate());
					dmc.setInputDate(personCanceledInfo.getCanceledDate());
					deathMedicineCertificateDao.update(dmc,  "inputDate","deathReason","deathDate","cancelStatus");
				}else{
					deathMedicineCertificateDao.insert(setDeathMedicineCertificate(personCanceledInfo,personInfoDao.get(personId)));
				}
				
			}
			
			
		}
		return result;
	}
	private DeathMedicineCertificate setDeathMedicineCertificate(PersonCanceledInfo personCanceledInfo, PersonInfo personInfo){
		DeathMedicineCertificate dmc = new DeathMedicineCertificate();
		dmc.setHealthFileNo(personInfo.getHealthFileNo());
		dmc.setBirthday(personInfo.getBirthday());
		dmc.setEducation(personInfo.getEducation());
		dmc.setGender(personInfo.getGender());
		dmc.setMarriage(personInfo.getMarriage());
		dmc.setNation(personInfo.getNation());
		dmc.setOccupation(personInfo.getOccupation());
		dmc.setPahouseNumber(personInfo.getPahouseNumber());
		dmc.setPaGroup(personInfo.getPaGroup());
		dmc.setPastreet(personInfo.getPastreet());
		dmc.setPatownShip(personInfo.getPatownShip());
		dmc.setPersonId(personInfo.getId());
		dmc.setName(personCanceledInfo.getPersonName());
		dmc.setIdcard(personCanceledInfo.getIdCard());
		dmc.setDeathDate(personCanceledInfo.getCanceledReasonDate());
		dmc.setIsDelete(0);
		dmc.setFillOrganCode(personCanceledInfo.getCanceledOrganCode());
		dmc.setFillOrganName(personCanceledInfo.getCanceledOrganName());
		dmc.setFillTime(personCanceledInfo.getCanceledDate());
		dmc.setFillUserName(personCanceledInfo.getCanceledName());
		dmc.setInputDate(personCanceledInfo.getCanceledDate());
		dmc.setInputerId(personCanceledInfo.getCanceledIp());
		dmc.setInputName(personCanceledInfo.getCanceledName());
		dmc.setCancelStatus("1");
		dmc.setDeathReason(personCanceledInfo.getOtherReason());
		return dmc;
	}

	private void setPhysicalExamRecordStatus(String status, Long personId){
		
		PhysicalExamRecord examRecord=physicalExamRecordDao.get(new Criteria("personId", personId));
		if(examRecord!=null){
			examRecord.setPersonId(personId);
			examRecord.setLogoff(Integer.parseInt("1"));
			physicalExamRecordDao.update(examRecord);
		}
		
	}
	
	// 更新Person的状态
	private int setPersonStatus(String status, Long personId) {
		// //将PersonInfo对象的
		String [] properties = new String[]{"filingFlag"};
		PersonInfo personInfo = new PersonInfo();
		personInfo.setId(personId);
		personInfo.setFilingFlag(status);
		//如果是注销，则写入注销时间， modify by yejianfei 20180410
		if(EHRConstants.HAD_OFF.equals(status)){
			personInfo.setLogoutDate(new Date());
			properties = new String[]{"filingFlag","logoutDate"};
		}
		return personInfoDao.update(personInfo, properties);
	}

	// @Override
	// public PersonCanceledInfo offPersonCanceled(IValidateDTO
	// personCanceledInfoTemp) {
	// //更新人员基本信息
	// PersonRecordOffDTO personRecordOff =
	// (PersonRecordOffDTO)personCanceledInfoTemp;
	// PersonCanceledInfo pci = personRecordOff.getPersonCanceledInfo();
	// PersonInfo pi = personRecordOff.getPersonInfo();
	// //更新人员信息
	// pi.setFilingFlag(EHRConstants.HAD_OFF);
	// personInfoDao.update(pi, "filingFlag");
	// //插入信息
	// Long id = personCanceledInfoDao.generatedKey(pci, "ID",
	// null).longValue();
	// pci.setId(id);
	// return pci;
	// }

	// 调用实现IPersonCancelListener的类的cancelPerson方法
	private void personCancel(List<IPersonCancelListener> personCancelListener, Long personId) {
		if (ObjectUtil.isNotEmpty(personCancelListener)) {
			PersonInfo p = personInfoDao.get(personId);
			if (ObjectUtil.isNotEmpty(p)) {
				for (IPersonCancelListener iPersonCancelListener : personCancelListener) {
					iPersonCancelListener.cancelPerson(p.getId(), p.getSmpiId());
				}
			}
		}
	}

	/**
	 * 注销档案列表
	 */
	@Override
	public PageList<PersonCanceledInfo> getCancelPersonRecordPageList(Criteria criteria, Page page, Order order) {
		String[] properties = {"id","personId", "personName", "canceledReason", "remark", "canceledName", "canceledOrganName","canceledReasonDate","canceledDate", "idCard","canceledIp" };
		PageList<PersonCanceledInfo> PersonCanceles = personCanceledInfoDao.getPageList(page, criteria, order, properties);
		return PersonCanceles;
	}

	/**
	 * 获取档案注销的详情
	 * @param criteria
	 * @return
	 */
	public PersonCanceledInfo getPersonCanceledInfo(Criteria criteria) {
		return personCanceledInfoDao.get(criteria);
	}
	@Transactional
	@Override
	public void cancelPersonByIdcard(String idcard) {
		if (null == idcard) {
			log.error("身份证号不能为空:");
			return;
		}

		PersonInfo personInfo = personInfoDao.get(new Criteria("idcard", idcard));
		if (null == personInfo) {
			log.error("该身份证号没有相关的档案:".concat(idcard));
			return;
		}

        //如果已经是注销状态,则不处理
        if(EHRConstants.HAD_OFF.equals(personInfo.getFilingFlag())){
            log.info("该身份证号关联档案已经注销::".concat(idcard));
            return;
        }

		Date now = new Date();

		// 注销信息
		PersonCanceledInfo personCanceledInfo = new PersonCanceledInfo();
		personCanceledInfo.setPersonId(personInfo.getId());
		personCanceledInfo.setIdCard(idcard);
		personCanceledInfo.setPersonName(personInfo.getName());
		personCanceledInfo.setCanceledDate(now);
		personCanceledInfo.setCanceledReason(EHRConstants.CANCEL_REASON_DEATH);// 死亡
		personCanceledInfo.setCanceledStatus(EHRConstants.CANCELED);
        //TODO 生命事件后修改
		personCanceledInfo.setRemark("死亡批量注销");
		personCanceledInfo.setCanceledOrganCode("FS-01");
		personCanceledInfo.setCanceledOrganName("卫生局");
		personCanceledInfo.setCanceledName("管理员");
		personCanceledInfo.setCanceledIdcard("");
		personCanceledInfoDao.insert(personCanceledInfo);

		// 档案状态修改为注销
		personInfo.setFilingFlag(EHRConstants.HAD_OFF);
		personInfo.setLogoutDate(now);
		personInfoDao.update(personInfo, "filingFlag", "logoutDate");

		// 通知其它模块
		if (ObjectUtil.isNotEmpty(personCancelListener)) {
			for (IPersonCancelListener iPersonCancelListener : personCancelListener) {
				iPersonCancelListener.cancelPerson(personInfo.getId(), personInfo.getSmpiId());
			}
		}
	}

	@Transactional
	@Override
	public String cancelPersonByIdcard(final CurrentLoginInfo loginInfo, final String ip) {
		
		final Criteria criteria= new Criteria("cancelStatus", "0");
		PageableDateSource.exec(new IDataSource<DeathMedicineCertificate>() {

			@Override
			public PageList<DeathMedicineCertificate> get(Page page) {
				return deathMedicineCertificateDao.getPageList(page, criteria);
			}

			@SuppressWarnings("unused")
			@Override
			public void run(List<DeathMedicineCertificate> list) {
				List<String> idcards = new ArrayList<String>();
				List<String> idcardsPersonInfo = new ArrayList<String>();
				for(DeathMedicineCertificate pdr : list){
					if (null == pdr.getIdcard()) {
						log.error("死亡管理-》结案身份证号不能为空!");
						continue;
					} else{
						idcards.add(pdr.getIdcard());
					}
				}
				List<PersonInfo> personInfoTemp = personInfoDao.getList(new Criteria("idcard", OP.IN, idcards));
				List<PersonInfo> personInfos = new ArrayList<PersonInfo>();
				List<PersonCanceledInfo> personCanceledInfos = new ArrayList<PersonCanceledInfo>();
				for(PersonInfo personInfo : personInfoTemp) {
					String idcard = personInfo.getIdcard();
					if (null == personInfo) {
						log.error("该身份证号没有相关的档案:".concat(idcard));
						continue;
					}
					idcardsPersonInfo.add(idcard);
			        //如果已经是注销状态,则不处理
			        if(EHRConstants.HAD_OFF.equals(personInfo.getFilingFlag())){
			            log.info("该身份证号关联档案已经结案::".concat(idcard));
			            continue;
			        }

					Date now = new Date();

					// 注销信息
					PersonCanceledInfo personCanceledInfo = new PersonCanceledInfo();
					personCanceledInfo.setPersonId(personInfo.getId());
					personCanceledInfo.setIdCard(idcard);
					personCanceledInfo.setPersonName(personInfo.getName());
					personCanceledInfo.setCanceledDate(now);
					personCanceledInfo.setCanceledReason("1");// 死亡
					//获取死亡证明上的死亡时间
					DeathMedicineCertificate deathMedicineCertificate=deathMedicineCertificateDao.get(new Criteria("IDCARD",idcard),"deathDate");
					personCanceledInfo.setCanceledReasonDate(deathMedicineCertificate==null?null:deathMedicineCertificate.getDeathDate());
					personCanceledInfo.setCanceledStatus(EHRConstants.CANCELED);
			        //TODO 生命事件后修改
					personCanceledInfo.setRemark("死亡批量结案");
					personCanceledInfo.setCanceledOrganCode(loginInfo.getOrganization().getOrganCode());
					personCanceledInfo.setCanceledOrganName(loginInfo.getOrganization().getOrganName());
					personCanceledInfo.setCanceledName(loginInfo.getUser().getUserName());
					personCanceledInfo.setCanceledIdcard(loginInfo.getUser().getIdentityCard());
					personCanceledInfo.setCanceledIp(ip);
					personCanceledInfos.add(personCanceledInfo);

					// 档案状态修改为注销
					personInfo.setFilingFlag(EHRConstants.HAD_OFF);
					personInfo.setLogoutDate(now);
					personInfos.add(personInfo);
				}
				//需要更改为注销的死亡人员
				List<DeathMedicineCertificate> updateList = deathMedicineCertificateDao.getList(new Criteria("idcard",OP.IN, idcardsPersonInfo));
				for(DeathMedicineCertificate d : updateList){
					d.setCancelStatus("1");
				}
				deathMedicineCertificateDao.batchUpdate(updateList,"cancelStatus");

				personCanceledInfoDao.batchInsert(personCanceledInfos);
				personInfoDao.batchUpdate(personInfos, "filingFlag", "logoutDate");
				// 通知其它模块
				if (ObjectUtil.isNotEmpty(personCancelListener)) {
					for (IPersonCancelListener iPersonCancelListener : personCancelListener) {
						for(PersonInfo personInfo : personInfos){
							iPersonCancelListener.cancelPerson(personInfo.getId(), personInfo.getSmpiId());
						}
					}
				}
			}
		});
		return null;
	}

	@Override
	public List<Map<String, Object>> exportCancelPersonRecordList(Page page,
                                                                  Criteria criteria, Order order) {
		PageList<Map<String,Object>> mapList = personCanceledInfoDao.exportPersonRecordList(page, criteria, order);
		
		if (null == mapList.getList()) {
			return Collections.emptyList();
		}
		return mapList.getList();
	}
}
