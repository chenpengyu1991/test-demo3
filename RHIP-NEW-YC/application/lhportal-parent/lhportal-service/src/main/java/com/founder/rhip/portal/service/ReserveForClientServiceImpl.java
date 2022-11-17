/**   
* @Title: ReserveHisServiceImpl.java 
* @Package com.founder.rhip.portal.service 
* @Description:预约和HIS交互的接口
* @author LJY
* @date 2013-8-8 下午2:26:34 
* @version V1.0   
*/
package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.ehr.repository.portal.*;
import com.founder.rhip.portal.dto.*;
import com.founder.rhip.portal.service.util.SMSUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/** 
 * @ClassName: ReserveHisServiceImpl 
 * @Description: 预约和HIS交互的接口
 * @author  LJY
 * @date 2013-8-8 下午2:26:34 
 *  
 */
@Service("reserveForClientService")
public class ReserveForClientServiceImpl implements IReserveForClientService {
	
	@Autowired
	private IOutClinicDao outClinicDao;
	
	@Autowired
	private IOutDoctorDao outDoctorDao;
	
	@Autowired
	private IRegisterScheduleDao registerScheduleDao;

	@Autowired
	private IRegisterScheduleTimeDao registerScheduleTimeDao;

	@Autowired
	private IReserveRegisterDao reserveRegisterDao;
	
	@Autowired
	private IReserveService reserveService;
	
	@Resource(name = "portalSetService")
    private IPortalSetService portalSetService;
	
