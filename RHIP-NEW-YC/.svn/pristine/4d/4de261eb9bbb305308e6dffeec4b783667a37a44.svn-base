package com.founder.rhip.portal.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.PortalSetType;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.SmsRecord;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.ehr.repository.portal.IAccountInfoDao;
import com.founder.rhip.ehr.repository.portal.IFrequentContactsDao;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IOutClinicDao;
import com.founder.rhip.ehr.repository.portal.IOutDoctorDao;
import com.founder.rhip.ehr.repository.portal.IRegisterScheduleDao;
import com.founder.rhip.ehr.repository.portal.IRegisterScheduleTimeDao;
import com.founder.rhip.ehr.repository.portal.IReserveRegisterDao;
import com.founder.rhip.ehr.repository.portal.ISmsRecordDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.portal.service.util.Axis2Util;
import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.SMSUtil;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("reserveService")
@TaskBean(cron = "0 0 23 * * ?", description = "处理逾期未到诊的情况及超3次的用户既禁止预约")
public class ReserveServiceImpl extends AbstractService implements IReserveService, Task {

	private static final Object YYHospitalCode = "001";

	@Autowired
	private IOutClinicDao outClinicDao;

	@Autowired
	private IOutDoctorDao outDoctorDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IReserveRegisterDao reserveRegisterDao;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Autowired
	private IRegisterScheduleService registerScheduleService;

	@Autowired
	private IRegisterScheduleDao registerScheduleDao;
	
	@Autowired
	private IRegisterScheduleTimeDao registerScheduleTimeDao;

	@Resource(name = "lhhospitalInfoService")
	private IHospitalInfoService hospitalInfoService;

	@Resource(name = "lhFrequentContactsDao")
	private IFrequentContactsDao lhFrequentContactsDao;
//	@Resource(name = "platformService")
//	private IPlatformService personService;

	@Autowired
	private IAccountInfoDao accountInfoDao;
	
	@Autowired
	private IHospitalInfoDao hospitalInfoDao;
	
	@Resource(name = "portalSetService")
    private IPortalSetService portalSetService;
	
	@Resource(name = "smsRecordDao")
	private ISmsRecordDao smsDao;
	
	protected static Logger log = Logger.getLogger(ReserveServiceImpl.class);
	
	@Override
	public List<HospitalInfo> getOutHospitals() {
		List<String> hospitalCodes = outClinicDao.getOutHospitalCode();
		if (ObjectUtil.isNullOrEmpty(hospitalCodes)) {
			return null;
		}
		String[] hospitalCodeArray = new String[hospitalCodes.size()];
		hospitalCodeArray = hospitalCodes.toArray(hospitalCodeArray);
		Criteria criteria = new Criteria("hospitalCode", OP.IN, hospitalCodeArray);
		List<RegisterSchedule> registerScheduleList = registerScheduleDao.getDisHosRegisterScheduleList(criteria);
		List<HospitalInfo> hospitalInfoList = new ArrayList<HospitalInfo>();
		for (int i = 0; i < registerScheduleList.size(); i++) {
			HospitalInfo hospitalInfo = hospitalInfoDao.get(new Criteria("hospitalNo", registerScheduleList.get(i).getHospitalCode()));
			if (ObjectUtil.isNotEmpty(hospitalInfo)) {
				hospitalInfoList.add(hospitalInfo);
			}
		}
		return hospitalInfoList;
	}

	@Override
	public List<OutClinic> getOutClinics(Criteria criteria) {
//		List<OutClinic> outClinic = outClinicDao.getList(criteria);
		List<OutClinic> outClinic = outClinicDao.getReserveableClinics(criteria);
		return outClinic;
	}

	@Override
	public OutClinic getOutClinic(Criteria criteria) {
		OutClinic outClinic = outClinicDao.get(criteria);
		return outClinic;
	}

	@Override
	public List<OutDoctor> getOutDoctors(Criteria criteria) {
		List<OutDoctor> outDoctors = outDoctorDao.getList(criteria);
		return outDoctors;
	}

