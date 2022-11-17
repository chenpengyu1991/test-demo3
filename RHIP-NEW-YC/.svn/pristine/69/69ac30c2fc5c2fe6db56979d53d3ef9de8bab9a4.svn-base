package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.constants.Constants;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PortalSetType;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.portal.common.ScheduleStatus;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IPortalSetService;
import com.founder.rhip.portal.service.IRegisterScheduleService;
import com.founder.rhip.portal.service.IReserveService;
import com.founder.rhip.portal.service.form.ReserveSearchForm;
import com.founder.rhip.portal.service.form.ScheduleSearchForm;
import com.founder.rhip.portal.service.util.SMSUtil;





/*import org.apache.commons.httpclient.util.DateUtil;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/portal/reserve")
public class ReserveController extends BaseController{
	
	@Resource(name = "reserveService")
   	private IReserveService reserveService;
	
	@Resource(name = "registerScheduleService")
   	private IRegisterScheduleService registerScheduleService;
	
	@Resource(name = "platformService")
	private IPlatformService personService;

	@Resource(name = "lhaccountInfoService")
	private IAccountInfoService accountInfoService;

	@Resource(name = "portalSetService")
    private IPortalSetService portalSetService;
	
	//操作名称
	private static final String acctionName = "预约挂号";
	
	//预约时间开始的key值
  	public static final String PORTAL_RESERVE_START_TIME= "portal_reserve_start_time";
  		
  	//预约时间结束的key值
  	public static final String PORTAL_RESERVE_END_TIME= "portal_reserve_end_time";
  	
  //预约时间结束的key值
  	public static final String PORTAL_RESERVE_VIEW_END_TIME= "portal_reserve_view_end_time";
	
	//操作来源0:平台；1:健康门户网站
	private static final String optFrom = "0";
	@RequestMapping(value = "/search")
	public String search(ModelMap model) {
		List<HospitalInfo> organizationList = reserveService.getOutHospitals();
		model.addAttribute("organizationList", organizationList);
		return "portal.reserve.search";
	}
	
	@RequestMapping(value = "/clinic")
	@ResponseBody
	public SelectDTO<OutClinic> clinic(HttpServletRequest request,String hospitalCode,String inputValue,int currentPage) {
		Criteria criteria = new Criteria();
		Page page = super.getPage(request, currentPage); 
		
		if(ObjectUtil.isNotEmpty(hospitalCode)){
			criteria.add("hospitalCode", hospitalCode);
		}
		if(ObjectUtil.isNotEmpty(inputValue)){
			criteria.add("name", OP.LIKE ,inputValue);
		}
		
		PageList<OutClinic> outClinicList = reserveService.getPageOutClinic(page,criteria);
		return new SelectDTO<OutClinic>(outClinicList);
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,ReserveSearchForm reserveSearchForm,int indexPage,ModelMap model) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = reserveSearchForm.getCriteria();
		PageList<ReserveRegister> reserveRegisters = reserveService.getReserveRegister(criteria, page);
		model.addAttribute("reserveRegisters", reserveRegisters.getList());
		model.addAttribute("page", reserveRegisters.getPage());
		return "portal.reserve.list";
	}
	
	@RequestMapping(value = "/add")
	public String add(ModelMap model) {
		/*if (reserveEffectiveTime(model)) {//判断当前时间是否在可预约的时间段内
			model.addAttribute("success", "true");
        }*/
		return "portal.reserve.add";
	}
	
	private Boolean reserveEffectiveTime(ModelMap model) {
		HashMap<String,String> map = portalSetService.getSetByType(PortalSetType.RESERVE.getValue());
	  	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
	  	
	  	try {
				Date reserveStart = (Date) sdf.parseObject(map.get(PORTAL_RESERVE_START_TIME));
				Date reserveEnd = (Date) sdf.parseObject(map.get(PORTAL_RESERVE_END_TIME));
				Calendar cal = Calendar.getInstance(); 
				
				Date nowDate = (Date) sdf.parseObject(cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
				
				if (nowDate.before(reserveStart) || nowDate.after(reserveEnd)) {
					String startTime = portalSetService.getByCode(PORTAL_RESERVE_START_TIME).split("\\:")[0];
					String endTime = portalSetService.getByCode(PORTAL_RESERVE_END_TIME).split("\\:")[0];
					model.addAttribute("startTime", startTime.trim());
					model.addAttribute("endTime", endTime.trim());
					return true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	@RequestMapping(value = "/loadDoctor")
	public String showDoctor(Long doctorId,ModelMap model) {
		Criteria criteria = new Criteria("id",doctorId);
		OutDoctor outDoctor = reserveService.getOutDoctor(criteria);
		model.addAttribute("outDoctor", outDoctor);
		return "portal.reserve.doctorView";
	}
	
	@RequestMapping(value = "/getPerson")
	@ResponseBody
	public PersonInfo getPerson(String idCard,ModelMap model) {
		idCard = idCard.trim();
		
		PersonInfo personInfo = personService.queryPersonalInfo(null, idCard);
		if(ObjectUtil.isNotEmpty(personInfo)){
			return personInfo;
		}
		personInfo = new PersonInfo();
		ReserveRegister reserveRegister = reserveService.getReserveRegisterByIdCard(idCard);
		if(ObjectUtil.isNotEmpty(reserveRegister)){
			personInfo.setIdcard(reserveRegister.getIdcard());
			personInfo.setName(reserveRegister.getName());
			personInfo.setBirthday(reserveRegister.getBirthday());
			personInfo.setUnitName(reserveRegister.getUnitName());
			personInfo.setPhoneNumber(reserveRegister.getPhoneNumber());
			personInfo.setIdcardHos(reserveRegister.getIdcardHos());
			personInfo.setIdcardFarm(reserveRegister.getIdcardFarm());
			personInfo.setPatownShip(reserveRegister.getPatownShip());
			personInfo.setPastreet(reserveRegister.getPastreet());
			personInfo.setPahouseNumber(reserveRegister.getPahouseNumber());
		}
		return personInfo;
	}
	
	@RequestMapping(value = "/schedule")
	public String schedule(ModelMap model) {
		List<HospitalInfo> organizationList = reserveService.getOutHospitals();
		model.addAttribute("organizationList", organizationList);
		return "portal.reserve.schedule";
	}
	
	/**
	 * 查询排班
	 * @param scheduleSearchForm
	 * @param indexPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/scheduleList")
	public String scheduleList(ScheduleSearchForm scheduleSearchForm,int indexPage,ModelMap model) {
		Page page = new Page(6, indexPage);
		Criteria criteria = scheduleSearchForm.getCriteria("RS","OC");
        //只显示7天内全部有资源的数据

		String startViewReserveHour = portalSetService.getByCode(PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode(PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[1];
		Date requestDateBegin;
		Date requestDateEnd;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			requestDateBegin  = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,2);
			requestDateEnd = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,8);
			DateUtil.getCriteriaByDateRange(criteria, "RS.REQUEST_DATE", requestDateBegin, requestDateEnd);
		}else {
			requestDateBegin  = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,1);
			requestDateEnd = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,7);
			DateUtil.getCriteriaByDateRange(criteria, "RS.REQUEST_DATE", requestDateBegin, requestDateEnd);
		}
		
		PageList<RegisterSchedule> registerSchedules = registerScheduleService.getRegisterSchedule(criteria, page);
		model.addAttribute("registerSchedules", registerSchedules.getList());
		model.addAttribute("page", registerSchedules.getPage());
		
		model.addAttribute("startDate",DateUtil.toDateString(requestDateBegin, "yyyy/MM/dd") );
		model.addAttribute("endDate", DateUtil.toDateString(requestDateEnd, "yyyy/MM/dd"));
		model.addAttribute("dateList",registerScheduleService.getBetweenDate(requestDateBegin,requestDateEnd));
		return "portal.reserve.scheduleList";
	}

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
    
	/***
	 * 显示预约时段的资源
	 * @param scheduleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String select(Long scheduleId, ModelMap model) {
		Criteria criteria = new Criteria("REGISTER_SCHEDULE_ID",scheduleId);
		List<RegisterScheduleTime> registerScheduleTimeList = registerScheduleService.getRegisterScheduleTimeLists(criteria);
		RegisterSchedule registerSchedule = registerScheduleService.getRegisterSchedule(new Criteria("id", scheduleId));
		model.addAttribute("registerScheduleTimeList", registerScheduleTimeList);
		model.addAttribute("registerSchedule", registerSchedule);
		model.addAttribute("scheduleId", scheduleId);
		return "portal.reserve.registerScheduleTimeView";
	}
	
	/**
	 * 保存
	 * @param request
	 * @param reserveRegister
	 * @param scheduleId
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request,ReserveRegister reserveRegister,Long scheduleId,Long scheduleTimeId) {
		User user = super.getCurrentUser(request);
		Organization org = super.getCurrentOrg(request);
		
		if(ObjectUtil.isNullOrEmpty(user) || ObjectUtil.isNullOrEmpty(org)){
			return EHRConstants.RESULT_FAIL;
		}
		reserveRegister.setSubmitOrg(org.getOrganCode());
		reserveRegister.setSubmitUser(user.getId());
		reserveRegister.setRegFrom(IReserveService.REG_CSWS);

		//为了门户我的预约查询添加 门户显示预约查询是 显示自己（平台医生帮预约的信息）的和常用联系人的
		AccountInfo accountInfo = accountInfoService.get(new Criteria("CARD_NO", reserveRegister.getIdcard()));
		if(ObjectUtil.isNotEmpty(accountInfo)) {
			reserveRegister.setAccountId(accountInfo.getId());
		}

		String result = reserveService.saveReserveRegister(reserveRegister, scheduleId, scheduleTimeId);
		if(NumberUtil.isDecimal(result)) {
			reserveService.sendSMS(reserveRegister, SMSUtil.MODE_TYPE_1);
		}
		switch (result) {
			case "fail": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号失败", OperationName.RESERVE_FAIL); break;
								
			case "full": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号数量已满", OperationName.RESERVE_FULL); break;
								
			case "over": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号同一天超过三次", OperationName.RESERVE_OVER); break;
			
			case "repeat": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户已经预约相同医生", OperationName.RESERVE_REPEAT); break;
			
			default: createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号成功", OperationName.RESERVE_SUCCESS);
		
		}
		return result;
	}

	/**
	 * 查看
	 * @param regId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(HttpServletRequest request,Long regId,ModelMap model) {
		ReserveRegister reserveRegister = reserveService.getReserveRegister(regId);
		if(ObjectUtil.isNullOrEmpty(reserveRegister)){
			return "portal.reserve.view";
		}
		createOperationLog(request, RhipModuleName.LHPORTAL, "查看健康门户预约信息", OperationName.UPDATE);
		model.addAttribute("reserveRegister", reserveRegister);
		String code = reserveRegister.getAmpm() + "_" + reserveRegister.getHospitalCode();
		/*model.addAttribute("promptMessage", portalSetService.getByCode(code));*/
		return "portal.reserve.view";
	}
	
	/**
	 * 取消
	 * @param regId
	 * @return
	 */
	@RequestMapping(value = "/cancel")
	@ResponseBody
	public String cancel(Long regId,	HttpServletRequest request) {
		String result = null;
    	String startViewReserveHour = portalSetService.getByCode(PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode(PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[1];
		Date date = DateUtil.convertDate("MM/dd/yyyy", new Date());
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//如果当前日前在PORTAL_RESERVE_VIEW_END_TIME后，将当前日期加1天
			date = DateUtil.add(date, Calendar.DAY_OF_MONTH,1);
		}
		ReserveRegister reserveRegister = reserveService.getReserveRegister(regId);
		if(!(reserveRegister.getRequestDate().after(date))) {//如果当前日期加1天等于预约表的日期就提示
			String rs= ReserveStauts.getByStauts("06").getDescription();
			result = "请在就诊日前一天"+startViewReserveHour+":"+startViewReserveMin+"之前"+rs;
			return result;
			}
		
		return cancelReserve(request, regId);
	}

	/***
     * 取消预约加上时间限制
     * @param request
     * @param regId
     * @return
     */
	private String cancelReserve(HttpServletRequest request, Long regId) {
		String result = null;
		/*User user = super.getCurrentUser(request);
		String operate_user=null;
		if(user!=null)
			operate_user=user.getUserName();
		result= reserveService.cancelRegister(regId,operate_user,optFrom);
		if(EHRConstants.CANCEL_OK.equals(result))
			createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户取消挂号", OperationName.UPDATE);*/
		return result;
	}
	
    /**
     * 打印
     * @param model
     * @param regId
     * @return
     */
    @RequestMapping(value = "/print")
    public String print1(HttpServletRequest request,ModelMap model, Long regId) {
        ReserveRegister reserveRegister = reserveService.getReserveRegister(regId);
        if(ObjectUtil.isNullOrEmpty(reserveRegister)){
            return "portal.reserve.view";
        }
        createOperationLog(request, RhipModuleName.LHPORTAL, "打印健康门户预约信息", OperationName.UPDATE);
        model.addAttribute("reserveRegister", reserveRegister);
        String code = reserveRegister.getAmpm() + "_" + reserveRegister.getHospitalCode();
        /*model.addAttribute("promptMessage", portalSetService.getByCode(code));*/
        return "portal.reserve.print";
    }
}
