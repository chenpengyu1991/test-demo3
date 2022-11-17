package com.founder.rhip.portal.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.dto.RegisterScheduleDTO;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IOutClinicDao;
import com.founder.rhip.ehr.repository.portal.IOutDoctorDao;
import com.founder.rhip.ehr.repository.portal.IRegisterScheduleDao;
import com.founder.rhip.ehr.repository.portal.IRegisterScheduleTimeDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.portal.service.util.Constants;

@Service("registerScheduleService")
public class RegisterScheduleServiceImpl  extends AbstractService implements IRegisterScheduleService {
	
	@Autowired
	private IOutClinicDao outClinicDao;
	
	@Autowired
	private IOutDoctorDao outDoctorDao;
	
	@Autowired
	private IRegisterScheduleDao registerScheduleDao;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "lhhospitalInfoDao")
	private IHospitalInfoDao lhhospitalInfoDao;
	
	@Autowired
	private IRegisterScheduleTimeDao registerScheduleTimeDao;
	
	@Resource(name = "maternalChildrenHospitalReserveAdapter")
    private IHospitalReserveAdapter maternalChildrenHospitalReserveAdapter;
    
    @Resource(name = "firstHospitalReserveAdapter")
    private IHospitalReserveAdapter firstHospitalReserveAdapter;
    
    @Resource(name = "chineseMedicineHospitalReserveAdapter")
    private IHospitalReserveAdapter chineseMedicineHospitalReserveAdapter;
    
    @Resource(name = "stomatologicalHospitalReserveAdapter")
    private IHospitalReserveAdapter stomatologicalHospitalReserveAdapter;
    
	@Override
	public RegisterSchedule getRegisterSchedule(Criteria criteria){
		RegisterSchedule peserveRegister = registerScheduleDao.get(criteria);
		
		if (ObjectUtil.isNotEmpty(peserveRegister)) {
			
			String hospitalCode = peserveRegister.getHospitalCode();
			String clinicSn = peserveRegister.getDeptSn();
			String doctorSn = peserveRegister.getDoctorSn();
			
			HospitalInfo hospitalInfo = lhhospitalInfoDao.get(new Criteria("hospitalNo", hospitalCode));
			OutClinic outClinic = getOutClinic( hospitalCode, clinicSn);
			OutDoctor outDoctor = getOutDoctor(hospitalCode, clinicSn, doctorSn);
			
			if(ObjectUtil.isNotEmpty(hospitalInfo)){
				peserveRegister.setHospitalName(hospitalInfo.getHospitalName());
				peserveRegister.setHospitalInfo(hospitalInfo.getHospitalInfo());
			}
			
			if(ObjectUtil.isNotEmpty(outClinic)){
				peserveRegister.setDeptName(outClinic.getName());
			}
			
			if(ObjectUtil.isNotEmpty(outDoctor)){
				peserveRegister.setDoctorName(outDoctor.getName());
			}
		}
		
		return peserveRegister;
	}
	
	/**
	 * 根据预约挂号获取排班资源
	 * @param reserveRegister
	 * @return
	 */
	@Override
	public RegisterSchedule getRegisterSchedule(ReserveRegister reserveRegister){
		reserveRegister.setReserverStauts(ReserveStauts.QX.getStauts());
		Criteria sCriteria = new Criteria();
		sCriteria.add("hospitalCode", reserveRegister.getHospitalCode());
		sCriteria.add("deptSn", reserveRegister.getDeptSn());

        //liuk 2014年3月10日 17:22:01 条件判断错误
        //如果医生为空,则作为独立记录
        //sCriteria.add("doctorSn", reserveRegister.getDoctorSn());
        if(ObjectUtil.isNotEmpty(reserveRegister.getDoctorSn())){
            sCriteria.add("doctorSn", reserveRegister.getDoctorSn());
        }else{
            sCriteria.add("doctorSn", OP.IS, " null ");
        }
		sCriteria.add("clinicType", reserveRegister.getClinicType());
		sCriteria.add("registerFee", reserveRegister.getRegisterFee());
		sCriteria.add("requestDate", reserveRegister.getRequestDate());
		sCriteria.add("ampm",reserveRegister.getAmpm());
		RegisterSchedule registerSchedule = registerScheduleDao.get(sCriteria);
		return registerSchedule;
	}
	
	@Override
	public PageList<RegisterSchedule> getRegisterSchedule(Criteria criteria,Page page){
		PageList<RegisterSchedule> peserveRegisters = registerScheduleDao.getRegisterSchedules(criteria,page);
		return peserveRegisters;
	}
	
	@Override
	public List<RegisterSchedule> getNoPageRegisterSchedule(Criteria criteria){
		List<RegisterSchedule> getNoPageRegisterSchedule = registerScheduleDao.getNoPageRegisterSchedule(criteria);
		return getNoPageRegisterSchedule;
	}
	
	/**
	 * 根据机构及科室编码获取出诊详细信息
	 * @param hospitalCode
	 * @param deptSn
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public RegisterScheduleDTO getRegisterScheduleDetail(String hospitalCode,String deptSn, Date startDate,Date endDate) {
		RegisterScheduleDTO registerScheduleDTO = new RegisterScheduleDTO();
		
		if (ObjectUtil.isNotEmpty(this.commonMethods(hospitalCode))) {//调用医院接口
			List<RegisterSchedule> querySchduleList = new ArrayList<RegisterSchedule>();
			Map<String, Object> querySchduleListMap = new HashMap<String, Object>();
			String returnCode = null;
			/*if (Constants.CHINESE_MEDICINE_HOSPITAL.equals(hospitalCode)) {*/
				querySchduleListMap = this.commonMethods(hospitalCode).querySchduleList(hospitalCode, null,null,deptSn, null,null,null);
				returnCode = querySchduleListMap.get(Constants.RESERVE_RET_CODE).toString();
			/*}*/
			if (Constants.RET_CODE_CORRECT.equals(returnCode)) {
				querySchduleList = (List<RegisterSchedule>) querySchduleListMap.get(Constants.RESERVE_RET_MSG);
			}
			registerScheduleDTO.setRegisterSchedules(querySchduleList);
			
		} else {
			HospitalInfo hospitalInfo = lhhospitalInfoDao.get(new Criteria("HOSPITAL_NO", hospitalCode));
			List<RegisterSchedule> registerSchedules = this.getRegisterSchedule(hospitalCode, deptSn, startDate, endDate);
			registerScheduleDTO.setHospitalInfo(hospitalInfo);
			registerScheduleDTO.setRegisterSchedules(registerSchedules);
		}
		
		return registerScheduleDTO;
	}

	/***
     * 根据不同医院调用不同接口
     * @param hospitalCode
     * @return
     */
	public IHospitalReserveAdapter commonMethods(String hospitalCode) { 
		switch (hospitalCode) {
			case Constants.FIRST_HOSPITAL:
				/*return firstHospitalReserveAdapter;*/
				return null;
			case Constants.SECOND_HOSPITAL:
				return null;
			case Constants.THIRD_HOSPITAL:
				return null;
			case Constants.CHINESE_MEDICINE_HOSPITAL:
				return chineseMedicineHospitalReserveAdapter;
			case Constants.MATERNAL_CHILD_HOSPITAL:
				return maternalChildrenHospitalReserveAdapter;
			case Constants.STOMATOLOGICAL_HOSPITAL:
				return stomatologicalHospitalReserveAdapter;
			default: return null;
		}
	}
	
	/**
	 * 获取开始结束时间之前的日期
	 * @return
	 */
	@Override
	public List<Date> getBetweenDate(Date startDate,Date endDate){
		String yyString = DateUtil.toFormatString("yyyy/MM/dd", startDate);
		Date yyDate = DateUtil.parseDateString(yyString);
		
		List<Date> dateList = new ArrayList<Date>();
		
		while(true){
			dateList.add(yyDate);
			yyDate = DateUtil.add(yyDate, Calendar.DAY_OF_MONTH,1);
			boolean dateAfter = yyDate.after(endDate);
			if(dateAfter){
				break;
			}
		}
		return dateList;
	}
	
	
	/**
	 * 根据机构及科室编码获取出诊科室
	 * @param hospitalCode
	 * @param clinicSn
	 * @return
	 */
	private OutClinic getOutClinic(String hospitalCode,String clinicSn){
		
		Criteria clinicCriteria = new Criteria();
		clinicCriteria.add("hospitalCode", hospitalCode);
		clinicCriteria.add("deptSn", clinicSn);
		OutClinic outClinic = outClinicDao.get(clinicCriteria);
		return outClinic;
	}
	
	/**
	 * 根据机构及科室编码获取出诊医生
	 * @param hospitalCode
	 * @param clinicSn
	 * @param doctorSn
	 * @return
	 */
	private OutDoctor getOutDoctor(String hospitalCode,String clinicSn,String doctorSn){
		Criteria docCriteria = new Criteria();
		docCriteria.add("hospitalCode", hospitalCode);
		docCriteria.add("deptSn", clinicSn);
		docCriteria.add("doctorSn", doctorSn);
		OutDoctor outDoctor = outDoctorDao.get(docCriteria);
		return outDoctor;
	}
	
	/**
	 * 根据机构及科室编码获取出诊详细信息
	 * @param hospitalCode
	 * @param deptSn
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private List<RegisterSchedule> getRegisterSchedule(String hospitalCode,String deptSn, Date startDate,Date endDate){
		Criteria scheduleCriteria = new Criteria();
		scheduleCriteria.add("hospitalCode", hospitalCode);
		scheduleCriteria.add("deptSn", deptSn);
		
		DateUtil.getCriteriaByDateRange(scheduleCriteria, "request_Date", startDate, endDate);
		Order order = new Order("request_Date");
		
		List<RegisterSchedule> registerSchedules = registerScheduleDao.getList(scheduleCriteria, order);
		
		if(ObjectUtil.isNullOrEmpty(registerSchedules)){
			return null;
		}
		for(RegisterSchedule reg :registerSchedules){
			String weekDate = DateUtil.getWeekByDate(reg.getRequestDate());	
			reg.setWeekDate(weekDate);
		}
		return registerSchedules;
	}

	@Override
	public List<RegisterScheduleTime> getRegisterScheduleTimeLists(Criteria criteria) {
		return registerScheduleTimeDao.getList(criteria);
	}

	@Override
	public RegisterScheduleTime getRegisterScheduleTime(Criteria criteria) {
		return registerScheduleTimeDao.get(criteria);
	}

	@Override
	public PageList<RegisterSchedule> getSearchRegisterSchedulePageLists(Page page, String deptName) {
		return registerScheduleDao.getSearchRegisterSchedulePageLists(page, deptName);
	}
	
}