	@Override
	public List<OutDoctor> getHosInfosByDoctor(Criteria criteria) {
		List<OutDoctor> outDoctors = outDoctorDao.getHosInfosByDoctor(criteria);
		return outDoctors;
	}
	
	@Override
	public OutDoctor getOutDoctor(Criteria criteria) {
		OutDoctor outDoctor = outDoctorDao.get(criteria);
		return outDoctor;
	}

	@Override
	public PageList<OutClinic> getPageOutClinic(Page page, Criteria criteria) {
		PageList<OutClinic> outClinic = outClinicDao.getPageList(page, criteria);
		return outClinic;
	}

	@Override
	public PageList<ReserveRegister> getReserveRegister(Criteria criteria, Page page) {
		Order order = new Order("SUBMIT_DATE", false);
		order.desc("ID");
		PageList<ReserveRegister> peserveRegisters = reserveRegisterDao.getPageList(page, criteria, order);
		return peserveRegisters;
	}

	@Override
	public ReserveRegister getReserveRegisterByIdCard(String idcard) {
		Criteria criteria = new Criteria("idcard", idcard);
		List<ReserveRegister> reserveRegisters = getReserveRegisters(criteria);
		if (ObjectUtil.isNotEmpty(reserveRegisters)) {
			return reserveRegisters.get(0);
		}
		return null;
	}

	@Override
	public List<ReserveRegister> getReserveRegisters(Criteria criteria) {
		Order order = new Order("REQUEST_DATE", false);
		List<ReserveRegister> peserveRegisters = reserveRegisterDao.getList(criteria, order);
		return peserveRegisters;
	}

	/**
	 * 返回数据
	 * 
	 * @param regId
	 * @return HashMap 里面包含预约信息，挂号者信息，患者信息的MAP KEY reserveRegister,submitUser
	 */
	@Override
	public ReserveRegister getReserveRegister(Long regId) {
		ReserveRegister reserveRegister = reserveRegisterDao.get(regId);

		if (ObjectUtil.isNullOrEmpty(reserveRegister)) {
			return null;
		}
		reserveRegister.setSubmitUserName(reserveRegister.getName());
		/**
		 * 如果是患者自己提交的预约，提交机构就为空
		 * */
		if (ObjectUtil.isNotEmpty(reserveRegister.getSubmitOrg())) {
			Long userId = reserveRegister.getSubmitUser();
			User user = userDao.get(userId);
			reserveRegister.setSubmitUserName(user.getName());
		}
		return reserveRegister;
	}

	/**
	 * 取消预约挂号
	 * 
	 * @param regId
	 * @return
	 */
	@Override
	@Transactional
	public String cancelRegister(ReserveRegister reserveRegister) {
		String reserveStauts = reserveRegister.getReserverStauts();
		if (Axis2Util.commonMethods(reserveRegister.getHospitalCode())) {
			if (ReserveStauts.SWDZ.getStauts().equals(reserveStauts)) {
				reserveRegister.setReserverStauts(ReserveStauts.QX.getStauts());
				reserveRegisterDao.update(reserveRegister);
				// 判断是否发送短信，将短信内容存入库中
				sendSMS(reserveRegister, SMSUtil.MODE_TYPE_4);
				return EHRConstants.CANCEL_OK;
			}
		} else {
			if (ReserveStauts.SWDZ.getStauts().equals(reserveStauts)) {
				reserveRegister.setReserverStauts(ReserveStauts.QX.getStauts());
				RegisterScheduleTime registerScheduleTime = registerScheduleTimeDao.get(new Criteria("id", reserveRegister.getRegisterScheduleTimeId()));

				if (ObjectUtil.isNotEmpty(registerScheduleTime) && registerScheduleTime.getReserveNum() > 0) {
					registerScheduleTime.setReserveNum(registerScheduleTime.getReserveNum() - 1);
				}
				reserveRegisterDao.update(reserveRegister);
				registerScheduleTimeDao.update(registerScheduleTime);
				// 判断是否发送短信，将短信内容存入库中
				sendSMS(reserveRegister, SMSUtil.MODE_TYPE_4);
				return EHRConstants.CANCEL_OK;
			}
		}
		return ReserveStauts.getByStauts(reserveStauts).getDescription();
	}