	@Resource(name = "smsRecordDao")
	private ISmsRecordDao smsDao;
	
	
	@Override
	public String getClinicByType(GetYYAllDepartmentInfo getYYAllDepartmentInfo){
		Criteria criteria = new Criteria("OC.HOSPITAL_CODE",getYYAllDepartmentInfo.getHospitalCode());
		if(ObjectUtil.isNotEmpty(getYYAllDepartmentInfo.getClinicType())){
			criteria.add("RS.CLINIC_TYPE", getYYAllDepartmentInfo.getClinicType());
		}
		
		//查询的科室按照时间规则过滤  add by bagen at 2016-01-11 ↓
		String startViewReserveHour = portalSetService.getByCode("portal_reserve_view_end_time").split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode("portal_reserve_view_end_time").split("\\:")[1];
		Date requestDateBegin;
		Date requestDateEnd;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//查看后天以后的7天资源
			requestDateBegin = getRequestDateByTime(2);
			requestDateEnd = getRequestDateByTime(8);
		}else {
			//查看明天以后的7天资源
			requestDateBegin = getRequestDateByTime(1);
			requestDateEnd = getRequestDateByTime(7);
		}
		DateUtil.getCriteriaByDateRange(criteria, "RS.REQUEST_DATE", requestDateBegin, requestDateEnd);
		//查询的科室按照时间规则过滤  add by bagen at 2016-01-11 ↑
		List<OutClinic> outClinics = outClinicDao.getOutClinics(criteria);
		GetYYAllDepartmentInfoResponse getYYAllDepartmentInfoResponse = new GetYYAllDepartmentInfoResponse();
		getYYAllDepartmentInfoResponse.setOutClinics(outClinics);
		return XmlWebserviceForUtil.getString(getYYAllDepartmentInfoResponse, GetYYAllDepartmentInfoResponse.class);
	}


	@Override
	public String getScheduleByClinic(GetYYDoctorInfo getYYDoctorInfo) {
		Criteria criteria = new Criteria("ODR.HOSPITAL_CODE",getYYDoctorInfo.getHospitalCode());
		criteria.add("ODR.DEPT_SN", getYYDoctorInfo.getDeptSn());
		criteria.add("T.CLINIC_TYPE", getYYDoctorInfo.getClinicType());
		DateUtil.getCriteriaByDateRange(criteria, "T.REQUEST_DATE", getYYDoctorInfo.getStartDate(), getYYDoctorInfo.getEndDate());
		return getSchedule(criteria);
	}
	
	@Override
	public String getScheduleByDoctor(GetYYDoctorInfoByDoctor getYYDoctorInfoByDoctor) {
		Criteria criteria = new Criteria("ODR.HOSPITAL_CODE",getYYDoctorInfoByDoctor.getHospitalCode());
		criteria.add("ODR.DEPT_SN", getYYDoctorInfoByDoctor.getDeptSn());
		criteria.add("ODR.DOCTOR_SN", getYYDoctorInfoByDoctor.getDoctorSn());
		// 查询的科室按照时间规则过滤 add by bagen at 2016-01-20 ↓
		String startViewReserveHour = portalSetService.getByCode("portal_reserve_view_end_time").split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode("portal_reserve_view_end_time").split("\\:")[1];
		Date requestDateBegin;
		Date requestDateEnd;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour, startViewReserveMin))) {
			// 查看后天以后的7天资源
			requestDateBegin = getRequestDateByTime(2);
			requestDateEnd = getRequestDateByTime(8);
		} else {
			// 查看明天以后的7天资源
			requestDateBegin = getRequestDateByTime(1);
			requestDateEnd = getRequestDateByTime(7);
		}
		DateUtil.getCriteriaByDateRange(criteria, "T.REQUEST_DATE", requestDateBegin, requestDateEnd);
		// 查询的科室按照时间规则过滤 add by bagen at 2016-01-20 ↑
		return getSchedule(criteria);
	}
	
	private String getSchedule(Criteria criteria){
		List<RegisterSchedule> registerSchedules = registerScheduleDao.getRegisterSchedules(criteria);
		for(RegisterSchedule registerSchedule : registerSchedules) {
			Long admitNum = 0l;
			Long reserveNum = 0l;
			List<RegisterScheduleTime> registerScheduleTimes = registerScheduleTimeDao.getList(new Criteria("REGISTER_SCHEDULE_ID", registerSchedule.getId()));
			for(RegisterScheduleTime registerScheduleTime : registerScheduleTimes) {
				admitNum = admitNum + registerScheduleTime.getAdmitNum();
				reserveNum = reserveNum + registerScheduleTime.getReserveNum();
			}
			registerSchedule.setReserveNum(reserveNum);
			registerSchedule.setAdmitNum(admitNum);
			registerSchedule.setRegisterScheduleTime(registerScheduleTimes);
		}
		if(ObjectUtil.isNotEmpty(registerSchedules)){
			GetYYDoctorInfoResponse getYYDoctorInfoResponse = new GetYYDoctorInfoResponse();
			getYYDoctorInfoResponse.setRegisterScheduleList(registerSchedules);
			return XmlWebserviceForUtil.getString(getYYDoctorInfoResponse, GetYYDoctorInfoResponse.class);		
		}
		return "没有记录";
	}
	
	@Override
	public String getDoctorByClinic(GetYYDoctorByDepartment getYYDoctorByDepartment){
		Criteria criteria = new Criteria("RS.HOSPITAL_CODE",getYYDoctorByDepartment.getHospitalCode());
		criteria.add("RS.DEPT_SN",getYYDoctorByDepartment.getDeptSn());
		criteria.add("RS.CLINIC_TYPE", getYYDoctorByDepartment.getClinicType());
		
		List<OutDoctor> outDoctors = outDoctorDao.getScheduleDoctor(criteria);
		GetYYDoctorByDepartmentResponse getYYDoctorByDepartmentResponse = new GetYYDoctorByDepartmentResponse();
		getYYDoctorByDepartmentResponse.setOutDoctors(outDoctors);
		return XmlWebserviceForUtil.getString(getYYDoctorByDepartmentResponse, GetYYDoctorByDepartmentResponse.class);
	}

	@Override
	public String getRequestDate(GetYYClinicDateByDepartment getYYClinicDateByDepartment){
		Criteria criteria = new Criteria("HOSPITAL_CODE",getYYClinicDateByDepartment.getHospitalCode());
		criteria.add("DEPT_SN", getYYClinicDateByDepartment.getDeptSn());
		criteria.add("CLINIC_TYPE", getYYClinicDateByDepartment.getClinicType());
		List<Date> dateList = registerScheduleDao.getRequestDate(criteria);
		GetYYClinicDateByDepartmentResponse clinicDateByDepartmentResponse = new GetYYClinicDateByDepartmentResponse();
		clinicDateByDepartmentResponse.setRequestDate(dateList);
		return XmlWebserviceForUtil.getString(clinicDateByDepartmentResponse, GetYYClinicDateByDepartmentResponse.class);
	}
	
	@Override
	public String saveRegister(ReserveRegister reserveRegister){
		Criteria criteria = new Criteria("HOSPITAL_CODE",reserveRegister.getHospitalCode());
		criteria.add("DEPT_SN", reserveRegister.getDeptSn());
		criteria.add("CLINIC_TYPE",reserveRegister.getClinicType());
		criteria.add("DOCTOR_SN", reserveRegister.getDoctorSn());
		criteria.add("REQUEST_DATE", reserveRegister.getRequestDate());
		criteria.add("REGISTER_FEE", reserveRegister.getRegisterFee());
		criteria.add("AMPM", reserveRegister.getAmpm());
		
		RegisterSchedule registerSchedule = registerScheduleDao.get(criteria);
		if(registerSchedule==null)
			return XmlWebserviceForUtil.returnError("提交预约失败，预约排班信息不存在!");
		//挂号来源为手机APP
		reserveRegister.setRegFrom(IReserveService.REG_PHONE);
		String registerScheduleTimeId = StringUtils.trimToEmpty(reserveRegister.getRegisterScheduleTimeId());
		String msgKey = reserveService.saveReserveRegister(reserveRegister, registerSchedule.getId(),Long.valueOf(registerScheduleTimeId));
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("repeat", "该用户已预约此科室医生");
		map.put("over", "该用户今天已预约三次，不能再进行预约");
		map.put("full", "对不起，该科室医生已约满");
		map.put("fail", "提交预约失败，建议重新登录再尝试预约");
		String msg = map.get(msgKey);
		
		if(ObjectUtil.isNotEmpty(msg)){
			return XmlWebserviceForUtil.returnError(msg);
		}
		
		Long id = Long.parseLong(msgKey);
		ReserveRegister reRegister =  reserveRegisterDao.get(id);
		Map<String,String> smsMap = new HashMap<String,String>();
		smsMap.put("NAME",reRegister.getName());
		smsMap.put("HOSPITAL",reRegister.getHospitalName());
		smsMap.put("HOSPITAL_CODE",reRegister.getHospitalCode());
		smsMap.put("DOCTOR_NAME",reRegister.getDoctorName());
		smsMap.put("DEPT_NAME",reRegister.getDeptName());
		smsMap.put("TIME",DateUtil.getDateTime("yyyy年MM月dd日",reRegister.getRequestDate()));
		smsMap.put("AMPM",reRegister.getAmpm());
		smsMap.put("TIME_INTERVAL_START",reRegister.getTimeIntervalStart().trim());
		smsMap.put("TIME_INTERVAL_END",reRegister.getTimeIntervalEnd().trim());
		smsMap.put("TAKE_NO_TIME_START",reRegister.getTakeNoTimeStart().trim());
		smsMap.put("TAKE_NO_TIME_END",reRegister.getTakeNoTimeEnd().trim());
		smsMap.put("SEARCH_CODE",reRegister.getSearchCode());
		
		//发送短信
		try {
			SMSUtil smsUtil=new SMSUtil();
			String content=smsUtil.createSMSContent(smsMap,SMSUtil.MODE_TYPE_1);
//			if(smsUtil.isPortal_reserve_send())
			String rs="";
			rs = smsUtil.send(content, reRegister.getPhoneNumber());
			if("Success".equals(rs)){
				SmsRecord sms=new SmsRecord();
				sms.setContent(content);
				sms.setName(reRegister.getName());
				sms.setPhoneNumber(reRegister.getPhoneNumber());
				sms.setType(SMSUtil.MODE_TYPE_1);
				sms.setCreateTime(new Date());
				smsDao.insert(sms);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return XmlWebserviceForUtil.getString(reRegister, ReserveRegister.class);
	}
	
	/**
	 * 获取开始时间
	 * @return
	 */
	public Date getRequestTimeBegin() {
    	Date requestTimeBegin;
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.HOUR_OF_DAY);
		cal.get(Calendar.MINUTE); 
		cal.get(Calendar.SECOND); 
		cal.get(Calendar.MILLISECOND);
		requestTimeBegin = cal.getTime();
		return requestTimeBegin;
	}
    
    /**
     * 得到结束时间
     * @param startViewReserveHour 开始小时
     * @param startViewReserveMin  开始分钟
     * @return
     */
    public Date getRequestTimeEnd(String startViewReserveHour, String startViewReserveMin) {
    	Date requestTimeEnd;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startViewReserveHour).intValue());
		if (startViewReserveMin.equals("00")) {
			cal.set(Calendar.MINUTE, 0);
		} else {
			cal.set(Calendar.MINUTE, Integer.valueOf(startViewReserveMin).intValue());
		}
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
		requestTimeEnd = cal.getTime();
		return requestTimeEnd;
	}
    
    private Date getRequestDateByTime(int i) {
		Date requestDate = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,i);
		return requestDate;
	}
}