	// @Override
	// public PersonInfo savePersonInfo(PersonInfo p){
	// Long personId = p.getId();
	//
	// if(ObjectUtil.isNullOrEmpty(personId)){
	// String pId = personService.createPerson(p, EHRConstants.RETURN_PERSON_ID,
	// false);
	// if(pId != null){
	// p.setId(Long.parseLong(pId));
	// }
	// return p;
	// }
	//
	// personService.updatePersonInfo(p,
	// "name","birthday","gender","unitName","updateName","updateOrganCode",
	// "phoneNumber","idcardHos","idcardFarm","patownShip","pastreet","pahouseNumber");
	// return p;
	// }

	/**
	 * @return RESULT_FULL 已挂满 RESULT_REPEAT 重复预约 RESULT_OVER 次数超过限制 RESULT_OK
	 *         预约成功
	 */
	@Override
	@Transactional
	public synchronized String saveReserveRegister(PersonInfo p, Long scheduleId, Long scheduleTimeId,String submitOrg, Long submitUser, String regFrom) {
		ReserveRegister reserveRegister = createReserveRegister(p, submitOrg, submitUser, regFrom);
		String id= saveReserveRegister(reserveRegister, scheduleId, scheduleTimeId);
		// 判断是否保存成功，将发送短信
		if(NumberUtil.isDecimal((id))){
			sendSMS(reserveRegister, SMSUtil.MODE_TYPE_1);
		}
		return id;
	}
	
	@Override
	public  String saveReserveRegister(ReserveRegister reserveRegister, Long scheduleId, Long scheduleTimeId) {
		RegisterSchedule registerSchedule = registerScheduleService.getRegisterSchedule(new Criteria("id", scheduleId));
		RegisterScheduleTime registerScheduleTime = null;
		if(scheduleTimeId!=null)
			registerScheduleTime = registerScheduleTimeDao.get(new Criteria("id", scheduleTimeId));
		buildSchedule(reserveRegister, registerSchedule, registerScheduleTime);
		if (ObjectUtil.isNotEmpty(registerScheduleTime)) {
			if (registerScheduleTime.isFull()) {
				return EHRConstants.RESULT_FULL;
			}
		}

		if (checkRepeat(reserveRegister)) {
			return EHRConstants.RESULT_REPEAT;
		}

		if (checkCount(reserveRegister, 3)) {
			return EHRConstants.RESULT_OVER;
		}
		//不可预约当天号源。
		Date reqDate = reserveRegister.getRequestDate();
		Date today = DateUtil.makeTimeToZero(new Date());
		if(reqDate==null){
			//预约资源时间字段为null
			return EHRConstants.RESULT_FAIL;
		}
		reqDate =DateUtil.makeTimeToZero(reqDate);
		//禁止预约今天及之前的资源。
		if(today.equals(reqDate)||today.after(reqDate)){
			return EHRConstants.RESULT_FAIL;
		}	
		String rs= doReserveRegister(reserveRegister, scheduleTimeId);
		if(rs==null)
			return EHRConstants.RESULT_FAIL;
		//
		return rs;
	}

    
	/**
	 * 执行预约操作
	 * 
	 * @param reserveRegister
	 * @param scheduleTimeId
	 * @return
	 */
	private String doReserveRegister(ReserveRegister reserveRegister, Long scheduleTimeId) {
		//更新预约资源已预约人数字段
		int rs = registerScheduleTimeDao.updateRegisterScheduleTime(scheduleTimeId);
		//判断是否更新成功
		if (rs<=0)
			return null;
		Long id  =reserveRegisterDao.generatedKey(reserveRegister, "ID", null).longValue();
		return id.toString();
	}

	private String getSearchCode() {
		int length = 12;
		String k = "";
		for (int i = 0; i < length; i++) {
			int temp = (int) (Math.random() * 9);
			k = k + temp;
		}
		return k;
	}

	/**
	 * 组装数据
	 * 
	 * @param p
	 * @param submitOrg
	 * @return
	 */
	private ReserveRegister createReserveRegister(PersonInfo p, String submitOrg, Long submitUser, String regFrom) {
		ReserveRegister reserveRegister = new ReserveRegister();
		reserveRegister.setPhoneNumber(p.getPhoneNumber());
		reserveRegister.setIdcard(p.getIdcard());
		reserveRegister.setIdcardFarm(p.getIdcardFarm());
		reserveRegister.setIdcardArchives(p.getIcdcardArchives());
		reserveRegister.setIdcardHos(p.getIdcardHos());
		reserveRegister.setName(p.getName());
		reserveRegister.setGender(p.getGender());
		reserveRegister.setSubmitOrg(submitOrg);
		reserveRegister.setSubmitUser(submitUser);
		reserveRegister.setBirthday(p.getBirthday());
		reserveRegister.setUnitName(p.getUnitName());
		reserveRegister.setPatownShip(p.getPatownShip());
		reserveRegister.setPastreet(p.getPastreet());
		reserveRegister.setRegFrom(regFrom);
		reserveRegister.setPahouseNumber(p.getPahouseNumber());
		reserveRegister.setAccountId(submitUser);
        try {
            addRequiredInfo(reserveRegister,p);
        } catch (Exception e) {
           log.error("设置电话,性别,生日时出错",e);
        }
        return reserveRegister;
	}

	
    private void addRequiredInfo(ReserveRegister reserveRegister, PersonInfo p) {
        String idcard = p.getIdcard();
        if (ObjectUtil.isNotEmpty(idcard)) {
            if (ObjectUtil.isNullOrEmpty(reserveRegister.getPhoneNumber())) {
                AccountInfo info = accountInfoDao.get(new Criteria("cardNo", idcard), "telephone");
                if (null != info) {
                    p.setPhoneNumber(info.getTelephone());
                    reserveRegister.setPhoneNumber(info.getTelephone());
                }
            }
            // 根据身份证获取性别
            if (ObjectUtil.isNullOrEmpty(reserveRegister.getGender())) {
                reserveRegister.setGender(IDCardUtil.getGenderByIdCard(idcard));
                p.setGender(reserveRegister.getGender());
            }

            // 根据身份证获取生日
            if (ObjectUtil.isNullOrEmpty(reserveRegister.getBirthday())) {
                reserveRegister.setBirthday(IDCardUtil.getBirthDateByIdCard(idcard));
                p.setBirthday(reserveRegister.getBirthday());
            }
        }
    }

	private void buildSchedule(ReserveRegister reserveRegister, RegisterSchedule registerSchedule, RegisterScheduleTime registerScheduleTime) {
		reserveRegister.setAmpm(registerSchedule.getAmpm());
		reserveRegister.setClinicType(registerSchedule.getClinicType());
		reserveRegister.setDeptSn(registerSchedule.getDeptSn());
		reserveRegister.setDoctorSn(registerSchedule.getDoctorSn());
		reserveRegister.setHospitalCode(registerSchedule.getHospitalCode());
		reserveRegister.setRequestDate(registerSchedule.getRequestDate());
		reserveRegister.setSubmitDate(new Date());
		reserveRegister.setReserverStauts(ReserveStauts.SWDZ.getStauts());
		reserveRegister.setHospitalName(registerSchedule.getHospitalName());
		reserveRegister.setDeptName(registerSchedule.getDeptName());
		reserveRegister.setDoctorName(registerSchedule.getDoctorName());
		reserveRegister.setRegisterFee(registerSchedule.getRegisterFee());
		reserveRegister.setSearchCode(getSearchCode());
		reserveRegister.setTimeIntervalStart(StringUtils.trimToEmpty(registerScheduleTime.getTimeIntervalStart()));
		reserveRegister.setTimeIntervalEnd(StringUtils.trimToEmpty(registerScheduleTime.getTimeIntervalEnd()));
		reserveRegister.setTakeNoTimeStart(StringUtils.trimToEmpty(registerScheduleTime.getTakeNoTimeStart()));
		reserveRegister.setTakeNoTimeEnd(StringUtils.trimToEmpty(registerScheduleTime.getTakeNoTimeEnd()));
		reserveRegister.setRegisterScheduleTimeId(String.valueOf(registerScheduleTime.getId()));
	}

	/**
	 * 判断是否已约此号，为TRUE表名已经预约
	 * 
	 * @param reserveRegister
	 * @return
	 */
	private boolean checkRepeat(ReserveRegister reserveRegister) {
		Criteria criteria = new Criteria();
		criteria.add("idcard", reserveRegister.getIdcard());
		criteria.add("ampm", reserveRegister.getAmpm());
		// criteria.add("clinicType", reserveRegister.getClinicType());
		criteria.add("deptSn", reserveRegister.getDeptSn());
		criteria.add("hospitalCode", reserveRegister.getHospitalCode());
		criteria.add("requestDate", reserveRegister.getRequestDate());
		criteria.add("reserverStauts", ReserveStauts.SWDZ.getStauts());
		ReserveRegister register = reserveRegisterDao.get(criteria);
		if (ObjectUtil.isNotEmpty(register)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断今天已约几个号
	 * 
	 * @param reserveRegister
	 * @param count
	 * @return true 表示预约数超过限制，false表示验证通过
	 */
	private boolean checkCount(ReserveRegister reserveRegister, int count) {
		Criteria criteria = new Criteria();
		criteria.add("idcard", reserveRegister.getIdcard());
		Date submitDateBegin = DateUtil.makeTimeToZero(new Date());
		DateUtil.getCriteriaByDateRange(criteria, "submitDate", submitDateBegin, submitDateBegin);
		List<ReserveRegister> registers = reserveRegisterDao.getList(criteria);

		if (ObjectUtil.isNullOrEmpty(registers)) {
			return false;
		}

		if (registers.size() < count) {
			return false;
		}
		return true;
	}

	/**
	 * @Title: overDate
	 * @Description: 处理逾期未到诊的情况,超过3次用户既禁止预约
	 * @param
	 * @return void
	 * @throws
	 */
	@Override
	// @Scheduled(cron = "0 0 23 * * ?")
	public void overDate() {
		Date date = DateUtil.getToday().getTime();
		Criteria criteria = new Criteria("REQUEST_DATE", OP.LT, date);
		criteria.add("RESERVER_STAUTS", ReserveStauts.SWDZ.getStauts());

		Parameters parameters = new Parameters("RESERVER_STAUTS", ReserveStauts.YQWDZ.getStauts());
		List<ReserveRegister> rs = reserveRegisterDao.getList(criteria);
		reserveRegisterDao.update(parameters, criteria);
		for(ReserveRegister rt:rs){	
		List<ReserveRegister> list = reserveRegisterDao.getList(new Criteria("RESERVER_STAUTS",ReserveStauts.YQWDZ.getStauts()).add("IDCARD",rt.getIdcard()), new Order("REQUEST_DATE",false));
			if(!list.isEmpty()&&list.size()>0&&list.size()%3 ==0)
			{
				ReserveRegister register = list.get(0);
				String requestDate =DateUtil.toDateString(register.getRequestDate(), "dd-MMM-yyyy");
				String yestoday=DateUtil.toDateString(DateUtil.add(date, Calendar.DATE, -1), "dd-MMM-yyyy");
				if(yestoday.equals(requestDate)){
					int cnt = accountInfoDao.update(new Parameters("RESERVE_STATUS", ReserveStauts.CANNOT.getStauts()),new Criteria("CARD_NO",rt.getIdcard()));
					lhFrequentContactsDao.update(new Parameters("RESERVE_STATUS", ReserveStauts.CANNOT.getStauts()),new Criteria("CARD_NO",rt.getIdcard()));
				}
			}
		}
	}

	@Override
	public void run(Map<String, Object> data) {
		overDate();
	}

	@Override
	public List<ReserveRegister> getRegisterTargetList(Criteria criteria) {
		return reserveRegisterDao.getRegisterTargetList(criteria);
	}

	@Override
	public List<RegisterScheduleTime> getRegisterScheduleTimeLists(Criteria criteria) {
		return registerScheduleTimeDao.getList(criteria);
	}

	@Override
	public List<OutClinic> getOutClinicList(Criteria criteria) {
		return outClinicDao.getList(criteria);
	}
	
	/***
	 * 平台预约成功发送短信
	 * @param reserveRegister
	 */
	public void sendSMS(ReserveRegister reserveRegister,String modeType) {
		HashMap<String,String> map = portalSetService.getSetByType(PortalSetType.SMS_CONF.getValue());
		String smsEnable=null;
		if(SMSUtil.MODE_TYPE_1.equals(modeType)){
			smsEnable=map.get(Constants.PORTAL_RESERVE_SEND);
			if(smsEnable==null){
				log.warn("预约短信发送开关未正确配置，请在健康门户=>门户设置中短信接口配置portal_reserve_send的值true or false!");
				return;
			}
			//判断预约短信通知开关开启
			if(!"TRUE".equals(smsEnable.toUpperCase()))
			{
				log.warn("预约短信发送开关未开启，如需开启请在健康门户=>门户设置中短信接口配置portal_reserve_send的值true!");
				return;
			}
		}
		else if(SMSUtil.MODE_TYPE_4.equals(modeType)){
			smsEnable=map.get(Constants.PORTAL_CANCEL_SEND);
			if(smsEnable==null){
				log.warn("取消预约短信发送开关未正确配置，请在健康门户=>门户设置中短信接口配置portal_cancel_send的值true or false!");
				return;
			}
			//判断预约短信通知开关开启
			if(!"TRUE".equals(smsEnable.toUpperCase()))
			{
				log.warn("取消预约短信发送开关未开启，如需开启请在健康门户=>门户设置中短信接口配置portal_cancel_send的值true!");
				return;
			}
		}
		else{
			log.warn("短信发送模式未能正确匹配，请检查sendSMS(ReserveRegister reserveRegister,String modeType)的参数modeType");
			return;
		}
		Map<String,String> smsMap = new HashMap<String,String>();
		smsMap.put("NAME",reserveRegister.getName());
		smsMap.put("HOSPITAL",reserveRegister.getHospitalName());
		smsMap.put("HOSPITAL_CODE",reserveRegister.getHospitalCode());
		smsMap.put("DEPT_NAME",reserveRegister.getDeptName());
		smsMap.put("DOCTOR_NAME",reserveRegister.getDoctorName());
		smsMap.put("TIME",DateUtil.getDateTime("yyyy年MM月dd日",reserveRegister.getRequestDate()));
		smsMap.put("AMPM",reserveRegister.getAmpm());
		smsMap.put("TIME_INTERVAL_START",reserveRegister.getTimeIntervalStart().trim());
		smsMap.put("TIME_INTERVAL_END",reserveRegister.getTimeIntervalEnd().trim());
		/*smsMap.put("TAKE_NO_TIME_START",reserveRegister.getTakeNoTimeStart().trim());
		smsMap.put("TAKE_NO_TIME_END",reserveRegister.getTakeNoTimeEnd().trim());*/
		smsMap.put("SEARCH_CODE",reserveRegister.getSearchCode());
		SMSUtil smsUtil=new SMSUtil();
		String content=smsUtil.createSMSContent(smsMap,modeType);
//		if(smsUtil.isPortal_reserve_send())
		String rs="";
		rs = smsUtil.send(content, reserveRegister.getPhoneNumber());
		if("Success".equals(rs)){
			SmsRecord sms=new SmsRecord();
			sms.setContent(content);
			sms.setName(reserveRegister.getName());
			sms.setPhoneNumber(reserveRegister.getPhoneNumber());
			sms.setType(modeType);
			sms.setCreateTime(new Date());
			smsDao.insert(sms);
		}
	}

	@Override
	public List<RegisterSchedule> getDeptName(Criteria criteria) {
		return registerScheduleDao.getDeptName(criteria);
	}

	@Override
	public List<RegisterSchedule> getHosByDeptName(Criteria deptSnCriteria) {
		return registerScheduleDao.getHosByDeptName(deptSnCriteria);
	}

	@Override
	public PageList<ReserveRegister> getResRegByFreContacts(Long accountId,Criteria criteria,
			Page page) {
		return reserveRegisterDao.getResRegByFreContacts(accountId,criteria,page);
	}

}
